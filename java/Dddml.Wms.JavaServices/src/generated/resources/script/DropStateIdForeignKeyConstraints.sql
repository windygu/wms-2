set @var=if((SELECT true FROM information_schema.TABLE_CONSTRAINTS WHERE
            CONSTRAINT_SCHEMA = DATABASE() AND
            TABLE_NAME        = 'AttributeValues' AND
            CONSTRAINT_NAME   = 'FK_AttributeValue_Attribute_StateId' AND
            CONSTRAINT_TYPE   = 'FOREIGN KEY') = true,'ALTER TABLE AttributeValues
            drop foreign key FK_AttributeValue_Attribute_StateId','select 1');

prepare stmt from @var;
execute stmt;
deallocate prepare stmt;

set @var=if((SELECT true FROM information_schema.TABLE_CONSTRAINTS WHERE
            CONSTRAINT_SCHEMA = DATABASE() AND
            TABLE_NAME        = 'AttributeAlias' AND
            CONSTRAINT_NAME   = 'FK_AttributeAlias_Attribute_StateId' AND
            CONSTRAINT_TYPE   = 'FOREIGN KEY') = true,'ALTER TABLE AttributeAlias
            drop foreign key FK_AttributeAlias_Attribute_StateId','select 1');

prepare stmt from @var;
execute stmt;
deallocate prepare stmt;

set @var=if((SELECT true FROM information_schema.TABLE_CONSTRAINTS WHERE
            CONSTRAINT_SCHEMA = DATABASE() AND
            TABLE_NAME        = 'AttributeUses' AND
            CONSTRAINT_NAME   = 'FK_AttributeUse_AttributeSet_StateId' AND
            CONSTRAINT_TYPE   = 'FOREIGN KEY') = true,'ALTER TABLE AttributeUses
            drop foreign key FK_AttributeUse_AttributeSet_StateId','select 1');

prepare stmt from @var;
execute stmt;
deallocate prepare stmt;

set @var=if((SELECT true FROM information_schema.TABLE_CONSTRAINTS WHERE
            CONSTRAINT_SCHEMA = DATABASE() AND
            TABLE_NAME        = 'InOutLines' AND
            CONSTRAINT_NAME   = 'FK_InOutLine_InOut_StateId' AND
            CONSTRAINT_TYPE   = 'FOREIGN KEY') = true,'ALTER TABLE InOutLines
            drop foreign key FK_InOutLine_InOut_StateId','select 1');

prepare stmt from @var;
execute stmt;
deallocate prepare stmt;

set @var=if((SELECT true FROM information_schema.TABLE_CONSTRAINTS WHERE
            CONSTRAINT_SCHEMA = DATABASE() AND
            TABLE_NAME        = 'InventoryItemEntries' AND
            CONSTRAINT_NAME   = 'FK_InventoryItemEntry_InventoryItem_StateId' AND
            CONSTRAINT_TYPE   = 'FOREIGN KEY') = true,'ALTER TABLE InventoryItemEntries
            drop foreign key FK_InventoryItemEntry_InventoryItem_StateId','select 1');

prepare stmt from @var;
execute stmt;
deallocate prepare stmt;

set @var=if((SELECT true FROM information_schema.TABLE_CONSTRAINTS WHERE
            CONSTRAINT_SCHEMA = DATABASE() AND
            TABLE_NAME        = 'InventoryItemRequirementEntries' AND
            CONSTRAINT_NAME   = 'FK_InventoryItemRequirementEntry_InventoryItemRequirement_StateId' AND
            CONSTRAINT_TYPE   = 'FOREIGN KEY') = true,'ALTER TABLE InventoryItemRequirementEntries
            drop foreign key FK_InventoryItemRequirementEntry_InventoryItemRequirement_StateId','select 1');

prepare stmt from @var;
execute stmt;
deallocate prepare stmt;

set @var=if((SELECT true FROM information_schema.TABLE_CONSTRAINTS WHERE
            CONSTRAINT_SCHEMA = DATABASE() AND
            TABLE_NAME        = 'MovementLines' AND
            CONSTRAINT_NAME   = 'FK_MovementLine_Movement_StateId' AND
            CONSTRAINT_TYPE   = 'FOREIGN KEY') = true,'ALTER TABLE MovementLines
            drop foreign key FK_MovementLine_Movement_StateId','select 1');

prepare stmt from @var;
execute stmt;
deallocate prepare stmt;

set @var=if((SELECT true FROM information_schema.TABLE_CONSTRAINTS WHERE
            CONSTRAINT_SCHEMA = DATABASE() AND
            TABLE_NAME        = 'MovementConfirmationLines' AND
            CONSTRAINT_NAME   = 'FK_MovementConfirmationLine_MovementConfirmation_StateId' AND
            CONSTRAINT_TYPE   = 'FOREIGN KEY') = true,'ALTER TABLE MovementConfirmationLines
            drop foreign key FK_MovementConfirmationLine_MovementConfirmation_StateId','select 1');

prepare stmt from @var;
execute stmt;
deallocate prepare stmt;

set @var=if((SELECT true FROM information_schema.TABLE_CONSTRAINTS WHERE
            CONSTRAINT_SCHEMA = DATABASE() AND
            TABLE_NAME        = 'OrderRoles' AND
            CONSTRAINT_NAME   = 'FK_OrderRole_Order_StateId' AND
            CONSTRAINT_TYPE   = 'FOREIGN KEY') = true,'ALTER TABLE OrderRoles
            drop foreign key FK_OrderRole_Order_StateId','select 1');

prepare stmt from @var;
execute stmt;
deallocate prepare stmt;

set @var=if((SELECT true FROM information_schema.TABLE_CONSTRAINTS WHERE
            CONSTRAINT_SCHEMA = DATABASE() AND
            TABLE_NAME        = 'OrderItems' AND
            CONSTRAINT_NAME   = 'FK_OrderItem_Order_StateId' AND
            CONSTRAINT_TYPE   = 'FOREIGN KEY') = true,'ALTER TABLE OrderItems
            drop foreign key FK_OrderItem_Order_StateId','select 1');

prepare stmt from @var;
execute stmt;
deallocate prepare stmt;

set @var=if((SELECT true FROM information_schema.TABLE_CONSTRAINTS WHERE
            CONSTRAINT_SCHEMA = DATABASE() AND
            TABLE_NAME        = 'OrderShipGroups' AND
            CONSTRAINT_NAME   = 'FK_OrderShipGroup_Order_StateId' AND
            CONSTRAINT_TYPE   = 'FOREIGN KEY') = true,'ALTER TABLE OrderShipGroups
            drop foreign key FK_OrderShipGroup_Order_StateId','select 1');

prepare stmt from @var;
execute stmt;
deallocate prepare stmt;

set @var=if((SELECT true FROM information_schema.TABLE_CONSTRAINTS WHERE
            CONSTRAINT_SCHEMA = DATABASE() AND
            TABLE_NAME        = 'OrderItemShipGroupAssociations' AND
            CONSTRAINT_NAME   = 'FK_OrderItemShipGroupAssociation_OrderShipGroup_StateId' AND
            CONSTRAINT_TYPE   = 'FOREIGN KEY') = true,'ALTER TABLE OrderItemShipGroupAssociations
            drop foreign key FK_OrderItemShipGroupAssociation_OrderShipGroup_StateId','select 1');

prepare stmt from @var;
execute stmt;
deallocate prepare stmt;

set @var=if((SELECT true FROM information_schema.TABLE_CONSTRAINTS WHERE
            CONSTRAINT_SCHEMA = DATABASE() AND
            TABLE_NAME        = 'PhysicalInventoryLines' AND
            CONSTRAINT_NAME   = 'FK_PhysicalInventoryLine_PhysicalInventory_StateId' AND
            CONSTRAINT_TYPE   = 'FOREIGN KEY') = true,'ALTER TABLE PhysicalInventoryLines
            drop foreign key FK_PhysicalInventoryLine_PhysicalInventory_StateId','select 1');

prepare stmt from @var;
execute stmt;
deallocate prepare stmt;

set @var=if((SELECT true FROM information_schema.TABLE_CONSTRAINTS WHERE
            CONSTRAINT_SCHEMA = DATABASE() AND
            TABLE_NAME        = 'PicklistRoles' AND
            CONSTRAINT_NAME   = 'FK_PicklistRole_Picklist_StateId' AND
            CONSTRAINT_TYPE   = 'FOREIGN KEY') = true,'ALTER TABLE PicklistRoles
            drop foreign key FK_PicklistRole_Picklist_StateId','select 1');

prepare stmt from @var;
execute stmt;
deallocate prepare stmt;

set @var=if((SELECT true FROM information_schema.TABLE_CONSTRAINTS WHERE
            CONSTRAINT_SCHEMA = DATABASE() AND
            TABLE_NAME        = 'PicklistItems' AND
            CONSTRAINT_NAME   = 'FK_PicklistItem_PicklistBin_StateId' AND
            CONSTRAINT_TYPE   = 'FOREIGN KEY') = true,'ALTER TABLE PicklistItems
            drop foreign key FK_PicklistItem_PicklistBin_StateId','select 1');

prepare stmt from @var;
execute stmt;
deallocate prepare stmt;

set @var=if((SELECT true FROM information_schema.TABLE_CONSTRAINTS WHERE
            CONSTRAINT_SCHEMA = DATABASE() AND
            TABLE_NAME        = 'SellableInventoryItemEntries' AND
            CONSTRAINT_NAME   = 'FK_SellableInventoryItemEntry_SellableInventoryItem_StateId' AND
            CONSTRAINT_TYPE   = 'FOREIGN KEY') = true,'ALTER TABLE SellableInventoryItemEntries
            drop foreign key FK_SellableInventoryItemEntry_SellableInventoryItem_StateId','select 1');

prepare stmt from @var;
execute stmt;
deallocate prepare stmt;

set @var=if((SELECT true FROM information_schema.TABLE_CONSTRAINTS WHERE
            CONSTRAINT_SCHEMA = DATABASE() AND
            TABLE_NAME        = 'ShipmentItems' AND
            CONSTRAINT_NAME   = 'FK_ShipmentItem_Shipment_StateId' AND
            CONSTRAINT_TYPE   = 'FOREIGN KEY') = true,'ALTER TABLE ShipmentItems
            drop foreign key FK_ShipmentItem_Shipment_StateId','select 1');

prepare stmt from @var;
execute stmt;
deallocate prepare stmt;

set @var=if((SELECT true FROM information_schema.TABLE_CONSTRAINTS WHERE
            CONSTRAINT_SCHEMA = DATABASE() AND
            TABLE_NAME        = 'ShipmentReceipts' AND
            CONSTRAINT_NAME   = 'FK_ShipmentReceipt_Shipment_StateId' AND
            CONSTRAINT_TYPE   = 'FOREIGN KEY') = true,'ALTER TABLE ShipmentReceipts
            drop foreign key FK_ShipmentReceipt_Shipment_StateId','select 1');

prepare stmt from @var;
execute stmt;
deallocate prepare stmt;

set @var=if((SELECT true FROM information_schema.TABLE_CONSTRAINTS WHERE
            CONSTRAINT_SCHEMA = DATABASE() AND
            TABLE_NAME        = 'ItemIssuances' AND
            CONSTRAINT_NAME   = 'FK_ItemIssuance_Shipment_StateId' AND
            CONSTRAINT_TYPE   = 'FOREIGN KEY') = true,'ALTER TABLE ItemIssuances
            drop foreign key FK_ItemIssuance_Shipment_StateId','select 1');

prepare stmt from @var;
execute stmt;
deallocate prepare stmt;

set @var=if((SELECT true FROM information_schema.TABLE_CONSTRAINTS WHERE
            CONSTRAINT_SCHEMA = DATABASE() AND
            TABLE_NAME        = 'ShipmentPackageContents' AND
            CONSTRAINT_NAME   = 'FK_ShipmentPackageContent_ShipmentPackage_StateId' AND
            CONSTRAINT_TYPE   = 'FOREIGN KEY') = true,'ALTER TABLE ShipmentPackageContents
            drop foreign key FK_ShipmentPackageContent_ShipmentPackage_StateId','select 1');

prepare stmt from @var;
execute stmt;
deallocate prepare stmt;

