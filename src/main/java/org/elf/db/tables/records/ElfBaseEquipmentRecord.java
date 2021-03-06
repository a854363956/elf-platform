/*
 * This file is generated by jOOQ.
 */
package org.elf.db.tables.records;


import javax.annotation.Generated;

import org.elf.db.tables.ElfBaseEquipment;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * 设备信息维护表
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ElfBaseEquipmentRecord extends UpdatableRecordImpl<ElfBaseEquipmentRecord> implements Record3<Long, String, Long> {

    private static final long serialVersionUID = -138617242;

    /**
     * Setter for <code>elf.elf_base_equipment.id</code>.
     */
    public ElfBaseEquipmentRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>elf.elf_base_equipment.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>elf.elf_base_equipment.equipment_name</code>. 设备名称
     */
    public ElfBaseEquipmentRecord setEquipmentName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>elf.elf_base_equipment.equipment_name</code>. 设备名称
     */
    public String getEquipmentName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>elf.elf_base_equipment.mechanism_id</code>. 机构ID
     */
    public ElfBaseEquipmentRecord setMechanismId(Long value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>elf.elf_base_equipment.mechanism_id</code>. 机构ID
     */
    public Long getMechanismId() {
        return (Long) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Long, String, Long> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Long, String, Long> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return ElfBaseEquipment.ELF_BASE_EQUIPMENT.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return ElfBaseEquipment.ELF_BASE_EQUIPMENT.EQUIPMENT_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field3() {
        return ElfBaseEquipment.ELF_BASE_EQUIPMENT.MECHANISM_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getEquipmentName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component3() {
        return getMechanismId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getEquipmentName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value3() {
        return getMechanismId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ElfBaseEquipmentRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ElfBaseEquipmentRecord value2(String value) {
        setEquipmentName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ElfBaseEquipmentRecord value3(Long value) {
        setMechanismId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ElfBaseEquipmentRecord values(Long value1, String value2, Long value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ElfBaseEquipmentRecord
     */
    public ElfBaseEquipmentRecord() {
        super(ElfBaseEquipment.ELF_BASE_EQUIPMENT);
    }

    /**
     * Create a detached, initialised ElfBaseEquipmentRecord
     */
    public ElfBaseEquipmentRecord(Long id, String equipmentName, Long mechanismId) {
        super(ElfBaseEquipment.ELF_BASE_EQUIPMENT);

        set(0, id);
        set(1, equipmentName);
        set(2, mechanismId);
    }
}
