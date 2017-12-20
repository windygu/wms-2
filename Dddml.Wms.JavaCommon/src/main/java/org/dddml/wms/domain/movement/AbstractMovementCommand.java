package org.dddml.wms.domain.movement;

import java.util.*;
import java.util.Date;
import java.math.BigDecimal;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractMovementCommand extends AbstractCommand implements MovementCommand
{
    private String documentNumber;

    public String getDocumentNumber()
    {
        return this.documentNumber;
    }

    public void setDocumentNumber(String documentNumber)
    {
        this.documentNumber = documentNumber;
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


    public static abstract class AbstractCreateOrMergePatchMovement extends AbstractMovementCommand implements CreateOrMergePatchMovement
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

        public MovementLineCommand.CreateMovementLine newCreateMovementLine()
        {
            AbstractMovementLineCommand.SimpleCreateMovementLine c = new AbstractMovementLineCommand.SimpleCreateMovementLine();
            c.setMovementDocumentNumber(this.getDocumentNumber());

            return c;
        }

        public MovementLineCommand.MergePatchMovementLine newMergePatchMovementLine()
        {
            AbstractMovementLineCommand.SimpleMergePatchMovementLine c = new AbstractMovementLineCommand.SimpleMergePatchMovementLine();
            c.setMovementDocumentNumber(this.getDocumentNumber());

            return c;
        }

        public MovementLineCommand.RemoveMovementLine newRemoveMovementLine()
        {
            AbstractMovementLineCommand.SimpleRemoveMovementLine c = new AbstractMovementLineCommand.SimpleRemoveMovementLine();
            c.setMovementDocumentNumber(this.getDocumentNumber());

            return c;
        }

        public MovementConfirmationLineCommand.CreateMovementConfirmationLine newCreateMovementConfirmationLine()
        {
            AbstractMovementConfirmationLineCommand.SimpleCreateMovementConfirmationLine c = new AbstractMovementConfirmationLineCommand.SimpleCreateMovementConfirmationLine();
            c.setMovementDocumentNumber(this.getDocumentNumber());

            return c;
        }

        public MovementConfirmationLineCommand.MergePatchMovementConfirmationLine newMergePatchMovementConfirmationLine()
        {
            AbstractMovementConfirmationLineCommand.SimpleMergePatchMovementConfirmationLine c = new AbstractMovementConfirmationLineCommand.SimpleMergePatchMovementConfirmationLine();
            c.setMovementDocumentNumber(this.getDocumentNumber());

            return c;
        }

        public MovementConfirmationLineCommand.RemoveMovementConfirmationLine newRemoveMovementConfirmationLine()
        {
            AbstractMovementConfirmationLineCommand.SimpleRemoveMovementConfirmationLine c = new AbstractMovementConfirmationLineCommand.SimpleRemoveMovementConfirmationLine();
            c.setMovementDocumentNumber(this.getDocumentNumber());

            return c;
        }

    }

    public static abstract class AbstractCreateMovement extends AbstractCreateOrMergePatchMovement implements CreateMovement
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

        private CreateMovementLineCommands movementLines = new SimpleCreateMovementLineCommands();

        public CreateMovementLineCommands getMovementLines()
        {
            return this.movementLines;
        }

        private CreateMovementConfirmationLineCommands movementConfirmationLines = new SimpleCreateMovementConfirmationLineCommands();

        public CreateMovementConfirmationLineCommands getMovementConfirmationLines()
        {
            return this.movementConfirmationLines;
        }

    }

    public static abstract class AbstractMergePatchMovement extends AbstractCreateOrMergePatchMovement implements MergePatchMovement
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
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

        private MovementLineCommands movementLineCommands = new SimpleMovementLineCommands();

        public MovementLineCommands getMovementLineCommands()
        {
            return this.movementLineCommands;
        }

        private MovementConfirmationLineCommands movementConfirmationLineCommands = new SimpleMovementConfirmationLineCommands();

        public MovementConfirmationLineCommands getMovementConfirmationLineCommands()
        {
            return this.movementConfirmationLineCommands;
        }

    }

    public static class SimpleCreateMovement extends AbstractCreateMovement
    {
    }

    
    public static class SimpleMergePatchMovement extends AbstractMergePatchMovement
    {
    }

    
	public static class SimpleDeleteMovement extends AbstractMovementCommand implements DeleteMovement
	{
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_DELETE;
        }
	}

    
    public static class SimpleCreateMovementLineCommands implements CreateMovementLineCommands
    {
        private List<MovementLineCommand.CreateMovementLine> innerCommands = new ArrayList<MovementLineCommand.CreateMovementLine>();

        public void add(MovementLineCommand.CreateMovementLine c)
        {
            innerCommands.add(c);
        }

        public void remove(MovementLineCommand.CreateMovementLine c)
        {
            innerCommands.remove(c);
        }

        public void clear()
        {
            innerCommands.clear();
        }

        @Override
        public Iterator<MovementLineCommand.CreateMovementLine> iterator()
        {
            return innerCommands.iterator();
        }
    }

    public static class SimpleMovementLineCommands implements MovementLineCommands
    {
        private List<MovementLineCommand> innerCommands = new ArrayList<MovementLineCommand>();

        public void add(MovementLineCommand c)
        {
            innerCommands.add(c);
        }

        public void remove(MovementLineCommand c)
        {
            innerCommands.remove(c);
        }

        public void clear()
        {
            innerCommands.clear();
        }

        @Override
        public Iterator<MovementLineCommand> iterator()
        {
            return innerCommands.iterator();
        }
    }

    public static class SimpleCreateMovementConfirmationLineCommands implements CreateMovementConfirmationLineCommands
    {
        private List<MovementConfirmationLineCommand.CreateMovementConfirmationLine> innerCommands = new ArrayList<MovementConfirmationLineCommand.CreateMovementConfirmationLine>();

        public void add(MovementConfirmationLineCommand.CreateMovementConfirmationLine c)
        {
            innerCommands.add(c);
        }

        public void remove(MovementConfirmationLineCommand.CreateMovementConfirmationLine c)
        {
            innerCommands.remove(c);
        }

        public void clear()
        {
            innerCommands.clear();
        }

        @Override
        public Iterator<MovementConfirmationLineCommand.CreateMovementConfirmationLine> iterator()
        {
            return innerCommands.iterator();
        }
    }

    public static class SimpleMovementConfirmationLineCommands implements MovementConfirmationLineCommands
    {
        private List<MovementConfirmationLineCommand> innerCommands = new ArrayList<MovementConfirmationLineCommand>();

        public void add(MovementConfirmationLineCommand c)
        {
            innerCommands.add(c);
        }

        public void remove(MovementConfirmationLineCommand c)
        {
            innerCommands.remove(c);
        }

        public void clear()
        {
            innerCommands.clear();
        }

        @Override
        public Iterator<MovementConfirmationLineCommand> iterator()
        {
            return innerCommands.iterator();
        }
    }


}

