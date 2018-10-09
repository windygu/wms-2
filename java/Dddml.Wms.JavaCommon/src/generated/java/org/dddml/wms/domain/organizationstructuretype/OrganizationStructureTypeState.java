package org.dddml.wms.domain.organizationstructuretype;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.organizationstructuretype.OrganizationStructureTypeEvent.*;

public interface OrganizationStructureTypeState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getId();

    String getDescription();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    Boolean getDeleted();

    interface MutableOrganizationStructureTypeState extends OrganizationStructureTypeState {
        void setId(String id);

        void setDescription(String description);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setDeleted(Boolean deleted);


        void mutate(Event e);

        void when(OrganizationStructureTypeEvent.OrganizationStructureTypeStateCreated e);

        void when(OrganizationStructureTypeEvent.OrganizationStructureTypeStateMergePatched e);

        void when(OrganizationStructureTypeEvent.OrganizationStructureTypeStateDeleted e);
    }

    interface SqlOrganizationStructureTypeState extends MutableOrganizationStructureTypeState {

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

