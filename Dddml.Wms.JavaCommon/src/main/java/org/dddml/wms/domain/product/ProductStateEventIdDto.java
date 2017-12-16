package org.dddml.wms.domain.product;

import org.dddml.wms.domain.*;

public class ProductStateEventIdDto
{

    public ProductStateEventIdDto()
    {
    }

    public ProductStateEventId toProductStateEventId()
    {
        ProductStateEventId v = new ProductStateEventId();
        v.setProductId(this.getProductId());
        v.setVersion(this.getVersion());
        return v;
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
        if (obj == null || obj.getClass() != ProductStateEventIdDto.class) {
            return false;
        }

        ProductStateEventIdDto other = (ProductStateEventIdDto)obj;
        return true 
            && (getProductId() == other.getProductId() || (getProductId() != null && getProductId().equals(other.getProductId())))
            && (getVersion() == other.getVersion() || (getVersion() != null && getVersion().equals(other.getVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getProductId() != null) {
            hash += 13 * this.getProductId().hashCode();
        }
        if (this.getVersion() != null) {
            hash += 13 * this.getVersion().hashCode();
        }
        return hash;
    }

}

