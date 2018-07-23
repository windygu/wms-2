package org.dddml.wms.domain.damagehandlingmethod;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractDamageHandlingMethodCommandDto extends AbstractCommand
{
    /**
     * Damage Handling Method Id
     */
    private String damageHandlingMethodId;

    public String getDamageHandlingMethodId()
    {
        return this.damageHandlingMethodId;
    }

    public void setDamageHandlingMethodId(String damageHandlingMethodId)
    {
        this.damageHandlingMethodId = damageHandlingMethodId;
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
