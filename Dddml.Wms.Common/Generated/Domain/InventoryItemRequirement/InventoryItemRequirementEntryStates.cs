﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateInventoryItemRequirementDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.InventoryItemRequirement;
using Dddml.Wms.Domain.InventoryItem;
using Dddml.Wms.Domain.InventoryPRTriggered;

namespace Dddml.Wms.Domain.InventoryItemRequirement
{

    public class InventoryItemRequirementEntryStates : IInventoryItemRequirementEntryStates
    {
        
		protected IInventoryItemRequirementEntryStateDao InventoryItemRequirementEntryStateDao
		{
			get
			{
				return ApplicationContext.Current["InventoryItemRequirementEntryStateDao"] as IInventoryItemRequirementEntryStateDao;
			}
		}

		private Dictionary<InventoryItemRequirementEntryId, IInventoryItemRequirementEntryState> _loadedInventoryItemRequirementEntryStates = new Dictionary<InventoryItemRequirementEntryId, IInventoryItemRequirementEntryState>();

		private Dictionary<InventoryItemRequirementEntryId, IInventoryItemRequirementEntryState> _removedInventoryItemRequirementEntryStates = new Dictionary<InventoryItemRequirementEntryId, IInventoryItemRequirementEntryState>();

		protected virtual IEnumerable<IInventoryItemRequirementEntryState> LoadedInventoryItemRequirementEntryStates {
			get {
				return this._loadedInventoryItemRequirementEntryStates.Values;
			}
		}

        private IInventoryItemRequirementState _inventoryItemRequirementState;

        private IEnumerable<IInventoryItemRequirementEntryState> InnerEnumeralbe
        {
            get
            {
                if (!ForReapplying)
                {
                    return InventoryItemRequirementEntryStateDao.FindByInventoryItemRequirementId(_inventoryItemRequirementState.InventoryItemRequirementId);
                }
                else
                {
                    return _loadedInventoryItemRequirementEntryStates.Values.Where(s => !(_removedInventoryItemRequirementEntryStates.ContainsKey(s.GlobalId) && s.Deleted));
                }
            }
        }

        private bool _forReapplying;

        public virtual bool ForReapplying
        {
            get { return _forReapplying; }
            set { _forReapplying = value; } 
        }

        public InventoryItemRequirementEntryStates(IInventoryItemRequirementState outerState)
        {
            this._inventoryItemRequirementState = outerState;
            this._forReapplying = outerState.ForReapplying;
        }

        public IEnumerator<IInventoryItemRequirementEntryState> GetEnumerator()
        {
            return InnerEnumeralbe.GetEnumerator();
        }

        System.Collections.IEnumerator System.Collections.IEnumerable.GetEnumerator()
        {
            return InnerEnumeralbe.GetEnumerator();
        }

        public virtual void Remove(IInventoryItemRequirementEntryState state)
        {
            this._removedInventoryItemRequirementEntryStates.Add(state.GlobalId, state);
        }

        public virtual IInventoryItemRequirementEntryState Get(long entrySeqId)
		{
			return Get(entrySeqId, false, false);
		}

        public virtual IInventoryItemRequirementEntryState Get(long entrySeqId, bool forCreation)
        {
			return Get(entrySeqId, forCreation, false);
        }

        public virtual IInventoryItemRequirementEntryState Get(long entrySeqId, bool forCreation, bool nullAllowed)
        {
            InventoryItemRequirementEntryId globalId = new InventoryItemRequirementEntryId(_inventoryItemRequirementState.InventoryItemRequirementId, entrySeqId);
            if (_loadedInventoryItemRequirementEntryStates.ContainsKey(globalId)) {
                var state = _loadedInventoryItemRequirementEntryStates[globalId];
                if (this._inventoryItemRequirementState != null && this._inventoryItemRequirementState.ReadOnly == false) { ((IInventoryItemRequirementEntryState)state).ReadOnly = false; }
                return state;
            }
            if (forCreation || ForReapplying)
            {
                var state = new InventoryItemRequirementEntryState(ForReapplying);
                state.InventoryItemRequirementEntryId = globalId;
                _loadedInventoryItemRequirementEntryStates.Add(globalId, state);
                if (this._inventoryItemRequirementState != null && this._inventoryItemRequirementState.ReadOnly == false) { ((IInventoryItemRequirementEntryState)state).ReadOnly = false; }
                return state;
            }
            else
            {
                var state = InventoryItemRequirementEntryStateDao.Get(globalId, nullAllowed);
                if (state != null)
                {
                    _loadedInventoryItemRequirementEntryStates.Add(globalId, state);
                }
                if (this._inventoryItemRequirementState != null && this._inventoryItemRequirementState.ReadOnly == false) { ((IInventoryItemRequirementEntryState)state).ReadOnly = false; }
                return state;
            }
        }

        public virtual void AddToSave(IInventoryItemRequirementEntryState state)
        {
            this._loadedInventoryItemRequirementEntryStates[state.GlobalId] = state;
        }

		#region Saveable Implements

		public virtual void Save ()
		{
			foreach (IInventoryItemRequirementEntryState s in this.LoadedInventoryItemRequirementEntryStates) {
                InventoryItemRequirementEntryStateDao.Save(s);
			}
            foreach(IInventoryItemRequirementEntryState s in this._removedInventoryItemRequirementEntryStates.Values)
            {
                InventoryItemRequirementEntryStateDao.Delete(s);
            }
		}

		#endregion


    }



}


