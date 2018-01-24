package org.dddml.wms.domain.damagetype;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchDamageTypeDto extends AbstractDamageTypeCommandDto
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

    public DamageTypeCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            return toCreateDamageType();
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            return toMergePatchDamageType();
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    protected DamageTypeCommand.CreateDamageType toCreateDamageType() {
        return new DamageTypeCommand.CreateDamageType() {
            @Override
            public String getDamageTypeId() {
                return CreateOrMergePatchDamageTypeDto.this.getDamageTypeId();
            }

            @Override
            public void setDamageTypeId(String p) {
                CreateOrMergePatchDamageTypeDto.this.setDamageTypeId(p);
            }

            @Override
            public Long getVersion() {
                return CreateOrMergePatchDamageTypeDto.this.getVersion();
            }

            @Override
            public void setVersion(Long p) {
                CreateOrMergePatchDamageTypeDto.this.setVersion(p);
            }

            @Override
            public String getCommandType() {
                return CreateOrMergePatchDamageTypeDto.this.getCommandType();
            }

            @Override
            public void setCommandType(String commandType) {
                 CreateOrMergePatchDamageTypeDto.this.setCommandType(commandType);
            }

            @Override
            public String getCommandId() {
                return CreateOrMergePatchDamageTypeDto.this.getCommandId();
            }

            @Override
            public void setCommandId(String commandId) {
                CreateOrMergePatchDamageTypeDto.this.setCommandId(commandId);
            }

            @Override
            public String getRequesterId() {
                return CreateOrMergePatchDamageTypeDto.this.getRequesterId();
            }

            @Override
            public void setRequesterId(String requesterId) {
                CreateOrMergePatchDamageTypeDto.this.setRequesterId(requesterId);
            }

            @Override
            public String getDescription() {
                return CreateOrMergePatchDamageTypeDto.this.getDescription();
            }

            @Override
            public void setDescription(String p) {
                CreateOrMergePatchDamageTypeDto.this.setDescription(p);
            }

            @Override
            public String getSequenceId() {
                return CreateOrMergePatchDamageTypeDto.this.getSequenceId();
            }

            @Override
            public void setSequenceId(String p) {
                CreateOrMergePatchDamageTypeDto.this.setSequenceId(p);
            }

            @Override
            public String getDefaultHandlingMethodId() {
                return CreateOrMergePatchDamageTypeDto.this.getDefaultHandlingMethodId();
            }

            @Override
            public void setDefaultHandlingMethodId(String p) {
                CreateOrMergePatchDamageTypeDto.this.setDefaultHandlingMethodId(p);
            }

            @Override
            public Boolean getActive() {
                return CreateOrMergePatchDamageTypeDto.this.getActive();
            }

            @Override
            public void setActive(Boolean p) {
                CreateOrMergePatchDamageTypeDto.this.setActive(p);
            }


        };
    }

    protected DamageTypeCommand.MergePatchDamageType toMergePatchDamageType() {
        return new DamageTypeCommand.MergePatchDamageType() {
            @Override
            public String getDamageTypeId() {
                return CreateOrMergePatchDamageTypeDto.this.getDamageTypeId();
            }

            @Override
            public void setDamageTypeId(String p) {
                CreateOrMergePatchDamageTypeDto.this.setDamageTypeId(p);
            }

            @Override
            public Long getVersion() {
                return CreateOrMergePatchDamageTypeDto.this.getVersion();
            }

            @Override
            public void setVersion(Long p) {
                CreateOrMergePatchDamageTypeDto.this.setVersion(p);
            }

            @Override
            public String getCommandType() {
                return CreateOrMergePatchDamageTypeDto.this.getCommandType();
            }

            @Override
            public void setCommandType(String commandType) {
                 CreateOrMergePatchDamageTypeDto.this.setCommandType(commandType);
            }

            @Override
            public String getCommandId() {
                return CreateOrMergePatchDamageTypeDto.this.getCommandId();
            }

            @Override
            public void setCommandId(String commandId) {
                CreateOrMergePatchDamageTypeDto.this.setCommandId(commandId);
            }

            @Override
            public String getRequesterId() {
                return CreateOrMergePatchDamageTypeDto.this.getRequesterId();
            }

            @Override
            public void setRequesterId(String requesterId) {
                CreateOrMergePatchDamageTypeDto.this.setRequesterId(requesterId);
            }

            @Override
            public String getDescription() {
                return CreateOrMergePatchDamageTypeDto.this.getDescription();
            }

            @Override
            public void setDescription(String p) {
                CreateOrMergePatchDamageTypeDto.this.setDescription(p);
            }

            @Override
            public String getSequenceId() {
                return CreateOrMergePatchDamageTypeDto.this.getSequenceId();
            }

            @Override
            public void setSequenceId(String p) {
                CreateOrMergePatchDamageTypeDto.this.setSequenceId(p);
            }

            @Override
            public String getDefaultHandlingMethodId() {
                return CreateOrMergePatchDamageTypeDto.this.getDefaultHandlingMethodId();
            }

            @Override
            public void setDefaultHandlingMethodId(String p) {
                CreateOrMergePatchDamageTypeDto.this.setDefaultHandlingMethodId(p);
            }

            @Override
            public Boolean getActive() {
                return CreateOrMergePatchDamageTypeDto.this.getActive();
            }

            @Override
            public void setActive(Boolean p) {
                CreateOrMergePatchDamageTypeDto.this.setActive(p);
            }

            @Override
            public Boolean getIsPropertyDescriptionRemoved() {
                return CreateOrMergePatchDamageTypeDto.this.getIsPropertyDescriptionRemoved();
            }

            @Override
            public void setIsPropertyDescriptionRemoved(Boolean removed) {
                CreateOrMergePatchDamageTypeDto.this.setIsPropertyDescriptionRemoved(removed);
            }

            @Override
            public Boolean getIsPropertySequenceIdRemoved() {
                return CreateOrMergePatchDamageTypeDto.this.getIsPropertySequenceIdRemoved();
            }

            @Override
            public void setIsPropertySequenceIdRemoved(Boolean removed) {
                CreateOrMergePatchDamageTypeDto.this.setIsPropertySequenceIdRemoved(removed);
            }

            @Override
            public Boolean getIsPropertyDefaultHandlingMethodIdRemoved() {
                return CreateOrMergePatchDamageTypeDto.this.getIsPropertyDefaultHandlingMethodIdRemoved();
            }

            @Override
            public void setIsPropertyDefaultHandlingMethodIdRemoved(Boolean removed) {
                CreateOrMergePatchDamageTypeDto.this.setIsPropertyDefaultHandlingMethodIdRemoved(removed);
            }

            @Override
            public Boolean getIsPropertyActiveRemoved() {
                return CreateOrMergePatchDamageTypeDto.this.getIsPropertyActiveRemoved();
            }

            @Override
            public void setIsPropertyActiveRemoved(Boolean removed) {
                CreateOrMergePatchDamageTypeDto.this.setIsPropertyActiveRemoved(removed);
            }


        };
    }

    public static class CreateDamageTypeDto extends CreateOrMergePatchDamageTypeDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public DamageTypeCommand.CreateDamageType toCreateDamageType()
        {
            return super.toCreateDamageType();
        }

    }

    public static class MergePatchDamageTypeDto extends CreateOrMergePatchDamageTypeDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public DamageTypeCommand.MergePatchDamageType toMergePatchDamageType()
        {
            return super.toMergePatchDamageType();
        }

    }

}

