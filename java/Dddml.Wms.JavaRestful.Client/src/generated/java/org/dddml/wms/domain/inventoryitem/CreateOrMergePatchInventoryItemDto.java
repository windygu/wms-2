package org.dddml.wms.domain.inventoryitem;

import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchInventoryItemDto extends AbstractInventoryItemCommandDto
{
    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }

    private CreateOrMergePatchInventoryItemEntryDto[] entries;

    public CreateOrMergePatchInventoryItemEntryDto[] getEntries()
    {
        return this.entries;
    }

    public void setEntries(CreateOrMergePatchInventoryItemEntryDto[] entries)
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

    public static class CreateInventoryItemDto extends CreateOrMergePatchInventoryItemDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static class MergePatchInventoryItemDto extends CreateOrMergePatchInventoryItemDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

    }

}

