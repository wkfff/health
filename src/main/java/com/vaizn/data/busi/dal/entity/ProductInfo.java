package com.vaizn.data.busi.dal.entity;

import javax.persistence.*;

@Table(name = "t_product_info")
public class ProductInfo {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String productId;

    @Column(name = "category_code")
    private String categoryCode;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "brand_name")
    private String brandName;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_material")
    private String productMaterial;

    @Column(name = "product_cert_no")
    private String productCertNo;

    @Column(name = "product_standard_no")
    private String productStandardNo;

    @Column(name = "sanitary_cert_no")
    private String sanitaryCertNo;

    @Column(name = "product_original")
    private String productOriginal;

    @Column(name = "product_garantee")
    private String productGarantee;

    @Column(name = "product_company")
    private String productCompany;

    @Column(name = "company_address")
    private String companyAddress;

    @Column(name = "company_phone")
    private String companyPhone;

    @Column(name = "product_factory")
    private String productFactory;

    @Column(name = "factory_address")
    private String factoryAddress;

    @Column(name = "factory_phone")
    private String factoryPhone;

    @Column(name = "product_agent")
    private String productAgent;

    @Column(name = "agent_address")
    private String agentAddress;

    @Column(name = "agent_phone")
    private String agentPhone;

    @Column(name = "bar_code")
    private String barCode;

    @Column(name = "net_content")
    private String netContent;

    @Column(name = "product_usage")
    private String productUsage;

    /**
     * @return product_id
     */
    public String getProductId() {
        return productId;
    }

    /**
     * @param productId
     */
    public void setProductId(String productId) {
        this.productId = productId;
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
     * @return brand_name
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * @param brandName
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    /**
     * @return product_name
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return product_material
     */
    public String getProductMaterial() {
        return productMaterial;
    }

    /**
     * @param productMaterial
     */
    public void setProductMaterial(String productMaterial) {
        this.productMaterial = productMaterial;
    }

    /**
     * @return product_cert_no
     */
    public String getProductCertNo() {
        return productCertNo;
    }

    /**
     * @param productCertNo
     */
    public void setProductCertNo(String productCertNo) {
        this.productCertNo = productCertNo;
    }

    /**
     * @return product_standard_no
     */
    public String getProductStandardNo() {
        return productStandardNo;
    }

    /**
     * @param productStandardNo
     */
    public void setProductStandardNo(String productStandardNo) {
        this.productStandardNo = productStandardNo;
    }

    /**
     * @return sanitary_cert_no
     */
    public String getSanitaryCertNo() {
        return sanitaryCertNo;
    }

    /**
     * @param sanitaryCertNo
     */
    public void setSanitaryCertNo(String sanitaryCertNo) {
        this.sanitaryCertNo = sanitaryCertNo;
    }

    /**
     * @return product_original
     */
    public String getProductOriginal() {
        return productOriginal;
    }

    /**
     * @param productOriginal
     */
    public void setProductOriginal(String productOriginal) {
        this.productOriginal = productOriginal;
    }

    /**
     * @return product_garantee
     */
    public String getProductGarantee() {
        return productGarantee;
    }

    /**
     * @param productGarantee
     */
    public void setProductGarantee(String productGarantee) {
        this.productGarantee = productGarantee;
    }

    /**
     * @return product_company
     */
    public String getProductCompany() {
        return productCompany;
    }

    /**
     * @param productCompany
     */
    public void setProductCompany(String productCompany) {
        this.productCompany = productCompany;
    }

    /**
     * @return company_address
     */
    public String getCompanyAddress() {
        return companyAddress;
    }

    /**
     * @param companyAddress
     */
    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    /**
     * @return company_phone
     */
    public String getCompanyPhone() {
        return companyPhone;
    }

    /**
     * @param companyPhone
     */
    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    /**
     * @return product_factory
     */
    public String getProductFactory() {
        return productFactory;
    }

    /**
     * @param productFactory
     */
    public void setProductFactory(String productFactory) {
        this.productFactory = productFactory;
    }

    /**
     * @return factory_address
     */
    public String getFactoryAddress() {
        return factoryAddress;
    }

    /**
     * @param factoryAddress
     */
    public void setFactoryAddress(String factoryAddress) {
        this.factoryAddress = factoryAddress;
    }

    /**
     * @return factory_phone
     */
    public String getFactoryPhone() {
        return factoryPhone;
    }

    /**
     * @param factoryPhone
     */
    public void setFactoryPhone(String factoryPhone) {
        this.factoryPhone = factoryPhone;
    }

    /**
     * @return product_agent
     */
    public String getProductAgent() {
        return productAgent;
    }

    /**
     * @param productAgent
     */
    public void setProductAgent(String productAgent) {
        this.productAgent = productAgent;
    }

    /**
     * @return agent_address
     */
    public String getAgentAddress() {
        return agentAddress;
    }

    /**
     * @param agentAddress
     */
    public void setAgentAddress(String agentAddress) {
        this.agentAddress = agentAddress;
    }

    /**
     * @return agent_phone
     */
    public String getAgentPhone() {
        return agentPhone;
    }

    /**
     * @param agentPhone
     */
    public void setAgentPhone(String agentPhone) {
        this.agentPhone = agentPhone;
    }

    /**
     * @return bar_code
     */
    public String getBarCode() {
        return barCode;
    }

    /**
     * @param barCode
     */
    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    /**
     * @return net_content
     */
    public String getNetContent() {
        return netContent;
    }

    /**
     * @param netContent
     */
    public void setNetContent(String netContent) {
        this.netContent = netContent;
    }

    /**
     * @return product_usage
     */
    public String getProductUsage() {
        return productUsage;
    }

    /**
     * @param productUsage
     */
    public void setProductUsage(String productUsage) {
        this.productUsage = productUsage;
    }
}