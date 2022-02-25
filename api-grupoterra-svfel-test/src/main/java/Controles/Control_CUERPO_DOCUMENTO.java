package Controles;

import Entidades.JsonIn.DTE_IN;
import Entidades.JsonOut.CUERPO_DOCUMENTO_OUT;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Control_CUERPO_DOCUMENTO implements Serializable {

    private static final long serialVersionUID = 1L;

    public Control_CUERPO_DOCUMENTO() {
    }

    public void registro_db_tabla_cuerpo_documento(Connection conn, DTE_IN dte_in, Long id_dte) {
        Driver driver = new Driver();

        try {
            for (Integer i = 0; i < dte_in.getCuerpoDocumento().size(); i++) {
                Long id_cuerpo_documento = Long.parseLong(i.toString());
                id_cuerpo_documento++;
                Long id_bien_servicio = driver.ObtenerLong("SELECT F.ID_BIEN_SERVICIO FROM FEL_SV_TBL_BIEN_SERVICIO F WHERE F.CODIGO='" + dte_in.getCuerpoDocumento().get(i).getTipoItem() + "'", conn);
                Long id_unidad_medida = driver.ObtenerLong("SELECT F.ID_UNIDAD_MEDIDA FROM FEL_SV_TBL_UNIDAD_MEDIDA F WHERE F.VALOR_JDE='" + dte_in.getCuerpoDocumento().get(i).getUniMedida() + "'", conn);

                String cadenasql = "INSERT INTO FEL_SV_TBL_CUERPO_DOCUMENTO ("
                        + "ID_DTE,"
                        + "ID_CUERPO_DOCUMENTO,"
                        + "ID_BIEN_SERVICIO,"
                        + "CANTIDAD,"
                        + "CODIGO,"
                        + "ID_UNIDAD_MEDIDA,"
                        + "DESCRIPCION,"
                        + "PRECIOUNI,"
                        + "MONTODESCU,"
                        + "VENTANOSUJ,"
                        + "VENTAEXENTA,"
                        + "VENTAGRAVADA,"
                        + "PSV,"
                        + "DIFERENCIAL,"
                        + "NOGRAVADO) VALUES ("
                        + id_dte + ","
                        + id_cuerpo_documento + ","
                        + id_bien_servicio + ","
                        + dte_in.getCuerpoDocumento().get(i).getCantidad() + ",'"
                        + dte_in.getCuerpoDocumento().get(i).getCodigo() + "',"
                        + id_unidad_medida + ",'"
                        + dte_in.getCuerpoDocumento().get(i).getDescripcion() + "',"
                        + dte_in.getCuerpoDocumento().get(i).getPrecioUni() + ","
                        + dte_in.getCuerpoDocumento().get(i).getMontoDescu() + ","
                        + dte_in.getCuerpoDocumento().get(i).getVentaNoSuj() + ","
                        + dte_in.getCuerpoDocumento().get(i).getVentaExenta() + ","
                        + dte_in.getCuerpoDocumento().get(i).getVentaGravada() + ","
                        + dte_in.getCuerpoDocumento().get(i).getPsv() + ","
                        + dte_in.getCuerpoDocumento().get(i).getDiferencial() + ","
                        + dte_in.getCuerpoDocumento().get(i).getNoGravado() + ")";
                Statement stmt = conn.createStatement();
                // System.out.println("******************** FEL_SV_TBL_CUERPO_DOCUMENTO: " + cadenasql);
                stmt.executeUpdate(cadenasql);
                stmt.close();

                for (Integer j = 0; j < dte_in.getCuerpoDocumento().get(i).getTributos().size(); j++) {
                    Long num_tributo = Long.parseLong(j.toString());
                    num_tributo++;

                    cadenasql = "INSERT INTO FEL_CUERPO_DOCUMENTO_TRIBUTO ("
                            + "ID_DTE,"
                            + "ID_CUERPO_DOCUMENTO,"
                            + "NUM_TRIBUTO,"
                            + "ID_TRIBUTO) VALUES ("
                            + id_dte + ","
                            + id_cuerpo_documento + ","
                            + num_tributo + ","
                            + dte_in.getCuerpoDocumento().get(i).getTributos().get(j) + ")";
                    stmt = conn.createStatement();
                    // System.out.println("******************** FEL_SV_TBL_CUERPO_DOCUMENTO_TRIBUTO: " + cadenasql);
                    stmt.executeUpdate(cadenasql);
                    stmt.close();
                }
            }
        } catch (Exception ex) {
            System.out.println("Proyecto: api-grupoterra-test-felsv | Clase: " + this.getClass().getName() + " | Metodo: registro_db_tabla_cuerpo_documento | Error: " + ex.toString());
        }
    }

    public List<CUERPO_DOCUMENTO_OUT> registro_json_cuerpo_documento(Connection conn, Long id_dte) {
        List<CUERPO_DOCUMENTO_OUT> resultado = new ArrayList<>();
        Driver driver = new Driver();

        try {
            List<String> lineas_detalle = driver.ObtenerVectorString("SELECT F.ID_CUERPO_DOCUMENTO FROM FEL_SV_TBL_CUERPO_DOCUMENTO F WHERE F.ID_DTE=" + id_dte, conn);
            for (Integer i = 0; i < lineas_detalle.size(); i++) {
                CUERPO_DOCUMENTO_OUT cuerpo_documento = new CUERPO_DOCUMENTO_OUT();
                cuerpo_documento.setNumItem(Integer.parseInt(lineas_detalle.get(i)));
                cuerpo_documento.setTipoItem(driver.ObtenerEntero("SELECT G.CODIGO FROM FEL_SV_TBL_CUERPO_DOCUMENTO F LEFT JOIN FEL_SV_TBL_BIEN_SERVICIO G ON (F.ID_BIEN_SERVICIO=G.ID_BIEN_SERVICIO) WHERE F.ID_DTE=" + id_dte + " AND F.ID_CUERPO_DOCUMENTO=" + lineas_detalle.get(i), conn));
                cuerpo_documento.setCantidad(driver.ObtenerEntero("SELECT F.CANTIDAD FROM FEL_SV_TBL_CUERPO_DOCUMENTO F WHERE F.ID_DTE=" + id_dte + " AND F.ID_CUERPO_DOCUMENTO=" + lineas_detalle.get(i), conn));
                cuerpo_documento.setCodigo(driver.ObtenerString("SELECT F.CODIGO FROM FEL_SV_TBL_CUERPO_DOCUMENTO F WHERE F.ID_DTE=" + id_dte + " AND F.ID_CUERPO_DOCUMENTO=" + lineas_detalle.get(i), conn));
                cuerpo_documento.setUniMedida(driver.ObtenerEntero("SELECT G.CODIGO FROM FEL_SV_TBL_CUERPO_DOCUMENTO F LEFT JOIN FEL_SV_TBL_UNIDAD_MEDIDA G ON (F.ID_UNIDAD_MEDIDA=G.ID_UNIDAD_MEDIDA) WHERE F.ID_DTE=" + id_dte + " AND F.ID_CUERPO_DOCUMENTO=" + lineas_detalle.get(i), conn));
                cuerpo_documento.setDescripcion(driver.ObtenerString("SELECT F.DESCRIPCION FROM FEL_SV_TBL_CUERPO_DOCUMENTO F WHERE F.ID_DTE=" + id_dte + " AND F.ID_CUERPO_DOCUMENTO=" + lineas_detalle.get(i), conn));
                cuerpo_documento.setPrecioUni(driver.ObtenerDouble("SELECT F.PRECIOUNI FROM FEL_SV_TBL_CUERPO_DOCUMENTO F WHERE F.ID_DTE=" + id_dte + " AND F.ID_CUERPO_DOCUMENTO=" + lineas_detalle.get(i), conn));
                cuerpo_documento.setMontoDescu(driver.ObtenerDouble("SELECT F.MONTODESCU FROM FEL_SV_TBL_CUERPO_DOCUMENTO F WHERE F.ID_DTE=" + id_dte + " AND F.ID_CUERPO_DOCUMENTO=" + lineas_detalle.get(i), conn));
                cuerpo_documento.setVentaNoSuj(driver.ObtenerDouble("SELECT F.VENTANOSUJ FROM FEL_SV_TBL_CUERPO_DOCUMENTO F WHERE F.ID_DTE=" + id_dte + " AND F.ID_CUERPO_DOCUMENTO=" + lineas_detalle.get(i), conn));
                cuerpo_documento.setVentaExenta(driver.ObtenerDouble("SELECT F.VENTAEXENTA FROM FEL_SV_TBL_CUERPO_DOCUMENTO F WHERE F.ID_DTE=" + id_dte + " AND F.ID_CUERPO_DOCUMENTO=" + lineas_detalle.get(i), conn));
                cuerpo_documento.setVentaGravada(driver.ObtenerDouble("SELECT F.VENTAGRAVADA FROM FEL_SV_TBL_CUERPO_DOCUMENTO F WHERE F.ID_DTE=" + id_dte + " AND F.ID_CUERPO_DOCUMENTO=" + lineas_detalle.get(i), conn));
                cuerpo_documento.setTributos(driver.ObtenerVectorEntero("SELECT G.CODIGO FROM FEL_CUERPO_DOCUMENTO_TRIBUTO F LEFT JOIN FEL_SV_TBL_TRIBUTO G ON (F.ID_TRIBUTO=G.ID_TRIBUTO) WHERE F.ID_DTE=" + id_dte + " AND F.ID_CUERPO_DOCUMENTO=" + lineas_detalle.get(i), conn));
                cuerpo_documento.setPsv(driver.ObtenerDouble("SELECT F.PSV FROM FEL_SV_TBL_CUERPO_DOCUMENTO F WHERE F.ID_DTE=" + id_dte + " AND F.ID_CUERPO_DOCUMENTO=" + lineas_detalle.get(i), conn));
                cuerpo_documento.setDiferencial(driver.ObtenerDouble("SELECT F.DIFERENCIAL FROM FEL_SV_TBL_CUERPO_DOCUMENTO F WHERE F.ID_DTE=" + id_dte + " AND F.ID_CUERPO_DOCUMENTO=" + lineas_detalle.get(i), conn));
                cuerpo_documento.setNoGravado(driver.ObtenerDouble("SELECT F.NOGRAVADO FROM FEL_SV_TBL_CUERPO_DOCUMENTO F WHERE F.ID_DTE=" + id_dte + " AND F.ID_CUERPO_DOCUMENTO=" + lineas_detalle.get(i), conn));
                resultado.add(cuerpo_documento);
            }
        } catch (Exception ex) {
            System.out.println("Proyecto: api-grupoterra-test-felsv | Clase: " + this.getClass().getName() + " | Metodo: registro_json_cuerpo_documento | Error: " + ex.toString());
        }

        return resultado;
    }

}
