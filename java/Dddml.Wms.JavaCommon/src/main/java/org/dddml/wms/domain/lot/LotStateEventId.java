package org.dddml.wms.domain.lot;

import java.io.Serializable;

public class LotStateEventId implements Serializable {
    private String lotId;

    public String getLotId() {
        return this.lotId;
    }

    public void setLotId(String lotId) {
        this.lotId = lotId;
    }

    private Long version;

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public LotStateEventId() {
    }

    public LotStateEventId(String lotId, Long version) {
        this.lotId = lotId;
        this.version = version;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        LotStateEventId other = (LotStateEventId) obj;
        return true
                && (lotId == other.lotId || (lotId != null && lotId.equals(other.lotId)))
                && (version == other.version || (version != null && version.equals(other.version)))
                ;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        if (this.lotId != null) {
            hash += 13 * this.lotId.hashCode();
        }
        if (this.version != null) {
            hash += 13 * this.version.hashCode();
        }
        return hash;
    }

}

