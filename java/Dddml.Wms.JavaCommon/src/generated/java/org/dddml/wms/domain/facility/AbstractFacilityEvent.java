package org.dddml.wms.domain.facility;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractFacilityEvent extends AbstractEvent implements FacilityEvent 
{
    private FacilityEventId facilityEventId;

    public FacilityEventId getFacilityEventId() {
        return this.facilityEventId;
    }

    public void setFacilityEventId(FacilityEventId eventId) {
        this.facilityEventId = eventId;
    }
    
    public String getFacilityId() {
        return getFacilityEventId().getFacilityId();
    }

    public void setFacilityId(String facilityId) {
        getFacilityEventId().setFacilityId(facilityId);
    }

    private boolean stateEventReadOnly;

    public boolean getEventReadOnly() { return this.stateEventReadOnly; }

    public void setEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

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

    private String createdBy;

    public String getCreatedBy()
    {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy)
    {
        this.createdBy = createdBy;
    }

    private Date createdAt;

    public Date getCreatedAt()
    {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
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


    private String commandId;

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    protected AbstractFacilityEvent() {
    }

    protected AbstractFacilityEvent(FacilityEventId eventId) {
        this.facilityEventId = eventId;
    }


    public abstract String getEventType();


    public static abstract class AbstractFacilityStateCreated extends AbstractFacilityEvent implements FacilityEvent.FacilityStateCreated
    {
        public AbstractFacilityStateCreated() {
            this(new FacilityEventId());
        }

        public AbstractFacilityStateCreated(FacilityEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractFacilityStateMergePatched extends AbstractFacilityEvent implements FacilityEvent.FacilityStateMergePatched
    {
        public AbstractFacilityStateMergePatched() {
            this(new FacilityEventId());
        }

        public AbstractFacilityStateMergePatched(FacilityEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyFacilityTypeIdRemoved;

        public Boolean getIsPropertyFacilityTypeIdRemoved() {
            return this.isPropertyFacilityTypeIdRemoved;
        }

        public void setIsPropertyFacilityTypeIdRemoved(Boolean removed) {
            this.isPropertyFacilityTypeIdRemoved = removed;
        }

        private Boolean isPropertyParentFacilityIdRemoved;

        public Boolean getIsPropertyParentFacilityIdRemoved() {
            return this.isPropertyParentFacilityIdRemoved;
        }

        public void setIsPropertyParentFacilityIdRemoved(Boolean removed) {
            this.isPropertyParentFacilityIdRemoved = removed;
        }

        private Boolean isPropertyOwnerPartyIdRemoved;

        public Boolean getIsPropertyOwnerPartyIdRemoved() {
            return this.isPropertyOwnerPartyIdRemoved;
        }

        public void setIsPropertyOwnerPartyIdRemoved(Boolean removed) {
            this.isPropertyOwnerPartyIdRemoved = removed;
        }

        private Boolean isPropertyDefaultInventoryItemTypeIdRemoved;

        public Boolean getIsPropertyDefaultInventoryItemTypeIdRemoved() {
            return this.isPropertyDefaultInventoryItemTypeIdRemoved;
        }

        public void setIsPropertyDefaultInventoryItemTypeIdRemoved(Boolean removed) {
            this.isPropertyDefaultInventoryItemTypeIdRemoved = removed;
        }

        private Boolean isPropertyFacilityNameRemoved;

        public Boolean getIsPropertyFacilityNameRemoved() {
            return this.isPropertyFacilityNameRemoved;
        }

        public void setIsPropertyFacilityNameRemoved(Boolean removed) {
            this.isPropertyFacilityNameRemoved = removed;
        }

        private Boolean isPropertyPrimaryFacilityGroupIdRemoved;

        public Boolean getIsPropertyPrimaryFacilityGroupIdRemoved() {
            return this.isPropertyPrimaryFacilityGroupIdRemoved;
        }

        public void setIsPropertyPrimaryFacilityGroupIdRemoved(Boolean removed) {
            this.isPropertyPrimaryFacilityGroupIdRemoved = removed;
        }

        private Boolean isPropertyOldSquareFootageRemoved;

        public Boolean getIsPropertyOldSquareFootageRemoved() {
            return this.isPropertyOldSquareFootageRemoved;
        }

        public void setIsPropertyOldSquareFootageRemoved(Boolean removed) {
            this.isPropertyOldSquareFootageRemoved = removed;
        }

        private Boolean isPropertyFacilitySizeRemoved;

        public Boolean getIsPropertyFacilitySizeRemoved() {
            return this.isPropertyFacilitySizeRemoved;
        }

        public void setIsPropertyFacilitySizeRemoved(Boolean removed) {
            this.isPropertyFacilitySizeRemoved = removed;
        }

        private Boolean isPropertyFacilitySizeUomIdRemoved;

        public Boolean getIsPropertyFacilitySizeUomIdRemoved() {
            return this.isPropertyFacilitySizeUomIdRemoved;
        }

        public void setIsPropertyFacilitySizeUomIdRemoved(Boolean removed) {
            this.isPropertyFacilitySizeUomIdRemoved = removed;
        }

        private Boolean isPropertyProductStoreIdRemoved;

        public Boolean getIsPropertyProductStoreIdRemoved() {
            return this.isPropertyProductStoreIdRemoved;
        }

        public void setIsPropertyProductStoreIdRemoved(Boolean removed) {
            this.isPropertyProductStoreIdRemoved = removed;
        }

        private Boolean isPropertyDefaultDaysToShipRemoved;

        public Boolean getIsPropertyDefaultDaysToShipRemoved() {
            return this.isPropertyDefaultDaysToShipRemoved;
        }

        public void setIsPropertyDefaultDaysToShipRemoved(Boolean removed) {
            this.isPropertyDefaultDaysToShipRemoved = removed;
        }

        private Boolean isPropertyOpenedDateRemoved;

        public Boolean getIsPropertyOpenedDateRemoved() {
            return this.isPropertyOpenedDateRemoved;
        }

        public void setIsPropertyOpenedDateRemoved(Boolean removed) {
            this.isPropertyOpenedDateRemoved = removed;
        }

        private Boolean isPropertyClosedDateRemoved;

        public Boolean getIsPropertyClosedDateRemoved() {
            return this.isPropertyClosedDateRemoved;
        }

        public void setIsPropertyClosedDateRemoved(Boolean removed) {
            this.isPropertyClosedDateRemoved = removed;
        }

        private Boolean isPropertyDescriptionRemoved;

        public Boolean getIsPropertyDescriptionRemoved() {
            return this.isPropertyDescriptionRemoved;
        }

        public void setIsPropertyDescriptionRemoved(Boolean removed) {
            this.isPropertyDescriptionRemoved = removed;
        }

        private Boolean isPropertyDefaultDimensionUomIdRemoved;

        public Boolean getIsPropertyDefaultDimensionUomIdRemoved() {
            return this.isPropertyDefaultDimensionUomIdRemoved;
        }

        public void setIsPropertyDefaultDimensionUomIdRemoved(Boolean removed) {
            this.isPropertyDefaultDimensionUomIdRemoved = removed;
        }

        private Boolean isPropertyDefaultWeightUomIdRemoved;

        public Boolean getIsPropertyDefaultWeightUomIdRemoved() {
            return this.isPropertyDefaultWeightUomIdRemoved;
        }

        public void setIsPropertyDefaultWeightUomIdRemoved(Boolean removed) {
            this.isPropertyDefaultWeightUomIdRemoved = removed;
        }

        private Boolean isPropertyGeoPointIdRemoved;

        public Boolean getIsPropertyGeoPointIdRemoved() {
            return this.isPropertyGeoPointIdRemoved;
        }

        public void setIsPropertyGeoPointIdRemoved(Boolean removed) {
            this.isPropertyGeoPointIdRemoved = removed;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

    }


    public static abstract class AbstractFacilityStateDeleted extends AbstractFacilityEvent implements FacilityEvent.FacilityStateDeleted
    {
        public AbstractFacilityStateDeleted() {
            this(new FacilityEventId());
        }

        public AbstractFacilityStateDeleted(FacilityEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.DELETED;
        }

    }
    public static class SimpleFacilityStateCreated extends AbstractFacilityStateCreated
    {
        public SimpleFacilityStateCreated() {
        }

        public SimpleFacilityStateCreated(FacilityEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleFacilityStateMergePatched extends AbstractFacilityStateMergePatched
    {
        public SimpleFacilityStateMergePatched() {
        }

        public SimpleFacilityStateMergePatched(FacilityEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleFacilityStateDeleted extends AbstractFacilityStateDeleted
    {
        public SimpleFacilityStateDeleted() {
        }

        public SimpleFacilityStateDeleted(FacilityEventId eventId) {
            super(eventId);
        }
    }

}

