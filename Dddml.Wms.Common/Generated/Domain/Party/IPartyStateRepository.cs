﻿// <autogenerated>
//   This file was generated by T4 code generator GeneratePartyDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Party;
using Dddml.Support.Criterion;

namespace Dddml.Wms.Domain.Party
{
	public partial interface IPartyStateRepository
	{

        IPartyState Get(string id, bool nullAllowed);
        
        void Save(IPartyState state);
        
	}

}

