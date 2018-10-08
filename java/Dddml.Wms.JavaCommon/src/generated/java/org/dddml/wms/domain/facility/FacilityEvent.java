package org.dddml.wms.domain.facility;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface FacilityEvent extends Event {

    interface SqlFacilityEvent extends FacilityEvent {
        FacilityEventId getFacilityEventId();
    }

    String getFacilityId();

    //void setFacilityId(String facilityId);

    Long getVersion();
    
    //void getVersion(Long version);

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface FacilityStateEvent extends FacilityEvent {
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

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface FacilityStateCreated extends FacilityStateEvent
    {
    
    }


    interface FacilityStateMergePatched extends FacilityStateEvent
    {
        Boolean getIsPropertyFacilityTypeIdRemoved();

        void setIsPropertyFacilityTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyParentFacilityIdRemoved();

        void setIsPropertyParentFacilityIdRemoved(Boolean removed);

        Boolean getIsPropertyOwnerPartyIdRemoved();

        void setIsPropertyOwnerPartyIdRemoved(Boolean removed);

        Boolean getIsPropertyDefaultInventoryItemTypeIdRemoved();

        void setIsPropertyDefaultInventoryItemTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyFacilityNameRemoved();

        void setIsPropertyFacilityNameRemoved(Boolean removed);

        Boolean getIsPropertyPrimaryFacilityGroupIdRemoved();

        void setIsPropertyPrimaryFacilityGroupIdRemoved(Boolean removed);

        Boolean getIsPropertyOldSquareFootageRemoved();

        void setIsPropertyOldSquareFootageRemoved(Boolean removed);

        Boolean getIsPropertyFacilitySizeRemoved();

        void setIsPropertyFacilitySizeRemoved(Boolean removed);

        Boolean getIsPropertyFacilitySizeUomIdRemoved();

        void setIsPropertyFacilitySizeUomIdRemoved(Boolean removed);

        Boolean getIsPropertyProductStoreIdRemoved();

        void setIsPropertyProductStoreIdRemoved(Boolean removed);

        Boolean getIsPropertyDefaultDaysToShipRemoved();

        void setIsPropertyDefaultDaysToShipRemoved(Boolean removed);

        Boolean getIsPropertyOpenedDateRemoved();

        void setIsPropertyOpenedDateRemoved(Boolean removed);

        Boolean getIsPropertyClosedDateRemoved();

        void setIsPropertyClosedDateRemoved(Boolean removed);

        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyDefaultDimensionUomIdRemoved();

        void setIsPropertyDefaultDimensionUomIdRemoved(Boolean removed);

        Boolean getIsPropertyDefaultWeightUomIdRemoved();

        void setIsPropertyDefaultWeightUomIdRemoved(Boolean removed);

        Boolean getIsPropertyGeoPointIdRemoved();

        void setIsPropertyGeoPointIdRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }

    interface FacilityStateDeleted extends FacilityStateEvent
    {
    }


}

