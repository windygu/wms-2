package org.dddml.wms.domain.damagetype;


public class DeleteDamageTypeDto extends AbstractDamageTypeCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public DamageTypeCommand.DeleteDamageType toDeleteDamageType()
    {
        AbstractDamageTypeCommand.SimpleDeleteDamageType command = new AbstractDamageTypeCommand.SimpleDeleteDamageType();
        ((AbstractDamageTypeCommandDto)this).copyTo(command);
        return command;
    }
}

