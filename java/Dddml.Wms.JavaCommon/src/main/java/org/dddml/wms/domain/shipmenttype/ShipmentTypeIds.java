package org.dddml.wms.domain.shipmenttype;

/**
 * Created by yangjiefeng on 2018/1/31.
 */
public class ShipmentTypeIds {

    public static final String INCOMING_SHIPMENT = "INCOMING_SHIPMENT";

    public static final String OUTGOING_SHIPMENT = "OUTGOING_SHIPMENT";

    // ////////////////////

    public static final String SALES_RETURN = "SALES_RETURN";

    public static final String SALES_SHIPMENT = "SALES_SHIPMENT";

    public static final String PURCHASE_SHIPMENT = "PURCHASE_SHIPMENT";

    public static final String PURCHASE_RETURN = "PURCHASE_RETURN";

    // ////////////////////
    public static final String DROP_SHIPMENT = "DROP_SHIPMENT";

    public static final String TRANSFER = "TRANSFER";

    private static java.util.Map<String, String> _parentTypeIdDictionary;

    static {
        java.util.Map<String, String> dict = new java.util.HashMap<String, String>();
        dict.put(SALES_RETURN, INCOMING_SHIPMENT);
        dict.put(SALES_SHIPMENT, OUTGOING_SHIPMENT);
        dict.put(PURCHASE_SHIPMENT, INCOMING_SHIPMENT);
        dict.put(PURCHASE_RETURN, OUTGOING_SHIPMENT);
        _parentTypeIdDictionary = dict;
    }

    public static String getParentTypeId(String shipmentTypeId) {
        if (_parentTypeIdDictionary.containsKey(shipmentTypeId)) {
            return _parentTypeIdDictionary.get(shipmentTypeId);
        }
        return null;
    }

}
