package org.elf.mvc.error;

import org.elf.mvc.models.ElfBaseLanguageModels;
import org.elf.mvc.models.utils.SpringUtils;

/**
 *  如果程序执行异常，应该抛出此异常
 * @author zhangj
 * @email zhangjin0908@hotmail.com
 *
 */
public class ElfRunException extends Exception {
	private static final long serialVersionUID = 3595687743301098696L;
	private Object data;
	private long status;
	public ElfRunException(Object data,int country,long code,String...strings) {
		super(internationalization(country,code,strings));
		this.data = data;
		this.status = code;
	}
	public ElfRunException(int country,long code,String...strings) {
		super(internationalization(country,code,strings));
		this.status = code;
	}
	public ElfRunException(int country,long code) {
		super(internationalization(country,code));
		this.status = code;
	}
	public ElfRunException(Object data,int country,long code) {
		super(internationalization(country,code));
		this.data = data;
		this.status = code;
	}
	
	protected static String internationalization(int country,long code,String...strings) {
		ElfBaseLanguageModels eblm = SpringUtils.getApplicationContext().getBean(ElfBaseLanguageModels.class);
		return eblm.getMsg(country, code, strings);
	}
	protected static String internationalization(int country,long code) {
		ElfBaseLanguageModels eblm = SpringUtils.getApplicationContext().getBean(ElfBaseLanguageModels.class);
		return eblm.getMsg(country, code);
	}

	public Object getData() {
		return data;
	}
	
	public long getStatus() {
		return status;
	}

}
