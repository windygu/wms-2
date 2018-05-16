package org.dddml.wms.domain.damagereason;


public class DeleteDamageReasonDto extends AbstractDamageReasonCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

