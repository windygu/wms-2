﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateDomainServicesDtos.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using System.Linq;

namespace Dddml.Wms.Domain.Services
{

    public partial class IdServiceCommandDtos
    {

        public class GetDocumentNumberDto
        {
            public string DocumentType { get; set; }

            public string CommandId { get; set; }

            public string RequesterId { get; set; }

            public IdServiceCommands.GetDocumentNumber ToGetDocumentNumber()
            {
                var cmd = new IdServiceCommands.GetDocumentNumber();
                cmd.DocumentType = this.DocumentType;
                cmd.CommandId = this.CommandId;
                cmd.RequesterId = this.RequesterId;
                return cmd;
            }
        }

    }

}
