package org.dddml.wms.domain.productcategorymember;

import org.dddml.wms.domain.*;

public class ProductCategoryMemberStateEventIdDto
{

    public ProductCategoryMemberStateEventIdDto()
    {
    }

    public ProductCategoryMemberStateEventId toProductCategoryMemberStateEventId()
    {
        ProductCategoryMemberStateEventId v = new ProductCategoryMemberStateEventId();
        v.setProductCategoryMemberId(this.getProductCategoryMemberId().toProductCategoryMemberId());
        v.setVersion(this.getVersion());
        return v;
    }

    private ProductCategoryMemberIdDto productCategoryMemberId = new ProductCategoryMemberIdDto();

    public ProductCategoryMemberIdDto getProductCategoryMemberId()
    {
        return this.productCategoryMemberId;
    }

    public void setProductCategoryMemberId(ProductCategoryMemberIdDto productCategoryMemberId)
    {
        this.productCategoryMemberId = productCategoryMemberId;
    }

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != ProductCategoryMemberStateEventIdDto.class) {
            return false;
        }

        ProductCategoryMemberStateEventIdDto other = (ProductCategoryMemberStateEventIdDto)obj;
        return true 
            && (getProductCategoryMemberId() == other.getProductCategoryMemberId() || (getProductCategoryMemberId() != null && getProductCategoryMemberId().equals(other.getProductCategoryMemberId())))
            && (getVersion() == other.getVersion() || (getVersion() != null && getVersion().equals(other.getVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getProductCategoryMemberId() != null) {
            hash += 13 * this.getProductCategoryMemberId().hashCode();
        }
        if (this.getVersion() != null) {
            hash += 13 * this.getVersion().hashCode();
        }
        return hash;
    }

}

