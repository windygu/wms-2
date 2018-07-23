package org.dddml.wms.domain.damagereason;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractDamageReasonCommandDto extends AbstractCommand
{
    /**
     * Damage Reason Id
     */
    private String damageReasonId;

    public String getDamageReasonId()
    {
        return this.damageReasonId;
    }

    public void setDamageReasonId(String damageReasonId)
    {
        this.damageReasonId = damageReasonId;
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
