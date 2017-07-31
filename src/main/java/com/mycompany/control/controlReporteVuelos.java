
package com.mycompany.control;

import com.mycompany.reportes.Reportes;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import net.sf.jasperreports.engine.JRException;

@ManagedBean
@ViewScoped
public class controlReporteVuelos implements Serializable {

    private Date Fecha1;
    private Date Fecha2;
    private String tipo;
    
    public controlReporteVuelos() {
    }

    public Date getFecha1() {
        return Fecha1;
    }

    public void setFecha1(Date Fecha1) {
        this.Fecha1 = Fecha1;
    }

    public Date getFecha2() {
        return Fecha2;
    }

    public void setFecha2(Date Fecha2) {
        this.Fecha2 = Fecha2;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public void generarReporte() throws JRException, IOException{
        Reportes r=new Reportes();
        Map parametros = new HashMap();
        parametros.put("Fecha1", Fecha1);
        parametros.put("Fecha2", Fecha2);
        r.generarReporte(parametros, tipo, "/reportes/ReporteVuelos.jasper", "Reporte");
        
    }
    
}
