﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateDomainMetadata.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Shipment;

namespace Dddml.Wms.Domain.Metadata
{

    public class ItemIssuanceMetadata
    {
        private static PropertyMetadata[] _properties = new PropertyMetadata[]{
                new PropertyMetadata {
                    Name = "ItemIssuanceSeqId",
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
                    IsId = true,
                    IsGlobalId = false,
                    IsDerived = true,
                    IsOuterId = true,
                    DerivedFrom = "ShipmentItemIssuanceId.ItemIssuanceSeqId",
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
                    Name = "OrderId",
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
                    Name = "OrderItemSeqId",
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
                    Name = "ShipGroupSeqId",
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
                    Name = "ProductId",
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
                    Name = "LocatorId",
                    Type = typeof(string),
                    TypeName = "string",
                    IsSimpleValueObjectType = true,
                    IsNullableType = false,
                    DisplayName = "",
                    Description = "",
                    Length = 50,
                    GenericTypeName = "",
                    ReferenceTypeName = "Locator",
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
                    Name = "AttributeSetInstanceId",
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
                    Name = "ShipmentItemSeqId",
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
                    Name = "FixedAssetId",
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
                    Name = "MaintHistSeqId",
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
                    Name = "IssuedDateTime",
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
                    Name = "IssuedByUserLoginId",
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
                    Name = "Quantity",
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
                    Name = "CancelQuantity",
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
                    Name = "ShipmentItemIssuanceId",
                    Type = typeof(ShipmentItemIssuanceId),
                    TypeName = "ShipmentItemIssuanceId",
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
                    Name = "ShipmentId",
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
                    IsDerived = true,
                    IsOuterId = true,
                    DerivedFrom = "ShipmentItemIssuanceId.ShipmentId",
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
                    Name = "ShipmentItemIssuanceId.ShipmentId",
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
                    IsReallyFlattened = false,
                    SourceChainingName = "ShipmentItemIssuanceId.ShipmentId",
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
                    Name = "ShipmentItemIssuanceId.ItemIssuanceSeqId",
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
                    IsReallyFlattened = false,
                    SourceChainingName = "ShipmentItemIssuanceId.ItemIssuanceSeqId",
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
            d.Add("ItemIssuanceSeqId", "ShipmentItemIssuanceId.ItemIssuanceSeqId");
            d.Add("itemIssuanceSeqId", "ShipmentItemIssuanceId.ItemIssuanceSeqId");
            d.Add("OrderId", "OrderId");
            d.Add("orderId", "OrderId");
            d.Add("OrderItemSeqId", "OrderItemSeqId");
            d.Add("orderItemSeqId", "OrderItemSeqId");
            d.Add("ShipGroupSeqId", "ShipGroupSeqId");
            d.Add("shipGroupSeqId", "ShipGroupSeqId");
            d.Add("ProductId", "ProductId");
            d.Add("productId", "ProductId");
            d.Add("LocatorId", "LocatorId");
            d.Add("locatorId", "LocatorId");
            d.Add("AttributeSetInstanceId", "AttributeSetInstanceId");
            d.Add("attributeSetInstanceId", "AttributeSetInstanceId");
            d.Add("ShipmentItemSeqId", "ShipmentItemSeqId");
            d.Add("shipmentItemSeqId", "ShipmentItemSeqId");
            d.Add("FixedAssetId", "FixedAssetId");
            d.Add("fixedAssetId", "FixedAssetId");
            d.Add("MaintHistSeqId", "MaintHistSeqId");
            d.Add("maintHistSeqId", "MaintHistSeqId");
            d.Add("IssuedDateTime", "IssuedDateTime");
            d.Add("issuedDateTime", "IssuedDateTime");
            d.Add("IssuedByUserLoginId", "IssuedByUserLoginId");
            d.Add("issuedByUserLoginId", "IssuedByUserLoginId");
            d.Add("Quantity", "Quantity");
            d.Add("quantity", "Quantity");
            d.Add("CancelQuantity", "CancelQuantity");
            d.Add("cancelQuantity", "CancelQuantity");
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
            d.Add("ShipmentId", "ShipmentItemIssuanceId.ShipmentId");
            d.Add("shipmentId", "ShipmentItemIssuanceId.ShipmentId");
            d.Add("ShipmentItemIssuanceId.ShipmentId", "ShipmentItemIssuanceId.ShipmentId");
            d.Add("shipmentItemIssuanceId.shipmentId", "ShipmentItemIssuanceId.ShipmentId");
            d.Add("ShipmentItemIssuanceId.ItemIssuanceSeqId", "ShipmentItemIssuanceId.ItemIssuanceSeqId");
            d.Add("shipmentItemIssuanceId.itemIssuanceSeqId", "ShipmentItemIssuanceId.ItemIssuanceSeqId");
            _filteringPropertyAliasDictionary = d;
        }

        static ItemIssuanceMetadata()
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

        private static ItemIssuanceMetadata _instance = new ItemIssuanceMetadata();

        public static ItemIssuanceMetadata Instance
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

        protected ItemIssuanceMetadata()
        { 
        }


    }

}
