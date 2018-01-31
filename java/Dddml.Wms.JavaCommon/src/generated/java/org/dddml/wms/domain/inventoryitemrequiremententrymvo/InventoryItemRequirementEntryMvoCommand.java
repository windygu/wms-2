package org.dddml.wms.domain.inventoryitemrequiremententrymvo;

import java.util.*;
import org.dddml.wms.domain.inventoryitemrequirement.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface InventoryItemRequirementEntryMvoCommand extends Command
{
    InventoryItemRequirementEntryId getInventoryItemRequirementEntryId();

    void setInventoryItemRequirementEntryId(InventoryItemRequirementEntryId inventoryItemRequirementEntryId);

    Long getInventoryItemRequirementVersion();

    void setInventoryItemRequirementVersion(Long inventoryItemRequirementVersion);

    static void throwOnInvalidStateTransition(InventoryItemRequirementEntryMvoState state, Command c) {
        if (state.getInventoryItemRequirementVersion() == null)
        {
            if (isCommandCreate((InventoryItemRequirementEntryMvoCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (isCommandCreate((InventoryItemRequirementEntryMvoCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(InventoryItemRequirementEntryMvoCommand c) {
        return ((c instanceof InventoryItemRequirementEntryMvoCommand.CreateInventoryItemRequirementEntryMvo) 
            && c.getInventoryItemRequirementVersion().equals(InventoryItemRequirementEntryMvoState.VERSION_NULL));
    }

    interface CreateOrMergePatchInventoryItemRequirementEntryMvo extends InventoryItemRequirementEntryMvoCommand
    {
        BigDecimal getQuantity();

        void setQuantity(BigDecimal quantity);

        InventoryPRTriggeredId getSourceEventId();

        void setSourceEventId(InventoryPRTriggeredId sourceEventId);

        Long getVersion();

        void setVersion(Long version);

        Boolean getActive();

        void setActive(Boolean active);

        BigDecimal getInventoryItemRequirementQuantity();

        void setInventoryItemRequirementQuantity(BigDecimal inventoryItemRequirementQuantity);

        String getInventoryItemRequirementCreatedBy();

        void setInventoryItemRequirementCreatedBy(String inventoryItemRequirementCreatedBy);

        Date getInventoryItemRequirementCreatedAt();

        void setInventoryItemRequirementCreatedAt(Date inventoryItemRequirementCreatedAt);

        String getInventoryItemRequirementUpdatedBy();

        void setInventoryItemRequirementUpdatedBy(String inventoryItemRequirementUpdatedBy);

        Date getInventoryItemRequirementUpdatedAt();

        void setInventoryItemRequirementUpdatedAt(Date inventoryItemRequirementUpdatedAt);

    }

    interface CreateInventoryItemRequirementEntryMvo extends CreateOrMergePatchInventoryItemRequirementEntryMvo
    {
    }

    interface MergePatchInventoryItemRequirementEntryMvo extends CreateOrMergePatchInventoryItemRequirementEntryMvo
    {
        Boolean getIsPropertyQuantityRemoved();

        void setIsPropertyQuantityRemoved(Boolean removed);

        Boolean getIsPropertySourceEventIdRemoved();

        void setIsPropertySourceEventIdRemoved(Boolean removed);

        Boolean getIsPropertyVersionRemoved();

        void setIsPropertyVersionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        Boolean getIsPropertyInventoryItemRequirementQuantityRemoved();

        void setIsPropertyInventoryItemRequirementQuantityRemoved(Boolean removed);

        Boolean getIsPropertyInventoryItemRequirementCreatedByRemoved();

        void setIsPropertyInventoryItemRequirementCreatedByRemoved(Boolean removed);

        Boolean getIsPropertyInventoryItemRequirementCreatedAtRemoved();

        void setIsPropertyInventoryItemRequirementCreatedAtRemoved(Boolean removed);

        Boolean getIsPropertyInventoryItemRequirementUpdatedByRemoved();

        void setIsPropertyInventoryItemRequirementUpdatedByRemoved(Boolean removed);

        Boolean getIsPropertyInventoryItemRequirementUpdatedAtRemoved();

        void setIsPropertyInventoryItemRequirementUpdatedAtRemoved(Boolean removed);

    }

	interface DeleteInventoryItemRequirementEntryMvo extends InventoryItemRequirementEntryMvoCommand
	{
	}

}

