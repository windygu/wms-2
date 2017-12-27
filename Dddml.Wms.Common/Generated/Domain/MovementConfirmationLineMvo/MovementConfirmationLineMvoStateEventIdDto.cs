﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateMovementConfirmationLineMvoDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.MovementConfirmationLineMvo;
using Dddml.Wms.Domain.MovementConfirmation;

namespace Dddml.Wms.Domain.MovementConfirmationLineMvo
{

	public class MovementConfirmationLineMvoStateEventIdDto
	{

		public MovementConfirmationLineMvoStateEventIdDto()
		{
		}

        public virtual MovementConfirmationLineMvoStateEventId ToMovementConfirmationLineMvoStateEventId()
        {
            MovementConfirmationLineMvoStateEventId v = new MovementConfirmationLineMvoStateEventId();
            v.MovementConfirmationLineId = this.MovementConfirmationLineId.ToMovementConfirmationLineId();
            v.MovementConfirmationVersion = this.MovementConfirmationVersion;
            return v;
        }

		private MovementConfirmationLineIdDto _movementConfirmationLineId = new MovementConfirmationLineIdDto();

		public virtual MovementConfirmationLineIdDto MovementConfirmationLineId { 
			get { return this._movementConfirmationLineId; } 
			set { this._movementConfirmationLineId = value; } 
		}

		public virtual long MovementConfirmationVersion { 
			get;
			set;
		}


		public override bool Equals (object obj)
		{
			if (Object.ReferenceEquals (this, obj)) {
				return true;
			}

			MovementConfirmationLineMvoStateEventIdDto other = obj as MovementConfirmationLineMvoStateEventIdDto;
			if (other == null) {
				return false;
			}

			return true 
				&& Object.Equals (this.MovementConfirmationLineId, other.MovementConfirmationLineId)
				&& Object.Equals (this.MovementConfirmationVersion, other.MovementConfirmationVersion)
				;
		}

		public override int GetHashCode ()
		{
			int hash = 0;
			if (this.MovementConfirmationLineId != null) {
				hash += 13 * this.MovementConfirmationLineId.GetHashCode ();
			}
			if (this.MovementConfirmationVersion != null) {
				hash += 13 * this.MovementConfirmationVersion.GetHashCode ();
			}
			return hash;
		}

	}

}

