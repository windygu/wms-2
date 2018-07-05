package org.dddml.wms.domain.picklist;

import java.util.Date;
import org.dddml.wms.domain.partyrole.*;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchPicklistDto extends AbstractPicklistCommandDto
{
    private String description;

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    private String facilityId;

    public String getFacilityId()
    {
        return this.facilityId;
    }

    public void setFacilityId(String facilityId)
    {
        this.facilityId = facilityId;
    }

    private String shipmentMethodTypeId;

    public String getShipmentMethodTypeId()
    {
        return this.shipmentMethodTypeId;
    }

    public void setShipmentMethodTypeId(String shipmentMethodTypeId)
    {
        this.shipmentMethodTypeId = shipmentMethodTypeId;
    }

    private String statusId;

    public String getStatusId()
    {
        return this.statusId;
    }

    public void setStatusId(String statusId)
    {
        this.statusId = statusId;
    }

    private java.sql.Timestamp picklistDate;

    public java.sql.Timestamp getPicklistDate()
    {
        return this.picklistDate;
    }

    public void setPicklistDate(java.sql.Timestamp picklistDate)
    {
        this.picklistDate = picklistDate;
    }

    private Long pickwaveId;

    public Long getPickwaveId()
    {
        return this.pickwaveId;
    }

    public void setPickwaveId(Long pickwaveId)
    {
        this.pickwaveId = pickwaveId;
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

    private CreateOrMergePatchPicklistRoleDto[] picklistRoles;

    public CreateOrMergePatchPicklistRoleDto[] getPicklistRoles()
    {
        return this.picklistRoles;
    }

    public void setPicklistRoles(CreateOrMergePatchPicklistRoleDto[] picklistRoles)
    {
        this.picklistRoles = picklistRoles;
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

    private Boolean isPropertyFacilityIdRemoved;

    public Boolean getIsPropertyFacilityIdRemoved()
    {
        return this.isPropertyFacilityIdRemoved;
    }

    public void setIsPropertyFacilityIdRemoved(Boolean removed)
    {
        this.isPropertyFacilityIdRemoved = removed;
    }

    private Boolean isPropertyShipmentMethodTypeIdRemoved;

    public Boolean getIsPropertyShipmentMethodTypeIdRemoved()
    {
        return this.isPropertyShipmentMethodTypeIdRemoved;
    }

    public void setIsPropertyShipmentMethodTypeIdRemoved(Boolean removed)
    {
        this.isPropertyShipmentMethodTypeIdRemoved = removed;
    }

    private Boolean isPropertyStatusIdRemoved;

    public Boolean getIsPropertyStatusIdRemoved()
    {
        return this.isPropertyStatusIdRemoved;
    }

    public void setIsPropertyStatusIdRemoved(Boolean removed)
    {
        this.isPropertyStatusIdRemoved = removed;
    }

    private Boolean isPropertyPicklistDateRemoved;

    public Boolean getIsPropertyPicklistDateRemoved()
    {
        return this.isPropertyPicklistDateRemoved;
    }

    public void setIsPropertyPicklistDateRemoved(Boolean removed)
    {
        this.isPropertyPicklistDateRemoved = removed;
    }

    private Boolean isPropertyPickwaveIdRemoved;

    public Boolean getIsPropertyPickwaveIdRemoved()
    {
        return this.isPropertyPickwaveIdRemoved;
    }

    public void setIsPropertyPickwaveIdRemoved(Boolean removed)
    {
        this.isPropertyPickwaveIdRemoved = removed;
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

    public static class CreatePicklistDto extends CreateOrMergePatchPicklistDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static class MergePatchPicklistDto extends CreateOrMergePatchPicklistDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

    }

}

