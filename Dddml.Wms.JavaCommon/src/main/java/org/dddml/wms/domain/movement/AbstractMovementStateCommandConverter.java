package org.dddml.wms.domain.movement;

import java.util.*;
import java.util.Date;
import java.math.BigDecimal;
import org.dddml.wms.domain.*;

public abstract class AbstractMovementStateCommandConverter<TCreateMovement extends MovementCommand.CreateMovement, TMergePatchMovement extends MovementCommand.MergePatchMovement, TDeleteMovement extends MovementCommand.DeleteMovement, TCreateMovementLine extends MovementLineCommand.CreateMovementLine, TMergePatchMovementLine extends MovementLineCommand.MergePatchMovementLine, TRemoveMovementLine extends MovementLineCommand.RemoveMovementLine>
{
    public MovementCommand toCreateOrMergePatchMovement(MovementState state)
    {
        //where TCreateMovement : ICreateMovement, new()
        //where TMergePatchMovement : IMergePatchMovement, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateMovement(state);
        }
        else 
        {
            return toMergePatchMovement(state);
        }
    }

    public TDeleteMovement toDeleteMovement(MovementState state) //where TDeleteMovement : IDeleteMovement, new()
    {
        TDeleteMovement cmd = newDeleteMovement();
        cmd.setDocumentNumber(state.getDocumentNumber());
        cmd.setVersion(state.getVersion());

        return cmd;
    }

    public TMergePatchMovement toMergePatchMovement(MovementState state) //where TMergePatchMovement : IMergePatchMovement, new()
    {
        TMergePatchMovement cmd = newMergePatchMovement();

        cmd.setVersion(state.getVersion());

        cmd.setDocumentNumber(state.getDocumentNumber());
        cmd.setMovementDate(state.getMovementDate());
        cmd.setPosted(state.getPosted());
        cmd.setProcessed(state.getProcessed());
        cmd.setProcessing(state.getProcessing());
        cmd.setDateReceived(state.getDateReceived());
        cmd.setDocumentTypeId(state.getDocumentTypeId());
        cmd.setIsInTransit(state.getIsInTransit());
        cmd.setIsApproved(state.getIsApproved());
        cmd.setApprovalAmount(state.getApprovalAmount());
        cmd.setShipperId(state.getShipperId());
        cmd.setSalesRepresentativeId(state.getSalesRepresentativeId());
        cmd.setBusinessPartnerId(state.getBusinessPartnerId());
        cmd.setChargeAmount(state.getChargeAmount());
        cmd.setCreateFrom(state.getCreateFrom());
        cmd.setFreightAmount(state.getFreightAmount());
        cmd.setReversalDocumentNumber(state.getReversalDocumentNumber());
        cmd.setWarehouseIdFrom(state.getWarehouseIdFrom());
        cmd.setWarehouseIdTo(state.getWarehouseIdTo());
        cmd.setDescription(state.getDescription());
        cmd.setActive(state.getActive());
            
        if (state.getMovementDate() == null) { cmd.setIsPropertyMovementDateRemoved(true); }
        if (state.getPosted() == null) { cmd.setIsPropertyPostedRemoved(true); }
        if (state.getProcessed() == null) { cmd.setIsPropertyProcessedRemoved(true); }
        if (state.getProcessing() == null) { cmd.setIsPropertyProcessingRemoved(true); }
        if (state.getDateReceived() == null) { cmd.setIsPropertyDateReceivedRemoved(true); }
        if (state.getDocumentTypeId() == null) { cmd.setIsPropertyDocumentTypeIdRemoved(true); }
        if (state.getIsInTransit() == null) { cmd.setIsPropertyIsInTransitRemoved(true); }
        if (state.getIsApproved() == null) { cmd.setIsPropertyIsApprovedRemoved(true); }
        if (state.getApprovalAmount() == null) { cmd.setIsPropertyApprovalAmountRemoved(true); }
        if (state.getShipperId() == null) { cmd.setIsPropertyShipperIdRemoved(true); }
        if (state.getSalesRepresentativeId() == null) { cmd.setIsPropertySalesRepresentativeIdRemoved(true); }
        if (state.getBusinessPartnerId() == null) { cmd.setIsPropertyBusinessPartnerIdRemoved(true); }
        if (state.getChargeAmount() == null) { cmd.setIsPropertyChargeAmountRemoved(true); }
        if (state.getCreateFrom() == null) { cmd.setIsPropertyCreateFromRemoved(true); }
        if (state.getFreightAmount() == null) { cmd.setIsPropertyFreightAmountRemoved(true); }
        if (state.getReversalDocumentNumber() == null) { cmd.setIsPropertyReversalDocumentNumberRemoved(true); }
        if (state.getWarehouseIdFrom() == null) { cmd.setIsPropertyWarehouseIdFromRemoved(true); }
        if (state.getWarehouseIdTo() == null) { cmd.setIsPropertyWarehouseIdToRemoved(true); }
        if (state.getDescription() == null) { cmd.setIsPropertyDescriptionRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        for (MovementLineState d : state.getMovementLines())
        {
            MovementLineCommand c = getMovementLineStateCommandConverter().toCreateOrMergePatchMovementLine(d);
            cmd.getMovementLineCommands().add(c);
        }
        return cmd;
    }

    public TCreateMovement toCreateMovement(MovementState state) //where TCreateMovement : ICreateMovement, new()
    {
        TCreateMovement cmd = newCreateMovement();

        cmd.setVersion(state.getVersion());
        cmd.setDocumentNumber(state.getDocumentNumber());
        cmd.setMovementDate(state.getMovementDate());
        cmd.setPosted(state.getPosted());
        cmd.setProcessed(state.getProcessed());
        cmd.setProcessing(state.getProcessing());
        cmd.setDateReceived(state.getDateReceived());
        cmd.setDocumentTypeId(state.getDocumentTypeId());
        cmd.setIsInTransit(state.getIsInTransit());
        cmd.setIsApproved(state.getIsApproved());
        cmd.setApprovalAmount(state.getApprovalAmount());
        cmd.setShipperId(state.getShipperId());
        cmd.setSalesRepresentativeId(state.getSalesRepresentativeId());
        cmd.setBusinessPartnerId(state.getBusinessPartnerId());
        cmd.setChargeAmount(state.getChargeAmount());
        cmd.setCreateFrom(state.getCreateFrom());
        cmd.setFreightAmount(state.getFreightAmount());
        cmd.setReversalDocumentNumber(state.getReversalDocumentNumber());
        cmd.setWarehouseIdFrom(state.getWarehouseIdFrom());
        cmd.setWarehouseIdTo(state.getWarehouseIdTo());
        cmd.setDescription(state.getDescription());
        cmd.setActive(state.getActive());
        for (MovementLineState d : state.getMovementLines())
        {
            MovementLineCommand.CreateMovementLine c = getMovementLineStateCommandConverter().toCreateMovementLine(d);
            cmd.getMovementLines().add(c);
        }
        return cmd;
    }

    protected abstract AbstractMovementLineStateCommandConverter<TCreateMovementLine, TMergePatchMovementLine, TRemoveMovementLine>
        getMovementLineStateCommandConverter();

    protected abstract TCreateMovement newCreateMovement();

    protected abstract TMergePatchMovement newMergePatchMovement(); 

    protected abstract TDeleteMovement newDeleteMovement();

    public static class SimpleMovementStateCommandConverter extends AbstractMovementStateCommandConverter<AbstractMovementCommand.SimpleCreateMovement, AbstractMovementCommand.SimpleMergePatchMovement, AbstractMovementCommand.SimpleDeleteMovement, AbstractMovementLineCommand.SimpleCreateMovementLine, AbstractMovementLineCommand.SimpleMergePatchMovementLine, AbstractMovementLineCommand.SimpleRemoveMovementLine>
    {
        @Override
        protected AbstractMovementCommand.SimpleCreateMovement newCreateMovement() {
            return new AbstractMovementCommand.SimpleCreateMovement();
        }

        @Override
        protected AbstractMovementCommand.SimpleMergePatchMovement newMergePatchMovement() {
            return new AbstractMovementCommand.SimpleMergePatchMovement();
        }

        @Override
        protected AbstractMovementCommand.SimpleDeleteMovement newDeleteMovement() {
            return new AbstractMovementCommand.SimpleDeleteMovement();
        }

        @Override
        protected AbstractMovementLineStateCommandConverter<AbstractMovementLineCommand.SimpleCreateMovementLine, AbstractMovementLineCommand.SimpleMergePatchMovementLine, AbstractMovementLineCommand.SimpleRemoveMovementLine> getMovementLineStateCommandConverter()
        {
            return new AbstractMovementLineStateCommandConverter.SimpleMovementLineStateCommandConverter();
        }


    }

}

