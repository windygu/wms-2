package org.dddml.wms.domain.order;

import java.util.Set;
import org.dddml.wms.domain.partyrole.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.order.OrderRoleEvent.*;

public interface OrderRoleState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    PartyRoleId getPartyRoleId();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    Boolean getDeleted();

    String getOrderId();

    interface MutableOrderRoleState extends OrderRoleState {
        void setOrderRoleId(OrderRoleId orderRoleId);

        void setPartyRoleId(PartyRoleId partyRoleId);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setDeleted(Boolean deleted);

        void setOrderId(String orderId);


        void mutate(Event e);

        void when(OrderRoleEvent.OrderRoleStateCreated e);

        void when(OrderRoleEvent.OrderRoleStateMergePatched e);

        void when(OrderRoleEvent.OrderRoleStateRemoved e);
    }

    interface SqlOrderRoleState extends MutableOrderRoleState {
        OrderRoleId getOrderRoleId();

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

