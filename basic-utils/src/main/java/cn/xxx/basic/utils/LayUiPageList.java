package cn.xxx.basic.utils;

import java.util.ArrayList;
import java.util.List;

public class LayUiPageList<T> {
    //总条数
    private Long count = 0L;
    //每页的数据
    private List<T> data = new ArrayList<>();

    private Long code=0L;
    private String msg="";

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
