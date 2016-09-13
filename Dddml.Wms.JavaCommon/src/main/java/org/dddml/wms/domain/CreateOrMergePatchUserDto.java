package org.dddml.wms.domain;

import java.util.Date;

public class CreateOrMergePatchUserDto extends AbstractUserCommandDto
{
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

    private CreateOrMergePatchUserRoleDto[] userRoles;

    public CreateOrMergePatchUserRoleDto[] getUserRoles()
    {
        return this.userRoles;
    }

    public void setUserRoles(CreateOrMergePatchUserRoleDto[] userRoles)
    {
        this.userRoles = userRoles;
    }

    private CreateOrMergePatchUserClaimDto[] userClaims;

    public CreateOrMergePatchUserClaimDto[] getUserClaims()
    {
        return this.userClaims;
    }

    public void setUserClaims(CreateOrMergePatchUserClaimDto[] userClaims)
    {
        this.userClaims = userClaims;
    }

    private CreateOrMergePatchUserPermissionDto[] userPermissions;

    public CreateOrMergePatchUserPermissionDto[] getUserPermissions()
    {
        return this.userPermissions;
    }

    public void setUserPermissions(CreateOrMergePatchUserPermissionDto[] userPermissions)
    {
        this.userPermissions = userPermissions;
    }

    private CreateOrMergePatchUserLoginDto[] userLogins;

    public CreateOrMergePatchUserLoginDto[] getUserLogins()
    {
        return this.userLogins;
    }

    public void setUserLogins(CreateOrMergePatchUserLoginDto[] userLogins)
    {
        this.userLogins = userLogins;
    }

    private Boolean isPropertyUserNameRemoved;

    public Boolean getIsPropertyUserNameRemoved()
    {
        return this.isPropertyUserNameRemoved;
    }

    public void setIsPropertyUserNameRemoved(Boolean removed)
    {
        this.isPropertyUserNameRemoved = removed;
    }

    private Boolean isPropertyAccessFailedCountRemoved;

    public Boolean getIsPropertyAccessFailedCountRemoved()
    {
        return this.isPropertyAccessFailedCountRemoved;
    }

    public void setIsPropertyAccessFailedCountRemoved(Boolean removed)
    {
        this.isPropertyAccessFailedCountRemoved = removed;
    }

    private Boolean isPropertyEmailRemoved;

    public Boolean getIsPropertyEmailRemoved()
    {
        return this.isPropertyEmailRemoved;
    }

    public void setIsPropertyEmailRemoved(Boolean removed)
    {
        this.isPropertyEmailRemoved = removed;
    }

    private Boolean isPropertyEmailConfirmedRemoved;

    public Boolean getIsPropertyEmailConfirmedRemoved()
    {
        return this.isPropertyEmailConfirmedRemoved;
    }

    public void setIsPropertyEmailConfirmedRemoved(Boolean removed)
    {
        this.isPropertyEmailConfirmedRemoved = removed;
    }

    private Boolean isPropertyLockoutEnabledRemoved;

    public Boolean getIsPropertyLockoutEnabledRemoved()
    {
        return this.isPropertyLockoutEnabledRemoved;
    }

    public void setIsPropertyLockoutEnabledRemoved(Boolean removed)
    {
        this.isPropertyLockoutEnabledRemoved = removed;
    }

    private Boolean isPropertyLockoutEndDateUtcRemoved;

    public Boolean getIsPropertyLockoutEndDateUtcRemoved()
    {
        return this.isPropertyLockoutEndDateUtcRemoved;
    }

    public void setIsPropertyLockoutEndDateUtcRemoved(Boolean removed)
    {
        this.isPropertyLockoutEndDateUtcRemoved = removed;
    }

    private Boolean isPropertyPasswordHashRemoved;

    public Boolean getIsPropertyPasswordHashRemoved()
    {
        return this.isPropertyPasswordHashRemoved;
    }

    public void setIsPropertyPasswordHashRemoved(Boolean removed)
    {
        this.isPropertyPasswordHashRemoved = removed;
    }

    private Boolean isPropertyPhoneNumberRemoved;

    public Boolean getIsPropertyPhoneNumberRemoved()
    {
        return this.isPropertyPhoneNumberRemoved;
    }

    public void setIsPropertyPhoneNumberRemoved(Boolean removed)
    {
        this.isPropertyPhoneNumberRemoved = removed;
    }

    private Boolean isPropertyPhoneNumberConfirmedRemoved;

    public Boolean getIsPropertyPhoneNumberConfirmedRemoved()
    {
        return this.isPropertyPhoneNumberConfirmedRemoved;
    }

    public void setIsPropertyPhoneNumberConfirmedRemoved(Boolean removed)
    {
        this.isPropertyPhoneNumberConfirmedRemoved = removed;
    }

    private Boolean isPropertyTwoFactorEnabledRemoved;

    public Boolean getIsPropertyTwoFactorEnabledRemoved()
    {
        return this.isPropertyTwoFactorEnabledRemoved;
    }

    public void setIsPropertyTwoFactorEnabledRemoved(Boolean removed)
    {
        this.isPropertyTwoFactorEnabledRemoved = removed;
    }

    private Boolean isPropertySecurityStampRemoved;

    public Boolean getIsPropertySecurityStampRemoved()
    {
        return this.isPropertySecurityStampRemoved;
    }

    public void setIsPropertySecurityStampRemoved(Boolean removed)
    {
        this.isPropertySecurityStampRemoved = removed;
    }

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved()
    {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed)
    {
        this.isPropertyActiveRemoved = removed;
    }

    public void copyTo(AbstractUserCommand.AbstractCreateOrMergePatchUser command)
    {
        ((AbstractUserCommandDto) this).copyTo(command);
        command.setUserName(this.getUserName());
        command.setAccessFailedCount(this.getAccessFailedCount());
        command.setEmail(this.getEmail());
        command.setEmailConfirmed(this.getEmailConfirmed());
        command.setLockoutEnabled(this.getLockoutEnabled());
        command.setLockoutEndDateUtc(this.getLockoutEndDateUtc());
        command.setPasswordHash(this.getPasswordHash());
        command.setPhoneNumber(this.getPhoneNumber());
        command.setPhoneNumberConfirmed(this.getPhoneNumberConfirmed());
        command.setTwoFactorEnabled(this.getTwoFactorEnabled());
        command.setSecurityStamp(this.getSecurityStamp());
        command.setActive(this.getActive());
    }

    public UserCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractUserCommand.SimpleCreateUser command = new AbstractUserCommand.SimpleCreateUser();
            copyTo((AbstractUserCommand.AbstractCreateUser) command);
            if (this.getUserRoles() != null) {
                for (CreateOrMergePatchUserRoleDto cmd : this.getUserRoles()) {
                    command.getUserRoles().add((UserRoleCommand.CreateUserRole) cmd.toCommand());
                }
            }
            if (this.getUserClaims() != null) {
                for (CreateOrMergePatchUserClaimDto cmd : this.getUserClaims()) {
                    command.getUserClaims().add((UserClaimCommand.CreateUserClaim) cmd.toCommand());
                }
            }
            if (this.getUserPermissions() != null) {
                for (CreateOrMergePatchUserPermissionDto cmd : this.getUserPermissions()) {
                    command.getUserPermissions().add((UserPermissionCommand.CreateUserPermission) cmd.toCommand());
                }
            }
            if (this.getUserLogins() != null) {
                for (CreateOrMergePatchUserLoginDto cmd : this.getUserLogins()) {
                    command.getUserLogins().add((UserLoginCommand.CreateUserLogin) cmd.toCommand());
                }
            }
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractUserCommand.SimpleMergePatchUser command = new AbstractUserCommand.SimpleMergePatchUser();
            copyTo((AbstractUserCommand.SimpleMergePatchUser) command);
            if (this.getUserRoles() != null) {
                for (CreateOrMergePatchUserRoleDto cmd : this.getUserRoles()) {
                    command.getUserRoleCommands().add(cmd.toCommand());
                }
            }
            if (this.getUserClaims() != null) {
                for (CreateOrMergePatchUserClaimDto cmd : this.getUserClaims()) {
                    command.getUserClaimCommands().add(cmd.toCommand());
                }
            }
            if (this.getUserPermissions() != null) {
                for (CreateOrMergePatchUserPermissionDto cmd : this.getUserPermissions()) {
                    command.getUserPermissionCommands().add(cmd.toCommand());
                }
            }
            if (this.getUserLogins() != null) {
                for (CreateOrMergePatchUserLoginDto cmd : this.getUserLogins()) {
                    command.getUserLoginCommands().add(cmd.toCommand());
                }
            }
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractUserCommand.AbstractCreateUser command)
    {
        copyTo((AbstractUserCommand.AbstractCreateOrMergePatchUser) command);
    }

    public void copyTo(AbstractUserCommand.AbstractMergePatchUser command)
    {
        copyTo((AbstractUserCommand.AbstractCreateOrMergePatchUser) command);
        command.setIsPropertyUserNameRemoved(this.getIsPropertyUserNameRemoved());
        command.setIsPropertyAccessFailedCountRemoved(this.getIsPropertyAccessFailedCountRemoved());
        command.setIsPropertyEmailRemoved(this.getIsPropertyEmailRemoved());
        command.setIsPropertyEmailConfirmedRemoved(this.getIsPropertyEmailConfirmedRemoved());
        command.setIsPropertyLockoutEnabledRemoved(this.getIsPropertyLockoutEnabledRemoved());
        command.setIsPropertyLockoutEndDateUtcRemoved(this.getIsPropertyLockoutEndDateUtcRemoved());
        command.setIsPropertyPasswordHashRemoved(this.getIsPropertyPasswordHashRemoved());
        command.setIsPropertyPhoneNumberRemoved(this.getIsPropertyPhoneNumberRemoved());
        command.setIsPropertyPhoneNumberConfirmedRemoved(this.getIsPropertyPhoneNumberConfirmedRemoved());
        command.setIsPropertyTwoFactorEnabledRemoved(this.getIsPropertyTwoFactorEnabledRemoved());
        command.setIsPropertySecurityStampRemoved(this.getIsPropertySecurityStampRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateUserDto extends CreateOrMergePatchUserDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public UserCommand.CreateUser toCreateUser()
        {
            return (UserCommand.CreateUser) toCommand();
        }

    }

    public static class MergePatchUserDto extends CreateOrMergePatchUserDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public UserCommand.MergePatchUser toMergePatchUser()
        {
            return (UserCommand.MergePatchUser) toCommand();
        }

    }

}

