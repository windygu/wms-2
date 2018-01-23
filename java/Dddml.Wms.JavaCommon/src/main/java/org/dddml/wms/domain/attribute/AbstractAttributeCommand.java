package org.dddml.wms.domain.attribute;

import org.dddml.wms.domain.AbstractCommand;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractAttributeCommand extends AbstractCommand implements AttributeCommand {
    private String attributeId;
    private Long version;

    public String getAttributeId() {
        return this.attributeId;
    }

    public void setAttributeId(String attributeId) {
        this.attributeId = attributeId;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }


    public static abstract class AbstractCreateOrMergePatchAttribute extends AbstractAttributeCommand implements CreateOrMergePatchAttribute {
        private String attributeName;
        private String organizationId;
        private String description;
        private Boolean isMandatory;
        private String attributeValueType;
        private Integer attributeValueLength;
        private Boolean isList;
        private String fieldName;
        private String referenceId;
        private Boolean active;

        public String getAttributeName() {
            return this.attributeName;
        }

        public void setAttributeName(String attributeName) {
            this.attributeName = attributeName;
        }

        public String getOrganizationId() {
            return this.organizationId;
        }

        public void setOrganizationId(String organizationId) {
            this.organizationId = organizationId;
        }

        public String getDescription() {
            return this.description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Boolean getIsMandatory() {
            return this.isMandatory;
        }

        public void setIsMandatory(Boolean isMandatory) {
            this.isMandatory = isMandatory;
        }

        public String getAttributeValueType() {
            return this.attributeValueType;
        }

        public void setAttributeValueType(String attributeValueType) {
            this.attributeValueType = attributeValueType;
        }

        public Integer getAttributeValueLength() {
            return this.attributeValueLength;
        }

        public void setAttributeValueLength(Integer attributeValueLength) {
            this.attributeValueLength = attributeValueLength;
        }

        public Boolean getIsList() {
            return this.isList;
        }

        public void setIsList(Boolean isList) {
            this.isList = isList;
        }

        public String getFieldName() {
            return this.fieldName;
        }

        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }

        public String getReferenceId() {
            return this.referenceId;
        }

        public void setReferenceId(String referenceId) {
            this.referenceId = referenceId;
        }

        public Boolean getActive() {
            return this.active;
        }

        public void setActive(Boolean active) {
            this.active = active;
        }

        public AttributeValueCommand.CreateAttributeValue newCreateAttributeValue() {
            AbstractAttributeValueCommand.SimpleCreateAttributeValue c = new AbstractAttributeValueCommand.SimpleCreateAttributeValue();
            c.setAttributeId(this.getAttributeId());

            return c;
        }

        public AttributeValueCommand.MergePatchAttributeValue newMergePatchAttributeValue() {
            AbstractAttributeValueCommand.SimpleMergePatchAttributeValue c = new AbstractAttributeValueCommand.SimpleMergePatchAttributeValue();
            c.setAttributeId(this.getAttributeId());

            return c;
        }

        public AttributeValueCommand.RemoveAttributeValue newRemoveAttributeValue() {
            AbstractAttributeValueCommand.SimpleRemoveAttributeValue c = new AbstractAttributeValueCommand.SimpleRemoveAttributeValue();
            c.setAttributeId(this.getAttributeId());

            return c;
        }

        public AttributeAliasCommand.CreateAttributeAlias newCreateAttributeAlias() {
            AbstractAttributeAliasCommand.SimpleCreateAttributeAlias c = new AbstractAttributeAliasCommand.SimpleCreateAttributeAlias();
            c.setAttributeId(this.getAttributeId());

            return c;
        }

        public AttributeAliasCommand.MergePatchAttributeAlias newMergePatchAttributeAlias() {
            AbstractAttributeAliasCommand.SimpleMergePatchAttributeAlias c = new AbstractAttributeAliasCommand.SimpleMergePatchAttributeAlias();
            c.setAttributeId(this.getAttributeId());

            return c;
        }

        public AttributeAliasCommand.RemoveAttributeAlias newRemoveAttributeAlias() {
            AbstractAttributeAliasCommand.SimpleRemoveAttributeAlias c = new AbstractAttributeAliasCommand.SimpleRemoveAttributeAlias();
            c.setAttributeId(this.getAttributeId());

            return c;
        }

    }

    public static abstract class AbstractCreateAttribute extends AbstractCreateOrMergePatchAttribute implements CreateAttribute {
        private CreateAttributeValueCommands attributeValues = new SimpleCreateAttributeValueCommands();
        private CreateAttributeAliasCommands aliases = new SimpleCreateAttributeAliasCommands();

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

        public CreateAttributeValueCommands getAttributeValues() {
            return this.attributeValues;
        }

        public CreateAttributeAliasCommands getAliases() {
            return this.aliases;
        }

    }

    public static abstract class AbstractMergePatchAttribute extends AbstractCreateOrMergePatchAttribute implements MergePatchAttribute {
        private Boolean isPropertyAttributeNameRemoved;
        private Boolean isPropertyOrganizationIdRemoved;
        private Boolean isPropertyDescriptionRemoved;
        private Boolean isPropertyIsMandatoryRemoved;
        private Boolean isPropertyAttributeValueTypeRemoved;
        private Boolean isPropertyAttributeValueLengthRemoved;
        private Boolean isPropertyIsListRemoved;
        private Boolean isPropertyFieldNameRemoved;
        private Boolean isPropertyReferenceIdRemoved;
        private Boolean isPropertyActiveRemoved;
        private AttributeValueCommands attributeValueCommands = new SimpleAttributeValueCommands();
        private AttributeAliasCommands attributeAliasCommands = new SimpleAttributeAliasCommands();

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

        public Boolean getIsPropertyAttributeNameRemoved() {
            return this.isPropertyAttributeNameRemoved;
        }

        public void setIsPropertyAttributeNameRemoved(Boolean removed) {
            this.isPropertyAttributeNameRemoved = removed;
        }

        public Boolean getIsPropertyOrganizationIdRemoved() {
            return this.isPropertyOrganizationIdRemoved;
        }

        public void setIsPropertyOrganizationIdRemoved(Boolean removed) {
            this.isPropertyOrganizationIdRemoved = removed;
        }

        public Boolean getIsPropertyDescriptionRemoved() {
            return this.isPropertyDescriptionRemoved;
        }

        public void setIsPropertyDescriptionRemoved(Boolean removed) {
            this.isPropertyDescriptionRemoved = removed;
        }

        public Boolean getIsPropertyIsMandatoryRemoved() {
            return this.isPropertyIsMandatoryRemoved;
        }

        public void setIsPropertyIsMandatoryRemoved(Boolean removed) {
            this.isPropertyIsMandatoryRemoved = removed;
        }

        public Boolean getIsPropertyAttributeValueTypeRemoved() {
            return this.isPropertyAttributeValueTypeRemoved;
        }

        public void setIsPropertyAttributeValueTypeRemoved(Boolean removed) {
            this.isPropertyAttributeValueTypeRemoved = removed;
        }

        public Boolean getIsPropertyAttributeValueLengthRemoved() {
            return this.isPropertyAttributeValueLengthRemoved;
        }

        public void setIsPropertyAttributeValueLengthRemoved(Boolean removed) {
            this.isPropertyAttributeValueLengthRemoved = removed;
        }

        public Boolean getIsPropertyIsListRemoved() {
            return this.isPropertyIsListRemoved;
        }

        public void setIsPropertyIsListRemoved(Boolean removed) {
            this.isPropertyIsListRemoved = removed;
        }

        public Boolean getIsPropertyFieldNameRemoved() {
            return this.isPropertyFieldNameRemoved;
        }

        public void setIsPropertyFieldNameRemoved(Boolean removed) {
            this.isPropertyFieldNameRemoved = removed;
        }

        public Boolean getIsPropertyReferenceIdRemoved() {
            return this.isPropertyReferenceIdRemoved;
        }

        public void setIsPropertyReferenceIdRemoved(Boolean removed) {
            this.isPropertyReferenceIdRemoved = removed;
        }

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

        public AttributeValueCommands getAttributeValueCommands() {
            return this.attributeValueCommands;
        }

        public AttributeAliasCommands getAttributeAliasCommands() {
            return this.attributeAliasCommands;
        }

    }

    public static class SimpleCreateAttribute extends AbstractCreateAttribute {
    }


    public static class SimpleMergePatchAttribute extends AbstractMergePatchAttribute {
    }


    public static class SimpleDeleteAttribute extends AbstractAttributeCommand implements DeleteAttribute {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_DELETE;
        }
    }


    public static class SimpleCreateAttributeValueCommands implements CreateAttributeValueCommands {
        private List<AttributeValueCommand.CreateAttributeValue> innerCommands = new ArrayList<AttributeValueCommand.CreateAttributeValue>();

        public void add(AttributeValueCommand.CreateAttributeValue c) {
            innerCommands.add(c);
        }

        public void remove(AttributeValueCommand.CreateAttributeValue c) {
            innerCommands.remove(c);
        }

        public void clear() {
            innerCommands.clear();
        }

        @Override
        public Iterator<AttributeValueCommand.CreateAttributeValue> iterator() {
            return innerCommands.iterator();
        }
    }

    public static class SimpleAttributeValueCommands implements AttributeValueCommands {
        private List<AttributeValueCommand> innerCommands = new ArrayList<AttributeValueCommand>();

        public void add(AttributeValueCommand c) {
            innerCommands.add(c);
        }

        public void remove(AttributeValueCommand c) {
            innerCommands.remove(c);
        }

        public void clear() {
            innerCommands.clear();
        }

        @Override
        public Iterator<AttributeValueCommand> iterator() {
            return innerCommands.iterator();
        }
    }

    public static class SimpleCreateAttributeAliasCommands implements CreateAttributeAliasCommands {
        private List<AttributeAliasCommand.CreateAttributeAlias> innerCommands = new ArrayList<AttributeAliasCommand.CreateAttributeAlias>();

        public void add(AttributeAliasCommand.CreateAttributeAlias c) {
            innerCommands.add(c);
        }

        public void remove(AttributeAliasCommand.CreateAttributeAlias c) {
            innerCommands.remove(c);
        }

        public void clear() {
            innerCommands.clear();
        }

        @Override
        public Iterator<AttributeAliasCommand.CreateAttributeAlias> iterator() {
            return innerCommands.iterator();
        }
    }

    public static class SimpleAttributeAliasCommands implements AttributeAliasCommands {
        private List<AttributeAliasCommand> innerCommands = new ArrayList<AttributeAliasCommand>();

        public void add(AttributeAliasCommand c) {
            innerCommands.add(c);
        }

        public void remove(AttributeAliasCommand c) {
            innerCommands.remove(c);
        }

        public void clear() {
            innerCommands.clear();
        }

        @Override
        public Iterator<AttributeAliasCommand> iterator() {
            return innerCommands.iterator();
        }
    }


}

