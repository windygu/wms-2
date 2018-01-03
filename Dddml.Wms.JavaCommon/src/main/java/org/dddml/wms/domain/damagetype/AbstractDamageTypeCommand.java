package org.dddml.wms.domain.damagetype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractDamageTypeCommand extends AbstractCommand implements DamageTypeCommand
{
    private String damageTypeId;

    public String getDamageTypeId()
    {
        return this.damageTypeId;
    }

    public void setDamageTypeId(String damageTypeId)
    {
        this.damageTypeId = damageTypeId;
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


    public static abstract class AbstractCreateOrMergePatchDamageType extends AbstractDamageTypeCommand implements CreateOrMergePatchDamageType
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

        private String sequenceId;

        public String getSequenceId()
        {
            return this.sequenceId;
        }

        public void setSequenceId(String sequenceId)
        {
            this.sequenceId = sequenceId;
        }

        private String defaultHandlingMethodId;

        public String getDefaultHandlingMethodId()
        {
            return this.defaultHandlingMethodId;
        }

        public void setDefaultHandlingMethodId(String defaultHandlingMethodId)
        {
            this.defaultHandlingMethodId = defaultHandlingMethodId;
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

    public static abstract class AbstractCreateDamageType extends AbstractCreateOrMergePatchDamageType implements CreateDamageType
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static abstract class AbstractMergePatchDamageType extends AbstractCreateOrMergePatchDamageType implements MergePatchDamageType
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

        private Boolean isPropertySequenceIdRemoved;

        public Boolean getIsPropertySequenceIdRemoved()
        {
            return this.isPropertySequenceIdRemoved;
        }

        public void setIsPropertySequenceIdRemoved(Boolean removed)
        {
            this.isPropertySequenceIdRemoved = removed;
        }

        private Boolean isPropertyDefaultHandlingMethodIdRemoved;

        public Boolean getIsPropertyDefaultHandlingMethodIdRemoved()
        {
            return this.isPropertyDefaultHandlingMethodIdRemoved;
        }

        public void setIsPropertyDefaultHandlingMethodIdRemoved(Boolean removed)
        {
            this.isPropertyDefaultHandlingMethodIdRemoved = removed;
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

    public static class SimpleCreateDamageType extends AbstractCreateDamageType
    {
    }

    
    public static class SimpleMergePatchDamageType extends AbstractMergePatchDamageType
    {
    }

    
	public static class SimpleDeleteDamageType extends AbstractDamageTypeCommand implements DeleteDamageType
	{
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_DELETE;
        }
	}

    

}

