package org.dddml.wms.domain.attributealiasmvo;

import org.dddml.wms.domain.attribute.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchAttributeAliasMvoDto extends AbstractAttributeAliasMvoCommandDto
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

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
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

    private String attributeAttributeName;

    public String getAttributeAttributeName()
    {
        return this.attributeAttributeName;
    }

    public void setAttributeAttributeName(String attributeAttributeName)
    {
        this.attributeAttributeName = attributeAttributeName;
    }

    private String attributeOrganizationId;

    public String getAttributeOrganizationId()
    {
        return this.attributeOrganizationId;
    }

    public void setAttributeOrganizationId(String attributeOrganizationId)
    {
        this.attributeOrganizationId = attributeOrganizationId;
    }

    private String attributeDescription;

    public String getAttributeDescription()
    {
        return this.attributeDescription;
    }

    public void setAttributeDescription(String attributeDescription)
    {
        this.attributeDescription = attributeDescription;
    }

    private Boolean attributeIsMandatory;

    public Boolean getAttributeIsMandatory()
    {
        return this.attributeIsMandatory;
    }

    public void setAttributeIsMandatory(Boolean attributeIsMandatory)
    {
        this.attributeIsMandatory = attributeIsMandatory;
    }

    private String attributeAttributeValueType;

    public String getAttributeAttributeValueType()
    {
        return this.attributeAttributeValueType;
    }

    public void setAttributeAttributeValueType(String attributeAttributeValueType)
    {
        this.attributeAttributeValueType = attributeAttributeValueType;
    }

    private Integer attributeAttributeValueLength;

    public Integer getAttributeAttributeValueLength()
    {
        return this.attributeAttributeValueLength;
    }

    public void setAttributeAttributeValueLength(Integer attributeAttributeValueLength)
    {
        this.attributeAttributeValueLength = attributeAttributeValueLength;
    }

    private Boolean attributeIsList;

    public Boolean getAttributeIsList()
    {
        return this.attributeIsList;
    }

    public void setAttributeIsList(Boolean attributeIsList)
    {
        this.attributeIsList = attributeIsList;
    }

    private String attributeFieldName;

    public String getAttributeFieldName()
    {
        return this.attributeFieldName;
    }

    public void setAttributeFieldName(String attributeFieldName)
    {
        this.attributeFieldName = attributeFieldName;
    }

    private String attributeReferenceId;

    public String getAttributeReferenceId()
    {
        return this.attributeReferenceId;
    }

    public void setAttributeReferenceId(String attributeReferenceId)
    {
        this.attributeReferenceId = attributeReferenceId;
    }

    private String attributeCreatedBy;

    public String getAttributeCreatedBy()
    {
        return this.attributeCreatedBy;
    }

    public void setAttributeCreatedBy(String attributeCreatedBy)
    {
        this.attributeCreatedBy = attributeCreatedBy;
    }

    private Date attributeCreatedAt;

    public Date getAttributeCreatedAt()
    {
        return this.attributeCreatedAt;
    }

    public void setAttributeCreatedAt(Date attributeCreatedAt)
    {
        this.attributeCreatedAt = attributeCreatedAt;
    }

    private String attributeUpdatedBy;

    public String getAttributeUpdatedBy()
    {
        return this.attributeUpdatedBy;
    }

    public void setAttributeUpdatedBy(String attributeUpdatedBy)
    {
        this.attributeUpdatedBy = attributeUpdatedBy;
    }

    private Date attributeUpdatedAt;

    public Date getAttributeUpdatedAt()
    {
        return this.attributeUpdatedAt;
    }

    public void setAttributeUpdatedAt(Date attributeUpdatedAt)
    {
        this.attributeUpdatedAt = attributeUpdatedAt;
    }

    private Boolean attributeActive;

    public Boolean getAttributeActive()
    {
        return this.attributeActive;
    }

    public void setAttributeActive(Boolean attributeActive)
    {
        this.attributeActive = attributeActive;
    }

    private Boolean attributeDeleted;

    public Boolean getAttributeDeleted()
    {
        return this.attributeDeleted;
    }

    public void setAttributeDeleted(Boolean attributeDeleted)
    {
        this.attributeDeleted = attributeDeleted;
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

    private Boolean isPropertyVersionRemoved;

    public Boolean getIsPropertyVersionRemoved()
    {
        return this.isPropertyVersionRemoved;
    }

    public void setIsPropertyVersionRemoved(Boolean removed)
    {
        this.isPropertyVersionRemoved = removed;
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

    private Boolean isPropertyAttributeAttributeNameRemoved;

    public Boolean getIsPropertyAttributeAttributeNameRemoved()
    {
        return this.isPropertyAttributeAttributeNameRemoved;
    }

    public void setIsPropertyAttributeAttributeNameRemoved(Boolean removed)
    {
        this.isPropertyAttributeAttributeNameRemoved = removed;
    }

    private Boolean isPropertyAttributeOrganizationIdRemoved;

    public Boolean getIsPropertyAttributeOrganizationIdRemoved()
    {
        return this.isPropertyAttributeOrganizationIdRemoved;
    }

    public void setIsPropertyAttributeOrganizationIdRemoved(Boolean removed)
    {
        this.isPropertyAttributeOrganizationIdRemoved = removed;
    }

    private Boolean isPropertyAttributeDescriptionRemoved;

    public Boolean getIsPropertyAttributeDescriptionRemoved()
    {
        return this.isPropertyAttributeDescriptionRemoved;
    }

    public void setIsPropertyAttributeDescriptionRemoved(Boolean removed)
    {
        this.isPropertyAttributeDescriptionRemoved = removed;
    }

    private Boolean isPropertyAttributeIsMandatoryRemoved;

    public Boolean getIsPropertyAttributeIsMandatoryRemoved()
    {
        return this.isPropertyAttributeIsMandatoryRemoved;
    }

    public void setIsPropertyAttributeIsMandatoryRemoved(Boolean removed)
    {
        this.isPropertyAttributeIsMandatoryRemoved = removed;
    }

    private Boolean isPropertyAttributeAttributeValueTypeRemoved;

    public Boolean getIsPropertyAttributeAttributeValueTypeRemoved()
    {
        return this.isPropertyAttributeAttributeValueTypeRemoved;
    }

    public void setIsPropertyAttributeAttributeValueTypeRemoved(Boolean removed)
    {
        this.isPropertyAttributeAttributeValueTypeRemoved = removed;
    }

    private Boolean isPropertyAttributeAttributeValueLengthRemoved;

    public Boolean getIsPropertyAttributeAttributeValueLengthRemoved()
    {
        return this.isPropertyAttributeAttributeValueLengthRemoved;
    }

    public void setIsPropertyAttributeAttributeValueLengthRemoved(Boolean removed)
    {
        this.isPropertyAttributeAttributeValueLengthRemoved = removed;
    }

    private Boolean isPropertyAttributeIsListRemoved;

    public Boolean getIsPropertyAttributeIsListRemoved()
    {
        return this.isPropertyAttributeIsListRemoved;
    }

    public void setIsPropertyAttributeIsListRemoved(Boolean removed)
    {
        this.isPropertyAttributeIsListRemoved = removed;
    }

    private Boolean isPropertyAttributeFieldNameRemoved;

    public Boolean getIsPropertyAttributeFieldNameRemoved()
    {
        return this.isPropertyAttributeFieldNameRemoved;
    }

    public void setIsPropertyAttributeFieldNameRemoved(Boolean removed)
    {
        this.isPropertyAttributeFieldNameRemoved = removed;
    }

    private Boolean isPropertyAttributeReferenceIdRemoved;

    public Boolean getIsPropertyAttributeReferenceIdRemoved()
    {
        return this.isPropertyAttributeReferenceIdRemoved;
    }

    public void setIsPropertyAttributeReferenceIdRemoved(Boolean removed)
    {
        this.isPropertyAttributeReferenceIdRemoved = removed;
    }

    private Boolean isPropertyAttributeCreatedByRemoved;

    public Boolean getIsPropertyAttributeCreatedByRemoved()
    {
        return this.isPropertyAttributeCreatedByRemoved;
    }

    public void setIsPropertyAttributeCreatedByRemoved(Boolean removed)
    {
        this.isPropertyAttributeCreatedByRemoved = removed;
    }

    private Boolean isPropertyAttributeCreatedAtRemoved;

    public Boolean getIsPropertyAttributeCreatedAtRemoved()
    {
        return this.isPropertyAttributeCreatedAtRemoved;
    }

    public void setIsPropertyAttributeCreatedAtRemoved(Boolean removed)
    {
        this.isPropertyAttributeCreatedAtRemoved = removed;
    }

    private Boolean isPropertyAttributeUpdatedByRemoved;

    public Boolean getIsPropertyAttributeUpdatedByRemoved()
    {
        return this.isPropertyAttributeUpdatedByRemoved;
    }

    public void setIsPropertyAttributeUpdatedByRemoved(Boolean removed)
    {
        this.isPropertyAttributeUpdatedByRemoved = removed;
    }

    private Boolean isPropertyAttributeUpdatedAtRemoved;

    public Boolean getIsPropertyAttributeUpdatedAtRemoved()
    {
        return this.isPropertyAttributeUpdatedAtRemoved;
    }

    public void setIsPropertyAttributeUpdatedAtRemoved(Boolean removed)
    {
        this.isPropertyAttributeUpdatedAtRemoved = removed;
    }

    private Boolean isPropertyAttributeActiveRemoved;

    public Boolean getIsPropertyAttributeActiveRemoved()
    {
        return this.isPropertyAttributeActiveRemoved;
    }

    public void setIsPropertyAttributeActiveRemoved(Boolean removed)
    {
        this.isPropertyAttributeActiveRemoved = removed;
    }

    private Boolean isPropertyAttributeDeletedRemoved;

    public Boolean getIsPropertyAttributeDeletedRemoved()
    {
        return this.isPropertyAttributeDeletedRemoved;
    }

    public void setIsPropertyAttributeDeletedRemoved(Boolean removed)
    {
        this.isPropertyAttributeDeletedRemoved = removed;
    }

    public void copyTo(AbstractAttributeAliasMvoCommand.AbstractCreateOrMergePatchAttributeAliasMvo command)
    {
        ((AbstractAttributeAliasMvoCommandDto) this).copyTo(command);
        command.setName(this.getName());
        command.setVersion(this.getVersion());
        command.setActive(this.getActive());
        command.setAttributeAttributeName(this.getAttributeAttributeName());
        command.setAttributeOrganizationId(this.getAttributeOrganizationId());
        command.setAttributeDescription(this.getAttributeDescription());
        command.setAttributeIsMandatory(this.getAttributeIsMandatory());
        command.setAttributeAttributeValueType(this.getAttributeAttributeValueType());
        command.setAttributeAttributeValueLength(this.getAttributeAttributeValueLength());
        command.setAttributeIsList(this.getAttributeIsList());
        command.setAttributeFieldName(this.getAttributeFieldName());
        command.setAttributeReferenceId(this.getAttributeReferenceId());
        command.setAttributeCreatedBy(this.getAttributeCreatedBy());
        command.setAttributeCreatedAt(this.getAttributeCreatedAt());
        command.setAttributeUpdatedBy(this.getAttributeUpdatedBy());
        command.setAttributeUpdatedAt(this.getAttributeUpdatedAt());
        command.setAttributeActive(this.getAttributeActive());
        command.setAttributeDeleted(this.getAttributeDeleted());
    }

    public AttributeAliasMvoCommand toCommand()
    {
        if (getCommandType() == null) {
            setCommandType(COMMAND_TYPE_MERGE_PATCH);
        }
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractAttributeAliasMvoCommand.SimpleCreateAttributeAliasMvo command = new AbstractAttributeAliasMvoCommand.SimpleCreateAttributeAliasMvo();
            copyTo((AbstractAttributeAliasMvoCommand.AbstractCreateAttributeAliasMvo) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractAttributeAliasMvoCommand.SimpleMergePatchAttributeAliasMvo command = new AbstractAttributeAliasMvoCommand.SimpleMergePatchAttributeAliasMvo();
            copyTo((AbstractAttributeAliasMvoCommand.SimpleMergePatchAttributeAliasMvo) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractAttributeAliasMvoCommand.AbstractCreateAttributeAliasMvo command)
    {
        copyTo((AbstractAttributeAliasMvoCommand.AbstractCreateOrMergePatchAttributeAliasMvo) command);
    }

    public void copyTo(AbstractAttributeAliasMvoCommand.AbstractMergePatchAttributeAliasMvo command)
    {
        copyTo((AbstractAttributeAliasMvoCommand.AbstractCreateOrMergePatchAttributeAliasMvo) command);
        command.setIsPropertyNameRemoved(this.getIsPropertyNameRemoved());
        command.setIsPropertyVersionRemoved(this.getIsPropertyVersionRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
        command.setIsPropertyAttributeAttributeNameRemoved(this.getIsPropertyAttributeAttributeNameRemoved());
        command.setIsPropertyAttributeOrganizationIdRemoved(this.getIsPropertyAttributeOrganizationIdRemoved());
        command.setIsPropertyAttributeDescriptionRemoved(this.getIsPropertyAttributeDescriptionRemoved());
        command.setIsPropertyAttributeIsMandatoryRemoved(this.getIsPropertyAttributeIsMandatoryRemoved());
        command.setIsPropertyAttributeAttributeValueTypeRemoved(this.getIsPropertyAttributeAttributeValueTypeRemoved());
        command.setIsPropertyAttributeAttributeValueLengthRemoved(this.getIsPropertyAttributeAttributeValueLengthRemoved());
        command.setIsPropertyAttributeIsListRemoved(this.getIsPropertyAttributeIsListRemoved());
        command.setIsPropertyAttributeFieldNameRemoved(this.getIsPropertyAttributeFieldNameRemoved());
        command.setIsPropertyAttributeReferenceIdRemoved(this.getIsPropertyAttributeReferenceIdRemoved());
        command.setIsPropertyAttributeCreatedByRemoved(this.getIsPropertyAttributeCreatedByRemoved());
        command.setIsPropertyAttributeCreatedAtRemoved(this.getIsPropertyAttributeCreatedAtRemoved());
        command.setIsPropertyAttributeUpdatedByRemoved(this.getIsPropertyAttributeUpdatedByRemoved());
        command.setIsPropertyAttributeUpdatedAtRemoved(this.getIsPropertyAttributeUpdatedAtRemoved());
        command.setIsPropertyAttributeActiveRemoved(this.getIsPropertyAttributeActiveRemoved());
        command.setIsPropertyAttributeDeletedRemoved(this.getIsPropertyAttributeDeletedRemoved());
    }

    public static class CreateAttributeAliasMvoDto extends CreateOrMergePatchAttributeAliasMvoDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public AttributeAliasMvoCommand.CreateAttributeAliasMvo toCreateAttributeAliasMvo()
        {
            return (AttributeAliasMvoCommand.CreateAttributeAliasMvo) toCommand();
        }

    }

    public static class MergePatchAttributeAliasMvoDto extends CreateOrMergePatchAttributeAliasMvoDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public AttributeAliasMvoCommand.MergePatchAttributeAliasMvo toMergePatchAttributeAliasMvo()
        {
            return (AttributeAliasMvoCommand.MergePatchAttributeAliasMvo) toCommand();
        }

    }

}

