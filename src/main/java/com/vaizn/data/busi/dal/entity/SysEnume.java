package com.vaizn.data.busi.dal.entity;

import javax.persistence.*;

@Table(name = "sys_enume")
public class SysEnume {
    @Id
    @Column(name = "enume_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String enumeId;

    @Column(name = "enume_code")
    private String enumeCode;

    @Column(name = "enume_desc")
    private String enumeDesc;

    @Column(name = "busi_table")
    private String busiTable;

    /**
     * @return enume_id
     */
    public String getEnumeId() {
        return enumeId;
    }

    /**
     * @param enumeId
     */
    public void setEnumeId(String enumeId) {
        this.enumeId = enumeId;
    }

    /**
     * @return enume_code
     */
    public String getEnumeCode() {
        return enumeCode;
    }

    /**
     * @param enumeCode
     */
    public void setEnumeCode(String enumeCode) {
        this.enumeCode = enumeCode;
    }

    /**
     * @return enume_desc
     */
    public String getEnumeDesc() {
        return enumeDesc;
    }

    /**
     * @param enumeDesc
     */
    public void setEnumeDesc(String enumeDesc) {
        this.enumeDesc = enumeDesc;
    }

    /**
     * @return busi_table
     */
    public String getBusiTable() {
        return busiTable;
    }

    /**
     * @param busiTable
     */
    public void setBusiTable(String busiTable) {
        this.busiTable = busiTable;
    }
}