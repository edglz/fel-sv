package Controles;

import Entidades.JsonIn.DTE_IN;
import Entidades.JsonIn.RECEPTOR_IN;
import Entidades.JsonOut.ACTIVIDAD_ECONOMICA_OUT;
import Entidades.JsonOut.DIRECCION_OUT;
import Entidades.JsonOut.RECEPTOR_OUT;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Statement;

public class Control_RECEPTOR implements Serializable {

    private static final long serialVersionUID = 1L;

    public Control_RECEPTOR() {
    }

    public void registro_db_tabla_receptor(Connection conn, DTE_IN dte_in, Long id_dte) {
        Driver driver = new Driver();

        try {
            Long id_receptor = Long.parseLong("1");
            Long id_tipo_documento_receptor = null;
            if (dte_in.getReceptor().getTipoDocumento() > 0) {
                id_tipo_documento_receptor = driver.ObtenerLong("SELECT F.ID_TIPO_DOCUMENTO_RECEPTOR FROM FEL_TIPO_DOCUMENTO_RECEPTOR F WHERE TRIM(F.CODIGO) = '" + dte_in.getReceptor().getTipoDocumento() + "'", conn);
            }
            Long id_actividad_economica = driver.ObtenerLong("SELECT F.ID_ACTIVIDAD_ECONOMICA FROM FEL_SV_ACTIVIDAD_ECONOMICA F WHERE TRIM(F.CODIGO) = '" + dte_in.getReceptor().getCodActividad() + "'", conn);
            Long id_departamento = driver.ObtenerLong("SELECT F.ID_DEPARTAMENTO FROM FEL_SV_TBL_DEPARTAMENTO F WHERE TRIM(F.CODIGO) = '" + dte_in.getReceptor().getDepartamento() + "'", conn);
            Long id_municipio = driver.ObtenerLong("SELECT F.ID_MUNICIPIO FROM FEL_SV_TBL_MUNICIPIO F WHERE TRIM(F.CODIGO) = '" + dte_in.getReceptor().getMunicipio() + "' AND F.ID_DEPARTAMENTO=" + id_departamento, conn);
            Long id_categoria_contribuyente = driver.ObtenerLong("SELECT F.ID_CATEGORIA_CONTRIBUYENTE FROM FEL_CATEGORIA_CONTRIBUYENTE F WHERE F.CODIGO='" + dte_in.getReceptor().getCategoria() + "'", conn);

            String cadenasql = "INSERT INTO FEL_SV_TBL_RECEPTOR ("
                    + "ID_DTE, "
                    + "ID_RECEPTOR, "
                    + "ID_TIPO_DOCUMENTO_RECEPTOR, "
                    + "NUMDOCUMENTONR, "
                    + "NIT, "
                    + "NRC, "
                    + "NUMFACTURADOR, "
                    + "NOMBRE, "
                    + "ID_ACTIVIDAD_ECONOMICA, "
                    + "NOMBRECOMERCIAL, "
                    + "ID_DEPARTAMENTO, "
                    + "ID_MUNICIPIO, "
                    + "DIRECCION_COMPLEMENTO, "
                    + "ID_CATEGORIA_CONTRIBUYENTE, "
                    + "TELEFONO, "
                    + "CORREO, "
                    + "FECSUJEXCL, "
                    + "NUMEXENCION, "
                    + "BIENTITULO) VALUES ("
                    + id_dte + ","
                    + id_receptor + ","
                    + id_tipo_documento_receptor + ",'"
                    + dte_in.getReceptor().getNumDocumento() + "','"
                    + dte_in.getReceptor().getNit() + "','"
                    + dte_in.getReceptor().getNrc() + "','"
                    + dte_in.getReceptor().getNumFacturador() + "','"
                    + dte_in.getReceptor().getNombre() + "',"
                    + id_actividad_economica + ",'"
                    + dte_in.getReceptor().getNombreComercial() + "',"
                    + id_departamento + ","
                    + id_municipio + ",'"
                    + dte_in.getReceptor().getComplemento() + "',"
                    + id_categoria_contribuyente + ",'"
                    + dte_in.getReceptor().getTelefono() + "','"
                    + dte_in.getReceptor().getCorreo() + "','"
                    + dte_in.getReceptor().getFecSujExcl() + "','"
                    + dte_in.getReceptor().getNumExencion() + "','"
                    + dte_in.getReceptor().getBienTitulo() + "')";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(cadenasql);
            stmt.close();
        } catch (Exception ex) {
            System.out.println("Proyecto: api-grupoterra-test-felsv | Clase: " + this.getClass().getName() + " | Metodo: registro_db_tabla_receptor | Error: " + ex.toString());
        }
    }

    public RECEPTOR_OUT registro_json_receptor(Connection conn, Long id_dte) {
        RECEPTOR_OUT resultado = null;
        Driver driver = new Driver();

        try {
            resultado = new RECEPTOR_OUT();
            resultado.setNit(driver.ObtenerString("SELECT F.NIT FROM FEL_SV_TBL_RECEPTOR F WHERE F.ID_DTE=" + id_dte, conn));
            resultado.setNrc(driver.ObtenerString("SELECT F.NRC FROM FEL_SV_TBL_RECEPTOR F WHERE F.ID_DTE=" + id_dte, conn));
            resultado.setNumFacturador(driver.ObtenerString("SELECT DECODE(F.NUMFACTURADOR,'-',NULL,F.NUMFACTURADOR) FROM FEL_SV_TBL_RECEPTOR F WHERE F.ID_DTE=" + id_dte, conn));
            resultado.setNombre(driver.ObtenerString("SELECT F.NOMBRE FROM FEL_SV_TBL_RECEPTOR F WHERE F.ID_DTE=" + id_dte, conn));
            ACTIVIDAD_ECONOMICA_OUT actividad = new ACTIVIDAD_ECONOMICA_OUT();
            actividad.setCodActividad(driver.ObtenerString("SELECT G.CODIGO FROM FEL_SV_TBL_RECEPTOR F LEFT JOIN FEL_SV_ACTIVIDAD_ECONOMICA G ON (F.ID_ACTIVIDAD_ECONOMICA=G.ID_ACTIVIDAD_ECONOMICA) WHERE F.ID_DTE=" + id_dte, conn));
            actividad.setDescActividad(driver.ObtenerString("SELECT G.VALOR FROM FEL_SV_TBL_RECEPTOR F LEFT JOIN FEL_SV_ACTIVIDAD_ECONOMICA G ON (F.ID_ACTIVIDAD_ECONOMICA=G.ID_ACTIVIDAD_ECONOMICA) WHERE F.ID_DTE=" + id_dte, conn));
            resultado.setActividad(actividad);
            resultado.setNombreComercial(driver.ObtenerString("SELECT F.NOMBRECOMERCIAL FROM FEL_SV_TBL_RECEPTOR F WHERE F.ID_DTE=" + id_dte, conn));
            DIRECCION_OUT direccion = new DIRECCION_OUT();
            direccion.setDepartamento(driver.ObtenerString("SELECT G.CODIGO FROM FEL_SV_TBL_RECEPTOR F LEFT JOIN FEL_SV_TBL_DEPARTAMENTO G ON (F.ID_DEPARTAMENTO=G.ID_DEPARTAMENTO) WHERE F.ID_DTE=" + id_dte, conn));
            direccion.setMunicipio(driver.ObtenerString("SELECT G.CODIGO FROM FEL_SV_TBL_RECEPTOR F LEFT JOIN FEL_SV_TBL_MUNICIPIO G ON (F.ID_MUNICIPIO=G.ID_MUNICIPIO) WHERE F.ID_DTE=" + id_dte, conn));
            direccion.setComplemento(driver.ObtenerString("SELECT F.DIRECCION_COMPLEMENTO FROM FEL_SV_TBL_RECEPTOR F WHERE F.ID_DTE=" + id_dte, conn));
            resultado.setDireccion(direccion);
            resultado.setCategoria(driver.ObtenerEntero("SELECT G.CODIGO FROM FEL_SV_TBL_RECEPTOR F LEFT JOIN FEL_CATEGORIA_CONTRIBUYENTE G ON (F.ID_CATEGORIA_CONTRIBUYENTE=G.ID_CATEGORIA_CONTRIBUYENTE) WHERE F.ID_DTE=" + id_dte, conn));
            resultado.setTelefono(driver.ObtenerString("SELECT F.TELEFONO FROM FEL_SV_TBL_RECEPTOR F WHERE F.ID_DTE=" + id_dte, conn));
            resultado.setCorreo(driver.ObtenerString("SELECT F.CORREO FROM FEL_SV_TBL_RECEPTOR F WHERE F.ID_DTE=" + id_dte, conn));
            resultado.setFecSujExcl(null);
        } catch (Exception ex) {
            System.out.println("Proyecto: api-grupoterra-test-felsv | Clase: " + this.getClass().getName() + " | Metodo: registro_json_receptor | Error: " + ex.toString());
        }

        return resultado;
    }

    public RECEPTOR_IN extraer_receptor_jde(Connection conn, String ambiente, String dcto_jde, String shan_jde) {
        RECEPTOR_IN resultado = new RECEPTOR_IN();
        Driver driver = new Driver();

        try {
            String esquema_jde = "";
            String esquema_jde_udc = "";
            String dblink_jde = "";
            if (ambiente.equals("test")) {
                esquema_jde = "CRPDTA";
                esquema_jde_udc = "CRPCTL";
                dblink_jde = "JDEPY";
            } else {
                esquema_jde = "PRODDTA";
                esquema_jde_udc = "PRODCTL";
                dblink_jde = "JDEPD";
            }

            if (dcto_jde.trim().equals("S3")) {
                resultado.setNit(driver.ObtenerString("SELECT NVL(REPLACE(TRIM(F.ABTX2),'-',''),'-') FROM " + esquema_jde + ".F0101@" + dblink_jde + " F WHERE F.ABAN8=" + shan_jde, conn));
                resultado.setTipoDocumento(0);
                resultado.setNumDocumento("-");
                resultado.setNrc(driver.ObtenerString("SELECT NVL(REPLACE(TRIM(F.ABTAX),'-',''),'-') FROM " + esquema_jde + ".F0101@" + dblink_jde + " F WHERE F.ABAN8=" + shan_jde, conn));
                resultado.setNumFacturador("-"); // PENDIENTE DEFINIR DONDE REGISTRAR EN JDE.
                resultado.setNombre(driver.ObtenerString("SELECT NVL(TRIM(F.WWMLNM),'-') FROM " + esquema_jde + ".F0111@" + dblink_jde + " F WHERE F.WWIDLN=0 AND F.WWAN8=" + shan_jde, conn));
                resultado.setCodActividad(driver.ObtenerString("SELECT NVL(TRIM(F.DRSPHD),'-') FROM " + esquema_jde_udc + ".F0005@" + dblink_jde + " F WHERE F.DRSY='55' AND F.DRRT='DR' AND TRIM(F.DRKY) IN (SELECT TRIM(G.ABAC06) FROM " + esquema_jde + ".F0101@" + dblink_jde + " G WHERE G.ABAN8=" + shan_jde + ")", conn));
                resultado.setNombreComercial(driver.ObtenerString("SELECT NVL(TRIM(F.WWALPH),'-') FROM " + esquema_jde + ".F0111@" + dblink_jde + " F WHERE F.WWIDLN=0 AND F.WWAN8=" + shan_jde, conn));
                resultado.setDepartamento(driver.ObtenerString("SELECT NVL(TRIM(F.DRSPHD),'-') FROM " + esquema_jde_udc + ".F0005@" + dblink_jde + " F WHERE F.DRSY='00' AND F.DRRT='S' AND TRIM(F.DRKY) IN (SELECT TRIM(G.ALADDS) FROM " + esquema_jde + ".F0116@" + dblink_jde + " G WHERE G.ALAN8=" + shan_jde + ")", conn));
                resultado.setMunicipio("17"); // PENDIENTE.
                resultado.setComplemento(driver.ObtenerString("SELECT NVL(TRIM(F.ALADD1),' ') || ' ' || NVL(TRIM(F.ALADD2),' ') || ' ' || NVL(TRIM(F.ALADD3),' ') || ' ' || NVL(TRIM(F.ALADD4),' ') FROM " + esquema_jde + ".F0116@" + dblink_jde + " F WHERE F.ALAN8=" + shan_jde, conn));
                resultado.setCategoria(driver.ObtenerEntero("SELECT NVL(TRIM(F.DRSPHD),0) FROM " + esquema_jde_udc + ".F0005@" + dblink_jde + " F WHERE F.DRSY='01' AND F.DRRT='14' AND TRIM(F.DRKY) IN (SELECT TRIM(G.ABAC14) FROM " + esquema_jde + ".F0101@" + dblink_jde + " G WHERE G.ABAN8=" + shan_jde + ")", conn));
                resultado.setTelefono(driver.ObtenerString("SELECT NVL(REPLACE(TRIM(F.WPPH1),'-',''),'-') FROM " + esquema_jde + ".F0115@" + dblink_jde + " F WHERE F.WPIDLN=0 AND F.WPCNLN=0 AND F.WPAN8=" + shan_jde, conn));
                resultado.setCorreo(driver.ObtenerString("SELECT NVL(TRIM(F.EAEMAL),'-') FROM " + esquema_jde + ".F01151@" + dblink_jde + " F WHERE F.EAIDLN=0 AND TRIM(F.EAETP) = 'E' AND F.EAAN8=" + shan_jde, conn));
                resultado.setFecSujExcl("-");
                resultado.setNumExencion("-");
                resultado.setBienTitulo("-");
            }
        } catch (Exception ex) {
            System.out.println("Proyecto: api-grupoterra-test-felsv | Clase: " + this.getClass().getName() + " | Metodo: extraer_receptor_jde | Error: " + ex.toString());
        }

        return resultado;
    }

}
