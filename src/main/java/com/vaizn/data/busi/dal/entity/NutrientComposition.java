package com.vaizn.data.busi.dal.entity;

import javax.persistence.*;

@Table(name = "t_nutrient_composition")
public class NutrientComposition {
    @Id
    @GeneratedValue(generator="UUID")
    private String nutrientId;

    private String productId;

    private String nutrientName;

    private String nutrientUnit;

    private String referenceValue;

    private String referenceUnit;

    public String getNutrientId() {
        return nutrientId;
    }

    public void setNutrientId(String nutrientId) {
        this.nutrientId = nutrientId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getNutrientName() {
        return nutrientName;
    }

    public void setNutrientName(String nutrientName) {
        this.nutrientName = nutrientName;
    }

    public String getNutrientUnit() {
        return nutrientUnit;
    }

    public void setNutrientUnit(String nutrientUnit) {
        this.nutrientUnit = nutrientUnit;
    }

    public String getReferenceValue() {
        return referenceValue;
    }

    public void setReferenceValue(String referenceValue) {
        this.referenceValue = referenceValue;
    }

    public String getReferenceUnit() {
        return referenceUnit;
    }

    public void setReferenceUnit(String referenceUnit) {
        this.referenceUnit = referenceUnit;
    }
}