package org.dddml.wms.domain.supplierproduct;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface SupplierProductEvent extends Event
{
    SupplierProductEventId getSupplierProductEventId();

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface SupplierProductStateEvent extends SupplierProductEvent {
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

    interface SupplierProductStateCreated extends SupplierProductStateEvent
    {
    
    }


    interface SupplierProductStateMergePatched extends SupplierProductStateEvent
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


}

