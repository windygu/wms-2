package org.dddml.wms.domain.documenttype;

import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class DocumentTypeStateEventIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "documentTypeId",
            "version",
        };

    public static final String[] propertyTypes = new String[]{
            "String",
            "Long",
        };

    public static final Map<String, String> propertyTypeMap;

    static {
        propertyTypeMap = new HashMap<String, String>();
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }
	
    private DocumentTypeStateEventIdDto value;

    public DocumentTypeStateEventIdFlattenedDto()
    {
        this(new DocumentTypeStateEventIdDto());
    }

    public DocumentTypeStateEventIdFlattenedDto(DocumentTypeStateEventIdDto value)
    {
        this.value = value;
    }

    public DocumentTypeStateEventIdDto toDocumentTypeStateEventIdDto()
    {
        return this.value;
    }

    public DocumentTypeStateEventId toDocumentTypeStateEventId()
    {
        return this.value.toDocumentTypeStateEventId();
    }

    public String getDocumentTypeId()
    {
        return this.value.getDocumentTypeId();
    }

    public void setDocumentTypeId(String documentTypeId)
    {
        this.value.setDocumentTypeId(documentTypeId);
    }

    public Long getVersion()
    {
        return this.value.getVersion();
    }

    public void setVersion(Long version)
    {
        this.value.setVersion(version);
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        DocumentTypeStateEventIdFlattenedDto other = (DocumentTypeStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

