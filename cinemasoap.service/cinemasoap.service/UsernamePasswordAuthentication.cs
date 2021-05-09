using cinemasoap.service.Models;
using System;
using System.Collections.Generic;
using System.IdentityModel.Selectors;
using System.Linq;
using System.Net;
using System.Security.Principal;
using System.ServiceModel;
using System.ServiceModel.Description;
using System.ServiceModel.Dispatcher;
using System.ServiceModel.Web;
using System.Text;
using System.Threading;
using System.Web;
using System.Web.Security;

namespace cinemasoap.service
{
    public class UsernamePasswordAuthentication: Attribute, IOperationBehavior, IParameterInspector
    {
        public void ApplyDispatchBehavior(OperationDescription operationDescription, DispatchOperation dispatchOperation)
        {
            dispatchOperation.ParameterInspectors.Add(this);
        }

        public void AfterCall(string operationName, object[] outputs, object returnValue, object correlationState)
        {
        }

        public object BeforeCall(string operationName, object[] inputs)
        {
            var usernamePasswordString = parseAuthorizationHeader(WebOperationContext.Current.IncomingRequest);
            if (usernamePasswordString != null)
            {
                string[] usernamePasswordArray = usernamePasswordString.Split(new char[] { ':' });
                string username = usernamePasswordArray[0];
                string password = usernamePasswordArray[1];
                if ((username != null) && (password != null) && User.SignIn(username, password))
                {
                    Thread.CurrentPrincipal = new GenericPrincipal(new GenericIdentity(username), new string[0]);
                    return null;
                }
                WebOperationContext.Current.OutgoingResponse.StatusCode = HttpStatusCode.Unauthorized;
                throw new FaultException<string>("Unauthorized", "Invalid credentials");
            }

            WebOperationContext.Current.OutgoingResponse.StatusCode = HttpStatusCode.Unauthorized;
            throw new FaultException<string>("Unauthorized", "Missing authorization data in Authorization header");
        }

        private string parseAuthorizationHeader(IncomingWebRequestContext request)
        {
            string rtnString = null;
            string authHeader = request.Headers["Authorization"];
            if (authHeader != null)
            {
                var authStr = authHeader.Trim();
                if (authStr.IndexOf("Basic", 0) == 0)
                {
                    string encodedCredentials = authStr.Substring(6);
                    byte[] decodedBytes = Convert.FromBase64String(encodedCredentials);
                    rtnString = new ASCIIEncoding().GetString(decodedBytes);
                }
            }
            return rtnString;
        }

        public void AddBindingParameters(OperationDescription operationDescription, System.ServiceModel.Channels.BindingParameterCollection bindingParameters)
        {
        }

        public void ApplyClientBehavior(OperationDescription operationDescription, ClientOperation clientOperation)
        {
        }

        public void Validate(OperationDescription operationDescription)
        {
        }
    }
}