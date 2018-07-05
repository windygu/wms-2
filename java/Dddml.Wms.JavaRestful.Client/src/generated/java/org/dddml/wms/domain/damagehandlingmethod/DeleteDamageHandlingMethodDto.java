package org.dddml.wms.domain.damagehandlingmethod;


public class DeleteDamageHandlingMethodDto extends AbstractDamageHandlingMethodCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

