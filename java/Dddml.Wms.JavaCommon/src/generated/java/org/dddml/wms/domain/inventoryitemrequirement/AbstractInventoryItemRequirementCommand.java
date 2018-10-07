package org.dddml.wms.domain.inventoryitemrequirement;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryprtriggered.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractInventoryItemRequirementCommand extends AbstractCommand implements InventoryItemRequirementCommand
{
    private InventoryItemId inventoryItemRequirementId;

    public InventoryItemId getInventoryItemRequirementId()
    {
        return this.inventoryItemRequirementId;
    }

    public void setInventoryItemRequirementId(InventoryItemId inventoryItemRequirementId)
    {
        this.inventoryItemRequirementId = inventoryItemRequirementId;
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


    public static abstract class AbstractCreateOrMergePatchInventoryItemRequirement extends AbstractInventoryItemRequirementCommand implements CreateOrMergePatchInventoryItemRequirement
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

        public InventoryItemRequirementEntryCommand.CreateInventoryItemRequirementEntry newCreateInventoryItemRequirementEntry()
        {
            AbstractInventoryItemRequirementEntryCommand.SimpleCreateInventoryItemRequirementEntry c = new AbstractInventoryItemRequirementEntryCommand.SimpleCreateInventoryItemRequirementEntry();
            c.setInventoryItemRequirementId(this.getInventoryItemRequirementId());

            return c;
        }

    }

    public static abstract class AbstractCreateInventoryItemRequirement extends AbstractCreateOrMergePatchInventoryItemRequirement implements CreateInventoryItemRequirement
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

        private CreateInventoryItemRequirementEntryCommandCollection createInventoryItemRequirementEntryCommands = new SimpleCreateInventoryItemRequirementEntryCommandCollection();

        public CreateInventoryItemRequirementEntryCommandCollection getCreateInventoryItemRequirementEntryCommands() {
            return this.createInventoryItemRequirementEntryCommands;
        }

        public CreateInventoryItemRequirementEntryCommandCollection getEntries() {
            return this.createInventoryItemRequirementEntryCommands; //entries;
        }

    }

    public static abstract class AbstractMergePatchInventoryItemRequirement extends AbstractCreateOrMergePatchInventoryItemRequirement implements MergePatchInventoryItemRequirement
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

        private InventoryItemRequirementEntryCommandCollection inventoryItemRequirementEntryCommands = new SimpleInventoryItemRequirementEntryCommandCollection();

        public InventoryItemRequirementEntryCommandCollection getInventoryItemRequirementEntryCommands()
        {
            return this.inventoryItemRequirementEntryCommands;
        }

    }

    public static class SimpleCreateInventoryItemRequirement extends AbstractCreateInventoryItemRequirement
    {
    }

    
    public static class SimpleMergePatchInventoryItemRequirement extends AbstractMergePatchInventoryItemRequirement
    {
    }

    
	public static class SimpleDeleteInventoryItemRequirement extends AbstractInventoryItemRequirementCommand implements DeleteInventoryItemRequirement
	{
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_DELETE;
        }
	}

    
    public static class SimpleCreateInventoryItemRequirementEntryCommandCollection implements CreateInventoryItemRequirementEntryCommandCollection {
        private List<InventoryItemRequirementEntryCommand.CreateInventoryItemRequirementEntry> innerCommands = new ArrayList<InventoryItemRequirementEntryCommand.CreateInventoryItemRequirementEntry>();

        public void add(InventoryItemRequirementEntryCommand.CreateInventoryItemRequirementEntry c) {
            innerCommands.add(c);
        }

        public void remove(InventoryItemRequirementEntryCommand.CreateInventoryItemRequirementEntry c) {
            innerCommands.remove(c);
        }

        public void clear() {
            innerCommands.clear();
        }

        @Override
        public Iterator<InventoryItemRequirementEntryCommand.CreateInventoryItemRequirementEntry> iterator() {
            return innerCommands.iterator();
        }
    }

    public static class SimpleInventoryItemRequirementEntryCommandCollection implements InventoryItemRequirementEntryCommandCollection {
        private List<InventoryItemRequirementEntryCommand> innerCommands = new ArrayList<InventoryItemRequirementEntryCommand>();

        public void add(InventoryItemRequirementEntryCommand c) {
            innerCommands.add(c);
        }

        public void remove(InventoryItemRequirementEntryCommand c) {
            innerCommands.remove(c);
        }

        public void clear() {
            innerCommands.clear();
        }

        @Override
        public Iterator<InventoryItemRequirementEntryCommand> iterator() {
            return innerCommands.iterator();
        }
    }


}

