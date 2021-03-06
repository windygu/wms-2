﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateInOutDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.InOut;

namespace Dddml.Wms.Domain.InOut
{

	public abstract class InOutImageStateEventDtoBase : IEventDto, IInOutImageStateCreated, IInOutImageStateMergePatched, IInOutImageStateRemoved
	{

        private InOutImageEventId _inOutImageEventId;

		protected internal virtual InOutImageEventId InOutImageEventId 
        {
            get 
            {
                if (_inOutImageEventId == null) { _inOutImageEventId = new InOutImageEventId(); }
                return _inOutImageEventId;
            }
            set
            {
                _inOutImageEventId = value;
            }
        }

        public virtual string SequenceId
        {
            get { return InOutImageEventId.SequenceId; }
            set { InOutImageEventId.SequenceId = value; }
        }

		public virtual string Url { get; set; }

		public virtual bool? Active { get; set; }

		public virtual string CreatedBy { get; set; }

		public virtual DateTime CreatedAt { get; set; }

        public virtual string CommandId { get; set; }

        string IEvent.CommandId { get { return this.CommandId; } set { this.CommandId = value; } }

		InOutImageEventId IGlobalIdentity<InOutImageEventId>.GlobalId {
			get 
			{
				return this.InOutImageEventId;
			}
		}

        public virtual bool EventReadOnly { get; set; }

        bool IInOutImageEvent.ReadOnly
        {
            get
            {
                return this.EventReadOnly;
            }
            set
            {
                this.EventReadOnly = value;
            }
        }

		public virtual long Version { get; set; }

		public virtual bool? IsPropertyUrlRemoved { get; set; }

        bool IInOutImageStateMergePatched.IsPropertyUrlRemoved
        {
            get 
            {
                var b = this.IsPropertyUrlRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyUrlRemoved = value;
            }
        }

		public virtual bool? IsPropertyActiveRemoved { get; set; }

        bool IInOutImageStateMergePatched.IsPropertyActiveRemoved
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


        InOutImageEventId IInOutImageEvent.InOutImageEventId
        {
            get { return this.InOutImageEventId; }
        }

        protected InOutImageStateEventDtoBase()
        {
        }

        protected InOutImageStateEventDtoBase(InOutImageEventId stateEventId)
        {
            this.InOutImageEventId = stateEventId;
        }

        // //////////////////////////////////////////////////

        string IEventDto.EventType 
        {
            get { return this.GetEventType(); }
        }

        protected abstract string GetEventType();

	}


    public class InOutImageStateCreatedOrMergePatchedOrRemovedDto : InOutImageStateEventDtoBase
    {
        private string _eventType;

        public virtual string EventType
        {
            get { return _eventType; }
            set { _eventType = value; }
        }

        protected override string GetEventType()
        {
            return this._eventType;
        }

    }



	public class InOutImageStateCreatedDto : InOutImageStateCreatedOrMergePatchedOrRemovedDto
	{
		public InOutImageStateCreatedDto()
		{
		}

        public override string EventType
        {
            get { return this.GetEventType(); }
            set
            {
                // do nothing
            }
        }

        protected override string GetEventType()
        {
            return Dddml.Wms.Specialization.StateEventType.Created;
        }

	}


	public class InOutImageStateMergePatchedDto : InOutImageStateCreatedOrMergePatchedOrRemovedDto
	{
		public InOutImageStateMergePatchedDto()
		{
		}

        public override string EventType
        {
            get { return this.GetEventType(); }
            set
            {
                // do nothing
            }
        }

        protected override string GetEventType()
        {
            return Dddml.Wms.Specialization.StateEventType.MergePatched;
        }

	}


	public class InOutImageStateRemovedDto : InOutImageStateCreatedOrMergePatchedOrRemovedDto
	{
		public InOutImageStateRemovedDto()
		{
		}

        public override string EventType
        {
            get { return this.GetEventType(); }
            set
            {
                // do nothing
            }
        }

        protected override string GetEventType()
        {
            return Dddml.Wms.Specialization.StateEventType.Removed;
        }

	}


    public partial class InOutImageStateCreatedOrMergePatchedOrRemovedDtos : IEnumerable<IInOutImageStateCreated>, IEnumerable<IInOutImageStateMergePatched>, IEnumerable<IInOutImageStateRemoved>
    {
        private List<InOutImageStateCreatedOrMergePatchedOrRemovedDto> _innerStateEvents = new List<InOutImageStateCreatedOrMergePatchedOrRemovedDto>();

        public virtual InOutImageStateCreatedOrMergePatchedOrRemovedDto[] ToArray()
        {
            return _innerStateEvents.ToArray();
        }

        public virtual void Clear()
        {
            _innerStateEvents.Clear();
        }

        public virtual void AddRange(IEnumerable<InOutImageStateCreatedOrMergePatchedOrRemovedDto> es)
        {
            _innerStateEvents.AddRange(es);
        }

        System.Collections.IEnumerator System.Collections.IEnumerable.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }

        IEnumerator<IInOutImageStateCreated> IEnumerable<IInOutImageStateCreated>.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }

        IEnumerator<IInOutImageStateMergePatched> IEnumerable<IInOutImageStateMergePatched>.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }

        IEnumerator<IInOutImageStateRemoved> IEnumerable<IInOutImageStateRemoved>.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }

        public void AddInOutImageEvent(IInOutImageStateCreated e)
        {
            _innerStateEvents.Add((InOutImageStateCreatedDto)e);
        }

        public void AddInOutImageEvent(IInOutImageEvent e)
        {
            _innerStateEvents.Add((InOutImageStateCreatedOrMergePatchedOrRemovedDto)e);
        }

        public void AddInOutImageEvent(IInOutImageStateRemoved e)
        {
            _innerStateEvents.Add((InOutImageStateRemovedDto)e);
        }

    }


}

