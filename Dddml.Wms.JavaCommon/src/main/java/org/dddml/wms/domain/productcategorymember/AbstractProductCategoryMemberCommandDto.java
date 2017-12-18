package org.dddml.wms.domain.productcategorymember;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractProductCategoryMemberCommandDto extends AbstractCommand
{
    private ProductCategoryMemberIdDto productCategoryMemberId;

    public ProductCategoryMemberIdDto getProductCategoryMemberId()
    {
        return this.productCategoryMemberId;
    }

    public void setProductCategoryMemberId(ProductCategoryMemberIdDto productCategoryMemberId)
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


    public void copyTo(AbstractProductCategoryMemberCommand command)
    {
        command.setProductCategoryMemberId((this.getProductCategoryMemberId() == null) ? null : this.getProductCategoryMemberId().toProductCategoryMemberId());
        command.setVersion(this.getVersion());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
