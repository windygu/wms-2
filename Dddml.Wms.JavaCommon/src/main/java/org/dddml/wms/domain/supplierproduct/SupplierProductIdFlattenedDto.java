package org.dddml.wms.domain.supplierproduct;

import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class SupplierProductIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "productId",
            "partyId",
            "currencyUomId",
            "minimumOrderQuantity",
        };

    public static final String[] propertyTypes = new String[]{
            "String",
            "String",
            "String",
            "java.math.BigDecimal",
        };

    public static final Map<String, String> propertyTypeMap;

    static {
        propertyTypeMap = new HashMap<String, String>();
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }
	
    private SupplierProductIdDto value;

    public SupplierProductIdFlattenedDto()
    {
        this(new SupplierProductIdDto());
    }

    public SupplierProductIdFlattenedDto(SupplierProductIdDto value)
    {
        this.value = value;
    }

    public SupplierProductIdDto toSupplierProductIdDto()
    {
        return this.value;
    }

    public SupplierProductId toSupplierProductId()
    {
        return this.value.toSupplierProductId();
    }

    public String getProductId()
    {
        return this.value.getProductId();
    }

    public void setProductId(String productId)
    {
        this.value.setProductId(productId);
    }

    public String getPartyId()
    {
        return this.value.getPartyId();
    }

    public void setPartyId(String partyId)
    {
        this.value.setPartyId(partyId);
    }

    public String getCurrencyUomId()
    {
        return this.value.getCurrencyUomId();
    }

    public void setCurrencyUomId(String currencyUomId)
    {
        this.value.setCurrencyUomId(currencyUomId);
    }

    public java.math.BigDecimal getMinimumOrderQuantity()
    {
        return this.value.getMinimumOrderQuantity();
    }

    public void setMinimumOrderQuantity(java.math.BigDecimal minimumOrderQuantity)
    {
        this.value.setMinimumOrderQuantity(minimumOrderQuantity);
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

        SupplierProductIdFlattenedDto other = (SupplierProductIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

