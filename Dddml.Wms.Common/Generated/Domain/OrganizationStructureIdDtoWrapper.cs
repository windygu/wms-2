﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateBoundedContextDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;

namespace Dddml.Wms.Domain
{

	public class OrganizationStructureIdDtoWrapper : OrganizationStructureIdDto
	{

        private OrganizationStructureId _value = new OrganizationStructureId();

		public OrganizationStructureIdDtoWrapper()
		{
		}

		public OrganizationStructureIdDtoWrapper(OrganizationStructureId val)
		{
			if (val == null) { throw new ArgumentNullException("val"); }
			this._value = val;
		}

        public override OrganizationStructureId ToOrganizationStructureId()
        {
            return this._value;
        }

		public override string OrganizationStructureTypeId { 
			get { return _value.OrganizationStructureTypeId; } 
			set { _value.OrganizationStructureTypeId = value; } 
		}

		public override string ParentId { 
			get { return _value.ParentId; } 
			set { _value.ParentId = value; } 
		}

		public override string SubsidiaryId { 
			get { return _value.SubsidiaryId; } 
			set { _value.SubsidiaryId = value; } 
		}


	}

}


