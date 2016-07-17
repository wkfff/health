package com.vaizn.data.busi.dal.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_description_info")
public class DescriptionInfo {
    @Id
    @Column(name = "desc_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String descId;

    @Column(name = "desc_title")
    private String descTitle;

    @Column(name = "category_code")
    private String categoryCode;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "desc_source")
    private String descSource;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "desc_valid")
    private Byte descValid;

    @Column(name = "desc_detail")
    private String descDetail;

    /**
     * @return desc_id
     */
    public String getDescId() {
        return descId;
    }

    /**
     * @param descId
     */
    public void setDescId(String descId) {
        this.descId = descId;
    }

    /**
     * @return desc_title
     */
    public String getDescTitle() {
        return descTitle;
    }

    /**
     * @param descTitle
     */
    public void setDescTitle(String descTitle) {
        this.descTitle = descTitle;
    }

    /**
     * @return category_code
     */
    public String getCategoryCode() {
        return categoryCode;
    }

    /**
     * @param categoryCode
     */
    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    /**
     * @return category_name
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * @param categoryName
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * @return desc_source
     */
    public String getDescSource() {
        return descSource;
    }

    /**
     * @param descSource
     */
    public void setDescSource(String descSource) {
        this.descSource = descSource;
    }

    /**
     * @return create_date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return desc_valid
     */
    public Byte getDescValid() {
        return descValid;
    }

    /**
     * @param descValid
     */
    public void setDescValid(Byte descValid) {
        this.descValid = descValid;
    }

    /**
     * @return desc_detail
     */
    public String getDescDetail() {
        return descDetail;
    }

    /**
     * @param descDetail
     */
    public void setDescDetail(String descDetail) {
        this.descDetail = descDetail;
    }
}