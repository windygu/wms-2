package org.dddml.wms.domain.productcategorymember;

import org.dddml.wms.domain.*;

public class ProductCategoryMemberIdDto
{

    public ProductCategoryMemberIdDto()
    {
    }

    public ProductCategoryMemberId toProductCategoryMemberId()
    {
        ProductCategoryMemberId v = new ProductCategoryMemberId();
        v.setProductCategoryId(this.getProductCategoryId());
        v.setProductId(this.getProductId());
        return v;
    }

    private String productCategoryId;

    public String getProductCategoryId()
    {
        return this.productCategoryId;
    }

    public void setProductCategoryId(String productCategoryId)
    {
        this.productCategoryId = productCategoryId;
    }

    private String productId;

    public String getProductId()
    {
        return this.productId;
    }

    public void setProductId(String productId)
    {
        this.productId = productId;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != ProductCategoryMemberIdDto.class) {
            return false;
        }

        ProductCategoryMemberIdDto other = (ProductCategoryMemberIdDto)obj;
        return true 
            && (getProductCategoryId() == other.getProductCategoryId() || (getProductCategoryId() != null && getProductCategoryId().equals(other.getProductCategoryId())))
            && (getProductId() == other.getProductId() || (getProductId() != null && getProductId().equals(other.getProductId())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getProductCategoryId() != null) {
            hash += 13 * this.getProductCategoryId().hashCode();
        }
        if (this.getProductId() != null) {
            hash += 13 * this.getProductId().hashCode();
        }
        return hash;
    }

}

