﻿// <autogenerated>
//   This file was generated by T4 code generator GeneratePicklistRoleMvoDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.PicklistRoleMvo;
using Dddml.Wms.Domain.Picklist;

namespace Dddml.Wms.Domain.PicklistRoleMvo
{

	public abstract class PicklistRoleMvoCommandBase : IPicklistRoleMvoCommand
	{
		public virtual PicklistRoleId PicklistRoleId { get; set; }


		PicklistRoleId IAggregateCommand<PicklistRoleId, long>.AggregateId
		{
			get
			{
				return this.PicklistRoleId;
			}
		}


		long IAggregateCommand<PicklistRoleId, long>.AggregateVersion
		{
			get
			{
				return this.PicklistVersion;
			}
		}

		public virtual long PicklistVersion { get; set; }

		public virtual string RequesterId { get; set; }

		public virtual string CommandId { get; set; }

        object ICommand.RequesterId
        {
            get { return this.RequesterId; }
            set { this.RequesterId = (string)value; }
        }

        string ICommand.CommandId
        {
            get { return this.CommandId; }
            set { this.CommandId = value; }
        }

		public virtual long? Version { get; set; }

		public virtual bool? Active { get; set; }

		public virtual string PicklistDescription { get; set; }

		public virtual string PicklistFacilityId { get; set; }

		public virtual string PicklistShipmentMethodTypeId { get; set; }

		public virtual string PicklistStatusId { get; set; }

		public virtual DateTime? PicklistPicklistDate { get; set; }

		public virtual string PicklistCreatedByUserLogin { get; set; }

		public virtual string PicklistLastModifiedByUserLogin { get; set; }

		public virtual long? PicklistPickwaveId { get; set; }

		public virtual DateTime? PicklistCreatedAt { get; set; }

		public virtual DateTime? PicklistUpdatedAt { get; set; }

		public virtual bool? PicklistActive { get; set; }

		public virtual bool? PicklistDeleted { get; set; }


		// //////////////////////////////////////////////////

        string ICommandDto.CommandType 
        {
            get { return this.GetCommandType(); }
        }

        protected abstract string GetCommandType();


	}


	public class CreatePicklistRoleMvo : PicklistRoleMvoCommandBase, ICreatePicklistRoleMvo
	{
		
		public CreatePicklistRoleMvo ()
		{
		}


        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.Create;
        }
	}


	public class MergePatchPicklistRoleMvo :PicklistRoleMvoCommandBase, IMergePatchPicklistRoleMvo
	{

		public virtual bool IsPropertyVersionRemoved { get; set; }

		public virtual bool IsPropertyActiveRemoved { get; set; }

		public virtual bool IsPropertyPicklistDescriptionRemoved { get; set; }

		public virtual bool IsPropertyPicklistFacilityIdRemoved { get; set; }

		public virtual bool IsPropertyPicklistShipmentMethodTypeIdRemoved { get; set; }

		public virtual bool IsPropertyPicklistStatusIdRemoved { get; set; }

		public virtual bool IsPropertyPicklistPicklistDateRemoved { get; set; }

		public virtual bool IsPropertyPicklistCreatedByUserLoginRemoved { get; set; }

		public virtual bool IsPropertyPicklistLastModifiedByUserLoginRemoved { get; set; }

		public virtual bool IsPropertyPicklistPickwaveIdRemoved { get; set; }

		public virtual bool IsPropertyPicklistCreatedAtRemoved { get; set; }

		public virtual bool IsPropertyPicklistUpdatedAtRemoved { get; set; }

		public virtual bool IsPropertyPicklistActiveRemoved { get; set; }

		public virtual bool IsPropertyPicklistDeletedRemoved { get; set; }


		public MergePatchPicklistRoleMvo ()
		{
		}

        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.MergePatch;
        }

	}

	public class DeletePicklistRoleMvo : PicklistRoleMvoCommandBase, IDeletePicklistRoleMvo
	{
		public DeletePicklistRoleMvo ()
		{
		}

        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.Delete;
        }

	}

    public static partial class PicklistRoleMvoCommands
    {
    }

}
