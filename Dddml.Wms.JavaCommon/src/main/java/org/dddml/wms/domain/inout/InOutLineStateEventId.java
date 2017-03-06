package org.dddml.wms.domain.inout;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class InOutLineStateEventId implements Serializable
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

    private Long inOutVersion;

    public Long getInOutVersion()
    {
        return this.inOutVersion;
    }

    public void setInOutVersion(Long inOutVersion)
    {
        this.inOutVersion = inOutVersion;
    }

    public InOutLineStateEventId()
    {
    }

    public InOutLineStateEventId(String inOutDocumentNumber, Long lineNumber, Long inOutVersion)
    {
        this.inOutDocumentNumber = inOutDocumentNumber;
        this.lineNumber = lineNumber;
        this.inOutVersion = inOutVersion;
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

        InOutLineStateEventId other = (InOutLineStateEventId)obj;
        return true 
            && (inOutDocumentNumber == other.inOutDocumentNumber || (inOutDocumentNumber != null && inOutDocumentNumber.equals(other.inOutDocumentNumber)))
            && (lineNumber == other.lineNumber || (lineNumber != null && lineNumber.equals(other.lineNumber)))
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
        if (this.lineNumber != null) {
            hash += 13 * this.lineNumber.hashCode();
        }
        if (this.inOutVersion != null) {
            hash += 13 * this.inOutVersion.hashCode();
        }
        return hash;
    }

}

