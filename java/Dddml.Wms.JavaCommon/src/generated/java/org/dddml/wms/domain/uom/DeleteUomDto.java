package org.dddml.wms.domain.uom;


public class DeleteUomDto extends AbstractUomCommandDto
{

    public DeleteUomDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public UomCommand.DeleteUom toDeleteUom()
    {
        AbstractUomCommand.SimpleDeleteUom command = new AbstractUomCommand.SimpleDeleteUom();
        ((AbstractUomCommandDto)this).copyTo(command);
        return command;
    }
}

