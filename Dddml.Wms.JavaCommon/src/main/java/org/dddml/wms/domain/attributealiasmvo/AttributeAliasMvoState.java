package org.dddml.wms.domain.attributealiasmvo;

import java.util.Set;
import org.dddml.wms.domain.attribute.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.attributealiasmvo.AttributeAliasMvoStateEvent.*;

public interface AttributeAliasMvoState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    AttributeAliasId getAttributeAliasId();

    void setAttributeAliasId(AttributeAliasId attributeAliasId);

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

    String getAttributeAttributeName();

    void setAttributeAttributeName(String attributeAttributeName);

    String getAttributeOrganizationId();

    void setAttributeOrganizationId(String attributeOrganizationId);

    String getAttributeDescription();

    void setAttributeDescription(String attributeDescription);

    Boolean getAttributeIsMandatory();

    void setAttributeIsMandatory(Boolean attributeIsMandatory);

    Boolean getAttributeIsInstanceAttribute();

    void setAttributeIsInstanceAttribute(Boolean attributeIsInstanceAttribute);

    String getAttributeAttributeValueType();

    void setAttributeAttributeValueType(String attributeAttributeValueType);

    Integer getAttributeAttributeValueLength();

    void setAttributeAttributeValueLength(Integer attributeAttributeValueLength);

    Boolean getAttributeIsList();

    void setAttributeIsList(Boolean attributeIsList);

    String getAttributeFieldName();

    void setAttributeFieldName(String attributeFieldName);

    String getAttributeReferenceId();

    void setAttributeReferenceId(String attributeReferenceId);

    Long getAttributeVersion();

    void setAttributeVersion(Long attributeVersion);

    String getAttributeCreatedBy();

    void setAttributeCreatedBy(String attributeCreatedBy);

    Date getAttributeCreatedAt();

    void setAttributeCreatedAt(Date attributeCreatedAt);

    String getAttributeUpdatedBy();

    void setAttributeUpdatedBy(String attributeUpdatedBy);

    Date getAttributeUpdatedAt();

    void setAttributeUpdatedAt(Date attributeUpdatedAt);

    Boolean getAttributeActive();

    void setAttributeActive(Boolean attributeActive);

    Boolean getAttributeDeleted();

    void setAttributeDeleted(Boolean attributeDeleted);


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(AttributeAliasMvoStateEvent.AttributeAliasMvoStateCreated e);

    void when(AttributeAliasMvoStateEvent.AttributeAliasMvoStateMergePatched e);

    void when(AttributeAliasMvoStateEvent.AttributeAliasMvoStateDeleted e);
    
}

