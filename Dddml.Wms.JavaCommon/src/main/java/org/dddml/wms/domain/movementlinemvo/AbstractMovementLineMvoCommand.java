package org.dddml.wms.domain.movementlinemvo;

import java.util.*;
import org.dddml.wms.domain.movement.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractMovementLineMvoCommand extends AbstractCommand implements MovementLineMvoCommand
{
    private MovementLineId movementLineId;

    public MovementLineId getMovementLineId()
    {
        return this.movementLineId;
    }

    public void setMovementLineId(MovementLineId movementLineId)
    {
        this.movementLineId = movementLineId;
    }

    private Long movementVersion;

    public Long getMovementVersion()
    {
        return this.movementVersion;
    }

    public void setMovementVersion(Long movementVersion)
    {
        this.movementVersion = movementVersion;
    }


    public static abstract class AbstractCreateOrMergePatchMovementLineMvo extends AbstractMovementLineMvoCommand implements CreateOrMergePatchMovementLineMvo
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

    }

    public static abstract class AbstractCreateMovementLineMvo extends AbstractCreateOrMergePatchMovementLineMvo implements CreateMovementLineMvo
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static abstract class AbstractMergePatchMovementLineMvo extends AbstractCreateOrMergePatchMovementLineMvo implements MergePatchMovementLineMvo
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
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

    }

    public static class SimpleCreateMovementLineMvo extends AbstractCreateMovementLineMvo
    {
    }

    
    public static class SimpleMergePatchMovementLineMvo extends AbstractMergePatchMovementLineMvo
    {
    }

    
	public static class SimpleDeleteMovementLineMvo extends AbstractMovementLineMvoCommand implements DeleteMovementLineMvo
	{
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_DELETE;
        }
	}

    

}

