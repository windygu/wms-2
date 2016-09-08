package org.dddml.wms.domain;


public class DeleteAttributeSetInstanceDto extends AbstractAttributeSetInstanceCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public AttributeSetInstanceCommand.DeleteAttributeSetInstance toDeleteAttributeSetInstance()
    {
        AbstractAttributeSetInstanceCommand.SimpleDeleteAttributeSetInstance command = new AbstractAttributeSetInstanceCommand.SimpleDeleteAttributeSetInstance();
        ((AbstractAttributeSetInstanceCommandDto)this).copyTo(command);
        return command;
    }

}

