package org.dddml.wms.domain.movementconfirmation;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface MovementConfirmationStateEvent extends Event
{
    MovementConfirmationEventId getMovementConfirmationEventId();

    boolean getStateEventReadOnly();

    void setStateEventReadOnly(boolean readOnly);

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

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    Boolean getActive();

    void setActive(Boolean active);

    String getCommandId();

    void setCommandId(String commandId);

    interface MovementConfirmationStateCreated extends MovementConfirmationStateEvent
    {
        Iterable<MovementConfirmationLineStateEvent.MovementConfirmationLineStateCreated> getMovementConfirmationLineEvents();
        
        void addMovementConfirmationLineEvent(MovementConfirmationLineStateEvent.MovementConfirmationLineStateCreated e);

        MovementConfirmationLineStateEvent.MovementConfirmationLineStateCreated newMovementConfirmationLineStateCreated(String lineNumber);

    
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

        Iterable<MovementConfirmationLineStateEvent> getMovementConfirmationLineEvents();
        
        void addMovementConfirmationLineEvent(MovementConfirmationLineStateEvent e);

        MovementConfirmationLineStateEvent.MovementConfirmationLineStateCreated newMovementConfirmationLineStateCreated(String lineNumber);

        MovementConfirmationLineStateEvent.MovementConfirmationLineStateMergePatched newMovementConfirmationLineStateMergePatched(String lineNumber);

        MovementConfirmationLineStateEvent.MovementConfirmationLineStateRemoved newMovementConfirmationLineStateRemoved(String lineNumber);


    }

    interface MovementConfirmationStateDeleted extends MovementConfirmationStateEvent
    {
        Iterable<MovementConfirmationLineStateEvent.MovementConfirmationLineStateRemoved> getMovementConfirmationLineEvents();
        
        void addMovementConfirmationLineEvent(MovementConfirmationLineStateEvent.MovementConfirmationLineStateRemoved e);
        
        MovementConfirmationLineStateEvent.MovementConfirmationLineStateRemoved newMovementConfirmationLineStateRemoved(String lineNumber);

    }


}

