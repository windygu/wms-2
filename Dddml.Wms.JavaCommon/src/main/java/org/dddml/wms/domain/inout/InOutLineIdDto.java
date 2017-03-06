package org.dddml.wms.domain.inout;

import org.dddml.wms.domain.*;

public class InOutLineIdDto
{

    public InOutLineIdDto()
    {
    }

    public InOutLineId toInOutLineId()
    {
        InOutLineId v = new InOutLineId();
        v.setInOutDocumentNumber(this.getInOutDocumentNumber());
        v.setLineNumber(this.getLineNumber());
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

    private Long lineNumber;

    public Long getLineNumber()
    {
        return this.lineNumber;
    }

    public void setLineNumber(Long lineNumber)
    {
        this.lineNumber = lineNumber;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != InOutLineIdDto.class) {
            return false;
        }

        InOutLineIdDto other = (InOutLineIdDto)obj;
        return true 
            && (getInOutDocumentNumber() == other.getInOutDocumentNumber() || (getInOutDocumentNumber() != null && getInOutDocumentNumber().equals(other.getInOutDocumentNumber())))
            && (getLineNumber() == other.getLineNumber() || (getLineNumber() != null && getLineNumber().equals(other.getLineNumber())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getInOutDocumentNumber() != null) {
            hash += 13 * this.getInOutDocumentNumber().hashCode();
        }
        if (this.getLineNumber() != null) {
            hash += 13 * this.getLineNumber().hashCode();
        }
        return hash;
    }

}

