package org.dddml.wms.domain.supplierproduct;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface SupplierProductCommand extends Command
{
    SupplierProductId getSupplierProductId();

    void setSupplierProductId(SupplierProductId supplierProductId);

    Long getVersion();

    void setVersion(Long version);

    static void throwOnInvalidStateTransition(SupplierProductState state, Command c) {
        if (state.getVersion() == null)
        {
            if (isCommandCreate((SupplierProductCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (isCommandCreate((SupplierProductCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(SupplierProductCommand c) {
        return ((c instanceof SupplierProductCommand.CreateSupplierProduct) 
            && (COMMAND_TYPE_CREATE.equals(c.getCommandType()) || c.getVersion().equals(SupplierProductState.VERSION_NULL)));
    }

    interface CreateOrMergePatchSupplierProduct extends SupplierProductCommand
    {
        java.sql.Timestamp getAvailableThruDate();

        void setAvailableThruDate(java.sql.Timestamp availableThruDate);

        String getSupplierPrefOrderId();

        void setSupplierPrefOrderId(String supplierPrefOrderId);

        String getSupplierRatingTypeId();

        void setSupplierRatingTypeId(String supplierRatingTypeId);

        java.math.BigDecimal getStandardLeadTimeDays();

        void setStandardLeadTimeDays(java.math.BigDecimal standardLeadTimeDays);

        java.math.BigDecimal getManufacturingLeadTimeDays();

        void setManufacturingLeadTimeDays(java.math.BigDecimal manufacturingLeadTimeDays);

        java.math.BigDecimal getDeliveryLeadTimeDays();

        void setDeliveryLeadTimeDays(java.math.BigDecimal deliveryLeadTimeDays);

        String getQuantityUomId();

        void setQuantityUomId(String quantityUomId);

        java.math.BigDecimal getLastPrice();

        void setLastPrice(java.math.BigDecimal lastPrice);

        java.math.BigDecimal getShippingPrice();

        void setShippingPrice(java.math.BigDecimal shippingPrice);

        String getExternalProductName();

        void setExternalProductName(String externalProductName);

        String getExternalProductId();

        void setExternalProductId(String externalProductId);

        Boolean getCanDropShip();

        void setCanDropShip(Boolean canDropShip);

        String getComments();

        void setComments(String comments);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateSupplierProduct extends CreateOrMergePatchSupplierProduct
    {
    }

    interface MergePatchSupplierProduct extends CreateOrMergePatchSupplierProduct
    {
        Boolean getIsPropertyAvailableThruDateRemoved();

        void setIsPropertyAvailableThruDateRemoved(Boolean removed);

        Boolean getIsPropertySupplierPrefOrderIdRemoved();

        void setIsPropertySupplierPrefOrderIdRemoved(Boolean removed);

        Boolean getIsPropertySupplierRatingTypeIdRemoved();

        void setIsPropertySupplierRatingTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyStandardLeadTimeDaysRemoved();

        void setIsPropertyStandardLeadTimeDaysRemoved(Boolean removed);

        Boolean getIsPropertyManufacturingLeadTimeDaysRemoved();

        void setIsPropertyManufacturingLeadTimeDaysRemoved(Boolean removed);

        Boolean getIsPropertyDeliveryLeadTimeDaysRemoved();

        void setIsPropertyDeliveryLeadTimeDaysRemoved(Boolean removed);

        Boolean getIsPropertyQuantityUomIdRemoved();

        void setIsPropertyQuantityUomIdRemoved(Boolean removed);

        Boolean getIsPropertyLastPriceRemoved();

        void setIsPropertyLastPriceRemoved(Boolean removed);

        Boolean getIsPropertyShippingPriceRemoved();

        void setIsPropertyShippingPriceRemoved(Boolean removed);

        Boolean getIsPropertyExternalProductNameRemoved();

        void setIsPropertyExternalProductNameRemoved(Boolean removed);

        Boolean getIsPropertyExternalProductIdRemoved();

        void setIsPropertyExternalProductIdRemoved(Boolean removed);

        Boolean getIsPropertyCanDropShipRemoved();

        void setIsPropertyCanDropShipRemoved(Boolean removed);

        Boolean getIsPropertyCommentsRemoved();

        void setIsPropertyCommentsRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

    }

	interface DeleteSupplierProduct extends SupplierProductCommand
	{
	}

}

