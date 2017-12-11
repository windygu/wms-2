package org.dddml.wms.domain.documenttype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface DocumentTypeCommand extends Command
{
    String getDocumentTypeId();

    void setDocumentTypeId(String documentTypeId);

    Long getVersion();

    void setVersion(Long version);

    static void throwOnInvalidStateTransition(DocumentTypeState state, Command c) {
        if (state.getVersion() == null)
        {
            if (isCommandCreate((DocumentTypeCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (state.getDeleted())
        {
            throw DomainError.named("zombie", "Can't do anything to deleted aggregate.");
        }
        if (isCommandCreate((DocumentTypeCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(DocumentTypeCommand c) {
        return ((c instanceof DocumentTypeCommand.CreateDocumentType) 
            && c.getVersion().equals(DocumentTypeState.VERSION_NULL));
    }

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

