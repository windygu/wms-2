alter TABLE `UserRoles` add
  CONSTRAINT `FK_UserRole_User_StateId` 
  FOREIGN KEY 
    (`UserRoleIdUserId`) 
  REFERENCES `Users` 
    (`UserId`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION;

alter TABLE `UserClaims` add
  CONSTRAINT `FK_UserClaim_User_StateId` 
  FOREIGN KEY 
    (`UserClaimIdUserId`) 
  REFERENCES `Users` 
    (`UserId`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION;

alter TABLE `UserPermissions` add
  CONSTRAINT `FK_UserPermission_User_StateId` 
  FOREIGN KEY 
    (`UserPermissionIdUserId`) 
  REFERENCES `Users` 
    (`UserId`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION;

alter TABLE `UserLogins` add
  CONSTRAINT `FK_UserLogin_User_StateId` 
  FOREIGN KEY 
    (`UserLoginIdUserId`) 
  REFERENCES `Users` 
    (`UserId`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION;

