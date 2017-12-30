package org.dddml.wms.domain.uomconversion;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractUomConversionCommandDto extends AbstractCommand
{
    private UomConversionIdDto uomConversionId;

    public UomConversionIdDto getUomConversionId()
    {
        return this.uomConversionId;
    }

    public void setUomConversionId(UomConversionIdDto uomConversionId)
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


    public void copyTo(AbstractUomConversionCommand command)
    {
        command.setUomConversionId((this.getUomConversionId() == null) ? null : this.getUomConversionId().toUomConversionId());
        command.setVersion(this.getVersion());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
