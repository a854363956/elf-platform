package org.elf.mvc.models;

import java.util.ArrayList;
import java.util.List;

import org.elf.db.Tables;
import org.elf.db.tables.pojos.ElfBaseMechanism;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ElfBaseMechanismModels {
	@Autowired
	private DSLContext dsl;
	
	/**
	 * 根据当前人员Id查询当前人员Id可以访问的机构
	 * @param userId 当前用户id
	 * @return
	 */
	public List<ElfBaseMechanism> getMechanismGroup(long userId) {
		return dsl.select(Tables.ELF_BASE_MECHANISM.fields()).from(Tables.ELF_BASE_MECHANISM)
				.leftJoin(Tables.ELF_BASE_MECHANISM_GROUP)
				.on(Tables.ELF_BASE_MECHANISM_GROUP.MECHANISM_ID.eq(Tables.ELF_BASE_MECHANISM.ID))
				.where(Tables.ELF_BASE_MECHANISM_GROUP.USER_ID.eq(userId))
				.and(Tables.ELF_BASE_MECHANISM.INVALID.notEqual(1L))
				.fetch().into(ElfBaseMechanism.class);
	}
	
}
