package org.dddml.wms.domain.contactmech;


public class DeleteContactMechDto extends AbstractContactMechCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

