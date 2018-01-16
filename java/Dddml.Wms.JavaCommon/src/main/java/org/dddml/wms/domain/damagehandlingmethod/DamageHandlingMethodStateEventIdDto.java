package org.dddml.wms.domain.damagehandlingmethod;

import org.dddml.wms.domain.*;

public class DamageHandlingMethodStateEventIdDto
{

    public DamageHandlingMethodStateEventIdDto()
    {
    }

    public DamageHandlingMethodStateEventId toDamageHandlingMethodStateEventId()
    {
        DamageHandlingMethodStateEventId v = new DamageHandlingMethodStateEventId();
        v.setDamageHandlingMethodId(this.getDamageHandlingMethodId());
        v.setVersion(this.getVersion());
        return v;
    }

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


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != DamageHandlingMethodStateEventIdDto.class) {
            return false;
        }

        DamageHandlingMethodStateEventIdDto other = (DamageHandlingMethodStateEventIdDto)obj;
        return true 
            && (getDamageHandlingMethodId() == other.getDamageHandlingMethodId() || (getDamageHandlingMethodId() != null && getDamageHandlingMethodId().equals(other.getDamageHandlingMethodId())))
            && (getVersion() == other.getVersion() || (getVersion() != null && getVersion().equals(other.getVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getDamageHandlingMethodId() != null) {
            hash += 13 * this.getDamageHandlingMethodId().hashCode();
        }
        if (this.getVersion() != null) {
            hash += 13 * this.getVersion().hashCode();
        }
        return hash;
    }

}

