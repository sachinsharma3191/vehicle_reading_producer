package com.egen.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CustomDateSerializer extends JsonSerializer<LocalDateTime> {

	@Override
	public void serialize(final LocalDateTime value,final JsonGenerator gen, final SerializerProvider arg2) throws IOException {

	    final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    final String formattedDate = formatter.format(value);
	    
	    gen.writeString(formattedDate);
	}
}
