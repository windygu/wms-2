package org.dddml.wms.domain.goodidentificationtype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface GoodIdentificationTypeEvent extends Event {

    interface SqlGoodIdentificationTypeEvent extends GoodIdentificationTypeEvent {
        GoodIdentificationTypeEventId getGoodIdentificationTypeEventId();
    }

    String getGoodIdentificationTypeId();

    //void setGoodIdentificationTypeId(String goodIdentificationTypeId);

    Long getVersion();
    
    //void getVersion(Long version);

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface GoodIdentificationTypeStateEvent extends GoodIdentificationTypeEvent {
        String getParentTypeId();

        void setParentTypeId(String parentTypeId);

        String getHasTable();

        void setHasTable(String hasTable);

        String getDescription();

        void setDescription(String description);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface GoodIdentificationTypeStateCreated extends GoodIdentificationTypeStateEvent
    {
    
    }


    interface GoodIdentificationTypeStateMergePatched extends GoodIdentificationTypeStateEvent
    {
        Boolean getIsPropertyParentTypeIdRemoved();

        void setIsPropertyParentTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyHasTableRemoved();

        void setIsPropertyHasTableRemoved(Boolean removed);

        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }

    interface GoodIdentificationTypeStateDeleted extends GoodIdentificationTypeStateEvent
    {
    }


}

