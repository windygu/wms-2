package org.dddml.wms.domain.documenttype;

import org.dddml.wms.domain.*;

public class DocumentTypeStateEventIdDtoWrapper extends DocumentTypeStateEventIdDto
{
	
    private DocumentTypeStateEventId value;

    public DocumentTypeStateEventIdDtoWrapper()
    {
        this(new DocumentTypeStateEventId());
    }

    public DocumentTypeStateEventIdDtoWrapper(DocumentTypeStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public DocumentTypeStateEventId toDocumentTypeStateEventId()
    {
        return this.value;
    }

    @Override
    public String getDocumentTypeId()
    {
        return this.value.getDocumentTypeId();
    }

    @Override
    public void setDocumentTypeId(String documentTypeId)
    {
        this.value.setDocumentTypeId(documentTypeId);
    }

    @Override
    public Long getVersion()
    {
        return this.value.getVersion();
    }

    @Override
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
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == DocumentTypeStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        DocumentTypeStateEventIdDtoWrapper other = (DocumentTypeStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

