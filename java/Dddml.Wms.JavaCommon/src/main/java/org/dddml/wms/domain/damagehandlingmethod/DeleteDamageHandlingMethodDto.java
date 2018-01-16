package org.dddml.wms.domain.damagehandlingmethod;


public class DeleteDamageHandlingMethodDto extends AbstractDamageHandlingMethodCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public DamageHandlingMethodCommand.DeleteDamageHandlingMethod toDeleteDamageHandlingMethod()
    {
        AbstractDamageHandlingMethodCommand.SimpleDeleteDamageHandlingMethod command = new AbstractDamageHandlingMethodCommand.SimpleDeleteDamageHandlingMethod();
        ((AbstractDamageHandlingMethodCommandDto)this).copyTo(command);
        return command;
    }
}

