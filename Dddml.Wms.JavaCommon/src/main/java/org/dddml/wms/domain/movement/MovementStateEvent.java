package org.dddml.wms.domain.movement;

import java.util.*;
import java.util.Date;
import java.math.BigDecimal;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface MovementStateEvent extends Event
{
    MovementStateEventId getStateEventId();

    boolean getStateEventReadOnly();

    void setStateEventReadOnly(boolean readOnly);

    String getDocumentTypeId();

    void setDocumentTypeId(String documentTypeId);

    String getDocumentStatusId();

    void setDocumentStatusId(String documentStatusId);

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

    interface MovementStateCreated extends MovementStateEvent
    {
        Iterable<MovementLineStateEvent.MovementLineStateCreated> getMovementLineEvents();
        
        void addMovementLineEvent(MovementLineStateEvent.MovementLineStateCreated e);

        MovementLineStateEvent.MovementLineStateCreated newMovementLineStateCreated(String lineNumber);

    
    }


    interface MovementStateMergePatched extends MovementStateEvent
    {
        Boolean getIsPropertyDocumentTypeIdRemoved();

        void setIsPropertyDocumentTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyDocumentStatusIdRemoved();

        void setIsPropertyDocumentStatusIdRemoved(Boolean removed);

        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        Iterable<MovementLineStateEvent> getMovementLineEvents();
        
        void addMovementLineEvent(MovementLineStateEvent e);

        MovementLineStateEvent.MovementLineStateCreated newMovementLineStateCreated(String lineNumber);

        MovementLineStateEvent.MovementLineStateMergePatched newMovementLineStateMergePatched(String lineNumber);

        MovementLineStateEvent.MovementLineStateRemoved newMovementLineStateRemoved(String lineNumber);


    }

    interface MovementStateDeleted extends MovementStateEvent
    {
        Iterable<MovementLineStateEvent.MovementLineStateRemoved> getMovementLineEvents();
        
        void addMovementLineEvent(MovementLineStateEvent.MovementLineStateRemoved e);
        
        MovementLineStateEvent.MovementLineStateRemoved newMovementLineStateRemoved(String lineNumber);

    }


}

