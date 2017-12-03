package org.dddml.wms.domain.documenttype;

import java.util.List;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface DocumentTypeAggregate
{
    DocumentTypeState getState();

    List<Event> getChanges();

    void create(DocumentTypeCommand.CreateDocumentType c);

    void mergePatch(DocumentTypeCommand.MergePatchDocumentType c);

    void delete(DocumentTypeCommand.DeleteDocumentType c);

    void throwOnInvalidStateTransition(Command c);
}

