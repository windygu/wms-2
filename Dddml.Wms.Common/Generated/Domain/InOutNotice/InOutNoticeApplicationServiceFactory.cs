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

    public partial class InOutNoticeApplicationServiceFactory : IInOutNoticeApplicationServiceFactory
    {

        public virtual IInOutNoticeApplicationService InOutNoticeApplicationService 
        {
		    get
		    {
			    return ApplicationContext.Current["InOutNoticeApplicationService"] as IInOutNoticeApplicationService;
		    }
        }

        public virtual ICreateInOutNotice NewCreateInOutNotice()
        {
		    return new CreateInOutNotice();
        }

        public virtual IMergePatchInOutNotice NewMergePatchInOutNotice()
        {
            return new MergePatchInOutNotice();
        }

        public virtual IDeleteInOutNotice NewDeleteInOutNotice()
        {
            return new DeleteInOutNotice();
        }

    }


}
