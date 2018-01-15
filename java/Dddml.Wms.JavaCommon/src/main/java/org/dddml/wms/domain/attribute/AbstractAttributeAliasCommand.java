package org.dddml.wms.domain.attribute;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractAttributeAliasCommand extends AbstractCommand implements AttributeAliasCommand
{
    private String code;

    public String getCode()
    {
        return this.code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    private String attributeId;

    public String getAttributeId()
    {
        return this.attributeId;
    }

    public void setAttributeId(String attributeId)
    {
        this.attributeId = attributeId;
    }


    public static abstract class AbstractCreateOrMergePatchAttributeAlias extends AbstractAttributeAliasCommand implements CreateOrMergePatchAttributeAlias
    {
        private String name;

        public String getName()
        {
            return this.name;
        }

        public void setName(String name)
        {
            this.name = name;
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

    }

    public static abstract class AbstractCreateAttributeAlias extends AbstractCreateOrMergePatchAttributeAlias implements CreateAttributeAlias
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static abstract class AbstractMergePatchAttributeAlias extends AbstractCreateOrMergePatchAttributeAlias implements MergePatchAttributeAlias
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

        private Boolean isPropertyNameRemoved;

        public Boolean getIsPropertyNameRemoved()
        {
            return this.isPropertyNameRemoved;
        }

        public void setIsPropertyNameRemoved(Boolean removed)
        {
            this.isPropertyNameRemoved = removed;
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

    public static class SimpleCreateAttributeAlias extends AbstractCreateAttributeAlias
    {
    }

    
    public static class SimpleMergePatchAttributeAlias extends AbstractMergePatchAttributeAlias
    {
    }

    
	public static class SimpleRemoveAttributeAlias extends AbstractAttributeAliasCommand implements RemoveAttributeAlias
	{
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_REMOVE;
        }
	}

    

}

