package org.dddml.wms.domain.physicalinventory;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;

public class PhysicalInventoryCommandDtos
{
    private PhysicalInventoryCommandDtos() {
    }

    public static class DocumentActionRequestContent {

        public String getCommandType() {
            return "DocumentAction";
        }

        private String value;

        public String getValue() {
            return this.value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        private String documentNumber;

        public String getDocumentNumber() {
            return this.documentNumber;
        }

        public void setDocumentNumber(String documentNumber) {
            this.documentNumber = documentNumber;
        }

        private Long version;

        public Long getVersion() {
            return this.version;
        }

        public void setVersion(Long version) {
            this.version = version;
        }

        private String commandId;

        public String getCommandId() {
            return this.commandId;
        }

        public void setCommandId(String commandId) {
            this.commandId = commandId;
        }

        private String requesterId;

        public String getRequesterId() {
            return this.requesterId;
        }

        public void setRequesterId(String requesterId) {
            this.requesterId = requesterId;
        }

       public PhysicalInventoryCommands.DocumentAction toDocumentAction() {
            PhysicalInventoryCommands.DocumentAction cmd = new PhysicalInventoryCommands.DocumentAction();
            cmd.setValue(this.getValue());
            cmd.setDocumentNumber(this.getDocumentNumber());
            cmd.setVersion(this.getVersion());
            cmd.setCommandId(this.getCommandId());
            cmd.setRequesterId(this.getRequesterId());
            return cmd;
        }

    }

}

