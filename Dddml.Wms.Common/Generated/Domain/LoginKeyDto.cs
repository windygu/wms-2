﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateBoundedContextDomainAggregates.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;

namespace Dddml.Wms.Domain
{

	public class LoginKeyDto
	{

        private LoginKey _value = new LoginKey();

		public LoginKeyDto()
		{
		}

		public LoginKeyDto(LoginKey val)
		{
			if (val == null) { throw new ArgumentNullException("val"); }
			this._value = val;
		}

        public LoginKey ToLoginKey()
        {
            return this._value;
        }

		public virtual string LoginProvider { 
			get { return _value.LoginProvider; } 
			set { _value.LoginProvider = value; } 
		}

		public virtual string ProviderKey { 
			get { return _value.ProviderKey; } 
			set { _value.ProviderKey = value; } 
		}


		public override bool Equals (object obj)
		{
			if (Object.ReferenceEquals (this, obj)) {
				return true;
			}

			LoginKeyDto other = obj as LoginKeyDto;
			if (other == null) {
				return false;
			}

            return _value.Equals(other._value);

		}

		public override int GetHashCode ()
		{
			return _value.GetHashCode();
		}

	}

}


