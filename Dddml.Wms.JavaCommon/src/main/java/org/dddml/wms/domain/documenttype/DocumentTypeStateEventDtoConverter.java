package org.dddml.wms.domain.documenttype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class DocumentTypeStateEventDtoConverter {

    public DocumentTypeStateEventDto toDocumentTypeStateEventDto(AbstractDocumentTypeStateEvent stateEvent) {
        if (stateEvent instanceof AbstractDocumentTypeStateEvent.AbstractDocumentTypeStateCreated) {
            DocumentTypeStateEvent.DocumentTypeStateCreated e = (DocumentTypeStateEvent.DocumentTypeStateCreated) stateEvent;
            return toDocumentTypeStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractDocumentTypeStateEvent.AbstractDocumentTypeStateMergePatched) {
            DocumentTypeStateEvent.DocumentTypeStateMergePatched e = (DocumentTypeStateEvent.DocumentTypeStateMergePatched) stateEvent;
            return toDocumentTypeStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractDocumentTypeStateEvent.AbstractDocumentTypeStateDeleted) {
            DocumentTypeStateEvent.DocumentTypeStateDeleted e = (DocumentTypeStateEvent.DocumentTypeStateDeleted) stateEvent;
            return toDocumentTypeStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public DocumentTypeStateEventDto.DocumentTypeStateCreatedDto toDocumentTypeStateCreatedDto(DocumentTypeStateEvent.DocumentTypeStateCreated e) {
        DocumentTypeStateEventDto.DocumentTypeStateCreatedDto dto = new DocumentTypeStateEventDto.DocumentTypeStateCreatedDto();
        dto.setStateEventId(new DocumentTypeStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setDescription(e.getDescription());
        dto.setActive(e.getActive());
        return dto;
    }

    public DocumentTypeStateEventDto.DocumentTypeStateMergePatchedDto toDocumentTypeStateMergePatchedDto(DocumentTypeStateEvent.DocumentTypeStateMergePatched e) {
        DocumentTypeStateEventDto.DocumentTypeStateMergePatchedDto dto = new DocumentTypeStateEventDto.DocumentTypeStateMergePatchedDto();
        dto.setStateEventId(new DocumentTypeStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setDescription(e.getDescription());
        dto.setActive(e.getActive());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public DocumentTypeStateEventDto.DocumentTypeStateDeletedDto toDocumentTypeStateDeletedDto(DocumentTypeStateEvent.DocumentTypeStateDeleted e) {
        DocumentTypeStateEventDto.DocumentTypeStateDeletedDto dto = new DocumentTypeStateEventDto.DocumentTypeStateDeletedDto();
        dto.setStateEventId(new DocumentTypeStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

