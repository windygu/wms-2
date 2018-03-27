package org.dddml.wms.domain.order;

import java.util.*;
import org.dddml.wms.domain.partyrole.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractOrderRoleStateCommandConverter<TCreateOrderRole extends OrderRoleCommand.CreateOrderRole, TMergePatchOrderRole extends OrderRoleCommand.MergePatchOrderRole, TRemoveOrderRole extends OrderRoleCommand.RemoveOrderRole>
{
    public OrderRoleCommand toCreateOrMergePatchOrderRole(OrderRoleState state)
    {
        //where TCreateOrderRole : ICreateOrderRole, new()
        //where TMergePatchOrderRole : IMergePatchOrderRole, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateOrderRole(state);
        }
        else 
        {
            return toMergePatchOrderRole(state);
        }
    }

    public TRemoveOrderRole toRemoveOrderRole(OrderRoleState state) //where TRemoveOrderRole : IRemoveOrderRole, new()
    {
        TRemoveOrderRole cmd = newRemoveOrderRole();
        cmd.setPartyRoleId(state.getPartyRoleId());
        return cmd;
    }

    public TMergePatchOrderRole toMergePatchOrderRole(OrderRoleState state) //where TMergePatchOrderRole : IMergePatchOrderRole, new()
    {
        TMergePatchOrderRole cmd = newMergePatchOrderRole();

        cmd.setPartyRoleId(state.getPartyRoleId());
        cmd.setActive(state.getActive());
        cmd.setOrderId(state.getOrderId());
            
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        return cmd;
    }

    public TCreateOrderRole toCreateOrderRole(OrderRoleState state) //where TCreateOrderRole : ICreateOrderRole, new()
    {
        TCreateOrderRole cmd = newCreateOrderRole();

        cmd.setPartyRoleId(state.getPartyRoleId());
        cmd.setActive(state.getActive());
        cmd.setOrderId(state.getOrderId());
        return cmd;
    }

    protected abstract TCreateOrderRole newCreateOrderRole();

    protected abstract TMergePatchOrderRole newMergePatchOrderRole(); 

    protected abstract TRemoveOrderRole newRemoveOrderRole();

    public static class SimpleOrderRoleStateCommandConverter extends AbstractOrderRoleStateCommandConverter<AbstractOrderRoleCommand.SimpleCreateOrderRole, AbstractOrderRoleCommand.SimpleMergePatchOrderRole, AbstractOrderRoleCommand.SimpleRemoveOrderRole>
    {
        @Override
        protected AbstractOrderRoleCommand.SimpleCreateOrderRole newCreateOrderRole() {
            return new AbstractOrderRoleCommand.SimpleCreateOrderRole();
        }

        @Override
        protected AbstractOrderRoleCommand.SimpleMergePatchOrderRole newMergePatchOrderRole() {
            return new AbstractOrderRoleCommand.SimpleMergePatchOrderRole();
        }

        @Override
        protected AbstractOrderRoleCommand.SimpleRemoveOrderRole newRemoveOrderRole() {
            return new AbstractOrderRoleCommand.SimpleRemoveOrderRole();
        }


    }

}

