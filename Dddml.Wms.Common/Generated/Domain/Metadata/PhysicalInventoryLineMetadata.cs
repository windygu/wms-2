﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateDomainMetadata.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.PhysicalInventory;
using Dddml.Wms.Domain.InventoryItem;

namespace Dddml.Wms.Domain.Metadata
{

    public class PhysicalInventoryLineMetadata
    {
        private static PropertyMetadata[] _properties = new PropertyMetadata[]{
                new PropertyMetadata {
                    Name = "InventoryItemId",
                    Type = typeof(InventoryItemId),
                    TypeName = "InventoryItemId",
                    IsSimpleValueObjectType = false,
                    IsNullableType = false,
                    DisplayName = "",
                    Description = "",
                    Length = 0,
                    GenericTypeName = "",
                    ReferenceTypeName = "",
                    ReferenceName = "",
                    ItemTypeName = "",
                    InverseOf = "",
                    IsHoisted = false,
                    IsId = true,
                    IsGlobalId = false,
                    IsDerived = true,
                    IsOuterId = true,
                    DerivedFrom = "PhysicalInventoryLineId.InventoryItemId",
                    IsDiscriminator = false,
                    IsReservedProperty = false,
                    IsReservedPropertyVersion = false,
                    IsReservedPropertyDeleted = false,
                    IsReservedPropertyActive = false,
                    IsReservedPropertyCreatedBy = false,
                    IsReservedPropertyCreatedAt = false,
                    IsReservedPropertyUpdatedBy = false,
                    IsReservedPropertyUpdatedAt = false,
                    IsFilteringProperty = false,
                },
                new PropertyMetadata {
                    Name = "BookQuantity",
                    Type = typeof(decimal),
                    TypeName = "decimal",
                    IsSimpleValueObjectType = true,
                    IsNullableType = false,
                    DisplayName = "",
                    Description = "",
                    Length = 0,
                    GenericTypeName = "",
                    ReferenceTypeName = "",
                    ReferenceName = "",
                    ItemTypeName = "",
                    InverseOf = "",
                    IsHoisted = false,
                    IsId = false,
                    IsGlobalId = false,
                    IsDerived = false,
                    IsDiscriminator = false,
                    IsReservedProperty = false,
                    IsReservedPropertyVersion = false,
                    IsReservedPropertyDeleted = false,
                    IsReservedPropertyActive = false,
                    IsReservedPropertyCreatedBy = false,
                    IsReservedPropertyCreatedAt = false,
                    IsReservedPropertyUpdatedBy = false,
                    IsReservedPropertyUpdatedAt = false,
                    IsFilteringProperty = true,
                },
                new PropertyMetadata {
                    Name = "CountedQuantity",
                    Type = typeof(decimal),
                    TypeName = "decimal",
                    IsSimpleValueObjectType = true,
                    IsNullableType = false,
                    DisplayName = "",
                    Description = "",
                    Length = 0,
                    GenericTypeName = "",
                    ReferenceTypeName = "",
                    ReferenceName = "",
                    ItemTypeName = "",
                    InverseOf = "",
                    IsHoisted = false,
                    IsId = false,
                    IsGlobalId = false,
                    IsDerived = false,
                    IsDiscriminator = false,
                    IsReservedProperty = false,
                    IsReservedPropertyVersion = false,
                    IsReservedPropertyDeleted = false,
                    IsReservedPropertyActive = false,
                    IsReservedPropertyCreatedBy = false,
                    IsReservedPropertyCreatedAt = false,
                    IsReservedPropertyUpdatedBy = false,
                    IsReservedPropertyUpdatedAt = false,
                    IsFilteringProperty = true,
                },
                new PropertyMetadata {
                    Name = "Processed",
                    Type = typeof(bool),
                    TypeName = "bool",
                    IsSimpleValueObjectType = true,
                    IsNullableType = false,
                    DisplayName = "",
                    Description = "",
                    Length = 0,
                    GenericTypeName = "",
                    ReferenceTypeName = "",
                    ReferenceName = "",
                    ItemTypeName = "",
                    InverseOf = "",
                    IsHoisted = false,
                    IsId = false,
                    IsGlobalId = false,
                    IsDerived = false,
                    IsDiscriminator = false,
                    IsReservedProperty = false,
                    IsReservedPropertyVersion = false,
                    IsReservedPropertyDeleted = false,
                    IsReservedPropertyActive = false,
                    IsReservedPropertyCreatedBy = false,
                    IsReservedPropertyCreatedAt = false,
                    IsReservedPropertyUpdatedBy = false,
                    IsReservedPropertyUpdatedAt = false,
                    IsFilteringProperty = true,
                },
                new PropertyMetadata {
                    Name = "ReversalLineNumber",
                    Type = typeof(long),
                    TypeName = "long",
                    IsSimpleValueObjectType = true,
                    IsNullableType = false,
                    DisplayName = "",
                    Description = "",
                    Length = 0,
                    GenericTypeName = "",
                    ReferenceTypeName = "",
                    ReferenceName = "",
                    ItemTypeName = "",
                    InverseOf = "",
                    IsHoisted = false,
                    IsId = false,
                    IsGlobalId = false,
                    IsDerived = false,
                    IsDiscriminator = false,
                    IsReservedProperty = false,
                    IsReservedPropertyVersion = false,
                    IsReservedPropertyDeleted = false,
                    IsReservedPropertyActive = false,
                    IsReservedPropertyCreatedBy = false,
                    IsReservedPropertyCreatedAt = false,
                    IsReservedPropertyUpdatedBy = false,
                    IsReservedPropertyUpdatedAt = false,
                    IsFilteringProperty = true,
                },
                new PropertyMetadata {
                    Name = "Description",
                    Type = typeof(string),
                    TypeName = "string",
                    IsSimpleValueObjectType = true,
                    IsNullableType = false,
                    DisplayName = "",
                    Description = "",
                    Length = 0,
                    GenericTypeName = "",
                    ReferenceTypeName = "",
                    ReferenceName = "",
                    ItemTypeName = "",
                    InverseOf = "",
                    IsHoisted = false,
                    IsId = false,
                    IsGlobalId = false,
                    IsDerived = false,
                    IsDiscriminator = false,
                    IsReservedProperty = false,
                    IsReservedPropertyVersion = false,
                    IsReservedPropertyDeleted = false,
                    IsReservedPropertyActive = false,
                    IsReservedPropertyCreatedBy = false,
                    IsReservedPropertyCreatedAt = false,
                    IsReservedPropertyUpdatedBy = false,
                    IsReservedPropertyUpdatedAt = false,
                    IsFilteringProperty = true,
                },
                new PropertyMetadata {
                    Name = "Version",
                    Type = typeof(long),
                    TypeName = "long",
                    IsSimpleValueObjectType = true,
                    IsNullableType = false,
                    DisplayName = "",
                    Description = "",
                    Length = 0,
                    GenericTypeName = "",
                    ReferenceTypeName = "",
                    ReferenceName = "",
                    ItemTypeName = "",
                    InverseOf = "",
                    IsHoisted = false,
                    IsId = false,
                    IsGlobalId = false,
                    IsDerived = false,
                    IsDiscriminator = false,
                    IsReservedProperty = true,
                    IsReservedPropertyVersion = true,
                    IsReservedPropertyDeleted = false,
                    IsReservedPropertyActive = false,
                    IsReservedPropertyCreatedBy = false,
                    IsReservedPropertyCreatedAt = false,
                    IsReservedPropertyUpdatedBy = false,
                    IsReservedPropertyUpdatedAt = false,
                    IsFilteringProperty = true,
                },
                new PropertyMetadata {
                    Name = "CreatedBy",
                    Type = typeof(string),
                    TypeName = "string",
                    IsSimpleValueObjectType = true,
                    IsNullableType = false,
                    DisplayName = "",
                    Description = "",
                    Length = 0,
                    GenericTypeName = "",
                    ReferenceTypeName = "",
                    ReferenceName = "",
                    ItemTypeName = "",
                    InverseOf = "",
                    IsHoisted = false,
                    IsId = false,
                    IsGlobalId = false,
                    IsDerived = false,
                    IsDiscriminator = false,
                    IsReservedProperty = true,
                    IsReservedPropertyVersion = false,
                    IsReservedPropertyDeleted = false,
                    IsReservedPropertyActive = false,
                    IsReservedPropertyCreatedBy = true,
                    IsReservedPropertyCreatedAt = false,
                    IsReservedPropertyUpdatedBy = false,
                    IsReservedPropertyUpdatedAt = false,
                    IsFilteringProperty = true,
                },
                new PropertyMetadata {
                    Name = "CreatedAt",
                    Type = typeof(DateTime),
                    TypeName = "DateTime",
                    IsSimpleValueObjectType = true,
                    IsNullableType = false,
                    DisplayName = "",
                    Description = "",
                    Length = 0,
                    GenericTypeName = "",
                    ReferenceTypeName = "",
                    ReferenceName = "",
                    ItemTypeName = "",
                    InverseOf = "",
                    IsHoisted = false,
                    IsId = false,
                    IsGlobalId = false,
                    IsDerived = false,
                    IsDiscriminator = false,
                    IsReservedProperty = true,
                    IsReservedPropertyVersion = false,
                    IsReservedPropertyDeleted = false,
                    IsReservedPropertyActive = false,
                    IsReservedPropertyCreatedBy = false,
                    IsReservedPropertyCreatedAt = true,
                    IsReservedPropertyUpdatedBy = false,
                    IsReservedPropertyUpdatedAt = false,
                    IsFilteringProperty = true,
                },
                new PropertyMetadata {
                    Name = "UpdatedBy",
                    Type = typeof(string),
                    TypeName = "string",
                    IsSimpleValueObjectType = true,
                    IsNullableType = false,
                    DisplayName = "",
                    Description = "",
                    Length = 0,
                    GenericTypeName = "",
                    ReferenceTypeName = "",
                    ReferenceName = "",
                    ItemTypeName = "",
                    InverseOf = "",
                    IsHoisted = false,
                    IsId = false,
                    IsGlobalId = false,
                    IsDerived = false,
                    IsDiscriminator = false,
                    IsReservedProperty = true,
                    IsReservedPropertyVersion = false,
                    IsReservedPropertyDeleted = false,
                    IsReservedPropertyActive = false,
                    IsReservedPropertyCreatedBy = false,
                    IsReservedPropertyCreatedAt = false,
                    IsReservedPropertyUpdatedBy = true,
                    IsReservedPropertyUpdatedAt = false,
                    IsFilteringProperty = true,
                },
                new PropertyMetadata {
                    Name = "UpdatedAt",
                    Type = typeof(DateTime),
                    TypeName = "DateTime",
                    IsSimpleValueObjectType = true,
                    IsNullableType = false,
                    DisplayName = "",
                    Description = "",
                    Length = 0,
                    GenericTypeName = "",
                    ReferenceTypeName = "",
                    ReferenceName = "",
                    ItemTypeName = "",
                    InverseOf = "",
                    IsHoisted = false,
                    IsId = false,
                    IsGlobalId = false,
                    IsDerived = false,
                    IsDiscriminator = false,
                    IsReservedProperty = true,
                    IsReservedPropertyVersion = false,
                    IsReservedPropertyDeleted = false,
                    IsReservedPropertyActive = false,
                    IsReservedPropertyCreatedBy = false,
                    IsReservedPropertyCreatedAt = false,
                    IsReservedPropertyUpdatedBy = false,
                    IsReservedPropertyUpdatedAt = true,
                    IsFilteringProperty = true,
                },
                new PropertyMetadata {
                    Name = "Active",
                    Type = typeof(bool),
                    TypeName = "bool",
                    IsSimpleValueObjectType = true,
                    IsNullableType = false,
                    DisplayName = "",
                    Description = "",
                    Length = 0,
                    GenericTypeName = "",
                    ReferenceTypeName = "",
                    ReferenceName = "",
                    ItemTypeName = "",
                    InverseOf = "",
                    IsHoisted = false,
                    IsId = false,
                    IsGlobalId = false,
                    IsDerived = false,
                    IsDiscriminator = false,
                    IsReservedProperty = true,
                    IsReservedPropertyVersion = false,
                    IsReservedPropertyDeleted = false,
                    IsReservedPropertyActive = true,
                    IsReservedPropertyCreatedBy = false,
                    IsReservedPropertyCreatedAt = false,
                    IsReservedPropertyUpdatedBy = false,
                    IsReservedPropertyUpdatedAt = false,
                    IsFilteringProperty = true,
                },
                new PropertyMetadata {
                    Name = "Deleted",
                    Type = typeof(bool),
                    TypeName = "bool",
                    IsSimpleValueObjectType = true,
                    IsNullableType = false,
                    DisplayName = "",
                    Description = "",
                    Length = 0,
                    GenericTypeName = "",
                    ReferenceTypeName = "",
                    ReferenceName = "",
                    ItemTypeName = "",
                    InverseOf = "",
                    IsHoisted = false,
                    IsId = false,
                    IsGlobalId = false,
                    IsDerived = false,
                    IsDiscriminator = false,
                    IsReservedProperty = true,
                    IsReservedPropertyVersion = false,
                    IsReservedPropertyDeleted = true,
                    IsReservedPropertyActive = false,
                    IsReservedPropertyCreatedBy = false,
                    IsReservedPropertyCreatedAt = false,
                    IsReservedPropertyUpdatedBy = false,
                    IsReservedPropertyUpdatedAt = false,
                    IsFilteringProperty = true,
                },
                new PropertyMetadata {
                    Name = "PhysicalInventoryLineId",
                    Type = typeof(PhysicalInventoryLineId),
                    TypeName = "PhysicalInventoryLineId",
                    IsSimpleValueObjectType = false,
                    IsNullableType = false,
                    DisplayName = "",
                    Description = "",
                    Length = 0,
                    GenericTypeName = "",
                    ReferenceTypeName = "",
                    ReferenceName = "",
                    ItemTypeName = "",
                    InverseOf = "",
                    IsHoisted = false,
                    IsId = false,
                    IsGlobalId = true,
                    IsDerived = false,
                    IsDiscriminator = false,
                    IsReservedProperty = false,
                    IsReservedPropertyVersion = false,
                    IsReservedPropertyDeleted = false,
                    IsReservedPropertyActive = false,
                    IsReservedPropertyCreatedBy = false,
                    IsReservedPropertyCreatedAt = false,
                    IsReservedPropertyUpdatedBy = false,
                    IsReservedPropertyUpdatedAt = false,
                    IsFilteringProperty = false,
                },
                new PropertyMetadata {
                    Name = "PhysicalInventoryDocumentNumber",
                    Type = typeof(string),
                    TypeName = "string",
                    IsSimpleValueObjectType = true,
                    IsNullableType = false,
                    DisplayName = "",
                    Description = "",
                    Length = 50,
                    GenericTypeName = "",
                    ReferenceTypeName = "",
                    ReferenceName = "",
                    ItemTypeName = "",
                    InverseOf = "",
                    IsHoisted = false,
                    IsId = false,
                    IsGlobalId = false,
                    IsDerived = true,
                    IsOuterId = true,
                    DerivedFrom = "PhysicalInventoryLineId.PhysicalInventoryDocumentNumber",
                    IsDiscriminator = false,
                    IsReservedProperty = false,
                    IsReservedPropertyVersion = false,
                    IsReservedPropertyDeleted = false,
                    IsReservedPropertyActive = false,
                    IsReservedPropertyCreatedBy = false,
                    IsReservedPropertyCreatedAt = false,
                    IsReservedPropertyUpdatedBy = false,
                    IsReservedPropertyUpdatedAt = false,
                    IsFilteringProperty = true,
                },
                new PropertyMetadata {
                    Name = "InventoryItemId.ProductId",
                    Type = typeof(string),
                    TypeName = "string",
                    IsSimpleValueObjectType = true,
                    IsNullableType = false,
                    DisplayName = "",
                    Description = "",
                    Length = 60,
                    GenericTypeName = "",
                    ReferenceTypeName = "",
                    ReferenceName = "",
                    ItemTypeName = "",
                    InverseOf = "",
                    IsHoisted = false,
                    IsId = false,
                    IsGlobalId = false,
                    IsDerived = false,
                    IsReallyFlattened = false,
                    SourceChainingName = "InventoryItemId.ProductId",
                    IsDiscriminator = false,
                    IsReservedProperty = false,
                    IsReservedPropertyVersion = false,
                    IsReservedPropertyDeleted = false,
                    IsReservedPropertyActive = false,
                    IsReservedPropertyCreatedBy = false,
                    IsReservedPropertyCreatedAt = false,
                    IsReservedPropertyUpdatedBy = false,
                    IsReservedPropertyUpdatedAt = false,
                    IsFilteringProperty = true,
                },
                new PropertyMetadata {
                    Name = "InventoryItemId.LocatorId",
                    Type = typeof(string),
                    TypeName = "string",
                    IsSimpleValueObjectType = true,
                    IsNullableType = false,
                    DisplayName = "",
                    Description = "",
                    Length = 50,
                    GenericTypeName = "",
                    ReferenceTypeName = "",
                    ReferenceName = "",
                    ItemTypeName = "",
                    InverseOf = "",
                    IsHoisted = false,
                    IsId = false,
                    IsGlobalId = false,
                    IsDerived = false,
                    IsReallyFlattened = false,
                    SourceChainingName = "InventoryItemId.LocatorId",
                    IsDiscriminator = false,
                    IsReservedProperty = false,
                    IsReservedPropertyVersion = false,
                    IsReservedPropertyDeleted = false,
                    IsReservedPropertyActive = false,
                    IsReservedPropertyCreatedBy = false,
                    IsReservedPropertyCreatedAt = false,
                    IsReservedPropertyUpdatedBy = false,
                    IsReservedPropertyUpdatedAt = false,
                    IsFilteringProperty = true,
                },
                new PropertyMetadata {
                    Name = "InventoryItemId.AttributeSetInstanceId",
                    Type = typeof(string),
                    TypeName = "string",
                    IsSimpleValueObjectType = true,
                    IsNullableType = false,
                    DisplayName = "",
                    Description = "",
                    Length = 50,
                    GenericTypeName = "",
                    ReferenceTypeName = "",
                    ReferenceName = "",
                    ItemTypeName = "",
                    InverseOf = "",
                    IsHoisted = false,
                    IsId = false,
                    IsGlobalId = false,
                    IsDerived = false,
                    IsReallyFlattened = false,
                    SourceChainingName = "InventoryItemId.AttributeSetInstanceId",
                    IsDiscriminator = false,
                    IsReservedProperty = false,
                    IsReservedPropertyVersion = false,
                    IsReservedPropertyDeleted = false,
                    IsReservedPropertyActive = false,
                    IsReservedPropertyCreatedBy = false,
                    IsReservedPropertyCreatedAt = false,
                    IsReservedPropertyUpdatedBy = false,
                    IsReservedPropertyUpdatedAt = false,
                    IsFilteringProperty = true,
                },
                new PropertyMetadata {
                    Name = "PhysicalInventoryLineId.PhysicalInventoryDocumentNumber",
                    Type = typeof(string),
                    TypeName = "string",
                    IsSimpleValueObjectType = true,
                    IsNullableType = false,
                    DisplayName = "",
                    Description = "",
                    Length = 50,
                    GenericTypeName = "",
                    ReferenceTypeName = "",
                    ReferenceName = "",
                    ItemTypeName = "",
                    InverseOf = "",
                    IsHoisted = false,
                    IsId = false,
                    IsGlobalId = false,
                    IsDerived = false,
                    IsReallyFlattened = false,
                    SourceChainingName = "PhysicalInventoryLineId.PhysicalInventoryDocumentNumber",
                    IsDiscriminator = false,
                    IsReservedProperty = false,
                    IsReservedPropertyVersion = false,
                    IsReservedPropertyDeleted = false,
                    IsReservedPropertyActive = false,
                    IsReservedPropertyCreatedBy = false,
                    IsReservedPropertyCreatedAt = false,
                    IsReservedPropertyUpdatedBy = false,
                    IsReservedPropertyUpdatedAt = false,
                    IsFilteringProperty = true,
                },
                new PropertyMetadata {
                    Name = "PhysicalInventoryLineId.InventoryItemIdProductId",
                    Type = typeof(string),
                    TypeName = "string",
                    IsSimpleValueObjectType = true,
                    IsNullableType = false,
                    DisplayName = "",
                    Description = "",
                    Length = 60,
                    GenericTypeName = "",
                    ReferenceTypeName = "",
                    ReferenceName = "",
                    ItemTypeName = "",
                    InverseOf = "",
                    IsHoisted = false,
                    IsId = false,
                    IsGlobalId = false,
                    IsDerived = false,
                    IsReallyFlattened = true,
                    SourceChainingName = "PhysicalInventoryLineId.InventoryItemId.ProductId",
                    IsDiscriminator = false,
                    IsReservedProperty = false,
                    IsReservedPropertyVersion = false,
                    IsReservedPropertyDeleted = false,
                    IsReservedPropertyActive = false,
                    IsReservedPropertyCreatedBy = false,
                    IsReservedPropertyCreatedAt = false,
                    IsReservedPropertyUpdatedBy = false,
                    IsReservedPropertyUpdatedAt = false,
                    IsFilteringProperty = true,
                },
                new PropertyMetadata {
                    Name = "PhysicalInventoryLineId.InventoryItemIdLocatorId",
                    Type = typeof(string),
                    TypeName = "string",
                    IsSimpleValueObjectType = true,
                    IsNullableType = false,
                    DisplayName = "",
                    Description = "",
                    Length = 50,
                    GenericTypeName = "",
                    ReferenceTypeName = "",
                    ReferenceName = "",
                    ItemTypeName = "",
                    InverseOf = "",
                    IsHoisted = false,
                    IsId = false,
                    IsGlobalId = false,
                    IsDerived = false,
                    IsReallyFlattened = true,
                    SourceChainingName = "PhysicalInventoryLineId.InventoryItemId.LocatorId",
                    IsDiscriminator = false,
                    IsReservedProperty = false,
                    IsReservedPropertyVersion = false,
                    IsReservedPropertyDeleted = false,
                    IsReservedPropertyActive = false,
                    IsReservedPropertyCreatedBy = false,
                    IsReservedPropertyCreatedAt = false,
                    IsReservedPropertyUpdatedBy = false,
                    IsReservedPropertyUpdatedAt = false,
                    IsFilteringProperty = true,
                },
                new PropertyMetadata {
                    Name = "PhysicalInventoryLineId.InventoryItemIdAttributeSetInstanceId",
                    Type = typeof(string),
                    TypeName = "string",
                    IsSimpleValueObjectType = true,
                    IsNullableType = false,
                    DisplayName = "",
                    Description = "",
                    Length = 50,
                    GenericTypeName = "",
                    ReferenceTypeName = "",
                    ReferenceName = "",
                    ItemTypeName = "",
                    InverseOf = "",
                    IsHoisted = false,
                    IsId = false,
                    IsGlobalId = false,
                    IsDerived = false,
                    IsReallyFlattened = true,
                    SourceChainingName = "PhysicalInventoryLineId.InventoryItemId.AttributeSetInstanceId",
                    IsDiscriminator = false,
                    IsReservedProperty = false,
                    IsReservedPropertyVersion = false,
                    IsReservedPropertyDeleted = false,
                    IsReservedPropertyActive = false,
                    IsReservedPropertyCreatedBy = false,
                    IsReservedPropertyCreatedAt = false,
                    IsReservedPropertyUpdatedBy = false,
                    IsReservedPropertyUpdatedAt = false,
                    IsFilteringProperty = true,
                },
            };


        private static IDictionary<string, PropertyMetadata> _propertyMetadataDictionary;

        private static IDictionary<string, string> _filteringPropertyAliasDictionary;

        public IDictionary<string, string> FilteringPropertyAliasDictionary
        {
            get { return _filteringPropertyAliasDictionary; }
        }

        private static void InitFilteringPropertyAliasDictionary()
        {
            var d = new Dictionary<string, string>();
            d.Add("BookQuantity", "BookQuantity");
            d.Add("bookQuantity", "BookQuantity");
            d.Add("CountedQuantity", "CountedQuantity");
            d.Add("countedQuantity", "CountedQuantity");
            d.Add("Processed", "Processed");
            d.Add("processed", "Processed");
            d.Add("ReversalLineNumber", "ReversalLineNumber");
            d.Add("reversalLineNumber", "ReversalLineNumber");
            d.Add("Description", "Description");
            d.Add("description", "Description");
            d.Add("Version", "Version");
            d.Add("version", "Version");
            d.Add("CreatedBy", "CreatedBy");
            d.Add("createdBy", "CreatedBy");
            d.Add("CreatedAt", "CreatedAt");
            d.Add("createdAt", "CreatedAt");
            d.Add("UpdatedBy", "UpdatedBy");
            d.Add("updatedBy", "UpdatedBy");
            d.Add("UpdatedAt", "UpdatedAt");
            d.Add("updatedAt", "UpdatedAt");
            d.Add("Active", "Active");
            d.Add("active", "Active");
            d.Add("Deleted", "Deleted");
            d.Add("deleted", "Deleted");
            d.Add("PhysicalInventoryDocumentNumber", "PhysicalInventoryLineId.PhysicalInventoryDocumentNumber");
            d.Add("physicalInventoryDocumentNumber", "PhysicalInventoryLineId.PhysicalInventoryDocumentNumber");
            d.Add("InventoryItemId.ProductId", "PhysicalInventoryLineId.InventoryItemIdProductId");
            d.Add("inventoryItemId.productId", "PhysicalInventoryLineId.InventoryItemIdProductId");
            d.Add("InventoryItemId.ProductId", "PhysicalInventoryLineId.InventoryItemIdProductId");
            d.Add("inventoryItemId.productId", "PhysicalInventoryLineId.InventoryItemIdProductId");
            d.Add("InventoryItemId.LocatorId", "PhysicalInventoryLineId.InventoryItemIdLocatorId");
            d.Add("inventoryItemId.locatorId", "PhysicalInventoryLineId.InventoryItemIdLocatorId");
            d.Add("InventoryItemId.LocatorId", "PhysicalInventoryLineId.InventoryItemIdLocatorId");
            d.Add("inventoryItemId.locatorId", "PhysicalInventoryLineId.InventoryItemIdLocatorId");
            d.Add("InventoryItemId.AttributeSetInstanceId", "PhysicalInventoryLineId.InventoryItemIdAttributeSetInstanceId");
            d.Add("inventoryItemId.attributeSetInstanceId", "PhysicalInventoryLineId.InventoryItemIdAttributeSetInstanceId");
            d.Add("InventoryItemId.AttributeSetInstanceId", "PhysicalInventoryLineId.InventoryItemIdAttributeSetInstanceId");
            d.Add("inventoryItemId.attributeSetInstanceId", "PhysicalInventoryLineId.InventoryItemIdAttributeSetInstanceId");
            d.Add("PhysicalInventoryLineId.PhysicalInventoryDocumentNumber", "PhysicalInventoryLineId.PhysicalInventoryDocumentNumber");
            d.Add("physicalInventoryLineId.physicalInventoryDocumentNumber", "PhysicalInventoryLineId.PhysicalInventoryDocumentNumber");
            d.Add("PhysicalInventoryLineId.InventoryItemIdProductId", "PhysicalInventoryLineId.InventoryItemIdProductId");
            d.Add("physicalInventoryLineId.inventoryItemIdProductId", "PhysicalInventoryLineId.InventoryItemIdProductId");
            d.Add("PhysicalInventoryLineId.InventoryItemId.ProductId", "PhysicalInventoryLineId.InventoryItemIdProductId");
            d.Add("physicalInventoryLineId.inventoryItemId.productId", "PhysicalInventoryLineId.InventoryItemIdProductId");
            d.Add("PhysicalInventoryLineId.InventoryItemIdLocatorId", "PhysicalInventoryLineId.InventoryItemIdLocatorId");
            d.Add("physicalInventoryLineId.inventoryItemIdLocatorId", "PhysicalInventoryLineId.InventoryItemIdLocatorId");
            d.Add("PhysicalInventoryLineId.InventoryItemId.LocatorId", "PhysicalInventoryLineId.InventoryItemIdLocatorId");
            d.Add("physicalInventoryLineId.inventoryItemId.locatorId", "PhysicalInventoryLineId.InventoryItemIdLocatorId");
            d.Add("PhysicalInventoryLineId.InventoryItemIdAttributeSetInstanceId", "PhysicalInventoryLineId.InventoryItemIdAttributeSetInstanceId");
            d.Add("physicalInventoryLineId.inventoryItemIdAttributeSetInstanceId", "PhysicalInventoryLineId.InventoryItemIdAttributeSetInstanceId");
            d.Add("PhysicalInventoryLineId.InventoryItemId.AttributeSetInstanceId", "PhysicalInventoryLineId.InventoryItemIdAttributeSetInstanceId");
            d.Add("physicalInventoryLineId.inventoryItemId.attributeSetInstanceId", "PhysicalInventoryLineId.InventoryItemIdAttributeSetInstanceId");
            _filteringPropertyAliasDictionary = d;
        }

        static PhysicalInventoryLineMetadata()
        {
            InitFilteringPropertyAliasDictionary();
            _propertyMetadataDictionary = new Dictionary<string, PropertyMetadata>();
            foreach (var p in _properties)
            {
                _propertyMetadataDictionary.Add(p.Name, p);
            }
            foreach (var kv in _filteringPropertyAliasDictionary)
            {
                if (_propertyMetadataDictionary.ContainsKey(kv.Value) && !_propertyMetadataDictionary.ContainsKey(kv.Key))
                {
                    var p = _propertyMetadataDictionary[kv.Value];
                    _propertyMetadataDictionary.Add(kv.Key, p);
                }
            }
        }

        private static PhysicalInventoryLineMetadata _instance = new PhysicalInventoryLineMetadata();

        public static PhysicalInventoryLineMetadata Instance
        {
            get
            {
                return _instance;
            }
        }


        public IEnumerable<PropertyMetadata> Properties
        {
            get { return _properties; }
        }

        public IDictionary<string, PropertyMetadata> PropertyMetadataDictionary
        {
            get { return _propertyMetadataDictionary; }
        }

        protected PhysicalInventoryLineMetadata()
        { 
        }


    }

}
