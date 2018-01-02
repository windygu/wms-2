package org.dddml.wms.domain.movement;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface MovementLineCommand extends Command
{
    String getLineNumber();

    void setLineNumber(String lineNumber);

    String getMovementDocumentNumber();

    void setMovementDocumentNumber(String movementDocumentNumber);

    interface CreateOrMergePatchMovementLine extends MovementLineCommand
    {
        BigDecimal getMovementQuantity();

        void setMovementQuantity(BigDecimal movementQuantity);

        String getProductId();

        void setProductId(String productId);

        String getLocatorIdFrom();

        void setLocatorIdFrom(String locatorIdFrom);

        String getLocatorIdTo();

        void setLocatorIdTo(String locatorIdTo);

        String getAttributeSetInstanceId();

        void setAttributeSetInstanceId(String attributeSetInstanceId);

        Boolean getProcessed();

        void setProcessed(Boolean processed);

        String getReversalLineNumber();

        void setReversalLineNumber(String reversalLineNumber);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateMovementLine extends CreateOrMergePatchMovementLine
    {
    }

    interface MergePatchMovementLine extends CreateOrMergePatchMovementLine
    {
        Boolean getIsPropertyMovementQuantityRemoved();

        void setIsPropertyMovementQuantityRemoved(Boolean removed);

        Boolean getIsPropertyProductIdRemoved();

        void setIsPropertyProductIdRemoved(Boolean removed);

        Boolean getIsPropertyLocatorIdFromRemoved();

        void setIsPropertyLocatorIdFromRemoved(Boolean removed);

        Boolean getIsPropertyLocatorIdToRemoved();

        void setIsPropertyLocatorIdToRemoved(Boolean removed);

        Boolean getIsPropertyAttributeSetInstanceIdRemoved();

        void setIsPropertyAttributeSetInstanceIdRemoved(Boolean removed);

        Boolean getIsPropertyProcessedRemoved();

        void setIsPropertyProcessedRemoved(Boolean removed);

        Boolean getIsPropertyReversalLineNumberRemoved();

        void setIsPropertyReversalLineNumberRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

    }

	interface RemoveMovementLine extends MovementLineCommand
	{
	}

}

