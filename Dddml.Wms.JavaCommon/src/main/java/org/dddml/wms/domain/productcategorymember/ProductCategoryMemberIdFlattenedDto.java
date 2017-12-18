package org.dddml.wms.domain.productcategorymember;

import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class ProductCategoryMemberIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "productCategoryId",
            "productId",
        };

    public static final String[] propertyTypes = new String[]{
            "String",
            "String",
        };

    public static final Map<String, String> propertyTypeMap;

    static {
        propertyTypeMap = new HashMap<String, String>();
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }
	
    private ProductCategoryMemberIdDto value;

    public ProductCategoryMemberIdFlattenedDto()
    {
        this(new ProductCategoryMemberIdDto());
    }

    public ProductCategoryMemberIdFlattenedDto(ProductCategoryMemberIdDto value)
    {
        this.value = value;
    }

    public ProductCategoryMemberIdDto toProductCategoryMemberIdDto()
    {
        return this.value;
    }

    public ProductCategoryMemberId toProductCategoryMemberId()
    {
        return this.value.toProductCategoryMemberId();
    }

    public String getProductCategoryId()
    {
        return this.value.getProductCategoryId();
    }

    public void setProductCategoryId(String productCategoryId)
    {
        this.value.setProductCategoryId(productCategoryId);
    }

    public String getProductId()
    {
        return this.value.getProductId();
    }

    public void setProductId(String productId)
    {
        this.value.setProductId(productId);
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        ProductCategoryMemberIdFlattenedDto other = (ProductCategoryMemberIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

