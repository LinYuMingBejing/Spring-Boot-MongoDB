package com.items.api.pojo;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthorBooksResponse<T> implements Serializable {
    boolean status = true;
    String msg = null;
    T data;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static AuthorBooksResponse data(Object data) {
        AuthorBooksResponse authorBooksResponse = new AuthorBooksResponse();
        authorBooksResponse.setData(data);
        return authorBooksResponse;
    }
}
