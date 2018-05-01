package novel.web.entitys;

public class JSONResponse2 {
	private int code;
	private String msg;
	private Object data;
	private int count;//据总数的字段名称


	public static JSONResponse2 success(Object data,int count) {
		JSONResponse2 response = new JSONResponse2();
		response.setCode(0);
		response.setData(data);
		response.setCount(count);
		response.setMsg("");
		return response;
	}
	public static JSONResponse2 error(String desc) {
		JSONResponse2 response = new JSONResponse2();
		response.setCode(1);
		response.setMsg(desc);
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
