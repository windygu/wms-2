﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateAttributeSetInstanceExtensionFieldDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.AttributeSetInstanceExtensionField;

namespace Dddml.Wms.Domain.AttributeSetInstanceExtensionField
{

	public static partial class AttributeSetInstanceExtensionFieldStateExtension
	{

        public static IAttributeSetInstanceExtensionFieldCommand ToCreateOrMergePatchAttributeSetInstanceExtensionField(this AttributeSetInstanceExtensionFieldState state)
        {
            return state.ToCreateOrMergePatchAttributeSetInstanceExtensionField<CreateAttributeSetInstanceExtensionField, MergePatchAttributeSetInstanceExtensionField>();
        }

        public static DeleteAttributeSetInstanceExtensionField ToDeleteAttributeSetInstanceExtensionField(this AttributeSetInstanceExtensionFieldState state)
        {
            return state.ToDeleteAttributeSetInstanceExtensionField<DeleteAttributeSetInstanceExtensionField>();
        }

        public static MergePatchAttributeSetInstanceExtensionField ToMergePatchAttributeSetInstanceExtensionField(this AttributeSetInstanceExtensionFieldState state)
        {
            return state.ToMergePatchAttributeSetInstanceExtensionField<MergePatchAttributeSetInstanceExtensionField>();
        }

        public static CreateAttributeSetInstanceExtensionField ToCreateAttributeSetInstanceExtensionField(this AttributeSetInstanceExtensionFieldState state)
        {
            return state.ToCreateAttributeSetInstanceExtensionField<CreateAttributeSetInstanceExtensionField>();
        }
		

	}

}

