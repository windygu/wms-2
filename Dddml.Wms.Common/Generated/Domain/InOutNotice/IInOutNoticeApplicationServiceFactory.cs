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

    public partial interface IInOutNoticeApplicationServiceFactory
    {

        IInOutNoticeApplicationService InOutNoticeApplicationService { get; }

        ICreateInOutNotice NewCreateInOutNotice();

        IMergePatchInOutNotice NewMergePatchInOutNotice();

        IDeleteInOutNotice NewDeleteInOutNotice();
    }


}
