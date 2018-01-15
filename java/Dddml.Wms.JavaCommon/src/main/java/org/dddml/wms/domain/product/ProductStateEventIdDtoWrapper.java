package org.dddml.wms.domain.product;

import org.dddml.wms.domain.*;

public class ProductStateEventIdDtoWrapper extends ProductStateEventIdDto
{
	
    private ProductStateEventId value;

    public ProductStateEventIdDtoWrapper()
    {
        this(new ProductStateEventId());
    }

    public ProductStateEventIdDtoWrapper(ProductStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public ProductStateEventId toProductStateEventId()
    {
        return this.value;
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
        if (obj.getClass() == ProductStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        ProductStateEventIdDtoWrapper other = (ProductStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

