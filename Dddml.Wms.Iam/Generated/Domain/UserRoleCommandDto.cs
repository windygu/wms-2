﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateBoundedContextDomainAggregates.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.User;

namespace Dddml.Wms.Domain.User
{

	public abstract class UserRoleCommandDtoBase : ICommandDto, ICreateUserRole, IMergePatchUserRole, IRemoveUserRole
	{

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

		public virtual string RoleId { get; set; }

		public virtual bool? Active { get; set; }

		public virtual string UserId { get; set; }

		public virtual bool? IsPropertyActiveRemoved { get; set; }

        bool IMergePatchUserRole.IsPropertyActiveRemoved
        {
            get
            {
                var b = this.IsPropertyActiveRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyActiveRemoved = value;
            }
        }


        string ICommandDto.CommandType 
        {
            get { return this.GetCommandType(); }
        }

        protected abstract string GetCommandType();

	}


    public class CreateOrMergePatchOrRemoveUserRoleDto : UserRoleCommandDtoBase
    {
        private string _commandType;

        public virtual string CommandType
        {
            get { return _commandType; }
            set { _commandType = value; }
        }

        protected override string GetCommandType()
        {
            return this._commandType;
        }

    }



	public class CreateUserRoleDto : CreateOrMergePatchOrRemoveUserRoleDto
	{

        public override string CommandType
        {
            get { return this.GetCommandType(); }
            set { 
				// do nothing
            }
        }

        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.Create;
        }

	}


	public class MergePatchUserRoleDto : CreateOrMergePatchOrRemoveUserRoleDto
	{

        public override string CommandType
        {
            get { return this.GetCommandType(); }
            set { 
				// do nothing
            }
        }

        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.MergePatch;
        }

	}

	public class RemoveUserRoleDto : CreateOrMergePatchOrRemoveUserRoleDto
	{
        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.Remove;
        }


        public override string CommandType
        {
            get { return this.GetCommandType(); }
            set { 
				// do nothing
            }
        }

	}


    public partial class CreateOrMergePatchOrRemoveUserRoleDtos : IUserRoleCommands, ICreateUserRoleCommands, IEnumerable<CreateOrMergePatchOrRemoveUserRoleDto>
    {
        private List<CreateOrMergePatchOrRemoveUserRoleDto> _innerCommands = new List<CreateOrMergePatchOrRemoveUserRoleDto>();

        public virtual CreateOrMergePatchOrRemoveUserRoleDto[] ToArray()
        {
            return _innerCommands.ToArray();
        }

        public virtual void Clear()
        {
            _innerCommands.Clear();
        }

        public virtual void AddRange(IEnumerable<CreateOrMergePatchOrRemoveUserRoleDto> cs)
        {
            _innerCommands.AddRange(cs);
        }

        void IUserRoleCommands.Add(IUserRoleCommand c)
        {
            _innerCommands.Add((CreateOrMergePatchOrRemoveUserRoleDto)c);
        }

        void IUserRoleCommands.Remove(IUserRoleCommand c)
        {
            _innerCommands.Remove((CreateOrMergePatchOrRemoveUserRoleDto)c);
        }


        IEnumerator<CreateOrMergePatchOrRemoveUserRoleDto> IEnumerable<CreateOrMergePatchOrRemoveUserRoleDto>.GetEnumerator()
        {
            return _innerCommands.GetEnumerator();
        }

        IEnumerator<IUserRoleCommand> IEnumerable<IUserRoleCommand>.GetEnumerator()
        {
            return _innerCommands.GetEnumerator();
        }

        System.Collections.IEnumerator System.Collections.IEnumerable.GetEnumerator()
        {
            return _innerCommands.GetEnumerator();
        }

        void ICreateUserRoleCommands.Add(ICreateUserRole c)
        {
            _innerCommands.Add((CreateUserRoleDto)c);
        }

        void ICreateUserRoleCommands.Remove(ICreateUserRole c)
        {
            _innerCommands.Remove((CreateUserRoleDto)c);
        }

        IEnumerator<ICreateUserRole> IEnumerable<ICreateUserRole>.GetEnumerator()
        {
            return _innerCommands.GetEnumerator();
        }

    }

}

