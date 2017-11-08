package br.com.softwareservice.util;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDate, Date> {

	@Override
	public Date convertToDatabaseColumn(LocalDate data) {
		return Date.valueOf(data);
	}

	@Override
	public LocalDate convertToEntityAttribute(Date date) {
		return date.toLocalDate();
	}

}
