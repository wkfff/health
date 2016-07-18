package com.vaizn.data.busi.dal.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_description_info")
public class DescriptionInfo {
    @Id
    @GeneratedValue(generator="UUID")
    private String descId;

    private String descTitle;

    private String categoryCode;

    private String categoryName;

    private String descSource;

    private Date createDate;

    private Integer descValid;

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

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescSource() {
        return descSource;
    }

    public void setDescSource(String descSource) {
        this.descSource = descSource;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getDescValid() {
		return descValid;
	}

	public void setDescValid(Integer descValid) {
		this.descValid = descValid;
	}

	public String getDescDetail() {
        return descDetail;
    }

    public void setDescDetail(String descDetail) {
        this.descDetail = descDetail;
    }
}