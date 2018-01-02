
    create table AttributeValue_RV (
        AttributeValueIdAttributeId VARCHAR(50) not null,
       AttributeValueIdValue VARCHAR(50) not null,
       AttributeVersion BIGINT not null,
       AttributeValueName VARCHAR(255),
       Description VARCHAR(255),
       ReferenceId VARCHAR(255),
       Version BIGINT,
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       AttributeAttributeName VARCHAR(255),
       AttributeOrganizationId VARCHAR(255),
       AttributeDescription VARCHAR(255),
       AttributeIsMandatory TINYINT(1),
       AttributeAttributeValueType VARCHAR(255),
       AttributeAttributeValueLength INTEGER,
       AttributeIsList TINYINT(1),
       AttributeFieldName VARCHAR(255),
       AttributeReferenceId VARCHAR(255),
       AttributeCreatedBy VARCHAR(255),
       AttributeCreatedAt DATETIME,
       AttributeUpdatedBy VARCHAR(255),
       AttributeUpdatedAt DATETIME,
       AttributeActive TINYINT(1),
       AttributeDeleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (AttributeValueIdAttributeId, AttributeValueIdValue)
    );
    create table AttributeUse_RV (
        AttributeSetAttributeUseIdAttributeSetId VARCHAR(50) not null,
       AttributeSetAttributeUseIdAttributeId VARCHAR(50) not null,
       AttributeSetVersion BIGINT not null,
       SequenceNumber INTEGER,
       Version BIGINT,
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       AttributeSetAttributeSetName VARCHAR(255),
       AttributeSetOrganizationId VARCHAR(255),
       AttributeSetDescription VARCHAR(255),
       AttributeSetReferenceId VARCHAR(255),
       AttributeSetIsInstanceAttributeSet TINYINT(1),
       AttributeSetIsMandatory TINYINT(1),
       AttributeSetCreatedBy VARCHAR(255),
       AttributeSetCreatedAt DATETIME,
       AttributeSetUpdatedBy VARCHAR(255),
       AttributeSetUpdatedAt DATETIME,
       AttributeSetActive TINYINT(1),
       AttributeSetDeleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (AttributeSetAttributeUseIdAttributeSetId, AttributeSetAttributeUseIdAttributeId)
    );
    create table AttributeAlias_RV (
        AttributeAliasIdAttributeId VARCHAR(50) not null,
       AttributeAliasIdCode VARCHAR(50) not null,
       AttributeVersion BIGINT not null,
       Name VARCHAR(255),
       Version BIGINT,
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       AttributeAttributeName VARCHAR(255),
       AttributeOrganizationId VARCHAR(255),
       AttributeDescription VARCHAR(255),
       AttributeIsMandatory TINYINT(1),
       AttributeAttributeValueType VARCHAR(255),
       AttributeAttributeValueLength INTEGER,
       AttributeIsList TINYINT(1),
       AttributeFieldName VARCHAR(255),
       AttributeReferenceId VARCHAR(255),
       AttributeCreatedBy VARCHAR(255),
       AttributeCreatedAt DATETIME,
       AttributeUpdatedBy VARCHAR(255),
       AttributeUpdatedAt DATETIME,
       AttributeActive TINYINT(1),
       AttributeDeleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (AttributeAliasIdAttributeId, AttributeAliasIdCode),
      unique (AttributeAliasIdCode),
      unique (Name)
    );
    create table InOutLine_RV (
        InOutLineIdInOutDocumentNumber VARCHAR(50) not null,
       InOutLineIdLineNumber VARCHAR(50) not null,
       InOutVersion BIGINT not null,
       LocatorId VARCHAR(255),
       ProductId VARCHAR(255),
       AttributeSetInstanceId VARCHAR(255),
       Description VARCHAR(255),
       QuantityUomId VARCHAR(255),
       MovementQuantity NUMERIC(19,5),
       PickedQuantity NUMERIC(19,5),
       IsInvoiced TINYINT(1),
       Processed TINYINT(1),
       RmaLineNumber BIGINT,
       ReversalLineNumber BIGINT,
       Version BIGINT,
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       InOutDocumentStatusId VARCHAR(255),
       InOutPosted TINYINT(1),
       InOutProcessed TINYINT(1),
       InOutProcessing VARCHAR(255),
       InOutDocumentTypeId VARCHAR(255),
       InOutDescription VARCHAR(255),
       InOutOrderId VARCHAR(255),
       InOutDateOrdered DATETIME,
       InOutIsPrinted TINYINT(1),
       InOutMovementTypeId VARCHAR(255),
       InOutMovementDate DATETIME,
       InOutBusinessPartnerId VARCHAR(255),
       InOutWarehouseId VARCHAR(255),
       InOutPOReference VARCHAR(255),
       InOutFreightAmount NUMERIC(19,5),
       InOutShipperId VARCHAR(255),
       InOutChargeAmount NUMERIC(19,5),
       InOutDatePrinted DATETIME,
       InOutCreatedFrom VARCHAR(255),
       InOutSalesRepresentativeId VARCHAR(255),
       InOutNumberOfPackages INTEGER,
       InOutPickDate DATETIME,
       InOutShipDate DATETIME,
       InOutTrackingNumber VARCHAR(255),
       InOutDateReceived DATETIME,
       InOutIsInTransit TINYINT(1),
       InOutIsApproved TINYINT(1),
       InOutIsInDispute TINYINT(1),
       InOutRmaDocumentNumber VARCHAR(255),
       InOutReversalDocumentNumber VARCHAR(255),
       InOutCreatedBy VARCHAR(255),
       InOutCreatedAt DATETIME,
       InOutUpdatedBy VARCHAR(255),
       InOutUpdatedAt DATETIME,
       InOutActive TINYINT(1),
       InOutDeleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (InOutLineIdInOutDocumentNumber, InOutLineIdLineNumber)
    );
    create table InventoryItemEntry_RV (
        ProductId VARCHAR(255) not null,
       LocatorId VARCHAR(255) not null,
       AttributeSetInstanceId VARCHAR(255) not null,
       EntrySeqId BIGINT not null,
       InventoryItemVersion BIGINT not null,
       OnHandQuantity NUMERIC(19,5),
       InTransitQuantity NUMERIC(19,5),
       ReservedQuantity NUMERIC(19,5),
       OccupiedQuantity NUMERIC(19,5),
       VirtualQuantity NUMERIC(19,5),
       SourceDocumentTypeId VARCHAR(255) not null,
       SourceDocumentNumber VARCHAR(255) not null,
       SourceLineNumber VARCHAR(255),
       Version BIGINT,
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       InventoryItemOnHandQuantity NUMERIC(19,5),
       InventoryItemInTransitQuantity NUMERIC(19,5),
       InventoryItemReservedQuantity NUMERIC(19,5),
       InventoryItemOccupiedQuantity NUMERIC(19,5),
       InventoryItemVirtualQuantity NUMERIC(19,5),
       InventoryItemCreatedBy VARCHAR(255),
       InventoryItemCreatedAt DATETIME,
       InventoryItemUpdatedBy VARCHAR(255),
       InventoryItemUpdatedAt DATETIME,
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (ProductId, LocatorId, AttributeSetInstanceId, EntrySeqId),
      unique (SourceDocumentTypeId, SourceDocumentNumber, SourceLineNumber)
    );
    create table InventoryItemRequirementEntry_RV (
        ProductId VARCHAR(255) not null,
       LocatorId VARCHAR(255) not null,
       AttributeSetInstanceId VARCHAR(255) not null,
       EntrySeqId BIGINT not null,
       InventoryItemRequirementVersion BIGINT not null,
       Quantity NUMERIC(19,5),
       SrcEventProductId VARCHAR(255),
       SrcEventLocatorId VARCHAR(255),
       SrcEventAttributeSetInstanceId VARCHAR(255),
       SrcEventEntrySeqId BIGINT,
       SrcEventInventoryPostingRuleId VARCHAR(255),
       Version BIGINT,
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       InventoryItemRequirementQuantity NUMERIC(19,5),
       InventoryItemRequirementCreatedBy VARCHAR(255),
       InventoryItemRequirementCreatedAt DATETIME,
       InventoryItemRequirementUpdatedBy VARCHAR(255),
       InventoryItemRequirementUpdatedAt DATETIME,
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (ProductId, LocatorId, AttributeSetInstanceId, EntrySeqId),
      unique (SrcEventProductId, SrcEventLocatorId, SrcEventAttributeSetInstanceId, SrcEventEntrySeqId, SrcEventInventoryPostingRuleId)
    );
    create table OrderItem_RV (
        OrderItemIdOrderId VARCHAR(20) not null,
       OrderItemIdOrderItemSeqId VARCHAR(20) not null,
       OrderVersion BIGINT not null,
       ProductId VARCHAR(20),
       ExternalProductId VARCHAR(60),
       Quantity DECIMAL(18,6),
       CancelQuantity DECIMAL(18,6),
       SelectedAmount DECIMAL(18,6),
       ExternalId VARCHAR(20),
       OrderItemTypeId VARCHAR(20),
       OrderItemGroupSeqId VARCHAR(20),
       IsItemGroupPrimary CHAR(1),
       FromInventoryItemId VARCHAR(20),
       IsPromo CHAR(1),
       QuoteId VARCHAR(20),
       QuoteItemSeqId VARCHAR(20),
       ShoppingListId VARCHAR(20),
       ShoppingListItemSeqId VARCHAR(20),
       UnitPrice DECIMAL(18,3),
       UnitListPrice DECIMAL(18,3),
       UnitAverageCost DECIMAL(18,2),
       UnitRecurringPrice DECIMAL(18,2),
       IsModifiedPrice CHAR(1),
       RecurringFreqUomId VARCHAR(20),
       ItemDescription VARCHAR(255),
       Comments VARCHAR(255),
       CorrespondingPoId VARCHAR(20),
       StatusId VARCHAR(20),
       SyncStatusId VARCHAR(20),
       EstimatedShipDate DATETIME,
       EstimatedDeliveryDate DATETIME,
       AutoCancelDate DATETIME,
       DontCancelSetDate DATETIME,
       DontCancelSetBy VARCHAR(250),
       ShipBeforeDate DATETIME,
       ShipAfterDate DATETIME,
       CancelBackOrderDate DATETIME,
       OverrideGlAccountId VARCHAR(20),
       Version BIGINT,
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       OrderOrderTypeId VARCHAR(20),
       OrderOrderName VARCHAR(100),
       OrderExternalId VARCHAR(20),
       OrderSalesChannelEnumId VARCHAR(20),
       OrderOrderDate DATETIME,
       OrderPriority CHAR(1),
       OrderEntryDate DATETIME,
       OrderPickSheetPrintedDate DATETIME,
       OrderStatusId VARCHAR(20),
       OrderCurrencyUom VARCHAR(20),
       OrderSyncStatusId VARCHAR(20),
       OrderBillingAccountId VARCHAR(20),
       OrderOriginFacilityId VARCHAR(20),
       OrderWebSiteId VARCHAR(20),
       OrderProductStoreId VARCHAR(20),
       OrderTerminalId VARCHAR(60),
       OrderTransactionId VARCHAR(60),
       OrderAutoOrderShoppingListId VARCHAR(20),
       OrderNeedsInventoryIssuance CHAR(1),
       OrderIsRushOrder CHAR(1),
       OrderInternalCode VARCHAR(60),
       OrderRemainingSubTotal DECIMAL(18,2),
       OrderGrandTotal DECIMAL(18,2),
       OrderInvoicePerShipment CHAR(1),
       OrderCreatedBy VARCHAR(255),
       OrderCreatedAt DATETIME,
       OrderUpdatedBy VARCHAR(255),
       OrderUpdatedAt DATETIME,
       OrderActive TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (OrderItemIdOrderId, OrderItemIdOrderItemSeqId)
    );
    create table SellableInventoryItemEntry_RV (
        ProductId VARCHAR(255) not null,
       LocatorId VARCHAR(255) not null,
       AttributeSetInstanceId VARCHAR(255) not null,
       EntrySeqId BIGINT not null,
       SellableInventoryItemVersion BIGINT not null,
       SellableQuantity NUMERIC(19,5),
       SrcEventProductId VARCHAR(255),
       SrcEventLocatorId VARCHAR(255),
       SrcEventAttributeSetInstanceId VARCHAR(255),
       SrcEventEntrySeqId BIGINT,
       SrcEventInventoryPostingRuleId VARCHAR(255),
       Version BIGINT,
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       SellableInventoryItemSellableQuantity NUMERIC(19,5),
       SellableInventoryItemCreatedBy VARCHAR(255),
       SellableInventoryItemCreatedAt DATETIME,
       SellableInventoryItemUpdatedBy VARCHAR(255),
       SellableInventoryItemUpdatedAt DATETIME,
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (ProductId, LocatorId, AttributeSetInstanceId, EntrySeqId),
      unique (SrcEventProductId, SrcEventLocatorId, SrcEventAttributeSetInstanceId, SrcEventEntrySeqId, SrcEventInventoryPostingRuleId)
    );
    create table ShipmentItem_RV (
        ShipmentItemIdShipmentId VARCHAR(20) not null,
       ShipmentItemIdShipmentItemSeqId VARCHAR(20) not null,
       ShipmentVersion BIGINT not null,
       ProductId VARCHAR(20),
       AttributeSetInstanceId VARCHAR(255),
       Quantity DECIMAL(18,6),
       ShipmentContentDescription VARCHAR(255),
       Version BIGINT,
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       ShipmentShipmentTypeId VARCHAR(20),
       ShipmentStatusId VARCHAR(20),
       ShipmentPrimaryOrderId VARCHAR(20),
       ShipmentPrimaryReturnId VARCHAR(20),
       ShipmentPicklistBinId VARCHAR(20),
       ShipmentEstimatedReadyDate DATETIME,
       ShipmentEstimatedShipDate DATETIME,
       ShipmentEstimatedShipWorkEffId VARCHAR(20),
       ShipmentEstimatedArrivalDate DATETIME,
       ShipmentEstimatedArrivalWorkEffId VARCHAR(20),
       ShipmentLatestCancelDate DATETIME,
       ShipmentEstimatedShipCost DECIMAL(18,2),
       ShipmentCurrencyUomId VARCHAR(20),
       ShipmentHandlingInstructions VARCHAR(255),
       ShipmentOriginFacilityId VARCHAR(20),
       ShipmentDestinationFacilityId VARCHAR(20),
       ShipmentOriginContactMechId VARCHAR(20),
       ShipmentOriginTelecomNumberId VARCHAR(20),
       ShipmentDestinationContactMechId VARCHAR(20),
       ShipmentDestinationTelecomNumberId VARCHAR(20),
       ShipmentPartyIdTo VARCHAR(20),
       ShipmentPartyIdFrom VARCHAR(20),
       ShipmentAdditionalShippingCharge DECIMAL(18,2),
       ShipmentAddtlShippingChargeDesc VARCHAR(255),
       ShipmentCreatedBy VARCHAR(255),
       ShipmentCreatedAt DATETIME,
       ShipmentUpdatedBy VARCHAR(255),
       ShipmentUpdatedAt DATETIME,
       ShipmentActive TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (ShipmentItemIdShipmentId, ShipmentItemIdShipmentItemSeqId)
    );
    create table MovementLine_RV (
        MovementLineIdMovementDocumentNumber VARCHAR(50) not null,
       MovementLineIdLineNumber VARCHAR(50) not null,
       MovementVersion BIGINT not null,
       MovementQuantity NUMERIC(19,5),
       ProductId VARCHAR(255),
       LocatorIdFrom VARCHAR(255),
       LocatorIdTo VARCHAR(255),
       AttributeSetInstanceId VARCHAR(255),
       Processed TINYINT(1),
       ReversalLineNumber VARCHAR(255),
       Version BIGINT,
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       MovementDocumentStatusId VARCHAR(255),
       MovementMovementDate DATETIME,
       MovementPosted TINYINT(1),
       MovementProcessed TINYINT(1),
       MovementProcessing VARCHAR(255),
       MovementDateReceived DATETIME,
       MovementDocumentTypeId VARCHAR(255),
       MovementIsInTransit TINYINT(1),
       MovementIsApproved TINYINT(1),
       MovementApprovalAmount NUMERIC(19,5),
       MovementShipperId VARCHAR(255),
       MovementSalesRepresentativeId VARCHAR(255),
       MovementBusinessPartnerId VARCHAR(255),
       MovementChargeAmount NUMERIC(19,5),
       MovementCreateFrom VARCHAR(255),
       MovementFreightAmount NUMERIC(19,5),
       MovementReversalDocumentNumber VARCHAR(255),
       MovementWarehouseIdFrom VARCHAR(255),
       MovementWarehouseIdTo VARCHAR(255),
       MovementDescription VARCHAR(255),
       MovementCreatedBy VARCHAR(255),
       MovementCreatedAt DATETIME,
       MovementUpdatedBy VARCHAR(255),
       MovementUpdatedAt DATETIME,
       MovementActive TINYINT(1),
       MovementDeleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (MovementLineIdMovementDocumentNumber, MovementLineIdLineNumber)
    );
    create table MovementConfirmationLine_RV (
        MovementConfirmationLineIdMovementConfirmationDocumentNumber VARCHAR(50) not null,
       MovementConfirmationLineIdLineNumber VARCHAR(50) not null,
       MovementConfirmationVersion BIGINT not null,
       MovementLineNumber VARCHAR(255),
       TargetQuantity NUMERIC(19,5),
       ConfirmedQuantity NUMERIC(19,5),
       DifferenceQuantity NUMERIC(19,5),
       ScrappedQuantity NUMERIC(19,5),
       Description VARCHAR(255),
       Processed TINYINT(1),
       Version BIGINT,
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       MovementConfirmationDocumentStatusId VARCHAR(255),
       MovementConfirmationMovementDocumentNumber VARCHAR(255),
       MovementConfirmationIsApproved TINYINT(1),
       MovementConfirmationApprovalAmount NUMERIC(19,5),
       MovementConfirmationProcessed TINYINT(1),
       MovementConfirmationProcessing VARCHAR(255),
       MovementConfirmationDocumentTypeId VARCHAR(255),
       MovementConfirmationDescription VARCHAR(255),
       MovementConfirmationCreatedBy VARCHAR(255),
       MovementConfirmationCreatedAt DATETIME,
       MovementConfirmationUpdatedBy VARCHAR(255),
       MovementConfirmationUpdatedAt DATETIME,
       MovementConfirmationActive TINYINT(1),
       MovementConfirmationDeleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (MovementConfirmationLineIdMovementConfirmationDocumentNumber, MovementConfirmationLineIdLineNumber)
    );
    create table PhysicalInventoryLine_RV (
        PhysicalInventoryLineIdPhysicalInventoryDocumentNumber VARCHAR(50) not null,
       PhysicalInventoryLineIdLineNumber VARCHAR(50) not null,
       PhysicalInventoryVersion BIGINT not null,
       LocatorId VARCHAR(255),
       ProductId VARCHAR(255),
       AttributeSetInstanceId VARCHAR(255),
       BookQuantity NUMERIC(19,5),
       CountedQuantity NUMERIC(19,5),
       Processed TINYINT(1),
       ReversalLineNumber BIGINT,
       Description VARCHAR(255),
       Version BIGINT,
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       PhysicalInventoryDocumentStatusId VARCHAR(255),
       PhysicalInventoryWarehouseId VARCHAR(255),
       PhysicalInventoryPosted TINYINT(1),
       PhysicalInventoryProcessed TINYINT(1),
       PhysicalInventoryProcessing VARCHAR(255),
       PhysicalInventoryDocumentTypeId VARCHAR(255),
       PhysicalInventoryMovementDate DATETIME,
       PhysicalInventoryDescription VARCHAR(255),
       PhysicalInventoryIsApproved TINYINT(1),
       PhysicalInventoryApprovalAmount NUMERIC(19,5),
       PhysicalInventoryIsQuantityUpdated TINYINT(1),
       PhysicalInventoryReversalDocumentNumber VARCHAR(255),
       PhysicalInventoryCreatedBy VARCHAR(255),
       PhysicalInventoryCreatedAt DATETIME,
       PhysicalInventoryUpdatedBy VARCHAR(255),
       PhysicalInventoryUpdatedAt DATETIME,
       PhysicalInventoryActive TINYINT(1),
       PhysicalInventoryDeleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (PhysicalInventoryLineIdPhysicalInventoryDocumentNumber, PhysicalInventoryLineIdLineNumber)
    );
    alter table ShipmentReceipts 
        add column DamagedQuantity DECIMAL(18,6);
    alter table ShipmentReceiptStateEvents 
        add column DamagedQuantity DECIMAL(18,6);
    alter table ShipmentReceiptStateEvents 
        add column IsPropertyDamagedQuantityRemoved TINYINT(1);
    create table ShipmentReceipt_RV (
        ShipmentReceiptIdShipmentId VARCHAR(20) not null,
       ShipmentReceiptIdReceiptSeqId VARCHAR(20) not null,
       ShipmentVersion BIGINT not null,
       ProductId VARCHAR(20),
       ShipmentItemSeqId VARCHAR(20),
       RejectionReasonId VARCHAR(20),
       DamageStatusId VARCHAR(20),
       DamageReasonId VARCHAR(20),
       ItemDescription VARCHAR(255),
       AcceptedQuantity DECIMAL(18,6),
       RejectedQuantity DECIMAL(18,6),
       DamagedQuantity DECIMAL(18,6),
       Version BIGINT,
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       ShipmentShipmentTypeId VARCHAR(20),
       ShipmentStatusId VARCHAR(20),
       ShipmentPrimaryOrderId VARCHAR(20),
       ShipmentPrimaryReturnId VARCHAR(20),
       ShipmentPicklistBinId VARCHAR(20),
       ShipmentEstimatedReadyDate DATETIME,
       ShipmentEstimatedShipDate DATETIME,
       ShipmentEstimatedShipWorkEffId VARCHAR(20),
       ShipmentEstimatedArrivalDate DATETIME,
       ShipmentEstimatedArrivalWorkEffId VARCHAR(20),
       ShipmentLatestCancelDate DATETIME,
       ShipmentEstimatedShipCost DECIMAL(18,2),
       ShipmentCurrencyUomId VARCHAR(20),
       ShipmentHandlingInstructions VARCHAR(255),
       ShipmentOriginFacilityId VARCHAR(20),
       ShipmentDestinationFacilityId VARCHAR(20),
       ShipmentOriginContactMechId VARCHAR(20),
       ShipmentOriginTelecomNumberId VARCHAR(20),
       ShipmentDestinationContactMechId VARCHAR(20),
       ShipmentDestinationTelecomNumberId VARCHAR(20),
       ShipmentPartyIdTo VARCHAR(20),
       ShipmentPartyIdFrom VARCHAR(20),
       ShipmentAdditionalShippingCharge DECIMAL(18,2),
       ShipmentAddtlShippingChargeDesc VARCHAR(255),
       ShipmentCreatedBy VARCHAR(255),
       ShipmentCreatedAt DATETIME,
       ShipmentUpdatedBy VARCHAR(255),
       ShipmentUpdatedAt DATETIME,
       ShipmentActive TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (ShipmentReceiptIdShipmentId, ShipmentReceiptIdReceiptSeqId)
    );
    alter table ShipmentReceiptMvoStateEvents 
        add column DamagedQuantity DECIMAL(18,6);
    alter table ShipmentReceiptMvoStateEvents 
        add column IsPropertyDamagedQuantityRemoved TINYINT(1);