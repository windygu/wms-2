package org.dddml.wms.domain.inoutlinemvo;

import java.util.*;
import org.dddml.wms.domain.inout.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractInOutLineMvoStateCommandConverter<TCreateInOutLineMvo extends InOutLineMvoCommand.CreateInOutLineMvo, TMergePatchInOutLineMvo extends InOutLineMvoCommand.MergePatchInOutLineMvo, TDeleteInOutLineMvo extends InOutLineMvoCommand.DeleteInOutLineMvo>
{
    public InOutLineMvoCommand toCreateOrMergePatchInOutLineMvo(InOutLineMvoState state)
    {
        //where TCreateInOutLineMvo : ICreateInOutLineMvo, new()
        //where TMergePatchInOutLineMvo : IMergePatchInOutLineMvo, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateInOutLineMvo(state);
        }
        else 
        {
            return toMergePatchInOutLineMvo(state);
        }
    }

    public TDeleteInOutLineMvo toDeleteInOutLineMvo(InOutLineMvoState state) //where TDeleteInOutLineMvo : IDeleteInOutLineMvo, new()
    {
        TDeleteInOutLineMvo cmd = newDeleteInOutLineMvo();
        cmd.setInOutLineId(state.getInOutLineId());
        cmd.setInOutVersion(state.getInOutVersion());

        return cmd;
    }

    public TMergePatchInOutLineMvo toMergePatchInOutLineMvo(InOutLineMvoState state) //where TMergePatchInOutLineMvo : IMergePatchInOutLineMvo, new()
    {
        TMergePatchInOutLineMvo cmd = newMergePatchInOutLineMvo();

        cmd.setInOutVersion(state.getInOutVersion());

        cmd.setInOutLineId(state.getInOutLineId());
        cmd.setLocatorId(state.getLocatorId());
        cmd.setProductId(state.getProductId());
        cmd.setAttributeSetInstanceId(state.getAttributeSetInstanceId());
        cmd.setDescription(state.getDescription());
        cmd.setQuantityUomId(state.getQuantityUomId());
        cmd.setMovementQuantity(state.getMovementQuantity());
        cmd.setPickedQuantity(state.getPickedQuantity());
        cmd.setIsInvoiced(state.getIsInvoiced());
        cmd.setProcessed(state.getProcessed());
        cmd.setRmaLineNumber(state.getRmaLineNumber());
        cmd.setReversalLineNumber(state.getReversalLineNumber());
        cmd.setVersion(state.getVersion());
        cmd.setActive(state.getActive());
        cmd.setInOutPosted(state.getInOutPosted());
        cmd.setInOutProcessed(state.getInOutProcessed());
        cmd.setInOutProcessing(state.getInOutProcessing());
        cmd.setInOutDocumentTypeId(state.getInOutDocumentTypeId());
        cmd.setInOutDescription(state.getInOutDescription());
        cmd.setInOutOrderId(state.getInOutOrderId());
        cmd.setInOutDateOrdered(state.getInOutDateOrdered());
        cmd.setInOutIsPrinted(state.getInOutIsPrinted());
        cmd.setInOutMovementTypeId(state.getInOutMovementTypeId());
        cmd.setInOutMovementDate(state.getInOutMovementDate());
        cmd.setInOutBusinessPartnerId(state.getInOutBusinessPartnerId());
        cmd.setInOutWarehouseId(state.getInOutWarehouseId());
        cmd.setInOutPOReference(state.getInOutPOReference());
        cmd.setInOutFreightAmount(state.getInOutFreightAmount());
        cmd.setInOutShipperId(state.getInOutShipperId());
        cmd.setInOutChargeAmount(state.getInOutChargeAmount());
        cmd.setInOutDatePrinted(state.getInOutDatePrinted());
        cmd.setInOutCreatedFrom(state.getInOutCreatedFrom());
        cmd.setInOutSalesRepresentativeId(state.getInOutSalesRepresentativeId());
        cmd.setInOutNumberOfPackages(state.getInOutNumberOfPackages());
        cmd.setInOutPickDate(state.getInOutPickDate());
        cmd.setInOutShipDate(state.getInOutShipDate());
        cmd.setInOutTrackingNumber(state.getInOutTrackingNumber());
        cmd.setInOutDateReceived(state.getInOutDateReceived());
        cmd.setInOutIsInTransit(state.getInOutIsInTransit());
        cmd.setInOutIsApproved(state.getInOutIsApproved());
        cmd.setInOutIsInDispute(state.getInOutIsInDispute());
        cmd.setInOutRmaDocumentNumber(state.getInOutRmaDocumentNumber());
        cmd.setInOutReversalDocumentNumber(state.getInOutReversalDocumentNumber());
        cmd.setInOutCreatedBy(state.getInOutCreatedBy());
        cmd.setInOutCreatedAt(state.getInOutCreatedAt());
        cmd.setInOutUpdatedBy(state.getInOutUpdatedBy());
        cmd.setInOutUpdatedAt(state.getInOutUpdatedAt());
        cmd.setInOutActive(state.getInOutActive());
        cmd.setInOutDeleted(state.getInOutDeleted());
            
        if (state.getLocatorId() == null) { cmd.setIsPropertyLocatorIdRemoved(true); }
        if (state.getProductId() == null) { cmd.setIsPropertyProductIdRemoved(true); }
        if (state.getAttributeSetInstanceId() == null) { cmd.setIsPropertyAttributeSetInstanceIdRemoved(true); }
        if (state.getDescription() == null) { cmd.setIsPropertyDescriptionRemoved(true); }
        if (state.getQuantityUomId() == null) { cmd.setIsPropertyQuantityUomIdRemoved(true); }
        if (state.getMovementQuantity() == null) { cmd.setIsPropertyMovementQuantityRemoved(true); }
        if (state.getPickedQuantity() == null) { cmd.setIsPropertyPickedQuantityRemoved(true); }
        if (state.getIsInvoiced() == null) { cmd.setIsPropertyIsInvoicedRemoved(true); }
        if (state.getProcessed() == null) { cmd.setIsPropertyProcessedRemoved(true); }
        if (state.getRmaLineNumber() == null) { cmd.setIsPropertyRmaLineNumberRemoved(true); }
        if (state.getReversalLineNumber() == null) { cmd.setIsPropertyReversalLineNumberRemoved(true); }
        if (state.getVersion() == null) { cmd.setIsPropertyVersionRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        if (state.getInOutPosted() == null) { cmd.setIsPropertyInOutPostedRemoved(true); }
        if (state.getInOutProcessed() == null) { cmd.setIsPropertyInOutProcessedRemoved(true); }
        if (state.getInOutProcessing() == null) { cmd.setIsPropertyInOutProcessingRemoved(true); }
        if (state.getInOutDocumentTypeId() == null) { cmd.setIsPropertyInOutDocumentTypeIdRemoved(true); }
        if (state.getInOutDescription() == null) { cmd.setIsPropertyInOutDescriptionRemoved(true); }
        if (state.getInOutOrderId() == null) { cmd.setIsPropertyInOutOrderIdRemoved(true); }
        if (state.getInOutDateOrdered() == null) { cmd.setIsPropertyInOutDateOrderedRemoved(true); }
        if (state.getInOutIsPrinted() == null) { cmd.setIsPropertyInOutIsPrintedRemoved(true); }
        if (state.getInOutMovementTypeId() == null) { cmd.setIsPropertyInOutMovementTypeIdRemoved(true); }
        if (state.getInOutMovementDate() == null) { cmd.setIsPropertyInOutMovementDateRemoved(true); }
        if (state.getInOutBusinessPartnerId() == null) { cmd.setIsPropertyInOutBusinessPartnerIdRemoved(true); }
        if (state.getInOutWarehouseId() == null) { cmd.setIsPropertyInOutWarehouseIdRemoved(true); }
        if (state.getInOutPOReference() == null) { cmd.setIsPropertyInOutPOReferenceRemoved(true); }
        if (state.getInOutFreightAmount() == null) { cmd.setIsPropertyInOutFreightAmountRemoved(true); }
        if (state.getInOutShipperId() == null) { cmd.setIsPropertyInOutShipperIdRemoved(true); }
        if (state.getInOutChargeAmount() == null) { cmd.setIsPropertyInOutChargeAmountRemoved(true); }
        if (state.getInOutDatePrinted() == null) { cmd.setIsPropertyInOutDatePrintedRemoved(true); }
        if (state.getInOutCreatedFrom() == null) { cmd.setIsPropertyInOutCreatedFromRemoved(true); }
        if (state.getInOutSalesRepresentativeId() == null) { cmd.setIsPropertyInOutSalesRepresentativeIdRemoved(true); }
        if (state.getInOutNumberOfPackages() == null) { cmd.setIsPropertyInOutNumberOfPackagesRemoved(true); }
        if (state.getInOutPickDate() == null) { cmd.setIsPropertyInOutPickDateRemoved(true); }
        if (state.getInOutShipDate() == null) { cmd.setIsPropertyInOutShipDateRemoved(true); }
        if (state.getInOutTrackingNumber() == null) { cmd.setIsPropertyInOutTrackingNumberRemoved(true); }
        if (state.getInOutDateReceived() == null) { cmd.setIsPropertyInOutDateReceivedRemoved(true); }
        if (state.getInOutIsInTransit() == null) { cmd.setIsPropertyInOutIsInTransitRemoved(true); }
        if (state.getInOutIsApproved() == null) { cmd.setIsPropertyInOutIsApprovedRemoved(true); }
        if (state.getInOutIsInDispute() == null) { cmd.setIsPropertyInOutIsInDisputeRemoved(true); }
        if (state.getInOutRmaDocumentNumber() == null) { cmd.setIsPropertyInOutRmaDocumentNumberRemoved(true); }
        if (state.getInOutReversalDocumentNumber() == null) { cmd.setIsPropertyInOutReversalDocumentNumberRemoved(true); }
        if (state.getInOutCreatedBy() == null) { cmd.setIsPropertyInOutCreatedByRemoved(true); }
        if (state.getInOutCreatedAt() == null) { cmd.setIsPropertyInOutCreatedAtRemoved(true); }
        if (state.getInOutUpdatedBy() == null) { cmd.setIsPropertyInOutUpdatedByRemoved(true); }
        if (state.getInOutUpdatedAt() == null) { cmd.setIsPropertyInOutUpdatedAtRemoved(true); }
        if (state.getInOutActive() == null) { cmd.setIsPropertyInOutActiveRemoved(true); }
        if (state.getInOutDeleted() == null) { cmd.setIsPropertyInOutDeletedRemoved(true); }
        return cmd;
    }

    public TCreateInOutLineMvo toCreateInOutLineMvo(InOutLineMvoState state) //where TCreateInOutLineMvo : ICreateInOutLineMvo, new()
    {
        TCreateInOutLineMvo cmd = newCreateInOutLineMvo();

        cmd.setInOutVersion(state.getInOutVersion());
        cmd.setInOutLineId(state.getInOutLineId());
        cmd.setLocatorId(state.getLocatorId());
        cmd.setProductId(state.getProductId());
        cmd.setAttributeSetInstanceId(state.getAttributeSetInstanceId());
        cmd.setDescription(state.getDescription());
        cmd.setQuantityUomId(state.getQuantityUomId());
        cmd.setMovementQuantity(state.getMovementQuantity());
        cmd.setPickedQuantity(state.getPickedQuantity());
        cmd.setIsInvoiced(state.getIsInvoiced());
        cmd.setProcessed(state.getProcessed());
        cmd.setRmaLineNumber(state.getRmaLineNumber());
        cmd.setReversalLineNumber(state.getReversalLineNumber());
        cmd.setVersion(state.getVersion());
        cmd.setActive(state.getActive());
        cmd.setInOutPosted(state.getInOutPosted());
        cmd.setInOutProcessed(state.getInOutProcessed());
        cmd.setInOutProcessing(state.getInOutProcessing());
        cmd.setInOutDocumentTypeId(state.getInOutDocumentTypeId());
        cmd.setInOutDescription(state.getInOutDescription());
        cmd.setInOutOrderId(state.getInOutOrderId());
        cmd.setInOutDateOrdered(state.getInOutDateOrdered());
        cmd.setInOutIsPrinted(state.getInOutIsPrinted());
        cmd.setInOutMovementTypeId(state.getInOutMovementTypeId());
        cmd.setInOutMovementDate(state.getInOutMovementDate());
        cmd.setInOutBusinessPartnerId(state.getInOutBusinessPartnerId());
        cmd.setInOutWarehouseId(state.getInOutWarehouseId());
        cmd.setInOutPOReference(state.getInOutPOReference());
        cmd.setInOutFreightAmount(state.getInOutFreightAmount());
        cmd.setInOutShipperId(state.getInOutShipperId());
        cmd.setInOutChargeAmount(state.getInOutChargeAmount());
        cmd.setInOutDatePrinted(state.getInOutDatePrinted());
        cmd.setInOutCreatedFrom(state.getInOutCreatedFrom());
        cmd.setInOutSalesRepresentativeId(state.getInOutSalesRepresentativeId());
        cmd.setInOutNumberOfPackages(state.getInOutNumberOfPackages());
        cmd.setInOutPickDate(state.getInOutPickDate());
        cmd.setInOutShipDate(state.getInOutShipDate());
        cmd.setInOutTrackingNumber(state.getInOutTrackingNumber());
        cmd.setInOutDateReceived(state.getInOutDateReceived());
        cmd.setInOutIsInTransit(state.getInOutIsInTransit());
        cmd.setInOutIsApproved(state.getInOutIsApproved());
        cmd.setInOutIsInDispute(state.getInOutIsInDispute());
        cmd.setInOutRmaDocumentNumber(state.getInOutRmaDocumentNumber());
        cmd.setInOutReversalDocumentNumber(state.getInOutReversalDocumentNumber());
        cmd.setInOutCreatedBy(state.getInOutCreatedBy());
        cmd.setInOutCreatedAt(state.getInOutCreatedAt());
        cmd.setInOutUpdatedBy(state.getInOutUpdatedBy());
        cmd.setInOutUpdatedAt(state.getInOutUpdatedAt());
        cmd.setInOutActive(state.getInOutActive());
        cmd.setInOutDeleted(state.getInOutDeleted());
        return cmd;
    }

    protected abstract TCreateInOutLineMvo newCreateInOutLineMvo();

    protected abstract TMergePatchInOutLineMvo newMergePatchInOutLineMvo(); 

    protected abstract TDeleteInOutLineMvo newDeleteInOutLineMvo();

    public static class SimpleInOutLineMvoStateCommandConverter extends AbstractInOutLineMvoStateCommandConverter<AbstractInOutLineMvoCommand.SimpleCreateInOutLineMvo, AbstractInOutLineMvoCommand.SimpleMergePatchInOutLineMvo, AbstractInOutLineMvoCommand.SimpleDeleteInOutLineMvo>
    {
        @Override
        protected AbstractInOutLineMvoCommand.SimpleCreateInOutLineMvo newCreateInOutLineMvo() {
            return new AbstractInOutLineMvoCommand.SimpleCreateInOutLineMvo();
        }

        @Override
        protected AbstractInOutLineMvoCommand.SimpleMergePatchInOutLineMvo newMergePatchInOutLineMvo() {
            return new AbstractInOutLineMvoCommand.SimpleMergePatchInOutLineMvo();
        }

        @Override
        protected AbstractInOutLineMvoCommand.SimpleDeleteInOutLineMvo newDeleteInOutLineMvo() {
            return new AbstractInOutLineMvoCommand.SimpleDeleteInOutLineMvo();
        }


    }

}

