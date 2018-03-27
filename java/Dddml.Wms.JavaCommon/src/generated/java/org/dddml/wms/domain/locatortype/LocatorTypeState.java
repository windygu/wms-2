package org.dddml.wms.domain.locatortype;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.locatortype.LocatorTypeStateEvent.*;

public interface LocatorTypeState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getLocatorTypeId();

    void setLocatorTypeId(String locatorTypeId);

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


    void mutate(Event e);

    void when(LocatorTypeStateEvent.LocatorTypeStateCreated e);

    void when(LocatorTypeStateEvent.LocatorTypeStateMergePatched e);

    void when(LocatorTypeStateEvent.LocatorTypeStateDeleted e);
    
}

