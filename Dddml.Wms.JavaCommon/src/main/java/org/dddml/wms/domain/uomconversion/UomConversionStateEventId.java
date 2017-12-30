package org.dddml.wms.domain.uomconversion;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class UomConversionStateEventId implements Serializable
{
    private UomConversionId uomConversionId = new UomConversionId();

    public UomConversionId getUomConversionId()
    {
        return this.uomConversionId;
    }

    public void setUomConversionId(UomConversionId uomConversionId)
    {
        this.uomConversionId = uomConversionId;
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

    public String getUomConversionIdUomId()
    {
        return getUomConversionId().getUomId();
    }

    public void setUomConversionIdUomId(String uomConversionIdUomId)
    {
        getUomConversionId().setUomId(uomConversionIdUomId);
    }

    public String getUomConversionIdUomIdTo()
    {
        return getUomConversionId().getUomIdTo();
    }

    public void setUomConversionIdUomIdTo(String uomConversionIdUomIdTo)
    {
        getUomConversionId().setUomIdTo(uomConversionIdUomIdTo);
    }

    public UomConversionStateEventId()
    {
    }

    public UomConversionStateEventId(UomConversionId uomConversionId, Long version)
    {
        this.uomConversionId = uomConversionId;
        this.version = version;
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

        UomConversionStateEventId other = (UomConversionStateEventId)obj;
        return true 
            && (uomConversionId == other.uomConversionId || (uomConversionId != null && uomConversionId.equals(other.uomConversionId)))
            && (version == other.version || (version != null && version.equals(other.version)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.uomConversionId != null) {
            hash += 13 * this.uomConversionId.hashCode();
        }
        if (this.version != null) {
            hash += 13 * this.version.hashCode();
        }
        return hash;
    }

}

