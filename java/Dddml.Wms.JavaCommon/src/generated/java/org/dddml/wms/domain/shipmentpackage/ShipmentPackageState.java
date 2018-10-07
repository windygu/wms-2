package org.dddml.wms.domain.shipmentpackage;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.shipmentpackage.ShipmentPackageEvent.*;

public interface ShipmentPackageState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    ShipmentPackageId getShipmentPackageId();

    void setShipmentPackageId(ShipmentPackageId shipmentPackageId);

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


    boolean isStateUnsaved();

    boolean getForReapplying();

    EntityStateCollection<String, ShipmentPackageContentState> getShipmentPackageContents();


    void mutate(Event e);

    void when(ShipmentPackageEvent.ShipmentPackageStateCreated e);

    void when(ShipmentPackageEvent.ShipmentPackageStateMergePatched e);

    void when(ShipmentPackageEvent.ShipmentPackageStateDeleted e);
    
}

