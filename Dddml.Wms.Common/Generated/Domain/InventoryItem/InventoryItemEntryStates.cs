﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateInventoryItemDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.InventoryItem;

namespace Dddml.Wms.Domain.InventoryItem
{

    public class InventoryItemEntryStates : IInventoryItemEntryStates
    {
        
		protected IInventoryItemEntryStateDao InventoryItemEntryStateDao
		{
			get
			{
				return ApplicationContext.Current["InventoryItemEntryStateDao"] as IInventoryItemEntryStateDao;
			}
		}

		private Dictionary<InventoryItemEntryId, IInventoryItemEntryState> _loadedInventoryItemEntryStates = new Dictionary<InventoryItemEntryId, IInventoryItemEntryState>();

		private Dictionary<InventoryItemEntryId, IInventoryItemEntryState> _removedInventoryItemEntryStates = new Dictionary<InventoryItemEntryId, IInventoryItemEntryState>();

		protected virtual IEnumerable<IInventoryItemEntryState> LoadedInventoryItemEntryStates {
			get {
				return this._loadedInventoryItemEntryStates.Values;
			}
		}

        private IInventoryItemState _inventoryItemState;

        private IEnumerable<IInventoryItemEntryState> InnerEnumeralbe
        {
            get
            {
                if (!ForReapplying)
                {
                    return InventoryItemEntryStateDao.FindByInventoryItemId(_inventoryItemState.InventoryItemId);
                }
                else
                {
                    return _loadedInventoryItemEntryStates.Values.Where(s => !(_removedInventoryItemEntryStates.ContainsKey(s.GlobalId) && s.Deleted));
                }
            }
        }

        private bool _forReapplying;

        public virtual bool ForReapplying
        {
            get { return _forReapplying; }
            set { _forReapplying = value; } 
        }

        public InventoryItemEntryStates(IInventoryItemState outerState)
        {
            this._inventoryItemState = outerState;
            this._forReapplying = outerState.ForReapplying;
        }

        public IEnumerator<IInventoryItemEntryState> GetEnumerator()
        {
            return InnerEnumeralbe.GetEnumerator();
        }

        System.Collections.IEnumerator System.Collections.IEnumerable.GetEnumerator()
        {
            return InnerEnumeralbe.GetEnumerator();
        }

        public virtual void Remove(IInventoryItemEntryState state)
        {
            this._removedInventoryItemEntryStates.Add(state.GlobalId, state);
        }

        public virtual IInventoryItemEntryState Get(long entrySeqId)
		{
			return Get(entrySeqId, false, false);
		}

        public virtual IInventoryItemEntryState Get(long entrySeqId, bool forCreation)
        {
			return Get(entrySeqId, forCreation, false);
        }

        public virtual IInventoryItemEntryState Get(long entrySeqId, bool forCreation, bool nullAllowed)
        {
            InventoryItemEntryId globalId = new InventoryItemEntryId(_inventoryItemState.InventoryItemId, entrySeqId);
            if (_loadedInventoryItemEntryStates.ContainsKey(globalId)) {
                return _loadedInventoryItemEntryStates[globalId];
            }
            if (forCreation || ForReapplying)
            {
                var state = new InventoryItemEntryState(ForReapplying);
                state.InventoryItemEntryId = globalId;
                _loadedInventoryItemEntryStates.Add(globalId, state);
                return state;
            }
            else
            {
                var state = InventoryItemEntryStateDao.Get(globalId, nullAllowed);
                if (state != null)
                {
                    _loadedInventoryItemEntryStates.Add(globalId, state);
                }
                return state;
            }
        }

        public virtual void AddToSave(IInventoryItemEntryState state)
        {
            this._loadedInventoryItemEntryStates[state.GlobalId] = state;
        }

		#region Saveable Implements

		public virtual void Save ()
		{
			foreach (IInventoryItemEntryState s in this.LoadedInventoryItemEntryStates) {
                InventoryItemEntryStateDao.Save(s);
			}
            foreach(IInventoryItemEntryState s in this._removedInventoryItemEntryStates.Values)
            {
                InventoryItemEntryStateDao.Delete(s);
            }
		}

		#endregion


    }



}

