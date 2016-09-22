package org.dddml.wms.domain;


public class MonthPlanStateEventIdDtoWrapper extends MonthPlanStateEventIdDto
{
	
    private MonthPlanStateEventId value;

    public MonthPlanStateEventIdDtoWrapper()
    {
        this(new MonthPlanStateEventId());
    }

    public MonthPlanStateEventIdDtoWrapper(MonthPlanStateEventId value)
    {
        this.value = value;
    }

    public MonthPlanStateEventId toMonthPlanStateEventId()
    {
        return this.value;
    }

    @Override
    public PersonalNameDto getPersonalName()
    {
        return new PersonalNameDtoWrapper(this.value.getPersonalName());
    }

    @Override
    public void setPersonalName(PersonalNameDto personalName)
    {
        this.value.setPersonalName(personalName.toPersonalName());
    }

    @Override
    public Integer getYear()
    {
        return this.value.getYear();
    }

    @Override
    public void setYear(Integer year)
    {
        this.value.setYear(year);
    }

    @Override
    public Integer getMonth()
    {
        return this.value.getMonth();
    }

    @Override
    public void setMonth(Integer month)
    {
        this.value.setMonth(month);
    }

    @Override
    public Long getPersonVersion()
    {
        return this.value.getPersonVersion();
    }

    @Override
    public void setPersonVersion(Long personVersion)
    {
        this.value.setPersonVersion(personVersion);
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == MonthPlanStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        MonthPlanStateEventIdDtoWrapper other = (MonthPlanStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

