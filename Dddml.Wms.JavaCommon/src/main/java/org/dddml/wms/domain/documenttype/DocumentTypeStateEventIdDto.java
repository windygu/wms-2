package org.dddml.wms.domain.documenttype;

import org.dddml.wms.domain.*;

public class DocumentTypeStateEventIdDto
{

    public DocumentTypeStateEventIdDto()
    {
    }

    public DocumentTypeStateEventId toDocumentTypeStateEventId()
    {
        DocumentTypeStateEventId v = new DocumentTypeStateEventId();
        v.setDocumentTypeId(this.getDocumentTypeId());
        v.setVersion(this.getVersion());
        return v;
    }

    private String documentTypeId;

    public String getDocumentTypeId()
    {
        return this.documentTypeId;
    }

    public void setDocumentTypeId(String documentTypeId)
    {
        this.documentTypeId = documentTypeId;
    }

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != DocumentTypeStateEventIdDto.class) {
            return false;
        }

        DocumentTypeStateEventIdDto other = (DocumentTypeStateEventIdDto)obj;
        return true 
            && (getDocumentTypeId() == other.getDocumentTypeId() || (getDocumentTypeId() != null && getDocumentTypeId().equals(other.getDocumentTypeId())))
            && (getVersion() == other.getVersion() || (getVersion() != null && getVersion().equals(other.getVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getDocumentTypeId() != null) {
            hash += 13 * this.getDocumentTypeId().hashCode();
        }
        if (this.getVersion() != null) {
            hash += 13 * this.getVersion().hashCode();
        }
        return hash;
    }

}

