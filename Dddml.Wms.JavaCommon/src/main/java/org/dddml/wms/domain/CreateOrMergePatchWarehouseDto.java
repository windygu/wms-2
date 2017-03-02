package org.dddml.wms.domain;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchWarehouseDto extends AbstractWarehouseCommandDto
{
    private String name;

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    private String description;

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    private Boolean isInTransit;

    public Boolean getIsInTransit()
    {
        return this.isInTransit;
    }

    public void setIsInTransit(Boolean isInTransit)
    {
        this.isInTransit = isInTransit;
    }

    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }

    private Boolean isPropertyNameRemoved;

    public Boolean getIsPropertyNameRemoved()
    {
        return this.isPropertyNameRemoved;
    }

    public void setIsPropertyNameRemoved(Boolean removed)
    {
        this.isPropertyNameRemoved = removed;
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
        command.setName(this.getName());
        command.setDescription(this.getDescription());
        command.setIsInTransit(this.getIsInTransit());
        command.setActive(this.getActive());
    }

    public WarehouseCommand toCommand()
    {
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
        command.setIsPropertyNameRemoved(this.getIsPropertyNameRemoved());
        command.setIsPropertyDescriptionRemoved(this.getIsPropertyDescriptionRemoved());
        command.setIsPropertyIsInTransitRemoved(this.getIsPropertyIsInTransitRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateWarehouseDto extends CreateOrMergePatchWarehouseDto
    {
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

