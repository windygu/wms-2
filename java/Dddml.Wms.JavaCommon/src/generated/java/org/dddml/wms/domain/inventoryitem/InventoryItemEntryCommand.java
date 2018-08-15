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
        BigDecimal getOnHandQuantity();

        void setOnHandQuantity(BigDecimal onHandQuantity);

        BigDecimal getInTransitQuantity();

        void setInTransitQuantity(BigDecimal inTransitQuantity);

        BigDecimal getReservedQuantity();

        void setReservedQuantity(BigDecimal reservedQuantity);

        BigDecimal getOccupiedQuantity();

        void setOccupiedQuantity(BigDecimal occupiedQuantity);

        BigDecimal getVirtualQuantity();

        void setVirtualQuantity(BigDecimal virtualQuantity);

        InventoryItemSourceInfo getSource();

        void setSource(InventoryItemSourceInfo source);

        java.sql.Timestamp getOccuredAt();

        void setOccuredAt(java.sql.Timestamp occuredAt);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateInventoryItemEntry extends CreateOrMergePatchInventoryItemEntry
    {
    }

}

