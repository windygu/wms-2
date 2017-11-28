package org.dddml.wms.domain.inventoryitem;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;

public interface InventoryItemEntryCommand extends Command
{
    Long getEntrySeqId();

    void setEntrySeqId(Long entrySeqId);

    InventoryItemId getInventoryItemId();

    void setInventoryItemId(InventoryItemId inventoryItemId);


    interface CreateOrMergePatchInventoryItemEntry extends InventoryItemEntryCommand
    {
        BigDecimal getQuantityOnHandVar();

        void setQuantityOnHandVar(BigDecimal quantityOnHandVar);

        BigDecimal getQuantityReservedVar();

        void setQuantityReservedVar(BigDecimal quantityReservedVar);

        BigDecimal getQuantityOccupiedVar();

        void setQuantityOccupiedVar(BigDecimal quantityOccupiedVar);

        BigDecimal getQuantityVirtualVar();

        void setQuantityVirtualVar(BigDecimal quantityVirtualVar);

        InventoryItemEventVO getEventVO();

        void setEventVO(InventoryItemEventVO eventVO);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateInventoryItemEntry extends CreateOrMergePatchInventoryItemEntry
    {
    }

}

