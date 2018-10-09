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

    String getShipmentBoxTypeId();

    java.sql.Timestamp getDateCreated();

    java.math.BigDecimal getBoxLength();

    java.math.BigDecimal getBoxHeight();

    java.math.BigDecimal getBoxWidth();

    String getDimensionUomId();

    java.math.BigDecimal getWeight();

    String getWeightUomId();

    java.math.BigDecimal getInsuredValue();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    Boolean getDeleted();

    EntityStateCollection<String, ShipmentPackageContentState> getShipmentPackageContents();

    interface MutableShipmentPackageState extends ShipmentPackageState {
        void setShipmentPackageId(ShipmentPackageId shipmentPackageId);

        void setShipmentBoxTypeId(String shipmentBoxTypeId);

        void setDateCreated(java.sql.Timestamp dateCreated);

        void setBoxLength(java.math.BigDecimal boxLength);

        void setBoxHeight(java.math.BigDecimal boxHeight);

        void setBoxWidth(java.math.BigDecimal boxWidth);

        void setDimensionUomId(String dimensionUomId);

        void setWeight(java.math.BigDecimal weight);

        void setWeightUomId(String weightUomId);

        void setInsuredValue(java.math.BigDecimal insuredValue);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setDeleted(Boolean deleted);


        void mutate(Event e);

        void when(ShipmentPackageEvent.ShipmentPackageStateCreated e);

        void when(ShipmentPackageEvent.ShipmentPackageStateMergePatched e);

        void when(ShipmentPackageEvent.ShipmentPackageStateDeleted e);
    }

    interface SqlShipmentPackageState extends MutableShipmentPackageState {

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

