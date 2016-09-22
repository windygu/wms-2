package org.dddml.wms.domain;


public class DayPlanMvoStateEventIdDto
{

    public DayPlanMvoStateEventIdDto()
    {
    }

    public DayPlanMvoStateEventId toDayPlanMvoStateEventId()
    {
        DayPlanMvoStateEventId v = new DayPlanMvoStateEventId();
        v.setDayPlanId(this.getDayPlanId().toDayPlanId());
        v.setPersonVersion(this.getPersonVersion());
        return v;
    }

    private DayPlanIdDto dayPlanId = new DayPlanIdDto();

    public DayPlanIdDto getDayPlanId()
    {
        return this.dayPlanId;
    }

    public void setDayPlanId(DayPlanIdDto dayPlanId)
    {
        this.dayPlanId = dayPlanId;
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
        if (obj == null || obj.getClass() != DayPlanMvoStateEventIdDto.class) {
            return false;
        }

        DayPlanMvoStateEventIdDto other = (DayPlanMvoStateEventIdDto)obj;
        return true 
            && (dayPlanId == other.dayPlanId || (dayPlanId != null && dayPlanId.equals(other.dayPlanId)))
            && (personVersion == other.personVersion || (personVersion != null && personVersion.equals(other.personVersion)))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.dayPlanId != null) {
            hash += 13 * this.dayPlanId.hashCode();
        }
        if (this.personVersion != null) {
            hash += 13 * this.personVersion.hashCode();
        }
        return hash;
    }

}

