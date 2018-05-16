package org.dddml.wms.domain.orderitemmvo;


public class DeleteOrderItemMvoDto extends AbstractOrderItemMvoCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

