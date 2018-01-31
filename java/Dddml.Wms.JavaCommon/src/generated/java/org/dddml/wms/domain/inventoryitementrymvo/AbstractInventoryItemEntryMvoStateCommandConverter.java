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
        cmd.setOnHandQuantity(state.getOnHandQuantity());
        cmd.setInTransitQuantity(state.getInTransitQuantity());
        cmd.setReservedQuantity(state.getReservedQuantity());
        cmd.setOccupiedQuantity(state.getOccupiedQuantity());
        cmd.setVirtualQuantity(state.getVirtualQuantity());
        cmd.setSource(state.getSource());
        cmd.setVersion(state.getVersion());
        cmd.setInventoryItemOnHandQuantity(state.getInventoryItemOnHandQuantity());
        cmd.setInventoryItemInTransitQuantity(state.getInventoryItemInTransitQuantity());
        cmd.setInventoryItemReservedQuantity(state.getInventoryItemReservedQuantity());
        cmd.setInventoryItemOccupiedQuantity(state.getInventoryItemOccupiedQuantity());
        cmd.setInventoryItemVirtualQuantity(state.getInventoryItemVirtualQuantity());
        cmd.setInventoryItemCreatedBy(state.getInventoryItemCreatedBy());
        cmd.setInventoryItemCreatedAt(state.getInventoryItemCreatedAt());
        cmd.setInventoryItemUpdatedBy(state.getInventoryItemUpdatedBy());
        cmd.setInventoryItemUpdatedAt(state.getInventoryItemUpdatedAt());
            
        if (state.getOnHandQuantity() == null) { cmd.setIsPropertyOnHandQuantityRemoved(true); }
        if (state.getInTransitQuantity() == null) { cmd.setIsPropertyInTransitQuantityRemoved(true); }
        if (state.getReservedQuantity() == null) { cmd.setIsPropertyReservedQuantityRemoved(true); }
        if (state.getOccupiedQuantity() == null) { cmd.setIsPropertyOccupiedQuantityRemoved(true); }
        if (state.getVirtualQuantity() == null) { cmd.setIsPropertyVirtualQuantityRemoved(true); }
        if (state.getSource() == null) { cmd.setIsPropertySourceRemoved(true); }
        if (state.getVersion() == null) { cmd.setIsPropertyVersionRemoved(true); }
        if (state.getInventoryItemOnHandQuantity() == null) { cmd.setIsPropertyInventoryItemOnHandQuantityRemoved(true); }
        if (state.getInventoryItemInTransitQuantity() == null) { cmd.setIsPropertyInventoryItemInTransitQuantityRemoved(true); }
        if (state.getInventoryItemReservedQuantity() == null) { cmd.setIsPropertyInventoryItemReservedQuantityRemoved(true); }
        if (state.getInventoryItemOccupiedQuantity() == null) { cmd.setIsPropertyInventoryItemOccupiedQuantityRemoved(true); }
        if (state.getInventoryItemVirtualQuantity() == null) { cmd.setIsPropertyInventoryItemVirtualQuantityRemoved(true); }
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
        cmd.setOnHandQuantity(state.getOnHandQuantity());
        cmd.setInTransitQuantity(state.getInTransitQuantity());
        cmd.setReservedQuantity(state.getReservedQuantity());
        cmd.setOccupiedQuantity(state.getOccupiedQuantity());
        cmd.setVirtualQuantity(state.getVirtualQuantity());
        cmd.setSource(state.getSource());
        cmd.setVersion(state.getVersion());
        cmd.setInventoryItemOnHandQuantity(state.getInventoryItemOnHandQuantity());
        cmd.setInventoryItemInTransitQuantity(state.getInventoryItemInTransitQuantity());
        cmd.setInventoryItemReservedQuantity(state.getInventoryItemReservedQuantity());
        cmd.setInventoryItemOccupiedQuantity(state.getInventoryItemOccupiedQuantity());
        cmd.setInventoryItemVirtualQuantity(state.getInventoryItemVirtualQuantity());
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

