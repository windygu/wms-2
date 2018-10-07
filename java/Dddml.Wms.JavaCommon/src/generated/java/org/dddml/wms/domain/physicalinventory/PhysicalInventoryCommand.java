package org.dddml.wms.domain.physicalinventory;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface PhysicalInventoryCommand extends Command
{
    String getDocumentNumber();

    void setDocumentNumber(String documentNumber);

    Long getVersion();

    void setVersion(Long version);

    static void throwOnInvalidStateTransition(PhysicalInventoryState state, Command c) {
        if (state.getVersion() == null)
        {
            if (isCommandCreate((PhysicalInventoryCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (isCommandCreate((PhysicalInventoryCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(PhysicalInventoryCommand c) {
        return ((c instanceof PhysicalInventoryCommand.CreatePhysicalInventory) 
            && (COMMAND_TYPE_CREATE.equals(c.getCommandType()) || c.getVersion().equals(PhysicalInventoryState.VERSION_NULL)));
    }

    interface CreateOrMergePatchPhysicalInventory extends PhysicalInventoryCommand
    {
        String getWarehouseId();

        void setWarehouseId(String warehouseId);

        String getLocatorIdPattern();

        void setLocatorIdPattern(String locatorIdPattern);

        String getProductIdPattern();

        void setProductIdPattern(String productIdPattern);

        Boolean getPosted();

        void setPosted(Boolean posted);

        Boolean getProcessed();

        void setProcessed(Boolean processed);

        String getProcessing();

        void setProcessing(String processing);

        String getDocumentTypeId();

        void setDocumentTypeId(String documentTypeId);

        Date getMovementDate();

        void setMovementDate(Date movementDate);

        String getDescription();

        void setDescription(String description);

        Boolean getIsApproved();

        void setIsApproved(Boolean isApproved);

        BigDecimal getApprovalAmount();

        void setApprovalAmount(BigDecimal approvalAmount);

        Boolean getIsQuantityUpdated();

        void setIsQuantityUpdated(Boolean isQuantityUpdated);

        String getReversalDocumentNumber();

        void setReversalDocumentNumber(String reversalDocumentNumber);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreatePhysicalInventory extends CreateOrMergePatchPhysicalInventory
    {
        CreatePhysicalInventoryLineCommandCollection getPhysicalInventoryLines();

        PhysicalInventoryLineCommand.CreatePhysicalInventoryLine newCreatePhysicalInventoryLine();

    }

    interface MergePatchPhysicalInventory extends CreateOrMergePatchPhysicalInventory
    {
        String getDocumentAction();

        void setDocumentAction(String documentAction);
                
        Boolean getIsPropertyWarehouseIdRemoved();

        void setIsPropertyWarehouseIdRemoved(Boolean removed);

        Boolean getIsPropertyLocatorIdPatternRemoved();

        void setIsPropertyLocatorIdPatternRemoved(Boolean removed);

        Boolean getIsPropertyProductIdPatternRemoved();

        void setIsPropertyProductIdPatternRemoved(Boolean removed);

        Boolean getIsPropertyPostedRemoved();

        void setIsPropertyPostedRemoved(Boolean removed);

        Boolean getIsPropertyProcessedRemoved();

        void setIsPropertyProcessedRemoved(Boolean removed);

        Boolean getIsPropertyProcessingRemoved();

        void setIsPropertyProcessingRemoved(Boolean removed);

        Boolean getIsPropertyDocumentTypeIdRemoved();

        void setIsPropertyDocumentTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyMovementDateRemoved();

        void setIsPropertyMovementDateRemoved(Boolean removed);

        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyIsApprovedRemoved();

        void setIsPropertyIsApprovedRemoved(Boolean removed);

        Boolean getIsPropertyApprovalAmountRemoved();

        void setIsPropertyApprovalAmountRemoved(Boolean removed);

        Boolean getIsPropertyIsQuantityUpdatedRemoved();

        void setIsPropertyIsQuantityUpdatedRemoved(Boolean removed);

        Boolean getIsPropertyReversalDocumentNumberRemoved();

        void setIsPropertyReversalDocumentNumberRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        PhysicalInventoryLineCommandCollection getPhysicalInventoryLineCommands();

        PhysicalInventoryLineCommand.CreatePhysicalInventoryLine newCreatePhysicalInventoryLine();

        PhysicalInventoryLineCommand.MergePatchPhysicalInventoryLine newMergePatchPhysicalInventoryLine();

        PhysicalInventoryLineCommand.RemovePhysicalInventoryLine newRemovePhysicalInventoryLine();

    }

	interface DeletePhysicalInventory extends PhysicalInventoryCommand
	{
	}

    interface CreatePhysicalInventoryLineCommandCollection extends Iterable<PhysicalInventoryLineCommand.CreatePhysicalInventoryLine>
    {
        void add(PhysicalInventoryLineCommand.CreatePhysicalInventoryLine c);

        void remove(PhysicalInventoryLineCommand.CreatePhysicalInventoryLine c);

        void clear();
    }

    interface PhysicalInventoryLineCommandCollection extends Iterable<PhysicalInventoryLineCommand>
    {
        void add(PhysicalInventoryLineCommand c);

        void remove(PhysicalInventoryLineCommand c);

        void clear();
    }

}

