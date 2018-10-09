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

    String getParentTypeId();

    String getHasTable();

    String getDescription();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    Boolean getDeleted();

    interface MutableGoodIdentificationTypeState extends GoodIdentificationTypeState {
        void setGoodIdentificationTypeId(String goodIdentificationTypeId);

        void setParentTypeId(String parentTypeId);

        void setHasTable(String hasTable);

        void setDescription(String description);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setDeleted(Boolean deleted);


        void mutate(Event e);

        void when(GoodIdentificationTypeEvent.GoodIdentificationTypeStateCreated e);

        void when(GoodIdentificationTypeEvent.GoodIdentificationTypeStateMergePatched e);

        void when(GoodIdentificationTypeEvent.GoodIdentificationTypeStateDeleted e);
    }

    interface SqlGoodIdentificationTypeState extends MutableGoodIdentificationTypeState {

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

