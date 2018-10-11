package org.dddml.wms.domain.inoutnotice;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.inoutnotice.InOutNoticeEvent.*;

public abstract class AbstractInOutNoticeState implements InOutNoticeState.SqlInOutNoticeState
{

    private String inOutNoticeId;

    public String getInOutNoticeId()
    {
        return this.inOutNoticeId;
    }

    public void setInOutNoticeId(String inOutNoticeId)
    {
        this.inOutNoticeId = inOutNoticeId;
    }

    private String warehouseId;

    public String getWarehouseId()
    {
        return this.warehouseId;
    }

    public void setWarehouseId(String warehouseId)
    {
        this.warehouseId = warehouseId;
    }

    private String inOutNoticeType;

    public String getInOutNoticeType()
    {
        return this.inOutNoticeType;
    }

    public void setInOutNoticeType(String inOutNoticeType)
    {
        this.inOutNoticeType = inOutNoticeType;
    }

    private String telecomContactMechId;

    public String getTelecomContactMechId()
    {
        return this.telecomContactMechId;
    }

    public void setTelecomContactMechId(String telecomContactMechId)
    {
        this.telecomContactMechId = telecomContactMechId;
    }

    private String trackingNumber;

    public String getTrackingNumber()
    {
        return this.trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber)
    {
        this.trackingNumber = trackingNumber;
    }

    private String contactPartyId;

    public String getContactPartyId()
    {
        return this.contactPartyId;
    }

    public void setContactPartyId(String contactPartyId)
    {
        this.contactPartyId = contactPartyId;
    }

    private String vehiclePlateNumber;

    public String getVehiclePlateNumber()
    {
        return this.vehiclePlateNumber;
    }

    public void setVehiclePlateNumber(String vehiclePlateNumber)
    {
        this.vehiclePlateNumber = vehiclePlateNumber;
    }

    private String shippingInstructions;

    public String getShippingInstructions()
    {
        return this.shippingInstructions;
    }

    public void setShippingInstructions(String shippingInstructions)
    {
        this.shippingInstructions = shippingInstructions;
    }

    private java.sql.Timestamp estimatedShipDate;

    public java.sql.Timestamp getEstimatedShipDate()
    {
        return this.estimatedShipDate;
    }

    public void setEstimatedShipDate(java.sql.Timestamp estimatedShipDate)
    {
        this.estimatedShipDate = estimatedShipDate;
    }

    private java.sql.Timestamp estimatedDeliveryDate;

    public java.sql.Timestamp getEstimatedDeliveryDate()
    {
        return this.estimatedDeliveryDate;
    }

    public void setEstimatedDeliveryDate(java.sql.Timestamp estimatedDeliveryDate)
    {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    private Boolean isScheduleNeeded;

    public Boolean getIsScheduleNeeded()
    {
        return this.isScheduleNeeded;
    }

    public void setIsScheduleNeeded(Boolean isScheduleNeeded)
    {
        this.isScheduleNeeded = isScheduleNeeded;
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

    public AbstractInOutNoticeState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setInOutNoticeId(((InOutNoticeEvent.SqlInOutNoticeEvent) events.get(0)).getInOutNoticeEventId().getInOutNoticeId());
            for (Event e : events) {
                mutate(e);
                this.setVersion(this.getVersion() + 1);
            }
        }
    }


    public AbstractInOutNoticeState() {
        this(false);
    }

    public AbstractInOutNoticeState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }

    @Override
    public int hashCode() {
        return getInOutNoticeId().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return Objects.equals(this.getInOutNoticeId(), ((InOutNoticeState)obj).getInOutNoticeId());
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof InOutNoticeStateCreated) {
            when((InOutNoticeStateCreated) e);
        } else if (e instanceof InOutNoticeStateMergePatched) {
            when((InOutNoticeStateMergePatched) e);
        } else if (e instanceof InOutNoticeStateDeleted) {
            when((InOutNoticeStateDeleted) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(InOutNoticeStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setWarehouseId(e.getWarehouseId());
        this.setInOutNoticeType(e.getInOutNoticeType());
        this.setTelecomContactMechId(e.getTelecomContactMechId());
        this.setTrackingNumber(e.getTrackingNumber());
        this.setContactPartyId(e.getContactPartyId());
        this.setVehiclePlateNumber(e.getVehiclePlateNumber());
        this.setShippingInstructions(e.getShippingInstructions());
        this.setEstimatedShipDate(e.getEstimatedShipDate());
        this.setEstimatedDeliveryDate(e.getEstimatedDeliveryDate());
        this.setIsScheduleNeeded(e.getIsScheduleNeeded());
        this.setStatusId(e.getStatusId());
        this.setActive(e.getActive());

        this.setDeleted(false);

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    protected void merge(InOutNoticeState s) {
        if (s == this) {
            return;
        }
        this.setWarehouseId(s.getWarehouseId());
        this.setInOutNoticeType(s.getInOutNoticeType());
        this.setTelecomContactMechId(s.getTelecomContactMechId());
        this.setTrackingNumber(s.getTrackingNumber());
        this.setContactPartyId(s.getContactPartyId());
        this.setVehiclePlateNumber(s.getVehiclePlateNumber());
        this.setShippingInstructions(s.getShippingInstructions());
        this.setEstimatedShipDate(s.getEstimatedShipDate());
        this.setEstimatedDeliveryDate(s.getEstimatedDeliveryDate());
        this.setIsScheduleNeeded(s.getIsScheduleNeeded());
        this.setStatusId(s.getStatusId());
        this.setActive(s.getActive());
    }

    public void when(InOutNoticeStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getWarehouseId() == null)
        {
            if (e.getIsPropertyWarehouseIdRemoved() != null && e.getIsPropertyWarehouseIdRemoved())
            {
                this.setWarehouseId(null);
            }
        }
        else
        {
            this.setWarehouseId(e.getWarehouseId());
        }
        if (e.getInOutNoticeType() == null)
        {
            if (e.getIsPropertyInOutNoticeTypeRemoved() != null && e.getIsPropertyInOutNoticeTypeRemoved())
            {
                this.setInOutNoticeType(null);
            }
        }
        else
        {
            this.setInOutNoticeType(e.getInOutNoticeType());
        }
        if (e.getTelecomContactMechId() == null)
        {
            if (e.getIsPropertyTelecomContactMechIdRemoved() != null && e.getIsPropertyTelecomContactMechIdRemoved())
            {
                this.setTelecomContactMechId(null);
            }
        }
        else
        {
            this.setTelecomContactMechId(e.getTelecomContactMechId());
        }
        if (e.getTrackingNumber() == null)
        {
            if (e.getIsPropertyTrackingNumberRemoved() != null && e.getIsPropertyTrackingNumberRemoved())
            {
                this.setTrackingNumber(null);
            }
        }
        else
        {
            this.setTrackingNumber(e.getTrackingNumber());
        }
        if (e.getContactPartyId() == null)
        {
            if (e.getIsPropertyContactPartyIdRemoved() != null && e.getIsPropertyContactPartyIdRemoved())
            {
                this.setContactPartyId(null);
            }
        }
        else
        {
            this.setContactPartyId(e.getContactPartyId());
        }
        if (e.getVehiclePlateNumber() == null)
        {
            if (e.getIsPropertyVehiclePlateNumberRemoved() != null && e.getIsPropertyVehiclePlateNumberRemoved())
            {
                this.setVehiclePlateNumber(null);
            }
        }
        else
        {
            this.setVehiclePlateNumber(e.getVehiclePlateNumber());
        }
        if (e.getShippingInstructions() == null)
        {
            if (e.getIsPropertyShippingInstructionsRemoved() != null && e.getIsPropertyShippingInstructionsRemoved())
            {
                this.setShippingInstructions(null);
            }
        }
        else
        {
            this.setShippingInstructions(e.getShippingInstructions());
        }
        if (e.getEstimatedShipDate() == null)
        {
            if (e.getIsPropertyEstimatedShipDateRemoved() != null && e.getIsPropertyEstimatedShipDateRemoved())
            {
                this.setEstimatedShipDate(null);
            }
        }
        else
        {
            this.setEstimatedShipDate(e.getEstimatedShipDate());
        }
        if (e.getEstimatedDeliveryDate() == null)
        {
            if (e.getIsPropertyEstimatedDeliveryDateRemoved() != null && e.getIsPropertyEstimatedDeliveryDateRemoved())
            {
                this.setEstimatedDeliveryDate(null);
            }
        }
        else
        {
            this.setEstimatedDeliveryDate(e.getEstimatedDeliveryDate());
        }
        if (e.getIsScheduleNeeded() == null)
        {
            if (e.getIsPropertyIsScheduleNeededRemoved() != null && e.getIsPropertyIsScheduleNeededRemoved())
            {
                this.setIsScheduleNeeded(null);
            }
        }
        else
        {
            this.setIsScheduleNeeded(e.getIsScheduleNeeded());
        }
        if (e.getStatusId() == null)
        {
            if (e.getIsPropertyStatusIdRemoved() != null && e.getIsPropertyStatusIdRemoved())
            {
                this.setStatusId(null);
            }
        }
        else
        {
            this.setStatusId(e.getStatusId());
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

    public void when(InOutNoticeStateDeleted e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(InOutNoticeEvent event)
    {
        String stateEntityId = this.getInOutNoticeId(); // Aggregate Id
        String eventEntityId = ((InOutNoticeEvent.SqlInOutNoticeEvent)event).getInOutNoticeEventId().getInOutNoticeId(); // EntityBase.Aggregate.GetEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getVersion();
        Long eventVersion = ((InOutNoticeEvent.SqlInOutNoticeEvent)event).getInOutNoticeEventId().getVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("event.getInOutNoticeEventId().getVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(InOutNoticeState.VERSION_NULL)) && !eventVersion.equals(stateVersion))
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleInOutNoticeState extends AbstractInOutNoticeState
    {

        public SimpleInOutNoticeState() {
        }

        public SimpleInOutNoticeState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimpleInOutNoticeState(List<Event> events) {
            super(events);
        }

    }


}

