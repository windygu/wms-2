package org.dddml.wms.domain.damagehandlingmethod;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchDamageHandlingMethodDto extends AbstractDamageHandlingMethodCommandDto
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
     * Sequence Id
     */
    private String sequenceId;

    public String getSequenceId()
    {
        return this.sequenceId;
    }

    public void setSequenceId(String sequenceId)
    {
        this.sequenceId = sequenceId;
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

    public DamageHandlingMethodCommand toCommand()
    {
        if (getCommandType() == null) {
            setCommandType(COMMAND_TYPE_MERGE_PATCH);
        }
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            return toCreateDamageHandlingMethod();
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            return toMergePatchDamageHandlingMethod();
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    protected DamageHandlingMethodCommand.CreateDamageHandlingMethod toCreateDamageHandlingMethod() {
        return new DamageHandlingMethodCommand.CreateDamageHandlingMethod() {
            @Override
            public String getDamageHandlingMethodId() {
                return CreateOrMergePatchDamageHandlingMethodDto.this.getDamageHandlingMethodId();
            }

            @Override
            public void setDamageHandlingMethodId(String p) {
                CreateOrMergePatchDamageHandlingMethodDto.this.setDamageHandlingMethodId(p);
            }

            @Override
            public Long getVersion() {
                return CreateOrMergePatchDamageHandlingMethodDto.this.getVersion();
            }

            @Override
            public void setVersion(Long p) {
                CreateOrMergePatchDamageHandlingMethodDto.this.setVersion(p);
            }

            @Override
            public String getCommandType() {
                return CreateOrMergePatchDamageHandlingMethodDto.this.getCommandType();
            }

            @Override
            public void setCommandType(String commandType) {
                 CreateOrMergePatchDamageHandlingMethodDto.this.setCommandType(commandType);
            }

            @Override
            public String getCommandId() {
                return CreateOrMergePatchDamageHandlingMethodDto.this.getCommandId();
            }

            @Override
            public void setCommandId(String commandId) {
                CreateOrMergePatchDamageHandlingMethodDto.this.setCommandId(commandId);
            }

            @Override
            public String getRequesterId() {
                return CreateOrMergePatchDamageHandlingMethodDto.this.getRequesterId();
            }

            @Override
            public void setRequesterId(String requesterId) {
                CreateOrMergePatchDamageHandlingMethodDto.this.setRequesterId(requesterId);
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
                return CreateOrMergePatchDamageHandlingMethodDto.this.getDescription();
            }

            @Override
            public void setDescription(String p) {
                CreateOrMergePatchDamageHandlingMethodDto.this.setDescription(p);
            }

            @Override
            public String getSequenceId() {
                return CreateOrMergePatchDamageHandlingMethodDto.this.getSequenceId();
            }

            @Override
            public void setSequenceId(String p) {
                CreateOrMergePatchDamageHandlingMethodDto.this.setSequenceId(p);
            }

            @Override
            public Boolean getActive() {
                return CreateOrMergePatchDamageHandlingMethodDto.this.getActive();
            }

            @Override
            public void setActive(Boolean p) {
                CreateOrMergePatchDamageHandlingMethodDto.this.setActive(p);
            }


        };
    }

    protected DamageHandlingMethodCommand.MergePatchDamageHandlingMethod toMergePatchDamageHandlingMethod() {
        return new DamageHandlingMethodCommand.MergePatchDamageHandlingMethod() {
            @Override
            public String getDamageHandlingMethodId() {
                return CreateOrMergePatchDamageHandlingMethodDto.this.getDamageHandlingMethodId();
            }

            @Override
            public void setDamageHandlingMethodId(String p) {
                CreateOrMergePatchDamageHandlingMethodDto.this.setDamageHandlingMethodId(p);
            }

            @Override
            public Long getVersion() {
                return CreateOrMergePatchDamageHandlingMethodDto.this.getVersion();
            }

            @Override
            public void setVersion(Long p) {
                CreateOrMergePatchDamageHandlingMethodDto.this.setVersion(p);
            }

            @Override
            public String getCommandType() {
                return CreateOrMergePatchDamageHandlingMethodDto.this.getCommandType();
            }

            @Override
            public void setCommandType(String commandType) {
                 CreateOrMergePatchDamageHandlingMethodDto.this.setCommandType(commandType);
            }

            @Override
            public String getCommandId() {
                return CreateOrMergePatchDamageHandlingMethodDto.this.getCommandId();
            }

            @Override
            public void setCommandId(String commandId) {
                CreateOrMergePatchDamageHandlingMethodDto.this.setCommandId(commandId);
            }

            @Override
            public String getRequesterId() {
                return CreateOrMergePatchDamageHandlingMethodDto.this.getRequesterId();
            }

            @Override
            public void setRequesterId(String requesterId) {
                CreateOrMergePatchDamageHandlingMethodDto.this.setRequesterId(requesterId);
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
                return CreateOrMergePatchDamageHandlingMethodDto.this.getDescription();
            }

            @Override
            public void setDescription(String p) {
                CreateOrMergePatchDamageHandlingMethodDto.this.setDescription(p);
            }

            @Override
            public String getSequenceId() {
                return CreateOrMergePatchDamageHandlingMethodDto.this.getSequenceId();
            }

            @Override
            public void setSequenceId(String p) {
                CreateOrMergePatchDamageHandlingMethodDto.this.setSequenceId(p);
            }

            @Override
            public Boolean getActive() {
                return CreateOrMergePatchDamageHandlingMethodDto.this.getActive();
            }

            @Override
            public void setActive(Boolean p) {
                CreateOrMergePatchDamageHandlingMethodDto.this.setActive(p);
            }

            @Override
            public Boolean getIsPropertyDescriptionRemoved() {
                return CreateOrMergePatchDamageHandlingMethodDto.this.getIsPropertyDescriptionRemoved();
            }

            @Override
            public void setIsPropertyDescriptionRemoved(Boolean removed) {
                CreateOrMergePatchDamageHandlingMethodDto.this.setIsPropertyDescriptionRemoved(removed);
            }

            @Override
            public Boolean getIsPropertySequenceIdRemoved() {
                return CreateOrMergePatchDamageHandlingMethodDto.this.getIsPropertySequenceIdRemoved();
            }

            @Override
            public void setIsPropertySequenceIdRemoved(Boolean removed) {
                CreateOrMergePatchDamageHandlingMethodDto.this.setIsPropertySequenceIdRemoved(removed);
            }

            @Override
            public Boolean getIsPropertyActiveRemoved() {
                return CreateOrMergePatchDamageHandlingMethodDto.this.getIsPropertyActiveRemoved();
            }

            @Override
            public void setIsPropertyActiveRemoved(Boolean removed) {
                CreateOrMergePatchDamageHandlingMethodDto.this.setIsPropertyActiveRemoved(removed);
            }


        };
    }

    public static class CreateDamageHandlingMethodDto extends CreateOrMergePatchDamageHandlingMethodDto
    {
        public CreateDamageHandlingMethodDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public DamageHandlingMethodCommand.CreateDamageHandlingMethod toCreateDamageHandlingMethod()
        {
            return super.toCreateDamageHandlingMethod();
        }

    }

    public static class MergePatchDamageHandlingMethodDto extends CreateOrMergePatchDamageHandlingMethodDto
    {
        public MergePatchDamageHandlingMethodDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public DamageHandlingMethodCommand.MergePatchDamageHandlingMethod toMergePatchDamageHandlingMethod()
        {
            return super.toMergePatchDamageHandlingMethod();
        }

    }

}

