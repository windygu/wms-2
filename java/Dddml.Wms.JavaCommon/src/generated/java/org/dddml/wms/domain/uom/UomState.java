package org.dddml.wms.domain.uom;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.uom.UomEvent.*;

public interface UomState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getUomId();

    String getUomTypeId();

    String getAbbreviation();

    String getDescription();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    Boolean getDeleted();

    interface MutableUomState extends UomState {
        void setUomId(String uomId);

        void setUomTypeId(String uomTypeId);

        void setAbbreviation(String abbreviation);

        void setDescription(String description);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setDeleted(Boolean deleted);


        void mutate(Event e);

        void when(UomEvent.UomStateCreated e);

        void when(UomEvent.UomStateMergePatched e);

        void when(UomEvent.UomStateDeleted e);
    }

    interface SqlUomState extends MutableUomState {

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

