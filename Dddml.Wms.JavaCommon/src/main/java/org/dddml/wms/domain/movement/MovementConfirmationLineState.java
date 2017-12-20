package org.dddml.wms.domain.movement;

import java.util.Set;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.movement.MovementConfirmationLineStateEvent.*;

public interface MovementConfirmationLineState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    MovementConfirmationLineId getMovementConfirmationLineId();

    void setMovementConfirmationLineId(MovementConfirmationLineId movementConfirmationLineId);

    String getLineNumber();

    void setLineNumber(String lineNumber);

    BigDecimal getTargetQuantity();

    void setTargetQuantity(BigDecimal targetQuantity);

    BigDecimal getConfirmedQuantity();

    void setConfirmedQuantity(BigDecimal confirmedQuantity);

    BigDecimal getDifferenceQuantity();

    void setDifferenceQuantity(BigDecimal differenceQuantity);

    BigDecimal getScrappedQuantity();

    void setScrappedQuantity(BigDecimal scrappedQuantity);

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

    String getMovementDocumentNumber();

    void setMovementDocumentNumber(String movementDocumentNumber);


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(MovementConfirmationLineStateEvent.MovementConfirmationLineStateCreated e);

    void when(MovementConfirmationLineStateEvent.MovementConfirmationLineStateMergePatched e);

    void when(MovementConfirmationLineStateEvent.MovementConfirmationLineStateRemoved e);
    
}

