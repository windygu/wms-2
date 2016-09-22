package org.dddml.wms.domain;

import java.util.*;
import java.util.Date;
import org.dddml.wms.specialization.*;


public class PersonStateDto
{

    private PersonalNameDto personalName;

    public PersonalNameDto getPersonalName()
    {
        return this.personalName;
    }

    public void setPersonalName(PersonalNameDto personalName)
    {
        this.personalName = personalName;
    }

    private Date birthDate;

    public Date getBirthDate()
    {
        return this.birthDate;
    }

    public void setBirthDate(Date birthDate)
    {
        this.birthDate = birthDate;
    }

    private PersonalNameDto loves;

    public PersonalNameDto getLoves()
    {
        return this.loves;
    }

    public void setLoves(PersonalNameDto loves)
    {
        this.loves = loves;
    }

    private ContactDto emergencyContact;

    public ContactDto getEmergencyContact()
    {
        return this.emergencyContact;
    }

    public void setEmergencyContact(ContactDto emergencyContact)
    {
        this.emergencyContact = emergencyContact;
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

    private YearPlanStateDto[] yearPlans;

    public YearPlanStateDto[] getYearPlans()
    {
        return this.yearPlans;
    }	

    public void setYearPlans(YearPlanStateDto[] yearPlans)
    {
        this.yearPlans = yearPlans;
    }


    public static class DtoConverter extends AbstractStateDtoConverter
    {
        public static Collection<String> collectionFieldNames = Arrays.asList(new String[]{"YearPlans"});

        @Override
        protected boolean isCollectionField(String fieldName) {
            return CollectionUtils.collectionContainsIgnoringCase(collectionFieldNames, fieldName);
        }

        public PersonStateDto[] toPersonStateDtoArray(Iterable<PersonState> states) 
        {
            ArrayList<PersonStateDto> stateDtos = new ArrayList();
            for (PersonState s : states) {
                PersonStateDto dto = toPersonStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos.toArray(new PersonStateDto[0]);
        }

        public PersonStateDto toPersonStateDto(PersonState state)
        {
            PersonStateDto dto = new PersonStateDto();
            if (returnedFieldsContains("PersonalName")) {
                dto.setPersonalName((state.getPersonalName() == null) ? null : new PersonalNameDtoWrapper(state.getPersonalName()));
            }
            if (returnedFieldsContains("BirthDate")) {
                dto.setBirthDate(state.getBirthDate());
            }
            if (returnedFieldsContains("Loves")) {
                dto.setLoves((state.getLoves() == null) ? null : new PersonalNameDtoWrapper(state.getLoves()));
            }
            if (returnedFieldsContains("EmergencyContact")) {
                dto.setEmergencyContact((state.getEmergencyContact() == null) ? null : new ContactDtoWrapper(state.getEmergencyContact()));
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
            if (returnedFieldsContains("YearPlans")) {
                ArrayList<YearPlanStateDto> arrayList = new ArrayList();
                if (state.getYearPlans() != null) {
                    YearPlanStateDto.DtoConverter conv = new YearPlanStateDto.DtoConverter();
                    String returnFS = CollectionUtils.mapGetValueIgnoringCase(getReturnedFields(), "YearPlans");
                    if(returnFS != null) { conv.setReturnedFieldsString(returnFS); } else { conv.setAllFieldsReturned(this.getAllFieldsReturned()); }
                    for (YearPlanState s : state.getYearPlans()) {
                        arrayList.add(conv.toYearPlanStateDto(s));
                    }
                }
                dto.setYearPlans(arrayList.toArray(new YearPlanStateDto[0]));
            }
            return dto;
        }

    }
}

