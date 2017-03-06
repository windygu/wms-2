package org.dddml.wms.domain.attributesetinstanceextensionfieldmvo;

import org.dddml.wms.domain.attributesetinstanceextensionfieldgroup.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractAttributeSetInstanceExtensionFieldMvoCommandDto extends AbstractCommand
{
    private AttributeSetInstanceExtensionFieldIdDto attributeSetInstanceExtensionFieldId;

    public AttributeSetInstanceExtensionFieldIdDto getAttributeSetInstanceExtensionFieldId()
    {
        return this.attributeSetInstanceExtensionFieldId;
    }

    public void setAttributeSetInstanceExtensionFieldId(AttributeSetInstanceExtensionFieldIdDto attributeSetInstanceExtensionFieldId)
    {
        this.attributeSetInstanceExtensionFieldId = attributeSetInstanceExtensionFieldId;
    }

    private Long attrSetInstEFGroupVersion;

    public Long getAttrSetInstEFGroupVersion()
    {
        return this.attrSetInstEFGroupVersion;
    }

    public void setAttrSetInstEFGroupVersion(Long attrSetInstEFGroupVersion)
    {
        this.attrSetInstEFGroupVersion = attrSetInstEFGroupVersion;
    }


    public void copyTo(AbstractAttributeSetInstanceExtensionFieldMvoCommand command)
    {
        command.setAttributeSetInstanceExtensionFieldId((this.getAttributeSetInstanceExtensionFieldId() == null) ? null : this.getAttributeSetInstanceExtensionFieldId().toAttributeSetInstanceExtensionFieldId());
        command.setAttrSetInstEFGroupVersion(this.getAttrSetInstEFGroupVersion());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
