package org.dddml.wms.domain.shipment;

import org.dddml.wms.domain.DocumentStatusIds;
import org.dddml.wms.domain.attributesetinstance.AttributeSetInstanceApplicationService;
import org.dddml.wms.domain.inventoryitem.InventoryItemApplicationService;
import org.dddml.wms.domain.product.ProductApplicationService;
import org.dddml.wms.domain.product.ProductState;
import org.dddml.wms.domain.service.AttributeSetService;
import org.dddml.wms.specialization.EventStore;
import org.dddml.wms.specialization.ApplicationContext;
import org.dddml.wms.specialization.IdGenerator;
import org.dddml.wms.specialization.hibernate.TableIdGenerator;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * Created by yangjiefeng on 2018/2/1.
 */
public class ShipmentApplicationServiceImpl extends AbstractShipmentApplicationService.SimpleShipmentApplicationService {

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

    public final IdGenerator<Long, Object, Object> getSeqIdGenerator() {
        return seqIdGenerator;
    }

    public final void setSeqIdGenerator(IdGenerator<Long, Object, Object> value) {
        seqIdGenerator = value;
    }

    public ShipmentApplicationServiceImpl(EventStore eventStore, ShipmentStateRepository stateRepository, ShipmentStateQueryRepository stateQueryRepository) {
        super(eventStore, stateRepository, stateQueryRepository);
    }

    @Override
    @Transactional
    public void when(ShipmentCommands.ConfirmAllItemsReceived c) {
        //todo
        super.when(c);
    }

    @Override
    @Transactional
    public void when(ShipmentCommands.ReceiveItem c) {
        //todo
        super.when(c);
    }

    @Override
    @Transactional
    public void when(ShipmentCommands.Import c) {
        //todo
        super.when(c);
    }

    private ProductState getProductState(String productId) {
        ProductState prdState = getProductApplicationService().get(productId);
        if (prdState == null) {
            throw new IllegalArgumentException(String.format("Product NOT found. Product Id.: %1$s", productId));
        }
        return prdState;
    }

    private ShipmentState assertShipmentStatus(String shipmentId, String status) {
        ShipmentState shipment = getStateRepository().get(shipmentId, true);
        if (shipment == null) {
            throw new IllegalArgumentException(String.format("Error shipment Id.: %1$s", shipmentId));
        } else {
            if (!Objects.equals(shipment.getStatusId().toLowerCase(), status.toLowerCase())) {
                throw new IllegalArgumentException(String.format("Error shipment status: %1$s", shipment.getStatusId()));
            }
        }
        return shipment;
    }

}
