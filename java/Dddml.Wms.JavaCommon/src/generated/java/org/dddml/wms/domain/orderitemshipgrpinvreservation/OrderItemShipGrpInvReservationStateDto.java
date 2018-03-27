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


    public static class DtoConverter extends AbstractStateDtoConverter
    {
        public static Collection<String> collectionFieldNames = Arrays.asList(new String[]{});

        @Override
        protected boolean isCollectionField(String fieldName) {
            return CollectionUtils.collectionContainsIgnoringCase(collectionFieldNames, fieldName);
        }

        public OrderItemShipGrpInvReservationStateDto[] toOrderItemShipGrpInvReservationStateDtoArray(Iterable<OrderItemShipGrpInvReservationState> states) 
        {
            ArrayList<OrderItemShipGrpInvReservationStateDto> stateDtos = new ArrayList();
            for (OrderItemShipGrpInvReservationState s : states) {
                OrderItemShipGrpInvReservationStateDto dto = toOrderItemShipGrpInvReservationStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos.toArray(new OrderItemShipGrpInvReservationStateDto[0]);
        }

        public OrderItemShipGrpInvReservationStateDto toOrderItemShipGrpInvReservationStateDto(OrderItemShipGrpInvReservationState state)
        {
            if(state == null) {
                return null;
            }
            OrderItemShipGrpInvReservationStateDto dto = new OrderItemShipGrpInvReservationStateDto();
            if (returnedFieldsContains("OrderItemShipGrpInvResId")) {
                dto.setOrderItemShipGrpInvResId(state.getOrderItemShipGrpInvResId());
            }
            if (returnedFieldsContains("ReserveOrderEnumId")) {
                dto.setReserveOrderEnumId(state.getReserveOrderEnumId());
            }
            if (returnedFieldsContains("Quantity")) {
                dto.setQuantity(state.getQuantity());
            }
            if (returnedFieldsContains("QuantityNotAvailable")) {
                dto.setQuantityNotAvailable(state.getQuantityNotAvailable());
            }
            if (returnedFieldsContains("ReservedDatetime")) {
                dto.setReservedDatetime(state.getReservedDatetime());
            }
            if (returnedFieldsContains("CreatedDatetime")) {
                dto.setCreatedDatetime(state.getCreatedDatetime());
            }
            if (returnedFieldsContains("PromisedDatetime")) {
                dto.setPromisedDatetime(state.getPromisedDatetime());
            }
            if (returnedFieldsContains("CurrentPromisedDate")) {
                dto.setCurrentPromisedDate(state.getCurrentPromisedDate());
            }
            if (returnedFieldsContains("Priority")) {
                dto.setPriority(state.getPriority());
            }
            if (returnedFieldsContains("SequenceId")) {
                dto.setSequenceId(state.getSequenceId());
            }
            if (returnedFieldsContains("OldPickStartDate")) {
                dto.setOldPickStartDate(state.getOldPickStartDate());
            }
            if (returnedFieldsContains("Active")) {
                dto.setActive(state.getActive());
            }
            if (returnedFieldsContains("Version")) {
                dto.setVersion(state.getVersion());
            }
            if (returnedFieldsContains("CreatedBy")) {
                dto.setCreatedBy(state.getCreatedBy());
            }
            if (returnedFieldsContains("CreatedAt")) {
                dto.setCreatedAt(state.getCreatedAt());
            }
            if (returnedFieldsContains("UpdatedBy")) {
                dto.setUpdatedBy(state.getUpdatedBy());
            }
            if (returnedFieldsContains("UpdatedAt")) {
                dto.setUpdatedAt(state.getUpdatedAt());
            }
            return dto;
        }

    }
}

