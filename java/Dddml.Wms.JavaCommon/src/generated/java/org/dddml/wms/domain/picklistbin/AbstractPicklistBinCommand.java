package org.dddml.wms.domain.picklistbin;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractPicklistBinCommand extends AbstractCommand implements PicklistBinCommand
{
    private String picklistBinId;

    public String getPicklistBinId()
    {
        return this.picklistBinId;
    }

    public void setPicklistBinId(String picklistBinId)
    {
        this.picklistBinId = picklistBinId;
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


    public static abstract class AbstractCreateOrMergePatchPicklistBin extends AbstractPicklistBinCommand implements CreateOrMergePatchPicklistBin
    {
        private String picklistId;

        public String getPicklistId()
        {
            return this.picklistId;
        }

        public void setPicklistId(String picklistId)
        {
            this.picklistId = picklistId;
        }

        private Long binLocationNumber;

        public Long getBinLocationNumber()
        {
            return this.binLocationNumber;
        }

        public void setBinLocationNumber(Long binLocationNumber)
        {
            this.binLocationNumber = binLocationNumber;
        }

        private String primaryOrderId;

        public String getPrimaryOrderId()
        {
            return this.primaryOrderId;
        }

        public void setPrimaryOrderId(String primaryOrderId)
        {
            this.primaryOrderId = primaryOrderId;
        }

        private String primaryShipGroupSeqId;

        public String getPrimaryShipGroupSeqId()
        {
            return this.primaryShipGroupSeqId;
        }

        public void setPrimaryShipGroupSeqId(String primaryShipGroupSeqId)
        {
            this.primaryShipGroupSeqId = primaryShipGroupSeqId;
        }

        private Boolean active;

        public Boolean getActive()
        {
            return this.active;
        }

        public void setActive(Boolean active)
        {
            this.active = active;
        }

        public PicklistItemCommand.CreatePicklistItem newCreatePicklistItem()
        {
            AbstractPicklistItemCommand.SimpleCreatePicklistItem c = new AbstractPicklistItemCommand.SimpleCreatePicklistItem();
            c.setPicklistBinId(this.getPicklistBinId());

            return c;
        }

        public PicklistItemCommand.MergePatchPicklistItem newMergePatchPicklistItem()
        {
            AbstractPicklistItemCommand.SimpleMergePatchPicklistItem c = new AbstractPicklistItemCommand.SimpleMergePatchPicklistItem();
            c.setPicklistBinId(this.getPicklistBinId());

            return c;
        }

        public PicklistItemCommand.RemovePicklistItem newRemovePicklistItem()
        {
            AbstractPicklistItemCommand.SimpleRemovePicklistItem c = new AbstractPicklistItemCommand.SimpleRemovePicklistItem();
            c.setPicklistBinId(this.getPicklistBinId());

            return c;
        }

    }

    public static abstract class AbstractCreatePicklistBin extends AbstractCreateOrMergePatchPicklistBin implements CreatePicklistBin
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

        private CreatePicklistItemCommands picklistItems = new SimpleCreatePicklistItemCommands();

        public CreatePicklistItemCommands getPicklistItems()
        {
            return this.picklistItems;
        }

    }

    public static abstract class AbstractMergePatchPicklistBin extends AbstractCreateOrMergePatchPicklistBin implements MergePatchPicklistBin
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

        private Boolean isPropertyPicklistIdRemoved;

        public Boolean getIsPropertyPicklistIdRemoved()
        {
            return this.isPropertyPicklistIdRemoved;
        }

        public void setIsPropertyPicklistIdRemoved(Boolean removed)
        {
            this.isPropertyPicklistIdRemoved = removed;
        }

        private Boolean isPropertyBinLocationNumberRemoved;

        public Boolean getIsPropertyBinLocationNumberRemoved()
        {
            return this.isPropertyBinLocationNumberRemoved;
        }

        public void setIsPropertyBinLocationNumberRemoved(Boolean removed)
        {
            this.isPropertyBinLocationNumberRemoved = removed;
        }

        private Boolean isPropertyPrimaryOrderIdRemoved;

        public Boolean getIsPropertyPrimaryOrderIdRemoved()
        {
            return this.isPropertyPrimaryOrderIdRemoved;
        }

        public void setIsPropertyPrimaryOrderIdRemoved(Boolean removed)
        {
            this.isPropertyPrimaryOrderIdRemoved = removed;
        }

        private Boolean isPropertyPrimaryShipGroupSeqIdRemoved;

        public Boolean getIsPropertyPrimaryShipGroupSeqIdRemoved()
        {
            return this.isPropertyPrimaryShipGroupSeqIdRemoved;
        }

        public void setIsPropertyPrimaryShipGroupSeqIdRemoved(Boolean removed)
        {
            this.isPropertyPrimaryShipGroupSeqIdRemoved = removed;
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

        private PicklistItemCommands picklistItemCommands = new SimplePicklistItemCommands();

        public PicklistItemCommands getPicklistItemCommands()
        {
            return this.picklistItemCommands;
        }

    }

    public static class SimpleCreatePicklistBin extends AbstractCreatePicklistBin
    {
    }

    
    public static class SimpleMergePatchPicklistBin extends AbstractMergePatchPicklistBin
    {
    }

    
	public static class SimpleDeletePicklistBin extends AbstractPicklistBinCommand implements DeletePicklistBin
	{
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_DELETE;
        }
	}

    
    public static class SimpleCreatePicklistItemCommands implements CreatePicklistItemCommands
    {
        private List<PicklistItemCommand.CreatePicklistItem> innerCommands = new ArrayList<PicklistItemCommand.CreatePicklistItem>();

        public void add(PicklistItemCommand.CreatePicklistItem c)
        {
            innerCommands.add(c);
        }

        public void remove(PicklistItemCommand.CreatePicklistItem c)
        {
            innerCommands.remove(c);
        }

        public void clear()
        {
            innerCommands.clear();
        }

        @Override
        public Iterator<PicklistItemCommand.CreatePicklistItem> iterator()
        {
            return innerCommands.iterator();
        }
    }

    public static class SimplePicklistItemCommands implements PicklistItemCommands
    {
        private List<PicklistItemCommand> innerCommands = new ArrayList<PicklistItemCommand>();

        public void add(PicklistItemCommand c)
        {
            innerCommands.add(c);
        }

        public void remove(PicklistItemCommand c)
        {
            innerCommands.remove(c);
        }

        public void clear()
        {
            innerCommands.clear();
        }

        @Override
        public Iterator<PicklistItemCommand> iterator()
        {
            return innerCommands.iterator();
        }
    }


}

