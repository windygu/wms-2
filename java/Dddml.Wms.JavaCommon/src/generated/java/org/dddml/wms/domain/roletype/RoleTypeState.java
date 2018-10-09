package org.dddml.wms.domain.roletype;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.roletype.RoleTypeEvent.*;

public interface RoleTypeState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getRoleTypeId();

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

    interface MutableRoleTypeState extends RoleTypeState {
        void setRoleTypeId(String roleTypeId);

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

        void when(RoleTypeEvent.RoleTypeStateCreated e);

        void when(RoleTypeEvent.RoleTypeStateMergePatched e);

        void when(RoleTypeEvent.RoleTypeStateDeleted e);
    }

    interface SqlRoleTypeState extends MutableRoleTypeState {

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

