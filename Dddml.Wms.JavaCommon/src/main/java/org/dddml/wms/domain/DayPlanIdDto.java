package org.dddml.wms.domain;


public class DayPlanIdDto
{

    public DayPlanIdDto()
    {
    }

    public DayPlanId toDayPlanId()
    {
        DayPlanId v = new DayPlanId();
        v.setPersonalName(this.getPersonalName().toPersonalName());
        v.setYear(this.getYear());
        v.setMonth(this.getMonth());
        v.setDay(this.getDay());
        return v;
    }

    private PersonalNameDto personalName = new PersonalNameDto();

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

    private Integer month;

    public Integer getMonth()
    {
        return this.month;
    }

    public void setMonth(Integer month)
    {
        this.month = month;
    }

    private Integer day;

    public Integer getDay()
    {
        return this.day;
    }

    public void setDay(Integer day)
    {
        this.day = day;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != DayPlanIdDto.class) {
            return false;
        }

        DayPlanIdDto other = (DayPlanIdDto)obj;
        return true 
            && (personalName == other.personalName || (personalName != null && personalName.equals(other.personalName)))
            && (year == other.year || (year != null && year.equals(other.year)))
            && (month == other.month || (month != null && month.equals(other.month)))
            && (day == other.day || (day != null && day.equals(other.day)))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.personalName != null) {
            hash += 13 * this.personalName.hashCode();
        }
        if (this.year != null) {
            hash += 13 * this.year.hashCode();
        }
        if (this.month != null) {
            hash += 13 * this.month.hashCode();
        }
        if (this.day != null) {
            hash += 13 * this.day.hashCode();
        }
        return hash;
    }

}

