﻿// <autogenerated>
//   This file was generated by T4 code generator GeneratePickwaveDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Pickwave;

namespace Dddml.Wms.Domain.Pickwave
{

	public static partial class PickwaveStateDtoExtension
	{

        public static IPickwaveCommand ToCreateOrMergePatchPickwave(this PickwaveStateDtoWrapper state)
        {
            return state.ToCreateOrMergePatchPickwave<CreatePickwaveDto, MergePatchPickwaveDto>();
        }

        public static DeletePickwaveDto ToDeletePickwave(this PickwaveStateDtoWrapper state)
        {
            return state.ToDeletePickwave<DeletePickwaveDto>();
        }

        public static MergePatchPickwaveDto ToMergePatchPickwave(this PickwaveStateDtoWrapper state)
        {
            return state.ToMergePatchPickwave<MergePatchPickwaveDto>();
        }

        public static CreatePickwaveDto ToCreatePickwave(this PickwaveStateDtoWrapper state)
        {
            return state.ToCreatePickwave<CreatePickwaveDto>();
        }
		

	}

}

