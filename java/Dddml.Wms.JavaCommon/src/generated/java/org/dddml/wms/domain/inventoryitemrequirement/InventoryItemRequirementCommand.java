package org.dddml.wms.domain.inventoryitemrequirement;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryprtriggered.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface InventoryItemRequirementCommand extends Command
{
    InventoryItemId getInventoryItemRequirementId();

    void setInventoryItemRequirementId(InventoryItemId inventoryItemRequirementId);

    Long getVersion();

    void setVersion(Long version);

    static void throwOnInvalidStateTransition(InventoryItemRequirementState state, Command c) {
        if (state.getVersion() == null)
        {
            if (isCommandCreate((InventoryItemRequirementCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (isCommandCreate((InventoryItemRequirementCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(InventoryItemRequirementCommand c) {
        return ((c instanceof InventoryItemRequirementCommand.CreateInventoryItemRequirement) 
            && (COMMAND_TYPE_CREATE.equals(c.getCommandType()) || c.getVersion().equals(InventoryItemRequirementState.VERSION_NULL)));
    }

    interface CreateOrMergePatchInventoryItemRequirement extends InventoryItemRequirementCommand
    {
        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateInventoryItemRequirement extends CreateOrMergePatchInventoryItemRequirement
    {
        CreateInventoryItemRequirementEntryCommandCollection getCreateInventoryItemRequirementEntryCommands();

        InventoryItemRequirementEntryCommand.CreateInventoryItemRequirementEntry newCreateInventoryItemRequirementEntry();

    }

    interface MergePatchInventoryItemRequirement extends CreateOrMergePatchInventoryItemRequirement
    {
        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        InventoryItemRequirementEntryCommandCollection getInventoryItemRequirementEntryCommands();

        InventoryItemRequirementEntryCommand.CreateInventoryItemRequirementEntry newCreateInventoryItemRequirementEntry();

    }

	interface DeleteInventoryItemRequirement extends InventoryItemRequirementCommand
	{
	}

    interface CreateInventoryItemRequirementEntryCommandCollection extends Iterable<InventoryItemRequirementEntryCommand.CreateInventoryItemRequirementEntry>
    {
        void add(InventoryItemRequirementEntryCommand.CreateInventoryItemRequirementEntry c);

        void remove(InventoryItemRequirementEntryCommand.CreateInventoryItemRequirementEntry c);

        void clear();
    }

    interface InventoryItemRequirementEntryCommandCollection extends Iterable<InventoryItemRequirementEntryCommand>
    {
        void add(InventoryItemRequirementEntryCommand c);

        void remove(InventoryItemRequirementEntryCommand c);

        void clear();
    }

}

