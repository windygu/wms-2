﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateOrganizationDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Organization;

namespace Dddml.Wms.Domain.Organization
{

	public class OrganizationStateEventIdDtoWrapper : OrganizationStateEventIdDto
	{

        private OrganizationStateEventId _value = new OrganizationStateEventId();

		public OrganizationStateEventIdDtoWrapper()
		{
		}

		public OrganizationStateEventIdDtoWrapper(OrganizationStateEventId val)
		{
			if (val == null) { throw new ArgumentNullException("val"); }
			this._value = val;
		}

        public override OrganizationStateEventId ToOrganizationStateEventId()
        {
            return this._value;
        }

		public override string PartyId { 
			get { return _value.PartyId; } 
			set { _value.PartyId = value; } 
		}

		public override long Version { 
			get { return _value.Version; } 
			set { _value.Version = value; } 
		}


	}

}


