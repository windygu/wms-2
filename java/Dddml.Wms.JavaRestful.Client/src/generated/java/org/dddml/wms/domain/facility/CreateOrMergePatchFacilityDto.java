package org.dddml.wms.domain.facility;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchFacilityDto extends AbstractFacilityCommandDto
{
    /**
     * Facility Type Id
     */
    private String facilityTypeId;

    public String getFacilityTypeId()
    {
        return this.facilityTypeId;
    }

    public void setFacilityTypeId(String facilityTypeId)
    {
        this.facilityTypeId = facilityTypeId;
    }

    /**
     * Parent Facility Id
     */
    private String parentFacilityId;

    public String getParentFacilityId()
    {
        return this.parentFacilityId;
    }

    public void setParentFacilityId(String parentFacilityId)
    {
        this.parentFacilityId = parentFacilityId;
    }

    /**
     * Owner Party Id
     */
    private String ownerPartyId;

    public String getOwnerPartyId()
    {
        return this.ownerPartyId;
    }

    public void setOwnerPartyId(String ownerPartyId)
    {
        this.ownerPartyId = ownerPartyId;
    }

    /**
     * Default Inventory Item Type Id
     */
    private String defaultInventoryItemTypeId;

    public String getDefaultInventoryItemTypeId()
    {
        return this.defaultInventoryItemTypeId;
    }

    public void setDefaultInventoryItemTypeId(String defaultInventoryItemTypeId)
    {
        this.defaultInventoryItemTypeId = defaultInventoryItemTypeId;
    }

    /**
     * Facility Name
     */
    private String facilityName;

    public String getFacilityName()
    {
        return this.facilityName;
    }

    public void setFacilityName(String facilityName)
    {
        this.facilityName = facilityName;
    }

    /**
     * Primary Facility Group Id
     */
    private String primaryFacilityGroupId;

    public String getPrimaryFacilityGroupId()
    {
        return this.primaryFacilityGroupId;
    }

    public void setPrimaryFacilityGroupId(String primaryFacilityGroupId)
    {
        this.primaryFacilityGroupId = primaryFacilityGroupId;
    }

    /**
     * Old Square Footage
     */
    private Long oldSquareFootage;

    public Long getOldSquareFootage()
    {
        return this.oldSquareFootage;
    }

    public void setOldSquareFootage(Long oldSquareFootage)
    {
        this.oldSquareFootage = oldSquareFootage;
    }

    /**
     * Facility Size
     */
    private java.math.BigDecimal facilitySize;

    public java.math.BigDecimal getFacilitySize()
    {
        return this.facilitySize;
    }

    public void setFacilitySize(java.math.BigDecimal facilitySize)
    {
        this.facilitySize = facilitySize;
    }

    /**
     * Facility Size Uom Id
     */
    private String facilitySizeUomId;

    public String getFacilitySizeUomId()
    {
        return this.facilitySizeUomId;
    }

    public void setFacilitySizeUomId(String facilitySizeUomId)
    {
        this.facilitySizeUomId = facilitySizeUomId;
    }

    /**
     * Product Store Id
     */
    private String productStoreId;

    public String getProductStoreId()
    {
        return this.productStoreId;
    }

    public void setProductStoreId(String productStoreId)
    {
        this.productStoreId = productStoreId;
    }

    /**
     * In the absence of a product specific days to ship in ProductFacility, this will be used
     */
    private Long defaultDaysToShip;

    public Long getDefaultDaysToShip()
    {
        return this.defaultDaysToShip;
    }

    public void setDefaultDaysToShip(Long defaultDaysToShip)
    {
        this.defaultDaysToShip = defaultDaysToShip;
    }

    /**
     * Opened Date
     */
    private java.sql.Timestamp openedDate;

    public java.sql.Timestamp getOpenedDate()
    {
        return this.openedDate;
    }

    public void setOpenedDate(java.sql.Timestamp openedDate)
    {
        this.openedDate = openedDate;
    }

    /**
     * Closed Date
     */
    private java.sql.Timestamp closedDate;

    public java.sql.Timestamp getClosedDate()
    {
        return this.closedDate;
    }

    public void setClosedDate(java.sql.Timestamp closedDate)
    {
        this.closedDate = closedDate;
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
     * This field store the unit of measurement of dimension (length, width and height)
     */
    private String defaultDimensionUomId;

    public String getDefaultDimensionUomId()
    {
        return this.defaultDimensionUomId;
    }

    public void setDefaultDimensionUomId(String defaultDimensionUomId)
    {
        this.defaultDimensionUomId = defaultDimensionUomId;
    }

    /**
     * Default Weight Uom Id
     */
    private String defaultWeightUomId;

    public String getDefaultWeightUomId()
    {
        return this.defaultWeightUomId;
    }

    public void setDefaultWeightUomId(String defaultWeightUomId)
    {
        this.defaultWeightUomId = defaultWeightUomId;
    }

    /**
     * Geo Point Id
     */
    private String geoPointId;

    public String getGeoPointId()
    {
        return this.geoPointId;
    }

    public void setGeoPointId(String geoPointId)
    {
        this.geoPointId = geoPointId;
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

    public static class CreateFacilityDto extends CreateOrMergePatchFacilityDto
    {
        public CreateFacilityDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static class MergePatchFacilityDto extends CreateOrMergePatchFacilityDto
    {
        public MergePatchFacilityDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

    }

}

