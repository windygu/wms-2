package org.dddml.wms.domain.uomconversion;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractUomConversionStateCommandConverter<TCreateUomConversion extends UomConversionCommand.CreateUomConversion, TMergePatchUomConversion extends UomConversionCommand.MergePatchUomConversion, TDeleteUomConversion extends UomConversionCommand.DeleteUomConversion>
{
    public UomConversionCommand toCreateOrMergePatchUomConversion(UomConversionState state)
    {
        //where TCreateUomConversion : ICreateUomConversion, new()
        //where TMergePatchUomConversion : IMergePatchUomConversion, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateUomConversion(state);
        }
        else 
        {
            return toMergePatchUomConversion(state);
        }
    }

    public TDeleteUomConversion toDeleteUomConversion(UomConversionState state) //where TDeleteUomConversion : IDeleteUomConversion, new()
    {
        TDeleteUomConversion cmd = newDeleteUomConversion();
        cmd.setUomConversionId(state.getUomConversionId());
        cmd.setVersion(state.getVersion());

        return cmd;
    }

    public TMergePatchUomConversion toMergePatchUomConversion(UomConversionState state) //where TMergePatchUomConversion : IMergePatchUomConversion, new()
    {
        TMergePatchUomConversion cmd = newMergePatchUomConversion();

        cmd.setVersion(state.getVersion());

        cmd.setUomConversionId(state.getUomConversionId());
        cmd.setConversionFactor(state.getConversionFactor());
        cmd.setCustomMethodId(state.getCustomMethodId());
        cmd.setDecimalScale(state.getDecimalScale());
        cmd.setRoundingMode(state.getRoundingMode());
        cmd.setActive(state.getActive());
            
        if (state.getConversionFactor() == null) { cmd.setIsPropertyConversionFactorRemoved(true); }
        if (state.getCustomMethodId() == null) { cmd.setIsPropertyCustomMethodIdRemoved(true); }
        if (state.getDecimalScale() == null) { cmd.setIsPropertyDecimalScaleRemoved(true); }
        if (state.getRoundingMode() == null) { cmd.setIsPropertyRoundingModeRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        return cmd;
    }

    public TCreateUomConversion toCreateUomConversion(UomConversionState state) //where TCreateUomConversion : ICreateUomConversion, new()
    {
        TCreateUomConversion cmd = newCreateUomConversion();

        cmd.setVersion(state.getVersion());
        cmd.setUomConversionId(state.getUomConversionId());
        cmd.setConversionFactor(state.getConversionFactor());
        cmd.setCustomMethodId(state.getCustomMethodId());
        cmd.setDecimalScale(state.getDecimalScale());
        cmd.setRoundingMode(state.getRoundingMode());
        cmd.setActive(state.getActive());
        return cmd;
    }

    protected abstract TCreateUomConversion newCreateUomConversion();

    protected abstract TMergePatchUomConversion newMergePatchUomConversion(); 

    protected abstract TDeleteUomConversion newDeleteUomConversion();

    public static class SimpleUomConversionStateCommandConverter extends AbstractUomConversionStateCommandConverter<AbstractUomConversionCommand.SimpleCreateUomConversion, AbstractUomConversionCommand.SimpleMergePatchUomConversion, AbstractUomConversionCommand.SimpleDeleteUomConversion>
    {
        @Override
        protected AbstractUomConversionCommand.SimpleCreateUomConversion newCreateUomConversion() {
            return new AbstractUomConversionCommand.SimpleCreateUomConversion();
        }

        @Override
        protected AbstractUomConversionCommand.SimpleMergePatchUomConversion newMergePatchUomConversion() {
            return new AbstractUomConversionCommand.SimpleMergePatchUomConversion();
        }

        @Override
        protected AbstractUomConversionCommand.SimpleDeleteUomConversion newDeleteUomConversion() {
            return new AbstractUomConversionCommand.SimpleDeleteUomConversion();
        }


    }

}

