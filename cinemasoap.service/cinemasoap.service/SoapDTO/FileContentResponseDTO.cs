using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Web;

namespace cinemasoap.service.SoapDTO
{
    [DataContract]
    public class FileContentResponseDTO
    {
        [DataMember]
        public byte[] Content;
        [DataMember]
        public string Message; 
    }
}