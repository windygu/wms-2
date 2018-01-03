CREATE VIEW `AttributeValue_RV` AS
    SELECT 
        `AttributeValues`.`AttributeValueIdAttributeId`,
        `AttributeValues`.`AttributeValueIdValue`,
        `AttributeValues`.`AttributeValueName`,
        `AttributeValues`.`Description`,
        `AttributeValues`.`ReferenceId`,
        `AttributeValues`.`Version`,
        `AttributeValues`.`CreatedBy`,
        `AttributeValues`.`CreatedAt`,
        `AttributeValues`.`UpdatedBy`,
        `AttributeValues`.`UpdatedAt`,
        `AttributeValues`.`Active`,
        `AttributeValues`.`Deleted`,
        `Attributes`.`AttributeName` AS `AttributeAttributeName`,
        `Attributes`.`OrganizationId` AS `AttributeOrganizationId`,
        `Attributes`.`Description` AS `AttributeDescription`,
        `Attributes`.`IsMandatory` AS `AttributeIsMandatory`,
        `Attributes`.`AttributeValueType` AS `AttributeAttributeValueType`,
        `Attributes`.`AttributeValueLength` AS `AttributeAttributeValueLength`,
        `Attributes`.`IsList` AS `AttributeIsList`,
        `Attributes`.`FieldName` AS `AttributeFieldName`,
        `Attributes`.`ReferenceId` AS `AttributeReferenceId`,
        `Attributes`.`Version` AS `AttributeVersion`,
        `Attributes`.`CreatedBy` AS `AttributeCreatedBy`,
        `Attributes`.`CreatedAt` AS `AttributeCreatedAt`,
        `Attributes`.`UpdatedBy` AS `AttributeUpdatedBy`,
        `Attributes`.`UpdatedAt` AS `AttributeUpdatedAt`,
        `Attributes`.`Active` AS `AttributeActive`,
        `Attributes`.`Deleted` AS `AttributeDeleted`
    FROM
        (`AttributeValues`
            JOIN `Attributes` ON ( 1=1 
                and (`AttributeValues`.`AttributeValueIdAttributeId` = `Attributes`.`AttributeId`)
            )
        );


CREATE VIEW `AttributeAlias_RV` AS
    SELECT 
        `AttributeAlias`.`AttributeAliasIdAttributeId`,
        `AttributeAlias`.`AttributeAliasIdCode`,
        `AttributeAlias`.`Name`,
        `AttributeAlias`.`Version`,
        `AttributeAlias`.`CreatedBy`,
        `AttributeAlias`.`CreatedAt`,
        `AttributeAlias`.`UpdatedBy`,
        `AttributeAlias`.`UpdatedAt`,
        `AttributeAlias`.`Active`,
        `AttributeAlias`.`Deleted`,
        `Attributes`.`AttributeName` AS `AttributeAttributeName`,
        `Attributes`.`OrganizationId` AS `AttributeOrganizationId`,
        `Attributes`.`Description` AS `AttributeDescription`,
        `Attributes`.`IsMandatory` AS `AttributeIsMandatory`,
        `Attributes`.`AttributeValueType` AS `AttributeAttributeValueType`,
        `Attributes`.`AttributeValueLength` AS `AttributeAttributeValueLength`,
        `Attributes`.`IsList` AS `AttributeIsList`,
        `Attributes`.`FieldName` AS `AttributeFieldName`,
        `Attributes`.`ReferenceId` AS `AttributeReferenceId`,
        `Attributes`.`Version` AS `AttributeVersion`,
        `Attributes`.`CreatedBy` AS `AttributeCreatedBy`,
        `Attributes`.`CreatedAt` AS `AttributeCreatedAt`,
        `Attributes`.`UpdatedBy` AS `AttributeUpdatedBy`,
        `Attributes`.`UpdatedAt` AS `AttributeUpdatedAt`,
        `Attributes`.`Active` AS `AttributeActive`,
        `Attributes`.`Deleted` AS `AttributeDeleted`
    FROM
        (`AttributeAlias`
            JOIN `Attributes` ON ( 1=1 
                and (`AttributeAlias`.`AttributeAliasIdAttributeId` = `Attributes`.`AttributeId`)
            )
        );


CREATE VIEW `AttributeUse_RV` AS
    SELECT 
        `AttributeUses`.`AttributeSetAttributeUseIdAttributeSetId`,
        `AttributeUses`.`AttributeSetAttributeUseIdAttributeId`,
        `AttributeUses`.`SequenceNumber`,
        `AttributeUses`.`Version`,
        `AttributeUses`.`CreatedBy`,
        `AttributeUses`.`CreatedAt`,
        `AttributeUses`.`UpdatedBy`,
        `AttributeUses`.`UpdatedAt`,
        `AttributeUses`.`Active`,
        `AttributeUses`.`Deleted`,
        `AttributeSets`.`AttributeSetName` AS `AttributeSetAttributeSetName`,
        `AttributeSets`.`OrganizationId` AS `AttributeSetOrganizationId`,
        `AttributeSets`.`Description` AS `AttributeSetDescription`,
        `AttributeSets`.`ReferenceId` AS `AttributeSetReferenceId`,
        `AttributeSets`.`IsInstanceAttributeSet` AS `AttributeSetIsInstanceAttributeSet`,
        `AttributeSets`.`IsMandatory` AS `AttributeSetIsMandatory`,
        `AttributeSets`.`Version` AS `AttributeSetVersion`,
        `AttributeSets`.`CreatedBy` AS `AttributeSetCreatedBy`,
        `AttributeSets`.`CreatedAt` AS `AttributeSetCreatedAt`,
        `AttributeSets`.`UpdatedBy` AS `AttributeSetUpdatedBy`,
        `AttributeSets`.`UpdatedAt` AS `AttributeSetUpdatedAt`,
        `AttributeSets`.`Active` AS `AttributeSetActive`,
        `AttributeSets`.`Deleted` AS `AttributeSetDeleted`
    FROM
        (`AttributeUses`
            JOIN `AttributeSets` ON ( 1=1 
                and (`AttributeUses`.`AttributeSetAttributeUseIdAttributeSetId` = `AttributeSets`.`AttributeSetId`)
            )
        );


CREATE VIEW `InOutLine_RV` AS
    SELECT 
        `InOutLines`.`InOutLineIdInOutDocumentNumber`,
        `InOutLines`.`InOutLineIdLineNumber`,
        `InOutLines`.`LocatorId`,
        `InOutLines`.`ProductId`,
        `InOutLines`.`AttributeSetInstanceId`,
        `InOutLines`.`Description`,
        `InOutLines`.`QuantityUomId`,
        `InOutLines`.`MovementQuantity`,
        `InOutLines`.`PickedQuantity`,
        `InOutLines`.`IsInvoiced`,
        `InOutLines`.`Processed`,
        `InOutLines`.`RmaLineNumber`,
        `InOutLines`.`ReversalLineNumber`,
        `InOutLines`.`Version`,
        `InOutLines`.`CreatedBy`,
        `InOutLines`.`CreatedAt`,
        `InOutLines`.`UpdatedBy`,
        `InOutLines`.`UpdatedAt`,
        `InOutLines`.`Active`,
        `InOutLines`.`Deleted`,
        `InOuts`.`DocumentStatusId` AS `InOutDocumentStatusId`,
        `InOuts`.`Posted` AS `InOutPosted`,
        `InOuts`.`Processed` AS `InOutProcessed`,
        `InOuts`.`Processing` AS `InOutProcessing`,
        `InOuts`.`DocumentTypeId` AS `InOutDocumentTypeId`,
        `InOuts`.`Description` AS `InOutDescription`,
        `InOuts`.`OrderId` AS `InOutOrderId`,
        `InOuts`.`DateOrdered` AS `InOutDateOrdered`,
        `InOuts`.`IsPrinted` AS `InOutIsPrinted`,
        `InOuts`.`MovementTypeId` AS `InOutMovementTypeId`,
        `InOuts`.`MovementDate` AS `InOutMovementDate`,
        `InOuts`.`BusinessPartnerId` AS `InOutBusinessPartnerId`,
        `InOuts`.`WarehouseId` AS `InOutWarehouseId`,
        `InOuts`.`POReference` AS `InOutPOReference`,
        `InOuts`.`FreightAmount` AS `InOutFreightAmount`,
        `InOuts`.`ShipperId` AS `InOutShipperId`,
        `InOuts`.`ChargeAmount` AS `InOutChargeAmount`,
        `InOuts`.`DatePrinted` AS `InOutDatePrinted`,
        `InOuts`.`CreatedFrom` AS `InOutCreatedFrom`,
        `InOuts`.`SalesRepresentativeId` AS `InOutSalesRepresentativeId`,
        `InOuts`.`NumberOfPackages` AS `InOutNumberOfPackages`,
        `InOuts`.`PickDate` AS `InOutPickDate`,
        `InOuts`.`ShipDate` AS `InOutShipDate`,
        `InOuts`.`TrackingNumber` AS `InOutTrackingNumber`,
        `InOuts`.`DateReceived` AS `InOutDateReceived`,
        `InOuts`.`IsInTransit` AS `InOutIsInTransit`,
        `InOuts`.`IsApproved` AS `InOutIsApproved`,
        `InOuts`.`IsInDispute` AS `InOutIsInDispute`,
        `InOuts`.`RmaDocumentNumber` AS `InOutRmaDocumentNumber`,
        `InOuts`.`ReversalDocumentNumber` AS `InOutReversalDocumentNumber`,
        `InOuts`.`Version` AS `InOutVersion`,
        `InOuts`.`CreatedBy` AS `InOutCreatedBy`,
        `InOuts`.`CreatedAt` AS `InOutCreatedAt`,
        `InOuts`.`UpdatedBy` AS `InOutUpdatedBy`,
        `InOuts`.`UpdatedAt` AS `InOutUpdatedAt`,
        `InOuts`.`Active` AS `InOutActive`
    FROM
        (`InOutLines`
            JOIN `InOuts` ON ( 1=1 
                and (`InOutLines`.`InOutLineIdInOutDocumentNumber` = `InOuts`.`DocumentNumber`)
            )
        );


CREATE VIEW `InventoryItemEntry_RV` AS
    SELECT 
        `InventoryItemEntries`.`ProductId`,
        `InventoryItemEntries`.`LocatorId`,
        `InventoryItemEntries`.`AttributeSetInstanceId`,
        `InventoryItemEntries`.`EntrySeqId`,
        `InventoryItemEntries`.`OnHandQuantity`,
        `InventoryItemEntries`.`InTransitQuantity`,
        `InventoryItemEntries`.`ReservedQuantity`,
        `InventoryItemEntries`.`OccupiedQuantity`,
        `InventoryItemEntries`.`VirtualQuantity`,
        `InventoryItemEntries`.`SourceDocumentTypeId`,
        `InventoryItemEntries`.`SourceDocumentNumber`,
        `InventoryItemEntries`.`SourceLineNumber`,
        `InventoryItemEntries`.`Version`,
        `InventoryItemEntries`.`CreatedBy`,
        `InventoryItemEntries`.`CreatedAt`,
        `InventoryItemEntries`.`UpdatedBy`,
        `InventoryItemEntries`.`UpdatedAt`,
        `InventoryItems`.`OnHandQuantity` AS `InventoryItemOnHandQuantity`,
        `InventoryItems`.`InTransitQuantity` AS `InventoryItemInTransitQuantity`,
        `InventoryItems`.`ReservedQuantity` AS `InventoryItemReservedQuantity`,
        `InventoryItems`.`OccupiedQuantity` AS `InventoryItemOccupiedQuantity`,
        `InventoryItems`.`VirtualQuantity` AS `InventoryItemVirtualQuantity`,
        `InventoryItems`.`Version` AS `InventoryItemVersion`,
        `InventoryItems`.`CreatedBy` AS `InventoryItemCreatedBy`,
        `InventoryItems`.`CreatedAt` AS `InventoryItemCreatedAt`,
        `InventoryItems`.`UpdatedBy` AS `InventoryItemUpdatedBy`,
        `InventoryItems`.`UpdatedAt` AS `InventoryItemUpdatedAt`
    FROM
        (`InventoryItemEntries`
            JOIN `InventoryItems` ON ( 1=1 
                and (`InventoryItemEntries`.`ProductId` = `InventoryItems`.`ProductId`)
                and (`InventoryItemEntries`.`LocatorId` = `InventoryItems`.`LocatorId`)
                and (`InventoryItemEntries`.`AttributeSetInstanceId` = `InventoryItems`.`AttributeSetInstanceId`)
            )
        );


CREATE VIEW `InventoryItemRequirementEntry_RV` AS
    SELECT 
        `InventoryItemRequirementEntries`.`ProductId`,
        `InventoryItemRequirementEntries`.`LocatorId`,
        `InventoryItemRequirementEntries`.`AttributeSetInstanceId`,
        `InventoryItemRequirementEntries`.`EntrySeqId`,
        `InventoryItemRequirementEntries`.`Quantity`,
        `InventoryItemRequirementEntries`.`SrcEventProductId`,
        `InventoryItemRequirementEntries`.`SrcEventLocatorId`,
        `InventoryItemRequirementEntries`.`SrcEventAttributeSetInstanceId`,
        `InventoryItemRequirementEntries`.`SrcEventEntrySeqId`,
        `InventoryItemRequirementEntries`.`SrcEventInventoryPostingRuleId`,
        `InventoryItemRequirementEntries`.`Version`,
        `InventoryItemRequirementEntries`.`CreatedBy`,
        `InventoryItemRequirementEntries`.`CreatedAt`,
        `InventoryItemRequirementEntries`.`UpdatedBy`,
        `InventoryItemRequirementEntries`.`UpdatedAt`,
        `InventoryItemRequirements`.`Quantity` AS `InventoryItemRequirementQuantity`,
        `InventoryItemRequirements`.`Version` AS `InventoryItemRequirementVersion`,
        `InventoryItemRequirements`.`CreatedBy` AS `InventoryItemRequirementCreatedBy`,
        `InventoryItemRequirements`.`CreatedAt` AS `InventoryItemRequirementCreatedAt`,
        `InventoryItemRequirements`.`UpdatedBy` AS `InventoryItemRequirementUpdatedBy`,
        `InventoryItemRequirements`.`UpdatedAt` AS `InventoryItemRequirementUpdatedAt`
    FROM
        (`InventoryItemRequirementEntries`
            JOIN `InventoryItemRequirements` ON ( 1=1 
                and (`InventoryItemRequirementEntries`.`ProductId` = `InventoryItemRequirements`.`ProductId`)
                and (`InventoryItemRequirementEntries`.`LocatorId` = `InventoryItemRequirements`.`LocatorId`)
                and (`InventoryItemRequirementEntries`.`AttributeSetInstanceId` = `InventoryItemRequirements`.`AttributeSetInstanceId`)
            )
        );


CREATE VIEW `MovementLine_RV` AS
    SELECT 
        `MovementLines`.`MovementLineIdMovementDocumentNumber`,
        `MovementLines`.`MovementLineIdLineNumber`,
        `MovementLines`.`MovementQuantity`,
        `MovementLines`.`ProductId`,
        `MovementLines`.`LocatorIdFrom`,
        `MovementLines`.`LocatorIdTo`,
        `MovementLines`.`AttributeSetInstanceId`,
        `MovementLines`.`Processed`,
        `MovementLines`.`ReversalLineNumber`,
        `MovementLines`.`Version`,
        `MovementLines`.`CreatedBy`,
        `MovementLines`.`CreatedAt`,
        `MovementLines`.`UpdatedBy`,
        `MovementLines`.`UpdatedAt`,
        `MovementLines`.`Active`,
        `MovementLines`.`Deleted`,
        `Movements`.`DocumentStatusId` AS `MovementDocumentStatusId`,
        `Movements`.`MovementDate` AS `MovementMovementDate`,
        `Movements`.`Posted` AS `MovementPosted`,
        `Movements`.`Processed` AS `MovementProcessed`,
        `Movements`.`Processing` AS `MovementProcessing`,
        `Movements`.`DateReceived` AS `MovementDateReceived`,
        `Movements`.`DocumentTypeId` AS `MovementDocumentTypeId`,
        `Movements`.`IsInTransit` AS `MovementIsInTransit`,
        `Movements`.`IsApproved` AS `MovementIsApproved`,
        `Movements`.`ApprovalAmount` AS `MovementApprovalAmount`,
        `Movements`.`ShipperId` AS `MovementShipperId`,
        `Movements`.`SalesRepresentativeId` AS `MovementSalesRepresentativeId`,
        `Movements`.`BusinessPartnerId` AS `MovementBusinessPartnerId`,
        `Movements`.`ChargeAmount` AS `MovementChargeAmount`,
        `Movements`.`CreateFrom` AS `MovementCreateFrom`,
        `Movements`.`FreightAmount` AS `MovementFreightAmount`,
        `Movements`.`ReversalDocumentNumber` AS `MovementReversalDocumentNumber`,
        `Movements`.`WarehouseIdFrom` AS `MovementWarehouseIdFrom`,
        `Movements`.`WarehouseIdTo` AS `MovementWarehouseIdTo`,
        `Movements`.`Description` AS `MovementDescription`,
        `Movements`.`Version` AS `MovementVersion`,
        `Movements`.`CreatedBy` AS `MovementCreatedBy`,
        `Movements`.`CreatedAt` AS `MovementCreatedAt`,
        `Movements`.`UpdatedBy` AS `MovementUpdatedBy`,
        `Movements`.`UpdatedAt` AS `MovementUpdatedAt`,
        `Movements`.`Active` AS `MovementActive`,
        `Movements`.`Deleted` AS `MovementDeleted`
    FROM
        (`MovementLines`
            JOIN `Movements` ON ( 1=1 
                and (`MovementLines`.`MovementLineIdMovementDocumentNumber` = `Movements`.`DocumentNumber`)
            )
        );


CREATE VIEW `MovementConfirmationLine_RV` AS
    SELECT 
        `MovementConfirmationLines`.`MovementConfirmationLineIdMovementConfirmationDocumentNumber`,
        `MovementConfirmationLines`.`MovementConfirmationLineIdLineNumber`,
        `MovementConfirmationLines`.`MovementLineNumber`,
        `MovementConfirmationLines`.`TargetQuantity`,
        `MovementConfirmationLines`.`ConfirmedQuantity`,
        `MovementConfirmationLines`.`DifferenceQuantity`,
        `MovementConfirmationLines`.`ScrappedQuantity`,
        `MovementConfirmationLines`.`Description`,
        `MovementConfirmationLines`.`Processed`,
        `MovementConfirmationLines`.`Version`,
        `MovementConfirmationLines`.`CreatedBy`,
        `MovementConfirmationLines`.`CreatedAt`,
        `MovementConfirmationLines`.`UpdatedBy`,
        `MovementConfirmationLines`.`UpdatedAt`,
        `MovementConfirmationLines`.`Active`,
        `MovementConfirmationLines`.`Deleted`,
        `MovementConfirmations`.`DocumentStatusId` AS `MovementConfirmationDocumentStatusId`,
        `MovementConfirmations`.`MovementDocumentNumber` AS `MovementConfirmationMovementDocumentNumber`,
        `MovementConfirmations`.`IsApproved` AS `MovementConfirmationIsApproved`,
        `MovementConfirmations`.`ApprovalAmount` AS `MovementConfirmationApprovalAmount`,
        `MovementConfirmations`.`Processed` AS `MovementConfirmationProcessed`,
        `MovementConfirmations`.`Processing` AS `MovementConfirmationProcessing`,
        `MovementConfirmations`.`DocumentTypeId` AS `MovementConfirmationDocumentTypeId`,
        `MovementConfirmations`.`Description` AS `MovementConfirmationDescription`,
        `MovementConfirmations`.`Version` AS `MovementConfirmationVersion`,
        `MovementConfirmations`.`CreatedBy` AS `MovementConfirmationCreatedBy`,
        `MovementConfirmations`.`CreatedAt` AS `MovementConfirmationCreatedAt`,
        `MovementConfirmations`.`UpdatedBy` AS `MovementConfirmationUpdatedBy`,
        `MovementConfirmations`.`UpdatedAt` AS `MovementConfirmationUpdatedAt`,
        `MovementConfirmations`.`Active` AS `MovementConfirmationActive`,
        `MovementConfirmations`.`Deleted` AS `MovementConfirmationDeleted`
    FROM
        (`MovementConfirmationLines`
            JOIN `MovementConfirmations` ON ( 1=1 
                and (`MovementConfirmationLines`.`MovementConfirmationLineIdMovementConfirmationDocumentNumber` = `MovementConfirmations`.`DocumentNumber`)
            )
        );


CREATE VIEW `OrderItem_RV` AS
    SELECT 
        `OrderItems`.`OrderItemIdOrderId`,
        `OrderItems`.`OrderItemIdOrderItemSeqId`,
        `OrderItems`.`ProductId`,
        `OrderItems`.`ExternalProductId`,
        `OrderItems`.`Quantity`,
        `OrderItems`.`CancelQuantity`,
        `OrderItems`.`SelectedAmount`,
        `OrderItems`.`ExternalId`,
        `OrderItems`.`OrderItemTypeId`,
        `OrderItems`.`OrderItemGroupSeqId`,
        `OrderItems`.`IsItemGroupPrimary`,
        `OrderItems`.`FromInventoryItemId`,
        `OrderItems`.`IsPromo`,
        `OrderItems`.`QuoteId`,
        `OrderItems`.`QuoteItemSeqId`,
        `OrderItems`.`ShoppingListId`,
        `OrderItems`.`ShoppingListItemSeqId`,
        `OrderItems`.`UnitPrice`,
        `OrderItems`.`UnitListPrice`,
        `OrderItems`.`UnitAverageCost`,
        `OrderItems`.`UnitRecurringPrice`,
        `OrderItems`.`IsModifiedPrice`,
        `OrderItems`.`RecurringFreqUomId`,
        `OrderItems`.`ItemDescription`,
        `OrderItems`.`Comments`,
        `OrderItems`.`CorrespondingPoId`,
        `OrderItems`.`StatusId`,
        `OrderItems`.`SyncStatusId`,
        `OrderItems`.`EstimatedShipDate`,
        `OrderItems`.`EstimatedDeliveryDate`,
        `OrderItems`.`AutoCancelDate`,
        `OrderItems`.`DontCancelSetDate`,
        `OrderItems`.`DontCancelSetBy`,
        `OrderItems`.`ShipBeforeDate`,
        `OrderItems`.`ShipAfterDate`,
        `OrderItems`.`CancelBackOrderDate`,
        `OrderItems`.`OverrideGlAccountId`,
        `OrderItems`.`Version`,
        `OrderItems`.`CreatedBy`,
        `OrderItems`.`CreatedAt`,
        `OrderItems`.`UpdatedBy`,
        `OrderItems`.`UpdatedAt`,
        `OrderItems`.`Active`,
        `Orders`.`OrderTypeId` AS `OrderOrderTypeId`,
        `Orders`.`OrderName` AS `OrderOrderName`,
        `Orders`.`ExternalId` AS `OrderExternalId`,
        `Orders`.`SalesChannelEnumId` AS `OrderSalesChannelEnumId`,
        `Orders`.`OrderDate` AS `OrderOrderDate`,
        `Orders`.`Priority` AS `OrderPriority`,
        `Orders`.`EntryDate` AS `OrderEntryDate`,
        `Orders`.`PickSheetPrintedDate` AS `OrderPickSheetPrintedDate`,
        `Orders`.`StatusId` AS `OrderStatusId`,
        `Orders`.`CurrencyUom` AS `OrderCurrencyUom`,
        `Orders`.`SyncStatusId` AS `OrderSyncStatusId`,
        `Orders`.`BillingAccountId` AS `OrderBillingAccountId`,
        `Orders`.`OriginFacilityId` AS `OrderOriginFacilityId`,
        `Orders`.`WebSiteId` AS `OrderWebSiteId`,
        `Orders`.`ProductStoreId` AS `OrderProductStoreId`,
        `Orders`.`TerminalId` AS `OrderTerminalId`,
        `Orders`.`TransactionId` AS `OrderTransactionId`,
        `Orders`.`AutoOrderShoppingListId` AS `OrderAutoOrderShoppingListId`,
        `Orders`.`NeedsInventoryIssuance` AS `OrderNeedsInventoryIssuance`,
        `Orders`.`IsRushOrder` AS `OrderIsRushOrder`,
        `Orders`.`InternalCode` AS `OrderInternalCode`,
        `Orders`.`RemainingSubTotal` AS `OrderRemainingSubTotal`,
        `Orders`.`GrandTotal` AS `OrderGrandTotal`,
        `Orders`.`InvoicePerShipment` AS `OrderInvoicePerShipment`,
        `Orders`.`Version` AS `OrderVersion`,
        `Orders`.`CreatedBy` AS `OrderCreatedBy`,
        `Orders`.`CreatedAt` AS `OrderCreatedAt`,
        `Orders`.`UpdatedBy` AS `OrderUpdatedBy`,
        `Orders`.`UpdatedAt` AS `OrderUpdatedAt`,
        `Orders`.`Active` AS `OrderActive`
    FROM
        (`OrderItems`
            JOIN `Orders` ON ( 1=1 
                and (`OrderItems`.`OrderItemIdOrderId` = `Orders`.`OrderId`)
            )
        );


CREATE VIEW `PhysicalInventoryLine_RV` AS
    SELECT 
        `PhysicalInventoryLines`.`PhysicalInventoryLineIdPhysicalInventoryDocumentNumber`,
        `PhysicalInventoryLines`.`PhysicalInventoryLineIdLineNumber`,
        `PhysicalInventoryLines`.`LocatorId`,
        `PhysicalInventoryLines`.`ProductId`,
        `PhysicalInventoryLines`.`AttributeSetInstanceId`,
        `PhysicalInventoryLines`.`BookQuantity`,
        `PhysicalInventoryLines`.`CountedQuantity`,
        `PhysicalInventoryLines`.`Processed`,
        `PhysicalInventoryLines`.`ReversalLineNumber`,
        `PhysicalInventoryLines`.`Description`,
        `PhysicalInventoryLines`.`Version`,
        `PhysicalInventoryLines`.`CreatedBy`,
        `PhysicalInventoryLines`.`CreatedAt`,
        `PhysicalInventoryLines`.`UpdatedBy`,
        `PhysicalInventoryLines`.`UpdatedAt`,
        `PhysicalInventoryLines`.`Active`,
        `PhysicalInventoryLines`.`Deleted`,
        `PhysicalInventories`.`DocumentStatusId` AS `PhysicalInventoryDocumentStatusId`,
        `PhysicalInventories`.`WarehouseId` AS `PhysicalInventoryWarehouseId`,
        `PhysicalInventories`.`Posted` AS `PhysicalInventoryPosted`,
        `PhysicalInventories`.`Processed` AS `PhysicalInventoryProcessed`,
        `PhysicalInventories`.`Processing` AS `PhysicalInventoryProcessing`,
        `PhysicalInventories`.`DocumentTypeId` AS `PhysicalInventoryDocumentTypeId`,
        `PhysicalInventories`.`MovementDate` AS `PhysicalInventoryMovementDate`,
        `PhysicalInventories`.`Description` AS `PhysicalInventoryDescription`,
        `PhysicalInventories`.`IsApproved` AS `PhysicalInventoryIsApproved`,
        `PhysicalInventories`.`ApprovalAmount` AS `PhysicalInventoryApprovalAmount`,
        `PhysicalInventories`.`IsQuantityUpdated` AS `PhysicalInventoryIsQuantityUpdated`,
        `PhysicalInventories`.`ReversalDocumentNumber` AS `PhysicalInventoryReversalDocumentNumber`,
        `PhysicalInventories`.`Version` AS `PhysicalInventoryVersion`,
        `PhysicalInventories`.`CreatedBy` AS `PhysicalInventoryCreatedBy`,
        `PhysicalInventories`.`CreatedAt` AS `PhysicalInventoryCreatedAt`,
        `PhysicalInventories`.`UpdatedBy` AS `PhysicalInventoryUpdatedBy`,
        `PhysicalInventories`.`UpdatedAt` AS `PhysicalInventoryUpdatedAt`,
        `PhysicalInventories`.`Active` AS `PhysicalInventoryActive`,
        `PhysicalInventories`.`Deleted` AS `PhysicalInventoryDeleted`
    FROM
        (`PhysicalInventoryLines`
            JOIN `PhysicalInventories` ON ( 1=1 
                and (`PhysicalInventoryLines`.`PhysicalInventoryLineIdPhysicalInventoryDocumentNumber` = `PhysicalInventories`.`DocumentNumber`)
            )
        );


CREATE VIEW `SellableInventoryItemEntry_RV` AS
    SELECT 
        `SellableInventoryItemEntries`.`ProductId`,
        `SellableInventoryItemEntries`.`LocatorId`,
        `SellableInventoryItemEntries`.`AttributeSetInstanceId`,
        `SellableInventoryItemEntries`.`EntrySeqId`,
        `SellableInventoryItemEntries`.`SellableQuantity`,
        `SellableInventoryItemEntries`.`SrcEventProductId`,
        `SellableInventoryItemEntries`.`SrcEventLocatorId`,
        `SellableInventoryItemEntries`.`SrcEventAttributeSetInstanceId`,
        `SellableInventoryItemEntries`.`SrcEventEntrySeqId`,
        `SellableInventoryItemEntries`.`SrcEventInventoryPostingRuleId`,
        `SellableInventoryItemEntries`.`Version`,
        `SellableInventoryItemEntries`.`CreatedBy`,
        `SellableInventoryItemEntries`.`CreatedAt`,
        `SellableInventoryItemEntries`.`UpdatedBy`,
        `SellableInventoryItemEntries`.`UpdatedAt`,
        `SellableInventoryItems`.`SellableQuantity` AS `SellableInventoryItemSellableQuantity`,
        `SellableInventoryItems`.`Version` AS `SellableInventoryItemVersion`,
        `SellableInventoryItems`.`CreatedBy` AS `SellableInventoryItemCreatedBy`,
        `SellableInventoryItems`.`CreatedAt` AS `SellableInventoryItemCreatedAt`,
        `SellableInventoryItems`.`UpdatedBy` AS `SellableInventoryItemUpdatedBy`,
        `SellableInventoryItems`.`UpdatedAt` AS `SellableInventoryItemUpdatedAt`
    FROM
        (`SellableInventoryItemEntries`
            JOIN `SellableInventoryItems` ON ( 1=1 
                and (`SellableInventoryItemEntries`.`ProductId` = `SellableInventoryItems`.`ProductId`)
                and (`SellableInventoryItemEntries`.`LocatorId` = `SellableInventoryItems`.`LocatorId`)
                and (`SellableInventoryItemEntries`.`AttributeSetInstanceId` = `SellableInventoryItems`.`AttributeSetInstanceId`)
            )
        );


CREATE VIEW `ShipmentItem_RV` AS
    SELECT 
        `ShipmentItems`.`ShipmentItemIdShipmentId`,
        `ShipmentItems`.`ShipmentItemIdShipmentItemSeqId`,
        `ShipmentItems`.`ProductId`,
        `ShipmentItems`.`AttributeSetInstanceId`,
        `ShipmentItems`.`Quantity`,
        `ShipmentItems`.`TargetQuantity`,
        `ShipmentItems`.`ShipmentContentDescription`,
        `ShipmentItems`.`Version`,
        `ShipmentItems`.`CreatedBy`,
        `ShipmentItems`.`CreatedAt`,
        `ShipmentItems`.`UpdatedBy`,
        `ShipmentItems`.`UpdatedAt`,
        `ShipmentItems`.`Active`,
        `Shipments`.`ShipmentTypeId` AS `ShipmentShipmentTypeId`,
        `Shipments`.`StatusId` AS `ShipmentStatusId`,
        `Shipments`.`PrimaryOrderId` AS `ShipmentPrimaryOrderId`,
        `Shipments`.`PrimaryReturnId` AS `ShipmentPrimaryReturnId`,
        `Shipments`.`PicklistBinId` AS `ShipmentPicklistBinId`,
        `Shipments`.`EstimatedReadyDate` AS `ShipmentEstimatedReadyDate`,
        `Shipments`.`EstimatedShipDate` AS `ShipmentEstimatedShipDate`,
        `Shipments`.`EstimatedShipWorkEffId` AS `ShipmentEstimatedShipWorkEffId`,
        `Shipments`.`EstimatedArrivalDate` AS `ShipmentEstimatedArrivalDate`,
        `Shipments`.`EstimatedArrivalWorkEffId` AS `ShipmentEstimatedArrivalWorkEffId`,
        `Shipments`.`LatestCancelDate` AS `ShipmentLatestCancelDate`,
        `Shipments`.`EstimatedShipCost` AS `ShipmentEstimatedShipCost`,
        `Shipments`.`CurrencyUomId` AS `ShipmentCurrencyUomId`,
        `Shipments`.`HandlingInstructions` AS `ShipmentHandlingInstructions`,
        `Shipments`.`OriginFacilityId` AS `ShipmentOriginFacilityId`,
        `Shipments`.`DestinationFacilityId` AS `ShipmentDestinationFacilityId`,
        `Shipments`.`OriginContactMechId` AS `ShipmentOriginContactMechId`,
        `Shipments`.`OriginTelecomNumberId` AS `ShipmentOriginTelecomNumberId`,
        `Shipments`.`DestinationContactMechId` AS `ShipmentDestinationContactMechId`,
        `Shipments`.`DestinationTelecomNumberId` AS `ShipmentDestinationTelecomNumberId`,
        `Shipments`.`PartyIdTo` AS `ShipmentPartyIdTo`,
        `Shipments`.`PartyIdFrom` AS `ShipmentPartyIdFrom`,
        `Shipments`.`AdditionalShippingCharge` AS `ShipmentAdditionalShippingCharge`,
        `Shipments`.`AddtlShippingChargeDesc` AS `ShipmentAddtlShippingChargeDesc`,
        `Shipments`.`ShipperId` AS `ShipmentShipperId`,
        `Shipments`.`Version` AS `ShipmentVersion`,
        `Shipments`.`CreatedBy` AS `ShipmentCreatedBy`,
        `Shipments`.`CreatedAt` AS `ShipmentCreatedAt`,
        `Shipments`.`UpdatedBy` AS `ShipmentUpdatedBy`,
        `Shipments`.`UpdatedAt` AS `ShipmentUpdatedAt`,
        `Shipments`.`Active` AS `ShipmentActive`
    FROM
        (`ShipmentItems`
            JOIN `Shipments` ON ( 1=1 
                and (`ShipmentItems`.`ShipmentItemIdShipmentId` = `Shipments`.`ShipmentId`)
            )
        );


CREATE VIEW `ShipmentReceipt_RV` AS
    SELECT 
        `ShipmentReceipts`.`ShipmentReceiptIdShipmentId`,
        `ShipmentReceipts`.`ShipmentReceiptIdReceiptSeqId`,
        `ShipmentReceipts`.`ProductId`,
        `ShipmentReceipts`.`ShipmentItemSeqId`,
        `ShipmentReceipts`.`RejectionReasonId`,
        `ShipmentReceipts`.`DamageStatusId`,
        `ShipmentReceipts`.`DamageReasonId`,
        `ShipmentReceipts`.`ReceivedBy`,
        `ShipmentReceipts`.`DatetimeReceived`,
        `ShipmentReceipts`.`ItemDescription`,
        `ShipmentReceipts`.`AcceptedQuantity`,
        `ShipmentReceipts`.`RejectedQuantity`,
        `ShipmentReceipts`.`DamagedQuantity`,
        `ShipmentReceipts`.`Version`,
        `ShipmentReceipts`.`CreatedBy`,
        `ShipmentReceipts`.`CreatedAt`,
        `ShipmentReceipts`.`UpdatedBy`,
        `ShipmentReceipts`.`UpdatedAt`,
        `ShipmentReceipts`.`Active`,
        `Shipments`.`ShipmentTypeId` AS `ShipmentShipmentTypeId`,
        `Shipments`.`StatusId` AS `ShipmentStatusId`,
        `Shipments`.`PrimaryOrderId` AS `ShipmentPrimaryOrderId`,
        `Shipments`.`PrimaryReturnId` AS `ShipmentPrimaryReturnId`,
        `Shipments`.`PicklistBinId` AS `ShipmentPicklistBinId`,
        `Shipments`.`EstimatedReadyDate` AS `ShipmentEstimatedReadyDate`,
        `Shipments`.`EstimatedShipDate` AS `ShipmentEstimatedShipDate`,
        `Shipments`.`EstimatedShipWorkEffId` AS `ShipmentEstimatedShipWorkEffId`,
        `Shipments`.`EstimatedArrivalDate` AS `ShipmentEstimatedArrivalDate`,
        `Shipments`.`EstimatedArrivalWorkEffId` AS `ShipmentEstimatedArrivalWorkEffId`,
        `Shipments`.`LatestCancelDate` AS `ShipmentLatestCancelDate`,
        `Shipments`.`EstimatedShipCost` AS `ShipmentEstimatedShipCost`,
        `Shipments`.`CurrencyUomId` AS `ShipmentCurrencyUomId`,
        `Shipments`.`HandlingInstructions` AS `ShipmentHandlingInstructions`,
        `Shipments`.`OriginFacilityId` AS `ShipmentOriginFacilityId`,
        `Shipments`.`DestinationFacilityId` AS `ShipmentDestinationFacilityId`,
        `Shipments`.`OriginContactMechId` AS `ShipmentOriginContactMechId`,
        `Shipments`.`OriginTelecomNumberId` AS `ShipmentOriginTelecomNumberId`,
        `Shipments`.`DestinationContactMechId` AS `ShipmentDestinationContactMechId`,
        `Shipments`.`DestinationTelecomNumberId` AS `ShipmentDestinationTelecomNumberId`,
        `Shipments`.`PartyIdTo` AS `ShipmentPartyIdTo`,
        `Shipments`.`PartyIdFrom` AS `ShipmentPartyIdFrom`,
        `Shipments`.`AdditionalShippingCharge` AS `ShipmentAdditionalShippingCharge`,
        `Shipments`.`AddtlShippingChargeDesc` AS `ShipmentAddtlShippingChargeDesc`,
        `Shipments`.`ShipperId` AS `ShipmentShipperId`,
        `Shipments`.`Version` AS `ShipmentVersion`,
        `Shipments`.`CreatedBy` AS `ShipmentCreatedBy`,
        `Shipments`.`CreatedAt` AS `ShipmentCreatedAt`,
        `Shipments`.`UpdatedBy` AS `ShipmentUpdatedBy`,
        `Shipments`.`UpdatedAt` AS `ShipmentUpdatedAt`,
        `Shipments`.`Active` AS `ShipmentActive`
    FROM
        (`ShipmentReceipts`
            JOIN `Shipments` ON ( 1=1 
                and (`ShipmentReceipts`.`ShipmentReceiptIdShipmentId` = `Shipments`.`ShipmentId`)
            )
        );


