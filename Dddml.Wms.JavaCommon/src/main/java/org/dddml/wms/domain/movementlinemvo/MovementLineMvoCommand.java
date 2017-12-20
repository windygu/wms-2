package org.dddml.wms.domain.movementlinemvo;

import java.util.*;
import org.dddml.wms.domain.movement.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface MovementLineMvoCommand extends Command
{
    MovementLineId getMovementLineId();

    void setMovementLineId(MovementLineId movementLineId);

    Long getMovementVersion();

    void setMovementVersion(Long movementVersion);

    static void throwOnInvalidStateTransition(MovementLineMvoState state, Command c) {
        if (state.getMovementVersion() == null)
        {
            if (isCommandCreate((MovementLineMvoCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (state.getDeleted())
        {
            throw DomainError.named("zombie", "Can't do anything to deleted aggregate.");
        }
        if (isCommandCreate((MovementLineMvoCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(MovementLineMvoCommand c) {
        return ((c instanceof MovementLineMvoCommand.CreateMovementLineMvo) 
            && c.getMovementVersion().equals(MovementLineMvoState.VERSION_NULL));
    }

    interface CreateOrMergePatchMovementLineMvo extends MovementLineMvoCommand
    {
        BigDecimal getMovementQuantity();

        void setMovementQuantity(BigDecimal movementQuantity);

        String getProductId();

        void setProductId(String productId);

        String getLocatorIdFrom();

        void setLocatorIdFrom(String locatorIdFrom);

        String getLocatorIdTo();

        void setLocatorIdTo(String locatorIdTo);

        String getAttributeSetInstanceIdFrom();

        void setAttributeSetInstanceIdFrom(String attributeSetInstanceIdFrom);

        String getAttributeSetInstanceIdTo();

        void setAttributeSetInstanceIdTo(String attributeSetInstanceIdTo);

        Boolean getProcessed();

        void setProcessed(Boolean processed);

        String getReversalLineNumber();

        void setReversalLineNumber(String reversalLineNumber);

        Long getVersion();

        void setVersion(Long version);

        Boolean getActive();

        void setActive(Boolean active);

        String getMovementDocumentTypeId();

        void setMovementDocumentTypeId(String movementDocumentTypeId);

        String getDocumentAction();

        void setDocumentAction(String documentAction);

        String getMovementDescription();

        void setMovementDescription(String movementDescription);

        String getMovementCreatedBy();

        void setMovementCreatedBy(String movementCreatedBy);

        Date getMovementCreatedAt();

        void setMovementCreatedAt(Date movementCreatedAt);

        String getMovementUpdatedBy();

        void setMovementUpdatedBy(String movementUpdatedBy);

        Date getMovementUpdatedAt();

        void setMovementUpdatedAt(Date movementUpdatedAt);

        Boolean getMovementActive();

        void setMovementActive(Boolean movementActive);

        Boolean getMovementDeleted();

        void setMovementDeleted(Boolean movementDeleted);

    }

    interface CreateMovementLineMvo extends CreateOrMergePatchMovementLineMvo
    {
    }

    interface MergePatchMovementLineMvo extends CreateOrMergePatchMovementLineMvo
    {
        Boolean getIsPropertyMovementQuantityRemoved();

        void setIsPropertyMovementQuantityRemoved(Boolean removed);

        Boolean getIsPropertyProductIdRemoved();

        void setIsPropertyProductIdRemoved(Boolean removed);

        Boolean getIsPropertyLocatorIdFromRemoved();

        void setIsPropertyLocatorIdFromRemoved(Boolean removed);

        Boolean getIsPropertyLocatorIdToRemoved();

        void setIsPropertyLocatorIdToRemoved(Boolean removed);

        Boolean getIsPropertyAttributeSetInstanceIdFromRemoved();

        void setIsPropertyAttributeSetInstanceIdFromRemoved(Boolean removed);

        Boolean getIsPropertyAttributeSetInstanceIdToRemoved();

        void setIsPropertyAttributeSetInstanceIdToRemoved(Boolean removed);

        Boolean getIsPropertyProcessedRemoved();

        void setIsPropertyProcessedRemoved(Boolean removed);

        Boolean getIsPropertyReversalLineNumberRemoved();

        void setIsPropertyReversalLineNumberRemoved(Boolean removed);

        Boolean getIsPropertyVersionRemoved();

        void setIsPropertyVersionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        Boolean getIsPropertyMovementDocumentTypeIdRemoved();

        void setIsPropertyMovementDocumentTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyMovementDescriptionRemoved();

        void setIsPropertyMovementDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyMovementCreatedByRemoved();

        void setIsPropertyMovementCreatedByRemoved(Boolean removed);

        Boolean getIsPropertyMovementCreatedAtRemoved();

        void setIsPropertyMovementCreatedAtRemoved(Boolean removed);

        Boolean getIsPropertyMovementUpdatedByRemoved();

        void setIsPropertyMovementUpdatedByRemoved(Boolean removed);

        Boolean getIsPropertyMovementUpdatedAtRemoved();

        void setIsPropertyMovementUpdatedAtRemoved(Boolean removed);

        Boolean getIsPropertyMovementActiveRemoved();

        void setIsPropertyMovementActiveRemoved(Boolean removed);

        Boolean getIsPropertyMovementDeletedRemoved();

        void setIsPropertyMovementDeletedRemoved(Boolean removed);

    }

	interface DeleteMovementLineMvo extends MovementLineMvoCommand
	{
	}

}

