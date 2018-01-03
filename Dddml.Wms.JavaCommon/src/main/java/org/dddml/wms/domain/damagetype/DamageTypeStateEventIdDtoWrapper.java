package org.dddml.wms.domain.damagetype;

import org.dddml.wms.domain.*;

public class DamageTypeStateEventIdDtoWrapper extends DamageTypeStateEventIdDto
{
	
    private DamageTypeStateEventId value;

    public DamageTypeStateEventIdDtoWrapper()
    {
        this(new DamageTypeStateEventId());
    }

    public DamageTypeStateEventIdDtoWrapper(DamageTypeStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public DamageTypeStateEventId toDamageTypeStateEventId()
    {
        return this.value;
    }

    @Override
    public String getDamageTypeId()
    {
        return this.value.getDamageTypeId();
    }

    @Override
    public void setDamageTypeId(String damageTypeId)
    {
        this.value.setDamageTypeId(damageTypeId);
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
        if (obj.getClass() == DamageTypeStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        DamageTypeStateEventIdDtoWrapper other = (DamageTypeStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

