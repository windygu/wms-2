package org.dddml.wms.domain.shipment;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;

public class ShipmentCommands
{
    private ShipmentCommands() {
    }

    public static class Import implements ShipmentCommand {

        public String getCommandType() {
            return "Import";
        }

        public void setCommandType(String commandType) {
            //do nothing
        }

        private Set<ImportingShipmentItem> shipmentItems;

        public Set<ImportingShipmentItem> getShipmentItems() {
            return this.shipmentItems;
        }

        public void setShipmentItems(Set<ImportingShipmentItem> shipmentItems) {
            this.shipmentItems = shipmentItems;
        }

        private String shipmentId;

        public String getShipmentId() {
            return this.shipmentId;
        }

        public void setShipmentId(String shipmentId) {
            this.shipmentId = shipmentId;
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

    }

}

