package org.dddml.wms.domain.uomtype;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface UomTypeState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getUomTypeId();

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

    String getCommandId();

    interface MutableUomTypeState extends UomTypeState {
        void setUomTypeId(String uomTypeId);

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

        void setCommandId(String commandId);

    }

    interface SqlUomTypeState extends MutableUomTypeState {

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

