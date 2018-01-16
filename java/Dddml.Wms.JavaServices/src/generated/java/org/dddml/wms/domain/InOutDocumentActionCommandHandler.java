package org.dddml.wms.domain;

import org.dddml.wms.specialization.CommandType;
import org.dddml.wms.specialization.PropertyCommand;
import org.dddml.wms.specialization.PropertyCommandHandler;
import org.squirrelframework.foundation.fsm.StateMachineBuilder;
import org.squirrelframework.foundation.fsm.StateMachineBuilderFactory;
import org.squirrelframework.foundation.fsm.impl.AbstractStateMachine;

/**
 * Created by Yang on 2016/7/31.
 */
public class InOutDocumentActionCommandHandler implements PropertyCommandHandler<String, String>
{

    public static class DocumentStatusStateMachine extends AbstractStateMachine<DocumentStatusStateMachine, String, String, Object>
    {

    }

    public static StateMachineBuilder<DocumentStatusStateMachine, String, String, Object> documentStatusStateMachineBuilder;

    static
    {
        documentStatusStateMachineBuilder
                = StateMachineBuilderFactory.create(DocumentStatusStateMachine.class, String.class,String.class, Object.class);
        documentStatusStateMachineBuilder.externalTransition().from(DocumentStatusIds.INITIAL).to(DocumentStatusIds.DRAFTED).on(DocumentAction.DRAFT);
        documentStatusStateMachineBuilder.externalTransition().from(DocumentStatusIds.DRAFTED).to(DocumentStatusIds.COMPLETED).on(DocumentAction.COMPLETE);
        documentStatusStateMachineBuilder.externalTransition().from(DocumentStatusIds.DRAFTED).to(DocumentStatusIds.VOIDED).on(DocumentAction.VOID);
        documentStatusStateMachineBuilder.externalTransition().from(DocumentStatusIds.COMPLETED).to(DocumentStatusIds.CLOSED).on(DocumentAction.CLOSE);
        documentStatusStateMachineBuilder.externalTransition().from(DocumentStatusIds.COMPLETED).to(DocumentStatusIds.REVERSED).on(DocumentAction.REVERSE);

    }

    @Override
    public final void execute(PropertyCommand<String, String> command)
    {
        String currentState = command.getStateGetter().get();
        String trigger = command.getContent();

        if (command.getOuterCommandType().equals(CommandType.CREATE)) {
            if (currentState == null || currentState.trim().equals("")) {
                currentState = DocumentStatusIds.INITIAL;
            }
            if (trigger == null) {
                trigger = DocumentAction.DRAFT;
            }
        }
        DocumentStatusStateMachine stateMachine = documentStatusStateMachineBuilder.newStateMachine(currentState);
        stateMachine.fire(trigger);
        command.getStateSetter().accept(stateMachine.getCurrentState());
    }

}
