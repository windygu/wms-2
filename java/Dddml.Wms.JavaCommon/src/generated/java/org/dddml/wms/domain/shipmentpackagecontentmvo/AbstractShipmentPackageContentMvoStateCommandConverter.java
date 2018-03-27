package org.dddml.wms.domain.shipmentpackagecontentmvo;

import java.util.*;
import org.dddml.wms.domain.shipmentpackage.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractShipmentPackageContentMvoStateCommandConverter<TCreateShipmentPackageContentMvo extends ShipmentPackageContentMvoCommand.CreateShipmentPackageContentMvo, TMergePatchShipmentPackageContentMvo extends ShipmentPackageContentMvoCommand.MergePatchShipmentPackageContentMvo, TDeleteShipmentPackageContentMvo extends ShipmentPackageContentMvoCommand.DeleteShipmentPackageContentMvo>
{
    public ShipmentPackageContentMvoCommand toCreateOrMergePatchShipmentPackageContentMvo(ShipmentPackageContentMvoState state)
    {
        //where TCreateShipmentPackageContentMvo : ICreateShipmentPackageContentMvo, new()
        //where TMergePatchShipmentPackageContentMvo : IMergePatchShipmentPackageContentMvo, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateShipmentPackageContentMvo(state);
        }
        else 
        {
            return toMergePatchShipmentPackageContentMvo(state);
        }
    }

    public TDeleteShipmentPackageContentMvo toDeleteShipmentPackageContentMvo(ShipmentPackageContentMvoState state) //where TDeleteShipmentPackageContentMvo : IDeleteShipmentPackageContentMvo, new()
    {
        TDeleteShipmentPackageContentMvo cmd = newDeleteShipmentPackageContentMvo();
        cmd.setShipmentPackageContentId(state.getShipmentPackageContentId());
        cmd.setShipmentPackageVersion(state.getShipmentPackageVersion());

        return cmd;
    }

    public TMergePatchShipmentPackageContentMvo toMergePatchShipmentPackageContentMvo(ShipmentPackageContentMvoState state) //where TMergePatchShipmentPackageContentMvo : IMergePatchShipmentPackageContentMvo, new()
    {
        TMergePatchShipmentPackageContentMvo cmd = newMergePatchShipmentPackageContentMvo();

        cmd.setShipmentPackageVersion(state.getShipmentPackageVersion());

        cmd.setShipmentPackageContentId(state.getShipmentPackageContentId());
        cmd.setQuantity(state.getQuantity());
        cmd.setSubProductId(state.getSubProductId());
        cmd.setSubProductQuantity(state.getSubProductQuantity());
        cmd.setVersion(state.getVersion());
        cmd.setActive(state.getActive());
        cmd.setShipmentPackageShipmentBoxTypeId(state.getShipmentPackageShipmentBoxTypeId());
        cmd.setShipmentPackageDateCreated(state.getShipmentPackageDateCreated());
        cmd.setShipmentPackageBoxLength(state.getShipmentPackageBoxLength());
        cmd.setShipmentPackageBoxHeight(state.getShipmentPackageBoxHeight());
        cmd.setShipmentPackageBoxWidth(state.getShipmentPackageBoxWidth());
        cmd.setShipmentPackageDimensionUomId(state.getShipmentPackageDimensionUomId());
        cmd.setShipmentPackageWeight(state.getShipmentPackageWeight());
        cmd.setShipmentPackageWeightUomId(state.getShipmentPackageWeightUomId());
        cmd.setShipmentPackageInsuredValue(state.getShipmentPackageInsuredValue());
        cmd.setShipmentPackageCreatedBy(state.getShipmentPackageCreatedBy());
        cmd.setShipmentPackageCreatedAt(state.getShipmentPackageCreatedAt());
        cmd.setShipmentPackageUpdatedBy(state.getShipmentPackageUpdatedBy());
        cmd.setShipmentPackageUpdatedAt(state.getShipmentPackageUpdatedAt());
        cmd.setShipmentPackageActive(state.getShipmentPackageActive());
        cmd.setShipmentPackageDeleted(state.getShipmentPackageDeleted());
            
        if (state.getQuantity() == null) { cmd.setIsPropertyQuantityRemoved(true); }
        if (state.getSubProductId() == null) { cmd.setIsPropertySubProductIdRemoved(true); }
        if (state.getSubProductQuantity() == null) { cmd.setIsPropertySubProductQuantityRemoved(true); }
        if (state.getVersion() == null) { cmd.setIsPropertyVersionRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        if (state.getShipmentPackageShipmentBoxTypeId() == null) { cmd.setIsPropertyShipmentPackageShipmentBoxTypeIdRemoved(true); }
        if (state.getShipmentPackageDateCreated() == null) { cmd.setIsPropertyShipmentPackageDateCreatedRemoved(true); }
        if (state.getShipmentPackageBoxLength() == null) { cmd.setIsPropertyShipmentPackageBoxLengthRemoved(true); }
        if (state.getShipmentPackageBoxHeight() == null) { cmd.setIsPropertyShipmentPackageBoxHeightRemoved(true); }
        if (state.getShipmentPackageBoxWidth() == null) { cmd.setIsPropertyShipmentPackageBoxWidthRemoved(true); }
        if (state.getShipmentPackageDimensionUomId() == null) { cmd.setIsPropertyShipmentPackageDimensionUomIdRemoved(true); }
        if (state.getShipmentPackageWeight() == null) { cmd.setIsPropertyShipmentPackageWeightRemoved(true); }
        if (state.getShipmentPackageWeightUomId() == null) { cmd.setIsPropertyShipmentPackageWeightUomIdRemoved(true); }
        if (state.getShipmentPackageInsuredValue() == null) { cmd.setIsPropertyShipmentPackageInsuredValueRemoved(true); }
        if (state.getShipmentPackageCreatedBy() == null) { cmd.setIsPropertyShipmentPackageCreatedByRemoved(true); }
        if (state.getShipmentPackageCreatedAt() == null) { cmd.setIsPropertyShipmentPackageCreatedAtRemoved(true); }
        if (state.getShipmentPackageUpdatedBy() == null) { cmd.setIsPropertyShipmentPackageUpdatedByRemoved(true); }
        if (state.getShipmentPackageUpdatedAt() == null) { cmd.setIsPropertyShipmentPackageUpdatedAtRemoved(true); }
        if (state.getShipmentPackageActive() == null) { cmd.setIsPropertyShipmentPackageActiveRemoved(true); }
        if (state.getShipmentPackageDeleted() == null) { cmd.setIsPropertyShipmentPackageDeletedRemoved(true); }
        return cmd;
    }

    public TCreateShipmentPackageContentMvo toCreateShipmentPackageContentMvo(ShipmentPackageContentMvoState state) //where TCreateShipmentPackageContentMvo : ICreateShipmentPackageContentMvo, new()
    {
        TCreateShipmentPackageContentMvo cmd = newCreateShipmentPackageContentMvo();

        cmd.setShipmentPackageVersion(state.getShipmentPackageVersion());
        cmd.setShipmentPackageContentId(state.getShipmentPackageContentId());
        cmd.setQuantity(state.getQuantity());
        cmd.setSubProductId(state.getSubProductId());
        cmd.setSubProductQuantity(state.getSubProductQuantity());
        cmd.setVersion(state.getVersion());
        cmd.setActive(state.getActive());
        cmd.setShipmentPackageShipmentBoxTypeId(state.getShipmentPackageShipmentBoxTypeId());
        cmd.setShipmentPackageDateCreated(state.getShipmentPackageDateCreated());
        cmd.setShipmentPackageBoxLength(state.getShipmentPackageBoxLength());
        cmd.setShipmentPackageBoxHeight(state.getShipmentPackageBoxHeight());
        cmd.setShipmentPackageBoxWidth(state.getShipmentPackageBoxWidth());
        cmd.setShipmentPackageDimensionUomId(state.getShipmentPackageDimensionUomId());
        cmd.setShipmentPackageWeight(state.getShipmentPackageWeight());
        cmd.setShipmentPackageWeightUomId(state.getShipmentPackageWeightUomId());
        cmd.setShipmentPackageInsuredValue(state.getShipmentPackageInsuredValue());
        cmd.setShipmentPackageCreatedBy(state.getShipmentPackageCreatedBy());
        cmd.setShipmentPackageCreatedAt(state.getShipmentPackageCreatedAt());
        cmd.setShipmentPackageUpdatedBy(state.getShipmentPackageUpdatedBy());
        cmd.setShipmentPackageUpdatedAt(state.getShipmentPackageUpdatedAt());
        cmd.setShipmentPackageActive(state.getShipmentPackageActive());
        cmd.setShipmentPackageDeleted(state.getShipmentPackageDeleted());
        return cmd;
    }

    protected abstract TCreateShipmentPackageContentMvo newCreateShipmentPackageContentMvo();

    protected abstract TMergePatchShipmentPackageContentMvo newMergePatchShipmentPackageContentMvo(); 

    protected abstract TDeleteShipmentPackageContentMvo newDeleteShipmentPackageContentMvo();

    public static class SimpleShipmentPackageContentMvoStateCommandConverter extends AbstractShipmentPackageContentMvoStateCommandConverter<AbstractShipmentPackageContentMvoCommand.SimpleCreateShipmentPackageContentMvo, AbstractShipmentPackageContentMvoCommand.SimpleMergePatchShipmentPackageContentMvo, AbstractShipmentPackageContentMvoCommand.SimpleDeleteShipmentPackageContentMvo>
    {
        @Override
        protected AbstractShipmentPackageContentMvoCommand.SimpleCreateShipmentPackageContentMvo newCreateShipmentPackageContentMvo() {
            return new AbstractShipmentPackageContentMvoCommand.SimpleCreateShipmentPackageContentMvo();
        }

        @Override
        protected AbstractShipmentPackageContentMvoCommand.SimpleMergePatchShipmentPackageContentMvo newMergePatchShipmentPackageContentMvo() {
            return new AbstractShipmentPackageContentMvoCommand.SimpleMergePatchShipmentPackageContentMvo();
        }

        @Override
        protected AbstractShipmentPackageContentMvoCommand.SimpleDeleteShipmentPackageContentMvo newDeleteShipmentPackageContentMvo() {
            return new AbstractShipmentPackageContentMvoCommand.SimpleDeleteShipmentPackageContentMvo();
        }


    }

}

