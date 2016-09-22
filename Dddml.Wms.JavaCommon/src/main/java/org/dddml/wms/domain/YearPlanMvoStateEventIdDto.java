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
            && (getYearPlanId() == other.getYearPlanId() || (getYearPlanId() != null && getYearPlanId().equals(other.getYearPlanId())))
            && (getPersonVersion() == other.getPersonVersion() || (getPersonVersion() != null && getPersonVersion().equals(other.getPersonVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getYearPlanId() != null) {
            hash += 13 * this.getYearPlanId().hashCode();
        }
        if (this.getPersonVersion() != null) {
            hash += 13 * this.getPersonVersion().hashCode();
        }
        return hash;
    }

}

