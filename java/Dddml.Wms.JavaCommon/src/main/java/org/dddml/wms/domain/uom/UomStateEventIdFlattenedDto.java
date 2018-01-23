package org.dddml.wms.domain.uom;

import java.util.HashMap;
import java.util.Map;

public class UomStateEventIdFlattenedDto {


    public static final String[] propertyNames = new String[]{
            "uomId",
            "version",
    };

    public static final String[] propertyTypes = new String[]{
            "String",
            "Long",
    };

    public static final Map<String, String> propertyTypeMap;

    static {
        propertyTypeMap = new HashMap<String, String>();
        for (int i = 0; i < propertyNames.length; i++) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

    private UomStateEventIdDto value;

    public UomStateEventIdFlattenedDto() {
        this(new UomStateEventIdDto());
    }

    public UomStateEventIdFlattenedDto(UomStateEventIdDto value) {
        this.value = value;
    }

    public UomStateEventIdDto toUomStateEventIdDto() {
        return this.value;
    }

    public UomStateEventId toUomStateEventId() {
        return this.value.toUomStateEventId();
    }

    public String getUomId() {
        return this.value.getUomId();
    }

    public void setUomId(String uomId) {
        this.value.setUomId(uomId);
    }

    public Long getVersion() {
        return this.value.getVersion();
    }

    public void setVersion(Long version) {
        this.value.setVersion(version);
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        UomStateEventIdFlattenedDto other = (UomStateEventIdFlattenedDto) obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}

