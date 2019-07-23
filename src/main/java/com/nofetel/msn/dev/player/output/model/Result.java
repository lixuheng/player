package com.nofetel.msn.dev.player.output.model;

import java.io.PipedReader;

/**
 * @author mengshengneng
 * @date 2019/7/23 12:18
 */
public class Result<T> {

    private Integer code;

    private String msg;

    private T data;

    private Long timestamp = System.currentTimeMillis();

    public Result() {
        this.data = null;
        this.code = 200;
        this.msg = "success";
    }

    public Result(Integer code) {
        if (code == 200) {
            this.code = 200;
            this.msg = "success";
        } else {
            this.code = code;
            this.msg = "failure";
        }
    }

    public Result(T data) {
        this.data = data;
        this.code = 200;
        this.msg = "success";
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public Result<T> setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public Result<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", timestamp=" + timestamp +
                '}';
    }



}
