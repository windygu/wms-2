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

    MovementConfirmationLineId getMovementConfirmationLineId();

    void setMovementConfirmationLineId(MovementConfirmationLineId movementConfirmationLineId);

    String getLineNumber();

    void setLineNumber(String lineNumber);

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

    Long getVersion();

    void setVersion(Long version);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getUpdatedBy();

    void setUpdatedBy(String updatedBy);

    Date getUpdatedAt();

    void setUpdatedAt(Date updatedAt);

    Boolean getActive();

    void setActive(Boolean active);

    Boolean getDeleted();

    void setDeleted(Boolean deleted);

    String getMovementConfirmationDocumentNumber();

    void setMovementConfirmationDocumentNumber(String movementConfirmationDocumentNumber);


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(MovementConfirmationLineEvent.MovementConfirmationLineStateCreated e);

    void when(MovementConfirmationLineEvent.MovementConfirmationLineStateMergePatched e);

    void when(MovementConfirmationLineEvent.MovementConfirmationLineStateRemoved e);
    
}

