package org.dddml.wms.domain.attributealiasmvo;

import java.util.*;
import org.dddml.wms.domain.attribute.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractAttributeAliasMvoStateCommandConverter<TCreateAttributeAliasMvo extends AttributeAliasMvoCommand.CreateAttributeAliasMvo, TMergePatchAttributeAliasMvo extends AttributeAliasMvoCommand.MergePatchAttributeAliasMvo, TDeleteAttributeAliasMvo extends AttributeAliasMvoCommand.DeleteAttributeAliasMvo>
{
    public AttributeAliasMvoCommand toCreateOrMergePatchAttributeAliasMvo(AttributeAliasMvoState state)
    {
        //where TCreateAttributeAliasMvo : ICreateAttributeAliasMvo, new()
        //where TMergePatchAttributeAliasMvo : IMergePatchAttributeAliasMvo, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateAttributeAliasMvo(state);
        }
        else 
        {
            return toMergePatchAttributeAliasMvo(state);
        }
    }

    public TDeleteAttributeAliasMvo toDeleteAttributeAliasMvo(AttributeAliasMvoState state) //where TDeleteAttributeAliasMvo : IDeleteAttributeAliasMvo, new()
    {
        TDeleteAttributeAliasMvo cmd = newDeleteAttributeAliasMvo();
        cmd.setAttributeAliasId(state.getAttributeAliasId());
        cmd.setAttributeVersion(state.getAttributeVersion());

        return cmd;
    }

    public TMergePatchAttributeAliasMvo toMergePatchAttributeAliasMvo(AttributeAliasMvoState state) //where TMergePatchAttributeAliasMvo : IMergePatchAttributeAliasMvo, new()
    {
        TMergePatchAttributeAliasMvo cmd = newMergePatchAttributeAliasMvo();

        cmd.setAttributeVersion(state.getAttributeVersion());

        cmd.setAttributeAliasId(state.getAttributeAliasId());
        cmd.setName(state.getName());
        cmd.setVersion(state.getVersion());
        cmd.setActive(state.getActive());
        cmd.setAttributeAttributeName(state.getAttributeAttributeName());
        cmd.setAttributeOrganizationId(state.getAttributeOrganizationId());
        cmd.setAttributeDescription(state.getAttributeDescription());
        cmd.setAttributeIsMandatory(state.getAttributeIsMandatory());
        cmd.setAttributeIsInstanceAttribute(state.getAttributeIsInstanceAttribute());
        cmd.setAttributeAttributeValueType(state.getAttributeAttributeValueType());
        cmd.setAttributeAttributeValueLength(state.getAttributeAttributeValueLength());
        cmd.setAttributeIsList(state.getAttributeIsList());
        cmd.setAttributeFieldName(state.getAttributeFieldName());
        cmd.setAttributeReferenceId(state.getAttributeReferenceId());
        cmd.setAttributeCreatedBy(state.getAttributeCreatedBy());
        cmd.setAttributeCreatedAt(state.getAttributeCreatedAt());
        cmd.setAttributeUpdatedBy(state.getAttributeUpdatedBy());
        cmd.setAttributeUpdatedAt(state.getAttributeUpdatedAt());
        cmd.setAttributeActive(state.getAttributeActive());
        cmd.setAttributeDeleted(state.getAttributeDeleted());
            
        if (state.getName() == null) { cmd.setIsPropertyNameRemoved(true); }
        if (state.getVersion() == null) { cmd.setIsPropertyVersionRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        if (state.getAttributeAttributeName() == null) { cmd.setIsPropertyAttributeAttributeNameRemoved(true); }
        if (state.getAttributeOrganizationId() == null) { cmd.setIsPropertyAttributeOrganizationIdRemoved(true); }
        if (state.getAttributeDescription() == null) { cmd.setIsPropertyAttributeDescriptionRemoved(true); }
        if (state.getAttributeIsMandatory() == null) { cmd.setIsPropertyAttributeIsMandatoryRemoved(true); }
        if (state.getAttributeIsInstanceAttribute() == null) { cmd.setIsPropertyAttributeIsInstanceAttributeRemoved(true); }
        if (state.getAttributeAttributeValueType() == null) { cmd.setIsPropertyAttributeAttributeValueTypeRemoved(true); }
        if (state.getAttributeAttributeValueLength() == null) { cmd.setIsPropertyAttributeAttributeValueLengthRemoved(true); }
        if (state.getAttributeIsList() == null) { cmd.setIsPropertyAttributeIsListRemoved(true); }
        if (state.getAttributeFieldName() == null) { cmd.setIsPropertyAttributeFieldNameRemoved(true); }
        if (state.getAttributeReferenceId() == null) { cmd.setIsPropertyAttributeReferenceIdRemoved(true); }
        if (state.getAttributeCreatedBy() == null) { cmd.setIsPropertyAttributeCreatedByRemoved(true); }
        if (state.getAttributeCreatedAt() == null) { cmd.setIsPropertyAttributeCreatedAtRemoved(true); }
        if (state.getAttributeUpdatedBy() == null) { cmd.setIsPropertyAttributeUpdatedByRemoved(true); }
        if (state.getAttributeUpdatedAt() == null) { cmd.setIsPropertyAttributeUpdatedAtRemoved(true); }
        if (state.getAttributeActive() == null) { cmd.setIsPropertyAttributeActiveRemoved(true); }
        if (state.getAttributeDeleted() == null) { cmd.setIsPropertyAttributeDeletedRemoved(true); }
        return cmd;
    }

    public TCreateAttributeAliasMvo toCreateAttributeAliasMvo(AttributeAliasMvoState state) //where TCreateAttributeAliasMvo : ICreateAttributeAliasMvo, new()
    {
        TCreateAttributeAliasMvo cmd = newCreateAttributeAliasMvo();

        cmd.setAttributeVersion(state.getAttributeVersion());
        cmd.setAttributeAliasId(state.getAttributeAliasId());
        cmd.setName(state.getName());
        cmd.setVersion(state.getVersion());
        cmd.setActive(state.getActive());
        cmd.setAttributeAttributeName(state.getAttributeAttributeName());
        cmd.setAttributeOrganizationId(state.getAttributeOrganizationId());
        cmd.setAttributeDescription(state.getAttributeDescription());
        cmd.setAttributeIsMandatory(state.getAttributeIsMandatory());
        cmd.setAttributeIsInstanceAttribute(state.getAttributeIsInstanceAttribute());
        cmd.setAttributeAttributeValueType(state.getAttributeAttributeValueType());
        cmd.setAttributeAttributeValueLength(state.getAttributeAttributeValueLength());
        cmd.setAttributeIsList(state.getAttributeIsList());
        cmd.setAttributeFieldName(state.getAttributeFieldName());
        cmd.setAttributeReferenceId(state.getAttributeReferenceId());
        cmd.setAttributeCreatedBy(state.getAttributeCreatedBy());
        cmd.setAttributeCreatedAt(state.getAttributeCreatedAt());
        cmd.setAttributeUpdatedBy(state.getAttributeUpdatedBy());
        cmd.setAttributeUpdatedAt(state.getAttributeUpdatedAt());
        cmd.setAttributeActive(state.getAttributeActive());
        cmd.setAttributeDeleted(state.getAttributeDeleted());
        return cmd;
    }

    protected abstract TCreateAttributeAliasMvo newCreateAttributeAliasMvo();

    protected abstract TMergePatchAttributeAliasMvo newMergePatchAttributeAliasMvo(); 

    protected abstract TDeleteAttributeAliasMvo newDeleteAttributeAliasMvo();

    public static class SimpleAttributeAliasMvoStateCommandConverter extends AbstractAttributeAliasMvoStateCommandConverter<AbstractAttributeAliasMvoCommand.SimpleCreateAttributeAliasMvo, AbstractAttributeAliasMvoCommand.SimpleMergePatchAttributeAliasMvo, AbstractAttributeAliasMvoCommand.SimpleDeleteAttributeAliasMvo>
    {
        @Override
        protected AbstractAttributeAliasMvoCommand.SimpleCreateAttributeAliasMvo newCreateAttributeAliasMvo() {
            return new AbstractAttributeAliasMvoCommand.SimpleCreateAttributeAliasMvo();
        }

        @Override
        protected AbstractAttributeAliasMvoCommand.SimpleMergePatchAttributeAliasMvo newMergePatchAttributeAliasMvo() {
            return new AbstractAttributeAliasMvoCommand.SimpleMergePatchAttributeAliasMvo();
        }

        @Override
        protected AbstractAttributeAliasMvoCommand.SimpleDeleteAttributeAliasMvo newDeleteAttributeAliasMvo() {
            return new AbstractAttributeAliasMvoCommand.SimpleDeleteAttributeAliasMvo();
        }


    }

}

