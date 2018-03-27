package org.dddml.wms.domain.facility;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractFacilityStateCommandConverter<TCreateFacility extends FacilityCommand.CreateFacility, TMergePatchFacility extends FacilityCommand.MergePatchFacility, TDeleteFacility extends FacilityCommand.DeleteFacility>
{
    public FacilityCommand toCreateOrMergePatchFacility(FacilityState state)
    {
        //where TCreateFacility : ICreateFacility, new()
        //where TMergePatchFacility : IMergePatchFacility, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateFacility(state);
        }
        else 
        {
            return toMergePatchFacility(state);
        }
    }

    public TDeleteFacility toDeleteFacility(FacilityState state) //where TDeleteFacility : IDeleteFacility, new()
    {
        TDeleteFacility cmd = newDeleteFacility();
        cmd.setFacilityId(state.getFacilityId());
        cmd.setVersion(state.getVersion());

        return cmd;
    }

    public TMergePatchFacility toMergePatchFacility(FacilityState state) //where TMergePatchFacility : IMergePatchFacility, new()
    {
        TMergePatchFacility cmd = newMergePatchFacility();

        cmd.setVersion(state.getVersion());

        cmd.setFacilityId(state.getFacilityId());
        cmd.setFacilityTypeId(state.getFacilityTypeId());
        cmd.setParentFacilityId(state.getParentFacilityId());
        cmd.setOwnerPartyId(state.getOwnerPartyId());
        cmd.setDefaultInventoryItemTypeId(state.getDefaultInventoryItemTypeId());
        cmd.setFacilityName(state.getFacilityName());
        cmd.setPrimaryFacilityGroupId(state.getPrimaryFacilityGroupId());
        cmd.setOldSquareFootage(state.getOldSquareFootage());
        cmd.setFacilitySize(state.getFacilitySize());
        cmd.setFacilitySizeUomId(state.getFacilitySizeUomId());
        cmd.setProductStoreId(state.getProductStoreId());
        cmd.setDefaultDaysToShip(state.getDefaultDaysToShip());
        cmd.setOpenedDate(state.getOpenedDate());
        cmd.setClosedDate(state.getClosedDate());
        cmd.setDescription(state.getDescription());
        cmd.setDefaultDimensionUomId(state.getDefaultDimensionUomId());
        cmd.setDefaultWeightUomId(state.getDefaultWeightUomId());
        cmd.setGeoPointId(state.getGeoPointId());
        cmd.setActive(state.getActive());
            
        if (state.getFacilityTypeId() == null) { cmd.setIsPropertyFacilityTypeIdRemoved(true); }
        if (state.getParentFacilityId() == null) { cmd.setIsPropertyParentFacilityIdRemoved(true); }
        if (state.getOwnerPartyId() == null) { cmd.setIsPropertyOwnerPartyIdRemoved(true); }
        if (state.getDefaultInventoryItemTypeId() == null) { cmd.setIsPropertyDefaultInventoryItemTypeIdRemoved(true); }
        if (state.getFacilityName() == null) { cmd.setIsPropertyFacilityNameRemoved(true); }
        if (state.getPrimaryFacilityGroupId() == null) { cmd.setIsPropertyPrimaryFacilityGroupIdRemoved(true); }
        if (state.getOldSquareFootage() == null) { cmd.setIsPropertyOldSquareFootageRemoved(true); }
        if (state.getFacilitySize() == null) { cmd.setIsPropertyFacilitySizeRemoved(true); }
        if (state.getFacilitySizeUomId() == null) { cmd.setIsPropertyFacilitySizeUomIdRemoved(true); }
        if (state.getProductStoreId() == null) { cmd.setIsPropertyProductStoreIdRemoved(true); }
        if (state.getDefaultDaysToShip() == null) { cmd.setIsPropertyDefaultDaysToShipRemoved(true); }
        if (state.getOpenedDate() == null) { cmd.setIsPropertyOpenedDateRemoved(true); }
        if (state.getClosedDate() == null) { cmd.setIsPropertyClosedDateRemoved(true); }
        if (state.getDescription() == null) { cmd.setIsPropertyDescriptionRemoved(true); }
        if (state.getDefaultDimensionUomId() == null) { cmd.setIsPropertyDefaultDimensionUomIdRemoved(true); }
        if (state.getDefaultWeightUomId() == null) { cmd.setIsPropertyDefaultWeightUomIdRemoved(true); }
        if (state.getGeoPointId() == null) { cmd.setIsPropertyGeoPointIdRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        return cmd;
    }

    public TCreateFacility toCreateFacility(FacilityState state) //where TCreateFacility : ICreateFacility, new()
    {
        TCreateFacility cmd = newCreateFacility();

        cmd.setVersion(state.getVersion());
        cmd.setFacilityId(state.getFacilityId());
        cmd.setFacilityTypeId(state.getFacilityTypeId());
        cmd.setParentFacilityId(state.getParentFacilityId());
        cmd.setOwnerPartyId(state.getOwnerPartyId());
        cmd.setDefaultInventoryItemTypeId(state.getDefaultInventoryItemTypeId());
        cmd.setFacilityName(state.getFacilityName());
        cmd.setPrimaryFacilityGroupId(state.getPrimaryFacilityGroupId());
        cmd.setOldSquareFootage(state.getOldSquareFootage());
        cmd.setFacilitySize(state.getFacilitySize());
        cmd.setFacilitySizeUomId(state.getFacilitySizeUomId());
        cmd.setProductStoreId(state.getProductStoreId());
        cmd.setDefaultDaysToShip(state.getDefaultDaysToShip());
        cmd.setOpenedDate(state.getOpenedDate());
        cmd.setClosedDate(state.getClosedDate());
        cmd.setDescription(state.getDescription());
        cmd.setDefaultDimensionUomId(state.getDefaultDimensionUomId());
        cmd.setDefaultWeightUomId(state.getDefaultWeightUomId());
        cmd.setGeoPointId(state.getGeoPointId());
        cmd.setActive(state.getActive());
        return cmd;
    }

    protected abstract TCreateFacility newCreateFacility();

    protected abstract TMergePatchFacility newMergePatchFacility(); 

    protected abstract TDeleteFacility newDeleteFacility();

    public static class SimpleFacilityStateCommandConverter extends AbstractFacilityStateCommandConverter<AbstractFacilityCommand.SimpleCreateFacility, AbstractFacilityCommand.SimpleMergePatchFacility, AbstractFacilityCommand.SimpleDeleteFacility>
    {
        @Override
        protected AbstractFacilityCommand.SimpleCreateFacility newCreateFacility() {
            return new AbstractFacilityCommand.SimpleCreateFacility();
        }

        @Override
        protected AbstractFacilityCommand.SimpleMergePatchFacility newMergePatchFacility() {
            return new AbstractFacilityCommand.SimpleMergePatchFacility();
        }

        @Override
        protected AbstractFacilityCommand.SimpleDeleteFacility newDeleteFacility() {
            return new AbstractFacilityCommand.SimpleDeleteFacility();
        }


    }

}

