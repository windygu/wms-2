package org.dddml.wms.domain.attributesetinstanceextensionfield;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractAttributeSetInstanceExtensionFieldStateCommandConverter<TCreateAttributeSetInstanceExtensionField extends AttributeSetInstanceExtensionFieldCommand.CreateAttributeSetInstanceExtensionField, TMergePatchAttributeSetInstanceExtensionField extends AttributeSetInstanceExtensionFieldCommand.MergePatchAttributeSetInstanceExtensionField, TDeleteAttributeSetInstanceExtensionField extends AttributeSetInstanceExtensionFieldCommand.DeleteAttributeSetInstanceExtensionField>
{
    public AttributeSetInstanceExtensionFieldCommand toCreateOrMergePatchAttributeSetInstanceExtensionField(AttributeSetInstanceExtensionFieldState state)
    {
        //where TCreateAttributeSetInstanceExtensionField : ICreateAttributeSetInstanceExtensionField, new()
        //where TMergePatchAttributeSetInstanceExtensionField : IMergePatchAttributeSetInstanceExtensionField, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateAttributeSetInstanceExtensionField(state);
        }
        else 
        {
            return toMergePatchAttributeSetInstanceExtensionField(state);
        }
    }

    public TDeleteAttributeSetInstanceExtensionField toDeleteAttributeSetInstanceExtensionField(AttributeSetInstanceExtensionFieldState state) //where TDeleteAttributeSetInstanceExtensionField : IDeleteAttributeSetInstanceExtensionField, new()
    {
        TDeleteAttributeSetInstanceExtensionField cmd = newDeleteAttributeSetInstanceExtensionField();
        cmd.setName(state.getName());
        cmd.setVersion(state.getVersion());

        return cmd;
    }

    public TMergePatchAttributeSetInstanceExtensionField toMergePatchAttributeSetInstanceExtensionField(AttributeSetInstanceExtensionFieldState state) //where TMergePatchAttributeSetInstanceExtensionField : IMergePatchAttributeSetInstanceExtensionField, new()
    {
        TMergePatchAttributeSetInstanceExtensionField cmd = newMergePatchAttributeSetInstanceExtensionField();

        cmd.setVersion(state.getVersion());

        cmd.setName(state.getName());
        cmd.setType(state.getType());
        cmd.setLength(state.getLength());
        cmd.setAlias(state.getAlias());
        cmd.setDescription(state.getDescription());
        cmd.setGroupId(state.getGroupId());
        cmd.setActive(state.getActive());
            
        if (state.getType() == null) { cmd.setIsPropertyTypeRemoved(true); }
        if (state.getLength() == null) { cmd.setIsPropertyLengthRemoved(true); }
        if (state.getAlias() == null) { cmd.setIsPropertyAliasRemoved(true); }
        if (state.getDescription() == null) { cmd.setIsPropertyDescriptionRemoved(true); }
        if (state.getGroupId() == null) { cmd.setIsPropertyGroupIdRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        return cmd;
    }

    public TCreateAttributeSetInstanceExtensionField toCreateAttributeSetInstanceExtensionField(AttributeSetInstanceExtensionFieldState state) //where TCreateAttributeSetInstanceExtensionField : ICreateAttributeSetInstanceExtensionField, new()
    {
        TCreateAttributeSetInstanceExtensionField cmd = newCreateAttributeSetInstanceExtensionField();

        cmd.setVersion(state.getVersion());
        cmd.setName(state.getName());
        cmd.setType(state.getType());
        cmd.setLength(state.getLength());
        cmd.setAlias(state.getAlias());
        cmd.setDescription(state.getDescription());
        cmd.setGroupId(state.getGroupId());
        cmd.setActive(state.getActive());
        return cmd;
    }

    protected abstract TCreateAttributeSetInstanceExtensionField newCreateAttributeSetInstanceExtensionField();

    protected abstract TMergePatchAttributeSetInstanceExtensionField newMergePatchAttributeSetInstanceExtensionField(); 

    protected abstract TDeleteAttributeSetInstanceExtensionField newDeleteAttributeSetInstanceExtensionField();

    public static class SimpleAttributeSetInstanceExtensionFieldStateCommandConverter extends AbstractAttributeSetInstanceExtensionFieldStateCommandConverter<AbstractAttributeSetInstanceExtensionFieldCommand.SimpleCreateAttributeSetInstanceExtensionField, AbstractAttributeSetInstanceExtensionFieldCommand.SimpleMergePatchAttributeSetInstanceExtensionField, AbstractAttributeSetInstanceExtensionFieldCommand.SimpleDeleteAttributeSetInstanceExtensionField>
    {
        @Override
        protected AbstractAttributeSetInstanceExtensionFieldCommand.SimpleCreateAttributeSetInstanceExtensionField newCreateAttributeSetInstanceExtensionField() {
            return new AbstractAttributeSetInstanceExtensionFieldCommand.SimpleCreateAttributeSetInstanceExtensionField();
        }

        @Override
        protected AbstractAttributeSetInstanceExtensionFieldCommand.SimpleMergePatchAttributeSetInstanceExtensionField newMergePatchAttributeSetInstanceExtensionField() {
            return new AbstractAttributeSetInstanceExtensionFieldCommand.SimpleMergePatchAttributeSetInstanceExtensionField();
        }

        @Override
        protected AbstractAttributeSetInstanceExtensionFieldCommand.SimpleDeleteAttributeSetInstanceExtensionField newDeleteAttributeSetInstanceExtensionField() {
            return new AbstractAttributeSetInstanceExtensionFieldCommand.SimpleDeleteAttributeSetInstanceExtensionField();
        }


    }

}

