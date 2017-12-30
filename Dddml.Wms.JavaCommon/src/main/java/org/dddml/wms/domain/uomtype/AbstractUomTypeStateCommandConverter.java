package org.dddml.wms.domain.uomtype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractUomTypeStateCommandConverter<TCreateUomType extends UomTypeCommand.CreateUomType, TMergePatchUomType extends UomTypeCommand.MergePatchUomType, TDeleteUomType extends UomTypeCommand.DeleteUomType>
{
    public UomTypeCommand toCreateOrMergePatchUomType(UomTypeState state)
    {
        //where TCreateUomType : ICreateUomType, new()
        //where TMergePatchUomType : IMergePatchUomType, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateUomType(state);
        }
        else 
        {
            return toMergePatchUomType(state);
        }
    }

    public TDeleteUomType toDeleteUomType(UomTypeState state) //where TDeleteUomType : IDeleteUomType, new()
    {
        TDeleteUomType cmd = newDeleteUomType();
        cmd.setUomTypeId(state.getUomTypeId());
        cmd.setVersion(state.getVersion());

        return cmd;
    }

    public TMergePatchUomType toMergePatchUomType(UomTypeState state) //where TMergePatchUomType : IMergePatchUomType, new()
    {
        TMergePatchUomType cmd = newMergePatchUomType();

        cmd.setVersion(state.getVersion());

        cmd.setUomTypeId(state.getUomTypeId());
        cmd.setParentTypeId(state.getParentTypeId());
        cmd.setHasTable(state.getHasTable());
        cmd.setDescription(state.getDescription());
        cmd.setActive(state.getActive());
            
        if (state.getParentTypeId() == null) { cmd.setIsPropertyParentTypeIdRemoved(true); }
        if (state.getHasTable() == null) { cmd.setIsPropertyHasTableRemoved(true); }
        if (state.getDescription() == null) { cmd.setIsPropertyDescriptionRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        return cmd;
    }

    public TCreateUomType toCreateUomType(UomTypeState state) //where TCreateUomType : ICreateUomType, new()
    {
        TCreateUomType cmd = newCreateUomType();

        cmd.setVersion(state.getVersion());
        cmd.setUomTypeId(state.getUomTypeId());
        cmd.setParentTypeId(state.getParentTypeId());
        cmd.setHasTable(state.getHasTable());
        cmd.setDescription(state.getDescription());
        cmd.setActive(state.getActive());
        return cmd;
    }

    protected abstract TCreateUomType newCreateUomType();

    protected abstract TMergePatchUomType newMergePatchUomType(); 

    protected abstract TDeleteUomType newDeleteUomType();

    public static class SimpleUomTypeStateCommandConverter extends AbstractUomTypeStateCommandConverter<AbstractUomTypeCommand.SimpleCreateUomType, AbstractUomTypeCommand.SimpleMergePatchUomType, AbstractUomTypeCommand.SimpleDeleteUomType>
    {
        @Override
        protected AbstractUomTypeCommand.SimpleCreateUomType newCreateUomType() {
            return new AbstractUomTypeCommand.SimpleCreateUomType();
        }

        @Override
        protected AbstractUomTypeCommand.SimpleMergePatchUomType newMergePatchUomType() {
            return new AbstractUomTypeCommand.SimpleMergePatchUomType();
        }

        @Override
        protected AbstractUomTypeCommand.SimpleDeleteUomType newDeleteUomType() {
            return new AbstractUomTypeCommand.SimpleDeleteUomType();
        }


    }

}

