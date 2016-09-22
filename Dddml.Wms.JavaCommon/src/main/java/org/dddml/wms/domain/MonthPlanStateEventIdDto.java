package org.dddml.wms.domain;


public class MonthPlanStateEventIdDto
{

    public MonthPlanStateEventIdDto()
    {
    }

    public MonthPlanStateEventId toMonthPlanStateEventId()
    {
        MonthPlanStateEventId v = new MonthPlanStateEventId();
        v.setPersonalName(this.getPersonalName().toPersonalName());
        v.setYear(this.getYear());
        v.setMonth(this.getMonth());
        v.setPersonVersion(this.getPersonVersion());
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

    private Long personVersion;

    public Long getPersonVersion()
    {
        return this.personVersion;
    }

    public void setPersonVersion(Long personVersion)
    {
        this.personVersion = personVersion;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != MonthPlanStateEventIdDto.class) {
            return false;
        }

        MonthPlanStateEventIdDto other = (MonthPlanStateEventIdDto)obj;
        return true 
            && (getPersonalName() == other.getPersonalName() || (getPersonalName() != null && getPersonalName().equals(other.getPersonalName())))
            && (getYear() == other.getYear() || (getYear() != null && getYear().equals(other.getYear())))
            && (getMonth() == other.getMonth() || (getMonth() != null && getMonth().equals(other.getMonth())))
            && (getPersonVersion() == other.getPersonVersion() || (getPersonVersion() != null && getPersonVersion().equals(other.getPersonVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getPersonalName() != null) {
            hash += 13 * this.getPersonalName().hashCode();
        }
        if (this.getYear() != null) {
            hash += 13 * this.getYear().hashCode();
        }
        if (this.getMonth() != null) {
            hash += 13 * this.getMonth().hashCode();
        }
        if (this.getPersonVersion() != null) {
            hash += 13 * this.getPersonVersion().hashCode();
        }
        return hash;
    }

}

