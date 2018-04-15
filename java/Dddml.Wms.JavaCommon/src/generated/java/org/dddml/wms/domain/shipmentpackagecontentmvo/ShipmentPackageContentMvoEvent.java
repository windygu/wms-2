package org.dddml.wms.domain.shipmentpackagecontentmvo;

import java.util.*;
import org.dddml.wms.domain.shipmentpackage.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface ShipmentPackageContentMvoEvent extends Event
{
    ShipmentPackageContentMvoEventId getShipmentPackageContentMvoEventId();

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    java.math.BigDecimal getQuantity();

    void setQuantity(java.math.BigDecimal quantity);

    String getSubProductId();

    void setSubProductId(String subProductId);

    java.math.BigDecimal getSubProductQuantity();

    void setSubProductQuantity(java.math.BigDecimal subProductQuantity);

    Long getVersion();

    void setVersion(Long version);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    Boolean getActive();

    void setActive(Boolean active);

    String getShipmentPackageShipmentBoxTypeId();

    void setShipmentPackageShipmentBoxTypeId(String shipmentPackageShipmentBoxTypeId);

    java.sql.Timestamp getShipmentPackageDateCreated();

    void setShipmentPackageDateCreated(java.sql.Timestamp shipmentPackageDateCreated);

    java.math.BigDecimal getShipmentPackageBoxLength();

    void setShipmentPackageBoxLength(java.math.BigDecimal shipmentPackageBoxLength);

    java.math.BigDecimal getShipmentPackageBoxHeight();

    void setShipmentPackageBoxHeight(java.math.BigDecimal shipmentPackageBoxHeight);

    java.math.BigDecimal getShipmentPackageBoxWidth();

    void setShipmentPackageBoxWidth(java.math.BigDecimal shipmentPackageBoxWidth);

    String getShipmentPackageDimensionUomId();

    void setShipmentPackageDimensionUomId(String shipmentPackageDimensionUomId);

    java.math.BigDecimal getShipmentPackageWeight();

    void setShipmentPackageWeight(java.math.BigDecimal shipmentPackageWeight);

    String getShipmentPackageWeightUomId();

    void setShipmentPackageWeightUomId(String shipmentPackageWeightUomId);

    java.math.BigDecimal getShipmentPackageInsuredValue();

    void setShipmentPackageInsuredValue(java.math.BigDecimal shipmentPackageInsuredValue);

    String getShipmentPackageCreatedBy();

    void setShipmentPackageCreatedBy(String shipmentPackageCreatedBy);

    Date getShipmentPackageCreatedAt();

    void setShipmentPackageCreatedAt(Date shipmentPackageCreatedAt);

    String getShipmentPackageUpdatedBy();

    void setShipmentPackageUpdatedBy(String shipmentPackageUpdatedBy);

    Date getShipmentPackageUpdatedAt();

    void setShipmentPackageUpdatedAt(Date shipmentPackageUpdatedAt);

    Boolean getShipmentPackageActive();

    void setShipmentPackageActive(Boolean shipmentPackageActive);

    Boolean getShipmentPackageDeleted();

    void setShipmentPackageDeleted(Boolean shipmentPackageDeleted);

    String getCommandId();

    void setCommandId(String commandId);

    interface ShipmentPackageContentMvoStateCreated extends ShipmentPackageContentMvoEvent
    {
    
    }


    interface ShipmentPackageContentMvoStateMergePatched extends ShipmentPackageContentMvoEvent
    {
        Boolean getIsPropertyQuantityRemoved();

        void setIsPropertyQuantityRemoved(Boolean removed);

        Boolean getIsPropertySubProductIdRemoved();

        void setIsPropertySubProductIdRemoved(Boolean removed);

        Boolean getIsPropertySubProductQuantityRemoved();

        void setIsPropertySubProductQuantityRemoved(Boolean removed);

        Boolean getIsPropertyVersionRemoved();

        void setIsPropertyVersionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        Boolean getIsPropertyShipmentPackageShipmentBoxTypeIdRemoved();

        void setIsPropertyShipmentPackageShipmentBoxTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyShipmentPackageDateCreatedRemoved();

        void setIsPropertyShipmentPackageDateCreatedRemoved(Boolean removed);

        Boolean getIsPropertyShipmentPackageBoxLengthRemoved();

        void setIsPropertyShipmentPackageBoxLengthRemoved(Boolean removed);

        Boolean getIsPropertyShipmentPackageBoxHeightRemoved();

        void setIsPropertyShipmentPackageBoxHeightRemoved(Boolean removed);

        Boolean getIsPropertyShipmentPackageBoxWidthRemoved();

        void setIsPropertyShipmentPackageBoxWidthRemoved(Boolean removed);

        Boolean getIsPropertyShipmentPackageDimensionUomIdRemoved();

        void setIsPropertyShipmentPackageDimensionUomIdRemoved(Boolean removed);

        Boolean getIsPropertyShipmentPackageWeightRemoved();

        void setIsPropertyShipmentPackageWeightRemoved(Boolean removed);

        Boolean getIsPropertyShipmentPackageWeightUomIdRemoved();

        void setIsPropertyShipmentPackageWeightUomIdRemoved(Boolean removed);

        Boolean getIsPropertyShipmentPackageInsuredValueRemoved();

        void setIsPropertyShipmentPackageInsuredValueRemoved(Boolean removed);

        Boolean getIsPropertyShipmentPackageCreatedByRemoved();

        void setIsPropertyShipmentPackageCreatedByRemoved(Boolean removed);

        Boolean getIsPropertyShipmentPackageCreatedAtRemoved();

        void setIsPropertyShipmentPackageCreatedAtRemoved(Boolean removed);

        Boolean getIsPropertyShipmentPackageUpdatedByRemoved();

        void setIsPropertyShipmentPackageUpdatedByRemoved(Boolean removed);

        Boolean getIsPropertyShipmentPackageUpdatedAtRemoved();

        void setIsPropertyShipmentPackageUpdatedAtRemoved(Boolean removed);

        Boolean getIsPropertyShipmentPackageActiveRemoved();

        void setIsPropertyShipmentPackageActiveRemoved(Boolean removed);

        Boolean getIsPropertyShipmentPackageDeletedRemoved();

        void setIsPropertyShipmentPackageDeletedRemoved(Boolean removed);


    }

    interface ShipmentPackageContentMvoStateDeleted extends ShipmentPackageContentMvoEvent
    {
    }


}

