package org.dddml.wms.domain.organizationstructure;


public class DeleteOrganizationStructureDto extends AbstractOrganizationStructureCommandDto
{

    public DeleteOrganizationStructureDto() {
        this.commandType = COMMAND_TYPE_DELETE;
    }

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

