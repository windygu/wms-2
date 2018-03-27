package org.dddml.wms.domain.facility;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.facility.FacilityStateEvent.*;

public interface FacilityState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getFacilityId();

    void setFacilityId(String facilityId);

    String getFacilityTypeId();

    void setFacilityTypeId(String facilityTypeId);

    String getParentFacilityId();

    void setParentFacilityId(String parentFacilityId);

    String getOwnerPartyId();

    void setOwnerPartyId(String ownerPartyId);

    String getDefaultInventoryItemTypeId();

    void setDefaultInventoryItemTypeId(String defaultInventoryItemTypeId);

    String getFacilityName();

    void setFacilityName(String facilityName);

    String getPrimaryFacilityGroupId();

    void setPrimaryFacilityGroupId(String primaryFacilityGroupId);

    Long getOldSquareFootage();

    void setOldSquareFootage(Long oldSquareFootage);

    java.math.BigDecimal getFacilitySize();

    void setFacilitySize(java.math.BigDecimal facilitySize);

    String getFacilitySizeUomId();

    void setFacilitySizeUomId(String facilitySizeUomId);

    String getProductStoreId();

    void setProductStoreId(String productStoreId);

    Long getDefaultDaysToShip();

    void setDefaultDaysToShip(Long defaultDaysToShip);

    java.sql.Timestamp getOpenedDate();

    void setOpenedDate(java.sql.Timestamp openedDate);

    java.sql.Timestamp getClosedDate();

    void setClosedDate(java.sql.Timestamp closedDate);

    String getDescription();

    void setDescription(String description);

    String getDefaultDimensionUomId();

    void setDefaultDimensionUomId(String defaultDimensionUomId);

    String getDefaultWeightUomId();

    void setDefaultWeightUomId(String defaultWeightUomId);

    String getGeoPointId();

    void setGeoPointId(String geoPointId);

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


    void mutate(Event e);

    void when(FacilityStateEvent.FacilityStateCreated e);

    void when(FacilityStateEvent.FacilityStateMergePatched e);

    void when(FacilityStateEvent.FacilityStateDeleted e);
    
}

