package org.dddml.wms.domain.product;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.product.GoodIdentificationEvent.*;

public interface GoodIdentificationState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getGoodIdentificationTypeId();

    String getIdValue();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    Boolean getDeleted();

    String getProductId();

    interface MutableGoodIdentificationState extends GoodIdentificationState {
        void setProductGoodIdentificationId(ProductGoodIdentificationId productGoodIdentificationId);

        void setGoodIdentificationTypeId(String goodIdentificationTypeId);

        void setIdValue(String idValue);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setDeleted(Boolean deleted);

        void setProductId(String productId);


        void mutate(Event e);

        void when(GoodIdentificationEvent.GoodIdentificationStateCreated e);

        void when(GoodIdentificationEvent.GoodIdentificationStateMergePatched e);

        void when(GoodIdentificationEvent.GoodIdentificationStateRemoved e);
    }

    interface SqlGoodIdentificationState extends MutableGoodIdentificationState {
        ProductGoodIdentificationId getProductGoodIdentificationId();

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

