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

	public class UserClaimMvoStateEventIdDtoWrapper : UserClaimMvoStateEventIdDto
	{

        private UserClaimMvoStateEventId _value = new UserClaimMvoStateEventId();

		public UserClaimMvoStateEventIdDtoWrapper()
		{
		}

		public UserClaimMvoStateEventIdDtoWrapper(UserClaimMvoStateEventId val)
		{
			if (val == null) { throw new ArgumentNullException("val"); }
			this._value = val;
		}

        public override UserClaimMvoStateEventId ToUserClaimMvoStateEventId()
        {
            return this._value;
        }

		public override UserClaimIdDto UserClaimId { 
			get { return new UserClaimIdDtoWrapper(_value.UserClaimId); } 
			set { _value.UserClaimId = value.ToUserClaimId(); } 
		}

		public override long UserVersion { 
			get { return _value.UserVersion; } 
			set { _value.UserVersion = value; } 
		}


	}

}


