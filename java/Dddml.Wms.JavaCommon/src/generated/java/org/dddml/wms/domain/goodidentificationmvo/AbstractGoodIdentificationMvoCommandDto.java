package org.dddml.wms.domain.goodidentificationmvo;

import org.dddml.wms.domain.product.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractGoodIdentificationMvoCommandDto extends AbstractCommand
{
    /**
     * Product Good Identification Id
     */
    private ProductGoodIdentificationId productGoodIdentificationId;

    public ProductGoodIdentificationId getProductGoodIdentificationId()
    {
        return this.productGoodIdentificationId;
    }

    public void setProductGoodIdentificationId(ProductGoodIdentificationId productGoodIdentificationId)
    {
        this.productGoodIdentificationId = productGoodIdentificationId;
    }

    /**
     * Product Version
     */
    private Long productVersion;

    public Long getProductVersion()
    {
        return this.productVersion;
    }

    public void setProductVersion(Long productVersion)
    {
        this.productVersion = productVersion;
    }


    public void copyTo(AbstractGoodIdentificationMvoCommand command)
    {
        command.setProductGoodIdentificationId(this.getProductGoodIdentificationId());
        command.setProductVersion(this.getProductVersion());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
