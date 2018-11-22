/*
 * This file is generated by jOOQ.
 */
package org.elf.db.tables.pojos;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.annotation.Generated;


/**
 * 用来维护用户信息
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ElfBaseUser implements Serializable {

    private static final long serialVersionUID = 1218339220;

    private final Long      id;
    private final String    userName;
    private final String    loginName;
    private final String    email;
    private final Long      language;
    private final Long      roleId;
    private final Timestamp createDate;
    private final Integer   online;
    private final String    password;

    public ElfBaseUser(ElfBaseUser value) {
        this.id = value.id;
        this.userName = value.userName;
        this.loginName = value.loginName;
        this.email = value.email;
        this.language = value.language;
        this.roleId = value.roleId;
        this.createDate = value.createDate;
        this.online = value.online;
        this.password = value.password;
    }

    public ElfBaseUser(
        Long      id,
        String    userName,
        String    loginName,
        String    email,
        Long      language,
        Long      roleId,
        Timestamp createDate,
        Integer   online,
        String    password
    ) {
        this.id = id;
        this.userName = userName;
        this.loginName = loginName;
        this.email = email;
        this.language = language;
        this.roleId = roleId;
        this.createDate = createDate;
        this.online = online;
        this.password = password;
    }

    public Long getId() {
        return this.id;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getLoginName() {
        return this.loginName;
    }

    public String getEmail() {
        return this.email;
    }

    public Long getLanguage() {
        return this.language;
    }

    public Long getRoleId() {
        return this.roleId;
    }

    public Timestamp getCreateDate() {
        return this.createDate;
    }

    public Integer getOnline() {
        return this.online;
    }

    public String getPassword() {
        return this.password;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ElfBaseUser (");

        sb.append(id);
        sb.append(", ").append(userName);
        sb.append(", ").append(loginName);
        sb.append(", ").append(email);
        sb.append(", ").append(language);
        sb.append(", ").append(roleId);
        sb.append(", ").append(createDate);
        sb.append(", ").append(online);
        sb.append(", ").append(password);

        sb.append(")");
        return sb.toString();
    }
}
