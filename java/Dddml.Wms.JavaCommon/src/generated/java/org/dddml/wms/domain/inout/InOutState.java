package org.dddml.wms.domain.inout;

import java.util.Set;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.inout.InOutEvent.*;

public interface InOutState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getDocumentNumber();

    void setDocumentNumber(String documentNumber);

    String getDocumentStatusId();

    void setDocumentStatusId(String documentStatusId);

    Boolean getPosted();

    void setPosted(Boolean posted);

    Boolean getProcessed();

    void setProcessed(Boolean processed);

    String getProcessing();

    void setProcessing(String processing);

    String getDocumentTypeId();

    void setDocumentTypeId(String documentTypeId);

    String getDescription();

    void setDescription(String description);

    String getOrderId();

    void setOrderId(String orderId);

    Date getDateOrdered();

    void setDateOrdered(Date dateOrdered);

    Boolean getIsPrinted();

    void setIsPrinted(Boolean isPrinted);

    String getMovementTypeId();

    void setMovementTypeId(String movementTypeId);

    Date getMovementDate();

    void setMovementDate(Date movementDate);

    String getBusinessPartnerId();

    void setBusinessPartnerId(String businessPartnerId);

    String getWarehouseId();

    void setWarehouseId(String warehouseId);

    String getPOReference();

    void setPOReference(String poReference);

    BigDecimal getFreightAmount();

    void setFreightAmount(BigDecimal freightAmount);

    String getShipperId();

    void setShipperId(String shipperId);

    BigDecimal getChargeAmount();

    void setChargeAmount(BigDecimal chargeAmount);

    Date getDatePrinted();

    void setDatePrinted(Date datePrinted);

    String getCreatedFrom();

    void setCreatedFrom(String createdFrom);

    String getSalesRepresentativeId();

    void setSalesRepresentativeId(String salesRepresentativeId);

    Integer getNumberOfPackages();

    void setNumberOfPackages(Integer numberOfPackages);

    Date getPickDate();

    void setPickDate(Date pickDate);

    Date getShipDate();

    void setShipDate(Date shipDate);

    String getTrackingNumber();

    void setTrackingNumber(String trackingNumber);

    Date getDateReceived();

    void setDateReceived(Date dateReceived);

    Boolean getIsInTransit();

    void setIsInTransit(Boolean isInTransit);

    Boolean getIsApproved();

    void setIsApproved(Boolean isApproved);

    Boolean getIsInDispute();

    void setIsInDispute(Boolean isInDispute);

    String getRmaDocumentNumber();

    void setRmaDocumentNumber(String rmaDocumentNumber);

    String getReversalDocumentNumber();

    void setReversalDocumentNumber(String reversalDocumentNumber);

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


    boolean isStateUnsaved();

    boolean getForReapplying();

    EntityStateCollection<String, InOutImageState> getInOutImages();

    EntityStateCollection<String, InOutLineState> getInOutLines();


    void mutate(Event e);

    void when(InOutEvent.InOutStateCreated e);

    void when(InOutEvent.InOutStateMergePatched e);

    
}

