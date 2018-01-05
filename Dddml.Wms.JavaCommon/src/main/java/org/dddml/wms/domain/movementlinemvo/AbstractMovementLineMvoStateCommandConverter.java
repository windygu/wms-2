package org.dddml.wms.domain.movementlinemvo;

import java.util.*;
import org.dddml.wms.domain.movement.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractMovementLineMvoStateCommandConverter<TCreateMovementLineMvo extends MovementLineMvoCommand.CreateMovementLineMvo, TMergePatchMovementLineMvo extends MovementLineMvoCommand.MergePatchMovementLineMvo, TDeleteMovementLineMvo extends MovementLineMvoCommand.DeleteMovementLineMvo>
{
    public MovementLineMvoCommand toCreateOrMergePatchMovementLineMvo(MovementLineMvoState state)
    {
        //where TCreateMovementLineMvo : ICreateMovementLineMvo, new()
        //where TMergePatchMovementLineMvo : IMergePatchMovementLineMvo, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateMovementLineMvo(state);
        }
        else 
        {
            return toMergePatchMovementLineMvo(state);
        }
    }

    public TDeleteMovementLineMvo toDeleteMovementLineMvo(MovementLineMvoState state) //where TDeleteMovementLineMvo : IDeleteMovementLineMvo, new()
    {
        TDeleteMovementLineMvo cmd = newDeleteMovementLineMvo();
        cmd.setMovementLineId(state.getMovementLineId());
        cmd.setMovementVersion(state.getMovementVersion());

        return cmd;
    }

    public TMergePatchMovementLineMvo toMergePatchMovementLineMvo(MovementLineMvoState state) //where TMergePatchMovementLineMvo : IMergePatchMovementLineMvo, new()
    {
        TMergePatchMovementLineMvo cmd = newMergePatchMovementLineMvo();

        cmd.setMovementVersion(state.getMovementVersion());

        cmd.setMovementLineId(state.getMovementLineId());
        cmd.setMovementQuantity(state.getMovementQuantity());
        cmd.setProductId(state.getProductId());
        cmd.setLocatorIdFrom(state.getLocatorIdFrom());
        cmd.setLocatorIdTo(state.getLocatorIdTo());
        cmd.setAttributeSetInstanceId(state.getAttributeSetInstanceId());
        cmd.setProcessed(state.getProcessed());
        cmd.setReversalLineNumber(state.getReversalLineNumber());
        cmd.setVersion(state.getVersion());
        cmd.setActive(state.getActive());
        cmd.setMovementDocumentStatusId(state.getMovementDocumentStatusId());
        cmd.setMovementMovementDate(state.getMovementMovementDate());
        cmd.setMovementPosted(state.getMovementPosted());
        cmd.setMovementProcessed(state.getMovementProcessed());
        cmd.setMovementProcessing(state.getMovementProcessing());
        cmd.setMovementDateReceived(state.getMovementDateReceived());
        cmd.setMovementDocumentTypeId(state.getMovementDocumentTypeId());
        cmd.setMovementIsInTransit(state.getMovementIsInTransit());
        cmd.setMovementIsApproved(state.getMovementIsApproved());
        cmd.setMovementApprovalAmount(state.getMovementApprovalAmount());
        cmd.setMovementShipperId(state.getMovementShipperId());
        cmd.setMovementSalesRepresentativeId(state.getMovementSalesRepresentativeId());
        cmd.setMovementBusinessPartnerId(state.getMovementBusinessPartnerId());
        cmd.setMovementChargeAmount(state.getMovementChargeAmount());
        cmd.setMovementCreateFrom(state.getMovementCreateFrom());
        cmd.setMovementFreightAmount(state.getMovementFreightAmount());
        cmd.setMovementReversalDocumentNumber(state.getMovementReversalDocumentNumber());
        cmd.setMovementWarehouseIdFrom(state.getMovementWarehouseIdFrom());
        cmd.setMovementWarehouseIdTo(state.getMovementWarehouseIdTo());
        cmd.setMovementDescription(state.getMovementDescription());
        cmd.setMovementCreatedBy(state.getMovementCreatedBy());
        cmd.setMovementCreatedAt(state.getMovementCreatedAt());
        cmd.setMovementUpdatedBy(state.getMovementUpdatedBy());
        cmd.setMovementUpdatedAt(state.getMovementUpdatedAt());
        cmd.setMovementActive(state.getMovementActive());
        cmd.setMovementDeleted(state.getMovementDeleted());
            
        if (state.getMovementQuantity() == null) { cmd.setIsPropertyMovementQuantityRemoved(true); }
        if (state.getProductId() == null) { cmd.setIsPropertyProductIdRemoved(true); }
        if (state.getLocatorIdFrom() == null) { cmd.setIsPropertyLocatorIdFromRemoved(true); }
        if (state.getLocatorIdTo() == null) { cmd.setIsPropertyLocatorIdToRemoved(true); }
        if (state.getAttributeSetInstanceId() == null) { cmd.setIsPropertyAttributeSetInstanceIdRemoved(true); }
        if (state.getProcessed() == null) { cmd.setIsPropertyProcessedRemoved(true); }
        if (state.getReversalLineNumber() == null) { cmd.setIsPropertyReversalLineNumberRemoved(true); }
        if (state.getVersion() == null) { cmd.setIsPropertyVersionRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        if (state.getMovementDocumentStatusId() == null) { cmd.setIsPropertyMovementDocumentStatusIdRemoved(true); }
        if (state.getMovementMovementDate() == null) { cmd.setIsPropertyMovementMovementDateRemoved(true); }
        if (state.getMovementPosted() == null) { cmd.setIsPropertyMovementPostedRemoved(true); }
        if (state.getMovementProcessed() == null) { cmd.setIsPropertyMovementProcessedRemoved(true); }
        if (state.getMovementProcessing() == null) { cmd.setIsPropertyMovementProcessingRemoved(true); }
        if (state.getMovementDateReceived() == null) { cmd.setIsPropertyMovementDateReceivedRemoved(true); }
        if (state.getMovementDocumentTypeId() == null) { cmd.setIsPropertyMovementDocumentTypeIdRemoved(true); }
        if (state.getMovementIsInTransit() == null) { cmd.setIsPropertyMovementIsInTransitRemoved(true); }
        if (state.getMovementIsApproved() == null) { cmd.setIsPropertyMovementIsApprovedRemoved(true); }
        if (state.getMovementApprovalAmount() == null) { cmd.setIsPropertyMovementApprovalAmountRemoved(true); }
        if (state.getMovementShipperId() == null) { cmd.setIsPropertyMovementShipperIdRemoved(true); }
        if (state.getMovementSalesRepresentativeId() == null) { cmd.setIsPropertyMovementSalesRepresentativeIdRemoved(true); }
        if (state.getMovementBusinessPartnerId() == null) { cmd.setIsPropertyMovementBusinessPartnerIdRemoved(true); }
        if (state.getMovementChargeAmount() == null) { cmd.setIsPropertyMovementChargeAmountRemoved(true); }
        if (state.getMovementCreateFrom() == null) { cmd.setIsPropertyMovementCreateFromRemoved(true); }
        if (state.getMovementFreightAmount() == null) { cmd.setIsPropertyMovementFreightAmountRemoved(true); }
        if (state.getMovementReversalDocumentNumber() == null) { cmd.setIsPropertyMovementReversalDocumentNumberRemoved(true); }
        if (state.getMovementWarehouseIdFrom() == null) { cmd.setIsPropertyMovementWarehouseIdFromRemoved(true); }
        if (state.getMovementWarehouseIdTo() == null) { cmd.setIsPropertyMovementWarehouseIdToRemoved(true); }
        if (state.getMovementDescription() == null) { cmd.setIsPropertyMovementDescriptionRemoved(true); }
        if (state.getMovementCreatedBy() == null) { cmd.setIsPropertyMovementCreatedByRemoved(true); }
        if (state.getMovementCreatedAt() == null) { cmd.setIsPropertyMovementCreatedAtRemoved(true); }
        if (state.getMovementUpdatedBy() == null) { cmd.setIsPropertyMovementUpdatedByRemoved(true); }
        if (state.getMovementUpdatedAt() == null) { cmd.setIsPropertyMovementUpdatedAtRemoved(true); }
        if (state.getMovementActive() == null) { cmd.setIsPropertyMovementActiveRemoved(true); }
        if (state.getMovementDeleted() == null) { cmd.setIsPropertyMovementDeletedRemoved(true); }
        return cmd;
    }

    public TCreateMovementLineMvo toCreateMovementLineMvo(MovementLineMvoState state) //where TCreateMovementLineMvo : ICreateMovementLineMvo, new()
    {
        TCreateMovementLineMvo cmd = newCreateMovementLineMvo();

        cmd.setMovementVersion(state.getMovementVersion());
        cmd.setMovementLineId(state.getMovementLineId());
        cmd.setMovementQuantity(state.getMovementQuantity());
        cmd.setProductId(state.getProductId());
        cmd.setLocatorIdFrom(state.getLocatorIdFrom());
        cmd.setLocatorIdTo(state.getLocatorIdTo());
        cmd.setAttributeSetInstanceId(state.getAttributeSetInstanceId());
        cmd.setProcessed(state.getProcessed());
        cmd.setReversalLineNumber(state.getReversalLineNumber());
        cmd.setVersion(state.getVersion());
        cmd.setActive(state.getActive());
        cmd.setMovementDocumentStatusId(state.getMovementDocumentStatusId());
        cmd.setMovementMovementDate(state.getMovementMovementDate());
        cmd.setMovementPosted(state.getMovementPosted());
        cmd.setMovementProcessed(state.getMovementProcessed());
        cmd.setMovementProcessing(state.getMovementProcessing());
        cmd.setMovementDateReceived(state.getMovementDateReceived());
        cmd.setMovementDocumentTypeId(state.getMovementDocumentTypeId());
        cmd.setMovementIsInTransit(state.getMovementIsInTransit());
        cmd.setMovementIsApproved(state.getMovementIsApproved());
        cmd.setMovementApprovalAmount(state.getMovementApprovalAmount());
        cmd.setMovementShipperId(state.getMovementShipperId());
        cmd.setMovementSalesRepresentativeId(state.getMovementSalesRepresentativeId());
        cmd.setMovementBusinessPartnerId(state.getMovementBusinessPartnerId());
        cmd.setMovementChargeAmount(state.getMovementChargeAmount());
        cmd.setMovementCreateFrom(state.getMovementCreateFrom());
        cmd.setMovementFreightAmount(state.getMovementFreightAmount());
        cmd.setMovementReversalDocumentNumber(state.getMovementReversalDocumentNumber());
        cmd.setMovementWarehouseIdFrom(state.getMovementWarehouseIdFrom());
        cmd.setMovementWarehouseIdTo(state.getMovementWarehouseIdTo());
        cmd.setMovementDescription(state.getMovementDescription());
        cmd.setMovementCreatedBy(state.getMovementCreatedBy());
        cmd.setMovementCreatedAt(state.getMovementCreatedAt());
        cmd.setMovementUpdatedBy(state.getMovementUpdatedBy());
        cmd.setMovementUpdatedAt(state.getMovementUpdatedAt());
        cmd.setMovementActive(state.getMovementActive());
        cmd.setMovementDeleted(state.getMovementDeleted());
        return cmd;
    }

    protected abstract TCreateMovementLineMvo newCreateMovementLineMvo();

    protected abstract TMergePatchMovementLineMvo newMergePatchMovementLineMvo(); 

    protected abstract TDeleteMovementLineMvo newDeleteMovementLineMvo();

    public static class SimpleMovementLineMvoStateCommandConverter extends AbstractMovementLineMvoStateCommandConverter<AbstractMovementLineMvoCommand.SimpleCreateMovementLineMvo, AbstractMovementLineMvoCommand.SimpleMergePatchMovementLineMvo, AbstractMovementLineMvoCommand.SimpleDeleteMovementLineMvo>
    {
        @Override
        protected AbstractMovementLineMvoCommand.SimpleCreateMovementLineMvo newCreateMovementLineMvo() {
            return new AbstractMovementLineMvoCommand.SimpleCreateMovementLineMvo();
        }

        @Override
        protected AbstractMovementLineMvoCommand.SimpleMergePatchMovementLineMvo newMergePatchMovementLineMvo() {
            return new AbstractMovementLineMvoCommand.SimpleMergePatchMovementLineMvo();
        }

        @Override
        protected AbstractMovementLineMvoCommand.SimpleDeleteMovementLineMvo newDeleteMovementLineMvo() {
            return new AbstractMovementLineMvoCommand.SimpleDeleteMovementLineMvo();
        }


    }

}

