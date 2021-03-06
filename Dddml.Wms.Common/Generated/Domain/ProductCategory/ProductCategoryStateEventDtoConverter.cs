﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateProductCategoryDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.ProductCategory;

namespace Dddml.Wms.Domain.ProductCategory
{

    public class ProductCategoryStateEventDtoConverter
    {
        public virtual ProductCategoryStateCreatedOrMergePatchedOrDeletedDto ToProductCategoryStateEventDto(IProductCategoryEvent stateEvent)
        {
            if (stateEvent.EventType == StateEventType.Created)
            {
                var e = (IProductCategoryStateCreated)stateEvent;
                return ToProductCategoryStateCreatedDto(e);
            }
            else if (stateEvent.EventType == StateEventType.MergePatched)
            {
                var e = (IProductCategoryStateMergePatched)stateEvent;
                return ToProductCategoryStateMergePatchedDto(e);
            }
            else if (stateEvent.EventType == StateEventType.Deleted)
            {
                var e = (IProductCategoryStateDeleted)stateEvent;
                return ToProductCategoryStateDeletedDto(e);
            }
            throw DomainError.Named("invalidEventType", String.Format("Invalid state event type: {0}", stateEvent.EventType));
        }

        public virtual ProductCategoryStateCreatedDto ToProductCategoryStateCreatedDto(IProductCategoryStateCreated e)
        {
            var dto = new ProductCategoryStateCreatedDto();
            dto.ProductCategoryEventId = e.ProductCategoryEventId;
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedBy = e.CreatedBy;
            dto.CommandId = e.CommandId;
            dto.ProductCategoryTypeId = e.ProductCategoryTypeId;
            dto.PrimaryParentCategoryId = e.PrimaryParentCategoryId;
            dto.CategoryName = e.CategoryName;
            dto.Description = e.Description;
            dto.CategoryImageUrl = e.CategoryImageUrl;
            dto.DetailScreen = e.DetailScreen;
            dto.ShowInSelect = e.ShowInSelect;
            dto.AttributeSetId = e.AttributeSetId;
            dto.Active = e.Active;
            return dto;
        }

        public virtual ProductCategoryStateMergePatchedDto ToProductCategoryStateMergePatchedDto(IProductCategoryStateMergePatched e)
        {
            var dto = new ProductCategoryStateMergePatchedDto();
            dto.ProductCategoryEventId = e.ProductCategoryEventId;
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedBy = e.CreatedBy;
            dto.CommandId = e.CommandId;
            dto.ProductCategoryTypeId = e.ProductCategoryTypeId;
            dto.PrimaryParentCategoryId = e.PrimaryParentCategoryId;
            dto.CategoryName = e.CategoryName;
            dto.Description = e.Description;
            dto.CategoryImageUrl = e.CategoryImageUrl;
            dto.DetailScreen = e.DetailScreen;
            dto.ShowInSelect = e.ShowInSelect;
            dto.AttributeSetId = e.AttributeSetId;
            dto.Active = e.Active;
            dto.IsPropertyProductCategoryTypeIdRemoved = e.IsPropertyProductCategoryTypeIdRemoved;
            dto.IsPropertyPrimaryParentCategoryIdRemoved = e.IsPropertyPrimaryParentCategoryIdRemoved;
            dto.IsPropertyCategoryNameRemoved = e.IsPropertyCategoryNameRemoved;
            dto.IsPropertyDescriptionRemoved = e.IsPropertyDescriptionRemoved;
            dto.IsPropertyCategoryImageUrlRemoved = e.IsPropertyCategoryImageUrlRemoved;
            dto.IsPropertyDetailScreenRemoved = e.IsPropertyDetailScreenRemoved;
            dto.IsPropertyShowInSelectRemoved = e.IsPropertyShowInSelectRemoved;
            dto.IsPropertyAttributeSetIdRemoved = e.IsPropertyAttributeSetIdRemoved;
            dto.IsPropertyActiveRemoved = e.IsPropertyActiveRemoved;

            return dto;
        }


        public virtual ProductCategoryStateDeletedDto ToProductCategoryStateDeletedDto(IProductCategoryStateDeleted e)
        {
            var dto = new ProductCategoryStateDeletedDto();
            dto.ProductCategoryEventId = e.ProductCategoryEventId;
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedBy = e.CreatedBy;
            dto.CommandId = e.CommandId;

            return dto;
        }


    }


}

