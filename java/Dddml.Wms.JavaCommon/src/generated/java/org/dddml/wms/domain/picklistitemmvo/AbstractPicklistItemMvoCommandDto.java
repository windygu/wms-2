package org.dddml.wms.domain.picklistitemmvo;

import org.dddml.wms.domain.picklistbin.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractPicklistItemMvoCommandDto extends AbstractCommand
{
    /**
     * Picklist Bin Picklist Item Id
     */
    private PicklistBinPicklistItemId picklistBinPicklistItemId;

    public PicklistBinPicklistItemId getPicklistBinPicklistItemId()
    {
        return this.picklistBinPicklistItemId;
    }

    public void setPicklistBinPicklistItemId(PicklistBinPicklistItemId picklistBinPicklistItemId)
    {
        this.picklistBinPicklistItemId = picklistBinPicklistItemId;
    }

    /**
     * Picklist Bin Version
     */
    private Long picklistBinVersion;

    public Long getPicklistBinVersion()
    {
        return this.picklistBinVersion;
    }

    public void setPicklistBinVersion(Long picklistBinVersion)
    {
        this.picklistBinVersion = picklistBinVersion;
    }


    public void copyTo(AbstractPicklistItemMvoCommand command)
    {
        command.setPicklistBinPicklistItemId(this.getPicklistBinPicklistItemId());
        command.setPicklistBinVersion(this.getPicklistBinVersion());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
