package Controles;

import Entidades.JsonOut.ACTIVIDAD_ECONOMICA_OUT;
import Entidades.JsonOut.DIRECCION_OUT;
import Entidades.JsonOut.EMISOR_OUT;
import Entidades.JsonOut.EMISOR_OUT_NC;
import Entidades.JsonOut.SUCURSAL_OUT;
import java.io.Serializable;
import java.sql.Connection;

public class Control_EMISOR implements Serializable {

    private static final long serialVersionUID = 1L;

    public Control_EMISOR() {
    }

    public EMISOR_OUT registro_json_emisor(Connection conn, Long id_dte, String mcu_jde) {
        EMISOR_OUT resultado = null;
        Driver driver = new Driver();

        try {
            resultado = new EMISOR_OUT();
            Long id_emisor = driver.ObtenerLong("SELECT F.ID_EMISOR FROM FEL_SV_TBL_DTE F WHERE F.ID_DTE=" + id_dte, conn);
            resultado.setNit(driver.ObtenerString("SELECT F.NIT FROM FEL_SV_TBL_EMISOR F WHERE F.ID_EMISOR=" + id_emisor, conn));
            resultado.setNrc(driver.ObtenerString("SELECT F.NRC FROM FEL_SV_TBL_EMISOR F WHERE F.ID_EMISOR=" + id_emisor, conn));
            resultado.setNumFacturador(driver.ObtenerString("SELECT F.NUMFACTURADOR FROM FEL_SV_TBL_EMISOR F WHERE F.ID_EMISOR=" + id_emisor, conn));
            resultado.setNombre(driver.ObtenerString("SELECT F.NOMBRE FROM FEL_SV_TBL_EMISOR F WHERE F.ID_EMISOR=" + id_emisor, conn));
            ACTIVIDAD_ECONOMICA_OUT actividad1 = new ACTIVIDAD_ECONOMICA_OUT();
            actividad1.setCodActividad(driver.ObtenerString("SELECT G.CODIGO FROM FEL_SV_TBL_EMISOR F LEFT JOIN FEL_SV_ACTIVIDAD_ECONOMICA G ON (F.ID_ACTIVIDAD_ECONOMICA_1=G.ID_ACTIVIDAD_ECONOMICA) WHERE F.ID_EMISOR=" + id_emisor, conn));
            actividad1.setDescActividad(driver.ObtenerString("SELECT G.VALOR FROM FEL_SV_TBL_EMISOR F LEFT JOIN FEL_SV_ACTIVIDAD_ECONOMICA G ON (F.ID_ACTIVIDAD_ECONOMICA_1=G.ID_ACTIVIDAD_ECONOMICA) WHERE F.ID_EMISOR=" + id_emisor, conn));
            resultado.setActividad1(actividad1);
            ACTIVIDAD_ECONOMICA_OUT actividad2 = null;
            resultado.setActividad2(actividad2);
            resultado.setNombreComercial(driver.ObtenerString("SELECT F.NOMBRECOMERCIAL FROM FEL_SV_TBL_EMISOR F WHERE F.ID_EMISOR=" + id_emisor, conn));
            DIRECCION_OUT direccion = new DIRECCION_OUT();
            direccion.setDepartamento(driver.ObtenerString("SELECT G.CODIGO FROM FEL_SV_TBL_EMISOR F LEFT JOIN FEL_SV_TBL_DEPARTAMENTO G ON (F.ID_DEPARTAMENTO=G.ID_DEPARTAMENTO) WHERE F.ID_EMISOR=" + id_emisor, conn));
            direccion.setMunicipio(driver.ObtenerString("SELECT G.CODIGO FROM FEL_SV_TBL_EMISOR F LEFT JOIN FEL_SV_TBL_MUNICIPIO G ON (F.ID_MUNICIPIO=G.ID_MUNICIPIO) WHERE F.ID_EMISOR=" + id_emisor, conn));
            direccion.setComplemento(driver.ObtenerString("SELECT F.DIRECCION_COMPLEMENTO FROM FEL_SV_TBL_EMISOR F WHERE F.ID_EMISOR=" + id_emisor, conn));
            resultado.setDireccion(direccion);
            resultado.setTelefono(driver.ObtenerString("SELECT F.TELEFONO FROM FEL_SV_TBL_EMISOR F WHERE F.ID_EMISOR=" + id_emisor, conn));
            resultado.setCorreo(driver.ObtenerString("SELECT F.CORREO FROM FEL_SV_TBL_EMISOR F WHERE F.ID_EMISOR=" + id_emisor, conn));
            resultado.setCategoria(driver.ObtenerEntero("SELECT G.CODIGO FROM FEL_SV_TBL_EMISOR F LEFT JOIN FEL_CATEGORIA_CONTRIBUYENTE G ON (F.ID_CATEGORIA_CONTRIBUYENTE=G.ID_CATEGORIA_CONTRIBUYENTE) WHERE F.ID_EMISOR=" + id_emisor, conn));
            resultado.setTipoEstablecimiento(driver.ObtenerEntero("SELECT G.CODIGO FROM FEL_EMISOR_ESTABLECIMIENTO F LEFT JOIN FEL_TIPO_ESTABLECIMIENTO G ON (F.ID_TIPO_ESTABLECIMIENTO=G.ID_TIPO_ESTABLECIMIENTO) WHERE F.ID_EMISOR=" + id_emisor, conn));
            SUCURSAL_OUT sucursal = null;
            if (resultado.getTipoEstablecimiento() != 1) {
                sucursal = new SUCURSAL_OUT();
                sucursal.setCodigo(driver.ObtenerString("SELECT F.CODIGO FROM FEL_EMISOR_ESTABLECIMIENTO F WHERE F.ID_EMISOR=" + id_emisor + " AND TRIM(F.MCU_JDE) LIKE '%" + mcu_jde + "%'", conn));
                sucursal.setPuntoVenta(driver.ObtenerString("SELECT F.PUNTOVENTA FROM FEL_EMISOR_ESTABLECIMIENTO F WHERE F.ID_EMISOR=" + id_emisor + " AND TRIM(F.MCU_JDE) LIKE '%" + mcu_jde + "%'", conn));
                sucursal.setNombre(driver.ObtenerString("SELECT F.NOMBRE FROM FEL_EMISOR_ESTABLECIMIENTO F WHERE F.ID_EMISOR=" + id_emisor + " AND TRIM(F.MCU_JDE) LIKE '%" + mcu_jde + "%'", conn));
                DIRECCION_OUT sucursal_direccion = new DIRECCION_OUT();
                sucursal_direccion.setDepartamento(driver.ObtenerString("SELECT G.CODIGO FROM FEL_EMISOR_ESTABLECIMIENTO F LEFT JOIN FEL_SV_TBL_DEPARTAMENTO G ON (F.ID_DEPARTAMENTO=G.ID_DEPARTAMENTO) WHERE F.ID_EMISOR=" + id_emisor + " AND TRIM(F.MCU_JDE) LIKE '%" + mcu_jde + "%'", conn));
                sucursal_direccion.setMunicipio(driver.ObtenerString("SELECT G.CODIGO FROM FEL_EMISOR_ESTABLECIMIENTO F LEFT JOIN FEL_SV_TBL_MUNICIPIO G ON (F.ID_MUNICIPIO=G.ID_MUNICIPIO) WHERE F.ID_EMISOR=" + id_emisor + " AND TRIM(F.MCU_JDE) LIKE '%" + mcu_jde + "%'", conn));
                sucursal_direccion.setComplemento(driver.ObtenerString("SELECT F.DIRECCION_COMPLEMENTO FROM FEL_EMISOR_ESTABLECIMIENTO F WHERE F.ID_EMISOR=" + id_emisor + " AND TRIM(F.MCU_JDE) LIKE '%" + mcu_jde + "%'", conn));
                sucursal.setDireccion(sucursal_direccion);
                sucursal.setTelefono(driver.ObtenerString("SELECT F.TELEFONO FROM FEL_EMISOR_ESTABLECIMIENTO F WHERE F.ID_EMISOR=" + id_emisor + " AND TRIM(F.MCU_JDE) LIKE '%" + mcu_jde + "%'", conn));
            }
            resultado.setSucursal(sucursal);
            resultado.setFecSujExcl(null);
            resultado.setMedico(null);
            resultado.setCartaVenta(null);
        } catch (Exception ex) {
            System.out.println("Proyecto: api-grupoterra-test-felsv | Clase: " + this.getClass().getName() + " | Metodo: registro_json_emisor | Error: " + ex.toString());
        }

        return resultado;
    }
    
    public EMISOR_OUT_NC registro_json_emisor_nc(Connection conn, Long id_dte, String mcu_jde) {
        EMISOR_OUT_NC resultado = null;
        Driver driver = new Driver();

        try {
            resultado = new EMISOR_OUT_NC();
            Long id_emisor = driver.ObtenerLong("SELECT F.ID_EMISOR FROM FEL_SV_TBL_DTE F WHERE F.ID_DTE=" + id_dte, conn);
            resultado.setNit(driver.ObtenerString("SELECT F.NIT FROM FEL_SV_TBL_EMISOR F WHERE F.ID_EMISOR=" + id_emisor, conn));
            resultado.setNrc(driver.ObtenerString("SELECT F.NRC FROM FEL_SV_TBL_EMISOR F WHERE F.ID_EMISOR=" + id_emisor, conn));
            resultado.setNumFacturador(driver.ObtenerString("SELECT F.NUMFACTURADOR FROM FEL_SV_TBL_EMISOR F WHERE F.ID_EMISOR=" + id_emisor, conn));
            resultado.setNombre(driver.ObtenerString("SELECT F.NOMBRE FROM FEL_SV_TBL_EMISOR F WHERE F.ID_EMISOR=" + id_emisor, conn));
            ACTIVIDAD_ECONOMICA_OUT actividad1 = new ACTIVIDAD_ECONOMICA_OUT();
            actividad1.setCodActividad(driver.ObtenerString("SELECT G.CODIGO FROM FEL_SV_TBL_EMISOR F LEFT JOIN FEL_SV_ACTIVIDAD_ECONOMICA G ON (F.ID_ACTIVIDAD_ECONOMICA_1=G.ID_ACTIVIDAD_ECONOMICA) WHERE F.ID_EMISOR=" + id_emisor, conn));
            actividad1.setDescActividad(driver.ObtenerString("SELECT G.VALOR FROM FEL_SV_TBL_EMISOR F LEFT JOIN FEL_SV_ACTIVIDAD_ECONOMICA G ON (F.ID_ACTIVIDAD_ECONOMICA_1=G.ID_ACTIVIDAD_ECONOMICA) WHERE F.ID_EMISOR=" + id_emisor, conn));
            resultado.setActividad1(actividad1);
            ACTIVIDAD_ECONOMICA_OUT actividad2 = null;
            resultado.setActividad2(actividad2);
            resultado.setNombreComercial(driver.ObtenerString("SELECT F.NOMBRECOMERCIAL FROM FEL_SV_TBL_EMISOR F WHERE F.ID_EMISOR=" + id_emisor, conn));
            DIRECCION_OUT direccion = new DIRECCION_OUT();
            direccion.setDepartamento(driver.ObtenerString("SELECT G.CODIGO FROM FEL_SV_TBL_EMISOR F LEFT JOIN FEL_SV_TBL_DEPARTAMENTO G ON (F.ID_DEPARTAMENTO=G.ID_DEPARTAMENTO) WHERE F.ID_EMISOR=" + id_emisor, conn));
            direccion.setMunicipio(driver.ObtenerString("SELECT G.CODIGO FROM FEL_SV_TBL_EMISOR F LEFT JOIN FEL_SV_TBL_MUNICIPIO G ON (F.ID_MUNICIPIO=G.ID_MUNICIPIO) WHERE F.ID_EMISOR=" + id_emisor, conn));
            direccion.setComplemento(driver.ObtenerString("SELECT F.DIRECCION_COMPLEMENTO FROM FEL_SV_TBL_EMISOR F WHERE F.ID_EMISOR=" + id_emisor, conn));
            resultado.setDireccion(direccion);
            resultado.setTelefono(driver.ObtenerString("SELECT F.TELEFONO FROM FEL_SV_TBL_EMISOR F WHERE F.ID_EMISOR=" + id_emisor, conn));
            resultado.setCorreo(driver.ObtenerString("SELECT F.CORREO FROM FEL_SV_TBL_EMISOR F WHERE F.ID_EMISOR=" + id_emisor, conn));
            resultado.setCategoria(driver.ObtenerEntero("SELECT G.CODIGO FROM FEL_SV_TBL_EMISOR F LEFT JOIN FEL_CATEGORIA_CONTRIBUYENTE G ON (F.ID_CATEGORIA_CONTRIBUYENTE=G.ID_CATEGORIA_CONTRIBUYENTE) WHERE F.ID_EMISOR=" + id_emisor, conn));
            resultado.setTipoEstablecimiento(driver.ObtenerEntero("SELECT G.CODIGO FROM FEL_EMISOR_ESTABLECIMIENTO F LEFT JOIN FEL_TIPO_ESTABLECIMIENTO G ON (F.ID_TIPO_ESTABLECIMIENTO=G.ID_TIPO_ESTABLECIMIENTO) WHERE F.ID_EMISOR=" + id_emisor, conn));
            SUCURSAL_OUT sucursal = null;
            if (resultado.getTipoEstablecimiento() != 1) {
                sucursal = new SUCURSAL_OUT();
                sucursal.setCodigo(driver.ObtenerString("SELECT F.CODIGO FROM FEL_EMISOR_ESTABLECIMIENTO F WHERE F.ID_EMISOR=" + id_emisor + " AND TRIM(F.MCU_JDE) LIKE '%" + mcu_jde + "%'", conn));
                sucursal.setPuntoVenta(driver.ObtenerString("SELECT F.PUNTOVENTA FROM FEL_EMISOR_ESTABLECIMIENTO F WHERE F.ID_EMISOR=" + id_emisor + " AND TRIM(F.MCU_JDE) LIKE '%" + mcu_jde + "%'", conn));
                sucursal.setNombre(driver.ObtenerString("SELECT F.NOMBRE FROM FEL_EMISOR_ESTABLECIMIENTO F WHERE F.ID_EMISOR=" + id_emisor + " AND TRIM(F.MCU_JDE) LIKE '%" + mcu_jde + "%'", conn));
                DIRECCION_OUT sucursal_direccion = new DIRECCION_OUT();
                sucursal_direccion.setDepartamento(driver.ObtenerString("SELECT G.CODIGO FROM FEL_EMISOR_ESTABLECIMIENTO F LEFT JOIN FEL_SV_TBL_DEPARTAMENTO G ON (F.ID_DEPARTAMENTO=G.ID_DEPARTAMENTO) WHERE F.ID_EMISOR=" + id_emisor + " AND TRIM(F.MCU_JDE) LIKE '%" + mcu_jde + "%'", conn));
                sucursal_direccion.setMunicipio(driver.ObtenerString("SELECT G.CODIGO FROM FEL_EMISOR_ESTABLECIMIENTO F LEFT JOIN FEL_SV_TBL_MUNICIPIO G ON (F.ID_MUNICIPIO=G.ID_MUNICIPIO) WHERE F.ID_EMISOR=" + id_emisor + " AND TRIM(F.MCU_JDE) LIKE '%" + mcu_jde + "%'", conn));
                sucursal_direccion.setComplemento(driver.ObtenerString("SELECT F.DIRECCION_COMPLEMENTO FROM FEL_EMISOR_ESTABLECIMIENTO F WHERE F.ID_EMISOR=" + id_emisor + " AND TRIM(F.MCU_JDE) LIKE '%" + mcu_jde + "%'", conn));
                sucursal.setDireccion(sucursal_direccion);
                sucursal.setTelefono(driver.ObtenerString("SELECT F.TELEFONO FROM FEL_EMISOR_ESTABLECIMIENTO F WHERE F.ID_EMISOR=" + id_emisor + " AND TRIM(F.MCU_JDE) LIKE '%" + mcu_jde + "%'", conn));
            }
            resultado.setSucursal(sucursal);
            resultado.setFecSujExcl(null);
        } catch (Exception ex) {
            System.out.println("Proyecto: api-grupoterra-test-felsv | Clase: " + this.getClass().getName() + " | Metodo: registro_json_emisor | Error: " + ex.toString());
        }

        return resultado;
    }
    
}
