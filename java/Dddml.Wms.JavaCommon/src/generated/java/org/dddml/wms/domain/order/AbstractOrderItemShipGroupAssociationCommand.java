package org.dddml.wms.domain.order;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractOrderItemShipGroupAssociationCommand extends AbstractCommand implements OrderItemShipGroupAssociationCommand
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


    public static abstract class AbstractCreateOrMergePatchOrderItemShipGroupAssociation extends AbstractOrderItemShipGroupAssociationCommand implements CreateOrMergePatchOrderItemShipGroupAssociation
    {
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

    }

    public static abstract class AbstractCreateOrderItemShipGroupAssociation extends AbstractCreateOrMergePatchOrderItemShipGroupAssociation implements CreateOrderItemShipGroupAssociation
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static abstract class AbstractMergePatchOrderItemShipGroupAssociation extends AbstractCreateOrMergePatchOrderItemShipGroupAssociation implements MergePatchOrderItemShipGroupAssociation
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
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

        private Boolean isPropertyCancelQuantityRemoved;

        public Boolean getIsPropertyCancelQuantityRemoved()
        {
            return this.isPropertyCancelQuantityRemoved;
        }

        public void setIsPropertyCancelQuantityRemoved(Boolean removed)
        {
            this.isPropertyCancelQuantityRemoved = removed;
        }

        private Boolean isPropertyNumberOfPackagesRemoved;

        public Boolean getIsPropertyNumberOfPackagesRemoved()
        {
            return this.isPropertyNumberOfPackagesRemoved;
        }

        public void setIsPropertyNumberOfPackagesRemoved(Boolean removed)
        {
            this.isPropertyNumberOfPackagesRemoved = removed;
        }

        private Boolean isPropertyNumberOfContainersRemoved;

        public Boolean getIsPropertyNumberOfContainersRemoved()
        {
            return this.isPropertyNumberOfContainersRemoved;
        }

        public void setIsPropertyNumberOfContainersRemoved(Boolean removed)
        {
            this.isPropertyNumberOfContainersRemoved = removed;
        }

        private Boolean isPropertyNumberOfPakagesPerContainerRemoved;

        public Boolean getIsPropertyNumberOfPakagesPerContainerRemoved()
        {
            return this.isPropertyNumberOfPakagesPerContainerRemoved;
        }

        public void setIsPropertyNumberOfPakagesPerContainerRemoved(Boolean removed)
        {
            this.isPropertyNumberOfPakagesPerContainerRemoved = removed;
        }

        private Boolean isPropertyOrderItemShipGroupAssociationKeyRemoved;

        public Boolean getIsPropertyOrderItemShipGroupAssociationKeyRemoved()
        {
            return this.isPropertyOrderItemShipGroupAssociationKeyRemoved;
        }

        public void setIsPropertyOrderItemShipGroupAssociationKeyRemoved(Boolean removed)
        {
            this.isPropertyOrderItemShipGroupAssociationKeyRemoved = removed;
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

    }

    public static class SimpleCreateOrderItemShipGroupAssociation extends AbstractCreateOrderItemShipGroupAssociation
    {
    }

    
    public static class SimpleMergePatchOrderItemShipGroupAssociation extends AbstractMergePatchOrderItemShipGroupAssociation
    {
    }

    
	public static class SimpleRemoveOrderItemShipGroupAssociation extends AbstractOrderItemShipGroupAssociationCommand implements RemoveOrderItemShipGroupAssociation
	{
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_REMOVE;
        }
	}

    

}

