﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateContactMechDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.ContactMech;

namespace Dddml.Wms.Domain.ContactMech
{

	public abstract class ContactMechStateProperties : IContactMechStateProperties
	{
		public virtual string ContactMechId { get; set; }

		public virtual string ContactMechTypeId { get; set; }

		public virtual string InfoString { get; set; }

		public virtual string ToName { get; set; }

		public virtual string AttnName { get; set; }

		public virtual string Address1 { get; set; }

		public virtual string Address2 { get; set; }

		public virtual string Directions { get; set; }

		public virtual string City { get; set; }

		public virtual string PostalCode { get; set; }

		public virtual string PostalCodeExt { get; set; }

		public virtual string CountryGeoId { get; set; }

		public virtual string StateProvinceGeoId { get; set; }

		public virtual string CountyGeoId { get; set; }

		public virtual string PostalCodeGeoId { get; set; }

		public virtual string GeoPointId { get; set; }

		public virtual string CountryCode { get; set; }

		public virtual string AreaCode { get; set; }

		public virtual string ContactNumber { get; set; }

		public virtual string AskForName { get; set; }

		public virtual long Version { get; set; }

		public virtual bool Active { get; set; }

        protected virtual void InitializeProperties()
        { 
        }

	}
}
