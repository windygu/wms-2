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

public class HibernateProductStateRepository implements ProductStateRepository
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
    public ProductState get(String id, boolean nullAllowed) {
        ProductState state = (ProductState)getCurrentSession().get(AbstractProductState.SimpleProductState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractProductState.SimpleProductState();
            state.setProductId(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (ProductState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{ProductState.class, Saveable.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    public void save(ProductState state)
    {
        ProductState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (ProductState) getReadOnlyProxyGenerator().getTarget(state);
        }
        if(s.getVersion() == null) {
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

