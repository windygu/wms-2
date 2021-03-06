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

	public partial interface IUomConversionAggregate : IGlobalIdentity<UomConversionId>
	{
		IUomConversionState State { get; }

		IList<IEvent> Changes { get; }

		void ThrowOnInvalidStateTransition (ICommand c);

		void Create (ICreateUomConversion c);

		void MergePatch (IMergePatchUomConversion c);

		void Delete (IDeleteUomConversion c);


	}

}

