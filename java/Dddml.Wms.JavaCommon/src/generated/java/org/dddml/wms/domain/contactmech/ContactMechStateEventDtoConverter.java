package org.dddml.wms.domain.contactmech;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class ContactMechStateEventDtoConverter {

    public ContactMechStateEventDto toContactMechStateEventDto(AbstractContactMechEvent stateEvent) {
        if (stateEvent instanceof AbstractContactMechEvent.AbstractContactMechStateCreated) {
            ContactMechEvent.ContactMechStateCreated e = (ContactMechEvent.ContactMechStateCreated) stateEvent;
            return toContactMechStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractContactMechEvent.AbstractContactMechStateMergePatched) {
            ContactMechEvent.ContactMechStateMergePatched e = (ContactMechEvent.ContactMechStateMergePatched) stateEvent;
            return toContactMechStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractContactMechEvent.AbstractContactMechStateDeleted) {
            ContactMechEvent.ContactMechStateDeleted e = (ContactMechEvent.ContactMechStateDeleted) stateEvent;
            return toContactMechStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public ContactMechStateEventDto.ContactMechStateCreatedDto toContactMechStateCreatedDto(ContactMechEvent.ContactMechStateCreated e) {
        ContactMechStateEventDto.ContactMechStateCreatedDto dto = new ContactMechStateEventDto.ContactMechStateCreatedDto();
        dto.setContactMechEventId(e.getContactMechEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setContactMechTypeId(e.getContactMechTypeId());
        dto.setInfoString(e.getInfoString());
        dto.setToName(e.getToName());
        dto.setAttnName(e.getAttnName());
        dto.setAddress1(e.getAddress1());
        dto.setAddress2(e.getAddress2());
        dto.setDirections(e.getDirections());
        dto.setCity(e.getCity());
        dto.setPostalCode(e.getPostalCode());
        dto.setPostalCodeExt(e.getPostalCodeExt());
        dto.setCountryGeoId(e.getCountryGeoId());
        dto.setStateProvinceGeoId(e.getStateProvinceGeoId());
        dto.setCountyGeoId(e.getCountyGeoId());
        dto.setPostalCodeGeoId(e.getPostalCodeGeoId());
        dto.setGeoPointId(e.getGeoPointId());
        dto.setCountryCode(e.getCountryCode());
        dto.setAreaCode(e.getAreaCode());
        dto.setContactNumber(e.getContactNumber());
        dto.setAskForName(e.getAskForName());
        dto.setActive(e.getActive());
        return dto;
    }

    public ContactMechStateEventDto.ContactMechStateMergePatchedDto toContactMechStateMergePatchedDto(ContactMechEvent.ContactMechStateMergePatched e) {
        ContactMechStateEventDto.ContactMechStateMergePatchedDto dto = new ContactMechStateEventDto.ContactMechStateMergePatchedDto();
        dto.setContactMechEventId(e.getContactMechEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setContactMechTypeId(e.getContactMechTypeId());
        dto.setInfoString(e.getInfoString());
        dto.setToName(e.getToName());
        dto.setAttnName(e.getAttnName());
        dto.setAddress1(e.getAddress1());
        dto.setAddress2(e.getAddress2());
        dto.setDirections(e.getDirections());
        dto.setCity(e.getCity());
        dto.setPostalCode(e.getPostalCode());
        dto.setPostalCodeExt(e.getPostalCodeExt());
        dto.setCountryGeoId(e.getCountryGeoId());
        dto.setStateProvinceGeoId(e.getStateProvinceGeoId());
        dto.setCountyGeoId(e.getCountyGeoId());
        dto.setPostalCodeGeoId(e.getPostalCodeGeoId());
        dto.setGeoPointId(e.getGeoPointId());
        dto.setCountryCode(e.getCountryCode());
        dto.setAreaCode(e.getAreaCode());
        dto.setContactNumber(e.getContactNumber());
        dto.setAskForName(e.getAskForName());
        dto.setActive(e.getActive());
        dto.setIsPropertyContactMechTypeIdRemoved(e.getIsPropertyContactMechTypeIdRemoved());
        dto.setIsPropertyInfoStringRemoved(e.getIsPropertyInfoStringRemoved());
        dto.setIsPropertyToNameRemoved(e.getIsPropertyToNameRemoved());
        dto.setIsPropertyAttnNameRemoved(e.getIsPropertyAttnNameRemoved());
        dto.setIsPropertyAddress1Removed(e.getIsPropertyAddress1Removed());
        dto.setIsPropertyAddress2Removed(e.getIsPropertyAddress2Removed());
        dto.setIsPropertyDirectionsRemoved(e.getIsPropertyDirectionsRemoved());
        dto.setIsPropertyCityRemoved(e.getIsPropertyCityRemoved());
        dto.setIsPropertyPostalCodeRemoved(e.getIsPropertyPostalCodeRemoved());
        dto.setIsPropertyPostalCodeExtRemoved(e.getIsPropertyPostalCodeExtRemoved());
        dto.setIsPropertyCountryGeoIdRemoved(e.getIsPropertyCountryGeoIdRemoved());
        dto.setIsPropertyStateProvinceGeoIdRemoved(e.getIsPropertyStateProvinceGeoIdRemoved());
        dto.setIsPropertyCountyGeoIdRemoved(e.getIsPropertyCountyGeoIdRemoved());
        dto.setIsPropertyPostalCodeGeoIdRemoved(e.getIsPropertyPostalCodeGeoIdRemoved());
        dto.setIsPropertyGeoPointIdRemoved(e.getIsPropertyGeoPointIdRemoved());
        dto.setIsPropertyCountryCodeRemoved(e.getIsPropertyCountryCodeRemoved());
        dto.setIsPropertyAreaCodeRemoved(e.getIsPropertyAreaCodeRemoved());
        dto.setIsPropertyContactNumberRemoved(e.getIsPropertyContactNumberRemoved());
        dto.setIsPropertyAskForNameRemoved(e.getIsPropertyAskForNameRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public ContactMechStateEventDto.ContactMechStateDeletedDto toContactMechStateDeletedDto(ContactMechEvent.ContactMechStateDeleted e) {
        ContactMechStateEventDto.ContactMechStateDeletedDto dto = new ContactMechStateEventDto.ContactMechStateDeletedDto();
        dto.setContactMechEventId(e.getContactMechEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

