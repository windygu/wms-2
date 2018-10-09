package org.dddml.wms.domain.attribute;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.attribute.AttributeEvent.*;

public interface AttributeState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getAttributeId();

    String getAttributeName();

    String getOrganizationId();

    String getDescription();

    Boolean getIsMandatory();

    String getAttributeValueType();

    Integer getAttributeValueLength();

    Boolean getIsList();

    String getFieldName();

    String getReferenceId();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    Boolean getDeleted();

    EntityStateCollection<String, AttributeValueState> getAttributeValues();

    EntityStateCollection<String, AttributeAliasState> getAliases();

    interface MutableAttributeState extends AttributeState {
        void setAttributeId(String attributeId);

        void setAttributeName(String attributeName);

        void setOrganizationId(String organizationId);

        void setDescription(String description);

        void setIsMandatory(Boolean isMandatory);

        void setAttributeValueType(String attributeValueType);

        void setAttributeValueLength(Integer attributeValueLength);

        void setIsList(Boolean isList);

        void setFieldName(String fieldName);

        void setReferenceId(String referenceId);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setDeleted(Boolean deleted);


        void mutate(Event e);

        void when(AttributeEvent.AttributeStateCreated e);

        void when(AttributeEvent.AttributeStateMergePatched e);

        void when(AttributeEvent.AttributeStateDeleted e);
    }

    interface SqlAttributeState extends MutableAttributeState {

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

