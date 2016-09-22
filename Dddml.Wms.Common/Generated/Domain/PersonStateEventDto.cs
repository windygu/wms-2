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

	public abstract class PersonStateEventDtoBase : IStateEventDto, IPersonStateCreated, IPersonStateMergePatched, IPersonStateDeleted
	{

        private PersonStateEventIdDto _stateEventId;

		protected internal virtual PersonStateEventIdDto StateEventId 
        {
            get 
            {
                if (_stateEventId == null) { _stateEventId = new PersonStateEventIdDto(); }
                return _stateEventId;
            }
            set
            {
                _stateEventId = value;
            }
        }

        public virtual PersonalNameDto PersonalName
        {
            get { return StateEventId.PersonalName; }
            set { StateEventId.PersonalName = value; }
        }

        public virtual long Version
        {
            get { return StateEventId.Version; }
            set { StateEventId.Version = value; }
        }

		public virtual DateTime? BirthDate { get; set; }

		private PersonalNameDto _loves = new PersonalNameDto();

		public virtual PersonalNameDto Loves { get { return _loves; } set { _loves = value; } }

		PersonalName IPersonStateEvent.Loves
		{ 
			get 
			{
				return this.Loves == null ? null : this.Loves.ToPersonalName(); 
			} 
			set
			{
				if (value == null) { Loves = null; } else { Loves = new PersonalNameDto(value); }
			} 
		}

		private ContactDto _emergencyContact = new ContactDto();

		public virtual ContactDto EmergencyContact { get { return _emergencyContact; } set { _emergencyContact = value; } }

		Contact IPersonStateEvent.EmergencyContact
		{ 
			get 
			{
				return this.EmergencyContact == null ? null : this.EmergencyContact.ToContact(); 
			} 
			set
			{
				if (value == null) { EmergencyContact = null; } else { EmergencyContact = new ContactDto(value); }
			} 
		}

		public virtual bool? Active { get; set; }

		public virtual string CreatedBy { get; set; }

		public virtual DateTime CreatedAt { get; set; }

        public virtual string CommandId { get; set; }

		PersonStateEventId IGlobalIdentity<PersonStateEventId>.GlobalId {
			get {
				return this.StateEventId.ToPersonStateEventId();
			}
		}

        public virtual bool StateEventReadOnly { get; set; }

        bool IPersonStateEvent.ReadOnly
        {
            get
            {
                return this.StateEventReadOnly;
            }
            set
            {
                this.StateEventReadOnly = value;
            }
        }

		public virtual bool? IsPropertyBirthDateRemoved { get; set; }

        bool IPersonStateMergePatched.IsPropertyBirthDateRemoved
        {
            get 
            {
                var b = this.IsPropertyBirthDateRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyBirthDateRemoved = value;
            }
        }

		public virtual bool? IsPropertyLovesRemoved { get; set; }

        bool IPersonStateMergePatched.IsPropertyLovesRemoved
        {
            get 
            {
                var b = this.IsPropertyLovesRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyLovesRemoved = value;
            }
        }

		public virtual bool? IsPropertyEmergencyContactRemoved { get; set; }

        bool IPersonStateMergePatched.IsPropertyEmergencyContactRemoved
        {
            get 
            {
                var b = this.IsPropertyEmergencyContactRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyEmergencyContactRemoved = value;
            }
        }

		public virtual bool? IsPropertyActiveRemoved { get; set; }

        bool IPersonStateMergePatched.IsPropertyActiveRemoved
        {
            get 
            {
                var b = this.IsPropertyActiveRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyActiveRemoved = value;
            }
        }


		string ICreated<string>.CreatedBy {
			get {
				return this.CreatedBy;
			}
			set {
				this.CreatedBy = value;
			}
		}

		DateTime ICreated<string>.CreatedAt {
			get {
				return this.CreatedAt;
			}
			set {
				this.CreatedAt = value;
			}
		}


        private YearPlanStateCreatedOrMergePatchedOrRemovedDtos _yearPlanEvents = new YearPlanStateCreatedOrMergePatchedOrRemovedDtos();

        public virtual YearPlanStateCreatedOrMergePatchedOrRemovedDto[] YearPlanEvents
        {
            get
            {
                return _yearPlanEvents.ToArray();
            }
            set
            {
                _yearPlanEvents.Clear();
                _yearPlanEvents.AddRange(value);
            }
        }



        private YearPlanStateEventIdDto NewYearPlanStateEventId(int year)
        {
            var eId = new YearPlanStateEventIdDto();
            eId.PersonalName = this.StateEventId.PersonalName;
            eId.Year = year;
            eId.PersonVersion = this.StateEventId.Version;
            return eId;
        }

        public virtual YearPlanStateCreatedDto NewYearPlanStateCreated(int year)
        {
            var e = new YearPlanStateCreatedDto();
            var eId = NewYearPlanStateEventId(year);
            e.StateEventId = eId;
            return e;
        }

        public virtual YearPlanStateMergePatchedDto NewYearPlanStateMergePatched(int year)
        {
            var e = new YearPlanStateMergePatchedDto();
            var eId = NewYearPlanStateEventId(year);
            e.StateEventId = eId;
            return e;
        }

        public virtual YearPlanStateRemovedDto NewYearPlanStateRemoved(int year)
        {
            var e = new YearPlanStateRemovedDto();
            var eId = NewYearPlanStateEventId(year);
            e.StateEventId = eId;
            return e;
        }

        IEnumerable<IYearPlanStateCreated> IPersonStateCreated.YearPlanEvents
        {
            get { return this._yearPlanEvents; }
        }

        void IPersonStateCreated.AddYearPlanEvent(IYearPlanStateCreated e)
        {
            this._yearPlanEvents.AddYearPlanEvent(e);
        }

        IYearPlanStateCreated IPersonStateCreated.NewYearPlanStateCreated(int year)
        {
            return NewYearPlanStateCreated(year);
        }

        IEnumerable<IYearPlanStateEvent> IPersonStateMergePatched.YearPlanEvents
        {
            get { return this._yearPlanEvents; }
        }

        void IPersonStateMergePatched.AddYearPlanEvent(IYearPlanStateEvent e)
        {
            this._yearPlanEvents.AddYearPlanEvent(e);
        }

        IYearPlanStateCreated IPersonStateMergePatched.NewYearPlanStateCreated(int year)
        {
            return NewYearPlanStateCreated(year);
        }

        IYearPlanStateMergePatched IPersonStateMergePatched.NewYearPlanStateMergePatched(int year)
        {
            return NewYearPlanStateMergePatched(year);
        }

        IYearPlanStateRemoved IPersonStateMergePatched.NewYearPlanStateRemoved(int year)
        {
            return NewYearPlanStateRemoved(year);
        }


        IEnumerable<IYearPlanStateRemoved> IPersonStateDeleted.YearPlanEvents
        {
            get { return this._yearPlanEvents; }
        }

        void IPersonStateDeleted.AddYearPlanEvent(IYearPlanStateRemoved e)
        {
            this._yearPlanEvents.AddYearPlanEvent(e);
        }

        IYearPlanStateRemoved IPersonStateDeleted.NewYearPlanStateRemoved(int year)
        {
            return NewYearPlanStateRemoved(year);
        }


        PersonStateEventId IPersonStateEvent.StateEventId
        {
            get { return this.StateEventId.ToPersonStateEventId(); }
        }

        protected PersonStateEventDtoBase()
        {
        }

        protected PersonStateEventDtoBase(PersonStateEventIdDto stateEventId)
        {
            this.StateEventId = stateEventId;
        }

        // //////////////////////////////////////////////////

        string IStateEventDto.StateEventType 
        {
            get { return this.GetStateEventType(); }
        }

        protected abstract string GetStateEventType();

	}


    public class PersonStateCreatedOrMergePatchedOrDeletedDto : PersonStateEventDtoBase
    {
        private string _stateEventType;

        public virtual string StateEventType
        {
            get { return _stateEventType; }
            set { _stateEventType = value; }
        }

        protected override string GetStateEventType()
        {
            return this._stateEventType;
        }

    }



	public class PersonStateCreatedDto : PersonStateCreatedOrMergePatchedOrDeletedDto
	{
		public PersonStateCreatedDto()
		{
		}

        public override string StateEventType
        {
            get { return this.GetStateEventType(); }
            set
            {
                // do nothing
            }
        }

        protected override string GetStateEventType()
        {
            return Dddml.Wms.Specialization.StateEventType.Created;
        }

	}


	public class PersonStateMergePatchedDto : PersonStateCreatedOrMergePatchedOrDeletedDto
	{
		public PersonStateMergePatchedDto()
		{
		}

        public override string StateEventType
        {
            get { return this.GetStateEventType(); }
            set
            {
                // do nothing
            }
        }

        protected override string GetStateEventType()
        {
            return Dddml.Wms.Specialization.StateEventType.MergePatched;
        }

	}


	public class PersonStateDeletedDto : PersonStateCreatedOrMergePatchedOrDeletedDto
	{
		public PersonStateDeletedDto()
		{
		}

        public override string StateEventType
        {
            get { return this.GetStateEventType(); }
            set
            {
                // do nothing
            }
        }

        protected override string GetStateEventType()
        {
            return Dddml.Wms.Specialization.StateEventType.Deleted;
        }

	}


    public partial class PersonStateCreatedOrMergePatchedOrDeletedDtos : IEnumerable<IPersonStateCreated>, IEnumerable<IPersonStateMergePatched>, IEnumerable<IPersonStateDeleted>
    {
        private List<PersonStateCreatedOrMergePatchedOrDeletedDto> _innerStateEvents = new List<PersonStateCreatedOrMergePatchedOrDeletedDto>();

        public virtual PersonStateCreatedOrMergePatchedOrDeletedDto[] ToArray()
        {
            return _innerStateEvents.ToArray();
        }

        public virtual void Clear()
        {
            _innerStateEvents.Clear();
        }

        public virtual void AddRange(IEnumerable<PersonStateCreatedOrMergePatchedOrDeletedDto> es)
        {
            _innerStateEvents.AddRange(es);
        }

        System.Collections.IEnumerator System.Collections.IEnumerable.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }

        IEnumerator<IPersonStateCreated> IEnumerable<IPersonStateCreated>.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }

        IEnumerator<IPersonStateMergePatched> IEnumerable<IPersonStateMergePatched>.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }

        IEnumerator<IPersonStateDeleted> IEnumerable<IPersonStateDeleted>.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }

        public void AddPersonEvent(IPersonStateCreated e)
        {
            _innerStateEvents.Add((PersonStateCreatedDto)e);
        }

        public void AddPersonEvent(IPersonStateEvent e)
        {
            _innerStateEvents.Add((PersonStateCreatedOrMergePatchedOrDeletedDto)e);
        }

        public void AddPersonEvent(IPersonStateDeleted e)
        {
            _innerStateEvents.Add((PersonStateDeletedDto)e);
        }

    }


}

