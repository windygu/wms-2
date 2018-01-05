﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateAttributeSetInstanceDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.AttributeSetInstance;

namespace Dddml.Wms.Domain.AttributeSetInstance
{
    public partial class AttributeSetInstanceAggregate : AggregateBase, IAttributeSetInstanceAggregate
    {

        readonly IAttributeSetInstanceState _state;

        readonly IList<IEvent> _changes = new List<IEvent>();

        public IAttributeSetInstanceState State
        {
            get
            {
                return _state;
            }
        }

        public IList<IEvent> Changes
        {
            get
            {
                return _changes;
            }
        }

        #region IIdentity implementation

        string IGlobalIdentity<string>.GlobalId
        {
            get
            {
                return this._state.GlobalId;
            }
        }

        #endregion


        public AttributeSetInstanceAggregate(IAttributeSetInstanceState state)
        {
            _state = state;
        }


        public virtual void ThrowOnInvalidStateTransition(ICommand c)
        {
            if (((IAttributeSetInstanceStateProperties)_state).Version == AttributeSetInstanceState.VersionZero)
            {
                if (IsCommandCreate((IAttributeSetInstanceCommand)c))
                {
                    return;
                }
                throw DomainError.Named("premature", "Can't do anything to unexistent aggregate");
            }
            if (_state.Deleted)
            {
                throw DomainError.Named("zombie", "Can't do anything to deleted aggregate.");
            }
            if (IsCommandCreate((IAttributeSetInstanceCommand)c))
                throw DomainError.Named("rebirth", "Can't create aggregate that already exists");
        }

        private static bool IsCommandCreate(IAttributeSetInstanceCommand c)
        {
            return c.Version == AttributeSetInstanceState.VersionZero;
        }

        protected internal virtual void Apply(IEvent e)
        {
            OnApplying(e);
            _state.Mutate(e);
            _changes.Add(e);
        }

        public virtual void Create(ICreateAttributeSetInstance c)
        {
            IAttributeSetInstanceStateCreated e = Map(c);
            Apply(e);
        }


        protected virtual IAttributeSetInstanceStateCreated Map(ICreateAttributeSetInstance c)
        {
			var stateEventId = new AttributeSetInstanceStateEventId(c.AttributeSetInstanceId, c.Version);
            IAttributeSetInstanceStateCreated e = NewAttributeSetInstanceStateCreated(stateEventId);
		
            e.AttributeSetId = c.AttributeSetId;
            e.OrganizationId = c.OrganizationId;
            e.ReferenceId = c.ReferenceId;
            e.SerialNumber = c.SerialNumber;
            e.LotId = c.LotId;
            e.Description = c.Description;
            e.Hash = c.Hash;
            e.WidthInch = c.WidthInch;
            e.DiameterInch = c.DiameterInch;
            e.WeightLbs = c.WeightLbs;
            e.WeightKg = c.WeightKg;
            e.AirDryWeightLbs = c.AirDryWeightLbs;
            e.AirDryWeightKg = c.AirDryWeightKg;
            e.AirDryMetricTon = c.AirDryMetricTon;
            e.PackageCount = c.PackageCount;
            e.AirDryPct = c.AirDryPct;
            e._F_B_0_ = c._F_B_0_;
            e._F_I_0_ = c._F_I_0_;
            e._F_L_0_ = c._F_L_0_;
            e._F_DT_0_ = c._F_DT_0_;
            e._F_N_0_ = c._F_N_0_;
            e._F_C5_0_ = c._F_C5_0_;
            e._F_C10_0_ = c._F_C10_0_;
            e._F_C20_0_ = c._F_C20_0_;
            e._F_C50_0_ = c._F_C50_0_;
            e._F_C100_0_ = c._F_C100_0_;
            e._F_C200_0_ = c._F_C200_0_;
            e._F_C500_0_ = c._F_C500_0_;
            e._F_C1000_0_ = c._F_C1000_0_;
            e._F_B_1_ = c._F_B_1_;
            e._F_I_1_ = c._F_I_1_;
            e._F_L_1_ = c._F_L_1_;
            e._F_DT_1_ = c._F_DT_1_;
            e._F_N_1_ = c._F_N_1_;
            e._F_C5_1_ = c._F_C5_1_;
            e._F_C10_1_ = c._F_C10_1_;
            e._F_C20_1_ = c._F_C20_1_;
            e._F_C50_1_ = c._F_C50_1_;
            e._F_C100_1_ = c._F_C100_1_;
            e._F_C200_1_ = c._F_C200_1_;
            e._F_B_2_ = c._F_B_2_;
            e._F_I_2_ = c._F_I_2_;
            e._F_L_2_ = c._F_L_2_;
            e._F_DT_2_ = c._F_DT_2_;
            e._F_N_2_ = c._F_N_2_;
            e._F_C5_2_ = c._F_C5_2_;
            e._F_C10_2_ = c._F_C10_2_;
            e._F_C20_2_ = c._F_C20_2_;
            e._F_C50_2_ = c._F_C50_2_;
            e._F_B_3_ = c._F_B_3_;
            e._F_I_3_ = c._F_I_3_;
            e._F_L_3_ = c._F_L_3_;
            e._F_DT_3_ = c._F_DT_3_;
            e._F_N_3_ = c._F_N_3_;
            e._F_C5_3_ = c._F_C5_3_;
            e._F_C10_3_ = c._F_C10_3_;
            e._F_C20_3_ = c._F_C20_3_;
            e._F_C50_3_ = c._F_C50_3_;
            e._F_B_4_ = c._F_B_4_;
            e._F_I_4_ = c._F_I_4_;
            e._F_L_4_ = c._F_L_4_;
            e._F_DT_4_ = c._F_DT_4_;
            e._F_N_4_ = c._F_N_4_;
            e._F_C5_4_ = c._F_C5_4_;
            e._F_C10_4_ = c._F_C10_4_;
            e._F_C20_4_ = c._F_C20_4_;
            e._F_C50_4_ = c._F_C50_4_;
            e.Active = c.Active;
            e.CommandId = c.CommandId;


            e.CreatedBy = (string)c.RequesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();
			var version = c.Version;


            return e;
        }

        private void ThrowOnInconsistentIds(object innerObject, string innerIdName, object innerIdValue, string outerIdName, object outerIdValue)
        {
            if (!Object.Equals(innerIdValue, outerIdValue))
            {
                if (innerIdValue is string && outerIdValue is string && ((string)innerIdValue).Normalize() == ((string)outerIdValue).Normalize())
                {
                    return;
                }
                throw DomainError.Named("inconsistentId", "Outer {0} {1} NOT equals inner {2} {3}", outerIdName, outerIdValue, innerIdName, innerIdValue);
            }
        }

////////////////////////

        protected AttributeSetInstanceStateCreated NewAttributeSetInstanceStateCreated(string commandId, string requesterId)
        {
            var stateEventId = new AttributeSetInstanceStateEventId(_state.AttributeSetInstanceId, ((IAttributeSetInstanceStateProperties)_state).Version);
            var e = NewAttributeSetInstanceStateCreated(stateEventId);

            e.CommandId = commandId;

            e.CreatedBy = (string)requesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();

            return e;
        }

////////////////////////

		private AttributeSetInstanceStateCreated NewAttributeSetInstanceStateCreated(AttributeSetInstanceStateEventId stateEventId)
		{
			return new AttributeSetInstanceStateCreated(stateEventId);			
		}

    }

}

