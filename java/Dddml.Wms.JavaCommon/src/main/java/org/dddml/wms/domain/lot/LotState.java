package org.dddml.wms.domain.lot;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.lot.LotStateEvent.*;

public interface LotState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getLotId();

    void setLotId(String lotId);

    java.sql.Timestamp getCreationDate();

    void setCreationDate(java.sql.Timestamp creationDate);

    java.math.BigDecimal getQuantity();

    void setQuantity(java.math.BigDecimal quantity);

    java.sql.Timestamp getExpirationDate();

    void setExpirationDate(java.sql.Timestamp expirationDate);

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


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(LotStateEvent.LotStateCreated e);

    void when(LotStateEvent.LotStateMergePatched e);

    void when(LotStateEvent.LotStateDeleted e);
    
}

