package Controladores;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Date;

public class Driver implements Serializable {

    private static final long serialVersionUID = 1L;

    public Driver() {
    }

    public String guardar_en_archivo(Long id_dte, String cadena) {
        String resultado = "";

        try {
            // String path_file = "C:\\\\FELSV3\\py\\";
            String path_file = "/FELSV3/py/";
            File directorio = new File(path_file);
            directorio.mkdir();

            FileWriter fichero = new FileWriter(path_file + "felsv_" + id_dte + ".dte", true);
            PrintWriter pw_request = new PrintWriter(fichero);
            pw_request.println(new Date() + ":: " + cadena);
            fichero.close();
        } catch (Exception ex) {

        }

        return resultado;
    }

}
