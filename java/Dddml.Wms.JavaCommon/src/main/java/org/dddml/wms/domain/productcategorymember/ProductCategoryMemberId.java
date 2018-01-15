package org.dddml.wms.domain.productcategorymember;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class ProductCategoryMemberId implements Serializable
{
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

    public ProductCategoryMemberId()
    {
    }

    public ProductCategoryMemberId(String productCategoryId, String productId)
    {
        this.productCategoryId = productCategoryId;
        this.productId = productId;
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

        ProductCategoryMemberId other = (ProductCategoryMemberId)obj;
        return true 
            && (productCategoryId == other.productCategoryId || (productCategoryId != null && productCategoryId.equals(other.productCategoryId)))
            && (productId == other.productId || (productId != null && productId.equals(other.productId)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.productCategoryId != null) {
            hash += 13 * this.productCategoryId.hashCode();
        }
        if (this.productId != null) {
            hash += 13 * this.productId.hashCode();
        }
        return hash;
    }

}

