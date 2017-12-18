package org.dddml.wms.domain.productcategorymember;

import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class ProductCategoryMemberStateEventIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "productCategoryMemberIdProductCategoryId",
            "productCategoryMemberIdProductId",
            "version",
        };

    public static final String[] propertyTypes = new String[]{
            "String",
            "String",
            "Long",
        };

    public static final Map<String, String> propertyTypeMap;

    static {
        propertyTypeMap = new HashMap<String, String>();
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }
	
    private ProductCategoryMemberStateEventIdDto value;

    public ProductCategoryMemberStateEventIdFlattenedDto()
    {
        this(new ProductCategoryMemberStateEventIdDto());
    }

    public ProductCategoryMemberStateEventIdFlattenedDto(ProductCategoryMemberStateEventIdDto value)
    {
        this.value = value;
    }

    public ProductCategoryMemberStateEventIdDto toProductCategoryMemberStateEventIdDto()
    {
        return this.value;
    }

    public ProductCategoryMemberStateEventId toProductCategoryMemberStateEventId()
    {
        return this.value.toProductCategoryMemberStateEventId();
    }

    public String getProductCategoryMemberIdProductCategoryId()
    {
        return this.value.getProductCategoryMemberId().getProductCategoryId();
    }

    public void setProductCategoryMemberIdProductCategoryId(String productCategoryMemberIdProductCategoryId)
    {
        this.value.getProductCategoryMemberId().setProductCategoryId(productCategoryMemberIdProductCategoryId);
    }

    public String getProductCategoryMemberIdProductId()
    {
        return this.value.getProductCategoryMemberId().getProductId();
    }

    public void setProductCategoryMemberIdProductId(String productCategoryMemberIdProductId)
    {
        this.value.getProductCategoryMemberId().setProductId(productCategoryMemberIdProductId);
    }

    public Long getVersion()
    {
        return this.value.getVersion();
    }

    public void setVersion(Long version)
    {
        this.value.setVersion(version);
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

        ProductCategoryMemberStateEventIdFlattenedDto other = (ProductCategoryMemberStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

