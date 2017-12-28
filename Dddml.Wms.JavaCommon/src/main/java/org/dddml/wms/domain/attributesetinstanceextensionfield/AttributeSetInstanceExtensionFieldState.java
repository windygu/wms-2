package org.dddml.wms.domain.attributesetinstanceextensionfield;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.attributesetinstanceextensionfield.AttributeSetInstanceExtensionFieldStateEvent.*;

public interface AttributeSetInstanceExtensionFieldState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getName();

    void setName(String name);

    String getType();

    void setType(String type);

    Integer getLength();

    void setLength(Integer length);

    String getAlias();

    void setAlias(String alias);

    String getDescription();

    void setDescription(String description);

    String getGroupId();

    void setGroupId(String groupId);

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

    void when(AttributeSetInstanceExtensionFieldStateEvent.AttributeSetInstanceExtensionFieldStateCreated e);

    void when(AttributeSetInstanceExtensionFieldStateEvent.AttributeSetInstanceExtensionFieldStateMergePatched e);

    void when(AttributeSetInstanceExtensionFieldStateEvent.AttributeSetInstanceExtensionFieldStateDeleted e);
    
}

