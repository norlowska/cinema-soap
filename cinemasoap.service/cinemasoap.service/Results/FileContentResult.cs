using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Web;

namespace cinemasoap.service.Results
{
    [DataContract]
    public class FileContentResult
    {
        [DataMember]
        public byte[] Content;
        [DataMember]
        public string Message; 
    }
}