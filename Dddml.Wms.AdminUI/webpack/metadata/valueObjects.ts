export const VALUE_OBJECT_METADATA = [
  {
    "name": "RolePermissionId",
    "plural": "RolePermissionIds",
    "label": "Role Permission Id",
    "collectionLabel": "Role Permission Ids",
    "properties": [
      { name: "roleId", label: "Role Id", type: "string" }, { name: "permissionId", label: "Permission Id", type: "string" }
    ]
  },
  {
    "name": "SkuId",
    "plural": "SkuIds",
    "label": "Sku Id",
    "collectionLabel": "Sku Ids",
    "properties": [
      { name: "productId", label: "Product Id", type: "string" }, { name: "attributeSetInstanceId", label: "Attribute Set Instance Id", type: "string" }
    ]
  },
  {
    "name": "OrganizationStructureId",
    "plural": "OrganizationStructureIds",
    "label": "Organization Structure Id",
    "collectionLabel": "Organization Structure Ids",
    "properties": [
      { name: "organizationStructureTypeId", label: "Organization Structure Type Id", type: "string", referenceType: "OrganizationStructureType" }, { name: "parentId", label: "Parent Id", type: "string", referenceType: "Organization" }, { name: "subsidiaryId", label: "Subsidiary Id", type: "string", referenceType: "Organization" }
    ]
  },
  {
    "name": "AttributeSetInstanceStateEventId",
    "plural": "AttributeSetInstanceStateEventIds",
    "label": "Attribute Set Instance State Event Id",
    "collectionLabel": "Attribute Set Instance State Event Ids",
    "properties": [
      { name: "attributeSetInstanceId", label: "Attribute Set Instance Id", type: "string" }, { name: "version", label: "Version", type: "long" }
    ]
  },
  {
    "name": "AttributeSetInstanceExtensionFieldId",
    "plural": "AttributeSetInstanceExtensionFieldIds",
    "label": "Attribute Set Instance Extension Field Id",
    "collectionLabel": "Attribute Set Instance Extension Field Ids",
    "properties": [
      { name: "groupId", label: "Group Id", type: "string" }, { name: "index", label: "Index", type: "string" }
    ]
  },
  {
    "name": "AttributeSetInstanceExtensionFieldGroupStateEventId",
    "plural": "AttributeSetInstanceExtensionFieldGroupStateEventIds",
    "label": "Attribute Set Instance Extension Field Group State Event Id",
    "collectionLabel": "Attribute Set Instance Extension Field Group State Event Ids",
    "properties": [
      { name: "id", label: "Id", type: "string" }, { name: "version", label: "Version", type: "long" }
    ]
  },
  {
    "name": "AttributeSetInstanceExtensionFieldStateEventId",
    "plural": "AttributeSetInstanceExtensionFieldStateEventIds",
    "label": "Attribute Set Instance Extension Field State Event Id",
    "collectionLabel": "Attribute Set Instance Extension Field State Event Ids",
    "properties": [
      { name: "groupId", label: "Group Id", type: "string" }, { name: "index", label: "Index", type: "string" }, { name: "attributeSetInstanceExtensionFieldGroupVersion", label: "Attribute Set Instance Extension Field Group Version", type: "long" }
    ]
  },
  {
    "name": "RoleStateEventId",
    "plural": "RoleStateEventIds",
    "label": "Role State Event Id",
    "collectionLabel": "Role State Event Ids",
    "properties": [
      { name: "roleId", label: "Role Id", type: "string" }, { name: "version", label: "Version", type: "long" }
    ]
  },
  {
    "name": "PermissionStateEventId",
    "plural": "PermissionStateEventIds",
    "label": "Permission State Event Id",
    "collectionLabel": "Permission State Event Ids",
    "properties": [
      { name: "permissionId", label: "Permission Id", type: "string" }, { name: "version", label: "Version", type: "long" }
    ]
  },
  {
    "name": "RolePermissionStateEventId",
    "plural": "RolePermissionStateEventIds",
    "label": "Role Permission State Event Id",
    "collectionLabel": "Role Permission State Event Ids",
    "properties": [
      { name: "id", label: "Id", type: "RolePermissionId" }, { name: "version", label: "Version", type: "long" }
    ]
  },
  {
    "name": "AttributeValueId",
    "plural": "AttributeValueIds",
    "label": "Attribute Value Id",
    "collectionLabel": "Attribute Value Ids",
    "properties": [
      { name: "attributeId", label: "Attribute Id", type: "string" }, { name: "value", label: "Value", type: "string" }
    ]
  },
  {
    "name": "AttributeStateEventId",
    "plural": "AttributeStateEventIds",
    "label": "Attribute State Event Id",
    "collectionLabel": "Attribute State Event Ids",
    "properties": [
      { name: "attributeId", label: "Attribute Id", type: "string" }, { name: "version", label: "Version", type: "long" }
    ]
  },
  {
    "name": "AttributeValueStateEventId",
    "plural": "AttributeValueStateEventIds",
    "label": "Attribute Value State Event Id",
    "collectionLabel": "Attribute Value State Event Ids",
    "properties": [
      { name: "attributeId", label: "Attribute Id", type: "string" }, { name: "value", label: "Value", type: "string" }, { name: "attributeVersion", label: "Attribute Version", type: "long" }
    ]
  },
  {
    "name": "AttributeSetAttributeUseId",
    "plural": "AttributeSetAttributeUseIds",
    "label": "Attribute Set Attribute Use Id",
    "collectionLabel": "Attribute Set Attribute Use Ids",
    "properties": [
      { name: "attributeSetId", label: "Attribute Set Id", type: "string" }, { name: "attributeId", label: "Attribute Id", type: "string" }
    ]
  },
  {
    "name": "AttributeSetStateEventId",
    "plural": "AttributeSetStateEventIds",
    "label": "Attribute Set State Event Id",
    "collectionLabel": "Attribute Set State Event Ids",
    "properties": [
      { name: "attributeSetId", label: "Attribute Set Id", type: "string" }, { name: "version", label: "Version", type: "long" }
    ]
  },
  {
    "name": "AttributeUseStateEventId",
    "plural": "AttributeUseStateEventIds",
    "label": "Attribute Use State Event Id",
    "collectionLabel": "Attribute Use State Event Ids",
    "properties": [
      { name: "attributeSetId", label: "Attribute Set Id", type: "string" }, { name: "attributeId", label: "Attribute Id", type: "string" }, { name: "attributeSetVersion", label: "Attribute Set Version", type: "long" }
    ]
  },
  {
    "name": "AudienceStateEventId",
    "plural": "AudienceStateEventIds",
    "label": "Audience State Event Id",
    "collectionLabel": "Audience State Event Ids",
    "properties": [
      { name: "clientId", label: "Client Id", type: "string" }, { name: "version", label: "Version", type: "long" }
    ]
  },
  {
    "name": "LoginKey",
    "plural": "LoginKeys",
    "label": "Login Key",
    "collectionLabel": "Login Keys",
    "properties": [
      { name: "loginProvider", label: "Login Provider", type: "string" }, { name: "providerKey", label: "Provider Key", type: "string" }
    ]
  },
  {
    "name": "UserRoleId",
    "plural": "UserRoleIds",
    "label": "User Role Id",
    "collectionLabel": "User Role Ids",
    "properties": [
      { name: "userId", label: "User Id", type: "string" }, { name: "roleId", label: "Role Id", type: "string" }
    ]
  },
  {
    "name": "UserClaimId",
    "plural": "UserClaimIds",
    "label": "User Claim Id",
    "collectionLabel": "User Claim Ids",
    "properties": [
      { name: "userId", label: "User Id", type: "string" }, { name: "claimId", label: "Claim Id", type: "int" }
    ]
  },
  {
    "name": "UserPermissionId",
    "plural": "UserPermissionIds",
    "label": "User Permission Id",
    "collectionLabel": "User Permission Ids",
    "properties": [
      { name: "userId", label: "User Id", type: "string" }, { name: "permissionId", label: "Permission Id", type: "string" }
    ]
  },
  {
    "name": "UserLoginId",
    "plural": "UserLoginIds",
    "label": "User Login Id",
    "collectionLabel": "User Login Ids",
    "properties": [
      { name: "userId", label: "User Id", type: "string" }, { name: "loginKey", label: "Login Key", type: "LoginKey" }
    ]
  },
  {
    "name": "UserStateEventId",
    "plural": "UserStateEventIds",
    "label": "User State Event Id",
    "collectionLabel": "User State Event Ids",
    "properties": [
      { name: "userId", label: "User Id", type: "string" }, { name: "version", label: "Version", type: "long" }
    ]
  },
  {
    "name": "UserRoleStateEventId",
    "plural": "UserRoleStateEventIds",
    "label": "User Role State Event Id",
    "collectionLabel": "User Role State Event Ids",
    "properties": [
      { name: "userId", label: "User Id", type: "string" }, { name: "roleId", label: "Role Id", type: "string" }, { name: "userVersion", label: "User Version", type: "long" }
    ]
  },
  {
    "name": "UserClaimStateEventId",
    "plural": "UserClaimStateEventIds",
    "label": "User Claim State Event Id",
    "collectionLabel": "User Claim State Event Ids",
    "properties": [
      { name: "userId", label: "User Id", type: "string" }, { name: "claimId", label: "Claim Id", type: "int" }, { name: "userVersion", label: "User Version", type: "long" }
    ]
  },
  {
    "name": "UserPermissionStateEventId",
    "plural": "UserPermissionStateEventIds",
    "label": "User Permission State Event Id",
    "collectionLabel": "User Permission State Event Ids",
    "properties": [
      { name: "userId", label: "User Id", type: "string" }, { name: "permissionId", label: "Permission Id", type: "string" }, { name: "userVersion", label: "User Version", type: "long" }
    ]
  },
  {
    "name": "UserLoginStateEventId",
    "plural": "UserLoginStateEventIds",
    "label": "User Login State Event Id",
    "collectionLabel": "User Login State Event Ids",
    "properties": [
      { name: "userId", label: "User Id", type: "string" }, { name: "loginKey", label: "Login Key", type: "LoginKey" }, { name: "userVersion", label: "User Version", type: "long" }
    ]
  },
  {
    "name": "InOutLineId",
    "plural": "InOutLineIds",
    "label": "In Out Line Id",
    "collectionLabel": "In Out Line Ids",
    "properties": [
      { name: "inOutDocumentNumber", label: "In Out Document Number", type: "string" }, { name: "skuId", label: "Sku Id", type: "SkuId" }
    ]
  },
  {
    "name": "InOutStateEventId",
    "plural": "InOutStateEventIds",
    "label": "In Out State Event Id",
    "collectionLabel": "In Out State Event Ids",
    "properties": [
      { name: "documentNumber", label: "Document Number", type: "string" }, { name: "version", label: "Version", type: "long" }
    ]
  },
  {
    "name": "InOutLineStateEventId",
    "plural": "InOutLineStateEventIds",
    "label": "In Out Line State Event Id",
    "collectionLabel": "In Out Line State Event Ids",
    "properties": [
      { name: "inOutDocumentNumber", label: "In Out Document Number", type: "string" }, { name: "skuId", label: "Sku Id", type: "SkuId" }, { name: "inOutVersion", label: "In Out Version", type: "long" }
    ]
  },
  {
    "name": "OrganizationStateEventId",
    "plural": "OrganizationStateEventIds",
    "label": "Organization State Event Id",
    "collectionLabel": "Organization State Event Ids",
    "properties": [
      { name: "organizationId", label: "Organization Id", type: "string" }, { name: "version", label: "Version", type: "long" }
    ]
  },
  {
    "name": "OrganizationStructureTypeStateEventId",
    "plural": "OrganizationStructureTypeStateEventIds",
    "label": "Organization Structure Type State Event Id",
    "collectionLabel": "Organization Structure Type State Event Ids",
    "properties": [
      { name: "id", label: "Id", type: "string" }, { name: "version", label: "Version", type: "long" }
    ]
  },
  {
    "name": "OrganizationStructureStateEventId",
    "plural": "OrganizationStructureStateEventIds",
    "label": "Organization Structure State Event Id",
    "collectionLabel": "Organization Structure State Event Ids",
    "properties": [
      { name: "id", label: "Id", type: "OrganizationStructureId" }, { name: "version", label: "Version", type: "long" }
    ]
  },
  {
    "name": "WarehouseStateEventId",
    "plural": "WarehouseStateEventIds",
    "label": "Warehouse State Event Id",
    "collectionLabel": "Warehouse State Event Ids",
    "properties": [
      { name: "warehouseId", label: "Warehouse Id", type: "string" }, { name: "version", label: "Version", type: "long" }
    ]
  },
  {
    "name": "LocatorStateEventId",
    "plural": "LocatorStateEventIds",
    "label": "Locator State Event Id",
    "collectionLabel": "Locator State Event Ids",
    "properties": [
      { name: "locatorId", label: "Locator Id", type: "string" }, { name: "version", label: "Version", type: "long" }
    ]
  },
  {
    "name": "AttributeSetInstanceExtensionFieldMvoStateEventId",
    "plural": "AttributeSetInstanceExtensionFieldMvoStateEventIds",
    "label": "Attribute Set Instance Extension Field Mvo State Event Id",
    "collectionLabel": "Attribute Set Instance Extension Field Mvo State Event Ids",
    "properties": [
      { name: "attributeSetInstanceExtensionFieldId", label: "Attribute Set Instance Extension Field Id", type: "AttributeSetInstanceExtensionFieldId" }, { name: "attrSetInstEFGroupVersion", label: "Attr Set Inst EF Group Version", type: "long" }
    ]
  },
  {
    "name": "AttributeValueMvoStateEventId",
    "plural": "AttributeValueMvoStateEventIds",
    "label": "Attribute Value Mvo State Event Id",
    "collectionLabel": "Attribute Value Mvo State Event Ids",
    "properties": [
      { name: "attributeValueId", label: "Attribute Value Id", type: "AttributeValueId" }, { name: "attributeVersion", label: "Attribute Version", type: "long" }
    ]
  },
  {
    "name": "AttributeUseMvoStateEventId",
    "plural": "AttributeUseMvoStateEventIds",
    "label": "Attribute Use Mvo State Event Id",
    "collectionLabel": "Attribute Use Mvo State Event Ids",
    "properties": [
      { name: "attributeSetAttributeUseId", label: "Attribute Set Attribute Use Id", type: "AttributeSetAttributeUseId" }, { name: "attributeSetVersion", label: "Attribute Set Version", type: "long" }
    ]
  },
  {
    "name": "UserRoleMvoStateEventId",
    "plural": "UserRoleMvoStateEventIds",
    "label": "User Role Mvo State Event Id",
    "collectionLabel": "User Role Mvo State Event Ids",
    "properties": [
      { name: "userRoleId", label: "User Role Id", type: "UserRoleId" }, { name: "userVersion", label: "User Version", type: "long" }
    ]
  },
  {
    "name": "UserClaimMvoStateEventId",
    "plural": "UserClaimMvoStateEventIds",
    "label": "User Claim Mvo State Event Id",
    "collectionLabel": "User Claim Mvo State Event Ids",
    "properties": [
      { name: "userClaimId", label: "User Claim Id", type: "UserClaimId" }, { name: "userVersion", label: "User Version", type: "long" }
    ]
  },
  {
    "name": "UserPermissionMvoStateEventId",
    "plural": "UserPermissionMvoStateEventIds",
    "label": "User Permission Mvo State Event Id",
    "collectionLabel": "User Permission Mvo State Event Ids",
    "properties": [
      { name: "userPermissionId", label: "User Permission Id", type: "UserPermissionId" }, { name: "userVersion", label: "User Version", type: "long" }
    ]
  },
  {
    "name": "UserLoginMvoStateEventId",
    "plural": "UserLoginMvoStateEventIds",
    "label": "User Login Mvo State Event Id",
    "collectionLabel": "User Login Mvo State Event Ids",
    "properties": [
      { name: "userLoginId", label: "User Login Id", type: "UserLoginId" }, { name: "userVersion", label: "User Version", type: "long" }
    ]
  },
  {
    "name": "InOutLineMvoStateEventId",
    "plural": "InOutLineMvoStateEventIds",
    "label": "In Out Line Mvo State Event Id",
    "collectionLabel": "In Out Line Mvo State Event Ids",
    "properties": [
      { name: "inOutLineId", label: "In Out Line Id", type: "InOutLineId" }, { name: "inOutVersion", label: "In Out Version", type: "long" }
    ]
  }
]

