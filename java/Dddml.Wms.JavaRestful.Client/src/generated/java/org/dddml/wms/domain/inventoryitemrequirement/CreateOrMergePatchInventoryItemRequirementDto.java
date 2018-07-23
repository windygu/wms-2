package org.dddml.wms.domain.inventoryitemrequirement;

import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryprtriggered.*;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchInventoryItemRequirementDto extends AbstractInventoryItemRequirementCommandDto
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

    private CreateOrMergePatchInventoryItemRequirementEntryDto[] entries;

    public CreateOrMergePatchInventoryItemRequirementEntryDto[] getEntries()
    {
        return this.entries;
    }

    public void setEntries(CreateOrMergePatchInventoryItemRequirementEntryDto[] entries)
    {
        this.entries = entries;
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

    public static class CreateInventoryItemRequirementDto extends CreateOrMergePatchInventoryItemRequirementDto
    {
        public CreateInventoryItemRequirementDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static class MergePatchInventoryItemRequirementDto extends CreateOrMergePatchInventoryItemRequirementDto
    {
        public MergePatchInventoryItemRequirementDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

    }

}

