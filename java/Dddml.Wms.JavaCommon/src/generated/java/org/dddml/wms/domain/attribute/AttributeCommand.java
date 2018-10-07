package org.dddml.wms.domain.attribute;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface AttributeCommand extends Command
{
    String getAttributeId();

    void setAttributeId(String attributeId);

    Long getVersion();

    void setVersion(Long version);

    static void throwOnInvalidStateTransition(AttributeState state, Command c) {
        if (state.getVersion() == null)
        {
            if (isCommandCreate((AttributeCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (state.getDeleted() != null && state.getDeleted())
        {
            throw DomainError.named("zombie", "Can't do anything to deleted aggregate.");
        }
        if (isCommandCreate((AttributeCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(AttributeCommand c) {
        return ((c instanceof AttributeCommand.CreateAttribute) 
            && (COMMAND_TYPE_CREATE.equals(c.getCommandType()) || c.getVersion().equals(AttributeState.VERSION_NULL)));
    }

    interface CreateOrMergePatchAttribute extends AttributeCommand
    {
        String getAttributeName();

        void setAttributeName(String attributeName);

        String getOrganizationId();

        void setOrganizationId(String organizationId);

        String getDescription();

        void setDescription(String description);

        Boolean getIsMandatory();

        void setIsMandatory(Boolean isMandatory);

        String getAttributeValueType();

        void setAttributeValueType(String attributeValueType);

        Integer getAttributeValueLength();

        void setAttributeValueLength(Integer attributeValueLength);

        Boolean getIsList();

        void setIsList(Boolean isList);

        String getFieldName();

        void setFieldName(String fieldName);

        String getReferenceId();

        void setReferenceId(String referenceId);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateAttribute extends CreateOrMergePatchAttribute
    {
        CreateAttributeValueCommandCollection getCreateAttributeValueCommands();

        AttributeValueCommand.CreateAttributeValue newCreateAttributeValue();

        CreateAttributeAliasCommandCollection getCreateAttributeAliasCommands();

        AttributeAliasCommand.CreateAttributeAlias newCreateAttributeAlias();

    }

    interface MergePatchAttribute extends CreateOrMergePatchAttribute
    {
        Boolean getIsPropertyAttributeNameRemoved();

        void setIsPropertyAttributeNameRemoved(Boolean removed);

        Boolean getIsPropertyOrganizationIdRemoved();

        void setIsPropertyOrganizationIdRemoved(Boolean removed);

        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyIsMandatoryRemoved();

        void setIsPropertyIsMandatoryRemoved(Boolean removed);

        Boolean getIsPropertyAttributeValueTypeRemoved();

        void setIsPropertyAttributeValueTypeRemoved(Boolean removed);

        Boolean getIsPropertyAttributeValueLengthRemoved();

        void setIsPropertyAttributeValueLengthRemoved(Boolean removed);

        Boolean getIsPropertyIsListRemoved();

        void setIsPropertyIsListRemoved(Boolean removed);

        Boolean getIsPropertyFieldNameRemoved();

        void setIsPropertyFieldNameRemoved(Boolean removed);

        Boolean getIsPropertyReferenceIdRemoved();

        void setIsPropertyReferenceIdRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        AttributeValueCommandCollection getAttributeValueCommands();

        AttributeValueCommand.CreateAttributeValue newCreateAttributeValue();

        AttributeValueCommand.MergePatchAttributeValue newMergePatchAttributeValue();

        AttributeValueCommand.RemoveAttributeValue newRemoveAttributeValue();

        AttributeAliasCommandCollection getAttributeAliasCommands();

        AttributeAliasCommand.CreateAttributeAlias newCreateAttributeAlias();

        AttributeAliasCommand.MergePatchAttributeAlias newMergePatchAttributeAlias();

        AttributeAliasCommand.RemoveAttributeAlias newRemoveAttributeAlias();

    }

	interface DeleteAttribute extends AttributeCommand
	{
	}

    interface CreateAttributeValueCommandCollection extends Iterable<AttributeValueCommand.CreateAttributeValue>
    {
        void add(AttributeValueCommand.CreateAttributeValue c);

        void remove(AttributeValueCommand.CreateAttributeValue c);

        void clear();
    }

    interface AttributeValueCommandCollection extends Iterable<AttributeValueCommand>
    {
        void add(AttributeValueCommand c);

        void remove(AttributeValueCommand c);

        void clear();
    }

    interface CreateAttributeAliasCommandCollection extends Iterable<AttributeAliasCommand.CreateAttributeAlias>
    {
        void add(AttributeAliasCommand.CreateAttributeAlias c);

        void remove(AttributeAliasCommand.CreateAttributeAlias c);

        void clear();
    }

    interface AttributeAliasCommandCollection extends Iterable<AttributeAliasCommand>
    {
        void add(AttributeAliasCommand c);

        void remove(AttributeAliasCommand c);

        void clear();
    }

}

