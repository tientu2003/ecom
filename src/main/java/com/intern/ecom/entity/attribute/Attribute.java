package com.intern.ecom.entity.attribute;

import jakarta.persistence.*;


import java.sql.Timestamp;


@Entity
@Table(name = "attribute")
public class Attribute {
    @Id
    @Column(name = "uuid_attribute", nullable = false, length = 40)
    private String uuidAttribute;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "uuid_attribute", nullable = false, referencedColumnName = "uuid_attribute")
    private ProductAttribute productAttribute;

    @Column(name = "`key`", length = 40)
    private String key;

    @Column(name = "created_date")
    private Timestamp createdDate;

    @Column(name = "updated_date")
    private Timestamp updatedDate;

    public String getUuidAttribute() {
        return uuidAttribute;
    }

    public void setUuidAttribute(String uuidAttribute) {
        this.uuidAttribute = uuidAttribute;
    }

    public ProductAttribute getProductAttribute() {
        return productAttribute;
    }

    public void setProductAttribute(ProductAttribute productAttribute) {
        this.productAttribute = productAttribute;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }

}