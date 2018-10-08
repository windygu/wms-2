package org.dddml.wms.domain.order;

import java.util.*;
import org.dddml.wms.domain.partyrole.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.order.OrderRoleEvent.*;

public abstract class AbstractOrderRoleState implements OrderRoleState
{

    private OrderRoleId orderRoleId = new OrderRoleId();

    public OrderRoleId getOrderRoleId() {
        return this.orderRoleId;
    }

    public void setOrderRoleId(OrderRoleId orderRoleId) {
        this.orderRoleId = orderRoleId;
    }

    public String getOrderId() {
        return this.getOrderRoleId().getOrderId();
    }
        
    public void setOrderId(String orderId) {
        this.getOrderRoleId().setOrderId(orderId);
    }

    public PartyRoleId getPartyRoleId() {
        return this.getOrderRoleId().getPartyRoleId();
    }
        
    public void setPartyRoleId(PartyRoleId partyRoleId) {
        this.getOrderRoleId().setPartyRoleId(partyRoleId);
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


    public AbstractOrderRoleState() {
        this(false);
    }

    public AbstractOrderRoleState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof OrderRoleStateCreated) {
            when((OrderRoleStateCreated) e);
        } else if (e instanceof OrderRoleStateMergePatched) {
            when((OrderRoleStateMergePatched) e);
        } else if (e instanceof OrderRoleStateRemoved) {
            when((OrderRoleStateRemoved) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(OrderRoleStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setActive(e.getActive());

        this.setDeleted(false);

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    public void when(OrderRoleStateMergePatched e)
    {
        throwOnWrongEvent(e);

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

    public void when(OrderRoleStateRemoved e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(OrderRoleEvent event)
    {
        String stateEntityIdOrderId = this.getOrderRoleId().getOrderId();
        String eventEntityIdOrderId = ((OrderRoleEvent.SqlOrderRoleEvent)event).getOrderRoleEventId().getOrderId();
        if (!stateEntityIdOrderId.equals(eventEntityIdOrderId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id OrderId %1$s in state but entity id OrderId %2$s in event", stateEntityIdOrderId, eventEntityIdOrderId);
        }

        PartyRoleId stateEntityIdPartyRoleId = this.getOrderRoleId().getPartyRoleId();
        PartyRoleId eventEntityIdPartyRoleId = ((OrderRoleEvent.SqlOrderRoleEvent)event).getOrderRoleEventId().getPartyRoleId();
        if (!stateEntityIdPartyRoleId.equals(eventEntityIdPartyRoleId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id PartyRoleId %1$s in state but entity id PartyRoleId %2$s in event", stateEntityIdPartyRoleId, eventEntityIdPartyRoleId);
        }

        if (getForReapplying()) { return; }

        OrderRoleStateEvent stateEvent = event instanceof OrderRoleStateEvent ? (OrderRoleStateEvent)event : null;
        if (stateEvent == null) { return; }

        Long stateVersion = this.getVersion();
        Long stateEventStateVersion = stateEvent.getVersion();
        //if (stateEventStateVersion == null) {
        stateEventStateVersion = stateVersion == null ? OrderRoleState.VERSION_NULL : stateVersion;
        stateEvent.setVersion(stateEventStateVersion);
        //}
        //if (!(stateVersion == null && stateEventStateVersion.equals(OrderRoleState.VERSION_NULL)) && !stateEventStateVersion.equals(stateVersion))
        //{
        //    throw DomainError.named("concurrencyConflict", "Conflict between stateVersion (%1$s) and stateEventStateVersion (%2$s)", stateVersion, stateEventStateVersion);
        //}

    }

    public static class SimpleOrderRoleState extends AbstractOrderRoleState
    {

        public SimpleOrderRoleState() {
        }

        public SimpleOrderRoleState(boolean forReapplying) {
            super(forReapplying);
        }

    }


}

