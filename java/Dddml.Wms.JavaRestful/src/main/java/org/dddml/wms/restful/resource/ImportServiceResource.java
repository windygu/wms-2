package org.dddml.wms.restful.resource;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Colour;
import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.biff.RowsExceededException;
import org.dddml.wms.domain.attributeset.AttributeSetApplicationService;
import org.dddml.wms.domain.attributeset.AttributeSetState;
import org.dddml.wms.domain.attributeset.AttributeUseState;
import org.dddml.wms.domain.product.ProductApplicationService;
import org.dddml.wms.domain.product.ProductState;
import org.dddml.wms.domain.shipment.ImportingShipmentItem;
import org.dddml.wms.domain.shipment.ShipmentApplicationService;
import org.dddml.wms.domain.shipment.ShipmentCommands;
import org.dddml.wms.domain.shipmenttype.ShipmentTypeIds;
import org.dddml.wms.specialization.DomainError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

@RequestMapping(path = "ImportService", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class ImportServiceResource {

    private static final String SHIPMENT_ID_COLUMN_NAME = "ShipmentId";
    private static final String PRODUCT_COLUMN_NAME = "Product";
    private static final String[] SHIPMENT_ITEM_PREFIX_COLUMN_NAMES = new String[]{
            SHIPMENT_ID_COLUMN_NAME,
            PRODUCT_COLUMN_NAME
    };
    private static final String SERIAL_NUMBER_COLUMN_NAME = "SerialNumber";
    private static final String LOT_ID_COLUMN_NAME = "LotId";
    private static final String QUANTITY_COLUMN_NAME = "Quantity";
    private static final String BOL_NUMBER_COLUMN_NAME = "BOL#";
    private static final String VEHICLE_ID_COLUMN_NAME = "VehicleId";
    private static final String SEAL_NUMBER_COLUMN_NAME = "Seal#";
    private static final String[] SHIPMENT_ITEM_SUFFIX_COLUMN_NAMES = new String[] {
            BOL_NUMBER_COLUMN_NAME,
            VEHICLE_ID_COLUMN_NAME ,
            SEAL_NUMBER_COLUMN_NAME
    };

    public static class ProductMapping {
        /**
         * Product name.
         */
        private String productName;

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        /**
         * Product Id.
         */
        private String productId;

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

    }

    public static class ImportingShipmentHeader {
        /**
         * Ship To
         */
        private String shipToPartyId;
        /**
         * Order#
         */
        private String primaryOrderId;
        /**
         * PO#
         */
        private String poNumber;
        /**
         * Carrier
         */
        private String carrier;
        /**
         * Date Shipped
         */
        private java.sql.Timestamp dateShipped;

        /**
         * Estimated Arrival Date
         */
        private java.sql.Timestamp estimatedArrivalDate;

        /**
         * Product name->id mappings.
         */
        private ProductMapping[] productMap;

        /**
         * File(xls) url.
         */
        private String fileUrl;

        public String getFileUrl() {
            return fileUrl;
        }

        public void setFileUrl(String fileUrl) {
            this.fileUrl = fileUrl;
        }

        public String getShipToPartyId() {
            return shipToPartyId;
        }

        public void setShipToPartyId(String shipToPartyId) {
            this.shipToPartyId = shipToPartyId;
        }

        public String getPrimaryOrderId() {
            return primaryOrderId;
        }

        public void setPrimaryOrderId(String primaryOrderId) {
            this.primaryOrderId = primaryOrderId;
        }

        public String getPoNumber() {
            return poNumber;
        }

        public void setPoNumber(String poNumber) {
            this.poNumber = poNumber;
        }

        public String getCarrier() {
            return carrier;
        }

        public void setCarrier(String carrier) {
            this.carrier = carrier;
        }

        public Timestamp getDateShipped() {
            return dateShipped;
        }

        public void setDateShipped(Timestamp dateShipped) {
            this.dateShipped = dateShipped;
        }

        public Timestamp getEstimatedArrivalDate() {
            return estimatedArrivalDate;
        }

        public void setEstimatedArrivalDate(Timestamp estimatedArrivalDate) {
            this.estimatedArrivalDate = estimatedArrivalDate;
        }

        public ProductMapping[] getProductMap() {
            return productMap;
        }

        public void setProductMap(ProductMapping[] productMap) {
            this.productMap = productMap;
        }
    }

    

    @Autowired
    private ProductApplicationService productApplicationService;

    @Autowired
    private AttributeSetApplicationService attributeSetApplicationService;

    @Autowired
    private ShipmentApplicationService shipmentApplicationService;

    //@Autowired
    //private ImportApplicationService importApplicationService;

    @GetMapping("GetShipmentItemColumnNames")
    public List<String> getShipmentItemColumnNames(@RequestParam(value = "productIds") String productIds) {
        String[] prdIdArray = productIds.split(",");
        return getShipmentItemColumnNames(prdIdArray);
    }

    @GetMapping("GetShipmentImportTemplate")
    public ResponseEntity<InputStreamResource> getShipmentImportTemplate(@RequestParam(value = "productIds") String productIds) throws IOException, WriteException {
        String[] prdIdArray = productIds.split(",");
        List<String> colNames = getShipmentItemColumnNames(prdIdArray);

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        WritableWorkbook workbook = createWritableWorkbook(os);

        try {
            WritableSheet sheet = workbook.createSheet("Sheet1", 0);
            addSheetHead(sheet, colNames);
        } finally {
            workbook.write();
            workbook.close();
            os.flush();
            os.close();
        }
        byte[] bs = os.toByteArray();
        InputStream inputStream = new ByteArrayInputStream(bs);
        String filename = "ShipmentImportTemplate.xls";//todo ???
        return ResponseEntity.ok()
                .contentLength(bs.length)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header("Content-Disposition", "attachment; filename=" + filename)
                .body(new InputStreamResource(inputStream));
    }

    @PostMapping("ImportShipments")
    public void importShipments(@RequestBody ImportingShipmentHeader shipmentHeader)
            throws MalformedURLException, IOException, BiffException {

        String fileUrl = shipmentHeader.getFileUrl();
        //"file:///C:\\Users\\yangjiefeng\\Documents\\青岛\\ShipmentImportExample (1).xls";
        Map<String, String> prdNameMap = new HashMap<>();
        //prdNameMap.put("GI SEMI-TREATED FLUFF", "1532609301202");
        if (shipmentHeader.getProductMap() != null) {
            for (ProductMapping pm : shipmentHeader.getProductMap()) {
                prdNameMap.put(pm.getProductName(), pm.getProductId());
            }
        }

        URL url = new URL(fileUrl);
        InputStream inputStream = url.openStream();

        // ////////////////////////////////
        ImportingShipmentBookReader readImportingShipmentBook = new ImportingShipmentBookReader(inputStream).readSheet0();
        Integer shipment_id_column_idx = readImportingShipmentBook.getShipment_id_column_idx();
        Integer product_column_idx = readImportingShipmentBook.getProduct_column_idx();
        List<String[]> matrix = readImportingShipmentBook.getMatrix();
        Integer serial_number_column_idx = readImportingShipmentBook.getSerial_number_column_idx();
        Integer lot_id_column_idx = readImportingShipmentBook.getLot_id_column_idx();
        Integer bol_number_column_idx = readImportingShipmentBook.getBol_number_column_idx();
        Integer vehicle_id_column_idx = readImportingShipmentBook.getVehicle_id_column_idx();
        Integer seal_number_column_idx = readImportingShipmentBook.getSeal_number_column_idx();
        Integer quantity_column_idx = readImportingShipmentBook.getQuantity_column_idx();
        Map<String, Integer> attributeIdColumnIdxMap = readImportingShipmentBook.getAttributeIdColumnIdxMap();

        // ////////////////////////////////
        if (shipment_id_column_idx == null) {
            throw DomainError.named("missedColumn", "Column '%1$s' missed.", SHIPMENT_ID_COLUMN_NAME);
        }
        if (product_column_idx == null) {
            throw DomainError.named("missedColumn", "Column '%1$s' missed.", PRODUCT_COLUMN_NAME);
        }
        Map<String, ProductState> prdMap = getProductMap(prdNameMap, product_column_idx, matrix);
        for (ProductState p : prdMap.values()) {
            if(p.getIsSerialNumbered() != null && p.getIsSerialNumbered() && serial_number_column_idx == null) {
                throw DomainError.named("missedColumn", "Column '%1$s' missed.", SERIAL_NUMBER_COLUMN_NAME);
            }
            if(p.getIsManagedByLot() != null && p.getIsManagedByLot() && lot_id_column_idx == null) {
                throw DomainError.named("missedColumn", "Column '%1$s' missed.", LOT_ID_COLUMN_NAME);
            }
        }

        Map<String, ShipmentCommands.Import> shipmentMap = getImportingShipmentMap(shipmentHeader, shipment_id_column_idx, product_column_idx, serial_number_column_idx, lot_id_column_idx, quantity_column_idx, vehicle_id_column_idx, bol_number_column_idx, seal_number_column_idx, attributeIdColumnIdxMap, prdMap, matrix);

        //execute import...
        for (ShipmentCommands.Import importInfo : shipmentMap.values()) {
            importInfo.setCommandId(importInfo.getShipmentId());
            shipmentApplicationService.when(importInfo);
        }
        //return shipmentMap;
    }

    private Map<String, ShipmentCommands.Import> getImportingShipmentMap(ImportingShipmentHeader shipmentHeader,
                                                                         Integer shipment_id_column_idx,
                                                                         Integer product_column_idx,
                                                                         Integer serial_number_column_idx,
                                                                         Integer lot_id_column_idx,
                                                                         Integer quantity_column_idx,
                                                                         Integer vehicle_id_column_idx,
                                                                         Integer bol_number_column_idx,
                                                                         Integer seal_number_column_idx,
                                                                         Map<String, Integer> attributeIdColumnIdxMap,
                                                                         Map<String, ProductState> prdMap,
                                                                         List<String[]> matrix) {

        Map<String, ShipmentCommands.Import> shipmentMap = new HashMap<>();
        for (int i = 0; i < matrix.size(); i++) {
            String[] line = matrix.get(i);
            String shipmentId = line[shipment_id_column_idx];
            if (shipmentId == null || shipmentId.isEmpty()) {
                throw DomainError.named("emptyError", "ShipmentId is empty.");
            }
            ShipmentCommands.Import shipmentImport = null;
            if (!shipmentMap.containsKey(shipmentId)) {
                shipmentImport = new ShipmentCommands.Import();
                shipmentImport.setShipmentId(shipmentId);
                // --------------- set common shipment header ---------------
                shipmentImport.setPrimaryOrderId(shipmentHeader.getPrimaryOrderId());
                shipmentImport.setPoNumber(shipmentHeader.getPoNumber());
                shipmentImport.setPartyIdTo(shipmentHeader.getShipToPartyId());
                shipmentImport.setCarrier(shipmentHeader.getCarrier());
                shipmentImport.setDateShipped(shipmentHeader.getDateShipped());
                shipmentImport.setEstimatedArrivalDate(shipmentHeader.getEstimatedArrivalDate());
                shipmentImport.setShipmentTypeId(ShipmentTypeIds.INCOMING_SHIPMENT);
                // -------------------------------------------------------------
                shipmentImport.setShipmentItems(new ArrayList<>());
                shipmentMap.put(shipmentId, shipmentImport);
            } else {
                shipmentImport = shipmentMap.get(shipmentId);
            }
            if (shipmentImport.getBolNumber() == null && bol_number_column_idx != null) {
                shipmentImport.setBolNumber(line[bol_number_column_idx]);
            }
            if (shipmentImport.getVehicleId() == null && vehicle_id_column_idx!= null) {
                shipmentImport.setVehicleId(line[vehicle_id_column_idx]);
            }
            if (shipmentImport.getSealNumber() == null && seal_number_column_idx != null) {
                shipmentImport.setSealNumber(line[seal_number_column_idx]);
            }
            ImportingShipmentItem shipmentItem = new ImportingShipmentItem();
            shipmentItem.setAttributeSetInstance(new HashMap<>());
            // Item Seq Id.
            shipmentItem.setShipmentItemSeqId(String.valueOf(i + 2));
            // Product Id.
            shipmentItem.setProductId(prdMap.get(line[product_column_idx]).getProductId());
            // Serial Number
            if (serial_number_column_idx != null && line[serial_number_column_idx] != null && !line[serial_number_column_idx].isEmpty()) {
                shipmentItem.getAttributeSetInstance().put("serialNumber",line[serial_number_column_idx]);
            }
            // Lot
            if (lot_id_column_idx != null && line[lot_id_column_idx] != null && !line[lot_id_column_idx].isEmpty()) {
                shipmentItem.getAttributeSetInstance().put("lotId",line[lot_id_column_idx]);
            }
            // Quantity
            shipmentItem.setQuantity(new BigDecimal(line[quantity_column_idx]));
            // Other Attribute values.
            for (Map.Entry<String, Integer> kv : attributeIdColumnIdxMap.entrySet()) {
                String attrId = kv.getKey();
                Integer attrColIdx = kv.getValue();
                Object attrVal = line[attrColIdx];
                // ////////////////////////////////////////////////////////
                //todo 如果不在 product 的属性集中的属性，应该忽略
                // ////////////////////////////////////////////////////////
                shipmentItem.getAttributeSetInstance().put(attrId, attrVal);
            }
            shipmentImport.getShipmentItems().add(shipmentItem);
        }
        return shipmentMap;
    }

    private Map<String, ProductState> getProductMap(Map<String, String> prdNameMap, final Integer product_column_idx, List<String[]> matrix) {
        Set<String> prds = matrix.stream().map(m -> m[product_column_idx]).collect(Collectors.toSet());
        Map<String, ProductState> prdMap = new HashMap<>();
        for (String prd : prds) {
            String prdId = prd;
            if(prdNameMap.containsKey(prd)) {
                prdId = prdNameMap.get(prd);
            }
            ProductState prdState = productApplicationService.get(prdId);
            if (prdState == null) {
                throw DomainError.named("missedProduct", "Product '%1$s' missed.", prd);
            }
            prdMap.put(prd, prdState);
        }
        return prdMap;
    }

    private static boolean columnNameEquals(String colName, String c) {
        boolean b = false;
        if (colName.equalsIgnoreCase(c)) {
            b = true;
        } else if (c == null) {
            b = false;
        } else if (c.toLowerCase().startsWith(colName.toLowerCase() + "(")) {
            b = true;
        }
        return b;
    }

    private WritableWorkbook createWritableWorkbook(ByteArrayOutputStream os) throws IOException {
        //全局设置
        WorkbookSettings settings = new WorkbookSettings();
        settings.setEncoding("UTF-8");
        settings.setLocale(new Locale("zh", "cn"));
        return Workbook.createWorkbook(os);
    }

    private void addSheetHead(WritableSheet sheet, List<String> colNames) throws RowsExceededException, WriteException {
        for (int i = 0; i < colNames.size(); i++) {
            Label label = new Label(i, 0, colNames.get(i));
            WritableCellFormat cellFormat = new WritableCellFormat();
            //cellFormat.setShrinkToFit(true);
            cellFormat.setBackground(Colour.LIGHT_ORANGE);
            label.setCellFormat(cellFormat);
            sheet.addCell(label);
        }
    }

    private List<String> getShipmentItemColumnNames(String[] productIds) {
        List<String> colNames = new ArrayList<>();
        boolean isSerialNumbered = false;
        boolean isManagedByLot = false;
        List<String> qtyUomIds = new ArrayList<>();
        List<String> attrIds = new ArrayList<>();
        for (String id : productIds) {
            ProductState prd = productApplicationService.get(id);
            if (prd == null) {
                continue;
            }
            if (prd.getIsSerialNumbered() != null && prd.getIsSerialNumbered()) {
                isSerialNumbered = true;
            }
            if (prd.getIsManagedByLot() != null && prd.getIsManagedByLot()) {
                isManagedByLot = true;
            }
            if (prd.getQuantityUomId() != null) {
                if (!qtyUomIds.contains(prd.getQuantityUomId())) {
                    qtyUomIds.add(prd.getQuantityUomId());
                }
            }
            if (prd.getAttributeSetId() == null) {
                continue;
            }
            AttributeSetState attrSet = attributeSetApplicationService.get(prd.getAttributeSetId());
            if (attrSet != null) {
                for (AttributeUseState attrUse : attrSet.getAttributeUses()) {
                    if (!attrIds.contains(attrUse.getAttributeId())) {
                        attrIds.add(attrUse.getAttributeId());
                    }
                }
            }
        }
        colNames.addAll(Arrays.asList(SHIPMENT_ITEM_PREFIX_COLUMN_NAMES));
        if (isSerialNumbered) {
            colNames.add(SERIAL_NUMBER_COLUMN_NAME + "(PackageId)");
        }
        if (isManagedByLot) {
            colNames.add(LOT_ID_COLUMN_NAME);
        }
        if (qtyUomIds.size() > 0) {
            colNames.add(QUANTITY_COLUMN_NAME + "("
                    + qtyUomIds.stream().reduce("", (a, b) -> a.equals("") ? b : a + "," + b)
                    + ")"
            );
        }
        colNames.addAll(attrIds);
        colNames.addAll(Arrays.asList(SHIPMENT_ITEM_SUFFIX_COLUMN_NAMES));
        return colNames;
    }

    private static class ImportingShipmentBookReader {
        private InputStream inputStream;
        private Integer shipment_id_column_idx;
        private Integer product_column_idx;
        private Integer serial_number_column_idx;
        private Integer lot_id_column_idx;
        private Integer quantity_column_idx;
        private Integer bol_number_column_idx;
        private Integer vehicle_id_column_idx;
        private Integer seal_number_column_idx;
        private Map<String, Integer> attributeIdColumnIdxMap;
        private List<String[]> matrix;

        public ImportingShipmentBookReader(InputStream inputStream) {
            this.inputStream = inputStream;
        }

        public Integer getShipment_id_column_idx() {
            return shipment_id_column_idx;
        }

        public Integer getProduct_column_idx() {
            return product_column_idx;
        }

        public Integer getSerial_number_column_idx() {
            return serial_number_column_idx;
        }

        public Integer getLot_id_column_idx() {
            return lot_id_column_idx;
        }

        public Integer getQuantity_column_idx() {
            return quantity_column_idx;
        }

        public Integer getBol_number_column_idx() {
            return bol_number_column_idx;
        }

        public Integer getVehicle_id_column_idx() {
            return vehicle_id_column_idx;
        }

        public Integer getSeal_number_column_idx() {
            return seal_number_column_idx;
        }

        public Map<String, Integer> getAttributeIdColumnIdxMap() {
            return attributeIdColumnIdxMap;
        }

        public List<String[]> getMatrix() {
            return matrix;
        }

        public ImportingShipmentBookReader readSheet0() throws IOException, BiffException {
            Workbook book = Workbook.getWorkbook(inputStream);
            List<String> colNames = null;
            shipment_id_column_idx = null;
            product_column_idx = null;
            serial_number_column_idx = null;
            lot_id_column_idx = null;
            quantity_column_idx = null;
            bol_number_column_idx = null;
            vehicle_id_column_idx = null;
            seal_number_column_idx = null;
            attributeIdColumnIdxMap = new HashMap<>();
            matrix = new ArrayList<>();
            try {
                Sheet sheet = book.getSheet(0);
                int rows = sheet.getRows();
                int columns = sheet.getColumns();
                // 遍历每行每列的单元格
                for (int i = 0; i < rows; i++) {
                    String[] mr = null;
                    if (i == 0) {
                        colNames = new ArrayList<>();
                    } else {
                        mr = new String[columns];
                    }
                    for (int j = 0; j < columns; j++) {
                        Cell cell = sheet.getCell(j, i);
                        String c = cell.getContents();
                        if (c != null) {
                            c = c.trim();
                        }
                        if (i == 0) {
                            colNames.add(c);
                            if (columnNameEquals(SHIPMENT_ID_COLUMN_NAME, c)) {
                                shipment_id_column_idx = j;
                            } else if (columnNameEquals(PRODUCT_COLUMN_NAME, c)) {
                                product_column_idx = j;
                            } else if (columnNameEquals(SERIAL_NUMBER_COLUMN_NAME, c)) {
                                serial_number_column_idx = j;
                            } else if (columnNameEquals(LOT_ID_COLUMN_NAME, c)) {
                                lot_id_column_idx = j;
                            } else if (columnNameEquals(QUANTITY_COLUMN_NAME, c)) {
                                quantity_column_idx = j;
                            } else if (columnNameEquals(BOL_NUMBER_COLUMN_NAME, c)) {
                                bol_number_column_idx = j;
                            } else if (columnNameEquals(VEHICLE_ID_COLUMN_NAME, c)) {
                                vehicle_id_column_idx = j;
                            } else if (columnNameEquals(SEAL_NUMBER_COLUMN_NAME, c)) {
                                seal_number_column_idx = j;
                            } else {
                                attributeIdColumnIdxMap.put(c, j);
                            }
                        } else {
                            mr[j] = c;
                        }
                    }
                    if (i > 0) {
                        matrix.add(mr);
                    }
                }
            } finally {
                book.close();
            }
            return this;
        }
    }
}

