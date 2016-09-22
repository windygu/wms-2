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
            && (monthPlanId == other.monthPlanId || (monthPlanId != null && monthPlanId.equals(other.monthPlanId)))
            && (personVersion == other.personVersion || (personVersion != null && personVersion.equals(other.personVersion)))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.monthPlanId != null) {
            hash += 13 * this.monthPlanId.hashCode();
        }
        if (this.personVersion != null) {
            hash += 13 * this.personVersion.hashCode();
        }
        return hash;
    }

}

