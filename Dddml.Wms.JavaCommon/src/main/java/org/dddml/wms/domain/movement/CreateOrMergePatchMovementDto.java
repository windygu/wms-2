package org.dddml.wms.domain.movement;

import java.util.Date;
import java.math.BigDecimal;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchMovementDto extends AbstractMovementCommandDto
{
    private String documentTypeId;

    public String getDocumentTypeId()
    {
        return this.documentTypeId;
    }

    public void setDocumentTypeId(String documentTypeId)
    {
        this.documentTypeId = documentTypeId;
    }

    private String documentAction;

    public String getDocumentAction()
    {
        return this.documentAction;
    }

    public void setDocumentAction(String documentAction)
    {
        this.documentAction = documentAction;
    }

    private String movementTypeId;

    public String getMovementTypeId()
    {
        return this.movementTypeId;
    }

    public void setMovementTypeId(String movementTypeId)
    {
        this.movementTypeId = movementTypeId;
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

    private CreateOrMergePatchMovementLineDto[] movementLines;

    public CreateOrMergePatchMovementLineDto[] getMovementLines()
    {
        return this.movementLines;
    }

    public void setMovementLines(CreateOrMergePatchMovementLineDto[] movementLines)
    {
        this.movementLines = movementLines;
    }

    private CreateOrMergePatchMovementConfirmationLineDto[] movementConfirmationLines;

    public CreateOrMergePatchMovementConfirmationLineDto[] getMovementConfirmationLines()
    {
        return this.movementConfirmationLines;
    }

    public void setMovementConfirmationLines(CreateOrMergePatchMovementConfirmationLineDto[] movementConfirmationLines)
    {
        this.movementConfirmationLines = movementConfirmationLines;
    }

    private Boolean isPropertyDocumentTypeIdRemoved;

    public Boolean getIsPropertyDocumentTypeIdRemoved()
    {
        return this.isPropertyDocumentTypeIdRemoved;
    }

    public void setIsPropertyDocumentTypeIdRemoved(Boolean removed)
    {
        this.isPropertyDocumentTypeIdRemoved = removed;
    }

    private Boolean isPropertyMovementTypeIdRemoved;

    public Boolean getIsPropertyMovementTypeIdRemoved()
    {
        return this.isPropertyMovementTypeIdRemoved;
    }

    public void setIsPropertyMovementTypeIdRemoved(Boolean removed)
    {
        this.isPropertyMovementTypeIdRemoved = removed;
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

    public void copyTo(AbstractMovementCommand.AbstractCreateOrMergePatchMovement command)
    {
        ((AbstractMovementCommandDto) this).copyTo(command);
        command.setDocumentTypeId(this.getDocumentTypeId());
        command.setDocumentAction(this.getDocumentAction());
        command.setMovementTypeId(this.getMovementTypeId());
        command.setDescription(this.getDescription());
        command.setActive(this.getActive());
    }

    public MovementCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractMovementCommand.SimpleCreateMovement command = new AbstractMovementCommand.SimpleCreateMovement();
            copyTo((AbstractMovementCommand.AbstractCreateMovement) command);
            if (this.getMovementLines() != null) {
                for (CreateOrMergePatchMovementLineDto cmd : this.getMovementLines()) {
                    command.getMovementLines().add((MovementLineCommand.CreateMovementLine) cmd.toCommand());
                }
            }
            if (this.getMovementConfirmationLines() != null) {
                for (CreateOrMergePatchMovementConfirmationLineDto cmd : this.getMovementConfirmationLines()) {
                    command.getMovementConfirmationLines().add((MovementConfirmationLineCommand.CreateMovementConfirmationLine) cmd.toCommand());
                }
            }
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractMovementCommand.SimpleMergePatchMovement command = new AbstractMovementCommand.SimpleMergePatchMovement();
            copyTo((AbstractMovementCommand.SimpleMergePatchMovement) command);
            if (this.getMovementLines() != null) {
                for (CreateOrMergePatchMovementLineDto cmd : this.getMovementLines()) {
                    command.getMovementLineCommands().add(cmd.toCommand());
                }
            }
            if (this.getMovementConfirmationLines() != null) {
                for (CreateOrMergePatchMovementConfirmationLineDto cmd : this.getMovementConfirmationLines()) {
                    command.getMovementConfirmationLineCommands().add(cmd.toCommand());
                }
            }
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractMovementCommand.AbstractCreateMovement command)
    {
        copyTo((AbstractMovementCommand.AbstractCreateOrMergePatchMovement) command);
    }

    public void copyTo(AbstractMovementCommand.AbstractMergePatchMovement command)
    {
        copyTo((AbstractMovementCommand.AbstractCreateOrMergePatchMovement) command);
        command.setIsPropertyDocumentTypeIdRemoved(this.getIsPropertyDocumentTypeIdRemoved());
        command.setIsPropertyMovementTypeIdRemoved(this.getIsPropertyMovementTypeIdRemoved());
        command.setIsPropertyDescriptionRemoved(this.getIsPropertyDescriptionRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateMovementDto extends CreateOrMergePatchMovementDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public MovementCommand.CreateMovement toCreateMovement()
        {
            return (MovementCommand.CreateMovement) toCommand();
        }

    }

    public static class MergePatchMovementDto extends CreateOrMergePatchMovementDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public MovementCommand.MergePatchMovement toMergePatchMovement()
        {
            return (MovementCommand.MergePatchMovement) toCommand();
        }

    }

}

