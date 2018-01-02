package org.dddml.wms.domain.damagereason;

import org.dddml.wms.domain.*;

public class DamageReasonStateEventIdDtoWrapper extends DamageReasonStateEventIdDto
{
	
    private DamageReasonStateEventId value;

    public DamageReasonStateEventIdDtoWrapper()
    {
        this(new DamageReasonStateEventId());
    }

    public DamageReasonStateEventIdDtoWrapper(DamageReasonStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public DamageReasonStateEventId toDamageReasonStateEventId()
    {
        return this.value;
    }

    @Override
    public String getDamageReasonId()
    {
        return this.value.getDamageReasonId();
    }

    @Override
    public void setDamageReasonId(String damageReasonId)
    {
        this.value.setDamageReasonId(damageReasonId);
    }

    @Override
    public Long getVersion()
    {
        return this.value.getVersion();
    }

    @Override
    public void setVersion(Long version)
    {
        this.value.setVersion(version);
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == DamageReasonStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        DamageReasonStateEventIdDtoWrapper other = (DamageReasonStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

