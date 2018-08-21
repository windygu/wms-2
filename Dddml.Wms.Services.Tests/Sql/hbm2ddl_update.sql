
    alter table AttributeSetInstances 
        add column Deleted TINYINT(1);
    alter table InventoryItemEntries 
        add column Deleted TINYINT(1);
    alter table InventoryItemRequirementEntries 
        add column Deleted TINYINT(1);
    alter table SellableInventoryItemEntries 
        add column Deleted TINYINT(1);
    alter table AttributeSetInstanceStatusIds 
        add index (AttributeSetInstanceId), 
        add constraint FK6CFC352E46B90463 
        foreign key (AttributeSetInstanceId) 
        references AttributeSetInstances (AttributeSetInstanceId);
    alter table InOutLineDamageStatusIds 
        add index (InOutLineIdInOutDocumentNumber, InOutLineIdLineNumber), 
        add constraint FK9F1B674E77BC4BCB 
        foreign key (InOutLineIdInOutDocumentNumber, InOutLineIdLineNumber) 
        references InOutLines (InOutLineIdInOutDocumentNumber, InOutLineIdLineNumber);
    alter table ShipmentReceiptDamageStatusIds 
        add index (ShipmentReceiptIdShipmentId, ShipmentReceiptIdReceiptSeqId), 
        add constraint FKB9FCE6E151B2BEEA 
        foreign key (ShipmentReceiptIdShipmentId, ShipmentReceiptIdReceiptSeqId) 
        references ShipmentReceipts (ShipmentReceiptIdShipmentId, ShipmentReceiptIdReceiptSeqId);
    alter table InOutLineStateEventDamageStatusIds 
        add index (InOutLineIdInOutDocumentNumber, InOutLineIdLineNumber, InOutVersion), 
        add constraint FK5BAF3ED4782FA244 
        foreign key (InOutLineIdInOutDocumentNumber, InOutLineIdLineNumber, InOutVersion) 
        references InOutLineEvents (InOutLineIdInOutDocumentNumber, InOutLineIdLineNumber, InOutVersion);
    alter table ShipmentReceiptStateEventDamageStatusIds 
        add index (ShipmentReceiptIdShipmentId, ShipmentReceiptIdReceiptSeqId, ShipmentVersion), 
        add constraint FK4AE85BEE4BB9F015 
        foreign key (ShipmentReceiptIdShipmentId, ShipmentReceiptIdReceiptSeqId, ShipmentVersion) 
        references ShipmentReceiptEvents (ShipmentReceiptIdShipmentId, ShipmentReceiptIdReceiptSeqId, ShipmentVersion);