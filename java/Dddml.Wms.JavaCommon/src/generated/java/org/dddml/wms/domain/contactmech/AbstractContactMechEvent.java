package org.dddml.wms.domain.contactmech;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractContactMechEvent extends AbstractEvent implements ContactMechEvent.SqlContactMechEvent 
{
    private ContactMechEventId contactMechEventId;

    public ContactMechEventId getContactMechEventId() {
        return this.contactMechEventId;
    }

    public void setContactMechEventId(ContactMechEventId eventId) {
        this.contactMechEventId = eventId;
    }
    
    public String getContactMechId() {
        return getContactMechEventId().getContactMechId();
    }

    public void setContactMechId(String contactMechId) {
        getContactMechEventId().setContactMechId(contactMechId);
    }

    public Long getVersion() {
        return getContactMechEventId().getVersion();
    }
    
    //public void getVersion(Long version) {
    //    getContactMechEventId().setVersion(version);
    //}

    private boolean stateEventReadOnly;

    public boolean getEventReadOnly() { return this.stateEventReadOnly; }

    public void setEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

    private String createdBy;

    public String getCreatedBy()
    {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy)
    {
        this.createdBy = createdBy;
    }

    private Date createdAt;

    public Date getCreatedAt()
    {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }


    private String commandId;

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    protected AbstractContactMechEvent() {
    }

    protected AbstractContactMechEvent(ContactMechEventId eventId) {
        this.contactMechEventId = eventId;
    }


    public abstract String getEventType();


    public static abstract class AbstractContactMechStateEvent extends AbstractContactMechEvent implements ContactMechEvent.ContactMechStateEvent {
        private String contactMechTypeId;

        public String getContactMechTypeId()
        {
            return this.contactMechTypeId;
        }

        public void setContactMechTypeId(String contactMechTypeId)
        {
            this.contactMechTypeId = contactMechTypeId;
        }

        private String infoString;

        public String getInfoString()
        {
            return this.infoString;
        }

        public void setInfoString(String infoString)
        {
            this.infoString = infoString;
        }

        private String toName;

        public String getToName()
        {
            return this.toName;
        }

        public void setToName(String toName)
        {
            this.toName = toName;
        }

        private String attnName;

        public String getAttnName()
        {
            return this.attnName;
        }

        public void setAttnName(String attnName)
        {
            this.attnName = attnName;
        }

        private String address1;

        public String getAddress1()
        {
            return this.address1;
        }

        public void setAddress1(String address1)
        {
            this.address1 = address1;
        }

        private String address2;

        public String getAddress2()
        {
            return this.address2;
        }

        public void setAddress2(String address2)
        {
            this.address2 = address2;
        }

        private String directions;

        public String getDirections()
        {
            return this.directions;
        }

        public void setDirections(String directions)
        {
            this.directions = directions;
        }

        private String city;

        public String getCity()
        {
            return this.city;
        }

        public void setCity(String city)
        {
            this.city = city;
        }

        private String postalCode;

        public String getPostalCode()
        {
            return this.postalCode;
        }

        public void setPostalCode(String postalCode)
        {
            this.postalCode = postalCode;
        }

        private String postalCodeExt;

        public String getPostalCodeExt()
        {
            return this.postalCodeExt;
        }

        public void setPostalCodeExt(String postalCodeExt)
        {
            this.postalCodeExt = postalCodeExt;
        }

        private String countryGeoId;

        public String getCountryGeoId()
        {
            return this.countryGeoId;
        }

        public void setCountryGeoId(String countryGeoId)
        {
            this.countryGeoId = countryGeoId;
        }

        private String stateProvinceGeoId;

        public String getStateProvinceGeoId()
        {
            return this.stateProvinceGeoId;
        }

        public void setStateProvinceGeoId(String stateProvinceGeoId)
        {
            this.stateProvinceGeoId = stateProvinceGeoId;
        }

        private String countyGeoId;

        public String getCountyGeoId()
        {
            return this.countyGeoId;
        }

        public void setCountyGeoId(String countyGeoId)
        {
            this.countyGeoId = countyGeoId;
        }

        private String postalCodeGeoId;

        public String getPostalCodeGeoId()
        {
            return this.postalCodeGeoId;
        }

        public void setPostalCodeGeoId(String postalCodeGeoId)
        {
            this.postalCodeGeoId = postalCodeGeoId;
        }

        private String geoPointId;

        public String getGeoPointId()
        {
            return this.geoPointId;
        }

        public void setGeoPointId(String geoPointId)
        {
            this.geoPointId = geoPointId;
        }

        private String countryCode;

        public String getCountryCode()
        {
            return this.countryCode;
        }

        public void setCountryCode(String countryCode)
        {
            this.countryCode = countryCode;
        }

        private String areaCode;

        public String getAreaCode()
        {
            return this.areaCode;
        }

        public void setAreaCode(String areaCode)
        {
            this.areaCode = areaCode;
        }

        private String contactNumber;

        public String getContactNumber()
        {
            return this.contactNumber;
        }

        public void setContactNumber(String contactNumber)
        {
            this.contactNumber = contactNumber;
        }

        private String askForName;

        public String getAskForName()
        {
            return this.askForName;
        }

        public void setAskForName(String askForName)
        {
            this.askForName = askForName;
        }

        private Boolean active;

        public Boolean getActive()
        {
            return this.active;
        }

        public void setActive(Boolean active)
        {
            this.active = active;
        }

        protected AbstractContactMechStateEvent(ContactMechEventId eventId) {
            super(eventId);
        }
    }

    public static abstract class AbstractContactMechStateCreated extends AbstractContactMechStateEvent implements ContactMechEvent.ContactMechStateCreated
    {
        public AbstractContactMechStateCreated() {
            this(new ContactMechEventId());
        }

        public AbstractContactMechStateCreated(ContactMechEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractContactMechStateMergePatched extends AbstractContactMechStateEvent implements ContactMechEvent.ContactMechStateMergePatched
    {
        public AbstractContactMechStateMergePatched() {
            this(new ContactMechEventId());
        }

        public AbstractContactMechStateMergePatched(ContactMechEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyContactMechTypeIdRemoved;

        public Boolean getIsPropertyContactMechTypeIdRemoved() {
            return this.isPropertyContactMechTypeIdRemoved;
        }

        public void setIsPropertyContactMechTypeIdRemoved(Boolean removed) {
            this.isPropertyContactMechTypeIdRemoved = removed;
        }

        private Boolean isPropertyInfoStringRemoved;

        public Boolean getIsPropertyInfoStringRemoved() {
            return this.isPropertyInfoStringRemoved;
        }

        public void setIsPropertyInfoStringRemoved(Boolean removed) {
            this.isPropertyInfoStringRemoved = removed;
        }

        private Boolean isPropertyToNameRemoved;

        public Boolean getIsPropertyToNameRemoved() {
            return this.isPropertyToNameRemoved;
        }

        public void setIsPropertyToNameRemoved(Boolean removed) {
            this.isPropertyToNameRemoved = removed;
        }

        private Boolean isPropertyAttnNameRemoved;

        public Boolean getIsPropertyAttnNameRemoved() {
            return this.isPropertyAttnNameRemoved;
        }

        public void setIsPropertyAttnNameRemoved(Boolean removed) {
            this.isPropertyAttnNameRemoved = removed;
        }

        private Boolean isPropertyAddress1Removed;

        public Boolean getIsPropertyAddress1Removed() {
            return this.isPropertyAddress1Removed;
        }

        public void setIsPropertyAddress1Removed(Boolean removed) {
            this.isPropertyAddress1Removed = removed;
        }

        private Boolean isPropertyAddress2Removed;

        public Boolean getIsPropertyAddress2Removed() {
            return this.isPropertyAddress2Removed;
        }

        public void setIsPropertyAddress2Removed(Boolean removed) {
            this.isPropertyAddress2Removed = removed;
        }

        private Boolean isPropertyDirectionsRemoved;

        public Boolean getIsPropertyDirectionsRemoved() {
            return this.isPropertyDirectionsRemoved;
        }

        public void setIsPropertyDirectionsRemoved(Boolean removed) {
            this.isPropertyDirectionsRemoved = removed;
        }

        private Boolean isPropertyCityRemoved;

        public Boolean getIsPropertyCityRemoved() {
            return this.isPropertyCityRemoved;
        }

        public void setIsPropertyCityRemoved(Boolean removed) {
            this.isPropertyCityRemoved = removed;
        }

        private Boolean isPropertyPostalCodeRemoved;

        public Boolean getIsPropertyPostalCodeRemoved() {
            return this.isPropertyPostalCodeRemoved;
        }

        public void setIsPropertyPostalCodeRemoved(Boolean removed) {
            this.isPropertyPostalCodeRemoved = removed;
        }

        private Boolean isPropertyPostalCodeExtRemoved;

        public Boolean getIsPropertyPostalCodeExtRemoved() {
            return this.isPropertyPostalCodeExtRemoved;
        }

        public void setIsPropertyPostalCodeExtRemoved(Boolean removed) {
            this.isPropertyPostalCodeExtRemoved = removed;
        }

        private Boolean isPropertyCountryGeoIdRemoved;

        public Boolean getIsPropertyCountryGeoIdRemoved() {
            return this.isPropertyCountryGeoIdRemoved;
        }

        public void setIsPropertyCountryGeoIdRemoved(Boolean removed) {
            this.isPropertyCountryGeoIdRemoved = removed;
        }

        private Boolean isPropertyStateProvinceGeoIdRemoved;

        public Boolean getIsPropertyStateProvinceGeoIdRemoved() {
            return this.isPropertyStateProvinceGeoIdRemoved;
        }

        public void setIsPropertyStateProvinceGeoIdRemoved(Boolean removed) {
            this.isPropertyStateProvinceGeoIdRemoved = removed;
        }

        private Boolean isPropertyCountyGeoIdRemoved;

        public Boolean getIsPropertyCountyGeoIdRemoved() {
            return this.isPropertyCountyGeoIdRemoved;
        }

        public void setIsPropertyCountyGeoIdRemoved(Boolean removed) {
            this.isPropertyCountyGeoIdRemoved = removed;
        }

        private Boolean isPropertyPostalCodeGeoIdRemoved;

        public Boolean getIsPropertyPostalCodeGeoIdRemoved() {
            return this.isPropertyPostalCodeGeoIdRemoved;
        }

        public void setIsPropertyPostalCodeGeoIdRemoved(Boolean removed) {
            this.isPropertyPostalCodeGeoIdRemoved = removed;
        }

        private Boolean isPropertyGeoPointIdRemoved;

        public Boolean getIsPropertyGeoPointIdRemoved() {
            return this.isPropertyGeoPointIdRemoved;
        }

        public void setIsPropertyGeoPointIdRemoved(Boolean removed) {
            this.isPropertyGeoPointIdRemoved = removed;
        }

        private Boolean isPropertyCountryCodeRemoved;

        public Boolean getIsPropertyCountryCodeRemoved() {
            return this.isPropertyCountryCodeRemoved;
        }

        public void setIsPropertyCountryCodeRemoved(Boolean removed) {
            this.isPropertyCountryCodeRemoved = removed;
        }

        private Boolean isPropertyAreaCodeRemoved;

        public Boolean getIsPropertyAreaCodeRemoved() {
            return this.isPropertyAreaCodeRemoved;
        }

        public void setIsPropertyAreaCodeRemoved(Boolean removed) {
            this.isPropertyAreaCodeRemoved = removed;
        }

        private Boolean isPropertyContactNumberRemoved;

        public Boolean getIsPropertyContactNumberRemoved() {
            return this.isPropertyContactNumberRemoved;
        }

        public void setIsPropertyContactNumberRemoved(Boolean removed) {
            this.isPropertyContactNumberRemoved = removed;
        }

        private Boolean isPropertyAskForNameRemoved;

        public Boolean getIsPropertyAskForNameRemoved() {
            return this.isPropertyAskForNameRemoved;
        }

        public void setIsPropertyAskForNameRemoved(Boolean removed) {
            this.isPropertyAskForNameRemoved = removed;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

    }


    public static abstract class AbstractContactMechStateDeleted extends AbstractContactMechStateEvent implements ContactMechEvent.ContactMechStateDeleted
    {
        public AbstractContactMechStateDeleted() {
            this(new ContactMechEventId());
        }

        public AbstractContactMechStateDeleted(ContactMechEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.DELETED;
        }

    }
    public static class SimpleContactMechStateCreated extends AbstractContactMechStateCreated
    {
        public SimpleContactMechStateCreated() {
        }

        public SimpleContactMechStateCreated(ContactMechEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleContactMechStateMergePatched extends AbstractContactMechStateMergePatched
    {
        public SimpleContactMechStateMergePatched() {
        }

        public SimpleContactMechStateMergePatched(ContactMechEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleContactMechStateDeleted extends AbstractContactMechStateDeleted
    {
        public SimpleContactMechStateDeleted() {
        }

        public SimpleContactMechStateDeleted(ContactMechEventId eventId) {
            super(eventId);
        }
    }

}

