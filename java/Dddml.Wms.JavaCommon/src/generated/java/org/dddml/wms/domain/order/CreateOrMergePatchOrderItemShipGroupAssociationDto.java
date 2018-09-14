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

    public void copyTo(AbstractOrderItemShipGroupAssociationCommand.AbstractCreateOrMergePatchOrderItemShipGroupAssociation command)
    {
        ((AbstractOrderItemShipGroupAssociationCommandDto) this).copyTo(command);
        command.setQuantity(this.getQuantity());
        command.setCancelQuantity(this.getCancelQuantity());
        command.setNumberOfPackages(this.getNumberOfPackages());
        command.setNumberOfContainers(this.getNumberOfContainers());
        command.setNumberOfPakagesPerContainer(this.getNumberOfPakagesPerContainer());
        command.setOrderItemShipGroupAssociationKey(this.getOrderItemShipGroupAssociationKey());
        command.setActive(this.getActive());
    }

    public OrderItemShipGroupAssociationCommand toCommand()
    {
        if (getCommandType() == null) {
            setCommandType(COMMAND_TYPE_MERGE_PATCH);
        }
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractOrderItemShipGroupAssociationCommand.SimpleCreateOrderItemShipGroupAssociation command = new AbstractOrderItemShipGroupAssociationCommand.SimpleCreateOrderItemShipGroupAssociation();
            copyTo((AbstractOrderItemShipGroupAssociationCommand.AbstractCreateOrderItemShipGroupAssociation) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractOrderItemShipGroupAssociationCommand.SimpleMergePatchOrderItemShipGroupAssociation command = new AbstractOrderItemShipGroupAssociationCommand.SimpleMergePatchOrderItemShipGroupAssociation();
            copyTo((AbstractOrderItemShipGroupAssociationCommand.SimpleMergePatchOrderItemShipGroupAssociation) command);
            return command;
        } 
        else if (COMMAND_TYPE_REMOVE.equals(getCommandType())) {
            AbstractOrderItemShipGroupAssociationCommand.SimpleRemoveOrderItemShipGroupAssociation command = new AbstractOrderItemShipGroupAssociationCommand.SimpleRemoveOrderItemShipGroupAssociation();
            ((AbstractOrderItemShipGroupAssociationCommandDto) this).copyTo(command);
            return command;
        }
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractOrderItemShipGroupAssociationCommand.AbstractCreateOrderItemShipGroupAssociation command)
    {
        copyTo((AbstractOrderItemShipGroupAssociationCommand.AbstractCreateOrMergePatchOrderItemShipGroupAssociation) command);
    }

    public void copyTo(AbstractOrderItemShipGroupAssociationCommand.AbstractMergePatchOrderItemShipGroupAssociation command)
    {
        copyTo((AbstractOrderItemShipGroupAssociationCommand.AbstractCreateOrMergePatchOrderItemShipGroupAssociation) command);
        command.setIsPropertyQuantityRemoved(this.getIsPropertyQuantityRemoved());
        command.setIsPropertyCancelQuantityRemoved(this.getIsPropertyCancelQuantityRemoved());
        command.setIsPropertyNumberOfPackagesRemoved(this.getIsPropertyNumberOfPackagesRemoved());
        command.setIsPropertyNumberOfContainersRemoved(this.getIsPropertyNumberOfContainersRemoved());
        command.setIsPropertyNumberOfPakagesPerContainerRemoved(this.getIsPropertyNumberOfPakagesPerContainerRemoved());
        command.setIsPropertyOrderItemShipGroupAssociationKeyRemoved(this.getIsPropertyOrderItemShipGroupAssociationKeyRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
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
        public OrderItemShipGroupAssociationCommand.CreateOrderItemShipGroupAssociation toCreateOrderItemShipGroupAssociation()
        {
            return (OrderItemShipGroupAssociationCommand.CreateOrderItemShipGroupAssociation) toCommand();
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
        public OrderItemShipGroupAssociationCommand.MergePatchOrderItemShipGroupAssociation toMergePatchOrderItemShipGroupAssociation()
        {
            return (OrderItemShipGroupAssociationCommand.MergePatchOrderItemShipGroupAssociation) toCommand();
        }

    }

}

