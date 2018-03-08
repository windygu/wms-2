package org.dddml.wms.domain.uom;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface UomStateEvent extends Event
{
    UomEventId getUomEventId();

    boolean getStateEventReadOnly();

    void setStateEventReadOnly(boolean readOnly);

    String getUomTypeId();

    void setUomTypeId(String uomTypeId);

    String getAbbreviation();

    void setAbbreviation(String abbreviation);

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

