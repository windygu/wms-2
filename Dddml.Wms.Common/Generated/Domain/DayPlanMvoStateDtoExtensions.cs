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

	public static partial class DayPlanMvoStateDtoExtensions
	{

        public static IDayPlanMvoCommand ToCreateOrMergePatchDayPlanMvo(this DayPlanMvoStateDto state)
        {
            return state.ToCreateOrMergePatchDayPlanMvo<CreateDayPlanMvoDto, MergePatchDayPlanMvoDto>();
        }

        public static DeleteDayPlanMvoDto ToDeleteDayPlanMvo(this DayPlanMvoStateDto state)
        {
            return state.ToDeleteDayPlanMvo<DeleteDayPlanMvoDto>();
        }

        public static MergePatchDayPlanMvoDto ToMergePatchDayPlanMvo(this DayPlanMvoStateDto state)
        {
            return state.ToMergePatchDayPlanMvo<MergePatchDayPlanMvoDto>();
        }

        public static CreateDayPlanMvoDto ToCreateDayPlanMvo(this DayPlanMvoStateDto state)
        {
            return state.ToCreateDayPlanMvo<CreateDayPlanMvoDto>();
        }
		

	}

}
