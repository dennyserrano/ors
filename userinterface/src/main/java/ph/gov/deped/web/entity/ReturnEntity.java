package ph.gov.deped.web.entity;

public class ReturnEntity<T> {
	private String message;
	private int code;
	private T data;
	
	
	
	public ReturnEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReturnEntity(String message, int code, T data) {
		super();
		this.message = message;
		this.code = code;
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	
}
