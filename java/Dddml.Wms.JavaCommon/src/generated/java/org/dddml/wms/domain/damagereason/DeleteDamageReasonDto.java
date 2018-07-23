package org.dddml.wms.domain.damagereason;


public class DeleteDamageReasonDto extends AbstractDamageReasonCommandDto
{

    public DeleteDamageReasonDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public DamageReasonCommand.DeleteDamageReason toDeleteDamageReason()
    {
        AbstractDamageReasonCommand.SimpleDeleteDamageReason command = new AbstractDamageReasonCommand.SimpleDeleteDamageReason();
        ((AbstractDamageReasonCommandDto)this).copyTo(command);
        return command;
    }
}

