package com.TD;

/**
 * 
 * @author 海龙
 *
 */
public class BaseResponse<T> {
	
	public BaseResponse(){
		this.code = "200";
		this.desc = "success";
	}
	
	public BaseResponse(String code, String desc){
		this.code = code;
		this.desc = desc;
	}
	
	public BaseResponse(String code, String desc,T data){
		this(code,desc);
		this.data = data;
	}
	
	public BaseResponse(T data){
		this();
		this.data = data;
	}
	
	
	private String code;
	private String desc;
	private T data;
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
