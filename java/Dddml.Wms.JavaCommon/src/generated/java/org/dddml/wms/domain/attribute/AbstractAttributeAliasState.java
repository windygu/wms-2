package org.dddml.wms.domain.attribute;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.attribute.AttributeAliasEvent.*;

public abstract class AbstractAttributeAliasState implements AttributeAliasState
{

    private AttributeAliasId attributeAliasId = new AttributeAliasId();

    public AttributeAliasId getAttributeAliasId() {
        return this.attributeAliasId;
    }

    public void setAttributeAliasId(AttributeAliasId attributeAliasId) {
        this.attributeAliasId = attributeAliasId;
    }

    public String getAttributeId() {
        return this.getAttributeAliasId().getAttributeId();
    }
        
    public void setAttributeId(String attributeId) {
        this.getAttributeAliasId().setAttributeId(attributeId);
    }

    public String getCode() {
        return this.getAttributeAliasId().getCode();
    }
        
    public void setCode(String code) {
        this.getAttributeAliasId().setCode(code);
    }

    private String name;

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
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


    public AbstractAttributeAliasState() {
        this(false);
    }

    public AbstractAttributeAliasState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof AttributeAliasStateCreated) {
            when((AttributeAliasStateCreated) e);
        } else if (e instanceof AttributeAliasStateMergePatched) {
            when((AttributeAliasStateMergePatched) e);
        } else if (e instanceof AttributeAliasStateRemoved) {
            when((AttributeAliasStateRemoved) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(AttributeAliasStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setName(e.getName());
        this.setActive(e.getActive());

        this.setDeleted(false);

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    public void when(AttributeAliasStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getName() == null)
        {
            if (e.getIsPropertyNameRemoved() != null && e.getIsPropertyNameRemoved())
            {
                this.setName(null);
            }
        }
        else
        {
            this.setName(e.getName());
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

    public void when(AttributeAliasStateRemoved e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(AttributeAliasEvent stateEvent)
    {
        String stateEntityIdAttributeId = this.getAttributeAliasId().getAttributeId();
        String eventEntityIdAttributeId = stateEvent.getAttributeAliasEventId().getAttributeId();
        if (!stateEntityIdAttributeId.equals(eventEntityIdAttributeId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id AttributeId %1$s in state but entity id AttributeId %2$s in event", stateEntityIdAttributeId, eventEntityIdAttributeId);
        }

        String stateEntityIdCode = this.getAttributeAliasId().getCode();
        String eventEntityIdCode = stateEvent.getAttributeAliasEventId().getCode();
        if (!stateEntityIdCode.equals(eventEntityIdCode))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id Code %1$s in state but entity id Code %2$s in event", stateEntityIdCode, eventEntityIdCode);
        }

        if (getForReapplying()) { return; }

        Long stateVersion = this.getVersion();
        Long eventVersion = stateEvent.getVersion();
        if (eventVersion == null) {
            eventVersion = stateVersion == null ? AttributeAliasState.VERSION_NULL : stateVersion;
            stateEvent.setVersion(eventVersion);
        }
        if (!(stateVersion == null && eventVersion.equals(AttributeAliasState.VERSION_NULL)) && !eventVersion.equals(stateVersion))//(eventVersion.compareTo(stateVersion) >= 0)
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleAttributeAliasState extends AbstractAttributeAliasState
    {

        public SimpleAttributeAliasState() {
        }

        public SimpleAttributeAliasState(boolean forReapplying) {
            super(forReapplying);
        }

    }


}

