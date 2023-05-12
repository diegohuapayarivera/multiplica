package mtrorrey.com.chipproducer.infrastructure.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Serializer {
	private static final ObjectMapper mapper = new ObjectMapper();
	private static final Logger log = LoggerFactory.getLogger(Serializer.class);
	
	static{ 
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		mapper.configure(SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS, false);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
	}
		
	public static <T> T jsonToObject(String json, Class<T> clase) {
		Object object = null;
		try {
			object = mapper.readValue(json, clase);
		} catch (IOException e) {
			log.info(e.getMessage());
		}
		return clase.cast(object);
	}
	
	public static <T> String objectToJson(T objeto) {
		String json = null;
		try {
			json = mapper.writeValueAsString(objeto);
		} catch (JsonProcessingException e) {			
			log.info(e.getMessage());
		}
		return json;		
	}

	private Serializer() {
	    throw new IllegalStateException("Clase Serializer");
	  }
}
