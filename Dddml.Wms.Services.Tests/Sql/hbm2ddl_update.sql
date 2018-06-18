
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
    create table InOutLine_RV (
        InOutLineIdInOutDocumentNumber VARCHAR(50) not null,
       InOutLineIdLineNumber VARCHAR(50) not null,
       InOutVersion BIGINT not null,
       LocatorId VARCHAR(255),
       ProductId VARCHAR(60),
       AttributeSetInstanceId VARCHAR(255),
       Description VARCHAR(255),
       QuantityUomId VARCHAR(255),
       MovementQuantity NUMERIC(19,5),
       PickedQuantity NUMERIC(19,5),
       IsInvoiced TINYINT(1),
       Processed TINYINT(1),
       RmaLineNumber VARCHAR(255),
       ReversalLineNumber VARCHAR(255),
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
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (InOutLineIdInOutDocumentNumber, InOutLineIdLineNumber)
    );
    create table InventoryItemEntry_RV (
        ProductId VARCHAR(60) not null,
       LocatorId VARCHAR(50) not null,
       AttributeSetInstanceId VARCHAR(50) not null,
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
       SourceLineSeqId INTEGER,
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
      unique (SourceDocumentTypeId, SourceDocumentNumber, SourceLineNumber, SourceLineSeqId)
    );
    create table InventoryItemRequirementEntry_RV (
        ProductId VARCHAR(60) not null,
       LocatorId VARCHAR(50) not null,
       AttributeSetInstanceId VARCHAR(50) not null,
       EntrySeqId BIGINT not null,
       InventoryItemRequirementVersion BIGINT not null,
       Quantity NUMERIC(19,5),
       SrcEventProductId VARCHAR(60),
       SrcEventLocatorId VARCHAR(50),
       SrcEventAttributeSetInstanceId VARCHAR(50),
       SrcEventEntrySeqId BIGINT,
       SrcEventInventoryPostingRuleId VARCHAR(50),
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
    create table MovementLine_RV (
        MovementLineIdMovementDocumentNumber VARCHAR(50) not null,
       MovementLineIdLineNumber VARCHAR(50) not null,
       MovementVersion BIGINT not null,
       MovementQuantity NUMERIC(19,5),
       ProductId VARCHAR(60),
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
    create table OrderRole_RV (
        OrderRoleIdOrderId VARCHAR(20) not null,
       OrderRoleIdPartyRoleIdPartyId VARCHAR(20) not null,
       OrderRoleIdPartyRoleIdRoleTypeId VARCHAR(20) not null,
       OrderVersion BIGINT not null,
       Version BIGINT,
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
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
       primary key (OrderRoleIdOrderId, OrderRoleIdPartyRoleIdPartyId, OrderRoleIdPartyRoleIdRoleTypeId)
    );
    create table OrderItem_RV (
        OrderItemIdOrderId VARCHAR(20) not null,
       OrderItemIdOrderItemSeqId VARCHAR(20) not null,
       OrderVersion BIGINT not null,
       ProductId VARCHAR(60),
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
    create table OrderShipGroup_RV (
        OrderShipGroupIdOrderId VARCHAR(20) not null,
       OrderShipGroupIdShipGroupSeqId DECIMAL(20,0) not null,
       OrderVersion BIGINT not null,
       ShipmentMethodTypeId VARCHAR(20),
       SupplierPartyId VARCHAR(20),
       VendorPartyId VARCHAR(20),
       CarrierPartyId VARCHAR(20),
       CarrierRoleTypeId VARCHAR(20),
       FacilityId VARCHAR(20),
       ContactMechId VARCHAR(20),
       TelecomContactMechId VARCHAR(20),
       TrackingNumber VARCHAR(60),
       ShippingInstructions VARCHAR(255),
       MaySplit CHAR(1),
       GiftMessage VARCHAR(255),
       IsGift CHAR(1),
       ShipAfterDate DATETIME,
       ShipByDate DATETIME,
       EstimatedShipDate DATETIME,
       EstimatedDeliveryDate DATETIME,
       PickwaveId DECIMAL(20,0),
       Version BIGINT,
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
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
       primary key (OrderShipGroupIdOrderId, OrderShipGroupIdShipGroupSeqId)
    );
    create table PhysicalInventoryLine_RV (
        PhysicalInventoryLineIdPhysicalInventoryDocumentNumber VARCHAR(50) not null,
       ProductId VARCHAR(60) not null,
       LocatorId VARCHAR(50) not null,
       AttributeSetInstanceId VARCHAR(50) not null,
       PhysicalInventoryVersion BIGINT not null,
       BookQuantity NUMERIC(19,5),
       CountedQuantity NUMERIC(19,5),
       Processed TINYINT(1),
       LineNumber VARCHAR(50) not null,
       ReversalLineNumber BIGINT,
       Description VARCHAR(255),
       Version BIGINT,
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Deleted TINYINT(1),
       PhysicalInventoryDocumentStatusId VARCHAR(255),
       PhysicalInventoryWarehouseId VARCHAR(255),
       PhysicalInventoryLocatorIdPattern VARCHAR(255),
       PhysicalInventoryProductIdPattern VARCHAR(60),
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
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (PhysicalInventoryLineIdPhysicalInventoryDocumentNumber, ProductId, LocatorId, AttributeSetInstanceId),
      unique (LineNumber)
    );
    create table PicklistRole_RV (
        PicklistRoleIdPicklistId VARCHAR(20) not null,
       PicklistRoleIdPartyRoleIdPartyId VARCHAR(20) not null,
       PicklistRoleIdPartyRoleIdRoleTypeId VARCHAR(20) not null,
       PicklistVersion BIGINT not null,
       CreatedByUserLogin VARCHAR(250),
       LastModifiedByUserLogin VARCHAR(250),
       Version BIGINT,
       Active TINYINT(1),
       Deleted TINYINT(1),
       PicklistDescription VARCHAR(255),
       PicklistFacilityId VARCHAR(20),
       PicklistShipmentMethodTypeId VARCHAR(20),
       PicklistStatusId VARCHAR(20),
       PicklistPicklistDate DATETIME,
       PicklistPickwaveId DECIMAL(20,0),
       PicklistCreatedBy VARCHAR(255),
       PicklistCreatedAt DATETIME,
       PicklistUpdatedBy VARCHAR(255),
       PicklistUpdatedAt DATETIME,
       PicklistActive TINYINT(1),
       PicklistDeleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (PicklistRoleIdPicklistId, PicklistRoleIdPartyRoleIdPartyId, PicklistRoleIdPartyRoleIdRoleTypeId)
    );
    create table PicklistItem_RV (
        PicklistBinId VARCHAR(20) not null,
       OrderId VARCHAR(20) not null,
       OrderItemSeqId VARCHAR(20) not null,
       ShipGroupSeqId DECIMAL(20,0) not null,
       ProductId VARCHAR(60) not null,
       LocatorId VARCHAR(50) not null,
       AttributeSetInstanceId VARCHAR(50) not null,
       PicklistBinVersion BIGINT not null,
       ItemStatusId VARCHAR(20),
       Quantity DECIMAL(18,6),
       Version BIGINT,
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       PicklistBinPicklistId VARCHAR(20),
       PicklistBinBinLocationNumber DECIMAL(20,0),
       PicklistBinPrimaryOrderId VARCHAR(20),
       PicklistBinPrimaryShipGroupSeqId DECIMAL(20,0),
       PicklistBinCreatedBy VARCHAR(255),
       PicklistBinCreatedAt DATETIME,
       PicklistBinUpdatedBy VARCHAR(255),
       PicklistBinUpdatedAt DATETIME,
       PicklistBinActive TINYINT(1),
       PicklistBinDeleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (PicklistBinId, OrderId, OrderItemSeqId, ShipGroupSeqId, ProductId, LocatorId, AttributeSetInstanceId)
    );
    create table SellableInventoryItemEntry_RV (
        ProductId VARCHAR(60) not null,
       LocatorId VARCHAR(50) not null,
       AttributeSetInstanceId VARCHAR(50) not null,
       EntrySeqId BIGINT not null,
       SellableInventoryItemVersion BIGINT not null,
       SellableQuantity NUMERIC(19,5),
       SrcEventProductId VARCHAR(60),
       SrcEventLocatorId VARCHAR(50),
       SrcEventAttributeSetInstanceId VARCHAR(50),
       SrcEventEntrySeqId BIGINT,
       SrcEventInventoryPostingRuleId VARCHAR(50),
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
       ProductId VARCHAR(60),
       AttributeSetInstanceId VARCHAR(255),
       Quantity DECIMAL(18,6) not null,
       ShipmentContentDescription VARCHAR(255),
       Version BIGINT,
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       ShipmentShipmentTypeId VARCHAR(20),
       ShipmentStatusId VARCHAR(20),
       ShipmentPrimaryOrderId VARCHAR(20),
       ShipmentPrimaryReturnId VARCHAR(20),
       ShipmentPrimaryShipGroupSeqId DECIMAL(20,0),
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
    create table ShipmentReceipt_RV (
        ShipmentReceiptIdShipmentId VARCHAR(20) not null,
       ShipmentReceiptIdReceiptSeqId VARCHAR(20) not null,
       ShipmentVersion BIGINT not null,
       ProductId VARCHAR(60),
       AttributeSetInstanceId VARCHAR(255),
       LocatorId VARCHAR(255),
       ShipmentItemSeqId VARCHAR(20),
       ShipmentPackageSeqId VARCHAR(20),
       OrderId VARCHAR(20),
       OrderItemSeqId VARCHAR(20),
       ReturnId VARCHAR(20),
       ReturnItemSeqId VARCHAR(20),
       RejectionReasonId VARCHAR(60),
       DamageStatusId VARCHAR(20),
       DamageReasonId VARCHAR(60),
       ReceivedBy VARCHAR(250),
       DatetimeReceived DATETIME,
       ItemDescription VARCHAR(255),
       AcceptedQuantity DECIMAL(18,6) not null,
       RejectedQuantity DECIMAL(18,6) not null,
       DamagedQuantity DECIMAL(18,6) not null,
       Version BIGINT,
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       ShipmentShipmentTypeId VARCHAR(20),
       ShipmentStatusId VARCHAR(20),
       ShipmentPrimaryOrderId VARCHAR(20),
       ShipmentPrimaryReturnId VARCHAR(20),
       ShipmentPrimaryShipGroupSeqId DECIMAL(20,0),
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
    create table ItemIssuance_RV (
        ShipmentItemIssuanceIdShipmentId VARCHAR(20) not null,
       ShipmentItemIssuanceIdItemIssuanceSeqId VARCHAR(20) not null,
       ShipmentVersion BIGINT not null,
       OrderId VARCHAR(20),
       OrderItemSeqId VARCHAR(20),
       ShipGroupSeqId DECIMAL(20,0),
       ProductId VARCHAR(60),
       LocatorId VARCHAR(50),
       AttributeSetInstanceId VARCHAR(50),
       ShipmentItemSeqId VARCHAR(20),
       FixedAssetId VARCHAR(20),
       MaintHistSeqId VARCHAR(20),
       IssuedDateTime DATETIME,
       IssuedByUserLoginId VARCHAR(250),
       Quantity DECIMAL(18,6),
       CancelQuantity DECIMAL(18,6),
       Version BIGINT,
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       ShipmentShipmentTypeId VARCHAR(20),
       ShipmentStatusId VARCHAR(20),
       ShipmentPrimaryOrderId VARCHAR(20),
       ShipmentPrimaryReturnId VARCHAR(20),
       ShipmentPrimaryShipGroupSeqId DECIMAL(20,0),
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
       primary key (ShipmentItemIssuanceIdShipmentId, ShipmentItemIssuanceIdItemIssuanceSeqId)
    );
    create table ShipmentPackageContent_RV (
        ShipmentPackageContentIdShipmentPackageIdShipmentId VARCHAR(20) not null,
       ShipmentPackageContentIdShipmentPackageIdShipmentPackageSeqId VARCHAR(20) not null,
       ShipmentPackageContentIdShipmentItemSeqId VARCHAR(20) not null,
       ShipmentPackageVersion BIGINT not null,
       Quantity DECIMAL(18,6),
       SubProductId VARCHAR(20),
       SubProductQuantity DECIMAL(18,6),
       Version BIGINT,
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       ShipmentPackageShipmentBoxTypeId VARCHAR(20),
       ShipmentPackageDateCreated DATETIME,
       ShipmentPackageBoxLength DECIMAL(18,6),
       ShipmentPackageBoxHeight DECIMAL(18,6),
       ShipmentPackageBoxWidth DECIMAL(18,6),
       ShipmentPackageDimensionUomId VARCHAR(20),
       ShipmentPackageWeight DECIMAL(18,6),
       ShipmentPackageWeightUomId VARCHAR(20),
       ShipmentPackageInsuredValue DECIMAL(18,2),
       ShipmentPackageCreatedBy VARCHAR(255),
       ShipmentPackageCreatedAt DATETIME,
       ShipmentPackageUpdatedBy VARCHAR(255),
       ShipmentPackageUpdatedAt DATETIME,
       ShipmentPackageActive TINYINT(1),
       ShipmentPackageDeleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (ShipmentPackageContentIdShipmentPackageIdShipmentId, ShipmentPackageContentIdShipmentPackageIdShipmentPackageSeqId, ShipmentPackageContentIdShipmentItemSeqId)
    );
    create table OrderItemShipGroupAssociation_RV (
        OrderItemShipGroupAssociationIdOrderId VARCHAR(20) not null,
       OrderItemShipGroupAssociationIdOrderShipGroupShipGroupSeqId DECIMAL(20,0) not null,
       OrderItemShipGroupAssociationIdOrderItemSeqId VARCHAR(20) not null,
       OrderVersion BIGINT not null,
       Quantity DECIMAL(18,6),
       CancelQuantity DECIMAL(18,6),
       Version BIGINT,
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       OrderShipGroupShipmentMethodTypeId VARCHAR(20),
       OrderShipGroupSupplierPartyId VARCHAR(20),
       OrderShipGroupVendorPartyId VARCHAR(20),
       OrderShipGroupCarrierPartyId VARCHAR(20),
       OrderShipGroupCarrierRoleTypeId VARCHAR(20),
       OrderShipGroupFacilityId VARCHAR(20),
       OrderShipGroupContactMechId VARCHAR(20),
       OrderShipGroupTelecomContactMechId VARCHAR(20),
       OrderShipGroupTrackingNumber VARCHAR(60),
       OrderShipGroupShippingInstructions VARCHAR(255),
       OrderShipGroupMaySplit CHAR(1),
       OrderShipGroupGiftMessage VARCHAR(255),
       OrderShipGroupIsGift CHAR(1),
       OrderShipGroupShipAfterDate DATETIME,
       OrderShipGroupShipByDate DATETIME,
       OrderShipGroupEstimatedShipDate DATETIME,
       OrderShipGroupEstimatedDeliveryDate DATETIME,
       OrderShipGroupPickwaveId DECIMAL(20,0),
       OrderShipGroupVersion BIGINT,
       OrderShipGroupCreatedBy VARCHAR(255),
       OrderShipGroupCreatedAt DATETIME,
       OrderShipGroupUpdatedBy VARCHAR(255),
       OrderShipGroupUpdatedAt DATETIME,
       OrderShipGroupActive TINYINT(1),
       OrderShipGroupDeleted TINYINT(1),
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
       primary key (OrderItemShipGroupAssociationIdOrderId, OrderItemShipGroupAssociationIdOrderShipGroupShipGroupSeqId, OrderItemShipGroupAssociationIdOrderItemSeqId)
    );
    create table GoodIdentification_RV (
        ProductGoodIdentificationIdProductId VARCHAR(60) not null,
       ProductGoodIdentificationIdGoodIdentificationTypeId VARCHAR(20) not null,
       ProductVersion BIGINT not null,
       IdValue VARCHAR(60) not null,
       Version BIGINT,
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       ProductProductTypeId VARCHAR(20),
       ProductPrimaryProductCategoryId VARCHAR(20),
       ProductManufacturerPartyId VARCHAR(20),
       ProductFacilityId VARCHAR(20),
       ProductIntroductionDate DATETIME,
       ProductReleaseDate DATETIME,
       ProductSupportDiscontinuationDate DATETIME,
       ProductSalesDiscontinuationDate DATETIME,
       ProductSalesDiscWhenNotAvail CHAR(1),
       ProductInternalName VARCHAR(255),
       ProductBrandName VARCHAR(100),
       ProductComments VARCHAR(255),
       ProductProductName VARCHAR(100),
       ProductDescription VARCHAR(255),
       ProductPriceDetailText VARCHAR(255),
       ProductSmallImageUrl VARCHAR(2000),
       ProductMediumImageUrl VARCHAR(2000),
       ProductLargeImageUrl VARCHAR(2000),
       ProductDetailImageUrl VARCHAR(2000),
       ProductOriginalImageUrl VARCHAR(2000),
       ProductDetailScreen VARCHAR(255),
       ProductInventoryMessage VARCHAR(255),
       ProductInventoryItemTypeId VARCHAR(20),
       ProductRequireInventory CHAR(1),
       ProductQuantityUomId VARCHAR(20),
       ProductQuantityIncluded DECIMAL(18,6),
       ProductPiecesIncluded DECIMAL(20,0),
       ProductRequireAmount CHAR(1),
       ProductFixedAmount DECIMAL(18,2),
       ProductAmountUomTypeId VARCHAR(20),
       ProductWeightUomId VARCHAR(20),
       ProductShippingWeight DECIMAL(18,6),
       ProductProductWeight DECIMAL(18,6),
       ProductHeightUomId VARCHAR(20),
       ProductProductHeight DECIMAL(18,6),
       ProductShippingHeight DECIMAL(18,6),
       ProductWidthUomId VARCHAR(20),
       ProductProductWidth DECIMAL(18,6),
       ProductShippingWidth DECIMAL(18,6),
       ProductDepthUomId VARCHAR(20),
       ProductProductDepth DECIMAL(18,6),
       ProductShippingDepth DECIMAL(18,6),
       ProductDiameterUomId VARCHAR(20),
       ProductProductDiameter DECIMAL(18,6),
       ProductProductRating DECIMAL(18,6),
       ProductRatingTypeEnum VARCHAR(20),
       ProductReturnable CHAR(1),
       ProductTaxable CHAR(1),
       ProductChargeShipping CHAR(1),
       ProductAutoCreateKeywords CHAR(1),
       ProductIncludeInPromotions CHAR(1),
       ProductIsVirtual CHAR(1),
       ProductIsVariant CHAR(1),
       ProductVirtualVariantMethodEnum VARCHAR(20),
       ProductInShippingBox CHAR(1),
       ProductDefaultShipmentBoxTypeId VARCHAR(20),
       ProductIsSerialNumbered TINYINT(1),
       ProductIsManagedByLot TINYINT(1),
       ProductAttributeSetId VARCHAR(255),
       ProductAttributeSetInstanceId VARCHAR(255),
       ProductCreatedBy VARCHAR(255),
       ProductCreatedAt DATETIME,
       ProductUpdatedBy VARCHAR(255),
       ProductUpdatedAt DATETIME,
       ProductActive TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (ProductGoodIdentificationIdProductId, ProductGoodIdentificationIdGoodIdentificationTypeId)
    );