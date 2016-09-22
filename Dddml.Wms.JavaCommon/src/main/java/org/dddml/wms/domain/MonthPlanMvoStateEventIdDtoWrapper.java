package org.dddml.wms.domain;


public class MonthPlanMvoStateEventIdDtoWrapper extends MonthPlanMvoStateEventIdDto
{
	
    private MonthPlanMvoStateEventId value;

    public MonthPlanMvoStateEventIdDtoWrapper()
    {
        this(new MonthPlanMvoStateEventId());
    }

    public MonthPlanMvoStateEventIdDtoWrapper(MonthPlanMvoStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public MonthPlanMvoStateEventId toMonthPlanMvoStateEventId()
    {
        return this.value;
    }

    @Override
    public MonthPlanIdDto getMonthPlanId()
    {
        return new MonthPlanIdDtoWrapper(this.value.getMonthPlanId());
    }

    @Override
    public void setMonthPlanId(MonthPlanIdDto monthPlanId)
    {
        this.value.setMonthPlanId(monthPlanId.toMonthPlanId());
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
        if (obj.getClass() == MonthPlanMvoStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        MonthPlanMvoStateEventIdDtoWrapper other = (MonthPlanMvoStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

