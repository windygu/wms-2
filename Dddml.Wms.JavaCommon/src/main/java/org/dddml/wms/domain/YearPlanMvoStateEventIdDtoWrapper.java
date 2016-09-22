package org.dddml.wms.domain;


public class YearPlanMvoStateEventIdDtoWrapper extends YearPlanMvoStateEventIdDto
{
	
    private YearPlanMvoStateEventId value;

    public YearPlanMvoStateEventIdDtoWrapper()
    {
        this(new YearPlanMvoStateEventId());
    }

    public YearPlanMvoStateEventIdDtoWrapper(YearPlanMvoStateEventId value)
    {
        this.value = value;
    }

    public YearPlanMvoStateEventId toYearPlanMvoStateEventId()
    {
        return this.value;
    }

    @Override
    public YearPlanIdDto getYearPlanId()
    {
        return new YearPlanIdDtoWrapper(this.value.getYearPlanId());
    }

    @Override
    public void setYearPlanId(YearPlanIdDto yearPlanId)
    {
        this.value.setYearPlanId(yearPlanId.toYearPlanId());
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
        if (obj.getClass() == YearPlanMvoStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        YearPlanMvoStateEventIdDtoWrapper other = (YearPlanMvoStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

    //@Override
    //public int hashCode()
    //{
    //    return value.hashCode();
    //}

}

