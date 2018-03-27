package org.dddml.wms.domain.contactmech;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.contactmech.ContactMechStateEvent.*;

public interface ContactMechState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getContactMechId();

    void setContactMechId(String contactMechId);

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

    Long getVersion();

    void setVersion(Long version);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getUpdatedBy();

    void setUpdatedBy(String updatedBy);

    Date getUpdatedAt();

    void setUpdatedAt(Date updatedAt);

    Boolean getActive();

    void setActive(Boolean active);

    Boolean getDeleted();

    void setDeleted(Boolean deleted);


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(ContactMechStateEvent.ContactMechStateCreated e);

    void when(ContactMechStateEvent.ContactMechStateMergePatched e);

    void when(ContactMechStateEvent.ContactMechStateDeleted e);
    
}

