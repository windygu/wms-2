package org.dddml.wms.domain.inventoryitementrymvo;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface InventoryItemEntryMvoStateEvent extends Event
{
    InventoryItemEntryMvoStateEventId getStateEventId();

    boolean getStateEventReadOnly();

    void setStateEventReadOnly(boolean readOnly);

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

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

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

    String getCommandId();

    void setCommandId(String commandId);

    interface InventoryItemEntryMvoStateCreated extends InventoryItemEntryMvoStateEvent
    {
    
    }


    interface InventoryItemEntryMvoStateMergePatched extends InventoryItemEntryMvoStateEvent
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


}

