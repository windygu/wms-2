package org.dddml.wms.domain.contactmech;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class ContactMechStateDto
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

    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
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

}

