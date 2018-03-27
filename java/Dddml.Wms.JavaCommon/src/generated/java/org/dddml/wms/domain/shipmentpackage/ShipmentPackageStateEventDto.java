package org.dddml.wms.domain.shipmentpackage;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractStateEvent;

public class ShipmentPackageStateEventDto extends AbstractStateEvent
{

    private ShipmentPackageEventId shipmentPackageEventId;

    ShipmentPackageEventId getStateEventId() {
        if (shipmentPackageEventId == null) { shipmentPackageEventId = new ShipmentPackageEventId(); }
        return shipmentPackageEventId;
    }

    void setShipmentPackageEventId(ShipmentPackageEventId eventId) {
        this.shipmentPackageEventId = eventId;
    }

    public ShipmentPackageId getShipmentPackageId() {
        return getStateEventId().getShipmentPackageId();
    }

    public void setShipmentPackageId(ShipmentPackageId shipmentPackageId) {
        getStateEventId().setShipmentPackageId(shipmentPackageId);
    }

    public Long getVersion() {
        return getStateEventId().getVersion();
    }
    
    public void getVersion(Long version) {
        getStateEventId().setVersion(version);
    }

    private String shipmentBoxTypeId;

    public String getShipmentBoxTypeId() {
        return this.shipmentBoxTypeId;
    }

    public void setShipmentBoxTypeId(String shipmentBoxTypeId) {
        this.shipmentBoxTypeId = shipmentBoxTypeId;
    }

    private java.sql.Timestamp dateCreated;

    public java.sql.Timestamp getDateCreated() {
        return this.dateCreated;
    }

    public void setDateCreated(java.sql.Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    private java.math.BigDecimal boxLength;

    public java.math.BigDecimal getBoxLength() {
        return this.boxLength;
    }

    public void setBoxLength(java.math.BigDecimal boxLength) {
        this.boxLength = boxLength;
    }

    private java.math.BigDecimal boxHeight;

    public java.math.BigDecimal getBoxHeight() {
        return this.boxHeight;
    }

    public void setBoxHeight(java.math.BigDecimal boxHeight) {
        this.boxHeight = boxHeight;
    }

    private java.math.BigDecimal boxWidth;

    public java.math.BigDecimal getBoxWidth() {
        return this.boxWidth;
    }

    public void setBoxWidth(java.math.BigDecimal boxWidth) {
        this.boxWidth = boxWidth;
    }

    private String dimensionUomId;

    public String getDimensionUomId() {
        return this.dimensionUomId;
    }

    public void setDimensionUomId(String dimensionUomId) {
        this.dimensionUomId = dimensionUomId;
    }

    private java.math.BigDecimal weight;

    public java.math.BigDecimal getWeight() {
        return this.weight;
    }

    public void setWeight(java.math.BigDecimal weight) {
        this.weight = weight;
    }

    private String weightUomId;

    public String getWeightUomId() {
        return this.weightUomId;
    }

    public void setWeightUomId(String weightUomId) {
        this.weightUomId = weightUomId;
    }

    private java.math.BigDecimal insuredValue;

    public java.math.BigDecimal getInsuredValue() {
        return this.insuredValue;
    }

    public void setInsuredValue(java.math.BigDecimal insuredValue) {
        this.insuredValue = insuredValue;
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

    private Boolean isPropertyShipmentBoxTypeIdRemoved;

    public Boolean getIsPropertyShipmentBoxTypeIdRemoved() {
        return this.isPropertyShipmentBoxTypeIdRemoved;
    }

    public void setIsPropertyShipmentBoxTypeIdRemoved(Boolean removed) {
        this.isPropertyShipmentBoxTypeIdRemoved = removed;
    }

    private Boolean isPropertyDateCreatedRemoved;

    public Boolean getIsPropertyDateCreatedRemoved() {
        return this.isPropertyDateCreatedRemoved;
    }

    public void setIsPropertyDateCreatedRemoved(Boolean removed) {
        this.isPropertyDateCreatedRemoved = removed;
    }

    private Boolean isPropertyBoxLengthRemoved;

    public Boolean getIsPropertyBoxLengthRemoved() {
        return this.isPropertyBoxLengthRemoved;
    }

    public void setIsPropertyBoxLengthRemoved(Boolean removed) {
        this.isPropertyBoxLengthRemoved = removed;
    }

    private Boolean isPropertyBoxHeightRemoved;

    public Boolean getIsPropertyBoxHeightRemoved() {
        return this.isPropertyBoxHeightRemoved;
    }

    public void setIsPropertyBoxHeightRemoved(Boolean removed) {
        this.isPropertyBoxHeightRemoved = removed;
    }

    private Boolean isPropertyBoxWidthRemoved;

    public Boolean getIsPropertyBoxWidthRemoved() {
        return this.isPropertyBoxWidthRemoved;
    }

    public void setIsPropertyBoxWidthRemoved(Boolean removed) {
        this.isPropertyBoxWidthRemoved = removed;
    }

    private Boolean isPropertyDimensionUomIdRemoved;

    public Boolean getIsPropertyDimensionUomIdRemoved() {
        return this.isPropertyDimensionUomIdRemoved;
    }

    public void setIsPropertyDimensionUomIdRemoved(Boolean removed) {
        this.isPropertyDimensionUomIdRemoved = removed;
    }

    private Boolean isPropertyWeightRemoved;

    public Boolean getIsPropertyWeightRemoved() {
        return this.isPropertyWeightRemoved;
    }

    public void setIsPropertyWeightRemoved(Boolean removed) {
        this.isPropertyWeightRemoved = removed;
    }

    private Boolean isPropertyWeightUomIdRemoved;

    public Boolean getIsPropertyWeightUomIdRemoved() {
        return this.isPropertyWeightUomIdRemoved;
    }

    public void setIsPropertyWeightUomIdRemoved(Boolean removed) {
        this.isPropertyWeightUomIdRemoved = removed;
    }

    private Boolean isPropertyInsuredValueRemoved;

    public Boolean getIsPropertyInsuredValueRemoved() {
        return this.isPropertyInsuredValueRemoved;
    }

    public void setIsPropertyInsuredValueRemoved(Boolean removed) {
        this.isPropertyInsuredValueRemoved = removed;
    }

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved() {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed) {
        this.isPropertyActiveRemoved = removed;
    }


    private ShipmentPackageContentStateEventDto[] shipmentPackageContentEvents;

    public ShipmentPackageContentStateEventDto[] getShipmentPackageContentEvents() {
        return this.shipmentPackageContentEvents;
    }

    public void setShipmentPackageContentEvents(ShipmentPackageContentStateEventDto[] events) {
        this.shipmentPackageContentEvents = events;
    }


	public static class ShipmentPackageStateCreatedDto extends ShipmentPackageStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class ShipmentPackageStateMergePatchedDto extends ShipmentPackageStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class ShipmentPackageStateDeletedDto extends ShipmentPackageStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_DELETED;
        }

	}


}

