package org.dddml.wms.domain.movement;

import java.util.*;
import java.util.Date;
import java.math.BigDecimal;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface MovementCommand extends Command
{
    String getDocumentNumber();

    void setDocumentNumber(String documentNumber);

    Long getVersion();

    void setVersion(Long version);

    static void throwOnInvalidStateTransition(MovementState state, Command c) {
        if (state.getVersion() == null)
        {
            if (isCommandCreate((MovementCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (state.getDeleted() != null && state.getDeleted())
        {
            throw DomainError.named("zombie", "Can't do anything to deleted aggregate.");
        }
        if (isCommandCreate((MovementCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(MovementCommand c) {
        return ((c instanceof MovementCommand.CreateMovement) 
            && (COMMAND_TYPE_CREATE.equals(c.getCommandType()) || c.getVersion().equals(MovementState.VERSION_NULL)));
    }

    interface CreateOrMergePatchMovement extends MovementCommand
    {
        Date getMovementDate();

        void setMovementDate(Date movementDate);

        Boolean getPosted();

        void setPosted(Boolean posted);

        Boolean getProcessed();

        void setProcessed(Boolean processed);

        String getProcessing();

        void setProcessing(String processing);

        Date getDateReceived();

        void setDateReceived(Date dateReceived);

        String getDocumentTypeId();

        void setDocumentTypeId(String documentTypeId);

        Boolean getIsInTransit();

        void setIsInTransit(Boolean isInTransit);

        Boolean getIsApproved();

        void setIsApproved(Boolean isApproved);

        BigDecimal getApprovalAmount();

        void setApprovalAmount(BigDecimal approvalAmount);

        String getShipperId();

        void setShipperId(String shipperId);

        String getSalesRepresentativeId();

        void setSalesRepresentativeId(String salesRepresentativeId);

        String getBusinessPartnerId();

        void setBusinessPartnerId(String businessPartnerId);

        BigDecimal getChargeAmount();

        void setChargeAmount(BigDecimal chargeAmount);

        String getCreateFrom();

        void setCreateFrom(String createFrom);

        BigDecimal getFreightAmount();

        void setFreightAmount(BigDecimal freightAmount);

        String getReversalDocumentNumber();

        void setReversalDocumentNumber(String reversalDocumentNumber);

        String getWarehouseIdFrom();

        void setWarehouseIdFrom(String warehouseIdFrom);

        String getWarehouseIdTo();

        void setWarehouseIdTo(String warehouseIdTo);

        String getDescription();

        void setDescription(String description);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateMovement extends CreateOrMergePatchMovement
    {
        CreateMovementLineCommandCollection getMovementLines();

        MovementLineCommand.CreateMovementLine newCreateMovementLine();

    }

    interface MergePatchMovement extends CreateOrMergePatchMovement
    {
        String getDocumentAction();

        void setDocumentAction(String documentAction);
                
        Boolean getIsPropertyMovementDateRemoved();

        void setIsPropertyMovementDateRemoved(Boolean removed);

        Boolean getIsPropertyPostedRemoved();

        void setIsPropertyPostedRemoved(Boolean removed);

        Boolean getIsPropertyProcessedRemoved();

        void setIsPropertyProcessedRemoved(Boolean removed);

        Boolean getIsPropertyProcessingRemoved();

        void setIsPropertyProcessingRemoved(Boolean removed);

        Boolean getIsPropertyDateReceivedRemoved();

        void setIsPropertyDateReceivedRemoved(Boolean removed);

        Boolean getIsPropertyDocumentTypeIdRemoved();

        void setIsPropertyDocumentTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyIsInTransitRemoved();

        void setIsPropertyIsInTransitRemoved(Boolean removed);

        Boolean getIsPropertyIsApprovedRemoved();

        void setIsPropertyIsApprovedRemoved(Boolean removed);

        Boolean getIsPropertyApprovalAmountRemoved();

        void setIsPropertyApprovalAmountRemoved(Boolean removed);

        Boolean getIsPropertyShipperIdRemoved();

        void setIsPropertyShipperIdRemoved(Boolean removed);

        Boolean getIsPropertySalesRepresentativeIdRemoved();

        void setIsPropertySalesRepresentativeIdRemoved(Boolean removed);

        Boolean getIsPropertyBusinessPartnerIdRemoved();

        void setIsPropertyBusinessPartnerIdRemoved(Boolean removed);

        Boolean getIsPropertyChargeAmountRemoved();

        void setIsPropertyChargeAmountRemoved(Boolean removed);

        Boolean getIsPropertyCreateFromRemoved();

        void setIsPropertyCreateFromRemoved(Boolean removed);

        Boolean getIsPropertyFreightAmountRemoved();

        void setIsPropertyFreightAmountRemoved(Boolean removed);

        Boolean getIsPropertyReversalDocumentNumberRemoved();

        void setIsPropertyReversalDocumentNumberRemoved(Boolean removed);

        Boolean getIsPropertyWarehouseIdFromRemoved();

        void setIsPropertyWarehouseIdFromRemoved(Boolean removed);

        Boolean getIsPropertyWarehouseIdToRemoved();

        void setIsPropertyWarehouseIdToRemoved(Boolean removed);

        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        MovementLineCommandCollection getMovementLineCommands();

        MovementLineCommand.CreateMovementLine newCreateMovementLine();

        MovementLineCommand.MergePatchMovementLine newMergePatchMovementLine();

        MovementLineCommand.RemoveMovementLine newRemoveMovementLine();

    }

	interface DeleteMovement extends MovementCommand
	{
	}

    interface CreateMovementLineCommandCollection extends Iterable<MovementLineCommand.CreateMovementLine>
    {
        void add(MovementLineCommand.CreateMovementLine c);

        void remove(MovementLineCommand.CreateMovementLine c);

        void clear();
    }

    interface MovementLineCommandCollection extends Iterable<MovementLineCommand>
    {
        void add(MovementLineCommand c);

        void remove(MovementLineCommand c);

        void clear();
    }

}

