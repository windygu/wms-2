package org.dddml.wms.domain;

import java.util.*;
import java.util.Date;
import org.dddml.wms.specialization.*;


public class UserLoginMvoStateDto
{

    private UserLoginIdDto userLoginId;

    public UserLoginIdDto getUserLoginId()
    {
        return this.userLoginId;
    }

    public void setUserLoginId(UserLoginIdDto userLoginId)
    {
        this.userLoginId = userLoginId;
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

    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }

    private String userUserName;

    public String getUserUserName()
    {
        return this.userUserName;
    }

    public void setUserUserName(String userUserName)
    {
        this.userUserName = userUserName;
    }

    private Integer userAccessFailedCount;

    public Integer getUserAccessFailedCount()
    {
        return this.userAccessFailedCount;
    }

    public void setUserAccessFailedCount(Integer userAccessFailedCount)
    {
        this.userAccessFailedCount = userAccessFailedCount;
    }

    private String userEmail;

    public String getUserEmail()
    {
        return this.userEmail;
    }

    public void setUserEmail(String userEmail)
    {
        this.userEmail = userEmail;
    }

    private Boolean userEmailConfirmed;

    public Boolean getUserEmailConfirmed()
    {
        return this.userEmailConfirmed;
    }

    public void setUserEmailConfirmed(Boolean userEmailConfirmed)
    {
        this.userEmailConfirmed = userEmailConfirmed;
    }

    private Boolean userLockoutEnabled;

    public Boolean getUserLockoutEnabled()
    {
        return this.userLockoutEnabled;
    }

    public void setUserLockoutEnabled(Boolean userLockoutEnabled)
    {
        this.userLockoutEnabled = userLockoutEnabled;
    }

    private Date userLockoutEndDateUtc;

    public Date getUserLockoutEndDateUtc()
    {
        return this.userLockoutEndDateUtc;
    }

    public void setUserLockoutEndDateUtc(Date userLockoutEndDateUtc)
    {
        this.userLockoutEndDateUtc = userLockoutEndDateUtc;
    }

    private String userPasswordHash;

    public String getUserPasswordHash()
    {
        return this.userPasswordHash;
    }

    public void setUserPasswordHash(String userPasswordHash)
    {
        this.userPasswordHash = userPasswordHash;
    }

    private String userPhoneNumber;

    public String getUserPhoneNumber()
    {
        return this.userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber)
    {
        this.userPhoneNumber = userPhoneNumber;
    }

    private Boolean userPhoneNumberConfirmed;

    public Boolean getUserPhoneNumberConfirmed()
    {
        return this.userPhoneNumberConfirmed;
    }

    public void setUserPhoneNumberConfirmed(Boolean userPhoneNumberConfirmed)
    {
        this.userPhoneNumberConfirmed = userPhoneNumberConfirmed;
    }

    private Boolean userTwoFactorEnabled;

    public Boolean getUserTwoFactorEnabled()
    {
        return this.userTwoFactorEnabled;
    }

    public void setUserTwoFactorEnabled(Boolean userTwoFactorEnabled)
    {
        this.userTwoFactorEnabled = userTwoFactorEnabled;
    }

    private String userSecurityStamp;

    public String getUserSecurityStamp()
    {
        return this.userSecurityStamp;
    }

    public void setUserSecurityStamp(String userSecurityStamp)
    {
        this.userSecurityStamp = userSecurityStamp;
    }

    private String userCreatedBy;

    public String getUserCreatedBy()
    {
        return this.userCreatedBy;
    }

    public void setUserCreatedBy(String userCreatedBy)
    {
        this.userCreatedBy = userCreatedBy;
    }

    private Date userCreatedAt;

    public Date getUserCreatedAt()
    {
        return this.userCreatedAt;
    }

    public void setUserCreatedAt(Date userCreatedAt)
    {
        this.userCreatedAt = userCreatedAt;
    }

    private String userUpdatedBy;

    public String getUserUpdatedBy()
    {
        return this.userUpdatedBy;
    }

    public void setUserUpdatedBy(String userUpdatedBy)
    {
        this.userUpdatedBy = userUpdatedBy;
    }

    private Date userUpdatedAt;

    public Date getUserUpdatedAt()
    {
        return this.userUpdatedAt;
    }

    public void setUserUpdatedAt(Date userUpdatedAt)
    {
        this.userUpdatedAt = userUpdatedAt;
    }

    private Boolean userActive;

    public Boolean getUserActive()
    {
        return this.userActive;
    }

    public void setUserActive(Boolean userActive)
    {
        this.userActive = userActive;
    }

    private Boolean userDeleted;

    public Boolean getUserDeleted()
    {
        return this.userDeleted;
    }

    public void setUserDeleted(Boolean userDeleted)
    {
        this.userDeleted = userDeleted;
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

    private String createdBy;

    public String getCreatedBy()
    {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy)
    {
        this.createdBy = createdBy;
    }

    private Date createdAt;

    public Date getCreatedAt()
    {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    private String updatedBy;

    public String getUpdatedBy()
    {
        return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy)
    {
        this.updatedBy = updatedBy;
    }

    private Date updatedAt;

    public Date getUpdatedAt()
    {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt)
    {
        this.updatedAt = updatedAt;
    }


    public static class DtoConverter extends AbstractStateDtoConverter
    {
        public static Collection<String> collectionFieldNames = Arrays.asList(new String[]{});

        @Override
        protected boolean isCollectionField(String fieldName) {
            return CollectionUtils.collectionContainsIgnoringCase(collectionFieldNames, fieldName);
        }

        public UserLoginMvoStateDto[] toUserLoginMvoStateDtoArray(Iterable<UserLoginMvoState> states) 
        {
            ArrayList<UserLoginMvoStateDto> stateDtos = new ArrayList();
            for (UserLoginMvoState s : states) {
                UserLoginMvoStateDto dto = toUserLoginMvoStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos.toArray(new UserLoginMvoStateDto[0]);
        }

        public UserLoginMvoStateDto toUserLoginMvoStateDto(UserLoginMvoState state)
        {
            UserLoginMvoStateDto dto = new UserLoginMvoStateDto();
            if (returnedFieldsContains("UserLoginId")) {
                dto.setUserLoginId((state.getUserLoginId() == null) ? null : new UserLoginIdDto(state.getUserLoginId()));
            }
            if (returnedFieldsContains("Version")) {
                dto.setVersion(state.getVersion());
            }
            if (returnedFieldsContains("Active")) {
                dto.setActive(state.getActive());
            }
            if (returnedFieldsContains("UserUserName")) {
                dto.setUserUserName(state.getUserUserName());
            }
            if (returnedFieldsContains("UserAccessFailedCount")) {
                dto.setUserAccessFailedCount(state.getUserAccessFailedCount());
            }
            if (returnedFieldsContains("UserEmail")) {
                dto.setUserEmail(state.getUserEmail());
            }
            if (returnedFieldsContains("UserEmailConfirmed")) {
                dto.setUserEmailConfirmed(state.getUserEmailConfirmed());
            }
            if (returnedFieldsContains("UserLockoutEnabled")) {
                dto.setUserLockoutEnabled(state.getUserLockoutEnabled());
            }
            if (returnedFieldsContains("UserLockoutEndDateUtc")) {
                dto.setUserLockoutEndDateUtc(state.getUserLockoutEndDateUtc());
            }
            if (returnedFieldsContains("UserPasswordHash")) {
                dto.setUserPasswordHash(state.getUserPasswordHash());
            }
            if (returnedFieldsContains("UserPhoneNumber")) {
                dto.setUserPhoneNumber(state.getUserPhoneNumber());
            }
            if (returnedFieldsContains("UserPhoneNumberConfirmed")) {
                dto.setUserPhoneNumberConfirmed(state.getUserPhoneNumberConfirmed());
            }
            if (returnedFieldsContains("UserTwoFactorEnabled")) {
                dto.setUserTwoFactorEnabled(state.getUserTwoFactorEnabled());
            }
            if (returnedFieldsContains("UserSecurityStamp")) {
                dto.setUserSecurityStamp(state.getUserSecurityStamp());
            }
            if (returnedFieldsContains("UserCreatedBy")) {
                dto.setUserCreatedBy(state.getUserCreatedBy());
            }
            if (returnedFieldsContains("UserCreatedAt")) {
                dto.setUserCreatedAt(state.getUserCreatedAt());
            }
            if (returnedFieldsContains("UserUpdatedBy")) {
                dto.setUserUpdatedBy(state.getUserUpdatedBy());
            }
            if (returnedFieldsContains("UserUpdatedAt")) {
                dto.setUserUpdatedAt(state.getUserUpdatedAt());
            }
            if (returnedFieldsContains("UserActive")) {
                dto.setUserActive(state.getUserActive());
            }
            if (returnedFieldsContains("UserDeleted")) {
                dto.setUserDeleted(state.getUserDeleted());
            }
            if (returnedFieldsContains("UserVersion")) {
                dto.setUserVersion(state.getUserVersion());
            }
            if (returnedFieldsContains("CreatedBy")) {
                dto.setCreatedBy(state.getCreatedBy());
            }
            if (returnedFieldsContains("CreatedAt")) {
                dto.setCreatedAt(state.getCreatedAt());
            }
            if (returnedFieldsContains("UpdatedBy")) {
                dto.setUpdatedBy(state.getUpdatedBy());
            }
            if (returnedFieldsContains("UpdatedAt")) {
                dto.setUpdatedAt(state.getUpdatedAt());
            }
            return dto;
        }

    }
}

