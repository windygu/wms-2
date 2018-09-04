package org.dddml.wms.domain.physicalinventory;

import org.dddml.wms.domain.attributesetinstance.AttributeSetInstanceApplicationService;
import org.dddml.wms.domain.attributesetinstance.AttributeSetInstanceState;
import org.dddml.wms.domain.attributesetinstance.AttributeSetInstanceUtils;
import org.dddml.wms.domain.inventoryitem.InventoryItemApplicationService;
import org.dddml.wms.domain.inventoryitem.InventoryItemId;
import org.dddml.wms.domain.inventoryitem.InventoryItemIds;
import org.dddml.wms.domain.inventoryitem.InventoryItemState;
import org.dddml.wms.domain.product.ProductApplicationService;
import org.dddml.wms.domain.product.ProductState;
import org.dddml.wms.domain.service.AttributeSetService;
import org.dddml.wms.specialization.ApplicationContext;
import org.dddml.wms.specialization.EventStore;
import org.dddml.wms.specialization.IdGenerator;
import org.dddml.wms.specialization.hibernate.TableIdGenerator;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yangjiefeng on 2018/9/3.
 */
public class PhysicalInventoryApplicationServiceImpl extends AbstractPhysicalInventoryApplicationService.SimplePhysicalInventoryApplicationService {

    static final String ATTRIBUTE_SET_INSTANCE_ID_KEY = "attributeSetInstanceId";

    InventoryItemQueryService getInventoryItemQueryService() {
        return (InventoryItemQueryService) ApplicationContext.current.get("inventoryItemQueryService");
    }

    ProductApplicationService getProductApplicationService() {
        return (ProductApplicationService) ApplicationContext.current.get("productApplicationService");
    }

    AttributeSetInstanceApplicationService getAttributeSetInstanceApplicationService() {
        return (AttributeSetInstanceApplicationService) ApplicationContext.current.get("attributeSetInstanceApplicationService");
    }

    AttributeSetService getAttributeSetService() {
        return (AttributeSetService) ApplicationContext.current.get("attributeSetService");
    }

    InventoryItemApplicationService getInventoryItemApplicationService() {
        return (InventoryItemApplicationService) ApplicationContext.current.get("inventoryItemApplicationService");
    }

    private IdGenerator<Long, Object, Object> seqIdGenerator = new TableIdGenerator();

    public IdGenerator<Long, Object, Object> getSeqIdGenerator() {
        return seqIdGenerator;
    }

    public void setSeqIdGenerator(IdGenerator<Long, Object, Object> seqIdGenerator) {
        this.seqIdGenerator = seqIdGenerator;
    }

    public PhysicalInventoryApplicationServiceImpl(EventStore eventStore, PhysicalInventoryStateRepository stateRepository, PhysicalInventoryStateQueryRepository stateQueryRepository) {
        super(eventStore, stateRepository, stateQueryRepository);
    }

    @Override
    public void when(PhysicalInventoryCommand.CreatePhysicalInventory c) {
        if (c.getWarehouseId() == null || c.getWarehouseId().isEmpty()) {
            throw new IllegalArgumentException("warehosueId is null");
        }
        if (c.getLocatorIdPattern() != null || c.getProductIdPattern() != null) {
            List<InventoryItemState> inventoryItems = getInventoryItemQueryService()
                    .getInventoryItems(c.getWarehouseId(), c.getLocatorIdPattern(), c.getProductIdPattern());
            for (InventoryItemState ii : inventoryItems) {
                PhysicalInventoryLineCommand.CreatePhysicalInventoryLine createPhysicalInventoryLine = new AbstractPhysicalInventoryLineCommand.SimpleCreatePhysicalInventoryLine();
                InventoryItemId inventoryItemId = ii.getInventoryItemId();
                createPhysicalInventoryLine.setInventoryItemId(inventoryItemId);
                createPhysicalInventoryLine.setBookQuantity(ii.getOnHandQuantity());//todo ???
                createPhysicalInventoryLine.setLineNumber(getSeqIdGenerator().getNextId().toString());
                createPhysicalInventoryLine.setActive(true);
                c.getPhysicalInventoryLines().add(createPhysicalInventoryLine);
            }
        }
        super.when(c);
    }

    @Transactional
    @Override
    public void when(PhysicalInventoryCommands.CountItem c) {
        Map<String, Object> attributeSetInstance = new HashMap<>(c.getAttributeSetInstance());
        String attributeSetInstanceId = (String) attributeSetInstance.get(ATTRIBUTE_SET_INSTANCE_ID_KEY);
        ProductState productState = getProductState(c.getProductId());
        if (attributeSetInstanceId == null || attributeSetInstanceId.trim().isEmpty()) {
            attributeSetInstance.remove(ATTRIBUTE_SET_INSTANCE_ID_KEY);
            if (attributeSetInstance.size() > 0) {
                attributeSetInstanceId = AttributeSetInstanceUtils.createAttributeSetInstance(
                        getAttributeSetService(), getAttributeSetInstanceApplicationService(),
                        productState.getAttributeSetId(), attributeSetInstance);
            }
        } else {
            AttributeSetInstanceState attrSetInstState = getAttributeSetInstanceApplicationService().get(attributeSetInstanceId);
            if (attrSetInstState == null) {
                throw new NullPointerException(
                        String.format("AttributeSetInstanceState NOT found. AttributeSetInstanceState Id.: %1$s",
                                attributeSetInstanceId));
            }
        }
        String notNullAttrSetInstId = (attributeSetInstanceId == null || attributeSetInstanceId.isEmpty())
                ? InventoryItemIds.EMPTY_ATTRIBUTE_SET_INSTANCE_ID : attributeSetInstanceId;
        attributeSetInstance.put(ATTRIBUTE_SET_INSTANCE_ID_KEY, notNullAttrSetInstId);
        c.setAttributeSetInstance(attributeSetInstance);
        super.when(c);
    }

    private ProductState getProductState(String productId) {
        ProductState prdState = getProductApplicationService().get(productId);
        if (prdState == null) {
            throw new IllegalArgumentException(String.format("Product NOT found. Product Id.: %1$s", productId));
        }
        return prdState;
    }

    public PhysicalInventoryAggregate getPhysicalInventoryAggregate(PhysicalInventoryState state)
    {
        return new PhysicalInventoryAggregateImpl(state);
    }

    public class PhysicalInventoryAggregateImpl extends AbstractPhysicalInventoryAggregate.SimplePhysicalInventoryAggregate {

        public PhysicalInventoryAggregateImpl(PhysicalInventoryState state) {
            super(state);
        }

        @Override
        public void countItem(String locatorId, String productId, java.util.Map<String, Object> attributeSetInstance, BigDecimal countedQuantity, Long version, String commandId, String requesterId) {
            String attributeSetInstanceId = (String) attributeSetInstance.get(ATTRIBUTE_SET_INSTANCE_ID_KEY);
            if (attributeSetInstanceId == null || attributeSetInstanceId.trim().isEmpty()) {
                throw new NullPointerException("The value of 'attributeSetInstanceId' is null.");
            }
            String notNullAttrSetInstId = attributeSetInstanceId;
            InventoryItemId inventoryItemId = new InventoryItemId(productId, locatorId, notNullAttrSetInstId);
            PhysicalInventoryLineState lineState = getState().getPhysicalInventoryLines().get(inventoryItemId, false, true);

            PhysicalInventoryEvent.PhysicalInventoryStateMergePatched e = newPhysicalInventoryStateMergePatched(version, commandId, requesterId);
            if (lineState != null) {
                PhysicalInventoryLineEvent.PhysicalInventoryLineStateMergePatched lineE = e.newPhysicalInventoryLineStateMergePatched(inventoryItemId);
                lineE.setCountedQuantity(countedQuantity);
                e.addPhysicalInventoryLineEvent(lineE);
                apply(e);
            } else {
                PhysicalInventoryLineEvent.PhysicalInventoryLineStateCreated lineE = e.newPhysicalInventoryLineStateCreated(inventoryItemId);
                lineE.setLineNumber(getSeqIdGenerator().getNextId().toString());
                lineE.setCountedQuantity(countedQuantity);
                lineE.setBookQuantity(BigDecimal.valueOf(0));
                e.addPhysicalInventoryLineEvent(lineE);
                apply(e);
            }
        }

    }

}
