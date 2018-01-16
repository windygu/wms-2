package org.dddml.wms.domain.damagehandlingmethod;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class DamageHandlingMethodStateEventId implements Serializable
{
    private String damageHandlingMethodId;

    public String getDamageHandlingMethodId()
    {
        return this.damageHandlingMethodId;
    }

    public void setDamageHandlingMethodId(String damageHandlingMethodId)
    {
        this.damageHandlingMethodId = damageHandlingMethodId;
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

    public DamageHandlingMethodStateEventId()
    {
    }

    public DamageHandlingMethodStateEventId(String damageHandlingMethodId, Long version)
    {
        this.damageHandlingMethodId = damageHandlingMethodId;
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

        DamageHandlingMethodStateEventId other = (DamageHandlingMethodStateEventId)obj;
        return true 
            && (damageHandlingMethodId == other.damageHandlingMethodId || (damageHandlingMethodId != null && damageHandlingMethodId.equals(other.damageHandlingMethodId)))
            && (version == other.version || (version != null && version.equals(other.version)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.damageHandlingMethodId != null) {
            hash += 13 * this.damageHandlingMethodId.hashCode();
        }
        if (this.version != null) {
            hash += 13 * this.version.hashCode();
        }
        return hash;
    }

}

