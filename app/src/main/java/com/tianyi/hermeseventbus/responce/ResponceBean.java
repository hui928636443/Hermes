package com.tianyi.hermeseventbus.responce;

/**
 * Created by Administrator on 2018/5/23.
 */

public class ResponceBean {

//fastjson
    private Object data;//UserManager

    public ResponceBean(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }
}
