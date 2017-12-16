package org.dddml.wms.domain.inout;

import java.util.*;
import java.util.Date;
import java.math.BigDecimal;
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
        if (state.getDeleted())
        {
            throw DomainError.named("zombie", "Can't do anything to deleted aggregate.");
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
        String getDocumentAction();

        void setDocumentAction(String documentAction);

        Boolean getPosted();

        void setPosted(Boolean posted);

        Boolean getProcessing();

        void setProcessing(Boolean processing);

        Boolean getProcessed();

        void setProcessed(Boolean processed);

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

        String getShipperId();

        void setShipperId(String shipperId);

        Date getDatePrinted();

        void setDatePrinted(Date datePrinted);

        String getSalesRepresentative();

        void setSalesRepresentative(String salesRepresentative);

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

        String getRmaNumber();

        void setRmaNumber(String rmaNumber);

        String getReversalNumber();

        void setReversalNumber(String reversalNumber);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateInOut extends CreateOrMergePatchInOut
    {
        CreateInOutLineCommands getInOutLines();

        InOutLineCommand.CreateInOutLine newCreateInOutLine();

    }

    interface MergePatchInOut extends CreateOrMergePatchInOut
    {
        Boolean getIsPropertyPostedRemoved();

        void setIsPropertyPostedRemoved(Boolean removed);

        Boolean getIsPropertyProcessingRemoved();

        void setIsPropertyProcessingRemoved(Boolean removed);

        Boolean getIsPropertyProcessedRemoved();

        void setIsPropertyProcessedRemoved(Boolean removed);

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

        Boolean getIsPropertyShipperIdRemoved();

        void setIsPropertyShipperIdRemoved(Boolean removed);

        Boolean getIsPropertyDatePrintedRemoved();

        void setIsPropertyDatePrintedRemoved(Boolean removed);

        Boolean getIsPropertySalesRepresentativeRemoved();

        void setIsPropertySalesRepresentativeRemoved(Boolean removed);

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

        Boolean getIsPropertyRmaNumberRemoved();

        void setIsPropertyRmaNumberRemoved(Boolean removed);

        Boolean getIsPropertyReversalNumberRemoved();

        void setIsPropertyReversalNumberRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        InOutLineCommands getInOutLineCommands();

        InOutLineCommand.CreateInOutLine newCreateInOutLine();

        InOutLineCommand.MergePatchInOutLine newMergePatchInOutLine();

        InOutLineCommand.RemoveInOutLine newRemoveInOutLine();

    }

	interface DeleteInOut extends InOutCommand
	{
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

