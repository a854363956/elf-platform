package org.elf.mvc.error;



/**
 *  如果程序执行异常，应该抛出此异常
 * @author zhangj
 * @email zhangjin0908@hotmail.com
 *
 */

public class ElfRunException extends Exception {
	private static final long serialVersionUID = 3595687743301098696L;
	private Object data;
	private int status;
	public ElfRunException(int code,Object data,String...strings) {
		super(internationalization(code,strings));
		this.data = data;
		this.status = code;
	}
	public ElfRunException(int code,String...strings) {
		super(internationalization(code,strings));
		this.status = code;
	}
	/**
	 *  将当前的错误代号转换为国际化内容
	 * @param code      当前的错误代号
	 * @param strings   要占用的字符串
	 * @return
	 */
	protected static String internationalization(int code,String...strings) {
		return "";
	}
	/**
	 * 没有占用的字符串，默认返回维护的代号
	 * @param code
	 * @return
	 */
	protected static String internationalization(int code) {
		return "";
	}
	public Object getData() {
		return data;
	}
	
	public int getStatus() {
		return status;
	}


}
