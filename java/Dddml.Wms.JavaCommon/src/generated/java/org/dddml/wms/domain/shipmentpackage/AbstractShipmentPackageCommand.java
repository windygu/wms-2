package org.dddml.wms.domain.shipmentpackage;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractShipmentPackageCommand extends AbstractCommand implements ShipmentPackageCommand
{
    private ShipmentPackageId shipmentPackageId;

    public ShipmentPackageId getShipmentPackageId()
    {
        return this.shipmentPackageId;
    }

    public void setShipmentPackageId(ShipmentPackageId shipmentPackageId)
    {
        this.shipmentPackageId = shipmentPackageId;
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


    public static abstract class AbstractCreateOrMergePatchShipmentPackage extends AbstractShipmentPackageCommand implements CreateOrMergePatchShipmentPackage
    {
        private String shipmentBoxTypeId;

        public String getShipmentBoxTypeId()
        {
            return this.shipmentBoxTypeId;
        }

        public void setShipmentBoxTypeId(String shipmentBoxTypeId)
        {
            this.shipmentBoxTypeId = shipmentBoxTypeId;
        }

        private java.sql.Timestamp dateCreated;

        public java.sql.Timestamp getDateCreated()
        {
            return this.dateCreated;
        }

        public void setDateCreated(java.sql.Timestamp dateCreated)
        {
            this.dateCreated = dateCreated;
        }

        private java.math.BigDecimal boxLength;

        public java.math.BigDecimal getBoxLength()
        {
            return this.boxLength;
        }

        public void setBoxLength(java.math.BigDecimal boxLength)
        {
            this.boxLength = boxLength;
        }

        private java.math.BigDecimal boxHeight;

        public java.math.BigDecimal getBoxHeight()
        {
            return this.boxHeight;
        }

        public void setBoxHeight(java.math.BigDecimal boxHeight)
        {
            this.boxHeight = boxHeight;
        }

        private java.math.BigDecimal boxWidth;

        public java.math.BigDecimal getBoxWidth()
        {
            return this.boxWidth;
        }

        public void setBoxWidth(java.math.BigDecimal boxWidth)
        {
            this.boxWidth = boxWidth;
        }

        private String dimensionUomId;

        public String getDimensionUomId()
        {
            return this.dimensionUomId;
        }

        public void setDimensionUomId(String dimensionUomId)
        {
            this.dimensionUomId = dimensionUomId;
        }

        private java.math.BigDecimal weight;

        public java.math.BigDecimal getWeight()
        {
            return this.weight;
        }

        public void setWeight(java.math.BigDecimal weight)
        {
            this.weight = weight;
        }

        private String weightUomId;

        public String getWeightUomId()
        {
            return this.weightUomId;
        }

        public void setWeightUomId(String weightUomId)
        {
            this.weightUomId = weightUomId;
        }

        private java.math.BigDecimal insuredValue;

        public java.math.BigDecimal getInsuredValue()
        {
            return this.insuredValue;
        }

        public void setInsuredValue(java.math.BigDecimal insuredValue)
        {
            this.insuredValue = insuredValue;
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

        public ShipmentPackageContentCommand.CreateShipmentPackageContent newCreateShipmentPackageContent()
        {
            AbstractShipmentPackageContentCommand.SimpleCreateShipmentPackageContent c = new AbstractShipmentPackageContentCommand.SimpleCreateShipmentPackageContent();
            c.setShipmentPackageId(this.getShipmentPackageId());

            return c;
        }

        public ShipmentPackageContentCommand.MergePatchShipmentPackageContent newMergePatchShipmentPackageContent()
        {
            AbstractShipmentPackageContentCommand.SimpleMergePatchShipmentPackageContent c = new AbstractShipmentPackageContentCommand.SimpleMergePatchShipmentPackageContent();
            c.setShipmentPackageId(this.getShipmentPackageId());

            return c;
        }

        public ShipmentPackageContentCommand.RemoveShipmentPackageContent newRemoveShipmentPackageContent()
        {
            AbstractShipmentPackageContentCommand.SimpleRemoveShipmentPackageContent c = new AbstractShipmentPackageContentCommand.SimpleRemoveShipmentPackageContent();
            c.setShipmentPackageId(this.getShipmentPackageId());

            return c;
        }

    }

    public static abstract class AbstractCreateShipmentPackage extends AbstractCreateOrMergePatchShipmentPackage implements CreateShipmentPackage
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

        private CreateShipmentPackageContentCommandCollection shipmentPackageContents = new SimpleCreateShipmentPackageContentCommandCollection();

        public CreateShipmentPackageContentCommandCollection getShipmentPackageContents()
        {
            return this.shipmentPackageContents;
        }

    }

    public static abstract class AbstractMergePatchShipmentPackage extends AbstractCreateOrMergePatchShipmentPackage implements MergePatchShipmentPackage
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
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

        private ShipmentPackageContentCommandCollection shipmentPackageContentCommands = new SimpleShipmentPackageContentCommandCollection();

        public ShipmentPackageContentCommandCollection getShipmentPackageContentCommands()
        {
            return this.shipmentPackageContentCommands;
        }

    }

    public static class SimpleCreateShipmentPackage extends AbstractCreateShipmentPackage
    {
    }

    
    public static class SimpleMergePatchShipmentPackage extends AbstractMergePatchShipmentPackage
    {
    }

    
	public static class SimpleDeleteShipmentPackage extends AbstractShipmentPackageCommand implements DeleteShipmentPackage
	{
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_DELETE;
        }
	}

    
    public static class SimpleCreateShipmentPackageContentCommandCollection implements CreateShipmentPackageContentCommandCollection {
        private List<ShipmentPackageContentCommand.CreateShipmentPackageContent> innerCommands = new ArrayList<ShipmentPackageContentCommand.CreateShipmentPackageContent>();

        public void add(ShipmentPackageContentCommand.CreateShipmentPackageContent c) {
            innerCommands.add(c);
        }

        public void remove(ShipmentPackageContentCommand.CreateShipmentPackageContent c) {
            innerCommands.remove(c);
        }

        public void clear() {
            innerCommands.clear();
        }

        @Override
        public Iterator<ShipmentPackageContentCommand.CreateShipmentPackageContent> iterator() {
            return innerCommands.iterator();
        }
    }

    public static class SimpleShipmentPackageContentCommandCollection implements ShipmentPackageContentCommandCollection {
        private List<ShipmentPackageContentCommand> innerCommands = new ArrayList<ShipmentPackageContentCommand>();

        public void add(ShipmentPackageContentCommand c) {
            innerCommands.add(c);
        }

        public void remove(ShipmentPackageContentCommand c) {
            innerCommands.remove(c);
        }

        public void clear() {
            innerCommands.clear();
        }

        @Override
        public Iterator<ShipmentPackageContentCommand> iterator() {
            return innerCommands.iterator();
        }
    }


}

