package org.dddml.wms.domain.supplierproduct;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.supplierproduct.SupplierProductStateEvent.*;

public interface SupplierProductState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    SupplierProductId getSupplierProductId();

    void setSupplierProductId(SupplierProductId supplierProductId);

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


    void mutate(Event e);

    void when(SupplierProductStateEvent.SupplierProductStateCreated e);

    void when(SupplierProductStateEvent.SupplierProductStateMergePatched e);

    
}

