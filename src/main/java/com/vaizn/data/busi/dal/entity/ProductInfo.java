package com.vaizn.data.busi.dal.entity;

import java.io.Serializable;

import javax.persistence.*;

@Table(name = "t_product_info")
public class ProductInfo implements Serializable {

	private static final long serialVersionUID = -4881868555451055959L;

	@Id
    @GeneratedValue(generator="UUID")
    private String productId;

    private String productCategory;

    private String brandName;

    private String productName;

    private String productMaterial;

    private String productCertNo;

    private String productStandardNo;

    private String sanitaryCertNo;

    private String productOriginal;

    private String productGarantee;

    private String productCompany;

    private String companyAddress;

    private String companyPhone;

    private String productFactory;

    private String factoryAddress;

    private String factoryPhone;

    private String productAgent;

    private String agentAddress;

    private String agentPhone;

    private String barCode;

    private String netContent;

    private String productUsage;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductMaterial() {
        return productMaterial;
    }

    public void setProductMaterial(String productMaterial) {
        this.productMaterial = productMaterial;
    }

    public String getProductCertNo() {
        return productCertNo;
    }

    public void setProductCertNo(String productCertNo) {
        this.productCertNo = productCertNo;
    }

    public String getProductStandardNo() {
        return productStandardNo;
    }

    public void setProductStandardNo(String productStandardNo) {
        this.productStandardNo = productStandardNo;
    }

    public String getSanitaryCertNo() {
        return sanitaryCertNo;
    }

    public void setSanitaryCertNo(String sanitaryCertNo) {
        this.sanitaryCertNo = sanitaryCertNo;
    }

    public String getProductOriginal() {
        return productOriginal;
    }

    public void setProductOriginal(String productOriginal) {
        this.productOriginal = productOriginal;
    }

    public String getProductGarantee() {
        return productGarantee;
    }

    public void setProductGarantee(String productGarantee) {
        this.productGarantee = productGarantee;
    }

    public String getProductCompany() {
        return productCompany;
    }

    public void setProductCompany(String productCompany) {
        this.productCompany = productCompany;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getProductFactory() {
        return productFactory;
    }

    public void setProductFactory(String productFactory) {
        this.productFactory = productFactory;
    }

    public String getFactoryAddress() {
        return factoryAddress;
    }

    public void setFactoryAddress(String factoryAddress) {
        this.factoryAddress = factoryAddress;
    }

    public String getFactoryPhone() {
        return factoryPhone;
    }

    public void setFactoryPhone(String factoryPhone) {
        this.factoryPhone = factoryPhone;
    }

    public String getProductAgent() {
        return productAgent;
    }

    public void setProductAgent(String productAgent) {
        this.productAgent = productAgent;
    }

    public String getAgentAddress() {
        return agentAddress;
    }

    public void setAgentAddress(String agentAddress) {
        this.agentAddress = agentAddress;
    }

    public String getAgentPhone() {
        return agentPhone;
    }

    public void setAgentPhone(String agentPhone) {
        this.agentPhone = agentPhone;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getNetContent() {
        return netContent;
    }

    public void setNetContent(String netContent) {
        this.netContent = netContent;
    }

    public String getProductUsage() {
        return productUsage;
    }

    public void setProductUsage(String productUsage) {
        this.productUsage = productUsage;
    }
}