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

alter TABLE `InOutLines` add
  CONSTRAINT `FK_InOutLine_InOut_StateId` 
  FOREIGN KEY 
    (`InOutLineIdInOutDocumentNumber`) 
  REFERENCES `InOuts` 
    (`DocumentNumber`) 
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

alter TABLE `OrderItems` add
  CONSTRAINT `FK_OrderItem_Order_StateId` 
  FOREIGN KEY 
    (`OrderItemIdOrderId`) 
  REFERENCES `Orders` 
    (`OrderId`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION;

alter TABLE `PhysicalInventoryLines` add
  CONSTRAINT `FK_PhysicalInventoryLine_PhysicalInventory_StateId` 
  FOREIGN KEY 
    (`PhysicalInventoryLineIdPhysicalInventoryDocumentNumber`) 
  REFERENCES `PhysicalInventories` 
    (`DocumentNumber`) 
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

