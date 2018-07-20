package org.dddml.wms.domain.attributevaluemvo;

import java.util.*;
import org.dddml.wms.domain.attribute.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface AttributeValueMvoCommand extends Command
{
    AttributeValueId getAttributeValueId();

    void setAttributeValueId(AttributeValueId attributeValueId);

    Long getAttributeVersion();

    void setAttributeVersion(Long attributeVersion);

    static void throwOnInvalidStateTransition(AttributeValueMvoState state, Command c) {
        if (state.getAttributeVersion() == null)
        {
            if (isCommandCreate((AttributeValueMvoCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (state.getDeleted() != null && state.getDeleted())
        {
            throw DomainError.named("zombie", "Can't do anything to deleted aggregate.");
        }
        if (isCommandCreate((AttributeValueMvoCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(AttributeValueMvoCommand c) {
        return ((c instanceof AttributeValueMvoCommand.CreateAttributeValueMvo) 
            && c.getAttributeVersion().equals(AttributeValueMvoState.VERSION_NULL));
    }

    interface CreateOrMergePatchAttributeValueMvo extends AttributeValueMvoCommand
    {
        String getAttributeValueName();

        void setAttributeValueName(String attributeValueName);

        String getDescription();

        void setDescription(String description);

        String getReferenceId();

        void setReferenceId(String referenceId);

        Long getVersion();

        void setVersion(Long version);

        Boolean getActive();

        void setActive(Boolean active);

        String getAttributeAttributeName();

        void setAttributeAttributeName(String attributeAttributeName);

        String getAttributeOrganizationId();

        void setAttributeOrganizationId(String attributeOrganizationId);

        String getAttributeDescription();

        void setAttributeDescription(String attributeDescription);

        Boolean getAttributeIsMandatory();

        void setAttributeIsMandatory(Boolean attributeIsMandatory);

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

    }

    interface CreateAttributeValueMvo extends CreateOrMergePatchAttributeValueMvo
    {
    }

    interface MergePatchAttributeValueMvo extends CreateOrMergePatchAttributeValueMvo
    {
        Boolean getIsPropertyAttributeValueNameRemoved();

        void setIsPropertyAttributeValueNameRemoved(Boolean removed);

        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyReferenceIdRemoved();

        void setIsPropertyReferenceIdRemoved(Boolean removed);

        Boolean getIsPropertyVersionRemoved();

        void setIsPropertyVersionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        Boolean getIsPropertyAttributeAttributeNameRemoved();

        void setIsPropertyAttributeAttributeNameRemoved(Boolean removed);

        Boolean getIsPropertyAttributeOrganizationIdRemoved();

        void setIsPropertyAttributeOrganizationIdRemoved(Boolean removed);

        Boolean getIsPropertyAttributeDescriptionRemoved();

        void setIsPropertyAttributeDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyAttributeIsMandatoryRemoved();

        void setIsPropertyAttributeIsMandatoryRemoved(Boolean removed);

        Boolean getIsPropertyAttributeAttributeValueTypeRemoved();

        void setIsPropertyAttributeAttributeValueTypeRemoved(Boolean removed);

        Boolean getIsPropertyAttributeAttributeValueLengthRemoved();

        void setIsPropertyAttributeAttributeValueLengthRemoved(Boolean removed);

        Boolean getIsPropertyAttributeIsListRemoved();

        void setIsPropertyAttributeIsListRemoved(Boolean removed);

        Boolean getIsPropertyAttributeFieldNameRemoved();

        void setIsPropertyAttributeFieldNameRemoved(Boolean removed);

        Boolean getIsPropertyAttributeReferenceIdRemoved();

        void setIsPropertyAttributeReferenceIdRemoved(Boolean removed);

        Boolean getIsPropertyAttributeCreatedByRemoved();

        void setIsPropertyAttributeCreatedByRemoved(Boolean removed);

        Boolean getIsPropertyAttributeCreatedAtRemoved();

        void setIsPropertyAttributeCreatedAtRemoved(Boolean removed);

        Boolean getIsPropertyAttributeUpdatedByRemoved();

        void setIsPropertyAttributeUpdatedByRemoved(Boolean removed);

        Boolean getIsPropertyAttributeUpdatedAtRemoved();

        void setIsPropertyAttributeUpdatedAtRemoved(Boolean removed);

        Boolean getIsPropertyAttributeActiveRemoved();

        void setIsPropertyAttributeActiveRemoved(Boolean removed);

        Boolean getIsPropertyAttributeDeletedRemoved();

        void setIsPropertyAttributeDeletedRemoved(Boolean removed);

    }

	interface DeleteAttributeValueMvo extends AttributeValueMvoCommand
	{
	}

}

