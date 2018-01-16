package org.dddml.wms.domain.damagehandlingmethod;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractDamageHandlingMethodCommandDto extends AbstractCommand
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


    public void copyTo(AbstractDamageHandlingMethodCommand command)
    {
        command.setDamageHandlingMethodId(this.getDamageHandlingMethodId());
        command.setVersion(this.getVersion());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
