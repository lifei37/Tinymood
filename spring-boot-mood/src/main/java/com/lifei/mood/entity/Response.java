package com.lifei.mood.entity;

public class Response {
    private Integer status;
    private String msg;
    private Object obj;

    public Response() {
    }

    public Response(Integer status, String msg, Object obj) {
        this.status = status;
        this.msg = msg;
        this.obj = obj;
    }

    public static Response ok(String msg, Object obj){
        return new Response(200, msg, obj);
    }

    public static Response ok(String msg){
        return new Response(200, msg, null);
    }

    public static Response error(String msg, Object obj){
        return new Response(500, msg, obj);
    }

    public static Response error(String msg){
        return new Response(500, msg, null);
    }

    public Integer getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
