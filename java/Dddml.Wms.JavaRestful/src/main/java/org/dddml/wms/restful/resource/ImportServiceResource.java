package org.dddml.wms.restful.resource;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Colour;
import jxl.write.*;
import jxl.write.biff.RowsExceededException;
import org.dddml.wms.domain.attributeset.AttributeSetApplicationService;
import org.dddml.wms.domain.attributeset.AttributeSetState;
import org.dddml.wms.domain.attributeset.AttributeUseState;
import org.dddml.wms.domain.product.ProductApplicationService;
import org.dddml.wms.domain.product.ProductState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

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
                    if (!attrIds.contains(attrUse)) {
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

