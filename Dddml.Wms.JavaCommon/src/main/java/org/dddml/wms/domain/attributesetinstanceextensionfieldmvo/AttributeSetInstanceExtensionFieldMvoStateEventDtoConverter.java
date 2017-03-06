package org.dddml.wms.domain.attributesetinstanceextensionfieldmvo;

import java.util.*;
import org.dddml.wms.domain.attributesetinstanceextensionfieldgroup.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class AttributeSetInstanceExtensionFieldMvoStateEventDtoConverter {

    public AttributeSetInstanceExtensionFieldMvoStateEventDto toAttributeSetInstanceExtensionFieldMvoStateEventDto(AbstractAttributeSetInstanceExtensionFieldMvoStateEvent stateEvent) {
        if (StateEventType.CREATED.equals(stateEvent.getStateEventType())) {
            AttributeSetInstanceExtensionFieldMvoStateEvent.AttributeSetInstanceExtensionFieldMvoStateCreated e = (AttributeSetInstanceExtensionFieldMvoStateEvent.AttributeSetInstanceExtensionFieldMvoStateCreated) stateEvent;
            return toAttributeSetInstanceExtensionFieldMvoStateCreatedDto(e);
        } else if (StateEventType.MERGE_PATCHED.equals(stateEvent.getStateEventType())) {
            AttributeSetInstanceExtensionFieldMvoStateEvent.AttributeSetInstanceExtensionFieldMvoStateMergePatched e = (AttributeSetInstanceExtensionFieldMvoStateEvent.AttributeSetInstanceExtensionFieldMvoStateMergePatched) stateEvent;
            return toAttributeSetInstanceExtensionFieldMvoStateMergePatchedDto(e);
        } else if (StateEventType.DELETED.equals(stateEvent.getStateEventType())) {
            AttributeSetInstanceExtensionFieldMvoStateEvent.AttributeSetInstanceExtensionFieldMvoStateDeleted e = (AttributeSetInstanceExtensionFieldMvoStateEvent.AttributeSetInstanceExtensionFieldMvoStateDeleted) stateEvent;
            return toAttributeSetInstanceExtensionFieldMvoStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public AttributeSetInstanceExtensionFieldMvoStateEventDto.AttributeSetInstanceExtensionFieldMvoStateCreatedDto toAttributeSetInstanceExtensionFieldMvoStateCreatedDto(AttributeSetInstanceExtensionFieldMvoStateEvent.AttributeSetInstanceExtensionFieldMvoStateCreated e) {
        AttributeSetInstanceExtensionFieldMvoStateEventDto.AttributeSetInstanceExtensionFieldMvoStateCreatedDto dto = new AttributeSetInstanceExtensionFieldMvoStateEventDto.AttributeSetInstanceExtensionFieldMvoStateCreatedDto();
        dto.setStateEventId(new AttributeSetInstanceExtensionFieldMvoStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setName(e.getName());
        dto.setType(e.getType());
        dto.setLength(e.getLength());
        dto.setAlias(e.getAlias());
        dto.setDescription(e.getDescription());
        dto.setVersion(e.getVersion());
        dto.setActive(e.getActive());
        dto.setAttrSetInstEFGroupFieldType(e.getAttrSetInstEFGroupFieldType());
        dto.setAttrSetInstEFGroupFieldLength(e.getAttrSetInstEFGroupFieldLength());
        dto.setAttrSetInstEFGroupFieldCount(e.getAttrSetInstEFGroupFieldCount());
        dto.setAttrSetInstEFGroupNameFormat(e.getAttrSetInstEFGroupNameFormat());
        dto.setAttrSetInstEFGroupDescription(e.getAttrSetInstEFGroupDescription());
        dto.setAttrSetInstEFGroupCreatedBy(e.getAttrSetInstEFGroupCreatedBy());
        dto.setAttrSetInstEFGroupCreatedAt(e.getAttrSetInstEFGroupCreatedAt());
        dto.setAttrSetInstEFGroupUpdatedBy(e.getAttrSetInstEFGroupUpdatedBy());
        dto.setAttrSetInstEFGroupUpdatedAt(e.getAttrSetInstEFGroupUpdatedAt());
        dto.setAttrSetInstEFGroupActive(e.getAttrSetInstEFGroupActive());
        dto.setAttrSetInstEFGroupDeleted(e.getAttrSetInstEFGroupDeleted());
        return dto;
    }

    public AttributeSetInstanceExtensionFieldMvoStateEventDto.AttributeSetInstanceExtensionFieldMvoStateMergePatchedDto toAttributeSetInstanceExtensionFieldMvoStateMergePatchedDto(AttributeSetInstanceExtensionFieldMvoStateEvent.AttributeSetInstanceExtensionFieldMvoStateMergePatched e) {
        AttributeSetInstanceExtensionFieldMvoStateEventDto.AttributeSetInstanceExtensionFieldMvoStateMergePatchedDto dto = new AttributeSetInstanceExtensionFieldMvoStateEventDto.AttributeSetInstanceExtensionFieldMvoStateMergePatchedDto();
        dto.setStateEventId(new AttributeSetInstanceExtensionFieldMvoStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setName(e.getName());
        dto.setType(e.getType());
        dto.setLength(e.getLength());
        dto.setAlias(e.getAlias());
        dto.setDescription(e.getDescription());
        dto.setVersion(e.getVersion());
        dto.setActive(e.getActive());
        dto.setAttrSetInstEFGroupFieldType(e.getAttrSetInstEFGroupFieldType());
        dto.setAttrSetInstEFGroupFieldLength(e.getAttrSetInstEFGroupFieldLength());
        dto.setAttrSetInstEFGroupFieldCount(e.getAttrSetInstEFGroupFieldCount());
        dto.setAttrSetInstEFGroupNameFormat(e.getAttrSetInstEFGroupNameFormat());
        dto.setAttrSetInstEFGroupDescription(e.getAttrSetInstEFGroupDescription());
        dto.setAttrSetInstEFGroupCreatedBy(e.getAttrSetInstEFGroupCreatedBy());
        dto.setAttrSetInstEFGroupCreatedAt(e.getAttrSetInstEFGroupCreatedAt());
        dto.setAttrSetInstEFGroupUpdatedBy(e.getAttrSetInstEFGroupUpdatedBy());
        dto.setAttrSetInstEFGroupUpdatedAt(e.getAttrSetInstEFGroupUpdatedAt());
        dto.setAttrSetInstEFGroupActive(e.getAttrSetInstEFGroupActive());
        dto.setAttrSetInstEFGroupDeleted(e.getAttrSetInstEFGroupDeleted());
        dto.setIsPropertyNameRemoved(e.getIsPropertyNameRemoved());
        dto.setIsPropertyTypeRemoved(e.getIsPropertyTypeRemoved());
        dto.setIsPropertyLengthRemoved(e.getIsPropertyLengthRemoved());
        dto.setIsPropertyAliasRemoved(e.getIsPropertyAliasRemoved());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        dto.setIsPropertyVersionRemoved(e.getIsPropertyVersionRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        dto.setIsPropertyAttrSetInstEFGroupFieldTypeRemoved(e.getIsPropertyAttrSetInstEFGroupFieldTypeRemoved());
        dto.setIsPropertyAttrSetInstEFGroupFieldLengthRemoved(e.getIsPropertyAttrSetInstEFGroupFieldLengthRemoved());
        dto.setIsPropertyAttrSetInstEFGroupFieldCountRemoved(e.getIsPropertyAttrSetInstEFGroupFieldCountRemoved());
        dto.setIsPropertyAttrSetInstEFGroupNameFormatRemoved(e.getIsPropertyAttrSetInstEFGroupNameFormatRemoved());
        dto.setIsPropertyAttrSetInstEFGroupDescriptionRemoved(e.getIsPropertyAttrSetInstEFGroupDescriptionRemoved());
        dto.setIsPropertyAttrSetInstEFGroupCreatedByRemoved(e.getIsPropertyAttrSetInstEFGroupCreatedByRemoved());
        dto.setIsPropertyAttrSetInstEFGroupCreatedAtRemoved(e.getIsPropertyAttrSetInstEFGroupCreatedAtRemoved());
        dto.setIsPropertyAttrSetInstEFGroupUpdatedByRemoved(e.getIsPropertyAttrSetInstEFGroupUpdatedByRemoved());
        dto.setIsPropertyAttrSetInstEFGroupUpdatedAtRemoved(e.getIsPropertyAttrSetInstEFGroupUpdatedAtRemoved());
        dto.setIsPropertyAttrSetInstEFGroupActiveRemoved(e.getIsPropertyAttrSetInstEFGroupActiveRemoved());
        dto.setIsPropertyAttrSetInstEFGroupDeletedRemoved(e.getIsPropertyAttrSetInstEFGroupDeletedRemoved());
        return dto;
    }


    public AttributeSetInstanceExtensionFieldMvoStateEventDto.AttributeSetInstanceExtensionFieldMvoStateDeletedDto toAttributeSetInstanceExtensionFieldMvoStateDeletedDto(AttributeSetInstanceExtensionFieldMvoStateEvent.AttributeSetInstanceExtensionFieldMvoStateDeleted e) {
        AttributeSetInstanceExtensionFieldMvoStateEventDto.AttributeSetInstanceExtensionFieldMvoStateDeletedDto dto = new AttributeSetInstanceExtensionFieldMvoStateEventDto.AttributeSetInstanceExtensionFieldMvoStateDeletedDto();
        dto.setStateEventId(new AttributeSetInstanceExtensionFieldMvoStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

