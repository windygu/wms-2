package org.dddml.wms.domain.attributealiasmvo;

import org.dddml.wms.domain.attribute.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractAttributeAliasMvoCommandDto extends AbstractCommand
{
    /**
     * Attribute Alias Id
     */
    private AttributeAliasId attributeAliasId;

    public AttributeAliasId getAttributeAliasId()
    {
        return this.attributeAliasId;
    }

    public void setAttributeAliasId(AttributeAliasId attributeAliasId)
    {
        this.attributeAliasId = attributeAliasId;
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


    public void copyTo(AbstractAttributeAliasMvoCommand command)
    {
        command.setAttributeAliasId(this.getAttributeAliasId());
        command.setAttributeVersion(this.getAttributeVersion());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
