package org.dddml.wms.domain.uom;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractUomStateCommandConverter<TCreateUom extends UomCommand.CreateUom, TMergePatchUom extends UomCommand.MergePatchUom, TDeleteUom extends UomCommand.DeleteUom>
{
    public UomCommand toCreateOrMergePatchUom(UomState state)
    {
        //where TCreateUom : ICreateUom, new()
        //where TMergePatchUom : IMergePatchUom, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateUom(state);
        }
        else 
        {
            return toMergePatchUom(state);
        }
    }

    public TDeleteUom toDeleteUom(UomState state) //where TDeleteUom : IDeleteUom, new()
    {
        TDeleteUom cmd = newDeleteUom();
        cmd.setUomId(state.getUomId());
        cmd.setVersion(state.getVersion());

        return cmd;
    }

    public TMergePatchUom toMergePatchUom(UomState state) //where TMergePatchUom : IMergePatchUom, new()
    {
        TMergePatchUom cmd = newMergePatchUom();

        cmd.setVersion(state.getVersion());

        cmd.setUomId(state.getUomId());
        cmd.setUomTypeId(state.getUomTypeId());
        cmd.setAbbreviation(state.getAbbreviation());
        cmd.setDescription(state.getDescription());
        cmd.setActive(state.getActive());
            
        if (state.getUomTypeId() == null) { cmd.setIsPropertyUomTypeIdRemoved(true); }
        if (state.getAbbreviation() == null) { cmd.setIsPropertyAbbreviationRemoved(true); }
        if (state.getDescription() == null) { cmd.setIsPropertyDescriptionRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        return cmd;
    }

    public TCreateUom toCreateUom(UomState state) //where TCreateUom : ICreateUom, new()
    {
        TCreateUom cmd = newCreateUom();

        cmd.setVersion(state.getVersion());
        cmd.setUomId(state.getUomId());
        cmd.setUomTypeId(state.getUomTypeId());
        cmd.setAbbreviation(state.getAbbreviation());
        cmd.setDescription(state.getDescription());
        cmd.setActive(state.getActive());
        return cmd;
    }

    protected abstract TCreateUom newCreateUom();

    protected abstract TMergePatchUom newMergePatchUom(); 

    protected abstract TDeleteUom newDeleteUom();

    public static class SimpleUomStateCommandConverter extends AbstractUomStateCommandConverter<AbstractUomCommand.SimpleCreateUom, AbstractUomCommand.SimpleMergePatchUom, AbstractUomCommand.SimpleDeleteUom>
    {
        @Override
        protected AbstractUomCommand.SimpleCreateUom newCreateUom() {
            return new AbstractUomCommand.SimpleCreateUom();
        }

        @Override
        protected AbstractUomCommand.SimpleMergePatchUom newMergePatchUom() {
            return new AbstractUomCommand.SimpleMergePatchUom();
        }

        @Override
        protected AbstractUomCommand.SimpleDeleteUom newDeleteUom() {
            return new AbstractUomCommand.SimpleDeleteUom();
        }


    }

}

