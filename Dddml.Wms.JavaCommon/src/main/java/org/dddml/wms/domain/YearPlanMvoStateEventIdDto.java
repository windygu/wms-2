package org.dddml.wms.domain;


public class YearPlanMvoStateEventIdDto
{

    public YearPlanMvoStateEventIdDto()
    {
    }

    public YearPlanMvoStateEventId toYearPlanMvoStateEventId()
    {
        YearPlanMvoStateEventId v = new YearPlanMvoStateEventId();
        v.setYearPlanId(this.getYearPlanId().toYearPlanId());
        v.setPersonVersion(this.getPersonVersion());
        return v;
    }

    private YearPlanIdDto yearPlanId = new YearPlanIdDto();

    public YearPlanIdDto getYearPlanId()
    {
        return this.yearPlanId;
    }

    public void setYearPlanId(YearPlanIdDto yearPlanId)
    {
        this.yearPlanId = yearPlanId;
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
        if (obj == null || obj.getClass() != YearPlanMvoStateEventIdDto.class) {
            return false;
        }

        YearPlanMvoStateEventIdDto other = (YearPlanMvoStateEventIdDto)obj;
        return true 
            && (yearPlanId == other.yearPlanId || (yearPlanId != null && yearPlanId.equals(other.yearPlanId)))
            && (personVersion == other.personVersion || (personVersion != null && personVersion.equals(other.personVersion)))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.yearPlanId != null) {
            hash += 13 * this.yearPlanId.hashCode();
        }
        if (this.personVersion != null) {
            hash += 13 * this.personVersion.hashCode();
        }
        return hash;
    }

}

