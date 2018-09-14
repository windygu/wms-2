package org.dddml.wms.domain.order;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchOrderItemShipGroupAssociationDto extends AbstractOrderItemShipGroupAssociationCommandDto
{
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
     * Cancel Quantity
     */
    private java.math.BigDecimal cancelQuantity;

    public java.math.BigDecimal getCancelQuantity()
    {
        return this.cancelQuantity;
    }

    public void setCancelQuantity(java.math.BigDecimal cancelQuantity)
    {
        this.cancelQuantity = cancelQuantity;
    }

    /**
     * Number Of Packages
     */
    private Integer numberOfPackages;

    public Integer getNumberOfPackages()
    {
        return this.numberOfPackages;
    }

    public void setNumberOfPackages(Integer numberOfPackages)
    {
        this.numberOfPackages = numberOfPackages;
    }

    /**
     * Number Of Containers
     */
    private Integer numberOfContainers;

    public Integer getNumberOfContainers()
    {
        return this.numberOfContainers;
    }

    public void setNumberOfContainers(Integer numberOfContainers)
    {
        this.numberOfContainers = numberOfContainers;
    }

    /**
     * Number Of Pakages Per Container
     */
    private Integer numberOfPakagesPerContainer;

    public Integer getNumberOfPakagesPerContainer()
    {
        return this.numberOfPakagesPerContainer;
    }

    public void setNumberOfPakagesPerContainer(Integer numberOfPakagesPerContainer)
    {
        this.numberOfPakagesPerContainer = numberOfPakagesPerContainer;
    }

    /**
     * Order Item Ship Group Association Key
     */
    private String orderItemShipGroupAssociationKey;

    public String getOrderItemShipGroupAssociationKey()
    {
        return this.orderItemShipGroupAssociationKey;
    }

    public void setOrderItemShipGroupAssociationKey(String orderItemShipGroupAssociationKey)
    {
        this.orderItemShipGroupAssociationKey = orderItemShipGroupAssociationKey;
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

    public static class CreateOrderItemShipGroupAssociationDto extends CreateOrMergePatchOrderItemShipGroupAssociationDto
    {
        public CreateOrderItemShipGroupAssociationDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static class MergePatchOrderItemShipGroupAssociationDto extends CreateOrMergePatchOrderItemShipGroupAssociationDto
    {
        public MergePatchOrderItemShipGroupAssociationDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

    }

}

