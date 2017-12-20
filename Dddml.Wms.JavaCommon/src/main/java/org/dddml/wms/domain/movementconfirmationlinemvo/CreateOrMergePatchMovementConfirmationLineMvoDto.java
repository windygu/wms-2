package org.dddml.wms.domain.movementconfirmationlinemvo;

import org.dddml.wms.domain.movement.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchMovementConfirmationLineMvoDto extends AbstractMovementConfirmationLineMvoCommandDto
{
    private BigDecimal targetQuantity;

    public BigDecimal getTargetQuantity()
    {
        return this.targetQuantity;
    }

    public void setTargetQuantity(BigDecimal targetQuantity)
    {
        this.targetQuantity = targetQuantity;
    }

    private BigDecimal confirmedQuantity;

    public BigDecimal getConfirmedQuantity()
    {
        return this.confirmedQuantity;
    }

    public void setConfirmedQuantity(BigDecimal confirmedQuantity)
    {
        this.confirmedQuantity = confirmedQuantity;
    }

    private BigDecimal differenceQuantity;

    public BigDecimal getDifferenceQuantity()
    {
        return this.differenceQuantity;
    }

    public void setDifferenceQuantity(BigDecimal differenceQuantity)
    {
        this.differenceQuantity = differenceQuantity;
    }

    private BigDecimal scrappedQuantity;

    public BigDecimal getScrappedQuantity()
    {
        return this.scrappedQuantity;
    }

    public void setScrappedQuantity(BigDecimal scrappedQuantity)
    {
        this.scrappedQuantity = scrappedQuantity;
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

    private String movementDocumentTypeId;

    public String getMovementDocumentTypeId()
    {
        return this.movementDocumentTypeId;
    }

    public void setMovementDocumentTypeId(String movementDocumentTypeId)
    {
        this.movementDocumentTypeId = movementDocumentTypeId;
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

    private String movementMovementTypeId;

    public String getMovementMovementTypeId()
    {
        return this.movementMovementTypeId;
    }

    public void setMovementMovementTypeId(String movementMovementTypeId)
    {
        this.movementMovementTypeId = movementMovementTypeId;
    }

    private String movementDescription;

    public String getMovementDescription()
    {
        return this.movementDescription;
    }

    public void setMovementDescription(String movementDescription)
    {
        this.movementDescription = movementDescription;
    }

    private String movementCreatedBy;

    public String getMovementCreatedBy()
    {
        return this.movementCreatedBy;
    }

    public void setMovementCreatedBy(String movementCreatedBy)
    {
        this.movementCreatedBy = movementCreatedBy;
    }

    private Date movementCreatedAt;

    public Date getMovementCreatedAt()
    {
        return this.movementCreatedAt;
    }

    public void setMovementCreatedAt(Date movementCreatedAt)
    {
        this.movementCreatedAt = movementCreatedAt;
    }

    private String movementUpdatedBy;

    public String getMovementUpdatedBy()
    {
        return this.movementUpdatedBy;
    }

    public void setMovementUpdatedBy(String movementUpdatedBy)
    {
        this.movementUpdatedBy = movementUpdatedBy;
    }

    private Date movementUpdatedAt;

    public Date getMovementUpdatedAt()
    {
        return this.movementUpdatedAt;
    }

    public void setMovementUpdatedAt(Date movementUpdatedAt)
    {
        this.movementUpdatedAt = movementUpdatedAt;
    }

    private Boolean movementActive;

    public Boolean getMovementActive()
    {
        return this.movementActive;
    }

    public void setMovementActive(Boolean movementActive)
    {
        this.movementActive = movementActive;
    }

    private Boolean movementDeleted;

    public Boolean getMovementDeleted()
    {
        return this.movementDeleted;
    }

    public void setMovementDeleted(Boolean movementDeleted)
    {
        this.movementDeleted = movementDeleted;
    }

    private Boolean isPropertyTargetQuantityRemoved;

    public Boolean getIsPropertyTargetQuantityRemoved()
    {
        return this.isPropertyTargetQuantityRemoved;
    }

    public void setIsPropertyTargetQuantityRemoved(Boolean removed)
    {
        this.isPropertyTargetQuantityRemoved = removed;
    }

    private Boolean isPropertyConfirmedQuantityRemoved;

    public Boolean getIsPropertyConfirmedQuantityRemoved()
    {
        return this.isPropertyConfirmedQuantityRemoved;
    }

    public void setIsPropertyConfirmedQuantityRemoved(Boolean removed)
    {
        this.isPropertyConfirmedQuantityRemoved = removed;
    }

    private Boolean isPropertyDifferenceQuantityRemoved;

    public Boolean getIsPropertyDifferenceQuantityRemoved()
    {
        return this.isPropertyDifferenceQuantityRemoved;
    }

    public void setIsPropertyDifferenceQuantityRemoved(Boolean removed)
    {
        this.isPropertyDifferenceQuantityRemoved = removed;
    }

    private Boolean isPropertyScrappedQuantityRemoved;

    public Boolean getIsPropertyScrappedQuantityRemoved()
    {
        return this.isPropertyScrappedQuantityRemoved;
    }

    public void setIsPropertyScrappedQuantityRemoved(Boolean removed)
    {
        this.isPropertyScrappedQuantityRemoved = removed;
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

    private Boolean isPropertyMovementDocumentTypeIdRemoved;

    public Boolean getIsPropertyMovementDocumentTypeIdRemoved()
    {
        return this.isPropertyMovementDocumentTypeIdRemoved;
    }

    public void setIsPropertyMovementDocumentTypeIdRemoved(Boolean removed)
    {
        this.isPropertyMovementDocumentTypeIdRemoved = removed;
    }

    private Boolean isPropertyMovementMovementTypeIdRemoved;

    public Boolean getIsPropertyMovementMovementTypeIdRemoved()
    {
        return this.isPropertyMovementMovementTypeIdRemoved;
    }

    public void setIsPropertyMovementMovementTypeIdRemoved(Boolean removed)
    {
        this.isPropertyMovementMovementTypeIdRemoved = removed;
    }

    private Boolean isPropertyMovementDescriptionRemoved;

    public Boolean getIsPropertyMovementDescriptionRemoved()
    {
        return this.isPropertyMovementDescriptionRemoved;
    }

    public void setIsPropertyMovementDescriptionRemoved(Boolean removed)
    {
        this.isPropertyMovementDescriptionRemoved = removed;
    }

    private Boolean isPropertyMovementCreatedByRemoved;

    public Boolean getIsPropertyMovementCreatedByRemoved()
    {
        return this.isPropertyMovementCreatedByRemoved;
    }

    public void setIsPropertyMovementCreatedByRemoved(Boolean removed)
    {
        this.isPropertyMovementCreatedByRemoved = removed;
    }

    private Boolean isPropertyMovementCreatedAtRemoved;

    public Boolean getIsPropertyMovementCreatedAtRemoved()
    {
        return this.isPropertyMovementCreatedAtRemoved;
    }

    public void setIsPropertyMovementCreatedAtRemoved(Boolean removed)
    {
        this.isPropertyMovementCreatedAtRemoved = removed;
    }

    private Boolean isPropertyMovementUpdatedByRemoved;

    public Boolean getIsPropertyMovementUpdatedByRemoved()
    {
        return this.isPropertyMovementUpdatedByRemoved;
    }

    public void setIsPropertyMovementUpdatedByRemoved(Boolean removed)
    {
        this.isPropertyMovementUpdatedByRemoved = removed;
    }

    private Boolean isPropertyMovementUpdatedAtRemoved;

    public Boolean getIsPropertyMovementUpdatedAtRemoved()
    {
        return this.isPropertyMovementUpdatedAtRemoved;
    }

    public void setIsPropertyMovementUpdatedAtRemoved(Boolean removed)
    {
        this.isPropertyMovementUpdatedAtRemoved = removed;
    }

    private Boolean isPropertyMovementActiveRemoved;

    public Boolean getIsPropertyMovementActiveRemoved()
    {
        return this.isPropertyMovementActiveRemoved;
    }

    public void setIsPropertyMovementActiveRemoved(Boolean removed)
    {
        this.isPropertyMovementActiveRemoved = removed;
    }

    private Boolean isPropertyMovementDeletedRemoved;

    public Boolean getIsPropertyMovementDeletedRemoved()
    {
        return this.isPropertyMovementDeletedRemoved;
    }

    public void setIsPropertyMovementDeletedRemoved(Boolean removed)
    {
        this.isPropertyMovementDeletedRemoved = removed;
    }

    public void copyTo(AbstractMovementConfirmationLineMvoCommand.AbstractCreateOrMergePatchMovementConfirmationLineMvo command)
    {
        ((AbstractMovementConfirmationLineMvoCommandDto) this).copyTo(command);
        command.setTargetQuantity(this.getTargetQuantity());
        command.setConfirmedQuantity(this.getConfirmedQuantity());
        command.setDifferenceQuantity(this.getDifferenceQuantity());
        command.setScrappedQuantity(this.getScrappedQuantity());
        command.setVersion(this.getVersion());
        command.setActive(this.getActive());
        command.setMovementDocumentTypeId(this.getMovementDocumentTypeId());
        command.setDocumentAction(this.getDocumentAction());
        command.setMovementMovementTypeId(this.getMovementMovementTypeId());
        command.setMovementDescription(this.getMovementDescription());
        command.setMovementCreatedBy(this.getMovementCreatedBy());
        command.setMovementCreatedAt(this.getMovementCreatedAt());
        command.setMovementUpdatedBy(this.getMovementUpdatedBy());
        command.setMovementUpdatedAt(this.getMovementUpdatedAt());
        command.setMovementActive(this.getMovementActive());
        command.setMovementDeleted(this.getMovementDeleted());
    }

    public MovementConfirmationLineMvoCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractMovementConfirmationLineMvoCommand.SimpleCreateMovementConfirmationLineMvo command = new AbstractMovementConfirmationLineMvoCommand.SimpleCreateMovementConfirmationLineMvo();
            copyTo((AbstractMovementConfirmationLineMvoCommand.AbstractCreateMovementConfirmationLineMvo) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractMovementConfirmationLineMvoCommand.SimpleMergePatchMovementConfirmationLineMvo command = new AbstractMovementConfirmationLineMvoCommand.SimpleMergePatchMovementConfirmationLineMvo();
            copyTo((AbstractMovementConfirmationLineMvoCommand.SimpleMergePatchMovementConfirmationLineMvo) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractMovementConfirmationLineMvoCommand.AbstractCreateMovementConfirmationLineMvo command)
    {
        copyTo((AbstractMovementConfirmationLineMvoCommand.AbstractCreateOrMergePatchMovementConfirmationLineMvo) command);
    }

    public void copyTo(AbstractMovementConfirmationLineMvoCommand.AbstractMergePatchMovementConfirmationLineMvo command)
    {
        copyTo((AbstractMovementConfirmationLineMvoCommand.AbstractCreateOrMergePatchMovementConfirmationLineMvo) command);
        command.setIsPropertyTargetQuantityRemoved(this.getIsPropertyTargetQuantityRemoved());
        command.setIsPropertyConfirmedQuantityRemoved(this.getIsPropertyConfirmedQuantityRemoved());
        command.setIsPropertyDifferenceQuantityRemoved(this.getIsPropertyDifferenceQuantityRemoved());
        command.setIsPropertyScrappedQuantityRemoved(this.getIsPropertyScrappedQuantityRemoved());
        command.setIsPropertyVersionRemoved(this.getIsPropertyVersionRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
        command.setIsPropertyMovementDocumentTypeIdRemoved(this.getIsPropertyMovementDocumentTypeIdRemoved());
        command.setIsPropertyMovementMovementTypeIdRemoved(this.getIsPropertyMovementMovementTypeIdRemoved());
        command.setIsPropertyMovementDescriptionRemoved(this.getIsPropertyMovementDescriptionRemoved());
        command.setIsPropertyMovementCreatedByRemoved(this.getIsPropertyMovementCreatedByRemoved());
        command.setIsPropertyMovementCreatedAtRemoved(this.getIsPropertyMovementCreatedAtRemoved());
        command.setIsPropertyMovementUpdatedByRemoved(this.getIsPropertyMovementUpdatedByRemoved());
        command.setIsPropertyMovementUpdatedAtRemoved(this.getIsPropertyMovementUpdatedAtRemoved());
        command.setIsPropertyMovementActiveRemoved(this.getIsPropertyMovementActiveRemoved());
        command.setIsPropertyMovementDeletedRemoved(this.getIsPropertyMovementDeletedRemoved());
    }

    public static class CreateMovementConfirmationLineMvoDto extends CreateOrMergePatchMovementConfirmationLineMvoDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public MovementConfirmationLineMvoCommand.CreateMovementConfirmationLineMvo toCreateMovementConfirmationLineMvo()
        {
            return (MovementConfirmationLineMvoCommand.CreateMovementConfirmationLineMvo) toCommand();
        }

    }

    public static class MergePatchMovementConfirmationLineMvoDto extends CreateOrMergePatchMovementConfirmationLineMvoDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public MovementConfirmationLineMvoCommand.MergePatchMovementConfirmationLineMvo toMergePatchMovementConfirmationLineMvo()
        {
            return (MovementConfirmationLineMvoCommand.MergePatchMovementConfirmationLineMvo) toCommand();
        }

    }

}

