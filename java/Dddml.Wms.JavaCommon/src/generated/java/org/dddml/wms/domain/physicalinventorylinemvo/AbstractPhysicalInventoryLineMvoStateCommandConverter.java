package org.dddml.wms.domain.physicalinventorylinemvo;

import java.util.*;
import org.dddml.wms.domain.physicalinventory.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractPhysicalInventoryLineMvoStateCommandConverter<TCreatePhysicalInventoryLineMvo extends PhysicalInventoryLineMvoCommand.CreatePhysicalInventoryLineMvo, TMergePatchPhysicalInventoryLineMvo extends PhysicalInventoryLineMvoCommand.MergePatchPhysicalInventoryLineMvo, TDeletePhysicalInventoryLineMvo extends PhysicalInventoryLineMvoCommand.DeletePhysicalInventoryLineMvo>
{
    public PhysicalInventoryLineMvoCommand toCreateOrMergePatchPhysicalInventoryLineMvo(PhysicalInventoryLineMvoState state)
    {
        //where TCreatePhysicalInventoryLineMvo : ICreatePhysicalInventoryLineMvo, new()
        //where TMergePatchPhysicalInventoryLineMvo : IMergePatchPhysicalInventoryLineMvo, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreatePhysicalInventoryLineMvo(state);
        }
        else 
        {
            return toMergePatchPhysicalInventoryLineMvo(state);
        }
    }

    public TDeletePhysicalInventoryLineMvo toDeletePhysicalInventoryLineMvo(PhysicalInventoryLineMvoState state) //where TDeletePhysicalInventoryLineMvo : IDeletePhysicalInventoryLineMvo, new()
    {
        TDeletePhysicalInventoryLineMvo cmd = newDeletePhysicalInventoryLineMvo();
        cmd.setPhysicalInventoryLineId(state.getPhysicalInventoryLineId());
        cmd.setPhysicalInventoryVersion(state.getPhysicalInventoryVersion());

        return cmd;
    }

    public TMergePatchPhysicalInventoryLineMvo toMergePatchPhysicalInventoryLineMvo(PhysicalInventoryLineMvoState state) //where TMergePatchPhysicalInventoryLineMvo : IMergePatchPhysicalInventoryLineMvo, new()
    {
        TMergePatchPhysicalInventoryLineMvo cmd = newMergePatchPhysicalInventoryLineMvo();

        cmd.setPhysicalInventoryVersion(state.getPhysicalInventoryVersion());

        cmd.setPhysicalInventoryLineId(state.getPhysicalInventoryLineId());
        cmd.setBookQuantity(state.getBookQuantity());
        cmd.setCountedQuantity(state.getCountedQuantity());
        cmd.setProcessed(state.getProcessed());
        cmd.setReversalLineNumber(state.getReversalLineNumber());
        cmd.setDescription(state.getDescription());
        cmd.setVersion(state.getVersion());
        cmd.setPhysicalInventoryDocumentStatusId(state.getPhysicalInventoryDocumentStatusId());
        cmd.setPhysicalInventoryWarehouseId(state.getPhysicalInventoryWarehouseId());
        cmd.setPhysicalInventoryLocatorIdPattern(state.getPhysicalInventoryLocatorIdPattern());
        cmd.setPhysicalInventoryProductIdPattern(state.getPhysicalInventoryProductIdPattern());
        cmd.setPhysicalInventoryPosted(state.getPhysicalInventoryPosted());
        cmd.setPhysicalInventoryProcessed(state.getPhysicalInventoryProcessed());
        cmd.setPhysicalInventoryProcessing(state.getPhysicalInventoryProcessing());
        cmd.setPhysicalInventoryDocumentTypeId(state.getPhysicalInventoryDocumentTypeId());
        cmd.setPhysicalInventoryMovementDate(state.getPhysicalInventoryMovementDate());
        cmd.setPhysicalInventoryDescription(state.getPhysicalInventoryDescription());
        cmd.setPhysicalInventoryIsApproved(state.getPhysicalInventoryIsApproved());
        cmd.setPhysicalInventoryApprovalAmount(state.getPhysicalInventoryApprovalAmount());
        cmd.setPhysicalInventoryIsQuantityUpdated(state.getPhysicalInventoryIsQuantityUpdated());
        cmd.setPhysicalInventoryReversalDocumentNumber(state.getPhysicalInventoryReversalDocumentNumber());
        cmd.setPhysicalInventoryCreatedBy(state.getPhysicalInventoryCreatedBy());
        cmd.setPhysicalInventoryCreatedAt(state.getPhysicalInventoryCreatedAt());
        cmd.setPhysicalInventoryUpdatedBy(state.getPhysicalInventoryUpdatedBy());
        cmd.setPhysicalInventoryUpdatedAt(state.getPhysicalInventoryUpdatedAt());
        cmd.setPhysicalInventoryActive(state.getPhysicalInventoryActive());
            
        if (state.getBookQuantity() == null) { cmd.setIsPropertyBookQuantityRemoved(true); }
        if (state.getCountedQuantity() == null) { cmd.setIsPropertyCountedQuantityRemoved(true); }
        if (state.getProcessed() == null) { cmd.setIsPropertyProcessedRemoved(true); }
        if (state.getReversalLineNumber() == null) { cmd.setIsPropertyReversalLineNumberRemoved(true); }
        if (state.getDescription() == null) { cmd.setIsPropertyDescriptionRemoved(true); }
        if (state.getVersion() == null) { cmd.setIsPropertyVersionRemoved(true); }
        if (state.getPhysicalInventoryDocumentStatusId() == null) { cmd.setIsPropertyPhysicalInventoryDocumentStatusIdRemoved(true); }
        if (state.getPhysicalInventoryWarehouseId() == null) { cmd.setIsPropertyPhysicalInventoryWarehouseIdRemoved(true); }
        if (state.getPhysicalInventoryLocatorIdPattern() == null) { cmd.setIsPropertyPhysicalInventoryLocatorIdPatternRemoved(true); }
        if (state.getPhysicalInventoryProductIdPattern() == null) { cmd.setIsPropertyPhysicalInventoryProductIdPatternRemoved(true); }
        if (state.getPhysicalInventoryPosted() == null) { cmd.setIsPropertyPhysicalInventoryPostedRemoved(true); }
        if (state.getPhysicalInventoryProcessed() == null) { cmd.setIsPropertyPhysicalInventoryProcessedRemoved(true); }
        if (state.getPhysicalInventoryProcessing() == null) { cmd.setIsPropertyPhysicalInventoryProcessingRemoved(true); }
        if (state.getPhysicalInventoryDocumentTypeId() == null) { cmd.setIsPropertyPhysicalInventoryDocumentTypeIdRemoved(true); }
        if (state.getPhysicalInventoryMovementDate() == null) { cmd.setIsPropertyPhysicalInventoryMovementDateRemoved(true); }
        if (state.getPhysicalInventoryDescription() == null) { cmd.setIsPropertyPhysicalInventoryDescriptionRemoved(true); }
        if (state.getPhysicalInventoryIsApproved() == null) { cmd.setIsPropertyPhysicalInventoryIsApprovedRemoved(true); }
        if (state.getPhysicalInventoryApprovalAmount() == null) { cmd.setIsPropertyPhysicalInventoryApprovalAmountRemoved(true); }
        if (state.getPhysicalInventoryIsQuantityUpdated() == null) { cmd.setIsPropertyPhysicalInventoryIsQuantityUpdatedRemoved(true); }
        if (state.getPhysicalInventoryReversalDocumentNumber() == null) { cmd.setIsPropertyPhysicalInventoryReversalDocumentNumberRemoved(true); }
        if (state.getPhysicalInventoryCreatedBy() == null) { cmd.setIsPropertyPhysicalInventoryCreatedByRemoved(true); }
        if (state.getPhysicalInventoryCreatedAt() == null) { cmd.setIsPropertyPhysicalInventoryCreatedAtRemoved(true); }
        if (state.getPhysicalInventoryUpdatedBy() == null) { cmd.setIsPropertyPhysicalInventoryUpdatedByRemoved(true); }
        if (state.getPhysicalInventoryUpdatedAt() == null) { cmd.setIsPropertyPhysicalInventoryUpdatedAtRemoved(true); }
        if (state.getPhysicalInventoryActive() == null) { cmd.setIsPropertyPhysicalInventoryActiveRemoved(true); }
        return cmd;
    }

    public TCreatePhysicalInventoryLineMvo toCreatePhysicalInventoryLineMvo(PhysicalInventoryLineMvoState state) //where TCreatePhysicalInventoryLineMvo : ICreatePhysicalInventoryLineMvo, new()
    {
        TCreatePhysicalInventoryLineMvo cmd = newCreatePhysicalInventoryLineMvo();

        cmd.setPhysicalInventoryVersion(state.getPhysicalInventoryVersion());
        cmd.setPhysicalInventoryLineId(state.getPhysicalInventoryLineId());
        cmd.setBookQuantity(state.getBookQuantity());
        cmd.setCountedQuantity(state.getCountedQuantity());
        cmd.setProcessed(state.getProcessed());
        cmd.setReversalLineNumber(state.getReversalLineNumber());
        cmd.setDescription(state.getDescription());
        cmd.setVersion(state.getVersion());
        cmd.setPhysicalInventoryDocumentStatusId(state.getPhysicalInventoryDocumentStatusId());
        cmd.setPhysicalInventoryWarehouseId(state.getPhysicalInventoryWarehouseId());
        cmd.setPhysicalInventoryLocatorIdPattern(state.getPhysicalInventoryLocatorIdPattern());
        cmd.setPhysicalInventoryProductIdPattern(state.getPhysicalInventoryProductIdPattern());
        cmd.setPhysicalInventoryPosted(state.getPhysicalInventoryPosted());
        cmd.setPhysicalInventoryProcessed(state.getPhysicalInventoryProcessed());
        cmd.setPhysicalInventoryProcessing(state.getPhysicalInventoryProcessing());
        cmd.setPhysicalInventoryDocumentTypeId(state.getPhysicalInventoryDocumentTypeId());
        cmd.setPhysicalInventoryMovementDate(state.getPhysicalInventoryMovementDate());
        cmd.setPhysicalInventoryDescription(state.getPhysicalInventoryDescription());
        cmd.setPhysicalInventoryIsApproved(state.getPhysicalInventoryIsApproved());
        cmd.setPhysicalInventoryApprovalAmount(state.getPhysicalInventoryApprovalAmount());
        cmd.setPhysicalInventoryIsQuantityUpdated(state.getPhysicalInventoryIsQuantityUpdated());
        cmd.setPhysicalInventoryReversalDocumentNumber(state.getPhysicalInventoryReversalDocumentNumber());
        cmd.setPhysicalInventoryCreatedBy(state.getPhysicalInventoryCreatedBy());
        cmd.setPhysicalInventoryCreatedAt(state.getPhysicalInventoryCreatedAt());
        cmd.setPhysicalInventoryUpdatedBy(state.getPhysicalInventoryUpdatedBy());
        cmd.setPhysicalInventoryUpdatedAt(state.getPhysicalInventoryUpdatedAt());
        cmd.setPhysicalInventoryActive(state.getPhysicalInventoryActive());
        return cmd;
    }

    protected abstract TCreatePhysicalInventoryLineMvo newCreatePhysicalInventoryLineMvo();

    protected abstract TMergePatchPhysicalInventoryLineMvo newMergePatchPhysicalInventoryLineMvo(); 

    protected abstract TDeletePhysicalInventoryLineMvo newDeletePhysicalInventoryLineMvo();

    public static class SimplePhysicalInventoryLineMvoStateCommandConverter extends AbstractPhysicalInventoryLineMvoStateCommandConverter<AbstractPhysicalInventoryLineMvoCommand.SimpleCreatePhysicalInventoryLineMvo, AbstractPhysicalInventoryLineMvoCommand.SimpleMergePatchPhysicalInventoryLineMvo, AbstractPhysicalInventoryLineMvoCommand.SimpleDeletePhysicalInventoryLineMvo>
    {
        @Override
        protected AbstractPhysicalInventoryLineMvoCommand.SimpleCreatePhysicalInventoryLineMvo newCreatePhysicalInventoryLineMvo() {
            return new AbstractPhysicalInventoryLineMvoCommand.SimpleCreatePhysicalInventoryLineMvo();
        }

        @Override
        protected AbstractPhysicalInventoryLineMvoCommand.SimpleMergePatchPhysicalInventoryLineMvo newMergePatchPhysicalInventoryLineMvo() {
            return new AbstractPhysicalInventoryLineMvoCommand.SimpleMergePatchPhysicalInventoryLineMvo();
        }

        @Override
        protected AbstractPhysicalInventoryLineMvoCommand.SimpleDeletePhysicalInventoryLineMvo newDeletePhysicalInventoryLineMvo() {
            return new AbstractPhysicalInventoryLineMvoCommand.SimpleDeletePhysicalInventoryLineMvo();
        }


    }

}

