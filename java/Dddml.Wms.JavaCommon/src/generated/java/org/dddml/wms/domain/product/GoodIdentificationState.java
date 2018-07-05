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

    ProductGoodIdentificationId getProductGoodIdentificationId();

    void setProductGoodIdentificationId(ProductGoodIdentificationId productGoodIdentificationId);

    String getGoodIdentificationTypeId();

    void setGoodIdentificationTypeId(String goodIdentificationTypeId);

    String getIdValue();

    void setIdValue(String idValue);

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

    String getProductId();

    void setProductId(String productId);


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(GoodIdentificationEvent.GoodIdentificationStateCreated e);

    void when(GoodIdentificationEvent.GoodIdentificationStateMergePatched e);

    void when(GoodIdentificationEvent.GoodIdentificationStateRemoved e);
    
}

