package org.dddml.wms.domain.documenttype;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class DocumentTypeStateEventId implements Serializable
{
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

    public DocumentTypeStateEventId()
    {
    }

    public DocumentTypeStateEventId(String documentTypeId, Long version)
    {
        this.documentTypeId = documentTypeId;
        this.version = version;
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

        DocumentTypeStateEventId other = (DocumentTypeStateEventId)obj;
        return true 
            && (documentTypeId == other.documentTypeId || (documentTypeId != null && documentTypeId.equals(other.documentTypeId)))
            && (version == other.version || (version != null && version.equals(other.version)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.documentTypeId != null) {
            hash += 13 * this.documentTypeId.hashCode();
        }
        if (this.version != null) {
            hash += 13 * this.version.hashCode();
        }
        return hash;
    }

}

