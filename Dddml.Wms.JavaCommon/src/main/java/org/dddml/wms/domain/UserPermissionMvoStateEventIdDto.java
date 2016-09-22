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
            && (userPermissionId == other.userPermissionId || (userPermissionId != null && userPermissionId.equals(other.userPermissionId)))
            && (userVersion == other.userVersion || (userVersion != null && userVersion.equals(other.userVersion)))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.userPermissionId != null) {
            hash += 13 * this.userPermissionId.hashCode();
        }
        if (this.userVersion != null) {
            hash += 13 * this.userVersion.hashCode();
        }
        return hash;
    }

}

