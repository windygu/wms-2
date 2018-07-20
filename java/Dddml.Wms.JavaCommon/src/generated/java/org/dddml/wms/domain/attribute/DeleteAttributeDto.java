package org.dddml.wms.domain.attribute;


public class DeleteAttributeDto extends AbstractAttributeCommandDto
{

    public DeleteAttributeDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public AttributeCommand.DeleteAttribute toDeleteAttribute()
    {
        AbstractAttributeCommand.SimpleDeleteAttribute command = new AbstractAttributeCommand.SimpleDeleteAttribute();
        ((AbstractAttributeCommandDto)this).copyTo(command);
        return command;
    }
}

