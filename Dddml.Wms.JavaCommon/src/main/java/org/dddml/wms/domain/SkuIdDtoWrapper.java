package org.dddml.wms.domain;


public class SkuIdDtoWrapper extends SkuIdDto
{
	
    private SkuId value;

    public SkuIdDtoWrapper()
    {
        this(new SkuId());
    }

    public SkuIdDtoWrapper(SkuId value)
    {
        this.value = value;
    }

    public SkuId toSkuId()
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
    public String getAttributeSetInstanceId()
    {
        return this.value.getAttributeSetInstanceId();
    }

    @Override
    public void setAttributeSetInstanceId(String attributeSetInstanceId)
    {
        this.value.setAttributeSetInstanceId(attributeSetInstanceId);
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
        if (obj.getClass() == SkuIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        SkuIdDtoWrapper other = (SkuIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

