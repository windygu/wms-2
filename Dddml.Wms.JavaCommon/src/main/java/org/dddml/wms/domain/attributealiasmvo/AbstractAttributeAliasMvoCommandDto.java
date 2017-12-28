package org.dddml.wms.domain.attributealiasmvo;

import org.dddml.wms.domain.attribute.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractAttributeAliasMvoCommandDto extends AbstractCommand
{
    private AttributeAliasIdDto attributeAliasId;

    public AttributeAliasIdDto getAttributeAliasId()
    {
        return this.attributeAliasId;
    }

    public void setAttributeAliasId(AttributeAliasIdDto attributeAliasId)
    {
        this.attributeAliasId = attributeAliasId;
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


    public void copyTo(AbstractAttributeAliasMvoCommand command)
    {
        command.setAttributeAliasId((this.getAttributeAliasId() == null) ? null : this.getAttributeAliasId().toAttributeAliasId());
        command.setAttributeVersion(this.getAttributeVersion());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
