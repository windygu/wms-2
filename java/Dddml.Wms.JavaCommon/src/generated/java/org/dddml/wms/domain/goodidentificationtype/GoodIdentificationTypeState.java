package org.dddml.wms.domain.goodidentificationtype;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.goodidentificationtype.GoodIdentificationTypeEvent.*;

public interface GoodIdentificationTypeState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getGoodIdentificationTypeId();

    void setGoodIdentificationTypeId(String goodIdentificationTypeId);

    String getParentTypeId();

    void setParentTypeId(String parentTypeId);

    String getHasTable();

    void setHasTable(String hasTable);

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

    void when(GoodIdentificationTypeEvent.GoodIdentificationTypeStateCreated e);

    void when(GoodIdentificationTypeEvent.GoodIdentificationTypeStateMergePatched e);

    void when(GoodIdentificationTypeEvent.GoodIdentificationTypeStateDeleted e);
    
}

