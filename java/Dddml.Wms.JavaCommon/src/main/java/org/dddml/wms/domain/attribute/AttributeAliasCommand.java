package org.dddml.wms.domain.attribute;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface AttributeAliasCommand extends Command
{
    String getCode();

    void setCode(String code);

    String getAttributeId();

    void setAttributeId(String attributeId);

    interface CreateOrMergePatchAttributeAlias extends AttributeAliasCommand
    {
        String getName();

        void setName(String name);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateAttributeAlias extends CreateOrMergePatchAttributeAlias
    {
    }

    interface MergePatchAttributeAlias extends CreateOrMergePatchAttributeAlias
    {
        Boolean getIsPropertyNameRemoved();

        void setIsPropertyNameRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

    }

	interface RemoveAttributeAlias extends AttributeAliasCommand
	{
	}

}

