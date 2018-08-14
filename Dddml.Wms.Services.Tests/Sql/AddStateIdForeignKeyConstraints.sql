alter TABLE `AttributeValues` add
  CONSTRAINT `FK_AttributeValue_Attribute_StateId` 
  FOREIGN KEY 
    (`AttributeValueIdAttributeId`) 
  REFERENCES `Attributes` 
    (`AttributeId`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION;

alter TABLE `AttributeAlias` add
  CONSTRAINT `FK_AttributeAlias_Attribute_StateId` 
  FOREIGN KEY 
    (`AttributeAliasIdAttributeId`) 
  REFERENCES `Attributes` 
    (`AttributeId`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION;

alter TABLE `AttributeUses` add
  CONSTRAINT `FK_AttributeUse_AttributeSet_StateId` 
  FOREIGN KEY 
    (`AttributeSetAttributeUseIdAttributeSetId`) 
  REFERENCES `AttributeSets` 
    (`AttributeSetId`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION;

alter TABLE `InOutImages` add
  CONSTRAINT `FK_InOutImage_InOut_StateId` 
  FOREIGN KEY 
    (`InOutImageIdInOutDocumentNumber`) 
  REFERENCES `InOuts` 
    (`DocumentNumber`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION;

alter TABLE `InOutLines` add
  CONSTRAINT `FK_InOutLine_InOut_StateId` 
  FOREIGN KEY 
    (`InOutLineIdInOutDocumentNumber`) 
  REFERENCES `InOuts` 
    (`DocumentNumber`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION;

alter TABLE `InOutLineImages` add
  CONSTRAINT `FK_InOutLineImage_InOutLine_StateId` 
  FOREIGN KEY 
    (`InOutLineImageIdInOutDocumentNumber`, `InOutLineImageIdInOutLineLineNumber`) 
  REFERENCES `InOutLines` 
    (`InOutLineIdInOutDocumentNumber`, `InOutLineIdLineNumber`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION;

alter TABLE `MovementLines` add
  CONSTRAINT `FK_MovementLine_Movement_StateId` 
  FOREIGN KEY 
    (`MovementLineIdMovementDocumentNumber`) 
  REFERENCES `Movements` 
    (`DocumentNumber`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION;

alter TABLE `MovementConfirmationLines` add
  CONSTRAINT `FK_MovementConfirmationLine_MovementConfirmation_StateId` 
  FOREIGN KEY 
    (`MovementConfirmationLineIdMovementConfirmationDocumentNumber`) 
  REFERENCES `MovementConfirmations` 
    (`DocumentNumber`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION;

alter TABLE `OrderRoles` add
  CONSTRAINT `FK_OrderRole_Order_StateId` 
  FOREIGN KEY 
    (`OrderRoleIdOrderId`) 
  REFERENCES `Orders` 
    (`OrderId`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION;

alter TABLE `OrderItems` add
  CONSTRAINT `FK_OrderItem_Order_StateId` 
  FOREIGN KEY 
    (`OrderItemIdOrderId`) 
  REFERENCES `Orders` 
    (`OrderId`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION;

alter TABLE `OrderShipGroups` add
  CONSTRAINT `FK_OrderShipGroup_Order_StateId` 
  FOREIGN KEY 
    (`OrderShipGroupIdOrderId`) 
  REFERENCES `Orders` 
    (`OrderId`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION;

alter TABLE `OrderItemShipGroupAssociations` add
  CONSTRAINT `FK_OrderItemShipGroupAssociation_OrderShipGroup_StateId` 
  FOREIGN KEY 
    (`OrderItemShipGroupAssociationIdOrderId`, `OrderItemShipGroupAssociationIdOrderShipGroupShipGroupSeqId`) 
  REFERENCES `OrderShipGroups` 
    (`OrderShipGroupIdOrderId`, `OrderShipGroupIdShipGroupSeqId`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION;

alter TABLE `PhysicalInventoryLines` add
  CONSTRAINT `FK_PhysicalInventoryLine_PhysicalInventory_StateId` 
  FOREIGN KEY 
    (`PhysicalInventoryLineIdPhysicalInventoryDocumentNumber`) 
  REFERENCES `PhysicalInventories` 
    (`DocumentNumber`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION;

alter TABLE `PicklistRoles` add
  CONSTRAINT `FK_PicklistRole_Picklist_StateId` 
  FOREIGN KEY 
    (`PicklistRoleIdPicklistId`) 
  REFERENCES `Picklists` 
    (`PicklistId`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION;

alter TABLE `PicklistItems` add
  CONSTRAINT `FK_PicklistItem_PicklistBin_StateId` 
  FOREIGN KEY 
    (`PicklistBinId`) 
  REFERENCES `PicklistBins` 
    (`PicklistBinId`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION;

alter TABLE `GoodIdentifications` add
  CONSTRAINT `FK_GoodIdentification_Product_StateId` 
  FOREIGN KEY 
    (`ProductGoodIdentificationIdProductId`) 
  REFERENCES `Products` 
    (`ProductId`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION;

alter TABLE `ShipmentImages` add
  CONSTRAINT `FK_ShipmentImage_Shipment_StateId` 
  FOREIGN KEY 
    (`ShipmentImageIdShipmentId`) 
  REFERENCES `Shipments` 
    (`ShipmentId`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION;

alter TABLE `ShipmentItems` add
  CONSTRAINT `FK_ShipmentItem_Shipment_StateId` 
  FOREIGN KEY 
    (`ShipmentItemIdShipmentId`) 
  REFERENCES `Shipments` 
    (`ShipmentId`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION;

alter TABLE `ShipmentReceipts` add
  CONSTRAINT `FK_ShipmentReceipt_Shipment_StateId` 
  FOREIGN KEY 
    (`ShipmentReceiptIdShipmentId`) 
  REFERENCES `Shipments` 
    (`ShipmentId`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION;

alter TABLE `ShipmentReceiptImages` add
  CONSTRAINT `FK_ShipmentReceiptImage_ShipmentReceipt_StateId` 
  FOREIGN KEY 
    (`ShipmentReceiptImageIdShipmentId`, `ShipmentReceiptImageIdShipmentReceiptReceiptSeqId`) 
  REFERENCES `ShipmentReceipts` 
    (`ShipmentReceiptIdShipmentId`, `ShipmentReceiptIdReceiptSeqId`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION;

alter TABLE `ItemIssuances` add
  CONSTRAINT `FK_ItemIssuance_Shipment_StateId` 
  FOREIGN KEY 
    (`ShipmentItemIssuanceIdShipmentId`) 
  REFERENCES `Shipments` 
    (`ShipmentId`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION;

alter TABLE `ShipmentPackageContents` add
  CONSTRAINT `FK_ShipmentPackageContent_ShipmentPackage_StateId` 
  FOREIGN KEY 
    (`ShipmentPackageContentIdShipmentPackageIdShipmentId`, `ShipmentPackageContentIdShipmentPackageIdShipmentPackageSeqId`) 
  REFERENCES `ShipmentPackages` 
    (`ShipmentPackageIdShipmentId`, `ShipmentPackageIdShipmentPackageSeqId`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION;

