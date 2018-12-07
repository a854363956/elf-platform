/*
 * This file is generated by jOOQ.
 */
package org.elf.db;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.elf.db.tables.ElfBaseEquipment;
import org.elf.db.tables.ElfBaseEquipmentGroup;
import org.elf.db.tables.ElfBaseLanguage;
import org.elf.db.tables.ElfBaseMechanism;
import org.elf.db.tables.ElfBaseMechanismGroup;
import org.elf.db.tables.ElfBaseRole;
import org.elf.db.tables.ElfBaseSession;
import org.elf.db.tables.ElfBaseUser;
import org.elf.db.tables.ElfMenuData;
import org.elf.db.tables.ElfMenuDataMapping;
import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Elf extends SchemaImpl {

    private static final long serialVersionUID = -1585043873;

    /**
     * The reference instance of <code>elf</code>
     */
    public static final Elf ELF = new Elf();

    /**
     * 设备信息维护表
     */
    public final ElfBaseEquipment ELF_BASE_EQUIPMENT = org.elf.db.tables.ElfBaseEquipment.ELF_BASE_EQUIPMENT;

    /**
     * 设备信息分组表
     */
    public final ElfBaseEquipmentGroup ELF_BASE_EQUIPMENT_GROUP = org.elf.db.tables.ElfBaseEquipmentGroup.ELF_BASE_EQUIPMENT_GROUP;

    /**
     * 用来做国际化翻译后台的提示信息
     */
    public final ElfBaseLanguage ELF_BASE_LANGUAGE = org.elf.db.tables.ElfBaseLanguage.ELF_BASE_LANGUAGE;

    /**
     * 所属机构的汇总
     */
    public final ElfBaseMechanism ELF_BASE_MECHANISM = org.elf.db.tables.ElfBaseMechanism.ELF_BASE_MECHANISM;

    /**
     * 所属机构，和用户对应的详细信息
     */
    public final ElfBaseMechanismGroup ELF_BASE_MECHANISM_GROUP = org.elf.db.tables.ElfBaseMechanismGroup.ELF_BASE_MECHANISM_GROUP;

    /**
     * 角色信息管理
     */
    public final ElfBaseRole ELF_BASE_ROLE = org.elf.db.tables.ElfBaseRole.ELF_BASE_ROLE;

    /**
     * 维护用户当前登入的session
     */
    public final ElfBaseSession ELF_BASE_SESSION = org.elf.db.tables.ElfBaseSession.ELF_BASE_SESSION;

    /**
     * 用来维护用户信息
     */
    public final ElfBaseUser ELF_BASE_USER = org.elf.db.tables.ElfBaseUser.ELF_BASE_USER;

    /**
     * 基础的菜单信息维护
     */
    public final ElfMenuData ELF_MENU_DATA = org.elf.db.tables.ElfMenuData.ELF_MENU_DATA;

    /**
     * 菜单权限映射表
     */
    public final ElfMenuDataMapping ELF_MENU_DATA_MAPPING = org.elf.db.tables.ElfMenuDataMapping.ELF_MENU_DATA_MAPPING;

    /**
     * No further instances allowed
     */
    private Elf() {
        super("elf", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            ElfBaseEquipment.ELF_BASE_EQUIPMENT,
            ElfBaseEquipmentGroup.ELF_BASE_EQUIPMENT_GROUP,
            ElfBaseLanguage.ELF_BASE_LANGUAGE,
            ElfBaseMechanism.ELF_BASE_MECHANISM,
            ElfBaseMechanismGroup.ELF_BASE_MECHANISM_GROUP,
            ElfBaseRole.ELF_BASE_ROLE,
            ElfBaseSession.ELF_BASE_SESSION,
            ElfBaseUser.ELF_BASE_USER,
            ElfMenuData.ELF_MENU_DATA,
            ElfMenuDataMapping.ELF_MENU_DATA_MAPPING);
    }
}
