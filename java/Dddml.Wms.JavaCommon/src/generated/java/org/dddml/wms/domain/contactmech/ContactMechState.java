package org.dddml.wms.domain.contactmech;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.contactmech.ContactMechEvent.*;

public interface ContactMechState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getContactMechId();

    String getContactMechTypeId();

    String getInfoString();

    String getToName();

    String getAttnName();

    String getAddress1();

    String getAddress2();

    String getDirections();

    String getCity();

    String getPostalCode();

    String getPostalCodeExt();

    String getCountryGeoId();

    String getStateProvinceGeoId();

    String getCountyGeoId();

    String getPostalCodeGeoId();

    String getGeoPointId();

    String getCountryCode();

    String getAreaCode();

    String getContactNumber();

    String getAskForName();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    Boolean getDeleted();

    interface MutableContactMechState extends ContactMechState {
        void setContactMechId(String contactMechId);

        void setContactMechTypeId(String contactMechTypeId);

        void setInfoString(String infoString);

        void setToName(String toName);

        void setAttnName(String attnName);

        void setAddress1(String address1);

        void setAddress2(String address2);

        void setDirections(String directions);

        void setCity(String city);

        void setPostalCode(String postalCode);

        void setPostalCodeExt(String postalCodeExt);

        void setCountryGeoId(String countryGeoId);

        void setStateProvinceGeoId(String stateProvinceGeoId);

        void setCountyGeoId(String countyGeoId);

        void setPostalCodeGeoId(String postalCodeGeoId);

        void setGeoPointId(String geoPointId);

        void setCountryCode(String countryCode);

        void setAreaCode(String areaCode);

        void setContactNumber(String contactNumber);

        void setAskForName(String askForName);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setDeleted(Boolean deleted);


        void mutate(Event e);

        void when(ContactMechEvent.ContactMechStateCreated e);

        void when(ContactMechEvent.ContactMechStateMergePatched e);

        void when(ContactMechEvent.ContactMechStateDeleted e);
    }

    interface SqlContactMechState extends MutableContactMechState {

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

