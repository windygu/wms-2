package org.dddml.wms.domain.picklist;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.partyrole.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface PicklistCommand extends Command
{
    String getPicklistId();

    void setPicklistId(String picklistId);

    Long getVersion();

    void setVersion(Long version);

    static void throwOnInvalidStateTransition(PicklistState state, Command c) {
        if (state.getVersion() == null)
        {
            if (isCommandCreate((PicklistCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (state.getDeleted() != null && state.getDeleted())
        {
            throw DomainError.named("zombie", "Can't do anything to deleted aggregate.");
        }
        if (isCommandCreate((PicklistCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(PicklistCommand c) {
        return ((c instanceof PicklistCommand.CreatePicklist) 
            && (COMMAND_TYPE_CREATE.equals(c.getCommandType()) || c.getVersion().equals(PicklistState.VERSION_NULL)));
    }

    interface CreateOrMergePatchPicklist extends PicklistCommand
    {
        String getDescription();

        void setDescription(String description);

        String getFacilityId();

        void setFacilityId(String facilityId);

        String getShipmentMethodTypeId();

        void setShipmentMethodTypeId(String shipmentMethodTypeId);

        String getStatusId();

        void setStatusId(String statusId);

        java.sql.Timestamp getPicklistDate();

        void setPicklistDate(java.sql.Timestamp picklistDate);

        Long getPickwaveId();

        void setPickwaveId(Long pickwaveId);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreatePicklist extends CreateOrMergePatchPicklist
    {
        CreatePicklistRoleCommandCollection getCreatePicklistRoleCommands();

        PicklistRoleCommand.CreatePicklistRole newCreatePicklistRole();

    }

    interface MergePatchPicklist extends CreateOrMergePatchPicklist
    {
        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyFacilityIdRemoved();

        void setIsPropertyFacilityIdRemoved(Boolean removed);

        Boolean getIsPropertyShipmentMethodTypeIdRemoved();

        void setIsPropertyShipmentMethodTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyStatusIdRemoved();

        void setIsPropertyStatusIdRemoved(Boolean removed);

        Boolean getIsPropertyPicklistDateRemoved();

        void setIsPropertyPicklistDateRemoved(Boolean removed);

        Boolean getIsPropertyPickwaveIdRemoved();

        void setIsPropertyPickwaveIdRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        PicklistRoleCommandCollection getPicklistRoleCommands();

        PicklistRoleCommand.CreatePicklistRole newCreatePicklistRole();

        PicklistRoleCommand.MergePatchPicklistRole newMergePatchPicklistRole();

        PicklistRoleCommand.RemovePicklistRole newRemovePicklistRole();

    }

	interface DeletePicklist extends PicklistCommand
	{
	}

    interface CreatePicklistRoleCommandCollection extends Iterable<PicklistRoleCommand.CreatePicklistRole>
    {
        void add(PicklistRoleCommand.CreatePicklistRole c);

        void remove(PicklistRoleCommand.CreatePicklistRole c);

        void clear();
    }

    interface PicklistRoleCommandCollection extends Iterable<PicklistRoleCommand>
    {
        void add(PicklistRoleCommand c);

        void remove(PicklistRoleCommand c);

        void clear();
    }

}

