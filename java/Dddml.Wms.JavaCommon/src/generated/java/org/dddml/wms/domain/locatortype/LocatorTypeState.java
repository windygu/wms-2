package org.dddml.wms.domain.locatortype;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.locatortype.LocatorTypeEvent.*;

public interface LocatorTypeState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getLocatorTypeId();

    String getDescription();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    Boolean getDeleted();

    interface MutableLocatorTypeState extends LocatorTypeState {
        void setLocatorTypeId(String locatorTypeId);

        void setDescription(String description);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setDeleted(Boolean deleted);


        void mutate(Event e);

        void when(LocatorTypeEvent.LocatorTypeStateCreated e);

        void when(LocatorTypeEvent.LocatorTypeStateMergePatched e);

        void when(LocatorTypeEvent.LocatorTypeStateDeleted e);
    }

    interface SqlLocatorTypeState extends MutableLocatorTypeState {

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

