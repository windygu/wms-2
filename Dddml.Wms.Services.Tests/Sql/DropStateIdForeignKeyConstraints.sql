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
            TABLE_NAME        = 'AttributeSetInstanceExtensionFields' AND
            CONSTRAINT_NAME   = 'FK_AttributeSetInstanceExtensionField_AttrSetInstEFGroup_StateId' AND
            CONSTRAINT_TYPE   = 'FOREIGN KEY') = true,'ALTER TABLE AttributeSetInstanceExtensionFields
            drop foreign key FK_AttributeSetInstanceExtensionField_AttrSetInstEFGroup_StateId','select 1');

prepare stmt from @var;
execute stmt;
deallocate prepare stmt;

