package org.dddml.wms.domain.movementconfirmationlinemvo;

import java.util.Set;
import org.dddml.wms.domain.movementconfirmation.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.movementconfirmationlinemvo.MovementConfirmationLineMvoStateEvent.*;

public interface MovementConfirmationLineMvoState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    MovementConfirmationLineId getMovementConfirmationLineId();

    void setMovementConfirmationLineId(MovementConfirmationLineId movementConfirmationLineId);

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

    String getMovementConfirmationDocumentTypeId();

    void setMovementConfirmationDocumentTypeId(String movementConfirmationDocumentTypeId);

    String getMovementConfirmationDocumentStatusId();

    void setMovementConfirmationDocumentStatusId(String movementConfirmationDocumentStatusId);

    String getMovementConfirmationMovementDocumentNumber();

    void setMovementConfirmationMovementDocumentNumber(String movementConfirmationMovementDocumentNumber);

    Boolean getMovementConfirmationIsApproved();

    void setMovementConfirmationIsApproved(Boolean movementConfirmationIsApproved);

    BigDecimal getMovementConfirmationApprovalAmount();

    void setMovementConfirmationApprovalAmount(BigDecimal movementConfirmationApprovalAmount);

    String getMovementConfirmationProcessing();

    void setMovementConfirmationProcessing(String movementConfirmationProcessing);

    Boolean getMovementConfirmationProcessed();

    void setMovementConfirmationProcessed(Boolean movementConfirmationProcessed);

    String getMovementConfirmationDescription();

    void setMovementConfirmationDescription(String movementConfirmationDescription);

    Long getMovementConfirmationVersion();

    void setMovementConfirmationVersion(Long movementConfirmationVersion);

    String getMovementConfirmationCreatedBy();

    void setMovementConfirmationCreatedBy(String movementConfirmationCreatedBy);

    Date getMovementConfirmationCreatedAt();

    void setMovementConfirmationCreatedAt(Date movementConfirmationCreatedAt);

    String getMovementConfirmationUpdatedBy();

    void setMovementConfirmationUpdatedBy(String movementConfirmationUpdatedBy);

    Date getMovementConfirmationUpdatedAt();

    void setMovementConfirmationUpdatedAt(Date movementConfirmationUpdatedAt);

    Boolean getMovementConfirmationActive();

    void setMovementConfirmationActive(Boolean movementConfirmationActive);

    Boolean getMovementConfirmationDeleted();

    void setMovementConfirmationDeleted(Boolean movementConfirmationDeleted);


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(MovementConfirmationLineMvoStateEvent.MovementConfirmationLineMvoStateCreated e);

    void when(MovementConfirmationLineMvoStateEvent.MovementConfirmationLineMvoStateMergePatched e);

    void when(MovementConfirmationLineMvoStateEvent.MovementConfirmationLineMvoStateDeleted e);
    
}

