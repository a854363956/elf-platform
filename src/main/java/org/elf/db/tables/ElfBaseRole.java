/*
 * This file is generated by jOOQ.
 */
package org.elf.db.tables;


import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.elf.db.Elf;
import org.elf.db.Indexes;
import org.elf.db.Keys;
import org.elf.db.tables.records.ElfBaseRoleRecord;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * 角色信息管理
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ElfBaseRole extends TableImpl<ElfBaseRoleRecord> {

    private static final long serialVersionUID = -1745551347;

    /**
     * The reference instance of <code>elf.elf_base_role</code>
     */
    public static final ElfBaseRole ELF_BASE_ROLE = new ElfBaseRole();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ElfBaseRoleRecord> getRecordType() {
        return ElfBaseRoleRecord.class;
    }

    /**
     * The column <code>elf.elf_base_role.id</code>.
     */
    public final TableField<ElfBaseRoleRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>elf.elf_base_role.role_name</code>. 角色名称
     */
    public final TableField<ElfBaseRoleRecord, String> ROLE_NAME = createField("role_name", org.jooq.impl.SQLDataType.VARCHAR(45).nullable(false), this, "角色名称");

    /**
     * The column <code>elf.elf_base_role.mechanism_id</code>. 所属仓库
     */
    public final TableField<ElfBaseRoleRecord, Long> MECHANISM_ID = createField("mechanism_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "所属仓库");

    /**
     * The column <code>elf.elf_base_role.create_date</code>. 创建时间
     */
    public final TableField<ElfBaseRoleRecord, Timestamp> CREATE_DATE = createField("create_date", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "创建时间");

    /**
     * Create a <code>elf.elf_base_role</code> table reference
     */
    public ElfBaseRole() {
        this(DSL.name("elf_base_role"), null);
    }

    /**
     * Create an aliased <code>elf.elf_base_role</code> table reference
     */
    public ElfBaseRole(String alias) {
        this(DSL.name(alias), ELF_BASE_ROLE);
    }

    /**
     * Create an aliased <code>elf.elf_base_role</code> table reference
     */
    public ElfBaseRole(Name alias) {
        this(alias, ELF_BASE_ROLE);
    }

    private ElfBaseRole(Name alias, Table<ElfBaseRoleRecord> aliased) {
        this(alias, aliased, null);
    }

    private ElfBaseRole(Name alias, Table<ElfBaseRoleRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("角色信息管理"));
    }

    public <O extends Record> ElfBaseRole(Table<O> child, ForeignKey<O, ElfBaseRoleRecord> key) {
        super(child, key, ELF_BASE_ROLE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Elf.ELF;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.ELF_BASE_ROLE_PRIMARY, Indexes.ELF_BASE_ROLE_ROLE_TO_MECHANISM_IDX);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ElfBaseRoleRecord> getPrimaryKey() {
        return Keys.KEY_ELF_BASE_ROLE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ElfBaseRoleRecord>> getKeys() {
        return Arrays.<UniqueKey<ElfBaseRoleRecord>>asList(Keys.KEY_ELF_BASE_ROLE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<ElfBaseRoleRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<ElfBaseRoleRecord, ?>>asList(Keys.ROLE_TO_MECHANISM);
    }

    public ElfBaseMechanism elfBaseMechanism() {
        return new ElfBaseMechanism(this, Keys.ROLE_TO_MECHANISM);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ElfBaseRole as(String alias) {
        return new ElfBaseRole(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ElfBaseRole as(Name alias) {
        return new ElfBaseRole(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public ElfBaseRole rename(String name) {
        return new ElfBaseRole(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public ElfBaseRole rename(Name name) {
        return new ElfBaseRole(name, null);
    }
}
