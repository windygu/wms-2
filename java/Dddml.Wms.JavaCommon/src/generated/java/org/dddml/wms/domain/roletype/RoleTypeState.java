package org.dddml.wms.domain.roletype;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.roletype.RoleTypeStateEvent.*;

public interface RoleTypeState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getRoleTypeId();

    void setRoleTypeId(String roleTypeId);

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

    void when(RoleTypeStateEvent.RoleTypeStateCreated e);

    void when(RoleTypeStateEvent.RoleTypeStateMergePatched e);

    void when(RoleTypeStateEvent.RoleTypeStateDeleted e);
    
}

