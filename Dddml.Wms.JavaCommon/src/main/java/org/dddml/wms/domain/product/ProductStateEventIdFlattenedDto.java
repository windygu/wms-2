package org.dddml.wms.domain.product;

import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class ProductStateEventIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "productId",
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
	
    private ProductStateEventIdDto value;

    public ProductStateEventIdFlattenedDto()
    {
        this(new ProductStateEventIdDto());
    }

    public ProductStateEventIdFlattenedDto(ProductStateEventIdDto value)
    {
        this.value = value;
    }

    public ProductStateEventIdDto toProductStateEventIdDto()
    {
        return this.value;
    }

    public ProductStateEventId toProductStateEventId()
    {
        return this.value.toProductStateEventId();
    }

    public String getProductId()
    {
        return this.value.getProductId();
    }

    public void setProductId(String productId)
    {
        this.value.setProductId(productId);
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

        ProductStateEventIdFlattenedDto other = (ProductStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

