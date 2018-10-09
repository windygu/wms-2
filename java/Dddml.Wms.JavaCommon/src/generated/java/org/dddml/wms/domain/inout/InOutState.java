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

    String getDocumentStatusId();

    Boolean getPosted();

    Boolean getProcessed();

    String getProcessing();

    String getDocumentTypeId();

    String getDescription();

    String getOrderId();

    Date getDateOrdered();

    Boolean getIsPrinted();

    String getMovementTypeId();

    Date getMovementDate();

    String getBusinessPartnerId();

    String getWarehouseId();

    String getPOReference();

    BigDecimal getFreightAmount();

    String getShipperId();

    BigDecimal getChargeAmount();

    Date getDatePrinted();

    String getCreatedFrom();

    String getSalesRepresentativeId();

    Integer getNumberOfPackages();

    Date getPickDate();

    Date getShipDate();

    String getTrackingNumber();

    Date getDateReceived();

    Boolean getIsInTransit();

    Boolean getIsApproved();

    Boolean getIsInDispute();

    String getRmaDocumentNumber();

    String getReversalDocumentNumber();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    EntityStateCollection<String, InOutImageState> getInOutImages();

    EntityStateCollection<String, InOutLineState> getInOutLines();

    interface MutableInOutState extends InOutState {
        void setDocumentNumber(String documentNumber);

        void setDocumentStatusId(String documentStatusId);

        void setPosted(Boolean posted);

        void setProcessed(Boolean processed);

        void setProcessing(String processing);

        void setDocumentTypeId(String documentTypeId);

        void setDescription(String description);

        void setOrderId(String orderId);

        void setDateOrdered(Date dateOrdered);

        void setIsPrinted(Boolean isPrinted);

        void setMovementTypeId(String movementTypeId);

        void setMovementDate(Date movementDate);

        void setBusinessPartnerId(String businessPartnerId);

        void setWarehouseId(String warehouseId);

        void setPOReference(String poReference);

        void setFreightAmount(BigDecimal freightAmount);

        void setShipperId(String shipperId);

        void setChargeAmount(BigDecimal chargeAmount);

        void setDatePrinted(Date datePrinted);

        void setCreatedFrom(String createdFrom);

        void setSalesRepresentativeId(String salesRepresentativeId);

        void setNumberOfPackages(Integer numberOfPackages);

        void setPickDate(Date pickDate);

        void setShipDate(Date shipDate);

        void setTrackingNumber(String trackingNumber);

        void setDateReceived(Date dateReceived);

        void setIsInTransit(Boolean isInTransit);

        void setIsApproved(Boolean isApproved);

        void setIsInDispute(Boolean isInDispute);

        void setRmaDocumentNumber(String rmaDocumentNumber);

        void setReversalDocumentNumber(String reversalDocumentNumber);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);


        void mutate(Event e);

        void when(InOutEvent.InOutStateCreated e);

        void when(InOutEvent.InOutStateMergePatched e);

    }

    interface SqlInOutState extends MutableInOutState {

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

