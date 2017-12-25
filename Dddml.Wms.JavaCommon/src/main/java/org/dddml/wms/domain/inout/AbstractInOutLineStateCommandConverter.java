package org.dddml.wms.domain.inout;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractInOutLineStateCommandConverter<TCreateInOutLine extends InOutLineCommand.CreateInOutLine, TMergePatchInOutLine extends InOutLineCommand.MergePatchInOutLine, TRemoveInOutLine extends InOutLineCommand.RemoveInOutLine>
{
    public InOutLineCommand toCreateOrMergePatchInOutLine(InOutLineState state)
    {
        //where TCreateInOutLine : ICreateInOutLine, new()
        //where TMergePatchInOutLine : IMergePatchInOutLine, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateInOutLine(state);
        }
        else 
        {
            return toMergePatchInOutLine(state);
        }
    }

    public TRemoveInOutLine toRemoveInOutLine(InOutLineState state) //where TRemoveInOutLine : IRemoveInOutLine, new()
    {
        TRemoveInOutLine cmd = newRemoveInOutLine();
        cmd.setLineNumber(state.getLineNumber());
        return cmd;
    }

    public TMergePatchInOutLine toMergePatchInOutLine(InOutLineState state) //where TMergePatchInOutLine : IMergePatchInOutLine, new()
    {
        TMergePatchInOutLine cmd = newMergePatchInOutLine();

        cmd.setLineNumber(state.getLineNumber());
        cmd.setLocatorId(state.getLocatorId());
        cmd.setProductId(state.getProductId());
        cmd.setAttributeSetInstanceId(state.getAttributeSetInstanceId());
        cmd.setDescription(state.getDescription());
        cmd.setUomId(state.getUomId());
        cmd.setMovementQuantity(state.getMovementQuantity());
        cmd.setPickedQuantity(state.getPickedQuantity());
        cmd.setIsInvoiced(state.getIsInvoiced());
        cmd.setProcessed(state.getProcessed());
        cmd.setRmaLineNumber(state.getRmaLineNumber());
        cmd.setReversalLineNumber(state.getReversalLineNumber());
        cmd.setActive(state.getActive());
        cmd.setInOutDocumentNumber(state.getInOutDocumentNumber());
            
        if (state.getLocatorId() == null) { cmd.setIsPropertyLocatorIdRemoved(true); }
        if (state.getProductId() == null) { cmd.setIsPropertyProductIdRemoved(true); }
        if (state.getAttributeSetInstanceId() == null) { cmd.setIsPropertyAttributeSetInstanceIdRemoved(true); }
        if (state.getDescription() == null) { cmd.setIsPropertyDescriptionRemoved(true); }
        if (state.getUomId() == null) { cmd.setIsPropertyUomIdRemoved(true); }
        if (state.getMovementQuantity() == null) { cmd.setIsPropertyMovementQuantityRemoved(true); }
        if (state.getPickedQuantity() == null) { cmd.setIsPropertyPickedQuantityRemoved(true); }
        if (state.getIsInvoiced() == null) { cmd.setIsPropertyIsInvoicedRemoved(true); }
        if (state.getProcessed() == null) { cmd.setIsPropertyProcessedRemoved(true); }
        if (state.getRmaLineNumber() == null) { cmd.setIsPropertyRmaLineNumberRemoved(true); }
        if (state.getReversalLineNumber() == null) { cmd.setIsPropertyReversalLineNumberRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        return cmd;
    }

    public TCreateInOutLine toCreateInOutLine(InOutLineState state) //where TCreateInOutLine : ICreateInOutLine, new()
    {
        TCreateInOutLine cmd = newCreateInOutLine();

        cmd.setLineNumber(state.getLineNumber());
        cmd.setLocatorId(state.getLocatorId());
        cmd.setProductId(state.getProductId());
        cmd.setAttributeSetInstanceId(state.getAttributeSetInstanceId());
        cmd.setDescription(state.getDescription());
        cmd.setUomId(state.getUomId());
        cmd.setMovementQuantity(state.getMovementQuantity());
        cmd.setPickedQuantity(state.getPickedQuantity());
        cmd.setIsInvoiced(state.getIsInvoiced());
        cmd.setProcessed(state.getProcessed());
        cmd.setRmaLineNumber(state.getRmaLineNumber());
        cmd.setReversalLineNumber(state.getReversalLineNumber());
        cmd.setActive(state.getActive());
        cmd.setInOutDocumentNumber(state.getInOutDocumentNumber());
        return cmd;
    }

    protected abstract TCreateInOutLine newCreateInOutLine();

    protected abstract TMergePatchInOutLine newMergePatchInOutLine(); 

    protected abstract TRemoveInOutLine newRemoveInOutLine();

    public static class SimpleInOutLineStateCommandConverter extends AbstractInOutLineStateCommandConverter<AbstractInOutLineCommand.SimpleCreateInOutLine, AbstractInOutLineCommand.SimpleMergePatchInOutLine, AbstractInOutLineCommand.SimpleRemoveInOutLine>
    {
        @Override
        protected AbstractInOutLineCommand.SimpleCreateInOutLine newCreateInOutLine() {
            return new AbstractInOutLineCommand.SimpleCreateInOutLine();
        }

        @Override
        protected AbstractInOutLineCommand.SimpleMergePatchInOutLine newMergePatchInOutLine() {
            return new AbstractInOutLineCommand.SimpleMergePatchInOutLine();
        }

        @Override
        protected AbstractInOutLineCommand.SimpleRemoveInOutLine newRemoveInOutLine() {
            return new AbstractInOutLineCommand.SimpleRemoveInOutLine();
        }


    }

}

