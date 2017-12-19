using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Dddml.Wms.Domain.ShipmentType
{
    public static class ShipmentTypeIds
    {
        public const string IncomingShipment = "INCOMING_SHIPMENT";

        public const string OutgoingShipment = "OUTGOING_SHIPMENT";

        // ////////////////////
        public const string SalesReturn = "SALES_RETURN";

        public const string SalesShipment = "SALES_SHIPMENT";
        
        public const string PurchaseShipment = "PURCHASE_SHIPMENT";
        
        public const string PurchaseReturn = "PURCHASE_RETURN";

        // ////////////////////
        public const string DropShipment = "DROP_SHIPMENT";
        
        public const string Transfer = "TRANSFER";

        static IDictionary<string, string> _parentTypeIdDictionary;

        static ShipmentTypeIds()
        {
            IDictionary<string, string> dict = new Dictionary<string, string>();
            dict.Add(SalesReturn, IncomingShipment);
            dict.Add(SalesShipment, OutgoingShipment);
            dict.Add(PurchaseShipment, IncomingShipment);
            dict.Add(PurchaseReturn, OutgoingShipment);
            _parentTypeIdDictionary = dict;
        }

        public static string GetParentTypeId(string shipmentTypeId)
        {
            if (_parentTypeIdDictionary.ContainsKey(shipmentTypeId))
            {
                return _parentTypeIdDictionary[shipmentTypeId];
            }
            return null;
        }

    }

}
