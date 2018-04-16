package org.dddml.wms.domain.facility;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class FacilityStateEventDtoConverter {

    public FacilityStateEventDto toFacilityStateEventDto(AbstractFacilityEvent stateEvent) {
        if (stateEvent instanceof AbstractFacilityEvent.AbstractFacilityStateCreated) {
            FacilityEvent.FacilityStateCreated e = (FacilityEvent.FacilityStateCreated) stateEvent;
            return toFacilityStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractFacilityEvent.AbstractFacilityStateMergePatched) {
            FacilityEvent.FacilityStateMergePatched e = (FacilityEvent.FacilityStateMergePatched) stateEvent;
            return toFacilityStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractFacilityEvent.AbstractFacilityStateDeleted) {
            FacilityEvent.FacilityStateDeleted e = (FacilityEvent.FacilityStateDeleted) stateEvent;
            return toFacilityStateDeletedDto(e);
        }

        throw DomainError.named("invalidEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public FacilityStateEventDto.FacilityStateCreatedDto toFacilityStateCreatedDto(FacilityEvent.FacilityStateCreated e) {
        FacilityStateEventDto.FacilityStateCreatedDto dto = new FacilityStateEventDto.FacilityStateCreatedDto();
        dto.setFacilityEventId(e.getFacilityEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setFacilityTypeId(e.getFacilityTypeId());
        dto.setParentFacilityId(e.getParentFacilityId());
        dto.setOwnerPartyId(e.getOwnerPartyId());
        dto.setDefaultInventoryItemTypeId(e.getDefaultInventoryItemTypeId());
        dto.setFacilityName(e.getFacilityName());
        dto.setPrimaryFacilityGroupId(e.getPrimaryFacilityGroupId());
        dto.setOldSquareFootage(e.getOldSquareFootage());
        dto.setFacilitySize(e.getFacilitySize());
        dto.setFacilitySizeUomId(e.getFacilitySizeUomId());
        dto.setProductStoreId(e.getProductStoreId());
        dto.setDefaultDaysToShip(e.getDefaultDaysToShip());
        dto.setOpenedDate(e.getOpenedDate());
        dto.setClosedDate(e.getClosedDate());
        dto.setDescription(e.getDescription());
        dto.setDefaultDimensionUomId(e.getDefaultDimensionUomId());
        dto.setDefaultWeightUomId(e.getDefaultWeightUomId());
        dto.setGeoPointId(e.getGeoPointId());
        dto.setActive(e.getActive());
        return dto;
    }

    public FacilityStateEventDto.FacilityStateMergePatchedDto toFacilityStateMergePatchedDto(FacilityEvent.FacilityStateMergePatched e) {
        FacilityStateEventDto.FacilityStateMergePatchedDto dto = new FacilityStateEventDto.FacilityStateMergePatchedDto();
        dto.setFacilityEventId(e.getFacilityEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setFacilityTypeId(e.getFacilityTypeId());
        dto.setParentFacilityId(e.getParentFacilityId());
        dto.setOwnerPartyId(e.getOwnerPartyId());
        dto.setDefaultInventoryItemTypeId(e.getDefaultInventoryItemTypeId());
        dto.setFacilityName(e.getFacilityName());
        dto.setPrimaryFacilityGroupId(e.getPrimaryFacilityGroupId());
        dto.setOldSquareFootage(e.getOldSquareFootage());
        dto.setFacilitySize(e.getFacilitySize());
        dto.setFacilitySizeUomId(e.getFacilitySizeUomId());
        dto.setProductStoreId(e.getProductStoreId());
        dto.setDefaultDaysToShip(e.getDefaultDaysToShip());
        dto.setOpenedDate(e.getOpenedDate());
        dto.setClosedDate(e.getClosedDate());
        dto.setDescription(e.getDescription());
        dto.setDefaultDimensionUomId(e.getDefaultDimensionUomId());
        dto.setDefaultWeightUomId(e.getDefaultWeightUomId());
        dto.setGeoPointId(e.getGeoPointId());
        dto.setActive(e.getActive());
        dto.setIsPropertyFacilityTypeIdRemoved(e.getIsPropertyFacilityTypeIdRemoved());
        dto.setIsPropertyParentFacilityIdRemoved(e.getIsPropertyParentFacilityIdRemoved());
        dto.setIsPropertyOwnerPartyIdRemoved(e.getIsPropertyOwnerPartyIdRemoved());
        dto.setIsPropertyDefaultInventoryItemTypeIdRemoved(e.getIsPropertyDefaultInventoryItemTypeIdRemoved());
        dto.setIsPropertyFacilityNameRemoved(e.getIsPropertyFacilityNameRemoved());
        dto.setIsPropertyPrimaryFacilityGroupIdRemoved(e.getIsPropertyPrimaryFacilityGroupIdRemoved());
        dto.setIsPropertyOldSquareFootageRemoved(e.getIsPropertyOldSquareFootageRemoved());
        dto.setIsPropertyFacilitySizeRemoved(e.getIsPropertyFacilitySizeRemoved());
        dto.setIsPropertyFacilitySizeUomIdRemoved(e.getIsPropertyFacilitySizeUomIdRemoved());
        dto.setIsPropertyProductStoreIdRemoved(e.getIsPropertyProductStoreIdRemoved());
        dto.setIsPropertyDefaultDaysToShipRemoved(e.getIsPropertyDefaultDaysToShipRemoved());
        dto.setIsPropertyOpenedDateRemoved(e.getIsPropertyOpenedDateRemoved());
        dto.setIsPropertyClosedDateRemoved(e.getIsPropertyClosedDateRemoved());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        dto.setIsPropertyDefaultDimensionUomIdRemoved(e.getIsPropertyDefaultDimensionUomIdRemoved());
        dto.setIsPropertyDefaultWeightUomIdRemoved(e.getIsPropertyDefaultWeightUomIdRemoved());
        dto.setIsPropertyGeoPointIdRemoved(e.getIsPropertyGeoPointIdRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public FacilityStateEventDto.FacilityStateDeletedDto toFacilityStateDeletedDto(FacilityEvent.FacilityStateDeleted e) {
        FacilityStateEventDto.FacilityStateDeletedDto dto = new FacilityStateEventDto.FacilityStateDeletedDto();
        dto.setFacilityEventId(e.getFacilityEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

