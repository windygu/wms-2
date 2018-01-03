package org.dddml.wms.domain.damagehandlingmethod;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractDamageHandlingMethodCommand extends AbstractCommand implements DamageHandlingMethodCommand
{
    private String damageHandlingMethodId;

    public String getDamageHandlingMethodId()
    {
        return this.damageHandlingMethodId;
    }

    public void setDamageHandlingMethodId(String damageHandlingMethodId)
    {
        this.damageHandlingMethodId = damageHandlingMethodId;
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


    public static abstract class AbstractCreateOrMergePatchDamageHandlingMethod extends AbstractDamageHandlingMethodCommand implements CreateOrMergePatchDamageHandlingMethod
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

    public static abstract class AbstractCreateDamageHandlingMethod extends AbstractCreateOrMergePatchDamageHandlingMethod implements CreateDamageHandlingMethod
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static abstract class AbstractMergePatchDamageHandlingMethod extends AbstractCreateOrMergePatchDamageHandlingMethod implements MergePatchDamageHandlingMethod
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

    public static class SimpleCreateDamageHandlingMethod extends AbstractCreateDamageHandlingMethod
    {
    }

    
    public static class SimpleMergePatchDamageHandlingMethod extends AbstractMergePatchDamageHandlingMethod
    {
    }

    
	public static class SimpleDeleteDamageHandlingMethod extends AbstractDamageHandlingMethodCommand implements DeleteDamageHandlingMethod
	{
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_DELETE;
        }
	}

    

}

