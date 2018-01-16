package org.dddml.wms.domain.attribute;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.attribute.AttributeAliasStateEvent.*;

public interface AttributeAliasState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    AttributeAliasId getAttributeAliasId();

    void setAttributeAliasId(AttributeAliasId attributeAliasId);

    String getCode();

    void setCode(String code);

    String getName();

    void setName(String name);

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

    String getAttributeId();

    void setAttributeId(String attributeId);


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(AttributeAliasStateEvent.AttributeAliasStateCreated e);

    void when(AttributeAliasStateEvent.AttributeAliasStateMergePatched e);

    void when(AttributeAliasStateEvent.AttributeAliasStateRemoved e);
    
}

