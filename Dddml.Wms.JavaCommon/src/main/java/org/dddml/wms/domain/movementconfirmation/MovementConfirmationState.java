package org.dddml.wms.domain.movementconfirmation;

import java.util.Set;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.movementconfirmation.MovementConfirmationStateEvent.*;

public interface MovementConfirmationState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getDocumentNumber();

    void setDocumentNumber(String documentNumber);

    String getDocumentTypeId();

    void setDocumentTypeId(String documentTypeId);

    String getDocumentStatusId();

    void setDocumentStatusId(String documentStatusId);

    String getMovementDocumentNumber();

    void setMovementDocumentNumber(String movementDocumentNumber);

    Boolean getIsApproved();

    void setIsApproved(Boolean isApproved);

    BigDecimal getApprovalAmount();

    void setApprovalAmount(BigDecimal approvalAmount);

    String getProcessing();

    void setProcessing(String processing);

    Boolean getProcessed();

    void setProcessed(Boolean processed);

    String getDescription();

    void setDescription(String description);

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


    boolean isStateUnsaved();

    boolean getForReapplying();

    MovementConfirmationLineStates getMovementConfirmationLines();


    void mutate(Event e);

    void when(MovementConfirmationStateEvent.MovementConfirmationStateCreated e);

    void when(MovementConfirmationStateEvent.MovementConfirmationStateMergePatched e);

    void when(MovementConfirmationStateEvent.MovementConfirmationStateDeleted e);
    
}

