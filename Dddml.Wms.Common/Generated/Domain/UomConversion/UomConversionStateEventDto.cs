﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateUomConversionDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.UomConversion;

namespace Dddml.Wms.Domain.UomConversion
{

	public abstract class UomConversionStateEventDtoBase : IStateEventDto, IUomConversionStateCreated, IUomConversionStateMergePatched, IUomConversionStateDeleted
	{

        private UomConversionStateEventIdDto _stateEventId;

		protected internal virtual UomConversionStateEventIdDto StateEventId 
        {
            get 
            {
                if (_stateEventId == null) { _stateEventId = new UomConversionStateEventIdDto(); }
                return _stateEventId;
            }
            set
            {
                _stateEventId = value;
            }
        }

        public virtual UomConversionIdDto UomConversionId
        {
            get { return StateEventId.UomConversionId; }
            set { StateEventId.UomConversionId = value; }
        }

        public virtual long Version
        {
            get { return StateEventId.Version; }
            set { StateEventId.Version = value; }
        }

		public virtual double? ConversionFactor { get; set; }

		public virtual string CustomMethodId { get; set; }

		public virtual long? DecimalScale { get; set; }

		public virtual string RoundingMode { get; set; }

		public virtual bool? Active { get; set; }

		public virtual string CreatedBy { get; set; }

		public virtual DateTime CreatedAt { get; set; }

        public virtual string CommandId { get; set; }

        string IEvent.CommandId { get { return this.CommandId; } set { this.CommandId = value; } }

		UomConversionStateEventId IGlobalIdentity<UomConversionStateEventId>.GlobalId {
			get 
			{
				return this.StateEventId.ToUomConversionStateEventId();
			}
		}

        public virtual bool StateEventReadOnly { get; set; }

        bool IUomConversionStateEvent.ReadOnly
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

		public virtual bool? IsPropertyConversionFactorRemoved { get; set; }

        bool IUomConversionStateMergePatched.IsPropertyConversionFactorRemoved
        {
            get 
            {
                var b = this.IsPropertyConversionFactorRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyConversionFactorRemoved = value;
            }
        }

		public virtual bool? IsPropertyCustomMethodIdRemoved { get; set; }

        bool IUomConversionStateMergePatched.IsPropertyCustomMethodIdRemoved
        {
            get 
            {
                var b = this.IsPropertyCustomMethodIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyCustomMethodIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyDecimalScaleRemoved { get; set; }

        bool IUomConversionStateMergePatched.IsPropertyDecimalScaleRemoved
        {
            get 
            {
                var b = this.IsPropertyDecimalScaleRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyDecimalScaleRemoved = value;
            }
        }

		public virtual bool? IsPropertyRoundingModeRemoved { get; set; }

        bool IUomConversionStateMergePatched.IsPropertyRoundingModeRemoved
        {
            get 
            {
                var b = this.IsPropertyRoundingModeRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return default(bool);
            }
            set 
            {
                this.IsPropertyRoundingModeRemoved = value;
            }
        }

		public virtual bool? IsPropertyActiveRemoved { get; set; }

        bool IUomConversionStateMergePatched.IsPropertyActiveRemoved
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


        UomConversionStateEventId IUomConversionStateEvent.StateEventId
        {
            get { return this.StateEventId.ToUomConversionStateEventId(); }
        }

        protected UomConversionStateEventDtoBase()
        {
        }

        protected UomConversionStateEventDtoBase(UomConversionStateEventIdDto stateEventId)
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


    public class UomConversionStateCreatedOrMergePatchedOrDeletedDto : UomConversionStateEventDtoBase
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



	public class UomConversionStateCreatedDto : UomConversionStateCreatedOrMergePatchedOrDeletedDto
	{
		public UomConversionStateCreatedDto()
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


	public class UomConversionStateMergePatchedDto : UomConversionStateCreatedOrMergePatchedOrDeletedDto
	{
		public UomConversionStateMergePatchedDto()
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


	public class UomConversionStateDeletedDto : UomConversionStateCreatedOrMergePatchedOrDeletedDto
	{
		public UomConversionStateDeletedDto()
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


    public partial class UomConversionStateCreatedOrMergePatchedOrDeletedDtos : IEnumerable<IUomConversionStateCreated>, IEnumerable<IUomConversionStateMergePatched>, IEnumerable<IUomConversionStateDeleted>
    {
        private List<UomConversionStateCreatedOrMergePatchedOrDeletedDto> _innerStateEvents = new List<UomConversionStateCreatedOrMergePatchedOrDeletedDto>();

        public virtual UomConversionStateCreatedOrMergePatchedOrDeletedDto[] ToArray()
        {
            return _innerStateEvents.ToArray();
        }

        public virtual void Clear()
        {
            _innerStateEvents.Clear();
        }

        public virtual void AddRange(IEnumerable<UomConversionStateCreatedOrMergePatchedOrDeletedDto> es)
        {
            _innerStateEvents.AddRange(es);
        }

        System.Collections.IEnumerator System.Collections.IEnumerable.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }

        IEnumerator<IUomConversionStateCreated> IEnumerable<IUomConversionStateCreated>.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }

        IEnumerator<IUomConversionStateMergePatched> IEnumerable<IUomConversionStateMergePatched>.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }

        IEnumerator<IUomConversionStateDeleted> IEnumerable<IUomConversionStateDeleted>.GetEnumerator()
        {
            return _innerStateEvents.GetEnumerator();
        }

        public void AddUomConversionEvent(IUomConversionStateCreated e)
        {
            _innerStateEvents.Add((UomConversionStateCreatedDto)e);
        }

        public void AddUomConversionEvent(IUomConversionStateEvent e)
        {
            _innerStateEvents.Add((UomConversionStateCreatedOrMergePatchedOrDeletedDto)e);
        }

        public void AddUomConversionEvent(IUomConversionStateDeleted e)
        {
            _innerStateEvents.Add((UomConversionStateDeletedDto)e);
        }

    }


}

