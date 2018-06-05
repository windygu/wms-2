package org.dddml.wms.domain.product;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface GoodIdentificationCommand extends Command
{
    String getGoodIdentificationTypeId();

    void setGoodIdentificationTypeId(String goodIdentificationTypeId);

    String getProductId();

    void setProductId(String productId);

    interface CreateOrMergePatchGoodIdentification extends GoodIdentificationCommand
    {
        String getIdValue();

        void setIdValue(String idValue);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateGoodIdentification extends CreateOrMergePatchGoodIdentification
    {
    }

    interface MergePatchGoodIdentification extends CreateOrMergePatchGoodIdentification
    {
        Boolean getIsPropertyIdValueRemoved();

        void setIsPropertyIdValueRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

    }

	interface RemoveGoodIdentification extends GoodIdentificationCommand
	{
	}

}

