package org.dddml.wms.domain.order;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class OrderStateEventId implements Serializable
{
    private String orderId;

    public String getOrderId()
    {
        return this.orderId;
    }

    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
    }

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }

    public OrderStateEventId()
    {
    }

    public OrderStateEventId(String orderId, Long version)
    {
        this.orderId = orderId;
        this.version = version;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        OrderStateEventId other = (OrderStateEventId)obj;
        return true 
            && (orderId == other.orderId || (orderId != null && orderId.equals(other.orderId)))
            && (version == other.version || (version != null && version.equals(other.version)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.orderId != null) {
            hash += 13 * this.orderId.hashCode();
        }
        if (this.version != null) {
            hash += 13 * this.version.hashCode();
        }
        return hash;
    }

}

