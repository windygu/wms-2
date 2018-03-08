package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface ShipmentReceiptStateEvent extends Event
{
    ShipmentReceiptEventId getStateEventId();

    boolean getStateEventReadOnly();

    void setStateEventReadOnly(boolean readOnly);

    Long getVersion();

    void setVersion(Long version);

    String getProductId();

    void setProductId(String productId);

    String getAttributeSetInstanceId();

    void setAttributeSetInstanceId(String attributeSetInstanceId);

    String getShipmentItemSeqId();

    void setShipmentItemSeqId(String shipmentItemSeqId);

    String getRejectionReasonId();

    void setRejectionReasonId(String rejectionReasonId);

    String getDamageStatusId();

    void setDamageStatusId(String damageStatusId);

    String getDamageReasonId();

    void setDamageReasonId(String damageReasonId);

    String getReceivedBy();

    void setReceivedBy(String receivedBy);

    java.sql.Timestamp getDatetimeReceived();

    void setDatetimeReceived(java.sql.Timestamp datetimeReceived);

    String getItemDescription();

    void setItemDescription(String itemDescription);

    java.math.BigDecimal getAcceptedQuantity();

    void setAcceptedQuantity(java.math.BigDecimal acceptedQuantity);

    java.math.BigDecimal getRejectedQuantity();

    void setRejectedQuantity(java.math.BigDecimal rejectedQuantity);

    java.math.BigDecimal getDamagedQuantity();

    void setDamagedQuantity(java.math.BigDecimal damagedQuantity);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    Boolean getActive();

    void setActive(Boolean active);

    String getCommandId();

    void setCommandId(String commandId);

    interface ShipmentReceiptStateCreated extends ShipmentReceiptStateEvent
    {
    
    }


    interface ShipmentReceiptStateMergePatched extends ShipmentReceiptStateEvent
    {
        Boolean getIsPropertyProductIdRemoved();

        void setIsPropertyProductIdRemoved(Boolean removed);

        Boolean getIsPropertyAttributeSetInstanceIdRemoved();

        void setIsPropertyAttributeSetInstanceIdRemoved(Boolean removed);

        Boolean getIsPropertyShipmentItemSeqIdRemoved();

        void setIsPropertyShipmentItemSeqIdRemoved(Boolean removed);

        Boolean getIsPropertyRejectionReasonIdRemoved();

        void setIsPropertyRejectionReasonIdRemoved(Boolean removed);

        Boolean getIsPropertyDamageStatusIdRemoved();

        void setIsPropertyDamageStatusIdRemoved(Boolean removed);

        Boolean getIsPropertyDamageReasonIdRemoved();

        void setIsPropertyDamageReasonIdRemoved(Boolean removed);

        Boolean getIsPropertyReceivedByRemoved();

        void setIsPropertyReceivedByRemoved(Boolean removed);

        Boolean getIsPropertyDatetimeReceivedRemoved();

        void setIsPropertyDatetimeReceivedRemoved(Boolean removed);

        Boolean getIsPropertyItemDescriptionRemoved();

        void setIsPropertyItemDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyAcceptedQuantityRemoved();

        void setIsPropertyAcceptedQuantityRemoved(Boolean removed);

        Boolean getIsPropertyRejectedQuantityRemoved();

        void setIsPropertyRejectedQuantityRemoved(Boolean removed);

        Boolean getIsPropertyDamagedQuantityRemoved();

        void setIsPropertyDamagedQuantityRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }


}

