package org.dddml.wms.domain.goodidentificationtype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractGoodIdentificationTypeStateCommandConverter<TCreateGoodIdentificationType extends GoodIdentificationTypeCommand.CreateGoodIdentificationType, TMergePatchGoodIdentificationType extends GoodIdentificationTypeCommand.MergePatchGoodIdentificationType, TDeleteGoodIdentificationType extends GoodIdentificationTypeCommand.DeleteGoodIdentificationType>
{
    public GoodIdentificationTypeCommand toCreateOrMergePatchGoodIdentificationType(GoodIdentificationTypeState state)
    {
        //where TCreateGoodIdentificationType : ICreateGoodIdentificationType, new()
        //where TMergePatchGoodIdentificationType : IMergePatchGoodIdentificationType, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateGoodIdentificationType(state);
        }
        else 
        {
            return toMergePatchGoodIdentificationType(state);
        }
    }

    public TDeleteGoodIdentificationType toDeleteGoodIdentificationType(GoodIdentificationTypeState state) //where TDeleteGoodIdentificationType : IDeleteGoodIdentificationType, new()
    {
        TDeleteGoodIdentificationType cmd = newDeleteGoodIdentificationType();
        cmd.setGoodIdentificationTypeId(state.getGoodIdentificationTypeId());
        cmd.setVersion(state.getVersion());

        return cmd;
    }

    public TMergePatchGoodIdentificationType toMergePatchGoodIdentificationType(GoodIdentificationTypeState state) //where TMergePatchGoodIdentificationType : IMergePatchGoodIdentificationType, new()
    {
        TMergePatchGoodIdentificationType cmd = newMergePatchGoodIdentificationType();

        cmd.setVersion(state.getVersion());

        cmd.setGoodIdentificationTypeId(state.getGoodIdentificationTypeId());
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

    public TCreateGoodIdentificationType toCreateGoodIdentificationType(GoodIdentificationTypeState state) //where TCreateGoodIdentificationType : ICreateGoodIdentificationType, new()
    {
        TCreateGoodIdentificationType cmd = newCreateGoodIdentificationType();

        cmd.setVersion(state.getVersion());
        cmd.setGoodIdentificationTypeId(state.getGoodIdentificationTypeId());
        cmd.setParentTypeId(state.getParentTypeId());
        cmd.setHasTable(state.getHasTable());
        cmd.setDescription(state.getDescription());
        cmd.setActive(state.getActive());
        return cmd;
    }

    protected abstract TCreateGoodIdentificationType newCreateGoodIdentificationType();

    protected abstract TMergePatchGoodIdentificationType newMergePatchGoodIdentificationType(); 

    protected abstract TDeleteGoodIdentificationType newDeleteGoodIdentificationType();

    public static class SimpleGoodIdentificationTypeStateCommandConverter extends AbstractGoodIdentificationTypeStateCommandConverter<AbstractGoodIdentificationTypeCommand.SimpleCreateGoodIdentificationType, AbstractGoodIdentificationTypeCommand.SimpleMergePatchGoodIdentificationType, AbstractGoodIdentificationTypeCommand.SimpleDeleteGoodIdentificationType>
    {
        @Override
        protected AbstractGoodIdentificationTypeCommand.SimpleCreateGoodIdentificationType newCreateGoodIdentificationType() {
            return new AbstractGoodIdentificationTypeCommand.SimpleCreateGoodIdentificationType();
        }

        @Override
        protected AbstractGoodIdentificationTypeCommand.SimpleMergePatchGoodIdentificationType newMergePatchGoodIdentificationType() {
            return new AbstractGoodIdentificationTypeCommand.SimpleMergePatchGoodIdentificationType();
        }

        @Override
        protected AbstractGoodIdentificationTypeCommand.SimpleDeleteGoodIdentificationType newDeleteGoodIdentificationType() {
            return new AbstractGoodIdentificationTypeCommand.SimpleDeleteGoodIdentificationType();
        }


    }

}

