package org.dddml.wms.domain.party;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class OrganizationStateDto extends PartyStateDto
{


    public static class DtoConverter extends AbstractStateDtoConverter
    {
        public static Collection<String> collectionFieldNames = Arrays.asList(new String[]{});

        @Override
        protected boolean isCollectionField(String fieldName) {
            return CollectionUtils.collectionContainsIgnoringCase(collectionFieldNames, fieldName);
        }

        public OrganizationStateDto[] toOrganizationStateDtoArray(Iterable<OrganizationState> states) {
            return toOrganizationStateDtoList(states).toArray(new OrganizationStateDto[0]);
        }

        public List<OrganizationStateDto> toOrganizationStateDtoList(Iterable<OrganizationState> states) {
            ArrayList<OrganizationStateDto> stateDtos = new ArrayList();
            for (OrganizationState s : states) {
                OrganizationStateDto dto = toOrganizationStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos;
        }

        public OrganizationStateDto toOrganizationStateDto(OrganizationState state)
        {
            if(state == null) {
                return null;
            }
            OrganizationStateDto dto = new OrganizationStateDto();
            if (returnedFieldsContains("PartyId")) {
                dto.setPartyId(state.getPartyId());
            }
            if (returnedFieldsContains("PartyTypeId")) {
                dto.setPartyTypeId(state.getPartyTypeId());
            }
            if (returnedFieldsContains("PrimaryRoleTypeId")) {
                dto.setPrimaryRoleTypeId(state.getPrimaryRoleTypeId());
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
            if (returnedFieldsContains("Description")) {
                dto.setDescription(ss.getDescription());
            }
            if (returnedFieldsContains("Type")) {
                dto.setType(ss.getType());
            }
            if (returnedFieldsContains("IsSummary")) {
                dto.setIsSummary(ss.getIsSummary());
            }
          }
          // ////////////////
            return dto;
        }

    }
}

