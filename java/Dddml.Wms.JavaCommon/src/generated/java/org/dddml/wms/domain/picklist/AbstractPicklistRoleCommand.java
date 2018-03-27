package org.dddml.wms.domain.picklist;

import java.util.*;
import org.dddml.wms.domain.partyrole.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractPicklistRoleCommand extends AbstractCommand implements PicklistRoleCommand
{
    private PartyRoleId partyRoleId;

    public PartyRoleId getPartyRoleId()
    {
        return this.partyRoleId;
    }

    public void setPartyRoleId(PartyRoleId partyRoleId)
    {
        this.partyRoleId = partyRoleId;
    }

    private String picklistId;

    public String getPicklistId()
    {
        return this.picklistId;
    }

    public void setPicklistId(String picklistId)
    {
        this.picklistId = picklistId;
    }


    public static abstract class AbstractCreateOrMergePatchPicklistRole extends AbstractPicklistRoleCommand implements CreateOrMergePatchPicklistRole
    {
        private Boolean active;

        public Boolean getActive()
        {
            return this.active;
        }

        public void setActive(Boolean active)
        {
            this.active = active;
        }

    }

    public static abstract class AbstractCreatePicklistRole extends AbstractCreateOrMergePatchPicklistRole implements CreatePicklistRole
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static abstract class AbstractMergePatchPicklistRole extends AbstractCreateOrMergePatchPicklistRole implements MergePatchPicklistRole
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved()
        {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed)
        {
            this.isPropertyActiveRemoved = removed;
        }

    }

    public static class SimpleCreatePicklistRole extends AbstractCreatePicklistRole
    {
    }

    
    public static class SimpleMergePatchPicklistRole extends AbstractMergePatchPicklistRole
    {
    }

    
	public static class SimpleRemovePicklistRole extends AbstractPicklistRoleCommand implements RemovePicklistRole
	{
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_REMOVE;
        }
	}

    

}

