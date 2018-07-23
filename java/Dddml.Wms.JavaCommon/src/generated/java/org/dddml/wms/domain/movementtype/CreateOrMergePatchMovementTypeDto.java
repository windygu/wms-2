package org.dddml.wms.domain.movementtype;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchMovementTypeDto extends AbstractMovementTypeCommandDto
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

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved()
    {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed)
    {
        this.isPropertyActiveRemoved = removed;
    }

    public MovementTypeCommand toCommand()
    {
        if (getCommandType() == null) {
            setCommandType(COMMAND_TYPE_MERGE_PATCH);
        }
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            return toCreateMovementType();
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            return toMergePatchMovementType();
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    protected MovementTypeCommand.CreateMovementType toCreateMovementType() {
        return new MovementTypeCommand.CreateMovementType() {
            @Override
            public String getMovementTypeId() {
                return CreateOrMergePatchMovementTypeDto.this.getMovementTypeId();
            }

            @Override
            public void setMovementTypeId(String p) {
                CreateOrMergePatchMovementTypeDto.this.setMovementTypeId(p);
            }

            @Override
            public Long getVersion() {
                return CreateOrMergePatchMovementTypeDto.this.getVersion();
            }

            @Override
            public void setVersion(Long p) {
                CreateOrMergePatchMovementTypeDto.this.setVersion(p);
            }

            @Override
            public String getCommandType() {
                return CreateOrMergePatchMovementTypeDto.this.getCommandType();
            }

            @Override
            public void setCommandType(String commandType) {
                 CreateOrMergePatchMovementTypeDto.this.setCommandType(commandType);
            }

            @Override
            public String getCommandId() {
                return CreateOrMergePatchMovementTypeDto.this.getCommandId();
            }

            @Override
            public void setCommandId(String commandId) {
                CreateOrMergePatchMovementTypeDto.this.setCommandId(commandId);
            }

            @Override
            public String getRequesterId() {
                return CreateOrMergePatchMovementTypeDto.this.getRequesterId();
            }

            @Override
            public void setRequesterId(String requesterId) {
                CreateOrMergePatchMovementTypeDto.this.setRequesterId(requesterId);
            }

            @Override
            public String getDescription() {
                return CreateOrMergePatchMovementTypeDto.this.getDescription();
            }

            @Override
            public void setDescription(String p) {
                CreateOrMergePatchMovementTypeDto.this.setDescription(p);
            }

            @Override
            public Boolean getActive() {
                return CreateOrMergePatchMovementTypeDto.this.getActive();
            }

            @Override
            public void setActive(Boolean p) {
                CreateOrMergePatchMovementTypeDto.this.setActive(p);
            }


        };
    }

    protected MovementTypeCommand.MergePatchMovementType toMergePatchMovementType() {
        return new MovementTypeCommand.MergePatchMovementType() {
            @Override
            public String getMovementTypeId() {
                return CreateOrMergePatchMovementTypeDto.this.getMovementTypeId();
            }

            @Override
            public void setMovementTypeId(String p) {
                CreateOrMergePatchMovementTypeDto.this.setMovementTypeId(p);
            }

            @Override
            public Long getVersion() {
                return CreateOrMergePatchMovementTypeDto.this.getVersion();
            }

            @Override
            public void setVersion(Long p) {
                CreateOrMergePatchMovementTypeDto.this.setVersion(p);
            }

            @Override
            public String getCommandType() {
                return CreateOrMergePatchMovementTypeDto.this.getCommandType();
            }

            @Override
            public void setCommandType(String commandType) {
                 CreateOrMergePatchMovementTypeDto.this.setCommandType(commandType);
            }

            @Override
            public String getCommandId() {
                return CreateOrMergePatchMovementTypeDto.this.getCommandId();
            }

            @Override
            public void setCommandId(String commandId) {
                CreateOrMergePatchMovementTypeDto.this.setCommandId(commandId);
            }

            @Override
            public String getRequesterId() {
                return CreateOrMergePatchMovementTypeDto.this.getRequesterId();
            }

            @Override
            public void setRequesterId(String requesterId) {
                CreateOrMergePatchMovementTypeDto.this.setRequesterId(requesterId);
            }

            @Override
            public String getDescription() {
                return CreateOrMergePatchMovementTypeDto.this.getDescription();
            }

            @Override
            public void setDescription(String p) {
                CreateOrMergePatchMovementTypeDto.this.setDescription(p);
            }

            @Override
            public Boolean getActive() {
                return CreateOrMergePatchMovementTypeDto.this.getActive();
            }

            @Override
            public void setActive(Boolean p) {
                CreateOrMergePatchMovementTypeDto.this.setActive(p);
            }

            @Override
            public Boolean getIsPropertyDescriptionRemoved() {
                return CreateOrMergePatchMovementTypeDto.this.getIsPropertyDescriptionRemoved();
            }

            @Override
            public void setIsPropertyDescriptionRemoved(Boolean removed) {
                CreateOrMergePatchMovementTypeDto.this.setIsPropertyDescriptionRemoved(removed);
            }

            @Override
            public Boolean getIsPropertyActiveRemoved() {
                return CreateOrMergePatchMovementTypeDto.this.getIsPropertyActiveRemoved();
            }

            @Override
            public void setIsPropertyActiveRemoved(Boolean removed) {
                CreateOrMergePatchMovementTypeDto.this.setIsPropertyActiveRemoved(removed);
            }


        };
    }

    public static class CreateMovementTypeDto extends CreateOrMergePatchMovementTypeDto
    {
        public CreateMovementTypeDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public MovementTypeCommand.CreateMovementType toCreateMovementType()
        {
            return super.toCreateMovementType();
        }

    }

    public static class MergePatchMovementTypeDto extends CreateOrMergePatchMovementTypeDto
    {
        public MergePatchMovementTypeDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public MovementTypeCommand.MergePatchMovementType toMergePatchMovementType()
        {
            return super.toMergePatchMovementType();
        }

    }

}

