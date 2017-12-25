package org.dddml.wms.domain.physicalinventory;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractPhysicalInventoryLineStateCommandConverter<TCreatePhysicalInventoryLine extends PhysicalInventoryLineCommand.CreatePhysicalInventoryLine, TMergePatchPhysicalInventoryLine extends PhysicalInventoryLineCommand.MergePatchPhysicalInventoryLine, TRemovePhysicalInventoryLine extends PhysicalInventoryLineCommand.RemovePhysicalInventoryLine>
{
    public PhysicalInventoryLineCommand toCreateOrMergePatchPhysicalInventoryLine(PhysicalInventoryLineState state)
    {
        //where TCreatePhysicalInventoryLine : ICreatePhysicalInventoryLine, new()
        //where TMergePatchPhysicalInventoryLine : IMergePatchPhysicalInventoryLine, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreatePhysicalInventoryLine(state);
        }
        else 
        {
            return toMergePatchPhysicalInventoryLine(state);
        }
    }

    public TRemovePhysicalInventoryLine toRemovePhysicalInventoryLine(PhysicalInventoryLineState state) //where TRemovePhysicalInventoryLine : IRemovePhysicalInventoryLine, new()
    {
        TRemovePhysicalInventoryLine cmd = newRemovePhysicalInventoryLine();
        cmd.setLineNumber(state.getLineNumber());
        return cmd;
    }

    public TMergePatchPhysicalInventoryLine toMergePatchPhysicalInventoryLine(PhysicalInventoryLineState state) //where TMergePatchPhysicalInventoryLine : IMergePatchPhysicalInventoryLine, new()
    {
        TMergePatchPhysicalInventoryLine cmd = newMergePatchPhysicalInventoryLine();

        cmd.setLineNumber(state.getLineNumber());
        cmd.setLocatorId(state.getLocatorId());
        cmd.setProductId(state.getProductId());
        cmd.setAttributeSetInstanceId(state.getAttributeSetInstanceId());
        cmd.setBookQuantity(state.getBookQuantity());
        cmd.setCountedQuantity(state.getCountedQuantity());
        cmd.setProcessed(state.getProcessed());
        cmd.setReversalLineNumber(state.getReversalLineNumber());
        cmd.setDescription(state.getDescription());
        cmd.setActive(state.getActive());
        cmd.setPhysicalInventoryDocumentNumber(state.getPhysicalInventoryDocumentNumber());
            
        if (state.getLocatorId() == null) { cmd.setIsPropertyLocatorIdRemoved(true); }
        if (state.getProductId() == null) { cmd.setIsPropertyProductIdRemoved(true); }
        if (state.getAttributeSetInstanceId() == null) { cmd.setIsPropertyAttributeSetInstanceIdRemoved(true); }
        if (state.getBookQuantity() == null) { cmd.setIsPropertyBookQuantityRemoved(true); }
        if (state.getCountedQuantity() == null) { cmd.setIsPropertyCountedQuantityRemoved(true); }
        if (state.getProcessed() == null) { cmd.setIsPropertyProcessedRemoved(true); }
        if (state.getReversalLineNumber() == null) { cmd.setIsPropertyReversalLineNumberRemoved(true); }
        if (state.getDescription() == null) { cmd.setIsPropertyDescriptionRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        return cmd;
    }

    public TCreatePhysicalInventoryLine toCreatePhysicalInventoryLine(PhysicalInventoryLineState state) //where TCreatePhysicalInventoryLine : ICreatePhysicalInventoryLine, new()
    {
        TCreatePhysicalInventoryLine cmd = newCreatePhysicalInventoryLine();

        cmd.setLineNumber(state.getLineNumber());
        cmd.setLocatorId(state.getLocatorId());
        cmd.setProductId(state.getProductId());
        cmd.setAttributeSetInstanceId(state.getAttributeSetInstanceId());
        cmd.setBookQuantity(state.getBookQuantity());
        cmd.setCountedQuantity(state.getCountedQuantity());
        cmd.setProcessed(state.getProcessed());
        cmd.setReversalLineNumber(state.getReversalLineNumber());
        cmd.setDescription(state.getDescription());
        cmd.setActive(state.getActive());
        cmd.setPhysicalInventoryDocumentNumber(state.getPhysicalInventoryDocumentNumber());
        return cmd;
    }

    protected abstract TCreatePhysicalInventoryLine newCreatePhysicalInventoryLine();

    protected abstract TMergePatchPhysicalInventoryLine newMergePatchPhysicalInventoryLine(); 

    protected abstract TRemovePhysicalInventoryLine newRemovePhysicalInventoryLine();

    public static class SimplePhysicalInventoryLineStateCommandConverter extends AbstractPhysicalInventoryLineStateCommandConverter<AbstractPhysicalInventoryLineCommand.SimpleCreatePhysicalInventoryLine, AbstractPhysicalInventoryLineCommand.SimpleMergePatchPhysicalInventoryLine, AbstractPhysicalInventoryLineCommand.SimpleRemovePhysicalInventoryLine>
    {
        @Override
        protected AbstractPhysicalInventoryLineCommand.SimpleCreatePhysicalInventoryLine newCreatePhysicalInventoryLine() {
            return new AbstractPhysicalInventoryLineCommand.SimpleCreatePhysicalInventoryLine();
        }

        @Override
        protected AbstractPhysicalInventoryLineCommand.SimpleMergePatchPhysicalInventoryLine newMergePatchPhysicalInventoryLine() {
            return new AbstractPhysicalInventoryLineCommand.SimpleMergePatchPhysicalInventoryLine();
        }

        @Override
        protected AbstractPhysicalInventoryLineCommand.SimpleRemovePhysicalInventoryLine newRemovePhysicalInventoryLine() {
            return new AbstractPhysicalInventoryLineCommand.SimpleRemovePhysicalInventoryLine();
        }


    }

}

