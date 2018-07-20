package org.dddml.wms.domain.contactmech;


public class DeleteContactMechDto extends AbstractContactMechCommandDto
{

    public DeleteContactMechDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public ContactMechCommand.DeleteContactMech toDeleteContactMech()
    {
        AbstractContactMechCommand.SimpleDeleteContactMech command = new AbstractContactMechCommand.SimpleDeleteContactMech();
        ((AbstractContactMechCommandDto)this).copyTo(command);
        return command;
    }
}

