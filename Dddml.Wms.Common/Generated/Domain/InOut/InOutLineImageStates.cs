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

    public class InOutLineImageStates : IInOutLineImageStates
    {
        
		protected IInOutLineImageStateDao InOutLineImageStateDao
		{
			get
			{
				return ApplicationContext.Current["InOutLineImageStateDao"] as IInOutLineImageStateDao;
			}
		}

		private Dictionary<InOutLineImageId, IInOutLineImageState> _loadedInOutLineImageStates = new Dictionary<InOutLineImageId, IInOutLineImageState>();

		private Dictionary<InOutLineImageId, IInOutLineImageState> _removedInOutLineImageStates = new Dictionary<InOutLineImageId, IInOutLineImageState>();

		protected virtual IEnumerable<IInOutLineImageState> LoadedInOutLineImageStates {
			get {
				return this._loadedInOutLineImageStates.Values;
			}
		}

        private IInOutLineState _inOutLineState;

        private IEnumerable<IInOutLineImageState> InnerEnumeralbe
        {
            get
            {
                if (!ForReapplying)
                {
                    return InOutLineImageStateDao.FindByInOutDocumentNumberAndInOutLineLineNumber((_inOutLineState as IGlobalIdentity<InOutLineId>).GlobalId.InOutDocumentNumber, (_inOutLineState as IGlobalIdentity<InOutLineId>).GlobalId.LineNumber);
                }
                else
                {
                    return _loadedInOutLineImageStates.Values.Where(s => !(_removedInOutLineImageStates.ContainsKey(s.GlobalId) && s.Deleted));
                }
            }
        }

        private bool _forReapplying;

        public virtual bool ForReapplying
        {
            get { return _forReapplying; }
            set { _forReapplying = value; } 
        }

        public InOutLineImageStates(IInOutLineState outerState)
        {
            this._inOutLineState = outerState;
            this._forReapplying = outerState.ForReapplying;
        }

        public IEnumerator<IInOutLineImageState> GetEnumerator()
        {
            return InnerEnumeralbe.GetEnumerator();
        }

        System.Collections.IEnumerator System.Collections.IEnumerable.GetEnumerator()
        {
            return InnerEnumeralbe.GetEnumerator();
        }

        public virtual void Remove(IInOutLineImageState state)
        {
            this._removedInOutLineImageStates.Add(state.GlobalId, state);
        }

        public virtual IInOutLineImageState Get(string sequenceId)
		{
			return Get(sequenceId, false, false);
		}

        public virtual IInOutLineImageState Get(string sequenceId, bool forCreation)
        {
			return Get(sequenceId, forCreation, false);
        }

        public virtual IInOutLineImageState Get(string sequenceId, bool forCreation, bool nullAllowed)
        {
            InOutLineImageId globalId = new InOutLineImageId((_inOutLineState as IGlobalIdentity<InOutLineId>).GlobalId.InOutDocumentNumber, (_inOutLineState as IGlobalIdentity<InOutLineId>).GlobalId.LineNumber, sequenceId);
            if (_loadedInOutLineImageStates.ContainsKey(globalId)) {
                var state = _loadedInOutLineImageStates[globalId];
                if (this._inOutLineState != null && this._inOutLineState.ReadOnly == false) { ((IInOutLineImageState)state).ReadOnly = false; }
                return state;
            }
            if (forCreation || ForReapplying)
            {
                var state = new InOutLineImageState(ForReapplying);
                state.InOutLineImageId = globalId;
                _loadedInOutLineImageStates.Add(globalId, state);
                if (this._inOutLineState != null && this._inOutLineState.ReadOnly == false) { ((IInOutLineImageState)state).ReadOnly = false; }
                return state;
            }
            else
            {
                var state = InOutLineImageStateDao.Get(globalId, nullAllowed);
                if (state != null)
                {
                    _loadedInOutLineImageStates.Add(globalId, state);
                }
                if (this._inOutLineState != null && this._inOutLineState.ReadOnly == false) { ((IInOutLineImageState)state).ReadOnly = false; }
                return state;
            }
        }

        public virtual void AddToSave(IInOutLineImageState state)
        {
            this._loadedInOutLineImageStates[state.GlobalId] = state;
        }

		#region Saveable Implements

		public virtual void Save ()
		{
			foreach (IInOutLineImageState s in this.LoadedInOutLineImageStates) {
                InOutLineImageStateDao.Save(s);
			}
            foreach(IInOutLineImageState s in this._removedInOutLineImageStates.Values)
            {
                InOutLineImageStateDao.Delete(s);
            }
		}

		#endregion


    }



}

