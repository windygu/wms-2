package org.dddml.wms.domain.attributeset;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractAttributeSetCommand extends AbstractCommand implements AttributeSetCommand
{
    private String attributeSetId;

    public String getAttributeSetId()
    {
        return this.attributeSetId;
    }

    public void setAttributeSetId(String attributeSetId)
    {
        this.attributeSetId = attributeSetId;
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


    public static abstract class AbstractCreateOrMergePatchAttributeSet extends AbstractAttributeSetCommand implements CreateOrMergePatchAttributeSet
    {
        private String attributeSetName;

        public String getAttributeSetName()
        {
            return this.attributeSetName;
        }

        public void setAttributeSetName(String attributeSetName)
        {
            this.attributeSetName = attributeSetName;
        }

        private String organizationId;

        public String getOrganizationId()
        {
            return this.organizationId;
        }

        public void setOrganizationId(String organizationId)
        {
            this.organizationId = organizationId;
        }

        private String description;

        public String getDescription()
        {
            return this.description;
        }

        public void setDescription(String description)
        {
            this.description = description;
        }

        private String referenceId;

        public String getReferenceId()
        {
            return this.referenceId;
        }

        public void setReferenceId(String referenceId)
        {
            this.referenceId = referenceId;
        }

        private Boolean isInstanceAttributeSet;

        public Boolean getIsInstanceAttributeSet()
        {
            return this.isInstanceAttributeSet;
        }

        public void setIsInstanceAttributeSet(Boolean isInstanceAttributeSet)
        {
            this.isInstanceAttributeSet = isInstanceAttributeSet;
        }

        private Boolean isMandatory;

        public Boolean getIsMandatory()
        {
            return this.isMandatory;
        }

        public void setIsMandatory(Boolean isMandatory)
        {
            this.isMandatory = isMandatory;
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

        public AttributeUseCommand.CreateAttributeUse newCreateAttributeUse()
        {
            AbstractAttributeUseCommand.SimpleCreateAttributeUse c = new AbstractAttributeUseCommand.SimpleCreateAttributeUse();
            c.setAttributeSetId(this.getAttributeSetId());

            return c;
        }

        public AttributeUseCommand.MergePatchAttributeUse newMergePatchAttributeUse()
        {
            AbstractAttributeUseCommand.SimpleMergePatchAttributeUse c = new AbstractAttributeUseCommand.SimpleMergePatchAttributeUse();
            c.setAttributeSetId(this.getAttributeSetId());

            return c;
        }

        public AttributeUseCommand.RemoveAttributeUse newRemoveAttributeUse()
        {
            AbstractAttributeUseCommand.SimpleRemoveAttributeUse c = new AbstractAttributeUseCommand.SimpleRemoveAttributeUse();
            c.setAttributeSetId(this.getAttributeSetId());

            return c;
        }

    }

    public static abstract class AbstractCreateAttributeSet extends AbstractCreateOrMergePatchAttributeSet implements CreateAttributeSet
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

        private CreateAttributeUseCommandCollection attributeUses = new SimpleCreateAttributeUseCommandCollection();

        public CreateAttributeUseCommandCollection getAttributeUses()
        {
            return this.attributeUses;
        }

    }

    public static abstract class AbstractMergePatchAttributeSet extends AbstractCreateOrMergePatchAttributeSet implements MergePatchAttributeSet
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

        private Boolean isPropertyAttributeSetNameRemoved;

        public Boolean getIsPropertyAttributeSetNameRemoved()
        {
            return this.isPropertyAttributeSetNameRemoved;
        }

        public void setIsPropertyAttributeSetNameRemoved(Boolean removed)
        {
            this.isPropertyAttributeSetNameRemoved = removed;
        }

        private Boolean isPropertyOrganizationIdRemoved;

        public Boolean getIsPropertyOrganizationIdRemoved()
        {
            return this.isPropertyOrganizationIdRemoved;
        }

        public void setIsPropertyOrganizationIdRemoved(Boolean removed)
        {
            this.isPropertyOrganizationIdRemoved = removed;
        }

        private Boolean isPropertyDescriptionRemoved;

        public Boolean getIsPropertyDescriptionRemoved()
        {
            return this.isPropertyDescriptionRemoved;
        }

        public void setIsPropertyDescriptionRemoved(Boolean removed)
        {
            this.isPropertyDescriptionRemoved = removed;
        }

        private Boolean isPropertyReferenceIdRemoved;

        public Boolean getIsPropertyReferenceIdRemoved()
        {
            return this.isPropertyReferenceIdRemoved;
        }

        public void setIsPropertyReferenceIdRemoved(Boolean removed)
        {
            this.isPropertyReferenceIdRemoved = removed;
        }

        private Boolean isPropertyIsInstanceAttributeSetRemoved;

        public Boolean getIsPropertyIsInstanceAttributeSetRemoved()
        {
            return this.isPropertyIsInstanceAttributeSetRemoved;
        }

        public void setIsPropertyIsInstanceAttributeSetRemoved(Boolean removed)
        {
            this.isPropertyIsInstanceAttributeSetRemoved = removed;
        }

        private Boolean isPropertyIsMandatoryRemoved;

        public Boolean getIsPropertyIsMandatoryRemoved()
        {
            return this.isPropertyIsMandatoryRemoved;
        }

        public void setIsPropertyIsMandatoryRemoved(Boolean removed)
        {
            this.isPropertyIsMandatoryRemoved = removed;
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

        private AttributeUseCommandCollection attributeUseCommands = new SimpleAttributeUseCommandCollection();

        public AttributeUseCommandCollection getAttributeUseCommands()
        {
            return this.attributeUseCommands;
        }

    }

    public static class SimpleCreateAttributeSet extends AbstractCreateAttributeSet
    {
    }

    
    public static class SimpleMergePatchAttributeSet extends AbstractMergePatchAttributeSet
    {
    }

    
	public static class SimpleDeleteAttributeSet extends AbstractAttributeSetCommand implements DeleteAttributeSet
	{
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_DELETE;
        }
	}

    
    public static class SimpleCreateAttributeUseCommandCollection implements CreateAttributeUseCommandCollection {
        private List<AttributeUseCommand.CreateAttributeUse> innerCommands = new ArrayList<AttributeUseCommand.CreateAttributeUse>();

        public void add(AttributeUseCommand.CreateAttributeUse c) {
            innerCommands.add(c);
        }

        public void remove(AttributeUseCommand.CreateAttributeUse c) {
            innerCommands.remove(c);
        }

        public void clear() {
            innerCommands.clear();
        }

        @Override
        public Iterator<AttributeUseCommand.CreateAttributeUse> iterator() {
            return innerCommands.iterator();
        }
    }

    public static class SimpleAttributeUseCommandCollection implements AttributeUseCommandCollection {
        private List<AttributeUseCommand> innerCommands = new ArrayList<AttributeUseCommand>();

        public void add(AttributeUseCommand c) {
            innerCommands.add(c);
        }

        public void remove(AttributeUseCommand c) {
            innerCommands.remove(c);
        }

        public void clear() {
            innerCommands.clear();
        }

        @Override
        public Iterator<AttributeUseCommand> iterator() {
            return innerCommands.iterator();
        }
    }


}

