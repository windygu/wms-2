set @var=if((SELECT true FROM information_schema.TABLE_CONSTRAINTS WHERE
            CONSTRAINT_SCHEMA = DATABASE() AND
            TABLE_NAME        = 'UserRoles' AND
            CONSTRAINT_NAME   = 'FK_UserRole_User_StateId' AND
            CONSTRAINT_TYPE   = 'FOREIGN KEY') = true,'ALTER TABLE UserRoles
            drop foreign key FK_UserRole_User_StateId','select 1');

prepare stmt from @var;
execute stmt;
deallocate prepare stmt;

set @var=if((SELECT true FROM information_schema.TABLE_CONSTRAINTS WHERE
            CONSTRAINT_SCHEMA = DATABASE() AND
            TABLE_NAME        = 'UserClaims' AND
            CONSTRAINT_NAME   = 'FK_UserClaim_User_StateId' AND
            CONSTRAINT_TYPE   = 'FOREIGN KEY') = true,'ALTER TABLE UserClaims
            drop foreign key FK_UserClaim_User_StateId','select 1');

prepare stmt from @var;
execute stmt;
deallocate prepare stmt;

set @var=if((SELECT true FROM information_schema.TABLE_CONSTRAINTS WHERE
            CONSTRAINT_SCHEMA = DATABASE() AND
            TABLE_NAME        = 'UserPermissions' AND
            CONSTRAINT_NAME   = 'FK_UserPermission_User_StateId' AND
            CONSTRAINT_TYPE   = 'FOREIGN KEY') = true,'ALTER TABLE UserPermissions
            drop foreign key FK_UserPermission_User_StateId','select 1');

prepare stmt from @var;
execute stmt;
deallocate prepare stmt;

set @var=if((SELECT true FROM information_schema.TABLE_CONSTRAINTS WHERE
            CONSTRAINT_SCHEMA = DATABASE() AND
            TABLE_NAME        = 'UserLogins' AND
            CONSTRAINT_NAME   = 'FK_UserLogin_User_StateId' AND
            CONSTRAINT_TYPE   = 'FOREIGN KEY') = true,'ALTER TABLE UserLogins
            drop foreign key FK_UserLogin_User_StateId','select 1');

prepare stmt from @var;
execute stmt;
deallocate prepare stmt;

