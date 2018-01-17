package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public class ShipmentCommandDtos
{
    private ShipmentCommandDtos() {
    }

    public static class ImportRequestContent {

        public String getCommandType() {
            return "Import";
        }

        private ImportingShipmentItemDto[] shipmentItems;

        public ImportingShipmentItemDto[] getShipmentItems() {
            return this.shipmentItems;
        }

        public void setShipmentItems(ImportingShipmentItemDto[] shipmentItems) {
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

       public ShipmentCommands.Import toImport() {
            ShipmentCommands.Import cmd = new ShipmentCommands.Import();
            cmd.setShipmentItems(this.getShipmentItems() == null ? null : java.util.Collections.unmodifiableSet(java.util.Arrays.stream(this.getShipmentItems()).map(p -> p.toImportingShipmentItem()).collect(java.util.stream.Collectors.toSet())));
            cmd.setShipmentId(this.getShipmentId());
            cmd.setVersion(this.getVersion());
            cmd.setCommandId(this.getCommandId());
            cmd.setRequesterId(this.getRequesterId());
            return cmd;
        }

    }

}

