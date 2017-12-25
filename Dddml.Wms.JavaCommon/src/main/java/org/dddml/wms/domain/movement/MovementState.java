package org.dddml.wms.domain.movement;

import java.util.Set;
import java.util.Date;
import java.math.BigDecimal;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.movement.MovementStateEvent.*;

public interface MovementState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getDocumentNumber();

    void setDocumentNumber(String documentNumber);

    String getDocumentStatusId();

    void setDocumentStatusId(String documentStatusId);

    Date getMovementDate();

    void setMovementDate(Date movementDate);

    Boolean getPosted();

    void setPosted(Boolean posted);

    Boolean getProcessed();

    void setProcessed(Boolean processed);

    String getProcessing();

    void setProcessing(String processing);

    Date getDateReceived();

    void setDateReceived(Date dateReceived);

    String getDocumentTypeId();

    void setDocumentTypeId(String documentTypeId);

    Boolean getIsInTransit();

    void setIsInTransit(Boolean isInTransit);

    Boolean getIsApproved();

    void setIsApproved(Boolean isApproved);

    BigDecimal getApprovalAmount();

    void setApprovalAmount(BigDecimal approvalAmount);

    String getShipperId();

    void setShipperId(String shipperId);

    String getSalesRepresentativeId();

    void setSalesRepresentativeId(String salesRepresentativeId);

    String getBusinessPartnerId();

    void setBusinessPartnerId(String businessPartnerId);

    BigDecimal getChargeAmount();

    void setChargeAmount(BigDecimal chargeAmount);

    String getCreateFrom();

    void setCreateFrom(String createFrom);

    BigDecimal getFreightAmount();

    void setFreightAmount(BigDecimal freightAmount);

    String getReversalDocumentNumber();

    void setReversalDocumentNumber(String reversalDocumentNumber);

    String getWarehouseIdFrom();

    void setWarehouseIdFrom(String warehouseIdFrom);

    String getWarehouseIdTo();

    void setWarehouseIdTo(String warehouseIdTo);

    String getDescription();

    void setDescription(String description);

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

    MovementLineStates getMovementLines();


    void mutate(Event e);

    void when(MovementStateEvent.MovementStateCreated e);

    void when(MovementStateEvent.MovementStateMergePatched e);

    void when(MovementStateEvent.MovementStateDeleted e);
    
}

