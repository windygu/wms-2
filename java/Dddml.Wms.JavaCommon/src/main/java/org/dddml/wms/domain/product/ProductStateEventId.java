package org.dddml.wms.domain.product;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class ProductStateEventId implements Serializable
{
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

    public ProductStateEventId()
    {
    }

    public ProductStateEventId(String productId, Long version)
    {
        this.productId = productId;
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

        ProductStateEventId other = (ProductStateEventId)obj;
        return true 
            && (productId == other.productId || (productId != null && productId.equals(other.productId)))
            && (version == other.version || (version != null && version.equals(other.version)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.productId != null) {
            hash += 13 * this.productId.hashCode();
        }
        if (this.version != null) {
            hash += 13 * this.version.hashCode();
        }
        return hash;
    }

}

