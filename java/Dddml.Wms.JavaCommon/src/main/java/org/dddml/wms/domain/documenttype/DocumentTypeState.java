package org.dddml.wms.domain.documenttype;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.documenttype.DocumentTypeStateEvent.*;

public interface DocumentTypeState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getDocumentTypeId();

    void setDocumentTypeId(String documentTypeId);

    String getDescription();

    void setDescription(String description);

    String getParentDocumentTypeId();

    void setParentDocumentTypeId(String parentDocumentTypeId);

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

    String getCommandId();

    void setCommandId(String commandId);


    void mutate(Event e);

    void when(DocumentTypeStateEvent.DocumentTypeStateCreated e);

    void when(DocumentTypeStateEvent.DocumentTypeStateMergePatched e);

    void when(DocumentTypeStateEvent.DocumentTypeStateDeleted e);
    
}

