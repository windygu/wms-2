package org.dddml.wms.domain.attributesetinstanceextensionfieldgroup;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchAttributeSetInstanceExtensionFieldGroupDto extends AbstractAttributeSetInstanceExtensionFieldGroupCommandDto
{
    /**
     * Field Type
     */
    private String fieldType;

    public String getFieldType()
    {
        return this.fieldType;
    }

    public void setFieldType(String fieldType)
    {
        this.fieldType = fieldType;
    }

    /**
     * Field Length
     */
    private Integer fieldLength;

    public Integer getFieldLength()
    {
        return this.fieldLength;
    }

    public void setFieldLength(Integer fieldLength)
    {
        this.fieldLength = fieldLength;
    }

    /**
     * Field Count
     */
    private Integer fieldCount;

    public Integer getFieldCount()
    {
        return this.fieldCount;
    }

    public void setFieldCount(Integer fieldCount)
    {
        this.fieldCount = fieldCount;
    }

    /**
     * Name Format
     */
    private String nameFormat;

    public String getNameFormat()
    {
        return this.nameFormat;
    }

    public void setNameFormat(String nameFormat)
    {
        this.nameFormat = nameFormat;
    }

    /**
     * Description
     */
    private String description;

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * Active
     */
    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }

    private Boolean isPropertyFieldTypeRemoved;

    public Boolean getIsPropertyFieldTypeRemoved()
    {
        return this.isPropertyFieldTypeRemoved;
    }

    public void setIsPropertyFieldTypeRemoved(Boolean removed)
    {
        this.isPropertyFieldTypeRemoved = removed;
    }

    private Boolean isPropertyFieldLengthRemoved;

    public Boolean getIsPropertyFieldLengthRemoved()
    {
        return this.isPropertyFieldLengthRemoved;
    }

    public void setIsPropertyFieldLengthRemoved(Boolean removed)
    {
        this.isPropertyFieldLengthRemoved = removed;
    }

    private Boolean isPropertyFieldCountRemoved;

    public Boolean getIsPropertyFieldCountRemoved()
    {
        return this.isPropertyFieldCountRemoved;
    }

    public void setIsPropertyFieldCountRemoved(Boolean removed)
    {
        this.isPropertyFieldCountRemoved = removed;
    }

    private Boolean isPropertyNameFormatRemoved;

    public Boolean getIsPropertyNameFormatRemoved()
    {
        return this.isPropertyNameFormatRemoved;
    }

    public void setIsPropertyNameFormatRemoved(Boolean removed)
    {
        this.isPropertyNameFormatRemoved = removed;
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

    public static class CreateAttributeSetInstanceExtensionFieldGroupDto extends CreateOrMergePatchAttributeSetInstanceExtensionFieldGroupDto
    {
        public CreateAttributeSetInstanceExtensionFieldGroupDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static class MergePatchAttributeSetInstanceExtensionFieldGroupDto extends CreateOrMergePatchAttributeSetInstanceExtensionFieldGroupDto
    {
        public MergePatchAttributeSetInstanceExtensionFieldGroupDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

    }

}

