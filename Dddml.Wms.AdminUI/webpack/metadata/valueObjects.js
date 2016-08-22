export default [
  {
    "name": "RolePermissionId",
    "plural": "RolePermissionIds",
    "label": "Role Permission Id",
    "collectionLabel": "Role Permission Ids",
    "properties": [
      { name: "roleId", label: "Role Id", chainingName: "roleId" }, { name: "permissionId", label: "Permission Id", chainingName: "permissionId" }
    ]
  },
  {
    "name": "SkuId",
    "plural": "SkuIds",
    "label": "Sku Id",
    "collectionLabel": "Sku Ids",
    "properties": [
      { name: "productId", label: "Product Id", chainingName: "productId" }, { name: "attributeSetInstanceId", label: "Attribute Set Instance Id", chainingName: "attributeSetInstanceId" }
    ]
  },
  {
    "name": "DocumentAction",
    "plural": "DocumentActions",
    "label": "Document Action",
    "collectionLabel": "Document Actions",
    "properties": [
      { name: "name", label: "Name", chainingName: "name" }
    ]
  },
  {
    "name": "OrganizationStructureId",
    "plural": "OrganizationStructureIds",
    "label": "Organization Structure Id",
    "collectionLabel": "Organization Structure Ids",
    "properties": [
      { name: "organizationStructureTypeId", label: "Organization Structure Type Id", chainingName: "organizationStructureTypeId" }, { name: "parentId", label: "Parent Id", chainingName: "parentId" }, { name: "subsidiaryId", label: "Subsidiary Id", chainingName: "subsidiaryId" }
    ]
  },
  {
    "name": "PersonalName",
    "plural": "PersonalNames",
    "label": "Personal Name",
    "collectionLabel": "Personal Names",
    "properties": [
      { name: "firstName", label: "First Name", chainingName: "firstName" }, { name: "lastName", label: "Last Name", chainingName: "lastName" }
    ]
  },
  {
    "name": "Contact",
    "plural": "Contacts",
    "label": "Contact",
    "collectionLabel": "Contacts",
    "properties": [
      { name: "personalNameFirstName", label: "Personal Name / First Name", chainingName: "personalName.firstName" }, { name: "personalNameLastName", label: "Personal Name / Last Name", chainingName: "personalName.lastName" }, { name: "phoneNumber", label: "Phone Number", chainingName: "phoneNumber" }, { name: "address", label: "Address", chainingName: "address" }
    ]
  },
  {
    "name": "AttributeSetInstanceStateEventId",
    "plural": "AttributeSetInstanceStateEventIds",
    "label": "Attribute Set Instance State Event Id",
    "collectionLabel": "Attribute Set Instance State Event Ids",
    "properties": [
      { name: "attributeSetInstanceId", label: "Attribute Set Instance Id", chainingName: "attributeSetInstanceId" }, { name: "version", label: "Version", chainingName: "version" }
    ]
  },
  {
    "name": "AttributeSetInstanceExtensionFieldId",
    "plural": "AttributeSetInstanceExtensionFieldIds",
    "label": "Attribute Set Instance Extension Field Id",
    "collectionLabel": "Attribute Set Instance Extension Field Ids",
    "properties": [
      { name: "groupId", label: "Group Id", chainingName: "groupId" }, { name: "index", label: "Index", chainingName: "index" }
    ]
  },
  {
    "name": "AttributeSetInstanceExtensionFieldGroupStateEventId",
    "plural": "AttributeSetInstanceExtensionFieldGroupStateEventIds",
    "label": "Attribute Set Instance Extension Field Group State Event Id",
    "collectionLabel": "Attribute Set Instance Extension Field Group State Event Ids",
    "properties": [
      { name: "id", label: "Id", chainingName: "id" }, { name: "version", label: "Version", chainingName: "version" }
    ]
  },
  {
    "name": "AttributeSetInstanceExtensionFieldStateEventId",
    "plural": "AttributeSetInstanceExtensionFieldStateEventIds",
    "label": "Attribute Set Instance Extension Field State Event Id",
    "collectionLabel": "Attribute Set Instance Extension Field State Event Ids",
    "properties": [
      { name: "groupId", label: "Group Id", chainingName: "groupId" }, { name: "index", label: "Index", chainingName: "index" }, { name: "attributeSetInstanceExtensionFieldGroupVersion", label: "Attribute Set Instance Extension Field Group Version", chainingName: "attributeSetInstanceExtensionFieldGroupVersion" }
    ]
  },
  {
    "name": "RoleStateEventId",
    "plural": "RoleStateEventIds",
    "label": "Role State Event Id",
    "collectionLabel": "Role State Event Ids",
    "properties": [
      { name: "roleId", label: "Role Id", chainingName: "roleId" }, { name: "version", label: "Version", chainingName: "version" }
    ]
  },
  {
    "name": "PermissionStateEventId",
    "plural": "PermissionStateEventIds",
    "label": "Permission State Event Id",
    "collectionLabel": "Permission State Event Ids",
    "properties": [
      { name: "permissionId", label: "Permission Id", chainingName: "permissionId" }, { name: "version", label: "Version", chainingName: "version" }
    ]
  },
  {
    "name": "RolePermissionStateEventId",
    "plural": "RolePermissionStateEventIds",
    "label": "Role Permission State Event Id",
    "collectionLabel": "Role Permission State Event Ids",
    "properties": [
      { name: "idRoleId", label: "Id / Role Id", chainingName: "id.roleId" }, { name: "idPermissionId", label: "Id / Permission Id", chainingName: "id.permissionId" }, { name: "version", label: "Version", chainingName: "version" }
    ]
  },
  {
    "name": "AttributeValueId",
    "plural": "AttributeValueIds",
    "label": "Attribute Value Id",
    "collectionLabel": "Attribute Value Ids",
    "properties": [
      { name: "attributeId", label: "Attribute Id", chainingName: "attributeId" }, { name: "value", label: "Value", chainingName: "value" }
    ]
  },
  {
    "name": "AttributeStateEventId",
    "plural": "AttributeStateEventIds",
    "label": "Attribute State Event Id",
    "collectionLabel": "Attribute State Event Ids",
    "properties": [
      { name: "attributeId", label: "Attribute Id", chainingName: "attributeId" }, { name: "version", label: "Version", chainingName: "version" }
    ]
  },
  {
    "name": "AttributeValueStateEventId",
    "plural": "AttributeValueStateEventIds",
    "label": "Attribute Value State Event Id",
    "collectionLabel": "Attribute Value State Event Ids",
    "properties": [
      { name: "attributeId", label: "Attribute Id", chainingName: "attributeId" }, { name: "value", label: "Value", chainingName: "value" }, { name: "attributeVersion", label: "Attribute Version", chainingName: "attributeVersion" }
    ]
  },
  {
    "name": "AttributeSetAttributeUseId",
    "plural": "AttributeSetAttributeUseIds",
    "label": "Attribute Set Attribute Use Id",
    "collectionLabel": "Attribute Set Attribute Use Ids",
    "properties": [
      { name: "attributeSetId", label: "Attribute Set Id", chainingName: "attributeSetId" }, { name: "attributeId", label: "Attribute Id", chainingName: "attributeId" }
    ]
  },
  {
    "name": "AttributeSetStateEventId",
    "plural": "AttributeSetStateEventIds",
    "label": "Attribute Set State Event Id",
    "collectionLabel": "Attribute Set State Event Ids",
    "properties": [
      { name: "attributeSetId", label: "Attribute Set Id", chainingName: "attributeSetId" }, { name: "version", label: "Version", chainingName: "version" }
    ]
  },
  {
    "name": "AttributeUseStateEventId",
    "plural": "AttributeUseStateEventIds",
    "label": "Attribute Use State Event Id",
    "collectionLabel": "Attribute Use State Event Ids",
    "properties": [
      { name: "attributeSetId", label: "Attribute Set Id", chainingName: "attributeSetId" }, { name: "attributeId", label: "Attribute Id", chainingName: "attributeId" }, { name: "attributeSetVersion", label: "Attribute Set Version", chainingName: "attributeSetVersion" }
    ]
  },
  {
    "name": "AudienceStateEventId",
    "plural": "AudienceStateEventIds",
    "label": "Audience State Event Id",
    "collectionLabel": "Audience State Event Ids",
    "properties": [
      { name: "clientId", label: "Client Id", chainingName: "clientId" }, { name: "version", label: "Version", chainingName: "version" }
    ]
  },
  {
    "name": "LoginKey",
    "plural": "LoginKeys",
    "label": "Login Key",
    "collectionLabel": "Login Keys",
    "properties": [
      { name: "loginProvider", label: "Login Provider", chainingName: "loginProvider" }, { name: "providerKey", label: "Provider Key", chainingName: "providerKey" }
    ]
  },
  {
    "name": "UserRoleId",
    "plural": "UserRoleIds",
    "label": "User Role Id",
    "collectionLabel": "User Role Ids",
    "properties": [
      { name: "userId", label: "User Id", chainingName: "userId" }, { name: "roleId", label: "Role Id", chainingName: "roleId" }
    ]
  },
  {
    "name": "UserClaimId",
    "plural": "UserClaimIds",
    "label": "User Claim Id",
    "collectionLabel": "User Claim Ids",
    "properties": [
      { name: "userId", label: "User Id", chainingName: "userId" }, { name: "claimId", label: "Claim Id", chainingName: "claimId" }
    ]
  },
  {
    "name": "UserPermissionId",
    "plural": "UserPermissionIds",
    "label": "User Permission Id",
    "collectionLabel": "User Permission Ids",
    "properties": [
      { name: "userId", label: "User Id", chainingName: "userId" }, { name: "permissionId", label: "Permission Id", chainingName: "permissionId" }
    ]
  },
  {
    "name": "UserLoginId",
    "plural": "UserLoginIds",
    "label": "User Login Id",
    "collectionLabel": "User Login Ids",
    "properties": [
      { name: "userId", label: "User Id", chainingName: "userId" }, { name: "loginKeyLoginProvider", label: "Login Key / Login Provider", chainingName: "loginKey.loginProvider" }, { name: "loginKeyProviderKey", label: "Login Key / Provider Key", chainingName: "loginKey.providerKey" }
    ]
  },
  {
    "name": "UserStateEventId",
    "plural": "UserStateEventIds",
    "label": "User State Event Id",
    "collectionLabel": "User State Event Ids",
    "properties": [
      { name: "userId", label: "User Id", chainingName: "userId" }, { name: "version", label: "Version", chainingName: "version" }
    ]
  },
  {
    "name": "UserRoleStateEventId",
    "plural": "UserRoleStateEventIds",
    "label": "User Role State Event Id",
    "collectionLabel": "User Role State Event Ids",
    "properties": [
      { name: "userId", label: "User Id", chainingName: "userId" }, { name: "roleId", label: "Role Id", chainingName: "roleId" }, { name: "userVersion", label: "User Version", chainingName: "userVersion" }
    ]
  },
  {
    "name": "UserClaimStateEventId",
    "plural": "UserClaimStateEventIds",
    "label": "User Claim State Event Id",
    "collectionLabel": "User Claim State Event Ids",
    "properties": [
      { name: "userId", label: "User Id", chainingName: "userId" }, { name: "claimId", label: "Claim Id", chainingName: "claimId" }, { name: "userVersion", label: "User Version", chainingName: "userVersion" }
    ]
  },
  {
    "name": "UserPermissionStateEventId",
    "plural": "UserPermissionStateEventIds",
    "label": "User Permission State Event Id",
    "collectionLabel": "User Permission State Event Ids",
    "properties": [
      { name: "userId", label: "User Id", chainingName: "userId" }, { name: "permissionId", label: "Permission Id", chainingName: "permissionId" }, { name: "userVersion", label: "User Version", chainingName: "userVersion" }
    ]
  },
  {
    "name": "UserLoginStateEventId",
    "plural": "UserLoginStateEventIds",
    "label": "User Login State Event Id",
    "collectionLabel": "User Login State Event Ids",
    "properties": [
      { name: "userId", label: "User Id", chainingName: "userId" }, { name: "loginKeyLoginProvider", label: "Login Key / Login Provider", chainingName: "loginKey.loginProvider" }, { name: "loginKeyProviderKey", label: "Login Key / Provider Key", chainingName: "loginKey.providerKey" }, { name: "userVersion", label: "User Version", chainingName: "userVersion" }
    ]
  },
  {
    "name": "InOutLineId",
    "plural": "InOutLineIds",
    "label": "In Out Line Id",
    "collectionLabel": "In Out Line Ids",
    "properties": [
      { name: "inOutDocumentNumber", label: "In Out Document Number", chainingName: "inOutDocumentNumber" }, { name: "skuIdProductId", label: "Sku Id / Product Id", chainingName: "skuId.productId" }, { name: "skuIdAttributeSetInstanceId", label: "Sku Id / Attribute Set Instance Id", chainingName: "skuId.attributeSetInstanceId" }
    ]
  },
  {
    "name": "InOutStateEventId",
    "plural": "InOutStateEventIds",
    "label": "In Out State Event Id",
    "collectionLabel": "In Out State Event Ids",
    "properties": [
      { name: "documentNumber", label: "Document Number", chainingName: "documentNumber" }, { name: "version", label: "Version", chainingName: "version" }
    ]
  },
  {
    "name": "InOutLineStateEventId",
    "plural": "InOutLineStateEventIds",
    "label": "In Out Line State Event Id",
    "collectionLabel": "In Out Line State Event Ids",
    "properties": [
      { name: "inOutDocumentNumber", label: "In Out Document Number", chainingName: "inOutDocumentNumber" }, { name: "skuIdProductId", label: "Sku Id / Product Id", chainingName: "skuId.productId" }, { name: "skuIdAttributeSetInstanceId", label: "Sku Id / Attribute Set Instance Id", chainingName: "skuId.attributeSetInstanceId" }, { name: "inOutVersion", label: "In Out Version", chainingName: "inOutVersion" }
    ]
  },
  {
    "name": "OrganizationStateEventId",
    "plural": "OrganizationStateEventIds",
    "label": "Organization State Event Id",
    "collectionLabel": "Organization State Event Ids",
    "properties": [
      { name: "organizationId", label: "Organization Id", chainingName: "organizationId" }, { name: "version", label: "Version", chainingName: "version" }
    ]
  },
  {
    "name": "OrganizationStructureTypeStateEventId",
    "plural": "OrganizationStructureTypeStateEventIds",
    "label": "Organization Structure Type State Event Id",
    "collectionLabel": "Organization Structure Type State Event Ids",
    "properties": [
      { name: "id", label: "Id", chainingName: "id" }, { name: "version", label: "Version", chainingName: "version" }
    ]
  },
  {
    "name": "OrganizationStructureStateEventId",
    "plural": "OrganizationStructureStateEventIds",
    "label": "Organization Structure State Event Id",
    "collectionLabel": "Organization Structure State Event Ids",
    "properties": [
      { name: "idOrganizationStructureTypeId", label: "Id / Organization Structure Type Id", chainingName: "id.organizationStructureTypeId" }, { name: "idParentId", label: "Id / Parent Id", chainingName: "id.parentId" }, { name: "idSubsidiaryId", label: "Id / Subsidiary Id", chainingName: "id.subsidiaryId" }, { name: "version", label: "Version", chainingName: "version" }
    ]
  },
  {
    "name": "WarehouseStateEventId",
    "plural": "WarehouseStateEventIds",
    "label": "Warehouse State Event Id",
    "collectionLabel": "Warehouse State Event Ids",
    "properties": [
      { name: "warehouseId", label: "Warehouse Id", chainingName: "warehouseId" }, { name: "version", label: "Version", chainingName: "version" }
    ]
  },
  {
    "name": "LocatorStateEventId",
    "plural": "LocatorStateEventIds",
    "label": "Locator State Event Id",
    "collectionLabel": "Locator State Event Ids",
    "properties": [
      { name: "locatorId", label: "Locator Id", chainingName: "locatorId" }, { name: "version", label: "Version", chainingName: "version" }
    ]
  },
  {
    "name": "YearPlanId",
    "plural": "YearPlanIds",
    "label": "Year Plan Id",
    "collectionLabel": "Year Plan Ids",
    "properties": [
      { name: "personalNameFirstName", label: "Personal Name / First Name", chainingName: "personalName.firstName" }, { name: "personalNameLastName", label: "Personal Name / Last Name", chainingName: "personalName.lastName" }, { name: "year", label: "Year", chainingName: "year" }
    ]
  },
  {
    "name": "MonthPlanId",
    "plural": "MonthPlanIds",
    "label": "Month Plan Id",
    "collectionLabel": "Month Plan Ids",
    "properties": [
      { name: "personalNameFirstName", label: "Personal Name / First Name", chainingName: "personalName.firstName" }, { name: "personalNameLastName", label: "Personal Name / Last Name", chainingName: "personalName.lastName" }, { name: "year", label: "Year", chainingName: "year" }, { name: "month", label: "Month", chainingName: "month" }
    ]
  },
  {
    "name": "DayPlanId",
    "plural": "DayPlanIds",
    "label": "Day Plan Id",
    "collectionLabel": "Day Plan Ids",
    "properties": [
      { name: "personalNameFirstName", label: "Personal Name / First Name", chainingName: "personalName.firstName" }, { name: "personalNameLastName", label: "Personal Name / Last Name", chainingName: "personalName.lastName" }, { name: "year", label: "Year", chainingName: "year" }, { name: "month", label: "Month", chainingName: "month" }, { name: "day", label: "Day", chainingName: "day" }
    ]
  },
  {
    "name": "PersonStateEventId",
    "plural": "PersonStateEventIds",
    "label": "Person State Event Id",
    "collectionLabel": "Person State Event Ids",
    "properties": [
      { name: "personalNameFirstName", label: "Personal Name / First Name", chainingName: "personalName.firstName" }, { name: "personalNameLastName", label: "Personal Name / Last Name", chainingName: "personalName.lastName" }, { name: "version", label: "Version", chainingName: "version" }
    ]
  },
  {
    "name": "YearPlanStateEventId",
    "plural": "YearPlanStateEventIds",
    "label": "Year Plan State Event Id",
    "collectionLabel": "Year Plan State Event Ids",
    "properties": [
      { name: "personalNameFirstName", label: "Personal Name / First Name", chainingName: "personalName.firstName" }, { name: "personalNameLastName", label: "Personal Name / Last Name", chainingName: "personalName.lastName" }, { name: "year", label: "Year", chainingName: "year" }, { name: "personVersion", label: "Person Version", chainingName: "personVersion" }
    ]
  },
  {
    "name": "MonthPlanStateEventId",
    "plural": "MonthPlanStateEventIds",
    "label": "Month Plan State Event Id",
    "collectionLabel": "Month Plan State Event Ids",
    "properties": [
      { name: "personalNameFirstName", label: "Personal Name / First Name", chainingName: "personalName.firstName" }, { name: "personalNameLastName", label: "Personal Name / Last Name", chainingName: "personalName.lastName" }, { name: "year", label: "Year", chainingName: "year" }, { name: "month", label: "Month", chainingName: "month" }, { name: "personVersion", label: "Person Version", chainingName: "personVersion" }
    ]
  },
  {
    "name": "DayPlanStateEventId",
    "plural": "DayPlanStateEventIds",
    "label": "Day Plan State Event Id",
    "collectionLabel": "Day Plan State Event Ids",
    "properties": [
      { name: "personalNameFirstName", label: "Personal Name / First Name", chainingName: "personalName.firstName" }, { name: "personalNameLastName", label: "Personal Name / Last Name", chainingName: "personalName.lastName" }, { name: "year", label: "Year", chainingName: "year" }, { name: "month", label: "Month", chainingName: "month" }, { name: "day", label: "Day", chainingName: "day" }, { name: "personVersion", label: "Person Version", chainingName: "personVersion" }
    ]
  },
  {
    "name": "TeamStateEventId",
    "plural": "TeamStateEventIds",
    "label": "Team State Event Id",
    "collectionLabel": "Team State Event Ids",
    "properties": [
      { name: "teamName", label: "Team Name", chainingName: "teamName" }, { name: "version", label: "Version", chainingName: "version" }
    ]
  },
  {
    "name": "AttributeSetInstanceExtensionFieldMvoStateEventId",
    "plural": "AttributeSetInstanceExtensionFieldMvoStateEventIds",
    "label": "Attribute Set Instance Extension Field Mvo State Event Id",
    "collectionLabel": "Attribute Set Instance Extension Field Mvo State Event Ids",
    "properties": [
      { name: "attributeSetInstanceExtensionFieldIdGroupId", label: "Attribute Set Instance Extension Field Id / Group Id", chainingName: "attributeSetInstanceExtensionFieldId.groupId" }, { name: "attributeSetInstanceExtensionFieldIdIndex", label: "Attribute Set Instance Extension Field Id / Index", chainingName: "attributeSetInstanceExtensionFieldId.index" }, { name: "attrSetInstEFGroupVersion", label: "Attr Set Inst EF Group Version", chainingName: "attrSetInstEFGroupVersion" }
    ]
  },
  {
    "name": "AttributeValueMvoStateEventId",
    "plural": "AttributeValueMvoStateEventIds",
    "label": "Attribute Value Mvo State Event Id",
    "collectionLabel": "Attribute Value Mvo State Event Ids",
    "properties": [
      { name: "attributeValueIdAttributeId", label: "Attribute Value Id / Attribute Id", chainingName: "attributeValueId.attributeId" }, { name: "attributeValueIdValue", label: "Attribute Value Id / Value", chainingName: "attributeValueId.value" }, { name: "attributeVersion", label: "Attribute Version", chainingName: "attributeVersion" }
    ]
  },
  {
    "name": "AttributeUseMvoStateEventId",
    "plural": "AttributeUseMvoStateEventIds",
    "label": "Attribute Use Mvo State Event Id",
    "collectionLabel": "Attribute Use Mvo State Event Ids",
    "properties": [
      { name: "attributeSetAttributeUseIdAttributeSetId", label: "Attribute Set Attribute Use Id / Attribute Set Id", chainingName: "attributeSetAttributeUseId.attributeSetId" }, { name: "attributeSetAttributeUseIdAttributeId", label: "Attribute Set Attribute Use Id / Attribute Id", chainingName: "attributeSetAttributeUseId.attributeId" }, { name: "attributeSetVersion", label: "Attribute Set Version", chainingName: "attributeSetVersion" }
    ]
  },
  {
    "name": "UserRoleMvoStateEventId",
    "plural": "UserRoleMvoStateEventIds",
    "label": "User Role Mvo State Event Id",
    "collectionLabel": "User Role Mvo State Event Ids",
    "properties": [
      { name: "userRoleIdUserId", label: "User Role Id / User Id", chainingName: "userRoleId.userId" }, { name: "userRoleIdRoleId", label: "User Role Id / Role Id", chainingName: "userRoleId.roleId" }, { name: "userVersion", label: "User Version", chainingName: "userVersion" }
    ]
  },
  {
    "name": "UserClaimMvoStateEventId",
    "plural": "UserClaimMvoStateEventIds",
    "label": "User Claim Mvo State Event Id",
    "collectionLabel": "User Claim Mvo State Event Ids",
    "properties": [
      { name: "userClaimIdUserId", label: "User Claim Id / User Id", chainingName: "userClaimId.userId" }, { name: "userClaimIdClaimId", label: "User Claim Id / Claim Id", chainingName: "userClaimId.claimId" }, { name: "userVersion", label: "User Version", chainingName: "userVersion" }
    ]
  },
  {
    "name": "UserPermissionMvoStateEventId",
    "plural": "UserPermissionMvoStateEventIds",
    "label": "User Permission Mvo State Event Id",
    "collectionLabel": "User Permission Mvo State Event Ids",
    "properties": [
      { name: "userPermissionIdUserId", label: "User Permission Id / User Id", chainingName: "userPermissionId.userId" }, { name: "userPermissionIdPermissionId", label: "User Permission Id / Permission Id", chainingName: "userPermissionId.permissionId" }, { name: "userVersion", label: "User Version", chainingName: "userVersion" }
    ]
  },
  {
    "name": "UserLoginMvoStateEventId",
    "plural": "UserLoginMvoStateEventIds",
    "label": "User Login Mvo State Event Id",
    "collectionLabel": "User Login Mvo State Event Ids",
    "properties": [
      { name: "userLoginIdUserId", label: "User Login Id / User Id", chainingName: "userLoginId.userId" }, { name: "userLoginIdLoginKeyLoginProvider", label: "User Login Id / Login Key / Login Provider", chainingName: "userLoginId.loginKey.loginProvider" }, { name: "userLoginIdLoginKeyProviderKey", label: "User Login Id / Login Key / Provider Key", chainingName: "userLoginId.loginKey.providerKey" }, { name: "userVersion", label: "User Version", chainingName: "userVersion" }
    ]
  },
  {
    "name": "InOutLineMvoStateEventId",
    "plural": "InOutLineMvoStateEventIds",
    "label": "In Out Line Mvo State Event Id",
    "collectionLabel": "In Out Line Mvo State Event Ids",
    "properties": [
      { name: "inOutLineIdInOutDocumentNumber", label: "In Out Line Id / In Out Document Number", chainingName: "inOutLineId.inOutDocumentNumber" }, { name: "inOutLineIdSkuIdProductId", label: "In Out Line Id / Sku Id / Product Id", chainingName: "inOutLineId.skuId.productId" }, { name: "inOutLineIdSkuIdAttributeSetInstanceId", label: "In Out Line Id / Sku Id / Attribute Set Instance Id", chainingName: "inOutLineId.skuId.attributeSetInstanceId" }, { name: "inOutVersion", label: "In Out Version", chainingName: "inOutVersion" }
    ]
  },
  {
    "name": "YearPlanMvoStateEventId",
    "plural": "YearPlanMvoStateEventIds",
    "label": "Year Plan Mvo State Event Id",
    "collectionLabel": "Year Plan Mvo State Event Ids",
    "properties": [
      { name: "yearPlanIdPersonalNameFirstName", label: "Year Plan Id / Personal Name / First Name", chainingName: "yearPlanId.personalName.firstName" }, { name: "yearPlanIdPersonalNameLastName", label: "Year Plan Id / Personal Name / Last Name", chainingName: "yearPlanId.personalName.lastName" }, { name: "yearPlanIdYear", label: "Year Plan Id / Year", chainingName: "yearPlanId.year" }, { name: "personVersion", label: "Person Version", chainingName: "personVersion" }
    ]
  },
  {
    "name": "MonthPlanMvoStateEventId",
    "plural": "MonthPlanMvoStateEventIds",
    "label": "Month Plan Mvo State Event Id",
    "collectionLabel": "Month Plan Mvo State Event Ids",
    "properties": [
      { name: "monthPlanIdPersonalNameFirstName", label: "Month Plan Id / Personal Name / First Name", chainingName: "monthPlanId.personalName.firstName" }, { name: "monthPlanIdPersonalNameLastName", label: "Month Plan Id / Personal Name / Last Name", chainingName: "monthPlanId.personalName.lastName" }, { name: "monthPlanIdYear", label: "Month Plan Id / Year", chainingName: "monthPlanId.year" }, { name: "monthPlanIdMonth", label: "Month Plan Id / Month", chainingName: "monthPlanId.month" }, { name: "personVersion", label: "Person Version", chainingName: "personVersion" }
    ]
  },
  {
    "name": "DayPlanMvoStateEventId",
    "plural": "DayPlanMvoStateEventIds",
    "label": "Day Plan Mvo State Event Id",
    "collectionLabel": "Day Plan Mvo State Event Ids",
    "properties": [
      { name: "dayPlanIdPersonalNameFirstName", label: "Day Plan Id / Personal Name / First Name", chainingName: "dayPlanId.personalName.firstName" }, { name: "dayPlanIdPersonalNameLastName", label: "Day Plan Id / Personal Name / Last Name", chainingName: "dayPlanId.personalName.lastName" }, { name: "dayPlanIdYear", label: "Day Plan Id / Year", chainingName: "dayPlanId.year" }, { name: "dayPlanIdMonth", label: "Day Plan Id / Month", chainingName: "dayPlanId.month" }, { name: "dayPlanIdDay", label: "Day Plan Id / Day", chainingName: "dayPlanId.day" }, { name: "personVersion", label: "Person Version", chainingName: "personVersion" }
    ]
  }
]

