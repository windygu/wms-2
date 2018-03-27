package org.dddml.wms.domain.picklistrolemvo;

import java.util.*;
import org.dddml.wms.domain.picklist.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractPicklistRoleMvoStateCommandConverter<TCreatePicklistRoleMvo extends PicklistRoleMvoCommand.CreatePicklistRoleMvo, TMergePatchPicklistRoleMvo extends PicklistRoleMvoCommand.MergePatchPicklistRoleMvo, TDeletePicklistRoleMvo extends PicklistRoleMvoCommand.DeletePicklistRoleMvo>
{
    public PicklistRoleMvoCommand toCreateOrMergePatchPicklistRoleMvo(PicklistRoleMvoState state)
    {
        //where TCreatePicklistRoleMvo : ICreatePicklistRoleMvo, new()
        //where TMergePatchPicklistRoleMvo : IMergePatchPicklistRoleMvo, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreatePicklistRoleMvo(state);
        }
        else 
        {
            return toMergePatchPicklistRoleMvo(state);
        }
    }

    public TDeletePicklistRoleMvo toDeletePicklistRoleMvo(PicklistRoleMvoState state) //where TDeletePicklistRoleMvo : IDeletePicklistRoleMvo, new()
    {
        TDeletePicklistRoleMvo cmd = newDeletePicklistRoleMvo();
        cmd.setPicklistRoleId(state.getPicklistRoleId());
        cmd.setPicklistVersion(state.getPicklistVersion());

        return cmd;
    }

    public TMergePatchPicklistRoleMvo toMergePatchPicklistRoleMvo(PicklistRoleMvoState state) //where TMergePatchPicklistRoleMvo : IMergePatchPicklistRoleMvo, new()
    {
        TMergePatchPicklistRoleMvo cmd = newMergePatchPicklistRoleMvo();

        cmd.setPicklistVersion(state.getPicklistVersion());

        cmd.setPicklistRoleId(state.getPicklistRoleId());
        cmd.setVersion(state.getVersion());
        cmd.setActive(state.getActive());
        cmd.setPicklistDescription(state.getPicklistDescription());
        cmd.setPicklistFacilityId(state.getPicklistFacilityId());
        cmd.setPicklistShipmentMethodTypeId(state.getPicklistShipmentMethodTypeId());
        cmd.setPicklistStatusId(state.getPicklistStatusId());
        cmd.setPicklistPicklistDate(state.getPicklistPicklistDate());
        cmd.setPicklistCreatedByUserLogin(state.getPicklistCreatedByUserLogin());
        cmd.setPicklistLastModifiedByUserLogin(state.getPicklistLastModifiedByUserLogin());
        cmd.setPicklistPickwaveId(state.getPicklistPickwaveId());
        cmd.setPicklistCreatedAt(state.getPicklistCreatedAt());
        cmd.setPicklistUpdatedAt(state.getPicklistUpdatedAt());
        cmd.setPicklistActive(state.getPicklistActive());
        cmd.setPicklistDeleted(state.getPicklistDeleted());
            
        if (state.getVersion() == null) { cmd.setIsPropertyVersionRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        if (state.getPicklistDescription() == null) { cmd.setIsPropertyPicklistDescriptionRemoved(true); }
        if (state.getPicklistFacilityId() == null) { cmd.setIsPropertyPicklistFacilityIdRemoved(true); }
        if (state.getPicklistShipmentMethodTypeId() == null) { cmd.setIsPropertyPicklistShipmentMethodTypeIdRemoved(true); }
        if (state.getPicklistStatusId() == null) { cmd.setIsPropertyPicklistStatusIdRemoved(true); }
        if (state.getPicklistPicklistDate() == null) { cmd.setIsPropertyPicklistPicklistDateRemoved(true); }
        if (state.getPicklistCreatedByUserLogin() == null) { cmd.setIsPropertyPicklistCreatedByUserLoginRemoved(true); }
        if (state.getPicklistLastModifiedByUserLogin() == null) { cmd.setIsPropertyPicklistLastModifiedByUserLoginRemoved(true); }
        if (state.getPicklistPickwaveId() == null) { cmd.setIsPropertyPicklistPickwaveIdRemoved(true); }
        if (state.getPicklistCreatedAt() == null) { cmd.setIsPropertyPicklistCreatedAtRemoved(true); }
        if (state.getPicklistUpdatedAt() == null) { cmd.setIsPropertyPicklistUpdatedAtRemoved(true); }
        if (state.getPicklistActive() == null) { cmd.setIsPropertyPicklistActiveRemoved(true); }
        if (state.getPicklistDeleted() == null) { cmd.setIsPropertyPicklistDeletedRemoved(true); }
        return cmd;
    }

    public TCreatePicklistRoleMvo toCreatePicklistRoleMvo(PicklistRoleMvoState state) //where TCreatePicklistRoleMvo : ICreatePicklistRoleMvo, new()
    {
        TCreatePicklistRoleMvo cmd = newCreatePicklistRoleMvo();

        cmd.setPicklistVersion(state.getPicklistVersion());
        cmd.setPicklistRoleId(state.getPicklistRoleId());
        cmd.setVersion(state.getVersion());
        cmd.setActive(state.getActive());
        cmd.setPicklistDescription(state.getPicklistDescription());
        cmd.setPicklistFacilityId(state.getPicklistFacilityId());
        cmd.setPicklistShipmentMethodTypeId(state.getPicklistShipmentMethodTypeId());
        cmd.setPicklistStatusId(state.getPicklistStatusId());
        cmd.setPicklistPicklistDate(state.getPicklistPicklistDate());
        cmd.setPicklistCreatedByUserLogin(state.getPicklistCreatedByUserLogin());
        cmd.setPicklistLastModifiedByUserLogin(state.getPicklistLastModifiedByUserLogin());
        cmd.setPicklistPickwaveId(state.getPicklistPickwaveId());
        cmd.setPicklistCreatedAt(state.getPicklistCreatedAt());
        cmd.setPicklistUpdatedAt(state.getPicklistUpdatedAt());
        cmd.setPicklistActive(state.getPicklistActive());
        cmd.setPicklistDeleted(state.getPicklistDeleted());
        return cmd;
    }

    protected abstract TCreatePicklistRoleMvo newCreatePicklistRoleMvo();

    protected abstract TMergePatchPicklistRoleMvo newMergePatchPicklistRoleMvo(); 

    protected abstract TDeletePicklistRoleMvo newDeletePicklistRoleMvo();

    public static class SimplePicklistRoleMvoStateCommandConverter extends AbstractPicklistRoleMvoStateCommandConverter<AbstractPicklistRoleMvoCommand.SimpleCreatePicklistRoleMvo, AbstractPicklistRoleMvoCommand.SimpleMergePatchPicklistRoleMvo, AbstractPicklistRoleMvoCommand.SimpleDeletePicklistRoleMvo>
    {
        @Override
        protected AbstractPicklistRoleMvoCommand.SimpleCreatePicklistRoleMvo newCreatePicklistRoleMvo() {
            return new AbstractPicklistRoleMvoCommand.SimpleCreatePicklistRoleMvo();
        }

        @Override
        protected AbstractPicklistRoleMvoCommand.SimpleMergePatchPicklistRoleMvo newMergePatchPicklistRoleMvo() {
            return new AbstractPicklistRoleMvoCommand.SimpleMergePatchPicklistRoleMvo();
        }

        @Override
        protected AbstractPicklistRoleMvoCommand.SimpleDeletePicklistRoleMvo newDeletePicklistRoleMvo() {
            return new AbstractPicklistRoleMvoCommand.SimpleDeletePicklistRoleMvo();
        }


    }

}

