package org.dddml.wms.domain.damagereason;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class DamageReasonStateEventId implements Serializable
{
    private String damageReasonId;

    public String getDamageReasonId()
    {
        return this.damageReasonId;
    }

    public void setDamageReasonId(String damageReasonId)
    {
        this.damageReasonId = damageReasonId;
    }

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }

    public DamageReasonStateEventId()
    {
    }

    public DamageReasonStateEventId(String damageReasonId, Long version)
    {
        this.damageReasonId = damageReasonId;
        this.version = version;
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

        DamageReasonStateEventId other = (DamageReasonStateEventId)obj;
        return true 
            && (damageReasonId == other.damageReasonId || (damageReasonId != null && damageReasonId.equals(other.damageReasonId)))
            && (version == other.version || (version != null && version.equals(other.version)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.damageReasonId != null) {
            hash += 13 * this.damageReasonId.hashCode();
        }
        if (this.version != null) {
            hash += 13 * this.version.hashCode();
        }
        return hash;
    }

}

