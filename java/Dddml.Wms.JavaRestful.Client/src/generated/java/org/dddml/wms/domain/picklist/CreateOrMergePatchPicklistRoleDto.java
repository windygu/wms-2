package org.dddml.wms.domain.picklist;

import org.dddml.wms.domain.partyrole.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchPicklistRoleDto extends AbstractPicklistRoleCommandDto
{
    /**
     * Active
     */
    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved()
    {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed)
    {
        this.isPropertyActiveRemoved = removed;
    }

    public static class CreatePicklistRoleDto extends CreateOrMergePatchPicklistRoleDto
    {
        public CreatePicklistRoleDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static class MergePatchPicklistRoleDto extends CreateOrMergePatchPicklistRoleDto
    {
        public MergePatchPicklistRoleDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

    }

}

