
    drop table if exists Audiences;

    drop table if exists AudienceStateEvents;

    drop table if exists Users;

    drop table if exists UserStateEvents;

    drop table if exists UserRoles;

    drop table if exists UserRoleStateEvents;

    drop table if exists UserClaims;

    drop table if exists UserClaimStateEvents;

    drop table if exists UserPermissions;

    drop table if exists UserPermissionStateEvents;

    drop table if exists UserLogins;

    drop table if exists UserLoginStateEvents;

    drop table if exists Roles;

    drop table if exists RoleStateEvents;

    drop table if exists Permissions;

    drop table if exists PermissionStateEvents;

    drop table if exists RolePermissions;

    drop table if exists RolePermissionStateEvents;

    drop table if exists UserRole_RV;

    drop table if exists UserRoleMvoStateEvents;

    drop table if exists UserClaim_RV;

    drop table if exists UserClaimMvoStateEvents;

    drop table if exists UserPermission_RV;

    drop table if exists UserPermissionMvoStateEvents;

    drop table if exists UserLogin_RV;

    drop table if exists UserLoginMvoStateEvents;

    create table Audiences (
        ClientId VARCHAR(50) not null,
       Version BIGINT not null,
       Name VARCHAR(255),
       Base64Secret VARCHAR(255),
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       UpdatedBy VARCHAR(255),
       UpdatedAt DATETIME,
       Active TINYINT(1),
       Deleted TINYINT(1),
       primary key (ClientId)
    );

    create table AudienceStateEvents (
        ClientId VARCHAR(50) not null,
       Version BIGINT not null,
       StateEventType VARCHAR(255) not null,
       Name VARCHAR(255),
       Base64Secret VARCHAR(255),
       Active TINYINT(1),
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       IsPropertyNameRemoved TINYINT(1),
       IsPropertyBase64SecretRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (ClientId, Version)
    );

    create table Users (
        UserId VARCHAR(50) not null,
       Version BIGINT not null,
       UserName VARCHAR(255),
       AccessFailedCount INTEGER,
       Email VARCHAR(255),
       EmailConfirmed TINYINT(1),
       LockoutEnabled TINYINT(1),
       LockoutEndDateUtc DATETIME,
       PasswordHash VARCHAR(255),
       PhoneNumber VARCHAR(255),
       PhoneNumberConfirmed TINYINT(1),
       TwoFactorEnabled TINYINT(1),
       SecurityStamp VARCHAR(255),
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       UpdatedBy VARCHAR(255),
       UpdatedAt DATETIME,
       Active TINYINT(1),
       Deleted TINYINT(1),
       primary key (UserId),
      unique (UserName)
    );

    create table UserStateEvents (
        UserId VARCHAR(50) not null,
       Version BIGINT not null,
       StateEventType VARCHAR(255) not null,
       UserName VARCHAR(255),
       AccessFailedCount INTEGER,
       Email VARCHAR(255),
       EmailConfirmed TINYINT(1),
       LockoutEnabled TINYINT(1),
       LockoutEndDateUtc DATETIME,
       PasswordHash VARCHAR(255),
       PhoneNumber VARCHAR(255),
       PhoneNumberConfirmed TINYINT(1),
       TwoFactorEnabled TINYINT(1),
       SecurityStamp VARCHAR(255),
       Active TINYINT(1),
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       IsPropertyUserNameRemoved TINYINT(1),
       IsPropertyAccessFailedCountRemoved TINYINT(1),
       IsPropertyEmailRemoved TINYINT(1),
       IsPropertyEmailConfirmedRemoved TINYINT(1),
       IsPropertyLockoutEnabledRemoved TINYINT(1),
       IsPropertyLockoutEndDateUtcRemoved TINYINT(1),
       IsPropertyPasswordHashRemoved TINYINT(1),
       IsPropertyPhoneNumberRemoved TINYINT(1),
       IsPropertyPhoneNumberConfirmedRemoved TINYINT(1),
       IsPropertyTwoFactorEnabledRemoved TINYINT(1),
       IsPropertySecurityStampRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (UserId, Version),
      unique (UserName)
    );

    create table UserRoles (
        UserRoleIdUserId VARCHAR(50) not null,
       UserRoleIdRoleId VARCHAR(50) not null,
       Version BIGINT not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       UpdatedBy VARCHAR(255),
       UpdatedAt DATETIME,
       Active TINYINT(1),
       Deleted TINYINT(1),
       primary key (UserRoleIdUserId, UserRoleIdRoleId)
    );

    create table UserRoleStateEvents (
        UserRoleIdUserId VARCHAR(50) not null,
       UserRoleIdRoleId VARCHAR(50) not null,
       UserVersion BIGINT not null,
       StateEventType VARCHAR(255) not null,
       Active TINYINT(1),
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       Version BIGINT not null,
       IsPropertyActiveRemoved TINYINT(1),
       primary key (UserRoleIdUserId, UserRoleIdRoleId, UserVersion)
    );

    create table UserClaims (
        UserClaimIdUserId VARCHAR(50) not null,
       UserClaimIdClaimId INTEGER not null,
       Version BIGINT not null,
       ClaimType VARCHAR(255),
       ClaimValue VARCHAR(255),
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       UpdatedBy VARCHAR(255),
       UpdatedAt DATETIME,
       Active TINYINT(1),
       Deleted TINYINT(1),
       primary key (UserClaimIdUserId, UserClaimIdClaimId)
    );

    create table UserClaimStateEvents (
        UserClaimIdUserId VARCHAR(50) not null,
       UserClaimIdClaimId INTEGER not null,
       UserVersion BIGINT not null,
       StateEventType VARCHAR(255) not null,
       ClaimType VARCHAR(255),
       ClaimValue VARCHAR(255),
       Active TINYINT(1),
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       Version BIGINT not null,
       IsPropertyClaimTypeRemoved TINYINT(1),
       IsPropertyClaimValueRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (UserClaimIdUserId, UserClaimIdClaimId, UserVersion)
    );

    create table UserPermissions (
        UserPermissionIdUserId VARCHAR(50) not null,
       UserPermissionIdPermissionId VARCHAR(50) not null,
       Version BIGINT not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       UpdatedBy VARCHAR(255),
       UpdatedAt DATETIME,
       Active TINYINT(1),
       Deleted TINYINT(1),
       primary key (UserPermissionIdUserId, UserPermissionIdPermissionId)
    );

    create table UserPermissionStateEvents (
        UserPermissionIdUserId VARCHAR(50) not null,
       UserPermissionIdPermissionId VARCHAR(50) not null,
       UserVersion BIGINT not null,
       StateEventType VARCHAR(255) not null,
       Active TINYINT(1),
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       Version BIGINT not null,
       IsPropertyActiveRemoved TINYINT(1),
       primary key (UserPermissionIdUserId, UserPermissionIdPermissionId, UserVersion)
    );

    create table UserLogins (
        UserLoginIdUserId VARCHAR(50) not null,
       UserLoginIdLoginKeyLoginProvider VARCHAR(255) not null,
       UserLoginIdLoginKeyProviderKey VARCHAR(255) not null,
       Version BIGINT not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       UpdatedBy VARCHAR(255),
       UpdatedAt DATETIME,
       Active TINYINT(1),
       Deleted TINYINT(1),
       primary key (UserLoginIdUserId, UserLoginIdLoginKeyLoginProvider, UserLoginIdLoginKeyProviderKey)
    );

    create table UserLoginStateEvents (
        UserLoginIdUserId VARCHAR(50) not null,
       UserLoginIdLoginKeyLoginProvider VARCHAR(255) not null,
       UserLoginIdLoginKeyProviderKey VARCHAR(255) not null,
       UserVersion BIGINT not null,
       StateEventType VARCHAR(255) not null,
       Active TINYINT(1),
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       Version BIGINT not null,
       IsPropertyActiveRemoved TINYINT(1),
       primary key (UserLoginIdUserId, UserLoginIdLoginKeyLoginProvider, UserLoginIdLoginKeyProviderKey, UserVersion)
    );

    create table Roles (
        RoleId VARCHAR(50) not null,
       Version BIGINT not null,
       Name VARCHAR(255),
       Description VARCHAR(255),
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       UpdatedBy VARCHAR(255),
       UpdatedAt DATETIME,
       Active TINYINT(1),
       Deleted TINYINT(1),
       primary key (RoleId)
    );

    create table RoleStateEvents (
        RoleId VARCHAR(50) not null,
       Version BIGINT not null,
       StateEventType VARCHAR(255) not null,
       Name VARCHAR(255),
       Description VARCHAR(255),
       Active TINYINT(1),
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       IsPropertyNameRemoved TINYINT(1),
       IsPropertyDescriptionRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (RoleId, Version)
    );

    create table Permissions (
        PermissionId VARCHAR(50) not null,
       Version BIGINT not null,
       Name VARCHAR(255),
       ParentPermissionId VARCHAR(255),
       Description VARCHAR(255),
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       UpdatedBy VARCHAR(255),
       UpdatedAt DATETIME,
       Active TINYINT(1),
       Deleted TINYINT(1),
       primary key (PermissionId)
    );

    create table PermissionStateEvents (
        PermissionId VARCHAR(50) not null,
       Version BIGINT not null,
       StateEventType VARCHAR(255) not null,
       Name VARCHAR(255),
       ParentPermissionId VARCHAR(255),
       Description VARCHAR(255),
       Active TINYINT(1),
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       IsPropertyNameRemoved TINYINT(1),
       IsPropertyParentPermissionIdRemoved TINYINT(1),
       IsPropertyDescriptionRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (PermissionId, Version)
    );

    create table RolePermissions (
        IdRoleId VARCHAR(255) not null,
       IdPermissionId VARCHAR(255) not null,
       Version BIGINT not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       UpdatedBy VARCHAR(255),
       UpdatedAt DATETIME,
       Active TINYINT(1),
       Deleted TINYINT(1),
       primary key (IdRoleId, IdPermissionId)
    );

    create table RolePermissionStateEvents (
        IdRoleId VARCHAR(255) not null,
       IdPermissionId VARCHAR(255) not null,
       Version BIGINT not null,
       StateEventType VARCHAR(255) not null,
       Active TINYINT(1),
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (IdRoleId, IdPermissionId, Version)
    );

    create table UserRole_RV (
        UserRoleIdUserId VARCHAR(50) not null,
       UserRoleIdRoleId VARCHAR(50) not null,
       UserVersion BIGINT not null,
       Version BIGINT,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       UpdatedBy VARCHAR(255),
       UpdatedAt DATETIME,
       Active TINYINT(1),
       Deleted TINYINT(1),
       UserUserName VARCHAR(255),
       UserAccessFailedCount INTEGER,
       UserEmail VARCHAR(255),
       UserEmailConfirmed TINYINT(1),
       UserLockoutEnabled TINYINT(1),
       UserLockoutEndDateUtc DATETIME,
       UserPasswordHash VARCHAR(255),
       UserPhoneNumber VARCHAR(255),
       UserPhoneNumberConfirmed TINYINT(1),
       UserTwoFactorEnabled TINYINT(1),
       UserSecurityStamp VARCHAR(255),
       UserCreatedBy VARCHAR(255),
       UserCreatedAt DATETIME,
       UserUpdatedBy VARCHAR(255),
       UserUpdatedAt DATETIME,
       UserActive TINYINT(1),
       UserDeleted TINYINT(1),
       primary key (UserRoleIdUserId, UserRoleIdRoleId)
    );

    create table UserRoleMvoStateEvents (
        UserRoleIdUserId VARCHAR(50) not null,
       UserRoleIdRoleId VARCHAR(50) not null,
       UserVersion BIGINT not null,
       StateEventType VARCHAR(255) not null,
       Version BIGINT,
       Active TINYINT(1),
       UserUserName VARCHAR(255),
       UserAccessFailedCount INTEGER,
       UserEmail VARCHAR(255),
       UserEmailConfirmed TINYINT(1),
       UserLockoutEnabled TINYINT(1),
       UserLockoutEndDateUtc DATETIME,
       UserPasswordHash VARCHAR(255),
       UserPhoneNumber VARCHAR(255),
       UserPhoneNumberConfirmed TINYINT(1),
       UserTwoFactorEnabled TINYINT(1),
       UserSecurityStamp VARCHAR(255),
       UserCreatedBy VARCHAR(255),
       UserCreatedAt DATETIME,
       UserUpdatedBy VARCHAR(255),
       UserUpdatedAt DATETIME,
       UserActive TINYINT(1),
       UserDeleted TINYINT(1),
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       IsPropertyVersionRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       IsPropertyUserUserNameRemoved TINYINT(1),
       IsPropertyUserAccessFailedCountRemoved TINYINT(1),
       IsPropertyUserEmailRemoved TINYINT(1),
       IsPropertyUserEmailConfirmedRemoved TINYINT(1),
       IsPropertyUserLockoutEnabledRemoved TINYINT(1),
       IsPropertyUserLockoutEndDateUtcRemoved TINYINT(1),
       IsPropertyUserPasswordHashRemoved TINYINT(1),
       IsPropertyUserPhoneNumberRemoved TINYINT(1),
       IsPropertyUserPhoneNumberConfirmedRemoved TINYINT(1),
       IsPropertyUserTwoFactorEnabledRemoved TINYINT(1),
       IsPropertyUserSecurityStampRemoved TINYINT(1),
       IsPropertyUserCreatedByRemoved TINYINT(1),
       IsPropertyUserCreatedAtRemoved TINYINT(1),
       IsPropertyUserUpdatedByRemoved TINYINT(1),
       IsPropertyUserUpdatedAtRemoved TINYINT(1),
       IsPropertyUserActiveRemoved TINYINT(1),
       IsPropertyUserDeletedRemoved TINYINT(1),
       primary key (UserRoleIdUserId, UserRoleIdRoleId, UserVersion)
    );

    create table UserClaim_RV (
        UserClaimIdUserId VARCHAR(50) not null,
       UserClaimIdClaimId INTEGER not null,
       UserVersion BIGINT not null,
       ClaimType VARCHAR(255),
       ClaimValue VARCHAR(255),
       Version BIGINT,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       UpdatedBy VARCHAR(255),
       UpdatedAt DATETIME,
       Active TINYINT(1),
       Deleted TINYINT(1),
       UserUserName VARCHAR(255),
       UserAccessFailedCount INTEGER,
       UserEmail VARCHAR(255),
       UserEmailConfirmed TINYINT(1),
       UserLockoutEnabled TINYINT(1),
       UserLockoutEndDateUtc DATETIME,
       UserPasswordHash VARCHAR(255),
       UserPhoneNumber VARCHAR(255),
       UserPhoneNumberConfirmed TINYINT(1),
       UserTwoFactorEnabled TINYINT(1),
       UserSecurityStamp VARCHAR(255),
       UserCreatedBy VARCHAR(255),
       UserCreatedAt DATETIME,
       UserUpdatedBy VARCHAR(255),
       UserUpdatedAt DATETIME,
       UserActive TINYINT(1),
       UserDeleted TINYINT(1),
       primary key (UserClaimIdUserId, UserClaimIdClaimId)
    );

    create table UserClaimMvoStateEvents (
        UserClaimIdUserId VARCHAR(50) not null,
       UserClaimIdClaimId INTEGER not null,
       UserVersion BIGINT not null,
       StateEventType VARCHAR(255) not null,
       ClaimType VARCHAR(255),
       ClaimValue VARCHAR(255),
       Version BIGINT,
       Active TINYINT(1),
       UserUserName VARCHAR(255),
       UserAccessFailedCount INTEGER,
       UserEmail VARCHAR(255),
       UserEmailConfirmed TINYINT(1),
       UserLockoutEnabled TINYINT(1),
       UserLockoutEndDateUtc DATETIME,
       UserPasswordHash VARCHAR(255),
       UserPhoneNumber VARCHAR(255),
       UserPhoneNumberConfirmed TINYINT(1),
       UserTwoFactorEnabled TINYINT(1),
       UserSecurityStamp VARCHAR(255),
       UserCreatedBy VARCHAR(255),
       UserCreatedAt DATETIME,
       UserUpdatedBy VARCHAR(255),
       UserUpdatedAt DATETIME,
       UserActive TINYINT(1),
       UserDeleted TINYINT(1),
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       IsPropertyClaimTypeRemoved TINYINT(1),
       IsPropertyClaimValueRemoved TINYINT(1),
       IsPropertyVersionRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       IsPropertyUserUserNameRemoved TINYINT(1),
       IsPropertyUserAccessFailedCountRemoved TINYINT(1),
       IsPropertyUserEmailRemoved TINYINT(1),
       IsPropertyUserEmailConfirmedRemoved TINYINT(1),
       IsPropertyUserLockoutEnabledRemoved TINYINT(1),
       IsPropertyUserLockoutEndDateUtcRemoved TINYINT(1),
       IsPropertyUserPasswordHashRemoved TINYINT(1),
       IsPropertyUserPhoneNumberRemoved TINYINT(1),
       IsPropertyUserPhoneNumberConfirmedRemoved TINYINT(1),
       IsPropertyUserTwoFactorEnabledRemoved TINYINT(1),
       IsPropertyUserSecurityStampRemoved TINYINT(1),
       IsPropertyUserCreatedByRemoved TINYINT(1),
       IsPropertyUserCreatedAtRemoved TINYINT(1),
       IsPropertyUserUpdatedByRemoved TINYINT(1),
       IsPropertyUserUpdatedAtRemoved TINYINT(1),
       IsPropertyUserActiveRemoved TINYINT(1),
       IsPropertyUserDeletedRemoved TINYINT(1),
       primary key (UserClaimIdUserId, UserClaimIdClaimId, UserVersion)
    );

    create table UserPermission_RV (
        UserPermissionIdUserId VARCHAR(50) not null,
       UserPermissionIdPermissionId VARCHAR(50) not null,
       UserVersion BIGINT not null,
       Version BIGINT,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       UpdatedBy VARCHAR(255),
       UpdatedAt DATETIME,
       Active TINYINT(1),
       Deleted TINYINT(1),
       UserUserName VARCHAR(255),
       UserAccessFailedCount INTEGER,
       UserEmail VARCHAR(255),
       UserEmailConfirmed TINYINT(1),
       UserLockoutEnabled TINYINT(1),
       UserLockoutEndDateUtc DATETIME,
       UserPasswordHash VARCHAR(255),
       UserPhoneNumber VARCHAR(255),
       UserPhoneNumberConfirmed TINYINT(1),
       UserTwoFactorEnabled TINYINT(1),
       UserSecurityStamp VARCHAR(255),
       UserCreatedBy VARCHAR(255),
       UserCreatedAt DATETIME,
       UserUpdatedBy VARCHAR(255),
       UserUpdatedAt DATETIME,
       UserActive TINYINT(1),
       UserDeleted TINYINT(1),
       primary key (UserPermissionIdUserId, UserPermissionIdPermissionId)
    );

    create table UserPermissionMvoStateEvents (
        UserPermissionIdUserId VARCHAR(50) not null,
       UserPermissionIdPermissionId VARCHAR(50) not null,
       UserVersion BIGINT not null,
       StateEventType VARCHAR(255) not null,
       Version BIGINT,
       Active TINYINT(1),
       UserUserName VARCHAR(255),
       UserAccessFailedCount INTEGER,
       UserEmail VARCHAR(255),
       UserEmailConfirmed TINYINT(1),
       UserLockoutEnabled TINYINT(1),
       UserLockoutEndDateUtc DATETIME,
       UserPasswordHash VARCHAR(255),
       UserPhoneNumber VARCHAR(255),
       UserPhoneNumberConfirmed TINYINT(1),
       UserTwoFactorEnabled TINYINT(1),
       UserSecurityStamp VARCHAR(255),
       UserCreatedBy VARCHAR(255),
       UserCreatedAt DATETIME,
       UserUpdatedBy VARCHAR(255),
       UserUpdatedAt DATETIME,
       UserActive TINYINT(1),
       UserDeleted TINYINT(1),
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       IsPropertyVersionRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       IsPropertyUserUserNameRemoved TINYINT(1),
       IsPropertyUserAccessFailedCountRemoved TINYINT(1),
       IsPropertyUserEmailRemoved TINYINT(1),
       IsPropertyUserEmailConfirmedRemoved TINYINT(1),
       IsPropertyUserLockoutEnabledRemoved TINYINT(1),
       IsPropertyUserLockoutEndDateUtcRemoved TINYINT(1),
       IsPropertyUserPasswordHashRemoved TINYINT(1),
       IsPropertyUserPhoneNumberRemoved TINYINT(1),
       IsPropertyUserPhoneNumberConfirmedRemoved TINYINT(1),
       IsPropertyUserTwoFactorEnabledRemoved TINYINT(1),
       IsPropertyUserSecurityStampRemoved TINYINT(1),
       IsPropertyUserCreatedByRemoved TINYINT(1),
       IsPropertyUserCreatedAtRemoved TINYINT(1),
       IsPropertyUserUpdatedByRemoved TINYINT(1),
       IsPropertyUserUpdatedAtRemoved TINYINT(1),
       IsPropertyUserActiveRemoved TINYINT(1),
       IsPropertyUserDeletedRemoved TINYINT(1),
       primary key (UserPermissionIdUserId, UserPermissionIdPermissionId, UserVersion)
    );

    create table UserLogin_RV (
        UserLoginIdUserId VARCHAR(50) not null,
       UserLoginIdLoginKeyLoginProvider VARCHAR(255) not null,
       UserLoginIdLoginKeyProviderKey VARCHAR(255) not null,
       UserVersion BIGINT not null,
       Version BIGINT,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       UpdatedBy VARCHAR(255),
       UpdatedAt DATETIME,
       Active TINYINT(1),
       Deleted TINYINT(1),
       UserUserName VARCHAR(255),
       UserAccessFailedCount INTEGER,
       UserEmail VARCHAR(255),
       UserEmailConfirmed TINYINT(1),
       UserLockoutEnabled TINYINT(1),
       UserLockoutEndDateUtc DATETIME,
       UserPasswordHash VARCHAR(255),
       UserPhoneNumber VARCHAR(255),
       UserPhoneNumberConfirmed TINYINT(1),
       UserTwoFactorEnabled TINYINT(1),
       UserSecurityStamp VARCHAR(255),
       UserCreatedBy VARCHAR(255),
       UserCreatedAt DATETIME,
       UserUpdatedBy VARCHAR(255),
       UserUpdatedAt DATETIME,
       UserActive TINYINT(1),
       UserDeleted TINYINT(1),
       primary key (UserLoginIdUserId, UserLoginIdLoginKeyLoginProvider, UserLoginIdLoginKeyProviderKey)
    );

    create table UserLoginMvoStateEvents (
        UserLoginIdUserId VARCHAR(50) not null,
       UserLoginIdLoginKeyLoginProvider VARCHAR(255) not null,
       UserLoginIdLoginKeyProviderKey VARCHAR(255) not null,
       UserVersion BIGINT not null,
       StateEventType VARCHAR(255) not null,
       Version BIGINT,
       Active TINYINT(1),
       UserUserName VARCHAR(255),
       UserAccessFailedCount INTEGER,
       UserEmail VARCHAR(255),
       UserEmailConfirmed TINYINT(1),
       UserLockoutEnabled TINYINT(1),
       UserLockoutEndDateUtc DATETIME,
       UserPasswordHash VARCHAR(255),
       UserPhoneNumber VARCHAR(255),
       UserPhoneNumberConfirmed TINYINT(1),
       UserTwoFactorEnabled TINYINT(1),
       UserSecurityStamp VARCHAR(255),
       UserCreatedBy VARCHAR(255),
       UserCreatedAt DATETIME,
       UserUpdatedBy VARCHAR(255),
       UserUpdatedAt DATETIME,
       UserActive TINYINT(1),
       UserDeleted TINYINT(1),
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       IsPropertyVersionRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       IsPropertyUserUserNameRemoved TINYINT(1),
       IsPropertyUserAccessFailedCountRemoved TINYINT(1),
       IsPropertyUserEmailRemoved TINYINT(1),
       IsPropertyUserEmailConfirmedRemoved TINYINT(1),
       IsPropertyUserLockoutEnabledRemoved TINYINT(1),
       IsPropertyUserLockoutEndDateUtcRemoved TINYINT(1),
       IsPropertyUserPasswordHashRemoved TINYINT(1),
       IsPropertyUserPhoneNumberRemoved TINYINT(1),
       IsPropertyUserPhoneNumberConfirmedRemoved TINYINT(1),
       IsPropertyUserTwoFactorEnabledRemoved TINYINT(1),
       IsPropertyUserSecurityStampRemoved TINYINT(1),
       IsPropertyUserCreatedByRemoved TINYINT(1),
       IsPropertyUserCreatedAtRemoved TINYINT(1),
       IsPropertyUserUpdatedByRemoved TINYINT(1),
       IsPropertyUserUpdatedAtRemoved TINYINT(1),
       IsPropertyUserActiveRemoved TINYINT(1),
       IsPropertyUserDeletedRemoved TINYINT(1),
       primary key (UserLoginIdUserId, UserLoginIdLoginKeyLoginProvider, UserLoginIdLoginKeyProviderKey, UserVersion)
    );
