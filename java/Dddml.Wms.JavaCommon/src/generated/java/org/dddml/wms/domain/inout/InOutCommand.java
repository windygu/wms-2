package org.dddml.wms.domain.inout;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface InOutCommand extends Command
{
    String getDocumentNumber();

    void setDocumentNumber(String documentNumber);

    Long getVersion();

    void setVersion(Long version);

    static void throwOnInvalidStateTransition(InOutState state, Command c) {
        if (state.getVersion() == null)
        {
            if (isCommandCreate((InOutCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (isCommandCreate((InOutCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(InOutCommand c) {
        return ((c instanceof InOutCommand.CreateInOut) 
            && c.getVersion().equals(InOutState.VERSION_NULL));
    }

    interface CreateOrMergePatchInOut extends InOutCommand
    {
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

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateInOut extends CreateOrMergePatchInOut
    {
        CreateInOutImageCommands getInOutImages();

        InOutImageCommand.CreateInOutImage newCreateInOutImage();

        CreateInOutLineCommands getInOutLines();

        InOutLineCommand.CreateInOutLine newCreateInOutLine();

    }

    interface MergePatchInOut extends CreateOrMergePatchInOut
    {
        Boolean getIsPropertyPostedRemoved();

        void setIsPropertyPostedRemoved(Boolean removed);

        Boolean getIsPropertyProcessedRemoved();

        void setIsPropertyProcessedRemoved(Boolean removed);

        Boolean getIsPropertyProcessingRemoved();

        void setIsPropertyProcessingRemoved(Boolean removed);

        Boolean getIsPropertyDocumentTypeIdRemoved();

        void setIsPropertyDocumentTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyOrderIdRemoved();

        void setIsPropertyOrderIdRemoved(Boolean removed);

        Boolean getIsPropertyDateOrderedRemoved();

        void setIsPropertyDateOrderedRemoved(Boolean removed);

        Boolean getIsPropertyIsPrintedRemoved();

        void setIsPropertyIsPrintedRemoved(Boolean removed);

        Boolean getIsPropertyMovementTypeIdRemoved();

        void setIsPropertyMovementTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyMovementDateRemoved();

        void setIsPropertyMovementDateRemoved(Boolean removed);

        Boolean getIsPropertyBusinessPartnerIdRemoved();

        void setIsPropertyBusinessPartnerIdRemoved(Boolean removed);

        Boolean getIsPropertyWarehouseIdRemoved();

        void setIsPropertyWarehouseIdRemoved(Boolean removed);

        Boolean getIsPropertyPOReferenceRemoved();

        void setIsPropertyPOReferenceRemoved(Boolean removed);

        Boolean getIsPropertyFreightAmountRemoved();

        void setIsPropertyFreightAmountRemoved(Boolean removed);

        Boolean getIsPropertyShipperIdRemoved();

        void setIsPropertyShipperIdRemoved(Boolean removed);

        Boolean getIsPropertyChargeAmountRemoved();

        void setIsPropertyChargeAmountRemoved(Boolean removed);

        Boolean getIsPropertyDatePrintedRemoved();

        void setIsPropertyDatePrintedRemoved(Boolean removed);

        Boolean getIsPropertyCreatedFromRemoved();

        void setIsPropertyCreatedFromRemoved(Boolean removed);

        Boolean getIsPropertySalesRepresentativeIdRemoved();

        void setIsPropertySalesRepresentativeIdRemoved(Boolean removed);

        Boolean getIsPropertyNumberOfPackagesRemoved();

        void setIsPropertyNumberOfPackagesRemoved(Boolean removed);

        Boolean getIsPropertyPickDateRemoved();

        void setIsPropertyPickDateRemoved(Boolean removed);

        Boolean getIsPropertyShipDateRemoved();

        void setIsPropertyShipDateRemoved(Boolean removed);

        Boolean getIsPropertyTrackingNumberRemoved();

        void setIsPropertyTrackingNumberRemoved(Boolean removed);

        Boolean getIsPropertyDateReceivedRemoved();

        void setIsPropertyDateReceivedRemoved(Boolean removed);

        Boolean getIsPropertyIsInTransitRemoved();

        void setIsPropertyIsInTransitRemoved(Boolean removed);

        Boolean getIsPropertyIsApprovedRemoved();

        void setIsPropertyIsApprovedRemoved(Boolean removed);

        Boolean getIsPropertyIsInDisputeRemoved();

        void setIsPropertyIsInDisputeRemoved(Boolean removed);

        Boolean getIsPropertyRmaDocumentNumberRemoved();

        void setIsPropertyRmaDocumentNumberRemoved(Boolean removed);

        Boolean getIsPropertyReversalDocumentNumberRemoved();

        void setIsPropertyReversalDocumentNumberRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        InOutImageCommands getInOutImageCommands();

        InOutImageCommand.CreateInOutImage newCreateInOutImage();

        InOutImageCommand.MergePatchInOutImage newMergePatchInOutImage();

        InOutImageCommand.RemoveInOutImage newRemoveInOutImage();

        InOutLineCommands getInOutLineCommands();

        InOutLineCommand.CreateInOutLine newCreateInOutLine();

        InOutLineCommand.MergePatchInOutLine newMergePatchInOutLine();

        InOutLineCommand.RemoveInOutLine newRemoveInOutLine();

    }

	interface DeleteInOut extends InOutCommand
	{
	}

    interface CreateInOutImageCommands extends Iterable<InOutImageCommand.CreateInOutImage>
    {
        void add(InOutImageCommand.CreateInOutImage c);

        void remove(InOutImageCommand.CreateInOutImage c);

        void clear();
    }

    interface InOutImageCommands extends Iterable<InOutImageCommand>
    {
        void add(InOutImageCommand c);

        void remove(InOutImageCommand c);

        void clear();
    }

    interface CreateInOutLineCommands extends Iterable<InOutLineCommand.CreateInOutLine>
    {
        void add(InOutLineCommand.CreateInOutLine c);

        void remove(InOutLineCommand.CreateInOutLine c);

        void clear();
    }

    interface InOutLineCommands extends Iterable<InOutLineCommand>
    {
        void add(InOutLineCommand c);

        void remove(InOutLineCommand c);

        void clear();
    }

}

