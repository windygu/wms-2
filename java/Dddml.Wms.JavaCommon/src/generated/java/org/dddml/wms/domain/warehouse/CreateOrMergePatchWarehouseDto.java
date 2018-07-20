package org.dddml.wms.domain.warehouse;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchWarehouseDto extends AbstractWarehouseCommandDto
{
    /**
     * Warehouse Name
     */
    private String warehouseName;

    public String getWarehouseName()
    {
        return this.warehouseName;
    }

    public void setWarehouseName(String warehouseName)
    {
        this.warehouseName = warehouseName;
    }

    /**
     * Description
     */
    private String description;

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * Is In Transit
     */
    private Boolean isInTransit;

    public Boolean getIsInTransit()
    {
        return this.isInTransit;
    }

    public void setIsInTransit(Boolean isInTransit)
    {
        this.isInTransit = isInTransit;
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

    private Boolean isPropertyWarehouseNameRemoved;

    public Boolean getIsPropertyWarehouseNameRemoved()
    {
        return this.isPropertyWarehouseNameRemoved;
    }

    public void setIsPropertyWarehouseNameRemoved(Boolean removed)
    {
        this.isPropertyWarehouseNameRemoved = removed;
    }

    private Boolean isPropertyDescriptionRemoved;

    public Boolean getIsPropertyDescriptionRemoved()
    {
        return this.isPropertyDescriptionRemoved;
    }

    public void setIsPropertyDescriptionRemoved(Boolean removed)
    {
        this.isPropertyDescriptionRemoved = removed;
    }

    private Boolean isPropertyIsInTransitRemoved;

    public Boolean getIsPropertyIsInTransitRemoved()
    {
        return this.isPropertyIsInTransitRemoved;
    }

    public void setIsPropertyIsInTransitRemoved(Boolean removed)
    {
        this.isPropertyIsInTransitRemoved = removed;
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

    public void copyTo(AbstractWarehouseCommand.AbstractCreateOrMergePatchWarehouse command)
    {
        ((AbstractWarehouseCommandDto) this).copyTo(command);
        command.setWarehouseName(this.getWarehouseName());
        command.setDescription(this.getDescription());
        command.setIsInTransit(this.getIsInTransit());
        command.setActive(this.getActive());
    }

    public WarehouseCommand toCommand()
    {
        if (getCommandType() == null) {
            setCommandType(COMMAND_TYPE_MERGE_PATCH);
        }
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractWarehouseCommand.SimpleCreateWarehouse command = new AbstractWarehouseCommand.SimpleCreateWarehouse();
            copyTo((AbstractWarehouseCommand.AbstractCreateWarehouse) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractWarehouseCommand.SimpleMergePatchWarehouse command = new AbstractWarehouseCommand.SimpleMergePatchWarehouse();
            copyTo((AbstractWarehouseCommand.SimpleMergePatchWarehouse) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractWarehouseCommand.AbstractCreateWarehouse command)
    {
        copyTo((AbstractWarehouseCommand.AbstractCreateOrMergePatchWarehouse) command);
    }

    public void copyTo(AbstractWarehouseCommand.AbstractMergePatchWarehouse command)
    {
        copyTo((AbstractWarehouseCommand.AbstractCreateOrMergePatchWarehouse) command);
        command.setIsPropertyWarehouseNameRemoved(this.getIsPropertyWarehouseNameRemoved());
        command.setIsPropertyDescriptionRemoved(this.getIsPropertyDescriptionRemoved());
        command.setIsPropertyIsInTransitRemoved(this.getIsPropertyIsInTransitRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateWarehouseDto extends CreateOrMergePatchWarehouseDto
    {
        public CreateWarehouseDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public WarehouseCommand.CreateWarehouse toCreateWarehouse()
        {
            return (WarehouseCommand.CreateWarehouse) toCommand();
        }

    }

    public static class MergePatchWarehouseDto extends CreateOrMergePatchWarehouseDto
    {
        public MergePatchWarehouseDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public WarehouseCommand.MergePatchWarehouse toMergePatchWarehouse()
        {
            return (WarehouseCommand.MergePatchWarehouse) toCommand();
        }

    }

}

