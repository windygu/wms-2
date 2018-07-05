package org.dddml.wms.domain.productcategory;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractProductCategoryCommandDto extends AbstractCommand
{
    private String productCategoryId;

    public String getProductCategoryId()
    {
        return this.productCategoryId;
    }

    public void setProductCategoryId(String productCategoryId)
    {
        this.productCategoryId = productCategoryId;
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


}
