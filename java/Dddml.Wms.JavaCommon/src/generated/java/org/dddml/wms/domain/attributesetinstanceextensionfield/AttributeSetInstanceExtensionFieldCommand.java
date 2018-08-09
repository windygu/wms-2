package org.dddml.wms.domain.attributesetinstanceextensionfield;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface AttributeSetInstanceExtensionFieldCommand extends Command
{
    String getName();

    void setName(String name);

    Long getVersion();

    void setVersion(Long version);

    static void throwOnInvalidStateTransition(AttributeSetInstanceExtensionFieldState state, Command c) {
        if (state.getVersion() == null)
        {
            if (isCommandCreate((AttributeSetInstanceExtensionFieldCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (state.getDeleted() != null && state.getDeleted())
        {
            throw DomainError.named("zombie", "Can't do anything to deleted aggregate.");
        }
        if (isCommandCreate((AttributeSetInstanceExtensionFieldCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(AttributeSetInstanceExtensionFieldCommand c) {
        return ((c instanceof AttributeSetInstanceExtensionFieldCommand.CreateAttributeSetInstanceExtensionField) 
            && (COMMAND_TYPE_CREATE.equals(c.getCommandType()) || c.getVersion().equals(AttributeSetInstanceExtensionFieldState.VERSION_NULL)));
    }

    interface CreateOrMergePatchAttributeSetInstanceExtensionField extends AttributeSetInstanceExtensionFieldCommand
    {
        String getType();

        void setType(String type);

        Integer getLength();

        void setLength(Integer length);

        String getAlias();

        void setAlias(String alias);

        String getDescription();

        void setDescription(String description);

        String getGroupId();

        void setGroupId(String groupId);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateAttributeSetInstanceExtensionField extends CreateOrMergePatchAttributeSetInstanceExtensionField
    {
    }

    interface MergePatchAttributeSetInstanceExtensionField extends CreateOrMergePatchAttributeSetInstanceExtensionField
    {
        Boolean getIsPropertyTypeRemoved();

        void setIsPropertyTypeRemoved(Boolean removed);

        Boolean getIsPropertyLengthRemoved();

        void setIsPropertyLengthRemoved(Boolean removed);

        Boolean getIsPropertyAliasRemoved();

        void setIsPropertyAliasRemoved(Boolean removed);

        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyGroupIdRemoved();

        void setIsPropertyGroupIdRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

    }

	interface DeleteAttributeSetInstanceExtensionField extends AttributeSetInstanceExtensionFieldCommand
	{
	}

}

