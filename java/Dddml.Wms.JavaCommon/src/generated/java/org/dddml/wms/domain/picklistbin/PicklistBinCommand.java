package org.dddml.wms.domain.picklistbin;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface PicklistBinCommand extends Command
{
    String getPicklistBinId();

    void setPicklistBinId(String picklistBinId);

    Long getVersion();

    void setVersion(Long version);

    static void throwOnInvalidStateTransition(PicklistBinState state, Command c) {
        if (state.getVersion() == null)
        {
            if (isCommandCreate((PicklistBinCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (state.getDeleted() != null && state.getDeleted())
        {
            throw DomainError.named("zombie", "Can't do anything to deleted aggregate.");
        }
        if (isCommandCreate((PicklistBinCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(PicklistBinCommand c) {
        return ((c instanceof PicklistBinCommand.CreatePicklistBin) 
            && c.getVersion().equals(PicklistBinState.VERSION_NULL));
    }

    interface CreateOrMergePatchPicklistBin extends PicklistBinCommand
    {
        String getPicklistId();

        void setPicklistId(String picklistId);

        Long getBinLocationNumber();

        void setBinLocationNumber(Long binLocationNumber);

        String getPrimaryOrderId();

        void setPrimaryOrderId(String primaryOrderId);

        Long getPrimaryShipGroupSeqId();

        void setPrimaryShipGroupSeqId(Long primaryShipGroupSeqId);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreatePicklistBin extends CreateOrMergePatchPicklistBin
    {
        CreatePicklistItemCommands getPicklistItems();

        PicklistItemCommand.CreatePicklistItem newCreatePicklistItem();

    }

    interface MergePatchPicklistBin extends CreateOrMergePatchPicklistBin
    {
        Boolean getIsPropertyPicklistIdRemoved();

        void setIsPropertyPicklistIdRemoved(Boolean removed);

        Boolean getIsPropertyBinLocationNumberRemoved();

        void setIsPropertyBinLocationNumberRemoved(Boolean removed);

        Boolean getIsPropertyPrimaryOrderIdRemoved();

        void setIsPropertyPrimaryOrderIdRemoved(Boolean removed);

        Boolean getIsPropertyPrimaryShipGroupSeqIdRemoved();

        void setIsPropertyPrimaryShipGroupSeqIdRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        PicklistItemCommands getPicklistItemCommands();

        PicklistItemCommand.CreatePicklistItem newCreatePicklistItem();

        PicklistItemCommand.MergePatchPicklistItem newMergePatchPicklistItem();

        PicklistItemCommand.RemovePicklistItem newRemovePicklistItem();

    }

	interface DeletePicklistBin extends PicklistBinCommand
	{
	}

    interface CreatePicklistItemCommands extends Iterable<PicklistItemCommand.CreatePicklistItem>
    {
        void add(PicklistItemCommand.CreatePicklistItem c);

        void remove(PicklistItemCommand.CreatePicklistItem c);

        void clear();
    }

    interface PicklistItemCommands extends Iterable<PicklistItemCommand>
    {
        void add(PicklistItemCommand c);

        void remove(PicklistItemCommand c);

        void clear();
    }

}

