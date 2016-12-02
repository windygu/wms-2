﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateBoundedContextDomainAggregates.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;

namespace Dddml.Wms.Domain
{

    public class AttributeSetInstanceExtensionFieldMvoStateEventDtoConverter
    {
        public virtual AttributeSetInstanceExtensionFieldMvoStateCreatedOrMergePatchedOrDeletedDto ToAttributeSetInstanceExtensionFieldMvoStateEventDto(IAttributeSetInstanceExtensionFieldMvoStateEvent stateEvent)
        {
            if (stateEvent.StateEventType == StateEventType.Created)
            {
                var e = (IAttributeSetInstanceExtensionFieldMvoStateCreated)stateEvent;
                return ToAttributeSetInstanceExtensionFieldMvoStateCreatedDto(e);
            }
            else if (stateEvent.StateEventType == StateEventType.MergePatched)
            {
                var e = (IAttributeSetInstanceExtensionFieldMvoStateMergePatched)stateEvent;
                return ToAttributeSetInstanceExtensionFieldMvoStateMergePatchedDto(e);
            }
            else if (stateEvent.StateEventType == StateEventType.Deleted)
            {
                var e = (IAttributeSetInstanceExtensionFieldMvoStateDeleted)stateEvent;
                return ToAttributeSetInstanceExtensionFieldMvoStateDeletedDto(e);
            }

            throw DomainError.Named("invalidStateEventType", String.Format("Invalid state event type: {0}", stateEvent.StateEventType));
        }

        public virtual AttributeSetInstanceExtensionFieldMvoStateCreatedDto ToAttributeSetInstanceExtensionFieldMvoStateCreatedDto(IAttributeSetInstanceExtensionFieldMvoStateCreated e)
        {
            var dto = new AttributeSetInstanceExtensionFieldMvoStateCreatedDto();
            dto.StateEventId = new AttributeSetInstanceExtensionFieldMvoStateEventIdDtoWrapper(e.StateEventId);
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedBy = e.CreatedBy;
            dto.CommandId = e.CommandId;
            dto.Name = e.Name;
            dto.Type = e.Type;
            dto.Length = e.Length;
            dto.Alias = e.Alias;
            dto.Description = e.Description;
            dto.Version = e.Version;
            dto.Active = e.Active;
            dto.AttrSetInstEFGroupFieldType = e.AttrSetInstEFGroupFieldType;
            dto.AttrSetInstEFGroupFieldLength = e.AttrSetInstEFGroupFieldLength;
            dto.AttrSetInstEFGroupFieldCount = e.AttrSetInstEFGroupFieldCount;
            dto.AttrSetInstEFGroupNameFormat = e.AttrSetInstEFGroupNameFormat;
            dto.AttrSetInstEFGroupDescription = e.AttrSetInstEFGroupDescription;
            dto.AttrSetInstEFGroupCreatedBy = e.AttrSetInstEFGroupCreatedBy;
            dto.AttrSetInstEFGroupCreatedAt = e.AttrSetInstEFGroupCreatedAt;
            dto.AttrSetInstEFGroupUpdatedBy = e.AttrSetInstEFGroupUpdatedBy;
            dto.AttrSetInstEFGroupUpdatedAt = e.AttrSetInstEFGroupUpdatedAt;
            dto.AttrSetInstEFGroupActive = e.AttrSetInstEFGroupActive;
            dto.AttrSetInstEFGroupDeleted = e.AttrSetInstEFGroupDeleted;
            return dto;
        }

        public virtual AttributeSetInstanceExtensionFieldMvoStateMergePatchedDto ToAttributeSetInstanceExtensionFieldMvoStateMergePatchedDto(IAttributeSetInstanceExtensionFieldMvoStateMergePatched e)
        {
            var dto = new AttributeSetInstanceExtensionFieldMvoStateMergePatchedDto();
            dto.StateEventId = new AttributeSetInstanceExtensionFieldMvoStateEventIdDtoWrapper(e.StateEventId);
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedBy = e.CreatedBy;
            dto.CommandId = e.CommandId;
            dto.Name = e.Name;
            dto.Type = e.Type;
            dto.Length = e.Length;
            dto.Alias = e.Alias;
            dto.Description = e.Description;
            dto.Version = e.Version;
            dto.Active = e.Active;
            dto.AttrSetInstEFGroupFieldType = e.AttrSetInstEFGroupFieldType;
            dto.AttrSetInstEFGroupFieldLength = e.AttrSetInstEFGroupFieldLength;
            dto.AttrSetInstEFGroupFieldCount = e.AttrSetInstEFGroupFieldCount;
            dto.AttrSetInstEFGroupNameFormat = e.AttrSetInstEFGroupNameFormat;
            dto.AttrSetInstEFGroupDescription = e.AttrSetInstEFGroupDescription;
            dto.AttrSetInstEFGroupCreatedBy = e.AttrSetInstEFGroupCreatedBy;
            dto.AttrSetInstEFGroupCreatedAt = e.AttrSetInstEFGroupCreatedAt;
            dto.AttrSetInstEFGroupUpdatedBy = e.AttrSetInstEFGroupUpdatedBy;
            dto.AttrSetInstEFGroupUpdatedAt = e.AttrSetInstEFGroupUpdatedAt;
            dto.AttrSetInstEFGroupActive = e.AttrSetInstEFGroupActive;
            dto.AttrSetInstEFGroupDeleted = e.AttrSetInstEFGroupDeleted;
            dto.IsPropertyNameRemoved = e.IsPropertyNameRemoved;
            dto.IsPropertyTypeRemoved = e.IsPropertyTypeRemoved;
            dto.IsPropertyLengthRemoved = e.IsPropertyLengthRemoved;
            dto.IsPropertyAliasRemoved = e.IsPropertyAliasRemoved;
            dto.IsPropertyDescriptionRemoved = e.IsPropertyDescriptionRemoved;
            dto.IsPropertyVersionRemoved = e.IsPropertyVersionRemoved;
            dto.IsPropertyActiveRemoved = e.IsPropertyActiveRemoved;
            dto.IsPropertyAttrSetInstEFGroupFieldTypeRemoved = e.IsPropertyAttrSetInstEFGroupFieldTypeRemoved;
            dto.IsPropertyAttrSetInstEFGroupFieldLengthRemoved = e.IsPropertyAttrSetInstEFGroupFieldLengthRemoved;
            dto.IsPropertyAttrSetInstEFGroupFieldCountRemoved = e.IsPropertyAttrSetInstEFGroupFieldCountRemoved;
            dto.IsPropertyAttrSetInstEFGroupNameFormatRemoved = e.IsPropertyAttrSetInstEFGroupNameFormatRemoved;
            dto.IsPropertyAttrSetInstEFGroupDescriptionRemoved = e.IsPropertyAttrSetInstEFGroupDescriptionRemoved;
            dto.IsPropertyAttrSetInstEFGroupCreatedByRemoved = e.IsPropertyAttrSetInstEFGroupCreatedByRemoved;
            dto.IsPropertyAttrSetInstEFGroupCreatedAtRemoved = e.IsPropertyAttrSetInstEFGroupCreatedAtRemoved;
            dto.IsPropertyAttrSetInstEFGroupUpdatedByRemoved = e.IsPropertyAttrSetInstEFGroupUpdatedByRemoved;
            dto.IsPropertyAttrSetInstEFGroupUpdatedAtRemoved = e.IsPropertyAttrSetInstEFGroupUpdatedAtRemoved;
            dto.IsPropertyAttrSetInstEFGroupActiveRemoved = e.IsPropertyAttrSetInstEFGroupActiveRemoved;
            dto.IsPropertyAttrSetInstEFGroupDeletedRemoved = e.IsPropertyAttrSetInstEFGroupDeletedRemoved;

            return dto;
        }


        public virtual AttributeSetInstanceExtensionFieldMvoStateDeletedDto ToAttributeSetInstanceExtensionFieldMvoStateDeletedDto(IAttributeSetInstanceExtensionFieldMvoStateDeleted e)
        {
            var dto = new AttributeSetInstanceExtensionFieldMvoStateDeletedDto();
            dto.StateEventId = new AttributeSetInstanceExtensionFieldMvoStateEventIdDtoWrapper(e.StateEventId);
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedBy = e.CreatedBy;
            dto.CommandId = e.CommandId;

            return dto;
        }


    }


}

