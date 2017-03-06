package org.dddml.wms.domain.inout;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class InOutLineId implements Serializable
{
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

    public InOutLineId()
    {
    }

    public InOutLineId(String inOutDocumentNumber, Long lineNumber)
    {
        this.inOutDocumentNumber = inOutDocumentNumber;
        this.lineNumber = lineNumber;
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

        InOutLineId other = (InOutLineId)obj;
        return true 
            && (inOutDocumentNumber == other.inOutDocumentNumber || (inOutDocumentNumber != null && inOutDocumentNumber.equals(other.inOutDocumentNumber)))
            && (lineNumber == other.lineNumber || (lineNumber != null && lineNumber.equals(other.lineNumber)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.inOutDocumentNumber != null) {
            hash += 13 * this.inOutDocumentNumber.hashCode();
        }
        if (this.lineNumber != null) {
            hash += 13 * this.lineNumber.hashCode();
        }
        return hash;
    }

}

