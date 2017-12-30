package org.dddml.wms.domain.uomtype;


public class DeleteUomTypeDto extends AbstractUomTypeCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public UomTypeCommand.DeleteUomType toDeleteUomType()
    {
        AbstractUomTypeCommand.SimpleDeleteUomType command = new AbstractUomTypeCommand.SimpleDeleteUomType();
        ((AbstractUomTypeCommandDto)this).copyTo(command);
        return command;
    }
}

