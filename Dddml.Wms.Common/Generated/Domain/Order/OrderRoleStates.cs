﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateOrderDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Order;
using Dddml.Wms.Domain.PartyRole;

namespace Dddml.Wms.Domain.Order
{

    public class OrderRoleStates : IOrderRoleStates
    {
        
		protected IOrderRoleStateDao OrderRoleStateDao
		{
			get
			{
				return ApplicationContext.Current["OrderRoleStateDao"] as IOrderRoleStateDao;
			}
		}

		private Dictionary<OrderRoleId, IOrderRoleState> _loadedOrderRoleStates = new Dictionary<OrderRoleId, IOrderRoleState>();

		private Dictionary<OrderRoleId, IOrderRoleState> _removedOrderRoleStates = new Dictionary<OrderRoleId, IOrderRoleState>();

		protected virtual IEnumerable<IOrderRoleState> LoadedOrderRoleStates {
			get {
				return this._loadedOrderRoleStates.Values;
			}
		}

        private IOrderState _orderState;

        private IEnumerable<IOrderRoleState> InnerEnumeralbe
        {
            get
            {
                if (!ForReapplying)
                {
                    return OrderRoleStateDao.FindByOrderId(_orderState.OrderId);
                }
                else
                {
                    return _loadedOrderRoleStates.Values.Where(s => !(_removedOrderRoleStates.ContainsKey(s.GlobalId) && s.Deleted));
                }
            }
        }

        private bool _forReapplying;

        public virtual bool ForReapplying
        {
            get { return _forReapplying; }
            set { _forReapplying = value; } 
        }

        public OrderRoleStates(IOrderState outerState)
        {
            this._orderState = outerState;
            this._forReapplying = outerState.ForReapplying;
        }

        public IEnumerator<IOrderRoleState> GetEnumerator()
        {
            return InnerEnumeralbe.GetEnumerator();
        }

        System.Collections.IEnumerator System.Collections.IEnumerable.GetEnumerator()
        {
            return InnerEnumeralbe.GetEnumerator();
        }

        public virtual void Remove(IOrderRoleState state)
        {
            this._removedOrderRoleStates.Add(state.GlobalId, state);
        }

        public virtual IOrderRoleState Get(PartyRoleId partyRoleId)
		{
			return Get(partyRoleId, false, false);
		}

        public virtual IOrderRoleState Get(PartyRoleId partyRoleId, bool forCreation)
        {
			return Get(partyRoleId, forCreation, false);
        }

        public virtual IOrderRoleState Get(PartyRoleId partyRoleId, bool forCreation, bool nullAllowed)
        {
            OrderRoleId globalId = new OrderRoleId(_orderState.OrderId, partyRoleId);
            if (_loadedOrderRoleStates.ContainsKey(globalId)) {
                var state = _loadedOrderRoleStates[globalId];
                if (this._orderState != null && this._orderState.ReadOnly == false) { ((IOrderRoleState)state).ReadOnly = false; }
                return state;
            }
            if (forCreation || ForReapplying)
            {
                var state = new OrderRoleState(ForReapplying);
                state.OrderRoleId = globalId;
                _loadedOrderRoleStates.Add(globalId, state);
                if (this._orderState != null && this._orderState.ReadOnly == false) { ((IOrderRoleState)state).ReadOnly = false; }
                return state;
            }
            else
            {
                var state = OrderRoleStateDao.Get(globalId, nullAllowed);
                if (state != null)
                {
                    _loadedOrderRoleStates.Add(globalId, state);
                }
                if (this._orderState != null && this._orderState.ReadOnly == false) { ((IOrderRoleState)state).ReadOnly = false; }
                return state;
            }
        }

        public virtual void AddToSave(IOrderRoleState state)
        {
            this._loadedOrderRoleStates[state.GlobalId] = state;
        }

		#region Saveable Implements

		public virtual void Save ()
		{
			foreach (IOrderRoleState s in this.LoadedOrderRoleStates) {
                OrderRoleStateDao.Save(s);
			}
            foreach(IOrderRoleState s in this._removedOrderRoleStates.Values)
            {
                OrderRoleStateDao.Delete(s);
            }
		}

		#endregion


    }



}

