package org.dddml.wms.domain.order;

import java.util.Set;
import org.dddml.wms.domain.partyrole.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.order.OrderRoleStateEvent.*;

public interface OrderRoleState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    OrderRoleId getOrderRoleId();

    void setOrderRoleId(OrderRoleId orderRoleId);

    PartyRoleId getPartyRoleId();

    void setPartyRoleId(PartyRoleId partyRoleId);

    Long getVersion();

    void setVersion(Long version);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getUpdatedBy();

    void setUpdatedBy(String updatedBy);

    Date getUpdatedAt();

    void setUpdatedAt(Date updatedAt);

    Boolean getActive();

    void setActive(Boolean active);

    Boolean getDeleted();

    void setDeleted(Boolean deleted);

    String getOrderId();

    void setOrderId(String orderId);


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(OrderRoleStateEvent.OrderRoleStateCreated e);

    void when(OrderRoleStateEvent.OrderRoleStateMergePatched e);

    void when(OrderRoleStateEvent.OrderRoleStateRemoved e);
    
}

