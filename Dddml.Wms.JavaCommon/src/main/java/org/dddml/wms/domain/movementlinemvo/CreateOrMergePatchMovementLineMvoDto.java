package org.dddml.wms.domain.movementlinemvo;

import org.dddml.wms.domain.movement.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchMovementLineMvoDto extends AbstractMovementLineMvoCommandDto
{
    private BigDecimal movementQuantity;

    public BigDecimal getMovementQuantity()
    {
        return this.movementQuantity;
    }

    public void setMovementQuantity(BigDecimal movementQuantity)
    {
        this.movementQuantity = movementQuantity;
    }

    private String productId;

    public String getProductId()
    {
        return this.productId;
    }

    public void setProductId(String productId)
    {
        this.productId = productId;
    }

    private String locatorIdFrom;

    public String getLocatorIdFrom()
    {
        return this.locatorIdFrom;
    }

    public void setLocatorIdFrom(String locatorIdFrom)
    {
        this.locatorIdFrom = locatorIdFrom;
    }

    private String locatorIdTo;

    public String getLocatorIdTo()
    {
        return this.locatorIdTo;
    }

    public void setLocatorIdTo(String locatorIdTo)
    {
        this.locatorIdTo = locatorIdTo;
    }

    private String attributeSetInstanceIdFrom;

    public String getAttributeSetInstanceIdFrom()
    {
        return this.attributeSetInstanceIdFrom;
    }

    public void setAttributeSetInstanceIdFrom(String attributeSetInstanceIdFrom)
    {
        this.attributeSetInstanceIdFrom = attributeSetInstanceIdFrom;
    }

    private String attributeSetInstanceIdTo;

    public String getAttributeSetInstanceIdTo()
    {
        return this.attributeSetInstanceIdTo;
    }

    public void setAttributeSetInstanceIdTo(String attributeSetInstanceIdTo)
    {
        this.attributeSetInstanceIdTo = attributeSetInstanceIdTo;
    }

    private Boolean processed;

    public Boolean getProcessed()
    {
        return this.processed;
    }

    public void setProcessed(Boolean processed)
    {
        this.processed = processed;
    }

    private String reversalLineNumber;

    public String getReversalLineNumber()
    {
        return this.reversalLineNumber;
    }

    public void setReversalLineNumber(String reversalLineNumber)
    {
        this.reversalLineNumber = reversalLineNumber;
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

    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }

    private String movementDocumentTypeId;

    public String getMovementDocumentTypeId()
    {
        return this.movementDocumentTypeId;
    }

    public void setMovementDocumentTypeId(String movementDocumentTypeId)
    {
        this.movementDocumentTypeId = movementDocumentTypeId;
    }

    private String documentAction;

    public String getDocumentAction()
    {
        return this.documentAction;
    }

    public void setDocumentAction(String documentAction)
    {
        this.documentAction = documentAction;
    }

    private String movementDescription;

    public String getMovementDescription()
    {
        return this.movementDescription;
    }

    public void setMovementDescription(String movementDescription)
    {
        this.movementDescription = movementDescription;
    }

    private String movementCreatedBy;

    public String getMovementCreatedBy()
    {
        return this.movementCreatedBy;
    }

    public void setMovementCreatedBy(String movementCreatedBy)
    {
        this.movementCreatedBy = movementCreatedBy;
    }

    private Date movementCreatedAt;

    public Date getMovementCreatedAt()
    {
        return this.movementCreatedAt;
    }

    public void setMovementCreatedAt(Date movementCreatedAt)
    {
        this.movementCreatedAt = movementCreatedAt;
    }

    private String movementUpdatedBy;

    public String getMovementUpdatedBy()
    {
        return this.movementUpdatedBy;
    }

    public void setMovementUpdatedBy(String movementUpdatedBy)
    {
        this.movementUpdatedBy = movementUpdatedBy;
    }

    private Date movementUpdatedAt;

    public Date getMovementUpdatedAt()
    {
        return this.movementUpdatedAt;
    }

    public void setMovementUpdatedAt(Date movementUpdatedAt)
    {
        this.movementUpdatedAt = movementUpdatedAt;
    }

    private Boolean movementActive;

    public Boolean getMovementActive()
    {
        return this.movementActive;
    }

    public void setMovementActive(Boolean movementActive)
    {
        this.movementActive = movementActive;
    }

    private Boolean movementDeleted;

    public Boolean getMovementDeleted()
    {
        return this.movementDeleted;
    }

    public void setMovementDeleted(Boolean movementDeleted)
    {
        this.movementDeleted = movementDeleted;
    }

    private Boolean isPropertyMovementQuantityRemoved;

    public Boolean getIsPropertyMovementQuantityRemoved()
    {
        return this.isPropertyMovementQuantityRemoved;
    }

    public void setIsPropertyMovementQuantityRemoved(Boolean removed)
    {
        this.isPropertyMovementQuantityRemoved = removed;
    }

    private Boolean isPropertyProductIdRemoved;

    public Boolean getIsPropertyProductIdRemoved()
    {
        return this.isPropertyProductIdRemoved;
    }

    public void setIsPropertyProductIdRemoved(Boolean removed)
    {
        this.isPropertyProductIdRemoved = removed;
    }

    private Boolean isPropertyLocatorIdFromRemoved;

    public Boolean getIsPropertyLocatorIdFromRemoved()
    {
        return this.isPropertyLocatorIdFromRemoved;
    }

    public void setIsPropertyLocatorIdFromRemoved(Boolean removed)
    {
        this.isPropertyLocatorIdFromRemoved = removed;
    }

    private Boolean isPropertyLocatorIdToRemoved;

    public Boolean getIsPropertyLocatorIdToRemoved()
    {
        return this.isPropertyLocatorIdToRemoved;
    }

    public void setIsPropertyLocatorIdToRemoved(Boolean removed)
    {
        this.isPropertyLocatorIdToRemoved = removed;
    }

    private Boolean isPropertyAttributeSetInstanceIdFromRemoved;

    public Boolean getIsPropertyAttributeSetInstanceIdFromRemoved()
    {
        return this.isPropertyAttributeSetInstanceIdFromRemoved;
    }

    public void setIsPropertyAttributeSetInstanceIdFromRemoved(Boolean removed)
    {
        this.isPropertyAttributeSetInstanceIdFromRemoved = removed;
    }

    private Boolean isPropertyAttributeSetInstanceIdToRemoved;

    public Boolean getIsPropertyAttributeSetInstanceIdToRemoved()
    {
        return this.isPropertyAttributeSetInstanceIdToRemoved;
    }

    public void setIsPropertyAttributeSetInstanceIdToRemoved(Boolean removed)
    {
        this.isPropertyAttributeSetInstanceIdToRemoved = removed;
    }

    private Boolean isPropertyProcessedRemoved;

    public Boolean getIsPropertyProcessedRemoved()
    {
        return this.isPropertyProcessedRemoved;
    }

    public void setIsPropertyProcessedRemoved(Boolean removed)
    {
        this.isPropertyProcessedRemoved = removed;
    }

    private Boolean isPropertyReversalLineNumberRemoved;

    public Boolean getIsPropertyReversalLineNumberRemoved()
    {
        return this.isPropertyReversalLineNumberRemoved;
    }

    public void setIsPropertyReversalLineNumberRemoved(Boolean removed)
    {
        this.isPropertyReversalLineNumberRemoved = removed;
    }

    private Boolean isPropertyVersionRemoved;

    public Boolean getIsPropertyVersionRemoved()
    {
        return this.isPropertyVersionRemoved;
    }

    public void setIsPropertyVersionRemoved(Boolean removed)
    {
        this.isPropertyVersionRemoved = removed;
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

    private Boolean isPropertyMovementDocumentTypeIdRemoved;

    public Boolean getIsPropertyMovementDocumentTypeIdRemoved()
    {
        return this.isPropertyMovementDocumentTypeIdRemoved;
    }

    public void setIsPropertyMovementDocumentTypeIdRemoved(Boolean removed)
    {
        this.isPropertyMovementDocumentTypeIdRemoved = removed;
    }

    private Boolean isPropertyMovementDescriptionRemoved;

    public Boolean getIsPropertyMovementDescriptionRemoved()
    {
        return this.isPropertyMovementDescriptionRemoved;
    }

    public void setIsPropertyMovementDescriptionRemoved(Boolean removed)
    {
        this.isPropertyMovementDescriptionRemoved = removed;
    }

    private Boolean isPropertyMovementCreatedByRemoved;

    public Boolean getIsPropertyMovementCreatedByRemoved()
    {
        return this.isPropertyMovementCreatedByRemoved;
    }

    public void setIsPropertyMovementCreatedByRemoved(Boolean removed)
    {
        this.isPropertyMovementCreatedByRemoved = removed;
    }

    private Boolean isPropertyMovementCreatedAtRemoved;

    public Boolean getIsPropertyMovementCreatedAtRemoved()
    {
        return this.isPropertyMovementCreatedAtRemoved;
    }

    public void setIsPropertyMovementCreatedAtRemoved(Boolean removed)
    {
        this.isPropertyMovementCreatedAtRemoved = removed;
    }

    private Boolean isPropertyMovementUpdatedByRemoved;

    public Boolean getIsPropertyMovementUpdatedByRemoved()
    {
        return this.isPropertyMovementUpdatedByRemoved;
    }

    public void setIsPropertyMovementUpdatedByRemoved(Boolean removed)
    {
        this.isPropertyMovementUpdatedByRemoved = removed;
    }

    private Boolean isPropertyMovementUpdatedAtRemoved;

    public Boolean getIsPropertyMovementUpdatedAtRemoved()
    {
        return this.isPropertyMovementUpdatedAtRemoved;
    }

    public void setIsPropertyMovementUpdatedAtRemoved(Boolean removed)
    {
        this.isPropertyMovementUpdatedAtRemoved = removed;
    }

    private Boolean isPropertyMovementActiveRemoved;

    public Boolean getIsPropertyMovementActiveRemoved()
    {
        return this.isPropertyMovementActiveRemoved;
    }

    public void setIsPropertyMovementActiveRemoved(Boolean removed)
    {
        this.isPropertyMovementActiveRemoved = removed;
    }

    private Boolean isPropertyMovementDeletedRemoved;

    public Boolean getIsPropertyMovementDeletedRemoved()
    {
        return this.isPropertyMovementDeletedRemoved;
    }

    public void setIsPropertyMovementDeletedRemoved(Boolean removed)
    {
        this.isPropertyMovementDeletedRemoved = removed;
    }

    public void copyTo(AbstractMovementLineMvoCommand.AbstractCreateOrMergePatchMovementLineMvo command)
    {
        ((AbstractMovementLineMvoCommandDto) this).copyTo(command);
        command.setMovementQuantity(this.getMovementQuantity());
        command.setProductId(this.getProductId());
        command.setLocatorIdFrom(this.getLocatorIdFrom());
        command.setLocatorIdTo(this.getLocatorIdTo());
        command.setAttributeSetInstanceIdFrom(this.getAttributeSetInstanceIdFrom());
        command.setAttributeSetInstanceIdTo(this.getAttributeSetInstanceIdTo());
        command.setProcessed(this.getProcessed());
        command.setReversalLineNumber(this.getReversalLineNumber());
        command.setVersion(this.getVersion());
        command.setActive(this.getActive());
        command.setMovementDocumentTypeId(this.getMovementDocumentTypeId());
        command.setDocumentAction(this.getDocumentAction());
        command.setMovementDescription(this.getMovementDescription());
        command.setMovementCreatedBy(this.getMovementCreatedBy());
        command.setMovementCreatedAt(this.getMovementCreatedAt());
        command.setMovementUpdatedBy(this.getMovementUpdatedBy());
        command.setMovementUpdatedAt(this.getMovementUpdatedAt());
        command.setMovementActive(this.getMovementActive());
        command.setMovementDeleted(this.getMovementDeleted());
    }

    public MovementLineMvoCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractMovementLineMvoCommand.SimpleCreateMovementLineMvo command = new AbstractMovementLineMvoCommand.SimpleCreateMovementLineMvo();
            copyTo((AbstractMovementLineMvoCommand.AbstractCreateMovementLineMvo) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractMovementLineMvoCommand.SimpleMergePatchMovementLineMvo command = new AbstractMovementLineMvoCommand.SimpleMergePatchMovementLineMvo();
            copyTo((AbstractMovementLineMvoCommand.SimpleMergePatchMovementLineMvo) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractMovementLineMvoCommand.AbstractCreateMovementLineMvo command)
    {
        copyTo((AbstractMovementLineMvoCommand.AbstractCreateOrMergePatchMovementLineMvo) command);
    }

    public void copyTo(AbstractMovementLineMvoCommand.AbstractMergePatchMovementLineMvo command)
    {
        copyTo((AbstractMovementLineMvoCommand.AbstractCreateOrMergePatchMovementLineMvo) command);
        command.setIsPropertyMovementQuantityRemoved(this.getIsPropertyMovementQuantityRemoved());
        command.setIsPropertyProductIdRemoved(this.getIsPropertyProductIdRemoved());
        command.setIsPropertyLocatorIdFromRemoved(this.getIsPropertyLocatorIdFromRemoved());
        command.setIsPropertyLocatorIdToRemoved(this.getIsPropertyLocatorIdToRemoved());
        command.setIsPropertyAttributeSetInstanceIdFromRemoved(this.getIsPropertyAttributeSetInstanceIdFromRemoved());
        command.setIsPropertyAttributeSetInstanceIdToRemoved(this.getIsPropertyAttributeSetInstanceIdToRemoved());
        command.setIsPropertyProcessedRemoved(this.getIsPropertyProcessedRemoved());
        command.setIsPropertyReversalLineNumberRemoved(this.getIsPropertyReversalLineNumberRemoved());
        command.setIsPropertyVersionRemoved(this.getIsPropertyVersionRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
        command.setIsPropertyMovementDocumentTypeIdRemoved(this.getIsPropertyMovementDocumentTypeIdRemoved());
        command.setIsPropertyMovementDescriptionRemoved(this.getIsPropertyMovementDescriptionRemoved());
        command.setIsPropertyMovementCreatedByRemoved(this.getIsPropertyMovementCreatedByRemoved());
        command.setIsPropertyMovementCreatedAtRemoved(this.getIsPropertyMovementCreatedAtRemoved());
        command.setIsPropertyMovementUpdatedByRemoved(this.getIsPropertyMovementUpdatedByRemoved());
        command.setIsPropertyMovementUpdatedAtRemoved(this.getIsPropertyMovementUpdatedAtRemoved());
        command.setIsPropertyMovementActiveRemoved(this.getIsPropertyMovementActiveRemoved());
        command.setIsPropertyMovementDeletedRemoved(this.getIsPropertyMovementDeletedRemoved());
    }

    public static class CreateMovementLineMvoDto extends CreateOrMergePatchMovementLineMvoDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public MovementLineMvoCommand.CreateMovementLineMvo toCreateMovementLineMvo()
        {
            return (MovementLineMvoCommand.CreateMovementLineMvo) toCommand();
        }

    }

    public static class MergePatchMovementLineMvoDto extends CreateOrMergePatchMovementLineMvoDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public MovementLineMvoCommand.MergePatchMovementLineMvo toMergePatchMovementLineMvo()
        {
            return (MovementLineMvoCommand.MergePatchMovementLineMvo) toCommand();
        }

    }

}

