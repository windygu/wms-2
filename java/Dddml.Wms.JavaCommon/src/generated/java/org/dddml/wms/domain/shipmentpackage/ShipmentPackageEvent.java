package org.dddml.wms.domain.shipmentpackage;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface ShipmentPackageEvent extends Event
{
    ShipmentPackageEventId getShipmentPackageEventId();

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    String getShipmentBoxTypeId();

    void setShipmentBoxTypeId(String shipmentBoxTypeId);

    java.sql.Timestamp getDateCreated();

    void setDateCreated(java.sql.Timestamp dateCreated);

    java.math.BigDecimal getBoxLength();

    void setBoxLength(java.math.BigDecimal boxLength);

    java.math.BigDecimal getBoxHeight();

    void setBoxHeight(java.math.BigDecimal boxHeight);

    java.math.BigDecimal getBoxWidth();

    void setBoxWidth(java.math.BigDecimal boxWidth);

    String getDimensionUomId();

    void setDimensionUomId(String dimensionUomId);

    java.math.BigDecimal getWeight();

    void setWeight(java.math.BigDecimal weight);

    String getWeightUomId();

    void setWeightUomId(String weightUomId);

    java.math.BigDecimal getInsuredValue();

    void setInsuredValue(java.math.BigDecimal insuredValue);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    Boolean getActive();

    void setActive(Boolean active);

    String getCommandId();

    void setCommandId(String commandId);

    interface ShipmentPackageStateCreated extends ShipmentPackageEvent
    {
        Iterable<ShipmentPackageContentEvent.ShipmentPackageContentStateCreated> getShipmentPackageContentEvents();
        
        void addShipmentPackageContentEvent(ShipmentPackageContentEvent.ShipmentPackageContentStateCreated e);

        ShipmentPackageContentEvent.ShipmentPackageContentStateCreated newShipmentPackageContentStateCreated(String shipmentItemSeqId);

    
    }


    interface ShipmentPackageStateMergePatched extends ShipmentPackageEvent
    {
        Boolean getIsPropertyShipmentBoxTypeIdRemoved();

        void setIsPropertyShipmentBoxTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyDateCreatedRemoved();

        void setIsPropertyDateCreatedRemoved(Boolean removed);

        Boolean getIsPropertyBoxLengthRemoved();

        void setIsPropertyBoxLengthRemoved(Boolean removed);

        Boolean getIsPropertyBoxHeightRemoved();

        void setIsPropertyBoxHeightRemoved(Boolean removed);

        Boolean getIsPropertyBoxWidthRemoved();

        void setIsPropertyBoxWidthRemoved(Boolean removed);

        Boolean getIsPropertyDimensionUomIdRemoved();

        void setIsPropertyDimensionUomIdRemoved(Boolean removed);

        Boolean getIsPropertyWeightRemoved();

        void setIsPropertyWeightRemoved(Boolean removed);

        Boolean getIsPropertyWeightUomIdRemoved();

        void setIsPropertyWeightUomIdRemoved(Boolean removed);

        Boolean getIsPropertyInsuredValueRemoved();

        void setIsPropertyInsuredValueRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        Iterable<ShipmentPackageContentEvent> getShipmentPackageContentEvents();
        
        void addShipmentPackageContentEvent(ShipmentPackageContentEvent e);

        ShipmentPackageContentEvent.ShipmentPackageContentStateCreated newShipmentPackageContentStateCreated(String shipmentItemSeqId);

        ShipmentPackageContentEvent.ShipmentPackageContentStateMergePatched newShipmentPackageContentStateMergePatched(String shipmentItemSeqId);

        ShipmentPackageContentEvent.ShipmentPackageContentStateRemoved newShipmentPackageContentStateRemoved(String shipmentItemSeqId);


    }

    interface ShipmentPackageStateDeleted extends ShipmentPackageEvent
    {
        Iterable<ShipmentPackageContentEvent.ShipmentPackageContentStateRemoved> getShipmentPackageContentEvents();
        
        void addShipmentPackageContentEvent(ShipmentPackageContentEvent.ShipmentPackageContentStateRemoved e);
        
        ShipmentPackageContentEvent.ShipmentPackageContentStateRemoved newShipmentPackageContentStateRemoved(String shipmentItemSeqId);

    }


}

