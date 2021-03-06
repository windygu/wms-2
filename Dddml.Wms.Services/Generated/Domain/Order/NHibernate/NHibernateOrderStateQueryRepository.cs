﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateOrderDomainNHibernate.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Order;
using Dddml.Wms.Domain.PartyRole;
using Dddml.Wms.Specialization.NHibernate;
using NHibernate;
using NHibernate.Criterion;
using Spring.Transaction.Interceptor;
using Dddml.Support.Criterion;
using NHibernateICriterion = NHibernate.Criterion.ICriterion;
using NHibernateRestrictions = NHibernate.Criterion.Restrictions;
using NHibernateDisjunction = NHibernate.Criterion.Disjunction;

namespace Dddml.Wms.Domain.Order.NHibernate
{

	public partial class NHibernateOrderStateQueryRepository : IOrderStateQueryRepository
	{
		public ISessionFactory SessionFactory { get; set; }

		protected ISession CurrentSession {
			get { return this.SessionFactory.GetCurrentSession (); }
		}

        private static readonly ISet<string> _readOnlyPropertyNames = new SortedSet<string>(new String[] { "OrderId", "OrderTypeId", "OrderName", "ExternalId", "SalesChannelEnumId", "OrderDate", "Priority", "EntryDate", "PickSheetPrintedDate", "StatusId", "CurrencyUomId", "SyncStatusId", "BillingAccountId", "OriginFacilityId", "WebSiteId", "ProductStoreId", "TerminalId", "TransactionId", "AutoOrderShoppingListId", "NeedsInventoryIssuance", "IsRushOrder", "InternalCode", "RemainingSubTotal", "GrandTotal", "InvoicePerShipment", "OrderItems", "OrderRoles", "OrderShipGroups", "Version", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted" });
    
        public IReadOnlyProxyGenerator ReadOnlyProxyGenerator { get; set; }

		public NHibernateOrderStateQueryRepository ()
		{
		}

		[Transaction (ReadOnly = true)]
		public IOrderState Get(string id)
		{
			IOrderState state = CurrentSession.Get<OrderState>(id);
            if (ReadOnlyProxyGenerator != null && state != null)
            {
                return ReadOnlyProxyGenerator.CreateProxy<IOrderState>(state, new Type[] { typeof(ISaveable) }, _readOnlyPropertyNames);
            }
			return state;
		}

        [Transaction(ReadOnly = true)]
        public IEnumerable<IOrderState> GetAll(int firstResult, int maxResults)
        {
            var criteria = CurrentSession.CreateCriteria<OrderState>();
            criteria.SetFirstResult(firstResult);
            criteria.SetMaxResults(maxResults);
            AddNotDeletedRestriction(criteria);
            return criteria.List<OrderState>();
        }

        [Transaction(ReadOnly = true)]
        public virtual IEnumerable<IOrderState> Get(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
        {
            var criteria = CurrentSession.CreateCriteria<OrderState>();

            NHibernateUtils.CriteriaAddFilterAndOrdersAndSetFirstResultAndMaxResults(criteria, filter, orders, firstResult, maxResults);
            AddNotDeletedRestriction(criteria);
            return criteria.List<OrderState>();
        }

        [Transaction(ReadOnly = true)]
        public virtual IEnumerable<IOrderState> Get(Dddml.Support.Criterion.ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
        {
            var criteria = CurrentSession.CreateCriteria<OrderState>();

            NHibernateUtils.CriteriaAddFilterAndOrdersAndSetFirstResultAndMaxResults(criteria, filter, orders, firstResult, maxResults);
            AddNotDeletedRestriction(criteria);
            return criteria.List<OrderState>();
        }


        [Transaction(ReadOnly = true)]
        public virtual IOrderState GetFirst(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null)
        {
            var list = (IList<OrderState>)Get(filter, orders, 0, 1);
            if (list == null || list.Count <= 0)
            {
                return null;
            }
            return list[0];
        }

        [Transaction(ReadOnly = true)]
        public virtual IOrderState GetFirst(KeyValuePair<string, object> keyValue, IList<string> orders = null)
        {
            return GetFirst(new KeyValuePair<string, object>[] { keyValue }, orders);
        }

        [Transaction(ReadOnly = true)]
        public virtual IEnumerable<IOrderState> GetByProperty(string propertyName, object propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
        {
            var filter = new KeyValuePair<string, object>[] { new KeyValuePair<string, object>(propertyName, propertyValue) };
            return Get(filter, orders, firstResult, maxResults);
        }

        [Transaction(ReadOnly = true)]
        public virtual long GetCount(IEnumerable<KeyValuePair<string, object>> filter)
        {
            var criteria = CurrentSession.CreateCriteria<OrderState>();
            criteria.SetProjection(Projections.RowCountInt64());
            NHibernateUtils.CriteriaAddFilter(criteria, filter);
            AddNotDeletedRestriction(criteria);
            return criteria.UniqueResult<long>();
        }

        [Transaction(ReadOnly = true)]
        public virtual long GetCount(Dddml.Support.Criterion.ICriterion filter)
        {
            var criteria = CurrentSession.CreateCriteria<OrderState>();
            criteria.SetProjection(Projections.RowCountInt64());
            if (filter != null)
            {
                NHibernateICriterion hc = CriterionUtils.ToNHibernateCriterion(filter);
                criteria.Add(hc);
            }
            AddNotDeletedRestriction(criteria);
            return criteria.UniqueResult<long>();
        }

        [Transaction(ReadOnly = true)]
        public virtual IOrderRoleState GetOrderRole(string orderId, PartyRoleId partyRoleId)
        {
            var entityId = new OrderRoleId(orderId, partyRoleId);
            return CurrentSession.Get<OrderRoleState>(entityId);
        }

        [Transaction(ReadOnly = true)]
        public IEnumerable<IOrderRoleState> GetOrderRoles(string orderId)
        {
            var criteria = CurrentSession.CreateCriteria<OrderRoleState>();
            var partIdCondition = global::NHibernate.Criterion.Restrictions.Conjunction()
                .Add(global::NHibernate.Criterion.Restrictions.Eq("OrderRoleId.OrderId", orderId))
                ;

            return criteria.Add(partIdCondition).List<OrderRoleState>();
        }

        [Transaction(ReadOnly = true)]
        public virtual IOrderItemState GetOrderItem(string orderId, string orderItemSeqId)
        {
            var entityId = new OrderItemId(orderId, orderItemSeqId);
            return CurrentSession.Get<OrderItemState>(entityId);
        }

        [Transaction(ReadOnly = true)]
        public IEnumerable<IOrderItemState> GetOrderItems(string orderId)
        {
            var criteria = CurrentSession.CreateCriteria<OrderItemState>();
            var partIdCondition = global::NHibernate.Criterion.Restrictions.Conjunction()
                .Add(global::NHibernate.Criterion.Restrictions.Eq("OrderItemId.OrderId", orderId))
                ;

            return criteria.Add(partIdCondition).List<OrderItemState>();
        }

        [Transaction(ReadOnly = true)]
        public virtual IOrderShipGroupState GetOrderShipGroup(string orderId, string shipGroupSeqId)
        {
            var entityId = new OrderShipGroupId(orderId, shipGroupSeqId);
            return CurrentSession.Get<OrderShipGroupState>(entityId);
        }

        [Transaction(ReadOnly = true)]
        public IEnumerable<IOrderShipGroupState> GetOrderShipGroups(string orderId)
        {
            var criteria = CurrentSession.CreateCriteria<OrderShipGroupState>();
            var partIdCondition = global::NHibernate.Criterion.Restrictions.Conjunction()
                .Add(global::NHibernate.Criterion.Restrictions.Eq("OrderShipGroupId.OrderId", orderId))
                ;

            return criteria.Add(partIdCondition).List<OrderShipGroupState>();
        }

        [Transaction(ReadOnly = true)]
        public virtual IOrderItemShipGroupAssociationState GetOrderItemShipGroupAssociation(string orderId, string orderShipGroupShipGroupSeqId, string orderItemSeqId)
        {
            var entityId = new OrderItemShipGroupAssociationId(orderId, orderShipGroupShipGroupSeqId, orderItemSeqId);
            return CurrentSession.Get<OrderItemShipGroupAssociationState>(entityId);
        }

        [Transaction(ReadOnly = true)]
        public IEnumerable<IOrderItemShipGroupAssociationState> GetOrderItemShipGroupAssociations(string orderId, string orderShipGroupShipGroupSeqId)
        {
            var criteria = CurrentSession.CreateCriteria<OrderItemShipGroupAssociationState>();
            var partIdCondition = global::NHibernate.Criterion.Restrictions.Conjunction()
                .Add(global::NHibernate.Criterion.Restrictions.Eq("OrderItemShipGroupAssociationId.OrderId", orderId))
                .Add(global::NHibernate.Criterion.Restrictions.Eq("OrderItemShipGroupAssociationId.OrderShipGroupShipGroupSeqId", orderShipGroupShipGroupSeqId))
                ;

            return criteria.Add(partIdCondition).List<OrderItemShipGroupAssociationState>();
        }


        protected static void AddNotDeletedRestriction(ICriteria criteria)
        {
        }

	}
}

