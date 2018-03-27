package org.dddml.wms.domain.facility;


public class DeleteFacilityDto extends AbstractFacilityCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

    public FacilityCommand.DeleteFacility toDeleteFacility()
    {
        AbstractFacilityCommand.SimpleDeleteFacility command = new AbstractFacilityCommand.SimpleDeleteFacility();
        ((AbstractFacilityCommandDto)this).copyTo(command);
        return command;
    }
}

