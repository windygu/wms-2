package org.dddml.wms.domain;

import java.util.*;
import java.util.Date;
import org.dddml.wms.specialization.*;


public class UserStateDto
{

    private String userId;

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    private String userName;

    public String getUserName()
    {
        return this.userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    private Integer accessFailedCount;

    public Integer getAccessFailedCount()
    {
        return this.accessFailedCount;
    }

    public void setAccessFailedCount(Integer accessFailedCount)
    {
        this.accessFailedCount = accessFailedCount;
    }

    private String email;

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    private Boolean emailConfirmed;

    public Boolean getEmailConfirmed()
    {
        return this.emailConfirmed;
    }

    public void setEmailConfirmed(Boolean emailConfirmed)
    {
        this.emailConfirmed = emailConfirmed;
    }

    private Boolean lockoutEnabled;

    public Boolean getLockoutEnabled()
    {
        return this.lockoutEnabled;
    }

    public void setLockoutEnabled(Boolean lockoutEnabled)
    {
        this.lockoutEnabled = lockoutEnabled;
    }

    private Date lockoutEndDateUtc;

    public Date getLockoutEndDateUtc()
    {
        return this.lockoutEndDateUtc;
    }

    public void setLockoutEndDateUtc(Date lockoutEndDateUtc)
    {
        this.lockoutEndDateUtc = lockoutEndDateUtc;
    }

    private String passwordHash;

    public String getPasswordHash()
    {
        return this.passwordHash;
    }

    public void setPasswordHash(String passwordHash)
    {
        this.passwordHash = passwordHash;
    }

    private String phoneNumber;

    public String getPhoneNumber()
    {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    private Boolean phoneNumberConfirmed;

    public Boolean getPhoneNumberConfirmed()
    {
        return this.phoneNumberConfirmed;
    }

    public void setPhoneNumberConfirmed(Boolean phoneNumberConfirmed)
    {
        this.phoneNumberConfirmed = phoneNumberConfirmed;
    }

    private Boolean twoFactorEnabled;

    public Boolean getTwoFactorEnabled()
    {
        return this.twoFactorEnabled;
    }

    public void setTwoFactorEnabled(Boolean twoFactorEnabled)
    {
        this.twoFactorEnabled = twoFactorEnabled;
    }

    private String securityStamp;

    public String getSecurityStamp()
    {
        return this.securityStamp;
    }

    public void setSecurityStamp(String securityStamp)
    {
        this.securityStamp = securityStamp;
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

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
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

    private UserRoleStateDto[] userRoles;

    public UserRoleStateDto[] getUserRoles()
    {
        return this.userRoles;
    }	

    public void setUserRoles(UserRoleStateDto[] userRoles)
    {
        this.userRoles = userRoles;
    }

    private UserClaimStateDto[] userClaims;

    public UserClaimStateDto[] getUserClaims()
    {
        return this.userClaims;
    }	

    public void setUserClaims(UserClaimStateDto[] userClaims)
    {
        this.userClaims = userClaims;
    }

    private UserPermissionStateDto[] userPermissions;

    public UserPermissionStateDto[] getUserPermissions()
    {
        return this.userPermissions;
    }	

    public void setUserPermissions(UserPermissionStateDto[] userPermissions)
    {
        this.userPermissions = userPermissions;
    }

    private UserLoginStateDto[] userLogins;

    public UserLoginStateDto[] getUserLogins()
    {
        return this.userLogins;
    }	

    public void setUserLogins(UserLoginStateDto[] userLogins)
    {
        this.userLogins = userLogins;
    }


    public static class DtoConverter extends AbstractStateDtoConverter
    {
        public static Collection<String> collectionFieldNames = Arrays.asList(new String[]{"UserRoles", "UserClaims", "UserPermissions", "UserLogins"});

        @Override
        protected boolean isCollectionField(String fieldName) {
            return CollectionUtils.collectionContainsIgnoringCase(collectionFieldNames, fieldName);
        }

        public UserStateDto[] toUserStateDtoArray(Iterable<UserState> states) 
        {
            ArrayList<UserStateDto> stateDtos = new ArrayList();
            for (UserState s : states) {
                UserStateDto dto = toUserStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos.toArray(new UserStateDto[0]);
        }

        public UserStateDto toUserStateDto(UserState state)
        {
            UserStateDto dto = new UserStateDto();
            if (returnedFieldsContains("UserId")) {
                dto.setUserId(state.getUserId());
            }
            if (returnedFieldsContains("UserName")) {
                dto.setUserName(state.getUserName());
            }
            if (returnedFieldsContains("AccessFailedCount")) {
                dto.setAccessFailedCount(state.getAccessFailedCount());
            }
            if (returnedFieldsContains("Email")) {
                dto.setEmail(state.getEmail());
            }
            if (returnedFieldsContains("EmailConfirmed")) {
                dto.setEmailConfirmed(state.getEmailConfirmed());
            }
            if (returnedFieldsContains("LockoutEnabled")) {
                dto.setLockoutEnabled(state.getLockoutEnabled());
            }
            if (returnedFieldsContains("LockoutEndDateUtc")) {
                dto.setLockoutEndDateUtc(state.getLockoutEndDateUtc());
            }
            if (returnedFieldsContains("PasswordHash")) {
                dto.setPasswordHash(state.getPasswordHash());
            }
            if (returnedFieldsContains("PhoneNumber")) {
                dto.setPhoneNumber(state.getPhoneNumber());
            }
            if (returnedFieldsContains("PhoneNumberConfirmed")) {
                dto.setPhoneNumberConfirmed(state.getPhoneNumberConfirmed());
            }
            if (returnedFieldsContains("TwoFactorEnabled")) {
                dto.setTwoFactorEnabled(state.getTwoFactorEnabled());
            }
            if (returnedFieldsContains("SecurityStamp")) {
                dto.setSecurityStamp(state.getSecurityStamp());
            }
            if (returnedFieldsContains("Active")) {
                dto.setActive(state.getActive());
            }
            if (returnedFieldsContains("Version")) {
                dto.setVersion(state.getVersion());
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
            if (returnedFieldsContains("UserRoles")) {
                ArrayList<UserRoleStateDto> arrayList = new ArrayList();
                if (state.getUserRoles() != null) {
                    UserRoleStateDto.DtoConverter conv = new UserRoleStateDto.DtoConverter();
                    String returnFS = CollectionUtils.mapGetValueIgnoringCase(getReturnedFields(), "UserRoles");
                    if(returnFS != null) { conv.setReturnedFieldsString(returnFS); } else { conv.setAllFieldsReturned(this.getAllFieldsReturned()); }
                    for (UserRoleState s : state.getUserRoles()) {
                        arrayList.add(conv.toUserRoleStateDto(s));
                    }
                }
                dto.setUserRoles(arrayList.toArray(new UserRoleStateDto[0]));
            }
            if (returnedFieldsContains("UserClaims")) {
                ArrayList<UserClaimStateDto> arrayList = new ArrayList();
                if (state.getUserClaims() != null) {
                    UserClaimStateDto.DtoConverter conv = new UserClaimStateDto.DtoConverter();
                    String returnFS = CollectionUtils.mapGetValueIgnoringCase(getReturnedFields(), "UserClaims");
                    if(returnFS != null) { conv.setReturnedFieldsString(returnFS); } else { conv.setAllFieldsReturned(this.getAllFieldsReturned()); }
                    for (UserClaimState s : state.getUserClaims()) {
                        arrayList.add(conv.toUserClaimStateDto(s));
                    }
                }
                dto.setUserClaims(arrayList.toArray(new UserClaimStateDto[0]));
            }
            if (returnedFieldsContains("UserPermissions")) {
                ArrayList<UserPermissionStateDto> arrayList = new ArrayList();
                if (state.getUserPermissions() != null) {
                    UserPermissionStateDto.DtoConverter conv = new UserPermissionStateDto.DtoConverter();
                    String returnFS = CollectionUtils.mapGetValueIgnoringCase(getReturnedFields(), "UserPermissions");
                    if(returnFS != null) { conv.setReturnedFieldsString(returnFS); } else { conv.setAllFieldsReturned(this.getAllFieldsReturned()); }
                    for (UserPermissionState s : state.getUserPermissions()) {
                        arrayList.add(conv.toUserPermissionStateDto(s));
                    }
                }
                dto.setUserPermissions(arrayList.toArray(new UserPermissionStateDto[0]));
            }
            if (returnedFieldsContains("UserLogins")) {
                ArrayList<UserLoginStateDto> arrayList = new ArrayList();
                if (state.getUserLogins() != null) {
                    UserLoginStateDto.DtoConverter conv = new UserLoginStateDto.DtoConverter();
                    String returnFS = CollectionUtils.mapGetValueIgnoringCase(getReturnedFields(), "UserLogins");
                    if(returnFS != null) { conv.setReturnedFieldsString(returnFS); } else { conv.setAllFieldsReturned(this.getAllFieldsReturned()); }
                    for (UserLoginState s : state.getUserLogins()) {
                        arrayList.add(conv.toUserLoginStateDto(s));
                    }
                }
                dto.setUserLogins(arrayList.toArray(new UserLoginStateDto[0]));
            }
            return dto;
        }

    }
}

