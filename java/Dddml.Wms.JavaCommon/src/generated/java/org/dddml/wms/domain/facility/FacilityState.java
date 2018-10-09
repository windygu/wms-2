package org.dddml.wms.domain.facility;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.facility.FacilityEvent.*;

public interface FacilityState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getFacilityId();

    String getFacilityTypeId();

    String getParentFacilityId();

    String getOwnerPartyId();

    String getDefaultInventoryItemTypeId();

    String getFacilityName();

    String getPrimaryFacilityGroupId();

    Long getOldSquareFootage();

    java.math.BigDecimal getFacilitySize();

    String getFacilitySizeUomId();

    String getProductStoreId();

    Long getDefaultDaysToShip();

    java.sql.Timestamp getOpenedDate();

    java.sql.Timestamp getClosedDate();

    String getDescription();

    String getDefaultDimensionUomId();

    String getDefaultWeightUomId();

    String getGeoPointId();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    Boolean getDeleted();

    interface MutableFacilityState extends FacilityState {
        void setFacilityId(String facilityId);

        void setFacilityTypeId(String facilityTypeId);

        void setParentFacilityId(String parentFacilityId);

        void setOwnerPartyId(String ownerPartyId);

        void setDefaultInventoryItemTypeId(String defaultInventoryItemTypeId);

        void setFacilityName(String facilityName);

        void setPrimaryFacilityGroupId(String primaryFacilityGroupId);

        void setOldSquareFootage(Long oldSquareFootage);

        void setFacilitySize(java.math.BigDecimal facilitySize);

        void setFacilitySizeUomId(String facilitySizeUomId);

        void setProductStoreId(String productStoreId);

        void setDefaultDaysToShip(Long defaultDaysToShip);

        void setOpenedDate(java.sql.Timestamp openedDate);

        void setClosedDate(java.sql.Timestamp closedDate);

        void setDescription(String description);

        void setDefaultDimensionUomId(String defaultDimensionUomId);

        void setDefaultWeightUomId(String defaultWeightUomId);

        void setGeoPointId(String geoPointId);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setDeleted(Boolean deleted);


        void mutate(Event e);

        void when(FacilityEvent.FacilityStateCreated e);

        void when(FacilityEvent.FacilityStateMergePatched e);

        void when(FacilityEvent.FacilityStateDeleted e);
    }

    interface SqlFacilityState extends MutableFacilityState {

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

