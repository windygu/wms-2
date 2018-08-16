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
import org.dddml.wms.domain.inout.InOutCommands;
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

    /**
     * 初始化库存设置。
     */
    public static class InitializingInventoryItemSettings {
        /**
         * 重量（LBS）列名.
         */
        private String weightLbsColumnName = "Weight (lbs)";

        /**
         * 风干重量（LBS）列名。
         */
        private String airDryWeightLbsColumnName = "AD (lbs)";

        /**
         * 数量（主计量单位）列名。
         */
        private String quantityColumnName = "Weight (kg)";

        /**
         * 风干系数列名。
         */
        private String airDryPctColumnName = "Air dry";

        /**
         * 风干重量（公斤）列名。
         */
        private String airDryWeightKgColumnName = "Weight (Adkg)";

        /**
         * 风干重量（ADMT）列名。
         */
        private String airDryMetricTonColumnName = "ADMT";

        /**
         * 卷数列名。
         */
        private String rollCntColumnName = "Roll Cnt";

        /**
         * 序列号（包装 Id）列名。
         */
        private String serialNumberColumnName = "Package";

        /**
         * 批次号列名。
         */
        private String lotIdColumnName = "PO#";

        /**
         * 货位 Id 列名。
         */
        private String locatorIdColumnName = "Locator Id";

        /**
         * PO 引用信息列名。
         */
        private String poReferenceColumnName = "PO#";

        /**
         * 入库时间列名。
         */
        private String entryDateColumnName = "Entry Date";

        /**
         * 产品列名。
         */
        private String productColumnName = "Product";
        /**
         * Product name->id mappings.
         */
        private ProductMapping[] productMap;

        private String fileUrl;

        public String getLocatorIdColumnName() {
            return locatorIdColumnName;
        }

        public void setLocatorIdColumnName(String locatorIdColumnName) {
            this.locatorIdColumnName = locatorIdColumnName;
        }

        public String getPoReferenceColumnName() {
            return poReferenceColumnName;
        }

        public void setPoReferenceColumnName(String poReferenceColumnName) {
            this.poReferenceColumnName = poReferenceColumnName;
        }

        public String getEntryDateColumnName() {
            return entryDateColumnName;
        }

        public void setEntryDateColumnName(String entryDateColumnName) {
            this.entryDateColumnName = entryDateColumnName;
        }

        public String getWeightLbsColumnName() {
            return weightLbsColumnName;
        }

        public void setWeightLbsColumnName(String weightLbsColumnName) {
            this.weightLbsColumnName = weightLbsColumnName;
        }

        public String getAirDryWeightLbsColumnName() {
            return airDryWeightLbsColumnName;
        }

        public void setAirDryWeightLbsColumnName(String airDryWeightLbsColumnName) {
            this.airDryWeightLbsColumnName = airDryWeightLbsColumnName;
        }

        public String getQuantityColumnName() {
            return quantityColumnName;
        }

        public void setQuantityColumnName(String quantityColumnName) {
            this.quantityColumnName = quantityColumnName;
        }

        public String getAirDryPctColumnName() {
            return airDryPctColumnName;
        }

        public void setAirDryPctColumnName(String airDryPctColumnName) {
            this.airDryPctColumnName = airDryPctColumnName;
        }

        public String getAirDryWeightKgColumnName() {
            return airDryWeightKgColumnName;
        }

        public void setAirDryWeightKgColumnName(String airDryWeightKgColumnName) {
            this.airDryWeightKgColumnName = airDryWeightKgColumnName;
        }

        public String getAirDryMetricTonColumnName() {
            return airDryMetricTonColumnName;
        }

        public void setAirDryMetricTonColumnName(String airDryMetricTonColumnName) {
            this.airDryMetricTonColumnName = airDryMetricTonColumnName;
        }

        public String getRollCntColumnName() {
            return rollCntColumnName;
        }

        public void setRollCntColumnName(String rollCntColumnName) {
            this.rollCntColumnName = rollCntColumnName;
        }

        public String getSerialNumberColumnName() {
            return serialNumberColumnName;
        }

        public void setSerialNumberColumnName(String serialNumberColumnName) {
            this.serialNumberColumnName = serialNumberColumnName;
        }

        public String getLotIdColumnName() {
            return lotIdColumnName;
        }

        public void setLotIdColumnName(String lotIdColumnName) {
            this.lotIdColumnName = lotIdColumnName;
        }

        public ProductMapping[] getProductMap() {
            return productMap;
        }

        public void setProductMap(ProductMapping[] productMap) {
            this.productMap = productMap;
        }

        public String getFileUrl() {
            return fileUrl;
        }

        public void setFileUrl(String fileUrl) {
            this.fileUrl = fileUrl;
        }

        public String getProductColumnName() {
            return productColumnName;
        }

        public void setProductColumnName(String productColumnName) {
            this.productColumnName = productColumnName;
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

        Map<String, String> prdNameMap = getProductNameMap(shipmentHeader.getProductMap());

        String fileUrl = shipmentHeader.getFileUrl();
        //"file:///C:\\Users\\yangjiefeng\\Documents\\青岛\\ShipmentImportExample (1).xls";
        URL url = new URL(fileUrl);
        InputStream inputStream = url.openStream();

        // ////////////////////////////////
        ImportingShipmentBookReader reader = new ImportingShipmentBookReader(inputStream).readSheet0();
        Integer shipmentIdColumnIdx = reader.getShipmentIdColumnIdx();
        Integer productColumnIdx = reader.getProductColumnIdx();
        Integer serialNumberColumnIdx = reader.getSerialNumberColumnIdx();
        Integer lotIdColumnIdx = reader.getLotIdColumnIdx();
        Integer bolNumberColumnIdx = reader.getBolNumberColumnIdx();
        Integer vehicleIdColumnIdx = reader.getVehicleIdColumnIdx();
        Integer sealNumberColumnIdx = reader.getSealNumberColumnIdx();
        Integer quantityColumnIdx = reader.getQuantityColumnIdx();
        Map<String, Integer> attributeIdColumnIdxMap = reader.getAttributeIdColumnIdxMap();
        List<String[]> matrix = reader.getMatrix();

        // ////////////////////////////////
        if (shipmentIdColumnIdx == null) {
            throw DomainError.named("missedColumn", "Column '%1$s' missed.", SHIPMENT_ID_COLUMN_NAME);
        }
        if (productColumnIdx == null) {
            throw DomainError.named("missedColumn", "Column '%1$s' missed.", PRODUCT_COLUMN_NAME);
        }
        Map<String, ProductState> prdMap = getProductMap(prdNameMap, productColumnIdx, matrix);
        for (ProductState p : prdMap.values()) {
            if(p.getIsSerialNumbered() != null && p.getIsSerialNumbered() && serialNumberColumnIdx == null) {
                throw DomainError.named("missedColumn", "Column '%1$s' missed.", SERIAL_NUMBER_COLUMN_NAME);
            }
            if(p.getIsManagedByLot() != null && p.getIsManagedByLot() && lotIdColumnIdx == null) {
                throw DomainError.named("missedColumn", "Column '%1$s' missed.", LOT_ID_COLUMN_NAME);
            }
        }

        Map<String, ShipmentCommands.Import> shipmentMap = getImportingShipmentMap(
                shipmentHeader,
                shipmentIdColumnIdx, productColumnIdx, serialNumberColumnIdx, lotIdColumnIdx, quantityColumnIdx,
                vehicleIdColumnIdx, bolNumberColumnIdx, sealNumberColumnIdx, attributeIdColumnIdxMap, prdMap, matrix);

        //execute import...
        for (ShipmentCommands.Import importInfo : shipmentMap.values()) {
            importInfo.setCommandId(importInfo.getShipmentId());
            shipmentApplicationService.when(importInfo);
        }
        //return shipmentMap;
    }

    private Map<String, String> getProductNameMap(ProductMapping[] productMappings) {
        Map<String, String> prdNameMap = new HashMap<>();
        //prdNameMap.put("GI SEMI-TREATED FLUFF", "1532609301202");
        if (productMappings != null) {
            for (ProductMapping pm : productMappings) {
                prdNameMap.put(pm.getProductName(), pm.getProductId());
            }
        }
        return prdNameMap;
    }

    @PostMapping("InitializeInventoryItems")
    public void initializeInventoryItems(@RequestBody InitializingInventoryItemSettings settings) throws IOException, BiffException {
        Map<String, String> prdNameMap = getProductNameMap(settings.getProductMap());

        String fileUrl = settings.getFileUrl();
        //"file:///C:\\Users\\yangjiefeng\\Documents\\青岛\\ShipmentImportExample (1).xls";
        URL url = new URL(fileUrl);
        InputStream inputStream = url.openStream();
        InitializingInventoryItemBookReader reader = new InitializingInventoryItemBookReader(settings, inputStream).readSheet0();
        Integer productColumnIdx = reader.getProductColumnIdx();
        Integer entryDateColumnIdx = reader.getEntryDateColumnIdx();
        Integer locatorIdColumnIdx = reader.getLocatorIdColumnIdx();
        Integer quantityColumnIdx = reader.getQuantityColumnIdx();
        Integer serialNumberColumnIdx = reader.getSerialNumberColumnIdx();
        Integer lotIdColumnIdx = reader.getLotIdColumnIdx();
        Integer weightLbsColumnIdx = reader.getWeightLbsColumnIdx();
        Integer airDryWeightLbsColumnIdx = reader.getAirDryWeightLbsColumnIdx();
        Integer airDryPctColumnIdx = reader.getAirDryPctColumnIdx();
        Integer airDryMetricTonColumnIdx = reader.getAirDryMetricTonColumnIdx();
        Integer airDryWeightKgColumnIdx = reader.getAirDryWeightKgColumnIdx();
        Integer rollCntColumnIdx = reader.getRollCntColumnIdx();
        Integer poReferenceColumnIdx = reader.getPoReferenceColumnIdx();
        Map<String, Integer> attributeIdColumnIdxMap = reader.getAttributeIdColumnIdxMap();
        List<String[]> matrix = reader.getMatrix();

        if (productColumnIdx == null) {
            throw DomainError.named("missedColumn", "Column '%1$s' missed.", settings.getProductColumnName());
        }
        if (entryDateColumnIdx == null) {
            throw DomainError.named("missedColumn", "Column '%1$s' missed.", settings.getEntryDateColumnName());
        }
        if (locatorIdColumnIdx == null) {
            throw DomainError.named("missedColumn", "Column '%1$s' missed.", settings.getLotIdColumnName());
        }
        if (quantityColumnIdx == null) {
            throw DomainError.named("missedColumn", "Column '%1$s' missed.", settings.getQuantityColumnName());
        }
        Map<String, ProductState> prdMap = getProductMap(prdNameMap, productColumnIdx, matrix);
        for (ProductState p : prdMap.values()) {
            if(p.getIsSerialNumbered() != null && p.getIsSerialNumbered() && serialNumberColumnIdx == null) {
                throw DomainError.named("missedColumn", "Column '%1$s' missed.", settings.getSerialNumberColumnName());
            }
            if(p.getIsManagedByLot() != null && p.getIsManagedByLot() && lotIdColumnIdx == null) {
                throw DomainError.named("missedColumn", "Column '%1$s' missed.", settings.getLotIdColumnName());
            }
        }
//        System.out.println(weightLbsColumnIdx);
//        System.out.println(airDryWeightLbsColumnIdx);
//        System.out.println(airDryPctColumnIdx);
//        System.out.println(airDryMetricTonColumnIdx);
//        System.out.println(airDryWeightKgColumnIdx);
//        System.out.println(rollCntColumnIdx);
//        System.out.println(poReferenceColumnIdx);
//        System.out.println(attributeIdColumnIdxMap);
//        System.out.println(matrix);

        //todo
        Map<String, InOutCommands.Import> inOutMap = new HashMap<>();

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

    private Map<String, ProductState> getProductMap(Map<String, String> productNameIdMap, final Integer productColumnIdx, List<String[]> matrix) {
        Set<String> productCellValues = matrix.stream().map(m -> m[productColumnIdx]).collect(Collectors.toSet());
        Map<String, ProductState> prdMap = new HashMap<>();
        for (String productNameOrId : productCellValues) {
            String productId = productNameOrId;
            if(productNameIdMap.containsKey(productNameOrId)) {
                productId = productNameIdMap.get(productNameOrId);
            }
            ProductState prdState = productApplicationService.get(productId);
            if (prdState == null) {
                throw DomainError.named("missedProduct", "Product '%1$s' missed.", productNameOrId);
            }
            prdMap.put(productNameOrId, prdState);
        }
        return prdMap;
    }

    /**
     * @param colName standard column name.
     * @param xlsColName column name in excel.
     * @return
     */
    private static boolean columnNameEquals(String colName, String xlsColName) {
        boolean b = false;
        if (colName.equalsIgnoreCase(xlsColName)) {
            b = true;
        } else if (xlsColName == null) {
            b = false;
        } else if (xlsColName.toLowerCase().startsWith(colName.toLowerCase() + "(")) {
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
        private Integer shipmentIdColumnIdx;
        private Integer productColumnIdx;
        private Integer serialNumberColumnIdx;
        private Integer lotIdColumnIdx;
        private Integer quantityColumnIdx;
        private Integer bolNumberColumnIdx;
        private Integer vehicleIdColumnIdx;
        private Integer sealNumberColumnIdx;
        private Map<String, Integer> attributeIdColumnIdxMap;
        private List<String[]> matrix;

        public ImportingShipmentBookReader(InputStream inputStream) {
            this.inputStream = inputStream;
        }

        public Integer getShipmentIdColumnIdx() {
            return shipmentIdColumnIdx;
        }

        public Integer getProductColumnIdx() {
            return productColumnIdx;
        }

        public Integer getSerialNumberColumnIdx() {
            return serialNumberColumnIdx;
        }

        public Integer getLotIdColumnIdx() {
            return lotIdColumnIdx;
        }

        public Integer getQuantityColumnIdx() {
            return quantityColumnIdx;
        }

        public Integer getBolNumberColumnIdx() {
            return bolNumberColumnIdx;
        }

        public Integer getVehicleIdColumnIdx() {
            return vehicleIdColumnIdx;
        }

        public Integer getSealNumberColumnIdx() {
            return sealNumberColumnIdx;
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
            shipmentIdColumnIdx = null;
            productColumnIdx = null;
            serialNumberColumnIdx = null;
            lotIdColumnIdx = null;
            quantityColumnIdx = null;
            bolNumberColumnIdx = null;
            vehicleIdColumnIdx = null;
            sealNumberColumnIdx = null;
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
                                shipmentIdColumnIdx = j;
                            } else if (columnNameEquals(PRODUCT_COLUMN_NAME, c)) {
                                productColumnIdx = j;
                            } else if (columnNameEquals(SERIAL_NUMBER_COLUMN_NAME, c)) {
                                serialNumberColumnIdx = j;
                            } else if (columnNameEquals(LOT_ID_COLUMN_NAME, c)) {
                                lotIdColumnIdx = j;
                            } else if (columnNameEquals(QUANTITY_COLUMN_NAME, c)) {
                                quantityColumnIdx = j;
                            } else if (columnNameEquals(BOL_NUMBER_COLUMN_NAME, c)) {
                                bolNumberColumnIdx = j;
                            } else if (columnNameEquals(VEHICLE_ID_COLUMN_NAME, c)) {
                                vehicleIdColumnIdx = j;
                            } else if (columnNameEquals(SEAL_NUMBER_COLUMN_NAME, c)) {
                                sealNumberColumnIdx = j;
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

    private class InitializingInventoryItemBookReader {
        private InitializingInventoryItemSettings settings;
        private InputStream inputStream;
        private Integer productColumnIdx;
        private Integer serialNumberColumnIdx;
        private Integer lotIdColumnIdx;
        private Integer quantityColumnIdx;
        private Integer weightLbsColumnIdx;
        private Integer airDryWeightLbsColumnIdx;
        private Integer airDryPctColumnIdx;
        private Integer airDryWeightKgColumnIdx;
        private Integer airDryMetricTonColumnIdx;
        private Integer rollCntColumnIdx;
        private Integer locatorIdColumnIdx;
        private Integer poReferenceColumnIdx;
        private Integer entryDateColumnIdx;
        private Map<String, Integer> attributeIdColumnIdxMap;
        private List<String[]> matrix;

        public InitializingInventoryItemBookReader(InitializingInventoryItemSettings settings, InputStream inputStream) {
            this.settings = settings;
            this.inputStream = inputStream;
        }

        public Integer getProductColumnIdx() {
            return productColumnIdx;
        }

        public Integer getSerialNumberColumnIdx() {
            return serialNumberColumnIdx;
        }

        public Integer getLotIdColumnIdx() {
            return lotIdColumnIdx;
        }

        public Integer getQuantityColumnIdx() {
            return quantityColumnIdx;
        }

        public Integer getWeightLbsColumnIdx() {
            return weightLbsColumnIdx;
        }

        public Integer getAirDryWeightLbsColumnIdx() {
            return airDryWeightLbsColumnIdx;
        }

        public Integer getAirDryPctColumnIdx() {
            return airDryPctColumnIdx;
        }

        public Integer getAirDryWeightKgColumnIdx() {
            return airDryWeightKgColumnIdx;
        }

        public Integer getAirDryMetricTonColumnIdx() {
            return airDryMetricTonColumnIdx;
        }

        public Integer getRollCntColumnIdx() {
            return rollCntColumnIdx;
        }

        public Integer getLocatorIdColumnIdx() {
            return locatorIdColumnIdx;
        }

        public Integer getPoReferenceColumnIdx() {
            return poReferenceColumnIdx;
        }

        public Integer getEntryDateColumnIdx() {
            return entryDateColumnIdx;
        }

        public Map<String, Integer> getAttributeIdColumnIdxMap() {
            return attributeIdColumnIdxMap;
        }

        public List<String[]> getMatrix() {
            return matrix;
        }

        public InitializingInventoryItemBookReader readSheet0() throws IOException, BiffException {
            productColumnIdx = null;
            serialNumberColumnIdx = null;
            lotIdColumnIdx = null;
            quantityColumnIdx = null;
            weightLbsColumnIdx = null;
            airDryWeightLbsColumnIdx = null;
            airDryPctColumnIdx = null;
            airDryWeightKgColumnIdx = null;
            airDryMetricTonColumnIdx = null;
            rollCntColumnIdx = null;
            locatorIdColumnIdx = null;
            poReferenceColumnIdx = null;
            entryDateColumnIdx = null;
            attributeIdColumnIdxMap = new HashMap<>();
            matrix = new ArrayList<>();
            Workbook book = Workbook.getWorkbook(inputStream);
            List<String> colNames = null;
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
                            if (columnNameEquals(settings.getProductColumnName(), c)) {
                                productColumnIdx = j;
                            } else if (columnNameEquals(settings.getSerialNumberColumnName(), c)) {
                                serialNumberColumnIdx = j;
                            } else if (columnNameEquals(settings.getLotIdColumnName(), c)) {
                                lotIdColumnIdx = j;
                            } else if (columnNameEquals(settings.getQuantityColumnName(), c)) {
                                quantityColumnIdx = j;
                            } else if (columnNameEquals(settings.getWeightLbsColumnName(), c)) {
                                weightLbsColumnIdx = j;//"Weight (lbs)";
                            } else if (columnNameEquals(settings.getAirDryWeightLbsColumnName(), c)) {
                                airDryWeightLbsColumnIdx = j;//"AD (lbs)";
                            } else if (columnNameEquals(settings.getAirDryPctColumnName(), c)) {
                                airDryPctColumnIdx = j;//"Air dry";
                            } else if (columnNameEquals(settings.getAirDryWeightKgColumnName(), c)) {
                                airDryWeightKgColumnIdx = j;//"Weight (Adkg)";
                            } else if (columnNameEquals(settings.getAirDryMetricTonColumnName(), c)) {
                                airDryMetricTonColumnIdx = j;//"ADMT";
                            } else if (columnNameEquals(settings.getRollCntColumnName(), c)) {
                                rollCntColumnIdx = j;//"Roll Cnt";
                            } else if (columnNameEquals(settings.getLocatorIdColumnName(), c)) {
                                locatorIdColumnIdx = j;//"Locator Id";
                            } else if (columnNameEquals(settings.getPoReferenceColumnName(), c)) {
                                poReferenceColumnIdx = j;//"PO#";
                            } else if (columnNameEquals(settings.getEntryDateColumnName(), c)) {
                                entryDateColumnIdx = j;//"Entry Date";
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

