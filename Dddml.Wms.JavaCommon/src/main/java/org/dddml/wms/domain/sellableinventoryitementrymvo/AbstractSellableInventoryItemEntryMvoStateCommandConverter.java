package org.dddml.wms.domain.sellableinventoryitementrymvo;

import java.util.*;
import org.dddml.wms.domain.sellableinventoryitem.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractSellableInventoryItemEntryMvoStateCommandConverter<TCreateSellableInventoryItemEntryMvo extends SellableInventoryItemEntryMvoCommand.CreateSellableInventoryItemEntryMvo, TMergePatchSellableInventoryItemEntryMvo extends SellableInventoryItemEntryMvoCommand.MergePatchSellableInventoryItemEntryMvo, TDeleteSellableInventoryItemEntryMvo extends SellableInventoryItemEntryMvoCommand.DeleteSellableInventoryItemEntryMvo>
{
    public SellableInventoryItemEntryMvoCommand toCreateOrMergePatchSellableInventoryItemEntryMvo(SellableInventoryItemEntryMvoState state)
    {
        //where TCreateSellableInventoryItemEntryMvo : ICreateSellableInventoryItemEntryMvo, new()
        //where TMergePatchSellableInventoryItemEntryMvo : IMergePatchSellableInventoryItemEntryMvo, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateSellableInventoryItemEntryMvo(state);
        }
        else 
        {
            return toMergePatchSellableInventoryItemEntryMvo(state);
        }
    }

    public TDeleteSellableInventoryItemEntryMvo toDeleteSellableInventoryItemEntryMvo(SellableInventoryItemEntryMvoState state) //where TDeleteSellableInventoryItemEntryMvo : IDeleteSellableInventoryItemEntryMvo, new()
    {
        TDeleteSellableInventoryItemEntryMvo cmd = newDeleteSellableInventoryItemEntryMvo();
        cmd.setSellableInventoryItemEntryId(state.getSellableInventoryItemEntryId());
        cmd.setSellableInventoryItemVersion(state.getSellableInventoryItemVersion());

        return cmd;
    }

    public TMergePatchSellableInventoryItemEntryMvo toMergePatchSellableInventoryItemEntryMvo(SellableInventoryItemEntryMvoState state) //where TMergePatchSellableInventoryItemEntryMvo : IMergePatchSellableInventoryItemEntryMvo, new()
    {
        TMergePatchSellableInventoryItemEntryMvo cmd = newMergePatchSellableInventoryItemEntryMvo();

        cmd.setSellableInventoryItemVersion(state.getSellableInventoryItemVersion());

        cmd.setSellableInventoryItemEntryId(state.getSellableInventoryItemEntryId());
        cmd.setQuantitySellable(state.getQuantitySellable());
        cmd.setSourceEventId(state.getSourceEventId());
        cmd.setVersion(state.getVersion());
        cmd.setSellableInventoryItemQuantitySellable(state.getSellableInventoryItemQuantitySellable());
        cmd.setSellableInventoryItemCreatedBy(state.getSellableInventoryItemCreatedBy());
        cmd.setSellableInventoryItemCreatedAt(state.getSellableInventoryItemCreatedAt());
        cmd.setSellableInventoryItemUpdatedBy(state.getSellableInventoryItemUpdatedBy());
        cmd.setSellableInventoryItemUpdatedAt(state.getSellableInventoryItemUpdatedAt());
            
        if (state.getQuantitySellable() == null) { cmd.setIsPropertyQuantitySellableRemoved(true); }
        if (state.getSourceEventId() == null) { cmd.setIsPropertySourceEventIdRemoved(true); }
        if (state.getVersion() == null) { cmd.setIsPropertyVersionRemoved(true); }
        if (state.getSellableInventoryItemQuantitySellable() == null) { cmd.setIsPropertySellableInventoryItemQuantitySellableRemoved(true); }
        if (state.getSellableInventoryItemCreatedBy() == null) { cmd.setIsPropertySellableInventoryItemCreatedByRemoved(true); }
        if (state.getSellableInventoryItemCreatedAt() == null) { cmd.setIsPropertySellableInventoryItemCreatedAtRemoved(true); }
        if (state.getSellableInventoryItemUpdatedBy() == null) { cmd.setIsPropertySellableInventoryItemUpdatedByRemoved(true); }
        if (state.getSellableInventoryItemUpdatedAt() == null) { cmd.setIsPropertySellableInventoryItemUpdatedAtRemoved(true); }
        return cmd;
    }

    public TCreateSellableInventoryItemEntryMvo toCreateSellableInventoryItemEntryMvo(SellableInventoryItemEntryMvoState state) //where TCreateSellableInventoryItemEntryMvo : ICreateSellableInventoryItemEntryMvo, new()
    {
        TCreateSellableInventoryItemEntryMvo cmd = newCreateSellableInventoryItemEntryMvo();

        cmd.setSellableInventoryItemVersion(state.getSellableInventoryItemVersion());
        cmd.setSellableInventoryItemEntryId(state.getSellableInventoryItemEntryId());
        cmd.setQuantitySellable(state.getQuantitySellable());
        cmd.setSourceEventId(state.getSourceEventId());
        cmd.setVersion(state.getVersion());
        cmd.setSellableInventoryItemQuantitySellable(state.getSellableInventoryItemQuantitySellable());
        cmd.setSellableInventoryItemCreatedBy(state.getSellableInventoryItemCreatedBy());
        cmd.setSellableInventoryItemCreatedAt(state.getSellableInventoryItemCreatedAt());
        cmd.setSellableInventoryItemUpdatedBy(state.getSellableInventoryItemUpdatedBy());
        cmd.setSellableInventoryItemUpdatedAt(state.getSellableInventoryItemUpdatedAt());
        return cmd;
    }

    protected abstract TCreateSellableInventoryItemEntryMvo newCreateSellableInventoryItemEntryMvo();

    protected abstract TMergePatchSellableInventoryItemEntryMvo newMergePatchSellableInventoryItemEntryMvo(); 

    protected abstract TDeleteSellableInventoryItemEntryMvo newDeleteSellableInventoryItemEntryMvo();

    public static class SimpleSellableInventoryItemEntryMvoStateCommandConverter extends AbstractSellableInventoryItemEntryMvoStateCommandConverter<AbstractSellableInventoryItemEntryMvoCommand.SimpleCreateSellableInventoryItemEntryMvo, AbstractSellableInventoryItemEntryMvoCommand.SimpleMergePatchSellableInventoryItemEntryMvo, AbstractSellableInventoryItemEntryMvoCommand.SimpleDeleteSellableInventoryItemEntryMvo>
    {
        @Override
        protected AbstractSellableInventoryItemEntryMvoCommand.SimpleCreateSellableInventoryItemEntryMvo newCreateSellableInventoryItemEntryMvo() {
            return new AbstractSellableInventoryItemEntryMvoCommand.SimpleCreateSellableInventoryItemEntryMvo();
        }

        @Override
        protected AbstractSellableInventoryItemEntryMvoCommand.SimpleMergePatchSellableInventoryItemEntryMvo newMergePatchSellableInventoryItemEntryMvo() {
            return new AbstractSellableInventoryItemEntryMvoCommand.SimpleMergePatchSellableInventoryItemEntryMvo();
        }

        @Override
        protected AbstractSellableInventoryItemEntryMvoCommand.SimpleDeleteSellableInventoryItemEntryMvo newDeleteSellableInventoryItemEntryMvo() {
            return new AbstractSellableInventoryItemEntryMvoCommand.SimpleDeleteSellableInventoryItemEntryMvo();
        }


    }

}

