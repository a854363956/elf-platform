/*
 * This file is generated by jOOQ.
 */
package org.elf.db.tables.pojos;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.annotation.Generated;


/**
 * 所属机构的汇总
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ElfBaseMechanism implements Serializable {

    private static final long serialVersionUID = -1521494130;

    private final Long      id;
    private final Long      mechanismCode;
    private final String    mechanismName;
    private final Long      invalid;
    private final Timestamp effectiveDate;

    public ElfBaseMechanism(ElfBaseMechanism value) {
        this.id = value.id;
        this.mechanismCode = value.mechanismCode;
        this.mechanismName = value.mechanismName;
        this.invalid = value.invalid;
        this.effectiveDate = value.effectiveDate;
    }

    public ElfBaseMechanism(
        Long      id,
        Long      mechanismCode,
        String    mechanismName,
        Long      invalid,
        Timestamp effectiveDate
    ) {
        this.id = id;
        this.mechanismCode = mechanismCode;
        this.mechanismName = mechanismName;
        this.invalid = invalid;
        this.effectiveDate = effectiveDate;
    }

    public Long getId() {
        return this.id;
    }

    public Long getMechanismCode() {
        return this.mechanismCode;
    }

    public String getMechanismName() {
        return this.mechanismName;
    }

    public Long getInvalid() {
        return this.invalid;
    }

    public Timestamp getEffectiveDate() {
        return this.effectiveDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ElfBaseMechanism (");

        sb.append(id);
        sb.append(", ").append(mechanismCode);
        sb.append(", ").append(mechanismName);
        sb.append(", ").append(invalid);
        sb.append(", ").append(effectiveDate);

        sb.append(")");
        return sb.toString();
    }
}
