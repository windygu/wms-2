package org.dddml.wms.domain.attribute;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface AttributeValueCommand extends Command
{
    String getValue();

    void setValue(String value);

    String getAttributeId();

    void setAttributeId(String attributeId);

    interface CreateOrMergePatchAttributeValue extends AttributeValueCommand
    {
        String getAttributeValueName();

        void setAttributeValueName(String attributeValueName);

        String getDescription();

        void setDescription(String description);

        String getReferenceId();

        void setReferenceId(String referenceId);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateAttributeValue extends CreateOrMergePatchAttributeValue
    {
    }

    interface MergePatchAttributeValue extends CreateOrMergePatchAttributeValue
    {
        Boolean getIsPropertyAttributeValueNameRemoved();

        void setIsPropertyAttributeValueNameRemoved(Boolean removed);

        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyReferenceIdRemoved();

        void setIsPropertyReferenceIdRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

    }

	interface RemoveAttributeValue extends AttributeValueCommand
	{
	}

}

