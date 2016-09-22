package org.dddml.wms.domain;


public class TeamStateEventIdDto
{

    public TeamStateEventIdDto()
    {
    }

    public TeamStateEventId toTeamStateEventId()
    {
        TeamStateEventId v = new TeamStateEventId();
        v.setTeamName(this.getTeamName());
        v.setVersion(this.getVersion());
        return v;
    }

    private String teamName;

    public String getTeamName()
    {
        return this.teamName;
    }

    public void setTeamName(String teamName)
    {
        this.teamName = teamName;
    }

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != TeamStateEventIdDto.class) {
            return false;
        }

        TeamStateEventIdDto other = (TeamStateEventIdDto)obj;
        return true 
            && (teamName == other.teamName || (teamName != null && teamName.equals(other.teamName)))
            && (version == other.version || (version != null && version.equals(other.version)))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.teamName != null) {
            hash += 13 * this.teamName.hashCode();
        }
        if (this.version != null) {
            hash += 13 * this.version.hashCode();
        }
        return hash;
    }

}

