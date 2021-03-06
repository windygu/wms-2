﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateLocatorTypeDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.LocatorType;

namespace Dddml.Wms.Domain.LocatorType
{
	public interface ILocatorTypeEvent : IEvent, IEventDto, IGlobalIdentity<LocatorTypeEventId>, ICreated<string>
	{
		LocatorTypeEventId LocatorTypeEventId { get; }

        bool ReadOnly { get; set; }

	}

    public interface ILocatorTypeStateEvent : ILocatorTypeEvent
    {
		string Description { get; set; }

		bool? Active { get; set; }

    }
   
	public interface ILocatorTypeStateCreated : ILocatorTypeStateEvent
	{
	
	}


	public interface ILocatorTypeStateMergePatched : ILocatorTypeStateEvent
	{
		bool IsPropertyDescriptionRemoved { get; set; }

		bool IsPropertyActiveRemoved { get; set; }


	}

	public interface ILocatorTypeStateDeleted : ILocatorTypeStateEvent
	{
	}


}

