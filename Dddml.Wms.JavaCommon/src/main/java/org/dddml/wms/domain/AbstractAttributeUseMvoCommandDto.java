package org.dddml.wms.domain;

import java.util.Date;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractAttributeUseMvoCommandDto extends AbstractCommand
{
    private AttributeSetAttributeUseIdDto attributeSetAttributeUseId;

    public AttributeSetAttributeUseIdDto getAttributeSetAttributeUseId()
    {
        return this.attributeSetAttributeUseId;
    }

    public void setAttributeSetAttributeUseId(AttributeSetAttributeUseIdDto attributeSetAttributeUseId)
    {
        this.attributeSetAttributeUseId = attributeSetAttributeUseId;
    }

    private Long attributeSetVersion;

    public Long getAttributeSetVersion()
    {
        return this.attributeSetVersion;
    }

    public void setAttributeSetVersion(Long attributeSetVersion)
    {
        this.attributeSetVersion = attributeSetVersion;
    }


    public void copyTo(AbstractAttributeUseMvoCommand command)
    {
        command.setAttributeSetAttributeUseId((this.getAttributeSetAttributeUseId() == null) ? null : this.getAttributeSetAttributeUseId().toAttributeSetAttributeUseId());
        command.setAttributeSetVersion(this.getAttributeSetVersion());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
