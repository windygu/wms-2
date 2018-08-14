package org.dddml.wms.domain.inout;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public class InOutCommands
{
    private InOutCommands() {
    }

    public static class Complete implements InOutCommand {

        public String getCommandType() {
            return "Complete";
        }

        public void setCommandType(String commandType) {
            //do nothing
        }

        /**
         * Document Number
         */
        private String documentNumber;

        public String getDocumentNumber() {
            return this.documentNumber;
        }

        public void setDocumentNumber(String documentNumber) {
            this.documentNumber = documentNumber;
        }

        /**
         * Version
         */
        private Long version;

        public Long getVersion() {
            return this.version;
        }

        public void setVersion(Long version) {
            this.version = version;
        }

        /**
         * Command Id
         */
        private String commandId;

        public String getCommandId() {
            return this.commandId;
        }

        public void setCommandId(String commandId) {
            this.commandId = commandId;
        }

        /**
         * Requester Id
         */
        private String requesterId;

        public String getRequesterId() {
            return this.requesterId;
        }

        public void setRequesterId(String requesterId) {
            this.requesterId = requesterId;
        }

    }

    public static class Close implements InOutCommand {

        public String getCommandType() {
            return "Close";
        }

        public void setCommandType(String commandType) {
            //do nothing
        }

        /**
         * Document Number
         */
        private String documentNumber;

        public String getDocumentNumber() {
            return this.documentNumber;
        }

        public void setDocumentNumber(String documentNumber) {
            this.documentNumber = documentNumber;
        }

        /**
         * Version
         */
        private Long version;

        public Long getVersion() {
            return this.version;
        }

        public void setVersion(Long version) {
            this.version = version;
        }

        /**
         * Command Id
         */
        private String commandId;

        public String getCommandId() {
            return this.commandId;
        }

        public void setCommandId(String commandId) {
            this.commandId = commandId;
        }

        /**
         * Requester Id
         */
        private String requesterId;

        public String getRequesterId() {
            return this.requesterId;
        }

        public void setRequesterId(String requesterId) {
            this.requesterId = requesterId;
        }

    }

    public static class Void implements InOutCommand {

        public String getCommandType() {
            return "Void";
        }

        public void setCommandType(String commandType) {
            //do nothing
        }

        /**
         * Document Number
         */
        private String documentNumber;

        public String getDocumentNumber() {
            return this.documentNumber;
        }

        public void setDocumentNumber(String documentNumber) {
            this.documentNumber = documentNumber;
        }

        /**
         * Version
         */
        private Long version;

        public Long getVersion() {
            return this.version;
        }

        public void setVersion(Long version) {
            this.version = version;
        }

        /**
         * Command Id
         */
        private String commandId;

        public String getCommandId() {
            return this.commandId;
        }

        public void setCommandId(String commandId) {
            this.commandId = commandId;
        }

        /**
         * Requester Id
         */
        private String requesterId;

        public String getRequesterId() {
            return this.requesterId;
        }

        public void setRequesterId(String requesterId) {
            this.requesterId = requesterId;
        }

    }

    public static class Reverse implements InOutCommand {

        public String getCommandType() {
            return "Reverse";
        }

        public void setCommandType(String commandType) {
            //do nothing
        }

        /**
         * Document Number
         */
        private String documentNumber;

        public String getDocumentNumber() {
            return this.documentNumber;
        }

        public void setDocumentNumber(String documentNumber) {
            this.documentNumber = documentNumber;
        }

        /**
         * Version
         */
        private Long version;

        public Long getVersion() {
            return this.version;
        }

        public void setVersion(Long version) {
            this.version = version;
        }

        /**
         * Command Id
         */
        private String commandId;

        public String getCommandId() {
            return this.commandId;
        }

        public void setCommandId(String commandId) {
            this.commandId = commandId;
        }

        /**
         * Requester Id
         */
        private String requesterId;

        public String getRequesterId() {
            return this.requesterId;
        }

        public void setRequesterId(String requesterId) {
            this.requesterId = requesterId;
        }

    }

    public static class AddLine implements InOutCommand {

        public String getCommandType() {
            return "AddLine";
        }

        public void setCommandType(String commandType) {
            //do nothing
        }

        /**
         * Line Number
         */
        private String lineNumber;

        public String getLineNumber() {
            return this.lineNumber;
        }

        public void setLineNumber(String lineNumber) {
            this.lineNumber = lineNumber;
        }

        /**
         * Locator Id
         */
        private String locatorId;

        public String getLocatorId() {
            return this.locatorId;
        }

        public void setLocatorId(String locatorId) {
            this.locatorId = locatorId;
        }

        /**
         * Product Id
         */
        private String productId;

        public String getProductId() {
            return this.productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        /**
         * Attribute Set Instance
         */
        private java.util.Map<String, Object> attributeSetInstance;

        public java.util.Map<String, Object> getAttributeSetInstance() {
            return this.attributeSetInstance;
        }

        public void setAttributeSetInstance(java.util.Map<String, Object> attributeSetInstance) {
            this.attributeSetInstance = attributeSetInstance;
        }

        /**
         * Damage Status Ids
         */
        private List<String> damageStatusIds;

        public List<String> getDamageStatusIds() {
            return this.damageStatusIds;
        }

        public void setDamageStatusIds(List<String> damageStatusIds) {
            this.damageStatusIds = damageStatusIds;
        }

        /**
         * Description
         */
        private String description;

        public String getDescription() {
            return this.description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        /**
         * Quantity Uom Id
         */
        private String quantityUomId;

        public String getQuantityUomId() {
            return this.quantityUomId;
        }

        public void setQuantityUomId(String quantityUomId) {
            this.quantityUomId = quantityUomId;
        }

        /**
         * Movement Quantity
         */
        private BigDecimal movementQuantity;

        public BigDecimal getMovementQuantity() {
            return this.movementQuantity;
        }

        public void setMovementQuantity(BigDecimal movementQuantity) {
            this.movementQuantity = movementQuantity;
        }

        /**
         * Document Number
         */
        private String documentNumber;

        public String getDocumentNumber() {
            return this.documentNumber;
        }

        public void setDocumentNumber(String documentNumber) {
            this.documentNumber = documentNumber;
        }

        /**
         * Version
         */
        private Long version;

        public Long getVersion() {
            return this.version;
        }

        public void setVersion(Long version) {
            this.version = version;
        }

        /**
         * Command Id
         */
        private String commandId;

        public String getCommandId() {
            return this.commandId;
        }

        public void setCommandId(String commandId) {
            this.commandId = commandId;
        }

        /**
         * Requester Id
         */
        private String requesterId;

        public String getRequesterId() {
            return this.requesterId;
        }

        public void setRequesterId(String requesterId) {
            this.requesterId = requesterId;
        }

    }

    public static class DocumentAction implements InOutCommand {

        public String getCommandType() {
            return "DocumentAction";
        }

        public void setCommandType(String commandType) {
            //do nothing
        }

        /**
         * Value
         */
        private String value;

        public String getValue() {
            return this.value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Document Number
         */
        private String documentNumber;

        public String getDocumentNumber() {
            return this.documentNumber;
        }

        public void setDocumentNumber(String documentNumber) {
            this.documentNumber = documentNumber;
        }

        /**
         * Version
         */
        private Long version;

        public Long getVersion() {
            return this.version;
        }

        public void setVersion(Long version) {
            this.version = version;
        }

        /**
         * Command Id
         */
        private String commandId;

        public String getCommandId() {
            return this.commandId;
        }

        public void setCommandId(String commandId) {
            this.commandId = commandId;
        }

        /**
         * Requester Id
         */
        private String requesterId;

        public String getRequesterId() {
            return this.requesterId;
        }

        public void setRequesterId(String requesterId) {
            this.requesterId = requesterId;
        }

    }

}

