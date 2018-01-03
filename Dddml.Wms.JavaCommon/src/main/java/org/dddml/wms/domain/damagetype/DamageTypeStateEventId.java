package org.dddml.wms.domain.damagetype;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class DamageTypeStateEventId implements Serializable
{
    private String damageTypeId;

    public String getDamageTypeId()
    {
        return this.damageTypeId;
    }

    public void setDamageTypeId(String damageTypeId)
    {
        this.damageTypeId = damageTypeId;
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

    public DamageTypeStateEventId()
    {
    }

    public DamageTypeStateEventId(String damageTypeId, Long version)
    {
        this.damageTypeId = damageTypeId;
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

        DamageTypeStateEventId other = (DamageTypeStateEventId)obj;
        return true 
            && (damageTypeId == other.damageTypeId || (damageTypeId != null && damageTypeId.equals(other.damageTypeId)))
            && (version == other.version || (version != null && version.equals(other.version)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.damageTypeId != null) {
            hash += 13 * this.damageTypeId.hashCode();
        }
        if (this.version != null) {
            hash += 13 * this.version.hashCode();
        }
        return hash;
    }

}

