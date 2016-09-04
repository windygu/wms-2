package org.dddml.wms.domain;

import java.util.Date;

public class CreateOrMergePatchLocatorDto extends AbstractLocatorCommandDto
{
    private String warehouseId;

    public String getWarehouseId()
    {
        return this.warehouseId;
    }

    public void setWarehouseId(String warehouseId)
    {
        this.warehouseId = warehouseId;
    }

    private String parentLocatorId;

    public String getParentLocatorId()
    {
        return this.parentLocatorId;
    }

    public void setParentLocatorId(String parentLocatorId)
    {
        this.parentLocatorId = parentLocatorId;
    }

    private String locatorType;

    public String getLocatorType()
    {
        return this.locatorType;
    }

    public void setLocatorType(String locatorType)
    {
        this.locatorType = locatorType;
    }

    private String priorityNumber;

    public String getPriorityNumber()
    {
        return this.priorityNumber;
    }

    public void setPriorityNumber(String priorityNumber)
    {
        this.priorityNumber = priorityNumber;
    }

    private Boolean isDefault;

    public Boolean getIsDefault()
    {
        return this.isDefault;
    }

    public void setIsDefault(Boolean isDefault)
    {
        this.isDefault = isDefault;
    }

    private String x;

    public String getX()
    {
        return this.x;
    }

    public void setX(String x)
    {
        this.x = x;
    }

    private String y;

    public String getY()
    {
        return this.y;
    }

    public void setY(String y)
    {
        this.y = y;
    }

    private String z;

    public String getZ()
    {
        return this.z;
    }

    public void setZ(String z)
    {
        this.z = z;
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

    private Boolean isPropertyWarehouseIdRemoved;

    public Boolean getIsPropertyWarehouseIdRemoved()
    {
        return this.isPropertyWarehouseIdRemoved;
    }

    public void setIsPropertyWarehouseIdRemoved(Boolean removed)
    {
        this.isPropertyWarehouseIdRemoved = removed;
    }

    private Boolean isPropertyParentLocatorIdRemoved;

    public Boolean getIsPropertyParentLocatorIdRemoved()
    {
        return this.isPropertyParentLocatorIdRemoved;
    }

    public void setIsPropertyParentLocatorIdRemoved(Boolean removed)
    {
        this.isPropertyParentLocatorIdRemoved = removed;
    }

    private Boolean isPropertyLocatorTypeRemoved;

    public Boolean getIsPropertyLocatorTypeRemoved()
    {
        return this.isPropertyLocatorTypeRemoved;
    }

    public void setIsPropertyLocatorTypeRemoved(Boolean removed)
    {
        this.isPropertyLocatorTypeRemoved = removed;
    }

    private Boolean isPropertyPriorityNumberRemoved;

    public Boolean getIsPropertyPriorityNumberRemoved()
    {
        return this.isPropertyPriorityNumberRemoved;
    }

    public void setIsPropertyPriorityNumberRemoved(Boolean removed)
    {
        this.isPropertyPriorityNumberRemoved = removed;
    }

    private Boolean isPropertyIsDefaultRemoved;

    public Boolean getIsPropertyIsDefaultRemoved()
    {
        return this.isPropertyIsDefaultRemoved;
    }

    public void setIsPropertyIsDefaultRemoved(Boolean removed)
    {
        this.isPropertyIsDefaultRemoved = removed;
    }

    private Boolean isPropertyXRemoved;

    public Boolean getIsPropertyXRemoved()
    {
        return this.isPropertyXRemoved;
    }

    public void setIsPropertyXRemoved(Boolean removed)
    {
        this.isPropertyXRemoved = removed;
    }

    private Boolean isPropertyYRemoved;

    public Boolean getIsPropertyYRemoved()
    {
        return this.isPropertyYRemoved;
    }

    public void setIsPropertyYRemoved(Boolean removed)
    {
        this.isPropertyYRemoved = removed;
    }

    private Boolean isPropertyZRemoved;

    public Boolean getIsPropertyZRemoved()
    {
        return this.isPropertyZRemoved;
    }

    public void setIsPropertyZRemoved(Boolean removed)
    {
        this.isPropertyZRemoved = removed;
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


    public void copyTo(AbstractLocatorCommand.AbstractCreateOrMergePatchLocator command)
    {
        ((AbstractLocatorCommandDto) this).copyTo(command);
        command.setWarehouseId(this.getWarehouseId());
        command.setParentLocatorId(this.getParentLocatorId());
        command.setLocatorType(this.getLocatorType());
        command.setPriorityNumber(this.getPriorityNumber());
        command.setIsDefault(this.getIsDefault());
        command.setX(this.getX());
        command.setY(this.getY());
        command.setZ(this.getZ());
        command.setActive(this.getActive());
    }

    public LocatorCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractLocatorCommand.SimpleCreateLocator command = new AbstractLocatorCommand.SimpleCreateLocator();
            copyTo((AbstractLocatorCommand.AbstractCreateLocator) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractLocatorCommand.SimpleMergePatchLocator command = new AbstractLocatorCommand.SimpleMergePatchLocator();
            copyTo((AbstractLocatorCommand.SimpleMergePatchLocator) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractLocatorCommand.AbstractCreateLocator command)
    {
        copyTo((AbstractLocatorCommand.AbstractCreateOrMergePatchLocator) command);
    }

    public void copyTo(AbstractLocatorCommand.AbstractMergePatchLocator command)
    {
        copyTo((AbstractLocatorCommand.AbstractCreateOrMergePatchLocator) command);
        command.setIsPropertyWarehouseIdRemoved(this.getIsPropertyWarehouseIdRemoved());
        command.setIsPropertyParentLocatorIdRemoved(this.getIsPropertyParentLocatorIdRemoved());
        command.setIsPropertyLocatorTypeRemoved(this.getIsPropertyLocatorTypeRemoved());
        command.setIsPropertyPriorityNumberRemoved(this.getIsPropertyPriorityNumberRemoved());
        command.setIsPropertyIsDefaultRemoved(this.getIsPropertyIsDefaultRemoved());
        command.setIsPropertyXRemoved(this.getIsPropertyXRemoved());
        command.setIsPropertyYRemoved(this.getIsPropertyYRemoved());
        command.setIsPropertyZRemoved(this.getIsPropertyZRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateLocatorDto extends CreateOrMergePatchLocatorDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

        public LocatorCommand.CreateLocator toCreateLocator()
        {
            return (LocatorCommand.CreateLocator) toCommand();
        }

    }

    public static class MergePatchLocatorDto extends CreateOrMergePatchLocatorDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

        public LocatorCommand.MergePatchLocator toMergePatchLocator()
        {
            return (LocatorCommand.MergePatchLocator) toCommand();
        }

    }

}

