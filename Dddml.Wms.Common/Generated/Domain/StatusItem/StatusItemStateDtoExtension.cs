﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateStatusItemDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.StatusItem;

namespace Dddml.Wms.Domain.StatusItem
{

	public static partial class StatusItemStateDtoExtension
	{

        public static IStatusItemCommand ToCreateOrMergePatchStatusItem(this StatusItemStateDtoWrapper state)
        {
            return state.ToCreateOrMergePatchStatusItem<CreateStatusItemDto, MergePatchStatusItemDto>();
        }

        public static DeleteStatusItemDto ToDeleteStatusItem(this StatusItemStateDtoWrapper state)
        {
            return state.ToDeleteStatusItem<DeleteStatusItemDto>();
        }

        public static MergePatchStatusItemDto ToMergePatchStatusItem(this StatusItemStateDtoWrapper state)
        {
            return state.ToMergePatchStatusItem<MergePatchStatusItemDto>();
        }

        public static CreateStatusItemDto ToCreateStatusItem(this StatusItemStateDtoWrapper state)
        {
            return state.ToCreateStatusItem<CreateStatusItemDto>();
        }
		

	}

}
