package org.dddml.wms.domain.orderrolemvo;


public class DeleteOrderRoleMvoDto extends AbstractOrderRoleMvoCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

