/*
 * This file is generated by jOOQ.
 */
package org.elf.db.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.elf.db.Elf;
import org.elf.db.Indexes;
import org.elf.db.Keys;
import org.elf.db.tables.records.ElfBaseMechanismGroupRecord;
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
 * 所属机构，和用户对应的详细信息
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ElfBaseMechanismGroup extends TableImpl<ElfBaseMechanismGroupRecord> {

    private static final long serialVersionUID = -2013801501;

    /**
     * The reference instance of <code>elf.elf_base_mechanism_group</code>
     */
    public static final ElfBaseMechanismGroup ELF_BASE_MECHANISM_GROUP = new ElfBaseMechanismGroup();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ElfBaseMechanismGroupRecord> getRecordType() {
        return ElfBaseMechanismGroupRecord.class;
    }

    /**
     * The column <code>elf.elf_base_mechanism_group.id</code>.
     */
    public final TableField<ElfBaseMechanismGroupRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>elf.elf_base_mechanism_group.mechanism_id</code>.
     */
    public final TableField<ElfBaseMechanismGroupRecord, Long> MECHANISM_ID = createField("mechanism_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>elf.elf_base_mechanism_group.user_id</code>.
     */
    public final TableField<ElfBaseMechanismGroupRecord, Long> USER_ID = createField("user_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * Create a <code>elf.elf_base_mechanism_group</code> table reference
     */
    public ElfBaseMechanismGroup() {
        this(DSL.name("elf_base_mechanism_group"), null);
    }

    /**
     * Create an aliased <code>elf.elf_base_mechanism_group</code> table reference
     */
    public ElfBaseMechanismGroup(String alias) {
        this(DSL.name(alias), ELF_BASE_MECHANISM_GROUP);
    }

    /**
     * Create an aliased <code>elf.elf_base_mechanism_group</code> table reference
     */
    public ElfBaseMechanismGroup(Name alias) {
        this(alias, ELF_BASE_MECHANISM_GROUP);
    }

    private ElfBaseMechanismGroup(Name alias, Table<ElfBaseMechanismGroupRecord> aliased) {
        this(alias, aliased, null);
    }

    private ElfBaseMechanismGroup(Name alias, Table<ElfBaseMechanismGroupRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("所属机构，和用户对应的详细信息"));
    }

    public <O extends Record> ElfBaseMechanismGroup(Table<O> child, ForeignKey<O, ElfBaseMechanismGroupRecord> key) {
        super(child, key, ELF_BASE_MECHANISM_GROUP);
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
        return Arrays.<Index>asList(Indexes.ELF_BASE_MECHANISM_GROUP_MECHANISM_GROUP_TO_MECHANISM_IDX, Indexes.ELF_BASE_MECHANISM_GROUP_MECHANISM_GROUP_TO_USER_IDX, Indexes.ELF_BASE_MECHANISM_GROUP_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ElfBaseMechanismGroupRecord> getPrimaryKey() {
        return Keys.KEY_ELF_BASE_MECHANISM_GROUP_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ElfBaseMechanismGroupRecord>> getKeys() {
        return Arrays.<UniqueKey<ElfBaseMechanismGroupRecord>>asList(Keys.KEY_ELF_BASE_MECHANISM_GROUP_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<ElfBaseMechanismGroupRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<ElfBaseMechanismGroupRecord, ?>>asList(Keys.MECHANISM_GROUP_TO_MECHANISM, Keys.MECHANISM_GROUP_TO_USER);
    }

    public ElfBaseMechanism elfBaseMechanism() {
        return new ElfBaseMechanism(this, Keys.MECHANISM_GROUP_TO_MECHANISM);
    }

    public ElfBaseUser elfBaseUser() {
        return new ElfBaseUser(this, Keys.MECHANISM_GROUP_TO_USER);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ElfBaseMechanismGroup as(String alias) {
        return new ElfBaseMechanismGroup(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ElfBaseMechanismGroup as(Name alias) {
        return new ElfBaseMechanismGroup(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public ElfBaseMechanismGroup rename(String name) {
        return new ElfBaseMechanismGroup(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public ElfBaseMechanismGroup rename(Name name) {
        return new ElfBaseMechanismGroup(name, null);
    }
}
