package org.dddml.wms.domain.productcategorymember;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractProductCategoryMemberAggregate extends AbstractAggregate implements ProductCategoryMemberAggregate
{
    private ProductCategoryMemberState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractProductCategoryMemberAggregate(ProductCategoryMemberState state)
    {
        this.state = state;
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
        ProductCategoryMemberStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(ProductCategoryMemberCommand.MergePatchProductCategoryMember c)
    {
        ProductCategoryMemberStateEvent e = map(c);
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

    protected ProductCategoryMemberStateEvent map(ProductCategoryMemberCommand.CreateProductCategoryMember c) {
        ProductCategoryMemberStateEventId stateEventId = new ProductCategoryMemberStateEventId(c.getProductCategoryMemberId(), c.getVersion());
        ProductCategoryMemberStateEvent.ProductCategoryMemberStateCreated e = newProductCategoryMemberStateCreated(stateEventId);
        e.setThruDate(c.getThruDate());
        e.setComments(c.getComments());
        e.setSequenceNum(c.getSequenceNum());
        e.setQuantity(c.getQuantity());
        e.setActive(c.getActive());
        ((AbstractProductCategoryMemberStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ProductCategoryMemberStateEvent map(ProductCategoryMemberCommand.MergePatchProductCategoryMember c) {
        ProductCategoryMemberStateEventId stateEventId = new ProductCategoryMemberStateEventId(c.getProductCategoryMemberId(), c.getVersion());
        ProductCategoryMemberStateEvent.ProductCategoryMemberStateMergePatched e = newProductCategoryMemberStateMergePatched(stateEventId);
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
        ((AbstractProductCategoryMemberStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected ProductCategoryMemberStateEvent.ProductCategoryMemberStateCreated newProductCategoryMemberStateCreated(String commandId, String requesterId) {
        ProductCategoryMemberStateEventId stateEventId = new ProductCategoryMemberStateEventId(this.state.getProductCategoryMemberId(), this.state.getVersion());
        ProductCategoryMemberStateEvent.ProductCategoryMemberStateCreated e = newProductCategoryMemberStateCreated(stateEventId);
        ((AbstractProductCategoryMemberStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ProductCategoryMemberStateEvent.ProductCategoryMemberStateMergePatched newProductCategoryMemberStateMergePatched(String commandId, String requesterId) {
        ProductCategoryMemberStateEventId stateEventId = new ProductCategoryMemberStateEventId(this.state.getProductCategoryMemberId(), this.state.getVersion());
        ProductCategoryMemberStateEvent.ProductCategoryMemberStateMergePatched e = newProductCategoryMemberStateMergePatched(stateEventId);
        ((AbstractProductCategoryMemberStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ProductCategoryMemberStateEvent.ProductCategoryMemberStateCreated newProductCategoryMemberStateCreated(ProductCategoryMemberStateEventId stateEventId) {
        return new AbstractProductCategoryMemberStateEvent.SimpleProductCategoryMemberStateCreated(stateEventId);
    }

    protected ProductCategoryMemberStateEvent.ProductCategoryMemberStateMergePatched newProductCategoryMemberStateMergePatched(ProductCategoryMemberStateEventId stateEventId) {
        return new AbstractProductCategoryMemberStateEvent.SimpleProductCategoryMemberStateMergePatched(stateEventId);
    }


    public static class SimpleProductCategoryMemberAggregate extends AbstractProductCategoryMemberAggregate
    {
        public SimpleProductCategoryMemberAggregate(ProductCategoryMemberState state) {
            super(state);
        }

    }

}

