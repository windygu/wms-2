package org.dddml.wms.domain.productcategorymember;

import org.dddml.wms.domain.*;

public class ProductCategoryMemberStateEventIdDtoWrapper extends ProductCategoryMemberStateEventIdDto
{
	
    private ProductCategoryMemberStateEventId value;

    public ProductCategoryMemberStateEventIdDtoWrapper()
    {
        this(new ProductCategoryMemberStateEventId());
    }

    public ProductCategoryMemberStateEventIdDtoWrapper(ProductCategoryMemberStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public ProductCategoryMemberStateEventId toProductCategoryMemberStateEventId()
    {
        return this.value;
    }

    @Override
    public ProductCategoryMemberIdDto getProductCategoryMemberId()
    {
        return new ProductCategoryMemberIdDtoWrapper(this.value.getProductCategoryMemberId());
    }

    @Override
    public void setProductCategoryMemberId(ProductCategoryMemberIdDto productCategoryMemberId)
    {
        this.value.setProductCategoryMemberId(productCategoryMemberId.toProductCategoryMemberId());
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
        if (obj.getClass() == ProductCategoryMemberStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        ProductCategoryMemberStateEventIdDtoWrapper other = (ProductCategoryMemberStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

