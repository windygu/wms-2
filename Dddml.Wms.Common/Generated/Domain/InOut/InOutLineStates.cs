﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateInOutDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.InOut;

namespace Dddml.Wms.Domain.InOut
{

    public class InOutLineStates : IInOutLineStates
    {
        
		protected IInOutLineStateDao InOutLineStateDao
		{
			get
			{
				return ApplicationContext.Current["InOutLineStateDao"] as IInOutLineStateDao;
			}
		}

		private Dictionary<InOutLineId, IInOutLineState> _loadedInOutLineStates = new Dictionary<InOutLineId, IInOutLineState>();

		private Dictionary<InOutLineId, IInOutLineState> _removedInOutLineStates = new Dictionary<InOutLineId, IInOutLineState>();

		protected virtual IEnumerable<IInOutLineState> LoadedInOutLineStates {
			get {
				return this._loadedInOutLineStates.Values;
			}
		}

        private IInOutState _inOutState;

        private IEnumerable<IInOutLineState> InnerEnumeralbe
        {
            get
            {
                if (!ForReapplying)
                {
                    return InOutLineStateDao.FindByInOutDocumentNumber(_inOutState.DocumentNumber);
                }
                else
                {
                    return _loadedInOutLineStates.Values.Where(s => !(_removedInOutLineStates.ContainsKey(s.GlobalId) && s.Deleted));
                }
            }
        }

        private bool _forReapplying;

        public virtual bool ForReapplying
        {
            get { return _forReapplying; }
            set { _forReapplying = value; } 
        }

        public InOutLineStates(IInOutState outerState)
        {
            this._inOutState = outerState;
            this._forReapplying = outerState.ForReapplying;
        }

        public IEnumerator<IInOutLineState> GetEnumerator()
        {
            return InnerEnumeralbe.GetEnumerator();
        }

        System.Collections.IEnumerator System.Collections.IEnumerable.GetEnumerator()
        {
            return InnerEnumeralbe.GetEnumerator();
        }

        public virtual void Remove(IInOutLineState state)
        {
            this._removedInOutLineStates.Add(state.GlobalId, state);
        }

        public virtual IInOutLineState Get(string lineNumber)
		{
			return Get(lineNumber, false, false);
		}

        public virtual IInOutLineState Get(string lineNumber, bool forCreation)
        {
			return Get(lineNumber, forCreation, false);
        }

        public virtual IInOutLineState Get(string lineNumber, bool forCreation, bool nullAllowed)
        {
            InOutLineId globalId = new InOutLineId(_inOutState.DocumentNumber, lineNumber);
            if (_loadedInOutLineStates.ContainsKey(globalId)) {
                var state = _loadedInOutLineStates[globalId];
                if (this._inOutState != null && this._inOutState.ReadOnly == false) { ((IInOutLineState)state).ReadOnly = false; }
                return state;
            }
            if (forCreation || ForReapplying)
            {
                var state = new InOutLineState(ForReapplying);
                state.InOutLineId = globalId;
                _loadedInOutLineStates.Add(globalId, state);
                if (this._inOutState != null && this._inOutState.ReadOnly == false) { ((IInOutLineState)state).ReadOnly = false; }
                return state;
            }
            else
            {
                var state = InOutLineStateDao.Get(globalId, nullAllowed);
                if (state != null)
                {
                    _loadedInOutLineStates.Add(globalId, state);
                }
                if (this._inOutState != null && this._inOutState.ReadOnly == false) { ((IInOutLineState)state).ReadOnly = false; }
                return state;
            }
        }

        public virtual void AddToSave(IInOutLineState state)
        {
            this._loadedInOutLineStates[state.GlobalId] = state;
        }

		#region Saveable Implements

		public virtual void Save ()
		{
			foreach (IInOutLineState s in this.LoadedInOutLineStates) {
                InOutLineStateDao.Save(s);
			}
            foreach(IInOutLineState s in this._removedInOutLineStates.Values)
            {
                InOutLineStateDao.Delete(s);
            }
		}

		#endregion


    }



}


