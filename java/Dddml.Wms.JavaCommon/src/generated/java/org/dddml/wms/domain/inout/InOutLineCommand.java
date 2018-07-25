package org.dddml.wms.domain.inout;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface InOutLineCommand extends Command
{
    String getLineNumber();

    void setLineNumber(String lineNumber);

    String getInOutDocumentNumber();

    void setInOutDocumentNumber(String inOutDocumentNumber);

    interface CreateOrMergePatchInOutLine extends InOutLineCommand
    {
        String getLocatorId();

        void setLocatorId(String locatorId);

        String getProductId();

        void setProductId(String productId);

        String getAttributeSetInstanceId();

        void setAttributeSetInstanceId(String attributeSetInstanceId);

        String getDamageStatusId();

        void setDamageStatusId(String damageStatusId);

        String getDescription();

        void setDescription(String description);

        String getQuantityUomId();

        void setQuantityUomId(String quantityUomId);

        BigDecimal getMovementQuantity();

        void setMovementQuantity(BigDecimal movementQuantity);

        BigDecimal getPickedQuantity();

        void setPickedQuantity(BigDecimal pickedQuantity);

        Boolean getIsInvoiced();

        void setIsInvoiced(Boolean isInvoiced);

        Boolean getProcessed();

        void setProcessed(Boolean processed);

        String getRmaLineNumber();

        void setRmaLineNumber(String rmaLineNumber);

        String getReversalLineNumber();

        void setReversalLineNumber(String reversalLineNumber);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateInOutLine extends CreateOrMergePatchInOutLine
    {
        CreateInOutLineImageCommands getInOutLineImages();

        InOutLineImageCommand.CreateInOutLineImage newCreateInOutLineImage();

    }

    interface MergePatchInOutLine extends CreateOrMergePatchInOutLine
    {
        Boolean getIsPropertyLocatorIdRemoved();

        void setIsPropertyLocatorIdRemoved(Boolean removed);

        Boolean getIsPropertyProductIdRemoved();

        void setIsPropertyProductIdRemoved(Boolean removed);

        Boolean getIsPropertyAttributeSetInstanceIdRemoved();

        void setIsPropertyAttributeSetInstanceIdRemoved(Boolean removed);

        Boolean getIsPropertyDamageStatusIdRemoved();

        void setIsPropertyDamageStatusIdRemoved(Boolean removed);

        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyQuantityUomIdRemoved();

        void setIsPropertyQuantityUomIdRemoved(Boolean removed);

        Boolean getIsPropertyMovementQuantityRemoved();

        void setIsPropertyMovementQuantityRemoved(Boolean removed);

        Boolean getIsPropertyPickedQuantityRemoved();

        void setIsPropertyPickedQuantityRemoved(Boolean removed);

        Boolean getIsPropertyIsInvoicedRemoved();

        void setIsPropertyIsInvoicedRemoved(Boolean removed);

        Boolean getIsPropertyProcessedRemoved();

        void setIsPropertyProcessedRemoved(Boolean removed);

        Boolean getIsPropertyRmaLineNumberRemoved();

        void setIsPropertyRmaLineNumberRemoved(Boolean removed);

        Boolean getIsPropertyReversalLineNumberRemoved();

        void setIsPropertyReversalLineNumberRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        InOutLineImageCommands getInOutLineImageCommands();

        InOutLineImageCommand.CreateInOutLineImage newCreateInOutLineImage();

        InOutLineImageCommand.MergePatchInOutLineImage newMergePatchInOutLineImage();

        InOutLineImageCommand.RemoveInOutLineImage newRemoveInOutLineImage();

    }

	interface RemoveInOutLine extends InOutLineCommand
	{
	}

    interface CreateInOutLineImageCommands extends Iterable<InOutLineImageCommand.CreateInOutLineImage>
    {
        void add(InOutLineImageCommand.CreateInOutLineImage c);

        void remove(InOutLineImageCommand.CreateInOutLineImage c);

        void clear();
    }

    interface InOutLineImageCommands extends Iterable<InOutLineImageCommand>
    {
        void add(InOutLineImageCommand c);

        void remove(InOutLineImageCommand c);

        void clear();
    }

}

