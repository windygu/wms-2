package org.dddml.wms.domain.goodidentificationmvo;

import org.dddml.wms.domain.product.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractGoodIdentificationMvoCommandDto extends AbstractCommand
{
    private ProductGoodIdentificationId productGoodIdentificationId;

    public ProductGoodIdentificationId getProductGoodIdentificationId()
    {
        return this.productGoodIdentificationId;
    }

    public void setProductGoodIdentificationId(ProductGoodIdentificationId productGoodIdentificationId)
    {
        this.productGoodIdentificationId = productGoodIdentificationId;
    }

    private Long productVersion;

    public Long getProductVersion()
    {
        return this.productVersion;
    }

    public void setProductVersion(Long productVersion)
    {
        this.productVersion = productVersion;
    }


}
