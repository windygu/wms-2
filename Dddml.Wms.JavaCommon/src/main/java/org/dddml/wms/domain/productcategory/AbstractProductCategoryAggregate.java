package org.dddml.wms.domain.productcategory;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractProductCategoryAggregate extends AbstractAggregate implements ProductCategoryAggregate
{
    private ProductCategoryState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractProductCategoryAggregate(ProductCategoryState state)
    {
        this.state = state;
    }

    public ProductCategoryState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(ProductCategoryCommand.CreateProductCategory c)
    {
        if (c.getVersion() == null) { c.setVersion(ProductCategoryState.VERSION_NULL); }
        ProductCategoryStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(ProductCategoryCommand.MergePatchProductCategory c)
    {
        ProductCategoryStateEvent e = map(c);
        apply(e);
    }

    public void delete(ProductCategoryCommand.DeleteProductCategory c)
    {
        ProductCategoryStateEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        ProductCategoryCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected ProductCategoryStateEvent map(ProductCategoryCommand.CreateProductCategory c) {
        ProductCategoryStateEventId stateEventId = new ProductCategoryStateEventId(c.getProductCategoryId(), c.getVersion());
        ProductCategoryStateEvent.ProductCategoryStateCreated e = newProductCategoryStateCreated(stateEventId);
        e.setProductCategoryTypeId(c.getProductCategoryTypeId());
        e.setPrimaryParentCategoryId(c.getPrimaryParentCategoryId());
        e.setCategoryName(c.getCategoryName());
        e.setDescription(c.getDescription());
        e.setCategoryImageUrl(c.getCategoryImageUrl());
        e.setDetailScreen(c.getDetailScreen());
        e.setShowInSelect(c.getShowInSelect());
        e.setAttributeSetId(c.getAttributeSetId());
        e.setActive(c.getActive());
        ((AbstractProductCategoryStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ProductCategoryStateEvent map(ProductCategoryCommand.MergePatchProductCategory c) {
        ProductCategoryStateEventId stateEventId = new ProductCategoryStateEventId(c.getProductCategoryId(), c.getVersion());
        ProductCategoryStateEvent.ProductCategoryStateMergePatched e = newProductCategoryStateMergePatched(stateEventId);
        e.setProductCategoryTypeId(c.getProductCategoryTypeId());
        e.setPrimaryParentCategoryId(c.getPrimaryParentCategoryId());
        e.setCategoryName(c.getCategoryName());
        e.setDescription(c.getDescription());
        e.setCategoryImageUrl(c.getCategoryImageUrl());
        e.setDetailScreen(c.getDetailScreen());
        e.setShowInSelect(c.getShowInSelect());
        e.setAttributeSetId(c.getAttributeSetId());
        e.setActive(c.getActive());
        e.setIsPropertyProductCategoryTypeIdRemoved(c.getIsPropertyProductCategoryTypeIdRemoved());
        e.setIsPropertyPrimaryParentCategoryIdRemoved(c.getIsPropertyPrimaryParentCategoryIdRemoved());
        e.setIsPropertyCategoryNameRemoved(c.getIsPropertyCategoryNameRemoved());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertyCategoryImageUrlRemoved(c.getIsPropertyCategoryImageUrlRemoved());
        e.setIsPropertyDetailScreenRemoved(c.getIsPropertyDetailScreenRemoved());
        e.setIsPropertyShowInSelectRemoved(c.getIsPropertyShowInSelectRemoved());
        e.setIsPropertyAttributeSetIdRemoved(c.getIsPropertyAttributeSetIdRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractProductCategoryStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ProductCategoryStateEvent map(ProductCategoryCommand.DeleteProductCategory c) {
        ProductCategoryStateEventId stateEventId = new ProductCategoryStateEventId(c.getProductCategoryId(), c.getVersion());
        ProductCategoryStateEvent.ProductCategoryStateDeleted e = newProductCategoryStateDeleted(stateEventId);
        ((AbstractProductCategoryStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected ProductCategoryStateEvent.ProductCategoryStateCreated newProductCategoryStateCreated(String commandId, String requesterId) {
        ProductCategoryStateEventId stateEventId = new ProductCategoryStateEventId(this.state.getProductCategoryId(), this.state.getVersion());
        ProductCategoryStateEvent.ProductCategoryStateCreated e = newProductCategoryStateCreated(stateEventId);
        ((AbstractProductCategoryStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ProductCategoryStateEvent.ProductCategoryStateMergePatched newProductCategoryStateMergePatched(String commandId, String requesterId) {
        ProductCategoryStateEventId stateEventId = new ProductCategoryStateEventId(this.state.getProductCategoryId(), this.state.getVersion());
        ProductCategoryStateEvent.ProductCategoryStateMergePatched e = newProductCategoryStateMergePatched(stateEventId);
        ((AbstractProductCategoryStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ProductCategoryStateEvent.ProductCategoryStateDeleted newProductCategoryStateDeleted(String commandId, String requesterId) {
        ProductCategoryStateEventId stateEventId = new ProductCategoryStateEventId(this.state.getProductCategoryId(), this.state.getVersion());
        ProductCategoryStateEvent.ProductCategoryStateDeleted e = newProductCategoryStateDeleted(stateEventId);
        ((AbstractProductCategoryStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ProductCategoryStateEvent.ProductCategoryStateCreated newProductCategoryStateCreated(ProductCategoryStateEventId stateEventId) {
        return new AbstractProductCategoryStateEvent.SimpleProductCategoryStateCreated(stateEventId);
    }

    protected ProductCategoryStateEvent.ProductCategoryStateMergePatched newProductCategoryStateMergePatched(ProductCategoryStateEventId stateEventId) {
        return new AbstractProductCategoryStateEvent.SimpleProductCategoryStateMergePatched(stateEventId);
    }

    protected ProductCategoryStateEvent.ProductCategoryStateDeleted newProductCategoryStateDeleted(ProductCategoryStateEventId stateEventId)
    {
        return new AbstractProductCategoryStateEvent.SimpleProductCategoryStateDeleted(stateEventId);
    }


    public static class SimpleProductCategoryAggregate extends AbstractProductCategoryAggregate
    {
        public SimpleProductCategoryAggregate(ProductCategoryState state) {
            super(state);
        }

    }

}

