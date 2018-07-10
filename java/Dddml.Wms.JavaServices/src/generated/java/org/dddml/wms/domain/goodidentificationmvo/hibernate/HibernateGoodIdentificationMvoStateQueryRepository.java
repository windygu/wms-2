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

public class HibernateGoodIdentificationMvoStateQueryRepository implements GoodIdentificationMvoStateQueryRepository
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
    public GoodIdentificationMvoState get(ProductGoodIdentificationId id) {

        GoodIdentificationMvoState state = (GoodIdentificationMvoState)getCurrentSession().get(AbstractGoodIdentificationMvoState.SimpleGoodIdentificationMvoState.class, id);
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (GoodIdentificationMvoState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{GoodIdentificationMvoState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    @Transactional(readOnly = true)
    public Iterable<GoodIdentificationMvoState> getAll(Integer firstResult, Integer maxResults)
    {
        Criteria criteria = getCurrentSession().createCriteria(GoodIdentificationMvoState.class);
        if (firstResult != null) { criteria.setFirstResult(firstResult); }
        if (maxResults != null) { criteria.setMaxResults(maxResults); }
         addNotDeletedRestriction(criteria);
        return criteria.list();
    }

    @Transactional(readOnly = true)
    public Iterable<GoodIdentificationMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults)
    {
        Criteria criteria = getCurrentSession().createCriteria(GoodIdentificationMvoState.class);

        HibernateUtils.criteriaAddFilterAndOrdersAndSetFirstResultAndMaxResults(criteria, filter, orders, firstResult, maxResults);
        addNotDeletedRestriction(criteria);
        return criteria.list();
    }

    @Transactional(readOnly = true)
    public Iterable<GoodIdentificationMvoState> get(org.dddml.support.criterion.Criterion filter, List<String> orders, Integer firstResult, Integer maxResults)
    {
        Criteria criteria = getCurrentSession().createCriteria(GoodIdentificationMvoState.class);

        HibernateUtils.criteriaAddFilterAndOrdersAndSetFirstResultAndMaxResults(criteria, filter, orders, firstResult, maxResults);
        addNotDeletedRestriction(criteria);
        return criteria.list();
    }

    @Transactional(readOnly = true)
    public GoodIdentificationMvoState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders)
    {
        List<GoodIdentificationMvoState> list = (List<GoodIdentificationMvoState>)get(filter, orders, 0, 1);
        if (list == null || list.size() <= 0)
        {
            return null;
        }
        return list.get(0);
    }

    @Transactional(readOnly = true)
    public GoodIdentificationMvoState getFirst(Map.Entry<String, Object> keyValue, List<String> orders)
    {
        List<Map.Entry<String, Object>> filter = new ArrayList<>();
        filter.add(keyValue);
        return getFirst(filter, orders);
    }

    @Transactional(readOnly = true)
    public Iterable<GoodIdentificationMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults)
    {
        Map.Entry<String, Object> keyValue = new java.util.AbstractMap.SimpleEntry<String, Object> (propertyName, propertyValue);
        List<Map.Entry<String, Object>> filter = new ArrayList<Map.Entry<String, Object>>();
        filter.add(keyValue);
        return get(filter, orders, firstResult, maxResults);
    }

    @Transactional(readOnly = true)
    public long getCount(Iterable<Map.Entry<String, Object>> filter)
    {
        Criteria criteria = getCurrentSession().createCriteria(GoodIdentificationMvoState.class);
        criteria.setProjection(Projections.rowCount());
        if (filter != null) {
            HibernateUtils.criteriaAddFilter(criteria, filter);
        }
        addNotDeletedRestriction(criteria);
        return (long)criteria.uniqueResult();
    }

    @Transactional(readOnly = true)
    public long getCount(org.dddml.support.criterion.Criterion filter)
    {
        Criteria criteria = getCurrentSession().createCriteria(GoodIdentificationMvoState.class);
        criteria.setProjection(Projections.rowCount());
        if (filter != null)
        {
            org.hibernate.criterion.Criterion hc = CriterionUtils.toHibernateCriterion(filter);
            criteria.add(hc);
        }
        addNotDeletedRestriction(criteria);
        return (long)criteria.uniqueResult();
    }


    protected static void addNotDeletedRestriction(Criteria criteria) {
        criteria.add(org.hibernate.criterion.Restrictions.eq("deleted", false));
    }

}

