package org.dddml.wms.domain.supplierproduct;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractSupplierProductAggregate extends AbstractAggregate implements SupplierProductAggregate
{
    private SupplierProductState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractSupplierProductAggregate(SupplierProductState state)
    {
        this.state = state;
    }

    public SupplierProductState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(SupplierProductCommand.CreateSupplierProduct c)
    {
        if (c.getVersion() == null) { c.setVersion(SupplierProductState.VERSION_NULL); }
        SupplierProductEvent e = map(c);
        apply(e);
    }

    public void mergePatch(SupplierProductCommand.MergePatchSupplierProduct c)
    {
        SupplierProductEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        SupplierProductCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected SupplierProductEvent map(SupplierProductCommand.CreateSupplierProduct c) {
        SupplierProductEventId stateEventId = new SupplierProductEventId(c.getSupplierProductId(), c.getVersion());
        SupplierProductEvent.SupplierProductStateCreated e = newSupplierProductStateCreated(stateEventId);
        e.setAvailableThruDate(c.getAvailableThruDate());
        e.setSupplierPrefOrderId(c.getSupplierPrefOrderId());
        e.setSupplierRatingTypeId(c.getSupplierRatingTypeId());
        e.setStandardLeadTimeDays(c.getStandardLeadTimeDays());
        e.setManufacturingLeadTimeDays(c.getManufacturingLeadTimeDays());
        e.setDeliveryLeadTimeDays(c.getDeliveryLeadTimeDays());
        e.setQuantityUomId(c.getQuantityUomId());
        e.setLastPrice(c.getLastPrice());
        e.setShippingPrice(c.getShippingPrice());
        e.setExternalProductName(c.getExternalProductName());
        e.setExternalProductId(c.getExternalProductId());
        e.setCanDropShip(c.getCanDropShip());
        e.setComments(c.getComments());
        e.setActive(c.getActive());
        ((AbstractSupplierProductEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected SupplierProductEvent map(SupplierProductCommand.MergePatchSupplierProduct c) {
        SupplierProductEventId stateEventId = new SupplierProductEventId(c.getSupplierProductId(), c.getVersion());
        SupplierProductEvent.SupplierProductStateMergePatched e = newSupplierProductStateMergePatched(stateEventId);
        e.setAvailableThruDate(c.getAvailableThruDate());
        e.setSupplierPrefOrderId(c.getSupplierPrefOrderId());
        e.setSupplierRatingTypeId(c.getSupplierRatingTypeId());
        e.setStandardLeadTimeDays(c.getStandardLeadTimeDays());
        e.setManufacturingLeadTimeDays(c.getManufacturingLeadTimeDays());
        e.setDeliveryLeadTimeDays(c.getDeliveryLeadTimeDays());
        e.setQuantityUomId(c.getQuantityUomId());
        e.setLastPrice(c.getLastPrice());
        e.setShippingPrice(c.getShippingPrice());
        e.setExternalProductName(c.getExternalProductName());
        e.setExternalProductId(c.getExternalProductId());
        e.setCanDropShip(c.getCanDropShip());
        e.setComments(c.getComments());
        e.setActive(c.getActive());
        e.setIsPropertyAvailableThruDateRemoved(c.getIsPropertyAvailableThruDateRemoved());
        e.setIsPropertySupplierPrefOrderIdRemoved(c.getIsPropertySupplierPrefOrderIdRemoved());
        e.setIsPropertySupplierRatingTypeIdRemoved(c.getIsPropertySupplierRatingTypeIdRemoved());
        e.setIsPropertyStandardLeadTimeDaysRemoved(c.getIsPropertyStandardLeadTimeDaysRemoved());
        e.setIsPropertyManufacturingLeadTimeDaysRemoved(c.getIsPropertyManufacturingLeadTimeDaysRemoved());
        e.setIsPropertyDeliveryLeadTimeDaysRemoved(c.getIsPropertyDeliveryLeadTimeDaysRemoved());
        e.setIsPropertyQuantityUomIdRemoved(c.getIsPropertyQuantityUomIdRemoved());
        e.setIsPropertyLastPriceRemoved(c.getIsPropertyLastPriceRemoved());
        e.setIsPropertyShippingPriceRemoved(c.getIsPropertyShippingPriceRemoved());
        e.setIsPropertyExternalProductNameRemoved(c.getIsPropertyExternalProductNameRemoved());
        e.setIsPropertyExternalProductIdRemoved(c.getIsPropertyExternalProductIdRemoved());
        e.setIsPropertyCanDropShipRemoved(c.getIsPropertyCanDropShipRemoved());
        e.setIsPropertyCommentsRemoved(c.getIsPropertyCommentsRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractSupplierProductEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected SupplierProductEvent.SupplierProductStateCreated newSupplierProductStateCreated(Long version, String commandId, String requesterId) {
        SupplierProductEventId stateEventId = new SupplierProductEventId(this.state.getSupplierProductId(), version);
        SupplierProductEvent.SupplierProductStateCreated e = newSupplierProductStateCreated(stateEventId);
        ((AbstractSupplierProductEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected SupplierProductEvent.SupplierProductStateMergePatched newSupplierProductStateMergePatched(Long version, String commandId, String requesterId) {
        SupplierProductEventId stateEventId = new SupplierProductEventId(this.state.getSupplierProductId(), version);
        SupplierProductEvent.SupplierProductStateMergePatched e = newSupplierProductStateMergePatched(stateEventId);
        ((AbstractSupplierProductEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected SupplierProductEvent.SupplierProductStateCreated newSupplierProductStateCreated(SupplierProductEventId stateEventId) {
        return new AbstractSupplierProductEvent.SimpleSupplierProductStateCreated(stateEventId);
    }

    protected SupplierProductEvent.SupplierProductStateMergePatched newSupplierProductStateMergePatched(SupplierProductEventId stateEventId) {
        return new AbstractSupplierProductEvent.SimpleSupplierProductStateMergePatched(stateEventId);
    }

    public static class SimpleSupplierProductAggregate extends AbstractSupplierProductAggregate
    {
        public SimpleSupplierProductAggregate(SupplierProductState state) {
            super(state);
        }

    }

}

