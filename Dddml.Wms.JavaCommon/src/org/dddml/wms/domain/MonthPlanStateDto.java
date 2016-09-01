package org.dddml.wms.domain;

import java.util.*;
import java.util.Date;
import org.dddml.wms.specialization.*;


public class MonthPlanStateDto
{

    private Integer month;

    public Integer getMonth()
    {
        return this.month;
    }

    public void setMonth(Integer month)
    {
        this.month = month;
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

    private Integer year;

    public Integer getYear()
    {
        return this.year;
    }

    public void setYear(Integer year)
    {
        this.year = year;
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

    private DayPlanStateDto[] dayPlans;

    public DayPlanStateDto[] getDayPlans()
    {
        return this.dayPlans;
    }	

    public void setDayPlans(DayPlanStateDto[] dayPlans)
    {
        this.dayPlans = dayPlans;
    }


    public static class DtoConverter extends AbstractStateDtoConverter
    {
        public static Collection<String> collectionFieldNames = Arrays.asList(new String[]{"DayPlans"});

        @Override
        protected boolean isCollectionField(String fieldName) {
            return CollectionUtils.collectionContainsIgnoringCase(collectionFieldNames, fieldName);
        }

        public MonthPlanStateDto[] toMonthPlanStateDtoArray(Iterable<MonthPlanState> states) 
        {
            ArrayList<MonthPlanStateDto> stateDtos = new ArrayList();
            for (MonthPlanState s : states) {
                MonthPlanStateDto dto = toMonthPlanStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos.toArray(new MonthPlanStateDto[0]);
        }

        public MonthPlanStateDto toMonthPlanStateDto(MonthPlanState state)
        {
            MonthPlanStateDto dto = new MonthPlanStateDto();
            if (returnedFieldsContains("Month")) {
                dto.setMonth(state.getMonth());
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
                dto.setPersonalName((state.getPersonalName() == null) ? null : new PersonalNameDto(state.getPersonalName()));
            }
            if (returnedFieldsContains("Year")) {
                dto.setYear(state.getYear());
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
            if (returnedFieldsContains("DayPlans")) {
                ArrayList<DayPlanStateDto> arrayList = new ArrayList();
                if (state.getDayPlans() != null) {
                    DayPlanStateDto.DtoConverter conv = new DayPlanStateDto.DtoConverter();
                    String returnFS = CollectionUtils.mapGetValueIgnoringCase(getReturnedFields(), "DayPlans");
                    if(returnFS != null) { conv.setReturnedFieldsString(returnFS); } else { conv.setAllFieldsReturned(this.getAllFieldsReturned()); }
                    for (DayPlanState s : state.getDayPlans()) {
                        arrayList.add(conv.toDayPlanStateDto(s));
                    }
                }
                dto.setDayPlans(arrayList.toArray(new DayPlanStateDto[0]));
            }
            return dto;
        }

    }
}

