package com.istloja.vistas;

import com.istloja.modelo.Proveedores;
import com.istloja.utilidad.Utilidades;
import com.toedter.calendar.JDateChooser;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author danielmora
 */
public class GestionContableProvedores {

    private JTextField txtRucProveedores;
    private JTextField txtRazonSocialProveedores;
    private JTextField txtTipoActividadProveedores;
    private JTextField txtNombreRepresentateLegalProveedores;
    private JTextField txtApellidosRepresentateLegalProveedores;
    private JTextField txtTelefonoProveedores;
    private JTextField txtCorrreoProveedores;
    private JTextField txtDireccionProveedores;
    private JDateChooser jDateFechaVencimientoDeuda;
    private Utilidades utilidades;
    private JFrame frameGestionContable;

    public GestionContableProvedores(JTextField txtxRuc, JTextField txtxRazonSiocial, JTextField txtTipo_actividad, JTextField txtNombre_Representante_Legal, JTextField txtApellido_Representante_legal, JTextField txtTelefono_Provedores, JTextField txtCorreo_provedores, JTextField txtDireccionProvedores, JDateChooser jDateFechaVencimientoDeuda, Utilidades utilidades, JFrame frameGestionContable) {
        this.txtRucProveedores = txtRucProveedores;
        this.txtRazonSocialProveedores = txtRazonSocialProveedores;
        this.txtTipoActividadProveedores = txtTipoActividadProveedores;
        this.txtNombreRepresentateLegalProveedores= txtNombreRepresentateLegalProveedores;
        this.txtApellidosRepresentateLegalProveedores = txtApellidosRepresentateLegalProveedores;
        this.txtTelefonoProveedores = txtTelefonoProveedores;
        this.txtCorrreoProveedores = txtCorrreoProveedores;
        this. txtDireccionProveedores=  txtDireccionProveedores;
        this.jDateFechaVencimientoDeuda = jDateFechaVencimientoDeuda;
        this.utilidades = utilidades;
        this.frameGestionContable = frameGestionContable;
    }

    public JTextField getTxtRucProveedores() {
        return txtRucProveedores;
    }

    public void setTxtRucProveedores(JTextField txtRucProveedores) {
        this.txtRucProveedores = txtRucProveedores;
    }

    public JTextField getTxtRazonSocialProveedores() {
        return txtRazonSocialProveedores;
    }

    public void setTxtRazonSocialProveedores(JTextField txtRazonSocialProveedores) {
        this.txtRazonSocialProveedores = txtRazonSocialProveedores;
    }

    public JTextField getTxtTipoActividadProveedores() {
        return txtTipoActividadProveedores;
    }

    public void setTxtTipoActividadProveedores(JTextField txtTipoActividadProveedores) {
        this.txtTipoActividadProveedores = txtTipoActividadProveedores;
    }

    public JTextField getTxtNombreRepresentateLegalProveedores() {
        return txtNombreRepresentateLegalProveedores;
    }

    public void setTxtNombreRepresentateLegalProveedores(JTextField txtNombreRepresentateLegalProveedores) {
        this.txtNombreRepresentateLegalProveedores = txtNombreRepresentateLegalProveedores;
    }

    public JTextField getTxtApellidosRepresentateLegalProveedores() {
        return txtApellidosRepresentateLegalProveedores;
    }

    public void setTxtApellidosRepresentateLegalProveedores(JTextField txtApellidosRepresentateLegalProveedores) {
        this.txtApellidosRepresentateLegalProveedores = txtApellidosRepresentateLegalProveedores;
    }

    public JTextField getTxtTelefonoProveedores() {
        return txtTelefonoProveedores;
    }

    public void setTxtTelefonoProveedores(JTextField txtTelefonoProveedores) {
        this.txtTelefonoProveedores = txtTelefonoProveedores;
    }

    public JTextField getTxtCorrreoProveedores() {
        return txtCorrreoProveedores;
    }

    public void setTxtCorrreoProveedores(JTextField txtCorrreoProveedores) {
        this.txtCorrreoProveedores = txtCorrreoProveedores;
    }

    public JTextField getTxtDireccionProveedores() {
        return txtDireccionProveedores;
    }

    public void setTxtDireccionProveedores(JTextField txtDireccionProveedores) {
        this.txtDireccionProveedores = txtDireccionProveedores;
    }

    public JDateChooser getjDateFechaVencimientoDeuda() {
        return jDateFechaVencimientoDeuda;
    }

    public void setjDateFechaVencimientoDeuda(JDateChooser jDateFechaVencimientoDeuda) {
        this.jDateFechaVencimientoDeuda = jDateFechaVencimientoDeuda;
    }

    public Utilidades getUtilidades() {
        return utilidades;
    }

    public void setUtilidades(Utilidades utilidades) {
        this.utilidades = utilidades;
    }

    public JFrame getFrameGestionContable() {
        return frameGestionContable;
    }

    public void setFrameGestionContable(JFrame frameGestionContable) {
        this.frameGestionContable = frameGestionContable;
    }

   

    public void limpiar_Caja_Provedores() {
        txtRucProveedores.setText("");
        txtRazonSocialProveedores.setText("");
        txtTipoActividadProveedores.setText("");
        txtNombreRepresentateLegalProveedores.setText("");
        txtApellidosRepresentateLegalProveedores.setText("");
        txtTelefonoProveedores.setText("");
        txtCorrreoProveedores.setText("");
        txtDireccionProveedores.setText("");
        jDateFechaVencimientoDeuda.setCalendar(null);
    }

    public Proveedores guardarEditarProvedores(boolean isEditar) {
        if (txtRucProveedores.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo ruc no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtRucProveedores.requestFocus();
            return null;
        }
        if (txtRazonSocialProveedores.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo razón social no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtRazonSocialProveedores.requestFocus();
            return null;
        }
        if (txtTipoActividadProveedores.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo tipo de actividad no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtTipoActividadProveedores.requestFocus();
            return null;
        }
        if (txtNombreRepresentateLegalProveedores.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo Nombre de Representante Legal no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtNombreRepresentateLegalProveedores.requestFocus();
            return null;
        }
        if (txtApellidosRepresentateLegalProveedores.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo Apellido de Representante Legal no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtApellidosRepresentateLegalProveedores.requestFocus();
            return null;

        }
        if (txtTelefonoProveedores.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameGestionContable, "El campo teléfono no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtTelefonoProveedores.requestFocus();
            return null;
        }
        if (!utilidades.validarNumeros(txtTelefonoProveedores.getText())) {
            JOptionPane.showMessageDialog(frameGestionContable, "Los datos ingresados en el teléfono no son validos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtTelefonoProveedores.requestFocus();
            return null;
        }
        if (txtDireccionProveedores.getText().isEmpty()) {
             JOptionPane.showMessageDialog(frameGestionContable, "El campo dirección no tiene datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
             txtDireccionProveedores.requestFocus();
             return null;
        }
        
        Proveedores provedores = new Proveedores();
        provedores.setRuc(txtRucProveedores.getText());
        provedores.setRazonSocial(txtRazonSocialProveedores.getText());
        provedores.setTipoActividad(txtTipoActividadProveedores.getText());
        provedores.setNombre_representante_legal(txtNombreRepresentateLegalProveedores.getText());
        provedores.setApellidos_representante_legal(txtApellidosRepresentateLegalProveedores.getText());
        provedores.setTelefono(txtTelefonoProveedores.getText());
        provedores.setCorreo(txtCorrreoProveedores.getText());
        provedores.setDireccion(txtDireccionProveedores.getText());
        if (isEditar) {
            provedores.setFechaActualizacion(new Date());
        }else{
            provedores.setFecha_registro(new Date());
        }
        provedores.setFechaVencimientoDeuda(new Date());
        return provedores;
    }
}
