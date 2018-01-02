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

    public partial class ProductCategoryStateDto : IProductCategoryStateDto
    {
        public virtual string ProductCategoryId
        {
            get;
            set;
        }

        public virtual string ProductCategoryTypeId
        {
            get;
            set;
        }

        public virtual string PrimaryParentCategoryId
        {
            get;
            set;
        }

        public virtual string CategoryName
        {
            get;
            set;
        }

        public virtual string Description
        {
            get;
            set;
        }

        public virtual string CategoryImageUrl
        {
            get;
            set;
        }

        public virtual string DetailScreen
        {
            get;
            set;
        }

        public virtual bool? ShowInSelect
        {
            get;
            set;
        }

        public virtual string AttributeSetId
        {
            get;
            set;
        }

        public virtual bool? Active
        {
            get;
            set;
        }

        public virtual long? Version
        {
            get;
            set;
        }

        public virtual string CreatedBy
        {
            get;
            set;
        }

        public virtual DateTime? CreatedAt
        {
            get;
            set;
        }

        public virtual string UpdatedBy
        {
            get;
            set;
        }

        public virtual DateTime? UpdatedAt
        {
            get;
            set;
        }

        public virtual IProductCategoryState ToProductCategoryState()
        {
            var state = new ProductCategoryState(true);
            state.ProductCategoryId = this.ProductCategoryId;
            state.ProductCategoryTypeId = this.ProductCategoryTypeId;
            state.PrimaryParentCategoryId = this.PrimaryParentCategoryId;
            state.CategoryName = this.CategoryName;
            state.Description = this.Description;
            state.CategoryImageUrl = this.CategoryImageUrl;
            state.DetailScreen = this.DetailScreen;
            if (this.ShowInSelect != null && this.ShowInSelect.HasValue) { state.ShowInSelect = this.ShowInSelect.Value; }
            state.AttributeSetId = this.AttributeSetId;
            if (this.Active != null && this.Active.HasValue) { state.Active = this.Active.Value; }
            if (this.Version != null && this.Version.HasValue) { state.Version = this.Version.Value; }
            state.CreatedBy = this.CreatedBy;
            if (this.CreatedAt != null && this.CreatedAt.HasValue) { state.CreatedAt = this.CreatedAt.Value; }
            state.UpdatedBy = this.UpdatedBy;
            if (this.UpdatedAt != null && this.UpdatedAt.HasValue) { state.UpdatedAt = this.UpdatedAt.Value; }

            return state;
        }

    }

}

