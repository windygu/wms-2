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

    public static class CountItemRequestContent extends org.dddml.wms.domain.AbstractCommand {

        public String getCommandType() {
            return "CountItem";
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
         * Counted Quantity
         */
        private BigDecimal countedQuantity;

        public BigDecimal getCountedQuantity() {
            return this.countedQuantity;
        }

        public void setCountedQuantity(BigDecimal countedQuantity) {
            this.countedQuantity = countedQuantity;
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

