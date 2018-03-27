package org.dddml.wms.domain.shipmentpackage;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractShipmentPackageStateCommandConverter<TCreateShipmentPackage extends ShipmentPackageCommand.CreateShipmentPackage, TMergePatchShipmentPackage extends ShipmentPackageCommand.MergePatchShipmentPackage, TDeleteShipmentPackage extends ShipmentPackageCommand.DeleteShipmentPackage, TCreateShipmentPackageContent extends ShipmentPackageContentCommand.CreateShipmentPackageContent, TMergePatchShipmentPackageContent extends ShipmentPackageContentCommand.MergePatchShipmentPackageContent, TRemoveShipmentPackageContent extends ShipmentPackageContentCommand.RemoveShipmentPackageContent>
{
    public ShipmentPackageCommand toCreateOrMergePatchShipmentPackage(ShipmentPackageState state)
    {
        //where TCreateShipmentPackage : ICreateShipmentPackage, new()
        //where TMergePatchShipmentPackage : IMergePatchShipmentPackage, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateShipmentPackage(state);
        }
        else 
        {
            return toMergePatchShipmentPackage(state);
        }
    }

    public TDeleteShipmentPackage toDeleteShipmentPackage(ShipmentPackageState state) //where TDeleteShipmentPackage : IDeleteShipmentPackage, new()
    {
        TDeleteShipmentPackage cmd = newDeleteShipmentPackage();
        cmd.setShipmentPackageId(state.getShipmentPackageId());
        cmd.setVersion(state.getVersion());

        return cmd;
    }

    public TMergePatchShipmentPackage toMergePatchShipmentPackage(ShipmentPackageState state) //where TMergePatchShipmentPackage : IMergePatchShipmentPackage, new()
    {
        TMergePatchShipmentPackage cmd = newMergePatchShipmentPackage();

        cmd.setVersion(state.getVersion());

        cmd.setShipmentPackageId(state.getShipmentPackageId());
        cmd.setShipmentBoxTypeId(state.getShipmentBoxTypeId());
        cmd.setDateCreated(state.getDateCreated());
        cmd.setBoxLength(state.getBoxLength());
        cmd.setBoxHeight(state.getBoxHeight());
        cmd.setBoxWidth(state.getBoxWidth());
        cmd.setDimensionUomId(state.getDimensionUomId());
        cmd.setWeight(state.getWeight());
        cmd.setWeightUomId(state.getWeightUomId());
        cmd.setInsuredValue(state.getInsuredValue());
        cmd.setActive(state.getActive());
            
        if (state.getShipmentBoxTypeId() == null) { cmd.setIsPropertyShipmentBoxTypeIdRemoved(true); }
        if (state.getDateCreated() == null) { cmd.setIsPropertyDateCreatedRemoved(true); }
        if (state.getBoxLength() == null) { cmd.setIsPropertyBoxLengthRemoved(true); }
        if (state.getBoxHeight() == null) { cmd.setIsPropertyBoxHeightRemoved(true); }
        if (state.getBoxWidth() == null) { cmd.setIsPropertyBoxWidthRemoved(true); }
        if (state.getDimensionUomId() == null) { cmd.setIsPropertyDimensionUomIdRemoved(true); }
        if (state.getWeight() == null) { cmd.setIsPropertyWeightRemoved(true); }
        if (state.getWeightUomId() == null) { cmd.setIsPropertyWeightUomIdRemoved(true); }
        if (state.getInsuredValue() == null) { cmd.setIsPropertyInsuredValueRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        for (ShipmentPackageContentState d : state.getShipmentPackageContents())
        {
            ShipmentPackageContentCommand c = getShipmentPackageContentStateCommandConverter().toCreateOrMergePatchShipmentPackageContent(d);
            cmd.getShipmentPackageContentCommands().add(c);
        }
        return cmd;
    }

    public TCreateShipmentPackage toCreateShipmentPackage(ShipmentPackageState state) //where TCreateShipmentPackage : ICreateShipmentPackage, new()
    {
        TCreateShipmentPackage cmd = newCreateShipmentPackage();

        cmd.setVersion(state.getVersion());
        cmd.setShipmentPackageId(state.getShipmentPackageId());
        cmd.setShipmentBoxTypeId(state.getShipmentBoxTypeId());
        cmd.setDateCreated(state.getDateCreated());
        cmd.setBoxLength(state.getBoxLength());
        cmd.setBoxHeight(state.getBoxHeight());
        cmd.setBoxWidth(state.getBoxWidth());
        cmd.setDimensionUomId(state.getDimensionUomId());
        cmd.setWeight(state.getWeight());
        cmd.setWeightUomId(state.getWeightUomId());
        cmd.setInsuredValue(state.getInsuredValue());
        cmd.setActive(state.getActive());
        for (ShipmentPackageContentState d : state.getShipmentPackageContents())
        {
            ShipmentPackageContentCommand.CreateShipmentPackageContent c = getShipmentPackageContentStateCommandConverter().toCreateShipmentPackageContent(d);
            cmd.getShipmentPackageContents().add(c);
        }
        return cmd;
    }

    protected abstract AbstractShipmentPackageContentStateCommandConverter<TCreateShipmentPackageContent, TMergePatchShipmentPackageContent, TRemoveShipmentPackageContent>
        getShipmentPackageContentStateCommandConverter();

    protected abstract TCreateShipmentPackage newCreateShipmentPackage();

    protected abstract TMergePatchShipmentPackage newMergePatchShipmentPackage(); 

    protected abstract TDeleteShipmentPackage newDeleteShipmentPackage();

    public static class SimpleShipmentPackageStateCommandConverter extends AbstractShipmentPackageStateCommandConverter<AbstractShipmentPackageCommand.SimpleCreateShipmentPackage, AbstractShipmentPackageCommand.SimpleMergePatchShipmentPackage, AbstractShipmentPackageCommand.SimpleDeleteShipmentPackage, AbstractShipmentPackageContentCommand.SimpleCreateShipmentPackageContent, AbstractShipmentPackageContentCommand.SimpleMergePatchShipmentPackageContent, AbstractShipmentPackageContentCommand.SimpleRemoveShipmentPackageContent>
    {
        @Override
        protected AbstractShipmentPackageCommand.SimpleCreateShipmentPackage newCreateShipmentPackage() {
            return new AbstractShipmentPackageCommand.SimpleCreateShipmentPackage();
        }

        @Override
        protected AbstractShipmentPackageCommand.SimpleMergePatchShipmentPackage newMergePatchShipmentPackage() {
            return new AbstractShipmentPackageCommand.SimpleMergePatchShipmentPackage();
        }

        @Override
        protected AbstractShipmentPackageCommand.SimpleDeleteShipmentPackage newDeleteShipmentPackage() {
            return new AbstractShipmentPackageCommand.SimpleDeleteShipmentPackage();
        }

        @Override
        protected AbstractShipmentPackageContentStateCommandConverter<AbstractShipmentPackageContentCommand.SimpleCreateShipmentPackageContent, AbstractShipmentPackageContentCommand.SimpleMergePatchShipmentPackageContent, AbstractShipmentPackageContentCommand.SimpleRemoveShipmentPackageContent> getShipmentPackageContentStateCommandConverter()
        {
            return new AbstractShipmentPackageContentStateCommandConverter.SimpleShipmentPackageContentStateCommandConverter();
        }


    }

}

