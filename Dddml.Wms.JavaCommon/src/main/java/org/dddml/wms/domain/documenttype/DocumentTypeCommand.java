package org.dddml.wms.domain.documenttype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;

public interface DocumentTypeCommand extends Command
{
    String getDocumentTypeId();

    void setDocumentTypeId(String documentTypeId);

    Long getVersion();

    void setVersion(Long version);


    interface CreateOrMergePatchDocumentType extends DocumentTypeCommand
    {
        String getDescription();

        void setDescription(String description);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateDocumentType extends CreateOrMergePatchDocumentType
    {
    }

    interface MergePatchDocumentType extends CreateOrMergePatchDocumentType
    {
        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

    }

	interface DeleteDocumentType extends DocumentTypeCommand
	{
	}

}

