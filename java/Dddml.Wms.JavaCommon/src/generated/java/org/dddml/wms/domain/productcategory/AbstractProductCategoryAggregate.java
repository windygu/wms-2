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
        ProductCategoryEvent e = map(c);
        apply(e);
    }

    public void mergePatch(ProductCategoryCommand.MergePatchProductCategory c)
    {
        ProductCategoryEvent e = map(c);
        apply(e);
    }

    public void delete(ProductCategoryCommand.DeleteProductCategory c)
    {
        ProductCategoryEvent e = map(c);
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

    protected ProductCategoryEvent map(ProductCategoryCommand.CreateProductCategory c) {
        ProductCategoryEventId stateEventId = new ProductCategoryEventId(c.getProductCategoryId(), c.getVersion());
        ProductCategoryEvent.ProductCategoryStateCreated e = newProductCategoryStateCreated(stateEventId);
        e.setProductCategoryTypeId(c.getProductCategoryTypeId());
        e.setPrimaryParentCategoryId(c.getPrimaryParentCategoryId());
        e.setCategoryName(c.getCategoryName());
        e.setDescription(c.getDescription());
        e.setCategoryImageUrl(c.getCategoryImageUrl());
        e.setDetailScreen(c.getDetailScreen());
        e.setShowInSelect(c.getShowInSelect());
        e.setAttributeSetId(c.getAttributeSetId());
        e.setActive(c.getActive());
        ((AbstractProductCategoryEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ProductCategoryEvent map(ProductCategoryCommand.MergePatchProductCategory c) {
        ProductCategoryEventId stateEventId = new ProductCategoryEventId(c.getProductCategoryId(), c.getVersion());
        ProductCategoryEvent.ProductCategoryStateMergePatched e = newProductCategoryStateMergePatched(stateEventId);
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
        ((AbstractProductCategoryEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ProductCategoryEvent map(ProductCategoryCommand.DeleteProductCategory c) {
        ProductCategoryEventId stateEventId = new ProductCategoryEventId(c.getProductCategoryId(), c.getVersion());
        ProductCategoryEvent.ProductCategoryStateDeleted e = newProductCategoryStateDeleted(stateEventId);
        ((AbstractProductCategoryEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected ProductCategoryEvent.ProductCategoryStateCreated newProductCategoryStateCreated(Long version, String commandId, String requesterId) {
        ProductCategoryEventId stateEventId = new ProductCategoryEventId(this.state.getProductCategoryId(), version);
        ProductCategoryEvent.ProductCategoryStateCreated e = newProductCategoryStateCreated(stateEventId);
        ((AbstractProductCategoryEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ProductCategoryEvent.ProductCategoryStateMergePatched newProductCategoryStateMergePatched(Long version, String commandId, String requesterId) {
        ProductCategoryEventId stateEventId = new ProductCategoryEventId(this.state.getProductCategoryId(), version);
        ProductCategoryEvent.ProductCategoryStateMergePatched e = newProductCategoryStateMergePatched(stateEventId);
        ((AbstractProductCategoryEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ProductCategoryEvent.ProductCategoryStateDeleted newProductCategoryStateDeleted(Long version, String commandId, String requesterId) {
        ProductCategoryEventId stateEventId = new ProductCategoryEventId(this.state.getProductCategoryId(), version);
        ProductCategoryEvent.ProductCategoryStateDeleted e = newProductCategoryStateDeleted(stateEventId);
        ((AbstractProductCategoryEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ProductCategoryEvent.ProductCategoryStateCreated newProductCategoryStateCreated(ProductCategoryEventId stateEventId) {
        return new AbstractProductCategoryEvent.SimpleProductCategoryStateCreated(stateEventId);
    }

    protected ProductCategoryEvent.ProductCategoryStateMergePatched newProductCategoryStateMergePatched(ProductCategoryEventId stateEventId) {
        return new AbstractProductCategoryEvent.SimpleProductCategoryStateMergePatched(stateEventId);
    }

    protected ProductCategoryEvent.ProductCategoryStateDeleted newProductCategoryStateDeleted(ProductCategoryEventId stateEventId)
    {
        return new AbstractProductCategoryEvent.SimpleProductCategoryStateDeleted(stateEventId);
    }

    public static class SimpleProductCategoryAggregate extends AbstractProductCategoryAggregate
    {
        public SimpleProductCategoryAggregate(ProductCategoryState state) {
            super(state);
        }

    }

}

