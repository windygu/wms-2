package org.dddml.wms.domain.movementlinemvo;

import java.util.Set;
import org.dddml.wms.domain.movement.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.movementlinemvo.MovementLineMvoEvent.*;

public interface MovementLineMvoState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    MovementLineId getMovementLineId();

    void setMovementLineId(MovementLineId movementLineId);

    BigDecimal getMovementQuantity();

    void setMovementQuantity(BigDecimal movementQuantity);

    String getProductId();

    void setProductId(String productId);

    String getLocatorIdFrom();

    void setLocatorIdFrom(String locatorIdFrom);

    String getLocatorIdTo();

    void setLocatorIdTo(String locatorIdTo);

    String getAttributeSetInstanceId();

    void setAttributeSetInstanceId(String attributeSetInstanceId);

    Boolean getProcessed();

    void setProcessed(Boolean processed);

    String getReversalLineNumber();

    void setReversalLineNumber(String reversalLineNumber);

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

    String getMovementDocumentStatusId();

    void setMovementDocumentStatusId(String movementDocumentStatusId);

    Date getMovementMovementDate();

    void setMovementMovementDate(Date movementMovementDate);

    Boolean getMovementPosted();

    void setMovementPosted(Boolean movementPosted);

    Boolean getMovementProcessed();

    void setMovementProcessed(Boolean movementProcessed);

    String getMovementProcessing();

    void setMovementProcessing(String movementProcessing);

    Date getMovementDateReceived();

    void setMovementDateReceived(Date movementDateReceived);

    String getMovementDocumentTypeId();

    void setMovementDocumentTypeId(String movementDocumentTypeId);

    Boolean getMovementIsInTransit();

    void setMovementIsInTransit(Boolean movementIsInTransit);

    Boolean getMovementIsApproved();

    void setMovementIsApproved(Boolean movementIsApproved);

    BigDecimal getMovementApprovalAmount();

    void setMovementApprovalAmount(BigDecimal movementApprovalAmount);

    String getMovementShipperId();

    void setMovementShipperId(String movementShipperId);

    String getMovementSalesRepresentativeId();

    void setMovementSalesRepresentativeId(String movementSalesRepresentativeId);

    String getMovementBusinessPartnerId();

    void setMovementBusinessPartnerId(String movementBusinessPartnerId);

    BigDecimal getMovementChargeAmount();

    void setMovementChargeAmount(BigDecimal movementChargeAmount);

    String getMovementCreateFrom();

    void setMovementCreateFrom(String movementCreateFrom);

    BigDecimal getMovementFreightAmount();

    void setMovementFreightAmount(BigDecimal movementFreightAmount);

    String getMovementReversalDocumentNumber();

    void setMovementReversalDocumentNumber(String movementReversalDocumentNumber);

    String getMovementWarehouseIdFrom();

    void setMovementWarehouseIdFrom(String movementWarehouseIdFrom);

    String getMovementWarehouseIdTo();

    void setMovementWarehouseIdTo(String movementWarehouseIdTo);

    String getMovementDescription();

    void setMovementDescription(String movementDescription);

    Long getMovementVersion();

    void setMovementVersion(Long movementVersion);

    String getMovementCreatedBy();

    void setMovementCreatedBy(String movementCreatedBy);

    Date getMovementCreatedAt();

    void setMovementCreatedAt(Date movementCreatedAt);

    String getMovementUpdatedBy();

    void setMovementUpdatedBy(String movementUpdatedBy);

    Date getMovementUpdatedAt();

    void setMovementUpdatedAt(Date movementUpdatedAt);

    Boolean getMovementActive();

    void setMovementActive(Boolean movementActive);

    Boolean getMovementDeleted();

    void setMovementDeleted(Boolean movementDeleted);


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(MovementLineMvoEvent.MovementLineMvoStateCreated e);

    void when(MovementLineMvoEvent.MovementLineMvoStateMergePatched e);

    void when(MovementLineMvoEvent.MovementLineMvoStateDeleted e);
    
}

