﻿// <autogenerated>
//   This file was generated by T4 code generator GeneratePickwaveDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Pickwave;

namespace Dddml.Wms.Domain.Pickwave
{

	public abstract class PickwaveStateEventDtoBase : IStateEventDto, IPickwaveStateCreated, IPickwaveStateMergePatched, IPickwaveStateDeleted
	{

        private PickwaveEventId _pickwaveEventId;

		protected internal virtual PickwaveEventId PickwaveEventId 
        {
            get 
            {
                if (_pickwaveEventId == null) { _pickwaveEventId = new PickwaveEventId(); }
                return _pickwaveEventId;
            }
            set
            {
                _pickwaveEventId = value;
            }
        }

        public virtual long? PickwaveId
        {
            get { return PickwaveEventId.PickwaveId; }
            set { PickwaveEventId.PickwaveId = value; }
        }

        public virtual long Version
        {
            get { return PickwaveEventId.Version; }
            set { PickwaveEventId.Version = value; }
        }

		public virtual string StatusId { get; set; }

		public virtual string Description { get; set; }

		public virtual bool? Active { get; set; }

		public virtual string CreatedBy { get; set; }

		public virtual DateTime CreatedAt { get; set; }

        public virtual string CommandId { get; set; }

        string IEvent.CommandId { get { return this.CommandId; } set { this.CommandId = value; } }

		PickwaveEventId IGlobalIdentity<PickwaveEventId>.GlobalId {
			get 
			{
				return this.PickwaveEventId;
			}
		}

        public virtual bool StateEventReadOnly { get; set; }

        bool IPickwaveStateEvent.ReadOnly
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

		public virtual bool? IsPropertyStatusIdRemoved { get; set; }

        bool IPickwaveStateMergePatched.IsPropertyStatusIdRemoved
        {
            get 
            {
                var b = this.IsPropertyStatusIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyStatusIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyDescriptionRemoved { get; set; }

        bool IPickwaveStateMergePatched.IsPropertyDescriptionRemoved
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

        bool IPickwaveStateMergePatched.IsPropertyActiveRemoved
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


        PickwaveEventId IPickwaveStateEvent.PickwaveEventId
        {
            get { return this.PickwaveEventId; }
        }

        protected PickwaveStateEventDtoBase()
        {
        }

        protected PickwaveStateEventDtoBase(PickwaveEventId stateEventId)
        {
            this.PickwaveEventId = stateEventId;
        }

        // //////////////////////////////////////////////////

        string IStateEventDto.StateEventType 
        {
            get { return this.GetStateEventType(); }
        }

        protected abstract string GetStateEventType();

	}


    public class PickwaveStateCreatedOrMergePatchedOrDeletedDto : PickwaveStateEventDtoBase
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



	public class PickwaveStateCreatedDto : PickwaveStateCreatedOrMergePatchedOrDeletedDto
	{
		public PickwaveStateCreatedDto()
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


	public class PickwaveStateMergePatchedDto : PickwaveStateCreatedOrMergePatchedOrDeletedDto
	{
		public PickwaveStateMergePatchedDto()
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


	public class PickwaveStateDeletedDto : PickwaveStateCreatedOrMergePatchedOrDeletedDto
	{
		public PickwaveStateDeletedDto()
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


    public partial class PickwaveStateCreatedOrMergePatchedOrDeletedDtos : IEnumerable<IPickwaveStateCreated>, IEnumerable<IPickwaveStateMergePatched>, IEnumerable<IPickwaveStateDeleted>
    {
        private List<PickwaveStateCreatedOrMergePatchedOrDeletedDto> _innerStateEvents = new List<PickwaveStateCreatedOrMergePatchedOrDeletedDto>();

        public virtual PickwaveStateCreatedOrMergePatchedOrDeletedDto[] ToArray()
        {
            return _innerStateEvents.ToArray();
        }

        public virtual void Clear()
        {
            _innerStateEvents.Clear();
        }

        public virtual void AddRange(IEnumerable<PickwaveStateCreatedOrMergePatchedOrDeletedDto> es)
        {
            _innerStateEvents.AddRange(es);
        }

        System.Collections.IEnumerator System.Collections.IEnumerable.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }

        IEnumerator<IPickwaveStateCreated> IEnumerable<IPickwaveStateCreated>.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }

        IEnumerator<IPickwaveStateMergePatched> IEnumerable<IPickwaveStateMergePatched>.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }

        IEnumerator<IPickwaveStateDeleted> IEnumerable<IPickwaveStateDeleted>.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }

        public void AddPickwaveEvent(IPickwaveStateCreated e)
        {
            _innerStateEvents.Add((PickwaveStateCreatedDto)e);
        }

        public void AddPickwaveEvent(IPickwaveStateEvent e)
        {
            _innerStateEvents.Add((PickwaveStateCreatedOrMergePatchedOrDeletedDto)e);
        }

        public void AddPickwaveEvent(IPickwaveStateDeleted e)
        {
            _innerStateEvents.Add((PickwaveStateDeletedDto)e);
        }

    }


}

