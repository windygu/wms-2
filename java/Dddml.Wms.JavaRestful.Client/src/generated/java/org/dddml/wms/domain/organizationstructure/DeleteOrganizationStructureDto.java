package org.dddml.wms.domain.organizationstructure;


public class DeleteOrganizationStructureDto extends AbstractOrganizationStructureCommandDto
{

    @Override
    public String getCommandType() {
        return COMMAND_TYPE_DELETE;
    }

}

