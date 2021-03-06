﻿// <autogenerated>
//   This file was generated by T4 code generator GeneratePhysicalInventoryDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.PhysicalInventory;
using Dddml.Wms.Domain.InventoryItem;

namespace Dddml.Wms.Domain.PhysicalInventory
{

	public static partial class PhysicalInventoryStateExtension
	{

        public static IPhysicalInventoryCommand ToCreateOrMergePatchPhysicalInventory(this PhysicalInventoryState state)
        {
            return state.ToCreateOrMergePatchPhysicalInventory<CreatePhysicalInventory, MergePatchPhysicalInventory, CreatePhysicalInventoryLine, MergePatchPhysicalInventoryLine>();
        }

        public static DeletePhysicalInventory ToDeletePhysicalInventory(this PhysicalInventoryState state)
        {
            return state.ToDeletePhysicalInventory<DeletePhysicalInventory>();
        }

        public static MergePatchPhysicalInventory ToMergePatchPhysicalInventory(this PhysicalInventoryState state)
        {
            return state.ToMergePatchPhysicalInventory<MergePatchPhysicalInventory, CreatePhysicalInventoryLine, MergePatchPhysicalInventoryLine>();
        }

        public static CreatePhysicalInventory ToCreatePhysicalInventory(this PhysicalInventoryState state)
        {
            return state.ToCreatePhysicalInventory<CreatePhysicalInventory, CreatePhysicalInventoryLine>();
        }
		

	}

}

