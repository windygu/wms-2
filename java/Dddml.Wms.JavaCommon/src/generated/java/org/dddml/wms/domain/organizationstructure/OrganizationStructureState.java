package org.dddml.wms.domain.organizationstructure;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.organizationstructure.OrganizationStructureEvent.*;

public interface OrganizationStructureState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    OrganizationStructureId getId();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    Boolean getDeleted();

    interface MutableOrganizationStructureState extends OrganizationStructureState {
        void setId(OrganizationStructureId id);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setDeleted(Boolean deleted);


        void mutate(Event e);

        void when(OrganizationStructureEvent.OrganizationStructureStateCreated e);

        void when(OrganizationStructureEvent.OrganizationStructureStateMergePatched e);

        void when(OrganizationStructureEvent.OrganizationStructureStateDeleted e);
    }

    interface SqlOrganizationStructureState extends MutableOrganizationStructureState {

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

