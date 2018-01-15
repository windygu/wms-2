package org.dddml.wms.domain.damagereason;

import org.dddml.wms.domain.*;

public class DamageReasonStateEventIdDto
{

    public DamageReasonStateEventIdDto()
    {
    }

    public DamageReasonStateEventId toDamageReasonStateEventId()
    {
        DamageReasonStateEventId v = new DamageReasonStateEventId();
        v.setDamageReasonId(this.getDamageReasonId());
        v.setVersion(this.getVersion());
        return v;
    }

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


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != DamageReasonStateEventIdDto.class) {
            return false;
        }

        DamageReasonStateEventIdDto other = (DamageReasonStateEventIdDto)obj;
        return true 
            && (getDamageReasonId() == other.getDamageReasonId() || (getDamageReasonId() != null && getDamageReasonId().equals(other.getDamageReasonId())))
            && (getVersion() == other.getVersion() || (getVersion() != null && getVersion().equals(other.getVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getDamageReasonId() != null) {
            hash += 13 * this.getDamageReasonId().hashCode();
        }
        if (this.getVersion() != null) {
            hash += 13 * this.getVersion().hashCode();
        }
        return hash;
    }

}

