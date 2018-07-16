/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.espacios.util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.ws.rs.WebApplicationException;
 
public class RESTTimeParam {
 
    private SimpleDateFormat df = new SimpleDateFormat( "h:mma" );
    private java.sql.Time time;
 
    public RESTTimeParam( String timeStr ) throws WebApplicationException {
        try {
            time = new java.sql.Time( df.parse( timeStr ).getTime() );
        } catch ( final ParseException ex ) {
            throw new WebApplicationException( ex );
        }
    }
 
    public java.sql.Time getTime() {
        return time;
    }
 
    @Override
    public String toString() {
        if ( time != null ) {
            return time.toString();
        } else {
            return "";
        }
    }
}