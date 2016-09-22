package org.dddml.wms.domain;


public class InOutStateEventIdDto
{

    public InOutStateEventIdDto()
    {
    }

    public InOutStateEventId toInOutStateEventId()
    {
        InOutStateEventId v = new InOutStateEventId();
        v.setDocumentNumber(this.getDocumentNumber());
        v.setVersion(this.getVersion());
        return v;
    }

    private String documentNumber;

    public String getDocumentNumber()
    {
        return this.documentNumber;
    }

    public void setDocumentNumber(String documentNumber)
    {
        this.documentNumber = documentNumber;
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
        if (obj == null || obj.getClass() != InOutStateEventIdDto.class) {
            return false;
        }

        InOutStateEventIdDto other = (InOutStateEventIdDto)obj;
        return true 
            && (documentNumber == other.documentNumber || (documentNumber != null && documentNumber.equals(other.documentNumber)))
            && (version == other.version || (version != null && version.equals(other.version)))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.documentNumber != null) {
            hash += 13 * this.documentNumber.hashCode();
        }
        if (this.version != null) {
            hash += 13 * this.version.hashCode();
        }
        return hash;
    }

}

