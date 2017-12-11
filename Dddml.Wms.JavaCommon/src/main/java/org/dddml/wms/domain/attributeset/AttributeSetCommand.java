package org.dddml.wms.domain.attributeset;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface AttributeSetCommand extends Command
{
    String getAttributeSetId();

    void setAttributeSetId(String attributeSetId);

    Long getVersion();

    void setVersion(Long version);

    static void throwOnInvalidStateTransition(AttributeSetState state, Command c) {
        if (state.getVersion() == null)
        {
            if (isCommandCreate((AttributeSetCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (state.getDeleted())
        {
            throw DomainError.named("zombie", "Can't do anything to deleted aggregate.");
        }
        if (isCommandCreate((AttributeSetCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(AttributeSetCommand c) {
        return ((c instanceof AttributeSetCommand.CreateAttributeSet) 
            && c.getVersion().equals(AttributeSetState.VERSION_NULL));
    }

    interface CreateOrMergePatchAttributeSet extends AttributeSetCommand
    {
        String getName();

        void setName(String name);

        String getOrganizationId();

        void setOrganizationId(String organizationId);

        String getDescription();

        void setDescription(String description);

        String getSerialNumberAttributeId();

        void setSerialNumberAttributeId(String serialNumberAttributeId);

        String getLotAttributeId();

        void setLotAttributeId(String lotAttributeId);

        String getReferenceId();

        void setReferenceId(String referenceId);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateAttributeSet extends CreateOrMergePatchAttributeSet
    {
        CreateAttributeUseCommands getAttributeUses();

        AttributeUseCommand.CreateAttributeUse newCreateAttributeUse();

    }

    interface MergePatchAttributeSet extends CreateOrMergePatchAttributeSet
    {
        Boolean getIsPropertyNameRemoved();

        void setIsPropertyNameRemoved(Boolean removed);

        Boolean getIsPropertyOrganizationIdRemoved();

        void setIsPropertyOrganizationIdRemoved(Boolean removed);

        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertySerialNumberAttributeIdRemoved();

        void setIsPropertySerialNumberAttributeIdRemoved(Boolean removed);

        Boolean getIsPropertyLotAttributeIdRemoved();

        void setIsPropertyLotAttributeIdRemoved(Boolean removed);

        Boolean getIsPropertyReferenceIdRemoved();

        void setIsPropertyReferenceIdRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        AttributeUseCommands getAttributeUseCommands();

        AttributeUseCommand.CreateAttributeUse newCreateAttributeUse();

        AttributeUseCommand.MergePatchAttributeUse newMergePatchAttributeUse();

        AttributeUseCommand.RemoveAttributeUse newRemoveAttributeUse();

    }

	interface DeleteAttributeSet extends AttributeSetCommand
	{
	}

    interface CreateAttributeUseCommands extends Iterable<AttributeUseCommand.CreateAttributeUse>
    {
        void add(AttributeUseCommand.CreateAttributeUse c);

        void remove(AttributeUseCommand.CreateAttributeUse c);

        void clear();
    }

    interface AttributeUseCommands extends Iterable<AttributeUseCommand>
    {
        void add(AttributeUseCommand c);

        void remove(AttributeUseCommand c);

        void clear();
    }

}

