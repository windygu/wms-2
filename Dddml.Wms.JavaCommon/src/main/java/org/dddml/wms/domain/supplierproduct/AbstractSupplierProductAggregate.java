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
        SupplierProductStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(SupplierProductCommand.MergePatchSupplierProduct c)
    {
        SupplierProductStateEvent e = map(c);
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

    protected SupplierProductStateEvent map(SupplierProductCommand.CreateSupplierProduct c) {
        SupplierProductStateEventId stateEventId = new SupplierProductStateEventId(c.getSupplierProductId(), c.getVersion());
        SupplierProductStateEvent.SupplierProductStateCreated e = newSupplierProductStateCreated(stateEventId);
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
        ((AbstractSupplierProductStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected SupplierProductStateEvent map(SupplierProductCommand.MergePatchSupplierProduct c) {
        SupplierProductStateEventId stateEventId = new SupplierProductStateEventId(c.getSupplierProductId(), c.getVersion());
        SupplierProductStateEvent.SupplierProductStateMergePatched e = newSupplierProductStateMergePatched(stateEventId);
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
        ((AbstractSupplierProductStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected SupplierProductStateEvent.SupplierProductStateCreated newSupplierProductStateCreated(String commandId, String requesterId) {
        SupplierProductStateEventId stateEventId = new SupplierProductStateEventId(this.state.getSupplierProductId(), this.state.getVersion());
        SupplierProductStateEvent.SupplierProductStateCreated e = newSupplierProductStateCreated(stateEventId);
        ((AbstractSupplierProductStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected SupplierProductStateEvent.SupplierProductStateMergePatched newSupplierProductStateMergePatched(String commandId, String requesterId) {
        SupplierProductStateEventId stateEventId = new SupplierProductStateEventId(this.state.getSupplierProductId(), this.state.getVersion());
        SupplierProductStateEvent.SupplierProductStateMergePatched e = newSupplierProductStateMergePatched(stateEventId);
        ((AbstractSupplierProductStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected SupplierProductStateEvent.SupplierProductStateCreated newSupplierProductStateCreated(SupplierProductStateEventId stateEventId) {
        return new AbstractSupplierProductStateEvent.SimpleSupplierProductStateCreated(stateEventId);
    }

    protected SupplierProductStateEvent.SupplierProductStateMergePatched newSupplierProductStateMergePatched(SupplierProductStateEventId stateEventId) {
        return new AbstractSupplierProductStateEvent.SimpleSupplierProductStateMergePatched(stateEventId);
    }


    public static class SimpleSupplierProductAggregate extends AbstractSupplierProductAggregate
    {
        public SimpleSupplierProductAggregate(SupplierProductState state) {
            super(state);
        }

    }

}

