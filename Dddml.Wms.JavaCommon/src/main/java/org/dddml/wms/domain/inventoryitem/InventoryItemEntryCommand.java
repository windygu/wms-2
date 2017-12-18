package org.dddml.wms.domain.inventoryitem;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface InventoryItemEntryCommand extends Command
{
    Long getEntrySeqId();

    void setEntrySeqId(Long entrySeqId);

    InventoryItemId getInventoryItemId();

    void setInventoryItemId(InventoryItemId inventoryItemId);

    interface CreateOrMergePatchInventoryItemEntry extends InventoryItemEntryCommand
    {
        BigDecimal getQuantityOnHand();

        void setQuantityOnHand(BigDecimal quantityOnHand);

        BigDecimal getQuantityInTransit();

        void setQuantityInTransit(BigDecimal quantityInTransit);

        BigDecimal getQuantityReserved();

        void setQuantityReserved(BigDecimal quantityReserved);

        BigDecimal getQuantityOccupied();

        void setQuantityOccupied(BigDecimal quantityOccupied);

        BigDecimal getQuantityVirtual();

        void setQuantityVirtual(BigDecimal quantityVirtual);

        InventoryItemSourceVO getSource();

        void setSource(InventoryItemSourceVO source);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateInventoryItemEntry extends CreateOrMergePatchInventoryItemEntry
    {
    }

}

