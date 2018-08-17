package org.dddml.wms.domain.party;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class PersonStateDto extends PartyStateDto
{


    public static class DtoConverter extends AbstractStateDtoConverter
    {
        public static Collection<String> collectionFieldNames = Arrays.asList(new String[]{});

        @Override
        protected boolean isCollectionField(String fieldName) {
            return CollectionUtils.collectionContainsIgnoringCase(collectionFieldNames, fieldName);
        }

        public PersonStateDto[] toPersonStateDtoArray(Iterable<PersonState> states) {
            return toPersonStateDtoList(states).toArray(new PersonStateDto[0]);
        }

        public List<PersonStateDto> toPersonStateDtoList(Iterable<PersonState> states) {
            ArrayList<PersonStateDto> stateDtos = new ArrayList();
            for (PersonState s : states) {
                PersonStateDto dto = toPersonStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos;
        }

        public PersonStateDto toPersonStateDto(PersonState state)
        {
            if(state == null) {
                return null;
            }
            PersonStateDto dto = new PersonStateDto();
            if (returnedFieldsContains("PartyId")) {
                dto.setPartyId(state.getPartyId());
            }
            if (returnedFieldsContains("PartyTypeId")) {
                dto.setPartyTypeId(state.getPartyTypeId());
            }
            if (returnedFieldsContains("PrimaryRoleTypeId")) {
                dto.setPrimaryRoleTypeId(state.getPrimaryRoleTypeId());
            }
            if (returnedFieldsContains("ExternalId")) {
                dto.setExternalId(state.getExternalId());
            }
            if (returnedFieldsContains("PreferredCurrencyUomId")) {
                dto.setPreferredCurrencyUomId(state.getPreferredCurrencyUomId());
            }
            if (returnedFieldsContains("Description")) {
                dto.setDescription(state.getDescription());
            }
            if (returnedFieldsContains("Active")) {
                dto.setActive(state.getActive());
            }
            if (returnedFieldsContains("Version")) {
                dto.setVersion(state.getVersion());
            }
            if (returnedFieldsContains("CreatedBy")) {
                dto.setCreatedBy(state.getCreatedBy());
            }
            if (returnedFieldsContains("CreatedAt")) {
                dto.setCreatedAt(state.getCreatedAt());
            }
            if (returnedFieldsContains("UpdatedBy")) {
                dto.setUpdatedBy(state.getUpdatedBy());
            }
            if (returnedFieldsContains("UpdatedAt")) {
                dto.setUpdatedAt(state.getUpdatedAt());
            }

          // ////////////////
          if (state instanceof OrganizationState) {
            OrganizationState ss = (OrganizationState) state;
            if (returnedFieldsContains("OrganizationName")) {
                dto.setOrganizationName(ss.getOrganizationName());
            }
            if (returnedFieldsContains("IsSummary")) {
                dto.setIsSummary(ss.getIsSummary());
            }
          }
          // ////////////////

          // ////////////////
          if (state instanceof PersonState) {
            PersonState ss = (PersonState) state;
            if (returnedFieldsContains("Salutation")) {
                dto.setSalutation(ss.getSalutation());
            }
            if (returnedFieldsContains("FirstName")) {
                dto.setFirstName(ss.getFirstName());
            }
            if (returnedFieldsContains("MiddleName")) {
                dto.setMiddleName(ss.getMiddleName());
            }
            if (returnedFieldsContains("LastName")) {
                dto.setLastName(ss.getLastName());
            }
            if (returnedFieldsContains("PersonalTitle")) {
                dto.setPersonalTitle(ss.getPersonalTitle());
            }
            if (returnedFieldsContains("Nickname")) {
                dto.setNickname(ss.getNickname());
            }
            if (returnedFieldsContains("CardId")) {
                dto.setCardId(ss.getCardId());
            }
          }
          // ////////////////
            return dto;
        }

    }
}

