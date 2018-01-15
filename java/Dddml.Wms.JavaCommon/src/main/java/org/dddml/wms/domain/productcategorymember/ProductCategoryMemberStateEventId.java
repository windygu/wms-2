package org.dddml.wms.domain.productcategorymember;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class ProductCategoryMemberStateEventId implements Serializable
{
    private ProductCategoryMemberId productCategoryMemberId = new ProductCategoryMemberId();

    public ProductCategoryMemberId getProductCategoryMemberId()
    {
        return this.productCategoryMemberId;
    }

    public void setProductCategoryMemberId(ProductCategoryMemberId productCategoryMemberId)
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

    public String getProductCategoryMemberIdProductCategoryId()
    {
        return getProductCategoryMemberId().getProductCategoryId();
    }

    public void setProductCategoryMemberIdProductCategoryId(String productCategoryMemberIdProductCategoryId)
    {
        getProductCategoryMemberId().setProductCategoryId(productCategoryMemberIdProductCategoryId);
    }

    public String getProductCategoryMemberIdProductId()
    {
        return getProductCategoryMemberId().getProductId();
    }

    public void setProductCategoryMemberIdProductId(String productCategoryMemberIdProductId)
    {
        getProductCategoryMemberId().setProductId(productCategoryMemberIdProductId);
    }

    public ProductCategoryMemberStateEventId()
    {
    }

    public ProductCategoryMemberStateEventId(ProductCategoryMemberId productCategoryMemberId, Long version)
    {
        this.productCategoryMemberId = productCategoryMemberId;
        this.version = version;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        ProductCategoryMemberStateEventId other = (ProductCategoryMemberStateEventId)obj;
        return true 
            && (productCategoryMemberId == other.productCategoryMemberId || (productCategoryMemberId != null && productCategoryMemberId.equals(other.productCategoryMemberId)))
            && (version == other.version || (version != null && version.equals(other.version)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.productCategoryMemberId != null) {
            hash += 13 * this.productCategoryMemberId.hashCode();
        }
        if (this.version != null) {
            hash += 13 * this.version.hashCode();
        }
        return hash;
    }

}

