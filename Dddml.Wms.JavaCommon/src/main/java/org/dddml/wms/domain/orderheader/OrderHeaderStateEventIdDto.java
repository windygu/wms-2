package org.dddml.wms.domain.orderheader;

import org.dddml.wms.domain.*;

public class OrderHeaderStateEventIdDto
{

    public OrderHeaderStateEventIdDto()
    {
    }

    public OrderHeaderStateEventId toOrderHeaderStateEventId()
    {
        OrderHeaderStateEventId v = new OrderHeaderStateEventId();
        v.setOrderId(this.getOrderId());
        v.setVersion(this.getVersion());
        return v;
    }

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


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != OrderHeaderStateEventIdDto.class) {
            return false;
        }

        OrderHeaderStateEventIdDto other = (OrderHeaderStateEventIdDto)obj;
        return true 
            && (getOrderId() == other.getOrderId() || (getOrderId() != null && getOrderId().equals(other.getOrderId())))
            && (getVersion() == other.getVersion() || (getVersion() != null && getVersion().equals(other.getVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getOrderId() != null) {
            hash += 13 * this.getOrderId().hashCode();
        }
        if (this.getVersion() != null) {
            hash += 13 * this.getVersion().hashCode();
        }
        return hash;
    }

}

