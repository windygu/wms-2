
    
alter table AttributeSetInstanceStateEventRemovedProperties  drop foreign key FK9C8A405747E4A019
;

    
alter table TeamPlayers  drop foreign key FKB13B0820CF73904F
;

    
alter table TeamMascots  drop foreign key FK5FD05D69CF73904F
;

    
alter table TeamStateEventPlayers  drop foreign key FKA55D710EDFD9A6F1
;

    
alter table TeamStateEventMascots  drop foreign key FK750DD7B3DFD9A6F1
;

    drop table if exists AttributeSetInstances;

    drop table if exists AttributeSetInstanceStateEvents;

    drop table if exists AttributeSetInstanceStateEventRemovedProperties;

    drop table if exists AttributeSetInstanceExtensionFieldGroups;

    drop table if exists AttributeSetInstanceExtensionFieldGroupStateEvents;

    drop table if exists AttributeSetInstanceExtensionFields;

    drop table if exists AttributeSetInstanceExtensionFieldStateEvents;

    drop table if exists Attributes;

    drop table if exists AttributeStateEvents;

    drop table if exists AttributeValues;

    drop table if exists AttributeValueStateEvents;

    drop table if exists AttributeSets;

    drop table if exists AttributeSetStateEvents;

    drop table if exists AttributeUses;

    drop table if exists AttributeUseStateEvents;

    drop table if exists Audiences;

    drop table if exists AudienceStateEvents;

    drop table if exists DayPlans;

    drop table if exists DayPlanStateEvents;

    drop table if exists AttributeSetInstanceExtensionField_RV;

    drop table if exists AttributeSetInstanceExtensionFieldMvoStateEvents;

    drop table if exists AttributeValue_RV;

    drop table if exists AttributeValueMvoStateEvents;

    drop table if exists AttributeUse_RV;

    drop table if exists AttributeUseMvoStateEvents;

    drop table if exists DayPlan_RV;

    drop table if exists DayPlanMvoStateEvents;

    drop table if exists Roles;

    drop table if exists RoleStateEvents;

    drop table if exists Permissions;

    drop table if exists PermissionStateEvents;

    drop table if exists RolePermissions;

    drop table if exists RolePermissionStateEvents;

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

    drop table if exists InOuts;

    drop table if exists InOutStateEvents;

    drop table if exists InOutLines;

    drop table if exists InOutLineStateEvents;

    drop table if exists Organizations;

    drop table if exists OrganizationStateEvents;

    drop table if exists OrganizationStructureTypes;

    drop table if exists OrganizationStructureTypeStateEvents;

    drop table if exists OrganizationStructures;

    drop table if exists OrganizationStructureStateEvents;

    drop table if exists Warehouses;

    drop table if exists WarehouseStateEvents;

    drop table if exists Locators;

    drop table if exists LocatorStateEvents;

    drop table if exists People;

    drop table if exists PersonStateEvents;

    drop table if exists YearPlans;

    drop table if exists YearPlanStateEvents;

    drop table if exists MonthPlans;

    drop table if exists MonthPlanStateEvents;

    drop table if exists Teams;

    drop table if exists TeamPlayers;

    drop table if exists TeamMascots;

    drop table if exists TeamStateEvents;

    drop table if exists TeamStateEventPlayers;

    drop table if exists TeamStateEventMascots;

    drop table if exists UserRole_RV;

    drop table if exists UserRoleMvoStateEvents;

    drop table if exists UserClaim_RV;

    drop table if exists UserClaimMvoStateEvents;

    drop table if exists UserPermission_RV;

    drop table if exists UserPermissionMvoStateEvents;

    drop table if exists UserLogin_RV;

    drop table if exists UserLoginMvoStateEvents;

    drop table if exists InOutLine_RV;

    drop table if exists InOutLineMvoStateEvents;

    drop table if exists YearPlan_RV;

    drop table if exists YearPlanMvoStateEvents;

    drop table if exists MonthPlan_RV;

    drop table if exists MonthPlanMvoStateEvents;
