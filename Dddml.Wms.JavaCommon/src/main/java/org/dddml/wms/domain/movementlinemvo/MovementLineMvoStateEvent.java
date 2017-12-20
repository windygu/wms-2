package org.dddml.wms.domain.movementlinemvo;

import java.util.*;
import org.dddml.wms.domain.movement.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface MovementLineMvoStateEvent extends Event
{
    MovementLineMvoStateEventId getStateEventId();

    boolean getStateEventReadOnly();

    void setStateEventReadOnly(boolean readOnly);

    BigDecimal getMovementQuantity();

    void setMovementQuantity(BigDecimal movementQuantity);

    Long getVersion();

    void setVersion(Long version);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    Boolean getActive();

    void setActive(Boolean active);

    String getMovementDocumentTypeId();

    void setMovementDocumentTypeId(String movementDocumentTypeId);

    String getMovementDocumentStatusId();

    void setMovementDocumentStatusId(String movementDocumentStatusId);

    String getMovementMovementTypeId();

    void setMovementMovementTypeId(String movementMovementTypeId);

    String getMovementDescription();

    void setMovementDescription(String movementDescription);

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

    String getCommandId();

    void setCommandId(String commandId);

    interface MovementLineMvoStateCreated extends MovementLineMvoStateEvent
    {
    
    }


    interface MovementLineMvoStateMergePatched extends MovementLineMvoStateEvent
    {
        Boolean getIsPropertyMovementQuantityRemoved();

        void setIsPropertyMovementQuantityRemoved(Boolean removed);

        Boolean getIsPropertyVersionRemoved();

        void setIsPropertyVersionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        Boolean getIsPropertyMovementDocumentTypeIdRemoved();

        void setIsPropertyMovementDocumentTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyMovementDocumentStatusIdRemoved();

        void setIsPropertyMovementDocumentStatusIdRemoved(Boolean removed);

        Boolean getIsPropertyMovementMovementTypeIdRemoved();

        void setIsPropertyMovementMovementTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyMovementDescriptionRemoved();

        void setIsPropertyMovementDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyMovementCreatedByRemoved();

        void setIsPropertyMovementCreatedByRemoved(Boolean removed);

        Boolean getIsPropertyMovementCreatedAtRemoved();

        void setIsPropertyMovementCreatedAtRemoved(Boolean removed);

        Boolean getIsPropertyMovementUpdatedByRemoved();

        void setIsPropertyMovementUpdatedByRemoved(Boolean removed);

        Boolean getIsPropertyMovementUpdatedAtRemoved();

        void setIsPropertyMovementUpdatedAtRemoved(Boolean removed);

        Boolean getIsPropertyMovementActiveRemoved();

        void setIsPropertyMovementActiveRemoved(Boolean removed);

        Boolean getIsPropertyMovementDeletedRemoved();

        void setIsPropertyMovementDeletedRemoved(Boolean removed);


    }

    interface MovementLineMvoStateDeleted extends MovementLineMvoStateEvent
    {
    }


}

