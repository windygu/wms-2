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
            && (getInOutDocumentNumber() == other.getInOutDocumentNumber() || (getInOutDocumentNumber() != null && getInOutDocumentNumber().equals(other.getInOutDocumentNumber())))
            && (getSkuId() == other.getSkuId() || (getSkuId() != null && getSkuId().equals(other.getSkuId())))
            && (getInOutVersion() == other.getInOutVersion() || (getInOutVersion() != null && getInOutVersion().equals(other.getInOutVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getInOutDocumentNumber() != null) {
            hash += 13 * this.getInOutDocumentNumber().hashCode();
        }
        if (this.getSkuId() != null) {
            hash += 13 * this.getSkuId().hashCode();
        }
        if (this.getInOutVersion() != null) {
            hash += 13 * this.getInOutVersion().hashCode();
        }
        return hash;
    }

}

