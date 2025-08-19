package ar.com.eleccion.reina.Service.Imple;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import ar.com.eleccion.reina.Service.IReporteService;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ReporteService implements IReporteService{

	@Override
	public byte[] ReporteGral(String ruta, List<?> datos, Map<String, Object> parametros) throws Exception {
		
		 InputStream reporteCompleto = getClass().getResourceAsStream(ruta);
	        JRBeanCollectionDataSource FuenteDatos = new JRBeanCollectionDataSource(datos);
	        
	        parametros.put("Parameter1", FuenteDatos);
	        JasperPrint reportePreparado = JasperFillManager.fillReport(reporteCompleto, parametros, FuenteDatos);

	        return JasperExportManager.exportReportToPdf(reportePreparado);}
	
	

}
