package org.dddml.wms.domain.productcategorymember;

import org.dddml.wms.domain.*;

public class ProductCategoryMemberIdDtoWrapper extends ProductCategoryMemberIdDto
{
	
    private ProductCategoryMemberId value;

    public ProductCategoryMemberIdDtoWrapper()
    {
        this(new ProductCategoryMemberId());
    }

    public ProductCategoryMemberIdDtoWrapper(ProductCategoryMemberId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public ProductCategoryMemberId toProductCategoryMemberId()
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
    public String getProductId()
    {
        return this.value.getProductId();
    }

    @Override
    public void setProductId(String productId)
    {
        this.value.setProductId(productId);
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
        if (obj.getClass() == ProductCategoryMemberIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        ProductCategoryMemberIdDtoWrapper other = (ProductCategoryMemberIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

