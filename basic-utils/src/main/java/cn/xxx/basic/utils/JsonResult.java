package cn.xxx.basic.utils;

/**
 * 增删改返回给前台的信息对象
 */
public class JsonResult {
    private Boolean success=true;
    private String msg;

    public JsonResult() {
    }

    public JsonResult(Boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
