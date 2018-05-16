package org.dddml.wms.domain.supplierproduct;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractSupplierProductCommandDto extends AbstractCommand
{
    private SupplierProductId supplierProductId;

    public SupplierProductId getSupplierProductId()
    {
        return this.supplierProductId;
    }

    public void setSupplierProductId(SupplierProductId supplierProductId)
    {
        this.supplierProductId = supplierProductId;
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
