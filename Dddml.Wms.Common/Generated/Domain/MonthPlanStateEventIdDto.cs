﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateBoundedContextDomainAggregates.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;

namespace Dddml.Wms.Domain
{

	public class MonthPlanStateEventIdDto
	{

        private MonthPlanStateEventId _value = new MonthPlanStateEventId();

		public MonthPlanStateEventIdDto()
		{
		}

		public MonthPlanStateEventIdDto(MonthPlanStateEventId val)
		{
			if (val == null) { throw new ArgumentNullException("val"); }
			this._value = val;
		}

        public MonthPlanStateEventId ToMonthPlanStateEventId()
        {
            return this._value;
        }

		public virtual PersonalNameDto PersonalName { 
			get { return new PersonalNameDto(_value.PersonalName); } 
			set { _value.PersonalName = value.ToPersonalName(); } 
		}

		public virtual int Year { 
			get { return _value.Year; } 
			set { _value.Year = value; } 
		}

		public virtual int Month { 
			get { return _value.Month; } 
			set { _value.Month = value; } 
		}

		public virtual long PersonVersion { 
			get { return _value.PersonVersion; } 
			set { _value.PersonVersion = value; } 
		}


		public override bool Equals (object obj)
		{
			if (Object.ReferenceEquals (this, obj)) {
				return true;
			}

			MonthPlanStateEventIdDto other = obj as MonthPlanStateEventIdDto;
			if (other == null) {
				return false;
			}

            return _value.Equals(other._value);

		}

		public override int GetHashCode ()
		{
			return _value.GetHashCode();
		}

	}

}


