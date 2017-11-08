package br.com.softwareservice.util;

import java.time.LocalDate;
import java.time.ZoneId;
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
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (null == value || value.isEmpty()) {
			return null;
		}

		LocalDate localDate = null;
		try {
			localDate = LocalDate.parse(value.trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy").withZone(ZoneId.systemDefault()));
		} catch (DateTimeParseException e) {
			throw new ConverterException("A data deve ser digita dessa forma: dia(dd)/mes(MM)/ano(AAAA)");
		}

		return localDate;

	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object localDate) {
		if (null == localDate) {
			return "";
		}
		return ((LocalDate) localDate).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

}