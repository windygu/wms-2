package org.dddml.wms.domain.uom;

public class UomStateEventIdDtoWrapper extends UomStateEventIdDto {

    private UomStateEventId value;

    public UomStateEventIdDtoWrapper() {
        this(new UomStateEventId());
    }

    public UomStateEventIdDtoWrapper(UomStateEventId value) {
        if (value == null) {
            throw new IllegalArgumentException("value == null");
        }
        this.value = value;
    }

    public UomStateEventId toUomStateEventId() {
        return this.value;
    }

    @Override
    public String getUomId() {
        return this.value.getUomId();
    }

    @Override
    public void setUomId(String uomId) {
        this.value.setUomId(uomId);
    }

    @Override
    public Long getVersion() {
        return this.value.getVersion();
    }

    @Override
    public void setVersion(Long version) {
        this.value.setVersion(version);
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == UomStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        UomStateEventIdDtoWrapper other = (UomStateEventIdDtoWrapper) obj;
        return value.equals(other.value);
    }

}

