package com.tianyi.hermeseventbus.core;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;

import com.tianyi.hermeseventbus.EventBusService;
import com.tianyi.hermeseventbus.Request;
import com.tianyi.hermeseventbus.Response;
import com.tianyi.hermeseventbus.service.HermesService;

import java.util.concurrent.ConcurrentHashMap;


/**
 * Created by Administrator on 2018/5/21.
 */

public class ServiceConnectionManager {
    private static final ServiceConnectionManager ourInstance = new ServiceConnectionManager();
    //    Class  对应的Binder  对象
    private final ConcurrentHashMap<Class<? extends HermesService>, EventBusService> mHermesServices = new ConcurrentHashMap<Class<? extends HermesService>, EventBusService>();

    public static ServiceConnectionManager getInstance() {
        return ourInstance;
    }
    //Class对应的链接对象
    private final ConcurrentHashMap<Class<? extends HermesService>, HermesServiceConnection> mHermesServiceConnections = new ConcurrentHashMap<Class<? extends HermesService>, HermesServiceConnection>();


    private ServiceConnectionManager() {
    }
    public void bind(Context context, String packageName, Class<? extends HermesService> service) {
        HermesServiceConnection connection = new HermesServiceConnection(service);
        mHermesServiceConnections.put(service, connection);
        Intent intent ;
        if (TextUtils.isEmpty(packageName)) {
            intent = new Intent(context, service);
        } else {
            intent = new Intent();
            intent.setClassName(packageName, service.getName());
        }
        context.bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    public Response request(Class<HermesService> hermesServiceClass, Request request) {
        EventBusService eventBusService = mHermesServices.get(hermesServiceClass);
        if (eventBusService != null) {
            try {
                Response responce= eventBusService.send(request);
                return responce;
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    //     接受远端的binder 对象   进程B就可以了通过Binder对象去操作 服务端的 方法
    private class HermesServiceConnection implements ServiceConnection {
        private Class<? extends HermesService> mClass;

        HermesServiceConnection(Class<? extends HermesService> service) {
            mClass = service;
        }
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            EventBusService hermesService = EventBusService.Stub.asInterface(service);
            mHermesServices.put(mClass, hermesService);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mHermesServices.remove(mClass);
        }
    }

}
