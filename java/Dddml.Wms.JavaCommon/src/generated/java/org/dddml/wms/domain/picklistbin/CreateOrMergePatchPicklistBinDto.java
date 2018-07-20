package org.dddml.wms.domain.picklistbin;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchPicklistBinDto extends AbstractPicklistBinCommandDto
{
    /**
     * Picklist Id
     */
    private String picklistId;

    public String getPicklistId()
    {
        return this.picklistId;
    }

    public void setPicklistId(String picklistId)
    {
        this.picklistId = picklistId;
    }

    /**
     * Bin Location Number
     */
    private Long binLocationNumber;

    public Long getBinLocationNumber()
    {
        return this.binLocationNumber;
    }

    public void setBinLocationNumber(Long binLocationNumber)
    {
        this.binLocationNumber = binLocationNumber;
    }

    /**
     * Primary Order Id
     */
    private String primaryOrderId;

    public String getPrimaryOrderId()
    {
        return this.primaryOrderId;
    }

    public void setPrimaryOrderId(String primaryOrderId)
    {
        this.primaryOrderId = primaryOrderId;
    }

    /**
     * Primary Ship Group Seq Id
     */
    private Long primaryShipGroupSeqId;

    public Long getPrimaryShipGroupSeqId()
    {
        return this.primaryShipGroupSeqId;
    }

    public void setPrimaryShipGroupSeqId(Long primaryShipGroupSeqId)
    {
        this.primaryShipGroupSeqId = primaryShipGroupSeqId;
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

    private CreateOrMergePatchPicklistItemDto[] picklistItems;

    public CreateOrMergePatchPicklistItemDto[] getPicklistItems()
    {
        return this.picklistItems;
    }

    public void setPicklistItems(CreateOrMergePatchPicklistItemDto[] picklistItems)
    {
        this.picklistItems = picklistItems;
    }

    private Boolean isPropertyPicklistIdRemoved;

    public Boolean getIsPropertyPicklistIdRemoved()
    {
        return this.isPropertyPicklistIdRemoved;
    }

    public void setIsPropertyPicklistIdRemoved(Boolean removed)
    {
        this.isPropertyPicklistIdRemoved = removed;
    }

    private Boolean isPropertyBinLocationNumberRemoved;

    public Boolean getIsPropertyBinLocationNumberRemoved()
    {
        return this.isPropertyBinLocationNumberRemoved;
    }

    public void setIsPropertyBinLocationNumberRemoved(Boolean removed)
    {
        this.isPropertyBinLocationNumberRemoved = removed;
    }

    private Boolean isPropertyPrimaryOrderIdRemoved;

    public Boolean getIsPropertyPrimaryOrderIdRemoved()
    {
        return this.isPropertyPrimaryOrderIdRemoved;
    }

    public void setIsPropertyPrimaryOrderIdRemoved(Boolean removed)
    {
        this.isPropertyPrimaryOrderIdRemoved = removed;
    }

    private Boolean isPropertyPrimaryShipGroupSeqIdRemoved;

    public Boolean getIsPropertyPrimaryShipGroupSeqIdRemoved()
    {
        return this.isPropertyPrimaryShipGroupSeqIdRemoved;
    }

    public void setIsPropertyPrimaryShipGroupSeqIdRemoved(Boolean removed)
    {
        this.isPropertyPrimaryShipGroupSeqIdRemoved = removed;
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

    public void copyTo(AbstractPicklistBinCommand.AbstractCreateOrMergePatchPicklistBin command)
    {
        ((AbstractPicklistBinCommandDto) this).copyTo(command);
        command.setPicklistId(this.getPicklistId());
        command.setBinLocationNumber(this.getBinLocationNumber());
        command.setPrimaryOrderId(this.getPrimaryOrderId());
        command.setPrimaryShipGroupSeqId(this.getPrimaryShipGroupSeqId());
        command.setActive(this.getActive());
    }

    public PicklistBinCommand toCommand()
    {
        if (getCommandType() == null) {
            setCommandType(COMMAND_TYPE_MERGE_PATCH);
        }
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractPicklistBinCommand.SimpleCreatePicklistBin command = new AbstractPicklistBinCommand.SimpleCreatePicklistBin();
            copyTo((AbstractPicklistBinCommand.AbstractCreatePicklistBin) command);
            if (this.getPicklistItems() != null) {
                for (CreateOrMergePatchPicklistItemDto cmd : this.getPicklistItems()) {
                    command.getPicklistItems().add((PicklistItemCommand.CreatePicklistItem) cmd.toCommand());
                }
            }
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractPicklistBinCommand.SimpleMergePatchPicklistBin command = new AbstractPicklistBinCommand.SimpleMergePatchPicklistBin();
            copyTo((AbstractPicklistBinCommand.SimpleMergePatchPicklistBin) command);
            if (this.getPicklistItems() != null) {
                for (CreateOrMergePatchPicklistItemDto cmd : this.getPicklistItems()) {
                    command.getPicklistItemCommands().add(cmd.toCommand());
                }
            }
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractPicklistBinCommand.AbstractCreatePicklistBin command)
    {
        copyTo((AbstractPicklistBinCommand.AbstractCreateOrMergePatchPicklistBin) command);
    }

    public void copyTo(AbstractPicklistBinCommand.AbstractMergePatchPicklistBin command)
    {
        copyTo((AbstractPicklistBinCommand.AbstractCreateOrMergePatchPicklistBin) command);
        command.setIsPropertyPicklistIdRemoved(this.getIsPropertyPicklistIdRemoved());
        command.setIsPropertyBinLocationNumberRemoved(this.getIsPropertyBinLocationNumberRemoved());
        command.setIsPropertyPrimaryOrderIdRemoved(this.getIsPropertyPrimaryOrderIdRemoved());
        command.setIsPropertyPrimaryShipGroupSeqIdRemoved(this.getIsPropertyPrimaryShipGroupSeqIdRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreatePicklistBinDto extends CreateOrMergePatchPicklistBinDto
    {
        public CreatePicklistBinDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public PicklistBinCommand.CreatePicklistBin toCreatePicklistBin()
        {
            return (PicklistBinCommand.CreatePicklistBin) toCommand();
        }

    }

    public static class MergePatchPicklistBinDto extends CreateOrMergePatchPicklistBinDto
    {
        public MergePatchPicklistBinDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public PicklistBinCommand.MergePatchPicklistBin toMergePatchPicklistBin()
        {
            return (PicklistBinCommand.MergePatchPicklistBin) toCommand();
        }

    }

}

