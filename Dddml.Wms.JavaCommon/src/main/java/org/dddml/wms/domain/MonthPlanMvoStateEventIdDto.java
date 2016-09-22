package org.dddml.wms.domain;


public class MonthPlanMvoStateEventIdDto
{

    public MonthPlanMvoStateEventIdDto()
    {
    }

    public MonthPlanMvoStateEventId toMonthPlanMvoStateEventId()
    {
        MonthPlanMvoStateEventId v = new MonthPlanMvoStateEventId();
        v.setMonthPlanId(this.getMonthPlanId().toMonthPlanId());
        v.setPersonVersion(this.getPersonVersion());
        return v;
    }

    private MonthPlanIdDto monthPlanId = new MonthPlanIdDto();

    public MonthPlanIdDto getMonthPlanId()
    {
        return this.monthPlanId;
    }

    public void setMonthPlanId(MonthPlanIdDto monthPlanId)
    {
        this.monthPlanId = monthPlanId;
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
        if (obj == null || obj.getClass() != MonthPlanMvoStateEventIdDto.class) {
            return false;
        }

        MonthPlanMvoStateEventIdDto other = (MonthPlanMvoStateEventIdDto)obj;
        return true 
            && (getMonthPlanId() == other.getMonthPlanId() || (getMonthPlanId() != null && getMonthPlanId().equals(other.getMonthPlanId())))
            && (getPersonVersion() == other.getPersonVersion() || (getPersonVersion() != null && getPersonVersion().equals(other.getPersonVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getMonthPlanId() != null) {
            hash += 13 * this.getMonthPlanId().hashCode();
        }
        if (this.getPersonVersion() != null) {
            hash += 13 * this.getPersonVersion().hashCode();
        }
        return hash;
    }

}

