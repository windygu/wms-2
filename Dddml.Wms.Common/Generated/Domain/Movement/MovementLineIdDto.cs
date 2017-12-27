﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateMovementDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Movement;

namespace Dddml.Wms.Domain.Movement
{

	public class MovementLineIdDto
	{

		public MovementLineIdDto()
		{
		}

        public virtual MovementLineId ToMovementLineId()
        {
            MovementLineId v = new MovementLineId();
            v.MovementDocumentNumber = this.MovementDocumentNumber;
            v.LineNumber = this.LineNumber;
            return v;
        }

		public virtual string MovementDocumentNumber { 
			get;
			set;
		}

		public virtual string LineNumber { 
			get;
			set;
		}


		public override bool Equals (object obj)
		{
			if (Object.ReferenceEquals (this, obj)) {
				return true;
			}

			MovementLineIdDto other = obj as MovementLineIdDto;
			if (other == null) {
				return false;
			}

			return true 
				&& Object.Equals (this.MovementDocumentNumber, other.MovementDocumentNumber)
				&& Object.Equals (this.LineNumber, other.LineNumber)
				;
		}

		public override int GetHashCode ()
		{
			int hash = 0;
			if (this.MovementDocumentNumber != null) {
				hash += 13 * this.MovementDocumentNumber.GetHashCode ();
			}
			if (this.LineNumber != null) {
				hash += 13 * this.LineNumber.GetHashCode ();
			}
			return hash;
		}

	}

}

