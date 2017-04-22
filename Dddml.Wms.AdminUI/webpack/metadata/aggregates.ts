export const AGGREGATES_METADATA = [
  {
    "name": "Attribute",
    "plural": "Attributes",
    "label": "Attribute",
    "collectionLabel": "Attributes",
    "id": {
  "name": "attributeId",
  "label": "Attribute Id",
  "type": "string"
},
    "properties": [ {
  "name": "name",
  "label": "Name",
  "type": "string"
}, {
  "name": "organizationId",
  "label": "Organization Id",
  "type": "string"
}, {
  "name": "description",
  "label": "Description",
  "type": "string"
}, {
  "name": "isMandatory",
  "label": "Is Mandatory",
  "type": "bool"
}, {
  "name": "isInstanceAttribute",
  "label": "Is Instance Attribute",
  "type": "bool"
}, {
  "name": "attributeValueType",
  "label": "Attribute Value Type",
  "type": "string"
}, {
  "name": "attributeValueLength",
  "label": "Attribute Value Length",
  "type": "int?"
}, {
  "name": "isList",
  "label": "Is List",
  "type": "bool"
}, {
  "name": "fieldName",
  "label": "Field Name",
  "type": "string"
}, {
  "name": "referenceId",
  "label": "Reference Id",
  "type": "string"
}, {
  "name": "version",
  "label": "Version",
  "type": "long"
}, {
  "name": "createdBy",
  "label": "Created By",
  "type": "string"
}, {
  "name": "createdAt",
  "label": "Created At",
  "type": "DateTime"
}, {
  "name": "updatedBy",
  "label": "Updated By",
  "type": "string"
}, {
  "name": "updatedAt",
  "label": "Updated At",
  "type": "DateTime"
}, {
  "name": "active",
  "label": "Active",
  "type": "bool"
}, {
  "name": "deleted",
  "label": "Deleted",
  "type": "bool"
}, {
  "name": "attributeValues",
  "label": "Attribute Values",
  "itemType": "AttributeValue"
} ]


, filteringProperties: [
  {
    "name": "AttributeId",
    "typeName": "string",
    "targetPropertyName": "attributeId"
  },
  {
    "name": "Name",
    "typeName": "string",
    "targetPropertyName": "name"
  },
  {
    "name": "OrganizationId",
    "typeName": "string",
    "targetPropertyName": "organizationId"
  },
  {
    "name": "Description",
    "typeName": "string",
    "targetPropertyName": "description"
  },
  {
    "name": "IsMandatory",
    "typeName": "bool",
    "targetPropertyName": "isMandatory"
  },
  {
    "name": "IsInstanceAttribute",
    "typeName": "bool",
    "targetPropertyName": "isInstanceAttribute"
  },
  {
    "name": "AttributeValueType",
    "typeName": "string",
    "targetPropertyName": "attributeValueType"
  },
  {
    "name": "AttributeValueLength",
    "typeName": "int",
    "targetPropertyName": "attributeValueLength"
  },
  {
    "name": "IsList",
    "typeName": "bool",
    "targetPropertyName": "isList"
  },
  {
    "name": "FieldName",
    "typeName": "string",
    "targetPropertyName": "fieldName"
  },
  {
    "name": "ReferenceId",
    "typeName": "string",
    "targetPropertyName": "referenceId"
  },
  {
    "name": "Version",
    "typeName": "long",
    "targetPropertyName": "version"
  },
  {
    "name": "CreatedBy",
    "typeName": "string",
    "targetPropertyName": "createdBy"
  },
  {
    "name": "CreatedAt",
    "typeName": "DateTime",
    "targetPropertyName": "createdAt"
  },
  {
    "name": "UpdatedBy",
    "typeName": "string",
    "targetPropertyName": "updatedBy"
  },
  {
    "name": "UpdatedAt",
    "typeName": "DateTime",
    "targetPropertyName": "updatedAt"
  },
  {
    "name": "Active",
    "typeName": "bool",
    "targetPropertyName": "active"
  },
  {
    "name": "Deleted",
    "typeName": "bool",
    "targetPropertyName": "deleted"
  }
]


    ,"entities": [
      {
        "name": "AttributeValue",
        "plural": "AttributeValues",
        "label": "Attribute Value",
        "collectionLabel": "Attribute Values",
        "id": {
  "name": "value",
  "label": "Value",
  "type": "string"
},
        "properties": [ {
  "name": "name",
  "label": "Name",
  "type": "string"
}, {
  "name": "description",
  "label": "Description",
  "type": "string"
}, {
  "name": "referenceId",
  "label": "Reference Id",
  "type": "string"
}, {
  "name": "version",
  "label": "Version",
  "type": "long"
}, {
  "name": "createdBy",
  "label": "Created By",
  "type": "string"
}, {
  "name": "createdAt",
  "label": "Created At",
  "type": "DateTime"
}, {
  "name": "updatedBy",
  "label": "Updated By",
  "type": "string"
}, {
  "name": "updatedAt",
  "label": "Updated At",
  "type": "DateTime"
}, {
  "name": "active",
  "label": "Active",
  "type": "bool"
}, {
  "name": "deleted",
  "label": "Deleted",
  "type": "bool"
} ]



      }
    ]
  },
  {
    "name": "AttributeSet",
    "plural": "AttributeSets",
    "label": "Attribute Set",
    "collectionLabel": "Attribute Sets",
    "id": {
  "name": "attributeSetId",
  "label": "Attribute Set Id",
  "type": "string"
},
    "properties": [ {
  "name": "name",
  "label": "Name",
  "type": "string"
}, {
  "name": "organizationId",
  "label": "Organization Id",
  "type": "string"
}, {
  "name": "description",
  "label": "Description",
  "type": "string"
}, {
  "name": "serialNumberAttributeId",
  "label": "Serial Number Attribute Id",
  "type": "string"
}, {
  "name": "lotAttributeId",
  "label": "Lot Attribute Id",
  "type": "string"
}, {
  "name": "referenceId",
  "label": "Reference Id",
  "type": "string"
}, {
  "name": "version",
  "label": "Version",
  "type": "long"
}, {
  "name": "createdBy",
  "label": "Created By",
  "type": "string"
}, {
  "name": "createdAt",
  "label": "Created At",
  "type": "DateTime"
}, {
  "name": "updatedBy",
  "label": "Updated By",
  "type": "string"
}, {
  "name": "updatedAt",
  "label": "Updated At",
  "type": "DateTime"
}, {
  "name": "active",
  "label": "Active",
  "type": "bool"
}, {
  "name": "deleted",
  "label": "Deleted",
  "type": "bool"
}, {
  "name": "attributeUses",
  "label": "Attribute Uses",
  "itemType": "AttributeUse"
} ]


, filteringProperties: [
  {
    "name": "AttributeSetId",
    "typeName": "string",
    "targetPropertyName": "attributeSetId"
  },
  {
    "name": "Name",
    "typeName": "string",
    "targetPropertyName": "name"
  },
  {
    "name": "OrganizationId",
    "typeName": "string",
    "targetPropertyName": "organizationId"
  },
  {
    "name": "Description",
    "typeName": "string",
    "targetPropertyName": "description"
  },
  {
    "name": "SerialNumberAttributeId",
    "typeName": "string",
    "targetPropertyName": "serialNumberAttributeId"
  },
  {
    "name": "LotAttributeId",
    "typeName": "string",
    "targetPropertyName": "lotAttributeId"
  },
  {
    "name": "ReferenceId",
    "typeName": "string",
    "targetPropertyName": "referenceId"
  },
  {
    "name": "Version",
    "typeName": "long",
    "targetPropertyName": "version"
  },
  {
    "name": "CreatedBy",
    "typeName": "string",
    "targetPropertyName": "createdBy"
  },
  {
    "name": "CreatedAt",
    "typeName": "DateTime",
    "targetPropertyName": "createdAt"
  },
  {
    "name": "UpdatedBy",
    "typeName": "string",
    "targetPropertyName": "updatedBy"
  },
  {
    "name": "UpdatedAt",
    "typeName": "DateTime",
    "targetPropertyName": "updatedAt"
  },
  {
    "name": "Active",
    "typeName": "bool",
    "targetPropertyName": "active"
  },
  {
    "name": "Deleted",
    "typeName": "bool",
    "targetPropertyName": "deleted"
  }
]


    ,"entities": [
      {
        "name": "AttributeUse",
        "plural": "AttributeUses",
        "label": "Attribute Use",
        "collectionLabel": "Attribute Uses",
        "id": {
  "name": "attributeId",
  "label": "Attribute Id",
  "type": "string"
},
        "properties": [ {
  "name": "sequenceNumber",
  "label": "Sequence Number",
  "type": "int"
}, {
  "name": "version",
  "label": "Version",
  "type": "long"
}, {
  "name": "createdBy",
  "label": "Created By",
  "type": "string"
}, {
  "name": "createdAt",
  "label": "Created At",
  "type": "DateTime"
}, {
  "name": "updatedBy",
  "label": "Updated By",
  "type": "string"
}, {
  "name": "updatedAt",
  "label": "Updated At",
  "type": "DateTime"
}, {
  "name": "active",
  "label": "Active",
  "type": "bool"
}, {
  "name": "deleted",
  "label": "Deleted",
  "type": "bool"
} ]



      }
    ]
  },
  {
    "name": "InOut",
    "plural": "InOuts",
    "label": "In Out",
    "collectionLabel": "In Outs",
    "id": {
  "name": "documentNumber",
  "label": "Document Number",
  "type": "string"
},
    "properties": [ {
  "name": "isSOTransaction",
  "label": "Is SO Transaction",
  "type": "bool"
}, {
  "name": "documentStatus",
  "label": "Document Status",
  "type": "string"
}, {
  "name": "posted",
  "label": "Posted",
  "type": "bool"
}, {
  "name": "processing",
  "label": "Processing",
  "type": "bool"
}, {
  "name": "processed",
  "label": "Processed",
  "type": "bool"
}, {
  "name": "documentType",
  "label": "Document Type",
  "type": "int"
}, {
  "name": "description",
  "label": "Description",
  "type": "string"
}, {
  "name": "orderNumber",
  "label": "Order Number",
  "type": "string"
}, {
  "name": "dateOrdered",
  "label": "Date Ordered",
  "type": "DateTime?"
}, {
  "name": "isPrinted",
  "label": "Is Printed",
  "type": "bool"
}, {
  "name": "movementType",
  "label": "Movement Type",
  "type": "string"
}, {
  "name": "movementDate",
  "label": "Movement Date",
  "type": "DateTime?"
}, {
  "name": "businessPartnerId",
  "label": "Business Partner Id",
  "type": "string"
}, {
  "name": "warehouseId",
  "label": "Warehouse Id",
  "type": "string"
}, {
  "name": "poReference",
  "label": "PO Reference",
  "type": "string"
}, {
  "name": "freightAmount",
  "label": "Freight Amount",
  "type": "Money"
}, {
  "name": "shipperId",
  "label": "Shipper Id",
  "type": "string"
}, {
  "name": "chargeAmount",
  "label": "Charge Amount",
  "type": "Money"
}, {
  "name": "datePrinted",
  "label": "Date Printed",
  "type": "DateTime?"
}, {
  "name": "salesRepresentative",
  "label": "Sales Representative",
  "type": "string"
}, {
  "name": "numberOfPackages",
  "label": "Number Of Packages",
  "type": "int"
}, {
  "name": "pickDate",
  "label": "Pick Date",
  "type": "DateTime?"
}, {
  "name": "shipDate",
  "label": "Ship Date",
  "type": "DateTime?"
}, {
  "name": "trackingNumber",
  "label": "Tracking Number",
  "type": "string"
}, {
  "name": "dateReceived",
  "label": "Date Received",
  "type": "DateTime?"
}, {
  "name": "isInTransit",
  "label": "Is In Transit",
  "type": "bool"
}, {
  "name": "isApproved",
  "label": "Is Approved",
  "type": "bool"
}, {
  "name": "isInDispute",
  "label": "Is In Dispute",
  "type": "bool"
}, {
  "name": "volume",
  "label": "Volume",
  "type": "decimal"
}, {
  "name": "weight",
  "label": "Weight",
  "type": "decimal"
}, {
  "name": "rmaNumber",
  "label": "Rma Number",
  "type": "string"
}, {
  "name": "reversalNumber",
  "label": "Reversal Number",
  "type": "string"
}, {
  "name": "isDropShip",
  "label": "Is Drop Ship",
  "type": "bool"
}, {
  "name": "dropShipBusinessPartnerId",
  "label": "Drop Ship Business Partner Id",
  "type": "string"
}, {
  "name": "version",
  "label": "Version",
  "type": "long"
}, {
  "name": "createdBy",
  "label": "Created By",
  "type": "string"
}, {
  "name": "createdAt",
  "label": "Created At",
  "type": "DateTime"
}, {
  "name": "updatedBy",
  "label": "Updated By",
  "type": "string"
}, {
  "name": "updatedAt",
  "label": "Updated At",
  "type": "DateTime"
}, {
  "name": "active",
  "label": "Active",
  "type": "bool"
}, {
  "name": "deleted",
  "label": "Deleted",
  "type": "bool"
}, {
  "name": "inOutLines",
  "label": "In Out Lines",
  "itemType": "InOutLine"
} ]


, filteringProperties: [
  {
    "name": "DocumentNumber",
    "typeName": "string",
    "targetPropertyName": "documentNumber"
  },
  {
    "name": "IsSOTransaction",
    "typeName": "bool",
    "targetPropertyName": "isSOTransaction"
  },
  {
    "name": "DocumentStatus",
    "typeName": "string",
    "targetPropertyName": "documentStatus"
  },
  {
    "name": "Posted",
    "typeName": "bool",
    "targetPropertyName": "posted"
  },
  {
    "name": "Processing",
    "typeName": "bool",
    "targetPropertyName": "processing"
  },
  {
    "name": "Processed",
    "typeName": "bool",
    "targetPropertyName": "processed"
  },
  {
    "name": "DocumentType",
    "typeName": "int",
    "targetPropertyName": "documentType"
  },
  {
    "name": "Description",
    "typeName": "string",
    "targetPropertyName": "description"
  },
  {
    "name": "OrderNumber",
    "typeName": "string",
    "targetPropertyName": "orderNumber"
  },
  {
    "name": "DateOrdered",
    "typeName": "DateTime",
    "targetPropertyName": "dateOrdered"
  },
  {
    "name": "IsPrinted",
    "typeName": "bool",
    "targetPropertyName": "isPrinted"
  },
  {
    "name": "MovementType",
    "typeName": "string",
    "targetPropertyName": "movementType"
  },
  {
    "name": "MovementDate",
    "typeName": "DateTime",
    "targetPropertyName": "movementDate"
  },
  {
    "name": "BusinessPartnerId",
    "typeName": "string",
    "targetPropertyName": "businessPartnerId"
  },
  {
    "name": "WarehouseId",
    "typeName": "string",
    "targetPropertyName": "warehouseId"
  },
  {
    "name": "POReference",
    "typeName": "string",
    "targetPropertyName": "poReference"
  },
  {
    "name": "FreightAmount",
    "typeName": "Money",
    "targetPropertyName": "freightAmount"
  },
  {
    "name": "ShipperId",
    "typeName": "string",
    "targetPropertyName": "shipperId"
  },
  {
    "name": "ChargeAmount",
    "typeName": "Money",
    "targetPropertyName": "chargeAmount"
  },
  {
    "name": "DatePrinted",
    "typeName": "DateTime",
    "targetPropertyName": "datePrinted"
  },
  {
    "name": "SalesRepresentative",
    "typeName": "string",
    "targetPropertyName": "salesRepresentative"
  },
  {
    "name": "NumberOfPackages",
    "typeName": "int",
    "targetPropertyName": "numberOfPackages"
  },
  {
    "name": "PickDate",
    "typeName": "DateTime",
    "targetPropertyName": "pickDate"
  },
  {
    "name": "ShipDate",
    "typeName": "DateTime",
    "targetPropertyName": "shipDate"
  },
  {
    "name": "TrackingNumber",
    "typeName": "string",
    "targetPropertyName": "trackingNumber"
  },
  {
    "name": "DateReceived",
    "typeName": "DateTime",
    "targetPropertyName": "dateReceived"
  },
  {
    "name": "IsInTransit",
    "typeName": "bool",
    "targetPropertyName": "isInTransit"
  },
  {
    "name": "IsApproved",
    "typeName": "bool",
    "targetPropertyName": "isApproved"
  },
  {
    "name": "IsInDispute",
    "typeName": "bool",
    "targetPropertyName": "isInDispute"
  },
  {
    "name": "Volume",
    "typeName": "decimal",
    "targetPropertyName": "volume"
  },
  {
    "name": "Weight",
    "typeName": "decimal",
    "targetPropertyName": "weight"
  },
  {
    "name": "RmaNumber",
    "typeName": "string",
    "targetPropertyName": "rmaNumber"
  },
  {
    "name": "ReversalNumber",
    "typeName": "string",
    "targetPropertyName": "reversalNumber"
  },
  {
    "name": "IsDropShip",
    "typeName": "bool",
    "targetPropertyName": "isDropShip"
  },
  {
    "name": "DropShipBusinessPartnerId",
    "typeName": "string",
    "targetPropertyName": "dropShipBusinessPartnerId"
  },
  {
    "name": "Version",
    "typeName": "long",
    "targetPropertyName": "version"
  },
  {
    "name": "CreatedBy",
    "typeName": "string",
    "targetPropertyName": "createdBy"
  },
  {
    "name": "CreatedAt",
    "typeName": "DateTime",
    "targetPropertyName": "createdAt"
  },
  {
    "name": "UpdatedBy",
    "typeName": "string",
    "targetPropertyName": "updatedBy"
  },
  {
    "name": "UpdatedAt",
    "typeName": "DateTime",
    "targetPropertyName": "updatedAt"
  },
  {
    "name": "Active",
    "typeName": "bool",
    "targetPropertyName": "active"
  },
  {
    "name": "Deleted",
    "typeName": "bool",
    "targetPropertyName": "deleted"
  },
  {
    "name": "FreightAmount.Amount",
    "typeName": "decimal",
    "targetPropertyName": "amount"
  },
  {
    "name": "FreightAmount.Currency",
    "typeName": "string",
    "targetPropertyName": "currency"
  },
  {
    "name": "ChargeAmount.Amount",
    "typeName": "decimal",
    "targetPropertyName": "amount"
  },
  {
    "name": "ChargeAmount.Currency",
    "typeName": "string",
    "targetPropertyName": "currency"
  }
]


    ,"entities": [
      {
        "name": "InOutLine",
        "plural": "InOutLines",
        "label": "In Out Line",
        "collectionLabel": "In Out Lines",
        "id": {
  "name": "lineNumber",
  "label": "Line Number",
  "type": "long"
},
        "properties": [ {
  "name": "description",
  "label": "Description",
  "type": "string"
}, {
  "name": "locatorId",
  "label": "Locator Id",
  "type": "string"
}, {
  "name": "productId",
  "label": "Product Id",
  "type": "string"
}, {
  "name": "uomId",
  "label": "Uom Id",
  "type": "string"
}, {
  "name": "movementQuantity",
  "label": "Movement Quantity",
  "type": "decimal"
}, {
  "name": "confirmedQuantity",
  "label": "Confirmed Quantity",
  "type": "decimal"
}, {
  "name": "scrappedQuantity",
  "label": "Scrapped Quantity",
  "type": "decimal"
}, {
  "name": "targetQuantity",
  "label": "Target Quantity",
  "type": "decimal"
}, {
  "name": "pickedQuantity",
  "label": "Picked Quantity",
  "type": "decimal"
}, {
  "name": "isInvoiced",
  "label": "Is Invoiced",
  "type": "bool"
}, {
  "name": "attributeSetInstanceId",
  "label": "Attribute Set Instance Id",
  "type": "string"
}, {
  "name": "isDescription",
  "label": "Is Description",
  "type": "bool"
}, {
  "name": "processed",
  "label": "Processed",
  "type": "bool"
}, {
  "name": "quantityEntered",
  "label": "Quantity Entered",
  "type": "decimal"
}, {
  "name": "rmaLineNumber",
  "label": "Rma Line Number",
  "type": "long"
}, {
  "name": "reversalLineNumber",
  "label": "Reversal Line Number",
  "type": "long"
}, {
  "name": "version",
  "label": "Version",
  "type": "long"
}, {
  "name": "createdBy",
  "label": "Created By",
  "type": "string"
}, {
  "name": "createdAt",
  "label": "Created At",
  "type": "DateTime"
}, {
  "name": "updatedBy",
  "label": "Updated By",
  "type": "string"
}, {
  "name": "updatedAt",
  "label": "Updated At",
  "type": "DateTime"
}, {
  "name": "active",
  "label": "Active",
  "type": "bool"
}, {
  "name": "deleted",
  "label": "Deleted",
  "type": "bool"
} ]



      }
    ]
  },
  {
    "name": "Organization",
    "plural": "Organizations",
    "label": "Organization",
    "collectionLabel": "Organizations",
    "id": {
  "name": "organizationId",
  "label": "Organization Id",
  "type": "string"
},
    "properties": [ {
  "name": "name",
  "label": "Name",
  "type": "string"
}, {
  "name": "description",
  "label": "Description",
  "type": "string"
}, {
  "name": "type",
  "label": "Type",
  "type": "string"
}, {
  "name": "isSummary",
  "label": "Is Summary",
  "type": "bool"
}, {
  "name": "version",
  "label": "Version",
  "type": "long"
}, {
  "name": "createdBy",
  "label": "Created By",
  "type": "string"
}, {
  "name": "createdAt",
  "label": "Created At",
  "type": "DateTime"
}, {
  "name": "updatedBy",
  "label": "Updated By",
  "type": "string"
}, {
  "name": "updatedAt",
  "label": "Updated At",
  "type": "DateTime"
}, {
  "name": "active",
  "label": "Active",
  "type": "bool"
}, {
  "name": "deleted",
  "label": "Deleted",
  "type": "bool"
} ]


, filteringProperties: [
  {
    "name": "OrganizationId",
    "typeName": "string",
    "targetPropertyName": "organizationId"
  },
  {
    "name": "Name",
    "typeName": "string",
    "targetPropertyName": "name"
  },
  {
    "name": "Description",
    "typeName": "string",
    "targetPropertyName": "description"
  },
  {
    "name": "Type",
    "typeName": "string",
    "targetPropertyName": "type"
  },
  {
    "name": "IsSummary",
    "typeName": "bool",
    "targetPropertyName": "isSummary"
  },
  {
    "name": "Version",
    "typeName": "long",
    "targetPropertyName": "version"
  },
  {
    "name": "CreatedBy",
    "typeName": "string",
    "targetPropertyName": "createdBy"
  },
  {
    "name": "CreatedAt",
    "typeName": "DateTime",
    "targetPropertyName": "createdAt"
  },
  {
    "name": "UpdatedBy",
    "typeName": "string",
    "targetPropertyName": "updatedBy"
  },
  {
    "name": "UpdatedAt",
    "typeName": "DateTime",
    "targetPropertyName": "updatedAt"
  },
  {
    "name": "Active",
    "typeName": "bool",
    "targetPropertyName": "active"
  },
  {
    "name": "Deleted",
    "typeName": "bool",
    "targetPropertyName": "deleted"
  }
]


  },
  {
    "name": "OrganizationStructureType",
    "plural": "OrganizationStructureTypes",
    "label": "Organization Structure Type",
    "collectionLabel": "Organization Structure Types",
    "id": {
  "name": "id",
  "label": "Id",
  "type": "string"
},
    "properties": [ {
  "name": "version",
  "label": "Version",
  "type": "long"
}, {
  "name": "createdBy",
  "label": "Created By",
  "type": "string"
}, {
  "name": "createdAt",
  "label": "Created At",
  "type": "DateTime"
}, {
  "name": "updatedBy",
  "label": "Updated By",
  "type": "string"
}, {
  "name": "updatedAt",
  "label": "Updated At",
  "type": "DateTime"
}, {
  "name": "active",
  "label": "Active",
  "type": "bool"
}, {
  "name": "deleted",
  "label": "Deleted",
  "type": "bool"
} ]


, filteringProperties: [
  {
    "name": "Id",
    "typeName": "string",
    "targetPropertyName": "id"
  },
  {
    "name": "Version",
    "typeName": "long",
    "targetPropertyName": "version"
  },
  {
    "name": "CreatedBy",
    "typeName": "string",
    "targetPropertyName": "createdBy"
  },
  {
    "name": "CreatedAt",
    "typeName": "DateTime",
    "targetPropertyName": "createdAt"
  },
  {
    "name": "UpdatedBy",
    "typeName": "string",
    "targetPropertyName": "updatedBy"
  },
  {
    "name": "UpdatedAt",
    "typeName": "DateTime",
    "targetPropertyName": "updatedAt"
  },
  {
    "name": "Active",
    "typeName": "bool",
    "targetPropertyName": "active"
  },
  {
    "name": "Deleted",
    "typeName": "bool",
    "targetPropertyName": "deleted"
  }
]


  },
  {
    "name": "OrganizationStructure",
    "plural": "OrganizationStructures",
    "label": "Organization Structure",
    "collectionLabel": "Organization Structures",
    "id": {
  "name": "id",
  "label": "Id",
  "type": "OrganizationStructureId"
},
    "properties": [ {
  "name": "version",
  "label": "Version",
  "type": "long"
}, {
  "name": "createdBy",
  "label": "Created By",
  "type": "string"
}, {
  "name": "createdAt",
  "label": "Created At",
  "type": "DateTime"
}, {
  "name": "updatedBy",
  "label": "Updated By",
  "type": "string"
}, {
  "name": "updatedAt",
  "label": "Updated At",
  "type": "DateTime"
}, {
  "name": "active",
  "label": "Active",
  "type": "bool"
}, {
  "name": "deleted",
  "label": "Deleted",
  "type": "bool"
} ]


, filteringProperties: [
  {
    "name": "Version",
    "typeName": "long",
    "targetPropertyName": "version"
  },
  {
    "name": "CreatedBy",
    "typeName": "string",
    "targetPropertyName": "createdBy"
  },
  {
    "name": "CreatedAt",
    "typeName": "DateTime",
    "targetPropertyName": "createdAt"
  },
  {
    "name": "UpdatedBy",
    "typeName": "string",
    "targetPropertyName": "updatedBy"
  },
  {
    "name": "UpdatedAt",
    "typeName": "DateTime",
    "targetPropertyName": "updatedAt"
  },
  {
    "name": "Active",
    "typeName": "bool",
    "targetPropertyName": "active"
  },
  {
    "name": "Deleted",
    "typeName": "bool",
    "targetPropertyName": "deleted"
  },
  {
    "name": "Id.OrganizationStructureTypeId",
    "typeName": "string",
    "targetPropertyName": "id.organizationStructureTypeId"
  },
  {
    "name": "Id.ParentId",
    "typeName": "string",
    "targetPropertyName": "id.parentId"
  },
  {
    "name": "Id.SubsidiaryId",
    "typeName": "string",
    "targetPropertyName": "id.subsidiaryId"
  }
]


  },
  {
    "name": "Warehouse",
    "plural": "Warehouses",
    "label": "Warehouse",
    "collectionLabel": "Warehouses",
    "id": {
  "name": "warehouseId",
  "label": "Warehouse Id",
  "type": "string"
},
    "properties": [ {
  "name": "name",
  "label": "Name",
  "type": "string"
}, {
  "name": "description",
  "label": "Description",
  "type": "string"
}, {
  "name": "isInTransit",
  "label": "Is In Transit",
  "type": "bool"
}, {
  "name": "version",
  "label": "Version",
  "type": "long"
}, {
  "name": "createdBy",
  "label": "Created By",
  "type": "string"
}, {
  "name": "createdAt",
  "label": "Created At",
  "type": "DateTime"
}, {
  "name": "updatedBy",
  "label": "Updated By",
  "type": "string"
}, {
  "name": "updatedAt",
  "label": "Updated At",
  "type": "DateTime"
}, {
  "name": "active",
  "label": "Active",
  "type": "bool"
}, {
  "name": "deleted",
  "label": "Deleted",
  "type": "bool"
} ]


, filteringProperties: [
  {
    "name": "WarehouseId",
    "typeName": "string",
    "targetPropertyName": "warehouseId"
  },
  {
    "name": "Name",
    "typeName": "string",
    "targetPropertyName": "name"
  },
  {
    "name": "Description",
    "typeName": "string",
    "targetPropertyName": "description"
  },
  {
    "name": "IsInTransit",
    "typeName": "bool",
    "targetPropertyName": "isInTransit"
  },
  {
    "name": "Version",
    "typeName": "long",
    "targetPropertyName": "version"
  },
  {
    "name": "CreatedBy",
    "typeName": "string",
    "targetPropertyName": "createdBy"
  },
  {
    "name": "CreatedAt",
    "typeName": "DateTime",
    "targetPropertyName": "createdAt"
  },
  {
    "name": "UpdatedBy",
    "typeName": "string",
    "targetPropertyName": "updatedBy"
  },
  {
    "name": "UpdatedAt",
    "typeName": "DateTime",
    "targetPropertyName": "updatedAt"
  },
  {
    "name": "Active",
    "typeName": "bool",
    "targetPropertyName": "active"
  },
  {
    "name": "Deleted",
    "typeName": "bool",
    "targetPropertyName": "deleted"
  }
]


  },
  {
    "name": "Locator",
    "plural": "Locators",
    "label": "Locator",
    "collectionLabel": "Locators",
    "id": {
  "name": "locatorId",
  "label": "Locator Id",
  "type": "string"
},
    "properties": [ {
  "name": "warehouseId",
  "label": "Warehouse Id",
  "type": "string"
}, {
  "name": "parentLocatorId",
  "label": "Parent Locator Id",
  "type": "string"
}, {
  "name": "locatorType",
  "label": "Locator Type",
  "type": "string"
}, {
  "name": "priorityNumber",
  "label": "Priority Number",
  "type": "string"
}, {
  "name": "isDefault",
  "label": "Is Default",
  "type": "bool"
}, {
  "name": "x",
  "label": "X",
  "type": "string"
}, {
  "name": "y",
  "label": "Y",
  "type": "string"
}, {
  "name": "z",
  "label": "Z",
  "type": "string"
}, {
  "name": "version",
  "label": "Version",
  "type": "long"
}, {
  "name": "createdBy",
  "label": "Created By",
  "type": "string"
}, {
  "name": "createdAt",
  "label": "Created At",
  "type": "DateTime"
}, {
  "name": "updatedBy",
  "label": "Updated By",
  "type": "string"
}, {
  "name": "updatedAt",
  "label": "Updated At",
  "type": "DateTime"
}, {
  "name": "active",
  "label": "Active",
  "type": "bool"
}, {
  "name": "deleted",
  "label": "Deleted",
  "type": "bool"
} ]


, filteringProperties: [
  {
    "name": "LocatorId",
    "typeName": "string",
    "targetPropertyName": "locatorId"
  },
  {
    "name": "WarehouseId",
    "typeName": "string",
    "targetPropertyName": "warehouseId"
  },
  {
    "name": "ParentLocatorId",
    "typeName": "string",
    "targetPropertyName": "parentLocatorId"
  },
  {
    "name": "LocatorType",
    "typeName": "string",
    "targetPropertyName": "locatorType"
  },
  {
    "name": "PriorityNumber",
    "typeName": "string",
    "targetPropertyName": "priorityNumber"
  },
  {
    "name": "IsDefault",
    "typeName": "bool",
    "targetPropertyName": "isDefault"
  },
  {
    "name": "X",
    "typeName": "string",
    "targetPropertyName": "x"
  },
  {
    "name": "Y",
    "typeName": "string",
    "targetPropertyName": "y"
  },
  {
    "name": "Z",
    "typeName": "string",
    "targetPropertyName": "z"
  },
  {
    "name": "Version",
    "typeName": "long",
    "targetPropertyName": "version"
  },
  {
    "name": "CreatedBy",
    "typeName": "string",
    "targetPropertyName": "createdBy"
  },
  {
    "name": "CreatedAt",
    "typeName": "DateTime",
    "targetPropertyName": "createdAt"
  },
  {
    "name": "UpdatedBy",
    "typeName": "string",
    "targetPropertyName": "updatedBy"
  },
  {
    "name": "UpdatedAt",
    "typeName": "DateTime",
    "targetPropertyName": "updatedAt"
  },
  {
    "name": "Active",
    "typeName": "bool",
    "targetPropertyName": "active"
  },
  {
    "name": "Deleted",
    "typeName": "bool",
    "targetPropertyName": "deleted"
  }
]


  },
  {
    "name": "AttributeSetInstance",
    "plural": "AttributeSetInstances",
    "label": "Attribute Set Instance",
    "collectionLabel": "Attribute Set Instances",
    "id": {
  "name": "attributeSetInstanceId",
  "label": "Attribute Set Instance Id",
  "type": "string"
},
    "properties": [ {
  "name": "attributeSetId",
  "label": "Attribute Set Id",
  "type": "string"
}, {
  "name": "organizationId",
  "label": "Organization Id",
  "type": "string"
}, {
  "name": "referenceId",
  "label": "Reference Id",
  "type": "string"
}, {
  "name": "serialNumber",
  "label": "Serial Number",
  "type": "string"
}, {
  "name": "lot",
  "label": "Lot",
  "type": "string"
}, {
  "name": "description",
  "label": "Description",
  "type": "string"
}, {
  "name": "hash",
  "label": "Hash",
  "type": "string",
  "isDerived": true
}, {
  "name": "_F_B_0_",
  "label": "F B 0",
  "type": "bool?"
}, {
  "name": "_F_I_0_",
  "label": "F I 0",
  "type": "int?"
}, {
  "name": "_F_L_0_",
  "label": "F L 0",
  "type": "long?"
}, {
  "name": "_F_DT_0_",
  "label": "F DT 0",
  "type": "DateTime?"
}, {
  "name": "_F_N_0_",
  "label": "F N 0",
  "type": "decimal?"
}, {
  "name": "_F_C5_0_",
  "label": "F C5 0",
  "type": "string"
}, {
  "name": "_F_C10_0_",
  "label": "F C10 0",
  "type": "string"
}, {
  "name": "_F_C20_0_",
  "label": "F C20 0",
  "type": "string"
}, {
  "name": "_F_C50_0_",
  "label": "F C50 0",
  "type": "string"
}, {
  "name": "_F_C100_0_",
  "label": "F C100 0",
  "type": "string"
}, {
  "name": "_F_C200_0_",
  "label": "F C200 0",
  "type": "string"
}, {
  "name": "_F_C500_0_",
  "label": "F C500 0",
  "type": "string"
}, {
  "name": "_F_C1000_0_",
  "label": "F C1000 0",
  "type": "string"
}, {
  "name": "_F_B_1_",
  "label": "F B 1",
  "type": "bool?"
}, {
  "name": "_F_I_1_",
  "label": "F I 1",
  "type": "int?"
}, {
  "name": "_F_L_1_",
  "label": "F L 1",
  "type": "long?"
}, {
  "name": "_F_DT_1_",
  "label": "F DT 1",
  "type": "DateTime?"
}, {
  "name": "_F_N_1_",
  "label": "F N 1",
  "type": "decimal?"
}, {
  "name": "_F_C5_1_",
  "label": "F C5 1",
  "type": "string"
}, {
  "name": "_F_C10_1_",
  "label": "F C10 1",
  "type": "string"
}, {
  "name": "_F_C20_1_",
  "label": "F C20 1",
  "type": "string"
}, {
  "name": "_F_C50_1_",
  "label": "F C50 1",
  "type": "string"
}, {
  "name": "_F_C100_1_",
  "label": "F C100 1",
  "type": "string"
}, {
  "name": "_F_C200_1_",
  "label": "F C200 1",
  "type": "string"
}, {
  "name": "_F_C500_1_",
  "label": "F C500 1",
  "type": "string"
}, {
  "name": "_F_C1000_1_",
  "label": "F C1000 1",
  "type": "string"
}, {
  "name": "_F_B_2_",
  "label": "F B 2",
  "type": "bool?"
}, {
  "name": "_F_I_2_",
  "label": "F I 2",
  "type": "int?"
}, {
  "name": "_F_L_2_",
  "label": "F L 2",
  "type": "long?"
}, {
  "name": "_F_DT_2_",
  "label": "F DT 2",
  "type": "DateTime?"
}, {
  "name": "_F_N_2_",
  "label": "F N 2",
  "type": "decimal?"
}, {
  "name": "_F_C5_2_",
  "label": "F C5 2",
  "type": "string"
}, {
  "name": "_F_C10_2_",
  "label": "F C10 2",
  "type": "string"
}, {
  "name": "_F_C20_2_",
  "label": "F C20 2",
  "type": "string"
}, {
  "name": "_F_C50_2_",
  "label": "F C50 2",
  "type": "string"
}, {
  "name": "_F_C100_2_",
  "label": "F C100 2",
  "type": "string"
}, {
  "name": "_F_C200_2_",
  "label": "F C200 2",
  "type": "string"
}, {
  "name": "_F_C500_2_",
  "label": "F C500 2",
  "type": "string"
}, {
  "name": "_F_C1000_2_",
  "label": "F C1000 2",
  "type": "string"
}, {
  "name": "_F_B_3_",
  "label": "F B 3",
  "type": "bool?"
}, {
  "name": "_F_I_3_",
  "label": "F I 3",
  "type": "int?"
}, {
  "name": "_F_L_3_",
  "label": "F L 3",
  "type": "long?"
}, {
  "name": "_F_DT_3_",
  "label": "F DT 3",
  "type": "DateTime?"
}, {
  "name": "_F_N_3_",
  "label": "F N 3",
  "type": "decimal?"
}, {
  "name": "_F_C5_3_",
  "label": "F C5 3",
  "type": "string"
}, {
  "name": "_F_C10_3_",
  "label": "F C10 3",
  "type": "string"
}, {
  "name": "_F_C20_3_",
  "label": "F C20 3",
  "type": "string"
}, {
  "name": "_F_C50_3_",
  "label": "F C50 3",
  "type": "string"
}, {
  "name": "_F_C100_3_",
  "label": "F C100 3",
  "type": "string"
}, {
  "name": "_F_C200_3_",
  "label": "F C200 3",
  "type": "string"
}, {
  "name": "_F_C500_3_",
  "label": "F C500 3",
  "type": "string"
}, {
  "name": "_F_C1000_3_",
  "label": "F C1000 3",
  "type": "string"
}, {
  "name": "_F_B_4_",
  "label": "F B 4",
  "type": "bool?"
}, {
  "name": "_F_I_4_",
  "label": "F I 4",
  "type": "int?"
}, {
  "name": "_F_L_4_",
  "label": "F L 4",
  "type": "long?"
}, {
  "name": "_F_DT_4_",
  "label": "F DT 4",
  "type": "DateTime?"
}, {
  "name": "_F_N_4_",
  "label": "F N 4",
  "type": "decimal?"
}, {
  "name": "_F_C5_4_",
  "label": "F C5 4",
  "type": "string"
}, {
  "name": "_F_C10_4_",
  "label": "F C10 4",
  "type": "string"
}, {
  "name": "_F_C20_4_",
  "label": "F C20 4",
  "type": "string"
}, {
  "name": "_F_C50_4_",
  "label": "F C50 4",
  "type": "string"
}, {
  "name": "_F_C100_4_",
  "label": "F C100 4",
  "type": "string"
}, {
  "name": "_F_C200_4_",
  "label": "F C200 4",
  "type": "string"
}, {
  "name": "_F_C500_4_",
  "label": "F C500 4",
  "type": "string"
}, {
  "name": "_F_C1000_4_",
  "label": "F C1000 4",
  "type": "string"
}, {
  "name": "_F_B_5_",
  "label": "F B 5",
  "type": "bool?"
}, {
  "name": "_F_I_5_",
  "label": "F I 5",
  "type": "int?"
}, {
  "name": "_F_L_5_",
  "label": "F L 5",
  "type": "long?"
}, {
  "name": "_F_DT_5_",
  "label": "F DT 5",
  "type": "DateTime?"
}, {
  "name": "_F_N_5_",
  "label": "F N 5",
  "type": "decimal?"
}, {
  "name": "_F_C5_5_",
  "label": "F C5 5",
  "type": "string"
}, {
  "name": "_F_C10_5_",
  "label": "F C10 5",
  "type": "string"
}, {
  "name": "_F_C20_5_",
  "label": "F C20 5",
  "type": "string"
}, {
  "name": "_F_C50_5_",
  "label": "F C50 5",
  "type": "string"
}, {
  "name": "_F_C100_5_",
  "label": "F C100 5",
  "type": "string"
}, {
  "name": "_F_C200_5_",
  "label": "F C200 5",
  "type": "string"
}, {
  "name": "_F_C500_5_",
  "label": "F C500 5",
  "type": "string"
}, {
  "name": "_F_B_6_",
  "label": "F B 6",
  "type": "bool?"
}, {
  "name": "_F_I_6_",
  "label": "F I 6",
  "type": "int?"
}, {
  "name": "_F_L_6_",
  "label": "F L 6",
  "type": "long?"
}, {
  "name": "_F_DT_6_",
  "label": "F DT 6",
  "type": "DateTime?"
}, {
  "name": "_F_N_6_",
  "label": "F N 6",
  "type": "decimal?"
}, {
  "name": "_F_C5_6_",
  "label": "F C5 6",
  "type": "string"
}, {
  "name": "_F_C10_6_",
  "label": "F C10 6",
  "type": "string"
}, {
  "name": "_F_C20_6_",
  "label": "F C20 6",
  "type": "string"
}, {
  "name": "_F_C50_6_",
  "label": "F C50 6",
  "type": "string"
}, {
  "name": "_F_C100_6_",
  "label": "F C100 6",
  "type": "string"
}, {
  "name": "_F_C200_6_",
  "label": "F C200 6",
  "type": "string"
}, {
  "name": "_F_C500_6_",
  "label": "F C500 6",
  "type": "string"
}, {
  "name": "_F_B_7_",
  "label": "F B 7",
  "type": "bool?"
}, {
  "name": "_F_I_7_",
  "label": "F I 7",
  "type": "int?"
}, {
  "name": "_F_L_7_",
  "label": "F L 7",
  "type": "long?"
}, {
  "name": "_F_DT_7_",
  "label": "F DT 7",
  "type": "DateTime?"
}, {
  "name": "_F_N_7_",
  "label": "F N 7",
  "type": "decimal?"
}, {
  "name": "_F_C5_7_",
  "label": "F C5 7",
  "type": "string"
}, {
  "name": "_F_C10_7_",
  "label": "F C10 7",
  "type": "string"
}, {
  "name": "_F_C20_7_",
  "label": "F C20 7",
  "type": "string"
}, {
  "name": "_F_C50_7_",
  "label": "F C50 7",
  "type": "string"
}, {
  "name": "_F_C100_7_",
  "label": "F C100 7",
  "type": "string"
}, {
  "name": "_F_C200_7_",
  "label": "F C200 7",
  "type": "string"
}, {
  "name": "_F_C500_7_",
  "label": "F C500 7",
  "type": "string"
}, {
  "name": "_F_B_8_",
  "label": "F B 8",
  "type": "bool?"
}, {
  "name": "_F_I_8_",
  "label": "F I 8",
  "type": "int?"
}, {
  "name": "_F_L_8_",
  "label": "F L 8",
  "type": "long?"
}, {
  "name": "_F_DT_8_",
  "label": "F DT 8",
  "type": "DateTime?"
}, {
  "name": "_F_N_8_",
  "label": "F N 8",
  "type": "decimal?"
}, {
  "name": "_F_C5_8_",
  "label": "F C5 8",
  "type": "string"
}, {
  "name": "_F_C10_8_",
  "label": "F C10 8",
  "type": "string"
}, {
  "name": "_F_C20_8_",
  "label": "F C20 8",
  "type": "string"
}, {
  "name": "_F_C50_8_",
  "label": "F C50 8",
  "type": "string"
}, {
  "name": "_F_C100_8_",
  "label": "F C100 8",
  "type": "string"
}, {
  "name": "_F_C200_8_",
  "label": "F C200 8",
  "type": "string"
}, {
  "name": "_F_C500_8_",
  "label": "F C500 8",
  "type": "string"
}, {
  "name": "_F_B_9_",
  "label": "F B 9",
  "type": "bool?"
}, {
  "name": "_F_I_9_",
  "label": "F I 9",
  "type": "int?"
}, {
  "name": "_F_L_9_",
  "label": "F L 9",
  "type": "long?"
}, {
  "name": "_F_DT_9_",
  "label": "F DT 9",
  "type": "DateTime?"
}, {
  "name": "_F_N_9_",
  "label": "F N 9",
  "type": "decimal?"
}, {
  "name": "_F_C5_9_",
  "label": "F C5 9",
  "type": "string"
}, {
  "name": "_F_C10_9_",
  "label": "F C10 9",
  "type": "string"
}, {
  "name": "_F_C20_9_",
  "label": "F C20 9",
  "type": "string"
}, {
  "name": "_F_C50_9_",
  "label": "F C50 9",
  "type": "string"
}, {
  "name": "_F_C100_9_",
  "label": "F C100 9",
  "type": "string"
}, {
  "name": "_F_C200_9_",
  "label": "F C200 9",
  "type": "string"
}, {
  "name": "_F_C500_9_",
  "label": "F C500 9",
  "type": "string"
}, {
  "name": "_F_B_10_",
  "label": "F B 10",
  "type": "bool?"
}, {
  "name": "_F_I_10_",
  "label": "F I 10",
  "type": "int?"
}, {
  "name": "_F_L_10_",
  "label": "F L 10",
  "type": "long?"
}, {
  "name": "_F_DT_10_",
  "label": "F DT 10",
  "type": "DateTime?"
}, {
  "name": "_F_N_10_",
  "label": "F N 10",
  "type": "decimal?"
}, {
  "name": "_F_C5_10_",
  "label": "F C5 10",
  "type": "string"
}, {
  "name": "_F_C10_10_",
  "label": "F C10 10",
  "type": "string"
}, {
  "name": "_F_C20_10_",
  "label": "F C20 10",
  "type": "string"
}, {
  "name": "_F_C50_10_",
  "label": "F C50 10",
  "type": "string"
}, {
  "name": "_F_C100_10_",
  "label": "F C100 10",
  "type": "string"
}, {
  "name": "_F_C200_10_",
  "label": "F C200 10",
  "type": "string"
}, {
  "name": "_F_B_11_",
  "label": "F B 11",
  "type": "bool?"
}, {
  "name": "_F_I_11_",
  "label": "F I 11",
  "type": "int?"
}, {
  "name": "_F_L_11_",
  "label": "F L 11",
  "type": "long?"
}, {
  "name": "_F_DT_11_",
  "label": "F DT 11",
  "type": "DateTime?"
}, {
  "name": "_F_N_11_",
  "label": "F N 11",
  "type": "decimal?"
}, {
  "name": "_F_C5_11_",
  "label": "F C5 11",
  "type": "string"
}, {
  "name": "_F_C10_11_",
  "label": "F C10 11",
  "type": "string"
}, {
  "name": "_F_C20_11_",
  "label": "F C20 11",
  "type": "string"
}, {
  "name": "_F_C50_11_",
  "label": "F C50 11",
  "type": "string"
}, {
  "name": "_F_C100_11_",
  "label": "F C100 11",
  "type": "string"
}, {
  "name": "_F_C200_11_",
  "label": "F C200 11",
  "type": "string"
}, {
  "name": "_F_B_12_",
  "label": "F B 12",
  "type": "bool?"
}, {
  "name": "_F_I_12_",
  "label": "F I 12",
  "type": "int?"
}, {
  "name": "_F_L_12_",
  "label": "F L 12",
  "type": "long?"
}, {
  "name": "_F_DT_12_",
  "label": "F DT 12",
  "type": "DateTime?"
}, {
  "name": "_F_N_12_",
  "label": "F N 12",
  "type": "decimal?"
}, {
  "name": "_F_C5_12_",
  "label": "F C5 12",
  "type": "string"
}, {
  "name": "_F_C10_12_",
  "label": "F C10 12",
  "type": "string"
}, {
  "name": "_F_C20_12_",
  "label": "F C20 12",
  "type": "string"
}, {
  "name": "_F_C50_12_",
  "label": "F C50 12",
  "type": "string"
}, {
  "name": "_F_C100_12_",
  "label": "F C100 12",
  "type": "string"
}, {
  "name": "_F_C200_12_",
  "label": "F C200 12",
  "type": "string"
}, {
  "name": "_F_B_13_",
  "label": "F B 13",
  "type": "bool?"
}, {
  "name": "_F_I_13_",
  "label": "F I 13",
  "type": "int?"
}, {
  "name": "_F_L_13_",
  "label": "F L 13",
  "type": "long?"
}, {
  "name": "_F_DT_13_",
  "label": "F DT 13",
  "type": "DateTime?"
}, {
  "name": "_F_N_13_",
  "label": "F N 13",
  "type": "decimal?"
}, {
  "name": "_F_C5_13_",
  "label": "F C5 13",
  "type": "string"
}, {
  "name": "_F_C10_13_",
  "label": "F C10 13",
  "type": "string"
}, {
  "name": "_F_C20_13_",
  "label": "F C20 13",
  "type": "string"
}, {
  "name": "_F_C50_13_",
  "label": "F C50 13",
  "type": "string"
}, {
  "name": "_F_C100_13_",
  "label": "F C100 13",
  "type": "string"
}, {
  "name": "_F_C200_13_",
  "label": "F C200 13",
  "type": "string"
}, {
  "name": "_F_B_14_",
  "label": "F B 14",
  "type": "bool?"
}, {
  "name": "_F_I_14_",
  "label": "F I 14",
  "type": "int?"
}, {
  "name": "_F_L_14_",
  "label": "F L 14",
  "type": "long?"
}, {
  "name": "_F_DT_14_",
  "label": "F DT 14",
  "type": "DateTime?"
}, {
  "name": "_F_N_14_",
  "label": "F N 14",
  "type": "decimal?"
}, {
  "name": "_F_C5_14_",
  "label": "F C5 14",
  "type": "string"
}, {
  "name": "_F_C10_14_",
  "label": "F C10 14",
  "type": "string"
}, {
  "name": "_F_C20_14_",
  "label": "F C20 14",
  "type": "string"
}, {
  "name": "_F_C50_14_",
  "label": "F C50 14",
  "type": "string"
}, {
  "name": "_F_C100_14_",
  "label": "F C100 14",
  "type": "string"
}, {
  "name": "_F_C200_14_",
  "label": "F C200 14",
  "type": "string"
}, {
  "name": "_F_B_15_",
  "label": "F B 15",
  "type": "bool?"
}, {
  "name": "_F_I_15_",
  "label": "F I 15",
  "type": "int?"
}, {
  "name": "_F_L_15_",
  "label": "F L 15",
  "type": "long?"
}, {
  "name": "_F_DT_15_",
  "label": "F DT 15",
  "type": "DateTime?"
}, {
  "name": "_F_N_15_",
  "label": "F N 15",
  "type": "decimal?"
}, {
  "name": "_F_C5_15_",
  "label": "F C5 15",
  "type": "string"
}, {
  "name": "_F_C10_15_",
  "label": "F C10 15",
  "type": "string"
}, {
  "name": "_F_C20_15_",
  "label": "F C20 15",
  "type": "string"
}, {
  "name": "_F_C50_15_",
  "label": "F C50 15",
  "type": "string"
}, {
  "name": "_F_C100_15_",
  "label": "F C100 15",
  "type": "string"
}, {
  "name": "_F_C200_15_",
  "label": "F C200 15",
  "type": "string"
}, {
  "name": "_F_B_16_",
  "label": "F B 16",
  "type": "bool?"
}, {
  "name": "_F_I_16_",
  "label": "F I 16",
  "type": "int?"
}, {
  "name": "_F_L_16_",
  "label": "F L 16",
  "type": "long?"
}, {
  "name": "_F_DT_16_",
  "label": "F DT 16",
  "type": "DateTime?"
}, {
  "name": "_F_N_16_",
  "label": "F N 16",
  "type": "decimal?"
}, {
  "name": "_F_C5_16_",
  "label": "F C5 16",
  "type": "string"
}, {
  "name": "_F_C10_16_",
  "label": "F C10 16",
  "type": "string"
}, {
  "name": "_F_C20_16_",
  "label": "F C20 16",
  "type": "string"
}, {
  "name": "_F_C50_16_",
  "label": "F C50 16",
  "type": "string"
}, {
  "name": "_F_C100_16_",
  "label": "F C100 16",
  "type": "string"
}, {
  "name": "_F_C200_16_",
  "label": "F C200 16",
  "type": "string"
}, {
  "name": "_F_B_17_",
  "label": "F B 17",
  "type": "bool?"
}, {
  "name": "_F_I_17_",
  "label": "F I 17",
  "type": "int?"
}, {
  "name": "_F_L_17_",
  "label": "F L 17",
  "type": "long?"
}, {
  "name": "_F_DT_17_",
  "label": "F DT 17",
  "type": "DateTime?"
}, {
  "name": "_F_N_17_",
  "label": "F N 17",
  "type": "decimal?"
}, {
  "name": "_F_C5_17_",
  "label": "F C5 17",
  "type": "string"
}, {
  "name": "_F_C10_17_",
  "label": "F C10 17",
  "type": "string"
}, {
  "name": "_F_C20_17_",
  "label": "F C20 17",
  "type": "string"
}, {
  "name": "_F_C50_17_",
  "label": "F C50 17",
  "type": "string"
}, {
  "name": "_F_C100_17_",
  "label": "F C100 17",
  "type": "string"
}, {
  "name": "_F_C200_17_",
  "label": "F C200 17",
  "type": "string"
}, {
  "name": "_F_B_18_",
  "label": "F B 18",
  "type": "bool?"
}, {
  "name": "_F_I_18_",
  "label": "F I 18",
  "type": "int?"
}, {
  "name": "_F_L_18_",
  "label": "F L 18",
  "type": "long?"
}, {
  "name": "_F_DT_18_",
  "label": "F DT 18",
  "type": "DateTime?"
}, {
  "name": "_F_N_18_",
  "label": "F N 18",
  "type": "decimal?"
}, {
  "name": "_F_C5_18_",
  "label": "F C5 18",
  "type": "string"
}, {
  "name": "_F_C10_18_",
  "label": "F C10 18",
  "type": "string"
}, {
  "name": "_F_C20_18_",
  "label": "F C20 18",
  "type": "string"
}, {
  "name": "_F_C50_18_",
  "label": "F C50 18",
  "type": "string"
}, {
  "name": "_F_C100_18_",
  "label": "F C100 18",
  "type": "string"
}, {
  "name": "_F_C200_18_",
  "label": "F C200 18",
  "type": "string"
}, {
  "name": "_F_B_19_",
  "label": "F B 19",
  "type": "bool?"
}, {
  "name": "_F_I_19_",
  "label": "F I 19",
  "type": "int?"
}, {
  "name": "_F_L_19_",
  "label": "F L 19",
  "type": "long?"
}, {
  "name": "_F_DT_19_",
  "label": "F DT 19",
  "type": "DateTime?"
}, {
  "name": "_F_N_19_",
  "label": "F N 19",
  "type": "decimal?"
}, {
  "name": "_F_C5_19_",
  "label": "F C5 19",
  "type": "string"
}, {
  "name": "_F_C10_19_",
  "label": "F C10 19",
  "type": "string"
}, {
  "name": "_F_C20_19_",
  "label": "F C20 19",
  "type": "string"
}, {
  "name": "_F_C50_19_",
  "label": "F C50 19",
  "type": "string"
}, {
  "name": "_F_C100_19_",
  "label": "F C100 19",
  "type": "string"
}, {
  "name": "_F_C200_19_",
  "label": "F C200 19",
  "type": "string"
}, {
  "name": "_F_B_20_",
  "label": "F B 20",
  "type": "bool?"
}, {
  "name": "_F_I_20_",
  "label": "F I 20",
  "type": "int?"
}, {
  "name": "_F_L_20_",
  "label": "F L 20",
  "type": "long?"
}, {
  "name": "_F_N_20_",
  "label": "F N 20",
  "type": "decimal?"
}, {
  "name": "_F_C5_20_",
  "label": "F C5 20",
  "type": "string"
}, {
  "name": "_F_C10_20_",
  "label": "F C10 20",
  "type": "string"
}, {
  "name": "_F_C20_20_",
  "label": "F C20 20",
  "type": "string"
}, {
  "name": "_F_C50_20_",
  "label": "F C50 20",
  "type": "string"
}, {
  "name": "_F_B_21_",
  "label": "F B 21",
  "type": "bool?"
}, {
  "name": "_F_I_21_",
  "label": "F I 21",
  "type": "int?"
}, {
  "name": "_F_L_21_",
  "label": "F L 21",
  "type": "long?"
}, {
  "name": "_F_N_21_",
  "label": "F N 21",
  "type": "decimal?"
}, {
  "name": "_F_C5_21_",
  "label": "F C5 21",
  "type": "string"
}, {
  "name": "_F_C10_21_",
  "label": "F C10 21",
  "type": "string"
}, {
  "name": "_F_C20_21_",
  "label": "F C20 21",
  "type": "string"
}, {
  "name": "_F_C50_21_",
  "label": "F C50 21",
  "type": "string"
}, {
  "name": "_F_B_22_",
  "label": "F B 22",
  "type": "bool?"
}, {
  "name": "_F_I_22_",
  "label": "F I 22",
  "type": "int?"
}, {
  "name": "_F_L_22_",
  "label": "F L 22",
  "type": "long?"
}, {
  "name": "_F_N_22_",
  "label": "F N 22",
  "type": "decimal?"
}, {
  "name": "_F_C5_22_",
  "label": "F C5 22",
  "type": "string"
}, {
  "name": "_F_C10_22_",
  "label": "F C10 22",
  "type": "string"
}, {
  "name": "_F_C20_22_",
  "label": "F C20 22",
  "type": "string"
}, {
  "name": "_F_C50_22_",
  "label": "F C50 22",
  "type": "string"
}, {
  "name": "_F_B_23_",
  "label": "F B 23",
  "type": "bool?"
}, {
  "name": "_F_I_23_",
  "label": "F I 23",
  "type": "int?"
}, {
  "name": "_F_L_23_",
  "label": "F L 23",
  "type": "long?"
}, {
  "name": "_F_N_23_",
  "label": "F N 23",
  "type": "decimal?"
}, {
  "name": "_F_C5_23_",
  "label": "F C5 23",
  "type": "string"
}, {
  "name": "_F_C10_23_",
  "label": "F C10 23",
  "type": "string"
}, {
  "name": "_F_C20_23_",
  "label": "F C20 23",
  "type": "string"
}, {
  "name": "_F_C50_23_",
  "label": "F C50 23",
  "type": "string"
}, {
  "name": "_F_B_24_",
  "label": "F B 24",
  "type": "bool?"
}, {
  "name": "_F_I_24_",
  "label": "F I 24",
  "type": "int?"
}, {
  "name": "_F_L_24_",
  "label": "F L 24",
  "type": "long?"
}, {
  "name": "_F_N_24_",
  "label": "F N 24",
  "type": "decimal?"
}, {
  "name": "_F_C5_24_",
  "label": "F C5 24",
  "type": "string"
}, {
  "name": "_F_C10_24_",
  "label": "F C10 24",
  "type": "string"
}, {
  "name": "_F_C20_24_",
  "label": "F C20 24",
  "type": "string"
}, {
  "name": "_F_C50_24_",
  "label": "F C50 24",
  "type": "string"
}, {
  "name": "_F_B_25_",
  "label": "F B 25",
  "type": "bool?"
}, {
  "name": "_F_I_25_",
  "label": "F I 25",
  "type": "int?"
}, {
  "name": "_F_L_25_",
  "label": "F L 25",
  "type": "long?"
}, {
  "name": "_F_N_25_",
  "label": "F N 25",
  "type": "decimal?"
}, {
  "name": "_F_C5_25_",
  "label": "F C5 25",
  "type": "string"
}, {
  "name": "_F_C10_25_",
  "label": "F C10 25",
  "type": "string"
}, {
  "name": "_F_C20_25_",
  "label": "F C20 25",
  "type": "string"
}, {
  "name": "_F_C50_25_",
  "label": "F C50 25",
  "type": "string"
}, {
  "name": "_F_B_26_",
  "label": "F B 26",
  "type": "bool?"
}, {
  "name": "_F_I_26_",
  "label": "F I 26",
  "type": "int?"
}, {
  "name": "_F_L_26_",
  "label": "F L 26",
  "type": "long?"
}, {
  "name": "_F_N_26_",
  "label": "F N 26",
  "type": "decimal?"
}, {
  "name": "_F_C5_26_",
  "label": "F C5 26",
  "type": "string"
}, {
  "name": "_F_C10_26_",
  "label": "F C10 26",
  "type": "string"
}, {
  "name": "_F_C20_26_",
  "label": "F C20 26",
  "type": "string"
}, {
  "name": "_F_C50_26_",
  "label": "F C50 26",
  "type": "string"
}, {
  "name": "_F_B_27_",
  "label": "F B 27",
  "type": "bool?"
}, {
  "name": "_F_I_27_",
  "label": "F I 27",
  "type": "int?"
}, {
  "name": "_F_L_27_",
  "label": "F L 27",
  "type": "long?"
}, {
  "name": "_F_N_27_",
  "label": "F N 27",
  "type": "decimal?"
}, {
  "name": "_F_C5_27_",
  "label": "F C5 27",
  "type": "string"
}, {
  "name": "_F_C10_27_",
  "label": "F C10 27",
  "type": "string"
}, {
  "name": "_F_C20_27_",
  "label": "F C20 27",
  "type": "string"
}, {
  "name": "_F_C50_27_",
  "label": "F C50 27",
  "type": "string"
}, {
  "name": "_F_B_28_",
  "label": "F B 28",
  "type": "bool?"
}, {
  "name": "_F_I_28_",
  "label": "F I 28",
  "type": "int?"
}, {
  "name": "_F_L_28_",
  "label": "F L 28",
  "type": "long?"
}, {
  "name": "_F_N_28_",
  "label": "F N 28",
  "type": "decimal?"
}, {
  "name": "_F_C5_28_",
  "label": "F C5 28",
  "type": "string"
}, {
  "name": "_F_C10_28_",
  "label": "F C10 28",
  "type": "string"
}, {
  "name": "_F_C20_28_",
  "label": "F C20 28",
  "type": "string"
}, {
  "name": "_F_C50_28_",
  "label": "F C50 28",
  "type": "string"
}, {
  "name": "_F_B_29_",
  "label": "F B 29",
  "type": "bool?"
}, {
  "name": "_F_I_29_",
  "label": "F I 29",
  "type": "int?"
}, {
  "name": "_F_L_29_",
  "label": "F L 29",
  "type": "long?"
}, {
  "name": "_F_N_29_",
  "label": "F N 29",
  "type": "decimal?"
}, {
  "name": "_F_C5_29_",
  "label": "F C5 29",
  "type": "string"
}, {
  "name": "_F_C10_29_",
  "label": "F C10 29",
  "type": "string"
}, {
  "name": "_F_C20_29_",
  "label": "F C20 29",
  "type": "string"
}, {
  "name": "_F_C50_29_",
  "label": "F C50 29",
  "type": "string"
}, {
  "name": "_F_B_30_",
  "label": "F B 30",
  "type": "bool?"
}, {
  "name": "_F_I_30_",
  "label": "F I 30",
  "type": "int?"
}, {
  "name": "_F_N_30_",
  "label": "F N 30",
  "type": "decimal?"
}, {
  "name": "_F_C5_30_",
  "label": "F C5 30",
  "type": "string"
}, {
  "name": "_F_C10_30_",
  "label": "F C10 30",
  "type": "string"
}, {
  "name": "_F_C20_30_",
  "label": "F C20 30",
  "type": "string"
}, {
  "name": "_F_C50_30_",
  "label": "F C50 30",
  "type": "string"
}, {
  "name": "_F_B_31_",
  "label": "F B 31",
  "type": "bool?"
}, {
  "name": "_F_I_31_",
  "label": "F I 31",
  "type": "int?"
}, {
  "name": "_F_N_31_",
  "label": "F N 31",
  "type": "decimal?"
}, {
  "name": "_F_C5_31_",
  "label": "F C5 31",
  "type": "string"
}, {
  "name": "_F_C10_31_",
  "label": "F C10 31",
  "type": "string"
}, {
  "name": "_F_C20_31_",
  "label": "F C20 31",
  "type": "string"
}, {
  "name": "_F_C50_31_",
  "label": "F C50 31",
  "type": "string"
}, {
  "name": "_F_B_32_",
  "label": "F B 32",
  "type": "bool?"
}, {
  "name": "_F_I_32_",
  "label": "F I 32",
  "type": "int?"
}, {
  "name": "_F_N_32_",
  "label": "F N 32",
  "type": "decimal?"
}, {
  "name": "_F_C5_32_",
  "label": "F C5 32",
  "type": "string"
}, {
  "name": "_F_C10_32_",
  "label": "F C10 32",
  "type": "string"
}, {
  "name": "_F_C20_32_",
  "label": "F C20 32",
  "type": "string"
}, {
  "name": "_F_C50_32_",
  "label": "F C50 32",
  "type": "string"
}, {
  "name": "_F_B_33_",
  "label": "F B 33",
  "type": "bool?"
}, {
  "name": "_F_I_33_",
  "label": "F I 33",
  "type": "int?"
}, {
  "name": "_F_N_33_",
  "label": "F N 33",
  "type": "decimal?"
}, {
  "name": "_F_C5_33_",
  "label": "F C5 33",
  "type": "string"
}, {
  "name": "_F_C10_33_",
  "label": "F C10 33",
  "type": "string"
}, {
  "name": "_F_C20_33_",
  "label": "F C20 33",
  "type": "string"
}, {
  "name": "_F_C50_33_",
  "label": "F C50 33",
  "type": "string"
}, {
  "name": "_F_B_34_",
  "label": "F B 34",
  "type": "bool?"
}, {
  "name": "_F_I_34_",
  "label": "F I 34",
  "type": "int?"
}, {
  "name": "_F_N_34_",
  "label": "F N 34",
  "type": "decimal?"
}, {
  "name": "_F_C5_34_",
  "label": "F C5 34",
  "type": "string"
}, {
  "name": "_F_C10_34_",
  "label": "F C10 34",
  "type": "string"
}, {
  "name": "_F_C20_34_",
  "label": "F C20 34",
  "type": "string"
}, {
  "name": "_F_C50_34_",
  "label": "F C50 34",
  "type": "string"
}, {
  "name": "_F_B_35_",
  "label": "F B 35",
  "type": "bool?"
}, {
  "name": "_F_I_35_",
  "label": "F I 35",
  "type": "int?"
}, {
  "name": "_F_N_35_",
  "label": "F N 35",
  "type": "decimal?"
}, {
  "name": "_F_C5_35_",
  "label": "F C5 35",
  "type": "string"
}, {
  "name": "_F_C10_35_",
  "label": "F C10 35",
  "type": "string"
}, {
  "name": "_F_C20_35_",
  "label": "F C20 35",
  "type": "string"
}, {
  "name": "_F_C50_35_",
  "label": "F C50 35",
  "type": "string"
}, {
  "name": "_F_B_36_",
  "label": "F B 36",
  "type": "bool?"
}, {
  "name": "_F_I_36_",
  "label": "F I 36",
  "type": "int?"
}, {
  "name": "_F_N_36_",
  "label": "F N 36",
  "type": "decimal?"
}, {
  "name": "_F_C5_36_",
  "label": "F C5 36",
  "type": "string"
}, {
  "name": "_F_C10_36_",
  "label": "F C10 36",
  "type": "string"
}, {
  "name": "_F_C20_36_",
  "label": "F C20 36",
  "type": "string"
}, {
  "name": "_F_C50_36_",
  "label": "F C50 36",
  "type": "string"
}, {
  "name": "_F_B_37_",
  "label": "F B 37",
  "type": "bool?"
}, {
  "name": "_F_I_37_",
  "label": "F I 37",
  "type": "int?"
}, {
  "name": "_F_N_37_",
  "label": "F N 37",
  "type": "decimal?"
}, {
  "name": "_F_C5_37_",
  "label": "F C5 37",
  "type": "string"
}, {
  "name": "_F_C10_37_",
  "label": "F C10 37",
  "type": "string"
}, {
  "name": "_F_C20_37_",
  "label": "F C20 37",
  "type": "string"
}, {
  "name": "_F_C50_37_",
  "label": "F C50 37",
  "type": "string"
}, {
  "name": "_F_B_38_",
  "label": "F B 38",
  "type": "bool?"
}, {
  "name": "_F_I_38_",
  "label": "F I 38",
  "type": "int?"
}, {
  "name": "_F_N_38_",
  "label": "F N 38",
  "type": "decimal?"
}, {
  "name": "_F_C5_38_",
  "label": "F C5 38",
  "type": "string"
}, {
  "name": "_F_C10_38_",
  "label": "F C10 38",
  "type": "string"
}, {
  "name": "_F_C20_38_",
  "label": "F C20 38",
  "type": "string"
}, {
  "name": "_F_C50_38_",
  "label": "F C50 38",
  "type": "string"
}, {
  "name": "_F_B_39_",
  "label": "F B 39",
  "type": "bool?"
}, {
  "name": "_F_I_39_",
  "label": "F I 39",
  "type": "int?"
}, {
  "name": "_F_N_39_",
  "label": "F N 39",
  "type": "decimal?"
}, {
  "name": "_F_C5_39_",
  "label": "F C5 39",
  "type": "string"
}, {
  "name": "_F_C10_39_",
  "label": "F C10 39",
  "type": "string"
}, {
  "name": "_F_C20_39_",
  "label": "F C20 39",
  "type": "string"
}, {
  "name": "_F_C50_39_",
  "label": "F C50 39",
  "type": "string"
}, {
  "name": "_F_B_40_",
  "label": "F B 40",
  "type": "bool?"
}, {
  "name": "_F_I_40_",
  "label": "F I 40",
  "type": "int?"
}, {
  "name": "_F_N_40_",
  "label": "F N 40",
  "type": "decimal?"
}, {
  "name": "_F_C5_40_",
  "label": "F C5 40",
  "type": "string"
}, {
  "name": "_F_C10_40_",
  "label": "F C10 40",
  "type": "string"
}, {
  "name": "_F_C20_40_",
  "label": "F C20 40",
  "type": "string"
}, {
  "name": "_F_C50_40_",
  "label": "F C50 40",
  "type": "string"
}, {
  "name": "_F_B_41_",
  "label": "F B 41",
  "type": "bool?"
}, {
  "name": "_F_I_41_",
  "label": "F I 41",
  "type": "int?"
}, {
  "name": "_F_N_41_",
  "label": "F N 41",
  "type": "decimal?"
}, {
  "name": "_F_C5_41_",
  "label": "F C5 41",
  "type": "string"
}, {
  "name": "_F_C10_41_",
  "label": "F C10 41",
  "type": "string"
}, {
  "name": "_F_C20_41_",
  "label": "F C20 41",
  "type": "string"
}, {
  "name": "_F_C50_41_",
  "label": "F C50 41",
  "type": "string"
}, {
  "name": "_F_B_42_",
  "label": "F B 42",
  "type": "bool?"
}, {
  "name": "_F_I_42_",
  "label": "F I 42",
  "type": "int?"
}, {
  "name": "_F_N_42_",
  "label": "F N 42",
  "type": "decimal?"
}, {
  "name": "_F_C5_42_",
  "label": "F C5 42",
  "type": "string"
}, {
  "name": "_F_C10_42_",
  "label": "F C10 42",
  "type": "string"
}, {
  "name": "_F_C20_42_",
  "label": "F C20 42",
  "type": "string"
}, {
  "name": "_F_C50_42_",
  "label": "F C50 42",
  "type": "string"
}, {
  "name": "_F_B_43_",
  "label": "F B 43",
  "type": "bool?"
}, {
  "name": "_F_I_43_",
  "label": "F I 43",
  "type": "int?"
}, {
  "name": "_F_N_43_",
  "label": "F N 43",
  "type": "decimal?"
}, {
  "name": "_F_C5_43_",
  "label": "F C5 43",
  "type": "string"
}, {
  "name": "_F_C10_43_",
  "label": "F C10 43",
  "type": "string"
}, {
  "name": "_F_C20_43_",
  "label": "F C20 43",
  "type": "string"
}, {
  "name": "_F_C50_43_",
  "label": "F C50 43",
  "type": "string"
}, {
  "name": "_F_B_44_",
  "label": "F B 44",
  "type": "bool?"
}, {
  "name": "_F_I_44_",
  "label": "F I 44",
  "type": "int?"
}, {
  "name": "_F_N_44_",
  "label": "F N 44",
  "type": "decimal?"
}, {
  "name": "_F_C5_44_",
  "label": "F C5 44",
  "type": "string"
}, {
  "name": "_F_C10_44_",
  "label": "F C10 44",
  "type": "string"
}, {
  "name": "_F_C20_44_",
  "label": "F C20 44",
  "type": "string"
}, {
  "name": "_F_C50_44_",
  "label": "F C50 44",
  "type": "string"
}, {
  "name": "_F_B_45_",
  "label": "F B 45",
  "type": "bool?"
}, {
  "name": "_F_I_45_",
  "label": "F I 45",
  "type": "int?"
}, {
  "name": "_F_N_45_",
  "label": "F N 45",
  "type": "decimal?"
}, {
  "name": "_F_C5_45_",
  "label": "F C5 45",
  "type": "string"
}, {
  "name": "_F_C10_45_",
  "label": "F C10 45",
  "type": "string"
}, {
  "name": "_F_C20_45_",
  "label": "F C20 45",
  "type": "string"
}, {
  "name": "_F_C50_45_",
  "label": "F C50 45",
  "type": "string"
}, {
  "name": "_F_B_46_",
  "label": "F B 46",
  "type": "bool?"
}, {
  "name": "_F_I_46_",
  "label": "F I 46",
  "type": "int?"
}, {
  "name": "_F_N_46_",
  "label": "F N 46",
  "type": "decimal?"
}, {
  "name": "_F_C5_46_",
  "label": "F C5 46",
  "type": "string"
}, {
  "name": "_F_C10_46_",
  "label": "F C10 46",
  "type": "string"
}, {
  "name": "_F_C20_46_",
  "label": "F C20 46",
  "type": "string"
}, {
  "name": "_F_C50_46_",
  "label": "F C50 46",
  "type": "string"
}, {
  "name": "_F_B_47_",
  "label": "F B 47",
  "type": "bool?"
}, {
  "name": "_F_I_47_",
  "label": "F I 47",
  "type": "int?"
}, {
  "name": "_F_N_47_",
  "label": "F N 47",
  "type": "decimal?"
}, {
  "name": "_F_C5_47_",
  "label": "F C5 47",
  "type": "string"
}, {
  "name": "_F_C10_47_",
  "label": "F C10 47",
  "type": "string"
}, {
  "name": "_F_C20_47_",
  "label": "F C20 47",
  "type": "string"
}, {
  "name": "_F_C50_47_",
  "label": "F C50 47",
  "type": "string"
}, {
  "name": "_F_B_48_",
  "label": "F B 48",
  "type": "bool?"
}, {
  "name": "_F_I_48_",
  "label": "F I 48",
  "type": "int?"
}, {
  "name": "_F_N_48_",
  "label": "F N 48",
  "type": "decimal?"
}, {
  "name": "_F_C5_48_",
  "label": "F C5 48",
  "type": "string"
}, {
  "name": "_F_C10_48_",
  "label": "F C10 48",
  "type": "string"
}, {
  "name": "_F_C20_48_",
  "label": "F C20 48",
  "type": "string"
}, {
  "name": "_F_C50_48_",
  "label": "F C50 48",
  "type": "string"
}, {
  "name": "_F_B_49_",
  "label": "F B 49",
  "type": "bool?"
}, {
  "name": "_F_I_49_",
  "label": "F I 49",
  "type": "int?"
}, {
  "name": "_F_N_49_",
  "label": "F N 49",
  "type": "decimal?"
}, {
  "name": "_F_C5_49_",
  "label": "F C5 49",
  "type": "string"
}, {
  "name": "_F_C10_49_",
  "label": "F C10 49",
  "type": "string"
}, {
  "name": "_F_C20_49_",
  "label": "F C20 49",
  "type": "string"
}, {
  "name": "_F_C50_49_",
  "label": "F C50 49",
  "type": "string"
}, {
  "name": "version",
  "label": "Version",
  "type": "long"
}, {
  "name": "createdBy",
  "label": "Created By",
  "type": "string"
}, {
  "name": "createdAt",
  "label": "Created At",
  "type": "DateTime"
}, {
  "name": "updatedBy",
  "label": "Updated By",
  "type": "string"
}, {
  "name": "updatedAt",
  "label": "Updated At",
  "type": "DateTime"
}, {
  "name": "active",
  "label": "Active",
  "type": "bool"
}, {
  "name": "deleted",
  "label": "Deleted",
  "type": "bool"
} ]

, httpPostCreationEnabled: true
, filteringProperties: [
  {
    "name": "AttributeSetInstanceId",
    "typeName": "string",
    "targetPropertyName": "attributeSetInstanceId"
  },
  {
    "name": "AttributeSetId",
    "typeName": "string",
    "targetPropertyName": "attributeSetId"
  },
  {
    "name": "OrganizationId",
    "typeName": "string",
    "targetPropertyName": "organizationId"
  },
  {
    "name": "ReferenceId",
    "typeName": "string",
    "targetPropertyName": "referenceId"
  },
  {
    "name": "SerialNumber",
    "typeName": "string",
    "targetPropertyName": "serialNumber"
  },
  {
    "name": "Lot",
    "typeName": "string",
    "targetPropertyName": "lot"
  },
  {
    "name": "Description",
    "typeName": "string",
    "targetPropertyName": "description"
  },
  {
    "name": "_F_B_0_",
    "typeName": "bool",
    "targetPropertyName": "_F_B_0_"
  },
  {
    "name": "_F_I_0_",
    "typeName": "int",
    "targetPropertyName": "_F_I_0_"
  },
  {
    "name": "_F_L_0_",
    "typeName": "long",
    "targetPropertyName": "_F_L_0_"
  },
  {
    "name": "_F_DT_0_",
    "typeName": "DateTime",
    "targetPropertyName": "_F_DT_0_"
  },
  {
    "name": "_F_N_0_",
    "typeName": "decimal",
    "targetPropertyName": "_F_N_0_"
  },
  {
    "name": "_F_C5_0_",
    "typeName": "string",
    "targetPropertyName": "_F_C5_0_"
  },
  {
    "name": "_F_C10_0_",
    "typeName": "string",
    "targetPropertyName": "_F_C10_0_"
  },
  {
    "name": "_F_C20_0_",
    "typeName": "string",
    "targetPropertyName": "_F_C20_0_"
  },
  {
    "name": "_F_C50_0_",
    "typeName": "string",
    "targetPropertyName": "_F_C50_0_"
  },
  {
    "name": "_F_C100_0_",
    "typeName": "string",
    "targetPropertyName": "_F_C100_0_"
  },
  {
    "name": "_F_C200_0_",
    "typeName": "string",
    "targetPropertyName": "_F_C200_0_"
  },
  {
    "name": "_F_C500_0_",
    "typeName": "string",
    "targetPropertyName": "_F_C500_0_"
  },
  {
    "name": "_F_C1000_0_",
    "typeName": "string",
    "targetPropertyName": "_F_C1000_0_"
  },
  {
    "name": "_F_B_1_",
    "typeName": "bool",
    "targetPropertyName": "_F_B_1_"
  },
  {
    "name": "_F_I_1_",
    "typeName": "int",
    "targetPropertyName": "_F_I_1_"
  },
  {
    "name": "_F_L_1_",
    "typeName": "long",
    "targetPropertyName": "_F_L_1_"
  },
  {
    "name": "_F_DT_1_",
    "typeName": "DateTime",
    "targetPropertyName": "_F_DT_1_"
  },
  {
    "name": "_F_N_1_",
    "typeName": "decimal",
    "targetPropertyName": "_F_N_1_"
  },
  {
    "name": "_F_C5_1_",
    "typeName": "string",
    "targetPropertyName": "_F_C5_1_"
  },
  {
    "name": "_F_C10_1_",
    "typeName": "string",
    "targetPropertyName": "_F_C10_1_"
  },
  {
    "name": "_F_C20_1_",
    "typeName": "string",
    "targetPropertyName": "_F_C20_1_"
  },
  {
    "name": "_F_C50_1_",
    "typeName": "string",
    "targetPropertyName": "_F_C50_1_"
  },
  {
    "name": "_F_C100_1_",
    "typeName": "string",
    "targetPropertyName": "_F_C100_1_"
  },
  {
    "name": "_F_C200_1_",
    "typeName": "string",
    "targetPropertyName": "_F_C200_1_"
  },
  {
    "name": "_F_C500_1_",
    "typeName": "string",
    "targetPropertyName": "_F_C500_1_"
  },
  {
    "name": "_F_C1000_1_",
    "typeName": "string",
    "targetPropertyName": "_F_C1000_1_"
  },
  {
    "name": "_F_B_2_",
    "typeName": "bool",
    "targetPropertyName": "_F_B_2_"
  },
  {
    "name": "_F_I_2_",
    "typeName": "int",
    "targetPropertyName": "_F_I_2_"
  },
  {
    "name": "_F_L_2_",
    "typeName": "long",
    "targetPropertyName": "_F_L_2_"
  },
  {
    "name": "_F_DT_2_",
    "typeName": "DateTime",
    "targetPropertyName": "_F_DT_2_"
  },
  {
    "name": "_F_N_2_",
    "typeName": "decimal",
    "targetPropertyName": "_F_N_2_"
  },
  {
    "name": "_F_C5_2_",
    "typeName": "string",
    "targetPropertyName": "_F_C5_2_"
  },
  {
    "name": "_F_C10_2_",
    "typeName": "string",
    "targetPropertyName": "_F_C10_2_"
  },
  {
    "name": "_F_C20_2_",
    "typeName": "string",
    "targetPropertyName": "_F_C20_2_"
  },
  {
    "name": "_F_C50_2_",
    "typeName": "string",
    "targetPropertyName": "_F_C50_2_"
  },
  {
    "name": "_F_C100_2_",
    "typeName": "string",
    "targetPropertyName": "_F_C100_2_"
  },
  {
    "name": "_F_C200_2_",
    "typeName": "string",
    "targetPropertyName": "_F_C200_2_"
  },
  {
    "name": "_F_C500_2_",
    "typeName": "string",
    "targetPropertyName": "_F_C500_2_"
  },
  {
    "name": "_F_C1000_2_",
    "typeName": "string",
    "targetPropertyName": "_F_C1000_2_"
  },
  {
    "name": "_F_B_3_",
    "typeName": "bool",
    "targetPropertyName": "_F_B_3_"
  },
  {
    "name": "_F_I_3_",
    "typeName": "int",
    "targetPropertyName": "_F_I_3_"
  },
  {
    "name": "_F_L_3_",
    "typeName": "long",
    "targetPropertyName": "_F_L_3_"
  },
  {
    "name": "_F_DT_3_",
    "typeName": "DateTime",
    "targetPropertyName": "_F_DT_3_"
  },
  {
    "name": "_F_N_3_",
    "typeName": "decimal",
    "targetPropertyName": "_F_N_3_"
  },
  {
    "name": "_F_C5_3_",
    "typeName": "string",
    "targetPropertyName": "_F_C5_3_"
  },
  {
    "name": "_F_C10_3_",
    "typeName": "string",
    "targetPropertyName": "_F_C10_3_"
  },
  {
    "name": "_F_C20_3_",
    "typeName": "string",
    "targetPropertyName": "_F_C20_3_"
  },
  {
    "name": "_F_C50_3_",
    "typeName": "string",
    "targetPropertyName": "_F_C50_3_"
  },
  {
    "name": "_F_C100_3_",
    "typeName": "string",
    "targetPropertyName": "_F_C100_3_"
  },
  {
    "name": "_F_C200_3_",
    "typeName": "string",
    "targetPropertyName": "_F_C200_3_"
  },
  {
    "name": "_F_C500_3_",
    "typeName": "string",
    "targetPropertyName": "_F_C500_3_"
  },
  {
    "name": "_F_C1000_3_",
    "typeName": "string",
    "targetPropertyName": "_F_C1000_3_"
  },
  {
    "name": "_F_B_4_",
    "typeName": "bool",
    "targetPropertyName": "_F_B_4_"
  },
  {
    "name": "_F_I_4_",
    "typeName": "int",
    "targetPropertyName": "_F_I_4_"
  },
  {
    "name": "_F_L_4_",
    "typeName": "long",
    "targetPropertyName": "_F_L_4_"
  },
  {
    "name": "_F_DT_4_",
    "typeName": "DateTime",
    "targetPropertyName": "_F_DT_4_"
  },
  {
    "name": "_F_N_4_",
    "typeName": "decimal",
    "targetPropertyName": "_F_N_4_"
  },
  {
    "name": "_F_C5_4_",
    "typeName": "string",
    "targetPropertyName": "_F_C5_4_"
  },
  {
    "name": "_F_C10_4_",
    "typeName": "string",
    "targetPropertyName": "_F_C10_4_"
  },
  {
    "name": "_F_C20_4_",
    "typeName": "string",
    "targetPropertyName": "_F_C20_4_"
  },
  {
    "name": "_F_C50_4_",
    "typeName": "string",
    "targetPropertyName": "_F_C50_4_"
  },
  {
    "name": "_F_C100_4_",
    "typeName": "string",
    "targetPropertyName": "_F_C100_4_"
  },
  {
    "name": "_F_C200_4_",
    "typeName": "string",
    "targetPropertyName": "_F_C200_4_"
  },
  {
    "name": "_F_C500_4_",
    "typeName": "string",
    "targetPropertyName": "_F_C500_4_"
  },
  {
    "name": "_F_C1000_4_",
    "typeName": "string",
    "targetPropertyName": "_F_C1000_4_"
  },
  {
    "name": "_F_B_5_",
    "typeName": "bool",
    "targetPropertyName": "_F_B_5_"
  },
  {
    "name": "_F_I_5_",
    "typeName": "int",
    "targetPropertyName": "_F_I_5_"
  },
  {
    "name": "_F_L_5_",
    "typeName": "long",
    "targetPropertyName": "_F_L_5_"
  },
  {
    "name": "_F_DT_5_",
    "typeName": "DateTime",
    "targetPropertyName": "_F_DT_5_"
  },
  {
    "name": "_F_N_5_",
    "typeName": "decimal",
    "targetPropertyName": "_F_N_5_"
  },
  {
    "name": "_F_C5_5_",
    "typeName": "string",
    "targetPropertyName": "_F_C5_5_"
  },
  {
    "name": "_F_C10_5_",
    "typeName": "string",
    "targetPropertyName": "_F_C10_5_"
  },
  {
    "name": "_F_C20_5_",
    "typeName": "string",
    "targetPropertyName": "_F_C20_5_"
  },
  {
    "name": "_F_C50_5_",
    "typeName": "string",
    "targetPropertyName": "_F_C50_5_"
  },
  {
    "name": "_F_C100_5_",
    "typeName": "string",
    "targetPropertyName": "_F_C100_5_"
  },
  {
    "name": "_F_C200_5_",
    "typeName": "string",
    "targetPropertyName": "_F_C200_5_"
  },
  {
    "name": "_F_C500_5_",
    "typeName": "string",
    "targetPropertyName": "_F_C500_5_"
  },
  {
    "name": "_F_B_6_",
    "typeName": "bool",
    "targetPropertyName": "_F_B_6_"
  },
  {
    "name": "_F_I_6_",
    "typeName": "int",
    "targetPropertyName": "_F_I_6_"
  },
  {
    "name": "_F_L_6_",
    "typeName": "long",
    "targetPropertyName": "_F_L_6_"
  },
  {
    "name": "_F_DT_6_",
    "typeName": "DateTime",
    "targetPropertyName": "_F_DT_6_"
  },
  {
    "name": "_F_N_6_",
    "typeName": "decimal",
    "targetPropertyName": "_F_N_6_"
  },
  {
    "name": "_F_C5_6_",
    "typeName": "string",
    "targetPropertyName": "_F_C5_6_"
  },
  {
    "name": "_F_C10_6_",
    "typeName": "string",
    "targetPropertyName": "_F_C10_6_"
  },
  {
    "name": "_F_C20_6_",
    "typeName": "string",
    "targetPropertyName": "_F_C20_6_"
  },
  {
    "name": "_F_C50_6_",
    "typeName": "string",
    "targetPropertyName": "_F_C50_6_"
  },
  {
    "name": "_F_C100_6_",
    "typeName": "string",
    "targetPropertyName": "_F_C100_6_"
  },
  {
    "name": "_F_C200_6_",
    "typeName": "string",
    "targetPropertyName": "_F_C200_6_"
  },
  {
    "name": "_F_C500_6_",
    "typeName": "string",
    "targetPropertyName": "_F_C500_6_"
  },
  {
    "name": "_F_B_7_",
    "typeName": "bool",
    "targetPropertyName": "_F_B_7_"
  },
  {
    "name": "_F_I_7_",
    "typeName": "int",
    "targetPropertyName": "_F_I_7_"
  },
  {
    "name": "_F_L_7_",
    "typeName": "long",
    "targetPropertyName": "_F_L_7_"
  },
  {
    "name": "_F_DT_7_",
    "typeName": "DateTime",
    "targetPropertyName": "_F_DT_7_"
  },
  {
    "name": "_F_N_7_",
    "typeName": "decimal",
    "targetPropertyName": "_F_N_7_"
  },
  {
    "name": "_F_C5_7_",
    "typeName": "string",
    "targetPropertyName": "_F_C5_7_"
  },
  {
    "name": "_F_C10_7_",
    "typeName": "string",
    "targetPropertyName": "_F_C10_7_"
  },
  {
    "name": "_F_C20_7_",
    "typeName": "string",
    "targetPropertyName": "_F_C20_7_"
  },
  {
    "name": "_F_C50_7_",
    "typeName": "string",
    "targetPropertyName": "_F_C50_7_"
  },
  {
    "name": "_F_C100_7_",
    "typeName": "string",
    "targetPropertyName": "_F_C100_7_"
  },
  {
    "name": "_F_C200_7_",
    "typeName": "string",
    "targetPropertyName": "_F_C200_7_"
  },
  {
    "name": "_F_C500_7_",
    "typeName": "string",
    "targetPropertyName": "_F_C500_7_"
  },
  {
    "name": "_F_B_8_",
    "typeName": "bool",
    "targetPropertyName": "_F_B_8_"
  },
  {
    "name": "_F_I_8_",
    "typeName": "int",
    "targetPropertyName": "_F_I_8_"
  },
  {
    "name": "_F_L_8_",
    "typeName": "long",
    "targetPropertyName": "_F_L_8_"
  },
  {
    "name": "_F_DT_8_",
    "typeName": "DateTime",
    "targetPropertyName": "_F_DT_8_"
  },
  {
    "name": "_F_N_8_",
    "typeName": "decimal",
    "targetPropertyName": "_F_N_8_"
  },
  {
    "name": "_F_C5_8_",
    "typeName": "string",
    "targetPropertyName": "_F_C5_8_"
  },
  {
    "name": "_F_C10_8_",
    "typeName": "string",
    "targetPropertyName": "_F_C10_8_"
  },
  {
    "name": "_F_C20_8_",
    "typeName": "string",
    "targetPropertyName": "_F_C20_8_"
  },
  {
    "name": "_F_C50_8_",
    "typeName": "string",
    "targetPropertyName": "_F_C50_8_"
  },
  {
    "name": "_F_C100_8_",
    "typeName": "string",
    "targetPropertyName": "_F_C100_8_"
  },
  {
    "name": "_F_C200_8_",
    "typeName": "string",
    "targetPropertyName": "_F_C200_8_"
  },
  {
    "name": "_F_C500_8_",
    "typeName": "string",
    "targetPropertyName": "_F_C500_8_"
  },
  {
    "name": "_F_B_9_",
    "typeName": "bool",
    "targetPropertyName": "_F_B_9_"
  },
  {
    "name": "_F_I_9_",
    "typeName": "int",
    "targetPropertyName": "_F_I_9_"
  },
  {
    "name": "_F_L_9_",
    "typeName": "long",
    "targetPropertyName": "_F_L_9_"
  },
  {
    "name": "_F_DT_9_",
    "typeName": "DateTime",
    "targetPropertyName": "_F_DT_9_"
  },
  {
    "name": "_F_N_9_",
    "typeName": "decimal",
    "targetPropertyName": "_F_N_9_"
  },
  {
    "name": "_F_C5_9_",
    "typeName": "string",
    "targetPropertyName": "_F_C5_9_"
  },
  {
    "name": "_F_C10_9_",
    "typeName": "string",
    "targetPropertyName": "_F_C10_9_"
  },
  {
    "name": "_F_C20_9_",
    "typeName": "string",
    "targetPropertyName": "_F_C20_9_"
  },
  {
    "name": "_F_C50_9_",
    "typeName": "string",
    "targetPropertyName": "_F_C50_9_"
  },
  {
    "name": "_F_C100_9_",
    "typeName": "string",
    "targetPropertyName": "_F_C100_9_"
  },
  {
    "name": "_F_C200_9_",
    "typeName": "string",
    "targetPropertyName": "_F_C200_9_"
  },
  {
    "name": "_F_C500_9_",
    "typeName": "string",
    "targetPropertyName": "_F_C500_9_"
  },
  {
    "name": "_F_B_10_",
    "typeName": "bool",
    "targetPropertyName": "_F_B_10_"
  },
  {
    "name": "_F_I_10_",
    "typeName": "int",
    "targetPropertyName": "_F_I_10_"
  },
  {
    "name": "_F_L_10_",
    "typeName": "long",
    "targetPropertyName": "_F_L_10_"
  },
  {
    "name": "_F_DT_10_",
    "typeName": "DateTime",
    "targetPropertyName": "_F_DT_10_"
  },
  {
    "name": "_F_N_10_",
    "typeName": "decimal",
    "targetPropertyName": "_F_N_10_"
  },
  {
    "name": "_F_C5_10_",
    "typeName": "string",
    "targetPropertyName": "_F_C5_10_"
  },
  {
    "name": "_F_C10_10_",
    "typeName": "string",
    "targetPropertyName": "_F_C10_10_"
  },
  {
    "name": "_F_C20_10_",
    "typeName": "string",
    "targetPropertyName": "_F_C20_10_"
  },
  {
    "name": "_F_C50_10_",
    "typeName": "string",
    "targetPropertyName": "_F_C50_10_"
  },
  {
    "name": "_F_C100_10_",
    "typeName": "string",
    "targetPropertyName": "_F_C100_10_"
  },
  {
    "name": "_F_C200_10_",
    "typeName": "string",
    "targetPropertyName": "_F_C200_10_"
  },
  {
    "name": "_F_B_11_",
    "typeName": "bool",
    "targetPropertyName": "_F_B_11_"
  },
  {
    "name": "_F_I_11_",
    "typeName": "int",
    "targetPropertyName": "_F_I_11_"
  },
  {
    "name": "_F_L_11_",
    "typeName": "long",
    "targetPropertyName": "_F_L_11_"
  },
  {
    "name": "_F_DT_11_",
    "typeName": "DateTime",
    "targetPropertyName": "_F_DT_11_"
  },
  {
    "name": "_F_N_11_",
    "typeName": "decimal",
    "targetPropertyName": "_F_N_11_"
  },
  {
    "name": "_F_C5_11_",
    "typeName": "string",
    "targetPropertyName": "_F_C5_11_"
  },
  {
    "name": "_F_C10_11_",
    "typeName": "string",
    "targetPropertyName": "_F_C10_11_"
  },
  {
    "name": "_F_C20_11_",
    "typeName": "string",
    "targetPropertyName": "_F_C20_11_"
  },
  {
    "name": "_F_C50_11_",
    "typeName": "string",
    "targetPropertyName": "_F_C50_11_"
  },
  {
    "name": "_F_C100_11_",
    "typeName": "string",
    "targetPropertyName": "_F_C100_11_"
  },
  {
    "name": "_F_C200_11_",
    "typeName": "string",
    "targetPropertyName": "_F_C200_11_"
  },
  {
    "name": "_F_B_12_",
    "typeName": "bool",
    "targetPropertyName": "_F_B_12_"
  },
  {
    "name": "_F_I_12_",
    "typeName": "int",
    "targetPropertyName": "_F_I_12_"
  },
  {
    "name": "_F_L_12_",
    "typeName": "long",
    "targetPropertyName": "_F_L_12_"
  },
  {
    "name": "_F_DT_12_",
    "typeName": "DateTime",
    "targetPropertyName": "_F_DT_12_"
  },
  {
    "name": "_F_N_12_",
    "typeName": "decimal",
    "targetPropertyName": "_F_N_12_"
  },
  {
    "name": "_F_C5_12_",
    "typeName": "string",
    "targetPropertyName": "_F_C5_12_"
  },
  {
    "name": "_F_C10_12_",
    "typeName": "string",
    "targetPropertyName": "_F_C10_12_"
  },
  {
    "name": "_F_C20_12_",
    "typeName": "string",
    "targetPropertyName": "_F_C20_12_"
  },
  {
    "name": "_F_C50_12_",
    "typeName": "string",
    "targetPropertyName": "_F_C50_12_"
  },
  {
    "name": "_F_C100_12_",
    "typeName": "string",
    "targetPropertyName": "_F_C100_12_"
  },
  {
    "name": "_F_C200_12_",
    "typeName": "string",
    "targetPropertyName": "_F_C200_12_"
  },
  {
    "name": "_F_B_13_",
    "typeName": "bool",
    "targetPropertyName": "_F_B_13_"
  },
  {
    "name": "_F_I_13_",
    "typeName": "int",
    "targetPropertyName": "_F_I_13_"
  },
  {
    "name": "_F_L_13_",
    "typeName": "long",
    "targetPropertyName": "_F_L_13_"
  },
  {
    "name": "_F_DT_13_",
    "typeName": "DateTime",
    "targetPropertyName": "_F_DT_13_"
  },
  {
    "name": "_F_N_13_",
    "typeName": "decimal",
    "targetPropertyName": "_F_N_13_"
  },
  {
    "name": "_F_C5_13_",
    "typeName": "string",
    "targetPropertyName": "_F_C5_13_"
  },
  {
    "name": "_F_C10_13_",
    "typeName": "string",
    "targetPropertyName": "_F_C10_13_"
  },
  {
    "name": "_F_C20_13_",
    "typeName": "string",
    "targetPropertyName": "_F_C20_13_"
  },
  {
    "name": "_F_C50_13_",
    "typeName": "string",
    "targetPropertyName": "_F_C50_13_"
  },
  {
    "name": "_F_C100_13_",
    "typeName": "string",
    "targetPropertyName": "_F_C100_13_"
  },
  {
    "name": "_F_C200_13_",
    "typeName": "string",
    "targetPropertyName": "_F_C200_13_"
  },
  {
    "name": "_F_B_14_",
    "typeName": "bool",
    "targetPropertyName": "_F_B_14_"
  },
  {
    "name": "_F_I_14_",
    "typeName": "int",
    "targetPropertyName": "_F_I_14_"
  },
  {
    "name": "_F_L_14_",
    "typeName": "long",
    "targetPropertyName": "_F_L_14_"
  },
  {
    "name": "_F_DT_14_",
    "typeName": "DateTime",
    "targetPropertyName": "_F_DT_14_"
  },
  {
    "name": "_F_N_14_",
    "typeName": "decimal",
    "targetPropertyName": "_F_N_14_"
  },
  {
    "name": "_F_C5_14_",
    "typeName": "string",
    "targetPropertyName": "_F_C5_14_"
  },
  {
    "name": "_F_C10_14_",
    "typeName": "string",
    "targetPropertyName": "_F_C10_14_"
  },
  {
    "name": "_F_C20_14_",
    "typeName": "string",
    "targetPropertyName": "_F_C20_14_"
  },
  {
    "name": "_F_C50_14_",
    "typeName": "string",
    "targetPropertyName": "_F_C50_14_"
  },
  {
    "name": "_F_C100_14_",
    "typeName": "string",
    "targetPropertyName": "_F_C100_14_"
  },
  {
    "name": "_F_C200_14_",
    "typeName": "string",
    "targetPropertyName": "_F_C200_14_"
  },
  {
    "name": "_F_B_15_",
    "typeName": "bool",
    "targetPropertyName": "_F_B_15_"
  },
  {
    "name": "_F_I_15_",
    "typeName": "int",
    "targetPropertyName": "_F_I_15_"
  },
  {
    "name": "_F_L_15_",
    "typeName": "long",
    "targetPropertyName": "_F_L_15_"
  },
  {
    "name": "_F_DT_15_",
    "typeName": "DateTime",
    "targetPropertyName": "_F_DT_15_"
  },
  {
    "name": "_F_N_15_",
    "typeName": "decimal",
    "targetPropertyName": "_F_N_15_"
  },
  {
    "name": "_F_C5_15_",
    "typeName": "string",
    "targetPropertyName": "_F_C5_15_"
  },
  {
    "name": "_F_C10_15_",
    "typeName": "string",
    "targetPropertyName": "_F_C10_15_"
  },
  {
    "name": "_F_C20_15_",
    "typeName": "string",
    "targetPropertyName": "_F_C20_15_"
  },
  {
    "name": "_F_C50_15_",
    "typeName": "string",
    "targetPropertyName": "_F_C50_15_"
  },
  {
    "name": "_F_C100_15_",
    "typeName": "string",
    "targetPropertyName": "_F_C100_15_"
  },
  {
    "name": "_F_C200_15_",
    "typeName": "string",
    "targetPropertyName": "_F_C200_15_"
  },
  {
    "name": "_F_B_16_",
    "typeName": "bool",
    "targetPropertyName": "_F_B_16_"
  },
  {
    "name": "_F_I_16_",
    "typeName": "int",
    "targetPropertyName": "_F_I_16_"
  },
  {
    "name": "_F_L_16_",
    "typeName": "long",
    "targetPropertyName": "_F_L_16_"
  },
  {
    "name": "_F_DT_16_",
    "typeName": "DateTime",
    "targetPropertyName": "_F_DT_16_"
  },
  {
    "name": "_F_N_16_",
    "typeName": "decimal",
    "targetPropertyName": "_F_N_16_"
  },
  {
    "name": "_F_C5_16_",
    "typeName": "string",
    "targetPropertyName": "_F_C5_16_"
  },
  {
    "name": "_F_C10_16_",
    "typeName": "string",
    "targetPropertyName": "_F_C10_16_"
  },
  {
    "name": "_F_C20_16_",
    "typeName": "string",
    "targetPropertyName": "_F_C20_16_"
  },
  {
    "name": "_F_C50_16_",
    "typeName": "string",
    "targetPropertyName": "_F_C50_16_"
  },
  {
    "name": "_F_C100_16_",
    "typeName": "string",
    "targetPropertyName": "_F_C100_16_"
  },
  {
    "name": "_F_C200_16_",
    "typeName": "string",
    "targetPropertyName": "_F_C200_16_"
  },
  {
    "name": "_F_B_17_",
    "typeName": "bool",
    "targetPropertyName": "_F_B_17_"
  },
  {
    "name": "_F_I_17_",
    "typeName": "int",
    "targetPropertyName": "_F_I_17_"
  },
  {
    "name": "_F_L_17_",
    "typeName": "long",
    "targetPropertyName": "_F_L_17_"
  },
  {
    "name": "_F_DT_17_",
    "typeName": "DateTime",
    "targetPropertyName": "_F_DT_17_"
  },
  {
    "name": "_F_N_17_",
    "typeName": "decimal",
    "targetPropertyName": "_F_N_17_"
  },
  {
    "name": "_F_C5_17_",
    "typeName": "string",
    "targetPropertyName": "_F_C5_17_"
  },
  {
    "name": "_F_C10_17_",
    "typeName": "string",
    "targetPropertyName": "_F_C10_17_"
  },
  {
    "name": "_F_C20_17_",
    "typeName": "string",
    "targetPropertyName": "_F_C20_17_"
  },
  {
    "name": "_F_C50_17_",
    "typeName": "string",
    "targetPropertyName": "_F_C50_17_"
  },
  {
    "name": "_F_C100_17_",
    "typeName": "string",
    "targetPropertyName": "_F_C100_17_"
  },
  {
    "name": "_F_C200_17_",
    "typeName": "string",
    "targetPropertyName": "_F_C200_17_"
  },
  {
    "name": "_F_B_18_",
    "typeName": "bool",
    "targetPropertyName": "_F_B_18_"
  },
  {
    "name": "_F_I_18_",
    "typeName": "int",
    "targetPropertyName": "_F_I_18_"
  },
  {
    "name": "_F_L_18_",
    "typeName": "long",
    "targetPropertyName": "_F_L_18_"
  },
  {
    "name": "_F_DT_18_",
    "typeName": "DateTime",
    "targetPropertyName": "_F_DT_18_"
  },
  {
    "name": "_F_N_18_",
    "typeName": "decimal",
    "targetPropertyName": "_F_N_18_"
  },
  {
    "name": "_F_C5_18_",
    "typeName": "string",
    "targetPropertyName": "_F_C5_18_"
  },
  {
    "name": "_F_C10_18_",
    "typeName": "string",
    "targetPropertyName": "_F_C10_18_"
  },
  {
    "name": "_F_C20_18_",
    "typeName": "string",
    "targetPropertyName": "_F_C20_18_"
  },
  {
    "name": "_F_C50_18_",
    "typeName": "string",
    "targetPropertyName": "_F_C50_18_"
  },
  {
    "name": "_F_C100_18_",
    "typeName": "string",
    "targetPropertyName": "_F_C100_18_"
  },
  {
    "name": "_F_C200_18_",
    "typeName": "string",
    "targetPropertyName": "_F_C200_18_"
  },
  {
    "name": "_F_B_19_",
    "typeName": "bool",
    "targetPropertyName": "_F_B_19_"
  },
  {
    "name": "_F_I_19_",
    "typeName": "int",
    "targetPropertyName": "_F_I_19_"
  },
  {
    "name": "_F_L_19_",
    "typeName": "long",
    "targetPropertyName": "_F_L_19_"
  },
  {
    "name": "_F_DT_19_",
    "typeName": "DateTime",
    "targetPropertyName": "_F_DT_19_"
  },
  {
    "name": "_F_N_19_",
    "typeName": "decimal",
    "targetPropertyName": "_F_N_19_"
  },
  {
    "name": "_F_C5_19_",
    "typeName": "string",
    "targetPropertyName": "_F_C5_19_"
  },
  {
    "name": "_F_C10_19_",
    "typeName": "string",
    "targetPropertyName": "_F_C10_19_"
  },
  {
    "name": "_F_C20_19_",
    "typeName": "string",
    "targetPropertyName": "_F_C20_19_"
  },
  {
    "name": "_F_C50_19_",
    "typeName": "string",
    "targetPropertyName": "_F_C50_19_"
  },
  {
    "name": "_F_C100_19_",
    "typeName": "string",
    "targetPropertyName": "_F_C100_19_"
  },
  {
    "name": "_F_C200_19_",
    "typeName": "string",
    "targetPropertyName": "_F_C200_19_"
  },
  {
    "name": "_F_B_20_",
    "typeName": "bool",
    "targetPropertyName": "_F_B_20_"
  },
  {
    "name": "_F_I_20_",
    "typeName": "int",
    "targetPropertyName": "_F_I_20_"
  },
  {
    "name": "_F_L_20_",
    "typeName": "long",
    "targetPropertyName": "_F_L_20_"
  },
  {
    "name": "_F_N_20_",
    "typeName": "decimal",
    "targetPropertyName": "_F_N_20_"
  },
  {
    "name": "_F_C5_20_",
    "typeName": "string",
    "targetPropertyName": "_F_C5_20_"
  },
  {
    "name": "_F_C10_20_",
    "typeName": "string",
    "targetPropertyName": "_F_C10_20_"
  },
  {
    "name": "_F_C20_20_",
    "typeName": "string",
    "targetPropertyName": "_F_C20_20_"
  },
  {
    "name": "_F_C50_20_",
    "typeName": "string",
    "targetPropertyName": "_F_C50_20_"
  },
  {
    "name": "_F_B_21_",
    "typeName": "bool",
    "targetPropertyName": "_F_B_21_"
  },
  {
    "name": "_F_I_21_",
    "typeName": "int",
    "targetPropertyName": "_F_I_21_"
  },
  {
    "name": "_F_L_21_",
    "typeName": "long",
    "targetPropertyName": "_F_L_21_"
  },
  {
    "name": "_F_N_21_",
    "typeName": "decimal",
    "targetPropertyName": "_F_N_21_"
  },
  {
    "name": "_F_C5_21_",
    "typeName": "string",
    "targetPropertyName": "_F_C5_21_"
  },
  {
    "name": "_F_C10_21_",
    "typeName": "string",
    "targetPropertyName": "_F_C10_21_"
  },
  {
    "name": "_F_C20_21_",
    "typeName": "string",
    "targetPropertyName": "_F_C20_21_"
  },
  {
    "name": "_F_C50_21_",
    "typeName": "string",
    "targetPropertyName": "_F_C50_21_"
  },
  {
    "name": "_F_B_22_",
    "typeName": "bool",
    "targetPropertyName": "_F_B_22_"
  },
  {
    "name": "_F_I_22_",
    "typeName": "int",
    "targetPropertyName": "_F_I_22_"
  },
  {
    "name": "_F_L_22_",
    "typeName": "long",
    "targetPropertyName": "_F_L_22_"
  },
  {
    "name": "_F_N_22_",
    "typeName": "decimal",
    "targetPropertyName": "_F_N_22_"
  },
  {
    "name": "_F_C5_22_",
    "typeName": "string",
    "targetPropertyName": "_F_C5_22_"
  },
  {
    "name": "_F_C10_22_",
    "typeName": "string",
    "targetPropertyName": "_F_C10_22_"
  },
  {
    "name": "_F_C20_22_",
    "typeName": "string",
    "targetPropertyName": "_F_C20_22_"
  },
  {
    "name": "_F_C50_22_",
    "typeName": "string",
    "targetPropertyName": "_F_C50_22_"
  },
  {
    "name": "_F_B_23_",
    "typeName": "bool",
    "targetPropertyName": "_F_B_23_"
  },
  {
    "name": "_F_I_23_",
    "typeName": "int",
    "targetPropertyName": "_F_I_23_"
  },
  {
    "name": "_F_L_23_",
    "typeName": "long",
    "targetPropertyName": "_F_L_23_"
  },
  {
    "name": "_F_N_23_",
    "typeName": "decimal",
    "targetPropertyName": "_F_N_23_"
  },
  {
    "name": "_F_C5_23_",
    "typeName": "string",
    "targetPropertyName": "_F_C5_23_"
  },
  {
    "name": "_F_C10_23_",
    "typeName": "string",
    "targetPropertyName": "_F_C10_23_"
  },
  {
    "name": "_F_C20_23_",
    "typeName": "string",
    "targetPropertyName": "_F_C20_23_"
  },
  {
    "name": "_F_C50_23_",
    "typeName": "string",
    "targetPropertyName": "_F_C50_23_"
  },
  {
    "name": "_F_B_24_",
    "typeName": "bool",
    "targetPropertyName": "_F_B_24_"
  },
  {
    "name": "_F_I_24_",
    "typeName": "int",
    "targetPropertyName": "_F_I_24_"
  },
  {
    "name": "_F_L_24_",
    "typeName": "long",
    "targetPropertyName": "_F_L_24_"
  },
  {
    "name": "_F_N_24_",
    "typeName": "decimal",
    "targetPropertyName": "_F_N_24_"
  },
  {
    "name": "_F_C5_24_",
    "typeName": "string",
    "targetPropertyName": "_F_C5_24_"
  },
  {
    "name": "_F_C10_24_",
    "typeName": "string",
    "targetPropertyName": "_F_C10_24_"
  },
  {
    "name": "_F_C20_24_",
    "typeName": "string",
    "targetPropertyName": "_F_C20_24_"
  },
  {
    "name": "_F_C50_24_",
    "typeName": "string",
    "targetPropertyName": "_F_C50_24_"
  },
  {
    "name": "_F_B_25_",
    "typeName": "bool",
    "targetPropertyName": "_F_B_25_"
  },
  {
    "name": "_F_I_25_",
    "typeName": "int",
    "targetPropertyName": "_F_I_25_"
  },
  {
    "name": "_F_L_25_",
    "typeName": "long",
    "targetPropertyName": "_F_L_25_"
  },
  {
    "name": "_F_N_25_",
    "typeName": "decimal",
    "targetPropertyName": "_F_N_25_"
  },
  {
    "name": "_F_C5_25_",
    "typeName": "string",
    "targetPropertyName": "_F_C5_25_"
  },
  {
    "name": "_F_C10_25_",
    "typeName": "string",
    "targetPropertyName": "_F_C10_25_"
  },
  {
    "name": "_F_C20_25_",
    "typeName": "string",
    "targetPropertyName": "_F_C20_25_"
  },
  {
    "name": "_F_C50_25_",
    "typeName": "string",
    "targetPropertyName": "_F_C50_25_"
  },
  {
    "name": "_F_B_26_",
    "typeName": "bool",
    "targetPropertyName": "_F_B_26_"
  },
  {
    "name": "_F_I_26_",
    "typeName": "int",
    "targetPropertyName": "_F_I_26_"
  },
  {
    "name": "_F_L_26_",
    "typeName": "long",
    "targetPropertyName": "_F_L_26_"
  },
  {
    "name": "_F_N_26_",
    "typeName": "decimal",
    "targetPropertyName": "_F_N_26_"
  },
  {
    "name": "_F_C5_26_",
    "typeName": "string",
    "targetPropertyName": "_F_C5_26_"
  },
  {
    "name": "_F_C10_26_",
    "typeName": "string",
    "targetPropertyName": "_F_C10_26_"
  },
  {
    "name": "_F_C20_26_",
    "typeName": "string",
    "targetPropertyName": "_F_C20_26_"
  },
  {
    "name": "_F_C50_26_",
    "typeName": "string",
    "targetPropertyName": "_F_C50_26_"
  },
  {
    "name": "_F_B_27_",
    "typeName": "bool",
    "targetPropertyName": "_F_B_27_"
  },
  {
    "name": "_F_I_27_",
    "typeName": "int",
    "targetPropertyName": "_F_I_27_"
  },
  {
    "name": "_F_L_27_",
    "typeName": "long",
    "targetPropertyName": "_F_L_27_"
  },
  {
    "name": "_F_N_27_",
    "typeName": "decimal",
    "targetPropertyName": "_F_N_27_"
  },
  {
    "name": "_F_C5_27_",
    "typeName": "string",
    "targetPropertyName": "_F_C5_27_"
  },
  {
    "name": "_F_C10_27_",
    "typeName": "string",
    "targetPropertyName": "_F_C10_27_"
  },
  {
    "name": "_F_C20_27_",
    "typeName": "string",
    "targetPropertyName": "_F_C20_27_"
  },
  {
    "name": "_F_C50_27_",
    "typeName": "string",
    "targetPropertyName": "_F_C50_27_"
  },
  {
    "name": "_F_B_28_",
    "typeName": "bool",
    "targetPropertyName": "_F_B_28_"
  },
  {
    "name": "_F_I_28_",
    "typeName": "int",
    "targetPropertyName": "_F_I_28_"
  },
  {
    "name": "_F_L_28_",
    "typeName": "long",
    "targetPropertyName": "_F_L_28_"
  },
  {
    "name": "_F_N_28_",
    "typeName": "decimal",
    "targetPropertyName": "_F_N_28_"
  },
  {
    "name": "_F_C5_28_",
    "typeName": "string",
    "targetPropertyName": "_F_C5_28_"
  },
  {
    "name": "_F_C10_28_",
    "typeName": "string",
    "targetPropertyName": "_F_C10_28_"
  },
  {
    "name": "_F_C20_28_",
    "typeName": "string",
    "targetPropertyName": "_F_C20_28_"
  },
  {
    "name": "_F_C50_28_",
    "typeName": "string",
    "targetPropertyName": "_F_C50_28_"
  },
  {
    "name": "_F_B_29_",
    "typeName": "bool",
    "targetPropertyName": "_F_B_29_"
  },
  {
    "name": "_F_I_29_",
    "typeName": "int",
    "targetPropertyName": "_F_I_29_"
  },
  {
    "name": "_F_L_29_",
    "typeName": "long",
    "targetPropertyName": "_F_L_29_"
  },
  {
    "name": "_F_N_29_",
    "typeName": "decimal",
    "targetPropertyName": "_F_N_29_"
  },
  {
    "name": "_F_C5_29_",
    "typeName": "string",
    "targetPropertyName": "_F_C5_29_"
  },
  {
    "name": "_F_C10_29_",
    "typeName": "string",
    "targetPropertyName": "_F_C10_29_"
  },
  {
    "name": "_F_C20_29_",
    "typeName": "string",
    "targetPropertyName": "_F_C20_29_"
  },
  {
    "name": "_F_C50_29_",
    "typeName": "string",
    "targetPropertyName": "_F_C50_29_"
  },
  {
    "name": "_F_B_30_",
    "typeName": "bool",
    "targetPropertyName": "_F_B_30_"
  },
  {
    "name": "_F_I_30_",
    "typeName": "int",
    "targetPropertyName": "_F_I_30_"
  },
  {
    "name": "_F_N_30_",
    "typeName": "decimal",
    "targetPropertyName": "_F_N_30_"
  },
  {
    "name": "_F_C5_30_",
    "typeName": "string",
    "targetPropertyName": "_F_C5_30_"
  },
  {
    "name": "_F_C10_30_",
    "typeName": "string",
    "targetPropertyName": "_F_C10_30_"
  },
  {
    "name": "_F_C20_30_",
    "typeName": "string",
    "targetPropertyName": "_F_C20_30_"
  },
  {
    "name": "_F_C50_30_",
    "typeName": "string",
    "targetPropertyName": "_F_C50_30_"
  },
  {
    "name": "_F_B_31_",
    "typeName": "bool",
    "targetPropertyName": "_F_B_31_"
  },
  {
    "name": "_F_I_31_",
    "typeName": "int",
    "targetPropertyName": "_F_I_31_"
  },
  {
    "name": "_F_N_31_",
    "typeName": "decimal",
    "targetPropertyName": "_F_N_31_"
  },
  {
    "name": "_F_C5_31_",
    "typeName": "string",
    "targetPropertyName": "_F_C5_31_"
  },
  {
    "name": "_F_C10_31_",
    "typeName": "string",
    "targetPropertyName": "_F_C10_31_"
  },
  {
    "name": "_F_C20_31_",
    "typeName": "string",
    "targetPropertyName": "_F_C20_31_"
  },
  {
    "name": "_F_C50_31_",
    "typeName": "string",
    "targetPropertyName": "_F_C50_31_"
  },
  {
    "name": "_F_B_32_",
    "typeName": "bool",
    "targetPropertyName": "_F_B_32_"
  },
  {
    "name": "_F_I_32_",
    "typeName": "int",
    "targetPropertyName": "_F_I_32_"
  },
  {
    "name": "_F_N_32_",
    "typeName": "decimal",
    "targetPropertyName": "_F_N_32_"
  },
  {
    "name": "_F_C5_32_",
    "typeName": "string",
    "targetPropertyName": "_F_C5_32_"
  },
  {
    "name": "_F_C10_32_",
    "typeName": "string",
    "targetPropertyName": "_F_C10_32_"
  },
  {
    "name": "_F_C20_32_",
    "typeName": "string",
    "targetPropertyName": "_F_C20_32_"
  },
  {
    "name": "_F_C50_32_",
    "typeName": "string",
    "targetPropertyName": "_F_C50_32_"
  },
  {
    "name": "_F_B_33_",
    "typeName": "bool",
    "targetPropertyName": "_F_B_33_"
  },
  {
    "name": "_F_I_33_",
    "typeName": "int",
    "targetPropertyName": "_F_I_33_"
  },
  {
    "name": "_F_N_33_",
    "typeName": "decimal",
    "targetPropertyName": "_F_N_33_"
  },
  {
    "name": "_F_C5_33_",
    "typeName": "string",
    "targetPropertyName": "_F_C5_33_"
  },
  {
    "name": "_F_C10_33_",
    "typeName": "string",
    "targetPropertyName": "_F_C10_33_"
  },
  {
    "name": "_F_C20_33_",
    "typeName": "string",
    "targetPropertyName": "_F_C20_33_"
  },
  {
    "name": "_F_C50_33_",
    "typeName": "string",
    "targetPropertyName": "_F_C50_33_"
  },
  {
    "name": "_F_B_34_",
    "typeName": "bool",
    "targetPropertyName": "_F_B_34_"
  },
  {
    "name": "_F_I_34_",
    "typeName": "int",
    "targetPropertyName": "_F_I_34_"
  },
  {
    "name": "_F_N_34_",
    "typeName": "decimal",
    "targetPropertyName": "_F_N_34_"
  },
  {
    "name": "_F_C5_34_",
    "typeName": "string",
    "targetPropertyName": "_F_C5_34_"
  },
  {
    "name": "_F_C10_34_",
    "typeName": "string",
    "targetPropertyName": "_F_C10_34_"
  },
  {
    "name": "_F_C20_34_",
    "typeName": "string",
    "targetPropertyName": "_F_C20_34_"
  },
  {
    "name": "_F_C50_34_",
    "typeName": "string",
    "targetPropertyName": "_F_C50_34_"
  },
  {
    "name": "_F_B_35_",
    "typeName": "bool",
    "targetPropertyName": "_F_B_35_"
  },
  {
    "name": "_F_I_35_",
    "typeName": "int",
    "targetPropertyName": "_F_I_35_"
  },
  {
    "name": "_F_N_35_",
    "typeName": "decimal",
    "targetPropertyName": "_F_N_35_"
  },
  {
    "name": "_F_C5_35_",
    "typeName": "string",
    "targetPropertyName": "_F_C5_35_"
  },
  {
    "name": "_F_C10_35_",
    "typeName": "string",
    "targetPropertyName": "_F_C10_35_"
  },
  {
    "name": "_F_C20_35_",
    "typeName": "string",
    "targetPropertyName": "_F_C20_35_"
  },
  {
    "name": "_F_C50_35_",
    "typeName": "string",
    "targetPropertyName": "_F_C50_35_"
  },
  {
    "name": "_F_B_36_",
    "typeName": "bool",
    "targetPropertyName": "_F_B_36_"
  },
  {
    "name": "_F_I_36_",
    "typeName": "int",
    "targetPropertyName": "_F_I_36_"
  },
  {
    "name": "_F_N_36_",
    "typeName": "decimal",
    "targetPropertyName": "_F_N_36_"
  },
  {
    "name": "_F_C5_36_",
    "typeName": "string",
    "targetPropertyName": "_F_C5_36_"
  },
  {
    "name": "_F_C10_36_",
    "typeName": "string",
    "targetPropertyName": "_F_C10_36_"
  },
  {
    "name": "_F_C20_36_",
    "typeName": "string",
    "targetPropertyName": "_F_C20_36_"
  },
  {
    "name": "_F_C50_36_",
    "typeName": "string",
    "targetPropertyName": "_F_C50_36_"
  },
  {
    "name": "_F_B_37_",
    "typeName": "bool",
    "targetPropertyName": "_F_B_37_"
  },
  {
    "name": "_F_I_37_",
    "typeName": "int",
    "targetPropertyName": "_F_I_37_"
  },
  {
    "name": "_F_N_37_",
    "typeName": "decimal",
    "targetPropertyName": "_F_N_37_"
  },
  {
    "name": "_F_C5_37_",
    "typeName": "string",
    "targetPropertyName": "_F_C5_37_"
  },
  {
    "name": "_F_C10_37_",
    "typeName": "string",
    "targetPropertyName": "_F_C10_37_"
  },
  {
    "name": "_F_C20_37_",
    "typeName": "string",
    "targetPropertyName": "_F_C20_37_"
  },
  {
    "name": "_F_C50_37_",
    "typeName": "string",
    "targetPropertyName": "_F_C50_37_"
  },
  {
    "name": "_F_B_38_",
    "typeName": "bool",
    "targetPropertyName": "_F_B_38_"
  },
  {
    "name": "_F_I_38_",
    "typeName": "int",
    "targetPropertyName": "_F_I_38_"
  },
  {
    "name": "_F_N_38_",
    "typeName": "decimal",
    "targetPropertyName": "_F_N_38_"
  },
  {
    "name": "_F_C5_38_",
    "typeName": "string",
    "targetPropertyName": "_F_C5_38_"
  },
  {
    "name": "_F_C10_38_",
    "typeName": "string",
    "targetPropertyName": "_F_C10_38_"
  },
  {
    "name": "_F_C20_38_",
    "typeName": "string",
    "targetPropertyName": "_F_C20_38_"
  },
  {
    "name": "_F_C50_38_",
    "typeName": "string",
    "targetPropertyName": "_F_C50_38_"
  },
  {
    "name": "_F_B_39_",
    "typeName": "bool",
    "targetPropertyName": "_F_B_39_"
  },
  {
    "name": "_F_I_39_",
    "typeName": "int",
    "targetPropertyName": "_F_I_39_"
  },
  {
    "name": "_F_N_39_",
    "typeName": "decimal",
    "targetPropertyName": "_F_N_39_"
  },
  {
    "name": "_F_C5_39_",
    "typeName": "string",
    "targetPropertyName": "_F_C5_39_"
  },
  {
    "name": "_F_C10_39_",
    "typeName": "string",
    "targetPropertyName": "_F_C10_39_"
  },
  {
    "name": "_F_C20_39_",
    "typeName": "string",
    "targetPropertyName": "_F_C20_39_"
  },
  {
    "name": "_F_C50_39_",
    "typeName": "string",
    "targetPropertyName": "_F_C50_39_"
  },
  {
    "name": "_F_B_40_",
    "typeName": "bool",
    "targetPropertyName": "_F_B_40_"
  },
  {
    "name": "_F_I_40_",
    "typeName": "int",
    "targetPropertyName": "_F_I_40_"
  },
  {
    "name": "_F_N_40_",
    "typeName": "decimal",
    "targetPropertyName": "_F_N_40_"
  },
  {
    "name": "_F_C5_40_",
    "typeName": "string",
    "targetPropertyName": "_F_C5_40_"
  },
  {
    "name": "_F_C10_40_",
    "typeName": "string",
    "targetPropertyName": "_F_C10_40_"
  },
  {
    "name": "_F_C20_40_",
    "typeName": "string",
    "targetPropertyName": "_F_C20_40_"
  },
  {
    "name": "_F_C50_40_",
    "typeName": "string",
    "targetPropertyName": "_F_C50_40_"
  },
  {
    "name": "_F_B_41_",
    "typeName": "bool",
    "targetPropertyName": "_F_B_41_"
  },
  {
    "name": "_F_I_41_",
    "typeName": "int",
    "targetPropertyName": "_F_I_41_"
  },
  {
    "name": "_F_N_41_",
    "typeName": "decimal",
    "targetPropertyName": "_F_N_41_"
  },
  {
    "name": "_F_C5_41_",
    "typeName": "string",
    "targetPropertyName": "_F_C5_41_"
  },
  {
    "name": "_F_C10_41_",
    "typeName": "string",
    "targetPropertyName": "_F_C10_41_"
  },
  {
    "name": "_F_C20_41_",
    "typeName": "string",
    "targetPropertyName": "_F_C20_41_"
  },
  {
    "name": "_F_C50_41_",
    "typeName": "string",
    "targetPropertyName": "_F_C50_41_"
  },
  {
    "name": "_F_B_42_",
    "typeName": "bool",
    "targetPropertyName": "_F_B_42_"
  },
  {
    "name": "_F_I_42_",
    "typeName": "int",
    "targetPropertyName": "_F_I_42_"
  },
  {
    "name": "_F_N_42_",
    "typeName": "decimal",
    "targetPropertyName": "_F_N_42_"
  },
  {
    "name": "_F_C5_42_",
    "typeName": "string",
    "targetPropertyName": "_F_C5_42_"
  },
  {
    "name": "_F_C10_42_",
    "typeName": "string",
    "targetPropertyName": "_F_C10_42_"
  },
  {
    "name": "_F_C20_42_",
    "typeName": "string",
    "targetPropertyName": "_F_C20_42_"
  },
  {
    "name": "_F_C50_42_",
    "typeName": "string",
    "targetPropertyName": "_F_C50_42_"
  },
  {
    "name": "_F_B_43_",
    "typeName": "bool",
    "targetPropertyName": "_F_B_43_"
  },
  {
    "name": "_F_I_43_",
    "typeName": "int",
    "targetPropertyName": "_F_I_43_"
  },
  {
    "name": "_F_N_43_",
    "typeName": "decimal",
    "targetPropertyName": "_F_N_43_"
  },
  {
    "name": "_F_C5_43_",
    "typeName": "string",
    "targetPropertyName": "_F_C5_43_"
  },
  {
    "name": "_F_C10_43_",
    "typeName": "string",
    "targetPropertyName": "_F_C10_43_"
  },
  {
    "name": "_F_C20_43_",
    "typeName": "string",
    "targetPropertyName": "_F_C20_43_"
  },
  {
    "name": "_F_C50_43_",
    "typeName": "string",
    "targetPropertyName": "_F_C50_43_"
  },
  {
    "name": "_F_B_44_",
    "typeName": "bool",
    "targetPropertyName": "_F_B_44_"
  },
  {
    "name": "_F_I_44_",
    "typeName": "int",
    "targetPropertyName": "_F_I_44_"
  },
  {
    "name": "_F_N_44_",
    "typeName": "decimal",
    "targetPropertyName": "_F_N_44_"
  },
  {
    "name": "_F_C5_44_",
    "typeName": "string",
    "targetPropertyName": "_F_C5_44_"
  },
  {
    "name": "_F_C10_44_",
    "typeName": "string",
    "targetPropertyName": "_F_C10_44_"
  },
  {
    "name": "_F_C20_44_",
    "typeName": "string",
    "targetPropertyName": "_F_C20_44_"
  },
  {
    "name": "_F_C50_44_",
    "typeName": "string",
    "targetPropertyName": "_F_C50_44_"
  },
  {
    "name": "_F_B_45_",
    "typeName": "bool",
    "targetPropertyName": "_F_B_45_"
  },
  {
    "name": "_F_I_45_",
    "typeName": "int",
    "targetPropertyName": "_F_I_45_"
  },
  {
    "name": "_F_N_45_",
    "typeName": "decimal",
    "targetPropertyName": "_F_N_45_"
  },
  {
    "name": "_F_C5_45_",
    "typeName": "string",
    "targetPropertyName": "_F_C5_45_"
  },
  {
    "name": "_F_C10_45_",
    "typeName": "string",
    "targetPropertyName": "_F_C10_45_"
  },
  {
    "name": "_F_C20_45_",
    "typeName": "string",
    "targetPropertyName": "_F_C20_45_"
  },
  {
    "name": "_F_C50_45_",
    "typeName": "string",
    "targetPropertyName": "_F_C50_45_"
  },
  {
    "name": "_F_B_46_",
    "typeName": "bool",
    "targetPropertyName": "_F_B_46_"
  },
  {
    "name": "_F_I_46_",
    "typeName": "int",
    "targetPropertyName": "_F_I_46_"
  },
  {
    "name": "_F_N_46_",
    "typeName": "decimal",
    "targetPropertyName": "_F_N_46_"
  },
  {
    "name": "_F_C5_46_",
    "typeName": "string",
    "targetPropertyName": "_F_C5_46_"
  },
  {
    "name": "_F_C10_46_",
    "typeName": "string",
    "targetPropertyName": "_F_C10_46_"
  },
  {
    "name": "_F_C20_46_",
    "typeName": "string",
    "targetPropertyName": "_F_C20_46_"
  },
  {
    "name": "_F_C50_46_",
    "typeName": "string",
    "targetPropertyName": "_F_C50_46_"
  },
  {
    "name": "_F_B_47_",
    "typeName": "bool",
    "targetPropertyName": "_F_B_47_"
  },
  {
    "name": "_F_I_47_",
    "typeName": "int",
    "targetPropertyName": "_F_I_47_"
  },
  {
    "name": "_F_N_47_",
    "typeName": "decimal",
    "targetPropertyName": "_F_N_47_"
  },
  {
    "name": "_F_C5_47_",
    "typeName": "string",
    "targetPropertyName": "_F_C5_47_"
  },
  {
    "name": "_F_C10_47_",
    "typeName": "string",
    "targetPropertyName": "_F_C10_47_"
  },
  {
    "name": "_F_C20_47_",
    "typeName": "string",
    "targetPropertyName": "_F_C20_47_"
  },
  {
    "name": "_F_C50_47_",
    "typeName": "string",
    "targetPropertyName": "_F_C50_47_"
  },
  {
    "name": "_F_B_48_",
    "typeName": "bool",
    "targetPropertyName": "_F_B_48_"
  },
  {
    "name": "_F_I_48_",
    "typeName": "int",
    "targetPropertyName": "_F_I_48_"
  },
  {
    "name": "_F_N_48_",
    "typeName": "decimal",
    "targetPropertyName": "_F_N_48_"
  },
  {
    "name": "_F_C5_48_",
    "typeName": "string",
    "targetPropertyName": "_F_C5_48_"
  },
  {
    "name": "_F_C10_48_",
    "typeName": "string",
    "targetPropertyName": "_F_C10_48_"
  },
  {
    "name": "_F_C20_48_",
    "typeName": "string",
    "targetPropertyName": "_F_C20_48_"
  },
  {
    "name": "_F_C50_48_",
    "typeName": "string",
    "targetPropertyName": "_F_C50_48_"
  },
  {
    "name": "_F_B_49_",
    "typeName": "bool",
    "targetPropertyName": "_F_B_49_"
  },
  {
    "name": "_F_I_49_",
    "typeName": "int",
    "targetPropertyName": "_F_I_49_"
  },
  {
    "name": "_F_N_49_",
    "typeName": "decimal",
    "targetPropertyName": "_F_N_49_"
  },
  {
    "name": "_F_C5_49_",
    "typeName": "string",
    "targetPropertyName": "_F_C5_49_"
  },
  {
    "name": "_F_C10_49_",
    "typeName": "string",
    "targetPropertyName": "_F_C10_49_"
  },
  {
    "name": "_F_C20_49_",
    "typeName": "string",
    "targetPropertyName": "_F_C20_49_"
  },
  {
    "name": "_F_C50_49_",
    "typeName": "string",
    "targetPropertyName": "_F_C50_49_"
  },
  {
    "name": "Version",
    "typeName": "long",
    "targetPropertyName": "version"
  },
  {
    "name": "CreatedBy",
    "typeName": "string",
    "targetPropertyName": "createdBy"
  },
  {
    "name": "CreatedAt",
    "typeName": "DateTime",
    "targetPropertyName": "createdAt"
  },
  {
    "name": "UpdatedBy",
    "typeName": "string",
    "targetPropertyName": "updatedBy"
  },
  {
    "name": "UpdatedAt",
    "typeName": "DateTime",
    "targetPropertyName": "updatedAt"
  },
  {
    "name": "Active",
    "typeName": "bool",
    "targetPropertyName": "active"
  },
  {
    "name": "Deleted",
    "typeName": "bool",
    "targetPropertyName": "deleted"
  }
]


  },
  {
    "name": "AttributeSetInstanceExtensionFieldGroup",
    "plural": "AttributeSetInstanceExtensionFieldGroups",
    "label": "Attribute Set Instance Extension Field Group",
    "collectionLabel": "Attribute Set Instance Extension Field Groups",
    "id": {
  "name": "id",
  "label": "Id",
  "type": "string"
},
    "properties": [ {
  "name": "fieldType",
  "label": "Field Type",
  "type": "string"
}, {
  "name": "fieldLength",
  "label": "Field Length",
  "type": "int?"
}, {
  "name": "fieldCount",
  "label": "Field Count",
  "type": "int"
}, {
  "name": "nameFormat",
  "label": "Name Format",
  "type": "string"
}, {
  "name": "description",
  "label": "Description",
  "type": "string"
}, {
  "name": "version",
  "label": "Version",
  "type": "long"
}, {
  "name": "createdBy",
  "label": "Created By",
  "type": "string"
}, {
  "name": "createdAt",
  "label": "Created At",
  "type": "DateTime"
}, {
  "name": "updatedBy",
  "label": "Updated By",
  "type": "string"
}, {
  "name": "updatedAt",
  "label": "Updated At",
  "type": "DateTime"
}, {
  "name": "active",
  "label": "Active",
  "type": "bool"
}, {
  "name": "deleted",
  "label": "Deleted",
  "type": "bool"
}, {
  "name": "fields",
  "label": "Fields",
  "itemType": "AttributeSetInstanceExtensionField"
} ]


, filteringProperties: [
  {
    "name": "Id",
    "typeName": "string",
    "targetPropertyName": "id"
  },
  {
    "name": "FieldType",
    "typeName": "string",
    "targetPropertyName": "fieldType"
  },
  {
    "name": "FieldLength",
    "typeName": "int",
    "targetPropertyName": "fieldLength"
  },
  {
    "name": "FieldCount",
    "typeName": "int",
    "targetPropertyName": "fieldCount"
  },
  {
    "name": "NameFormat",
    "typeName": "string",
    "targetPropertyName": "nameFormat"
  },
  {
    "name": "Description",
    "typeName": "string",
    "targetPropertyName": "description"
  },
  {
    "name": "Version",
    "typeName": "long",
    "targetPropertyName": "version"
  },
  {
    "name": "CreatedBy",
    "typeName": "string",
    "targetPropertyName": "createdBy"
  },
  {
    "name": "CreatedAt",
    "typeName": "DateTime",
    "targetPropertyName": "createdAt"
  },
  {
    "name": "UpdatedBy",
    "typeName": "string",
    "targetPropertyName": "updatedBy"
  },
  {
    "name": "UpdatedAt",
    "typeName": "DateTime",
    "targetPropertyName": "updatedAt"
  },
  {
    "name": "Active",
    "typeName": "bool",
    "targetPropertyName": "active"
  },
  {
    "name": "Deleted",
    "typeName": "bool",
    "targetPropertyName": "deleted"
  }
]


    ,"entities": [
      {
        "name": "AttributeSetInstanceExtensionField",
        "plural": "AttributeSetInstanceExtensionFields",
        "label": "Attribute Set Instance Extension Field",
        "collectionLabel": "Attribute Set Instance Extension Fields",
        "id": {
  "name": "index",
  "label": "Index",
  "type": "string"
},
        "properties": [ {
  "name": "name",
  "label": "Name",
  "type": "string"
}, {
  "name": "type",
  "label": "Type",
  "type": "string"
}, {
  "name": "length",
  "label": "Length",
  "type": "int?"
}, {
  "name": "alias",
  "label": "Alias",
  "type": "string"
}, {
  "name": "description",
  "label": "Description",
  "type": "string"
}, {
  "name": "version",
  "label": "Version",
  "type": "long"
}, {
  "name": "createdBy",
  "label": "Created By",
  "type": "string"
}, {
  "name": "createdAt",
  "label": "Created At",
  "type": "DateTime"
}, {
  "name": "updatedBy",
  "label": "Updated By",
  "type": "string"
}, {
  "name": "updatedAt",
  "label": "Updated At",
  "type": "DateTime"
}, {
  "name": "active",
  "label": "Active",
  "type": "bool"
}, {
  "name": "deleted",
  "label": "Deleted",
  "type": "bool"
} ]



      }
    ]
  },
  {
    "name": "AttributeValueMvo",
    "plural": "AttributeValueMvos",
    "label": "Attribute Value Mvo",
    "collectionLabel": "Attribute Value Mvos",
    "id": {
  "name": "attributeValueId",
  "label": "Attribute Value Id",
  "type": "AttributeValueId"
},
    "properties": [ {
  "name": "name",
  "label": "Name",
  "type": "string"
}, {
  "name": "description",
  "label": "Description",
  "type": "string"
}, {
  "name": "referenceId",
  "label": "Reference Id",
  "type": "string"
}, {
  "name": "version",
  "label": "Version",
  "type": "long"
}, {
  "name": "createdBy",
  "label": "Created By",
  "type": "string"
}, {
  "name": "createdAt",
  "label": "Created At",
  "type": "DateTime"
}, {
  "name": "updatedBy",
  "label": "Updated By",
  "type": "string"
}, {
  "name": "updatedAt",
  "label": "Updated At",
  "type": "DateTime"
}, {
  "name": "active",
  "label": "Active",
  "type": "bool"
}, {
  "name": "deleted",
  "label": "Deleted",
  "type": "bool"
}, {
  "name": "attributeName",
  "label": "Attribute Name",
  "type": "string"
}, {
  "name": "attributeOrganizationId",
  "label": "Attribute Organization Id",
  "type": "string"
}, {
  "name": "attributeDescription",
  "label": "Attribute Description",
  "type": "string"
}, {
  "name": "attributeIsMandatory",
  "label": "Attribute Is Mandatory",
  "type": "bool"
}, {
  "name": "attributeIsInstanceAttribute",
  "label": "Attribute Is Instance Attribute",
  "type": "bool"
}, {
  "name": "attributeAttributeValueType",
  "label": "Attribute Attribute Value Type",
  "type": "string"
}, {
  "name": "attributeAttributeValueLength",
  "label": "Attribute Attribute Value Length",
  "type": "int?"
}, {
  "name": "attributeIsList",
  "label": "Attribute Is List",
  "type": "bool"
}, {
  "name": "attributeFieldName",
  "label": "Attribute Field Name",
  "type": "string"
}, {
  "name": "attributeReferenceId",
  "label": "Attribute Reference Id",
  "type": "string"
}, {
  "name": "attributeVersion",
  "label": "Attribute Version",
  "type": "long"
}, {
  "name": "attributeCreatedBy",
  "label": "Attribute Created By",
  "type": "string"
}, {
  "name": "attributeCreatedAt",
  "label": "Attribute Created At",
  "type": "DateTime"
}, {
  "name": "attributeUpdatedBy",
  "label": "Attribute Updated By",
  "type": "string"
}, {
  "name": "attributeUpdatedAt",
  "label": "Attribute Updated At",
  "type": "DateTime"
}, {
  "name": "attributeActive",
  "label": "Attribute Active",
  "type": "bool"
}, {
  "name": "attributeDeleted",
  "label": "Attribute Deleted",
  "type": "bool"
} ]


, filteringProperties: [
  {
    "name": "Name",
    "typeName": "string",
    "targetPropertyName": "name"
  },
  {
    "name": "Description",
    "typeName": "string",
    "targetPropertyName": "description"
  },
  {
    "name": "ReferenceId",
    "typeName": "string",
    "targetPropertyName": "referenceId"
  },
  {
    "name": "Version",
    "typeName": "long",
    "targetPropertyName": "version"
  },
  {
    "name": "CreatedBy",
    "typeName": "string",
    "targetPropertyName": "createdBy"
  },
  {
    "name": "CreatedAt",
    "typeName": "DateTime",
    "targetPropertyName": "createdAt"
  },
  {
    "name": "UpdatedBy",
    "typeName": "string",
    "targetPropertyName": "updatedBy"
  },
  {
    "name": "UpdatedAt",
    "typeName": "DateTime",
    "targetPropertyName": "updatedAt"
  },
  {
    "name": "Active",
    "typeName": "bool",
    "targetPropertyName": "active"
  },
  {
    "name": "Deleted",
    "typeName": "bool",
    "targetPropertyName": "deleted"
  },
  {
    "name": "AttributeName",
    "typeName": "string",
    "targetPropertyName": "attributeName"
  },
  {
    "name": "AttributeOrganizationId",
    "typeName": "string",
    "targetPropertyName": "attributeOrganizationId"
  },
  {
    "name": "AttributeDescription",
    "typeName": "string",
    "targetPropertyName": "attributeDescription"
  },
  {
    "name": "AttributeIsMandatory",
    "typeName": "bool",
    "targetPropertyName": "attributeIsMandatory"
  },
  {
    "name": "AttributeIsInstanceAttribute",
    "typeName": "bool",
    "targetPropertyName": "attributeIsInstanceAttribute"
  },
  {
    "name": "AttributeAttributeValueType",
    "typeName": "string",
    "targetPropertyName": "attributeAttributeValueType"
  },
  {
    "name": "AttributeAttributeValueLength",
    "typeName": "int",
    "targetPropertyName": "attributeAttributeValueLength"
  },
  {
    "name": "AttributeIsList",
    "typeName": "bool",
    "targetPropertyName": "attributeIsList"
  },
  {
    "name": "AttributeFieldName",
    "typeName": "string",
    "targetPropertyName": "attributeFieldName"
  },
  {
    "name": "AttributeReferenceId",
    "typeName": "string",
    "targetPropertyName": "attributeReferenceId"
  },
  {
    "name": "AttributeVersion",
    "typeName": "long",
    "targetPropertyName": "attributeVersion"
  },
  {
    "name": "AttributeCreatedBy",
    "typeName": "string",
    "targetPropertyName": "attributeCreatedBy"
  },
  {
    "name": "AttributeCreatedAt",
    "typeName": "DateTime",
    "targetPropertyName": "attributeCreatedAt"
  },
  {
    "name": "AttributeUpdatedBy",
    "typeName": "string",
    "targetPropertyName": "attributeUpdatedBy"
  },
  {
    "name": "AttributeUpdatedAt",
    "typeName": "DateTime",
    "targetPropertyName": "attributeUpdatedAt"
  },
  {
    "name": "AttributeActive",
    "typeName": "bool",
    "targetPropertyName": "attributeActive"
  },
  {
    "name": "AttributeDeleted",
    "typeName": "bool",
    "targetPropertyName": "attributeDeleted"
  },
  {
    "name": "AttributeValueId.AttributeId",
    "typeName": "string",
    "targetPropertyName": "attributeValueId.attributeId"
  },
  {
    "name": "AttributeValueId.Value",
    "typeName": "string",
    "targetPropertyName": "attributeValueId.value"
  }
]
, reservedProperties: {
  "version": "attributeVersion"
}

  },
  {
    "name": "AttributeUseMvo",
    "plural": "AttributeUseMvos",
    "label": "Attribute Use Mvo",
    "collectionLabel": "Attribute Use Mvos",
    "id": {
  "name": "attributeSetAttributeUseId",
  "label": "Attribute Set Attribute Use Id",
  "type": "AttributeSetAttributeUseId"
},
    "properties": [ {
  "name": "sequenceNumber",
  "label": "Sequence Number",
  "type": "int"
}, {
  "name": "version",
  "label": "Version",
  "type": "long"
}, {
  "name": "createdBy",
  "label": "Created By",
  "type": "string"
}, {
  "name": "createdAt",
  "label": "Created At",
  "type": "DateTime"
}, {
  "name": "updatedBy",
  "label": "Updated By",
  "type": "string"
}, {
  "name": "updatedAt",
  "label": "Updated At",
  "type": "DateTime"
}, {
  "name": "active",
  "label": "Active",
  "type": "bool"
}, {
  "name": "deleted",
  "label": "Deleted",
  "type": "bool"
}, {
  "name": "attributeSetName",
  "label": "Attribute Set Name",
  "type": "string"
}, {
  "name": "attributeSetOrganizationId",
  "label": "Attribute Set Organization Id",
  "type": "string"
}, {
  "name": "attributeSetDescription",
  "label": "Attribute Set Description",
  "type": "string"
}, {
  "name": "attributeSetSerialNumberAttributeId",
  "label": "Attribute Set Serial Number Attribute Id",
  "type": "string"
}, {
  "name": "attributeSetLotAttributeId",
  "label": "Attribute Set Lot Attribute Id",
  "type": "string"
}, {
  "name": "attributeSetReferenceId",
  "label": "Attribute Set Reference Id",
  "type": "string"
}, {
  "name": "attributeSetVersion",
  "label": "Attribute Set Version",
  "type": "long"
}, {
  "name": "attributeSetCreatedBy",
  "label": "Attribute Set Created By",
  "type": "string"
}, {
  "name": "attributeSetCreatedAt",
  "label": "Attribute Set Created At",
  "type": "DateTime"
}, {
  "name": "attributeSetUpdatedBy",
  "label": "Attribute Set Updated By",
  "type": "string"
}, {
  "name": "attributeSetUpdatedAt",
  "label": "Attribute Set Updated At",
  "type": "DateTime"
}, {
  "name": "attributeSetActive",
  "label": "Attribute Set Active",
  "type": "bool"
}, {
  "name": "attributeSetDeleted",
  "label": "Attribute Set Deleted",
  "type": "bool"
} ]


, filteringProperties: [
  {
    "name": "SequenceNumber",
    "typeName": "int",
    "targetPropertyName": "sequenceNumber"
  },
  {
    "name": "Version",
    "typeName": "long",
    "targetPropertyName": "version"
  },
  {
    "name": "CreatedBy",
    "typeName": "string",
    "targetPropertyName": "createdBy"
  },
  {
    "name": "CreatedAt",
    "typeName": "DateTime",
    "targetPropertyName": "createdAt"
  },
  {
    "name": "UpdatedBy",
    "typeName": "string",
    "targetPropertyName": "updatedBy"
  },
  {
    "name": "UpdatedAt",
    "typeName": "DateTime",
    "targetPropertyName": "updatedAt"
  },
  {
    "name": "Active",
    "typeName": "bool",
    "targetPropertyName": "active"
  },
  {
    "name": "Deleted",
    "typeName": "bool",
    "targetPropertyName": "deleted"
  },
  {
    "name": "AttributeSetName",
    "typeName": "string",
    "targetPropertyName": "attributeSetName"
  },
  {
    "name": "AttributeSetOrganizationId",
    "typeName": "string",
    "targetPropertyName": "attributeSetOrganizationId"
  },
  {
    "name": "AttributeSetDescription",
    "typeName": "string",
    "targetPropertyName": "attributeSetDescription"
  },
  {
    "name": "AttributeSetSerialNumberAttributeId",
    "typeName": "string",
    "targetPropertyName": "attributeSetSerialNumberAttributeId"
  },
  {
    "name": "AttributeSetLotAttributeId",
    "typeName": "string",
    "targetPropertyName": "attributeSetLotAttributeId"
  },
  {
    "name": "AttributeSetReferenceId",
    "typeName": "string",
    "targetPropertyName": "attributeSetReferenceId"
  },
  {
    "name": "AttributeSetVersion",
    "typeName": "long",
    "targetPropertyName": "attributeSetVersion"
  },
  {
    "name": "AttributeSetCreatedBy",
    "typeName": "string",
    "targetPropertyName": "attributeSetCreatedBy"
  },
  {
    "name": "AttributeSetCreatedAt",
    "typeName": "DateTime",
    "targetPropertyName": "attributeSetCreatedAt"
  },
  {
    "name": "AttributeSetUpdatedBy",
    "typeName": "string",
    "targetPropertyName": "attributeSetUpdatedBy"
  },
  {
    "name": "AttributeSetUpdatedAt",
    "typeName": "DateTime",
    "targetPropertyName": "attributeSetUpdatedAt"
  },
  {
    "name": "AttributeSetActive",
    "typeName": "bool",
    "targetPropertyName": "attributeSetActive"
  },
  {
    "name": "AttributeSetDeleted",
    "typeName": "bool",
    "targetPropertyName": "attributeSetDeleted"
  },
  {
    "name": "AttributeSetAttributeUseId.AttributeSetId",
    "typeName": "string",
    "targetPropertyName": "attributeSetAttributeUseId.attributeSetId"
  },
  {
    "name": "AttributeSetAttributeUseId.AttributeId",
    "typeName": "string",
    "targetPropertyName": "attributeSetAttributeUseId.attributeId"
  }
]
, reservedProperties: {
  "version": "attributeSetVersion"
}

  },
  {
    "name": "InOutLineMvo",
    "plural": "InOutLineMvos",
    "label": "In Out Line Mvo",
    "collectionLabel": "In Out Line Mvos",
    "id": {
  "name": "inOutLineId",
  "label": "In Out Line Id",
  "type": "InOutLineId"
},
    "properties": [ {
  "name": "description",
  "label": "Description",
  "type": "string"
}, {
  "name": "locatorId",
  "label": "Locator Id",
  "type": "string"
}, {
  "name": "productId",
  "label": "Product Id",
  "type": "string"
}, {
  "name": "uomId",
  "label": "Uom Id",
  "type": "string"
}, {
  "name": "movementQuantity",
  "label": "Movement Quantity",
  "type": "decimal"
}, {
  "name": "confirmedQuantity",
  "label": "Confirmed Quantity",
  "type": "decimal"
}, {
  "name": "scrappedQuantity",
  "label": "Scrapped Quantity",
  "type": "decimal"
}, {
  "name": "targetQuantity",
  "label": "Target Quantity",
  "type": "decimal"
}, {
  "name": "pickedQuantity",
  "label": "Picked Quantity",
  "type": "decimal"
}, {
  "name": "isInvoiced",
  "label": "Is Invoiced",
  "type": "bool"
}, {
  "name": "attributeSetInstanceId",
  "label": "Attribute Set Instance Id",
  "type": "string"
}, {
  "name": "isDescription",
  "label": "Is Description",
  "type": "bool"
}, {
  "name": "processed",
  "label": "Processed",
  "type": "bool"
}, {
  "name": "quantityEntered",
  "label": "Quantity Entered",
  "type": "decimal"
}, {
  "name": "rmaLineNumber",
  "label": "Rma Line Number",
  "type": "long"
}, {
  "name": "reversalLineNumber",
  "label": "Reversal Line Number",
  "type": "long"
}, {
  "name": "version",
  "label": "Version",
  "type": "long"
}, {
  "name": "createdBy",
  "label": "Created By",
  "type": "string"
}, {
  "name": "createdAt",
  "label": "Created At",
  "type": "DateTime"
}, {
  "name": "updatedBy",
  "label": "Updated By",
  "type": "string"
}, {
  "name": "updatedAt",
  "label": "Updated At",
  "type": "DateTime"
}, {
  "name": "active",
  "label": "Active",
  "type": "bool"
}, {
  "name": "deleted",
  "label": "Deleted",
  "type": "bool"
}, {
  "name": "inOutIsSOTransaction",
  "label": "In Out Is SO Transaction",
  "type": "bool"
}, {
  "name": "inOutDocumentStatus",
  "label": "In Out Document Status",
  "type": "string"
}, {
  "name": "inOutPosted",
  "label": "In Out Posted",
  "type": "bool"
}, {
  "name": "inOutProcessing",
  "label": "In Out Processing",
  "type": "bool"
}, {
  "name": "inOutProcessed",
  "label": "In Out Processed",
  "type": "bool"
}, {
  "name": "inOutDocumentType",
  "label": "In Out Document Type",
  "type": "int"
}, {
  "name": "inOutDescription",
  "label": "In Out Description",
  "type": "string"
}, {
  "name": "inOutOrderNumber",
  "label": "In Out Order Number",
  "type": "string"
}, {
  "name": "inOutDateOrdered",
  "label": "In Out Date Ordered",
  "type": "DateTime?"
}, {
  "name": "inOutIsPrinted",
  "label": "In Out Is Printed",
  "type": "bool"
}, {
  "name": "inOutMovementType",
  "label": "In Out Movement Type",
  "type": "string"
}, {
  "name": "inOutMovementDate",
  "label": "In Out Movement Date",
  "type": "DateTime?"
}, {
  "name": "inOutBusinessPartnerId",
  "label": "In Out Business Partner Id",
  "type": "string"
}, {
  "name": "inOutWarehouseId",
  "label": "In Out Warehouse Id",
  "type": "string"
}, {
  "name": "inOutPOReference",
  "label": "In Out PO Reference",
  "type": "string"
}, {
  "name": "inOutFreightAmount",
  "label": "In Out Freight Amount",
  "type": "Money"
}, {
  "name": "inOutShipperId",
  "label": "In Out Shipper Id",
  "type": "string"
}, {
  "name": "inOutChargeAmount",
  "label": "In Out Charge Amount",
  "type": "Money"
}, {
  "name": "inOutDatePrinted",
  "label": "In Out Date Printed",
  "type": "DateTime?"
}, {
  "name": "inOutSalesRepresentative",
  "label": "In Out Sales Representative",
  "type": "string"
}, {
  "name": "inOutNumberOfPackages",
  "label": "In Out Number Of Packages",
  "type": "int"
}, {
  "name": "inOutPickDate",
  "label": "In Out Pick Date",
  "type": "DateTime?"
}, {
  "name": "inOutShipDate",
  "label": "In Out Ship Date",
  "type": "DateTime?"
}, {
  "name": "inOutTrackingNumber",
  "label": "In Out Tracking Number",
  "type": "string"
}, {
  "name": "inOutDateReceived",
  "label": "In Out Date Received",
  "type": "DateTime?"
}, {
  "name": "inOutIsInTransit",
  "label": "In Out Is In Transit",
  "type": "bool"
}, {
  "name": "inOutIsApproved",
  "label": "In Out Is Approved",
  "type": "bool"
}, {
  "name": "inOutIsInDispute",
  "label": "In Out Is In Dispute",
  "type": "bool"
}, {
  "name": "inOutVolume",
  "label": "In Out Volume",
  "type": "decimal"
}, {
  "name": "inOutWeight",
  "label": "In Out Weight",
  "type": "decimal"
}, {
  "name": "inOutRmaNumber",
  "label": "In Out Rma Number",
  "type": "string"
}, {
  "name": "inOutReversalNumber",
  "label": "In Out Reversal Number",
  "type": "string"
}, {
  "name": "inOutIsDropShip",
  "label": "In Out Is Drop Ship",
  "type": "bool"
}, {
  "name": "inOutDropShipBusinessPartnerId",
  "label": "In Out Drop Ship Business Partner Id",
  "type": "string"
}, {
  "name": "inOutVersion",
  "label": "In Out Version",
  "type": "long"
}, {
  "name": "inOutCreatedBy",
  "label": "In Out Created By",
  "type": "string"
}, {
  "name": "inOutCreatedAt",
  "label": "In Out Created At",
  "type": "DateTime"
}, {
  "name": "inOutUpdatedBy",
  "label": "In Out Updated By",
  "type": "string"
}, {
  "name": "inOutUpdatedAt",
  "label": "In Out Updated At",
  "type": "DateTime"
}, {
  "name": "inOutActive",
  "label": "In Out Active",
  "type": "bool"
}, {
  "name": "inOutDeleted",
  "label": "In Out Deleted",
  "type": "bool"
} ]


, filteringProperties: [
  {
    "name": "Description",
    "typeName": "string",
    "targetPropertyName": "description"
  },
  {
    "name": "LocatorId",
    "typeName": "string",
    "targetPropertyName": "locatorId"
  },
  {
    "name": "ProductId",
    "typeName": "string",
    "targetPropertyName": "productId"
  },
  {
    "name": "UomId",
    "typeName": "string",
    "targetPropertyName": "uomId"
  },
  {
    "name": "MovementQuantity",
    "typeName": "decimal",
    "targetPropertyName": "movementQuantity"
  },
  {
    "name": "ConfirmedQuantity",
    "typeName": "decimal",
    "targetPropertyName": "confirmedQuantity"
  },
  {
    "name": "ScrappedQuantity",
    "typeName": "decimal",
    "targetPropertyName": "scrappedQuantity"
  },
  {
    "name": "TargetQuantity",
    "typeName": "decimal",
    "targetPropertyName": "targetQuantity"
  },
  {
    "name": "PickedQuantity",
    "typeName": "decimal",
    "targetPropertyName": "pickedQuantity"
  },
  {
    "name": "IsInvoiced",
    "typeName": "bool",
    "targetPropertyName": "isInvoiced"
  },
  {
    "name": "AttributeSetInstanceId",
    "typeName": "string",
    "targetPropertyName": "attributeSetInstanceId"
  },
  {
    "name": "IsDescription",
    "typeName": "bool",
    "targetPropertyName": "isDescription"
  },
  {
    "name": "Processed",
    "typeName": "bool",
    "targetPropertyName": "processed"
  },
  {
    "name": "QuantityEntered",
    "typeName": "decimal",
    "targetPropertyName": "quantityEntered"
  },
  {
    "name": "RmaLineNumber",
    "typeName": "long",
    "targetPropertyName": "rmaLineNumber"
  },
  {
    "name": "ReversalLineNumber",
    "typeName": "long",
    "targetPropertyName": "reversalLineNumber"
  },
  {
    "name": "Version",
    "typeName": "long",
    "targetPropertyName": "version"
  },
  {
    "name": "CreatedBy",
    "typeName": "string",
    "targetPropertyName": "createdBy"
  },
  {
    "name": "CreatedAt",
    "typeName": "DateTime",
    "targetPropertyName": "createdAt"
  },
  {
    "name": "UpdatedBy",
    "typeName": "string",
    "targetPropertyName": "updatedBy"
  },
  {
    "name": "UpdatedAt",
    "typeName": "DateTime",
    "targetPropertyName": "updatedAt"
  },
  {
    "name": "Active",
    "typeName": "bool",
    "targetPropertyName": "active"
  },
  {
    "name": "Deleted",
    "typeName": "bool",
    "targetPropertyName": "deleted"
  },
  {
    "name": "InOutIsSOTransaction",
    "typeName": "bool",
    "targetPropertyName": "inOutIsSOTransaction"
  },
  {
    "name": "InOutDocumentStatus",
    "typeName": "string",
    "targetPropertyName": "inOutDocumentStatus"
  },
  {
    "name": "InOutPosted",
    "typeName": "bool",
    "targetPropertyName": "inOutPosted"
  },
  {
    "name": "InOutProcessing",
    "typeName": "bool",
    "targetPropertyName": "inOutProcessing"
  },
  {
    "name": "InOutProcessed",
    "typeName": "bool",
    "targetPropertyName": "inOutProcessed"
  },
  {
    "name": "InOutDocumentType",
    "typeName": "int",
    "targetPropertyName": "inOutDocumentType"
  },
  {
    "name": "InOutDescription",
    "typeName": "string",
    "targetPropertyName": "inOutDescription"
  },
  {
    "name": "InOutOrderNumber",
    "typeName": "string",
    "targetPropertyName": "inOutOrderNumber"
  },
  {
    "name": "InOutDateOrdered",
    "typeName": "DateTime",
    "targetPropertyName": "inOutDateOrdered"
  },
  {
    "name": "InOutIsPrinted",
    "typeName": "bool",
    "targetPropertyName": "inOutIsPrinted"
  },
  {
    "name": "InOutMovementType",
    "typeName": "string",
    "targetPropertyName": "inOutMovementType"
  },
  {
    "name": "InOutMovementDate",
    "typeName": "DateTime",
    "targetPropertyName": "inOutMovementDate"
  },
  {
    "name": "InOutBusinessPartnerId",
    "typeName": "string",
    "targetPropertyName": "inOutBusinessPartnerId"
  },
  {
    "name": "InOutWarehouseId",
    "typeName": "string",
    "targetPropertyName": "inOutWarehouseId"
  },
  {
    "name": "InOutPOReference",
    "typeName": "string",
    "targetPropertyName": "inOutPOReference"
  },
  {
    "name": "InOutFreightAmount",
    "typeName": "Money",
    "targetPropertyName": "inOutFreightAmount"
  },
  {
    "name": "InOutShipperId",
    "typeName": "string",
    "targetPropertyName": "inOutShipperId"
  },
  {
    "name": "InOutChargeAmount",
    "typeName": "Money",
    "targetPropertyName": "inOutChargeAmount"
  },
  {
    "name": "InOutDatePrinted",
    "typeName": "DateTime",
    "targetPropertyName": "inOutDatePrinted"
  },
  {
    "name": "InOutSalesRepresentative",
    "typeName": "string",
    "targetPropertyName": "inOutSalesRepresentative"
  },
  {
    "name": "InOutNumberOfPackages",
    "typeName": "int",
    "targetPropertyName": "inOutNumberOfPackages"
  },
  {
    "name": "InOutPickDate",
    "typeName": "DateTime",
    "targetPropertyName": "inOutPickDate"
  },
  {
    "name": "InOutShipDate",
    "typeName": "DateTime",
    "targetPropertyName": "inOutShipDate"
  },
  {
    "name": "InOutTrackingNumber",
    "typeName": "string",
    "targetPropertyName": "inOutTrackingNumber"
  },
  {
    "name": "InOutDateReceived",
    "typeName": "DateTime",
    "targetPropertyName": "inOutDateReceived"
  },
  {
    "name": "InOutIsInTransit",
    "typeName": "bool",
    "targetPropertyName": "inOutIsInTransit"
  },
  {
    "name": "InOutIsApproved",
    "typeName": "bool",
    "targetPropertyName": "inOutIsApproved"
  },
  {
    "name": "InOutIsInDispute",
    "typeName": "bool",
    "targetPropertyName": "inOutIsInDispute"
  },
  {
    "name": "InOutVolume",
    "typeName": "decimal",
    "targetPropertyName": "inOutVolume"
  },
  {
    "name": "InOutWeight",
    "typeName": "decimal",
    "targetPropertyName": "inOutWeight"
  },
  {
    "name": "InOutRmaNumber",
    "typeName": "string",
    "targetPropertyName": "inOutRmaNumber"
  },
  {
    "name": "InOutReversalNumber",
    "typeName": "string",
    "targetPropertyName": "inOutReversalNumber"
  },
  {
    "name": "InOutIsDropShip",
    "typeName": "bool",
    "targetPropertyName": "inOutIsDropShip"
  },
  {
    "name": "InOutDropShipBusinessPartnerId",
    "typeName": "string",
    "targetPropertyName": "inOutDropShipBusinessPartnerId"
  },
  {
    "name": "InOutVersion",
    "typeName": "long",
    "targetPropertyName": "inOutVersion"
  },
  {
    "name": "InOutCreatedBy",
    "typeName": "string",
    "targetPropertyName": "inOutCreatedBy"
  },
  {
    "name": "InOutCreatedAt",
    "typeName": "DateTime",
    "targetPropertyName": "inOutCreatedAt"
  },
  {
    "name": "InOutUpdatedBy",
    "typeName": "string",
    "targetPropertyName": "inOutUpdatedBy"
  },
  {
    "name": "InOutUpdatedAt",
    "typeName": "DateTime",
    "targetPropertyName": "inOutUpdatedAt"
  },
  {
    "name": "InOutActive",
    "typeName": "bool",
    "targetPropertyName": "inOutActive"
  },
  {
    "name": "InOutDeleted",
    "typeName": "bool",
    "targetPropertyName": "inOutDeleted"
  },
  {
    "name": "InOutLineId.InOutDocumentNumber",
    "typeName": "string",
    "targetPropertyName": "inOutLineId.inOutDocumentNumber"
  },
  {
    "name": "InOutLineId.LineNumber",
    "typeName": "long",
    "targetPropertyName": "inOutLineId.lineNumber"
  },
  {
    "name": "InOutFreightAmount.Amount",
    "typeName": "decimal",
    "targetPropertyName": "amount"
  },
  {
    "name": "InOutFreightAmount.Currency",
    "typeName": "string",
    "targetPropertyName": "currency"
  },
  {
    "name": "InOutChargeAmount.Amount",
    "typeName": "decimal",
    "targetPropertyName": "amount"
  },
  {
    "name": "InOutChargeAmount.Currency",
    "typeName": "string",
    "targetPropertyName": "currency"
  }
]
, reservedProperties: {
  "version": "inOutVersion"
}

  },
  {
    "name": "AttributeSetInstanceExtensionFieldMvo",
    "plural": "AttributeSetInstanceExtensionFieldMvos",
    "label": "Attribute Set Instance Extension Field Mvo",
    "collectionLabel": "Attribute Set Instance Extension Field Mvos",
    "id": {
  "name": "attributeSetInstanceExtensionFieldId",
  "label": "Attribute Set Instance Extension Field Id",
  "type": "AttributeSetInstanceExtensionFieldId"
},
    "properties": [ {
  "name": "name",
  "label": "Name",
  "type": "string"
}, {
  "name": "type",
  "label": "Type",
  "type": "string"
}, {
  "name": "length",
  "label": "Length",
  "type": "int?"
}, {
  "name": "alias",
  "label": "Alias",
  "type": "string"
}, {
  "name": "description",
  "label": "Description",
  "type": "string"
}, {
  "name": "version",
  "label": "Version",
  "type": "long"
}, {
  "name": "createdBy",
  "label": "Created By",
  "type": "string"
}, {
  "name": "createdAt",
  "label": "Created At",
  "type": "DateTime"
}, {
  "name": "updatedBy",
  "label": "Updated By",
  "type": "string"
}, {
  "name": "updatedAt",
  "label": "Updated At",
  "type": "DateTime"
}, {
  "name": "active",
  "label": "Active",
  "type": "bool"
}, {
  "name": "deleted",
  "label": "Deleted",
  "type": "bool"
}, {
  "name": "attrSetInstEFGroupFieldType",
  "label": "Attr Set Inst EF Group Field Type",
  "type": "string"
}, {
  "name": "attrSetInstEFGroupFieldLength",
  "label": "Attr Set Inst EF Group Field Length",
  "type": "int?"
}, {
  "name": "attrSetInstEFGroupFieldCount",
  "label": "Attr Set Inst EF Group Field Count",
  "type": "int"
}, {
  "name": "attrSetInstEFGroupNameFormat",
  "label": "Attr Set Inst EF Group Name Format",
  "type": "string"
}, {
  "name": "attrSetInstEFGroupDescription",
  "label": "Attr Set Inst EF Group Description",
  "type": "string"
}, {
  "name": "attrSetInstEFGroupVersion",
  "label": "Attr Set Inst EF Group Version",
  "type": "long"
}, {
  "name": "attrSetInstEFGroupCreatedBy",
  "label": "Attr Set Inst EF Group Created By",
  "type": "string"
}, {
  "name": "attrSetInstEFGroupCreatedAt",
  "label": "Attr Set Inst EF Group Created At",
  "type": "DateTime"
}, {
  "name": "attrSetInstEFGroupUpdatedBy",
  "label": "Attr Set Inst EF Group Updated By",
  "type": "string"
}, {
  "name": "attrSetInstEFGroupUpdatedAt",
  "label": "Attr Set Inst EF Group Updated At",
  "type": "DateTime"
}, {
  "name": "attrSetInstEFGroupActive",
  "label": "Attr Set Inst EF Group Active",
  "type": "bool"
}, {
  "name": "attrSetInstEFGroupDeleted",
  "label": "Attr Set Inst EF Group Deleted",
  "type": "bool"
} ]


, filteringProperties: [
  {
    "name": "Name",
    "typeName": "string",
    "targetPropertyName": "name"
  },
  {
    "name": "Type",
    "typeName": "string",
    "targetPropertyName": "type"
  },
  {
    "name": "Length",
    "typeName": "int",
    "targetPropertyName": "length"
  },
  {
    "name": "Alias",
    "typeName": "string",
    "targetPropertyName": "alias"
  },
  {
    "name": "Description",
    "typeName": "string",
    "targetPropertyName": "description"
  },
  {
    "name": "Version",
    "typeName": "long",
    "targetPropertyName": "version"
  },
  {
    "name": "CreatedBy",
    "typeName": "string",
    "targetPropertyName": "createdBy"
  },
  {
    "name": "CreatedAt",
    "typeName": "DateTime",
    "targetPropertyName": "createdAt"
  },
  {
    "name": "UpdatedBy",
    "typeName": "string",
    "targetPropertyName": "updatedBy"
  },
  {
    "name": "UpdatedAt",
    "typeName": "DateTime",
    "targetPropertyName": "updatedAt"
  },
  {
    "name": "Active",
    "typeName": "bool",
    "targetPropertyName": "active"
  },
  {
    "name": "Deleted",
    "typeName": "bool",
    "targetPropertyName": "deleted"
  },
  {
    "name": "AttrSetInstEFGroupFieldType",
    "typeName": "string",
    "targetPropertyName": "attrSetInstEFGroupFieldType"
  },
  {
    "name": "AttrSetInstEFGroupFieldLength",
    "typeName": "int",
    "targetPropertyName": "attrSetInstEFGroupFieldLength"
  },
  {
    "name": "AttrSetInstEFGroupFieldCount",
    "typeName": "int",
    "targetPropertyName": "attrSetInstEFGroupFieldCount"
  },
  {
    "name": "AttrSetInstEFGroupNameFormat",
    "typeName": "string",
    "targetPropertyName": "attrSetInstEFGroupNameFormat"
  },
  {
    "name": "AttrSetInstEFGroupDescription",
    "typeName": "string",
    "targetPropertyName": "attrSetInstEFGroupDescription"
  },
  {
    "name": "AttrSetInstEFGroupVersion",
    "typeName": "long",
    "targetPropertyName": "attrSetInstEFGroupVersion"
  },
  {
    "name": "AttrSetInstEFGroupCreatedBy",
    "typeName": "string",
    "targetPropertyName": "attrSetInstEFGroupCreatedBy"
  },
  {
    "name": "AttrSetInstEFGroupCreatedAt",
    "typeName": "DateTime",
    "targetPropertyName": "attrSetInstEFGroupCreatedAt"
  },
  {
    "name": "AttrSetInstEFGroupUpdatedBy",
    "typeName": "string",
    "targetPropertyName": "attrSetInstEFGroupUpdatedBy"
  },
  {
    "name": "AttrSetInstEFGroupUpdatedAt",
    "typeName": "DateTime",
    "targetPropertyName": "attrSetInstEFGroupUpdatedAt"
  },
  {
    "name": "AttrSetInstEFGroupActive",
    "typeName": "bool",
    "targetPropertyName": "attrSetInstEFGroupActive"
  },
  {
    "name": "AttrSetInstEFGroupDeleted",
    "typeName": "bool",
    "targetPropertyName": "attrSetInstEFGroupDeleted"
  },
  {
    "name": "AttributeSetInstanceExtensionFieldId.GroupId",
    "typeName": "string",
    "targetPropertyName": "attributeSetInstanceExtensionFieldId.groupId"
  },
  {
    "name": "AttributeSetInstanceExtensionFieldId.Index",
    "typeName": "string",
    "targetPropertyName": "attributeSetInstanceExtensionFieldId.index"
  }
]
, reservedProperties: {
  "version": "attrSetInstEFGroupVersion"
}

  }
]

