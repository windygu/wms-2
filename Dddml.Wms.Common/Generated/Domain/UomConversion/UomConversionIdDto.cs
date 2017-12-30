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

	public class UomConversionIdDto
	{

		public UomConversionIdDto()
		{
		}

        public virtual UomConversionId ToUomConversionId()
        {
            UomConversionId v = new UomConversionId();
            v.UomId = this.UomId;
            v.UomIdTo = this.UomIdTo;
            return v;
        }

		public virtual string UomId { 
			get;
			set;
		}

		public virtual string UomIdTo { 
			get;
			set;
		}


		public override bool Equals (object obj)
		{
			if (Object.ReferenceEquals (this, obj)) {
				return true;
			}

			UomConversionIdDto other = obj as UomConversionIdDto;
			if (other == null) {
				return false;
			}

			return true 
				&& Object.Equals (this.UomId, other.UomId)
				&& Object.Equals (this.UomIdTo, other.UomIdTo)
				;
		}

		public override int GetHashCode ()
		{
			int hash = 0;
			if (this.UomId != null) {
				hash += 13 * this.UomId.GetHashCode ();
			}
			if (this.UomIdTo != null) {
				hash += 13 * this.UomIdTo.GetHashCode ();
			}
			return hash;
		}

	}

}


