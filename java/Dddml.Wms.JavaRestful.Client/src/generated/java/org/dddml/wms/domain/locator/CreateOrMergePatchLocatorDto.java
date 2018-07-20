package org.dddml.wms.domain.locator;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchLocatorDto extends AbstractLocatorCommandDto
{
    /**
     * Warehouse Id
     */
    private String warehouseId;

    public String getWarehouseId()
    {
        return this.warehouseId;
    }

    public void setWarehouseId(String warehouseId)
    {
        this.warehouseId = warehouseId;
    }

    /**
     * Parent Locator Id
     */
    private String parentLocatorId;

    public String getParentLocatorId()
    {
        return this.parentLocatorId;
    }

    public void setParentLocatorId(String parentLocatorId)
    {
        this.parentLocatorId = parentLocatorId;
    }

    /**
     * Locator Type
     */
    private String locatorType;

    public String getLocatorType()
    {
        return this.locatorType;
    }

    public void setLocatorType(String locatorType)
    {
        this.locatorType = locatorType;
    }

    /**
     * Priority Number
     */
    private String priorityNumber;

    public String getPriorityNumber()
    {
        return this.priorityNumber;
    }

    public void setPriorityNumber(String priorityNumber)
    {
        this.priorityNumber = priorityNumber;
    }

    /**
     * Is Default
     */
    private Boolean isDefault;

    public Boolean getIsDefault()
    {
        return this.isDefault;
    }

    public void setIsDefault(Boolean isDefault)
    {
        this.isDefault = isDefault;
    }

    /**
     * X
     */
    private String x;

    public String getX()
    {
        return this.x;
    }

    public void setX(String x)
    {
        this.x = x;
    }

    /**
     * Y
     */
    private String y;

    public String getY()
    {
        return this.y;
    }

    public void setY(String y)
    {
        this.y = y;
    }

    /**
     * Z
     */
    private String z;

    public String getZ()
    {
        return this.z;
    }

    public void setZ(String z)
    {
        this.z = z;
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
     * Locator Type Id
     */
    private String locatorTypeId;

    public String getLocatorTypeId()
    {
        return this.locatorTypeId;
    }

    public void setLocatorTypeId(String locatorTypeId)
    {
        this.locatorTypeId = locatorTypeId;
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

    private Boolean isPropertyDescriptionRemoved;

    public Boolean getIsPropertyDescriptionRemoved()
    {
        return this.isPropertyDescriptionRemoved;
    }

    public void setIsPropertyDescriptionRemoved(Boolean removed)
    {
        this.isPropertyDescriptionRemoved = removed;
    }

    private Boolean isPropertyLocatorTypeIdRemoved;

    public Boolean getIsPropertyLocatorTypeIdRemoved()
    {
        return this.isPropertyLocatorTypeIdRemoved;
    }

    public void setIsPropertyLocatorTypeIdRemoved(Boolean removed)
    {
        this.isPropertyLocatorTypeIdRemoved = removed;
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

    public static class CreateLocatorDto extends CreateOrMergePatchLocatorDto
    {
        public CreateLocatorDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static class MergePatchLocatorDto extends CreateOrMergePatchLocatorDto
    {
        public MergePatchLocatorDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

    }

}

