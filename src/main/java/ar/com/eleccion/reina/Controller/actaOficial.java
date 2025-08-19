package ar.com.eleccion.reina.Controller;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ar.com.eleccion.reina.Entity.Admin;
import ar.com.eleccion.reina.Entity.Jurado;
import ar.com.eleccion.reina.Entity.ganadorasDTO;
import ar.com.eleccion.reina.Service.IActaService;
import ar.com.eleccion.reina.Service.IAdminService;
import ar.com.eleccion.reina.Service.IEvaluacionService;
import ar.com.eleccion.reina.Service.IJuradoService;
import ar.com.eleccion.reina.Service.IReporteService;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
public class actaOficial {
	
	@Autowired
	IJuradoService juri;
	
	@Autowired
	IAdminService admin;
	
	@Autowired
	IActaService actaservice;
	@Autowired
	IActaService evalu;
	
	@Autowired
	IReporteService repo;
	
	//REPORTE DE ACTA
    @GetMapping("/reporte")
    public ResponseEntity<byte[]> descargaReporte(){
    	
    	//lista jurado
    	List<Jurado> listaJurado = juri.listarJurados();
    	
    	List<Admin> listaAdmin = admin.listarAdminds();
    	
    	List<ganadorasDTO> gadores = evalu.obtenerTop3Candidatas();
    	
    	JRBeanCollectionDataSource FuenteDatos1 = new JRBeanCollectionDataSource(listaJurado);
    	JRBeanCollectionDataSource FuenteDatos2 = new JRBeanCollectionDataSource(listaAdmin);
    	JRBeanCollectionDataSource FuenteDatos3 = new JRBeanCollectionDataSource(gadores);
    	//cargar el logo poe
		/*
		 * InputStream logo =
		 * getClass().getResourceAsStream("/static/img/logo-fiesta.png");
		 */
    	
    	
    	//creamos los parametros a pasar
    	Map<String, Object> parametros = new HashMap<>();
    	parametros.put("admin", FuenteDatos2);
    	parametros.put("jurado", FuenteDatos1);
    	parametros.put("reinas", FuenteDatos3);
		/* parametros.put("logo", logo); */
    	//llamamos al servicio que genera el pdf
    	
    	
        byte[] reportePDF = null;
		try {
			reportePDF = repo.ReporteGral("/templates/reportes/MyReports/MyReports/actaFinal.jasper", gadores, parametros);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	//devolvemos el pdf como repuesta http para que descargue
    	
    	
    return ResponseEntity.ok()
    		.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=listaArrend.pdf")
    		.contentType(MediaType.APPLICATION_PDF)
    		.body(reportePDF);}

}
