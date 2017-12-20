package org.dddml.wms.domain.movement;

import java.util.Set;
import java.util.Date;
import java.math.BigDecimal;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.movement.MovementStateEvent.*;

public interface MovementState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getDocumentNumber();

    void setDocumentNumber(String documentNumber);

    String getDocumentTypeId();

    void setDocumentTypeId(String documentTypeId);

    String getDocumentStatusId();

    void setDocumentStatusId(String documentStatusId);

    String getMovementTypeId();

    void setMovementTypeId(String movementTypeId);

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

    MovementLineStates getMovementLines();

    MovementConfirmationLineStates getMovementConfirmationLines();


    void mutate(Event e);

    void when(MovementStateEvent.MovementStateCreated e);

    void when(MovementStateEvent.MovementStateMergePatched e);

    void when(MovementStateEvent.MovementStateDeleted e);
    
}

