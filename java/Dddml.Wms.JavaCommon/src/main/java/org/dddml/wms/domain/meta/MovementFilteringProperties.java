package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;

public final class MovementFilteringProperties
{

    private MovementFilteringProperties()
    {
    }

    public static final String[] propertyNames = new String[] {
            "documentNumber",
            "documentStatusId",
            "movementDate",
            "posted",
            "processed",
            "processing",
            "dateReceived",
            "documentTypeId",
            "isInTransit",
            "isApproved",
            "approvalAmount",
            "shipperId",
            "salesRepresentativeId",
            "businessPartnerId",
            "chargeAmount",
            "createFrom",
            "freightAmount",
            "reversalDocumentNumber",
            "warehouseIdFrom",
            "warehouseIdTo",
            "description",
            "version",
            "createdBy",
            "createdAt",
            "updatedBy",
            "updatedAt",
            "active",
            "deleted",
    };

    public static final String[] propertyTypes = new String[] {
            "String",
            "String",
            "Date",
            "Boolean",
            "Boolean",
            "String",
            "Date",
            "String",
            "Boolean",
            "Boolean",
            "BigDecimal",
            "String",
            "String",
            "String",
            "BigDecimal",
            "String",
            "BigDecimal",
            "String",
            "String",
            "String",
            "String",
            "Long",
            "String",
            "Date",
            "String",
            "Date",
            "Boolean",
            "Boolean",
    };

    public static final Map<String, String> propertyTypeMap;

    public static final Map<String, String> aliasMap;

    static {
        propertyTypeMap = new HashMap<String, String>();
        initPropertyTypeMap();
        aliasMap = new HashMap<String, String>();
        initAliasMap();
    }

    private static  void initAliasMap() {
        aliasMap.put("documentNumber", "documentNumber");
        aliasMap.put("DocumentNumber", "documentNumber");
        aliasMap.put("documentStatusId", "documentStatusId");
        aliasMap.put("DocumentStatusId", "documentStatusId");
        aliasMap.put("movementDate", "movementDate");
        aliasMap.put("MovementDate", "movementDate");
        aliasMap.put("posted", "posted");
        aliasMap.put("Posted", "posted");
        aliasMap.put("processed", "processed");
        aliasMap.put("Processed", "processed");
        aliasMap.put("processing", "processing");
        aliasMap.put("Processing", "processing");
        aliasMap.put("dateReceived", "dateReceived");
        aliasMap.put("DateReceived", "dateReceived");
        aliasMap.put("documentTypeId", "documentTypeId");
        aliasMap.put("DocumentTypeId", "documentTypeId");
        aliasMap.put("isInTransit", "isInTransit");
        aliasMap.put("IsInTransit", "isInTransit");
        aliasMap.put("isApproved", "isApproved");
        aliasMap.put("IsApproved", "isApproved");
        aliasMap.put("approvalAmount", "approvalAmount");
        aliasMap.put("ApprovalAmount", "approvalAmount");
        aliasMap.put("shipperId", "shipperId");
        aliasMap.put("ShipperId", "shipperId");
        aliasMap.put("salesRepresentativeId", "salesRepresentativeId");
        aliasMap.put("SalesRepresentativeId", "salesRepresentativeId");
        aliasMap.put("businessPartnerId", "businessPartnerId");
        aliasMap.put("BusinessPartnerId", "businessPartnerId");
        aliasMap.put("chargeAmount", "chargeAmount");
        aliasMap.put("ChargeAmount", "chargeAmount");
        aliasMap.put("createFrom", "createFrom");
        aliasMap.put("CreateFrom", "createFrom");
        aliasMap.put("freightAmount", "freightAmount");
        aliasMap.put("FreightAmount", "freightAmount");
        aliasMap.put("reversalDocumentNumber", "reversalDocumentNumber");
        aliasMap.put("ReversalDocumentNumber", "reversalDocumentNumber");
        aliasMap.put("warehouseIdFrom", "warehouseIdFrom");
        aliasMap.put("WarehouseIdFrom", "warehouseIdFrom");
        aliasMap.put("warehouseIdTo", "warehouseIdTo");
        aliasMap.put("WarehouseIdTo", "warehouseIdTo");
        aliasMap.put("description", "description");
        aliasMap.put("Description", "description");
        aliasMap.put("version", "version");
        aliasMap.put("Version", "version");
        aliasMap.put("createdBy", "createdBy");
        aliasMap.put("CreatedBy", "createdBy");
        aliasMap.put("createdAt", "createdAt");
        aliasMap.put("CreatedAt", "createdAt");
        aliasMap.put("updatedBy", "updatedBy");
        aliasMap.put("UpdatedBy", "updatedBy");
        aliasMap.put("updatedAt", "updatedAt");
        aliasMap.put("UpdatedAt", "updatedAt");
        aliasMap.put("active", "active");
        aliasMap.put("Active", "active");
        aliasMap.put("deleted", "deleted");
        aliasMap.put("Deleted", "deleted");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

