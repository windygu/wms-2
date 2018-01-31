package org.dddml.wms.domain.attributeusemvo;

import java.util.Set;
import org.dddml.wms.domain.attributeset.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.attributeusemvo.AttributeUseMvoStateEvent.*;

public interface AttributeUseMvoState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    AttributeSetAttributeUseId getAttributeSetAttributeUseId();

    void setAttributeSetAttributeUseId(AttributeSetAttributeUseId attributeSetAttributeUseId);

    Integer getSequenceNumber();

    void setSequenceNumber(Integer sequenceNumber);

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

    String getAttributeSetAttributeSetName();

    void setAttributeSetAttributeSetName(String attributeSetAttributeSetName);

    String getAttributeSetOrganizationId();

    void setAttributeSetOrganizationId(String attributeSetOrganizationId);

    String getAttributeSetDescription();

    void setAttributeSetDescription(String attributeSetDescription);

    String getAttributeSetReferenceId();

    void setAttributeSetReferenceId(String attributeSetReferenceId);

    Boolean getAttributeSetIsInstanceAttributeSet();

    void setAttributeSetIsInstanceAttributeSet(Boolean attributeSetIsInstanceAttributeSet);

    Boolean getAttributeSetIsMandatory();

    void setAttributeSetIsMandatory(Boolean attributeSetIsMandatory);

    Long getAttributeSetVersion();

    void setAttributeSetVersion(Long attributeSetVersion);

    String getAttributeSetCreatedBy();

    void setAttributeSetCreatedBy(String attributeSetCreatedBy);

    Date getAttributeSetCreatedAt();

    void setAttributeSetCreatedAt(Date attributeSetCreatedAt);

    String getAttributeSetUpdatedBy();

    void setAttributeSetUpdatedBy(String attributeSetUpdatedBy);

    Date getAttributeSetUpdatedAt();

    void setAttributeSetUpdatedAt(Date attributeSetUpdatedAt);

    Boolean getAttributeSetActive();

    void setAttributeSetActive(Boolean attributeSetActive);

    Boolean getAttributeSetDeleted();

    void setAttributeSetDeleted(Boolean attributeSetDeleted);


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(AttributeUseMvoStateEvent.AttributeUseMvoStateCreated e);

    void when(AttributeUseMvoStateEvent.AttributeUseMvoStateMergePatched e);

    void when(AttributeUseMvoStateEvent.AttributeUseMvoStateDeleted e);
    
}

