package org.dddml.wms.domain.productcategory;

import org.dddml.wms.domain.*;

public class ProductCategoryStateEventIdDto
{

    public ProductCategoryStateEventIdDto()
    {
    }

    public ProductCategoryStateEventId toProductCategoryStateEventId()
    {
        ProductCategoryStateEventId v = new ProductCategoryStateEventId();
        v.setProductCategoryId(this.getProductCategoryId());
        v.setVersion(this.getVersion());
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
        if (obj == null || obj.getClass() != ProductCategoryStateEventIdDto.class) {
            return false;
        }

        ProductCategoryStateEventIdDto other = (ProductCategoryStateEventIdDto)obj;
        return true 
            && (getProductCategoryId() == other.getProductCategoryId() || (getProductCategoryId() != null && getProductCategoryId().equals(other.getProductCategoryId())))
            && (getVersion() == other.getVersion() || (getVersion() != null && getVersion().equals(other.getVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getProductCategoryId() != null) {
            hash += 13 * this.getProductCategoryId().hashCode();
        }
        if (this.getVersion() != null) {
            hash += 13 * this.getVersion().hashCode();
        }
        return hash;
    }

}

