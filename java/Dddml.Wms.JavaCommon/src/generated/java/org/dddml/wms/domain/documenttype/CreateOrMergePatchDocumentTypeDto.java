package org.dddml.wms.domain.documenttype;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchDocumentTypeDto extends AbstractDocumentTypeCommandDto
{
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
     * Parent Document Type Id
     */
    private String parentDocumentTypeId;

    public String getParentDocumentTypeId()
    {
        return this.parentDocumentTypeId;
    }

    public void setParentDocumentTypeId(String parentDocumentTypeId)
    {
        this.parentDocumentTypeId = parentDocumentTypeId;
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

    private Boolean isPropertyDescriptionRemoved;

    public Boolean getIsPropertyDescriptionRemoved()
    {
        return this.isPropertyDescriptionRemoved;
    }

    public void setIsPropertyDescriptionRemoved(Boolean removed)
    {
        this.isPropertyDescriptionRemoved = removed;
    }

    private Boolean isPropertyParentDocumentTypeIdRemoved;

    public Boolean getIsPropertyParentDocumentTypeIdRemoved()
    {
        return this.isPropertyParentDocumentTypeIdRemoved;
    }

    public void setIsPropertyParentDocumentTypeIdRemoved(Boolean removed)
    {
        this.isPropertyParentDocumentTypeIdRemoved = removed;
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

    public DocumentTypeCommand toCommand()
    {
        if (getCommandType() == null) {
            setCommandType(COMMAND_TYPE_MERGE_PATCH);
        }
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            return toCreateDocumentType();
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            return toMergePatchDocumentType();
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    protected DocumentTypeCommand.CreateDocumentType toCreateDocumentType() {
        return new DocumentTypeCommand.CreateDocumentType() {
            @Override
            public String getDocumentTypeId() {
                return CreateOrMergePatchDocumentTypeDto.this.getDocumentTypeId();
            }

            @Override
            public void setDocumentTypeId(String p) {
                CreateOrMergePatchDocumentTypeDto.this.setDocumentTypeId(p);
            }

            @Override
            public Long getVersion() {
                return CreateOrMergePatchDocumentTypeDto.this.getVersion();
            }

            @Override
            public void setVersion(Long p) {
                CreateOrMergePatchDocumentTypeDto.this.setVersion(p);
            }

            @Override
            public String getCommandType() {
                return CreateOrMergePatchDocumentTypeDto.this.getCommandType();
            }

            @Override
            public void setCommandType(String commandType) {
                 CreateOrMergePatchDocumentTypeDto.this.setCommandType(commandType);
            }

            @Override
            public String getCommandId() {
                return CreateOrMergePatchDocumentTypeDto.this.getCommandId();
            }

            @Override
            public void setCommandId(String commandId) {
                CreateOrMergePatchDocumentTypeDto.this.setCommandId(commandId);
            }

            @Override
            public String getRequesterId() {
                return CreateOrMergePatchDocumentTypeDto.this.getRequesterId();
            }

            @Override
            public void setRequesterId(String requesterId) {
                CreateOrMergePatchDocumentTypeDto.this.setRequesterId(requesterId);
            }

            private java.util.Map<String, Object> commandContext;

            @Override
            public java.util.Map<String, Object> getCommandContext() {
                return commandContext;
            }

            public void setCommandContext(java.util.Map<String, Object> commandContext) {
                this.commandContext = commandContext;
            }

            @Override
            public String getDescription() {
                return CreateOrMergePatchDocumentTypeDto.this.getDescription();
            }

            @Override
            public void setDescription(String p) {
                CreateOrMergePatchDocumentTypeDto.this.setDescription(p);
            }

            @Override
            public String getParentDocumentTypeId() {
                return CreateOrMergePatchDocumentTypeDto.this.getParentDocumentTypeId();
            }

            @Override
            public void setParentDocumentTypeId(String p) {
                CreateOrMergePatchDocumentTypeDto.this.setParentDocumentTypeId(p);
            }

            @Override
            public Boolean getActive() {
                return CreateOrMergePatchDocumentTypeDto.this.getActive();
            }

            @Override
            public void setActive(Boolean p) {
                CreateOrMergePatchDocumentTypeDto.this.setActive(p);
            }


        };
    }

    protected DocumentTypeCommand.MergePatchDocumentType toMergePatchDocumentType() {
        return new DocumentTypeCommand.MergePatchDocumentType() {
            @Override
            public String getDocumentTypeId() {
                return CreateOrMergePatchDocumentTypeDto.this.getDocumentTypeId();
            }

            @Override
            public void setDocumentTypeId(String p) {
                CreateOrMergePatchDocumentTypeDto.this.setDocumentTypeId(p);
            }

            @Override
            public Long getVersion() {
                return CreateOrMergePatchDocumentTypeDto.this.getVersion();
            }

            @Override
            public void setVersion(Long p) {
                CreateOrMergePatchDocumentTypeDto.this.setVersion(p);
            }

            @Override
            public String getCommandType() {
                return CreateOrMergePatchDocumentTypeDto.this.getCommandType();
            }

            @Override
            public void setCommandType(String commandType) {
                 CreateOrMergePatchDocumentTypeDto.this.setCommandType(commandType);
            }

            @Override
            public String getCommandId() {
                return CreateOrMergePatchDocumentTypeDto.this.getCommandId();
            }

            @Override
            public void setCommandId(String commandId) {
                CreateOrMergePatchDocumentTypeDto.this.setCommandId(commandId);
            }

            @Override
            public String getRequesterId() {
                return CreateOrMergePatchDocumentTypeDto.this.getRequesterId();
            }

            @Override
            public void setRequesterId(String requesterId) {
                CreateOrMergePatchDocumentTypeDto.this.setRequesterId(requesterId);
            }

            private java.util.Map<String, Object> commandContext;

            @Override
            public java.util.Map<String, Object> getCommandContext() {
                return commandContext;
            }

            public void setCommandContext(java.util.Map<String, Object> commandContext) {
                this.commandContext = commandContext;
            }

            @Override
            public String getDescription() {
                return CreateOrMergePatchDocumentTypeDto.this.getDescription();
            }

            @Override
            public void setDescription(String p) {
                CreateOrMergePatchDocumentTypeDto.this.setDescription(p);
            }

            @Override
            public String getParentDocumentTypeId() {
                return CreateOrMergePatchDocumentTypeDto.this.getParentDocumentTypeId();
            }

            @Override
            public void setParentDocumentTypeId(String p) {
                CreateOrMergePatchDocumentTypeDto.this.setParentDocumentTypeId(p);
            }

            @Override
            public Boolean getActive() {
                return CreateOrMergePatchDocumentTypeDto.this.getActive();
            }

            @Override
            public void setActive(Boolean p) {
                CreateOrMergePatchDocumentTypeDto.this.setActive(p);
            }

            @Override
            public Boolean getIsPropertyDescriptionRemoved() {
                return CreateOrMergePatchDocumentTypeDto.this.getIsPropertyDescriptionRemoved();
            }

            @Override
            public void setIsPropertyDescriptionRemoved(Boolean removed) {
                CreateOrMergePatchDocumentTypeDto.this.setIsPropertyDescriptionRemoved(removed);
            }

            @Override
            public Boolean getIsPropertyParentDocumentTypeIdRemoved() {
                return CreateOrMergePatchDocumentTypeDto.this.getIsPropertyParentDocumentTypeIdRemoved();
            }

            @Override
            public void setIsPropertyParentDocumentTypeIdRemoved(Boolean removed) {
                CreateOrMergePatchDocumentTypeDto.this.setIsPropertyParentDocumentTypeIdRemoved(removed);
            }

            @Override
            public Boolean getIsPropertyActiveRemoved() {
                return CreateOrMergePatchDocumentTypeDto.this.getIsPropertyActiveRemoved();
            }

            @Override
            public void setIsPropertyActiveRemoved(Boolean removed) {
                CreateOrMergePatchDocumentTypeDto.this.setIsPropertyActiveRemoved(removed);
            }


        };
    }

    public static class CreateDocumentTypeDto extends CreateOrMergePatchDocumentTypeDto
    {
        public CreateDocumentTypeDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public DocumentTypeCommand.CreateDocumentType toCreateDocumentType()
        {
            return super.toCreateDocumentType();
        }

    }

    public static class MergePatchDocumentTypeDto extends CreateOrMergePatchDocumentTypeDto
    {
        public MergePatchDocumentTypeDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public DocumentTypeCommand.MergePatchDocumentType toMergePatchDocumentType()
        {
            return super.toMergePatchDocumentType();
        }

    }

}

