package org.dddml.wms.domain.damagetype;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractDamageTypeCommandDto extends AbstractCommand
{
    /**
     * Damage Type Id
     */
    private String damageTypeId;

    public String getDamageTypeId()
    {
        return this.damageTypeId;
    }

    public void setDamageTypeId(String damageTypeId)
    {
        this.damageTypeId = damageTypeId;
    }

    /**
     * Version
     */
    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }


}
