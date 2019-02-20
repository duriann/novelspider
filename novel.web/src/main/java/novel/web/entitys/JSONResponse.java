package novel.web.entitys;

public class JSONResponse {
	private int code;
	private String msg;
	private Object data;
    private int count;//据总数的字段名称

    public static JSONResponse success(Object data,int count) {
        JSONResponse response = new JSONResponse();
        response.setCode(0);
        response.setData(data);
        response.setCount(count);
        response.setMsg("");
        return response;
    }
    public static JSONResponse success(Object data) {
        JSONResponse response = new JSONResponse();
        response.setCode(0);
        response.setData(data);
        response.setMsg("");
        return response;
    }
    public static JSONResponse success(Object data,String msg) {
        JSONResponse response = new JSONResponse();
        response.setCode(0);
        response.setData(data);
        response.setMsg(msg);
        return response;
    }
    public static JSONResponse error(String msg) {
        JSONResponse response = new JSONResponse();
        response.setCode(1);
        response.setMsg(msg);
        return response;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }



}
