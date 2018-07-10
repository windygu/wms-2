package org.dddml.wms.domain.goodidentificationmvo.hibernate;

import java.util.*;
import org.dddml.wms.domain.product.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.SessionFactory;
import org.dddml.wms.domain.goodidentificationmvo.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateGoodIdentificationMvoStateRepository implements GoodIdentificationMvoStateRepository
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("ProductGoodIdentificationId", "IdValue", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted", "ProductProductTypeId", "ProductPrimaryProductCategoryId", "ProductManufacturerPartyId", "ProductFacilityId", "ProductIntroductionDate", "ProductReleaseDate", "ProductSupportDiscontinuationDate", "ProductSalesDiscontinuationDate", "ProductSalesDiscWhenNotAvail", "ProductInternalName", "ProductBrandName", "ProductComments", "ProductProductName", "ProductDescription", "ProductPriceDetailText", "ProductSmallImageUrl", "ProductMediumImageUrl", "ProductLargeImageUrl", "ProductDetailImageUrl", "ProductOriginalImageUrl", "ProductDetailScreen", "ProductInventoryMessage", "ProductInventoryItemTypeId", "ProductRequireInventory", "ProductQuantityUomId", "ProductQuantityIncluded", "ProductPiecesIncluded", "ProductRequireAmount", "ProductFixedAmount", "ProductAmountUomTypeId", "ProductWeightUomId", "ProductShippingWeight", "ProductProductWeight", "ProductHeightUomId", "ProductProductHeight", "ProductShippingHeight", "ProductWidthUomId", "ProductProductWidth", "ProductShippingWidth", "ProductDepthUomId", "ProductProductDepth", "ProductShippingDepth", "ProductDiameterUomId", "ProductProductDiameter", "ProductProductRating", "ProductRatingTypeEnum", "ProductReturnable", "ProductTaxable", "ProductChargeShipping", "ProductAutoCreateKeywords", "ProductIncludeInPromotions", "ProductIsVirtual", "ProductIsVariant", "ProductVirtualVariantMethodEnum", "ProductInShippingBox", "ProductDefaultShipmentBoxTypeId", "ProductIsSerialNumbered", "ProductIsManagedByLot", "ProductAttributeSetId", "ProductAttributeSetInstanceId", "ProductGoodIdentifications", "ProductVersion", "ProductCreatedBy", "ProductCreatedAt", "ProductUpdatedBy", "ProductUpdatedAt", "ProductActive"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    public GoodIdentificationMvoState get(ProductGoodIdentificationId id, boolean nullAllowed) {
        GoodIdentificationMvoState state = (GoodIdentificationMvoState)getCurrentSession().get(AbstractGoodIdentificationMvoState.SimpleGoodIdentificationMvoState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractGoodIdentificationMvoState.SimpleGoodIdentificationMvoState();
            state.setProductGoodIdentificationId(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (GoodIdentificationMvoState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{GoodIdentificationMvoState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    public void save(GoodIdentificationMvoState state)
    {
        GoodIdentificationMvoState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (GoodIdentificationMvoState) getReadOnlyProxyGenerator().getTarget(state);
        }
        if(s.getProductVersion() == null) {
            getCurrentSession().save(s);
        }else {
            getCurrentSession().update(s);
        }

        if (s instanceof Saveable)
        {
            Saveable saveable = (Saveable) s;
            saveable.save();
        }
        getCurrentSession().flush();
    }

    //protected static void addNotDeletedRestriction(Criteria criteria) {
    //    criteria.add(org.hibernate.criterion.Restrictions.eq("deleted", false));
    //}

}

