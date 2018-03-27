package org.dddml.wms.domain.shipmentmethodtype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractShipmentMethodTypeStateCommandConverter<TCreateShipmentMethodType extends ShipmentMethodTypeCommand.CreateShipmentMethodType, TMergePatchShipmentMethodType extends ShipmentMethodTypeCommand.MergePatchShipmentMethodType, TDeleteShipmentMethodType extends ShipmentMethodTypeCommand.DeleteShipmentMethodType>
{
    public ShipmentMethodTypeCommand toCreateOrMergePatchShipmentMethodType(ShipmentMethodTypeState state)
    {
        //where TCreateShipmentMethodType : ICreateShipmentMethodType, new()
        //where TMergePatchShipmentMethodType : IMergePatchShipmentMethodType, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateShipmentMethodType(state);
        }
        else 
        {
            return toMergePatchShipmentMethodType(state);
        }
    }

    public TDeleteShipmentMethodType toDeleteShipmentMethodType(ShipmentMethodTypeState state) //where TDeleteShipmentMethodType : IDeleteShipmentMethodType, new()
    {
        TDeleteShipmentMethodType cmd = newDeleteShipmentMethodType();
        cmd.setShipmentMethodTypeId(state.getShipmentMethodTypeId());
        cmd.setVersion(state.getVersion());

        return cmd;
    }

    public TMergePatchShipmentMethodType toMergePatchShipmentMethodType(ShipmentMethodTypeState state) //where TMergePatchShipmentMethodType : IMergePatchShipmentMethodType, new()
    {
        TMergePatchShipmentMethodType cmd = newMergePatchShipmentMethodType();

        cmd.setVersion(state.getVersion());

        cmd.setShipmentMethodTypeId(state.getShipmentMethodTypeId());
        cmd.setDescription(state.getDescription());
        cmd.setSequenceNum(state.getSequenceNum());
        cmd.setActive(state.getActive());
            
        if (state.getDescription() == null) { cmd.setIsPropertyDescriptionRemoved(true); }
        if (state.getSequenceNum() == null) { cmd.setIsPropertySequenceNumRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        return cmd;
    }

    public TCreateShipmentMethodType toCreateShipmentMethodType(ShipmentMethodTypeState state) //where TCreateShipmentMethodType : ICreateShipmentMethodType, new()
    {
        TCreateShipmentMethodType cmd = newCreateShipmentMethodType();

        cmd.setVersion(state.getVersion());
        cmd.setShipmentMethodTypeId(state.getShipmentMethodTypeId());
        cmd.setDescription(state.getDescription());
        cmd.setSequenceNum(state.getSequenceNum());
        cmd.setActive(state.getActive());
        return cmd;
    }

    protected abstract TCreateShipmentMethodType newCreateShipmentMethodType();

    protected abstract TMergePatchShipmentMethodType newMergePatchShipmentMethodType(); 

    protected abstract TDeleteShipmentMethodType newDeleteShipmentMethodType();

    public static class SimpleShipmentMethodTypeStateCommandConverter extends AbstractShipmentMethodTypeStateCommandConverter<AbstractShipmentMethodTypeCommand.SimpleCreateShipmentMethodType, AbstractShipmentMethodTypeCommand.SimpleMergePatchShipmentMethodType, AbstractShipmentMethodTypeCommand.SimpleDeleteShipmentMethodType>
    {
        @Override
        protected AbstractShipmentMethodTypeCommand.SimpleCreateShipmentMethodType newCreateShipmentMethodType() {
            return new AbstractShipmentMethodTypeCommand.SimpleCreateShipmentMethodType();
        }

        @Override
        protected AbstractShipmentMethodTypeCommand.SimpleMergePatchShipmentMethodType newMergePatchShipmentMethodType() {
            return new AbstractShipmentMethodTypeCommand.SimpleMergePatchShipmentMethodType();
        }

        @Override
        protected AbstractShipmentMethodTypeCommand.SimpleDeleteShipmentMethodType newDeleteShipmentMethodType() {
            return new AbstractShipmentMethodTypeCommand.SimpleDeleteShipmentMethodType();
        }


    }

}

