package org.dddml.wms.domain.product.hibernate;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.SessionFactory;
import org.dddml.wms.domain.product.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateProductStateQueryRepository implements ProductStateQueryRepository
{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("ProductId", "ProductTypeId", "PrimaryProductCategoryId", "ManufacturerPartyId", "FacilityId", "IntroductionDate", "ReleaseDate", "SupportDiscontinuationDate", "SalesDiscontinuationDate", "SalesDiscWhenNotAvail", "InternalName", "BrandName", "Comments", "ProductName", "Description", "PriceDetailText", "SmallImageUrl", "MediumImageUrl", "LargeImageUrl", "DetailImageUrl", "OriginalImageUrl", "DetailScreen", "InventoryMessage", "InventoryItemTypeId", "RequireInventory", "QuantityUomId", "QuantityIncluded", "PiecesIncluded", "RequireAmount", "FixedAmount", "AmountUomTypeId", "WeightUomId", "ShippingWeight", "ProductWeight", "HeightUomId", "ProductHeight", "ShippingHeight", "WidthUomId", "ProductWidth", "ShippingWidth", "DepthUomId", "ProductDepth", "ShippingDepth", "DiameterUomId", "ProductDiameter", "ProductRating", "RatingTypeEnum", "Returnable", "Taxable", "ChargeShipping", "AutoCreateKeywords", "IncludeInPromotions", "IsVirtual", "IsVariant", "VirtualVariantMethodEnum", "InShippingBox", "DefaultShipmentBoxTypeId", "IsSerialNumbered", "IsManagedByLot", "AttributeSetId", "AttributeSetInstanceId", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    public ProductState get(String id) {

        ProductState state = (ProductState)getCurrentSession().get(AbstractProductState.SimpleProductState.class, id);
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (ProductState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{ProductState.class, Saveable.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    @Transactional(readOnly = true)
    public Iterable<ProductState> getAll(Integer firstResult, Integer maxResults)
    {
        Criteria criteria = getCurrentSession().createCriteria(ProductState.class);
        if (firstResult != null) { criteria.setFirstResult(firstResult); }
        if (maxResults != null) { criteria.setMaxResults(maxResults); }
         addNotDeletedRestriction(criteria);
        return criteria.list();
    }

    @Transactional(readOnly = true)
    public Iterable<ProductState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults)
    {
        Criteria criteria = getCurrentSession().createCriteria(ProductState.class);

        HibernateUtils.criteriaAddFilterAndOrdersAndSetFirstResultAndMaxResults(criteria, filter, orders, firstResult, maxResults);
        addNotDeletedRestriction(criteria);
        return criteria.list();
    }

    @Transactional(readOnly = true)
    public Iterable<ProductState> get(org.dddml.support.criterion.Criterion filter, List<String> orders, Integer firstResult, Integer maxResults)
    {
        Criteria criteria = getCurrentSession().createCriteria(ProductState.class);

        HibernateUtils.criteriaAddFilterAndOrdersAndSetFirstResultAndMaxResults(criteria, filter, orders, firstResult, maxResults);
        addNotDeletedRestriction(criteria);
        return criteria.list();
    }

    @Transactional(readOnly = true)
    public ProductState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders)
    {
        List<ProductState> list = (List<ProductState>)get(filter, orders, 0, 1);
        if (list == null || list.size() <= 0)
        {
            return null;
        }
        return list.get(0);
    }

    @Transactional(readOnly = true)
    public ProductState getFirst(Map.Entry<String, Object> keyValue, List<String> orders)
    {
        List<Map.Entry<String, Object>> filter = new ArrayList<>();
        filter.add(keyValue);
        return getFirst(filter, orders);
    }

    @Transactional(readOnly = true)
    public Iterable<ProductState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults)
    {
        Map.Entry<String, Object> keyValue = new java.util.AbstractMap.SimpleEntry<String, Object> (propertyName, propertyValue);
        List<Map.Entry<String, Object>> filter = new ArrayList<Map.Entry<String, Object>>();
        filter.add(keyValue);
        return get(filter, orders, firstResult, maxResults);
    }

    @Transactional(readOnly = true)
    public long getCount(Iterable<Map.Entry<String, Object>> filter)
    {
        Criteria criteria = getCurrentSession().createCriteria(ProductState.class);
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
        Criteria criteria = getCurrentSession().createCriteria(ProductState.class);
        criteria.setProjection(Projections.rowCount());
        if (filter != null)
        {
            org.hibernate.criterion.Criterion hc = CriterionUtils.toHibernateCriterion(filter);
            criteria.add(hc);
        }
        addNotDeletedRestriction(criteria);
        return (long)criteria.uniqueResult();
    }

    @Transactional(readOnly = true)
    public GoodIdentificationState getGoodIdentification(String productId, String goodIdentificationTypeId) {
        ProductGoodIdentificationId entityId = new ProductGoodIdentificationId(productId, goodIdentificationTypeId);
        return (GoodIdentificationState) getCurrentSession().get(AbstractGoodIdentificationState.SimpleGoodIdentificationState.class, entityId);
    }

    @Transactional(readOnly = true)
    public Iterable<GoodIdentificationState> getGoodIdentifications(String productId) {
        Criteria criteria = getCurrentSession().createCriteria(AbstractGoodIdentificationState.SimpleGoodIdentificationState.class);
        org.hibernate.criterion.Junction partIdCondition = org.hibernate.criterion.Restrictions.conjunction()
            .add(org.hibernate.criterion.Restrictions.eq("productGoodIdentificationId.productId", productId))
            ;
        return criteria.add(partIdCondition).list();
    }


    protected static void addNotDeletedRestriction(Criteria criteria) {
    }

}

