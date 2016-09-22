package org.dddml.wms.domain;


public class TeamStateEventIdDtoWrapper extends TeamStateEventIdDto
{
	
    private TeamStateEventId value;

    public TeamStateEventIdDtoWrapper()
    {
        this(new TeamStateEventId());
    }

    public TeamStateEventIdDtoWrapper(TeamStateEventId value)
    {
        this.value = value;
    }

    public TeamStateEventId toTeamStateEventId()
    {
        return this.value;
    }

    @Override
    public String getTeamName()
    {
        return this.value.getTeamName();
    }

    @Override
    public void setTeamName(String teamName)
    {
        this.value.setTeamName(teamName);
    }

    @Override
    public Long getVersion()
    {
        return this.value.getVersion();
    }

    @Override
    public void setVersion(Long version)
    {
        this.value.setVersion(version);
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
        if (obj.getClass() == TeamStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        TeamStateEventIdDtoWrapper other = (TeamStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

    //@Override
    //public int hashCode()
    //{
    //    return value.hashCode();
    //}

}

