package org.dddml.wms.domain.contactmech;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractContactMechStateCommandConverter<TCreateContactMech extends ContactMechCommand.CreateContactMech, TMergePatchContactMech extends ContactMechCommand.MergePatchContactMech, TDeleteContactMech extends ContactMechCommand.DeleteContactMech>
{
    public ContactMechCommand toCreateOrMergePatchContactMech(ContactMechState state)
    {
        //where TCreateContactMech : ICreateContactMech, new()
        //where TMergePatchContactMech : IMergePatchContactMech, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateContactMech(state);
        }
        else 
        {
            return toMergePatchContactMech(state);
        }
    }

    public TDeleteContactMech toDeleteContactMech(ContactMechState state) //where TDeleteContactMech : IDeleteContactMech, new()
    {
        TDeleteContactMech cmd = newDeleteContactMech();
        cmd.setContactMechId(state.getContactMechId());
        cmd.setVersion(state.getVersion());

        return cmd;
    }

    public TMergePatchContactMech toMergePatchContactMech(ContactMechState state) //where TMergePatchContactMech : IMergePatchContactMech, new()
    {
        TMergePatchContactMech cmd = newMergePatchContactMech();

        cmd.setVersion(state.getVersion());

        cmd.setContactMechId(state.getContactMechId());
        cmd.setContactMechTypeId(state.getContactMechTypeId());
        cmd.setInfoString(state.getInfoString());
        cmd.setToName(state.getToName());
        cmd.setAttnName(state.getAttnName());
        cmd.setAddress1(state.getAddress1());
        cmd.setAddress2(state.getAddress2());
        cmd.setDirections(state.getDirections());
        cmd.setCity(state.getCity());
        cmd.setPostalCode(state.getPostalCode());
        cmd.setPostalCodeExt(state.getPostalCodeExt());
        cmd.setCountryGeoId(state.getCountryGeoId());
        cmd.setStateProvinceGeoId(state.getStateProvinceGeoId());
        cmd.setCountyGeoId(state.getCountyGeoId());
        cmd.setPostalCodeGeoId(state.getPostalCodeGeoId());
        cmd.setGeoPointId(state.getGeoPointId());
        cmd.setCountryCode(state.getCountryCode());
        cmd.setAreaCode(state.getAreaCode());
        cmd.setContactNumber(state.getContactNumber());
        cmd.setAskForName(state.getAskForName());
        cmd.setActive(state.getActive());
            
        if (state.getContactMechTypeId() == null) { cmd.setIsPropertyContactMechTypeIdRemoved(true); }
        if (state.getInfoString() == null) { cmd.setIsPropertyInfoStringRemoved(true); }
        if (state.getToName() == null) { cmd.setIsPropertyToNameRemoved(true); }
        if (state.getAttnName() == null) { cmd.setIsPropertyAttnNameRemoved(true); }
        if (state.getAddress1() == null) { cmd.setIsPropertyAddress1Removed(true); }
        if (state.getAddress2() == null) { cmd.setIsPropertyAddress2Removed(true); }
        if (state.getDirections() == null) { cmd.setIsPropertyDirectionsRemoved(true); }
        if (state.getCity() == null) { cmd.setIsPropertyCityRemoved(true); }
        if (state.getPostalCode() == null) { cmd.setIsPropertyPostalCodeRemoved(true); }
        if (state.getPostalCodeExt() == null) { cmd.setIsPropertyPostalCodeExtRemoved(true); }
        if (state.getCountryGeoId() == null) { cmd.setIsPropertyCountryGeoIdRemoved(true); }
        if (state.getStateProvinceGeoId() == null) { cmd.setIsPropertyStateProvinceGeoIdRemoved(true); }
        if (state.getCountyGeoId() == null) { cmd.setIsPropertyCountyGeoIdRemoved(true); }
        if (state.getPostalCodeGeoId() == null) { cmd.setIsPropertyPostalCodeGeoIdRemoved(true); }
        if (state.getGeoPointId() == null) { cmd.setIsPropertyGeoPointIdRemoved(true); }
        if (state.getCountryCode() == null) { cmd.setIsPropertyCountryCodeRemoved(true); }
        if (state.getAreaCode() == null) { cmd.setIsPropertyAreaCodeRemoved(true); }
        if (state.getContactNumber() == null) { cmd.setIsPropertyContactNumberRemoved(true); }
        if (state.getAskForName() == null) { cmd.setIsPropertyAskForNameRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        return cmd;
    }

    public TCreateContactMech toCreateContactMech(ContactMechState state) //where TCreateContactMech : ICreateContactMech, new()
    {
        TCreateContactMech cmd = newCreateContactMech();

        cmd.setVersion(state.getVersion());
        cmd.setContactMechId(state.getContactMechId());
        cmd.setContactMechTypeId(state.getContactMechTypeId());
        cmd.setInfoString(state.getInfoString());
        cmd.setToName(state.getToName());
        cmd.setAttnName(state.getAttnName());
        cmd.setAddress1(state.getAddress1());
        cmd.setAddress2(state.getAddress2());
        cmd.setDirections(state.getDirections());
        cmd.setCity(state.getCity());
        cmd.setPostalCode(state.getPostalCode());
        cmd.setPostalCodeExt(state.getPostalCodeExt());
        cmd.setCountryGeoId(state.getCountryGeoId());
        cmd.setStateProvinceGeoId(state.getStateProvinceGeoId());
        cmd.setCountyGeoId(state.getCountyGeoId());
        cmd.setPostalCodeGeoId(state.getPostalCodeGeoId());
        cmd.setGeoPointId(state.getGeoPointId());
        cmd.setCountryCode(state.getCountryCode());
        cmd.setAreaCode(state.getAreaCode());
        cmd.setContactNumber(state.getContactNumber());
        cmd.setAskForName(state.getAskForName());
        cmd.setActive(state.getActive());
        return cmd;
    }

    protected abstract TCreateContactMech newCreateContactMech();

    protected abstract TMergePatchContactMech newMergePatchContactMech(); 

    protected abstract TDeleteContactMech newDeleteContactMech();

    public static class SimpleContactMechStateCommandConverter extends AbstractContactMechStateCommandConverter<AbstractContactMechCommand.SimpleCreateContactMech, AbstractContactMechCommand.SimpleMergePatchContactMech, AbstractContactMechCommand.SimpleDeleteContactMech>
    {
        @Override
        protected AbstractContactMechCommand.SimpleCreateContactMech newCreateContactMech() {
            return new AbstractContactMechCommand.SimpleCreateContactMech();
        }

        @Override
        protected AbstractContactMechCommand.SimpleMergePatchContactMech newMergePatchContactMech() {
            return new AbstractContactMechCommand.SimpleMergePatchContactMech();
        }

        @Override
        protected AbstractContactMechCommand.SimpleDeleteContactMech newDeleteContactMech() {
            return new AbstractContactMechCommand.SimpleDeleteContactMech();
        }


    }

}

