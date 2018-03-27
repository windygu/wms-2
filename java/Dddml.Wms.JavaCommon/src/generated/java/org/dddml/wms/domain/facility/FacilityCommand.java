package org.dddml.wms.domain.facility;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface FacilityCommand extends Command
{
    String getFacilityId();

    void setFacilityId(String facilityId);

    Long getVersion();

    void setVersion(Long version);

    static void throwOnInvalidStateTransition(FacilityState state, Command c) {
        if (state.getVersion() == null)
        {
            if (isCommandCreate((FacilityCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (state.getDeleted())
        {
            throw DomainError.named("zombie", "Can't do anything to deleted aggregate.");
        }
        if (isCommandCreate((FacilityCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(FacilityCommand c) {
        return ((c instanceof FacilityCommand.CreateFacility) 
            && c.getVersion().equals(FacilityState.VERSION_NULL));
    }

    interface CreateOrMergePatchFacility extends FacilityCommand
    {
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

    interface CreateFacility extends CreateOrMergePatchFacility
    {
    }

    interface MergePatchFacility extends CreateOrMergePatchFacility
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

	interface DeleteFacility extends FacilityCommand
	{
	}

}

