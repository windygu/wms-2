package org.dddml.wms.restful.resource;

import java.util.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.meta.*;


@RestController
public class StateMachineMetadataResource {

    private static List<StateMachine> stateMachines;

    static {
        List<StateMachine> sms = new ArrayList<>();
        StateMachine sm = null;
        StateMachine.Transition t = null;

        // ///////////////  state machine start.  //////////////////
        sm = new StateMachine();
        sm.setEntityPath("InOuts/{documentNumber}");
        sm.setPropertyName("documentStatusId");
        sm.setCommandName("DocumentAction");
        sm.setTransitions(new ArrayList<>());

        t = new StateMachine.Transition();
        t.setSourceState(null);
        t.setTrigger(null);
        t.setTargetState("Drafted");
        sm.getTransitions().add(t);

        t = new StateMachine.Transition();
        t.setSourceState("Drafted");
        t.setTrigger("Complete");
        t.setTargetState("Completed");
        sm.getTransitions().add(t);

        t = new StateMachine.Transition();
        t.setSourceState("Drafted");
        t.setTrigger("Void");
        t.setTargetState("Voided");
        sm.getTransitions().add(t);

        t = new StateMachine.Transition();
        t.setSourceState("Completed");
        t.setTrigger("Close");
        t.setTargetState("Closed");
        sm.getTransitions().add(t);

        t = new StateMachine.Transition();
        t.setSourceState("Completed");
        t.setTrigger("Reverse");
        t.setTargetState("Reversed");
        sm.getTransitions().add(t);

        sms.add(sm);
        // ///////////////  state machine end.  //////////////////

        // ///////////////  state machine start.  //////////////////
        sm = new StateMachine();
        sm.setEntityPath("InOutNotices/{inOutNoticeId}");
        sm.setPropertyName("statusId");
        sm.setCommandName("InOutNoticeAction");
        sm.setTransitions(new ArrayList<>());

        t = new StateMachine.Transition();
        t.setSourceState(null);
        t.setTrigger(null);
        t.setTargetState("NOTICE_CREATED");
        sm.getTransitions().add(t);

        t = new StateMachine.Transition();
        t.setSourceState("NOTICE_CREATED");
        t.setTrigger("Approve");
        t.setTargetState("NOTICE_APPROVED");
        sm.getTransitions().add(t);

        t = new StateMachine.Transition();
        t.setSourceState("NOTICE_APPROVED");
        t.setTrigger("Complete");
        t.setTargetState("NOTICE_COMPLETED");
        sm.getTransitions().add(t);

        t = new StateMachine.Transition();
        t.setSourceState("NOTICE_CREATED");
        t.setTrigger("Reject");
        t.setTargetState("NOTICE_REJECTED");
        sm.getTransitions().add(t);

        t = new StateMachine.Transition();
        t.setSourceState("NOTICE_CREATED");
        t.setTrigger("Cancel");
        t.setTargetState("NOTICE_CANCELLED");
        sm.getTransitions().add(t);

        sms.add(sm);
        // ///////////////  state machine end.  //////////////////

        // ///////////////  state machine start.  //////////////////
        sm = new StateMachine();
        sm.setEntityPath("Movements/{documentNumber}");
        sm.setPropertyName("documentStatusId");
        sm.setCommandName("DocumentAction");
        sm.setTransitions(new ArrayList<>());

        t = new StateMachine.Transition();
        t.setSourceState(null);
        t.setTrigger(null);
        t.setTargetState("Drafted");
        sm.getTransitions().add(t);

        t = new StateMachine.Transition();
        t.setSourceState("Drafted");
        t.setTrigger("Void");
        t.setTargetState("Voided");
        sm.getTransitions().add(t);

        t = new StateMachine.Transition();
        t.setSourceState("Drafted");
        t.setTrigger("Complete");
        t.setTargetState("Completed");
        t.setGuard("{this}.getIsInTransit() == false");
        sm.getTransitions().add(t);

        t = new StateMachine.Transition();
        t.setSourceState("Drafted");
        t.setTrigger("Complete");
        t.setTargetState("InProgress");
        t.setGuard("{this}.getIsInTransit() == true");
        sm.getTransitions().add(t);

        t = new StateMachine.Transition();
        t.setSourceState("InProgress");
        t.setTrigger("Confirm");
        t.setTargetState("Complete");
        sm.getTransitions().add(t);

        t = new StateMachine.Transition();
        t.setSourceState("Completed");
        t.setTrigger("Close");
        t.setTargetState("Closed");
        sm.getTransitions().add(t);

        t = new StateMachine.Transition();
        t.setSourceState("Completed");
        t.setTrigger("Reverse");
        t.setTargetState("Reversed");
        t.setGuard("{this}.getIsInTransit() == false");
        sm.getTransitions().add(t);

        sms.add(sm);
        // ///////////////  state machine end.  //////////////////

        // ///////////////  state machine start.  //////////////////
        sm = new StateMachine();
        sm.setEntityPath("MovementConfirmations/{documentNumber}");
        sm.setPropertyName("documentStatusId");
        sm.setCommandName("DocumentAction");
        sm.setTransitions(new ArrayList<>());

        t = new StateMachine.Transition();
        t.setSourceState(null);
        t.setTrigger(null);
        t.setTargetState("InProgress");
        sm.getTransitions().add(t);

        t = new StateMachine.Transition();
        t.setSourceState("InProgress");
        t.setTrigger("Confirm");
        t.setTargetState("Completed");
        sm.getTransitions().add(t);

        t = new StateMachine.Transition();
        t.setSourceState("Completed");
        t.setTrigger("Close");
        t.setTargetState("Closed");
        sm.getTransitions().add(t);

        sms.add(sm);
        // ///////////////  state machine end.  //////////////////

        // ///////////////  state machine start.  //////////////////
        sm = new StateMachine();
        sm.setEntityPath("Orders/{orderId}/OrderShipGroups/{shipGroupSeqId}");
        sm.setPropertyName("orderShipGroupStatusId");
        sm.setCommandName("OrderShipGroupAction");
        sm.setTransitions(new ArrayList<>());

        t = new StateMachine.Transition();
        t.setSourceState(null);
        t.setTrigger(null);
        t.setTargetState("SHIP_GRP_CREATED");
        sm.getTransitions().add(t);

        t = new StateMachine.Transition();
        t.setSourceState("SHIP_GRP_CREATED");
        t.setTrigger("Approve");
        t.setTargetState("SHIP_GRP_APPROVED");
        sm.getTransitions().add(t);

        t = new StateMachine.Transition();
        t.setSourceState("SHIP_GRP_APPROVED");
        t.setTrigger("Complete");
        t.setTargetState("SHIP_GRP_COMPLETED");
        sm.getTransitions().add(t);

        t = new StateMachine.Transition();
        t.setSourceState("SHIP_GRP_CREATED");
        t.setTrigger("Reject");
        t.setTargetState("SHIP_GRP_REJECTED");
        sm.getTransitions().add(t);

        t = new StateMachine.Transition();
        t.setSourceState("SHIP_GRP_CREATED");
        t.setTrigger("Cancel");
        t.setTargetState("SHIP_GRP_CANCELLED");
        sm.getTransitions().add(t);

        sms.add(sm);
        // ///////////////  state machine end.  //////////////////

        // ///////////////  state machine start.  //////////////////
        sm = new StateMachine();
        sm.setEntityPath("PhysicalInventories/{documentNumber}");
        sm.setPropertyName("documentStatusId");
        sm.setCommandName("DocumentAction");
        sm.setTransitions(new ArrayList<>());

        t = new StateMachine.Transition();
        t.setSourceState(null);
        t.setTrigger(null);
        t.setTargetState("Drafted");
        sm.getTransitions().add(t);

        t = new StateMachine.Transition();
        t.setSourceState("Drafted");
        t.setTrigger("Complete");
        t.setTargetState("Completed");
        sm.getTransitions().add(t);

        t = new StateMachine.Transition();
        t.setSourceState("Drafted");
        t.setTrigger("Void");
        t.setTargetState("Voided");
        sm.getTransitions().add(t);

        t = new StateMachine.Transition();
        t.setSourceState("Completed");
        t.setTrigger("Close");
        t.setTargetState("Closed");
        sm.getTransitions().add(t);

        t = new StateMachine.Transition();
        t.setSourceState("Completed");
        t.setTrigger("Reverse");
        t.setTargetState("Reversed");
        sm.getTransitions().add(t);

        sms.add(sm);
        // ///////////////  state machine end.  //////////////////

        // ///////////////  state machine start.  //////////////////
        sm = new StateMachine();
        sm.setEntityPath("PurchaseShipments/{shipmentId}");
        sm.setPropertyName("statusId");
        sm.setCommandName("PurchaseShipmentAction");
        sm.setTransitions(new ArrayList<>());

        t = new StateMachine.Transition();
        t.setSourceState(null);
        t.setTrigger(null);
        t.setTargetState("PURCH_SHIP_CREATED");
        sm.getTransitions().add(t);

        t = new StateMachine.Transition();
        t.setSourceState("PURCH_SHIP_CREATED");
        t.setTrigger("Ship");
        t.setTargetState("PURCH_SHIP_SHIPPED");
        sm.getTransitions().add(t);

        t = new StateMachine.Transition();
        t.setSourceState("PURCH_SHIP_SHIPPED");
        t.setTrigger("Receive");
        t.setTargetState("PURCH_SHIP_RECEIVED");
        sm.getTransitions().add(t);

        sms.add(sm);
        // ///////////////  state machine end.  //////////////////

        // ///////////////  state machine start.  //////////////////
        sm = new StateMachine();
        sm.setEntityPath("SalesShipments/{shipmentId}");
        sm.setPropertyName("statusId");
        sm.setCommandName("SalesShipmentAction");
        sm.setTransitions(new ArrayList<>());

        t = new StateMachine.Transition();
        t.setSourceState(null);
        t.setTrigger(null);
        t.setTargetState("SHIPMENT_INPUT");
        sm.getTransitions().add(t);

        t = new StateMachine.Transition();
        t.setSourceState("SHIPMENT_INPUT");
        t.setTrigger("Ship");
        t.setTargetState("SHIPMENT_SHIPPED");
        t.setGuard("!{this}.getIsScheduleNeeded()");
        sm.getTransitions().add(t);

        t = new StateMachine.Transition();
        t.setSourceState("SHIPMENT_INPUT");
        t.setTrigger("Schedule");
        t.setTargetState("SHIPMENT_SCHEDULED");
        sm.getTransitions().add(t);

        t = new StateMachine.Transition();
        t.setSourceState("SHIPMENT_INPUT");
        t.setTrigger("Cancel");
        t.setTargetState("SHIPMENT_CANCELLED");
        sm.getTransitions().add(t);

        t = new StateMachine.Transition();
        t.setSourceState("SHIPMENT_SCHEDULED");
        t.setTrigger("Cancel");
        t.setTargetState("SHIPMENT_CANCELLED");
        sm.getTransitions().add(t);

        t = new StateMachine.Transition();
        t.setSourceState("SHIPMENT_SCHEDULED");
        t.setTrigger("Ship");
        t.setTargetState("SHIPMENT_SHIPPED");
        sm.getTransitions().add(t);

        t = new StateMachine.Transition();
        t.setSourceState("SHIPMENT_SHIPPED");
        t.setTrigger("Deliver");
        t.setTargetState("SHIPMENT_DELIVERED");
        sm.getTransitions().add(t);

        t = new StateMachine.Transition();
        t.setSourceState("SHIPMENT_SHIPPED");
        t.setTrigger("Reverse");
        t.setTargetState("SHIPMENT_REVERSED");
        sm.getTransitions().add(t);

        sms.add(sm);
        // ///////////////  state machine end.  //////////////////

        stateMachines = sms;
    }

    @GetMapping("_metadata/stateMachines")
    public List<StateMachine> getStateMachineMetadata() {
        return stateMachines;
    }

    public static class StateMachine {

        private String entityPath;

        public String getEntityPath() {
            return entityPath;
        }

        public void setEntityPath(String entityPath) {
            this.entityPath = entityPath;
        }

        private String propertyName;

        public String getPropertyName() {
            return propertyName;
        }

        public void setPropertyName(String value) {
            propertyName = value;
        }

        private String commandName;

        public String getCommandName() {
            return commandName;
        }

        public void setCommandName(String commandName) {
            this.commandName = commandName;
        }

        private List<Transition> transitions;

        public List<Transition> getTransitions() {
            return transitions;
        }

        public void setTransitions(List<Transition> value) {
            transitions = value;
        }


        public static class Transition {
            /**
             * Source state.
             */
            private String sourceState;

            public String getSourceState() {
                return sourceState;
            }

            public void setSourceState(String value) {
                sourceState = value;
            }

            /**
             * Target state.
             */
            private String targetState;

            public String getTargetState() {
                return targetState;
            }

            public void setTargetState(String value) {
                targetState = value;
            }

            /**
             * Triggering event.
             */
            private String trigger;

            public String getTrigger() {
                return trigger;
            }

            public void setTrigger(String value) {
                trigger = value;
            }

            /**
             * Guard conditions.
             */
            private String guard;

            public String getGuard() {
                return guard;
            }

            public void setGuard(String value) {
                guard = value;
            }
        }

    }
}


