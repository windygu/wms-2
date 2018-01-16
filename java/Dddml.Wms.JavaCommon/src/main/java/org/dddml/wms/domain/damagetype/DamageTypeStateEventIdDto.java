package org.dddml.wms.domain.damagetype;

import org.dddml.wms.domain.*;

public class DamageTypeStateEventIdDto
{

    public DamageTypeStateEventIdDto()
    {
    }

    public DamageTypeStateEventId toDamageTypeStateEventId()
    {
        DamageTypeStateEventId v = new DamageTypeStateEventId();
        v.setDamageTypeId(this.getDamageTypeId());
        v.setVersion(this.getVersion());
        return v;
    }

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


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != DamageTypeStateEventIdDto.class) {
            return false;
        }

        DamageTypeStateEventIdDto other = (DamageTypeStateEventIdDto)obj;
        return true 
            && (getDamageTypeId() == other.getDamageTypeId() || (getDamageTypeId() != null && getDamageTypeId().equals(other.getDamageTypeId())))
            && (getVersion() == other.getVersion() || (getVersion() != null && getVersion().equals(other.getVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getDamageTypeId() != null) {
            hash += 13 * this.getDamageTypeId().hashCode();
        }
        if (this.getVersion() != null) {
            hash += 13 * this.getVersion().hashCode();
        }
        return hash;
    }

}

