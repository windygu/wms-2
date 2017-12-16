package org.dddml.wms.domain.productcategory;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class ProductCategoryStateEventId implements Serializable
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

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }

    public ProductCategoryStateEventId()
    {
    }

    public ProductCategoryStateEventId(String productCategoryId, Long version)
    {
        this.productCategoryId = productCategoryId;
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

        ProductCategoryStateEventId other = (ProductCategoryStateEventId)obj;
        return true 
            && (productCategoryId == other.productCategoryId || (productCategoryId != null && productCategoryId.equals(other.productCategoryId)))
            && (version == other.version || (version != null && version.equals(other.version)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.productCategoryId != null) {
            hash += 13 * this.productCategoryId.hashCode();
        }
        if (this.version != null) {
            hash += 13 * this.version.hashCode();
        }
        return hash;
    }

}

