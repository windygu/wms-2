package org.dddml.wms.domain.party;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractPartyStateCommandConverter<TCreateParty extends PartyCommand.CreateParty, TMergePatchParty extends PartyCommand.MergePatchParty, TDeleteParty extends PartyCommand.DeleteParty>
{
    public PartyCommand toCreateOrMergePatchParty(PartyState state)
    {
        //where TCreateParty : ICreateParty, new()
        //where TMergePatchParty : IMergePatchParty, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateParty(state);
        }
        else 
        {
            return toMergePatchParty(state);
        }
    }

    public TDeleteParty toDeleteParty(PartyState state) //where TDeleteParty : IDeleteParty, new()
    {
        TDeleteParty cmd = newDeleteParty();
        cmd.setPartyId(state.getPartyId());
        cmd.setVersion(state.getVersion());

        return cmd;
    }

    public TMergePatchParty toMergePatchParty(PartyState state) //where TMergePatchParty : IMergePatchParty, new()
    {
        TMergePatchParty cmd = newMergePatchParty();

        cmd.setVersion(state.getVersion());

        cmd.setPartyId(state.getPartyId());
        cmd.setPartyTypeId(state.getPartyTypeId());
        cmd.setActive(state.getActive());
            
        if (state.getPartyTypeId() == null) { cmd.setIsPropertyPartyTypeIdRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        return cmd;
    }

    public TCreateParty toCreateParty(PartyState state) //where TCreateParty : ICreateParty, new()
    {
        TCreateParty cmd = newCreateParty();

        cmd.setVersion(state.getVersion());
        cmd.setPartyId(state.getPartyId());
        cmd.setPartyTypeId(state.getPartyTypeId());
        cmd.setActive(state.getActive());
        return cmd;
    }

    protected abstract TCreateParty newCreateParty();

    protected abstract TMergePatchParty newMergePatchParty(); 

    protected abstract TDeleteParty newDeleteParty();

    public static class SimplePartyStateCommandConverter extends AbstractPartyStateCommandConverter<AbstractPartyCommand.SimpleCreateParty, AbstractPartyCommand.SimpleMergePatchParty, AbstractPartyCommand.SimpleDeleteParty>
    {
        @Override
        protected AbstractPartyCommand.SimpleCreateParty newCreateParty() {
            return new AbstractPartyCommand.SimpleCreateParty();
        }

        @Override
        protected AbstractPartyCommand.SimpleMergePatchParty newMergePatchParty() {
            return new AbstractPartyCommand.SimpleMergePatchParty();
        }

        @Override
        protected AbstractPartyCommand.SimpleDeleteParty newDeleteParty() {
            return new AbstractPartyCommand.SimpleDeleteParty();
        }


    }

}

