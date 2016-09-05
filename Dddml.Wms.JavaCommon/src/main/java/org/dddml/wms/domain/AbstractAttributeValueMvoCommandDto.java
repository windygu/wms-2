package org.dddml.wms.domain;

import java.util.Date;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractAttributeValueMvoCommandDto extends AbstractCommand
{
    private AttributeValueIdDto attributeValueId;

    public AttributeValueIdDto getAttributeValueId()
    {
        return this.attributeValueId;
    }

    public void setAttributeValueId(AttributeValueIdDto attributeValueId)
    {
        this.attributeValueId = attributeValueId;
    }

    private Long attributeVersion;

    public Long getAttributeVersion()
    {
        return this.attributeVersion;
    }

    public void setAttributeVersion(Long attributeVersion)
    {
        this.attributeVersion = attributeVersion;
    }


    public void copyTo(AbstractAttributeValueMvoCommand command)
    {
        command.setAttributeValueId((this.getAttributeValueId() == null) ? null : this.getAttributeValueId().toAttributeValueId());
        command.setAttributeVersion(this.getAttributeVersion());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}

