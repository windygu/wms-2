package org.dddml.wms.domain.attributeusemvo;

import org.dddml.wms.domain.attributeset.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractAttributeUseMvoCommandDto extends AbstractCommand
{
    /**
     * Attribute Set Attribute Use Id
     */
    private AttributeSetAttributeUseId attributeSetAttributeUseId;

    public AttributeSetAttributeUseId getAttributeSetAttributeUseId()
    {
        return this.attributeSetAttributeUseId;
    }

    public void setAttributeSetAttributeUseId(AttributeSetAttributeUseId attributeSetAttributeUseId)
    {
        this.attributeSetAttributeUseId = attributeSetAttributeUseId;
    }

    /**
     * Attribute Set Version
     */
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
        command.setAttributeSetAttributeUseId(this.getAttributeSetAttributeUseId());
        command.setAttributeSetVersion(this.getAttributeSetVersion());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
