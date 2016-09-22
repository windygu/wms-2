package org.dddml.wms.domain;


public class DayPlanMvoStateEventIdDtoWrapper extends DayPlanMvoStateEventIdDto
{
	
    private DayPlanMvoStateEventId value;

    public DayPlanMvoStateEventIdDtoWrapper()
    {
        this(new DayPlanMvoStateEventId());
    }

    public DayPlanMvoStateEventIdDtoWrapper(DayPlanMvoStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public DayPlanMvoStateEventId toDayPlanMvoStateEventId()
    {
        return this.value;
    }

    @Override
    public DayPlanIdDto getDayPlanId()
    {
        return new DayPlanIdDtoWrapper(this.value.getDayPlanId());
    }

    @Override
    public void setDayPlanId(DayPlanIdDto dayPlanId)
    {
        this.value.setDayPlanId(dayPlanId.toDayPlanId());
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
        if (obj.getClass() == DayPlanMvoStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        DayPlanMvoStateEventIdDtoWrapper other = (DayPlanMvoStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

