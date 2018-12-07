package org.elf.mvc.models;

import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.elf.db.Tables;
import org.elf.db.tables.pojos.ElfBaseEquipmentGroup;
import org.elf.db.tables.pojos.ElfBaseMechanismGroup;
import org.elf.db.tables.pojos.ElfBaseRole;
import org.elf.db.tables.pojos.ElfBaseSession;
import org.elf.db.tables.pojos.ElfBaseUser;
import org.elf.mvc.error.ElfRunException;
import org.elf.mvc.models.utils.City;
import org.elf.mvc.models.utils.SnowflakeIdGenerator;
import org.elf.mvc.models.utils.StringUtils;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 用来管理人员操作一些模块类 PS: 所有的数据必须通过SessionCode来进行判断,比如当前登入人等等...绝对不能通过前端传入的人员来进行判断
 * 
 * @author zhangj
 * @email zhangjin0908@hotmail.com
 */
@Component
public class ElfBaseUserModels {
	@Autowired
	private DSLContext dsl;
	@Autowired
	private SnowflakeIdGenerator sig;

	/**
	 * 用户点击登入按钮登入系统
	 * 
	 * @param userName    用户名
	 * @param password    密码
	 * @param equipmentId 设备的id
	 * @return
	 * @throws ElfRunException
	 * @throws NoSuchAlgorithmException
	 */
	public ElfBaseSession login(String userName, String password, long equipmentId)
			throws ElfRunException, NoSuchAlgorithmException {
		var ebu = queryUser(userName);
		if (ebu == null) {
			// 表示当前人员名称输入错误，预占用-> 人员名称
			throw new ElfRunException(City.CHINA_CN.getValue(), 1000, userName);
		}
		var ebr = queryRole(ebu.getRoleId());
		if (ebr == null) {
			// 表示当前人员没有维护角色信息, 预占用->人员名称
			new ElfRunException(City.CHINA_CN.getValue(), 1001, userName);
		}
		if (!ebu.getPassword().equals(StringUtils.md5(password))) {
			// 如果账户的密码不正确则抛出密码不正确 预占用->人员名称
			throw new ElfRunException(City.CHINA_CN.getValue(), 1002, userName);
		}

		var ebs = querySession(ebu.getId(), equipmentId);
		if (ebs == null) {
			// 如果用户未登入,那么就创建登入数据
			var ebeg = queryEquipmentGroup(ebu.getRoleId(), equipmentId);
			if (ebeg == null) {
				throw new ElfRunException(City.CHINA_CN.getValue(), 1003, userName);
			}
			var elfSession = new ElfBaseSession(sig.nextId(), // 随机ID
					StringUtils.get64UUID(), // 64位的会话ID防止被暴力破解
					ebu.getId(), // 人员ID
					equipmentId, // 设备ID
					new Timestamp(new Date().getTime()), // 最后操作时间
					new Timestamp(new Date().getTime()));// 创建日期
			var dto = dsl.newRecord(Tables.ELF_BASE_SESSION, elfSession);
			dsl.executeInsert(dto);
			return elfSession;
		} else {
			// 如果当前用户登入了，那么只需要更新他的最后时间
			dsl.update(Tables.ELF_BASE_SESSION)
					.set(Tables.ELF_BASE_SESSION.LAST_DATE, new Timestamp(new Date().getTime()))
					.where(Tables.ELF_BASE_SESSION.ID.eq(ebs.getId())).execute();
			return ebs;
		}
	}

	/**
	 * 根据登入名称,获取当前登入的人的信息
	 * 
	 * @param username 登入人的登入名称
	 * @return 返回登入人的信息 null 未查询到对应人的信息
	 */
	public ElfBaseUser queryUser(String loginName) {
		var result = dsl.select().from(Tables.ELF_BASE_USER).where(Tables.ELF_BASE_USER.LOGIN_NAME.eq(loginName))
				.fetchAny();
		if (null == result) {
			return null;
		} else {
			return result.into(ElfBaseUser.class);
		}
	}

	/**
	 * 根据设备ID查询对应的设备关系映射表
	 * 
	 * @param equipmentId 设备ID
	 * @param roleId      角色信息
	 * @return
	 */
	public ElfBaseEquipmentGroup queryEquipmentGroup(long roleId, long equipmentId) {
		var result = dsl.select().from(Tables.ELF_BASE_EQUIPMENT_GROUP)
				.where(Tables.ELF_BASE_EQUIPMENT_GROUP.ROLE_ID.eq(roleId))
				.and(Tables.ELF_BASE_EQUIPMENT_GROUP.EQUIPMENT_ID.eq(equipmentId)).fetchAny();
		if (null == result) {
			return null;
		} else {
			return result.into(ElfBaseEquipmentGroup.class);
		}
	}

	/**
	 * 根据角色ID查询当前的角色信息
	 * 
	 * @param roleId 当前的角色ID
	 * @return 返回查询到的角色信息
	 */
	public ElfBaseRole queryRole(long roleId) {
		var result = dsl.select().from(Tables.ELF_BASE_ROLE).where(Tables.ELF_BASE_ROLE.ID.eq(roleId)).fetchAny();
		if (null == result) {
			return null;
		} else {
			return result.into(ElfBaseRole.class);
		}
	}

	/**
	 * 根据人员Id查询当前人员是否在系统内登入
	 * 
	 * @param userId 当前的人员ID
	 * @return 返回查询到当前用户登入的会话ID
	 */
	public ElfBaseSession querySession(long userId, long equipmentId) {
		var result = dsl.select().from(Tables.ELF_BASE_SESSION).where(Tables.ELF_BASE_SESSION.USER_ID.eq(userId))
				.and(Tables.ELF_BASE_SESSION.EQUIPMENT_ID.eq(equipmentId)).fetchAny();
		if (null == result) {
			return null;
		} else {
			return result.into(ElfBaseSession.class);
		}
	}

	/**
	 * 根据会话ID来进行查询当前的会话实体对象
	 * 
	 * @param id 当前会话的ID
	 * @return
	 */
	public ElfBaseSession querySession(long id) {
		var result = dsl.select().from(Tables.ELF_BASE_SESSION).where(Tables.ELF_BASE_SESSION.ID.eq(id)).fetchAny();
		if (null == result) {
			return null;
		} else {
			return result.into(ElfBaseSession.class);
		}
	}

	/**
	 * 根据人员Id查询当前人员可以访问的仓库编号
	 * 
	 * @param userId
	 * @return
	 */
	public List<ElfBaseMechanismGroup> queryMechanismGroup(long userId) {
		var result = dsl.select().from(Tables.ELF_BASE_MECHANISM_GROUP)
				.where(Tables.ELF_BASE_MECHANISM_GROUP.ID.eq(userId)).fetch();
		if (null == result) {
			return null;
		} else {
			return result.into(ElfBaseMechanismGroup.class);
		}
	}

	/**
	 * 根据SessionCode查询相关的session数据
	 * 
	 * @param sessionCode  sessionCode
	 * @param equipment_id 设备Id
	 * @return 返回查询到的Session数据集合
	 */
	public ElfBaseSession queryUserBySession(String sessionCode) {
		var data = dsl.select().from(Tables.ELF_BASE_SESSION)
				.where(Tables.ELF_BASE_SESSION.SESSION_CODE.eq(sessionCode)).fetchAny();
		if (data == null) {
			return null;
		} else {
			return data.into(ElfBaseSession.class);
		}
	}

	/**
	 * 通过SessionCode获取当前语言信息
	 * 
	 * @param sessionCode
	 * @return
	 */
	public Long getCurrentLanguage(String sessionCode) {
		return getCurrentUser(sessionCode).getLanguage();
	}

	/**
	 * 通过sessionCode获取当前人员信息
	 * 
	 * @param sessionCode
	 * @return
	 */
	public ElfBaseUser getCurrentUser(String sessionCode) {
		var elfBaseSession = queryUserBySession(sessionCode);
		return dsl.select().from(Tables.ELF_BASE_USER).where(Tables.ELF_BASE_USER.ID.eq(elfBaseSession.getUserId()))
				.fetchAny().into(ElfBaseUser.class);
	}

	/**
	 * 根据当前用户名和密码来进行修改密码
	 * 
	 * @param sessionCode 当前用户登入的sessionCode
	 * @param password    当前用户登入的密码
	 * @param newPassword 要修改的新密码
	 * @return
	 * @throws IllegalArgumentException
	 * @throws NoSuchAlgorithmException
	 * @throws ElfRunException
	 */
	public int updatePassword(String sessionCode, String password, String newPassword)
			throws IllegalArgumentException, NoSuchAlgorithmException, ElfRunException {
		var elfBaseUser = getCurrentUser(sessionCode);
		// 如果密码输入正确，则更新密码为输入的新密码
		if (elfBaseUser.getPassword().equals(StringUtils.md5(password))) {
			return dsl.update(Tables.ELF_BASE_USER).set(Tables.ELF_BASE_USER.PASSWORD, StringUtils.md5(newPassword))
					.execute();
		} else {
			throw new ElfRunException(getCurrentLanguage(sessionCode).intValue(), 1004);
		}
	}
}
