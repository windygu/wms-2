package org.dddml.wms.domain.contactmech;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.contactmech.ContactMechEvent.*;

public abstract class AbstractContactMechState implements ContactMechState
{

    private String contactMechId;

    public String getContactMechId()
    {
        return this.contactMechId;
    }

    public void setContactMechId(String contactMechId)
    {
        this.contactMechId = contactMechId;
    }

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

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }

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

    private String updatedBy;

    public String getUpdatedBy()
    {
        return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy)
    {
        this.updatedBy = updatedBy;
    }

    private Date updatedAt;

    public Date getUpdatedAt()
    {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt)
    {
        this.updatedAt = updatedAt;
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

    private Boolean deleted;

    public Boolean getDeleted()
    {
        return this.deleted;
    }

    public void setDeleted(Boolean deleted)
    {
        this.deleted = deleted;
    }

    public boolean isStateUnsaved() 
    {
        return this.getVersion() == null;
    }

    private Boolean stateReadOnly;

    public Boolean getStateReadOnly() { return this.stateReadOnly; }

    public void setStateReadOnly(Boolean readOnly) { this.stateReadOnly = readOnly; }

    private boolean forReapplying;

    public boolean getForReapplying() {
        return forReapplying;
    }

    public void setForReapplying(boolean forReapplying) {
        this.forReapplying = forReapplying;
    }

    public AbstractContactMechState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setContactMechId(((ContactMechEvent) events.get(0)).getContactMechEventId().getContactMechId());
            for (Event e : events) {
                mutate(e);
                this.setVersion(this.getVersion() + 1);
            }
        }
    }


    public AbstractContactMechState() {
        this(false);
    }

    public AbstractContactMechState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof ContactMechStateCreated) {
            when((ContactMechStateCreated) e);
        } else if (e instanceof ContactMechStateMergePatched) {
            when((ContactMechStateMergePatched) e);
        } else if (e instanceof ContactMechStateDeleted) {
            when((ContactMechStateDeleted) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(ContactMechStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setContactMechTypeId(e.getContactMechTypeId());
        this.setInfoString(e.getInfoString());
        this.setToName(e.getToName());
        this.setAttnName(e.getAttnName());
        this.setAddress1(e.getAddress1());
        this.setAddress2(e.getAddress2());
        this.setDirections(e.getDirections());
        this.setCity(e.getCity());
        this.setPostalCode(e.getPostalCode());
        this.setPostalCodeExt(e.getPostalCodeExt());
        this.setCountryGeoId(e.getCountryGeoId());
        this.setStateProvinceGeoId(e.getStateProvinceGeoId());
        this.setCountyGeoId(e.getCountyGeoId());
        this.setPostalCodeGeoId(e.getPostalCodeGeoId());
        this.setGeoPointId(e.getGeoPointId());
        this.setCountryCode(e.getCountryCode());
        this.setAreaCode(e.getAreaCode());
        this.setContactNumber(e.getContactNumber());
        this.setAskForName(e.getAskForName());
        this.setActive(e.getActive());

        this.setDeleted(false);

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    public void when(ContactMechStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getContactMechTypeId() == null)
        {
            if (e.getIsPropertyContactMechTypeIdRemoved() != null && e.getIsPropertyContactMechTypeIdRemoved())
            {
                this.setContactMechTypeId(null);
            }
        }
        else
        {
            this.setContactMechTypeId(e.getContactMechTypeId());
        }
        if (e.getInfoString() == null)
        {
            if (e.getIsPropertyInfoStringRemoved() != null && e.getIsPropertyInfoStringRemoved())
            {
                this.setInfoString(null);
            }
        }
        else
        {
            this.setInfoString(e.getInfoString());
        }
        if (e.getToName() == null)
        {
            if (e.getIsPropertyToNameRemoved() != null && e.getIsPropertyToNameRemoved())
            {
                this.setToName(null);
            }
        }
        else
        {
            this.setToName(e.getToName());
        }
        if (e.getAttnName() == null)
        {
            if (e.getIsPropertyAttnNameRemoved() != null && e.getIsPropertyAttnNameRemoved())
            {
                this.setAttnName(null);
            }
        }
        else
        {
            this.setAttnName(e.getAttnName());
        }
        if (e.getAddress1() == null)
        {
            if (e.getIsPropertyAddress1Removed() != null && e.getIsPropertyAddress1Removed())
            {
                this.setAddress1(null);
            }
        }
        else
        {
            this.setAddress1(e.getAddress1());
        }
        if (e.getAddress2() == null)
        {
            if (e.getIsPropertyAddress2Removed() != null && e.getIsPropertyAddress2Removed())
            {
                this.setAddress2(null);
            }
        }
        else
        {
            this.setAddress2(e.getAddress2());
        }
        if (e.getDirections() == null)
        {
            if (e.getIsPropertyDirectionsRemoved() != null && e.getIsPropertyDirectionsRemoved())
            {
                this.setDirections(null);
            }
        }
        else
        {
            this.setDirections(e.getDirections());
        }
        if (e.getCity() == null)
        {
            if (e.getIsPropertyCityRemoved() != null && e.getIsPropertyCityRemoved())
            {
                this.setCity(null);
            }
        }
        else
        {
            this.setCity(e.getCity());
        }
        if (e.getPostalCode() == null)
        {
            if (e.getIsPropertyPostalCodeRemoved() != null && e.getIsPropertyPostalCodeRemoved())
            {
                this.setPostalCode(null);
            }
        }
        else
        {
            this.setPostalCode(e.getPostalCode());
        }
        if (e.getPostalCodeExt() == null)
        {
            if (e.getIsPropertyPostalCodeExtRemoved() != null && e.getIsPropertyPostalCodeExtRemoved())
            {
                this.setPostalCodeExt(null);
            }
        }
        else
        {
            this.setPostalCodeExt(e.getPostalCodeExt());
        }
        if (e.getCountryGeoId() == null)
        {
            if (e.getIsPropertyCountryGeoIdRemoved() != null && e.getIsPropertyCountryGeoIdRemoved())
            {
                this.setCountryGeoId(null);
            }
        }
        else
        {
            this.setCountryGeoId(e.getCountryGeoId());
        }
        if (e.getStateProvinceGeoId() == null)
        {
            if (e.getIsPropertyStateProvinceGeoIdRemoved() != null && e.getIsPropertyStateProvinceGeoIdRemoved())
            {
                this.setStateProvinceGeoId(null);
            }
        }
        else
        {
            this.setStateProvinceGeoId(e.getStateProvinceGeoId());
        }
        if (e.getCountyGeoId() == null)
        {
            if (e.getIsPropertyCountyGeoIdRemoved() != null && e.getIsPropertyCountyGeoIdRemoved())
            {
                this.setCountyGeoId(null);
            }
        }
        else
        {
            this.setCountyGeoId(e.getCountyGeoId());
        }
        if (e.getPostalCodeGeoId() == null)
        {
            if (e.getIsPropertyPostalCodeGeoIdRemoved() != null && e.getIsPropertyPostalCodeGeoIdRemoved())
            {
                this.setPostalCodeGeoId(null);
            }
        }
        else
        {
            this.setPostalCodeGeoId(e.getPostalCodeGeoId());
        }
        if (e.getGeoPointId() == null)
        {
            if (e.getIsPropertyGeoPointIdRemoved() != null && e.getIsPropertyGeoPointIdRemoved())
            {
                this.setGeoPointId(null);
            }
        }
        else
        {
            this.setGeoPointId(e.getGeoPointId());
        }
        if (e.getCountryCode() == null)
        {
            if (e.getIsPropertyCountryCodeRemoved() != null && e.getIsPropertyCountryCodeRemoved())
            {
                this.setCountryCode(null);
            }
        }
        else
        {
            this.setCountryCode(e.getCountryCode());
        }
        if (e.getAreaCode() == null)
        {
            if (e.getIsPropertyAreaCodeRemoved() != null && e.getIsPropertyAreaCodeRemoved())
            {
                this.setAreaCode(null);
            }
        }
        else
        {
            this.setAreaCode(e.getAreaCode());
        }
        if (e.getContactNumber() == null)
        {
            if (e.getIsPropertyContactNumberRemoved() != null && e.getIsPropertyContactNumberRemoved())
            {
                this.setContactNumber(null);
            }
        }
        else
        {
            this.setContactNumber(e.getContactNumber());
        }
        if (e.getAskForName() == null)
        {
            if (e.getIsPropertyAskForNameRemoved() != null && e.getIsPropertyAskForNameRemoved())
            {
                this.setAskForName(null);
            }
        }
        else
        {
            this.setAskForName(e.getAskForName());
        }
        if (e.getActive() == null)
        {
            if (e.getIsPropertyActiveRemoved() != null && e.getIsPropertyActiveRemoved())
            {
                this.setActive(null);
            }
        }
        else
        {
            this.setActive(e.getActive());
        }

        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void when(ContactMechStateDeleted e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(ContactMechEvent stateEvent)
    {
        String stateEntityId = this.getContactMechId(); // Aggregate Id
        String eventEntityId = stateEvent.getContactMechEventId().getContactMechId(); // EntityBase.Aggregate.GetEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getVersion();
        Long eventVersion = stateEvent.getContactMechEventId().getVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("stateEvent.getContactMechEventId().getVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(ContactMechState.VERSION_NULL)) && !eventVersion.equals(stateVersion))//(eventVersion.compareTo(stateVersion) >= 0)
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleContactMechState extends AbstractContactMechState
    {

        public SimpleContactMechState() {
        }

        public SimpleContactMechState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimpleContactMechState(List<Event> events) {
            super(events);
        }

    }


}

