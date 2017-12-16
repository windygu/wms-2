package org.dddml.wms.domain.supplierproduct;

import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class SupplierProductStateEventIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "supplierProductIdProductId",
            "supplierProductIdPartyId",
            "supplierProductIdCurrencyUomId",
            "supplierProductIdMinimumOrderQuantity",
            "version",
        };

    public static final String[] propertyTypes = new String[]{
            "String",
            "String",
            "String",
            "java.math.BigDecimal",
            "Long",
        };

    public static final Map<String, String> propertyTypeMap;

    static {
        propertyTypeMap = new HashMap<String, String>();
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }
	
    private SupplierProductStateEventIdDto value;

    public SupplierProductStateEventIdFlattenedDto()
    {
        this(new SupplierProductStateEventIdDto());
    }

    public SupplierProductStateEventIdFlattenedDto(SupplierProductStateEventIdDto value)
    {
        this.value = value;
    }

    public SupplierProductStateEventIdDto toSupplierProductStateEventIdDto()
    {
        return this.value;
    }

    public SupplierProductStateEventId toSupplierProductStateEventId()
    {
        return this.value.toSupplierProductStateEventId();
    }

    public String getSupplierProductIdProductId()
    {
        return this.value.getSupplierProductId().getProductId();
    }

    public void setSupplierProductIdProductId(String supplierProductIdProductId)
    {
        this.value.getSupplierProductId().setProductId(supplierProductIdProductId);
    }

    public String getSupplierProductIdPartyId()
    {
        return this.value.getSupplierProductId().getPartyId();
    }

    public void setSupplierProductIdPartyId(String supplierProductIdPartyId)
    {
        this.value.getSupplierProductId().setPartyId(supplierProductIdPartyId);
    }

    public String getSupplierProductIdCurrencyUomId()
    {
        return this.value.getSupplierProductId().getCurrencyUomId();
    }

    public void setSupplierProductIdCurrencyUomId(String supplierProductIdCurrencyUomId)
    {
        this.value.getSupplierProductId().setCurrencyUomId(supplierProductIdCurrencyUomId);
    }

    public java.math.BigDecimal getSupplierProductIdMinimumOrderQuantity()
    {
        return this.value.getSupplierProductId().getMinimumOrderQuantity();
    }

    public void setSupplierProductIdMinimumOrderQuantity(java.math.BigDecimal supplierProductIdMinimumOrderQuantity)
    {
        this.value.getSupplierProductId().setMinimumOrderQuantity(supplierProductIdMinimumOrderQuantity);
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

        SupplierProductStateEventIdFlattenedDto other = (SupplierProductStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

