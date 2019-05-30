package com.tianyi.hermeseventbus;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2018/5/18.
 */

public class Response implements Parcelable {
//    响应的对象
    private String data;

    public String getData() {
        return data;
    }

    protected Response(Parcel in) {
        data = in.readString();
    }

    public Response(String data) {
        this.data = data;
    }

    public static final Creator<Response> CREATOR = new Creator<Response>() {
        @Override
        public Response createFromParcel(Parcel in) {
            return new Response(in);
        }

        @Override
        public Response[] newArray(int size) {
            return new Response[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(data);
    }
}
