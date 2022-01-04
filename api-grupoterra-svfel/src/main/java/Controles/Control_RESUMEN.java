package Controles;

import Entidades.JsonIn.DTE_IN;
import Entidades.JsonOut.PAGOS_OUT;
import Entidades.JsonOut.RESUMEN_OUT;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Statement;

public class Control_RESUMEN implements Serializable {

    private static final long serialVersionUID = 1L;

    public Control_RESUMEN() {
    }

    public void registro_db_tabla_resumen(Connection conn, DTE_IN dte_in, Long id_dte) {
        Driver driver = new Driver();

        try {
            Long id_resumen = Long.parseLong("1");
            Long id_condicion_operacion = driver.ObtenerLong("SELECT F.ID_CONDICION_OPERACION FROM FEL_SV_CONDICION_OPERACION F WHERE F.CODIGO='" + dte_in.getResumen().getCondicionOperacion() + "'", conn);
            Long id_forma_pago = driver.ObtenerLong("SELECT F.ID_FORMA_PAGO FROM FEL_SV_TBL_FORMA_PAGO F WHERE F.CODIGO='" + dte_in.getResumen().getPagos_codigo() + "'", conn);
            Long id_plazo = driver.ObtenerLong("SELECT F.ID_PLAZO FROM FEL_SV_TBL_PLAZO F WHERE F.CODIGO='" + dte_in.getResumen().getPagos_plazo() + "'", conn);

            String cadenasql = "INSERT INTO FEL_SV_TBL_RESUMEN ("
                    + "ID_DTE,"
                    + "ID_RESUMEN,"
                    + "TOTALNOSUJ,"
                    + "TOTALEXENTA,"
                    + "TOTALGRAVADA,"
                    + "SUBTOTALVENTAS,"
                    + "PORCENTAJEDESCUENTO,"
                    + "DESCUENTO,"
                    + "TOTALIVA,"
                    + "SUBTOTAL,"
                    + "IVAPERCI1,"
                    + "IVARETE1,"
                    + "FOVIAL,"
                    + "COTRANS,"
                    + "TURISMO,"
                    + "ADVALOREM,"
                    + "MONTOTOTALOPERACION,"
                    + "TOTALNOGRAVADO,"
                    + "TOTALPAGAR,"
                    + "TOTALLETRAS,"
                    + "SALDOFAVOR,"
                    + "ID_CONDICION_OPERACION,"
                    + "ID_FORMA_PAGO,"
                    + "PAGOS_REFERENCIA,"
                    + "ID_PLAZO,"
                    + "PAGOS_PERIODO,"
                    + "NUMPAGOELECTRONICO) VALUES ("
                    + id_dte + ","
                    + id_resumen + ","
                    + dte_in.getResumen().getTotalNoSuj() + ","
                    + dte_in.getResumen().getTotalExenta() + ","
                    + dte_in.getResumen().getTotalGravada() + ","
                    + dte_in.getResumen().getSubTotalVentas() + ","
                    + dte_in.getResumen().getPorcentajeDescuento() + ","
                    + dte_in.getResumen().getDescuento() + ","
                    + dte_in.getResumen().getTotalIva() + ","
                    + dte_in.getResumen().getSubTotal() + ","
                    + dte_in.getResumen().getIvaPerci1() + ","
                    + dte_in.getResumen().getIvaRete1() + ","
                    + dte_in.getResumen().getFovial() + ","
                    + dte_in.getResumen().getCotrans() + ","
                    + dte_in.getResumen().getTurismo() + ","
                    + dte_in.getResumen().getAdValorem() + ","
                    + dte_in.getResumen().getMontoTotalOperacion() + ","
                    + dte_in.getResumen().getTotalNoGravado() + ","
                    + dte_in.getResumen().getTotalPagar() + ",'"
                    + dte_in.getResumen().getTotalLetras() + "',"
                    + dte_in.getResumen().getSaldoFavor() + ","
                    + id_condicion_operacion + ","
                    + id_forma_pago + ",'"
                    + "-" + "',"
                    + id_plazo + ","
                    + dte_in.getResumen().getPagos_periodo() + ",'"
                    + dte_in.getResumen().getNumPagoElectronico() + "')";
            Statement stmt = conn.createStatement();
            // System.out.println("******************** FEL_SV_TBL_RESUMEN: " + cadenasql);
            stmt.executeUpdate(cadenasql);
            stmt.close();
        } catch (Exception ex) {
            System.out.println("Proyecto: api-grupoterra-test-felsv | Clase: " + this.getClass().getName() + " | Metodo: registro_db_tabla_resumen | Error: " + ex.toString());
        }
    }

    public RESUMEN_OUT registro_json_resumen(Connection conn, Long id_dte) {
        RESUMEN_OUT resultado = null;
        Driver driver = new Driver();

        try {
            resultado = new RESUMEN_OUT();
            resultado.setTotalNoSuj(driver.ObtenerDouble("SELECT F.TOTALNOSUJ FROM FEL_SV_TBL_RESUMEN F WHERE F.ID_DTE=" + id_dte, conn));
            resultado.setTotalExenta(driver.ObtenerDouble("SELECT F.TOTALEXENTA FROM FEL_SV_TBL_RESUMEN F WHERE F.ID_DTE=" + id_dte, conn));
            resultado.setTotalGravada(driver.ObtenerDouble("SELECT F.TOTALGRAVADA FROM FEL_SV_TBL_RESUMEN F WHERE F.ID_DTE=" + id_dte, conn));
            resultado.setSubTotalVentas(driver.ObtenerDouble("SELECT F.SUBTOTALVENTAS FROM FEL_SV_TBL_RESUMEN F WHERE F.ID_DTE=" + id_dte, conn));
            resultado.setPorcentajeDescuento(driver.ObtenerDouble("SELECT F.PORCENTAJEDESCUENTO FROM FEL_SV_TBL_RESUMEN F WHERE F.ID_DTE=" + id_dte, conn));
            resultado.setDescuento(driver.ObtenerDouble("SELECT F.DESCUENTO FROM FEL_SV_TBL_RESUMEN F WHERE F.ID_DTE=" + id_dte, conn));
            resultado.setTotalIva(driver.ObtenerDouble("SELECT F.TOTALIVA FROM FEL_SV_TBL_RESUMEN F WHERE F.ID_DTE=" + id_dte, conn));
            resultado.setSubTotal(driver.ObtenerDouble("SELECT F.SUBTOTAL FROM FEL_SV_TBL_RESUMEN F WHERE F.ID_DTE=" + id_dte, conn));
            resultado.setIvaPerci1(driver.ObtenerDouble("SELECT F.IVAPERCI1 FROM FEL_SV_TBL_RESUMEN F WHERE F.ID_DTE=" + id_dte, conn));
            resultado.setIvaRete1(driver.ObtenerDouble("SELECT F.IVARETE1 FROM FEL_SV_TBL_RESUMEN F WHERE F.ID_DTE=" + id_dte, conn));
            resultado.setFovial(driver.ObtenerDouble("SELECT F.FOVIAL FROM FEL_SV_TBL_RESUMEN F WHERE F.ID_DTE=" + id_dte, conn));
            resultado.setCotrans(driver.ObtenerDouble("SELECT F.COTRANS FROM FEL_SV_TBL_RESUMEN F WHERE F.ID_DTE=" + id_dte, conn));
            resultado.setTurismo(driver.ObtenerDouble("SELECT F.TURISMO FROM FEL_SV_TBL_RESUMEN F WHERE F.ID_DTE=" + id_dte, conn));
            resultado.setAdValorem(driver.ObtenerDouble("SELECT F.ADVALOREM FROM FEL_SV_TBL_RESUMEN F WHERE F.ID_DTE=" + id_dte, conn));
            resultado.setMontoTotalOperacion(driver.ObtenerDouble("SELECT F.MONTOTOTALOPERACION FROM FEL_SV_TBL_RESUMEN F WHERE F.ID_DTE=" + id_dte, conn));
            resultado.setTotalNoGravado(driver.ObtenerDouble("SELECT F.TOTALNOGRAVADO FROM FEL_SV_TBL_RESUMEN F WHERE F.ID_DTE=" + id_dte, conn));
            resultado.setTotalPagar(driver.ObtenerDouble("SELECT F.TOTALPAGAR FROM FEL_SV_TBL_RESUMEN F WHERE F.ID_DTE=" + id_dte, conn));
            resultado.setTotalLetras(driver.ObtenerString("SELECT F.TOTALLETRAS FROM FEL_SV_TBL_RESUMEN F WHERE F.ID_DTE=" + id_dte, conn));
            resultado.setSaldoFavor(driver.ObtenerDouble("SELECT F.SALDOFAVOR FROM FEL_SV_TBL_RESUMEN F WHERE F.ID_DTE=" + id_dte, conn));
            resultado.setCondicionOperacion(driver.ObtenerEntero("SELECT G.CODIGO FROM FEL_SV_TBL_RESUMEN F LEFT JOIN FEL_SV_CONDICION_OPERACION G ON (F.ID_CONDICION_OPERACION=G.ID_CONDICION_OPERACION) WHERE F.ID_DTE=" + id_dte, conn));
            PAGOS_OUT pagos = new PAGOS_OUT();
            pagos.setCodigo(driver.ObtenerString("SELECT G.CODIGO FROM FEL_SV_TBL_RESUMEN F LEFT JOIN FEL_SV_TBL_FORMA_PAGO G ON (F.ID_FORMA_PAGO=G.ID_FORMA_PAGO) WHERE F.ID_DTE=" + id_dte, conn));
            pagos.setDescripcion(driver.ObtenerString("SELECT G.VALOR FROM FEL_SV_TBL_RESUMEN F LEFT JOIN FEL_SV_TBL_FORMA_PAGO G ON (F.ID_FORMA_PAGO=G.ID_FORMA_PAGO) WHERE F.ID_DTE=" + id_dte, conn));
            pagos.setReferencia(null);
            pagos.setPlazo(driver.ObtenerString("SELECT G.CODIGO FROM FEL_SV_TBL_RESUMEN F LEFT JOIN FEL_SV_TBL_PLAZO G ON (F.ID_PLAZO=G.ID_PLAZO) WHERE F.ID_DTE=" + id_dte, conn));
            pagos.setPeriodo(driver.ObtenerEntero("SELECT F.PAGOS_PERIODO FROM FEL_SV_TBL_RESUMEN F WHERE F.ID_DTE=" + id_dte, conn));
            resultado.setPagos(null);
            resultado.setNumPagoElectronico(driver.ObtenerString("SELECT DECODE(F.NUMPAGOELECTRONICO,'-',NULL,F.NUMPAGOELECTRONICO) FROM FEL_SV_TBL_RESUMEN F WHERE F.ID_DTE=" + id_dte, conn));
        } catch (Exception ex) {
            System.out.println("Proyecto: api-grupoterra-test-felsv | Clase: " + this.getClass().getName() + " | Metodo: registro_json_resumen | Error: " + ex.toString());
        }

        return resultado;
    }

}
