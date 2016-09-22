package org.dddml.wms.domain;


public class SkuIdDto
{

    public SkuIdDto()
    {
    }

    public SkuId toSkuId()
    {
        SkuId v = new SkuId();
        v.setProductId(this.getProductId());
        v.setAttributeSetInstanceId(this.getAttributeSetInstanceId());
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

    private String attributeSetInstanceId;

    public String getAttributeSetInstanceId()
    {
        return this.attributeSetInstanceId;
    }

    public void setAttributeSetInstanceId(String attributeSetInstanceId)
    {
        this.attributeSetInstanceId = attributeSetInstanceId;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != SkuIdDto.class) {
            return false;
        }

        SkuIdDto other = (SkuIdDto)obj;
        return true 
            && (productId == other.productId || (productId != null && productId.equals(other.productId)))
            && (attributeSetInstanceId == other.attributeSetInstanceId || (attributeSetInstanceId != null && attributeSetInstanceId.equals(other.attributeSetInstanceId)))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.productId != null) {
            hash += 13 * this.productId.hashCode();
        }
        if (this.attributeSetInstanceId != null) {
            hash += 13 * this.attributeSetInstanceId.hashCode();
        }
        return hash;
    }

}

