﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateBoundedContextDomainAggregates.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;

namespace Dddml.Wms.Domain
{

    public class MonthPlanStates : IMonthPlanStates
    {
        
		protected IMonthPlanStateDao MonthPlanStateDao
		{
			get
			{
				return ApplicationContext.Current["MonthPlanStateDao"] as IMonthPlanStateDao;
			}
		}

		private Dictionary<MonthPlanId, IMonthPlanState> _loadedMonthPlanStates = new Dictionary<MonthPlanId, IMonthPlanState>();

        //private List<IMonthPlanState> _removedMonthPlanStates = new List<IMonthPlanState>();

		private Dictionary<MonthPlanId, IMonthPlanState> _removedMonthPlanStates = new Dictionary<MonthPlanId, IMonthPlanState>();

		protected virtual IEnumerable<IMonthPlanState> LoadedMonthPlanStates {
			get {
				return this._loadedMonthPlanStates.Values;
			}
		}

        private IYearPlanState _yearPlanState;

        //private IEnumerable<IMonthPlanState> _innerEnumerable;

        private IEnumerable<IMonthPlanState> InnerEnumeralbe
        {
            get
            {
                if (!ForReapplying)//(_innerEnumerable == null)
                {
                    return MonthPlanStateDao.FindByPersonalNameAndYear((_yearPlanState as IGlobalIdentity<YearPlanId>).GlobalId.PersonalName, (_yearPlanState as IGlobalIdentity<YearPlanId>).GlobalId.Year);
                }
                else //return _innerEnumerable;
                {
                    return _loadedMonthPlanStates.Values.Where(s => !_removedMonthPlanStates.ContainsKey(s.GlobalId));
                }
            }
        }

        private bool _forReapplying;

        public virtual bool ForReapplying
        {
            get { return _forReapplying; }
            set { _forReapplying = value; } 
        }

        public MonthPlanStates(YearPlanState outerState)
        {
            this._yearPlanState = outerState;
            this._forReapplying = outerState.ForReapplying;
        }

        public IEnumerator<IMonthPlanState> GetEnumerator()
        {
            return InnerEnumeralbe.GetEnumerator();
        }

        System.Collections.IEnumerator System.Collections.IEnumerable.GetEnumerator()
        {
            return InnerEnumeralbe.GetEnumerator();
        }

        public virtual void Remove(IMonthPlanState state)
        {
            this._removedMonthPlanStates.Add(state.GlobalId, state);
        }

        public virtual IMonthPlanState Get(int month)
		{
			MonthPlanId globalId = new MonthPlanId((_yearPlanState as IGlobalIdentity<YearPlanId>).GlobalId.PersonalName, (_yearPlanState as IGlobalIdentity<YearPlanId>).GlobalId.Year, month);
            if (_loadedMonthPlanStates.ContainsKey(globalId)) {
                return _loadedMonthPlanStates[globalId];
            }
            if (ForReapplying)
            {
                var state = new MonthPlanState(true); // state.ForReapplying = true;
                state.MonthPlanId = globalId;
			    _loadedMonthPlanStates.Add(globalId, state);
			    return state;
            }
            else
            {
                var state = MonthPlanStateDao.Get(globalId);
			    _loadedMonthPlanStates.Add(globalId, state);
			    return state;
            }
		}

        public virtual void AddToSave(IMonthPlanState state)
        {
            this._loadedMonthPlanStates[state.GlobalId] = state;
        }

		#region Saveable Implements

		public virtual void Save ()
		{
			foreach (IMonthPlanState s in this.LoadedMonthPlanStates) {
                MonthPlanStateDao.Save(s);
			}
            foreach(IMonthPlanState s in this._removedMonthPlanStates.Values)
            {
                MonthPlanStateDao.Delete(s);
            }
		}

		#endregion


    }



}


