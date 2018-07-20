package org.dddml.wms.domain.orderitemshipgrpinvreservation;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchOrderItemShipGrpInvReservationDto extends AbstractOrderItemShipGrpInvReservationCommandDto
{
    /**
     * Reserve Order Enum Id
     */
    private String reserveOrderEnumId;

    public String getReserveOrderEnumId()
    {
        return this.reserveOrderEnumId;
    }

    public void setReserveOrderEnumId(String reserveOrderEnumId)
    {
        this.reserveOrderEnumId = reserveOrderEnumId;
    }

    /**
     * Quantity
     */
    private java.math.BigDecimal quantity;

    public java.math.BigDecimal getQuantity()
    {
        return this.quantity;
    }

    public void setQuantity(java.math.BigDecimal quantity)
    {
        this.quantity = quantity;
    }

    /**
     * Quantity Not Available
     */
    private java.math.BigDecimal quantityNotAvailable;

    public java.math.BigDecimal getQuantityNotAvailable()
    {
        return this.quantityNotAvailable;
    }

    public void setQuantityNotAvailable(java.math.BigDecimal quantityNotAvailable)
    {
        this.quantityNotAvailable = quantityNotAvailable;
    }

    /**
     * Reserved Datetime
     */
    private java.sql.Timestamp reservedDatetime;

    public java.sql.Timestamp getReservedDatetime()
    {
        return this.reservedDatetime;
    }

    public void setReservedDatetime(java.sql.Timestamp reservedDatetime)
    {
        this.reservedDatetime = reservedDatetime;
    }

    /**
     * Created Datetime
     */
    private java.sql.Timestamp createdDatetime;

    public java.sql.Timestamp getCreatedDatetime()
    {
        return this.createdDatetime;
    }

    public void setCreatedDatetime(java.sql.Timestamp createdDatetime)
    {
        this.createdDatetime = createdDatetime;
    }

    /**
     * Promised Datetime
     */
    private java.sql.Timestamp promisedDatetime;

    public java.sql.Timestamp getPromisedDatetime()
    {
        return this.promisedDatetime;
    }

    public void setPromisedDatetime(java.sql.Timestamp promisedDatetime)
    {
        this.promisedDatetime = promisedDatetime;
    }

    /**
     * Current Promised Date
     */
    private java.sql.Timestamp currentPromisedDate;

    public java.sql.Timestamp getCurrentPromisedDate()
    {
        return this.currentPromisedDate;
    }

    public void setCurrentPromisedDate(java.sql.Timestamp currentPromisedDate)
    {
        this.currentPromisedDate = currentPromisedDate;
    }

    /**
     * Sets priority for Inventory Reservation
     */
    private String priority;

    public String getPriority()
    {
        return this.priority;
    }

    public void setPriority(String priority)
    {
        this.priority = priority;
    }

    /**
     * Sequence Id
     */
    private Long sequenceId;

    public Long getSequenceId()
    {
        return this.sequenceId;
    }

    public void setSequenceId(Long sequenceId)
    {
        this.sequenceId = sequenceId;
    }

    /**
     * Old Pick Start Date
     */
    private java.sql.Timestamp oldPickStartDate;

    public java.sql.Timestamp getOldPickStartDate()
    {
        return this.oldPickStartDate;
    }

    public void setOldPickStartDate(java.sql.Timestamp oldPickStartDate)
    {
        this.oldPickStartDate = oldPickStartDate;
    }

    /**
     * Active
     */
    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }

    private Boolean isPropertyReserveOrderEnumIdRemoved;

    public Boolean getIsPropertyReserveOrderEnumIdRemoved()
    {
        return this.isPropertyReserveOrderEnumIdRemoved;
    }

    public void setIsPropertyReserveOrderEnumIdRemoved(Boolean removed)
    {
        this.isPropertyReserveOrderEnumIdRemoved = removed;
    }

    private Boolean isPropertyQuantityRemoved;

    public Boolean getIsPropertyQuantityRemoved()
    {
        return this.isPropertyQuantityRemoved;
    }

    public void setIsPropertyQuantityRemoved(Boolean removed)
    {
        this.isPropertyQuantityRemoved = removed;
    }

    private Boolean isPropertyQuantityNotAvailableRemoved;

    public Boolean getIsPropertyQuantityNotAvailableRemoved()
    {
        return this.isPropertyQuantityNotAvailableRemoved;
    }

    public void setIsPropertyQuantityNotAvailableRemoved(Boolean removed)
    {
        this.isPropertyQuantityNotAvailableRemoved = removed;
    }

    private Boolean isPropertyReservedDatetimeRemoved;

    public Boolean getIsPropertyReservedDatetimeRemoved()
    {
        return this.isPropertyReservedDatetimeRemoved;
    }

    public void setIsPropertyReservedDatetimeRemoved(Boolean removed)
    {
        this.isPropertyReservedDatetimeRemoved = removed;
    }

    private Boolean isPropertyCreatedDatetimeRemoved;

    public Boolean getIsPropertyCreatedDatetimeRemoved()
    {
        return this.isPropertyCreatedDatetimeRemoved;
    }

    public void setIsPropertyCreatedDatetimeRemoved(Boolean removed)
    {
        this.isPropertyCreatedDatetimeRemoved = removed;
    }

    private Boolean isPropertyPromisedDatetimeRemoved;

    public Boolean getIsPropertyPromisedDatetimeRemoved()
    {
        return this.isPropertyPromisedDatetimeRemoved;
    }

    public void setIsPropertyPromisedDatetimeRemoved(Boolean removed)
    {
        this.isPropertyPromisedDatetimeRemoved = removed;
    }

    private Boolean isPropertyCurrentPromisedDateRemoved;

    public Boolean getIsPropertyCurrentPromisedDateRemoved()
    {
        return this.isPropertyCurrentPromisedDateRemoved;
    }

    public void setIsPropertyCurrentPromisedDateRemoved(Boolean removed)
    {
        this.isPropertyCurrentPromisedDateRemoved = removed;
    }

    private Boolean isPropertyPriorityRemoved;

    public Boolean getIsPropertyPriorityRemoved()
    {
        return this.isPropertyPriorityRemoved;
    }

    public void setIsPropertyPriorityRemoved(Boolean removed)
    {
        this.isPropertyPriorityRemoved = removed;
    }

    private Boolean isPropertySequenceIdRemoved;

    public Boolean getIsPropertySequenceIdRemoved()
    {
        return this.isPropertySequenceIdRemoved;
    }

    public void setIsPropertySequenceIdRemoved(Boolean removed)
    {
        this.isPropertySequenceIdRemoved = removed;
    }

    private Boolean isPropertyOldPickStartDateRemoved;

    public Boolean getIsPropertyOldPickStartDateRemoved()
    {
        return this.isPropertyOldPickStartDateRemoved;
    }

    public void setIsPropertyOldPickStartDateRemoved(Boolean removed)
    {
        this.isPropertyOldPickStartDateRemoved = removed;
    }

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved()
    {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed)
    {
        this.isPropertyActiveRemoved = removed;
    }

    public static class CreateOrderItemShipGrpInvReservationDto extends CreateOrMergePatchOrderItemShipGrpInvReservationDto
    {
        public CreateOrderItemShipGrpInvReservationDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static class MergePatchOrderItemShipGrpInvReservationDto extends CreateOrMergePatchOrderItemShipGrpInvReservationDto
    {
        public MergePatchOrderItemShipGrpInvReservationDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

    }

}

