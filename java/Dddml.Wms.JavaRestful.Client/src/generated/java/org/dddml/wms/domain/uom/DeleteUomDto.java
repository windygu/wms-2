package org.dddml.wms.domain.uom;


public class DeleteUomDto extends AbstractUomCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

