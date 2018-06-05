package org.dddml.wms.domain.product;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractGoodIdentificationCommandDto extends AbstractCommand
{
    private String goodIdentificationTypeId;

    public String getGoodIdentificationTypeId()
    {
        return this.goodIdentificationTypeId;
    }

    public void setGoodIdentificationTypeId(String goodIdentificationTypeId)
    {
        this.goodIdentificationTypeId = goodIdentificationTypeId;
    }


}
