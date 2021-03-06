﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateLotDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Lot;

namespace Dddml.Wms.Domain.Lot
{

	public partial interface ILotAggregate : IGlobalIdentity<string>
	{
		ILotState State { get; }

		IList<IEvent> Changes { get; }

		void ThrowOnInvalidStateTransition (ICommand c);

		void Create (ICreateLot c);

		void MergePatch (IMergePatchLot c);

		void Delete (IDeleteLot c);


	}

}

