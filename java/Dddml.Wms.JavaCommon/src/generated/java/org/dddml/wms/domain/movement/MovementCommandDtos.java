package org.dddml.wms.domain.movement;

import java.util.*;
import java.util.Date;
import java.math.BigDecimal;
import org.dddml.wms.domain.*;

public class MovementCommandDtos
{
    private MovementCommandDtos() {
    }

    public static class AddLineRequestContent {

        public String getCommandType() {
            return "AddLine";
        }

        private String lineNumber;

        public String getLineNumber() {
            return this.lineNumber;
        }

        public void setLineNumber(String lineNumber) {
            this.lineNumber = lineNumber;
        }

        private String productId;

        public String getProductId() {
            return this.productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        private String locatorIdFrom;

        public String getLocatorIdFrom() {
            return this.locatorIdFrom;
        }

        public void setLocatorIdFrom(String locatorIdFrom) {
            this.locatorIdFrom = locatorIdFrom;
        }

        private String locatorIdTo;

        public String getLocatorIdTo() {
            return this.locatorIdTo;
        }

        public void setLocatorIdTo(String locatorIdTo) {
            this.locatorIdTo = locatorIdTo;
        }

        private java.util.Map<String, Object> attributeSetInstance;

        public java.util.Map<String, Object> getAttributeSetInstance() {
            return this.attributeSetInstance;
        }

        public void setAttributeSetInstance(java.util.Map<String, Object> attributeSetInstance) {
            this.attributeSetInstance = attributeSetInstance;
        }

        private String description;

        public String getDescription() {
            return this.description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        private String quantityUomId;

        public String getQuantityUomId() {
            return this.quantityUomId;
        }

        public void setQuantityUomId(String quantityUomId) {
            this.quantityUomId = quantityUomId;
        }

        private BigDecimal movementQuantity;

        public BigDecimal getMovementQuantity() {
            return this.movementQuantity;
        }

        public void setMovementQuantity(BigDecimal movementQuantity) {
            this.movementQuantity = movementQuantity;
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

       public MovementCommands.AddLine toAddLine() {
            MovementCommands.AddLine cmd = new MovementCommands.AddLine();
            cmd.setLineNumber(this.getLineNumber());
            cmd.setProductId(this.getProductId());
            cmd.setLocatorIdFrom(this.getLocatorIdFrom());
            cmd.setLocatorIdTo(this.getLocatorIdTo());
            cmd.setAttributeSetInstance(this.getAttributeSetInstance());
            cmd.setDescription(this.getDescription());
            cmd.setQuantityUomId(this.getQuantityUomId());
            cmd.setMovementQuantity(this.getMovementQuantity());
            cmd.setDocumentNumber(this.getDocumentNumber());
            cmd.setVersion(this.getVersion());
            cmd.setCommandId(this.getCommandId());
            cmd.setRequesterId(this.getRequesterId());
            return cmd;
        }

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

       public MovementCommands.DocumentAction toDocumentAction() {
            MovementCommands.DocumentAction cmd = new MovementCommands.DocumentAction();
            cmd.setValue(this.getValue());
            cmd.setDocumentNumber(this.getDocumentNumber());
            cmd.setVersion(this.getVersion());
            cmd.setCommandId(this.getCommandId());
            cmd.setRequesterId(this.getRequesterId());
            return cmd;
        }

    }

}

