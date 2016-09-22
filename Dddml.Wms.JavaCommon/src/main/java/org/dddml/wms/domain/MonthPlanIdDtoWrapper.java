package org.dddml.wms.domain;


public class MonthPlanIdDtoWrapper extends MonthPlanIdDto
{
	
    private MonthPlanId value;

    public MonthPlanIdDtoWrapper()
    {
        this(new MonthPlanId());
    }

    public MonthPlanIdDtoWrapper(MonthPlanId value)
    {
        this.value = value;
    }

    public MonthPlanId toMonthPlanId()
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
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == MonthPlanIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        MonthPlanIdDtoWrapper other = (MonthPlanIdDtoWrapper)obj;
        return value.equals(other.value);
    }

    //@Override
    //public int hashCode()
    //{
    //    return value.hashCode();
    //}

}

