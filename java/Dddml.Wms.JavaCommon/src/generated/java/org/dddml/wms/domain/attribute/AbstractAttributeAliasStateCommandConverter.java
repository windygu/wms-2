package org.dddml.wms.domain.attribute;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractAttributeAliasStateCommandConverter<TCreateAttributeAlias extends AttributeAliasCommand.CreateAttributeAlias, TMergePatchAttributeAlias extends AttributeAliasCommand.MergePatchAttributeAlias, TRemoveAttributeAlias extends AttributeAliasCommand.RemoveAttributeAlias>
{
    public AttributeAliasCommand toCreateOrMergePatchAttributeAlias(AttributeAliasState state)
    {
        //where TCreateAttributeAlias : ICreateAttributeAlias, new()
        //where TMergePatchAttributeAlias : IMergePatchAttributeAlias, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateAttributeAlias(state);
        }
        else 
        {
            return toMergePatchAttributeAlias(state);
        }
    }

    public TRemoveAttributeAlias toRemoveAttributeAlias(AttributeAliasState state) //where TRemoveAttributeAlias : IRemoveAttributeAlias, new()
    {
        TRemoveAttributeAlias cmd = newRemoveAttributeAlias();
        cmd.setCode(state.getCode());
        return cmd;
    }

    public TMergePatchAttributeAlias toMergePatchAttributeAlias(AttributeAliasState state) //where TMergePatchAttributeAlias : IMergePatchAttributeAlias, new()
    {
        TMergePatchAttributeAlias cmd = newMergePatchAttributeAlias();

        cmd.setCode(state.getCode());
        cmd.setName(state.getName());
        cmd.setActive(state.getActive());
        cmd.setAttributeId(state.getAttributeId());
            
        if (state.getName() == null) { cmd.setIsPropertyNameRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        return cmd;
    }

    public TCreateAttributeAlias toCreateAttributeAlias(AttributeAliasState state) //where TCreateAttributeAlias : ICreateAttributeAlias, new()
    {
        TCreateAttributeAlias cmd = newCreateAttributeAlias();

        cmd.setCode(state.getCode());
        cmd.setName(state.getName());
        cmd.setActive(state.getActive());
        cmd.setAttributeId(state.getAttributeId());
        return cmd;
    }

    protected abstract TCreateAttributeAlias newCreateAttributeAlias();

    protected abstract TMergePatchAttributeAlias newMergePatchAttributeAlias(); 

    protected abstract TRemoveAttributeAlias newRemoveAttributeAlias();

    public static class SimpleAttributeAliasStateCommandConverter extends AbstractAttributeAliasStateCommandConverter<AbstractAttributeAliasCommand.SimpleCreateAttributeAlias, AbstractAttributeAliasCommand.SimpleMergePatchAttributeAlias, AbstractAttributeAliasCommand.SimpleRemoveAttributeAlias>
    {
        @Override
        protected AbstractAttributeAliasCommand.SimpleCreateAttributeAlias newCreateAttributeAlias() {
            return new AbstractAttributeAliasCommand.SimpleCreateAttributeAlias();
        }

        @Override
        protected AbstractAttributeAliasCommand.SimpleMergePatchAttributeAlias newMergePatchAttributeAlias() {
            return new AbstractAttributeAliasCommand.SimpleMergePatchAttributeAlias();
        }

        @Override
        protected AbstractAttributeAliasCommand.SimpleRemoveAttributeAlias newRemoveAttributeAlias() {
            return new AbstractAttributeAliasCommand.SimpleRemoveAttributeAlias();
        }


    }

}

