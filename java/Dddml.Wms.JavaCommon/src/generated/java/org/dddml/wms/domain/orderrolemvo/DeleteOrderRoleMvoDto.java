package org.dddml.wms.domain.orderrolemvo;


public class DeleteOrderRoleMvoDto extends AbstractOrderRoleMvoCommandDto
{

    public DeleteOrderRoleMvoDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public OrderRoleMvoCommand.DeleteOrderRoleMvo toDeleteOrderRoleMvo()
    {
        AbstractOrderRoleMvoCommand.SimpleDeleteOrderRoleMvo command = new AbstractOrderRoleMvoCommand.SimpleDeleteOrderRoleMvo();
        ((AbstractOrderRoleMvoCommandDto)this).copyTo(command);
        return command;
    }
}

