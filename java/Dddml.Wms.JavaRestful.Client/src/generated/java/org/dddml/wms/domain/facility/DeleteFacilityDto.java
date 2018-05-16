package org.dddml.wms.domain.facility;


public class DeleteFacilityDto extends AbstractFacilityCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

