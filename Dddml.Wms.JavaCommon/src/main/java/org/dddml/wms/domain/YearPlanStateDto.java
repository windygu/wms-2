package org.dddml.wms.domain;

import java.util.*;
import java.util.Date;
import org.dddml.wms.specialization.*;


public class YearPlanStateDto
{

    private Integer year;

    public Integer getYear()
    {
        return this.year;
    }

    public void setYear(Integer year)
    {
        this.year = year;
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

    private PersonalNameDto personalName;

    public PersonalNameDto getPersonalName()
    {
        return this.personalName;
    }

    public void setPersonalName(PersonalNameDto personalName)
    {
        this.personalName = personalName;
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

    private MonthPlanStateDto[] monthPlans;

    public MonthPlanStateDto[] getMonthPlans()
    {
        return this.monthPlans;
    }	

    public void setMonthPlans(MonthPlanStateDto[] monthPlans)
    {
        this.monthPlans = monthPlans;
    }


    public static class DtoConverter extends AbstractStateDtoConverter
    {
        public static Collection<String> collectionFieldNames = Arrays.asList(new String[]{"MonthPlans"});

        @Override
        protected boolean isCollectionField(String fieldName) {
            return CollectionUtils.collectionContainsIgnoringCase(collectionFieldNames, fieldName);
        }

        public YearPlanStateDto[] toYearPlanStateDtoArray(Iterable<YearPlanState> states) 
        {
            ArrayList<YearPlanStateDto> stateDtos = new ArrayList();
            for (YearPlanState s : states) {
                YearPlanStateDto dto = toYearPlanStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos.toArray(new YearPlanStateDto[0]);
        }

        public YearPlanStateDto toYearPlanStateDto(YearPlanState state)
        {
            YearPlanStateDto dto = new YearPlanStateDto();
            if (returnedFieldsContains("Year")) {
                dto.setYear(state.getYear());
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
            if (returnedFieldsContains("PersonalName")) {
                dto.setPersonalName((state.getPersonalName() == null) ? null : new PersonalNameDtoWrapper(state.getPersonalName()));
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
            if (returnedFieldsContains("MonthPlans")) {
                ArrayList<MonthPlanStateDto> arrayList = new ArrayList();
                if (state.getMonthPlans() != null) {
                    MonthPlanStateDto.DtoConverter conv = new MonthPlanStateDto.DtoConverter();
                    String returnFS = CollectionUtils.mapGetValueIgnoringCase(getReturnedFields(), "MonthPlans");
                    if(returnFS != null) { conv.setReturnedFieldsString(returnFS); } else { conv.setAllFieldsReturned(this.getAllFieldsReturned()); }
                    for (MonthPlanState s : state.getMonthPlans()) {
                        arrayList.add(conv.toMonthPlanStateDto(s));
                    }
                }
                dto.setMonthPlans(arrayList.toArray(new MonthPlanStateDto[0]));
            }
            return dto;
        }

    }
}

