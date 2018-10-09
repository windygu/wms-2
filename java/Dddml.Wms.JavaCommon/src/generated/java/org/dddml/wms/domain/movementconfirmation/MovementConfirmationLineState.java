package org.dddml.wms.domain.movementconfirmation;

import java.util.Set;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.movementconfirmation.MovementConfirmationLineEvent.*;

public interface MovementConfirmationLineState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getLineNumber();

    String getMovementLineNumber();

    BigDecimal getTargetQuantity();

    BigDecimal getConfirmedQuantity();

    BigDecimal getDifferenceQuantity();

    BigDecimal getScrappedQuantity();

    String getDescription();

    Boolean getProcessed();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    Boolean getDeleted();

    String getMovementConfirmationDocumentNumber();

    interface MutableMovementConfirmationLineState extends MovementConfirmationLineState {
        void setMovementConfirmationLineId(MovementConfirmationLineId movementConfirmationLineId);

        void setLineNumber(String lineNumber);

        void setMovementLineNumber(String movementLineNumber);

        void setTargetQuantity(BigDecimal targetQuantity);

        void setConfirmedQuantity(BigDecimal confirmedQuantity);

        void setDifferenceQuantity(BigDecimal differenceQuantity);

        void setScrappedQuantity(BigDecimal scrappedQuantity);

        void setDescription(String description);

        void setProcessed(Boolean processed);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setDeleted(Boolean deleted);

        void setMovementConfirmationDocumentNumber(String movementConfirmationDocumentNumber);


        void mutate(Event e);

        void when(MovementConfirmationLineEvent.MovementConfirmationLineStateCreated e);

        void when(MovementConfirmationLineEvent.MovementConfirmationLineStateMergePatched e);

        void when(MovementConfirmationLineEvent.MovementConfirmationLineStateRemoved e);
    }

    interface SqlMovementConfirmationLineState extends MutableMovementConfirmationLineState {
        MovementConfirmationLineId getMovementConfirmationLineId();

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

