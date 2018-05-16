package org.dddml.wms.domain.orderitemshipgrpinvreservation;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class OrderItemShipGrpInvReservationStateDto
{

    private OrderItemShipGrpInvResId orderItemShipGrpInvResId;

    public OrderItemShipGrpInvResId getOrderItemShipGrpInvResId()
    {
        return this.orderItemShipGrpInvResId;
    }

    public void setOrderItemShipGrpInvResId(OrderItemShipGrpInvResId orderItemShipGrpInvResId)
    {
        this.orderItemShipGrpInvResId = orderItemShipGrpInvResId;
    }

    private String reserveOrderEnumId;

    public String getReserveOrderEnumId()
    {
        return this.reserveOrderEnumId;
    }

    public void setReserveOrderEnumId(String reserveOrderEnumId)
    {
        this.reserveOrderEnumId = reserveOrderEnumId;
    }

    private java.math.BigDecimal quantity;

    public java.math.BigDecimal getQuantity()
    {
        return this.quantity;
    }

    public void setQuantity(java.math.BigDecimal quantity)
    {
        this.quantity = quantity;
    }

    private java.math.BigDecimal quantityNotAvailable;

    public java.math.BigDecimal getQuantityNotAvailable()
    {
        return this.quantityNotAvailable;
    }

    public void setQuantityNotAvailable(java.math.BigDecimal quantityNotAvailable)
    {
        this.quantityNotAvailable = quantityNotAvailable;
    }

    private java.sql.Timestamp reservedDatetime;

    public java.sql.Timestamp getReservedDatetime()
    {
        return this.reservedDatetime;
    }

    public void setReservedDatetime(java.sql.Timestamp reservedDatetime)
    {
        this.reservedDatetime = reservedDatetime;
    }

    private java.sql.Timestamp createdDatetime;

    public java.sql.Timestamp getCreatedDatetime()
    {
        return this.createdDatetime;
    }

    public void setCreatedDatetime(java.sql.Timestamp createdDatetime)
    {
        this.createdDatetime = createdDatetime;
    }

    private java.sql.Timestamp promisedDatetime;

    public java.sql.Timestamp getPromisedDatetime()
    {
        return this.promisedDatetime;
    }

    public void setPromisedDatetime(java.sql.Timestamp promisedDatetime)
    {
        this.promisedDatetime = promisedDatetime;
    }

    private java.sql.Timestamp currentPromisedDate;

    public java.sql.Timestamp getCurrentPromisedDate()
    {
        return this.currentPromisedDate;
    }

    public void setCurrentPromisedDate(java.sql.Timestamp currentPromisedDate)
    {
        this.currentPromisedDate = currentPromisedDate;
    }

    private String priority;

    public String getPriority()
    {
        return this.priority;
    }

    public void setPriority(String priority)
    {
        this.priority = priority;
    }

    private Long sequenceId;

    public Long getSequenceId()
    {
        return this.sequenceId;
    }

    public void setSequenceId(Long sequenceId)
    {
        this.sequenceId = sequenceId;
    }

    private java.sql.Timestamp oldPickStartDate;

    public java.sql.Timestamp getOldPickStartDate()
    {
        return this.oldPickStartDate;
    }

    public void setOldPickStartDate(java.sql.Timestamp oldPickStartDate)
    {
        this.oldPickStartDate = oldPickStartDate;
    }

    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
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

    private String createdBy;

    public String getCreatedBy()
    {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy)
    {
        this.createdBy = createdBy;
    }

    private Date createdAt;

    public Date getCreatedAt()
    {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    private String updatedBy;

    public String getUpdatedBy()
    {
        return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy)
    {
        this.updatedBy = updatedBy;
    }

    private Date updatedAt;

    public Date getUpdatedAt()
    {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt)
    {
        this.updatedAt = updatedAt;
    }

}

