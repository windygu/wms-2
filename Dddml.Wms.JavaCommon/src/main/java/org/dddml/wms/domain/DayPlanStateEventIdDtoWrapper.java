package org.dddml.wms.domain;


public class DayPlanStateEventIdDtoWrapper extends DayPlanStateEventIdDto
{
	
    private DayPlanStateEventId value;

    public DayPlanStateEventIdDtoWrapper()
    {
        this(new DayPlanStateEventId());
    }

    public DayPlanStateEventIdDtoWrapper(DayPlanStateEventId value)
    {
        this.value = value;
    }

    public DayPlanStateEventId toDayPlanStateEventId()
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
    public Integer getDay()
    {
        return this.value.getDay();
    }

    @Override
    public void setDay(Integer day)
    {
        this.value.setDay(day);
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
        if (obj.getClass() == DayPlanStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        DayPlanStateEventIdDtoWrapper other = (DayPlanStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

    //@Override
    //public int hashCode()
    //{
    //    return value.hashCode();
    //}

}

