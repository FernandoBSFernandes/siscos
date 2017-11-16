package br.com.softwareservice.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("converterLocalDate")
public class ConverterLocalDateJSF implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String stringValue) {

		if (null == stringValue || stringValue.isEmpty()) {
			return null;
		}

		LocalDate localDate = null;

		try {
			localDate = LocalDate.parse(stringValue, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

		} catch (DateTimeParseException e) {
			throw new ConverterException("Informe uma idade dessa forma: dia(dd)/mes(MM)/ano(aaaa).");
		}

		return localDate;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object localDateValue) {
		if (null == localDateValue) {
			return "";
		}
		return ((LocalDate) localDateValue).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
}