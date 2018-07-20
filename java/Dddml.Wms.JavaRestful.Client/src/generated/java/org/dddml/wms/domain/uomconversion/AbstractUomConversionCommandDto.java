package org.dddml.wms.domain.uomconversion;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractUomConversionCommandDto extends AbstractCommand
{
    /**
     * Uom Conversion Id
     */
    private UomConversionId uomConversionId;

    public UomConversionId getUomConversionId()
    {
        return this.uomConversionId;
    }

    public void setUomConversionId(UomConversionId uomConversionId)
    {
        this.uomConversionId = uomConversionId;
    }

    /**
     * Version
     */
    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }


}
