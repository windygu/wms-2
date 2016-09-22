package org.dddml.wms.domain;


public class YearPlanStateEventIdDtoWrapper extends YearPlanStateEventIdDto
{
	
    private YearPlanStateEventId value;

    public YearPlanStateEventIdDtoWrapper()
    {
        this(new YearPlanStateEventId());
    }

    public YearPlanStateEventIdDtoWrapper(YearPlanStateEventId value)
    {
        this.value = value;
    }

    public YearPlanStateEventId toYearPlanStateEventId()
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
        if (obj.getClass() == YearPlanStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        YearPlanStateEventIdDtoWrapper other = (YearPlanStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

    //@Override
    //public int hashCode()
    //{
    //    return value.hashCode();
    //}

}

