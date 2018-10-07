package org.dddml.wms.domain.product;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractProductAggregate extends AbstractAggregate implements ProductAggregate
{
    private ProductState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractProductAggregate(ProductState state)
    {
        this.state = state;
    }

    public ProductState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(ProductCommand.CreateProduct c)
    {
        if (c.getVersion() == null) { c.setVersion(ProductState.VERSION_NULL); }
        ProductEvent e = map(c);
        apply(e);
    }

    public void mergePatch(ProductCommand.MergePatchProduct c)
    {
        ProductEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        ProductCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected ProductEvent map(ProductCommand.CreateProduct c) {
        ProductEventId stateEventId = new ProductEventId(c.getProductId(), c.getVersion());
        ProductEvent.ProductStateCreated e = newProductStateCreated(stateEventId);
        e.setProductTypeId(c.getProductTypeId());
        e.setPrimaryProductCategoryId(c.getPrimaryProductCategoryId());
        e.setManufacturerPartyId(c.getManufacturerPartyId());
        e.setFacilityId(c.getFacilityId());
        e.setIntroductionDate(c.getIntroductionDate());
        e.setReleaseDate(c.getReleaseDate());
        e.setSupportDiscontinuationDate(c.getSupportDiscontinuationDate());
        e.setSalesDiscontinuationDate(c.getSalesDiscontinuationDate());
        e.setSalesDiscWhenNotAvail(c.getSalesDiscWhenNotAvail());
        e.setInternalName(c.getInternalName());
        e.setBrandName(c.getBrandName());
        e.setComments(c.getComments());
        e.setProductName(c.getProductName());
        e.setDescription(c.getDescription());
        e.setPriceDetailText(c.getPriceDetailText());
        e.setSmallImageUrl(c.getSmallImageUrl());
        e.setMediumImageUrl(c.getMediumImageUrl());
        e.setLargeImageUrl(c.getLargeImageUrl());
        e.setDetailImageUrl(c.getDetailImageUrl());
        e.setOriginalImageUrl(c.getOriginalImageUrl());
        e.setDetailScreen(c.getDetailScreen());
        e.setInventoryMessage(c.getInventoryMessage());
        e.setInventoryItemTypeId(c.getInventoryItemTypeId());
        e.setRequireInventory(c.getRequireInventory());
        e.setQuantityUomId(c.getQuantityUomId());
        e.setQuantityIncluded(c.getQuantityIncluded());
        e.setPiecesIncluded(c.getPiecesIncluded());
        e.setRequireAmount(c.getRequireAmount());
        e.setFixedAmount(c.getFixedAmount());
        e.setAmountUomTypeId(c.getAmountUomTypeId());
        e.setWeightUomId(c.getWeightUomId());
        e.setShippingWeight(c.getShippingWeight());
        e.setProductWeight(c.getProductWeight());
        e.setHeightUomId(c.getHeightUomId());
        e.setProductHeight(c.getProductHeight());
        e.setShippingHeight(c.getShippingHeight());
        e.setWidthUomId(c.getWidthUomId());
        e.setProductWidth(c.getProductWidth());
        e.setShippingWidth(c.getShippingWidth());
        e.setDepthUomId(c.getDepthUomId());
        e.setProductDepth(c.getProductDepth());
        e.setShippingDepth(c.getShippingDepth());
        e.setDiameterUomId(c.getDiameterUomId());
        e.setProductDiameter(c.getProductDiameter());
        e.setProductRating(c.getProductRating());
        e.setRatingTypeEnum(c.getRatingTypeEnum());
        e.setReturnable(c.getReturnable());
        e.setTaxable(c.getTaxable());
        e.setChargeShipping(c.getChargeShipping());
        e.setAutoCreateKeywords(c.getAutoCreateKeywords());
        e.setIncludeInPromotions(c.getIncludeInPromotions());
        e.setIsVirtual(c.getIsVirtual());
        e.setIsVariant(c.getIsVariant());
        e.setVirtualVariantMethodEnum(c.getVirtualVariantMethodEnum());
        e.setInShippingBox(c.getInShippingBox());
        e.setDefaultShipmentBoxTypeId(c.getDefaultShipmentBoxTypeId());
        e.setIsSerialNumbered(c.getIsSerialNumbered());
        e.setIsManagedByLot(c.getIsManagedByLot());
        e.setAttributeSetId(c.getAttributeSetId());
        e.setAttributeSetInstanceId(c.getAttributeSetInstanceId());
        e.setGrade(c.getGrade());
        e.setGsm(c.getGsm());
        e.setCoreDiameter(c.getCoreDiameter());
        e.setOutsideDiameter(c.getOutsideDiameter());
        e.setMoisturePct(c.getMoisturePct());
        e.setRollCnt(c.getRollCnt());
        e.setActive(c.getActive());
        ((AbstractProductEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        Long version = c.getVersion();
        for (GoodIdentificationCommand.CreateGoodIdentification innerCommand : c.getCreateGoodIdentificationCommands())
        {
            throwOnInconsistentCommands(c, innerCommand);
            GoodIdentificationEvent.GoodIdentificationStateCreated innerEvent = mapCreate(innerCommand, c, version, this.state);
            e.addGoodIdentificationEvent(innerEvent);
        }

        return e;
    }

    protected ProductEvent map(ProductCommand.MergePatchProduct c) {
        ProductEventId stateEventId = new ProductEventId(c.getProductId(), c.getVersion());
        ProductEvent.ProductStateMergePatched e = newProductStateMergePatched(stateEventId);
        e.setProductTypeId(c.getProductTypeId());
        e.setPrimaryProductCategoryId(c.getPrimaryProductCategoryId());
        e.setManufacturerPartyId(c.getManufacturerPartyId());
        e.setFacilityId(c.getFacilityId());
        e.setIntroductionDate(c.getIntroductionDate());
        e.setReleaseDate(c.getReleaseDate());
        e.setSupportDiscontinuationDate(c.getSupportDiscontinuationDate());
        e.setSalesDiscontinuationDate(c.getSalesDiscontinuationDate());
        e.setSalesDiscWhenNotAvail(c.getSalesDiscWhenNotAvail());
        e.setInternalName(c.getInternalName());
        e.setBrandName(c.getBrandName());
        e.setComments(c.getComments());
        e.setProductName(c.getProductName());
        e.setDescription(c.getDescription());
        e.setPriceDetailText(c.getPriceDetailText());
        e.setSmallImageUrl(c.getSmallImageUrl());
        e.setMediumImageUrl(c.getMediumImageUrl());
        e.setLargeImageUrl(c.getLargeImageUrl());
        e.setDetailImageUrl(c.getDetailImageUrl());
        e.setOriginalImageUrl(c.getOriginalImageUrl());
        e.setDetailScreen(c.getDetailScreen());
        e.setInventoryMessage(c.getInventoryMessage());
        e.setInventoryItemTypeId(c.getInventoryItemTypeId());
        e.setRequireInventory(c.getRequireInventory());
        e.setQuantityUomId(c.getQuantityUomId());
        e.setQuantityIncluded(c.getQuantityIncluded());
        e.setPiecesIncluded(c.getPiecesIncluded());
        e.setRequireAmount(c.getRequireAmount());
        e.setFixedAmount(c.getFixedAmount());
        e.setAmountUomTypeId(c.getAmountUomTypeId());
        e.setWeightUomId(c.getWeightUomId());
        e.setShippingWeight(c.getShippingWeight());
        e.setProductWeight(c.getProductWeight());
        e.setHeightUomId(c.getHeightUomId());
        e.setProductHeight(c.getProductHeight());
        e.setShippingHeight(c.getShippingHeight());
        e.setWidthUomId(c.getWidthUomId());
        e.setProductWidth(c.getProductWidth());
        e.setShippingWidth(c.getShippingWidth());
        e.setDepthUomId(c.getDepthUomId());
        e.setProductDepth(c.getProductDepth());
        e.setShippingDepth(c.getShippingDepth());
        e.setDiameterUomId(c.getDiameterUomId());
        e.setProductDiameter(c.getProductDiameter());
        e.setProductRating(c.getProductRating());
        e.setRatingTypeEnum(c.getRatingTypeEnum());
        e.setReturnable(c.getReturnable());
        e.setTaxable(c.getTaxable());
        e.setChargeShipping(c.getChargeShipping());
        e.setAutoCreateKeywords(c.getAutoCreateKeywords());
        e.setIncludeInPromotions(c.getIncludeInPromotions());
        e.setIsVirtual(c.getIsVirtual());
        e.setIsVariant(c.getIsVariant());
        e.setVirtualVariantMethodEnum(c.getVirtualVariantMethodEnum());
        e.setInShippingBox(c.getInShippingBox());
        e.setDefaultShipmentBoxTypeId(c.getDefaultShipmentBoxTypeId());
        e.setIsSerialNumbered(c.getIsSerialNumbered());
        e.setIsManagedByLot(c.getIsManagedByLot());
        e.setAttributeSetId(c.getAttributeSetId());
        e.setAttributeSetInstanceId(c.getAttributeSetInstanceId());
        e.setGrade(c.getGrade());
        e.setGsm(c.getGsm());
        e.setCoreDiameter(c.getCoreDiameter());
        e.setOutsideDiameter(c.getOutsideDiameter());
        e.setMoisturePct(c.getMoisturePct());
        e.setRollCnt(c.getRollCnt());
        e.setActive(c.getActive());
        e.setIsPropertyProductTypeIdRemoved(c.getIsPropertyProductTypeIdRemoved());
        e.setIsPropertyPrimaryProductCategoryIdRemoved(c.getIsPropertyPrimaryProductCategoryIdRemoved());
        e.setIsPropertyManufacturerPartyIdRemoved(c.getIsPropertyManufacturerPartyIdRemoved());
        e.setIsPropertyFacilityIdRemoved(c.getIsPropertyFacilityIdRemoved());
        e.setIsPropertyIntroductionDateRemoved(c.getIsPropertyIntroductionDateRemoved());
        e.setIsPropertyReleaseDateRemoved(c.getIsPropertyReleaseDateRemoved());
        e.setIsPropertySupportDiscontinuationDateRemoved(c.getIsPropertySupportDiscontinuationDateRemoved());
        e.setIsPropertySalesDiscontinuationDateRemoved(c.getIsPropertySalesDiscontinuationDateRemoved());
        e.setIsPropertySalesDiscWhenNotAvailRemoved(c.getIsPropertySalesDiscWhenNotAvailRemoved());
        e.setIsPropertyInternalNameRemoved(c.getIsPropertyInternalNameRemoved());
        e.setIsPropertyBrandNameRemoved(c.getIsPropertyBrandNameRemoved());
        e.setIsPropertyCommentsRemoved(c.getIsPropertyCommentsRemoved());
        e.setIsPropertyProductNameRemoved(c.getIsPropertyProductNameRemoved());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertyPriceDetailTextRemoved(c.getIsPropertyPriceDetailTextRemoved());
        e.setIsPropertySmallImageUrlRemoved(c.getIsPropertySmallImageUrlRemoved());
        e.setIsPropertyMediumImageUrlRemoved(c.getIsPropertyMediumImageUrlRemoved());
        e.setIsPropertyLargeImageUrlRemoved(c.getIsPropertyLargeImageUrlRemoved());
        e.setIsPropertyDetailImageUrlRemoved(c.getIsPropertyDetailImageUrlRemoved());
        e.setIsPropertyOriginalImageUrlRemoved(c.getIsPropertyOriginalImageUrlRemoved());
        e.setIsPropertyDetailScreenRemoved(c.getIsPropertyDetailScreenRemoved());
        e.setIsPropertyInventoryMessageRemoved(c.getIsPropertyInventoryMessageRemoved());
        e.setIsPropertyInventoryItemTypeIdRemoved(c.getIsPropertyInventoryItemTypeIdRemoved());
        e.setIsPropertyRequireInventoryRemoved(c.getIsPropertyRequireInventoryRemoved());
        e.setIsPropertyQuantityUomIdRemoved(c.getIsPropertyQuantityUomIdRemoved());
        e.setIsPropertyQuantityIncludedRemoved(c.getIsPropertyQuantityIncludedRemoved());
        e.setIsPropertyPiecesIncludedRemoved(c.getIsPropertyPiecesIncludedRemoved());
        e.setIsPropertyRequireAmountRemoved(c.getIsPropertyRequireAmountRemoved());
        e.setIsPropertyFixedAmountRemoved(c.getIsPropertyFixedAmountRemoved());
        e.setIsPropertyAmountUomTypeIdRemoved(c.getIsPropertyAmountUomTypeIdRemoved());
        e.setIsPropertyWeightUomIdRemoved(c.getIsPropertyWeightUomIdRemoved());
        e.setIsPropertyShippingWeightRemoved(c.getIsPropertyShippingWeightRemoved());
        e.setIsPropertyProductWeightRemoved(c.getIsPropertyProductWeightRemoved());
        e.setIsPropertyHeightUomIdRemoved(c.getIsPropertyHeightUomIdRemoved());
        e.setIsPropertyProductHeightRemoved(c.getIsPropertyProductHeightRemoved());
        e.setIsPropertyShippingHeightRemoved(c.getIsPropertyShippingHeightRemoved());
        e.setIsPropertyWidthUomIdRemoved(c.getIsPropertyWidthUomIdRemoved());
        e.setIsPropertyProductWidthRemoved(c.getIsPropertyProductWidthRemoved());
        e.setIsPropertyShippingWidthRemoved(c.getIsPropertyShippingWidthRemoved());
        e.setIsPropertyDepthUomIdRemoved(c.getIsPropertyDepthUomIdRemoved());
        e.setIsPropertyProductDepthRemoved(c.getIsPropertyProductDepthRemoved());
        e.setIsPropertyShippingDepthRemoved(c.getIsPropertyShippingDepthRemoved());
        e.setIsPropertyDiameterUomIdRemoved(c.getIsPropertyDiameterUomIdRemoved());
        e.setIsPropertyProductDiameterRemoved(c.getIsPropertyProductDiameterRemoved());
        e.setIsPropertyProductRatingRemoved(c.getIsPropertyProductRatingRemoved());
        e.setIsPropertyRatingTypeEnumRemoved(c.getIsPropertyRatingTypeEnumRemoved());
        e.setIsPropertyReturnableRemoved(c.getIsPropertyReturnableRemoved());
        e.setIsPropertyTaxableRemoved(c.getIsPropertyTaxableRemoved());
        e.setIsPropertyChargeShippingRemoved(c.getIsPropertyChargeShippingRemoved());
        e.setIsPropertyAutoCreateKeywordsRemoved(c.getIsPropertyAutoCreateKeywordsRemoved());
        e.setIsPropertyIncludeInPromotionsRemoved(c.getIsPropertyIncludeInPromotionsRemoved());
        e.setIsPropertyIsVirtualRemoved(c.getIsPropertyIsVirtualRemoved());
        e.setIsPropertyIsVariantRemoved(c.getIsPropertyIsVariantRemoved());
        e.setIsPropertyVirtualVariantMethodEnumRemoved(c.getIsPropertyVirtualVariantMethodEnumRemoved());
        e.setIsPropertyInShippingBoxRemoved(c.getIsPropertyInShippingBoxRemoved());
        e.setIsPropertyDefaultShipmentBoxTypeIdRemoved(c.getIsPropertyDefaultShipmentBoxTypeIdRemoved());
        e.setIsPropertyIsSerialNumberedRemoved(c.getIsPropertyIsSerialNumberedRemoved());
        e.setIsPropertyIsManagedByLotRemoved(c.getIsPropertyIsManagedByLotRemoved());
        e.setIsPropertyAttributeSetIdRemoved(c.getIsPropertyAttributeSetIdRemoved());
        e.setIsPropertyAttributeSetInstanceIdRemoved(c.getIsPropertyAttributeSetInstanceIdRemoved());
        e.setIsPropertyGradeRemoved(c.getIsPropertyGradeRemoved());
        e.setIsPropertyGsmRemoved(c.getIsPropertyGsmRemoved());
        e.setIsPropertyCoreDiameterRemoved(c.getIsPropertyCoreDiameterRemoved());
        e.setIsPropertyOutsideDiameterRemoved(c.getIsPropertyOutsideDiameterRemoved());
        e.setIsPropertyMoisturePctRemoved(c.getIsPropertyMoisturePctRemoved());
        e.setIsPropertyRollCntRemoved(c.getIsPropertyRollCntRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractProductEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        Long version = c.getVersion();
        for (GoodIdentificationCommand innerCommand : c.getGoodIdentificationCommands())
        {
            throwOnInconsistentCommands(c, innerCommand);
            GoodIdentificationEvent innerEvent = map(innerCommand, c, version, this.state);
            e.addGoodIdentificationEvent(innerEvent);
        }

        return e;
    }


    protected GoodIdentificationEvent map(GoodIdentificationCommand c, ProductCommand outerCommand, Long version, ProductState outerState)
    {
        GoodIdentificationCommand.CreateGoodIdentification create = (c.getCommandType().equals(CommandType.CREATE)) ? ((GoodIdentificationCommand.CreateGoodIdentification)c) : null;
        if(create != null)
        {
            return mapCreate(create, outerCommand, version, outerState);
        }

        GoodIdentificationCommand.MergePatchGoodIdentification merge = (c.getCommandType().equals(CommandType.MERGE_PATCH)) ? ((GoodIdentificationCommand.MergePatchGoodIdentification)c) : null;
        if(merge != null)
        {
            return mapMergePatch(merge, outerCommand, version, outerState);
        }

        GoodIdentificationCommand.RemoveGoodIdentification remove = (c.getCommandType().equals(CommandType.REMOVE)) ? ((GoodIdentificationCommand.RemoveGoodIdentification)c) : null;
        if (remove != null)
        {
            return mapRemove(remove, outerCommand, version);
        }
        throw new UnsupportedOperationException();
    }

    protected GoodIdentificationEvent.GoodIdentificationStateCreated mapCreate(GoodIdentificationCommand.CreateGoodIdentification c, ProductCommand outerCommand, Long version, ProductState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        GoodIdentificationEventId stateEventId = new GoodIdentificationEventId(c.getProductId(), c.getGoodIdentificationTypeId(), version);
        GoodIdentificationEvent.GoodIdentificationStateCreated e = newGoodIdentificationStateCreated(stateEventId);
        GoodIdentificationState s = outerState.getGoodIdentifications().get(c.getGoodIdentificationTypeId());

        e.setIdValue(c.getIdValue());
        e.setActive(c.getActive());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(ICreate... ////////////////////////////

    protected GoodIdentificationEvent.GoodIdentificationStateMergePatched mapMergePatch(GoodIdentificationCommand.MergePatchGoodIdentification c, ProductCommand outerCommand, Long version, ProductState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        GoodIdentificationEventId stateEventId = new GoodIdentificationEventId(c.getProductId(), c.getGoodIdentificationTypeId(), version);
        GoodIdentificationEvent.GoodIdentificationStateMergePatched e = newGoodIdentificationStateMergePatched(stateEventId);
        GoodIdentificationState s = outerState.getGoodIdentifications().get(c.getGoodIdentificationTypeId());

        e.setIdValue(c.getIdValue());
        e.setActive(c.getActive());
        e.setIsPropertyIdValueRemoved(c.getIsPropertyIdValueRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(IMergePatch... ////////////////////////////

    protected GoodIdentificationEvent.GoodIdentificationStateRemoved mapRemove(GoodIdentificationCommand.RemoveGoodIdentification c, ProductCommand outerCommand, Long version)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        GoodIdentificationEventId stateEventId = new GoodIdentificationEventId(c.getProductId(), c.getGoodIdentificationTypeId(), version);
        GoodIdentificationEvent.GoodIdentificationStateRemoved e = newGoodIdentificationStateRemoved(stateEventId);

        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));

        return e;

    }// END map(IRemove... ////////////////////////////

    protected void throwOnInconsistentCommands(ProductCommand command, GoodIdentificationCommand innerCommand)
    {
        AbstractProductCommand properties = command instanceof AbstractProductCommand ? (AbstractProductCommand) command : null;
        AbstractGoodIdentificationCommand innerProperties = innerCommand instanceof AbstractGoodIdentificationCommand ? (AbstractGoodIdentificationCommand) innerCommand : null;
        if (properties == null || innerProperties == null) { return; }
        String outerProductIdName = "ProductId";
        String outerProductIdValue = properties.getProductId();
        String innerProductIdName = "ProductId";
        String innerProductIdValue = innerProperties.getProductId();
        if (innerProductIdValue == null) {
            innerProperties.setProductId(outerProductIdValue);
        }
        else if (innerProductIdValue != outerProductIdValue 
            && (innerProductIdValue == null || innerProductIdValue != null && !innerProductIdValue.equals(outerProductIdValue))) 
        {
            throw DomainError.named("inconsistentId", "Outer %1$s %2$s NOT equals inner %3$s %4$s", outerProductIdName, outerProductIdValue, innerProductIdName, innerProductIdValue);
        }
    }// END throwOnInconsistentCommands /////////////////////


    ////////////////////////

    protected ProductEvent.ProductStateCreated newProductStateCreated(Long version, String commandId, String requesterId) {
        ProductEventId stateEventId = new ProductEventId(this.state.getProductId(), version);
        ProductEvent.ProductStateCreated e = newProductStateCreated(stateEventId);
        ((AbstractProductEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ProductEvent.ProductStateMergePatched newProductStateMergePatched(Long version, String commandId, String requesterId) {
        ProductEventId stateEventId = new ProductEventId(this.state.getProductId(), version);
        ProductEvent.ProductStateMergePatched e = newProductStateMergePatched(stateEventId);
        ((AbstractProductEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ProductEvent.ProductStateCreated newProductStateCreated(ProductEventId stateEventId) {
        return new AbstractProductEvent.SimpleProductStateCreated(stateEventId);
    }

    protected ProductEvent.ProductStateMergePatched newProductStateMergePatched(ProductEventId stateEventId) {
        return new AbstractProductEvent.SimpleProductStateMergePatched(stateEventId);
    }

    protected GoodIdentificationEvent.GoodIdentificationStateCreated newGoodIdentificationStateCreated(GoodIdentificationEventId stateEventId) {
        return new AbstractGoodIdentificationEvent.SimpleGoodIdentificationStateCreated(stateEventId);
    }

    protected GoodIdentificationEvent.GoodIdentificationStateMergePatched newGoodIdentificationStateMergePatched(GoodIdentificationEventId stateEventId) {
        return new AbstractGoodIdentificationEvent.SimpleGoodIdentificationStateMergePatched(stateEventId);
    }

    protected GoodIdentificationEvent.GoodIdentificationStateRemoved newGoodIdentificationStateRemoved(GoodIdentificationEventId stateEventId)
    {
        return new AbstractGoodIdentificationEvent.SimpleGoodIdentificationStateRemoved(stateEventId);
    }

    public static class SimpleProductAggregate extends AbstractProductAggregate
    {
        public SimpleProductAggregate(ProductState state) {
            super(state);
        }

    }

}

