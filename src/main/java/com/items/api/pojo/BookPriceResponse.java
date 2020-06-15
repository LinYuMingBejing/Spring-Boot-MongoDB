package com.items.api.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookPriceResponse<T> implements Serializable{
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

    public static BookPriceResponse data(Object data){
        BookPriceResponse bookPriceResponse = new BookPriceResponse();
        bookPriceResponse.setData(data);
        return bookPriceResponse;
    }
}
