package org.dddml.wms.domain.ordershipgroupmvo;


public class DeleteOrderShipGroupMvoDto extends AbstractOrderShipGroupMvoCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

