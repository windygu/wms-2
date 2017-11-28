package org.dddml.wms.domain.inventoryitementrymvo;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractInventoryItemEntryMvoStateCommandConverter<TCreateInventoryItemEntryMvo extends InventoryItemEntryMvoCommand.CreateInventoryItemEntryMvo, TMergePatchInventoryItemEntryMvo extends InventoryItemEntryMvoCommand.MergePatchInventoryItemEntryMvo, TDeleteInventoryItemEntryMvo extends InventoryItemEntryMvoCommand.DeleteInventoryItemEntryMvo>
{
    public InventoryItemEntryMvoCommand toCreateOrMergePatchInventoryItemEntryMvo(InventoryItemEntryMvoState state)
    {
        //where TCreateInventoryItemEntryMvo : ICreateInventoryItemEntryMvo, new()
        //where TMergePatchInventoryItemEntryMvo : IMergePatchInventoryItemEntryMvo, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateInventoryItemEntryMvo(state);
        }
        else 
        {
            return toMergePatchInventoryItemEntryMvo(state);
        }
    }

    public TDeleteInventoryItemEntryMvo toDeleteInventoryItemEntryMvo(InventoryItemEntryMvoState state) //where TDeleteInventoryItemEntryMvo : IDeleteInventoryItemEntryMvo, new()
    {
        TDeleteInventoryItemEntryMvo cmd = newDeleteInventoryItemEntryMvo();
        cmd.setInventoryItemEntryId(state.getInventoryItemEntryId());
        cmd.setInventoryItemVersion(state.getInventoryItemVersion());

        return cmd;
    }

    public TMergePatchInventoryItemEntryMvo toMergePatchInventoryItemEntryMvo(InventoryItemEntryMvoState state) //where TMergePatchInventoryItemEntryMvo : IMergePatchInventoryItemEntryMvo, new()
    {
        TMergePatchInventoryItemEntryMvo cmd = newMergePatchInventoryItemEntryMvo();

        cmd.setInventoryItemVersion(state.getInventoryItemVersion());

        cmd.setInventoryItemEntryId(state.getInventoryItemEntryId());
        cmd.setQuantityOnHandVar(state.getQuantityOnHandVar());
        cmd.setQuantityReservedVar(state.getQuantityReservedVar());
        cmd.setQuantityOccupiedVar(state.getQuantityOccupiedVar());
        cmd.setQuantityVirtualVar(state.getQuantityVirtualVar());
        cmd.setEventVO(state.getEventVO());
        cmd.setVersion(state.getVersion());
        cmd.setActive(state.getActive());
        cmd.setInventoryItemQuantityOnHand(state.getInventoryItemQuantityOnHand());
        cmd.setInventoryItemQuantityReserved(state.getInventoryItemQuantityReserved());
        cmd.setInventoryItemQuantityOccupied(state.getInventoryItemQuantityOccupied());
        cmd.setInventoryItemQuantityVirtual(state.getInventoryItemQuantityVirtual());
        cmd.setInventoryItemCreatedBy(state.getInventoryItemCreatedBy());
        cmd.setInventoryItemCreatedAt(state.getInventoryItemCreatedAt());
        cmd.setInventoryItemUpdatedBy(state.getInventoryItemUpdatedBy());
        cmd.setInventoryItemUpdatedAt(state.getInventoryItemUpdatedAt());
            
        if (state.getQuantityOnHandVar() == null) { cmd.setIsPropertyQuantityOnHandVarRemoved(true); }
        if (state.getQuantityReservedVar() == null) { cmd.setIsPropertyQuantityReservedVarRemoved(true); }
        if (state.getQuantityOccupiedVar() == null) { cmd.setIsPropertyQuantityOccupiedVarRemoved(true); }
        if (state.getQuantityVirtualVar() == null) { cmd.setIsPropertyQuantityVirtualVarRemoved(true); }
        if (state.getEventVO() == null) { cmd.setIsPropertyEventVORemoved(true); }
        if (state.getVersion() == null) { cmd.setIsPropertyVersionRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        if (state.getInventoryItemQuantityOnHand() == null) { cmd.setIsPropertyInventoryItemQuantityOnHandRemoved(true); }
        if (state.getInventoryItemQuantityReserved() == null) { cmd.setIsPropertyInventoryItemQuantityReservedRemoved(true); }
        if (state.getInventoryItemQuantityOccupied() == null) { cmd.setIsPropertyInventoryItemQuantityOccupiedRemoved(true); }
        if (state.getInventoryItemQuantityVirtual() == null) { cmd.setIsPropertyInventoryItemQuantityVirtualRemoved(true); }
        if (state.getInventoryItemCreatedBy() == null) { cmd.setIsPropertyInventoryItemCreatedByRemoved(true); }
        if (state.getInventoryItemCreatedAt() == null) { cmd.setIsPropertyInventoryItemCreatedAtRemoved(true); }
        if (state.getInventoryItemUpdatedBy() == null) { cmd.setIsPropertyInventoryItemUpdatedByRemoved(true); }
        if (state.getInventoryItemUpdatedAt() == null) { cmd.setIsPropertyInventoryItemUpdatedAtRemoved(true); }
        return cmd;
    }

    public TCreateInventoryItemEntryMvo toCreateInventoryItemEntryMvo(InventoryItemEntryMvoState state) //where TCreateInventoryItemEntryMvo : ICreateInventoryItemEntryMvo, new()
    {
        TCreateInventoryItemEntryMvo cmd = newCreateInventoryItemEntryMvo();

        cmd.setInventoryItemVersion(state.getInventoryItemVersion());
        cmd.setInventoryItemEntryId(state.getInventoryItemEntryId());
        cmd.setQuantityOnHandVar(state.getQuantityOnHandVar());
        cmd.setQuantityReservedVar(state.getQuantityReservedVar());
        cmd.setQuantityOccupiedVar(state.getQuantityOccupiedVar());
        cmd.setQuantityVirtualVar(state.getQuantityVirtualVar());
        cmd.setEventVO(state.getEventVO());
        cmd.setVersion(state.getVersion());
        cmd.setActive(state.getActive());
        cmd.setInventoryItemQuantityOnHand(state.getInventoryItemQuantityOnHand());
        cmd.setInventoryItemQuantityReserved(state.getInventoryItemQuantityReserved());
        cmd.setInventoryItemQuantityOccupied(state.getInventoryItemQuantityOccupied());
        cmd.setInventoryItemQuantityVirtual(state.getInventoryItemQuantityVirtual());
        cmd.setInventoryItemCreatedBy(state.getInventoryItemCreatedBy());
        cmd.setInventoryItemCreatedAt(state.getInventoryItemCreatedAt());
        cmd.setInventoryItemUpdatedBy(state.getInventoryItemUpdatedBy());
        cmd.setInventoryItemUpdatedAt(state.getInventoryItemUpdatedAt());
        return cmd;
    }

    protected abstract TCreateInventoryItemEntryMvo newCreateInventoryItemEntryMvo();

    protected abstract TMergePatchInventoryItemEntryMvo newMergePatchInventoryItemEntryMvo(); 

    protected abstract TDeleteInventoryItemEntryMvo newDeleteInventoryItemEntryMvo();

    public static class SimpleInventoryItemEntryMvoStateCommandConverter extends AbstractInventoryItemEntryMvoStateCommandConverter<AbstractInventoryItemEntryMvoCommand.SimpleCreateInventoryItemEntryMvo, AbstractInventoryItemEntryMvoCommand.SimpleMergePatchInventoryItemEntryMvo, AbstractInventoryItemEntryMvoCommand.SimpleDeleteInventoryItemEntryMvo>
    {
        @Override
        protected AbstractInventoryItemEntryMvoCommand.SimpleCreateInventoryItemEntryMvo newCreateInventoryItemEntryMvo() {
            return new AbstractInventoryItemEntryMvoCommand.SimpleCreateInventoryItemEntryMvo();
        }

        @Override
        protected AbstractInventoryItemEntryMvoCommand.SimpleMergePatchInventoryItemEntryMvo newMergePatchInventoryItemEntryMvo() {
            return new AbstractInventoryItemEntryMvoCommand.SimpleMergePatchInventoryItemEntryMvo();
        }

        @Override
        protected AbstractInventoryItemEntryMvoCommand.SimpleDeleteInventoryItemEntryMvo newDeleteInventoryItemEntryMvo() {
            return new AbstractInventoryItemEntryMvoCommand.SimpleDeleteInventoryItemEntryMvo();
        }


    }

}

