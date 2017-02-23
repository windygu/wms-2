CREATE VIEW `UserRole_RV` AS
    SELECT 
        `UserRoles`.`UserRoleIdUserId`,
        `UserRoles`.`UserRoleIdRoleId`,
        `UserRoles`.`Version`,
        `UserRoles`.`CreatedBy`,
        `UserRoles`.`CreatedAt`,
        `UserRoles`.`UpdatedBy`,
        `UserRoles`.`UpdatedAt`,
        `UserRoles`.`Active`,
        `UserRoles`.`Deleted`,
        `Users`.`UserName` AS `UserUserName`,
        `Users`.`AccessFailedCount` AS `UserAccessFailedCount`,
        `Users`.`Email` AS `UserEmail`,
        `Users`.`EmailConfirmed` AS `UserEmailConfirmed`,
        `Users`.`LockoutEnabled` AS `UserLockoutEnabled`,
        `Users`.`LockoutEndDateUtc` AS `UserLockoutEndDateUtc`,
        `Users`.`PasswordHash` AS `UserPasswordHash`,
        `Users`.`PhoneNumber` AS `UserPhoneNumber`,
        `Users`.`PhoneNumberConfirmed` AS `UserPhoneNumberConfirmed`,
        `Users`.`TwoFactorEnabled` AS `UserTwoFactorEnabled`,
        `Users`.`SecurityStamp` AS `UserSecurityStamp`,
        `Users`.`Version` AS `UserVersion`,
        `Users`.`CreatedBy` AS `UserCreatedBy`,
        `Users`.`CreatedAt` AS `UserCreatedAt`,
        `Users`.`UpdatedBy` AS `UserUpdatedBy`,
        `Users`.`UpdatedAt` AS `UserUpdatedAt`,
        `Users`.`Active` AS `UserActive`,
        `Users`.`Deleted` AS `UserDeleted`
    FROM
        (`UserRoles`
            JOIN `Users` ON ( 1=1 
                and (`UserRoles`.`UserRoleIdUserId` = `Users`.`UserId`)
            )
        );


CREATE VIEW `UserClaim_RV` AS
    SELECT 
        `UserClaims`.`UserClaimIdUserId`,
        `UserClaims`.`UserClaimIdClaimId`,
        `UserClaims`.`ClaimType`,
        `UserClaims`.`ClaimValue`,
        `UserClaims`.`Version`,
        `UserClaims`.`CreatedBy`,
        `UserClaims`.`CreatedAt`,
        `UserClaims`.`UpdatedBy`,
        `UserClaims`.`UpdatedAt`,
        `UserClaims`.`Active`,
        `UserClaims`.`Deleted`,
        `Users`.`UserName` AS `UserUserName`,
        `Users`.`AccessFailedCount` AS `UserAccessFailedCount`,
        `Users`.`Email` AS `UserEmail`,
        `Users`.`EmailConfirmed` AS `UserEmailConfirmed`,
        `Users`.`LockoutEnabled` AS `UserLockoutEnabled`,
        `Users`.`LockoutEndDateUtc` AS `UserLockoutEndDateUtc`,
        `Users`.`PasswordHash` AS `UserPasswordHash`,
        `Users`.`PhoneNumber` AS `UserPhoneNumber`,
        `Users`.`PhoneNumberConfirmed` AS `UserPhoneNumberConfirmed`,
        `Users`.`TwoFactorEnabled` AS `UserTwoFactorEnabled`,
        `Users`.`SecurityStamp` AS `UserSecurityStamp`,
        `Users`.`Version` AS `UserVersion`,
        `Users`.`CreatedBy` AS `UserCreatedBy`,
        `Users`.`CreatedAt` AS `UserCreatedAt`,
        `Users`.`UpdatedBy` AS `UserUpdatedBy`,
        `Users`.`UpdatedAt` AS `UserUpdatedAt`,
        `Users`.`Active` AS `UserActive`,
        `Users`.`Deleted` AS `UserDeleted`
    FROM
        (`UserClaims`
            JOIN `Users` ON ( 1=1 
                and (`UserClaims`.`UserClaimIdUserId` = `Users`.`UserId`)
            )
        );


CREATE VIEW `UserPermission_RV` AS
    SELECT 
        `UserPermissions`.`UserPermissionIdUserId`,
        `UserPermissions`.`UserPermissionIdPermissionId`,
        `UserPermissions`.`Version`,
        `UserPermissions`.`CreatedBy`,
        `UserPermissions`.`CreatedAt`,
        `UserPermissions`.`UpdatedBy`,
        `UserPermissions`.`UpdatedAt`,
        `UserPermissions`.`Active`,
        `UserPermissions`.`Deleted`,
        `Users`.`UserName` AS `UserUserName`,
        `Users`.`AccessFailedCount` AS `UserAccessFailedCount`,
        `Users`.`Email` AS `UserEmail`,
        `Users`.`EmailConfirmed` AS `UserEmailConfirmed`,
        `Users`.`LockoutEnabled` AS `UserLockoutEnabled`,
        `Users`.`LockoutEndDateUtc` AS `UserLockoutEndDateUtc`,
        `Users`.`PasswordHash` AS `UserPasswordHash`,
        `Users`.`PhoneNumber` AS `UserPhoneNumber`,
        `Users`.`PhoneNumberConfirmed` AS `UserPhoneNumberConfirmed`,
        `Users`.`TwoFactorEnabled` AS `UserTwoFactorEnabled`,
        `Users`.`SecurityStamp` AS `UserSecurityStamp`,
        `Users`.`Version` AS `UserVersion`,
        `Users`.`CreatedBy` AS `UserCreatedBy`,
        `Users`.`CreatedAt` AS `UserCreatedAt`,
        `Users`.`UpdatedBy` AS `UserUpdatedBy`,
        `Users`.`UpdatedAt` AS `UserUpdatedAt`,
        `Users`.`Active` AS `UserActive`,
        `Users`.`Deleted` AS `UserDeleted`
    FROM
        (`UserPermissions`
            JOIN `Users` ON ( 1=1 
                and (`UserPermissions`.`UserPermissionIdUserId` = `Users`.`UserId`)
            )
        );


CREATE VIEW `UserLogin_RV` AS
    SELECT 
        `UserLogins`.`UserLoginIdUserId`,
        `UserLogins`.`UserLoginIdLoginKeyLoginProvider`,
        `UserLogins`.`UserLoginIdLoginKeyProviderKey`,
        `UserLogins`.`Version`,
        `UserLogins`.`CreatedBy`,
        `UserLogins`.`CreatedAt`,
        `UserLogins`.`UpdatedBy`,
        `UserLogins`.`UpdatedAt`,
        `UserLogins`.`Active`,
        `UserLogins`.`Deleted`,
        `Users`.`UserName` AS `UserUserName`,
        `Users`.`AccessFailedCount` AS `UserAccessFailedCount`,
        `Users`.`Email` AS `UserEmail`,
        `Users`.`EmailConfirmed` AS `UserEmailConfirmed`,
        `Users`.`LockoutEnabled` AS `UserLockoutEnabled`,
        `Users`.`LockoutEndDateUtc` AS `UserLockoutEndDateUtc`,
        `Users`.`PasswordHash` AS `UserPasswordHash`,
        `Users`.`PhoneNumber` AS `UserPhoneNumber`,
        `Users`.`PhoneNumberConfirmed` AS `UserPhoneNumberConfirmed`,
        `Users`.`TwoFactorEnabled` AS `UserTwoFactorEnabled`,
        `Users`.`SecurityStamp` AS `UserSecurityStamp`,
        `Users`.`Version` AS `UserVersion`,
        `Users`.`CreatedBy` AS `UserCreatedBy`,
        `Users`.`CreatedAt` AS `UserCreatedAt`,
        `Users`.`UpdatedBy` AS `UserUpdatedBy`,
        `Users`.`UpdatedAt` AS `UserUpdatedAt`,
        `Users`.`Active` AS `UserActive`,
        `Users`.`Deleted` AS `UserDeleted`
    FROM
        (`UserLogins`
            JOIN `Users` ON ( 1=1 
                and (`UserLogins`.`UserLoginIdUserId` = `Users`.`UserId`)
            )
        );


