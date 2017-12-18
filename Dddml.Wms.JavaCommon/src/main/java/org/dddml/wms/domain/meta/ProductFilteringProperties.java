package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;

public final class ProductFilteringProperties
{

    private ProductFilteringProperties()
    {
    }

    public static final String[] propertyNames = new String[] {
            "productId",
            "productTypeId",
            "primaryProductCategoryId",
            "manufacturerPartyId",
            "facilityId",
            "introductionDate",
            "releaseDate",
            "supportDiscontinuationDate",
            "salesDiscontinuationDate",
            "salesDiscWhenNotAvail",
            "internalName",
            "brandName",
            "comments",
            "productName",
            "description",
            "priceDetailText",
            "smallImageUrl",
            "mediumImageUrl",
            "largeImageUrl",
            "detailImageUrl",
            "originalImageUrl",
            "detailScreen",
            "inventoryMessage",
            "inventoryItemTypeId",
            "requireInventory",
            "quantityUomId",
            "quantityIncluded",
            "piecesIncluded",
            "requireAmount",
            "fixedAmount",
            "amountUomTypeId",
            "weightUomId",
            "shippingWeight",
            "productWeight",
            "heightUomId",
            "productHeight",
            "shippingHeight",
            "widthUomId",
            "productWidth",
            "shippingWidth",
            "depthUomId",
            "productDepth",
            "shippingDepth",
            "diameterUomId",
            "productDiameter",
            "productRating",
            "ratingTypeEnum",
            "returnable",
            "taxable",
            "chargeShipping",
            "autoCreateKeywords",
            "includeInPromotions",
            "isVirtual",
            "isVariant",
            "virtualVariantMethodEnum",
            "inShippingBox",
            "defaultShipmentBoxTypeId",
            "lotIdFilledIn",
            "version",
            "createdBy",
            "createdAt",
            "updatedBy",
            "updatedAt",
            "active",
            "deleted",
    };

    public static final String[] propertyTypes = new String[] {
            "String",
            "String",
            "String",
            "String",
            "String",
            "java.sql.Timestamp",
            "java.sql.Timestamp",
            "java.sql.Timestamp",
            "java.sql.Timestamp",
            "String",
            "String",
            "String",
            "String",
            "String",
            "String",
            "String",
            "String",
            "String",
            "String",
            "String",
            "String",
            "String",
            "String",
            "String",
            "String",
            "String",
            "java.math.BigDecimal",
            "Long",
            "String",
            "java.math.BigDecimal",
            "String",
            "String",
            "java.math.BigDecimal",
            "java.math.BigDecimal",
            "String",
            "java.math.BigDecimal",
            "java.math.BigDecimal",
            "String",
            "java.math.BigDecimal",
            "java.math.BigDecimal",
            "String",
            "java.math.BigDecimal",
            "java.math.BigDecimal",
            "String",
            "java.math.BigDecimal",
            "java.math.BigDecimal",
            "String",
            "String",
            "String",
            "String",
            "String",
            "String",
            "String",
            "String",
            "String",
            "String",
            "String",
            "String",
            "Long",
            "String",
            "Date",
            "String",
            "Date",
            "Boolean",
            "Boolean",
    };

    public static final Map<String, String> propertyTypeMap;

    public static final Map<String, String> aliasMap;

    static {
        propertyTypeMap = new HashMap<String, String>();
        initPropertyTypeMap();
        aliasMap = new HashMap<String, String>();
        initAliasMap();
    }

    private static  void initAliasMap() {
        aliasMap.put("productId", "productId");
        aliasMap.put("ProductId", "productId");
        aliasMap.put("productTypeId", "productTypeId");
        aliasMap.put("ProductTypeId", "productTypeId");
        aliasMap.put("primaryProductCategoryId", "primaryProductCategoryId");
        aliasMap.put("PrimaryProductCategoryId", "primaryProductCategoryId");
        aliasMap.put("manufacturerPartyId", "manufacturerPartyId");
        aliasMap.put("ManufacturerPartyId", "manufacturerPartyId");
        aliasMap.put("facilityId", "facilityId");
        aliasMap.put("FacilityId", "facilityId");
        aliasMap.put("introductionDate", "introductionDate");
        aliasMap.put("IntroductionDate", "introductionDate");
        aliasMap.put("releaseDate", "releaseDate");
        aliasMap.put("ReleaseDate", "releaseDate");
        aliasMap.put("supportDiscontinuationDate", "supportDiscontinuationDate");
        aliasMap.put("SupportDiscontinuationDate", "supportDiscontinuationDate");
        aliasMap.put("salesDiscontinuationDate", "salesDiscontinuationDate");
        aliasMap.put("SalesDiscontinuationDate", "salesDiscontinuationDate");
        aliasMap.put("salesDiscWhenNotAvail", "salesDiscWhenNotAvail");
        aliasMap.put("SalesDiscWhenNotAvail", "salesDiscWhenNotAvail");
        aliasMap.put("internalName", "internalName");
        aliasMap.put("InternalName", "internalName");
        aliasMap.put("brandName", "brandName");
        aliasMap.put("BrandName", "brandName");
        aliasMap.put("comments", "comments");
        aliasMap.put("Comments", "comments");
        aliasMap.put("productName", "productName");
        aliasMap.put("ProductName", "productName");
        aliasMap.put("description", "description");
        aliasMap.put("Description", "description");
        aliasMap.put("priceDetailText", "priceDetailText");
        aliasMap.put("PriceDetailText", "priceDetailText");
        aliasMap.put("smallImageUrl", "smallImageUrl");
        aliasMap.put("SmallImageUrl", "smallImageUrl");
        aliasMap.put("mediumImageUrl", "mediumImageUrl");
        aliasMap.put("MediumImageUrl", "mediumImageUrl");
        aliasMap.put("largeImageUrl", "largeImageUrl");
        aliasMap.put("LargeImageUrl", "largeImageUrl");
        aliasMap.put("detailImageUrl", "detailImageUrl");
        aliasMap.put("DetailImageUrl", "detailImageUrl");
        aliasMap.put("originalImageUrl", "originalImageUrl");
        aliasMap.put("OriginalImageUrl", "originalImageUrl");
        aliasMap.put("detailScreen", "detailScreen");
        aliasMap.put("DetailScreen", "detailScreen");
        aliasMap.put("inventoryMessage", "inventoryMessage");
        aliasMap.put("InventoryMessage", "inventoryMessage");
        aliasMap.put("inventoryItemTypeId", "inventoryItemTypeId");
        aliasMap.put("InventoryItemTypeId", "inventoryItemTypeId");
        aliasMap.put("requireInventory", "requireInventory");
        aliasMap.put("RequireInventory", "requireInventory");
        aliasMap.put("quantityUomId", "quantityUomId");
        aliasMap.put("QuantityUomId", "quantityUomId");
        aliasMap.put("quantityIncluded", "quantityIncluded");
        aliasMap.put("QuantityIncluded", "quantityIncluded");
        aliasMap.put("piecesIncluded", "piecesIncluded");
        aliasMap.put("PiecesIncluded", "piecesIncluded");
        aliasMap.put("requireAmount", "requireAmount");
        aliasMap.put("RequireAmount", "requireAmount");
        aliasMap.put("fixedAmount", "fixedAmount");
        aliasMap.put("FixedAmount", "fixedAmount");
        aliasMap.put("amountUomTypeId", "amountUomTypeId");
        aliasMap.put("AmountUomTypeId", "amountUomTypeId");
        aliasMap.put("weightUomId", "weightUomId");
        aliasMap.put("WeightUomId", "weightUomId");
        aliasMap.put("shippingWeight", "shippingWeight");
        aliasMap.put("ShippingWeight", "shippingWeight");
        aliasMap.put("productWeight", "productWeight");
        aliasMap.put("ProductWeight", "productWeight");
        aliasMap.put("heightUomId", "heightUomId");
        aliasMap.put("HeightUomId", "heightUomId");
        aliasMap.put("productHeight", "productHeight");
        aliasMap.put("ProductHeight", "productHeight");
        aliasMap.put("shippingHeight", "shippingHeight");
        aliasMap.put("ShippingHeight", "shippingHeight");
        aliasMap.put("widthUomId", "widthUomId");
        aliasMap.put("WidthUomId", "widthUomId");
        aliasMap.put("productWidth", "productWidth");
        aliasMap.put("ProductWidth", "productWidth");
        aliasMap.put("shippingWidth", "shippingWidth");
        aliasMap.put("ShippingWidth", "shippingWidth");
        aliasMap.put("depthUomId", "depthUomId");
        aliasMap.put("DepthUomId", "depthUomId");
        aliasMap.put("productDepth", "productDepth");
        aliasMap.put("ProductDepth", "productDepth");
        aliasMap.put("shippingDepth", "shippingDepth");
        aliasMap.put("ShippingDepth", "shippingDepth");
        aliasMap.put("diameterUomId", "diameterUomId");
        aliasMap.put("DiameterUomId", "diameterUomId");
        aliasMap.put("productDiameter", "productDiameter");
        aliasMap.put("ProductDiameter", "productDiameter");
        aliasMap.put("productRating", "productRating");
        aliasMap.put("ProductRating", "productRating");
        aliasMap.put("ratingTypeEnum", "ratingTypeEnum");
        aliasMap.put("RatingTypeEnum", "ratingTypeEnum");
        aliasMap.put("returnable", "returnable");
        aliasMap.put("Returnable", "returnable");
        aliasMap.put("taxable", "taxable");
        aliasMap.put("Taxable", "taxable");
        aliasMap.put("chargeShipping", "chargeShipping");
        aliasMap.put("ChargeShipping", "chargeShipping");
        aliasMap.put("autoCreateKeywords", "autoCreateKeywords");
        aliasMap.put("AutoCreateKeywords", "autoCreateKeywords");
        aliasMap.put("includeInPromotions", "includeInPromotions");
        aliasMap.put("IncludeInPromotions", "includeInPromotions");
        aliasMap.put("isVirtual", "isVirtual");
        aliasMap.put("IsVirtual", "isVirtual");
        aliasMap.put("isVariant", "isVariant");
        aliasMap.put("IsVariant", "isVariant");
        aliasMap.put("virtualVariantMethodEnum", "virtualVariantMethodEnum");
        aliasMap.put("VirtualVariantMethodEnum", "virtualVariantMethodEnum");
        aliasMap.put("inShippingBox", "inShippingBox");
        aliasMap.put("InShippingBox", "inShippingBox");
        aliasMap.put("defaultShipmentBoxTypeId", "defaultShipmentBoxTypeId");
        aliasMap.put("DefaultShipmentBoxTypeId", "defaultShipmentBoxTypeId");
        aliasMap.put("lotIdFilledIn", "lotIdFilledIn");
        aliasMap.put("LotIdFilledIn", "lotIdFilledIn");
        aliasMap.put("version", "version");
        aliasMap.put("Version", "version");
        aliasMap.put("createdBy", "createdBy");
        aliasMap.put("CreatedBy", "createdBy");
        aliasMap.put("createdAt", "createdAt");
        aliasMap.put("CreatedAt", "createdAt");
        aliasMap.put("updatedBy", "updatedBy");
        aliasMap.put("UpdatedBy", "updatedBy");
        aliasMap.put("updatedAt", "updatedAt");
        aliasMap.put("UpdatedAt", "updatedAt");
        aliasMap.put("active", "active");
        aliasMap.put("Active", "active");
        aliasMap.put("deleted", "deleted");
        aliasMap.put("Deleted", "deleted");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

