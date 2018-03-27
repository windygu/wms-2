package org.dddml.wms.domain.picklist;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.partyrole.*;
import org.dddml.wms.domain.*;

public abstract class AbstractPicklistStateCommandConverter<TCreatePicklist extends PicklistCommand.CreatePicklist, TMergePatchPicklist extends PicklistCommand.MergePatchPicklist, TDeletePicklist extends PicklistCommand.DeletePicklist, TCreatePicklistRole extends PicklistRoleCommand.CreatePicklistRole, TMergePatchPicklistRole extends PicklistRoleCommand.MergePatchPicklistRole, TRemovePicklistRole extends PicklistRoleCommand.RemovePicklistRole>
{
    public PicklistCommand toCreateOrMergePatchPicklist(PicklistState state)
    {
        //where TCreatePicklist : ICreatePicklist, new()
        //where TMergePatchPicklist : IMergePatchPicklist, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreatePicklist(state);
        }
        else 
        {
            return toMergePatchPicklist(state);
        }
    }

    public TDeletePicklist toDeletePicklist(PicklistState state) //where TDeletePicklist : IDeletePicklist, new()
    {
        TDeletePicklist cmd = newDeletePicklist();
        cmd.setPicklistId(state.getPicklistId());
        cmd.setVersion(state.getVersion());

        return cmd;
    }

    public TMergePatchPicklist toMergePatchPicklist(PicklistState state) //where TMergePatchPicklist : IMergePatchPicklist, new()
    {
        TMergePatchPicklist cmd = newMergePatchPicklist();

        cmd.setVersion(state.getVersion());

        cmd.setPicklistId(state.getPicklistId());
        cmd.setDescription(state.getDescription());
        cmd.setFacilityId(state.getFacilityId());
        cmd.setShipmentMethodTypeId(state.getShipmentMethodTypeId());
        cmd.setStatusId(state.getStatusId());
        cmd.setPicklistDate(state.getPicklistDate());
        cmd.setActive(state.getActive());
            
        if (state.getDescription() == null) { cmd.setIsPropertyDescriptionRemoved(true); }
        if (state.getFacilityId() == null) { cmd.setIsPropertyFacilityIdRemoved(true); }
        if (state.getShipmentMethodTypeId() == null) { cmd.setIsPropertyShipmentMethodTypeIdRemoved(true); }
        if (state.getStatusId() == null) { cmd.setIsPropertyStatusIdRemoved(true); }
        if (state.getPicklistDate() == null) { cmd.setIsPropertyPicklistDateRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        for (PicklistRoleState d : state.getPicklistRoles())
        {
            PicklistRoleCommand c = getPicklistRoleStateCommandConverter().toCreateOrMergePatchPicklistRole(d);
            cmd.getPicklistRoleCommands().add(c);
        }
        return cmd;
    }

    public TCreatePicklist toCreatePicklist(PicklistState state) //where TCreatePicklist : ICreatePicklist, new()
    {
        TCreatePicklist cmd = newCreatePicklist();

        cmd.setVersion(state.getVersion());
        cmd.setPicklistId(state.getPicklistId());
        cmd.setDescription(state.getDescription());
        cmd.setFacilityId(state.getFacilityId());
        cmd.setShipmentMethodTypeId(state.getShipmentMethodTypeId());
        cmd.setStatusId(state.getStatusId());
        cmd.setPicklistDate(state.getPicklistDate());
        cmd.setActive(state.getActive());
        for (PicklistRoleState d : state.getPicklistRoles())
        {
            PicklistRoleCommand.CreatePicklistRole c = getPicklistRoleStateCommandConverter().toCreatePicklistRole(d);
            cmd.getPicklistRoles().add(c);
        }
        return cmd;
    }

    protected abstract AbstractPicklistRoleStateCommandConverter<TCreatePicklistRole, TMergePatchPicklistRole, TRemovePicklistRole>
        getPicklistRoleStateCommandConverter();

    protected abstract TCreatePicklist newCreatePicklist();

    protected abstract TMergePatchPicklist newMergePatchPicklist(); 

    protected abstract TDeletePicklist newDeletePicklist();

    public static class SimplePicklistStateCommandConverter extends AbstractPicklistStateCommandConverter<AbstractPicklistCommand.SimpleCreatePicklist, AbstractPicklistCommand.SimpleMergePatchPicklist, AbstractPicklistCommand.SimpleDeletePicklist, AbstractPicklistRoleCommand.SimpleCreatePicklistRole, AbstractPicklistRoleCommand.SimpleMergePatchPicklistRole, AbstractPicklistRoleCommand.SimpleRemovePicklistRole>
    {
        @Override
        protected AbstractPicklistCommand.SimpleCreatePicklist newCreatePicklist() {
            return new AbstractPicklistCommand.SimpleCreatePicklist();
        }

        @Override
        protected AbstractPicklistCommand.SimpleMergePatchPicklist newMergePatchPicklist() {
            return new AbstractPicklistCommand.SimpleMergePatchPicklist();
        }

        @Override
        protected AbstractPicklistCommand.SimpleDeletePicklist newDeletePicklist() {
            return new AbstractPicklistCommand.SimpleDeletePicklist();
        }

        @Override
        protected AbstractPicklistRoleStateCommandConverter<AbstractPicklistRoleCommand.SimpleCreatePicklistRole, AbstractPicklistRoleCommand.SimpleMergePatchPicklistRole, AbstractPicklistRoleCommand.SimpleRemovePicklistRole> getPicklistRoleStateCommandConverter()
        {
            return new AbstractPicklistRoleStateCommandConverter.SimplePicklistRoleStateCommandConverter();
        }


    }

}

