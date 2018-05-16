package org.dddml.wms.domain.orderitemshipgroupassociationmvo;


public class DeleteOrderItemShipGroupAssociationMvoDto extends AbstractOrderItemShipGroupAssociationMvoCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

