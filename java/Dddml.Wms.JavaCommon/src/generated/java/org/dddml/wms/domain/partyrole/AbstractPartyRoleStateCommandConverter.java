package org.dddml.wms.domain.partyrole;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractPartyRoleStateCommandConverter<TCreatePartyRole extends PartyRoleCommand.CreatePartyRole, TMergePatchPartyRole extends PartyRoleCommand.MergePatchPartyRole, TDeletePartyRole extends PartyRoleCommand.DeletePartyRole>
{
    public PartyRoleCommand toCreateOrMergePatchPartyRole(PartyRoleState state)
    {
        //where TCreatePartyRole : ICreatePartyRole, new()
        //where TMergePatchPartyRole : IMergePatchPartyRole, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreatePartyRole(state);
        }
        else 
        {
            return toMergePatchPartyRole(state);
        }
    }

    public TDeletePartyRole toDeletePartyRole(PartyRoleState state) //where TDeletePartyRole : IDeletePartyRole, new()
    {
        TDeletePartyRole cmd = newDeletePartyRole();
        cmd.setPartyRoleId(state.getPartyRoleId());
        cmd.setVersion(state.getVersion());

        return cmd;
    }

    public TMergePatchPartyRole toMergePatchPartyRole(PartyRoleState state) //where TMergePatchPartyRole : IMergePatchPartyRole, new()
    {
        TMergePatchPartyRole cmd = newMergePatchPartyRole();

        cmd.setVersion(state.getVersion());

        cmd.setPartyRoleId(state.getPartyRoleId());
        cmd.setActive(state.getActive());
            
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        return cmd;
    }

    public TCreatePartyRole toCreatePartyRole(PartyRoleState state) //where TCreatePartyRole : ICreatePartyRole, new()
    {
        TCreatePartyRole cmd = newCreatePartyRole();

        cmd.setVersion(state.getVersion());
        cmd.setPartyRoleId(state.getPartyRoleId());
        cmd.setActive(state.getActive());
        return cmd;
    }

    protected abstract TCreatePartyRole newCreatePartyRole();

    protected abstract TMergePatchPartyRole newMergePatchPartyRole(); 

    protected abstract TDeletePartyRole newDeletePartyRole();

    public static class SimplePartyRoleStateCommandConverter extends AbstractPartyRoleStateCommandConverter<AbstractPartyRoleCommand.SimpleCreatePartyRole, AbstractPartyRoleCommand.SimpleMergePatchPartyRole, AbstractPartyRoleCommand.SimpleDeletePartyRole>
    {
        @Override
        protected AbstractPartyRoleCommand.SimpleCreatePartyRole newCreatePartyRole() {
            return new AbstractPartyRoleCommand.SimpleCreatePartyRole();
        }

        @Override
        protected AbstractPartyRoleCommand.SimpleMergePatchPartyRole newMergePatchPartyRole() {
            return new AbstractPartyRoleCommand.SimpleMergePatchPartyRole();
        }

        @Override
        protected AbstractPartyRoleCommand.SimpleDeletePartyRole newDeletePartyRole() {
            return new AbstractPartyRoleCommand.SimpleDeletePartyRole();
        }


    }

}

