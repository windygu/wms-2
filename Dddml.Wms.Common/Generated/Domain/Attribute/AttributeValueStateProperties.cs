﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateAttributeDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Attribute;

namespace Dddml.Wms.Domain.Attribute
{

	public abstract class AttributeValueStateProperties : IAttributeValueStateProperties
	{
		public virtual string Value { get; set; }

		public virtual string AttributeValueName { get; set; }

		public virtual string Description { get; set; }

		public virtual string ReferenceId { get; set; }

		public virtual long Version { get; set; }

		public virtual bool Active { get; set; }

		// Outer Id:

		public virtual string AttributeId { get; set; }

        protected virtual void InitializeProperties()
        { 
        }

	}
}
