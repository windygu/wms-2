package org.dddml.wms.domain.inout;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public class InOutCommandDtos
{
    private InOutCommandDtos() {
    }

    public static class CompleteRequestContent extends org.dddml.wms.domain.AbstractCommand {

        public String getCommandType() {
            return "Complete";
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

    }

    public static class CloseRequestContent extends org.dddml.wms.domain.AbstractCommand {

        public String getCommandType() {
            return "Close";
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

    }

    public static class VoidRequestContent extends org.dddml.wms.domain.AbstractCommand {

        public String getCommandType() {
            return "Void";
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

    }

    public static class ReverseRequestContent extends org.dddml.wms.domain.AbstractCommand {

        public String getCommandType() {
            return "Reverse";
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

    }

    public static class AddLineRequestContent extends org.dddml.wms.domain.AbstractCommand {

        public String getCommandType() {
            return "AddLine";
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
        private String[] damageStatusIds;

        public String[] getDamageStatusIds() {
            return this.damageStatusIds;
        }

        public void setDamageStatusIds(String[] damageStatusIds) {
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

    }

    public static class ImportRequestContent extends org.dddml.wms.domain.AbstractCommand {

        public String getCommandType() {
            return "Import";
        }

        /**
         * Document Type Id
         */
        private String documentTypeId;

        public String getDocumentTypeId() {
            return this.documentTypeId;
        }

        public void setDocumentTypeId(String documentTypeId) {
            this.documentTypeId = documentTypeId;
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
         * Order Id
         */
        private String orderId;

        public String getOrderId() {
            return this.orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        /**
         * Date Ordered
         */
        private Date dateOrdered;

        public Date getDateOrdered() {
            return this.dateOrdered;
        }

        public void setDateOrdered(Date dateOrdered) {
            this.dateOrdered = dateOrdered;
        }

        /**
         * Movement Type Id
         */
        private String movementTypeId;

        public String getMovementTypeId() {
            return this.movementTypeId;
        }

        public void setMovementTypeId(String movementTypeId) {
            this.movementTypeId = movementTypeId;
        }

        /**
         * Movement Date
         */
        private Date movementDate;

        public Date getMovementDate() {
            return this.movementDate;
        }

        public void setMovementDate(Date movementDate) {
            this.movementDate = movementDate;
        }

        /**
         * Warehouse Id
         */
        private String warehouseId;

        public String getWarehouseId() {
            return this.warehouseId;
        }

        public void setWarehouseId(String warehouseId) {
            this.warehouseId = warehouseId;
        }

        /**
         * PO Reference
         */
        private String POReference;

        public String getPOReference() {
            return this.POReference;
        }

        public void setPOReference(String POReference) {
            this.POReference = POReference;
        }

        /**
         * Shipper Id
         */
        private String shipperId;

        public String getShipperId() {
            return this.shipperId;
        }

        public void setShipperId(String shipperId) {
            this.shipperId = shipperId;
        }

        /**
         * In Out Lines
         */
        private ImportingInOutLine[] inOutLines;

        public ImportingInOutLine[] getInOutLines() {
            return this.inOutLines;
        }

        public void setInOutLines(ImportingInOutLine[] inOutLines) {
            this.inOutLines = inOutLines;
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

    }

    public static class DocumentActionRequestContent extends org.dddml.wms.domain.AbstractCommand {

        public String getCommandType() {
            return "DocumentAction";
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

    }

}

