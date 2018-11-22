/*
 * This file is generated by jOOQ.
 */
package org.elf.db.tables.pojos;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.annotation.Generated;


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
public class ElfBaseSession implements Serializable {

    private static final long serialVersionUID = 1582737796;

    private final Long      id;
    private final String    sessionCode;
    private final Long      userId;
    private final Long      equipmentId;
    private final Timestamp lastDate;
    private final Timestamp createDate;

    public ElfBaseSession(ElfBaseSession value) {
        this.id = value.id;
        this.sessionCode = value.sessionCode;
        this.userId = value.userId;
        this.equipmentId = value.equipmentId;
        this.lastDate = value.lastDate;
        this.createDate = value.createDate;
    }

    public ElfBaseSession(
        Long      id,
        String    sessionCode,
        Long      userId,
        Long      equipmentId,
        Timestamp lastDate,
        Timestamp createDate
    ) {
        this.id = id;
        this.sessionCode = sessionCode;
        this.userId = userId;
        this.equipmentId = equipmentId;
        this.lastDate = lastDate;
        this.createDate = createDate;
    }

    public Long getId() {
        return this.id;
    }

    public String getSessionCode() {
        return this.sessionCode;
    }

    public Long getUserId() {
        return this.userId;
    }

    public Long getEquipmentId() {
        return this.equipmentId;
    }

    public Timestamp getLastDate() {
        return this.lastDate;
    }

    public Timestamp getCreateDate() {
        return this.createDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ElfBaseSession (");

        sb.append(id);
        sb.append(", ").append(sessionCode);
        sb.append(", ").append(userId);
        sb.append(", ").append(equipmentId);
        sb.append(", ").append(lastDate);
        sb.append(", ").append(createDate);

        sb.append(")");
        return sb.toString();
    }
}
