package org.dddml.wms.domain.productcategory;

import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class ProductCategoryStateEventIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "productCategoryId",
            "version",
        };

    public static final String[] propertyTypes = new String[]{
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
	
    private ProductCategoryStateEventIdDto value;

    public ProductCategoryStateEventIdFlattenedDto()
    {
        this(new ProductCategoryStateEventIdDto());
    }

    public ProductCategoryStateEventIdFlattenedDto(ProductCategoryStateEventIdDto value)
    {
        this.value = value;
    }

    public ProductCategoryStateEventIdDto toProductCategoryStateEventIdDto()
    {
        return this.value;
    }

    public ProductCategoryStateEventId toProductCategoryStateEventId()
    {
        return this.value.toProductCategoryStateEventId();
    }

    public String getProductCategoryId()
    {
        return this.value.getProductCategoryId();
    }

    public void setProductCategoryId(String productCategoryId)
    {
        this.value.setProductCategoryId(productCategoryId);
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

        ProductCategoryStateEventIdFlattenedDto other = (ProductCategoryStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

