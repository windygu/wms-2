package org.dddml.wms.domain.damagehandlingmethod;

import org.dddml.wms.domain.*;

public class DamageHandlingMethodStateEventIdDtoWrapper extends DamageHandlingMethodStateEventIdDto
{
	
    private DamageHandlingMethodStateEventId value;

    public DamageHandlingMethodStateEventIdDtoWrapper()
    {
        this(new DamageHandlingMethodStateEventId());
    }

    public DamageHandlingMethodStateEventIdDtoWrapper(DamageHandlingMethodStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public DamageHandlingMethodStateEventId toDamageHandlingMethodStateEventId()
    {
        return this.value;
    }

    @Override
    public String getDamageHandlingMethodId()
    {
        return this.value.getDamageHandlingMethodId();
    }

    @Override
    public void setDamageHandlingMethodId(String damageHandlingMethodId)
    {
        this.value.setDamageHandlingMethodId(damageHandlingMethodId);
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
        if (obj.getClass() == DamageHandlingMethodStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        DamageHandlingMethodStateEventIdDtoWrapper other = (DamageHandlingMethodStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

