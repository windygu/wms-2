﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateUomTypeDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.UomType;

namespace Dddml.Wms.Domain.UomType
{

	public abstract class UomTypeStateEventDtoBase : IStateEventDto, IUomTypeStateCreated, IUomTypeStateMergePatched, IUomTypeStateDeleted
	{

        private UomTypeStateEventIdDto _stateEventId;

		protected internal virtual UomTypeStateEventIdDto StateEventId 
        {
            get 
            {
                if (_stateEventId == null) { _stateEventId = new UomTypeStateEventIdDto(); }
                return _stateEventId;
            }
            set
            {
                _stateEventId = value;
            }
        }

        public virtual string UomTypeId
        {
            get { return StateEventId.UomTypeId; }
            set { StateEventId.UomTypeId = value; }
        }

        public virtual long Version
        {
            get { return StateEventId.Version; }
            set { StateEventId.Version = value; }
        }

		public virtual string ParentTypeId { get; set; }

		public virtual string HasTable { get; set; }

		public virtual string Description { get; set; }

		public virtual bool? Active { get; set; }

		public virtual string CreatedBy { get; set; }

		public virtual DateTime CreatedAt { get; set; }

        public virtual string CommandId { get; set; }

        string IEvent.CommandId { get { return this.CommandId; } set { this.CommandId = value; } }

		UomTypeStateEventId IGlobalIdentity<UomTypeStateEventId>.GlobalId {
			get 
			{
				return this.StateEventId.ToUomTypeStateEventId();
			}
		}

        public virtual bool StateEventReadOnly { get; set; }

        bool IUomTypeStateEvent.ReadOnly
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

		public virtual bool? IsPropertyParentTypeIdRemoved { get; set; }

        bool IUomTypeStateMergePatched.IsPropertyParentTypeIdRemoved
        {
            get 
            {
                var b = this.IsPropertyParentTypeIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyParentTypeIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyHasTableRemoved { get; set; }

        bool IUomTypeStateMergePatched.IsPropertyHasTableRemoved
        {
            get 
            {
                var b = this.IsPropertyHasTableRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyHasTableRemoved = value;
            }
        }

		public virtual bool? IsPropertyDescriptionRemoved { get; set; }

        bool IUomTypeStateMergePatched.IsPropertyDescriptionRemoved
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

		public virtual bool? IsPropertyActiveRemoved { get; set; }

        bool IUomTypeStateMergePatched.IsPropertyActiveRemoved
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


        UomTypeStateEventId IUomTypeStateEvent.StateEventId
        {
            get { return this.StateEventId.ToUomTypeStateEventId(); }
        }

        protected UomTypeStateEventDtoBase()
        {
        }

        protected UomTypeStateEventDtoBase(UomTypeStateEventIdDto stateEventId)
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


    public class UomTypeStateCreatedOrMergePatchedOrDeletedDto : UomTypeStateEventDtoBase
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



	public class UomTypeStateCreatedDto : UomTypeStateCreatedOrMergePatchedOrDeletedDto
	{
		public UomTypeStateCreatedDto()
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


	public class UomTypeStateMergePatchedDto : UomTypeStateCreatedOrMergePatchedOrDeletedDto
	{
		public UomTypeStateMergePatchedDto()
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


	public class UomTypeStateDeletedDto : UomTypeStateCreatedOrMergePatchedOrDeletedDto
	{
		public UomTypeStateDeletedDto()
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


    public partial class UomTypeStateCreatedOrMergePatchedOrDeletedDtos : IEnumerable<IUomTypeStateCreated>, IEnumerable<IUomTypeStateMergePatched>, IEnumerable<IUomTypeStateDeleted>
    {
        private List<UomTypeStateCreatedOrMergePatchedOrDeletedDto> _innerStateEvents = new List<UomTypeStateCreatedOrMergePatchedOrDeletedDto>();

        public virtual UomTypeStateCreatedOrMergePatchedOrDeletedDto[] ToArray()
        {
            return _innerStateEvents.ToArray();
        }

        public virtual void Clear()
        {
            _innerStateEvents.Clear();
        }

        public virtual void AddRange(IEnumerable<UomTypeStateCreatedOrMergePatchedOrDeletedDto> es)
        {
            _innerStateEvents.AddRange(es);
        }

        System.Collections.IEnumerator System.Collections.IEnumerable.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }

        IEnumerator<IUomTypeStateCreated> IEnumerable<IUomTypeStateCreated>.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }

        IEnumerator<IUomTypeStateMergePatched> IEnumerable<IUomTypeStateMergePatched>.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }

        IEnumerator<IUomTypeStateDeleted> IEnumerable<IUomTypeStateDeleted>.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }

        public void AddUomTypeEvent(IUomTypeStateCreated e)
        {
            _innerStateEvents.Add((UomTypeStateCreatedDto)e);
        }

        public void AddUomTypeEvent(IUomTypeStateEvent e)
        {
            _innerStateEvents.Add((UomTypeStateCreatedOrMergePatchedOrDeletedDto)e);
        }

        public void AddUomTypeEvent(IUomTypeStateDeleted e)
        {
            _innerStateEvents.Add((UomTypeStateDeletedDto)e);
        }

    }


}

