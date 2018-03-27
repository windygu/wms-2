package org.dddml.wms.domain.orderrolemvo;

import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractOrderRoleMvoCommandDto extends AbstractCommand
{
    private OrderRoleId orderRoleId;

    public OrderRoleId getOrderRoleId()
    {
        return this.orderRoleId;
    }

    public void setOrderRoleId(OrderRoleId orderRoleId)
    {
        this.orderRoleId = orderRoleId;
    }

    private Long orderVersion;

    public Long getOrderVersion()
    {
        return this.orderVersion;
    }

    public void setOrderVersion(Long orderVersion)
    {
        this.orderVersion = orderVersion;
    }


    public void copyTo(AbstractOrderRoleMvoCommand command)
    {
        command.setOrderRoleId(this.getOrderRoleId());
        command.setOrderVersion(this.getOrderVersion());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
