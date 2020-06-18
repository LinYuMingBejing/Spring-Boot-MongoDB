package com.items.api.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.items.api.entity.BookInfo;

import java.io.Serializable;
import java.util.List;

// 轉JSON時排除全部值為null的屬性
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookDateResponse implements Serializable {
    private List<BookInfo> data;
    private boolean status;
    String msg = null;

    public BookDateResponse() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public List<BookInfo> getData() {
        return data;
    }

    public void setData(List<BookInfo> data) {
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
