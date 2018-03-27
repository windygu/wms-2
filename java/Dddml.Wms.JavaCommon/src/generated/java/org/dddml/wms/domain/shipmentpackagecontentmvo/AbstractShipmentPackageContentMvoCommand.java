package org.dddml.wms.domain.shipmentpackagecontentmvo;

import java.util.*;
import org.dddml.wms.domain.shipmentpackage.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractShipmentPackageContentMvoCommand extends AbstractCommand implements ShipmentPackageContentMvoCommand
{
    private ShipmentPackageContentId shipmentPackageContentId;

    public ShipmentPackageContentId getShipmentPackageContentId()
    {
        return this.shipmentPackageContentId;
    }

    public void setShipmentPackageContentId(ShipmentPackageContentId shipmentPackageContentId)
    {
        this.shipmentPackageContentId = shipmentPackageContentId;
    }

    private Long shipmentPackageVersion;

    public Long getShipmentPackageVersion()
    {
        return this.shipmentPackageVersion;
    }

    public void setShipmentPackageVersion(Long shipmentPackageVersion)
    {
        this.shipmentPackageVersion = shipmentPackageVersion;
    }


    public static abstract class AbstractCreateOrMergePatchShipmentPackageContentMvo extends AbstractShipmentPackageContentMvoCommand implements CreateOrMergePatchShipmentPackageContentMvo
    {
        private java.math.BigDecimal quantity;

        public java.math.BigDecimal getQuantity()
        {
            return this.quantity;
        }

        public void setQuantity(java.math.BigDecimal quantity)
        {
            this.quantity = quantity;
        }

        private String subProductId;

        public String getSubProductId()
        {
            return this.subProductId;
        }

        public void setSubProductId(String subProductId)
        {
            this.subProductId = subProductId;
        }

        private java.math.BigDecimal subProductQuantity;

        public java.math.BigDecimal getSubProductQuantity()
        {
            return this.subProductQuantity;
        }

        public void setSubProductQuantity(java.math.BigDecimal subProductQuantity)
        {
            this.subProductQuantity = subProductQuantity;
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

        private Boolean active;

        public Boolean getActive()
        {
            return this.active;
        }

        public void setActive(Boolean active)
        {
            this.active = active;
        }

        private String shipmentPackageShipmentBoxTypeId;

        public String getShipmentPackageShipmentBoxTypeId()
        {
            return this.shipmentPackageShipmentBoxTypeId;
        }

        public void setShipmentPackageShipmentBoxTypeId(String shipmentPackageShipmentBoxTypeId)
        {
            this.shipmentPackageShipmentBoxTypeId = shipmentPackageShipmentBoxTypeId;
        }

        private java.sql.Timestamp shipmentPackageDateCreated;

        public java.sql.Timestamp getShipmentPackageDateCreated()
        {
            return this.shipmentPackageDateCreated;
        }

        public void setShipmentPackageDateCreated(java.sql.Timestamp shipmentPackageDateCreated)
        {
            this.shipmentPackageDateCreated = shipmentPackageDateCreated;
        }

        private java.math.BigDecimal shipmentPackageBoxLength;

        public java.math.BigDecimal getShipmentPackageBoxLength()
        {
            return this.shipmentPackageBoxLength;
        }

        public void setShipmentPackageBoxLength(java.math.BigDecimal shipmentPackageBoxLength)
        {
            this.shipmentPackageBoxLength = shipmentPackageBoxLength;
        }

        private java.math.BigDecimal shipmentPackageBoxHeight;

        public java.math.BigDecimal getShipmentPackageBoxHeight()
        {
            return this.shipmentPackageBoxHeight;
        }

        public void setShipmentPackageBoxHeight(java.math.BigDecimal shipmentPackageBoxHeight)
        {
            this.shipmentPackageBoxHeight = shipmentPackageBoxHeight;
        }

        private java.math.BigDecimal shipmentPackageBoxWidth;

        public java.math.BigDecimal getShipmentPackageBoxWidth()
        {
            return this.shipmentPackageBoxWidth;
        }

        public void setShipmentPackageBoxWidth(java.math.BigDecimal shipmentPackageBoxWidth)
        {
            this.shipmentPackageBoxWidth = shipmentPackageBoxWidth;
        }

        private String shipmentPackageDimensionUomId;

        public String getShipmentPackageDimensionUomId()
        {
            return this.shipmentPackageDimensionUomId;
        }

        public void setShipmentPackageDimensionUomId(String shipmentPackageDimensionUomId)
        {
            this.shipmentPackageDimensionUomId = shipmentPackageDimensionUomId;
        }

        private java.math.BigDecimal shipmentPackageWeight;

        public java.math.BigDecimal getShipmentPackageWeight()
        {
            return this.shipmentPackageWeight;
        }

        public void setShipmentPackageWeight(java.math.BigDecimal shipmentPackageWeight)
        {
            this.shipmentPackageWeight = shipmentPackageWeight;
        }

        private String shipmentPackageWeightUomId;

        public String getShipmentPackageWeightUomId()
        {
            return this.shipmentPackageWeightUomId;
        }

        public void setShipmentPackageWeightUomId(String shipmentPackageWeightUomId)
        {
            this.shipmentPackageWeightUomId = shipmentPackageWeightUomId;
        }

        private java.math.BigDecimal shipmentPackageInsuredValue;

        public java.math.BigDecimal getShipmentPackageInsuredValue()
        {
            return this.shipmentPackageInsuredValue;
        }

        public void setShipmentPackageInsuredValue(java.math.BigDecimal shipmentPackageInsuredValue)
        {
            this.shipmentPackageInsuredValue = shipmentPackageInsuredValue;
        }

        private String shipmentPackageCreatedBy;

        public String getShipmentPackageCreatedBy()
        {
            return this.shipmentPackageCreatedBy;
        }

        public void setShipmentPackageCreatedBy(String shipmentPackageCreatedBy)
        {
            this.shipmentPackageCreatedBy = shipmentPackageCreatedBy;
        }

        private Date shipmentPackageCreatedAt;

        public Date getShipmentPackageCreatedAt()
        {
            return this.shipmentPackageCreatedAt;
        }

        public void setShipmentPackageCreatedAt(Date shipmentPackageCreatedAt)
        {
            this.shipmentPackageCreatedAt = shipmentPackageCreatedAt;
        }

        private String shipmentPackageUpdatedBy;

        public String getShipmentPackageUpdatedBy()
        {
            return this.shipmentPackageUpdatedBy;
        }

        public void setShipmentPackageUpdatedBy(String shipmentPackageUpdatedBy)
        {
            this.shipmentPackageUpdatedBy = shipmentPackageUpdatedBy;
        }

        private Date shipmentPackageUpdatedAt;

        public Date getShipmentPackageUpdatedAt()
        {
            return this.shipmentPackageUpdatedAt;
        }

        public void setShipmentPackageUpdatedAt(Date shipmentPackageUpdatedAt)
        {
            this.shipmentPackageUpdatedAt = shipmentPackageUpdatedAt;
        }

        private Boolean shipmentPackageActive;

        public Boolean getShipmentPackageActive()
        {
            return this.shipmentPackageActive;
        }

        public void setShipmentPackageActive(Boolean shipmentPackageActive)
        {
            this.shipmentPackageActive = shipmentPackageActive;
        }

        private Boolean shipmentPackageDeleted;

        public Boolean getShipmentPackageDeleted()
        {
            return this.shipmentPackageDeleted;
        }

        public void setShipmentPackageDeleted(Boolean shipmentPackageDeleted)
        {
            this.shipmentPackageDeleted = shipmentPackageDeleted;
        }

    }

    public static abstract class AbstractCreateShipmentPackageContentMvo extends AbstractCreateOrMergePatchShipmentPackageContentMvo implements CreateShipmentPackageContentMvo
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static abstract class AbstractMergePatchShipmentPackageContentMvo extends AbstractCreateOrMergePatchShipmentPackageContentMvo implements MergePatchShipmentPackageContentMvo
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

        private Boolean isPropertyQuantityRemoved;

        public Boolean getIsPropertyQuantityRemoved()
        {
            return this.isPropertyQuantityRemoved;
        }

        public void setIsPropertyQuantityRemoved(Boolean removed)
        {
            this.isPropertyQuantityRemoved = removed;
        }

        private Boolean isPropertySubProductIdRemoved;

        public Boolean getIsPropertySubProductIdRemoved()
        {
            return this.isPropertySubProductIdRemoved;
        }

        public void setIsPropertySubProductIdRemoved(Boolean removed)
        {
            this.isPropertySubProductIdRemoved = removed;
        }

        private Boolean isPropertySubProductQuantityRemoved;

        public Boolean getIsPropertySubProductQuantityRemoved()
        {
            return this.isPropertySubProductQuantityRemoved;
        }

        public void setIsPropertySubProductQuantityRemoved(Boolean removed)
        {
            this.isPropertySubProductQuantityRemoved = removed;
        }

        private Boolean isPropertyVersionRemoved;

        public Boolean getIsPropertyVersionRemoved()
        {
            return this.isPropertyVersionRemoved;
        }

        public void setIsPropertyVersionRemoved(Boolean removed)
        {
            this.isPropertyVersionRemoved = removed;
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

        private Boolean isPropertyShipmentPackageShipmentBoxTypeIdRemoved;

        public Boolean getIsPropertyShipmentPackageShipmentBoxTypeIdRemoved()
        {
            return this.isPropertyShipmentPackageShipmentBoxTypeIdRemoved;
        }

        public void setIsPropertyShipmentPackageShipmentBoxTypeIdRemoved(Boolean removed)
        {
            this.isPropertyShipmentPackageShipmentBoxTypeIdRemoved = removed;
        }

        private Boolean isPropertyShipmentPackageDateCreatedRemoved;

        public Boolean getIsPropertyShipmentPackageDateCreatedRemoved()
        {
            return this.isPropertyShipmentPackageDateCreatedRemoved;
        }

        public void setIsPropertyShipmentPackageDateCreatedRemoved(Boolean removed)
        {
            this.isPropertyShipmentPackageDateCreatedRemoved = removed;
        }

        private Boolean isPropertyShipmentPackageBoxLengthRemoved;

        public Boolean getIsPropertyShipmentPackageBoxLengthRemoved()
        {
            return this.isPropertyShipmentPackageBoxLengthRemoved;
        }

        public void setIsPropertyShipmentPackageBoxLengthRemoved(Boolean removed)
        {
            this.isPropertyShipmentPackageBoxLengthRemoved = removed;
        }

        private Boolean isPropertyShipmentPackageBoxHeightRemoved;

        public Boolean getIsPropertyShipmentPackageBoxHeightRemoved()
        {
            return this.isPropertyShipmentPackageBoxHeightRemoved;
        }

        public void setIsPropertyShipmentPackageBoxHeightRemoved(Boolean removed)
        {
            this.isPropertyShipmentPackageBoxHeightRemoved = removed;
        }

        private Boolean isPropertyShipmentPackageBoxWidthRemoved;

        public Boolean getIsPropertyShipmentPackageBoxWidthRemoved()
        {
            return this.isPropertyShipmentPackageBoxWidthRemoved;
        }

        public void setIsPropertyShipmentPackageBoxWidthRemoved(Boolean removed)
        {
            this.isPropertyShipmentPackageBoxWidthRemoved = removed;
        }

        private Boolean isPropertyShipmentPackageDimensionUomIdRemoved;

        public Boolean getIsPropertyShipmentPackageDimensionUomIdRemoved()
        {
            return this.isPropertyShipmentPackageDimensionUomIdRemoved;
        }

        public void setIsPropertyShipmentPackageDimensionUomIdRemoved(Boolean removed)
        {
            this.isPropertyShipmentPackageDimensionUomIdRemoved = removed;
        }

        private Boolean isPropertyShipmentPackageWeightRemoved;

        public Boolean getIsPropertyShipmentPackageWeightRemoved()
        {
            return this.isPropertyShipmentPackageWeightRemoved;
        }

        public void setIsPropertyShipmentPackageWeightRemoved(Boolean removed)
        {
            this.isPropertyShipmentPackageWeightRemoved = removed;
        }

        private Boolean isPropertyShipmentPackageWeightUomIdRemoved;

        public Boolean getIsPropertyShipmentPackageWeightUomIdRemoved()
        {
            return this.isPropertyShipmentPackageWeightUomIdRemoved;
        }

        public void setIsPropertyShipmentPackageWeightUomIdRemoved(Boolean removed)
        {
            this.isPropertyShipmentPackageWeightUomIdRemoved = removed;
        }

        private Boolean isPropertyShipmentPackageInsuredValueRemoved;

        public Boolean getIsPropertyShipmentPackageInsuredValueRemoved()
        {
            return this.isPropertyShipmentPackageInsuredValueRemoved;
        }

        public void setIsPropertyShipmentPackageInsuredValueRemoved(Boolean removed)
        {
            this.isPropertyShipmentPackageInsuredValueRemoved = removed;
        }

        private Boolean isPropertyShipmentPackageCreatedByRemoved;

        public Boolean getIsPropertyShipmentPackageCreatedByRemoved()
        {
            return this.isPropertyShipmentPackageCreatedByRemoved;
        }

        public void setIsPropertyShipmentPackageCreatedByRemoved(Boolean removed)
        {
            this.isPropertyShipmentPackageCreatedByRemoved = removed;
        }

        private Boolean isPropertyShipmentPackageCreatedAtRemoved;

        public Boolean getIsPropertyShipmentPackageCreatedAtRemoved()
        {
            return this.isPropertyShipmentPackageCreatedAtRemoved;
        }

        public void setIsPropertyShipmentPackageCreatedAtRemoved(Boolean removed)
        {
            this.isPropertyShipmentPackageCreatedAtRemoved = removed;
        }

        private Boolean isPropertyShipmentPackageUpdatedByRemoved;

        public Boolean getIsPropertyShipmentPackageUpdatedByRemoved()
        {
            return this.isPropertyShipmentPackageUpdatedByRemoved;
        }

        public void setIsPropertyShipmentPackageUpdatedByRemoved(Boolean removed)
        {
            this.isPropertyShipmentPackageUpdatedByRemoved = removed;
        }

        private Boolean isPropertyShipmentPackageUpdatedAtRemoved;

        public Boolean getIsPropertyShipmentPackageUpdatedAtRemoved()
        {
            return this.isPropertyShipmentPackageUpdatedAtRemoved;
        }

        public void setIsPropertyShipmentPackageUpdatedAtRemoved(Boolean removed)
        {
            this.isPropertyShipmentPackageUpdatedAtRemoved = removed;
        }

        private Boolean isPropertyShipmentPackageActiveRemoved;

        public Boolean getIsPropertyShipmentPackageActiveRemoved()
        {
            return this.isPropertyShipmentPackageActiveRemoved;
        }

        public void setIsPropertyShipmentPackageActiveRemoved(Boolean removed)
        {
            this.isPropertyShipmentPackageActiveRemoved = removed;
        }

        private Boolean isPropertyShipmentPackageDeletedRemoved;

        public Boolean getIsPropertyShipmentPackageDeletedRemoved()
        {
            return this.isPropertyShipmentPackageDeletedRemoved;
        }

        public void setIsPropertyShipmentPackageDeletedRemoved(Boolean removed)
        {
            this.isPropertyShipmentPackageDeletedRemoved = removed;
        }

    }

    public static class SimpleCreateShipmentPackageContentMvo extends AbstractCreateShipmentPackageContentMvo
    {
    }

    
    public static class SimpleMergePatchShipmentPackageContentMvo extends AbstractMergePatchShipmentPackageContentMvo
    {
    }

    
	public static class SimpleDeleteShipmentPackageContentMvo extends AbstractShipmentPackageContentMvoCommand implements DeleteShipmentPackageContentMvo
	{
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_DELETE;
        }
	}

    

}

