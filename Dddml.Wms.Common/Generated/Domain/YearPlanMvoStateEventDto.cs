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

	public abstract class YearPlanMvoStateEventDtoBase : IStateEventDto, IYearPlanMvoStateCreated, IYearPlanMvoStateMergePatched, IYearPlanMvoStateDeleted
	{

        private YearPlanMvoStateEventIdDto _stateEventId;

		protected internal virtual YearPlanMvoStateEventIdDto StateEventId 
        {
            get 
            {
                if (_stateEventId == null) { _stateEventId = new YearPlanMvoStateEventIdDto(); }
                return _stateEventId;
            }
            set
            {
                _stateEventId = value;
            }
        }

        public virtual YearPlanIdDto YearPlanId
        {
            get { return StateEventId.YearPlanId; }
            set { StateEventId.YearPlanId = value; }
        }

        public virtual long PersonVersion
        {
            get { return StateEventId.PersonVersion; }
            set { StateEventId.PersonVersion = value; }
        }

		public virtual string Description { get; set; }

		public virtual long? Version { get; set; }

		public virtual bool? Active { get; set; }

		public virtual DateTime? PersonBirthDate { get; set; }

		private PersonalNameDto _personLoves = new PersonalNameDto();

		public virtual PersonalNameDto PersonLoves { get { return _personLoves; } set { _personLoves = value; } }

		PersonalName IYearPlanMvoStateEvent.PersonLoves { get { return this.PersonLoves.ToPersonalName(); } set { PersonLoves = new PersonalNameDto(value); } }

		private ContactDto _personEmergencyContact = new ContactDto();

		public virtual ContactDto PersonEmergencyContact { get { return _personEmergencyContact; } set { _personEmergencyContact = value; } }

		Contact IYearPlanMvoStateEvent.PersonEmergencyContact { get { return this.PersonEmergencyContact.ToContact(); } set { PersonEmergencyContact = new ContactDto(value); } }

		public virtual string PersonCreatedBy { get; set; }

		public virtual string PersonUpdatedBy { get; set; }

		public virtual DateTime? PersonCreatedAt { get; set; }

		public virtual DateTime? PersonUpdatedAt { get; set; }

		public virtual bool? PersonActive { get; set; }

		public virtual bool? PersonDeleted { get; set; }

		public virtual string CreatedBy { get; set; }

		public virtual DateTime CreatedAt { get; set; }

        public virtual string CommandId { get; set; }

		YearPlanMvoStateEventId IGlobalIdentity<YearPlanMvoStateEventId>.GlobalId {
			get {
				return this.StateEventId.ToYearPlanMvoStateEventId();
			}
		}

        public virtual bool StateEventReadOnly { get; set; }

        bool IYearPlanMvoStateEvent.ReadOnly
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

		public virtual bool? IsPropertyDescriptionRemoved { get; set; }

        bool IYearPlanMvoStateMergePatched.IsPropertyDescriptionRemoved
        {
            get 
            {
                var b = this.IsPropertyDescriptionRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyDescriptionRemoved = value;
            }
        }

		public virtual bool? IsPropertyVersionRemoved { get; set; }

        bool IYearPlanMvoStateMergePatched.IsPropertyVersionRemoved
        {
            get 
            {
                var b = this.IsPropertyVersionRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyVersionRemoved = value;
            }
        }

		public virtual bool? IsPropertyActiveRemoved { get; set; }

        bool IYearPlanMvoStateMergePatched.IsPropertyActiveRemoved
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

		public virtual bool? IsPropertyPersonBirthDateRemoved { get; set; }

        bool IYearPlanMvoStateMergePatched.IsPropertyPersonBirthDateRemoved
        {
            get 
            {
                var b = this.IsPropertyPersonBirthDateRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyPersonBirthDateRemoved = value;
            }
        }

		public virtual bool? IsPropertyPersonLovesRemoved { get; set; }

        bool IYearPlanMvoStateMergePatched.IsPropertyPersonLovesRemoved
        {
            get 
            {
                var b = this.IsPropertyPersonLovesRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyPersonLovesRemoved = value;
            }
        }

		public virtual bool? IsPropertyPersonEmergencyContactRemoved { get; set; }

        bool IYearPlanMvoStateMergePatched.IsPropertyPersonEmergencyContactRemoved
        {
            get 
            {
                var b = this.IsPropertyPersonEmergencyContactRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyPersonEmergencyContactRemoved = value;
            }
        }

		public virtual bool? IsPropertyPersonCreatedByRemoved { get; set; }

        bool IYearPlanMvoStateMergePatched.IsPropertyPersonCreatedByRemoved
        {
            get 
            {
                var b = this.IsPropertyPersonCreatedByRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyPersonCreatedByRemoved = value;
            }
        }

		public virtual bool? IsPropertyPersonUpdatedByRemoved { get; set; }

        bool IYearPlanMvoStateMergePatched.IsPropertyPersonUpdatedByRemoved
        {
            get 
            {
                var b = this.IsPropertyPersonUpdatedByRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyPersonUpdatedByRemoved = value;
            }
        }

		public virtual bool? IsPropertyPersonCreatedAtRemoved { get; set; }

        bool IYearPlanMvoStateMergePatched.IsPropertyPersonCreatedAtRemoved
        {
            get 
            {
                var b = this.IsPropertyPersonCreatedAtRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyPersonCreatedAtRemoved = value;
            }
        }

		public virtual bool? IsPropertyPersonUpdatedAtRemoved { get; set; }

        bool IYearPlanMvoStateMergePatched.IsPropertyPersonUpdatedAtRemoved
        {
            get 
            {
                var b = this.IsPropertyPersonUpdatedAtRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyPersonUpdatedAtRemoved = value;
            }
        }

		public virtual bool? IsPropertyPersonActiveRemoved { get; set; }

        bool IYearPlanMvoStateMergePatched.IsPropertyPersonActiveRemoved
        {
            get 
            {
                var b = this.IsPropertyPersonActiveRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyPersonActiveRemoved = value;
            }
        }

		public virtual bool? IsPropertyPersonDeletedRemoved { get; set; }

        bool IYearPlanMvoStateMergePatched.IsPropertyPersonDeletedRemoved
        {
            get 
            {
                var b = this.IsPropertyPersonDeletedRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyPersonDeletedRemoved = value;
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


        YearPlanMvoStateEventId IYearPlanMvoStateEvent.StateEventId
        {
            get { return this.StateEventId.ToYearPlanMvoStateEventId(); }
        }

        protected YearPlanMvoStateEventDtoBase()
        {
        }

        protected YearPlanMvoStateEventDtoBase(YearPlanMvoStateEventIdDto stateEventId)
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


    public class YearPlanMvoStateCreatedOrMergePatchedOrDeletedDto : YearPlanMvoStateEventDtoBase
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



	public class YearPlanMvoStateCreatedDto : YearPlanMvoStateCreatedOrMergePatchedOrDeletedDto
	{
		public YearPlanMvoStateCreatedDto()
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


	public class YearPlanMvoStateMergePatchedDto : YearPlanMvoStateCreatedOrMergePatchedOrDeletedDto
	{
		public YearPlanMvoStateMergePatchedDto()
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


	public class YearPlanMvoStateDeletedDto : YearPlanMvoStateCreatedOrMergePatchedOrDeletedDto
	{
		public YearPlanMvoStateDeletedDto()
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


    public partial class YearPlanMvoStateCreatedOrMergePatchedOrDeletedDtos : IEnumerable<IYearPlanMvoStateCreated>, IEnumerable<IYearPlanMvoStateMergePatched>, IEnumerable<IYearPlanMvoStateDeleted>
    {
        private List<YearPlanMvoStateCreatedOrMergePatchedOrDeletedDto> _innerStateEvents = new List<YearPlanMvoStateCreatedOrMergePatchedOrDeletedDto>();

        public virtual YearPlanMvoStateCreatedOrMergePatchedOrDeletedDto[] ToArray()
        {
            return _innerStateEvents.ToArray();
        }

        public virtual void Clear()
        {
            _innerStateEvents.Clear();
        }

        public virtual void AddRange(IEnumerable<YearPlanMvoStateCreatedOrMergePatchedOrDeletedDto> es)
        {
            _innerStateEvents.AddRange(es);
        }

        System.Collections.IEnumerator System.Collections.IEnumerable.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }

        IEnumerator<IYearPlanMvoStateCreated> IEnumerable<IYearPlanMvoStateCreated>.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }

        IEnumerator<IYearPlanMvoStateMergePatched> IEnumerable<IYearPlanMvoStateMergePatched>.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }

        IEnumerator<IYearPlanMvoStateDeleted> IEnumerable<IYearPlanMvoStateDeleted>.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }

        public void AddYearPlanMvoEvent(IYearPlanMvoStateCreated e)
        {
            _innerStateEvents.Add((YearPlanMvoStateCreatedDto)e);
        }

        public void AddYearPlanMvoEvent(IYearPlanMvoStateEvent e)
        {
            _innerStateEvents.Add((YearPlanMvoStateCreatedOrMergePatchedOrDeletedDto)e);
        }

        public void AddYearPlanMvoEvent(IYearPlanMvoStateDeleted e)
        {
            _innerStateEvents.Add((YearPlanMvoStateDeletedDto)e);
        }

    }


}

