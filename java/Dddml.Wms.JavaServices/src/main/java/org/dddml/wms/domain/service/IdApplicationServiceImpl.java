package org.dddml.wms.domain.service;

import org.dddml.wms.domain.documenttype.DocumentTypeIds;
import org.dddml.wms.specialization.hibernate.TableIdGenerator;
import org.dddml.wms.specialization.ApplicationContext;

/**
 * Created by yangjiefeng on 2018/7/18.
 */
public class IdApplicationServiceImpl implements IdApplicationService  {

    @Override
    public String when(IdServiceCommands.GetDocumentNumber c) {
        String docType = c.getDocumentType();
        TableIdGenerator idGen = ApplicationContext.current.get(TableIdGenerator.class);
        String seqId = idGen.getNextId().toString();
        String docTypePrefix = docType.substring(0, 1).toUpperCase();
        if (DocumentTypeIds.IN.equalsIgnoreCase(docType)) {
            docTypePrefix = "R";
        } else if (DocumentTypeIds.OUT.equalsIgnoreCase(docType)) {
            docTypePrefix = "C";
        } else if (DocumentTypeIds.SHIPMENT.equalsIgnoreCase(docType)) {
            docTypePrefix = "S";
        } else if (DocumentTypeIds.MOVEMENT.equalsIgnoreCase(docType)) {
            docTypePrefix = "M";
        } else if (DocumentTypeIds.PHYSICAL_INVENTORY.equalsIgnoreCase(docType)) {
            docTypePrefix = "P";
        }
        //todo more type???

        return docTypePrefix + seqId;
    }

}
