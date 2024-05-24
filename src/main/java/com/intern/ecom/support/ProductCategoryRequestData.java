package com.intern.ecom.support;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ProductCategoryRequestData {
    @NotBlank
    @Size(max = 40)
    String uuidProduct;
    @NotBlank
    @Size(max = 40)
    String uuidCategory;

    public @NotBlank @Size(max = 40) String getUuidProduct() {
        return uuidProduct;
    }

    public ProductCategoryRequestData setUuidProduct(@NotBlank @Size(max = 40) String uuidProduct) {
        this.uuidProduct = uuidProduct;
        return this;
    }

    public @NotBlank @Size(max = 40) String getUuidCategory() {
        return uuidCategory;
    }

    public ProductCategoryRequestData setUuidCategory(@NotBlank @Size(max = 40) String uuidCategory) {
        this.uuidCategory = uuidCategory;
        return this;
    }
}
