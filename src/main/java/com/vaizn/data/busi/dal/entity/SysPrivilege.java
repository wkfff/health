package com.vaizn.data.busi.dal.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_privilege")
public class SysPrivilege implements Serializable {

	private static final long serialVersionUID = 944848535226572496L;

	@Id
    @GeneratedValue(generator="UUID")
    private String privilegeId;

    private String privilegeMaster;

    private String masterCode;

    private String privilegeAccess;

    private String accessCode;

    private String privilegeOperator;

    private String privilegeCreator;

    private Date createDate;

    private String privilegeModitor;

    private Date modiDate;

    public String getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(String privilegeId) {
        this.privilegeId = privilegeId;
    }

    public String getPrivilegeMaster() {
        return privilegeMaster;
    }

    public void setPrivilegeMaster(String privilegeMaster) {
        this.privilegeMaster = privilegeMaster;
    }

    public String getMasterCode() {
        return masterCode;
    }

    public void setMasterCode(String masterCode) {
        this.masterCode = masterCode;
    }

    public String getPrivilegeAccess() {
        return privilegeAccess;
    }

    public void setPrivilegeAccess(String privilegeAccess) {
        this.privilegeAccess = privilegeAccess;
    }

    public String getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(String accessCode) {
        this.accessCode = accessCode;
    }

    public String getPrivilegeOperator() {
        return privilegeOperator;
    }

    public void setPrivilegeOperator(String privilegeOperator) {
        this.privilegeOperator = privilegeOperator;
    }

    public String getPrivilegeCreator() {
        return privilegeCreator;
    }

    public void setPrivilegeCreator(String privilegeCreator) {
        this.privilegeCreator = privilegeCreator;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getPrivilegeModitor() {
        return privilegeModitor;
    }

    public void setPrivilegeModitor(String privilegeModitor) {
        this.privilegeModitor = privilegeModitor;
    }

    public Date getModiDate() {
        return modiDate;
    }

    public void setModiDate(Date modiDate) {
        this.modiDate = modiDate;
    }
}