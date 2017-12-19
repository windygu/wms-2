package org.dddml.wms.domain.shipmenttype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractShipmentTypeStateCommandConverter<TCreateShipmentType extends ShipmentTypeCommand.CreateShipmentType, TMergePatchShipmentType extends ShipmentTypeCommand.MergePatchShipmentType, TDeleteShipmentType extends ShipmentTypeCommand.DeleteShipmentType>
{
    public ShipmentTypeCommand toCreateOrMergePatchShipmentType(ShipmentTypeState state)
    {
        //where TCreateShipmentType : ICreateShipmentType, new()
        //where TMergePatchShipmentType : IMergePatchShipmentType, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateShipmentType(state);
        }
        else 
        {
            return toMergePatchShipmentType(state);
        }
    }

    public TDeleteShipmentType toDeleteShipmentType(ShipmentTypeState state) //where TDeleteShipmentType : IDeleteShipmentType, new()
    {
        TDeleteShipmentType cmd = newDeleteShipmentType();
        cmd.setShipmentTypeId(state.getShipmentTypeId());
        cmd.setVersion(state.getVersion());

        return cmd;
    }

    public TMergePatchShipmentType toMergePatchShipmentType(ShipmentTypeState state) //where TMergePatchShipmentType : IMergePatchShipmentType, new()
    {
        TMergePatchShipmentType cmd = newMergePatchShipmentType();

        cmd.setVersion(state.getVersion());

        cmd.setShipmentTypeId(state.getShipmentTypeId());
        cmd.setParentTypeId(state.getParentTypeId());
        cmd.setHasTable(state.getHasTable());
        cmd.setDescription(state.getDescription());
        cmd.setActive(state.getActive());
            
        if (state.getParentTypeId() == null) { cmd.setIsPropertyParentTypeIdRemoved(true); }
        if (state.getHasTable() == null) { cmd.setIsPropertyHasTableRemoved(true); }
        if (state.getDescription() == null) { cmd.setIsPropertyDescriptionRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        return cmd;
    }

    public TCreateShipmentType toCreateShipmentType(ShipmentTypeState state) //where TCreateShipmentType : ICreateShipmentType, new()
    {
        TCreateShipmentType cmd = newCreateShipmentType();

        cmd.setVersion(state.getVersion());
        cmd.setShipmentTypeId(state.getShipmentTypeId());
        cmd.setParentTypeId(state.getParentTypeId());
        cmd.setHasTable(state.getHasTable());
        cmd.setDescription(state.getDescription());
        cmd.setActive(state.getActive());
        return cmd;
    }

    protected abstract TCreateShipmentType newCreateShipmentType();

    protected abstract TMergePatchShipmentType newMergePatchShipmentType(); 

    protected abstract TDeleteShipmentType newDeleteShipmentType();

    public static class SimpleShipmentTypeStateCommandConverter extends AbstractShipmentTypeStateCommandConverter<AbstractShipmentTypeCommand.SimpleCreateShipmentType, AbstractShipmentTypeCommand.SimpleMergePatchShipmentType, AbstractShipmentTypeCommand.SimpleDeleteShipmentType>
    {
        @Override
        protected AbstractShipmentTypeCommand.SimpleCreateShipmentType newCreateShipmentType() {
            return new AbstractShipmentTypeCommand.SimpleCreateShipmentType();
        }

        @Override
        protected AbstractShipmentTypeCommand.SimpleMergePatchShipmentType newMergePatchShipmentType() {
            return new AbstractShipmentTypeCommand.SimpleMergePatchShipmentType();
        }

        @Override
        protected AbstractShipmentTypeCommand.SimpleDeleteShipmentType newDeleteShipmentType() {
            return new AbstractShipmentTypeCommand.SimpleDeleteShipmentType();
        }


    }

}

