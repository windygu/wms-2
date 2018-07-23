package org.dddml.wms.domain.sellableinventoryitem;

import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryprtriggered.*;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchSellableInventoryItemDto extends AbstractSellableInventoryItemCommandDto
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

    private CreateOrMergePatchSellableInventoryItemEntryDto[] entries;

    public CreateOrMergePatchSellableInventoryItemEntryDto[] getEntries()
    {
        return this.entries;
    }

    public void setEntries(CreateOrMergePatchSellableInventoryItemEntryDto[] entries)
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

    public static class CreateSellableInventoryItemDto extends CreateOrMergePatchSellableInventoryItemDto
    {
        public CreateSellableInventoryItemDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static class MergePatchSellableInventoryItemDto extends CreateOrMergePatchSellableInventoryItemDto
    {
        public MergePatchSellableInventoryItemDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

    }

}

