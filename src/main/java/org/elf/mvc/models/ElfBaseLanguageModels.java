package org.elf.mvc.models;

import org.elf.db.Tables;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *   用来管理国际化的一些工具,如果不设置语言，那么默认语言是中国86
 * @author zhangj
 * @email zhangjin0908@Hotmail.com
 *
 */
@Component
public class ElfBaseLanguageModels {
	@Autowired
	private DSLContext dsl;
	private final String notFound = "404 not found language country=%s key=%s ";
	//@Autowired
	//private SnowflakeIdGenerator sig;
	
	protected Record getMsgRecord(int country, long key) {
		return dsl.select().from(Tables.ELF_BASE_LANGUAGE).where(Tables.ELF_BASE_LANGUAGE.COUNTRY.eq(country))
				.and(Tables.ELF_BASE_LANGUAGE.KEY.eq(key)).fetchAny();
	}
	
	/**
	 * 根据以下获取到当前的国际化信息
	 * @param country  当前城市
	 * @param key      当前代号
	 * @param strings  占位符的替换参数
	 * @return  返回具体的消息
	 */
	public String getMsg(int country, long key, String... strings) {
		var data = getMsgRecord(country,key);
		if (null == data) {
			return String.format(notFound, country,key);
		} else {
			return String.format(data.get(Tables.ELF_BASE_LANGUAGE.MSG), (Object[])strings);
		}
	}
	/***
	 * 根据以下获取到当前的国际化信息
	 * @param country  当前城市
	 * @param key      当前代号
	 * @return  返回具体的消息
	 */
	public String getMsg(int country, long key) {
		var data = getMsgRecord(country,key);
		if (null == data) {
			return String.format(notFound, country,key);
		} else {
			return data.get(Tables.ELF_BASE_LANGUAGE.MSG);
		}
	}
}
