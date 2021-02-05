package com.johnny.vis.cloud.common.entity;

import com.johnny.vis.cloud.common.constant.Response;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * web请求返回给前台的包装对象
 *
 * @author Johnny
 * @date 2020-12-23
 */
@Getter
@Setter
public class ResponseData<T> implements Serializable {
    private static final long serialVersionUID = 2158495006352410142L;

    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 返回提示消息
     */
    private String message;

    /**
     * 返回数据
     */
    private T data;

    public ResponseData() {
        this.success = true;
        this.message = "";
        this.data = null;
    }

    public ResponseData(T data) {
        this.data = data;
    }

    public ResponseData(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    /**
     * 无数据成功
     */
    public static final ResponseData<Object> SUCCESS_NO_DATA = new ResponseData<>(Response.OPERATE_SUCCESS, Response.SUCCESS_DEFAULT, Response.NO_DATA);

    /**
     * 默认成功
     *
     * @param data data
     * @return ResponseData
     */
    public static<T> ResponseData<T> success(T data) {
        return new ResponseData<T>(Response.OPERATE_SUCCESS, Response.SUCCESS_DEFAULT, data);
    }

    /**
     * 仅消息成功
     *
     * @param message message
     * @return ResponseData
     */
    public static ResponseData<Object> success(String message) {
        return new ResponseData<>(Response.OPERATE_SUCCESS, message, Response.NO_DATA);
    }

    /**
     * 带消息和数据成功
     *
     * @param message message
     * @param data    data
     * @return ResponseData
     */
    public static<T> ResponseData<T> success(String message, T data) {
        return new ResponseData<T>(Response.OPERATE_SUCCESS, message, data);
    }

    /**
     * 无数据失败
     */
    public static final ResponseData<Object> ERROR_NO_DATA = new ResponseData<>(Response.OPERATE_ERROR, Response.ERROR_DEFAULT, Response.NO_DATA);

    /**
     * 仅消息失败
     *
     * @param message message
     * @return ResponseData
     */
    public static ResponseData<Object> error(String message) {
        return new ResponseData<>(Response.OPERATE_ERROR, message, Response.NO_DATA);
    }
}

