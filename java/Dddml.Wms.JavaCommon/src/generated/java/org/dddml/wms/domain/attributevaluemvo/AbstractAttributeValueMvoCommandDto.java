package org.dddml.wms.domain.attributevaluemvo;

import org.dddml.wms.domain.attribute.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractAttributeValueMvoCommandDto extends AbstractCommand
{
    /**
     * Attribute Value Id
     */
    private AttributeValueId attributeValueId;

    public AttributeValueId getAttributeValueId()
    {
        return this.attributeValueId;
    }

    public void setAttributeValueId(AttributeValueId attributeValueId)
    {
        this.attributeValueId = attributeValueId;
    }

    /**
     * Attribute Version
     */
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
        command.setAttributeValueId(this.getAttributeValueId());
        command.setAttributeVersion(this.getAttributeVersion());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
