package org.dddml.wms.domain.shipmentpackage;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchShipmentPackageDto extends AbstractShipmentPackageCommandDto
{
    /**
     * Shipment Box Type Id
     */
    private String shipmentBoxTypeId;

    public String getShipmentBoxTypeId()
    {
        return this.shipmentBoxTypeId;
    }

    public void setShipmentBoxTypeId(String shipmentBoxTypeId)
    {
        this.shipmentBoxTypeId = shipmentBoxTypeId;
    }

    /**
     * Date Created
     */
    private java.sql.Timestamp dateCreated;

    public java.sql.Timestamp getDateCreated()
    {
        return this.dateCreated;
    }

    public void setDateCreated(java.sql.Timestamp dateCreated)
    {
        this.dateCreated = dateCreated;
    }

    /**
     * This field store the length of package; if a shipmentBoxTypeId is specified then this overrides the dimension specified there; this field is meant to be used when there is no applicable ShipmentBoxType
     */
    private java.math.BigDecimal boxLength;

    public java.math.BigDecimal getBoxLength()
    {
        return this.boxLength;
    }

    public void setBoxLength(java.math.BigDecimal boxLength)
    {
        this.boxLength = boxLength;
    }

    /**
     * This field store the height of package; if a shipmentBoxTypeId is specified then this overrides the dimension specified there; this field is meant to be used when there is no applicable ShipmentBoxType
     */
    private java.math.BigDecimal boxHeight;

    public java.math.BigDecimal getBoxHeight()
    {
        return this.boxHeight;
    }

    public void setBoxHeight(java.math.BigDecimal boxHeight)
    {
        this.boxHeight = boxHeight;
    }

    /**
     * This field store the width of package; if a shipmentBoxTypeId is specified then this overrides the dimension specified there; this field is meant to be used when there is no applicable ShipmentBoxType
     */
    private java.math.BigDecimal boxWidth;

    public java.math.BigDecimal getBoxWidth()
    {
        return this.boxWidth;
    }

    public void setBoxWidth(java.math.BigDecimal boxWidth)
    {
        this.boxWidth = boxWidth;
    }

    /**
     * This field store the unit of measurement of dimension (length, width and height)
     */
    private String dimensionUomId;

    public String getDimensionUomId()
    {
        return this.dimensionUomId;
    }

    public void setDimensionUomId(String dimensionUomId)
    {
        this.dimensionUomId = dimensionUomId;
    }

    /**
     * Weight
     */
    private java.math.BigDecimal weight;

    public java.math.BigDecimal getWeight()
    {
        return this.weight;
    }

    public void setWeight(java.math.BigDecimal weight)
    {
        this.weight = weight;
    }

    /**
     * Weight Uom Id
     */
    private String weightUomId;

    public String getWeightUomId()
    {
        return this.weightUomId;
    }

    public void setWeightUomId(String weightUomId)
    {
        this.weightUomId = weightUomId;
    }

    /**
     * Insured Value
     */
    private java.math.BigDecimal insuredValue;

    public java.math.BigDecimal getInsuredValue()
    {
        return this.insuredValue;
    }

    public void setInsuredValue(java.math.BigDecimal insuredValue)
    {
        this.insuredValue = insuredValue;
    }

    /**
     * Active
     */
    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }

    private CreateOrMergePatchShipmentPackageContentDto[] shipmentPackageContents;

    public CreateOrMergePatchShipmentPackageContentDto[] getShipmentPackageContents()
    {
        return this.shipmentPackageContents;
    }

    public void setShipmentPackageContents(CreateOrMergePatchShipmentPackageContentDto[] shipmentPackageContents)
    {
        this.shipmentPackageContents = shipmentPackageContents;
    }

    private Boolean isPropertyShipmentBoxTypeIdRemoved;

    public Boolean getIsPropertyShipmentBoxTypeIdRemoved()
    {
        return this.isPropertyShipmentBoxTypeIdRemoved;
    }

    public void setIsPropertyShipmentBoxTypeIdRemoved(Boolean removed)
    {
        this.isPropertyShipmentBoxTypeIdRemoved = removed;
    }

    private Boolean isPropertyDateCreatedRemoved;

    public Boolean getIsPropertyDateCreatedRemoved()
    {
        return this.isPropertyDateCreatedRemoved;
    }

    public void setIsPropertyDateCreatedRemoved(Boolean removed)
    {
        this.isPropertyDateCreatedRemoved = removed;
    }

    private Boolean isPropertyBoxLengthRemoved;

    public Boolean getIsPropertyBoxLengthRemoved()
    {
        return this.isPropertyBoxLengthRemoved;
    }

    public void setIsPropertyBoxLengthRemoved(Boolean removed)
    {
        this.isPropertyBoxLengthRemoved = removed;
    }

    private Boolean isPropertyBoxHeightRemoved;

    public Boolean getIsPropertyBoxHeightRemoved()
    {
        return this.isPropertyBoxHeightRemoved;
    }

    public void setIsPropertyBoxHeightRemoved(Boolean removed)
    {
        this.isPropertyBoxHeightRemoved = removed;
    }

    private Boolean isPropertyBoxWidthRemoved;

    public Boolean getIsPropertyBoxWidthRemoved()
    {
        return this.isPropertyBoxWidthRemoved;
    }

    public void setIsPropertyBoxWidthRemoved(Boolean removed)
    {
        this.isPropertyBoxWidthRemoved = removed;
    }

    private Boolean isPropertyDimensionUomIdRemoved;

    public Boolean getIsPropertyDimensionUomIdRemoved()
    {
        return this.isPropertyDimensionUomIdRemoved;
    }

    public void setIsPropertyDimensionUomIdRemoved(Boolean removed)
    {
        this.isPropertyDimensionUomIdRemoved = removed;
    }

    private Boolean isPropertyWeightRemoved;

    public Boolean getIsPropertyWeightRemoved()
    {
        return this.isPropertyWeightRemoved;
    }

    public void setIsPropertyWeightRemoved(Boolean removed)
    {
        this.isPropertyWeightRemoved = removed;
    }

    private Boolean isPropertyWeightUomIdRemoved;

    public Boolean getIsPropertyWeightUomIdRemoved()
    {
        return this.isPropertyWeightUomIdRemoved;
    }

    public void setIsPropertyWeightUomIdRemoved(Boolean removed)
    {
        this.isPropertyWeightUomIdRemoved = removed;
    }

    private Boolean isPropertyInsuredValueRemoved;

    public Boolean getIsPropertyInsuredValueRemoved()
    {
        return this.isPropertyInsuredValueRemoved;
    }

    public void setIsPropertyInsuredValueRemoved(Boolean removed)
    {
        this.isPropertyInsuredValueRemoved = removed;
    }

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved()
    {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed)
    {
        this.isPropertyActiveRemoved = removed;
    }

    public static class CreateShipmentPackageDto extends CreateOrMergePatchShipmentPackageDto
    {
        public CreateShipmentPackageDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static class MergePatchShipmentPackageDto extends CreateOrMergePatchShipmentPackageDto
    {
        public MergePatchShipmentPackageDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

    }

}

