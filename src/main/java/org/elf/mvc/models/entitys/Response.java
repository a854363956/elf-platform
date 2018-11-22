package org.elf.mvc.models.entitys;

import java.io.Serializable;

import org.elf.mvc.error.ElfRunException;


public class Response implements Serializable{
	private static final long serialVersionUID = 7742743279369000017L;
	private int status;
	private Object   data;
	private String msg;
	
	protected Response() {
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public static Response getSuccess(String msg,Object data) {
		var re = new Response();
		re.setData(data);
		re.setMsg(msg);
		re.setStatus(200);
		return re;
	}
	public static Response getError(ElfRunException e) {
		var re = new Response();
		re.setData(e.getData());
		re.setMsg(e.getMessage());
		re.setStatus(e.getStatus());
		return re;
	}
	public static Response getError(String msg,Object data){
		var re = new Response();
		re.setData(data);
		re.setMsg(msg);
		re.setStatus(500);
		return re;
	}
}
