package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;


public final class GoodIdentificationMvoMetadata {

    private GoodIdentificationMvoMetadata() {
    }

    public static final String PROPERTY_NAME_VERSION      = "productVersion";
    public static final String PROPERTY_NAME_ACTIVE       = "active";
    public static final String PROPERTY_NAME_DELETED      = "deleted";
    public static final String PROPERTY_NAME_CREATED_BY   = "createdBy";
    public static final String PROPERTY_NAME_CREATED_AT   = "createdAt";
    public static final String PROPERTY_NAME_UPDATED_BY   = "updatedBy";
    public static final String PROPERTY_NAME_UPDATED_AT   = "updatedAt";

    public static final String[] propertyNames = new String[] {
            "idValue",
            "version",
            "createdBy",
            "createdAt",
            "updatedBy",
            "updatedAt",
            "active",
            "deleted",
            "productProductTypeId",
            "productPrimaryProductCategoryId",
            "productManufacturerPartyId",
            "productFacilityId",
            "productIntroductionDate",
            "productReleaseDate",
            "productSupportDiscontinuationDate",
            "productSalesDiscontinuationDate",
            "productSalesDiscWhenNotAvail",
            "productInternalName",
            "productBrandName",
            "productComments",
            "productProductName",
            "productDescription",
            "productPriceDetailText",
            "productSmallImageUrl",
            "productMediumImageUrl",
            "productLargeImageUrl",
            "productDetailImageUrl",
            "productOriginalImageUrl",
            "productDetailScreen",
            "productInventoryMessage",
            "productInventoryItemTypeId",
            "productRequireInventory",
            "productQuantityUomId",
            "productQuantityIncluded",
            "productPiecesIncluded",
            "productRequireAmount",
            "productFixedAmount",
            "productAmountUomTypeId",
            "productWeightUomId",
            "productShippingWeight",
            "productProductWeight",
            "productHeightUomId",
            "productProductHeight",
            "productShippingHeight",
            "productWidthUomId",
            "productProductWidth",
            "productShippingWidth",
            "productDepthUomId",
            "productProductDepth",
            "productShippingDepth",
            "productDiameterUomId",
            "productProductDiameter",
            "productProductRating",
            "productRatingTypeEnum",
            "productReturnable",
            "productTaxable",
            "productChargeShipping",
            "productAutoCreateKeywords",
            "productIncludeInPromotions",
            "productIsVirtual",
            "productIsVariant",
            "productVirtualVariantMethodEnum",
            "productInShippingBox",
            "productDefaultShipmentBoxTypeId",
            "productIsSerialNumbered",
            "productIsManagedByLot",
            "productAttributeSetId",
            "productAttributeSetInstanceId",
            "productVersion",
            "productCreatedBy",
            "productCreatedAt",
            "productUpdatedBy",
            "productUpdatedAt",
            "productActive",
            "productGoodIdentificationId.productId",
            "productGoodIdentificationId.goodIdentificationTypeId",
    };

    public static final String[] propertyTypes = new String[] {
            "String",
            "Long",
            "String",
            "Date",
            "String",
            "Date",
            "Boolean",
            "Boolean",
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
            "Boolean",
            "Boolean",
            "String",
            "String",
            "Long",
            "String",
            "Date",
            "String",
            "Date",
            "Boolean",
            "String",
            "String",
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
        aliasMap.put("idValue", "idValue");
        aliasMap.put("IdValue", "idValue");
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
        aliasMap.put("productProductTypeId", "productProductTypeId");
        aliasMap.put("ProductProductTypeId", "productProductTypeId");
        aliasMap.put("productPrimaryProductCategoryId", "productPrimaryProductCategoryId");
        aliasMap.put("ProductPrimaryProductCategoryId", "productPrimaryProductCategoryId");
        aliasMap.put("productManufacturerPartyId", "productManufacturerPartyId");
        aliasMap.put("ProductManufacturerPartyId", "productManufacturerPartyId");
        aliasMap.put("productFacilityId", "productFacilityId");
        aliasMap.put("ProductFacilityId", "productFacilityId");
        aliasMap.put("productIntroductionDate", "productIntroductionDate");
        aliasMap.put("ProductIntroductionDate", "productIntroductionDate");
        aliasMap.put("productReleaseDate", "productReleaseDate");
        aliasMap.put("ProductReleaseDate", "productReleaseDate");
        aliasMap.put("productSupportDiscontinuationDate", "productSupportDiscontinuationDate");
        aliasMap.put("ProductSupportDiscontinuationDate", "productSupportDiscontinuationDate");
        aliasMap.put("productSalesDiscontinuationDate", "productSalesDiscontinuationDate");
        aliasMap.put("ProductSalesDiscontinuationDate", "productSalesDiscontinuationDate");
        aliasMap.put("productSalesDiscWhenNotAvail", "productSalesDiscWhenNotAvail");
        aliasMap.put("ProductSalesDiscWhenNotAvail", "productSalesDiscWhenNotAvail");
        aliasMap.put("productInternalName", "productInternalName");
        aliasMap.put("ProductInternalName", "productInternalName");
        aliasMap.put("productBrandName", "productBrandName");
        aliasMap.put("ProductBrandName", "productBrandName");
        aliasMap.put("productComments", "productComments");
        aliasMap.put("ProductComments", "productComments");
        aliasMap.put("productProductName", "productProductName");
        aliasMap.put("ProductProductName", "productProductName");
        aliasMap.put("productDescription", "productDescription");
        aliasMap.put("ProductDescription", "productDescription");
        aliasMap.put("productPriceDetailText", "productPriceDetailText");
        aliasMap.put("ProductPriceDetailText", "productPriceDetailText");
        aliasMap.put("productSmallImageUrl", "productSmallImageUrl");
        aliasMap.put("ProductSmallImageUrl", "productSmallImageUrl");
        aliasMap.put("productMediumImageUrl", "productMediumImageUrl");
        aliasMap.put("ProductMediumImageUrl", "productMediumImageUrl");
        aliasMap.put("productLargeImageUrl", "productLargeImageUrl");
        aliasMap.put("ProductLargeImageUrl", "productLargeImageUrl");
        aliasMap.put("productDetailImageUrl", "productDetailImageUrl");
        aliasMap.put("ProductDetailImageUrl", "productDetailImageUrl");
        aliasMap.put("productOriginalImageUrl", "productOriginalImageUrl");
        aliasMap.put("ProductOriginalImageUrl", "productOriginalImageUrl");
        aliasMap.put("productDetailScreen", "productDetailScreen");
        aliasMap.put("ProductDetailScreen", "productDetailScreen");
        aliasMap.put("productInventoryMessage", "productInventoryMessage");
        aliasMap.put("ProductInventoryMessage", "productInventoryMessage");
        aliasMap.put("productInventoryItemTypeId", "productInventoryItemTypeId");
        aliasMap.put("ProductInventoryItemTypeId", "productInventoryItemTypeId");
        aliasMap.put("productRequireInventory", "productRequireInventory");
        aliasMap.put("ProductRequireInventory", "productRequireInventory");
        aliasMap.put("productQuantityUomId", "productQuantityUomId");
        aliasMap.put("ProductQuantityUomId", "productQuantityUomId");
        aliasMap.put("productQuantityIncluded", "productQuantityIncluded");
        aliasMap.put("ProductQuantityIncluded", "productQuantityIncluded");
        aliasMap.put("productPiecesIncluded", "productPiecesIncluded");
        aliasMap.put("ProductPiecesIncluded", "productPiecesIncluded");
        aliasMap.put("productRequireAmount", "productRequireAmount");
        aliasMap.put("ProductRequireAmount", "productRequireAmount");
        aliasMap.put("productFixedAmount", "productFixedAmount");
        aliasMap.put("ProductFixedAmount", "productFixedAmount");
        aliasMap.put("productAmountUomTypeId", "productAmountUomTypeId");
        aliasMap.put("ProductAmountUomTypeId", "productAmountUomTypeId");
        aliasMap.put("productWeightUomId", "productWeightUomId");
        aliasMap.put("ProductWeightUomId", "productWeightUomId");
        aliasMap.put("productShippingWeight", "productShippingWeight");
        aliasMap.put("ProductShippingWeight", "productShippingWeight");
        aliasMap.put("productProductWeight", "productProductWeight");
        aliasMap.put("ProductProductWeight", "productProductWeight");
        aliasMap.put("productHeightUomId", "productHeightUomId");
        aliasMap.put("ProductHeightUomId", "productHeightUomId");
        aliasMap.put("productProductHeight", "productProductHeight");
        aliasMap.put("ProductProductHeight", "productProductHeight");
        aliasMap.put("productShippingHeight", "productShippingHeight");
        aliasMap.put("ProductShippingHeight", "productShippingHeight");
        aliasMap.put("productWidthUomId", "productWidthUomId");
        aliasMap.put("ProductWidthUomId", "productWidthUomId");
        aliasMap.put("productProductWidth", "productProductWidth");
        aliasMap.put("ProductProductWidth", "productProductWidth");
        aliasMap.put("productShippingWidth", "productShippingWidth");
        aliasMap.put("ProductShippingWidth", "productShippingWidth");
        aliasMap.put("productDepthUomId", "productDepthUomId");
        aliasMap.put("ProductDepthUomId", "productDepthUomId");
        aliasMap.put("productProductDepth", "productProductDepth");
        aliasMap.put("ProductProductDepth", "productProductDepth");
        aliasMap.put("productShippingDepth", "productShippingDepth");
        aliasMap.put("ProductShippingDepth", "productShippingDepth");
        aliasMap.put("productDiameterUomId", "productDiameterUomId");
        aliasMap.put("ProductDiameterUomId", "productDiameterUomId");
        aliasMap.put("productProductDiameter", "productProductDiameter");
        aliasMap.put("ProductProductDiameter", "productProductDiameter");
        aliasMap.put("productProductRating", "productProductRating");
        aliasMap.put("ProductProductRating", "productProductRating");
        aliasMap.put("productRatingTypeEnum", "productRatingTypeEnum");
        aliasMap.put("ProductRatingTypeEnum", "productRatingTypeEnum");
        aliasMap.put("productReturnable", "productReturnable");
        aliasMap.put("ProductReturnable", "productReturnable");
        aliasMap.put("productTaxable", "productTaxable");
        aliasMap.put("ProductTaxable", "productTaxable");
        aliasMap.put("productChargeShipping", "productChargeShipping");
        aliasMap.put("ProductChargeShipping", "productChargeShipping");
        aliasMap.put("productAutoCreateKeywords", "productAutoCreateKeywords");
        aliasMap.put("ProductAutoCreateKeywords", "productAutoCreateKeywords");
        aliasMap.put("productIncludeInPromotions", "productIncludeInPromotions");
        aliasMap.put("ProductIncludeInPromotions", "productIncludeInPromotions");
        aliasMap.put("productIsVirtual", "productIsVirtual");
        aliasMap.put("ProductIsVirtual", "productIsVirtual");
        aliasMap.put("productIsVariant", "productIsVariant");
        aliasMap.put("ProductIsVariant", "productIsVariant");
        aliasMap.put("productVirtualVariantMethodEnum", "productVirtualVariantMethodEnum");
        aliasMap.put("ProductVirtualVariantMethodEnum", "productVirtualVariantMethodEnum");
        aliasMap.put("productInShippingBox", "productInShippingBox");
        aliasMap.put("ProductInShippingBox", "productInShippingBox");
        aliasMap.put("productDefaultShipmentBoxTypeId", "productDefaultShipmentBoxTypeId");
        aliasMap.put("ProductDefaultShipmentBoxTypeId", "productDefaultShipmentBoxTypeId");
        aliasMap.put("productIsSerialNumbered", "productIsSerialNumbered");
        aliasMap.put("ProductIsSerialNumbered", "productIsSerialNumbered");
        aliasMap.put("productIsManagedByLot", "productIsManagedByLot");
        aliasMap.put("ProductIsManagedByLot", "productIsManagedByLot");
        aliasMap.put("productAttributeSetId", "productAttributeSetId");
        aliasMap.put("ProductAttributeSetId", "productAttributeSetId");
        aliasMap.put("productAttributeSetInstanceId", "productAttributeSetInstanceId");
        aliasMap.put("ProductAttributeSetInstanceId", "productAttributeSetInstanceId");
        aliasMap.put("productVersion", "productVersion");
        aliasMap.put("ProductVersion", "productVersion");
        aliasMap.put("productCreatedBy", "productCreatedBy");
        aliasMap.put("ProductCreatedBy", "productCreatedBy");
        aliasMap.put("productCreatedAt", "productCreatedAt");
        aliasMap.put("ProductCreatedAt", "productCreatedAt");
        aliasMap.put("productUpdatedBy", "productUpdatedBy");
        aliasMap.put("ProductUpdatedBy", "productUpdatedBy");
        aliasMap.put("productUpdatedAt", "productUpdatedAt");
        aliasMap.put("ProductUpdatedAt", "productUpdatedAt");
        aliasMap.put("productActive", "productActive");
        aliasMap.put("ProductActive", "productActive");
        aliasMap.put("productGoodIdentificationId.productId", "productGoodIdentificationId.productId");
        aliasMap.put("ProductGoodIdentificationId.ProductId", "productGoodIdentificationId.productId");
        aliasMap.put("productGoodIdentificationId.goodIdentificationTypeId", "productGoodIdentificationId.goodIdentificationTypeId");
        aliasMap.put("ProductGoodIdentificationId.GoodIdentificationTypeId", "productGoodIdentificationId.goodIdentificationTypeId");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

