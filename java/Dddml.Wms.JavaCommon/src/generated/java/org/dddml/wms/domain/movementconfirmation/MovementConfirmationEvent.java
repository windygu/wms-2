package org.dddml.wms.domain.movementconfirmation;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface MovementConfirmationEvent extends Event
{
    MovementConfirmationEventId getMovementConfirmationEventId();

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface MovementConfirmationStateEvent extends MovementConfirmationEvent {
        String getDocumentStatusId();

        void setDocumentStatusId(String documentStatusId);

        String getMovementDocumentNumber();

        void setMovementDocumentNumber(String movementDocumentNumber);

        Boolean getIsApproved();

        void setIsApproved(Boolean isApproved);

        BigDecimal getApprovalAmount();

        void setApprovalAmount(BigDecimal approvalAmount);

        Boolean getProcessed();

        void setProcessed(Boolean processed);

        String getProcessing();

        void setProcessing(String processing);

        String getDocumentTypeId();

        void setDocumentTypeId(String documentTypeId);

        String getDescription();

        void setDescription(String description);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface MovementConfirmationStateCreated extends MovementConfirmationStateEvent
    {
        Iterable<MovementConfirmationLineEvent.MovementConfirmationLineStateCreated> getMovementConfirmationLineEvents();
        
        void addMovementConfirmationLineEvent(MovementConfirmationLineEvent.MovementConfirmationLineStateCreated e);

        MovementConfirmationLineEvent.MovementConfirmationLineStateCreated newMovementConfirmationLineStateCreated(String lineNumber);

    
    }


    interface MovementConfirmationStateMergePatched extends MovementConfirmationStateEvent
    {
        Boolean getIsPropertyDocumentStatusIdRemoved();

        void setIsPropertyDocumentStatusIdRemoved(Boolean removed);

        Boolean getIsPropertyMovementDocumentNumberRemoved();

        void setIsPropertyMovementDocumentNumberRemoved(Boolean removed);

        Boolean getIsPropertyIsApprovedRemoved();

        void setIsPropertyIsApprovedRemoved(Boolean removed);

        Boolean getIsPropertyApprovalAmountRemoved();

        void setIsPropertyApprovalAmountRemoved(Boolean removed);

        Boolean getIsPropertyProcessedRemoved();

        void setIsPropertyProcessedRemoved(Boolean removed);

        Boolean getIsPropertyProcessingRemoved();

        void setIsPropertyProcessingRemoved(Boolean removed);

        Boolean getIsPropertyDocumentTypeIdRemoved();

        void setIsPropertyDocumentTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        Iterable<MovementConfirmationLineEvent> getMovementConfirmationLineEvents();
        
        void addMovementConfirmationLineEvent(MovementConfirmationLineEvent e);

        MovementConfirmationLineEvent.MovementConfirmationLineStateCreated newMovementConfirmationLineStateCreated(String lineNumber);

        MovementConfirmationLineEvent.MovementConfirmationLineStateMergePatched newMovementConfirmationLineStateMergePatched(String lineNumber);

        MovementConfirmationLineEvent.MovementConfirmationLineStateRemoved newMovementConfirmationLineStateRemoved(String lineNumber);


    }

    interface MovementConfirmationStateDeleted extends MovementConfirmationStateEvent
    {
        Iterable<MovementConfirmationLineEvent.MovementConfirmationLineStateRemoved> getMovementConfirmationLineEvents();
        
        void addMovementConfirmationLineEvent(MovementConfirmationLineEvent.MovementConfirmationLineStateRemoved e);
        
        MovementConfirmationLineEvent.MovementConfirmationLineStateRemoved newMovementConfirmationLineStateRemoved(String lineNumber);

    }


}

