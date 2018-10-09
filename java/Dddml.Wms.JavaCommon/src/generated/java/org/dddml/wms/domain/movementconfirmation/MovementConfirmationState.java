package org.dddml.wms.domain.movementconfirmation;

import java.util.Set;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.movementconfirmation.MovementConfirmationEvent.*;

public interface MovementConfirmationState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getDocumentNumber();

    String getDocumentStatusId();

    String getMovementDocumentNumber();

    Boolean getIsApproved();

    BigDecimal getApprovalAmount();

    Boolean getProcessed();

    String getProcessing();

    String getDocumentTypeId();

    String getDescription();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    Boolean getDeleted();

    EntityStateCollection<String, MovementConfirmationLineState> getMovementConfirmationLines();

    interface MutableMovementConfirmationState extends MovementConfirmationState {
        void setDocumentNumber(String documentNumber);

        void setDocumentStatusId(String documentStatusId);

        void setMovementDocumentNumber(String movementDocumentNumber);

        void setIsApproved(Boolean isApproved);

        void setApprovalAmount(BigDecimal approvalAmount);

        void setProcessed(Boolean processed);

        void setProcessing(String processing);

        void setDocumentTypeId(String documentTypeId);

        void setDescription(String description);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setDeleted(Boolean deleted);


        void mutate(Event e);

        void when(MovementConfirmationEvent.MovementConfirmationStateCreated e);

        void when(MovementConfirmationEvent.MovementConfirmationStateMergePatched e);

        void when(MovementConfirmationEvent.MovementConfirmationStateDeleted e);
    }

    interface SqlMovementConfirmationState extends MutableMovementConfirmationState {

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

