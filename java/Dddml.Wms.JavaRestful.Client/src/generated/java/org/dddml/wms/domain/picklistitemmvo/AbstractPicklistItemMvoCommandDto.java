package org.dddml.wms.domain.picklistitemmvo;

import org.dddml.wms.domain.picklistbin.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractPicklistItemMvoCommandDto extends AbstractCommand
{
    private PicklistBinPicklistItemId picklistBinPicklistItemId;

    public PicklistBinPicklistItemId getPicklistBinPicklistItemId()
    {
        return this.picklistBinPicklistItemId;
    }

    public void setPicklistBinPicklistItemId(PicklistBinPicklistItemId picklistBinPicklistItemId)
    {
        this.picklistBinPicklistItemId = picklistBinPicklistItemId;
    }

    private Long picklistBinVersion;

    public Long getPicklistBinVersion()
    {
        return this.picklistBinVersion;
    }

    public void setPicklistBinVersion(Long picklistBinVersion)
    {
        this.picklistBinVersion = picklistBinVersion;
    }


}
