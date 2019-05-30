package com.tianyi.hermeseventbus.bean;

/**
 * Created by Administrator on 2018/5/21.
 */

public class RequestBean {
//    类型 B   UserManager userManager.getInstance()   请求对象的class类型
    private String className;
//    className com.dongn.UserManager
    private String resultClassName;
    private String requestObject;
    private String methodName;

//    参数
    private RequestParameter[] requestParameter;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getResultClassName() {
        return resultClassName;
    }

    public void setResultClassName(String resultClassName) {
        this.resultClassName = resultClassName;
    }

    public String getRequestObject() {
        return requestObject;
    }

    public void setRequestObject(String requestObject) {
        this.requestObject = requestObject;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public RequestParameter[] getRequestParameter() {
        return requestParameter;
    }

    public void setRequestParameter(RequestParameter[] requestParameter) {
        this.requestParameter = requestParameter;
    }
}
