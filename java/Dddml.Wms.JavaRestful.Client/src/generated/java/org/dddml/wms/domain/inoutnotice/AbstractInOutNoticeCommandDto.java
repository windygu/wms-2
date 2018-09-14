package org.dddml.wms.domain.inoutnotice;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractInOutNoticeCommandDto extends AbstractCommand
{
    /**
     * In Out Notice Id
     */
    private String inOutNoticeId;

    public String getInOutNoticeId()
    {
        return this.inOutNoticeId;
    }

    public void setInOutNoticeId(String inOutNoticeId)
    {
        this.inOutNoticeId = inOutNoticeId;
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


}
