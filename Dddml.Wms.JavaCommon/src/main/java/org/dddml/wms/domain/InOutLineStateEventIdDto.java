package org.dddml.wms.domain;


public class InOutLineStateEventIdDto
{

    public InOutLineStateEventIdDto()
    {
    }

    public InOutLineStateEventId toInOutLineStateEventId()
    {
        InOutLineStateEventId v = new InOutLineStateEventId();
        v.setInOutDocumentNumber(this.getInOutDocumentNumber());
        v.setSkuId(this.getSkuId().toSkuId());
        v.setInOutVersion(this.getInOutVersion());
        return v;
    }

    private String inOutDocumentNumber;

    public String getInOutDocumentNumber()
    {
        return this.inOutDocumentNumber;
    }

    public void setInOutDocumentNumber(String inOutDocumentNumber)
    {
        this.inOutDocumentNumber = inOutDocumentNumber;
    }

    private SkuIdDto skuId = new SkuIdDto();

    public SkuIdDto getSkuId()
    {
        return this.skuId;
    }

    public void setSkuId(SkuIdDto skuId)
    {
        this.skuId = skuId;
    }

    private Long inOutVersion;

    public Long getInOutVersion()
    {
        return this.inOutVersion;
    }

    public void setInOutVersion(Long inOutVersion)
    {
        this.inOutVersion = inOutVersion;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != InOutLineStateEventIdDto.class) {
            return false;
        }

        InOutLineStateEventIdDto other = (InOutLineStateEventIdDto)obj;
        return true 
            && (inOutDocumentNumber == other.inOutDocumentNumber || (inOutDocumentNumber != null && inOutDocumentNumber.equals(other.inOutDocumentNumber)))
            && (skuId == other.skuId || (skuId != null && skuId.equals(other.skuId)))
            && (inOutVersion == other.inOutVersion || (inOutVersion != null && inOutVersion.equals(other.inOutVersion)))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.inOutDocumentNumber != null) {
            hash += 13 * this.inOutDocumentNumber.hashCode();
        }
        if (this.skuId != null) {
            hash += 13 * this.skuId.hashCode();
        }
        if (this.inOutVersion != null) {
            hash += 13 * this.inOutVersion.hashCode();
        }
        return hash;
    }

}

