package org.dddml.wms.domain.productcategorymember;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractProductCategoryMemberCommandDto extends AbstractCommand
{
    private ProductCategoryMemberId productCategoryMemberId;

    public ProductCategoryMemberId getProductCategoryMemberId()
    {
        return this.productCategoryMemberId;
    }

    public void setProductCategoryMemberId(ProductCategoryMemberId productCategoryMemberId)
    {
        this.productCategoryMemberId = productCategoryMemberId;
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
