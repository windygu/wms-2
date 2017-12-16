package org.dddml.wms.domain.orderheader;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractOrderHeaderStateCommandConverter<TCreateOrderHeader extends OrderHeaderCommand.CreateOrderHeader, TMergePatchOrderHeader extends OrderHeaderCommand.MergePatchOrderHeader, TDeleteOrderHeader extends OrderHeaderCommand.DeleteOrderHeader>
{
    public OrderHeaderCommand toCreateOrMergePatchOrderHeader(OrderHeaderState state)
    {
        //where TCreateOrderHeader : ICreateOrderHeader, new()
        //where TMergePatchOrderHeader : IMergePatchOrderHeader, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateOrderHeader(state);
        }
        else 
        {
            return toMergePatchOrderHeader(state);
        }
    }

    public TDeleteOrderHeader toDeleteOrderHeader(OrderHeaderState state) //where TDeleteOrderHeader : IDeleteOrderHeader, new()
    {
        TDeleteOrderHeader cmd = newDeleteOrderHeader();
        cmd.setOrderId(state.getOrderId());
        cmd.setVersion(state.getVersion());

        return cmd;
    }

    public TMergePatchOrderHeader toMergePatchOrderHeader(OrderHeaderState state) //where TMergePatchOrderHeader : IMergePatchOrderHeader, new()
    {
        TMergePatchOrderHeader cmd = newMergePatchOrderHeader();

        cmd.setVersion(state.getVersion());

        cmd.setOrderId(state.getOrderId());
        cmd.setOrderTypeId(state.getOrderTypeId());
        cmd.setOrderName(state.getOrderName());
        cmd.setExternalId(state.getExternalId());
        cmd.setSalesChannelEnumId(state.getSalesChannelEnumId());
        cmd.setOrderDate(state.getOrderDate());
        cmd.setPriority(state.getPriority());
        cmd.setEntryDate(state.getEntryDate());
        cmd.setPickSheetPrintedDate(state.getPickSheetPrintedDate());
        cmd.setCurrencyUom(state.getCurrencyUom());
        cmd.setSyncStatusId(state.getSyncStatusId());
        cmd.setBillingAccountId(state.getBillingAccountId());
        cmd.setOriginFacilityId(state.getOriginFacilityId());
        cmd.setWebSiteId(state.getWebSiteId());
        cmd.setProductStoreId(state.getProductStoreId());
        cmd.setTerminalId(state.getTerminalId());
        cmd.setTransactionId(state.getTransactionId());
        cmd.setAutoOrderShoppingListId(state.getAutoOrderShoppingListId());
        cmd.setNeedsInventoryIssuance(state.getNeedsInventoryIssuance());
        cmd.setIsRushOrder(state.getIsRushOrder());
        cmd.setInternalCode(state.getInternalCode());
        cmd.setRemainingSubTotal(state.getRemainingSubTotal());
        cmd.setGrandTotal(state.getGrandTotal());
        cmd.setInvoicePerShipment(state.getInvoicePerShipment());
        cmd.setActive(state.getActive());
            
        if (state.getOrderTypeId() == null) { cmd.setIsPropertyOrderTypeIdRemoved(true); }
        if (state.getOrderName() == null) { cmd.setIsPropertyOrderNameRemoved(true); }
        if (state.getExternalId() == null) { cmd.setIsPropertyExternalIdRemoved(true); }
        if (state.getSalesChannelEnumId() == null) { cmd.setIsPropertySalesChannelEnumIdRemoved(true); }
        if (state.getOrderDate() == null) { cmd.setIsPropertyOrderDateRemoved(true); }
        if (state.getPriority() == null) { cmd.setIsPropertyPriorityRemoved(true); }
        if (state.getEntryDate() == null) { cmd.setIsPropertyEntryDateRemoved(true); }
        if (state.getPickSheetPrintedDate() == null) { cmd.setIsPropertyPickSheetPrintedDateRemoved(true); }
        if (state.getCurrencyUom() == null) { cmd.setIsPropertyCurrencyUomRemoved(true); }
        if (state.getSyncStatusId() == null) { cmd.setIsPropertySyncStatusIdRemoved(true); }
        if (state.getBillingAccountId() == null) { cmd.setIsPropertyBillingAccountIdRemoved(true); }
        if (state.getOriginFacilityId() == null) { cmd.setIsPropertyOriginFacilityIdRemoved(true); }
        if (state.getWebSiteId() == null) { cmd.setIsPropertyWebSiteIdRemoved(true); }
        if (state.getProductStoreId() == null) { cmd.setIsPropertyProductStoreIdRemoved(true); }
        if (state.getTerminalId() == null) { cmd.setIsPropertyTerminalIdRemoved(true); }
        if (state.getTransactionId() == null) { cmd.setIsPropertyTransactionIdRemoved(true); }
        if (state.getAutoOrderShoppingListId() == null) { cmd.setIsPropertyAutoOrderShoppingListIdRemoved(true); }
        if (state.getNeedsInventoryIssuance() == null) { cmd.setIsPropertyNeedsInventoryIssuanceRemoved(true); }
        if (state.getIsRushOrder() == null) { cmd.setIsPropertyIsRushOrderRemoved(true); }
        if (state.getInternalCode() == null) { cmd.setIsPropertyInternalCodeRemoved(true); }
        if (state.getRemainingSubTotal() == null) { cmd.setIsPropertyRemainingSubTotalRemoved(true); }
        if (state.getGrandTotal() == null) { cmd.setIsPropertyGrandTotalRemoved(true); }
        if (state.getInvoicePerShipment() == null) { cmd.setIsPropertyInvoicePerShipmentRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        return cmd;
    }

    public TCreateOrderHeader toCreateOrderHeader(OrderHeaderState state) //where TCreateOrderHeader : ICreateOrderHeader, new()
    {
        TCreateOrderHeader cmd = newCreateOrderHeader();

        cmd.setVersion(state.getVersion());
        cmd.setOrderId(state.getOrderId());
        cmd.setOrderTypeId(state.getOrderTypeId());
        cmd.setOrderName(state.getOrderName());
        cmd.setExternalId(state.getExternalId());
        cmd.setSalesChannelEnumId(state.getSalesChannelEnumId());
        cmd.setOrderDate(state.getOrderDate());
        cmd.setPriority(state.getPriority());
        cmd.setEntryDate(state.getEntryDate());
        cmd.setPickSheetPrintedDate(state.getPickSheetPrintedDate());
        cmd.setCurrencyUom(state.getCurrencyUom());
        cmd.setSyncStatusId(state.getSyncStatusId());
        cmd.setBillingAccountId(state.getBillingAccountId());
        cmd.setOriginFacilityId(state.getOriginFacilityId());
        cmd.setWebSiteId(state.getWebSiteId());
        cmd.setProductStoreId(state.getProductStoreId());
        cmd.setTerminalId(state.getTerminalId());
        cmd.setTransactionId(state.getTransactionId());
        cmd.setAutoOrderShoppingListId(state.getAutoOrderShoppingListId());
        cmd.setNeedsInventoryIssuance(state.getNeedsInventoryIssuance());
        cmd.setIsRushOrder(state.getIsRushOrder());
        cmd.setInternalCode(state.getInternalCode());
        cmd.setRemainingSubTotal(state.getRemainingSubTotal());
        cmd.setGrandTotal(state.getGrandTotal());
        cmd.setInvoicePerShipment(state.getInvoicePerShipment());
        cmd.setActive(state.getActive());
        return cmd;
    }

    protected abstract TCreateOrderHeader newCreateOrderHeader();

    protected abstract TMergePatchOrderHeader newMergePatchOrderHeader(); 

    protected abstract TDeleteOrderHeader newDeleteOrderHeader();

    public static class SimpleOrderHeaderStateCommandConverter extends AbstractOrderHeaderStateCommandConverter<AbstractOrderHeaderCommand.SimpleCreateOrderHeader, AbstractOrderHeaderCommand.SimpleMergePatchOrderHeader, AbstractOrderHeaderCommand.SimpleDeleteOrderHeader>
    {
        @Override
        protected AbstractOrderHeaderCommand.SimpleCreateOrderHeader newCreateOrderHeader() {
            return new AbstractOrderHeaderCommand.SimpleCreateOrderHeader();
        }

        @Override
        protected AbstractOrderHeaderCommand.SimpleMergePatchOrderHeader newMergePatchOrderHeader() {
            return new AbstractOrderHeaderCommand.SimpleMergePatchOrderHeader();
        }

        @Override
        protected AbstractOrderHeaderCommand.SimpleDeleteOrderHeader newDeleteOrderHeader() {
            return new AbstractOrderHeaderCommand.SimpleDeleteOrderHeader();
        }


    }

}

