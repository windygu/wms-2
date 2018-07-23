package org.dddml.wms.domain.product;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractProductCommandDto extends AbstractCommand
{
    /**
     * Product Id
     */
    private String productId;

    public String getProductId()
    {
        return this.productId;
    }

    public void setProductId(String productId)
    {
        this.productId = productId;
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


    public void copyTo(AbstractProductCommand command)
    {
        command.setProductId(this.getProductId());
        command.setVersion(this.getVersion());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
