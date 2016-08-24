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

	public class DayPlanStateEventIdDto
	{

        private DayPlanStateEventId _value = new DayPlanStateEventId();

		public DayPlanStateEventIdDto()
		{
		}

		public DayPlanStateEventIdDto(DayPlanStateEventId val)
		{
			this._value = val;
		}

        public DayPlanStateEventId ToDayPlanStateEventId()
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

		public virtual int Day { 
			get { return _value.Day; } 
			set { _value.Day = value; } 
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

			DayPlanStateEventIdDto other = obj as DayPlanStateEventIdDto;
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

