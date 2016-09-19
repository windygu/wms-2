﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateControllers.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Metadata;
using Dddml.Wms.HttpServices.Filters;
using System.Linq;
using System.Net;
using System.ComponentModel;
using System.Net.Http;
using System.Net.Http.Formatting;
using System.Web.Http;
using Newtonsoft.Json.Linq;
using Dddml.Support.Criterion;

namespace Dddml.Wms.HttpServices.ApiControllers
{

    [RoutePrefix("api/Users")][Authorize]
    public partial class UsersController : ApiController
    {

        IUserApplicationService _userApplicationService = ApplicationContext.Current["UserApplicationService"] as IUserApplicationService;

        [Route(Order = 1)]
        [HttpGet]
        public IEnumerable<UserStateDto> GetAll(string sort = null, string fields = null, int firstResult = 0, int maxResults = int.MaxValue, string filter = null)
        {
          try {
            IEnumerable<IUserState> states = null; 
            if (!String.IsNullOrWhiteSpace(filter))
            {
                states = _userApplicationService.Get(CriterionDto.ToSubclass(JObject.Parse(filter).ToObject<CriterionDto>(),new ApiControllerTypeConverter(), new PropertyTypeResolver())
                    , UsersControllerUtils.GetQueryOrders(sort, QueryOrderSeparator), firstResult, maxResults);
            }
            else 
            {
                states = _userApplicationService.Get(UsersControllerUtils.GetQueryFilterDictionary(this.Request.GetQueryNameValuePairs())
                    , UsersControllerUtils.GetQueryOrders(sort, QueryOrderSeparator), firstResult, maxResults);
            }
            var stateDtos = new List<UserStateDto>();
            foreach (var s in states)
            {
                var dto = s is UserStateDto ? (UserStateDto)s : new UserStateDto((UserState)s);
                if (String.IsNullOrWhiteSpace(fields))
                {
                    dto.AllFieldsReturned = true;
                }
                else
                {
                    dto.ReturnedFieldsString = fields;
                }
                stateDtos.Add(dto);
            }
            return stateDtos;
          } catch (Exception ex) { var response = UsersControllerUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [HttpGet]
        public UserStateDto Get(string id, string fields = null)
        {
          try {
            var idObj = id;
            var state = (UserState)_userApplicationService.Get(idObj);
            if (state == null) { return null; }
            var stateDto = new UserStateDto(state);
            if (String.IsNullOrWhiteSpace(fields))
            {
                stateDto.AllFieldsReturned = true;
            }
            else
            {
                stateDto.ReturnedFieldsString = fields;
            }
            return stateDto;
          } catch (Exception ex) { var response = UsersControllerUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }


        [Route("_count")]
        [HttpGet]
        public long GetCount(string filter = null)
        {
          try
          {
            long count = 0;
            if (!String.IsNullOrWhiteSpace(filter))
            {
                count = _userApplicationService.GetCount(CriterionDto.ToSubclass(JObject.Parse(filter).ToObject<CriterionDto>(),new ApiControllerTypeConverter(), new PropertyTypeResolver()));
            }
            else 
            {
                count = _userApplicationService.GetCount(UsersControllerUtils.GetQueryFilterDictionary(this.Request.GetQueryNameValuePairs()));
            }
            return count;
          } catch (Exception ex) { var response = UsersControllerUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [HttpPut][SetRequesterId][Authorize(Roles = "SystemAdministrator,UserManagement")]
        public void Put(string id, [FromBody]CreateUserDto value)
        {
          try {
            UsersControllerUtils.SetNullIdOrThrowOnInconsistentIds(id, value);
            _userApplicationService.When(value as ICreateUser);
          } catch (Exception ex) { var response = UsersControllerUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [HttpPatch][SetRequesterId][Authorize(Roles = "SystemAdministrator,UserManagement")]
        public void Patch(string id, [FromBody]MergePatchUserDto value)
        {
          try {
            UsersControllerUtils.SetNullIdOrThrowOnInconsistentIds(id, value);
            _userApplicationService.When(value as IMergePatchUser);
          } catch (Exception ex) { var response = UsersControllerUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [HttpDelete][SetRequesterId][Authorize(Roles = "SystemAdministrator,UserManagement")]
        public void Delete(string id, string commandId, string version, string requesterId = default(string))
        {
          try {
            var value = new DeleteUserDto();
            value.CommandId = commandId;
            value.RequesterId = requesterId;
            value.Version = (long)Convert.ChangeType(version, typeof(long));
            UsersControllerUtils.SetNullIdOrThrowOnInconsistentIds(id, value);
            _userApplicationService.When(value as IDeleteUser);
          } catch (Exception ex) { var response = UsersControllerUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }


        [Route("_metadata/filteringFields")]
        [HttpGet]
        public IEnumerable<PropertyMetadata> GetMetadataFilteringFields()
        {
          try {
            var filtering = new List<PropertyMetadata>();
            foreach (var p in UserMetadata.Instance.Properties)
            {
                if (p.IsFilteringProperty)
                {
                    filtering.Add(p);
                }
            }
            return filtering;
          } catch (Exception ex) { var response = UsersControllerUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route("{id}/_stateEvents/{version}")]
        [HttpGet]
        public IUserStateEvent GetStateEvent(string id, long version)
        {
          try {
            var idObj = id;
            return _userApplicationService.GetStateEvent(idObj, version);
          } catch (Exception ex) { var response = UsersControllerUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route("{id}/_historyStates/{version}")]
        [HttpGet]
        public UserStateDto Get(string id, long version, string fields = null)
        {
          try {
            var idObj = id;
            var state = (UserState)_userApplicationService.GetHistoryState(idObj, version);
            if (state == null) { return null; }
            var stateDto = new UserStateDto(state);
            if (String.IsNullOrWhiteSpace(fields))
            {
                stateDto.AllFieldsReturned = true;
            }
            else
            {
                stateDto.ReturnedFieldsString = fields;
            }
            return stateDto;
          } catch (Exception ex) { var response = UsersControllerUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route("{userId}/UserRoles/{roleId}")]
        [HttpGet]
        public UserRoleStateDto GetUserRole(string userId, string roleId)
        {
          try {
            var state = (UserRoleState)_userApplicationService.GetUserRole(userId, roleId);
            if (state == null) { return null; }
            var stateDto = new UserRoleStateDto(state);
            stateDto.AllFieldsReturned = true;
            return stateDto;
          } catch (Exception ex) { var response = UsersControllerUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route("{userId}/UserClaims/{claimId}")]
        [HttpGet]
        public UserClaimStateDto GetUserClaim(string userId, int claimId)
        {
          try {
            var state = (UserClaimState)_userApplicationService.GetUserClaim(userId, claimId);
            if (state == null) { return null; }
            var stateDto = new UserClaimStateDto(state);
            stateDto.AllFieldsReturned = true;
            return stateDto;
          } catch (Exception ex) { var response = UsersControllerUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route("{userId}/UserPermissions/{permissionId}")]
        [HttpGet]
        public UserPermissionStateDto GetUserPermission(string userId, string permissionId)
        {
          try {
            var state = (UserPermissionState)_userApplicationService.GetUserPermission(userId, permissionId);
            if (state == null) { return null; }
            var stateDto = new UserPermissionStateDto(state);
            stateDto.AllFieldsReturned = true;
            return stateDto;
          } catch (Exception ex) { var response = UsersControllerUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route("{userId}/UserLogins/{loginKey}")]
        [HttpGet]
        public UserLoginStateDto GetUserLogin(string userId, string loginKey)
        {
          try {
            var state = (UserLoginState)_userApplicationService.GetUserLogin(userId, (new LoginKeyFlattenedDtoFormatter().Parse(loginKey)).ToLoginKey());
            if (state == null) { return null; }
            var stateDto = new UserLoginStateDto(state);
            stateDto.AllFieldsReturned = true;
            return stateDto;
          } catch (Exception ex) { var response = UsersControllerUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }


		// /////////////////////////////////////////////////

        protected virtual string QueryOrderSeparator
        {
            get { return ","; }
        }

        // ////////////////////////////////

        private class ApiControllerTypeConverter : Dddml.Support.Criterion.ITypeConverter
        {
            public T ConvertFromString<T>(string text)
            {
                return (T)ApplicationContext.Current.TypeConverter.ConvertFromString(typeof(T), text);
            }

            public object ConvertFromString(Type type, string text)
            {
                return ApplicationContext.Current.TypeConverter.ConvertFromString(type, text);
            }

            public string ConvertToString<T>(T value)
            {
                return ApplicationContext.Current.TypeConverter.ConvertToString(typeof(T), value);
            }

            public string ConvertToString(object value)
            {
                return ApplicationContext.Current.TypeConverter.ConvertToString(value.GetType(), value);
            }

            public string[] ConvertToStringArray(object[] values)
            {
                throw new NotSupportedException();
            }
        }

        private class PropertyTypeResolver : IPropertyTypeResolver
        {

            public Type ResolveTypeByPropertyName(string propertyName)
            {
                return UsersControllerUtils.GetFilterPropertyType(propertyName);
            }
        }

    }


    
    public static class UsersControllerUtils
    {

        public static HttpResponseMessage GetErrorHttpResponseMessage(Exception ex)
        {
            var errorName = ex.GetType().Name;
            var errorMessage = ex.Message;
            if (ex is DomainError)
            {
                DomainError de = ex as DomainError;
                errorName = de.Name;
                errorMessage = de.Message;
            }
            else
            {
                //改进??
                errorMessage = String.IsNullOrWhiteSpace(ex.Message) ? String.Empty : ex.Message.Substring(0, (ex.Message.Length > 140) ? 140 : ex.Message.Length);
            }
            dynamic content = new JObject();
            content.ErrorName = errorName;
            content.ErrorMessage = errorMessage;
            var response = new HttpResponseMessage(HttpStatusCode.InternalServerError)
            {
                Content = new ObjectContent<JObject>(content as JObject, new JsonMediaTypeFormatter()),
                ReasonPhrase = "Server Error"
            };
            return response;
        }

        public static void SetNullIdOrThrowOnInconsistentIds(string id, CreateOrMergePatchOrDeleteUserDto value)
        {
            var idObj = id;
            if (value.UserId == null)
            {
                value.UserId = idObj;
            }
            else if (!((ICreateOrMergePatchOrDeleteUser)value).UserId.Equals(idObj))
            {
                throw DomainError.Named("inconsistentId", "Argument Id {0} NOT equals body Id {1}", id, value.UserId);
            }
        }


        public static string GetFilterPropertyName(string fieldName)
        {
            if (String.Equals(fieldName, "sort", StringComparison.InvariantCultureIgnoreCase)
                || String.Equals(fieldName, "firstResult", StringComparison.InvariantCultureIgnoreCase)
                || String.Equals(fieldName, "maxResults", StringComparison.InvariantCultureIgnoreCase)
                || String.Equals(fieldName, "fields", StringComparison.InvariantCultureIgnoreCase))
            {
                return null;
            }
            if (UserMetadata.Instance.PropertyMetadataDictionary.ContainsKey(fieldName))
            {
                var p = UserMetadata.Instance.PropertyMetadataDictionary[fieldName];
                if (p.IsFilteringProperty)
                {
                    var propertyName = fieldName;
                    if (p.IsDerived)
                    {
                        propertyName = p.DerivedFrom;
                    }
                    return propertyName;
                }
            }
            return null;
        }

        public static Type GetFilterPropertyType(string propertyName)
        {
            if (UserMetadata.Instance.PropertyMetadataDictionary.ContainsKey(propertyName))
            {
                return UserMetadata.Instance.PropertyMetadataDictionary[propertyName].Type;
            }
            return typeof(string);
        }

        public static IDictionary<string, object> GetQueryFilterDictionary(IEnumerable<KeyValuePair<string, string>> queryNameValuePairs)
        {
            var filter = new Dictionary<string, object>();
            foreach (var p in queryNameValuePairs)
            {
                var pName = GetFilterPropertyName(p.Key);
                if (!String.IsNullOrWhiteSpace(pName))
                {
                    Type type = GetFilterPropertyType(pName);
                    var pValue = ApplicationContext.Current.TypeConverter.ConvertFromString(type, p.Value);
                    filter.Add(pName, pValue);
                }
            }
            return filter;
        }

        public static IList<string> GetQueryOrders(string str, string separator)
        {
            if (String.IsNullOrWhiteSpace(str))
            {
                return new string[0];
            }
            var arr = str.Split(new string[] { separator }, StringSplitOptions.RemoveEmptyEntries);
            var orders = new List<string>();
            foreach (var a in arr)
            {
                orders.Add(a.Trim());
            }
            return orders;
        }

        public static IEnumerable<UserStateDto> ToUserStateDtoCollection(IEnumerable<string> ids)
        {
            var states = new List<UserStateDto>();
            foreach (var id in ids)
            {
                var dto = new UserStateDto();
                dto.UserId = id;
                states.Add(dto);
            }
            return states;
        }

    }

}

