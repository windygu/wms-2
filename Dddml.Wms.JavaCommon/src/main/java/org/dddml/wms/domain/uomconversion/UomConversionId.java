package org.dddml.wms.domain.uomconversion;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class UomConversionId implements Serializable
{
    private String uomId;

    public String getUomId()
    {
        return this.uomId;
    }

    public void setUomId(String uomId)
    {
        this.uomId = uomId;
    }

    private String uomIdTo;

    public String getUomIdTo()
    {
        return this.uomIdTo;
    }

    public void setUomIdTo(String uomIdTo)
    {
        this.uomIdTo = uomIdTo;
    }

    public UomConversionId()
    {
    }

    public UomConversionId(String uomId, String uomIdTo)
    {
        this.uomId = uomId;
        this.uomIdTo = uomIdTo;
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

        UomConversionId other = (UomConversionId)obj;
        return true 
            && (uomId == other.uomId || (uomId != null && uomId.equals(other.uomId)))
            && (uomIdTo == other.uomIdTo || (uomIdTo != null && uomIdTo.equals(other.uomIdTo)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.uomId != null) {
            hash += 13 * this.uomId.hashCode();
        }
        if (this.uomIdTo != null) {
            hash += 13 * this.uomIdTo.hashCode();
        }
        return hash;
    }

}

