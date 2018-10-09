package org.dddml.wms.domain.lot;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.lot.LotEvent.*;

public interface LotState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getLotId();

    java.math.BigDecimal getQuantity();

    java.sql.Timestamp getExpirationDate();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    Boolean getDeleted();

    interface MutableLotState extends LotState {
        void setLotId(String lotId);

        void setQuantity(java.math.BigDecimal quantity);

        void setExpirationDate(java.sql.Timestamp expirationDate);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setDeleted(Boolean deleted);


        void mutate(Event e);

        void when(LotEvent.LotStateCreated e);

        void when(LotEvent.LotStateMergePatched e);

        void when(LotEvent.LotStateDeleted e);
    }

    interface SqlLotState extends MutableLotState {

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

