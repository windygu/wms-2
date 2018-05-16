package org.dddml.wms.domain.uom;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchUomDto extends AbstractUomCommandDto
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

    public static class CreateUomDto extends CreateOrMergePatchUomDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static class MergePatchUomDto extends CreateOrMergePatchUomDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

    }

}

