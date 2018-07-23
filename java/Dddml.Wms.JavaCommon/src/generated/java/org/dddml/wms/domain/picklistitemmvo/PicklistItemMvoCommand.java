package org.dddml.wms.domain.picklistitemmvo;

import java.util.*;
import org.dddml.wms.domain.picklistbin.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface PicklistItemMvoCommand extends Command
{
    PicklistBinPicklistItemId getPicklistBinPicklistItemId();

    void setPicklistBinPicklistItemId(PicklistBinPicklistItemId picklistBinPicklistItemId);

    Long getPicklistBinVersion();

    void setPicklistBinVersion(Long picklistBinVersion);

    static void throwOnInvalidStateTransition(PicklistItemMvoState state, Command c) {
        if (state.getPicklistBinVersion() == null)
        {
            if (isCommandCreate((PicklistItemMvoCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (state.getDeleted() != null && state.getDeleted())
        {
            throw DomainError.named("zombie", "Can't do anything to deleted aggregate.");
        }
        if (isCommandCreate((PicklistItemMvoCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(PicklistItemMvoCommand c) {
        return ((c instanceof PicklistItemMvoCommand.CreatePicklistItemMvo) 
            && c.getPicklistBinVersion().equals(PicklistItemMvoState.VERSION_NULL));
    }

    interface CreateOrMergePatchPicklistItemMvo extends PicklistItemMvoCommand
    {
        String getItemStatusId();

        void setItemStatusId(String itemStatusId);

        java.math.BigDecimal getQuantity();

        void setQuantity(java.math.BigDecimal quantity);

        Long getVersion();

        void setVersion(Long version);

        Boolean getActive();

        void setActive(Boolean active);

        String getPicklistBinPicklistId();

        void setPicklistBinPicklistId(String picklistBinPicklistId);

        Long getPicklistBinBinLocationNumber();

        void setPicklistBinBinLocationNumber(Long picklistBinBinLocationNumber);

        String getPicklistBinPrimaryOrderId();

        void setPicklistBinPrimaryOrderId(String picklistBinPrimaryOrderId);

        Long getPicklistBinPrimaryShipGroupSeqId();

        void setPicklistBinPrimaryShipGroupSeqId(Long picklistBinPrimaryShipGroupSeqId);

        String getPicklistBinCreatedBy();

        void setPicklistBinCreatedBy(String picklistBinCreatedBy);

        Date getPicklistBinCreatedAt();

        void setPicklistBinCreatedAt(Date picklistBinCreatedAt);

        String getPicklistBinUpdatedBy();

        void setPicklistBinUpdatedBy(String picklistBinUpdatedBy);

        Date getPicklistBinUpdatedAt();

        void setPicklistBinUpdatedAt(Date picklistBinUpdatedAt);

        Boolean getPicklistBinActive();

        void setPicklistBinActive(Boolean picklistBinActive);

        Boolean getPicklistBinDeleted();

        void setPicklistBinDeleted(Boolean picklistBinDeleted);

    }

    interface CreatePicklistItemMvo extends CreateOrMergePatchPicklistItemMvo
    {
    }

    interface MergePatchPicklistItemMvo extends CreateOrMergePatchPicklistItemMvo
    {
        Boolean getIsPropertyItemStatusIdRemoved();

        void setIsPropertyItemStatusIdRemoved(Boolean removed);

        Boolean getIsPropertyQuantityRemoved();

        void setIsPropertyQuantityRemoved(Boolean removed);

        Boolean getIsPropertyVersionRemoved();

        void setIsPropertyVersionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        Boolean getIsPropertyPicklistBinPicklistIdRemoved();

        void setIsPropertyPicklistBinPicklistIdRemoved(Boolean removed);

        Boolean getIsPropertyPicklistBinBinLocationNumberRemoved();

        void setIsPropertyPicklistBinBinLocationNumberRemoved(Boolean removed);

        Boolean getIsPropertyPicklistBinPrimaryOrderIdRemoved();

        void setIsPropertyPicklistBinPrimaryOrderIdRemoved(Boolean removed);

        Boolean getIsPropertyPicklistBinPrimaryShipGroupSeqIdRemoved();

        void setIsPropertyPicklistBinPrimaryShipGroupSeqIdRemoved(Boolean removed);

        Boolean getIsPropertyPicklistBinCreatedByRemoved();

        void setIsPropertyPicklistBinCreatedByRemoved(Boolean removed);

        Boolean getIsPropertyPicklistBinCreatedAtRemoved();

        void setIsPropertyPicklistBinCreatedAtRemoved(Boolean removed);

        Boolean getIsPropertyPicklistBinUpdatedByRemoved();

        void setIsPropertyPicklistBinUpdatedByRemoved(Boolean removed);

        Boolean getIsPropertyPicklistBinUpdatedAtRemoved();

        void setIsPropertyPicklistBinUpdatedAtRemoved(Boolean removed);

        Boolean getIsPropertyPicklistBinActiveRemoved();

        void setIsPropertyPicklistBinActiveRemoved(Boolean removed);

        Boolean getIsPropertyPicklistBinDeletedRemoved();

        void setIsPropertyPicklistBinDeletedRemoved(Boolean removed);

    }

	interface DeletePicklistItemMvo extends PicklistItemMvoCommand
	{
	}

}

