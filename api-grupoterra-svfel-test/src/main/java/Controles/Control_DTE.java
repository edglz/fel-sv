package Controles;

import Entidades.JsonIn.DTE_IN;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Control_DTE implements Serializable {

    private static final long serialVersionUID = 1L;

    public Control_DTE() {
    }

    public String valida_campos_raiz_dte(Connection conn, DTE_IN dte_in) {
        String resultado = "";
        Driver driver = new Driver();
        Boolean validado = true;
        String mensaje_error = "";

        try {
            // VALIDA CAMPO: KCOO_JDE.
            if (validado) {
                if (dte_in.getKcoo_jde() == null) {
                    validado = false;
                    mensaje_error = "El campo kcoo_jde no puede ser nulo o vacio.";
                } else {
                    if (dte_in.getKcoo_jde().trim().equals("")) {
                        validado = false;
                        mensaje_error = "El campo kcoo_jde no puede ser nulo o vacio.";
                    } else {
                        Long id_emisor = driver.ObtenerLong("SELECT F.ID_EMISOR FROM FEL_SV_TBL_EMISOR_KCOO F WHERE TRIM(F.KCOO_JDE)='" + dte_in.getKcoo_jde() + "'", conn);
                        if (id_emisor == null) {
                            validado = false;
                            mensaje_error = "El campo kcoo_jde no se encuenta en el catálogo de compañías FEL-SV.";
                        } else {
                            validado = true;
                        }
                    }
                }
            }

            // VALIDA CAMPO: MCU_JDE.
            if (validado) {
                if (dte_in.getMcu_jde() == null) {
                    validado = false;
                    mensaje_error = "El campo mcu_jde no puede ser nulo o vacio.";
                } else {
                    if (dte_in.getMcu_jde().trim().equals("")) {
                        validado = false;
                        mensaje_error = "El campo mcu_jde no puede ser nulo o vacio.";
                    } else {
                        Long id_establecimiento = driver.ObtenerLong("SELECT A.ID_EMISOR_ESTABLECIMIENTO FROM FEL_EMISOR_ESTABLECIMIENTO A LEFT JOIN FEL_SV_TBL_EMISOR_KCOO B ON (A.ID_EMISOR = B.ID_EMISOR) WHERE B.KCOO_JDE='" + dte_in.getKcoo_jde() + "'", conn);
                        if (id_establecimiento == null) {
                            validado = false;
                            mensaje_error = "El campo mcu_jde no se encuenta en el catálogo de establecimientos FEL-SV de la compañia KCOO: " + dte_in.getKcoo_jde();
                        } else {
                            validado = true;
                        }
                    }
                }
            }

            // VALIDA CAMPO: DOCO_JDE.
            if (validado) {
                if (dte_in.getDoco_jde() == null) {
                    validado = false;
                    mensaje_error = "El campo doco_jde no puede ser nulo o vacio.";
                } else {
                    if (dte_in.getDoco_jde().trim().equals("")) {
                        validado = false;
                        mensaje_error = "El campo doco_jde no puede ser nulo o vacio.";
                    } else {
                        validado = true;
                    }
                }
            }

            // VALIDA CAMPO: DCTO_JDE.
            if (validado) {
                if (dte_in.getDcto_jde() == null) {
                    validado = false;
                    mensaje_error = "El campo dcto_jde no puede ser nulo o vacio.";
                } else {
                    if (dte_in.getDcto_jde().trim().equals("")) {
                        validado = false;
                        mensaje_error = "El campo dcto_jde no puede ser nulo o vacio.";
                    } else {
                        validado = true;
                    }
                }
            }

            // VALIDA CAMPO: DOC_JDE.
            if (validado) {
                if (dte_in.getDoc_jde() == null) {
                    validado = false;
                    mensaje_error = "El campo doc_jde no puede ser nulo o vacio.";
                } else {
                    if (dte_in.getDoc_jde().trim().equals("")) {
                        validado = false;
                        mensaje_error = "El campo doc_jde no puede ser nulo o vacio.";
                    } else {
                        validado = true;
                    }
                }
            }

            // VALIDA CAMPO: DCT_JDE.
            if (validado) {
                if (dte_in.getDct_jde() == null) {
                    validado = false;
                    mensaje_error = "El campo dct_jde no puede ser nulo o vacio.";
                } else {
                    if (dte_in.getDct_jde().trim().equals("")) {
                        validado = false;
                        mensaje_error = "El campo dct_jde no puede ser nulo o vacio.";
                    } else {
                        validado = true;
                    }
                }
            }

            // VALIDA CAMPO: AN8_JDE.
            if (validado) {
                if (dte_in.getAn8_jde() == null) {
                    validado = false;
                    mensaje_error = "El campo an8_jde no puede ser nulo o vacio.";
                } else {
                    if (dte_in.getAn8_jde().trim().equals("")) {
                        validado = false;
                        mensaje_error = "El campo an8_jde no puede ser nulo o vacio.";
                    } else {
                        validado = true;
                    }
                }
            }

            // VALIDA CAMPO: SHAN_JDE.
            if (validado) {
                if (dte_in.getShan_jde() == null) {
                    validado = false;
                    mensaje_error = "El campo shan_jde no puede ser nulo o vacio.";
                } else {
                    if (dte_in.getShan_jde().trim().equals("")) {
                        validado = false;
                        mensaje_error = "El campo shan_jde no puede ser nulo o vacio.";
                    } else {
                        validado = true;
                    }
                }
            }

            // VALIDA CAMPO: CRCD_JDE.
            if (validado) {
                if (dte_in.getCrcd_jde() == null) {
                    validado = false;
                    mensaje_error = "El campo crcd_jde no puede ser nulo o vacio.";
                } else {
                    if (dte_in.getCrcd_jde().trim().equals("")) {
                        validado = false;
                        mensaje_error = "El campo crcd_jde no puede ser nulo o vacio.";
                    } else {
                        validado = true;
                    }
                }
            }

            // VALIDA CAMPO: IVD_JDE.
            if (validado) {
                if (dte_in.getIvd_jde() == null) {
                    validado = false;
                    mensaje_error = "El campo ivd_jde no puede ser nulo o vacio.";
                } else {
                    if (dte_in.getIvd_jde().trim().equals("")) {
                        validado = false;
                        mensaje_error = "El campo ivd_jde no puede ser nulo o vacio.";
                    } else {
                        validado = true;
                    }
                }
            }
            
            // VALIDAR DOCUMENTO REPETIDO
            if (validado) {
                Long id_dte = driver.ObtenerLong("SELECT F.ID_DTE FROM FEL_SV_TBL_DTE F WHERE "
                        + "KCOO_JDE='" + dte_in.getKcoo_jde().trim() + "' AND "
                        + "MCU_JDE='" + dte_in.getMcu_jde().trim() + "' AND "
                        + "DOCO_JDE='" + dte_in.getDoco_jde().trim() + "' AND "
                        + "DCTO_JDE='" + dte_in.getDcto_jde().trim() + "' AND "
                        + "DOC_JDE='" + dte_in.getDoc_jde().trim() + "' AND "
                        + "DCT_JDE='" + dte_in.getDct_jde().trim() + "'", conn);
                if (id_dte != null) {
                    validado = false;
                    mensaje_error = "DTE duplicado "
                            + "KCOO=" + dte_in.getKcoo_jde().trim() + "; "
                            + "MCU=" + dte_in.getMcu_jde().trim() + "; "
                            + "DOCO=" + dte_in.getDoco_jde().trim() + "; "
                            + "DCTO=" + dte_in.getDcto_jde().trim() + "; "
                            + "DOC=" + dte_in.getDoc_jde().trim() + "; "
                            + "DCT=" + dte_in.getDct_jde().trim();
                } else {
                    validado = true;
                }
            }
            
            // VALIDAR MODO DE TRANSFERENCIA.
            if (validado) {
                String fecha_juliana_actual = driver.ObtenerString("SELECT TO_NUMBER(SUBSTR(TO_CHAR(CURRENT_DATE,'ccYYddd'),2,6)) FECHA_JDE FROM DUAL", conn);
                if (!fecha_juliana_actual.equals(dte_in.getIvd_jde())) {
                    validado = false;
                    Date fecha_actual = new Date();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    mensaje_error = "DTE debe ser enviado en modo contingencia; IVD=" + dte_in.getIvd_jde() + "; FECHA=" + dateFormat.format(fecha_actual);
                } else {
                    validado = true;
                }
            }

            if (validado) {
                resultado = "0,SECCION VALIDADA.";
            } else {
                resultado = "1," + mensaje_error;
            }
        } catch (Exception ex) {
            resultado = "1," + ex.toString();
            System.out.println("Proyecto: api-grupoterra-test-felsv | Clase: " + this.getClass().getName() + " | Metodo: valida_campos_raiz_dte | Error: " + ex.toString());
        }

        return resultado;
    }

    public Long registro_db_tabla_dte(Connection conn, DTE_IN dte_in) {
        Long resultado = Long.parseLong("0");
        Driver driver = new Driver();

        try {
            Long id_dte = driver.ObtenerLong("SELECT NVL(MAX(F.ID_DTE), 0) + 1 MAXIMO FROM FEL_SV_TBL_DTE F", conn);
            Long id_emisor = driver.ObtenerLong("SELECT F.ID_EMISOR FROM FEL_SV_TBL_EMISOR_KCOO F WHERE TRIM(F.KCOO_JDE) = '" + dte_in.getKcoo_jde() + "'", conn);

            String cadenasql = "INSERT INTO FEL_SV_TBL_DTE ("
                    + "ID_DTE, "
                    + "KCOO_JDE, "
                    + "MCU_JDE, "
                    + "DOCO_JDE, "
                    + "DCTO_JDE, "
                    + "DOC_JDE, "
                    + "DCT_JDE, "
                    + "AN8_JDE, "
                    + "SHAN_JDE, "
                    + "CRCD_JDE, "
                    + "IVD_JDE, "
                    + "ID_EMISOR, "
                    + "RESPONSE_VERSION, "
                    + "RESPONSE_AMBIENTE, "
                    + "RESPONSE_VERSIONAPP, "
                    + "RESPONSE_ESTADO, "
                    + "RESPONSE_CODIGOGENERACION, "
                    + "RESPONSE_NUMVALIDACION, "
                    + "RESPONSE_FHPROCESAMIENTO, "
                    + "RESPONSE_CODIGOMSG, "
                    + "RESPONSE_DESCRIPCIONMSG, "
                    + "RESPONSE_OBSERVACIONES) VALUES ("
                    + id_dte + ",'"
                    + dte_in.getKcoo_jde() + "','"
                    + dte_in.getMcu_jde() + "','"
                    + dte_in.getDoco_jde() + "','"
                    + dte_in.getDcto_jde() + "','"
                    + dte_in.getDoc_jde() + "','"
                    + dte_in.getDct_jde() + "','"
                    + dte_in.getAn8_jde() + "','"
                    + dte_in.getShan_jde() + "','"
                    + dte_in.getCrcd_jde() + "','"
                    + dte_in.getIvd_jde() + "',"
                    + id_emisor + ","
                    + "0" + ",'"
                    + "-" + "',"
                    + "0" + ",'"
                    + "-" + "','"
                    + "-" + "','"
                    + "-" + "','"
                    + "-" + "','"
                    + "-" + "','"
                    + "-" + "','"
                    + "-" + "')";
            Statement stmt = conn.createStatement();
            // System.out.println("******************** FEL_SV_TBL_DTE: " + cadenasql);
            stmt.executeUpdate(cadenasql);
            stmt.close();

            resultado = id_dte;
        } catch (Exception ex) {
            System.out.println("Proyecto: api-grupoterra-test-felsv | Clase: " + this.getClass().getName() + " | Metodo: registro_db_tabla_dte | Error: " + ex.toString());
        }

        return resultado;
    }

}
