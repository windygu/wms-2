package org.dddml.wms.domain.goodidentificationtype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractGoodIdentificationTypeCommand extends AbstractCommand implements GoodIdentificationTypeCommand
{
    private String goodIdentificationTypeId;

    public String getGoodIdentificationTypeId()
    {
        return this.goodIdentificationTypeId;
    }

    public void setGoodIdentificationTypeId(String goodIdentificationTypeId)
    {
        this.goodIdentificationTypeId = goodIdentificationTypeId;
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


    public static abstract class AbstractCreateOrMergePatchGoodIdentificationType extends AbstractGoodIdentificationTypeCommand implements CreateOrMergePatchGoodIdentificationType
    {
        private String parentTypeId;

        public String getParentTypeId()
        {
            return this.parentTypeId;
        }

        public void setParentTypeId(String parentTypeId)
        {
            this.parentTypeId = parentTypeId;
        }

        private String hasTable;

        public String getHasTable()
        {
            return this.hasTable;
        }

        public void setHasTable(String hasTable)
        {
            this.hasTable = hasTable;
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

    public static abstract class AbstractCreateGoodIdentificationType extends AbstractCreateOrMergePatchGoodIdentificationType implements CreateGoodIdentificationType
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static abstract class AbstractMergePatchGoodIdentificationType extends AbstractCreateOrMergePatchGoodIdentificationType implements MergePatchGoodIdentificationType
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

        private Boolean isPropertyParentTypeIdRemoved;

        public Boolean getIsPropertyParentTypeIdRemoved()
        {
            return this.isPropertyParentTypeIdRemoved;
        }

        public void setIsPropertyParentTypeIdRemoved(Boolean removed)
        {
            this.isPropertyParentTypeIdRemoved = removed;
        }

        private Boolean isPropertyHasTableRemoved;

        public Boolean getIsPropertyHasTableRemoved()
        {
            return this.isPropertyHasTableRemoved;
        }

        public void setIsPropertyHasTableRemoved(Boolean removed)
        {
            this.isPropertyHasTableRemoved = removed;
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

    public static class SimpleCreateGoodIdentificationType extends AbstractCreateGoodIdentificationType
    {
    }

    
    public static class SimpleMergePatchGoodIdentificationType extends AbstractMergePatchGoodIdentificationType
    {
    }

    
	public static class SimpleDeleteGoodIdentificationType extends AbstractGoodIdentificationTypeCommand implements DeleteGoodIdentificationType
	{
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_DELETE;
        }
	}

    

}

