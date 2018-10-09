package org.dddml.wms.domain.movement;

import java.util.Set;
import java.util.Date;
import java.math.BigDecimal;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.movement.MovementEvent.*;

public interface MovementState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getDocumentNumber();

    String getDocumentStatusId();

    Date getMovementDate();

    Boolean getPosted();

    Boolean getProcessed();

    String getProcessing();

    Date getDateReceived();

    String getDocumentTypeId();

    Boolean getIsInTransit();

    Boolean getIsApproved();

    BigDecimal getApprovalAmount();

    String getShipperId();

    String getSalesRepresentativeId();

    String getBusinessPartnerId();

    BigDecimal getChargeAmount();

    String getCreateFrom();

    BigDecimal getFreightAmount();

    String getReversalDocumentNumber();

    String getWarehouseIdFrom();

    String getWarehouseIdTo();

    String getDescription();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    Boolean getDeleted();

    EntityStateCollection<String, MovementLineState> getMovementLines();

    interface MutableMovementState extends MovementState {
        void setDocumentNumber(String documentNumber);

        void setDocumentStatusId(String documentStatusId);

        void setMovementDate(Date movementDate);

        void setPosted(Boolean posted);

        void setProcessed(Boolean processed);

        void setProcessing(String processing);

        void setDateReceived(Date dateReceived);

        void setDocumentTypeId(String documentTypeId);

        void setIsInTransit(Boolean isInTransit);

        void setIsApproved(Boolean isApproved);

        void setApprovalAmount(BigDecimal approvalAmount);

        void setShipperId(String shipperId);

        void setSalesRepresentativeId(String salesRepresentativeId);

        void setBusinessPartnerId(String businessPartnerId);

        void setChargeAmount(BigDecimal chargeAmount);

        void setCreateFrom(String createFrom);

        void setFreightAmount(BigDecimal freightAmount);

        void setReversalDocumentNumber(String reversalDocumentNumber);

        void setWarehouseIdFrom(String warehouseIdFrom);

        void setWarehouseIdTo(String warehouseIdTo);

        void setDescription(String description);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setDeleted(Boolean deleted);


        void mutate(Event e);

        void when(MovementEvent.MovementStateCreated e);

        void when(MovementEvent.MovementStateMergePatched e);

        void when(MovementEvent.MovementStateDeleted e);
    }

    interface SqlMovementState extends MutableMovementState {

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

