package org.dddml.wms.domain.facility;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchFacilityDto extends AbstractFacilityCommandDto
{
    private String facilityTypeId;

    public String getFacilityTypeId()
    {
        return this.facilityTypeId;
    }

    public void setFacilityTypeId(String facilityTypeId)
    {
        this.facilityTypeId = facilityTypeId;
    }

    private String parentFacilityId;

    public String getParentFacilityId()
    {
        return this.parentFacilityId;
    }

    public void setParentFacilityId(String parentFacilityId)
    {
        this.parentFacilityId = parentFacilityId;
    }

    private String ownerPartyId;

    public String getOwnerPartyId()
    {
        return this.ownerPartyId;
    }

    public void setOwnerPartyId(String ownerPartyId)
    {
        this.ownerPartyId = ownerPartyId;
    }

    private String defaultInventoryItemTypeId;

    public String getDefaultInventoryItemTypeId()
    {
        return this.defaultInventoryItemTypeId;
    }

    public void setDefaultInventoryItemTypeId(String defaultInventoryItemTypeId)
    {
        this.defaultInventoryItemTypeId = defaultInventoryItemTypeId;
    }

    private String facilityName;

    public String getFacilityName()
    {
        return this.facilityName;
    }

    public void setFacilityName(String facilityName)
    {
        this.facilityName = facilityName;
    }

    private String primaryFacilityGroupId;

    public String getPrimaryFacilityGroupId()
    {
        return this.primaryFacilityGroupId;
    }

    public void setPrimaryFacilityGroupId(String primaryFacilityGroupId)
    {
        this.primaryFacilityGroupId = primaryFacilityGroupId;
    }

    private Long oldSquareFootage;

    public Long getOldSquareFootage()
    {
        return this.oldSquareFootage;
    }

    public void setOldSquareFootage(Long oldSquareFootage)
    {
        this.oldSquareFootage = oldSquareFootage;
    }

    private java.math.BigDecimal facilitySize;

    public java.math.BigDecimal getFacilitySize()
    {
        return this.facilitySize;
    }

    public void setFacilitySize(java.math.BigDecimal facilitySize)
    {
        this.facilitySize = facilitySize;
    }

    private String facilitySizeUomId;

    public String getFacilitySizeUomId()
    {
        return this.facilitySizeUomId;
    }

    public void setFacilitySizeUomId(String facilitySizeUomId)
    {
        this.facilitySizeUomId = facilitySizeUomId;
    }

    private String productStoreId;

    public String getProductStoreId()
    {
        return this.productStoreId;
    }

    public void setProductStoreId(String productStoreId)
    {
        this.productStoreId = productStoreId;
    }

    private Long defaultDaysToShip;

    public Long getDefaultDaysToShip()
    {
        return this.defaultDaysToShip;
    }

    public void setDefaultDaysToShip(Long defaultDaysToShip)
    {
        this.defaultDaysToShip = defaultDaysToShip;
    }

    private java.sql.Timestamp openedDate;

    public java.sql.Timestamp getOpenedDate()
    {
        return this.openedDate;
    }

    public void setOpenedDate(java.sql.Timestamp openedDate)
    {
        this.openedDate = openedDate;
    }

    private java.sql.Timestamp closedDate;

    public java.sql.Timestamp getClosedDate()
    {
        return this.closedDate;
    }

    public void setClosedDate(java.sql.Timestamp closedDate)
    {
        this.closedDate = closedDate;
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

    private String defaultDimensionUomId;

    public String getDefaultDimensionUomId()
    {
        return this.defaultDimensionUomId;
    }

    public void setDefaultDimensionUomId(String defaultDimensionUomId)
    {
        this.defaultDimensionUomId = defaultDimensionUomId;
    }

    private String defaultWeightUomId;

    public String getDefaultWeightUomId()
    {
        return this.defaultWeightUomId;
    }

    public void setDefaultWeightUomId(String defaultWeightUomId)
    {
        this.defaultWeightUomId = defaultWeightUomId;
    }

    private String geoPointId;

    public String getGeoPointId()
    {
        return this.geoPointId;
    }

    public void setGeoPointId(String geoPointId)
    {
        this.geoPointId = geoPointId;
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

    private Boolean isPropertyFacilityTypeIdRemoved;

    public Boolean getIsPropertyFacilityTypeIdRemoved()
    {
        return this.isPropertyFacilityTypeIdRemoved;
    }

    public void setIsPropertyFacilityTypeIdRemoved(Boolean removed)
    {
        this.isPropertyFacilityTypeIdRemoved = removed;
    }

    private Boolean isPropertyParentFacilityIdRemoved;

    public Boolean getIsPropertyParentFacilityIdRemoved()
    {
        return this.isPropertyParentFacilityIdRemoved;
    }

    public void setIsPropertyParentFacilityIdRemoved(Boolean removed)
    {
        this.isPropertyParentFacilityIdRemoved = removed;
    }

    private Boolean isPropertyOwnerPartyIdRemoved;

    public Boolean getIsPropertyOwnerPartyIdRemoved()
    {
        return this.isPropertyOwnerPartyIdRemoved;
    }

    public void setIsPropertyOwnerPartyIdRemoved(Boolean removed)
    {
        this.isPropertyOwnerPartyIdRemoved = removed;
    }

    private Boolean isPropertyDefaultInventoryItemTypeIdRemoved;

    public Boolean getIsPropertyDefaultInventoryItemTypeIdRemoved()
    {
        return this.isPropertyDefaultInventoryItemTypeIdRemoved;
    }

    public void setIsPropertyDefaultInventoryItemTypeIdRemoved(Boolean removed)
    {
        this.isPropertyDefaultInventoryItemTypeIdRemoved = removed;
    }

    private Boolean isPropertyFacilityNameRemoved;

    public Boolean getIsPropertyFacilityNameRemoved()
    {
        return this.isPropertyFacilityNameRemoved;
    }

    public void setIsPropertyFacilityNameRemoved(Boolean removed)
    {
        this.isPropertyFacilityNameRemoved = removed;
    }

    private Boolean isPropertyPrimaryFacilityGroupIdRemoved;

    public Boolean getIsPropertyPrimaryFacilityGroupIdRemoved()
    {
        return this.isPropertyPrimaryFacilityGroupIdRemoved;
    }

    public void setIsPropertyPrimaryFacilityGroupIdRemoved(Boolean removed)
    {
        this.isPropertyPrimaryFacilityGroupIdRemoved = removed;
    }

    private Boolean isPropertyOldSquareFootageRemoved;

    public Boolean getIsPropertyOldSquareFootageRemoved()
    {
        return this.isPropertyOldSquareFootageRemoved;
    }

    public void setIsPropertyOldSquareFootageRemoved(Boolean removed)
    {
        this.isPropertyOldSquareFootageRemoved = removed;
    }

    private Boolean isPropertyFacilitySizeRemoved;

    public Boolean getIsPropertyFacilitySizeRemoved()
    {
        return this.isPropertyFacilitySizeRemoved;
    }

    public void setIsPropertyFacilitySizeRemoved(Boolean removed)
    {
        this.isPropertyFacilitySizeRemoved = removed;
    }

    private Boolean isPropertyFacilitySizeUomIdRemoved;

    public Boolean getIsPropertyFacilitySizeUomIdRemoved()
    {
        return this.isPropertyFacilitySizeUomIdRemoved;
    }

    public void setIsPropertyFacilitySizeUomIdRemoved(Boolean removed)
    {
        this.isPropertyFacilitySizeUomIdRemoved = removed;
    }

    private Boolean isPropertyProductStoreIdRemoved;

    public Boolean getIsPropertyProductStoreIdRemoved()
    {
        return this.isPropertyProductStoreIdRemoved;
    }

    public void setIsPropertyProductStoreIdRemoved(Boolean removed)
    {
        this.isPropertyProductStoreIdRemoved = removed;
    }

    private Boolean isPropertyDefaultDaysToShipRemoved;

    public Boolean getIsPropertyDefaultDaysToShipRemoved()
    {
        return this.isPropertyDefaultDaysToShipRemoved;
    }

    public void setIsPropertyDefaultDaysToShipRemoved(Boolean removed)
    {
        this.isPropertyDefaultDaysToShipRemoved = removed;
    }

    private Boolean isPropertyOpenedDateRemoved;

    public Boolean getIsPropertyOpenedDateRemoved()
    {
        return this.isPropertyOpenedDateRemoved;
    }

    public void setIsPropertyOpenedDateRemoved(Boolean removed)
    {
        this.isPropertyOpenedDateRemoved = removed;
    }

    private Boolean isPropertyClosedDateRemoved;

    public Boolean getIsPropertyClosedDateRemoved()
    {
        return this.isPropertyClosedDateRemoved;
    }

    public void setIsPropertyClosedDateRemoved(Boolean removed)
    {
        this.isPropertyClosedDateRemoved = removed;
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

    private Boolean isPropertyDefaultDimensionUomIdRemoved;

    public Boolean getIsPropertyDefaultDimensionUomIdRemoved()
    {
        return this.isPropertyDefaultDimensionUomIdRemoved;
    }

    public void setIsPropertyDefaultDimensionUomIdRemoved(Boolean removed)
    {
        this.isPropertyDefaultDimensionUomIdRemoved = removed;
    }

    private Boolean isPropertyDefaultWeightUomIdRemoved;

    public Boolean getIsPropertyDefaultWeightUomIdRemoved()
    {
        return this.isPropertyDefaultWeightUomIdRemoved;
    }

    public void setIsPropertyDefaultWeightUomIdRemoved(Boolean removed)
    {
        this.isPropertyDefaultWeightUomIdRemoved = removed;
    }

    private Boolean isPropertyGeoPointIdRemoved;

    public Boolean getIsPropertyGeoPointIdRemoved()
    {
        return this.isPropertyGeoPointIdRemoved;
    }

    public void setIsPropertyGeoPointIdRemoved(Boolean removed)
    {
        this.isPropertyGeoPointIdRemoved = removed;
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

    public void copyTo(AbstractFacilityCommand.AbstractCreateOrMergePatchFacility command)
    {
        ((AbstractFacilityCommandDto) this).copyTo(command);
        command.setFacilityTypeId(this.getFacilityTypeId());
        command.setParentFacilityId(this.getParentFacilityId());
        command.setOwnerPartyId(this.getOwnerPartyId());
        command.setDefaultInventoryItemTypeId(this.getDefaultInventoryItemTypeId());
        command.setFacilityName(this.getFacilityName());
        command.setPrimaryFacilityGroupId(this.getPrimaryFacilityGroupId());
        command.setOldSquareFootage(this.getOldSquareFootage());
        command.setFacilitySize(this.getFacilitySize());
        command.setFacilitySizeUomId(this.getFacilitySizeUomId());
        command.setProductStoreId(this.getProductStoreId());
        command.setDefaultDaysToShip(this.getDefaultDaysToShip());
        command.setOpenedDate(this.getOpenedDate());
        command.setClosedDate(this.getClosedDate());
        command.setDescription(this.getDescription());
        command.setDefaultDimensionUomId(this.getDefaultDimensionUomId());
        command.setDefaultWeightUomId(this.getDefaultWeightUomId());
        command.setGeoPointId(this.getGeoPointId());
        command.setActive(this.getActive());
    }

    public FacilityCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractFacilityCommand.SimpleCreateFacility command = new AbstractFacilityCommand.SimpleCreateFacility();
            copyTo((AbstractFacilityCommand.AbstractCreateFacility) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractFacilityCommand.SimpleMergePatchFacility command = new AbstractFacilityCommand.SimpleMergePatchFacility();
            copyTo((AbstractFacilityCommand.SimpleMergePatchFacility) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractFacilityCommand.AbstractCreateFacility command)
    {
        copyTo((AbstractFacilityCommand.AbstractCreateOrMergePatchFacility) command);
    }

    public void copyTo(AbstractFacilityCommand.AbstractMergePatchFacility command)
    {
        copyTo((AbstractFacilityCommand.AbstractCreateOrMergePatchFacility) command);
        command.setIsPropertyFacilityTypeIdRemoved(this.getIsPropertyFacilityTypeIdRemoved());
        command.setIsPropertyParentFacilityIdRemoved(this.getIsPropertyParentFacilityIdRemoved());
        command.setIsPropertyOwnerPartyIdRemoved(this.getIsPropertyOwnerPartyIdRemoved());
        command.setIsPropertyDefaultInventoryItemTypeIdRemoved(this.getIsPropertyDefaultInventoryItemTypeIdRemoved());
        command.setIsPropertyFacilityNameRemoved(this.getIsPropertyFacilityNameRemoved());
        command.setIsPropertyPrimaryFacilityGroupIdRemoved(this.getIsPropertyPrimaryFacilityGroupIdRemoved());
        command.setIsPropertyOldSquareFootageRemoved(this.getIsPropertyOldSquareFootageRemoved());
        command.setIsPropertyFacilitySizeRemoved(this.getIsPropertyFacilitySizeRemoved());
        command.setIsPropertyFacilitySizeUomIdRemoved(this.getIsPropertyFacilitySizeUomIdRemoved());
        command.setIsPropertyProductStoreIdRemoved(this.getIsPropertyProductStoreIdRemoved());
        command.setIsPropertyDefaultDaysToShipRemoved(this.getIsPropertyDefaultDaysToShipRemoved());
        command.setIsPropertyOpenedDateRemoved(this.getIsPropertyOpenedDateRemoved());
        command.setIsPropertyClosedDateRemoved(this.getIsPropertyClosedDateRemoved());
        command.setIsPropertyDescriptionRemoved(this.getIsPropertyDescriptionRemoved());
        command.setIsPropertyDefaultDimensionUomIdRemoved(this.getIsPropertyDefaultDimensionUomIdRemoved());
        command.setIsPropertyDefaultWeightUomIdRemoved(this.getIsPropertyDefaultWeightUomIdRemoved());
        command.setIsPropertyGeoPointIdRemoved(this.getIsPropertyGeoPointIdRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateFacilityDto extends CreateOrMergePatchFacilityDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public FacilityCommand.CreateFacility toCreateFacility()
        {
            return (FacilityCommand.CreateFacility) toCommand();
        }

    }

    public static class MergePatchFacilityDto extends CreateOrMergePatchFacilityDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public FacilityCommand.MergePatchFacility toMergePatchFacility()
        {
            return (FacilityCommand.MergePatchFacility) toCommand();
        }

    }

}

