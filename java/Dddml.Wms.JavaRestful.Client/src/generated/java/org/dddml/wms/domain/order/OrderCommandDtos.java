package org.dddml.wms.domain.order;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.partyrole.*;
import org.dddml.wms.domain.*;

public class OrderCommandDtos
{
    private OrderCommandDtos() {
    }

    public static class OrderShipGroupActionRequestContent {

        public String getCommandType() {
            return "OrderShipGroupAction";
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
         * Order Ship Group Id
         */
        private OrderShipGroupId orderShipGroupId;

        public OrderShipGroupId getOrderShipGroupId() {
            return this.orderShipGroupId;
        }

        public void setOrderShipGroupId(OrderShipGroupId orderShipGroupId) {
            this.orderShipGroupId = orderShipGroupId;
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

