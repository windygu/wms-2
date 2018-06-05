package org.dddml.wms.domain.product;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractGoodIdentificationStateCommandConverter<TCreateGoodIdentification extends GoodIdentificationCommand.CreateGoodIdentification, TMergePatchGoodIdentification extends GoodIdentificationCommand.MergePatchGoodIdentification, TRemoveGoodIdentification extends GoodIdentificationCommand.RemoveGoodIdentification>
{
    public GoodIdentificationCommand toCreateOrMergePatchGoodIdentification(GoodIdentificationState state)
    {
        //where TCreateGoodIdentification : ICreateGoodIdentification, new()
        //where TMergePatchGoodIdentification : IMergePatchGoodIdentification, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateGoodIdentification(state);
        }
        else 
        {
            return toMergePatchGoodIdentification(state);
        }
    }

    public TRemoveGoodIdentification toRemoveGoodIdentification(GoodIdentificationState state) //where TRemoveGoodIdentification : IRemoveGoodIdentification, new()
    {
        TRemoveGoodIdentification cmd = newRemoveGoodIdentification();
        cmd.setGoodIdentificationTypeId(state.getGoodIdentificationTypeId());
        return cmd;
    }

    public TMergePatchGoodIdentification toMergePatchGoodIdentification(GoodIdentificationState state) //where TMergePatchGoodIdentification : IMergePatchGoodIdentification, new()
    {
        TMergePatchGoodIdentification cmd = newMergePatchGoodIdentification();

        cmd.setGoodIdentificationTypeId(state.getGoodIdentificationTypeId());
        cmd.setIdValue(state.getIdValue());
        cmd.setActive(state.getActive());
        cmd.setProductId(state.getProductId());
            
        if (state.getIdValue() == null) { cmd.setIsPropertyIdValueRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        return cmd;
    }

    public TCreateGoodIdentification toCreateGoodIdentification(GoodIdentificationState state) //where TCreateGoodIdentification : ICreateGoodIdentification, new()
    {
        TCreateGoodIdentification cmd = newCreateGoodIdentification();

        cmd.setGoodIdentificationTypeId(state.getGoodIdentificationTypeId());
        cmd.setIdValue(state.getIdValue());
        cmd.setActive(state.getActive());
        cmd.setProductId(state.getProductId());
        return cmd;
    }

    protected abstract TCreateGoodIdentification newCreateGoodIdentification();

    protected abstract TMergePatchGoodIdentification newMergePatchGoodIdentification(); 

    protected abstract TRemoveGoodIdentification newRemoveGoodIdentification();

    public static class SimpleGoodIdentificationStateCommandConverter extends AbstractGoodIdentificationStateCommandConverter<AbstractGoodIdentificationCommand.SimpleCreateGoodIdentification, AbstractGoodIdentificationCommand.SimpleMergePatchGoodIdentification, AbstractGoodIdentificationCommand.SimpleRemoveGoodIdentification>
    {
        @Override
        protected AbstractGoodIdentificationCommand.SimpleCreateGoodIdentification newCreateGoodIdentification() {
            return new AbstractGoodIdentificationCommand.SimpleCreateGoodIdentification();
        }

        @Override
        protected AbstractGoodIdentificationCommand.SimpleMergePatchGoodIdentification newMergePatchGoodIdentification() {
            return new AbstractGoodIdentificationCommand.SimpleMergePatchGoodIdentification();
        }

        @Override
        protected AbstractGoodIdentificationCommand.SimpleRemoveGoodIdentification newRemoveGoodIdentification() {
            return new AbstractGoodIdentificationCommand.SimpleRemoveGoodIdentification();
        }


    }

}

