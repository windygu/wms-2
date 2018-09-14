package org.dddml.wms.domain.order;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class OrderItemShipGroupAssociationStateDto
{

    private String orderItemSeqId;

    public String getOrderItemSeqId()
    {
        return this.orderItemSeqId;
    }

    public void setOrderItemSeqId(String orderItemSeqId)
    {
        this.orderItemSeqId = orderItemSeqId;
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

    private java.math.BigDecimal cancelQuantity;

    public java.math.BigDecimal getCancelQuantity()
    {
        return this.cancelQuantity;
    }

    public void setCancelQuantity(java.math.BigDecimal cancelQuantity)
    {
        this.cancelQuantity = cancelQuantity;
    }

    private Integer numberOfPackages;

    public Integer getNumberOfPackages()
    {
        return this.numberOfPackages;
    }

    public void setNumberOfPackages(Integer numberOfPackages)
    {
        this.numberOfPackages = numberOfPackages;
    }

    private Integer numberOfContainers;

    public Integer getNumberOfContainers()
    {
        return this.numberOfContainers;
    }

    public void setNumberOfContainers(Integer numberOfContainers)
    {
        this.numberOfContainers = numberOfContainers;
    }

    private Integer numberOfPakagesPerContainer;

    public Integer getNumberOfPakagesPerContainer()
    {
        return this.numberOfPakagesPerContainer;
    }

    public void setNumberOfPakagesPerContainer(Integer numberOfPakagesPerContainer)
    {
        this.numberOfPakagesPerContainer = numberOfPakagesPerContainer;
    }

    private String orderItemShipGroupAssociationKey;

    public String getOrderItemShipGroupAssociationKey()
    {
        return this.orderItemShipGroupAssociationKey;
    }

    public void setOrderItemShipGroupAssociationKey(String orderItemShipGroupAssociationKey)
    {
        this.orderItemShipGroupAssociationKey = orderItemShipGroupAssociationKey;
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

    private String orderId;

    public String getOrderId()
    {
        return this.orderId;
    }

    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
    }

    private String orderShipGroupShipGroupSeqId;

    public String getOrderShipGroupShipGroupSeqId()
    {
        return this.orderShipGroupShipGroupSeqId;
    }

    public void setOrderShipGroupShipGroupSeqId(String orderShipGroupShipGroupSeqId)
    {
        this.orderShipGroupShipGroupSeqId = orderShipGroupShipGroupSeqId;
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

        public OrderItemShipGroupAssociationStateDto[] toOrderItemShipGroupAssociationStateDtoArray(Iterable<OrderItemShipGroupAssociationState> states) {
            return toOrderItemShipGroupAssociationStateDtoList(states).toArray(new OrderItemShipGroupAssociationStateDto[0]);
        }

        public List<OrderItemShipGroupAssociationStateDto> toOrderItemShipGroupAssociationStateDtoList(Iterable<OrderItemShipGroupAssociationState> states) {
            ArrayList<OrderItemShipGroupAssociationStateDto> stateDtos = new ArrayList();
            for (OrderItemShipGroupAssociationState s : states) {
                OrderItemShipGroupAssociationStateDto dto = toOrderItemShipGroupAssociationStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos;
        }

        public OrderItemShipGroupAssociationStateDto toOrderItemShipGroupAssociationStateDto(OrderItemShipGroupAssociationState state)
        {
            if(state == null) {
                return null;
            }
            OrderItemShipGroupAssociationStateDto dto = new OrderItemShipGroupAssociationStateDto();
            if (returnedFieldsContains("OrderItemSeqId")) {
                dto.setOrderItemSeqId(state.getOrderItemSeqId());
            }
            if (returnedFieldsContains("Quantity")) {
                dto.setQuantity(state.getQuantity());
            }
            if (returnedFieldsContains("CancelQuantity")) {
                dto.setCancelQuantity(state.getCancelQuantity());
            }
            if (returnedFieldsContains("NumberOfPackages")) {
                dto.setNumberOfPackages(state.getNumberOfPackages());
            }
            if (returnedFieldsContains("NumberOfContainers")) {
                dto.setNumberOfContainers(state.getNumberOfContainers());
            }
            if (returnedFieldsContains("NumberOfPakagesPerContainer")) {
                dto.setNumberOfPakagesPerContainer(state.getNumberOfPakagesPerContainer());
            }
            if (returnedFieldsContains("OrderItemShipGroupAssociationKey")) {
                dto.setOrderItemShipGroupAssociationKey(state.getOrderItemShipGroupAssociationKey());
            }
            if (returnedFieldsContains("Active")) {
                dto.setActive(state.getActive());
            }
            if (returnedFieldsContains("Version")) {
                dto.setVersion(state.getVersion());
            }
            if (returnedFieldsContains("OrderId")) {
                dto.setOrderId(state.getOrderId());
            }
            if (returnedFieldsContains("OrderShipGroupShipGroupSeqId")) {
                dto.setOrderShipGroupShipGroupSeqId(state.getOrderShipGroupShipGroupSeqId());
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

