package novel.web.entitys;

import java.util.Date;

public class SystemLog {

	private long id;
	private String module;
	private String method;
	private String statusDesc;
	private String args;
	private long userId;
	private String username;
	private String ip;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private Date createTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
	
	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public String getArgs() {
		return args;
	}

	public void setArgs(String args) {
		this.args = args;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}


	public String getIp() {
		return ip;
	}

    @Override
    public String toString() {
        return "SystemLog{" +
                "id=" + id +
                ", module='" + module + '\'' +
                ", method='" + method + '\'' +
                ", statusDesc='" + statusDesc + '\'' +
                ", args='" + args + '\'' +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                ", ip='" + ip + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}



}
