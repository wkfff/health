package com.vaizn.data.busi.dal.entity;

import javax.persistence.*;

@Table(name = "sys_enume")
public class SysEnume {
    @Id
    @GeneratedValue(generator="UUID")
    private String enumeId;

    private String enumeCode;

    private String enumeDesc;

    private String busiTable;

    public String getEnumeId() {
        return enumeId;
    }

    public void setEnumeId(String enumeId) {
        this.enumeId = enumeId;
    }

    public String getEnumeCode() {
        return enumeCode;
    }

    public void setEnumeCode(String enumeCode) {
        this.enumeCode = enumeCode;
    }

    public String getEnumeDesc() {
        return enumeDesc;
    }

    public void setEnumeDesc(String enumeDesc) {
        this.enumeDesc = enumeDesc;
    }

    public String getBusiTable() {
        return busiTable;
    }

    public void setBusiTable(String busiTable) {
        this.busiTable = busiTable;
    }
}