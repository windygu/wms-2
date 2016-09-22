package org.dddml.wms.domain;

import java.util.*;
import java.util.Date;
import org.dddml.wms.specialization.*;


public class YearPlanMvoStateDto
{

    private YearPlanIdDto yearPlanId;

    public YearPlanIdDto getYearPlanId()
    {
        return this.yearPlanId;
    }

    public void setYearPlanId(YearPlanIdDto yearPlanId)
    {
        this.yearPlanId = yearPlanId;
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

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
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

    private Date personBirthDate;

    public Date getPersonBirthDate()
    {
        return this.personBirthDate;
    }

    public void setPersonBirthDate(Date personBirthDate)
    {
        this.personBirthDate = personBirthDate;
    }

    private PersonalNameDto personLoves;

    public PersonalNameDto getPersonLoves()
    {
        return this.personLoves;
    }

    public void setPersonLoves(PersonalNameDto personLoves)
    {
        this.personLoves = personLoves;
    }

    private ContactDto personEmergencyContact;

    public ContactDto getPersonEmergencyContact()
    {
        return this.personEmergencyContact;
    }

    public void setPersonEmergencyContact(ContactDto personEmergencyContact)
    {
        this.personEmergencyContact = personEmergencyContact;
    }

    private String personCreatedBy;

    public String getPersonCreatedBy()
    {
        return this.personCreatedBy;
    }

    public void setPersonCreatedBy(String personCreatedBy)
    {
        this.personCreatedBy = personCreatedBy;
    }

    private String personUpdatedBy;

    public String getPersonUpdatedBy()
    {
        return this.personUpdatedBy;
    }

    public void setPersonUpdatedBy(String personUpdatedBy)
    {
        this.personUpdatedBy = personUpdatedBy;
    }

    private Date personCreatedAt;

    public Date getPersonCreatedAt()
    {
        return this.personCreatedAt;
    }

    public void setPersonCreatedAt(Date personCreatedAt)
    {
        this.personCreatedAt = personCreatedAt;
    }

    private Date personUpdatedAt;

    public Date getPersonUpdatedAt()
    {
        return this.personUpdatedAt;
    }

    public void setPersonUpdatedAt(Date personUpdatedAt)
    {
        this.personUpdatedAt = personUpdatedAt;
    }

    private Boolean personActive;

    public Boolean getPersonActive()
    {
        return this.personActive;
    }

    public void setPersonActive(Boolean personActive)
    {
        this.personActive = personActive;
    }

    private Boolean personDeleted;

    public Boolean getPersonDeleted()
    {
        return this.personDeleted;
    }

    public void setPersonDeleted(Boolean personDeleted)
    {
        this.personDeleted = personDeleted;
    }

    private Long personVersion;

    public Long getPersonVersion()
    {
        return this.personVersion;
    }

    public void setPersonVersion(Long personVersion)
    {
        this.personVersion = personVersion;
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

        public YearPlanMvoStateDto[] toYearPlanMvoStateDtoArray(Iterable<YearPlanMvoState> states) 
        {
            ArrayList<YearPlanMvoStateDto> stateDtos = new ArrayList();
            for (YearPlanMvoState s : states) {
                YearPlanMvoStateDto dto = toYearPlanMvoStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos.toArray(new YearPlanMvoStateDto[0]);
        }

        public YearPlanMvoStateDto toYearPlanMvoStateDto(YearPlanMvoState state)
        {
            YearPlanMvoStateDto dto = new YearPlanMvoStateDto();
            if (returnedFieldsContains("YearPlanId")) {
                dto.setYearPlanId((state.getYearPlanId() == null) ? null : new YearPlanIdDtoWrapper(state.getYearPlanId()));
            }
            if (returnedFieldsContains("Description")) {
                dto.setDescription(state.getDescription());
            }
            if (returnedFieldsContains("Version")) {
                dto.setVersion(state.getVersion());
            }
            if (returnedFieldsContains("Active")) {
                dto.setActive(state.getActive());
            }
            if (returnedFieldsContains("PersonBirthDate")) {
                dto.setPersonBirthDate(state.getPersonBirthDate());
            }
            if (returnedFieldsContains("PersonLoves")) {
                dto.setPersonLoves((state.getPersonLoves() == null) ? null : new PersonalNameDtoWrapper(state.getPersonLoves()));
            }
            if (returnedFieldsContains("PersonEmergencyContact")) {
                dto.setPersonEmergencyContact((state.getPersonEmergencyContact() == null) ? null : new ContactDtoWrapper(state.getPersonEmergencyContact()));
            }
            if (returnedFieldsContains("PersonCreatedBy")) {
                dto.setPersonCreatedBy(state.getPersonCreatedBy());
            }
            if (returnedFieldsContains("PersonUpdatedBy")) {
                dto.setPersonUpdatedBy(state.getPersonUpdatedBy());
            }
            if (returnedFieldsContains("PersonCreatedAt")) {
                dto.setPersonCreatedAt(state.getPersonCreatedAt());
            }
            if (returnedFieldsContains("PersonUpdatedAt")) {
                dto.setPersonUpdatedAt(state.getPersonUpdatedAt());
            }
            if (returnedFieldsContains("PersonActive")) {
                dto.setPersonActive(state.getPersonActive());
            }
            if (returnedFieldsContains("PersonDeleted")) {
                dto.setPersonDeleted(state.getPersonDeleted());
            }
            if (returnedFieldsContains("PersonVersion")) {
                dto.setPersonVersion(state.getPersonVersion());
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
            return dto;
        }

    }
}

