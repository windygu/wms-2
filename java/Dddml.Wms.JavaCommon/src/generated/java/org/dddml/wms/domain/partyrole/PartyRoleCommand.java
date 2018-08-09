package org.dddml.wms.domain.partyrole;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface PartyRoleCommand extends Command
{
    PartyRoleId getPartyRoleId();

    void setPartyRoleId(PartyRoleId partyRoleId);

    Long getVersion();

    void setVersion(Long version);

    static void throwOnInvalidStateTransition(PartyRoleState state, Command c) {
        if (state.getVersion() == null)
        {
            if (isCommandCreate((PartyRoleCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (state.getDeleted() != null && state.getDeleted())
        {
            throw DomainError.named("zombie", "Can't do anything to deleted aggregate.");
        }
        if (isCommandCreate((PartyRoleCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(PartyRoleCommand c) {
        return ((c instanceof PartyRoleCommand.CreatePartyRole) 
            && (COMMAND_TYPE_CREATE.equals(c.getCommandType()) || c.getVersion().equals(PartyRoleState.VERSION_NULL)));
    }

    interface CreateOrMergePatchPartyRole extends PartyRoleCommand
    {
        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreatePartyRole extends CreateOrMergePatchPartyRole
    {
    }

    interface MergePatchPartyRole extends CreateOrMergePatchPartyRole
    {
        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

    }

	interface DeletePartyRole extends PartyRoleCommand
	{
	}

}

