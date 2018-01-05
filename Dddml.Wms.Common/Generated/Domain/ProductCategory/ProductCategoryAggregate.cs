﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateProductCategoryDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.ProductCategory;

namespace Dddml.Wms.Domain.ProductCategory
{
    public partial class ProductCategoryAggregate : AggregateBase, IProductCategoryAggregate
    {

        readonly IProductCategoryState _state;

        readonly IList<IEvent> _changes = new List<IEvent>();

        public IProductCategoryState State
        {
            get
            {
                return _state;
            }
        }

        public IList<IEvent> Changes
        {
            get
            {
                return _changes;
            }
        }

        #region IIdentity implementation

        string IGlobalIdentity<string>.GlobalId
        {
            get
            {
                return this._state.GlobalId;
            }
        }

        #endregion


        public ProductCategoryAggregate(IProductCategoryState state)
        {
            _state = state;
        }


        public virtual void ThrowOnInvalidStateTransition(ICommand c)
        {
            if (((IProductCategoryStateProperties)_state).Version == ProductCategoryState.VersionZero)
            {
                if (IsCommandCreate((IProductCategoryCommand)c))
                {
                    return;
                }
                throw DomainError.Named("premature", "Can't do anything to unexistent aggregate");
            }
            if (_state.Deleted)
            {
                throw DomainError.Named("zombie", "Can't do anything to deleted aggregate.");
            }
            if (IsCommandCreate((IProductCategoryCommand)c))
                throw DomainError.Named("rebirth", "Can't create aggregate that already exists");
        }

        private static bool IsCommandCreate(IProductCategoryCommand c)
        {
            return c.Version == ProductCategoryState.VersionZero;
        }

        protected internal virtual void Apply(IEvent e)
        {
            OnApplying(e);
            _state.Mutate(e);
            _changes.Add(e);
        }

        public virtual void Create(ICreateProductCategory c)
        {
            IProductCategoryStateCreated e = Map(c);
            Apply(e);
        }

        public virtual void MergePatch(IMergePatchProductCategory c)
        {
            IProductCategoryStateMergePatched e = Map(c);
            Apply(e);
        }

        public virtual void Delete(IDeleteProductCategory c)
        {
            IProductCategoryStateDeleted e = Map(c);
            Apply(e);
        }


        protected virtual IProductCategoryStateCreated Map(ICreateProductCategory c)
        {
			var stateEventId = new ProductCategoryStateEventId(c.ProductCategoryId, c.Version);
            IProductCategoryStateCreated e = NewProductCategoryStateCreated(stateEventId);
		
            e.ProductCategoryTypeId = c.ProductCategoryTypeId;
            e.PrimaryParentCategoryId = c.PrimaryParentCategoryId;
            e.CategoryName = c.CategoryName;
            e.Description = c.Description;
            e.CategoryImageUrl = c.CategoryImageUrl;
            e.DetailScreen = c.DetailScreen;
            e.ShowInSelect = c.ShowInSelect;
            e.AttributeSetId = c.AttributeSetId;
            e.Active = c.Active;
            e.CommandId = c.CommandId;


            e.CreatedBy = (string)c.RequesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();
			var version = c.Version;


            return e;
        }

        protected virtual IProductCategoryStateMergePatched Map(IMergePatchProductCategory c)
        {
			var stateEventId = new ProductCategoryStateEventId(c.ProductCategoryId, c.Version);
            IProductCategoryStateMergePatched e = NewProductCategoryStateMergePatched(stateEventId);

            e.ProductCategoryTypeId = c.ProductCategoryTypeId;
            e.PrimaryParentCategoryId = c.PrimaryParentCategoryId;
            e.CategoryName = c.CategoryName;
            e.Description = c.Description;
            e.CategoryImageUrl = c.CategoryImageUrl;
            e.DetailScreen = c.DetailScreen;
            e.ShowInSelect = c.ShowInSelect;
            e.AttributeSetId = c.AttributeSetId;
            e.Active = c.Active;
            e.IsPropertyProductCategoryTypeIdRemoved = c.IsPropertyProductCategoryTypeIdRemoved;
            e.IsPropertyPrimaryParentCategoryIdRemoved = c.IsPropertyPrimaryParentCategoryIdRemoved;
            e.IsPropertyCategoryNameRemoved = c.IsPropertyCategoryNameRemoved;
            e.IsPropertyDescriptionRemoved = c.IsPropertyDescriptionRemoved;
            e.IsPropertyCategoryImageUrlRemoved = c.IsPropertyCategoryImageUrlRemoved;
            e.IsPropertyDetailScreenRemoved = c.IsPropertyDetailScreenRemoved;
            e.IsPropertyShowInSelectRemoved = c.IsPropertyShowInSelectRemoved;
            e.IsPropertyAttributeSetIdRemoved = c.IsPropertyAttributeSetIdRemoved;
            e.IsPropertyActiveRemoved = c.IsPropertyActiveRemoved;

            e.CommandId = c.CommandId;


            e.CreatedBy = (string)c.RequesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();

			var version = c.Version;


            return e;
        }

        protected virtual IProductCategoryStateDeleted Map(IDeleteProductCategory c)
        {
			var stateEventId = new ProductCategoryStateEventId(c.ProductCategoryId, c.Version);
            IProductCategoryStateDeleted e = NewProductCategoryStateDeleted(stateEventId);
			
            e.CommandId = c.CommandId;


            e.CreatedBy = (string)c.RequesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();


            return e;
        }

        private void ThrowOnInconsistentIds(object innerObject, string innerIdName, object innerIdValue, string outerIdName, object outerIdValue)
        {
            if (!Object.Equals(innerIdValue, outerIdValue))
            {
                if (innerIdValue is string && outerIdValue is string && ((string)innerIdValue).Normalize() == ((string)outerIdValue).Normalize())
                {
                    return;
                }
                throw DomainError.Named("inconsistentId", "Outer {0} {1} NOT equals inner {2} {3}", outerIdName, outerIdValue, innerIdName, innerIdValue);
            }
        }

////////////////////////

        protected ProductCategoryStateCreated NewProductCategoryStateCreated(string commandId, string requesterId)
        {
            var stateEventId = new ProductCategoryStateEventId(_state.ProductCategoryId, ((IProductCategoryStateProperties)_state).Version);
            var e = NewProductCategoryStateCreated(stateEventId);

            e.CommandId = commandId;

            e.CreatedBy = (string)requesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();

            return e;
        }

        protected ProductCategoryStateMergePatched NewProductCategoryStateMergePatched(string commandId, string requesterId)
        {
            var stateEventId = new ProductCategoryStateEventId(_state.ProductCategoryId, ((IProductCategoryStateProperties)_state).Version);
            var e = NewProductCategoryStateMergePatched(stateEventId);

            e.CommandId = commandId;

            e.CreatedBy = (string)requesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();

            return e;
        }


        protected ProductCategoryStateDeleted NewProductCategoryStateDeleted(string commandId, string requesterId)
        {
            var stateEventId = new ProductCategoryStateEventId(_state.ProductCategoryId, ((IProductCategoryStateProperties)_state).Version);
            var e = NewProductCategoryStateDeleted(stateEventId);

            e.CommandId = commandId;

            e.CreatedBy = (string)requesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();

            return e;
        }

////////////////////////

		private ProductCategoryStateCreated NewProductCategoryStateCreated(ProductCategoryStateEventId stateEventId)
		{
			return new ProductCategoryStateCreated(stateEventId);			
		}

        private ProductCategoryStateMergePatched NewProductCategoryStateMergePatched(ProductCategoryStateEventId stateEventId)
		{
			return new ProductCategoryStateMergePatched(stateEventId);
		}

        private ProductCategoryStateDeleted NewProductCategoryStateDeleted(ProductCategoryStateEventId stateEventId)
		{
			return new ProductCategoryStateDeleted(stateEventId);
		}
    }

}

