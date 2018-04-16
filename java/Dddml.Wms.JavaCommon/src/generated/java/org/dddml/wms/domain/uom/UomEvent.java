package org.dddml.wms.domain.uom;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface UomEvent extends Event
{
    UomEventId getUomEventId();

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface UomStateEvent extends UomEvent {
        String getUomTypeId();

        void setUomTypeId(String uomTypeId);

        String getAbbreviation();

        void setAbbreviation(String abbreviation);

        String getDescription();

        void setDescription(String description);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface UomStateCreated extends UomStateEvent
    {
    
    }


    interface UomStateMergePatched extends UomStateEvent
    {
        Boolean getIsPropertyUomTypeIdRemoved();

        void setIsPropertyUomTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyAbbreviationRemoved();

        void setIsPropertyAbbreviationRemoved(Boolean removed);

        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }

    interface UomStateDeleted extends UomStateEvent
    {
    }


}

