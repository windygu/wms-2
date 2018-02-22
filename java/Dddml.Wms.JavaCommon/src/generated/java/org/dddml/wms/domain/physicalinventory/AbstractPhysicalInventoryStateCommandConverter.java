package org.dddml.wms.domain.physicalinventory;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;

public abstract class AbstractPhysicalInventoryStateCommandConverter<TCreatePhysicalInventory extends PhysicalInventoryCommand.CreatePhysicalInventory, TMergePatchPhysicalInventory extends PhysicalInventoryCommand.MergePatchPhysicalInventory, TDeletePhysicalInventory extends PhysicalInventoryCommand.DeletePhysicalInventory, TCreatePhysicalInventoryLine extends PhysicalInventoryLineCommand.CreatePhysicalInventoryLine, TMergePatchPhysicalInventoryLine extends PhysicalInventoryLineCommand.MergePatchPhysicalInventoryLine, TRemovePhysicalInventoryLine extends PhysicalInventoryLineCommand.RemovePhysicalInventoryLine>
{
    public PhysicalInventoryCommand toCreateOrMergePatchPhysicalInventory(PhysicalInventoryState state)
    {
        //where TCreatePhysicalInventory : ICreatePhysicalInventory, new()
        //where TMergePatchPhysicalInventory : IMergePatchPhysicalInventory, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreatePhysicalInventory(state);
        }
        else 
        {
            return toMergePatchPhysicalInventory(state);
        }
    }

    public TDeletePhysicalInventory toDeletePhysicalInventory(PhysicalInventoryState state) //where TDeletePhysicalInventory : IDeletePhysicalInventory, new()
    {
        TDeletePhysicalInventory cmd = newDeletePhysicalInventory();
        cmd.setDocumentNumber(state.getDocumentNumber());
        cmd.setVersion(state.getVersion());

        return cmd;
    }

    public TMergePatchPhysicalInventory toMergePatchPhysicalInventory(PhysicalInventoryState state) //where TMergePatchPhysicalInventory : IMergePatchPhysicalInventory, new()
    {
        TMergePatchPhysicalInventory cmd = newMergePatchPhysicalInventory();

        cmd.setVersion(state.getVersion());

        cmd.setDocumentNumber(state.getDocumentNumber());
        cmd.setWarehouseId(state.getWarehouseId());
        cmd.setLocatorIdPattern(state.getLocatorIdPattern());
        cmd.setProductIdPattern(state.getProductIdPattern());
        cmd.setPosted(state.getPosted());
        cmd.setProcessed(state.getProcessed());
        cmd.setProcessing(state.getProcessing());
        cmd.setDocumentTypeId(state.getDocumentTypeId());
        cmd.setMovementDate(state.getMovementDate());
        cmd.setDescription(state.getDescription());
        cmd.setIsApproved(state.getIsApproved());
        cmd.setApprovalAmount(state.getApprovalAmount());
        cmd.setIsQuantityUpdated(state.getIsQuantityUpdated());
        cmd.setReversalDocumentNumber(state.getReversalDocumentNumber());
        cmd.setActive(state.getActive());
            
        if (state.getWarehouseId() == null) { cmd.setIsPropertyWarehouseIdRemoved(true); }
        if (state.getLocatorIdPattern() == null) { cmd.setIsPropertyLocatorIdPatternRemoved(true); }
        if (state.getProductIdPattern() == null) { cmd.setIsPropertyProductIdPatternRemoved(true); }
        if (state.getPosted() == null) { cmd.setIsPropertyPostedRemoved(true); }
        if (state.getProcessed() == null) { cmd.setIsPropertyProcessedRemoved(true); }
        if (state.getProcessing() == null) { cmd.setIsPropertyProcessingRemoved(true); }
        if (state.getDocumentTypeId() == null) { cmd.setIsPropertyDocumentTypeIdRemoved(true); }
        if (state.getMovementDate() == null) { cmd.setIsPropertyMovementDateRemoved(true); }
        if (state.getDescription() == null) { cmd.setIsPropertyDescriptionRemoved(true); }
        if (state.getIsApproved() == null) { cmd.setIsPropertyIsApprovedRemoved(true); }
        if (state.getApprovalAmount() == null) { cmd.setIsPropertyApprovalAmountRemoved(true); }
        if (state.getIsQuantityUpdated() == null) { cmd.setIsPropertyIsQuantityUpdatedRemoved(true); }
        if (state.getReversalDocumentNumber() == null) { cmd.setIsPropertyReversalDocumentNumberRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        for (PhysicalInventoryLineState d : state.getPhysicalInventoryLines())
        {
            PhysicalInventoryLineCommand c = getPhysicalInventoryLineStateCommandConverter().toCreateOrMergePatchPhysicalInventoryLine(d);
            cmd.getPhysicalInventoryLineCommands().add(c);
        }
        return cmd;
    }

    public TCreatePhysicalInventory toCreatePhysicalInventory(PhysicalInventoryState state) //where TCreatePhysicalInventory : ICreatePhysicalInventory, new()
    {
        TCreatePhysicalInventory cmd = newCreatePhysicalInventory();

        cmd.setVersion(state.getVersion());
        cmd.setDocumentNumber(state.getDocumentNumber());
        cmd.setWarehouseId(state.getWarehouseId());
        cmd.setLocatorIdPattern(state.getLocatorIdPattern());
        cmd.setProductIdPattern(state.getProductIdPattern());
        cmd.setPosted(state.getPosted());
        cmd.setProcessed(state.getProcessed());
        cmd.setProcessing(state.getProcessing());
        cmd.setDocumentTypeId(state.getDocumentTypeId());
        cmd.setMovementDate(state.getMovementDate());
        cmd.setDescription(state.getDescription());
        cmd.setIsApproved(state.getIsApproved());
        cmd.setApprovalAmount(state.getApprovalAmount());
        cmd.setIsQuantityUpdated(state.getIsQuantityUpdated());
        cmd.setReversalDocumentNumber(state.getReversalDocumentNumber());
        cmd.setActive(state.getActive());
        for (PhysicalInventoryLineState d : state.getPhysicalInventoryLines())
        {
            PhysicalInventoryLineCommand.CreatePhysicalInventoryLine c = getPhysicalInventoryLineStateCommandConverter().toCreatePhysicalInventoryLine(d);
            cmd.getPhysicalInventoryLines().add(c);
        }
        return cmd;
    }

    protected abstract AbstractPhysicalInventoryLineStateCommandConverter<TCreatePhysicalInventoryLine, TMergePatchPhysicalInventoryLine, TRemovePhysicalInventoryLine>
        getPhysicalInventoryLineStateCommandConverter();

    protected abstract TCreatePhysicalInventory newCreatePhysicalInventory();

    protected abstract TMergePatchPhysicalInventory newMergePatchPhysicalInventory(); 

    protected abstract TDeletePhysicalInventory newDeletePhysicalInventory();

    public static class SimplePhysicalInventoryStateCommandConverter extends AbstractPhysicalInventoryStateCommandConverter<AbstractPhysicalInventoryCommand.SimpleCreatePhysicalInventory, AbstractPhysicalInventoryCommand.SimpleMergePatchPhysicalInventory, AbstractPhysicalInventoryCommand.SimpleDeletePhysicalInventory, AbstractPhysicalInventoryLineCommand.SimpleCreatePhysicalInventoryLine, AbstractPhysicalInventoryLineCommand.SimpleMergePatchPhysicalInventoryLine, AbstractPhysicalInventoryLineCommand.SimpleRemovePhysicalInventoryLine>
    {
        @Override
        protected AbstractPhysicalInventoryCommand.SimpleCreatePhysicalInventory newCreatePhysicalInventory() {
            return new AbstractPhysicalInventoryCommand.SimpleCreatePhysicalInventory();
        }

        @Override
        protected AbstractPhysicalInventoryCommand.SimpleMergePatchPhysicalInventory newMergePatchPhysicalInventory() {
            return new AbstractPhysicalInventoryCommand.SimpleMergePatchPhysicalInventory();
        }

        @Override
        protected AbstractPhysicalInventoryCommand.SimpleDeletePhysicalInventory newDeletePhysicalInventory() {
            return new AbstractPhysicalInventoryCommand.SimpleDeletePhysicalInventory();
        }

        @Override
        protected AbstractPhysicalInventoryLineStateCommandConverter<AbstractPhysicalInventoryLineCommand.SimpleCreatePhysicalInventoryLine, AbstractPhysicalInventoryLineCommand.SimpleMergePatchPhysicalInventoryLine, AbstractPhysicalInventoryLineCommand.SimpleRemovePhysicalInventoryLine> getPhysicalInventoryLineStateCommandConverter()
        {
            return new AbstractPhysicalInventoryLineStateCommandConverter.SimplePhysicalInventoryLineStateCommandConverter();
        }


    }

}

