package org.dddml.wms.domain.productcategory;

import org.dddml.wms.domain.*;

public class ProductCategoryStateEventIdDtoWrapper extends ProductCategoryStateEventIdDto
{
	
    private ProductCategoryStateEventId value;

    public ProductCategoryStateEventIdDtoWrapper()
    {
        this(new ProductCategoryStateEventId());
    }

    public ProductCategoryStateEventIdDtoWrapper(ProductCategoryStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public ProductCategoryStateEventId toProductCategoryStateEventId()
    {
        return this.value;
    }

    @Override
    public String getProductCategoryId()
    {
        return this.value.getProductCategoryId();
    }

    @Override
    public void setProductCategoryId(String productCategoryId)
    {
        this.value.setProductCategoryId(productCategoryId);
    }

    @Override
    public Long getVersion()
    {
        return this.value.getVersion();
    }

    @Override
    public void setVersion(Long version)
    {
        this.value.setVersion(version);
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == ProductCategoryStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        ProductCategoryStateEventIdDtoWrapper other = (ProductCategoryStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

