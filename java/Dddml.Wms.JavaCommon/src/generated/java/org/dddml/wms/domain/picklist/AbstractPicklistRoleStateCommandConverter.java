package org.dddml.wms.domain.picklist;

import java.util.*;
import org.dddml.wms.domain.partyrole.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractPicklistRoleStateCommandConverter<TCreatePicklistRole extends PicklistRoleCommand.CreatePicklistRole, TMergePatchPicklistRole extends PicklistRoleCommand.MergePatchPicklistRole, TRemovePicklistRole extends PicklistRoleCommand.RemovePicklistRole>
{
    public PicklistRoleCommand toCreateOrMergePatchPicklistRole(PicklistRoleState state)
    {
        //where TCreatePicklistRole : ICreatePicklistRole, new()
        //where TMergePatchPicklistRole : IMergePatchPicklistRole, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreatePicklistRole(state);
        }
        else 
        {
            return toMergePatchPicklistRole(state);
        }
    }

    public TRemovePicklistRole toRemovePicklistRole(PicklistRoleState state) //where TRemovePicklistRole : IRemovePicklistRole, new()
    {
        TRemovePicklistRole cmd = newRemovePicklistRole();
        cmd.setPartyRoleId(state.getPartyRoleId());
        return cmd;
    }

    public TMergePatchPicklistRole toMergePatchPicklistRole(PicklistRoleState state) //where TMergePatchPicklistRole : IMergePatchPicklistRole, new()
    {
        TMergePatchPicklistRole cmd = newMergePatchPicklistRole();

        cmd.setPartyRoleId(state.getPartyRoleId());
        cmd.setActive(state.getActive());
        cmd.setPicklistId(state.getPicklistId());
            
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        return cmd;
    }

    public TCreatePicklistRole toCreatePicklistRole(PicklistRoleState state) //where TCreatePicklistRole : ICreatePicklistRole, new()
    {
        TCreatePicklistRole cmd = newCreatePicklistRole();

        cmd.setPartyRoleId(state.getPartyRoleId());
        cmd.setActive(state.getActive());
        cmd.setPicklistId(state.getPicklistId());
        return cmd;
    }

    protected abstract TCreatePicklistRole newCreatePicklistRole();

    protected abstract TMergePatchPicklistRole newMergePatchPicklistRole(); 

    protected abstract TRemovePicklistRole newRemovePicklistRole();

    public static class SimplePicklistRoleStateCommandConverter extends AbstractPicklistRoleStateCommandConverter<AbstractPicklistRoleCommand.SimpleCreatePicklistRole, AbstractPicklistRoleCommand.SimpleMergePatchPicklistRole, AbstractPicklistRoleCommand.SimpleRemovePicklistRole>
    {
        @Override
        protected AbstractPicklistRoleCommand.SimpleCreatePicklistRole newCreatePicklistRole() {
            return new AbstractPicklistRoleCommand.SimpleCreatePicklistRole();
        }

        @Override
        protected AbstractPicklistRoleCommand.SimpleMergePatchPicklistRole newMergePatchPicklistRole() {
            return new AbstractPicklistRoleCommand.SimpleMergePatchPicklistRole();
        }

        @Override
        protected AbstractPicklistRoleCommand.SimpleRemovePicklistRole newRemovePicklistRole() {
            return new AbstractPicklistRoleCommand.SimpleRemovePicklistRole();
        }


    }

}

