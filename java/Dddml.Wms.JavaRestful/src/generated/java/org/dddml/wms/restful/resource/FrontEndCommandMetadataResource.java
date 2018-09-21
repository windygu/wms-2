package org.dddml.wms.restful.resource;

import java.util.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.meta.*;


@RestController
public class FrontEndCommandMetadataResource {


    private List<FrontEndCommand> frontEndCommands;

    public List<FrontEndCommand> getFrontEndCommands() {
        if(frontEndCommands != null) {
            return frontEndCommands;
        }

        List<FrontEndCommand> cmds = new ArrayList<>();
        FrontEndCommand cmd = null;
        FrontEndCommand.CommandInstance ci = null;
        Map<String, Object> precondition = null;

        // ///////////////  state machine start.  //////////////////
        cmd = new FrontEndCommand();
        cmd.setEntityPath("InOuts/{documentNumber}");
        cmd.setCommandPath("InOuts/{documentNumber}/_commands/DocumentAction");
        cmd.setCommandMethod("PUT");
        cmd.setCommandInstances(new ArrayList<>());

        ci = new FrontEndCommand.CommandInstance();
        ci.setValue("Complete");
        ci.setDisplayName("Complete");
        precondition = new HashMap<>();
        precondition.put("documentStatusId", "Drafted");
        ci.setPrecondition(precondition);
        cmd.getCommandInstances().add(ci);

        ci = new FrontEndCommand.CommandInstance();
        ci.setValue("Void");
        ci.setDisplayName("Void");
        precondition = new HashMap<>();
        precondition.put("documentStatusId", "Drafted");
        ci.setPrecondition(precondition);
        cmd.getCommandInstances().add(ci);

        ci = new FrontEndCommand.CommandInstance();
        ci.setValue("Close");
        ci.setDisplayName("Close");
        precondition = new HashMap<>();
        precondition.put("documentStatusId", "Completed");
        ci.setPrecondition(precondition);
        cmd.getCommandInstances().add(ci);

        ci = new FrontEndCommand.CommandInstance();
        ci.setValue("Reverse");
        ci.setDisplayName("Reverse");
        precondition = new HashMap<>();
        precondition.put("documentStatusId", "Completed");
        ci.setPrecondition(precondition);
        cmd.getCommandInstances().add(ci);

        cmds.add(cmd);
        // ///////////////  state machine end.  //////////////////

        // ///////////////  state machine start.  //////////////////
        cmd = new FrontEndCommand();
        cmd.setEntityPath("InOutNotices/{inOutNoticeId}");
        cmd.setCommandPath("InOutNotices/{inOutNoticeId}/_commands/InOutNoticeAction");
        cmd.setCommandMethod("PUT");
        cmd.setCommandInstances(new ArrayList<>());

        ci = new FrontEndCommand.CommandInstance();
        ci.setValue("Approve");
        ci.setDisplayName("Approve");
        precondition = new HashMap<>();
        precondition.put("statusId", "NOTICE_CREATED");
        ci.setPrecondition(precondition);
        cmd.getCommandInstances().add(ci);

        ci = new FrontEndCommand.CommandInstance();
        ci.setValue("Complete");
        ci.setDisplayName("Complete");
        precondition = new HashMap<>();
        precondition.put("statusId", "NOTICE_APPROVED");
        ci.setPrecondition(precondition);
        cmd.getCommandInstances().add(ci);

        ci = new FrontEndCommand.CommandInstance();
        ci.setValue("Reject");
        ci.setDisplayName("Reject");
        precondition = new HashMap<>();
        precondition.put("statusId", "NOTICE_CREATED");
        ci.setPrecondition(precondition);
        cmd.getCommandInstances().add(ci);

        ci = new FrontEndCommand.CommandInstance();
        ci.setValue("Cancel");
        ci.setDisplayName("Cancel");
        precondition = new HashMap<>();
        precondition.put("statusId", "NOTICE_CREATED");
        ci.setPrecondition(precondition);
        cmd.getCommandInstances().add(ci);

        cmds.add(cmd);
        // ///////////////  state machine end.  //////////////////

        // ///////////////  state machine start.  //////////////////
        cmd = new FrontEndCommand();
        cmd.setEntityPath("Movements/{documentNumber}");
        cmd.setCommandPath("Movements/{documentNumber}/_commands/DocumentAction");
        cmd.setCommandMethod("PUT");
        cmd.setCommandInstances(new ArrayList<>());

        ci = new FrontEndCommand.CommandInstance();
        ci.setValue("Void");
        ci.setDisplayName("Void");
        precondition = new HashMap<>();
        precondition.put("documentStatusId", "Drafted");
        ci.setPrecondition(precondition);
        cmd.getCommandInstances().add(ci);

        ci = new FrontEndCommand.CommandInstance();
        ci.setValue("Complete");
        ci.setDisplayName("Complete");
        precondition = new HashMap<>();
        precondition.put("documentStatusId", "Drafted");
        precondition.put("isInTransit", ApplicationContext.current.getTypeConverter().convertFromString(Boolean.class, "false"));
        ci.setPrecondition(precondition);
        cmd.getCommandInstances().add(ci);

        ci = new FrontEndCommand.CommandInstance();
        ci.setValue("Complete");
        ci.setDisplayName("Complete");
        precondition = new HashMap<>();
        precondition.put("documentStatusId", "Drafted");
        precondition.put("isInTransit", ApplicationContext.current.getTypeConverter().convertFromString(Boolean.class, "true"));
        ci.setPrecondition(precondition);
        cmd.getCommandInstances().add(ci);

        ci = new FrontEndCommand.CommandInstance();
        ci.setValue("Confirm");
        ci.setDisplayName("Confirm");
        precondition = new HashMap<>();
        precondition.put("documentStatusId", "InProgress");
        ci.setPrecondition(precondition);
        cmd.getCommandInstances().add(ci);

        ci = new FrontEndCommand.CommandInstance();
        ci.setValue("Close");
        ci.setDisplayName("Close");
        precondition = new HashMap<>();
        precondition.put("documentStatusId", "Completed");
        ci.setPrecondition(precondition);
        cmd.getCommandInstances().add(ci);

        ci = new FrontEndCommand.CommandInstance();
        ci.setValue("Reverse");
        ci.setDisplayName("Reverse");
        precondition = new HashMap<>();
        precondition.put("documentStatusId", "Completed");
        precondition.put("isInTransit", ApplicationContext.current.getTypeConverter().convertFromString(Boolean.class, "false"));
        ci.setPrecondition(precondition);
        cmd.getCommandInstances().add(ci);

        cmds.add(cmd);
        // ///////////////  state machine end.  //////////////////

        // ///////////////  state machine start.  //////////////////
        cmd = new FrontEndCommand();
        cmd.setEntityPath("MovementConfirmations/{documentNumber}");
        cmd.setCommandPath("MovementConfirmations/{documentNumber}/_commands/DocumentAction");
        cmd.setCommandMethod("PUT");
        cmd.setCommandInstances(new ArrayList<>());

        ci = new FrontEndCommand.CommandInstance();
        ci.setValue("Confirm");
        ci.setDisplayName("Confirm");
        precondition = new HashMap<>();
        precondition.put("documentStatusId", "InProgress");
        ci.setPrecondition(precondition);
        cmd.getCommandInstances().add(ci);

        ci = new FrontEndCommand.CommandInstance();
        ci.setValue("Close");
        ci.setDisplayName("Close");
        precondition = new HashMap<>();
        precondition.put("documentStatusId", "Completed");
        ci.setPrecondition(precondition);
        cmd.getCommandInstances().add(ci);

        cmds.add(cmd);
        // ///////////////  state machine end.  //////////////////

        // ///////////////  state machine start.  //////////////////
        cmd = new FrontEndCommand();
        cmd.setEntityPath("Orders/{orderId}/OrderShipGroups/{shipGroupSeqId}");
        cmd.setCommandPath("Orders/{orderId}/OrderShipGroups/{shipGroupSeqId}/_commands/OrderShipGroupAction");
        cmd.setCommandMethod("PUT");
        cmd.setCommandInstances(new ArrayList<>());

        ci = new FrontEndCommand.CommandInstance();
        ci.setValue("Approve");
        ci.setDisplayName("Approve");
        precondition = new HashMap<>();
        precondition.put("orderShipGroupStatusId", "SHIP_GRP_CREATED");
        ci.setPrecondition(precondition);
        cmd.getCommandInstances().add(ci);

        ci = new FrontEndCommand.CommandInstance();
        ci.setValue("Complete");
        ci.setDisplayName("Complete");
        precondition = new HashMap<>();
        precondition.put("orderShipGroupStatusId", "SHIP_GRP_APPROVED");
        ci.setPrecondition(precondition);
        cmd.getCommandInstances().add(ci);

        ci = new FrontEndCommand.CommandInstance();
        ci.setValue("Reject");
        ci.setDisplayName("Reject");
        precondition = new HashMap<>();
        precondition.put("orderShipGroupStatusId", "SHIP_GRP_CREATED");
        ci.setPrecondition(precondition);
        cmd.getCommandInstances().add(ci);

        ci = new FrontEndCommand.CommandInstance();
        ci.setValue("Cancel");
        ci.setDisplayName("Cancel");
        precondition = new HashMap<>();
        precondition.put("orderShipGroupStatusId", "SHIP_GRP_CREATED");
        ci.setPrecondition(precondition);
        cmd.getCommandInstances().add(ci);

        cmds.add(cmd);
        // ///////////////  state machine end.  //////////////////

        // ///////////////  state machine start.  //////////////////
        cmd = new FrontEndCommand();
        cmd.setEntityPath("PhysicalInventories/{documentNumber}");
        cmd.setCommandPath("PhysicalInventories/{documentNumber}/_commands/DocumentAction");
        cmd.setCommandMethod("PUT");
        cmd.setCommandInstances(new ArrayList<>());

        ci = new FrontEndCommand.CommandInstance();
        ci.setValue("Complete");
        ci.setDisplayName("Complete");
        precondition = new HashMap<>();
        precondition.put("documentStatusId", "Drafted");
        ci.setPrecondition(precondition);
        cmd.getCommandInstances().add(ci);

        ci = new FrontEndCommand.CommandInstance();
        ci.setValue("Void");
        ci.setDisplayName("Void");
        precondition = new HashMap<>();
        precondition.put("documentStatusId", "Drafted");
        ci.setPrecondition(precondition);
        cmd.getCommandInstances().add(ci);

        ci = new FrontEndCommand.CommandInstance();
        ci.setValue("Close");
        ci.setDisplayName("Close");
        precondition = new HashMap<>();
        precondition.put("documentStatusId", "Completed");
        ci.setPrecondition(precondition);
        cmd.getCommandInstances().add(ci);

        ci = new FrontEndCommand.CommandInstance();
        ci.setValue("Reverse");
        ci.setDisplayName("Reverse");
        precondition = new HashMap<>();
        precondition.put("documentStatusId", "Completed");
        ci.setPrecondition(precondition);
        cmd.getCommandInstances().add(ci);

        cmds.add(cmd);
        // ///////////////  state machine end.  //////////////////

        // ///////////////  state machine start.  //////////////////
        cmd = new FrontEndCommand();
        cmd.setEntityPath("PurchaseShipments/{shipmentId}");
        cmd.setCommandPath("PurchaseShipments/{shipmentId}/_commands/PurchaseShipmentAction");
        cmd.setCommandMethod("PUT");
        cmd.setCommandInstances(new ArrayList<>());

        ci = new FrontEndCommand.CommandInstance();
        ci.setValue("Ship");
        ci.setDisplayName("Ship");
        precondition = new HashMap<>();
        precondition.put("statusId", "PURCH_SHIP_CREATED");
        ci.setPrecondition(precondition);
        cmd.getCommandInstances().add(ci);

        ci = new FrontEndCommand.CommandInstance();
        ci.setValue("Receive");
        ci.setDisplayName("Receive");
        precondition = new HashMap<>();
        precondition.put("statusId", "PURCH_SHIP_SHIPPED");
        ci.setPrecondition(precondition);
        cmd.getCommandInstances().add(ci);

        cmds.add(cmd);
        // ///////////////  state machine end.  //////////////////

        // ///////////////  state machine start.  //////////////////
        cmd = new FrontEndCommand();
        cmd.setEntityPath("SalesShipments/{shipmentId}");
        cmd.setCommandPath("SalesShipments/{shipmentId}/_commands/SalesShipmentAction");
        cmd.setCommandMethod("PUT");
        cmd.setCommandInstances(new ArrayList<>());

        ci = new FrontEndCommand.CommandInstance();
        ci.setValue("Ship");
        ci.setDisplayName("Ship");
        precondition = new HashMap<>();
        precondition.put("statusId", "SHIPMENT_INPUT");
        precondition.put("isScheduleNeeded", ApplicationContext.current.getTypeConverter().convertFromString(Boolean.class, "false"));
        ci.setPrecondition(precondition);
        cmd.getCommandInstances().add(ci);

        ci = new FrontEndCommand.CommandInstance();
        ci.setValue("Schedule");
        ci.setDisplayName("Schedule");
        precondition = new HashMap<>();
        precondition.put("statusId", "SHIPMENT_INPUT");
        ci.setPrecondition(precondition);
        cmd.getCommandInstances().add(ci);

        ci = new FrontEndCommand.CommandInstance();
        ci.setValue("Cancel");
        ci.setDisplayName("Cancel");
        precondition = new HashMap<>();
        precondition.put("statusId", "SHIPMENT_INPUT");
        ci.setPrecondition(precondition);
        cmd.getCommandInstances().add(ci);

        ci = new FrontEndCommand.CommandInstance();
        ci.setValue("Cancel");
        ci.setDisplayName("Cancel");
        precondition = new HashMap<>();
        precondition.put("statusId", "SHIPMENT_SCHEDULED");
        ci.setPrecondition(precondition);
        cmd.getCommandInstances().add(ci);

        ci = new FrontEndCommand.CommandInstance();
        ci.setValue("Ship");
        ci.setDisplayName("Ship");
        precondition = new HashMap<>();
        precondition.put("statusId", "SHIPMENT_SCHEDULED");
        ci.setPrecondition(precondition);
        cmd.getCommandInstances().add(ci);

        ci = new FrontEndCommand.CommandInstance();
        ci.setValue("Deliver");
        ci.setDisplayName("Deliver");
        precondition = new HashMap<>();
        precondition.put("statusId", "SHIPMENT_SHIPPED");
        ci.setPrecondition(precondition);
        cmd.getCommandInstances().add(ci);

        ci = new FrontEndCommand.CommandInstance();
        ci.setValue("Reverse");
        ci.setDisplayName("Reverse");
        precondition = new HashMap<>();
        precondition.put("statusId", "SHIPMENT_SHIPPED");
        ci.setPrecondition(precondition);
        cmd.getCommandInstances().add(ci);

        cmds.add(cmd);
        // ///////////////  state machine end.  //////////////////


        frontEndCommands = cmds;
        return frontEndCommands;
    }

    @GetMapping("_metadata/frontEndCommands")
    public List<FrontEndCommand> getFrontEndCommandMetadata() {
        return getFrontEndCommands();
    }

    public static class FrontEndCommand {

        private String entityPath;
        private String commandPath;
        private String commandMethod;
        private List<CommandInstance> commandInstances;

        public String getEntityPath() {
            return entityPath;
        }

        public void setEntityPath(String entityPath) {
            this.entityPath = entityPath;
        }

        public String getCommandPath() {
            return commandPath;
        }

        public void setCommandPath(String commandPath) {
            this.commandPath = commandPath;
        }

        public String getCommandMethod() {
            return commandMethod;
        }

        public void setCommandMethod(String commandMethod) {
            this.commandMethod = commandMethod;
        }

        public List<CommandInstance> getCommandInstances() {
            return commandInstances;
        }

        public void setCommandInstances(List<CommandInstance> commandInstances) {
            this.commandInstances = commandInstances;
        }

        public static class CommandInstance {

            private Map<String, Object> precondition;
            private String value;
            private String displayName;

            public Map<String, Object> getPrecondition() {
                return precondition;
            }

            public void setPrecondition(Map<String, Object> precondition) {
                this.precondition = precondition;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public String getDisplayName() {
                return displayName;
            }

            public void setDisplayName(String displayName) {
                this.displayName = displayName;
            }
        }
   }

}


