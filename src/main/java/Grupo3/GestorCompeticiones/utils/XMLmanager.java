package Grupo3.GestorCompeticiones.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlType;

@XmlType
public class XMLmanager {
	public static <T, JAXBContext> boolean writeXML(T c, String fichero) {
		boolean result = false;
		JAXBContext context;
		try {
			context = (JAXBContext) context(c.getClass());
			Marshaller m = ((javax.xml.bind.JAXBContext) context).createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			m.marshal(c, new File(fichero));
			result = true;
		} catch (JAXBException e) {
			e.printStackTrace();
		} 
		return result;
}
private static Class<? extends Object> context(Class<? extends Object> class1) {
		
		return class1;
	}
public static <T> T readXML(T c,String fichero) {
	T result = c;
	JAXBContext context;
	try {
		context = JAXBContext.newInstance(result.getClass());
		Unmarshaller m = context.createUnmarshaller();
		result=(T)m.unmarshal(new File(fichero));
	} catch (JAXBException e) {
		e.printStackTrace();
	}
	return result;
}
}
