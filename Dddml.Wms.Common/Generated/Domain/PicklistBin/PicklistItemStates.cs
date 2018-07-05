﻿// <autogenerated>
//   This file was generated by T4 code generator GeneratePicklistBinDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.PicklistBin;

namespace Dddml.Wms.Domain.PicklistBin
{

    public class PicklistItemStates : IPicklistItemStates
    {
        
		protected IPicklistItemStateDao PicklistItemStateDao
		{
			get
			{
				return ApplicationContext.Current["PicklistItemStateDao"] as IPicklistItemStateDao;
			}
		}

		private Dictionary<PicklistBinPicklistItemId, IPicklistItemState> _loadedPicklistItemStates = new Dictionary<PicklistBinPicklistItemId, IPicklistItemState>();

		private Dictionary<PicklistBinPicklistItemId, IPicklistItemState> _removedPicklistItemStates = new Dictionary<PicklistBinPicklistItemId, IPicklistItemState>();

		protected virtual IEnumerable<IPicklistItemState> LoadedPicklistItemStates {
			get {
				return this._loadedPicklistItemStates.Values;
			}
		}

        private IPicklistBinState _picklistBinState;

        private IEnumerable<IPicklistItemState> InnerEnumeralbe
        {
            get
            {
                if (!ForReapplying)
                {
                    return PicklistItemStateDao.FindByPicklistBinId(_picklistBinState.PicklistBinId);
                }
                else
                {
                    return _loadedPicklistItemStates.Values.Where(s => !(_removedPicklistItemStates.ContainsKey(s.GlobalId) && s.Deleted));
                }
            }
        }

        private bool _forReapplying;

        public virtual bool ForReapplying
        {
            get { return _forReapplying; }
            set { _forReapplying = value; } 
        }

        public PicklistItemStates(IPicklistBinState outerState)
        {
            this._picklistBinState = outerState;
            this._forReapplying = outerState.ForReapplying;
        }

        public IEnumerator<IPicklistItemState> GetEnumerator()
        {
            return InnerEnumeralbe.GetEnumerator();
        }

        System.Collections.IEnumerator System.Collections.IEnumerable.GetEnumerator()
        {
            return InnerEnumeralbe.GetEnumerator();
        }

        public virtual void Remove(IPicklistItemState state)
        {
            this._removedPicklistItemStates.Add(state.GlobalId, state);
        }

        public virtual IPicklistItemState Get(PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId)
		{
			return Get(picklistItemOrderShipGrpInvId, false, false);
		}

        public virtual IPicklistItemState Get(PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId, bool forCreation)
        {
			return Get(picklistItemOrderShipGrpInvId, forCreation, false);
        }

        public virtual IPicklistItemState Get(PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId, bool forCreation, bool nullAllowed)
        {
            PicklistBinPicklistItemId globalId = new PicklistBinPicklistItemId(_picklistBinState.PicklistBinId, picklistItemOrderShipGrpInvId);
            if (_loadedPicklistItemStates.ContainsKey(globalId)) {
                var state = _loadedPicklistItemStates[globalId];
                if (this._picklistBinState != null && this._picklistBinState.ReadOnly == false) { ((IPicklistItemState)state).ReadOnly = false; }
                return state;
            }
            if (forCreation || ForReapplying)
            {
                var state = new PicklistItemState(ForReapplying);
                state.PicklistBinPicklistItemId = globalId;
                _loadedPicklistItemStates.Add(globalId, state);
                if (this._picklistBinState != null && this._picklistBinState.ReadOnly == false) { ((IPicklistItemState)state).ReadOnly = false; }
                return state;
            }
            else
            {
                var state = PicklistItemStateDao.Get(globalId, nullAllowed);
                if (state != null)
                {
                    _loadedPicklistItemStates.Add(globalId, state);
                }
                if (this._picklistBinState != null && this._picklistBinState.ReadOnly == false) { ((IPicklistItemState)state).ReadOnly = false; }
                return state;
            }
        }

        public virtual void AddToSave(IPicklistItemState state)
        {
            this._loadedPicklistItemStates[state.GlobalId] = state;
        }

		#region Saveable Implements

		public virtual void Save ()
		{
			foreach (IPicklistItemState s in this.LoadedPicklistItemStates) {
                PicklistItemStateDao.Save(s);
			}
            foreach(IPicklistItemState s in this._removedPicklistItemStates.Values)
            {
                PicklistItemStateDao.Delete(s);
            }
		}

		#endregion


    }



}


