package org.dddml.wms.domain;


public class UserPermissionMvoStateEventIdDto
{

    public UserPermissionMvoStateEventIdDto()
    {
    }

    public UserPermissionMvoStateEventId toUserPermissionMvoStateEventId()
    {
        UserPermissionMvoStateEventId v = new UserPermissionMvoStateEventId();
        v.setUserPermissionId(this.getUserPermissionId().toUserPermissionId());
        v.setUserVersion(this.getUserVersion());
        return v;
    }

    private UserPermissionIdDto userPermissionId = new UserPermissionIdDto();

    public UserPermissionIdDto getUserPermissionId()
    {
        return this.userPermissionId;
    }

    public void setUserPermissionId(UserPermissionIdDto userPermissionId)
    {
        this.userPermissionId = userPermissionId;
    }

    private Long userVersion;

    public Long getUserVersion()
    {
        return this.userVersion;
    }

    public void setUserVersion(Long userVersion)
    {
        this.userVersion = userVersion;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != UserPermissionMvoStateEventIdDto.class) {
            return false;
        }

        UserPermissionMvoStateEventIdDto other = (UserPermissionMvoStateEventIdDto)obj;
        return true 
            && (getUserPermissionId() == other.getUserPermissionId() || (getUserPermissionId() != null && getUserPermissionId().equals(other.getUserPermissionId())))
            && (getUserVersion() == other.getUserVersion() || (getUserVersion() != null && getUserVersion().equals(other.getUserVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getUserPermissionId() != null) {
            hash += 13 * this.getUserPermissionId().hashCode();
        }
        if (this.getUserVersion() != null) {
            hash += 13 * this.getUserVersion().hashCode();
        }
        return hash;
    }

}

