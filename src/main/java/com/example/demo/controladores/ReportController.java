package com.example.demo.controladores;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelos.Producto;
import com.example.demo.repository.ProductoRepository;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

@Controller
@RequestMapping("/report")
public class ReportController {

	@Autowired
	private ProductoRepository productoRepository;
	
	@GetMapping("/report")
	public ResponseEntity<byte[]> showReport() throws Exception {
		
		InputStream jasperStream =
				this.getClass().getResourceAsStream("/reportes/reporteProductos.jasper");
		Map<String, Object> params = new HashMap<>();
		params.put("empresa", "Cibertec");
		
		List<Producto> listProduct = productoRepository.findAll();
		
		JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(listProduct);
		
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
		
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params , datasource);
		
		byte[] pdfBytes = JasperExportManager.exportReportToPdf(jasperPrint);
		
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_PDF);
	    headers.setContentDispositionFormData("filename", "reporte.pdf");
	    
	    return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
}
}
