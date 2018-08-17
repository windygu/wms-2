package org.dddml.wms.domain.party;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class PartyStateDto
{

    private String partyId;

    public String getPartyId()
    {
        return this.partyId;
    }

    public void setPartyId(String partyId)
    {
        this.partyId = partyId;
    }

    private String partyTypeId;

    public String getPartyTypeId()
    {
        return this.partyTypeId;
    }

    public void setPartyTypeId(String partyTypeId)
    {
        this.partyTypeId = partyTypeId;
    }

    private String primaryRoleTypeId;

    public String getPrimaryRoleTypeId()
    {
        return this.primaryRoleTypeId;
    }

    public void setPrimaryRoleTypeId(String primaryRoleTypeId)
    {
        this.primaryRoleTypeId = primaryRoleTypeId;
    }

    private String externalId;

    public String getExternalId()
    {
        return this.externalId;
    }

    public void setExternalId(String externalId)
    {
        this.externalId = externalId;
    }

    private String preferredCurrencyUomId;

    public String getPreferredCurrencyUomId()
    {
        return this.preferredCurrencyUomId;
    }

    public void setPreferredCurrencyUomId(String preferredCurrencyUomId)
    {
        this.preferredCurrencyUomId = preferredCurrencyUomId;
    }

    private String description;

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    private String organizationName;

    public String getOrganizationName()
    {
        return this.organizationName;
    }

    public void setOrganizationName(String organizationName)
    {
        this.organizationName = organizationName;
    }

    private Boolean isSummary;

    public Boolean getIsSummary()
    {
        return this.isSummary;
    }

    public void setIsSummary(Boolean isSummary)
    {
        this.isSummary = isSummary;
    }

    private String salutation;

    public String getSalutation()
    {
        return this.salutation;
    }

    public void setSalutation(String salutation)
    {
        this.salutation = salutation;
    }

    private String firstName;

    public String getFirstName()
    {
        return this.firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    private String middleName;

    public String getMiddleName()
    {
        return this.middleName;
    }

    public void setMiddleName(String middleName)
    {
        this.middleName = middleName;
    }

    private String lastName;

    public String getLastName()
    {
        return this.lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    private String personalTitle;

    public String getPersonalTitle()
    {
        return this.personalTitle;
    }

    public void setPersonalTitle(String personalTitle)
    {
        this.personalTitle = personalTitle;
    }

    private String nickname;

    public String getNickname()
    {
        return this.nickname;
    }

    public void setNickname(String nickname)
    {
        this.nickname = nickname;
    }

    private String cardId;

    public String getCardId()
    {
        return this.cardId;
    }

    public void setCardId(String cardId)
    {
        this.cardId = cardId;
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


    public static class DtoConverter extends AbstractStateDtoConverter
    {
        public static Collection<String> collectionFieldNames = Arrays.asList(new String[]{});

        @Override
        protected boolean isCollectionField(String fieldName) {
            return CollectionUtils.collectionContainsIgnoringCase(collectionFieldNames, fieldName);
        }

        public PartyStateDto[] toPartyStateDtoArray(Iterable<PartyState> states) {
            return toPartyStateDtoList(states).toArray(new PartyStateDto[0]);
        }

        public List<PartyStateDto> toPartyStateDtoList(Iterable<PartyState> states) {
            ArrayList<PartyStateDto> stateDtos = new ArrayList();
            for (PartyState s : states) {
                PartyStateDto dto = toPartyStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos;
        }

        public PartyStateDto toPartyStateDto(PartyState state)
        {
            if(state == null) {
                return null;
            }
            PartyStateDto dto = new PartyStateDto();
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

