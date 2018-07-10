package org.dddml.wms.domain.supplierproduct;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractEvent;

public class SupplierProductStateEventDto extends AbstractEvent
{

    private SupplierProductEventId supplierProductEventId;

    SupplierProductEventId getSupplierProductEventId() {
        if (supplierProductEventId == null) { supplierProductEventId = new SupplierProductEventId(); }
        return supplierProductEventId;
    }

    void setSupplierProductEventId(SupplierProductEventId eventId) {
        this.supplierProductEventId = eventId;
    }

    public SupplierProductId getSupplierProductId() {
        return getSupplierProductEventId().getSupplierProductId();
    }

    public void setSupplierProductId(SupplierProductId supplierProductId) {
        getSupplierProductEventId().setSupplierProductId(supplierProductId);
    }

    public Long getVersion() {
        return getSupplierProductEventId().getVersion();
    }
    
    public void getVersion(Long version) {
        getSupplierProductEventId().setVersion(version);
    }

    private java.sql.Timestamp availableThruDate;

    public java.sql.Timestamp getAvailableThruDate() {
        return this.availableThruDate;
    }

    public void setAvailableThruDate(java.sql.Timestamp availableThruDate) {
        this.availableThruDate = availableThruDate;
    }

    private String supplierPrefOrderId;

    public String getSupplierPrefOrderId() {
        return this.supplierPrefOrderId;
    }

    public void setSupplierPrefOrderId(String supplierPrefOrderId) {
        this.supplierPrefOrderId = supplierPrefOrderId;
    }

    private String supplierRatingTypeId;

    public String getSupplierRatingTypeId() {
        return this.supplierRatingTypeId;
    }

    public void setSupplierRatingTypeId(String supplierRatingTypeId) {
        this.supplierRatingTypeId = supplierRatingTypeId;
    }

    private java.math.BigDecimal standardLeadTimeDays;

    public java.math.BigDecimal getStandardLeadTimeDays() {
        return this.standardLeadTimeDays;
    }

    public void setStandardLeadTimeDays(java.math.BigDecimal standardLeadTimeDays) {
        this.standardLeadTimeDays = standardLeadTimeDays;
    }

    private java.math.BigDecimal manufacturingLeadTimeDays;

    public java.math.BigDecimal getManufacturingLeadTimeDays() {
        return this.manufacturingLeadTimeDays;
    }

    public void setManufacturingLeadTimeDays(java.math.BigDecimal manufacturingLeadTimeDays) {
        this.manufacturingLeadTimeDays = manufacturingLeadTimeDays;
    }

    private java.math.BigDecimal deliveryLeadTimeDays;

    public java.math.BigDecimal getDeliveryLeadTimeDays() {
        return this.deliveryLeadTimeDays;
    }

    public void setDeliveryLeadTimeDays(java.math.BigDecimal deliveryLeadTimeDays) {
        this.deliveryLeadTimeDays = deliveryLeadTimeDays;
    }

    private String quantityUomId;

    public String getQuantityUomId() {
        return this.quantityUomId;
    }

    public void setQuantityUomId(String quantityUomId) {
        this.quantityUomId = quantityUomId;
    }

    private java.math.BigDecimal lastPrice;

    public java.math.BigDecimal getLastPrice() {
        return this.lastPrice;
    }

    public void setLastPrice(java.math.BigDecimal lastPrice) {
        this.lastPrice = lastPrice;
    }

    private java.math.BigDecimal shippingPrice;

    public java.math.BigDecimal getShippingPrice() {
        return this.shippingPrice;
    }

    public void setShippingPrice(java.math.BigDecimal shippingPrice) {
        this.shippingPrice = shippingPrice;
    }

    private String externalProductName;

    public String getExternalProductName() {
        return this.externalProductName;
    }

    public void setExternalProductName(String externalProductName) {
        this.externalProductName = externalProductName;
    }

    private String externalProductId;

    public String getExternalProductId() {
        return this.externalProductId;
    }

    public void setExternalProductId(String externalProductId) {
        this.externalProductId = externalProductId;
    }

    private Boolean canDropShip;

    public Boolean getCanDropShip() {
        return this.canDropShip;
    }

    public void setCanDropShip(Boolean canDropShip) {
        this.canDropShip = canDropShip;
    }

    private String comments;

    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    private Boolean active;

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    private String createdBy;

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    private Date createdAt;

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    private Boolean isPropertyAvailableThruDateRemoved;

    public Boolean getIsPropertyAvailableThruDateRemoved() {
        return this.isPropertyAvailableThruDateRemoved;
    }

    public void setIsPropertyAvailableThruDateRemoved(Boolean removed) {
        this.isPropertyAvailableThruDateRemoved = removed;
    }

    private Boolean isPropertySupplierPrefOrderIdRemoved;

    public Boolean getIsPropertySupplierPrefOrderIdRemoved() {
        return this.isPropertySupplierPrefOrderIdRemoved;
    }

    public void setIsPropertySupplierPrefOrderIdRemoved(Boolean removed) {
        this.isPropertySupplierPrefOrderIdRemoved = removed;
    }

    private Boolean isPropertySupplierRatingTypeIdRemoved;

    public Boolean getIsPropertySupplierRatingTypeIdRemoved() {
        return this.isPropertySupplierRatingTypeIdRemoved;
    }

    public void setIsPropertySupplierRatingTypeIdRemoved(Boolean removed) {
        this.isPropertySupplierRatingTypeIdRemoved = removed;
    }

    private Boolean isPropertyStandardLeadTimeDaysRemoved;

    public Boolean getIsPropertyStandardLeadTimeDaysRemoved() {
        return this.isPropertyStandardLeadTimeDaysRemoved;
    }

    public void setIsPropertyStandardLeadTimeDaysRemoved(Boolean removed) {
        this.isPropertyStandardLeadTimeDaysRemoved = removed;
    }

    private Boolean isPropertyManufacturingLeadTimeDaysRemoved;

    public Boolean getIsPropertyManufacturingLeadTimeDaysRemoved() {
        return this.isPropertyManufacturingLeadTimeDaysRemoved;
    }

    public void setIsPropertyManufacturingLeadTimeDaysRemoved(Boolean removed) {
        this.isPropertyManufacturingLeadTimeDaysRemoved = removed;
    }

    private Boolean isPropertyDeliveryLeadTimeDaysRemoved;

    public Boolean getIsPropertyDeliveryLeadTimeDaysRemoved() {
        return this.isPropertyDeliveryLeadTimeDaysRemoved;
    }

    public void setIsPropertyDeliveryLeadTimeDaysRemoved(Boolean removed) {
        this.isPropertyDeliveryLeadTimeDaysRemoved = removed;
    }

    private Boolean isPropertyQuantityUomIdRemoved;

    public Boolean getIsPropertyQuantityUomIdRemoved() {
        return this.isPropertyQuantityUomIdRemoved;
    }

    public void setIsPropertyQuantityUomIdRemoved(Boolean removed) {
        this.isPropertyQuantityUomIdRemoved = removed;
    }

    private Boolean isPropertyLastPriceRemoved;

    public Boolean getIsPropertyLastPriceRemoved() {
        return this.isPropertyLastPriceRemoved;
    }

    public void setIsPropertyLastPriceRemoved(Boolean removed) {
        this.isPropertyLastPriceRemoved = removed;
    }

    private Boolean isPropertyShippingPriceRemoved;

    public Boolean getIsPropertyShippingPriceRemoved() {
        return this.isPropertyShippingPriceRemoved;
    }

    public void setIsPropertyShippingPriceRemoved(Boolean removed) {
        this.isPropertyShippingPriceRemoved = removed;
    }

    private Boolean isPropertyExternalProductNameRemoved;

    public Boolean getIsPropertyExternalProductNameRemoved() {
        return this.isPropertyExternalProductNameRemoved;
    }

    public void setIsPropertyExternalProductNameRemoved(Boolean removed) {
        this.isPropertyExternalProductNameRemoved = removed;
    }

    private Boolean isPropertyExternalProductIdRemoved;

    public Boolean getIsPropertyExternalProductIdRemoved() {
        return this.isPropertyExternalProductIdRemoved;
    }

    public void setIsPropertyExternalProductIdRemoved(Boolean removed) {
        this.isPropertyExternalProductIdRemoved = removed;
    }

    private Boolean isPropertyCanDropShipRemoved;

    public Boolean getIsPropertyCanDropShipRemoved() {
        return this.isPropertyCanDropShipRemoved;
    }

    public void setIsPropertyCanDropShipRemoved(Boolean removed) {
        this.isPropertyCanDropShipRemoved = removed;
    }

    private Boolean isPropertyCommentsRemoved;

    public Boolean getIsPropertyCommentsRemoved() {
        return this.isPropertyCommentsRemoved;
    }

    public void setIsPropertyCommentsRemoved(Boolean removed) {
        this.isPropertyCommentsRemoved = removed;
    }

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved() {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed) {
        this.isPropertyActiveRemoved = removed;
    }


	public static class SupplierProductStateCreatedDto extends SupplierProductStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class SupplierProductStateMergePatchedDto extends SupplierProductStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class SupplierProductStateDeletedDto extends SupplierProductStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_DELETED;
        }

	}


}

