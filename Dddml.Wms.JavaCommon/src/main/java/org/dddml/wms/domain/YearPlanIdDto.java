package org.dddml.wms.domain;


public class YearPlanIdDto
{

    public YearPlanIdDto()
    {
    }

    public YearPlanId toYearPlanId()
    {
        YearPlanId v = new YearPlanId();
        v.setPersonalName(this.getPersonalName().toPersonalName());
        v.setYear(this.getYear());
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


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != YearPlanIdDto.class) {
            return false;
        }

        YearPlanIdDto other = (YearPlanIdDto)obj;
        return true 
            && (personalName == other.personalName || (personalName != null && personalName.equals(other.personalName)))
            && (year == other.year || (year != null && year.equals(other.year)))
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
        return hash;
    }

}

