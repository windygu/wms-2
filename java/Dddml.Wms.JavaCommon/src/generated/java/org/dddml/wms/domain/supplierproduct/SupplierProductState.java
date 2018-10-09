package org.dddml.wms.domain.supplierproduct;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.supplierproduct.SupplierProductEvent.*;

public interface SupplierProductState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    SupplierProductId getSupplierProductId();

    java.sql.Timestamp getAvailableThruDate();

    String getSupplierPrefOrderId();

    String getSupplierRatingTypeId();

    java.math.BigDecimal getStandardLeadTimeDays();

    java.math.BigDecimal getManufacturingLeadTimeDays();

    java.math.BigDecimal getDeliveryLeadTimeDays();

    String getQuantityUomId();

    java.math.BigDecimal getLastPrice();

    java.math.BigDecimal getShippingPrice();

    String getExternalProductName();

    String getExternalProductId();

    Boolean getCanDropShip();

    String getComments();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    interface MutableSupplierProductState extends SupplierProductState {
        void setSupplierProductId(SupplierProductId supplierProductId);

        void setAvailableThruDate(java.sql.Timestamp availableThruDate);

        void setSupplierPrefOrderId(String supplierPrefOrderId);

        void setSupplierRatingTypeId(String supplierRatingTypeId);

        void setStandardLeadTimeDays(java.math.BigDecimal standardLeadTimeDays);

        void setManufacturingLeadTimeDays(java.math.BigDecimal manufacturingLeadTimeDays);

        void setDeliveryLeadTimeDays(java.math.BigDecimal deliveryLeadTimeDays);

        void setQuantityUomId(String quantityUomId);

        void setLastPrice(java.math.BigDecimal lastPrice);

        void setShippingPrice(java.math.BigDecimal shippingPrice);

        void setExternalProductName(String externalProductName);

        void setExternalProductId(String externalProductId);

        void setCanDropShip(Boolean canDropShip);

        void setComments(String comments);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);


        void mutate(Event e);

        void when(SupplierProductEvent.SupplierProductStateCreated e);

        void when(SupplierProductEvent.SupplierProductStateMergePatched e);

    }

    interface SqlSupplierProductState extends MutableSupplierProductState {

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

