﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateInOutNoticeDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.InOutNotice;

namespace Dddml.Wms.Domain.InOutNotice
{

	public static partial class InOutNoticeStateDtoExtension
	{

        public static IInOutNoticeCommand ToCreateOrMergePatchInOutNotice(this InOutNoticeStateDtoWrapper state)
        {
            return state.ToCreateOrMergePatchInOutNotice<CreateInOutNoticeDto, MergePatchInOutNoticeDto>();
        }

        public static DeleteInOutNoticeDto ToDeleteInOutNotice(this InOutNoticeStateDtoWrapper state)
        {
            return state.ToDeleteInOutNotice<DeleteInOutNoticeDto>();
        }

        public static MergePatchInOutNoticeDto ToMergePatchInOutNotice(this InOutNoticeStateDtoWrapper state)
        {
            return state.ToMergePatchInOutNotice<MergePatchInOutNoticeDto>();
        }

        public static CreateInOutNoticeDto ToCreateInOutNotice(this InOutNoticeStateDtoWrapper state)
        {
            return state.ToCreateInOutNotice<CreateInOutNoticeDto>();
        }
		

	}

}

