package org.dddml.wms.domain.lot;

public class LotStateEventIdDtoWrapper extends LotStateEventIdDto {

    private LotStateEventId value;

    public LotStateEventIdDtoWrapper() {
        this(new LotStateEventId());
    }

    public LotStateEventIdDtoWrapper(LotStateEventId value) {
        if (value == null) {
            throw new IllegalArgumentException("value == null");
        }
        this.value = value;
    }

    public LotStateEventId toLotStateEventId() {
        return this.value;
    }

    @Override
    public String getLotId() {
        return this.value.getLotId();
    }

    @Override
    public void setLotId(String lotId) {
        this.value.setLotId(lotId);
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
        if (obj.getClass() == LotStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        LotStateEventIdDtoWrapper other = (LotStateEventIdDtoWrapper) obj;
        return value.equals(other.value);
    }

}

