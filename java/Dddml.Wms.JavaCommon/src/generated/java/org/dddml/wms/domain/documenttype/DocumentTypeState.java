package org.dddml.wms.domain.documenttype;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface DocumentTypeState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getDocumentTypeId();

    String getDescription();

    String getParentDocumentTypeId();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    Boolean getDeleted();

    String getCommandId();

    interface MutableDocumentTypeState extends DocumentTypeState {
        void setDocumentTypeId(String documentTypeId);

        void setDescription(String description);

        void setParentDocumentTypeId(String parentDocumentTypeId);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setDeleted(Boolean deleted);

        void setCommandId(String commandId);

    }

    interface SqlDocumentTypeState extends MutableDocumentTypeState {

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

