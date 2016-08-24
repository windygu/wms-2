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

	public abstract class TeamStateEventBase : ITeamStateEvent
	{

		public virtual TeamStateEventId StateEventId { get; set; }

		public virtual string Description { get; set; }

		public virtual bool? Active { get; set; }

		public virtual ISet<PersonalName> Players { get; set; }

		public virtual ISet<string> Mascots { get; set; }


		public virtual string CreatedBy { get; set; }

		public virtual DateTime CreatedAt { get; set; }

        public virtual string CommandId { get; set; }

		TeamStateEventId IGlobalIdentity<TeamStateEventId>.GlobalId {
			get {
				return this.StateEventId;
			}
		}

        public virtual bool StateEventReadOnly { get; set; }

        bool ITeamStateEvent.ReadOnly
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

        protected TeamStateEventBase()
        {
        }

        protected TeamStateEventBase(TeamStateEventId stateEventId)
        {
            this.StateEventId = stateEventId;
        }


        string IStateEventDto.StateEventType
        {
            get { return this.GetStateEventType(); }
        }

        protected abstract string GetStateEventType();

	}

	public class TeamStateCreated : TeamStateEventBase, ITeamStateCreated
	{
		public TeamStateCreated ()
		{
		}

		public TeamStateCreated (TeamStateEventId stateEventId) : base(stateEventId)
		{
		}


        protected override string GetStateEventType()
        {
            return Dddml.Wms.Specialization.StateEventType.Created;
        }

	}


	public class TeamStateMergePatched : TeamStateEventBase, ITeamStateMergePatched
	{
		public virtual bool IsPropertyDescriptionRemoved { get; set; }

		public virtual bool IsPropertyPlayersRemoved { get; set; }

		public virtual bool IsPropertyMascotsRemoved { get; set; }

		public virtual bool IsPropertyActiveRemoved { get; set; }


		public TeamStateMergePatched ()
		{
		}

		public TeamStateMergePatched (TeamStateEventId stateEventId) : base(stateEventId)
		{
		}


        protected override string GetStateEventType()
        {
            return Dddml.Wms.Specialization.StateEventType.MergePatched;
        }

	}


	public class TeamStateDeleted : TeamStateEventBase, ITeamStateDeleted
	{
		public TeamStateDeleted ()
		{
		}

		public TeamStateDeleted (TeamStateEventId stateEventId) : base(stateEventId)
		{
		}

        protected override string GetStateEventType()
        {
            return Dddml.Wms.Specialization.StateEventType.Deleted;
        }



	}



}
