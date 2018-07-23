package org.dddml.wms.domain.inventoryprtriggered;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchInventoryPRTriggeredDto extends AbstractInventoryPRTriggeredCommandDto
{
    /**
     * Is Processed
     */
    private Boolean isProcessed;

    public Boolean getIsProcessed()
    {
        return this.isProcessed;
    }

    public void setIsProcessed(Boolean isProcessed)
    {
        this.isProcessed = isProcessed;
    }

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

    private Boolean isPropertyIsProcessedRemoved;

    public Boolean getIsPropertyIsProcessedRemoved()
    {
        return this.isPropertyIsProcessedRemoved;
    }

    public void setIsPropertyIsProcessedRemoved(Boolean removed)
    {
        this.isPropertyIsProcessedRemoved = removed;
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

    public static class CreateInventoryPRTriggeredDto extends CreateOrMergePatchInventoryPRTriggeredDto
    {
        public CreateInventoryPRTriggeredDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static class MergePatchInventoryPRTriggeredDto extends CreateOrMergePatchInventoryPRTriggeredDto
    {
        public MergePatchInventoryPRTriggeredDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

    }

}

