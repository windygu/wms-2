package org.dddml.wms.domain.warehouse;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchWarehouseDto extends AbstractWarehouseCommandDto
{
    private String warehouseName;

    public String getWarehouseName()
    {
        return this.warehouseName;
    }

    public void setWarehouseName(String warehouseName)
    {
        this.warehouseName = warehouseName;
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

    public static class CreateWarehouseDto extends CreateOrMergePatchWarehouseDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static class MergePatchWarehouseDto extends CreateOrMergePatchWarehouseDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

    }

}

