package org.dddml.wms.domain.facility;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.facility.FacilityEvent.*;

public abstract class AbstractFacilityState implements FacilityState.SqlFacilityState
{

    private String facilityId;

    public String getFacilityId()
    {
        return this.facilityId;
    }

    public void setFacilityId(String facilityId)
    {
        this.facilityId = facilityId;
    }

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

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
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

    private String updatedBy;

    public String getUpdatedBy()
    {
        return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy)
    {
        this.updatedBy = updatedBy;
    }

    private Date updatedAt;

    public Date getUpdatedAt()
    {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt)
    {
        this.updatedAt = updatedAt;
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

    private Boolean deleted;

    public Boolean getDeleted()
    {
        return this.deleted;
    }

    public void setDeleted(Boolean deleted)
    {
        this.deleted = deleted;
    }

    public boolean isStateUnsaved() 
    {
        return this.getVersion() == null;
    }

    private Boolean stateReadOnly;

    public Boolean getStateReadOnly() { return this.stateReadOnly; }

    public void setStateReadOnly(Boolean readOnly) { this.stateReadOnly = readOnly; }

    private boolean forReapplying;

    public boolean getForReapplying() {
        return forReapplying;
    }

    public void setForReapplying(boolean forReapplying) {
        this.forReapplying = forReapplying;
    }

    public AbstractFacilityState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setFacilityId(((FacilityEvent.SqlFacilityEvent) events.get(0)).getFacilityEventId().getFacilityId());
            for (Event e : events) {
                mutate(e);
                this.setVersion(this.getVersion() + 1);
            }
        }
    }


    public AbstractFacilityState() {
        this(false);
    }

    public AbstractFacilityState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }

    @Override
    public int hashCode() {
        return getFacilityId().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return Objects.equals(this.getFacilityId(), ((FacilityState)obj).getFacilityId());
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof FacilityStateCreated) {
            when((FacilityStateCreated) e);
        } else if (e instanceof FacilityStateMergePatched) {
            when((FacilityStateMergePatched) e);
        } else if (e instanceof FacilityStateDeleted) {
            when((FacilityStateDeleted) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(FacilityStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setFacilityTypeId(e.getFacilityTypeId());
        this.setParentFacilityId(e.getParentFacilityId());
        this.setOwnerPartyId(e.getOwnerPartyId());
        this.setDefaultInventoryItemTypeId(e.getDefaultInventoryItemTypeId());
        this.setFacilityName(e.getFacilityName());
        this.setPrimaryFacilityGroupId(e.getPrimaryFacilityGroupId());
        this.setOldSquareFootage(e.getOldSquareFootage());
        this.setFacilitySize(e.getFacilitySize());
        this.setFacilitySizeUomId(e.getFacilitySizeUomId());
        this.setProductStoreId(e.getProductStoreId());
        this.setDefaultDaysToShip(e.getDefaultDaysToShip());
        this.setOpenedDate(e.getOpenedDate());
        this.setClosedDate(e.getClosedDate());
        this.setDescription(e.getDescription());
        this.setDefaultDimensionUomId(e.getDefaultDimensionUomId());
        this.setDefaultWeightUomId(e.getDefaultWeightUomId());
        this.setGeoPointId(e.getGeoPointId());
        this.setActive(e.getActive());

        this.setDeleted(false);

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    protected void merge(FacilityState s) {
        if (s == this) {
            return;
        }
        this.setFacilityTypeId(s.getFacilityTypeId());
        this.setParentFacilityId(s.getParentFacilityId());
        this.setOwnerPartyId(s.getOwnerPartyId());
        this.setDefaultInventoryItemTypeId(s.getDefaultInventoryItemTypeId());
        this.setFacilityName(s.getFacilityName());
        this.setPrimaryFacilityGroupId(s.getPrimaryFacilityGroupId());
        this.setOldSquareFootage(s.getOldSquareFootage());
        this.setFacilitySize(s.getFacilitySize());
        this.setFacilitySizeUomId(s.getFacilitySizeUomId());
        this.setProductStoreId(s.getProductStoreId());
        this.setDefaultDaysToShip(s.getDefaultDaysToShip());
        this.setOpenedDate(s.getOpenedDate());
        this.setClosedDate(s.getClosedDate());
        this.setDescription(s.getDescription());
        this.setDefaultDimensionUomId(s.getDefaultDimensionUomId());
        this.setDefaultWeightUomId(s.getDefaultWeightUomId());
        this.setGeoPointId(s.getGeoPointId());
        this.setActive(s.getActive());
    }

    public void when(FacilityStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getFacilityTypeId() == null)
        {
            if (e.getIsPropertyFacilityTypeIdRemoved() != null && e.getIsPropertyFacilityTypeIdRemoved())
            {
                this.setFacilityTypeId(null);
            }
        }
        else
        {
            this.setFacilityTypeId(e.getFacilityTypeId());
        }
        if (e.getParentFacilityId() == null)
        {
            if (e.getIsPropertyParentFacilityIdRemoved() != null && e.getIsPropertyParentFacilityIdRemoved())
            {
                this.setParentFacilityId(null);
            }
        }
        else
        {
            this.setParentFacilityId(e.getParentFacilityId());
        }
        if (e.getOwnerPartyId() == null)
        {
            if (e.getIsPropertyOwnerPartyIdRemoved() != null && e.getIsPropertyOwnerPartyIdRemoved())
            {
                this.setOwnerPartyId(null);
            }
        }
        else
        {
            this.setOwnerPartyId(e.getOwnerPartyId());
        }
        if (e.getDefaultInventoryItemTypeId() == null)
        {
            if (e.getIsPropertyDefaultInventoryItemTypeIdRemoved() != null && e.getIsPropertyDefaultInventoryItemTypeIdRemoved())
            {
                this.setDefaultInventoryItemTypeId(null);
            }
        }
        else
        {
            this.setDefaultInventoryItemTypeId(e.getDefaultInventoryItemTypeId());
        }
        if (e.getFacilityName() == null)
        {
            if (e.getIsPropertyFacilityNameRemoved() != null && e.getIsPropertyFacilityNameRemoved())
            {
                this.setFacilityName(null);
            }
        }
        else
        {
            this.setFacilityName(e.getFacilityName());
        }
        if (e.getPrimaryFacilityGroupId() == null)
        {
            if (e.getIsPropertyPrimaryFacilityGroupIdRemoved() != null && e.getIsPropertyPrimaryFacilityGroupIdRemoved())
            {
                this.setPrimaryFacilityGroupId(null);
            }
        }
        else
        {
            this.setPrimaryFacilityGroupId(e.getPrimaryFacilityGroupId());
        }
        if (e.getOldSquareFootage() == null)
        {
            if (e.getIsPropertyOldSquareFootageRemoved() != null && e.getIsPropertyOldSquareFootageRemoved())
            {
                this.setOldSquareFootage(null);
            }
        }
        else
        {
            this.setOldSquareFootage(e.getOldSquareFootage());
        }
        if (e.getFacilitySize() == null)
        {
            if (e.getIsPropertyFacilitySizeRemoved() != null && e.getIsPropertyFacilitySizeRemoved())
            {
                this.setFacilitySize(null);
            }
        }
        else
        {
            this.setFacilitySize(e.getFacilitySize());
        }
        if (e.getFacilitySizeUomId() == null)
        {
            if (e.getIsPropertyFacilitySizeUomIdRemoved() != null && e.getIsPropertyFacilitySizeUomIdRemoved())
            {
                this.setFacilitySizeUomId(null);
            }
        }
        else
        {
            this.setFacilitySizeUomId(e.getFacilitySizeUomId());
        }
        if (e.getProductStoreId() == null)
        {
            if (e.getIsPropertyProductStoreIdRemoved() != null && e.getIsPropertyProductStoreIdRemoved())
            {
                this.setProductStoreId(null);
            }
        }
        else
        {
            this.setProductStoreId(e.getProductStoreId());
        }
        if (e.getDefaultDaysToShip() == null)
        {
            if (e.getIsPropertyDefaultDaysToShipRemoved() != null && e.getIsPropertyDefaultDaysToShipRemoved())
            {
                this.setDefaultDaysToShip(null);
            }
        }
        else
        {
            this.setDefaultDaysToShip(e.getDefaultDaysToShip());
        }
        if (e.getOpenedDate() == null)
        {
            if (e.getIsPropertyOpenedDateRemoved() != null && e.getIsPropertyOpenedDateRemoved())
            {
                this.setOpenedDate(null);
            }
        }
        else
        {
            this.setOpenedDate(e.getOpenedDate());
        }
        if (e.getClosedDate() == null)
        {
            if (e.getIsPropertyClosedDateRemoved() != null && e.getIsPropertyClosedDateRemoved())
            {
                this.setClosedDate(null);
            }
        }
        else
        {
            this.setClosedDate(e.getClosedDate());
        }
        if (e.getDescription() == null)
        {
            if (e.getIsPropertyDescriptionRemoved() != null && e.getIsPropertyDescriptionRemoved())
            {
                this.setDescription(null);
            }
        }
        else
        {
            this.setDescription(e.getDescription());
        }
        if (e.getDefaultDimensionUomId() == null)
        {
            if (e.getIsPropertyDefaultDimensionUomIdRemoved() != null && e.getIsPropertyDefaultDimensionUomIdRemoved())
            {
                this.setDefaultDimensionUomId(null);
            }
        }
        else
        {
            this.setDefaultDimensionUomId(e.getDefaultDimensionUomId());
        }
        if (e.getDefaultWeightUomId() == null)
        {
            if (e.getIsPropertyDefaultWeightUomIdRemoved() != null && e.getIsPropertyDefaultWeightUomIdRemoved())
            {
                this.setDefaultWeightUomId(null);
            }
        }
        else
        {
            this.setDefaultWeightUomId(e.getDefaultWeightUomId());
        }
        if (e.getGeoPointId() == null)
        {
            if (e.getIsPropertyGeoPointIdRemoved() != null && e.getIsPropertyGeoPointIdRemoved())
            {
                this.setGeoPointId(null);
            }
        }
        else
        {
            this.setGeoPointId(e.getGeoPointId());
        }
        if (e.getActive() == null)
        {
            if (e.getIsPropertyActiveRemoved() != null && e.getIsPropertyActiveRemoved())
            {
                this.setActive(null);
            }
        }
        else
        {
            this.setActive(e.getActive());
        }

        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void when(FacilityStateDeleted e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(FacilityEvent event)
    {
        String stateEntityId = this.getFacilityId(); // Aggregate Id
        String eventEntityId = ((FacilityEvent.SqlFacilityEvent)event).getFacilityEventId().getFacilityId(); // EntityBase.Aggregate.GetEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getVersion();
        Long eventVersion = ((FacilityEvent.SqlFacilityEvent)event).getFacilityEventId().getVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("event.getFacilityEventId().getVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(FacilityState.VERSION_NULL)) && !eventVersion.equals(stateVersion))
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleFacilityState extends AbstractFacilityState
    {

        public SimpleFacilityState() {
        }

        public SimpleFacilityState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimpleFacilityState(List<Event> events) {
            super(events);
        }

    }


}

