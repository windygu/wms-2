package org.dddml.wms.domain.productcategorymember;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractProductCategoryMemberAggregate extends AbstractAggregate implements ProductCategoryMemberAggregate
{
    private ProductCategoryMemberState.MutableProductCategoryMemberState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractProductCategoryMemberAggregate(ProductCategoryMemberState state)
    {
        this.state = (ProductCategoryMemberState.MutableProductCategoryMemberState)state;
    }

    public ProductCategoryMemberState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(ProductCategoryMemberCommand.CreateProductCategoryMember c)
    {
        if (c.getVersion() == null) { c.setVersion(ProductCategoryMemberState.VERSION_NULL); }
        ProductCategoryMemberEvent e = map(c);
        apply(e);
    }

    public void mergePatch(ProductCategoryMemberCommand.MergePatchProductCategoryMember c)
    {
        ProductCategoryMemberEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        ProductCategoryMemberCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected ProductCategoryMemberEvent map(ProductCategoryMemberCommand.CreateProductCategoryMember c) {
        ProductCategoryMemberEventId stateEventId = new ProductCategoryMemberEventId(c.getProductCategoryMemberId(), c.getVersion());
        ProductCategoryMemberEvent.ProductCategoryMemberStateCreated e = newProductCategoryMemberStateCreated(stateEventId);
        e.setThruDate(c.getThruDate());
        e.setComments(c.getComments());
        e.setSequenceNum(c.getSequenceNum());
        e.setQuantity(c.getQuantity());
        e.setActive(c.getActive());
        ((AbstractProductCategoryMemberEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ProductCategoryMemberEvent map(ProductCategoryMemberCommand.MergePatchProductCategoryMember c) {
        ProductCategoryMemberEventId stateEventId = new ProductCategoryMemberEventId(c.getProductCategoryMemberId(), c.getVersion());
        ProductCategoryMemberEvent.ProductCategoryMemberStateMergePatched e = newProductCategoryMemberStateMergePatched(stateEventId);
        e.setThruDate(c.getThruDate());
        e.setComments(c.getComments());
        e.setSequenceNum(c.getSequenceNum());
        e.setQuantity(c.getQuantity());
        e.setActive(c.getActive());
        e.setIsPropertyThruDateRemoved(c.getIsPropertyThruDateRemoved());
        e.setIsPropertyCommentsRemoved(c.getIsPropertyCommentsRemoved());
        e.setIsPropertySequenceNumRemoved(c.getIsPropertySequenceNumRemoved());
        e.setIsPropertyQuantityRemoved(c.getIsPropertyQuantityRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractProductCategoryMemberEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected ProductCategoryMemberEvent.ProductCategoryMemberStateCreated newProductCategoryMemberStateCreated(Long version, String commandId, String requesterId) {
        ProductCategoryMemberEventId stateEventId = new ProductCategoryMemberEventId(this.state.getProductCategoryMemberId(), version);
        ProductCategoryMemberEvent.ProductCategoryMemberStateCreated e = newProductCategoryMemberStateCreated(stateEventId);
        ((AbstractProductCategoryMemberEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ProductCategoryMemberEvent.ProductCategoryMemberStateMergePatched newProductCategoryMemberStateMergePatched(Long version, String commandId, String requesterId) {
        ProductCategoryMemberEventId stateEventId = new ProductCategoryMemberEventId(this.state.getProductCategoryMemberId(), version);
        ProductCategoryMemberEvent.ProductCategoryMemberStateMergePatched e = newProductCategoryMemberStateMergePatched(stateEventId);
        ((AbstractProductCategoryMemberEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ProductCategoryMemberEvent.ProductCategoryMemberStateCreated newProductCategoryMemberStateCreated(ProductCategoryMemberEventId stateEventId) {
        return new AbstractProductCategoryMemberEvent.SimpleProductCategoryMemberStateCreated(stateEventId);
    }

    protected ProductCategoryMemberEvent.ProductCategoryMemberStateMergePatched newProductCategoryMemberStateMergePatched(ProductCategoryMemberEventId stateEventId) {
        return new AbstractProductCategoryMemberEvent.SimpleProductCategoryMemberStateMergePatched(stateEventId);
    }

    public static class SimpleProductCategoryMemberAggregate extends AbstractProductCategoryMemberAggregate
    {
        public SimpleProductCategoryMemberAggregate(ProductCategoryMemberState state) {
            super(state);
        }

    }

}

