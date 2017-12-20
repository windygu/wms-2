package org.dddml.wms.domain.movementconfirmationlinemvo;

import java.util.*;
import org.dddml.wms.domain.movement.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractMovementConfirmationLineMvoStateCommandConverter<TCreateMovementConfirmationLineMvo extends MovementConfirmationLineMvoCommand.CreateMovementConfirmationLineMvo, TMergePatchMovementConfirmationLineMvo extends MovementConfirmationLineMvoCommand.MergePatchMovementConfirmationLineMvo, TDeleteMovementConfirmationLineMvo extends MovementConfirmationLineMvoCommand.DeleteMovementConfirmationLineMvo>
{
    public MovementConfirmationLineMvoCommand toCreateOrMergePatchMovementConfirmationLineMvo(MovementConfirmationLineMvoState state)
    {
        //where TCreateMovementConfirmationLineMvo : ICreateMovementConfirmationLineMvo, new()
        //where TMergePatchMovementConfirmationLineMvo : IMergePatchMovementConfirmationLineMvo, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateMovementConfirmationLineMvo(state);
        }
        else 
        {
            return toMergePatchMovementConfirmationLineMvo(state);
        }
    }

    public TDeleteMovementConfirmationLineMvo toDeleteMovementConfirmationLineMvo(MovementConfirmationLineMvoState state) //where TDeleteMovementConfirmationLineMvo : IDeleteMovementConfirmationLineMvo, new()
    {
        TDeleteMovementConfirmationLineMvo cmd = newDeleteMovementConfirmationLineMvo();
        cmd.setMovementConfirmationLineId(state.getMovementConfirmationLineId());
        cmd.setMovementVersion(state.getMovementVersion());

        return cmd;
    }

    public TMergePatchMovementConfirmationLineMvo toMergePatchMovementConfirmationLineMvo(MovementConfirmationLineMvoState state) //where TMergePatchMovementConfirmationLineMvo : IMergePatchMovementConfirmationLineMvo, new()
    {
        TMergePatchMovementConfirmationLineMvo cmd = newMergePatchMovementConfirmationLineMvo();

        cmd.setMovementVersion(state.getMovementVersion());

        cmd.setMovementConfirmationLineId(state.getMovementConfirmationLineId());
        cmd.setTargetQuantity(state.getTargetQuantity());
        cmd.setConfirmedQuantity(state.getConfirmedQuantity());
        cmd.setDifferenceQuantity(state.getDifferenceQuantity());
        cmd.setScrappedQuantity(state.getScrappedQuantity());
        cmd.setVersion(state.getVersion());
        cmd.setActive(state.getActive());
        cmd.setMovementDocumentTypeId(state.getMovementDocumentTypeId());
        cmd.setMovementMovementTypeId(state.getMovementMovementTypeId());
        cmd.setMovementDescription(state.getMovementDescription());
        cmd.setMovementCreatedBy(state.getMovementCreatedBy());
        cmd.setMovementCreatedAt(state.getMovementCreatedAt());
        cmd.setMovementUpdatedBy(state.getMovementUpdatedBy());
        cmd.setMovementUpdatedAt(state.getMovementUpdatedAt());
        cmd.setMovementActive(state.getMovementActive());
        cmd.setMovementDeleted(state.getMovementDeleted());
            
        if (state.getTargetQuantity() == null) { cmd.setIsPropertyTargetQuantityRemoved(true); }
        if (state.getConfirmedQuantity() == null) { cmd.setIsPropertyConfirmedQuantityRemoved(true); }
        if (state.getDifferenceQuantity() == null) { cmd.setIsPropertyDifferenceQuantityRemoved(true); }
        if (state.getScrappedQuantity() == null) { cmd.setIsPropertyScrappedQuantityRemoved(true); }
        if (state.getVersion() == null) { cmd.setIsPropertyVersionRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        if (state.getMovementDocumentTypeId() == null) { cmd.setIsPropertyMovementDocumentTypeIdRemoved(true); }
        if (state.getMovementMovementTypeId() == null) { cmd.setIsPropertyMovementMovementTypeIdRemoved(true); }
        if (state.getMovementDescription() == null) { cmd.setIsPropertyMovementDescriptionRemoved(true); }
        if (state.getMovementCreatedBy() == null) { cmd.setIsPropertyMovementCreatedByRemoved(true); }
        if (state.getMovementCreatedAt() == null) { cmd.setIsPropertyMovementCreatedAtRemoved(true); }
        if (state.getMovementUpdatedBy() == null) { cmd.setIsPropertyMovementUpdatedByRemoved(true); }
        if (state.getMovementUpdatedAt() == null) { cmd.setIsPropertyMovementUpdatedAtRemoved(true); }
        if (state.getMovementActive() == null) { cmd.setIsPropertyMovementActiveRemoved(true); }
        if (state.getMovementDeleted() == null) { cmd.setIsPropertyMovementDeletedRemoved(true); }
        return cmd;
    }

    public TCreateMovementConfirmationLineMvo toCreateMovementConfirmationLineMvo(MovementConfirmationLineMvoState state) //where TCreateMovementConfirmationLineMvo : ICreateMovementConfirmationLineMvo, new()
    {
        TCreateMovementConfirmationLineMvo cmd = newCreateMovementConfirmationLineMvo();

        cmd.setMovementVersion(state.getMovementVersion());
        cmd.setMovementConfirmationLineId(state.getMovementConfirmationLineId());
        cmd.setTargetQuantity(state.getTargetQuantity());
        cmd.setConfirmedQuantity(state.getConfirmedQuantity());
        cmd.setDifferenceQuantity(state.getDifferenceQuantity());
        cmd.setScrappedQuantity(state.getScrappedQuantity());
        cmd.setVersion(state.getVersion());
        cmd.setActive(state.getActive());
        cmd.setMovementDocumentTypeId(state.getMovementDocumentTypeId());
        cmd.setMovementMovementTypeId(state.getMovementMovementTypeId());
        cmd.setMovementDescription(state.getMovementDescription());
        cmd.setMovementCreatedBy(state.getMovementCreatedBy());
        cmd.setMovementCreatedAt(state.getMovementCreatedAt());
        cmd.setMovementUpdatedBy(state.getMovementUpdatedBy());
        cmd.setMovementUpdatedAt(state.getMovementUpdatedAt());
        cmd.setMovementActive(state.getMovementActive());
        cmd.setMovementDeleted(state.getMovementDeleted());
        return cmd;
    }

    protected abstract TCreateMovementConfirmationLineMvo newCreateMovementConfirmationLineMvo();

    protected abstract TMergePatchMovementConfirmationLineMvo newMergePatchMovementConfirmationLineMvo(); 

    protected abstract TDeleteMovementConfirmationLineMvo newDeleteMovementConfirmationLineMvo();

    public static class SimpleMovementConfirmationLineMvoStateCommandConverter extends AbstractMovementConfirmationLineMvoStateCommandConverter<AbstractMovementConfirmationLineMvoCommand.SimpleCreateMovementConfirmationLineMvo, AbstractMovementConfirmationLineMvoCommand.SimpleMergePatchMovementConfirmationLineMvo, AbstractMovementConfirmationLineMvoCommand.SimpleDeleteMovementConfirmationLineMvo>
    {
        @Override
        protected AbstractMovementConfirmationLineMvoCommand.SimpleCreateMovementConfirmationLineMvo newCreateMovementConfirmationLineMvo() {
            return new AbstractMovementConfirmationLineMvoCommand.SimpleCreateMovementConfirmationLineMvo();
        }

        @Override
        protected AbstractMovementConfirmationLineMvoCommand.SimpleMergePatchMovementConfirmationLineMvo newMergePatchMovementConfirmationLineMvo() {
            return new AbstractMovementConfirmationLineMvoCommand.SimpleMergePatchMovementConfirmationLineMvo();
        }

        @Override
        protected AbstractMovementConfirmationLineMvoCommand.SimpleDeleteMovementConfirmationLineMvo newDeleteMovementConfirmationLineMvo() {
            return new AbstractMovementConfirmationLineMvoCommand.SimpleDeleteMovementConfirmationLineMvo();
        }


    }

}

