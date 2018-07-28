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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

@RequestMapping(path = "ImportService", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class ImportServiceResource {

    //@Autowired
    //private ImportApplicationService importApplicationService;

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

    @Autowired
    private ProductApplicationService productApplicationService;

    @Autowired
    private AttributeSetApplicationService attributeSetApplicationService;

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

    private void readSheet0()  throws MalformedURLException, IOException, BiffException {
        URL url = new URL("file:///D:/test/测试.xls");
        Workbook book = Workbook.getWorkbook(url.openStream());
        List<String> colNames = null;
        Integer shipment_id_column_idx = null;
        Integer product_column_idx = null;
        Integer serial_number_column_idx = null;
        Integer lot_id_column_idx = null;
        Integer quantity_column_idx = null;
        Integer bol_number_column_idx = null;
        Integer vehicle_id_column_idx = null;
        Integer seal_number_column_idx = null;
        Map<String, Integer> attributeIdColumnIdxMap = new HashMap<>();
        List<String[]> matrix = new ArrayList<>();
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

    }

    private boolean columnNameEquals(String colName, String c) {
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

    private List<String> getShipmentItemColumnNames(String[] prdIds) {
        List<String> colNames = new ArrayList<>();
        boolean isSerialNumbered = false;
        boolean isManagedByLot = false;
        List<String> qtyUomIds = new ArrayList<>();
        List<String> attrIds = new ArrayList<>();
        for (String id : prdIds) {
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

}

