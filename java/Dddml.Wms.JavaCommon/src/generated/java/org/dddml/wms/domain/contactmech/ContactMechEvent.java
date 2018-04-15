package org.dddml.wms.domain.contactmech;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface ContactMechEvent extends Event
{
    ContactMechEventId getContactMechEventId();

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    String getContactMechTypeId();

    void setContactMechTypeId(String contactMechTypeId);

    String getInfoString();

    void setInfoString(String infoString);

    String getToName();

    void setToName(String toName);

    String getAttnName();

    void setAttnName(String attnName);

    String getAddress1();

    void setAddress1(String address1);

    String getAddress2();

    void setAddress2(String address2);

    String getDirections();

    void setDirections(String directions);

    String getCity();

    void setCity(String city);

    String getPostalCode();

    void setPostalCode(String postalCode);

    String getPostalCodeExt();

    void setPostalCodeExt(String postalCodeExt);

    String getCountryGeoId();

    void setCountryGeoId(String countryGeoId);

    String getStateProvinceGeoId();

    void setStateProvinceGeoId(String stateProvinceGeoId);

    String getCountyGeoId();

    void setCountyGeoId(String countyGeoId);

    String getPostalCodeGeoId();

    void setPostalCodeGeoId(String postalCodeGeoId);

    String getGeoPointId();

    void setGeoPointId(String geoPointId);

    String getCountryCode();

    void setCountryCode(String countryCode);

    String getAreaCode();

    void setAreaCode(String areaCode);

    String getContactNumber();

    void setContactNumber(String contactNumber);

    String getAskForName();

    void setAskForName(String askForName);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    Boolean getActive();

    void setActive(Boolean active);

    String getCommandId();

    void setCommandId(String commandId);

    interface ContactMechStateCreated extends ContactMechEvent
    {
    
    }


    interface ContactMechStateMergePatched extends ContactMechEvent
    {
        Boolean getIsPropertyContactMechTypeIdRemoved();

        void setIsPropertyContactMechTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyInfoStringRemoved();

        void setIsPropertyInfoStringRemoved(Boolean removed);

        Boolean getIsPropertyToNameRemoved();

        void setIsPropertyToNameRemoved(Boolean removed);

        Boolean getIsPropertyAttnNameRemoved();

        void setIsPropertyAttnNameRemoved(Boolean removed);

        Boolean getIsPropertyAddress1Removed();

        void setIsPropertyAddress1Removed(Boolean removed);

        Boolean getIsPropertyAddress2Removed();

        void setIsPropertyAddress2Removed(Boolean removed);

        Boolean getIsPropertyDirectionsRemoved();

        void setIsPropertyDirectionsRemoved(Boolean removed);

        Boolean getIsPropertyCityRemoved();

        void setIsPropertyCityRemoved(Boolean removed);

        Boolean getIsPropertyPostalCodeRemoved();

        void setIsPropertyPostalCodeRemoved(Boolean removed);

        Boolean getIsPropertyPostalCodeExtRemoved();

        void setIsPropertyPostalCodeExtRemoved(Boolean removed);

        Boolean getIsPropertyCountryGeoIdRemoved();

        void setIsPropertyCountryGeoIdRemoved(Boolean removed);

        Boolean getIsPropertyStateProvinceGeoIdRemoved();

        void setIsPropertyStateProvinceGeoIdRemoved(Boolean removed);

        Boolean getIsPropertyCountyGeoIdRemoved();

        void setIsPropertyCountyGeoIdRemoved(Boolean removed);

        Boolean getIsPropertyPostalCodeGeoIdRemoved();

        void setIsPropertyPostalCodeGeoIdRemoved(Boolean removed);

        Boolean getIsPropertyGeoPointIdRemoved();

        void setIsPropertyGeoPointIdRemoved(Boolean removed);

        Boolean getIsPropertyCountryCodeRemoved();

        void setIsPropertyCountryCodeRemoved(Boolean removed);

        Boolean getIsPropertyAreaCodeRemoved();

        void setIsPropertyAreaCodeRemoved(Boolean removed);

        Boolean getIsPropertyContactNumberRemoved();

        void setIsPropertyContactNumberRemoved(Boolean removed);

        Boolean getIsPropertyAskForNameRemoved();

        void setIsPropertyAskForNameRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }

    interface ContactMechStateDeleted extends ContactMechEvent
    {
    }


}

