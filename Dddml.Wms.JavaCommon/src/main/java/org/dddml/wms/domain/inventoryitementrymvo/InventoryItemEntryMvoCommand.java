package org.dddml.wms.domain.inventoryitementrymvo;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;

public interface InventoryItemEntryMvoCommand extends Command
{
    InventoryItemEntryId getInventoryItemEntryId();

    void setInventoryItemEntryId(InventoryItemEntryId inventoryItemEntryId);

    Long getInventoryItemVersion();

    void setInventoryItemVersion(Long inventoryItemVersion);


    interface CreateOrMergePatchInventoryItemEntryMvo extends InventoryItemEntryMvoCommand
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

        Long getVersion();

        void setVersion(Long version);

        Boolean getActive();

        void setActive(Boolean active);

        BigDecimal getInventoryItemQuantityOnHand();

        void setInventoryItemQuantityOnHand(BigDecimal inventoryItemQuantityOnHand);

        BigDecimal getInventoryItemQuantityReserved();

        void setInventoryItemQuantityReserved(BigDecimal inventoryItemQuantityReserved);

        BigDecimal getInventoryItemQuantityOccupied();

        void setInventoryItemQuantityOccupied(BigDecimal inventoryItemQuantityOccupied);

        BigDecimal getInventoryItemQuantityVirtual();

        void setInventoryItemQuantityVirtual(BigDecimal inventoryItemQuantityVirtual);

        String getInventoryItemCreatedBy();

        void setInventoryItemCreatedBy(String inventoryItemCreatedBy);

        Date getInventoryItemCreatedAt();

        void setInventoryItemCreatedAt(Date inventoryItemCreatedAt);

        String getInventoryItemUpdatedBy();

        void setInventoryItemUpdatedBy(String inventoryItemUpdatedBy);

        Date getInventoryItemUpdatedAt();

        void setInventoryItemUpdatedAt(Date inventoryItemUpdatedAt);

    }

    interface CreateInventoryItemEntryMvo extends CreateOrMergePatchInventoryItemEntryMvo
    {
    }

    interface MergePatchInventoryItemEntryMvo extends CreateOrMergePatchInventoryItemEntryMvo
    {
        Boolean getIsPropertyQuantityOnHandVarRemoved();

        void setIsPropertyQuantityOnHandVarRemoved(Boolean removed);

        Boolean getIsPropertyQuantityReservedVarRemoved();

        void setIsPropertyQuantityReservedVarRemoved(Boolean removed);

        Boolean getIsPropertyQuantityOccupiedVarRemoved();

        void setIsPropertyQuantityOccupiedVarRemoved(Boolean removed);

        Boolean getIsPropertyQuantityVirtualVarRemoved();

        void setIsPropertyQuantityVirtualVarRemoved(Boolean removed);

        Boolean getIsPropertyEventVORemoved();

        void setIsPropertyEventVORemoved(Boolean removed);

        Boolean getIsPropertyVersionRemoved();

        void setIsPropertyVersionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        Boolean getIsPropertyInventoryItemQuantityOnHandRemoved();

        void setIsPropertyInventoryItemQuantityOnHandRemoved(Boolean removed);

        Boolean getIsPropertyInventoryItemQuantityReservedRemoved();

        void setIsPropertyInventoryItemQuantityReservedRemoved(Boolean removed);

        Boolean getIsPropertyInventoryItemQuantityOccupiedRemoved();

        void setIsPropertyInventoryItemQuantityOccupiedRemoved(Boolean removed);

        Boolean getIsPropertyInventoryItemQuantityVirtualRemoved();

        void setIsPropertyInventoryItemQuantityVirtualRemoved(Boolean removed);

        Boolean getIsPropertyInventoryItemCreatedByRemoved();

        void setIsPropertyInventoryItemCreatedByRemoved(Boolean removed);

        Boolean getIsPropertyInventoryItemCreatedAtRemoved();

        void setIsPropertyInventoryItemCreatedAtRemoved(Boolean removed);

        Boolean getIsPropertyInventoryItemUpdatedByRemoved();

        void setIsPropertyInventoryItemUpdatedByRemoved(Boolean removed);

        Boolean getIsPropertyInventoryItemUpdatedAtRemoved();

        void setIsPropertyInventoryItemUpdatedAtRemoved(Boolean removed);

    }

	interface DeleteInventoryItemEntryMvo extends InventoryItemEntryMvoCommand
	{
	}

}

