package org.dddml.wms.domain.uom;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractUomCommand extends AbstractCommand implements UomCommand
{
    private String uomId;

    public String getUomId()
    {
        return this.uomId;
    }

    public void setUomId(String uomId)
    {
        this.uomId = uomId;
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


    public static abstract class AbstractCreateOrMergePatchUom extends AbstractUomCommand implements CreateOrMergePatchUom
    {
        private String uomTypeId;

        public String getUomTypeId()
        {
            return this.uomTypeId;
        }

        public void setUomTypeId(String uomTypeId)
        {
            this.uomTypeId = uomTypeId;
        }

        private String abbreviation;

        public String getAbbreviation()
        {
            return this.abbreviation;
        }

        public void setAbbreviation(String abbreviation)
        {
            this.abbreviation = abbreviation;
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

    public static abstract class AbstractCreateUom extends AbstractCreateOrMergePatchUom implements CreateUom
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static abstract class AbstractMergePatchUom extends AbstractCreateOrMergePatchUom implements MergePatchUom
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

        private Boolean isPropertyUomTypeIdRemoved;

        public Boolean getIsPropertyUomTypeIdRemoved()
        {
            return this.isPropertyUomTypeIdRemoved;
        }

        public void setIsPropertyUomTypeIdRemoved(Boolean removed)
        {
            this.isPropertyUomTypeIdRemoved = removed;
        }

        private Boolean isPropertyAbbreviationRemoved;

        public Boolean getIsPropertyAbbreviationRemoved()
        {
            return this.isPropertyAbbreviationRemoved;
        }

        public void setIsPropertyAbbreviationRemoved(Boolean removed)
        {
            this.isPropertyAbbreviationRemoved = removed;
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

    public static class SimpleCreateUom extends AbstractCreateUom
    {
    }

    
    public static class SimpleMergePatchUom extends AbstractMergePatchUom
    {
    }

    
	public static class SimpleDeleteUom extends AbstractUomCommand implements DeleteUom
	{
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_DELETE;
        }
	}

    

}

