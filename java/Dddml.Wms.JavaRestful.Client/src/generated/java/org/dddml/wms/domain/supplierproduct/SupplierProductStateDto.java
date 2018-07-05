package org.dddml.wms.domain.supplierproduct;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class SupplierProductStateDto
{

    private SupplierProductId supplierProductId;

    public SupplierProductId getSupplierProductId()
    {
        return this.supplierProductId;
    }

    public void setSupplierProductId(SupplierProductId supplierProductId)
    {
        this.supplierProductId = supplierProductId;
    }

    private java.sql.Timestamp availableThruDate;

    public java.sql.Timestamp getAvailableThruDate()
    {
        return this.availableThruDate;
    }

    public void setAvailableThruDate(java.sql.Timestamp availableThruDate)
    {
        this.availableThruDate = availableThruDate;
    }

    private String supplierPrefOrderId;

    public String getSupplierPrefOrderId()
    {
        return this.supplierPrefOrderId;
    }

    public void setSupplierPrefOrderId(String supplierPrefOrderId)
    {
        this.supplierPrefOrderId = supplierPrefOrderId;
    }

    private String supplierRatingTypeId;

    public String getSupplierRatingTypeId()
    {
        return this.supplierRatingTypeId;
    }

    public void setSupplierRatingTypeId(String supplierRatingTypeId)
    {
        this.supplierRatingTypeId = supplierRatingTypeId;
    }

    private java.math.BigDecimal standardLeadTimeDays;

    public java.math.BigDecimal getStandardLeadTimeDays()
    {
        return this.standardLeadTimeDays;
    }

    public void setStandardLeadTimeDays(java.math.BigDecimal standardLeadTimeDays)
    {
        this.standardLeadTimeDays = standardLeadTimeDays;
    }

    private java.math.BigDecimal manufacturingLeadTimeDays;

    public java.math.BigDecimal getManufacturingLeadTimeDays()
    {
        return this.manufacturingLeadTimeDays;
    }

    public void setManufacturingLeadTimeDays(java.math.BigDecimal manufacturingLeadTimeDays)
    {
        this.manufacturingLeadTimeDays = manufacturingLeadTimeDays;
    }

    private java.math.BigDecimal deliveryLeadTimeDays;

    public java.math.BigDecimal getDeliveryLeadTimeDays()
    {
        return this.deliveryLeadTimeDays;
    }

    public void setDeliveryLeadTimeDays(java.math.BigDecimal deliveryLeadTimeDays)
    {
        this.deliveryLeadTimeDays = deliveryLeadTimeDays;
    }

    private String quantityUomId;

    public String getQuantityUomId()
    {
        return this.quantityUomId;
    }

    public void setQuantityUomId(String quantityUomId)
    {
        this.quantityUomId = quantityUomId;
    }

    private java.math.BigDecimal lastPrice;

    public java.math.BigDecimal getLastPrice()
    {
        return this.lastPrice;
    }

    public void setLastPrice(java.math.BigDecimal lastPrice)
    {
        this.lastPrice = lastPrice;
    }

    private java.math.BigDecimal shippingPrice;

    public java.math.BigDecimal getShippingPrice()
    {
        return this.shippingPrice;
    }

    public void setShippingPrice(java.math.BigDecimal shippingPrice)
    {
        this.shippingPrice = shippingPrice;
    }

    private String externalProductName;

    public String getExternalProductName()
    {
        return this.externalProductName;
    }

    public void setExternalProductName(String externalProductName)
    {
        this.externalProductName = externalProductName;
    }

    private String externalProductId;

    public String getExternalProductId()
    {
        return this.externalProductId;
    }

    public void setExternalProductId(String externalProductId)
    {
        this.externalProductId = externalProductId;
    }

    private Boolean canDropShip;

    public Boolean getCanDropShip()
    {
        return this.canDropShip;
    }

    public void setCanDropShip(Boolean canDropShip)
    {
        this.canDropShip = canDropShip;
    }

    private String comments;

    public String getComments()
    {
        return this.comments;
    }

    public void setComments(String comments)
    {
        this.comments = comments;
    }

    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }

    private String createdBy;

    public String getCreatedBy()
    {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy)
    {
        this.createdBy = createdBy;
    }

    private Date createdAt;

    public Date getCreatedAt()
    {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    private String updatedBy;

    public String getUpdatedBy()
    {
        return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy)
    {
        this.updatedBy = updatedBy;
    }

    private Date updatedAt;

    public Date getUpdatedAt()
    {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt)
    {
        this.updatedAt = updatedAt;
    }

}

