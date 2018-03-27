package org.dddml.wms.domain.shipmentpackagecontentmvo;

import java.util.Set;
import org.dddml.wms.domain.shipmentpackage.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.shipmentpackagecontentmvo.ShipmentPackageContentMvoStateEvent.*;

public interface ShipmentPackageContentMvoState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    ShipmentPackageContentId getShipmentPackageContentId();

    void setShipmentPackageContentId(ShipmentPackageContentId shipmentPackageContentId);

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

    String getUpdatedBy();

    void setUpdatedBy(String updatedBy);

    Date getUpdatedAt();

    void setUpdatedAt(Date updatedAt);

    Boolean getActive();

    void setActive(Boolean active);

    Boolean getDeleted();

    void setDeleted(Boolean deleted);

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

    Long getShipmentPackageVersion();

    void setShipmentPackageVersion(Long shipmentPackageVersion);

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


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(ShipmentPackageContentMvoStateEvent.ShipmentPackageContentMvoStateCreated e);

    void when(ShipmentPackageContentMvoStateEvent.ShipmentPackageContentMvoStateMergePatched e);

    void when(ShipmentPackageContentMvoStateEvent.ShipmentPackageContentMvoStateDeleted e);
    
}

