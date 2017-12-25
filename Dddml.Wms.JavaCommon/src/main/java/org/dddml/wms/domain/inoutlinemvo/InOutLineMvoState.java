package org.dddml.wms.domain.inoutlinemvo;

import java.util.Set;
import org.dddml.wms.domain.inout.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.inoutlinemvo.InOutLineMvoStateEvent.*;

public interface InOutLineMvoState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    InOutLineId getInOutLineId();

    void setInOutLineId(InOutLineId inOutLineId);

    String getLocatorId();

    void setLocatorId(String locatorId);

    String getProductId();

    void setProductId(String productId);

    String getAttributeSetInstanceId();

    void setAttributeSetInstanceId(String attributeSetInstanceId);

    String getDescription();

    void setDescription(String description);

    String getUomId();

    void setUomId(String uomId);

    BigDecimal getMovementQuantity();

    void setMovementQuantity(BigDecimal movementQuantity);

    BigDecimal getPickedQuantity();

    void setPickedQuantity(BigDecimal pickedQuantity);

    Boolean getIsInvoiced();

    void setIsInvoiced(Boolean isInvoiced);

    Boolean getProcessed();

    void setProcessed(Boolean processed);

    Long getRmaLineNumber();

    void setRmaLineNumber(Long rmaLineNumber);

    Long getReversalLineNumber();

    void setReversalLineNumber(Long reversalLineNumber);

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

    String getInOutDocumentStatusId();

    void setInOutDocumentStatusId(String inOutDocumentStatusId);

    Boolean getInOutPosted();

    void setInOutPosted(Boolean inOutPosted);

    Boolean getInOutProcessed();

    void setInOutProcessed(Boolean inOutProcessed);

    String getInOutProcessing();

    void setInOutProcessing(String inOutProcessing);

    String getInOutDocumentTypeId();

    void setInOutDocumentTypeId(String inOutDocumentTypeId);

    String getInOutDescription();

    void setInOutDescription(String inOutDescription);

    String getInOutOrderId();

    void setInOutOrderId(String inOutOrderId);

    Date getInOutDateOrdered();

    void setInOutDateOrdered(Date inOutDateOrdered);

    Boolean getInOutIsPrinted();

    void setInOutIsPrinted(Boolean inOutIsPrinted);

    String getInOutMovementTypeId();

    void setInOutMovementTypeId(String inOutMovementTypeId);

    Date getInOutMovementDate();

    void setInOutMovementDate(Date inOutMovementDate);

    String getInOutBusinessPartnerId();

    void setInOutBusinessPartnerId(String inOutBusinessPartnerId);

    String getInOutWarehouseId();

    void setInOutWarehouseId(String inOutWarehouseId);

    String getInOutPOReference();

    void setInOutPOReference(String inOutPOReference);

    BigDecimal getInOutFreightAmount();

    void setInOutFreightAmount(BigDecimal inOutFreightAmount);

    String getInOutShipperId();

    void setInOutShipperId(String inOutShipperId);

    BigDecimal getInOutChargeAmount();

    void setInOutChargeAmount(BigDecimal inOutChargeAmount);

    Date getInOutDatePrinted();

    void setInOutDatePrinted(Date inOutDatePrinted);

    String getInOutCreatedFrom();

    void setInOutCreatedFrom(String inOutCreatedFrom);

    String getInOutSalesRepresentativeId();

    void setInOutSalesRepresentativeId(String inOutSalesRepresentativeId);

    Integer getInOutNumberOfPackages();

    void setInOutNumberOfPackages(Integer inOutNumberOfPackages);

    Date getInOutPickDate();

    void setInOutPickDate(Date inOutPickDate);

    Date getInOutShipDate();

    void setInOutShipDate(Date inOutShipDate);

    String getInOutTrackingNumber();

    void setInOutTrackingNumber(String inOutTrackingNumber);

    Date getInOutDateReceived();

    void setInOutDateReceived(Date inOutDateReceived);

    Boolean getInOutIsInTransit();

    void setInOutIsInTransit(Boolean inOutIsInTransit);

    Boolean getInOutIsApproved();

    void setInOutIsApproved(Boolean inOutIsApproved);

    Boolean getInOutIsInDispute();

    void setInOutIsInDispute(Boolean inOutIsInDispute);

    String getInOutRmaDocumentNumber();

    void setInOutRmaDocumentNumber(String inOutRmaDocumentNumber);

    String getInOutReversalDocumentNumber();

    void setInOutReversalDocumentNumber(String inOutReversalDocumentNumber);

    Long getInOutVersion();

    void setInOutVersion(Long inOutVersion);

    String getInOutCreatedBy();

    void setInOutCreatedBy(String inOutCreatedBy);

    Date getInOutCreatedAt();

    void setInOutCreatedAt(Date inOutCreatedAt);

    String getInOutUpdatedBy();

    void setInOutUpdatedBy(String inOutUpdatedBy);

    Date getInOutUpdatedAt();

    void setInOutUpdatedAt(Date inOutUpdatedAt);

    Boolean getInOutActive();

    void setInOutActive(Boolean inOutActive);

    Boolean getInOutDeleted();

    void setInOutDeleted(Boolean inOutDeleted);


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(InOutLineMvoStateEvent.InOutLineMvoStateCreated e);

    void when(InOutLineMvoStateEvent.InOutLineMvoStateMergePatched e);

    void when(InOutLineMvoStateEvent.InOutLineMvoStateDeleted e);
    
}

