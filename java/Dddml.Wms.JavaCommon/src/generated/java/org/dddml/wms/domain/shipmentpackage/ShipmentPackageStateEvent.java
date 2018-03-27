package org.dddml.wms.domain.shipmentpackage;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface ShipmentPackageStateEvent extends Event
{
    ShipmentPackageEventId getShipmentPackageEventId();

    boolean getStateEventReadOnly();

    void setStateEventReadOnly(boolean readOnly);

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

    interface ShipmentPackageStateCreated extends ShipmentPackageStateEvent
    {
        Iterable<ShipmentPackageContentStateEvent.ShipmentPackageContentStateCreated> getShipmentPackageContentEvents();
        
        void addShipmentPackageContentEvent(ShipmentPackageContentStateEvent.ShipmentPackageContentStateCreated e);

        ShipmentPackageContentStateEvent.ShipmentPackageContentStateCreated newShipmentPackageContentStateCreated(String shipmentItemSeqId);

    
    }


    interface ShipmentPackageStateMergePatched extends ShipmentPackageStateEvent
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

        Iterable<ShipmentPackageContentStateEvent> getShipmentPackageContentEvents();
        
        void addShipmentPackageContentEvent(ShipmentPackageContentStateEvent e);

        ShipmentPackageContentStateEvent.ShipmentPackageContentStateCreated newShipmentPackageContentStateCreated(String shipmentItemSeqId);

        ShipmentPackageContentStateEvent.ShipmentPackageContentStateMergePatched newShipmentPackageContentStateMergePatched(String shipmentItemSeqId);

        ShipmentPackageContentStateEvent.ShipmentPackageContentStateRemoved newShipmentPackageContentStateRemoved(String shipmentItemSeqId);


    }

    interface ShipmentPackageStateDeleted extends ShipmentPackageStateEvent
    {
        Iterable<ShipmentPackageContentStateEvent.ShipmentPackageContentStateRemoved> getShipmentPackageContentEvents();
        
        void addShipmentPackageContentEvent(ShipmentPackageContentStateEvent.ShipmentPackageContentStateRemoved e);
        
        ShipmentPackageContentStateEvent.ShipmentPackageContentStateRemoved newShipmentPackageContentStateRemoved(String shipmentItemSeqId);

    }


}

