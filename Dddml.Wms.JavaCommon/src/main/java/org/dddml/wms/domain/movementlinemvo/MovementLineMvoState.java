package org.dddml.wms.domain.movementlinemvo;

import java.util.Set;
import org.dddml.wms.domain.movement.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.movementlinemvo.MovementLineMvoStateEvent.*;

public interface MovementLineMvoState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    MovementLineId getMovementLineId();

    void setMovementLineId(MovementLineId movementLineId);

    BigDecimal getMovementQuantity();

    void setMovementQuantity(BigDecimal movementQuantity);

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

    String getMovementDocumentTypeId();

    void setMovementDocumentTypeId(String movementDocumentTypeId);

    String getMovementDocumentStatusId();

    void setMovementDocumentStatusId(String movementDocumentStatusId);

    String getMovementMovementTypeId();

    void setMovementMovementTypeId(String movementMovementTypeId);

    String getMovementDescription();

    void setMovementDescription(String movementDescription);

    Long getMovementVersion();

    void setMovementVersion(Long movementVersion);

    String getMovementCreatedBy();

    void setMovementCreatedBy(String movementCreatedBy);

    Date getMovementCreatedAt();

    void setMovementCreatedAt(Date movementCreatedAt);

    String getMovementUpdatedBy();

    void setMovementUpdatedBy(String movementUpdatedBy);

    Date getMovementUpdatedAt();

    void setMovementUpdatedAt(Date movementUpdatedAt);

    Boolean getMovementActive();

    void setMovementActive(Boolean movementActive);

    Boolean getMovementDeleted();

    void setMovementDeleted(Boolean movementDeleted);


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(MovementLineMvoStateEvent.MovementLineMvoStateCreated e);

    void when(MovementLineMvoStateEvent.MovementLineMvoStateMergePatched e);

    void when(MovementLineMvoStateEvent.MovementLineMvoStateDeleted e);
    
}

