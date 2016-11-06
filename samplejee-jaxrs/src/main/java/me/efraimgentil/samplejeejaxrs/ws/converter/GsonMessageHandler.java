package me.efraimgentil.samplejeejaxrs.ws.converter;

import com.google.gson.GsonBuilder;
import com.google.gson.internal.Excluder;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * Created by efraimgentil<efraimgentil@gmail.com> on 06/11/16.
 */
@Provider
@Produces( MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes( MediaType.APPLICATION_JSON + ";charset=utf-8")
public class GsonMessageHandler implements MessageBodyWriter<Object>, MessageBodyReader<Object> {

  @Override
  public boolean isReadable(Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
    return true;
  }

  @Override
  public Object readFrom(Class<Object> aClass, Type type, Annotation[] annotations, MediaType mediaType
          , MultivaluedMap<String, String> multivaluedMap, InputStream inputStream) throws IOException, WebApplicationException {
    try( InputStreamReader streamReader = new InputStreamReader(inputStream) ) {
      return new GsonBuilder().create().fromJson( streamReader , getType(aClass , type ) );
    }
  }

  @Override
  public boolean isWriteable(Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
    return true;
  }

  @Override
  public long getSize(Object o, Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
    return -1;
  }

  @Override
  public void writeTo(Object o, Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType
          , MultivaluedMap<String, Object> multivaluedMap, OutputStream outputStream) throws IOException, WebApplicationException {
    try(OutputStreamWriter writer = new OutputStreamWriter( outputStream, "UTF-8" ) ){
      new GsonBuilder().create().toJson( o , getType(aClass, type) , writer );
    }
  }

  public Type getType(  Class<?> aClass, Type type) {
    Type jsonType;
    if( aClass.equals( type )) {
      jsonType = aClass;
    }else {
      jsonType = type;
    }
    return jsonType;
  }
}
