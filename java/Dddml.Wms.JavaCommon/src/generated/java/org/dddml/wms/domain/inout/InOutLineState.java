package org.dddml.wms.domain.inout;

import java.util.Set;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.inout.InOutLineEvent.*;

public interface InOutLineState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getLineNumber();

    String getLocatorId();

    String getProductId();

    String getAttributeSetInstanceId();

    String getDescription();

    String getQuantityUomId();

    BigDecimal getMovementQuantity();

    BigDecimal getPickedQuantity();

    Boolean getIsInvoiced();

    Boolean getProcessed();

    String getRmaLineNumber();

    String getReversalLineNumber();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    Boolean getDeleted();

    String getInOutDocumentNumber();

    Set<String> getDamageStatusIds();

    void setDamageStatusIds(Set<String> damageStatusIds);

    EntityStateCollection<String, InOutLineImageState> getInOutLineImages();

    interface MutableInOutLineState extends InOutLineState {
        void setInOutLineId(InOutLineId inOutLineId);

        void setLineNumber(String lineNumber);

        void setLocatorId(String locatorId);

        void setProductId(String productId);

        void setAttributeSetInstanceId(String attributeSetInstanceId);

        void setDescription(String description);

        void setQuantityUomId(String quantityUomId);

        void setMovementQuantity(BigDecimal movementQuantity);

        void setPickedQuantity(BigDecimal pickedQuantity);

        void setIsInvoiced(Boolean isInvoiced);

        void setProcessed(Boolean processed);

        void setRmaLineNumber(String rmaLineNumber);

        void setReversalLineNumber(String reversalLineNumber);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setDeleted(Boolean deleted);

        void setInOutDocumentNumber(String inOutDocumentNumber);

        void setDamageStatusIds(Set<String> damageStatusIds);


        void mutate(Event e);

        void when(InOutLineEvent.InOutLineStateCreated e);

        void when(InOutLineEvent.InOutLineStateMergePatched e);

        void when(InOutLineEvent.InOutLineStateRemoved e);
    }

    interface SqlInOutLineState extends MutableInOutLineState {
        InOutLineId getInOutLineId();

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

