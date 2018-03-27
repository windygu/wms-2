package org.dddml.wms.domain.locatortype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractLocatorTypeCommand extends AbstractCommand implements LocatorTypeCommand
{
    private String locatorTypeId;

    public String getLocatorTypeId()
    {
        return this.locatorTypeId;
    }

    public void setLocatorTypeId(String locatorTypeId)
    {
        this.locatorTypeId = locatorTypeId;
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


    public static abstract class AbstractCreateOrMergePatchLocatorType extends AbstractLocatorTypeCommand implements CreateOrMergePatchLocatorType
    {
        private String description;

        public String getDescription()
        {
            return this.description;
        }

        public void setDescription(String description)
        {
            this.description = description;
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

    public static abstract class AbstractCreateLocatorType extends AbstractCreateOrMergePatchLocatorType implements CreateLocatorType
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static abstract class AbstractMergePatchLocatorType extends AbstractCreateOrMergePatchLocatorType implements MergePatchLocatorType
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
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

    public static class SimpleCreateLocatorType extends AbstractCreateLocatorType
    {
    }

    
    public static class SimpleMergePatchLocatorType extends AbstractMergePatchLocatorType
    {
    }

    
	public static class SimpleDeleteLocatorType extends AbstractLocatorTypeCommand implements DeleteLocatorType
	{
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_DELETE;
        }
	}

    

}

