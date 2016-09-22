package org.dddml.wms.domain;


public class YearPlanIdDtoWrapper extends YearPlanIdDto
{
	
    private YearPlanId value;

    public YearPlanIdDtoWrapper()
    {
        this(new YearPlanId());
    }

    public YearPlanIdDtoWrapper(YearPlanId value)
    {
        this.value = value;
    }

    public YearPlanId toYearPlanId()
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
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == YearPlanIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        YearPlanIdDtoWrapper other = (YearPlanIdDtoWrapper)obj;
        return value.equals(other.value);
    }

    //@Override
    //public int hashCode()
    //{
    //    return value.hashCode();
    //}

}

