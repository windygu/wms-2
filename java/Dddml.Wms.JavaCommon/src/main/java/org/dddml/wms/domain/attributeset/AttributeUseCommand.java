package org.dddml.wms.domain.attributeset;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface AttributeUseCommand extends Command
{
    String getAttributeId();

    void setAttributeId(String attributeId);

    String getAttributeSetId();

    void setAttributeSetId(String attributeSetId);

    interface CreateOrMergePatchAttributeUse extends AttributeUseCommand
    {
        Integer getSequenceNumber();

        void setSequenceNumber(Integer sequenceNumber);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateAttributeUse extends CreateOrMergePatchAttributeUse
    {
    }

    interface MergePatchAttributeUse extends CreateOrMergePatchAttributeUse
    {
        Boolean getIsPropertySequenceNumberRemoved();

        void setIsPropertySequenceNumberRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

    }

	interface RemoveAttributeUse extends AttributeUseCommand
	{
	}

}

