package org.dddml.wms.domain.attributesetinstanceextensionfieldgroup;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.attributesetinstanceextensionfieldgroup.AttributeSetInstanceExtensionFieldGroupEvent.*;

public interface AttributeSetInstanceExtensionFieldGroupState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getId();

    void setId(String id);

    String getFieldType();

    void setFieldType(String fieldType);

    Integer getFieldLength();

    void setFieldLength(Integer fieldLength);

    Integer getFieldCount();

    void setFieldCount(Integer fieldCount);

    String getNameFormat();

    void setNameFormat(String nameFormat);

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

    void when(AttributeSetInstanceExtensionFieldGroupEvent.AttributeSetInstanceExtensionFieldGroupStateCreated e);

    void when(AttributeSetInstanceExtensionFieldGroupEvent.AttributeSetInstanceExtensionFieldGroupStateMergePatched e);

    void when(AttributeSetInstanceExtensionFieldGroupEvent.AttributeSetInstanceExtensionFieldGroupStateDeleted e);
    
}

