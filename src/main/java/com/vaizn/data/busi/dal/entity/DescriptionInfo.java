package com.vaizn.data.busi.dal.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vaizn.common.DateSerializerForDay;

@Table(name = "t_description_info")
public class DescriptionInfo implements Serializable {

	private static final long serialVersionUID = -3544581306152736954L;

	@Id
    @GeneratedValue(generator="UUID")
    private String descId;

    private String descTitle;

    private String descCategory;

    private String descSource;

    private Date createDate;

    private String descStatus;

    private String descDetail;

    public String getDescId() {
        return descId;
    }

    public void setDescId(String descId) {
        this.descId = descId;
    }

    public String getDescTitle() {
        return descTitle;
    }

    public void setDescTitle(String descTitle) {
        this.descTitle = descTitle;
    }

    public String getDescCategory() {
		return descCategory;
	}

	public void setDescCategory(String descCategory) {
		this.descCategory = descCategory;
	}

	public String getDescSource() {
        return descSource;
    }

    public void setDescSource(String descSource) {
        this.descSource = descSource;
    }

    @JsonSerialize(using = DateSerializerForDay.class)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

	public String getDescStatus() {
		return descStatus;
	}

	public void setDescStatus(String descStatus) {
		this.descStatus = descStatus;
	}

	public String getDescDetail() {
        return descDetail;
    }

    public void setDescDetail(String descDetail) {
        this.descDetail = descDetail;
    }
}