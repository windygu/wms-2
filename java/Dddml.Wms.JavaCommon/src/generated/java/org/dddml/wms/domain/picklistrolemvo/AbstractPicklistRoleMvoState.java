package org.dddml.wms.domain.picklistrolemvo;

import java.util.*;
import org.dddml.wms.domain.picklist.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.picklistrolemvo.PicklistRoleMvoEvent.*;

public abstract class AbstractPicklistRoleMvoState implements PicklistRoleMvoState
{

    private PicklistRoleId picklistRoleId;

    public PicklistRoleId getPicklistRoleId()
    {
        return this.picklistRoleId;
    }

    public void setPicklistRoleId(PicklistRoleId picklistRoleId)
    {
        this.picklistRoleId = picklistRoleId;
    }

    private String createdByUserLogin;

    public String getCreatedByUserLogin()
    {
        return this.createdByUserLogin;
    }

    public void setCreatedByUserLogin(String createdByUserLogin)
    {
        this.createdByUserLogin = createdByUserLogin;
    }

    private String lastModifiedByUserLogin;

    public String getLastModifiedByUserLogin()
    {
        return this.lastModifiedByUserLogin;
    }

    public void setLastModifiedByUserLogin(String lastModifiedByUserLogin)
    {
        this.lastModifiedByUserLogin = lastModifiedByUserLogin;
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

    private Date createdAt;

    public Date getCreatedAt()
    {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
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

    private String picklistDescription;

    public String getPicklistDescription()
    {
        return this.picklistDescription;
    }

    public void setPicklistDescription(String picklistDescription)
    {
        this.picklistDescription = picklistDescription;
    }

    private String picklistFacilityId;

    public String getPicklistFacilityId()
    {
        return this.picklistFacilityId;
    }

    public void setPicklistFacilityId(String picklistFacilityId)
    {
        this.picklistFacilityId = picklistFacilityId;
    }

    private String picklistShipmentMethodTypeId;

    public String getPicklistShipmentMethodTypeId()
    {
        return this.picklistShipmentMethodTypeId;
    }

    public void setPicklistShipmentMethodTypeId(String picklistShipmentMethodTypeId)
    {
        this.picklistShipmentMethodTypeId = picklistShipmentMethodTypeId;
    }

    private String picklistStatusId;

    public String getPicklistStatusId()
    {
        return this.picklistStatusId;
    }

    public void setPicklistStatusId(String picklistStatusId)
    {
        this.picklistStatusId = picklistStatusId;
    }

    private java.sql.Timestamp picklistPicklistDate;

    public java.sql.Timestamp getPicklistPicklistDate()
    {
        return this.picklistPicklistDate;
    }

    public void setPicklistPicklistDate(java.sql.Timestamp picklistPicklistDate)
    {
        this.picklistPicklistDate = picklistPicklistDate;
    }

    private Long picklistPickwaveId;

    public Long getPicklistPickwaveId()
    {
        return this.picklistPickwaveId;
    }

    public void setPicklistPickwaveId(Long picklistPickwaveId)
    {
        this.picklistPickwaveId = picklistPickwaveId;
    }

    private Long picklistVersion;

    public Long getPicklistVersion()
    {
        return this.picklistVersion;
    }

    public void setPicklistVersion(Long picklistVersion)
    {
        this.picklistVersion = picklistVersion;
    }

    private String picklistCreatedBy;

    public String getPicklistCreatedBy()
    {
        return this.picklistCreatedBy;
    }

    public void setPicklistCreatedBy(String picklistCreatedBy)
    {
        this.picklistCreatedBy = picklistCreatedBy;
    }

    private Date picklistCreatedAt;

    public Date getPicklistCreatedAt()
    {
        return this.picklistCreatedAt;
    }

    public void setPicklistCreatedAt(Date picklistCreatedAt)
    {
        this.picklistCreatedAt = picklistCreatedAt;
    }

    private String picklistUpdatedBy;

    public String getPicklistUpdatedBy()
    {
        return this.picklistUpdatedBy;
    }

    public void setPicklistUpdatedBy(String picklistUpdatedBy)
    {
        this.picklistUpdatedBy = picklistUpdatedBy;
    }

    private Date picklistUpdatedAt;

    public Date getPicklistUpdatedAt()
    {
        return this.picklistUpdatedAt;
    }

    public void setPicklistUpdatedAt(Date picklistUpdatedAt)
    {
        this.picklistUpdatedAt = picklistUpdatedAt;
    }

    private Boolean picklistActive;

    public Boolean getPicklistActive()
    {
        return this.picklistActive;
    }

    public void setPicklistActive(Boolean picklistActive)
    {
        this.picklistActive = picklistActive;
    }

    private Boolean picklistDeleted;

    public Boolean getPicklistDeleted()
    {
        return this.picklistDeleted;
    }

    public void setPicklistDeleted(Boolean picklistDeleted)
    {
        this.picklistDeleted = picklistDeleted;
    }

    public boolean isStateUnsaved() 
    {
        return this.getPicklistVersion() == null;
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

    public AbstractPicklistRoleMvoState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setPicklistRoleId(((PicklistRoleMvoEvent) events.get(0)).getPicklistRoleMvoEventId().getPicklistRoleId());
            for (Event e : events) {
                mutate(e);
                this.setPicklistVersion(this.getPicklistVersion() + 1);
            }
        }
    }


    public AbstractPicklistRoleMvoState() {
        this(false);
    }

    public AbstractPicklistRoleMvoState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof PicklistRoleMvoStateCreated) {
            when((PicklistRoleMvoStateCreated) e);
        } else if (e instanceof PicklistRoleMvoStateMergePatched) {
            when((PicklistRoleMvoStateMergePatched) e);
        } else if (e instanceof PicklistRoleMvoStateDeleted) {
            when((PicklistRoleMvoStateDeleted) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(PicklistRoleMvoStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setVersion(e.getVersion());
        this.setActive(e.getActive());
        this.setPicklistDescription(e.getPicklistDescription());
        this.setPicklistFacilityId(e.getPicklistFacilityId());
        this.setPicklistShipmentMethodTypeId(e.getPicklistShipmentMethodTypeId());
        this.setPicklistStatusId(e.getPicklistStatusId());
        this.setPicklistPicklistDate(e.getPicklistPicklistDate());
        this.setPicklistPickwaveId(e.getPicklistPickwaveId());
        this.setPicklistCreatedBy(e.getPicklistCreatedBy());
        this.setPicklistCreatedAt(e.getPicklistCreatedAt());
        this.setPicklistUpdatedBy(e.getPicklistUpdatedBy());
        this.setPicklistUpdatedAt(e.getPicklistUpdatedAt());
        this.setPicklistActive(e.getPicklistActive());
        this.setPicklistDeleted(e.getPicklistDeleted());

        this.setDeleted(false);

        this.setCreatedByUserLogin(e.getCreatedByUserLogin());
        this.setCreatedAt(e.getCreatedAt());

    }

    public void when(PicklistRoleMvoStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getVersion() == null)
        {
            if (e.getIsPropertyVersionRemoved() != null && e.getIsPropertyVersionRemoved())
            {
                this.setVersion(null);
            }
        }
        else
        {
            this.setVersion(e.getVersion());
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
        if (e.getPicklistDescription() == null)
        {
            if (e.getIsPropertyPicklistDescriptionRemoved() != null && e.getIsPropertyPicklistDescriptionRemoved())
            {
                this.setPicklistDescription(null);
            }
        }
        else
        {
            this.setPicklistDescription(e.getPicklistDescription());
        }
        if (e.getPicklistFacilityId() == null)
        {
            if (e.getIsPropertyPicklistFacilityIdRemoved() != null && e.getIsPropertyPicklistFacilityIdRemoved())
            {
                this.setPicklistFacilityId(null);
            }
        }
        else
        {
            this.setPicklistFacilityId(e.getPicklistFacilityId());
        }
        if (e.getPicklistShipmentMethodTypeId() == null)
        {
            if (e.getIsPropertyPicklistShipmentMethodTypeIdRemoved() != null && e.getIsPropertyPicklistShipmentMethodTypeIdRemoved())
            {
                this.setPicklistShipmentMethodTypeId(null);
            }
        }
        else
        {
            this.setPicklistShipmentMethodTypeId(e.getPicklistShipmentMethodTypeId());
        }
        if (e.getPicklistStatusId() == null)
        {
            if (e.getIsPropertyPicklistStatusIdRemoved() != null && e.getIsPropertyPicklistStatusIdRemoved())
            {
                this.setPicklistStatusId(null);
            }
        }
        else
        {
            this.setPicklistStatusId(e.getPicklistStatusId());
        }
        if (e.getPicklistPicklistDate() == null)
        {
            if (e.getIsPropertyPicklistPicklistDateRemoved() != null && e.getIsPropertyPicklistPicklistDateRemoved())
            {
                this.setPicklistPicklistDate(null);
            }
        }
        else
        {
            this.setPicklistPicklistDate(e.getPicklistPicklistDate());
        }
        if (e.getPicklistPickwaveId() == null)
        {
            if (e.getIsPropertyPicklistPickwaveIdRemoved() != null && e.getIsPropertyPicklistPickwaveIdRemoved())
            {
                this.setPicklistPickwaveId(null);
            }
        }
        else
        {
            this.setPicklistPickwaveId(e.getPicklistPickwaveId());
        }
        if (e.getPicklistCreatedBy() == null)
        {
            if (e.getIsPropertyPicklistCreatedByRemoved() != null && e.getIsPropertyPicklistCreatedByRemoved())
            {
                this.setPicklistCreatedBy(null);
            }
        }
        else
        {
            this.setPicklistCreatedBy(e.getPicklistCreatedBy());
        }
        if (e.getPicklistCreatedAt() == null)
        {
            if (e.getIsPropertyPicklistCreatedAtRemoved() != null && e.getIsPropertyPicklistCreatedAtRemoved())
            {
                this.setPicklistCreatedAt(null);
            }
        }
        else
        {
            this.setPicklistCreatedAt(e.getPicklistCreatedAt());
        }
        if (e.getPicklistUpdatedBy() == null)
        {
            if (e.getIsPropertyPicklistUpdatedByRemoved() != null && e.getIsPropertyPicklistUpdatedByRemoved())
            {
                this.setPicklistUpdatedBy(null);
            }
        }
        else
        {
            this.setPicklistUpdatedBy(e.getPicklistUpdatedBy());
        }
        if (e.getPicklistUpdatedAt() == null)
        {
            if (e.getIsPropertyPicklistUpdatedAtRemoved() != null && e.getIsPropertyPicklistUpdatedAtRemoved())
            {
                this.setPicklistUpdatedAt(null);
            }
        }
        else
        {
            this.setPicklistUpdatedAt(e.getPicklistUpdatedAt());
        }
        if (e.getPicklistActive() == null)
        {
            if (e.getIsPropertyPicklistActiveRemoved() != null && e.getIsPropertyPicklistActiveRemoved())
            {
                this.setPicklistActive(null);
            }
        }
        else
        {
            this.setPicklistActive(e.getPicklistActive());
        }
        if (e.getPicklistDeleted() == null)
        {
            if (e.getIsPropertyPicklistDeletedRemoved() != null && e.getIsPropertyPicklistDeletedRemoved())
            {
                this.setPicklistDeleted(null);
            }
        }
        else
        {
            this.setPicklistDeleted(e.getPicklistDeleted());
        }

        this.setLastModifiedByUserLogin(e.getCreatedByUserLogin());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void when(PicklistRoleMvoStateDeleted e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setLastModifiedByUserLogin(e.getCreatedByUserLogin());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(PicklistRoleMvoEvent event)
    {
        PicklistRoleId stateEntityId = this.getPicklistRoleId(); // Aggregate Id
        PicklistRoleId eventEntityId = event.getPicklistRoleMvoEventId().getPicklistRoleId(); // EntityBase.Aggregate.GetEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getPicklistVersion();
        Long eventVersion = event.getPicklistRoleMvoEventId().getPicklistVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("event.getPicklistRoleMvoEventId().getPicklistVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(PicklistRoleMvoState.VERSION_NULL)) && !eventVersion.equals(stateVersion))
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimplePicklistRoleMvoState extends AbstractPicklistRoleMvoState
    {

        public SimplePicklistRoleMvoState() {
        }

        public SimplePicklistRoleMvoState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimplePicklistRoleMvoState(List<Event> events) {
            super(events);
        }

    }


}

