package com.vaizn.data.busi.dal.entity;

import javax.persistence.*;

@Table(name = "t_nutrient_composition")
public class NutrientComposition {
    @Id
    @Column(name = "nutrient_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nutrientId;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "nutrient_name")
    private String nutrientName;

    @Column(name = "nutrient_unit")
    private String nutrientUnit;

    @Column(name = "reference_value")
    private String referenceValue;

    @Column(name = "reference_unit")
    private String referenceUnit;

    /**
     * @return nutrient_id
     */
    public String getNutrientId() {
        return nutrientId;
    }

    /**
     * @param nutrientId
     */
    public void setNutrientId(String nutrientId) {
        this.nutrientId = nutrientId;
    }

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
     * @return nutrient_name
     */
    public String getNutrientName() {
        return nutrientName;
    }

    /**
     * @param nutrientName
     */
    public void setNutrientName(String nutrientName) {
        this.nutrientName = nutrientName;
    }

    /**
     * @return nutrient_unit
     */
    public String getNutrientUnit() {
        return nutrientUnit;
    }

    /**
     * @param nutrientUnit
     */
    public void setNutrientUnit(String nutrientUnit) {
        this.nutrientUnit = nutrientUnit;
    }

    /**
     * @return reference_value
     */
    public String getReferenceValue() {
        return referenceValue;
    }

    /**
     * @param referenceValue
     */
    public void setReferenceValue(String referenceValue) {
        this.referenceValue = referenceValue;
    }

    /**
     * @return reference_unit
     */
    public String getReferenceUnit() {
        return referenceUnit;
    }

    /**
     * @param referenceUnit
     */
    public void setReferenceUnit(String referenceUnit) {
        this.referenceUnit = referenceUnit;
    }
}