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
import org.elf.db.tables.records.ElfBaseSessionRecord;
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
 * 维护用户当前登入的session
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ElfBaseSession extends TableImpl<ElfBaseSessionRecord> {

    private static final long serialVersionUID = 918987514;

    /**
     * The reference instance of <code>elf.elf_base_session</code>
     */
    public static final ElfBaseSession ELF_BASE_SESSION = new ElfBaseSession();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ElfBaseSessionRecord> getRecordType() {
        return ElfBaseSessionRecord.class;
    }

    /**
     * The column <code>elf.elf_base_session.id</code>.
     */
    public final TableField<ElfBaseSessionRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>elf.elf_base_session.session_code</code>. 显示给前台的session_code,64位的UUID防止用户进行暴力破解
     */
    public final TableField<ElfBaseSessionRecord, String> SESSION_CODE = createField("session_code", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "显示给前台的session_code,64位的UUID防止用户进行暴力破解");

    /**
     * The column <code>elf.elf_base_session.user_id</code>. 用户ID
     */
    public final TableField<ElfBaseSessionRecord, Long> USER_ID = createField("user_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "用户ID");

    /**
     * The column <code>elf.elf_base_session.equipment_id</code>. 设备类型
     */
    public final TableField<ElfBaseSessionRecord, Long> EQUIPMENT_ID = createField("equipment_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "设备类型");

    /**
     * The column <code>elf.elf_base_session.last_date</code>. 最后操作时间
     */
    public final TableField<ElfBaseSessionRecord, Timestamp> LAST_DATE = createField("last_date", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "最后操作时间");

    /**
     * The column <code>elf.elf_base_session.create_date</code>. 创建时间
     */
    public final TableField<ElfBaseSessionRecord, Timestamp> CREATE_DATE = createField("create_date", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "创建时间");

    /**
     * Create a <code>elf.elf_base_session</code> table reference
     */
    public ElfBaseSession() {
        this(DSL.name("elf_base_session"), null);
    }

    /**
     * Create an aliased <code>elf.elf_base_session</code> table reference
     */
    public ElfBaseSession(String alias) {
        this(DSL.name(alias), ELF_BASE_SESSION);
    }

    /**
     * Create an aliased <code>elf.elf_base_session</code> table reference
     */
    public ElfBaseSession(Name alias) {
        this(alias, ELF_BASE_SESSION);
    }

    private ElfBaseSession(Name alias, Table<ElfBaseSessionRecord> aliased) {
        this(alias, aliased, null);
    }

    private ElfBaseSession(Name alias, Table<ElfBaseSessionRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("维护用户当前登入的session"));
    }

    public <O extends Record> ElfBaseSession(Table<O> child, ForeignKey<O, ElfBaseSessionRecord> key) {
        super(child, key, ELF_BASE_SESSION);
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
        return Arrays.<Index>asList(Indexes.ELF_BASE_SESSION_PRIMARY, Indexes.ELF_BASE_SESSION_SESSION_TO_EQUIPMENT_IDX, Indexes.ELF_BASE_SESSION_SESSION_TO_USER_IDX);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ElfBaseSessionRecord> getPrimaryKey() {
        return Keys.KEY_ELF_BASE_SESSION_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ElfBaseSessionRecord>> getKeys() {
        return Arrays.<UniqueKey<ElfBaseSessionRecord>>asList(Keys.KEY_ELF_BASE_SESSION_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<ElfBaseSessionRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<ElfBaseSessionRecord, ?>>asList(Keys.SESSION_TO_USER, Keys.SESSION_TO_EQUIPMENT);
    }

    public ElfBaseUser elfBaseUser() {
        return new ElfBaseUser(this, Keys.SESSION_TO_USER);
    }

    public ElfBaseEquipment elfBaseEquipment() {
        return new ElfBaseEquipment(this, Keys.SESSION_TO_EQUIPMENT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ElfBaseSession as(String alias) {
        return new ElfBaseSession(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ElfBaseSession as(Name alias) {
        return new ElfBaseSession(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public ElfBaseSession rename(String name) {
        return new ElfBaseSession(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public ElfBaseSession rename(Name name) {
        return new ElfBaseSession(name, null);
    }
}
