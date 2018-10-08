package org.dddml.wms.domain.movementconfirmation;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface MovementConfirmationLineEvent extends Event {

    interface SqlMovementConfirmationLineEvent extends MovementConfirmationLineEvent {
        MovementConfirmationLineEventId getMovementConfirmationLineEventId();
    }

    String getLineNumber();

    //void setLineNumber(String lineNumber);

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface MovementConfirmationLineStateEvent extends MovementConfirmationLineEvent {
        Long getVersion();

        void setVersion(Long version);

        String getMovementLineNumber();

        void setMovementLineNumber(String movementLineNumber);

        BigDecimal getTargetQuantity();

        void setTargetQuantity(BigDecimal targetQuantity);

        BigDecimal getConfirmedQuantity();

        void setConfirmedQuantity(BigDecimal confirmedQuantity);

        BigDecimal getDifferenceQuantity();

        void setDifferenceQuantity(BigDecimal differenceQuantity);

        BigDecimal getScrappedQuantity();

        void setScrappedQuantity(BigDecimal scrappedQuantity);

        String getDescription();

        void setDescription(String description);

        Boolean getProcessed();

        void setProcessed(Boolean processed);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface MovementConfirmationLineStateCreated extends MovementConfirmationLineStateEvent
    {
    
    }


    interface MovementConfirmationLineStateMergePatched extends MovementConfirmationLineStateEvent
    {
        Boolean getIsPropertyMovementLineNumberRemoved();

        void setIsPropertyMovementLineNumberRemoved(Boolean removed);

        Boolean getIsPropertyTargetQuantityRemoved();

        void setIsPropertyTargetQuantityRemoved(Boolean removed);

        Boolean getIsPropertyConfirmedQuantityRemoved();

        void setIsPropertyConfirmedQuantityRemoved(Boolean removed);

        Boolean getIsPropertyDifferenceQuantityRemoved();

        void setIsPropertyDifferenceQuantityRemoved(Boolean removed);

        Boolean getIsPropertyScrappedQuantityRemoved();

        void setIsPropertyScrappedQuantityRemoved(Boolean removed);

        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyProcessedRemoved();

        void setIsPropertyProcessedRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }

    interface MovementConfirmationLineStateRemoved extends MovementConfirmationLineStateEvent
    {
    }


}

