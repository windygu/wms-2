package org.dddml.wms.domain.product;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.product.ProductEvent.*;

public abstract class AbstractProductState implements ProductState, Saveable
{

    private String productId;

    public String getProductId()
    {
        return this.productId;
    }

    public void setProductId(String productId)
    {
        this.productId = productId;
    }

    private String productTypeId;

    public String getProductTypeId()
    {
        return this.productTypeId;
    }

    public void setProductTypeId(String productTypeId)
    {
        this.productTypeId = productTypeId;
    }

    private String primaryProductCategoryId;

    public String getPrimaryProductCategoryId()
    {
        return this.primaryProductCategoryId;
    }

    public void setPrimaryProductCategoryId(String primaryProductCategoryId)
    {
        this.primaryProductCategoryId = primaryProductCategoryId;
    }

    private String manufacturerPartyId;

    public String getManufacturerPartyId()
    {
        return this.manufacturerPartyId;
    }

    public void setManufacturerPartyId(String manufacturerPartyId)
    {
        this.manufacturerPartyId = manufacturerPartyId;
    }

    private String facilityId;

    public String getFacilityId()
    {
        return this.facilityId;
    }

    public void setFacilityId(String facilityId)
    {
        this.facilityId = facilityId;
    }

    private java.sql.Timestamp introductionDate;

    public java.sql.Timestamp getIntroductionDate()
    {
        return this.introductionDate;
    }

    public void setIntroductionDate(java.sql.Timestamp introductionDate)
    {
        this.introductionDate = introductionDate;
    }

    private java.sql.Timestamp releaseDate;

    public java.sql.Timestamp getReleaseDate()
    {
        return this.releaseDate;
    }

    public void setReleaseDate(java.sql.Timestamp releaseDate)
    {
        this.releaseDate = releaseDate;
    }

    private java.sql.Timestamp supportDiscontinuationDate;

    public java.sql.Timestamp getSupportDiscontinuationDate()
    {
        return this.supportDiscontinuationDate;
    }

    public void setSupportDiscontinuationDate(java.sql.Timestamp supportDiscontinuationDate)
    {
        this.supportDiscontinuationDate = supportDiscontinuationDate;
    }

    private java.sql.Timestamp salesDiscontinuationDate;

    public java.sql.Timestamp getSalesDiscontinuationDate()
    {
        return this.salesDiscontinuationDate;
    }

    public void setSalesDiscontinuationDate(java.sql.Timestamp salesDiscontinuationDate)
    {
        this.salesDiscontinuationDate = salesDiscontinuationDate;
    }

    private String salesDiscWhenNotAvail;

    public String getSalesDiscWhenNotAvail()
    {
        return this.salesDiscWhenNotAvail;
    }

    public void setSalesDiscWhenNotAvail(String salesDiscWhenNotAvail)
    {
        this.salesDiscWhenNotAvail = salesDiscWhenNotAvail;
    }

    private String internalName;

    public String getInternalName()
    {
        return this.internalName;
    }

    public void setInternalName(String internalName)
    {
        this.internalName = internalName;
    }

    private String brandName;

    public String getBrandName()
    {
        return this.brandName;
    }

    public void setBrandName(String brandName)
    {
        this.brandName = brandName;
    }

    private String comments;

    public String getComments()
    {
        return this.comments;
    }

    public void setComments(String comments)
    {
        this.comments = comments;
    }

    private String productName;

    public String getProductName()
    {
        return this.productName;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    private String description;

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    private String priceDetailText;

    public String getPriceDetailText()
    {
        return this.priceDetailText;
    }

    public void setPriceDetailText(String priceDetailText)
    {
        this.priceDetailText = priceDetailText;
    }

    private String smallImageUrl;

    public String getSmallImageUrl()
    {
        return this.smallImageUrl;
    }

    public void setSmallImageUrl(String smallImageUrl)
    {
        this.smallImageUrl = smallImageUrl;
    }

    private String mediumImageUrl;

    public String getMediumImageUrl()
    {
        return this.mediumImageUrl;
    }

    public void setMediumImageUrl(String mediumImageUrl)
    {
        this.mediumImageUrl = mediumImageUrl;
    }

    private String largeImageUrl;

    public String getLargeImageUrl()
    {
        return this.largeImageUrl;
    }

    public void setLargeImageUrl(String largeImageUrl)
    {
        this.largeImageUrl = largeImageUrl;
    }

    private String detailImageUrl;

    public String getDetailImageUrl()
    {
        return this.detailImageUrl;
    }

    public void setDetailImageUrl(String detailImageUrl)
    {
        this.detailImageUrl = detailImageUrl;
    }

    private String originalImageUrl;

    public String getOriginalImageUrl()
    {
        return this.originalImageUrl;
    }

    public void setOriginalImageUrl(String originalImageUrl)
    {
        this.originalImageUrl = originalImageUrl;
    }

    private String detailScreen;

    public String getDetailScreen()
    {
        return this.detailScreen;
    }

    public void setDetailScreen(String detailScreen)
    {
        this.detailScreen = detailScreen;
    }

    private String inventoryMessage;

    public String getInventoryMessage()
    {
        return this.inventoryMessage;
    }

    public void setInventoryMessage(String inventoryMessage)
    {
        this.inventoryMessage = inventoryMessage;
    }

    private String inventoryItemTypeId;

    public String getInventoryItemTypeId()
    {
        return this.inventoryItemTypeId;
    }

    public void setInventoryItemTypeId(String inventoryItemTypeId)
    {
        this.inventoryItemTypeId = inventoryItemTypeId;
    }

    private String requireInventory;

    public String getRequireInventory()
    {
        return this.requireInventory;
    }

    public void setRequireInventory(String requireInventory)
    {
        this.requireInventory = requireInventory;
    }

    private String quantityUomId;

    public String getQuantityUomId()
    {
        return this.quantityUomId;
    }

    public void setQuantityUomId(String quantityUomId)
    {
        this.quantityUomId = quantityUomId;
    }

    private java.math.BigDecimal quantityIncluded;

    public java.math.BigDecimal getQuantityIncluded()
    {
        return this.quantityIncluded;
    }

    public void setQuantityIncluded(java.math.BigDecimal quantityIncluded)
    {
        this.quantityIncluded = quantityIncluded;
    }

    private Long piecesIncluded;

    public Long getPiecesIncluded()
    {
        return this.piecesIncluded;
    }

    public void setPiecesIncluded(Long piecesIncluded)
    {
        this.piecesIncluded = piecesIncluded;
    }

    private String requireAmount;

    public String getRequireAmount()
    {
        return this.requireAmount;
    }

    public void setRequireAmount(String requireAmount)
    {
        this.requireAmount = requireAmount;
    }

    private java.math.BigDecimal fixedAmount;

    public java.math.BigDecimal getFixedAmount()
    {
        return this.fixedAmount;
    }

    public void setFixedAmount(java.math.BigDecimal fixedAmount)
    {
        this.fixedAmount = fixedAmount;
    }

    private String amountUomTypeId;

    public String getAmountUomTypeId()
    {
        return this.amountUomTypeId;
    }

    public void setAmountUomTypeId(String amountUomTypeId)
    {
        this.amountUomTypeId = amountUomTypeId;
    }

    private String weightUomId;

    public String getWeightUomId()
    {
        return this.weightUomId;
    }

    public void setWeightUomId(String weightUomId)
    {
        this.weightUomId = weightUomId;
    }

    private java.math.BigDecimal shippingWeight;

    public java.math.BigDecimal getShippingWeight()
    {
        return this.shippingWeight;
    }

    public void setShippingWeight(java.math.BigDecimal shippingWeight)
    {
        this.shippingWeight = shippingWeight;
    }

    private java.math.BigDecimal productWeight;

    public java.math.BigDecimal getProductWeight()
    {
        return this.productWeight;
    }

    public void setProductWeight(java.math.BigDecimal productWeight)
    {
        this.productWeight = productWeight;
    }

    private String heightUomId;

    public String getHeightUomId()
    {
        return this.heightUomId;
    }

    public void setHeightUomId(String heightUomId)
    {
        this.heightUomId = heightUomId;
    }

    private java.math.BigDecimal productHeight;

    public java.math.BigDecimal getProductHeight()
    {
        return this.productHeight;
    }

    public void setProductHeight(java.math.BigDecimal productHeight)
    {
        this.productHeight = productHeight;
    }

    private java.math.BigDecimal shippingHeight;

    public java.math.BigDecimal getShippingHeight()
    {
        return this.shippingHeight;
    }

    public void setShippingHeight(java.math.BigDecimal shippingHeight)
    {
        this.shippingHeight = shippingHeight;
    }

    private String widthUomId;

    public String getWidthUomId()
    {
        return this.widthUomId;
    }

    public void setWidthUomId(String widthUomId)
    {
        this.widthUomId = widthUomId;
    }

    private java.math.BigDecimal productWidth;

    public java.math.BigDecimal getProductWidth()
    {
        return this.productWidth;
    }

    public void setProductWidth(java.math.BigDecimal productWidth)
    {
        this.productWidth = productWidth;
    }

    private java.math.BigDecimal shippingWidth;

    public java.math.BigDecimal getShippingWidth()
    {
        return this.shippingWidth;
    }

    public void setShippingWidth(java.math.BigDecimal shippingWidth)
    {
        this.shippingWidth = shippingWidth;
    }

    private String depthUomId;

    public String getDepthUomId()
    {
        return this.depthUomId;
    }

    public void setDepthUomId(String depthUomId)
    {
        this.depthUomId = depthUomId;
    }

    private java.math.BigDecimal productDepth;

    public java.math.BigDecimal getProductDepth()
    {
        return this.productDepth;
    }

    public void setProductDepth(java.math.BigDecimal productDepth)
    {
        this.productDepth = productDepth;
    }

    private java.math.BigDecimal shippingDepth;

    public java.math.BigDecimal getShippingDepth()
    {
        return this.shippingDepth;
    }

    public void setShippingDepth(java.math.BigDecimal shippingDepth)
    {
        this.shippingDepth = shippingDepth;
    }

    private String diameterUomId;

    public String getDiameterUomId()
    {
        return this.diameterUomId;
    }

    public void setDiameterUomId(String diameterUomId)
    {
        this.diameterUomId = diameterUomId;
    }

    private java.math.BigDecimal productDiameter;

    public java.math.BigDecimal getProductDiameter()
    {
        return this.productDiameter;
    }

    public void setProductDiameter(java.math.BigDecimal productDiameter)
    {
        this.productDiameter = productDiameter;
    }

    private java.math.BigDecimal productRating;

    public java.math.BigDecimal getProductRating()
    {
        return this.productRating;
    }

    public void setProductRating(java.math.BigDecimal productRating)
    {
        this.productRating = productRating;
    }

    private String ratingTypeEnum;

    public String getRatingTypeEnum()
    {
        return this.ratingTypeEnum;
    }

    public void setRatingTypeEnum(String ratingTypeEnum)
    {
        this.ratingTypeEnum = ratingTypeEnum;
    }

    private String returnable;

    public String getReturnable()
    {
        return this.returnable;
    }

    public void setReturnable(String returnable)
    {
        this.returnable = returnable;
    }

    private String taxable;

    public String getTaxable()
    {
        return this.taxable;
    }

    public void setTaxable(String taxable)
    {
        this.taxable = taxable;
    }

    private String chargeShipping;

    public String getChargeShipping()
    {
        return this.chargeShipping;
    }

    public void setChargeShipping(String chargeShipping)
    {
        this.chargeShipping = chargeShipping;
    }

    private String autoCreateKeywords;

    public String getAutoCreateKeywords()
    {
        return this.autoCreateKeywords;
    }

    public void setAutoCreateKeywords(String autoCreateKeywords)
    {
        this.autoCreateKeywords = autoCreateKeywords;
    }

    private String includeInPromotions;

    public String getIncludeInPromotions()
    {
        return this.includeInPromotions;
    }

    public void setIncludeInPromotions(String includeInPromotions)
    {
        this.includeInPromotions = includeInPromotions;
    }

    private String isVirtual;

    public String getIsVirtual()
    {
        return this.isVirtual;
    }

    public void setIsVirtual(String isVirtual)
    {
        this.isVirtual = isVirtual;
    }

    private String isVariant;

    public String getIsVariant()
    {
        return this.isVariant;
    }

    public void setIsVariant(String isVariant)
    {
        this.isVariant = isVariant;
    }

    private String virtualVariantMethodEnum;

    public String getVirtualVariantMethodEnum()
    {
        return this.virtualVariantMethodEnum;
    }

    public void setVirtualVariantMethodEnum(String virtualVariantMethodEnum)
    {
        this.virtualVariantMethodEnum = virtualVariantMethodEnum;
    }

    private String inShippingBox;

    public String getInShippingBox()
    {
        return this.inShippingBox;
    }

    public void setInShippingBox(String inShippingBox)
    {
        this.inShippingBox = inShippingBox;
    }

    private String defaultShipmentBoxTypeId;

    public String getDefaultShipmentBoxTypeId()
    {
        return this.defaultShipmentBoxTypeId;
    }

    public void setDefaultShipmentBoxTypeId(String defaultShipmentBoxTypeId)
    {
        this.defaultShipmentBoxTypeId = defaultShipmentBoxTypeId;
    }

    private Boolean isSerialNumbered;

    public Boolean getIsSerialNumbered()
    {
        return this.isSerialNumbered;
    }

    public void setIsSerialNumbered(Boolean isSerialNumbered)
    {
        this.isSerialNumbered = isSerialNumbered;
    }

    private Boolean isManagedByLot;

    public Boolean getIsManagedByLot()
    {
        return this.isManagedByLot;
    }

    public void setIsManagedByLot(Boolean isManagedByLot)
    {
        this.isManagedByLot = isManagedByLot;
    }

    private String attributeSetId;

    public String getAttributeSetId()
    {
        return this.attributeSetId;
    }

    public void setAttributeSetId(String attributeSetId)
    {
        this.attributeSetId = attributeSetId;
    }

    private String attributeSetInstanceId;

    public String getAttributeSetInstanceId()
    {
        return this.attributeSetInstanceId;
    }

    public void setAttributeSetInstanceId(String attributeSetInstanceId)
    {
        this.attributeSetInstanceId = attributeSetInstanceId;
    }

    private String grade;

    public String getGrade()
    {
        return this.grade;
    }

    public void setGrade(String grade)
    {
        this.grade = grade;
    }

    private java.math.BigDecimal gsm;

    public java.math.BigDecimal getGsm()
    {
        return this.gsm;
    }

    public void setGsm(java.math.BigDecimal gsm)
    {
        this.gsm = gsm;
    }

    private java.math.BigDecimal coreDiameter;

    public java.math.BigDecimal getCoreDiameter()
    {
        return this.coreDiameter;
    }

    public void setCoreDiameter(java.math.BigDecimal coreDiameter)
    {
        this.coreDiameter = coreDiameter;
    }

    private java.math.BigDecimal outsideDiameter;

    public java.math.BigDecimal getOutsideDiameter()
    {
        return this.outsideDiameter;
    }

    public void setOutsideDiameter(java.math.BigDecimal outsideDiameter)
    {
        this.outsideDiameter = outsideDiameter;
    }

    private java.math.BigDecimal moisturePct;

    public java.math.BigDecimal getMoisturePct()
    {
        return this.moisturePct;
    }

    public void setMoisturePct(java.math.BigDecimal moisturePct)
    {
        this.moisturePct = moisturePct;
    }

    private String rollCnt;

    public String getRollCnt()
    {
        return this.rollCnt;
    }

    public void setRollCnt(String rollCnt)
    {
        this.rollCnt = rollCnt;
    }

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }

    private String createdBy;

    public String getCreatedBy()
    {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy)
    {
        this.createdBy = createdBy;
    }

    private Date createdAt;

    public Date getCreatedAt()
    {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    private String updatedBy;

    public String getUpdatedBy()
    {
        return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy)
    {
        this.updatedBy = updatedBy;
    }

    private Date updatedAt;

    public Date getUpdatedAt()
    {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt)
    {
        this.updatedAt = updatedAt;
    }

    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }

    public boolean isStateUnsaved() 
    {
        return this.getVersion() == null;
    }

    private EntityStateCollection<String, GoodIdentificationState> goodIdentifications;

    public EntityStateCollection<String, GoodIdentificationState> getGoodIdentifications()
    {
        return this.goodIdentifications;
    }

    public void setGoodIdentifications(EntityStateCollection<String, GoodIdentificationState> goodIdentifications)
    {
        this.goodIdentifications = goodIdentifications;
    }

    private Boolean stateReadOnly;

    public Boolean getStateReadOnly() { return this.stateReadOnly; }

    public void setStateReadOnly(Boolean readOnly) { this.stateReadOnly = readOnly; }

    private boolean forReapplying;

    public boolean getForReapplying() {
        return forReapplying;
    }

    public void setForReapplying(boolean forReapplying) {
        this.forReapplying = forReapplying;
    }

    public AbstractProductState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setProductId(((ProductEvent.SqlProductEvent) events.get(0)).getProductEventId().getProductId());
            for (Event e : events) {
                mutate(e);
                this.setVersion(this.getVersion() + 1);
            }
        }
    }


    public AbstractProductState() {
        this(false);
    }

    public AbstractProductState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
        goodIdentifications = new SimpleGoodIdentificationStateCollection(this);
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof ProductStateCreated) {
            when((ProductStateCreated) e);
        } else if (e instanceof ProductStateMergePatched) {
            when((ProductStateMergePatched) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(ProductStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setProductTypeId(e.getProductTypeId());
        this.setPrimaryProductCategoryId(e.getPrimaryProductCategoryId());
        this.setManufacturerPartyId(e.getManufacturerPartyId());
        this.setFacilityId(e.getFacilityId());
        this.setIntroductionDate(e.getIntroductionDate());
        this.setReleaseDate(e.getReleaseDate());
        this.setSupportDiscontinuationDate(e.getSupportDiscontinuationDate());
        this.setSalesDiscontinuationDate(e.getSalesDiscontinuationDate());
        this.setSalesDiscWhenNotAvail(e.getSalesDiscWhenNotAvail());
        this.setInternalName(e.getInternalName());
        this.setBrandName(e.getBrandName());
        this.setComments(e.getComments());
        this.setProductName(e.getProductName());
        this.setDescription(e.getDescription());
        this.setPriceDetailText(e.getPriceDetailText());
        this.setSmallImageUrl(e.getSmallImageUrl());
        this.setMediumImageUrl(e.getMediumImageUrl());
        this.setLargeImageUrl(e.getLargeImageUrl());
        this.setDetailImageUrl(e.getDetailImageUrl());
        this.setOriginalImageUrl(e.getOriginalImageUrl());
        this.setDetailScreen(e.getDetailScreen());
        this.setInventoryMessage(e.getInventoryMessage());
        this.setInventoryItemTypeId(e.getInventoryItemTypeId());
        this.setRequireInventory(e.getRequireInventory());
        this.setQuantityUomId(e.getQuantityUomId());
        this.setQuantityIncluded(e.getQuantityIncluded());
        this.setPiecesIncluded(e.getPiecesIncluded());
        this.setRequireAmount(e.getRequireAmount());
        this.setFixedAmount(e.getFixedAmount());
        this.setAmountUomTypeId(e.getAmountUomTypeId());
        this.setWeightUomId(e.getWeightUomId());
        this.setShippingWeight(e.getShippingWeight());
        this.setProductWeight(e.getProductWeight());
        this.setHeightUomId(e.getHeightUomId());
        this.setProductHeight(e.getProductHeight());
        this.setShippingHeight(e.getShippingHeight());
        this.setWidthUomId(e.getWidthUomId());
        this.setProductWidth(e.getProductWidth());
        this.setShippingWidth(e.getShippingWidth());
        this.setDepthUomId(e.getDepthUomId());
        this.setProductDepth(e.getProductDepth());
        this.setShippingDepth(e.getShippingDepth());
        this.setDiameterUomId(e.getDiameterUomId());
        this.setProductDiameter(e.getProductDiameter());
        this.setProductRating(e.getProductRating());
        this.setRatingTypeEnum(e.getRatingTypeEnum());
        this.setReturnable(e.getReturnable());
        this.setTaxable(e.getTaxable());
        this.setChargeShipping(e.getChargeShipping());
        this.setAutoCreateKeywords(e.getAutoCreateKeywords());
        this.setIncludeInPromotions(e.getIncludeInPromotions());
        this.setIsVirtual(e.getIsVirtual());
        this.setIsVariant(e.getIsVariant());
        this.setVirtualVariantMethodEnum(e.getVirtualVariantMethodEnum());
        this.setInShippingBox(e.getInShippingBox());
        this.setDefaultShipmentBoxTypeId(e.getDefaultShipmentBoxTypeId());
        this.setIsSerialNumbered(e.getIsSerialNumbered());
        this.setIsManagedByLot(e.getIsManagedByLot());
        this.setAttributeSetId(e.getAttributeSetId());
        this.setAttributeSetInstanceId(e.getAttributeSetInstanceId());
        this.setGrade(e.getGrade());
        this.setGsm(e.getGsm());
        this.setCoreDiameter(e.getCoreDiameter());
        this.setOutsideDiameter(e.getOutsideDiameter());
        this.setMoisturePct(e.getMoisturePct());
        this.setRollCnt(e.getRollCnt());
        this.setActive(e.getActive());

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

        for (GoodIdentificationEvent.GoodIdentificationStateCreated innerEvent : e.getGoodIdentificationEvents()) {
            GoodIdentificationState innerState = this.getGoodIdentifications().get(((GoodIdentificationEvent.SqlGoodIdentificationEvent)innerEvent).getGoodIdentificationEventId().getGoodIdentificationTypeId());
            innerState.mutate(innerEvent);
        }
    }

    public void when(ProductStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getProductTypeId() == null)
        {
            if (e.getIsPropertyProductTypeIdRemoved() != null && e.getIsPropertyProductTypeIdRemoved())
            {
                this.setProductTypeId(null);
            }
        }
        else
        {
            this.setProductTypeId(e.getProductTypeId());
        }
        if (e.getPrimaryProductCategoryId() == null)
        {
            if (e.getIsPropertyPrimaryProductCategoryIdRemoved() != null && e.getIsPropertyPrimaryProductCategoryIdRemoved())
            {
                this.setPrimaryProductCategoryId(null);
            }
        }
        else
        {
            this.setPrimaryProductCategoryId(e.getPrimaryProductCategoryId());
        }
        if (e.getManufacturerPartyId() == null)
        {
            if (e.getIsPropertyManufacturerPartyIdRemoved() != null && e.getIsPropertyManufacturerPartyIdRemoved())
            {
                this.setManufacturerPartyId(null);
            }
        }
        else
        {
            this.setManufacturerPartyId(e.getManufacturerPartyId());
        }
        if (e.getFacilityId() == null)
        {
            if (e.getIsPropertyFacilityIdRemoved() != null && e.getIsPropertyFacilityIdRemoved())
            {
                this.setFacilityId(null);
            }
        }
        else
        {
            this.setFacilityId(e.getFacilityId());
        }
        if (e.getIntroductionDate() == null)
        {
            if (e.getIsPropertyIntroductionDateRemoved() != null && e.getIsPropertyIntroductionDateRemoved())
            {
                this.setIntroductionDate(null);
            }
        }
        else
        {
            this.setIntroductionDate(e.getIntroductionDate());
        }
        if (e.getReleaseDate() == null)
        {
            if (e.getIsPropertyReleaseDateRemoved() != null && e.getIsPropertyReleaseDateRemoved())
            {
                this.setReleaseDate(null);
            }
        }
        else
        {
            this.setReleaseDate(e.getReleaseDate());
        }
        if (e.getSupportDiscontinuationDate() == null)
        {
            if (e.getIsPropertySupportDiscontinuationDateRemoved() != null && e.getIsPropertySupportDiscontinuationDateRemoved())
            {
                this.setSupportDiscontinuationDate(null);
            }
        }
        else
        {
            this.setSupportDiscontinuationDate(e.getSupportDiscontinuationDate());
        }
        if (e.getSalesDiscontinuationDate() == null)
        {
            if (e.getIsPropertySalesDiscontinuationDateRemoved() != null && e.getIsPropertySalesDiscontinuationDateRemoved())
            {
                this.setSalesDiscontinuationDate(null);
            }
        }
        else
        {
            this.setSalesDiscontinuationDate(e.getSalesDiscontinuationDate());
        }
        if (e.getSalesDiscWhenNotAvail() == null)
        {
            if (e.getIsPropertySalesDiscWhenNotAvailRemoved() != null && e.getIsPropertySalesDiscWhenNotAvailRemoved())
            {
                this.setSalesDiscWhenNotAvail(null);
            }
        }
        else
        {
            this.setSalesDiscWhenNotAvail(e.getSalesDiscWhenNotAvail());
        }
        if (e.getInternalName() == null)
        {
            if (e.getIsPropertyInternalNameRemoved() != null && e.getIsPropertyInternalNameRemoved())
            {
                this.setInternalName(null);
            }
        }
        else
        {
            this.setInternalName(e.getInternalName());
        }
        if (e.getBrandName() == null)
        {
            if (e.getIsPropertyBrandNameRemoved() != null && e.getIsPropertyBrandNameRemoved())
            {
                this.setBrandName(null);
            }
        }
        else
        {
            this.setBrandName(e.getBrandName());
        }
        if (e.getComments() == null)
        {
            if (e.getIsPropertyCommentsRemoved() != null && e.getIsPropertyCommentsRemoved())
            {
                this.setComments(null);
            }
        }
        else
        {
            this.setComments(e.getComments());
        }
        if (e.getProductName() == null)
        {
            if (e.getIsPropertyProductNameRemoved() != null && e.getIsPropertyProductNameRemoved())
            {
                this.setProductName(null);
            }
        }
        else
        {
            this.setProductName(e.getProductName());
        }
        if (e.getDescription() == null)
        {
            if (e.getIsPropertyDescriptionRemoved() != null && e.getIsPropertyDescriptionRemoved())
            {
                this.setDescription(null);
            }
        }
        else
        {
            this.setDescription(e.getDescription());
        }
        if (e.getPriceDetailText() == null)
        {
            if (e.getIsPropertyPriceDetailTextRemoved() != null && e.getIsPropertyPriceDetailTextRemoved())
            {
                this.setPriceDetailText(null);
            }
        }
        else
        {
            this.setPriceDetailText(e.getPriceDetailText());
        }
        if (e.getSmallImageUrl() == null)
        {
            if (e.getIsPropertySmallImageUrlRemoved() != null && e.getIsPropertySmallImageUrlRemoved())
            {
                this.setSmallImageUrl(null);
            }
        }
        else
        {
            this.setSmallImageUrl(e.getSmallImageUrl());
        }
        if (e.getMediumImageUrl() == null)
        {
            if (e.getIsPropertyMediumImageUrlRemoved() != null && e.getIsPropertyMediumImageUrlRemoved())
            {
                this.setMediumImageUrl(null);
            }
        }
        else
        {
            this.setMediumImageUrl(e.getMediumImageUrl());
        }
        if (e.getLargeImageUrl() == null)
        {
            if (e.getIsPropertyLargeImageUrlRemoved() != null && e.getIsPropertyLargeImageUrlRemoved())
            {
                this.setLargeImageUrl(null);
            }
        }
        else
        {
            this.setLargeImageUrl(e.getLargeImageUrl());
        }
        if (e.getDetailImageUrl() == null)
        {
            if (e.getIsPropertyDetailImageUrlRemoved() != null && e.getIsPropertyDetailImageUrlRemoved())
            {
                this.setDetailImageUrl(null);
            }
        }
        else
        {
            this.setDetailImageUrl(e.getDetailImageUrl());
        }
        if (e.getOriginalImageUrl() == null)
        {
            if (e.getIsPropertyOriginalImageUrlRemoved() != null && e.getIsPropertyOriginalImageUrlRemoved())
            {
                this.setOriginalImageUrl(null);
            }
        }
        else
        {
            this.setOriginalImageUrl(e.getOriginalImageUrl());
        }
        if (e.getDetailScreen() == null)
        {
            if (e.getIsPropertyDetailScreenRemoved() != null && e.getIsPropertyDetailScreenRemoved())
            {
                this.setDetailScreen(null);
            }
        }
        else
        {
            this.setDetailScreen(e.getDetailScreen());
        }
        if (e.getInventoryMessage() == null)
        {
            if (e.getIsPropertyInventoryMessageRemoved() != null && e.getIsPropertyInventoryMessageRemoved())
            {
                this.setInventoryMessage(null);
            }
        }
        else
        {
            this.setInventoryMessage(e.getInventoryMessage());
        }
        if (e.getInventoryItemTypeId() == null)
        {
            if (e.getIsPropertyInventoryItemTypeIdRemoved() != null && e.getIsPropertyInventoryItemTypeIdRemoved())
            {
                this.setInventoryItemTypeId(null);
            }
        }
        else
        {
            this.setInventoryItemTypeId(e.getInventoryItemTypeId());
        }
        if (e.getRequireInventory() == null)
        {
            if (e.getIsPropertyRequireInventoryRemoved() != null && e.getIsPropertyRequireInventoryRemoved())
            {
                this.setRequireInventory(null);
            }
        }
        else
        {
            this.setRequireInventory(e.getRequireInventory());
        }
        if (e.getQuantityUomId() == null)
        {
            if (e.getIsPropertyQuantityUomIdRemoved() != null && e.getIsPropertyQuantityUomIdRemoved())
            {
                this.setQuantityUomId(null);
            }
        }
        else
        {
            this.setQuantityUomId(e.getQuantityUomId());
        }
        if (e.getQuantityIncluded() == null)
        {
            if (e.getIsPropertyQuantityIncludedRemoved() != null && e.getIsPropertyQuantityIncludedRemoved())
            {
                this.setQuantityIncluded(null);
            }
        }
        else
        {
            this.setQuantityIncluded(e.getQuantityIncluded());
        }
        if (e.getPiecesIncluded() == null)
        {
            if (e.getIsPropertyPiecesIncludedRemoved() != null && e.getIsPropertyPiecesIncludedRemoved())
            {
                this.setPiecesIncluded(null);
            }
        }
        else
        {
            this.setPiecesIncluded(e.getPiecesIncluded());
        }
        if (e.getRequireAmount() == null)
        {
            if (e.getIsPropertyRequireAmountRemoved() != null && e.getIsPropertyRequireAmountRemoved())
            {
                this.setRequireAmount(null);
            }
        }
        else
        {
            this.setRequireAmount(e.getRequireAmount());
        }
        if (e.getFixedAmount() == null)
        {
            if (e.getIsPropertyFixedAmountRemoved() != null && e.getIsPropertyFixedAmountRemoved())
            {
                this.setFixedAmount(null);
            }
        }
        else
        {
            this.setFixedAmount(e.getFixedAmount());
        }
        if (e.getAmountUomTypeId() == null)
        {
            if (e.getIsPropertyAmountUomTypeIdRemoved() != null && e.getIsPropertyAmountUomTypeIdRemoved())
            {
                this.setAmountUomTypeId(null);
            }
        }
        else
        {
            this.setAmountUomTypeId(e.getAmountUomTypeId());
        }
        if (e.getWeightUomId() == null)
        {
            if (e.getIsPropertyWeightUomIdRemoved() != null && e.getIsPropertyWeightUomIdRemoved())
            {
                this.setWeightUomId(null);
            }
        }
        else
        {
            this.setWeightUomId(e.getWeightUomId());
        }
        if (e.getShippingWeight() == null)
        {
            if (e.getIsPropertyShippingWeightRemoved() != null && e.getIsPropertyShippingWeightRemoved())
            {
                this.setShippingWeight(null);
            }
        }
        else
        {
            this.setShippingWeight(e.getShippingWeight());
        }
        if (e.getProductWeight() == null)
        {
            if (e.getIsPropertyProductWeightRemoved() != null && e.getIsPropertyProductWeightRemoved())
            {
                this.setProductWeight(null);
            }
        }
        else
        {
            this.setProductWeight(e.getProductWeight());
        }
        if (e.getHeightUomId() == null)
        {
            if (e.getIsPropertyHeightUomIdRemoved() != null && e.getIsPropertyHeightUomIdRemoved())
            {
                this.setHeightUomId(null);
            }
        }
        else
        {
            this.setHeightUomId(e.getHeightUomId());
        }
        if (e.getProductHeight() == null)
        {
            if (e.getIsPropertyProductHeightRemoved() != null && e.getIsPropertyProductHeightRemoved())
            {
                this.setProductHeight(null);
            }
        }
        else
        {
            this.setProductHeight(e.getProductHeight());
        }
        if (e.getShippingHeight() == null)
        {
            if (e.getIsPropertyShippingHeightRemoved() != null && e.getIsPropertyShippingHeightRemoved())
            {
                this.setShippingHeight(null);
            }
        }
        else
        {
            this.setShippingHeight(e.getShippingHeight());
        }
        if (e.getWidthUomId() == null)
        {
            if (e.getIsPropertyWidthUomIdRemoved() != null && e.getIsPropertyWidthUomIdRemoved())
            {
                this.setWidthUomId(null);
            }
        }
        else
        {
            this.setWidthUomId(e.getWidthUomId());
        }
        if (e.getProductWidth() == null)
        {
            if (e.getIsPropertyProductWidthRemoved() != null && e.getIsPropertyProductWidthRemoved())
            {
                this.setProductWidth(null);
            }
        }
        else
        {
            this.setProductWidth(e.getProductWidth());
        }
        if (e.getShippingWidth() == null)
        {
            if (e.getIsPropertyShippingWidthRemoved() != null && e.getIsPropertyShippingWidthRemoved())
            {
                this.setShippingWidth(null);
            }
        }
        else
        {
            this.setShippingWidth(e.getShippingWidth());
        }
        if (e.getDepthUomId() == null)
        {
            if (e.getIsPropertyDepthUomIdRemoved() != null && e.getIsPropertyDepthUomIdRemoved())
            {
                this.setDepthUomId(null);
            }
        }
        else
        {
            this.setDepthUomId(e.getDepthUomId());
        }
        if (e.getProductDepth() == null)
        {
            if (e.getIsPropertyProductDepthRemoved() != null && e.getIsPropertyProductDepthRemoved())
            {
                this.setProductDepth(null);
            }
        }
        else
        {
            this.setProductDepth(e.getProductDepth());
        }
        if (e.getShippingDepth() == null)
        {
            if (e.getIsPropertyShippingDepthRemoved() != null && e.getIsPropertyShippingDepthRemoved())
            {
                this.setShippingDepth(null);
            }
        }
        else
        {
            this.setShippingDepth(e.getShippingDepth());
        }
        if (e.getDiameterUomId() == null)
        {
            if (e.getIsPropertyDiameterUomIdRemoved() != null && e.getIsPropertyDiameterUomIdRemoved())
            {
                this.setDiameterUomId(null);
            }
        }
        else
        {
            this.setDiameterUomId(e.getDiameterUomId());
        }
        if (e.getProductDiameter() == null)
        {
            if (e.getIsPropertyProductDiameterRemoved() != null && e.getIsPropertyProductDiameterRemoved())
            {
                this.setProductDiameter(null);
            }
        }
        else
        {
            this.setProductDiameter(e.getProductDiameter());
        }
        if (e.getProductRating() == null)
        {
            if (e.getIsPropertyProductRatingRemoved() != null && e.getIsPropertyProductRatingRemoved())
            {
                this.setProductRating(null);
            }
        }
        else
        {
            this.setProductRating(e.getProductRating());
        }
        if (e.getRatingTypeEnum() == null)
        {
            if (e.getIsPropertyRatingTypeEnumRemoved() != null && e.getIsPropertyRatingTypeEnumRemoved())
            {
                this.setRatingTypeEnum(null);
            }
        }
        else
        {
            this.setRatingTypeEnum(e.getRatingTypeEnum());
        }
        if (e.getReturnable() == null)
        {
            if (e.getIsPropertyReturnableRemoved() != null && e.getIsPropertyReturnableRemoved())
            {
                this.setReturnable(null);
            }
        }
        else
        {
            this.setReturnable(e.getReturnable());
        }
        if (e.getTaxable() == null)
        {
            if (e.getIsPropertyTaxableRemoved() != null && e.getIsPropertyTaxableRemoved())
            {
                this.setTaxable(null);
            }
        }
        else
        {
            this.setTaxable(e.getTaxable());
        }
        if (e.getChargeShipping() == null)
        {
            if (e.getIsPropertyChargeShippingRemoved() != null && e.getIsPropertyChargeShippingRemoved())
            {
                this.setChargeShipping(null);
            }
        }
        else
        {
            this.setChargeShipping(e.getChargeShipping());
        }
        if (e.getAutoCreateKeywords() == null)
        {
            if (e.getIsPropertyAutoCreateKeywordsRemoved() != null && e.getIsPropertyAutoCreateKeywordsRemoved())
            {
                this.setAutoCreateKeywords(null);
            }
        }
        else
        {
            this.setAutoCreateKeywords(e.getAutoCreateKeywords());
        }
        if (e.getIncludeInPromotions() == null)
        {
            if (e.getIsPropertyIncludeInPromotionsRemoved() != null && e.getIsPropertyIncludeInPromotionsRemoved())
            {
                this.setIncludeInPromotions(null);
            }
        }
        else
        {
            this.setIncludeInPromotions(e.getIncludeInPromotions());
        }
        if (e.getIsVirtual() == null)
        {
            if (e.getIsPropertyIsVirtualRemoved() != null && e.getIsPropertyIsVirtualRemoved())
            {
                this.setIsVirtual(null);
            }
        }
        else
        {
            this.setIsVirtual(e.getIsVirtual());
        }
        if (e.getIsVariant() == null)
        {
            if (e.getIsPropertyIsVariantRemoved() != null && e.getIsPropertyIsVariantRemoved())
            {
                this.setIsVariant(null);
            }
        }
        else
        {
            this.setIsVariant(e.getIsVariant());
        }
        if (e.getVirtualVariantMethodEnum() == null)
        {
            if (e.getIsPropertyVirtualVariantMethodEnumRemoved() != null && e.getIsPropertyVirtualVariantMethodEnumRemoved())
            {
                this.setVirtualVariantMethodEnum(null);
            }
        }
        else
        {
            this.setVirtualVariantMethodEnum(e.getVirtualVariantMethodEnum());
        }
        if (e.getInShippingBox() == null)
        {
            if (e.getIsPropertyInShippingBoxRemoved() != null && e.getIsPropertyInShippingBoxRemoved())
            {
                this.setInShippingBox(null);
            }
        }
        else
        {
            this.setInShippingBox(e.getInShippingBox());
        }
        if (e.getDefaultShipmentBoxTypeId() == null)
        {
            if (e.getIsPropertyDefaultShipmentBoxTypeIdRemoved() != null && e.getIsPropertyDefaultShipmentBoxTypeIdRemoved())
            {
                this.setDefaultShipmentBoxTypeId(null);
            }
        }
        else
        {
            this.setDefaultShipmentBoxTypeId(e.getDefaultShipmentBoxTypeId());
        }
        if (e.getIsSerialNumbered() == null)
        {
            if (e.getIsPropertyIsSerialNumberedRemoved() != null && e.getIsPropertyIsSerialNumberedRemoved())
            {
                this.setIsSerialNumbered(null);
            }
        }
        else
        {
            this.setIsSerialNumbered(e.getIsSerialNumbered());
        }
        if (e.getIsManagedByLot() == null)
        {
            if (e.getIsPropertyIsManagedByLotRemoved() != null && e.getIsPropertyIsManagedByLotRemoved())
            {
                this.setIsManagedByLot(null);
            }
        }
        else
        {
            this.setIsManagedByLot(e.getIsManagedByLot());
        }
        if (e.getAttributeSetId() == null)
        {
            if (e.getIsPropertyAttributeSetIdRemoved() != null && e.getIsPropertyAttributeSetIdRemoved())
            {
                this.setAttributeSetId(null);
            }
        }
        else
        {
            this.setAttributeSetId(e.getAttributeSetId());
        }
        if (e.getAttributeSetInstanceId() == null)
        {
            if (e.getIsPropertyAttributeSetInstanceIdRemoved() != null && e.getIsPropertyAttributeSetInstanceIdRemoved())
            {
                this.setAttributeSetInstanceId(null);
            }
        }
        else
        {
            this.setAttributeSetInstanceId(e.getAttributeSetInstanceId());
        }
        if (e.getGrade() == null)
        {
            if (e.getIsPropertyGradeRemoved() != null && e.getIsPropertyGradeRemoved())
            {
                this.setGrade(null);
            }
        }
        else
        {
            this.setGrade(e.getGrade());
        }
        if (e.getGsm() == null)
        {
            if (e.getIsPropertyGsmRemoved() != null && e.getIsPropertyGsmRemoved())
            {
                this.setGsm(null);
            }
        }
        else
        {
            this.setGsm(e.getGsm());
        }
        if (e.getCoreDiameter() == null)
        {
            if (e.getIsPropertyCoreDiameterRemoved() != null && e.getIsPropertyCoreDiameterRemoved())
            {
                this.setCoreDiameter(null);
            }
        }
        else
        {
            this.setCoreDiameter(e.getCoreDiameter());
        }
        if (e.getOutsideDiameter() == null)
        {
            if (e.getIsPropertyOutsideDiameterRemoved() != null && e.getIsPropertyOutsideDiameterRemoved())
            {
                this.setOutsideDiameter(null);
            }
        }
        else
        {
            this.setOutsideDiameter(e.getOutsideDiameter());
        }
        if (e.getMoisturePct() == null)
        {
            if (e.getIsPropertyMoisturePctRemoved() != null && e.getIsPropertyMoisturePctRemoved())
            {
                this.setMoisturePct(null);
            }
        }
        else
        {
            this.setMoisturePct(e.getMoisturePct());
        }
        if (e.getRollCnt() == null)
        {
            if (e.getIsPropertyRollCntRemoved() != null && e.getIsPropertyRollCntRemoved())
            {
                this.setRollCnt(null);
            }
        }
        else
        {
            this.setRollCnt(e.getRollCnt());
        }
        if (e.getActive() == null)
        {
            if (e.getIsPropertyActiveRemoved() != null && e.getIsPropertyActiveRemoved())
            {
                this.setActive(null);
            }
        }
        else
        {
            this.setActive(e.getActive());
        }

        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

        for (GoodIdentificationEvent innerEvent : e.getGoodIdentificationEvents()) {
            GoodIdentificationState innerState = this.getGoodIdentifications().get(((GoodIdentificationEvent.SqlGoodIdentificationEvent)innerEvent).getGoodIdentificationEventId().getGoodIdentificationTypeId());
            innerState.mutate(innerEvent);
            if (innerEvent instanceof GoodIdentificationEvent.GoodIdentificationStateRemoved)
            {
                //GoodIdentificationEvent.GoodIdentificationStateRemoved removed = (GoodIdentificationEvent.GoodIdentificationStateRemoved)innerEvent;
                this.getGoodIdentifications().remove(innerState);
            }
        }
    }

    public void save()
    {
        ((Saveable)goodIdentifications).save();

    }

    protected void throwOnWrongEvent(ProductEvent event)
    {
        String stateEntityId = this.getProductId(); // Aggregate Id
        String eventEntityId = ((ProductEvent.SqlProductEvent)event).getProductEventId().getProductId(); // EntityBase.Aggregate.GetEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getVersion();
        Long eventVersion = ((ProductEvent.SqlProductEvent)event).getProductEventId().getVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("event.getProductEventId().getVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(ProductState.VERSION_NULL)) && !eventVersion.equals(stateVersion))
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleProductState extends AbstractProductState
    {

        public SimpleProductState() {
        }

        public SimpleProductState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimpleProductState(List<Event> events) {
            super(events);
        }

    }

    static class SimpleGoodIdentificationStateCollection extends AbstractGoodIdentificationStateCollection
    {
        public SimpleGoodIdentificationStateCollection(AbstractProductState outerState)
        {
            super(outerState);
        }
    }


}

