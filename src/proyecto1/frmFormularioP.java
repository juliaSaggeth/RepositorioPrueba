package proyecto1;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmFormularioP extends javax.swing.JFrame {

    Pedidos pd = new Pedidos();
    boolean encontrado = false;
    ResultSet rs = null;
    boolean newRecord = false;
    int cantidad = 0;
    int mayor = 0;

    DefaultComboBoxModel defaultClientes = new DefaultComboBoxModel();
    DefaultComboBoxModel defaultVendedores = new DefaultComboBoxModel();
    DefaultComboBoxModel nombresVendedores = new DefaultComboBoxModel();
    DefaultComboBoxModel nombresClientes = new DefaultComboBoxModel();
    DefaultTableModel modeloPedidos = new DefaultTableModel();
    ArrayList<String> encabezados = new ArrayList<>();

    ResultSet rstPedidos = null;
    ResultSet rstClientesCMB = null;
    ResultSet rstVendedoresCMB = null;
    Clientes clientescmb = new Clientes();
    vendedores vendedorescmb = new vendedores();

    public frmFormularioP() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        btnCancelar.setEnabled(false);
        txtId.setEnabled(false);
        Bloquear();

        rstVendedoresCMB = vendedorescmb.llenarVendedores();
        try {
            while (rstVendedoresCMB.next()) {
                defaultVendedores.addElement(rstVendedoresCMB.getInt(1));
                nombresVendedores.addElement(rstVendedoresCMB.getString(4));
            }
            cmbVendedores.setModel(nombresVendedores);
            lblVendedorSeleccionado.setText(String.valueOf(defaultVendedores.getElementAt(0)));
        } catch (SQLException ex) {
            Logger.getLogger(frmFormularioP.class.getName()).log(Level.SEVERE, null, ex);
        }

        rstClientesCMB = clientescmb.llenarClientes();
        try {
            while (rstClientesCMB.next()) {
                defaultClientes.addElement(rstClientesCMB.getInt(1));
                nombresClientes.addElement(rstClientesCMB.getString(4));
            }
            cmbClientes.setModel(nombresClientes);
            lblClienteSeleccionado.setText(String.valueOf(defaultClientes.getElementAt(0)));
        } catch (SQLException ex) {
            Logger.getLogger(frmFormularioP.class.getName()).log(Level.SEVERE, null, ex);
        }

        //VER LA TABLA CON LOS DATOS DESDE UN INICIO
        int cuantasColumnas;
        int columna;
        reinicio();
        Columnas();
        rstPedidos = null;
        rstPedidos = pd.llenarTabla();

        try {
            ResultSetMetaData rstClientesMD = rstPedidos.getMetaData();
            cuantasColumnas = rstClientesMD.getColumnCount();

            //llenar la tabla con encabezados
            for (columna = 0; columna < cuantasColumnas; columna++) {
                modeloPedidos.addColumn(encabezados.get(columna));
            }

            while (rstPedidos.next()) {
                Object[] fila = new Object[columna];
                for (int campo = 0; campo < cuantasColumnas; campo++) {
                    fila[campo] = rstPedidos.getObject(campo + 1);
                }
                modeloPedidos.addRow(fila);
            }

            //finaliza llenado de tabla
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        tblPedidos.setModel(modeloPedidos);
    }

    private void Bloquear() {
        btnNuevo.setEnabled(true);
        btnAgregar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnModificar.setEnabled(false);
        btnBuscar.setEnabled(true);
        btnEliminar.setEnabled(true);
        cmbVendedores.setEnabled(false);
        cmbClientes.setEnabled(false);
        ftxtFechaPedido.setEnabled(false);
        ftxtFechaSugerida.setEnabled(false);
    }

    private void Desbloquear() {
        btnNuevo.setEnabled(false);
        btnAgregar.setEnabled(true);
        //btnBuscar.setEnabled(false);
        cmbVendedores.setEnabled(true);
        cmbClientes.setEnabled(true);
        ftxtFechaPedido.setEnabled(true);
        ftxtFechaSugerida.setEnabled(true);
    }

    private void Bloquear2() {
        cmbVendedores.setEnabled(false);
        cmbClientes.setEnabled(false);
        ftxtFechaPedido.setEnabled(false);
        ftxtFechaSugerida.setEnabled(false);
        btnAgregar.setEnabled(false);
        btnModificar.setEnabled(true);

    }

    private void Desbloquear2() {
        cmbVendedores.setEnabled(true);
        cmbClientes.setEnabled(true);
        ftxtFechaPedido.setEnabled(true);
        ftxtFechaSugerida.setEnabled(true);
        btnAgregar.setEnabled(false);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);

    }

    private void Bloquear3() {
        btnNuevo.setEnabled(true);
        btnAgregar.setEnabled(false);
        btnBuscar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnEliminar.setEnabled(true);
    }

    private void Desbloquear3() {
        btnNuevo.setEnabled(false);
        btnGuardar.setEnabled(true);
    }

    public void Limpiar() {
        //txtId.setText("");
        cmbClientes.setSelectedIndex(0);
        cmbVendedores.setSelectedIndex(0);
        ftxtFechaPedido.setText("");
        ftxtFechaSugerida.setText("");

    }

    public void Columnas() {
        encabezados.clear();
        encabezados.add("Id");
        encabezados.add("Vendedor");
        encabezados.add("Cliente");
        encabezados.add("Fecha de Pedido");
        encabezados.add("Fecha Sugerida");
    }

    public void reinicio() {
        modeloPedidos.setColumnCount(0);
        modeloPedidos.setRowCount(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        cmbVendedores = new javax.swing.JComboBox<>();
        cmbClientes = new javax.swing.JComboBox<>();
        ftxtFechaPedido = new javax.swing.JFormattedTextField();
        ftxtFechaSugerida = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPedidos = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblVendedorSeleccionado = new javax.swing.JLabel();
        lblClienteSeleccionado = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Id:");

        jLabel2.setText("Vendedor:");

        jLabel3.setText("Cliente:");

        jLabel4.setText("Fecha de Pedido:");

        jLabel5.setText("Fecha de Entrega Sugerida:");

        cmbVendedores.setModel(defaultVendedores);
        cmbVendedores.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbVendedoresItemStateChanged(evt);
            }
        });

        cmbClientes.setModel(defaultClientes);
        cmbClientes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbClientesItemStateChanged(evt);
            }
        });

        try {
            ftxtFechaPedido.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-20##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            ftxtFechaSugerida.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-20##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        tblPedidos.setModel(modeloPedidos);
        tblPedidos.setEnabled(false);
        jScrollPane1.setViewportView(tblPedidos);

        btnNuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnAgregar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnGuardar.setText("Guardar Cambios");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEliminar.setText("Eliminar Pedido");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblVendedorSeleccionado.setText(" ");

        lblClienteSeleccionado.setText(" ");

        jLabel6.setText("dd-mm-aaaa");

        jLabel7.setText("dd-mm-aaaa");

        btnMenu.setText("Regresar al MENU");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbVendedores, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbClientes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(ftxtFechaPedido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                                            .addComponent(ftxtFechaSugerida, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblClienteSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblVendedorSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNuevo)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregar)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                        .addComponent(btnCancelar))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMenu)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnMenu)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cmbVendedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblVendedorSeleccionado))
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cmbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblClienteSeleccionado))
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ftxtFechaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6))
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ftxtFechaSugerida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7))
                            .addComponent(jLabel5)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnBuscar)
                    .addComponent(btnAgregar)
                    .addComponent(btnModificar)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar)
                    .addComponent(btnCancelar))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        rs = null;
        //ColoresTodos();
        //txtApellido1.setBackground(Color.yellow);
        //método en clase Clientes
        rs = pd.contarRegistros();
        try {
            while (rs.next()) {
                cantidad = rs.getInt(1);
                if (cantidad != 0) {
                    rs = null;
                    //método en clase Clientes
                    rs = pd.mayorRegistro();
                    while (rs.next()) {
                        mayor = rs.getInt(1) + 1;
                        //recuerde que debe completar 5 digitos
                        if (mayor < 10) {
                            txtId.setText("0000" + mayor);
                        } else if (mayor < 100) {
                            this.txtId.setText("000" + mayor);
                        } else if (mayor < 1000) {
                            txtId.setText("00" + mayor);
                        } else if (mayor < 10000) {
                            txtId.setText("0" + mayor);
                        } else {
                            txtId.setText("" + mayor);
                        }
                    }
                } else {
                    txtId.setText("0000" + 1);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "AVISO DEL SISTEMA", 0);
        }
        Desbloquear();
        Limpiar();
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnBuscar.setEnabled(false);
        btnCancelar.setEnabled(true);
        this.cmbVendedores.requestFocus();
        newRecord = true;

    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String codigo = JOptionPane.showInputDialog("Ingrese el dato a buscar: ");
        rs = pd.buscar(codigo);
        

        try {
            while (rs.next()) {
                txtId.setText(rs.getString(1));
                cmbVendedores.setActionCommand(rs.getString(2));
                cmbClientes.setActionCommand(rs.getString(3));
                ftxtFechaPedido.setText(rs.getString(4));
                ftxtFechaSugerida.setText(rs.getString(5));
                encontrado = true;
                btnBuscar.setEnabled(true);
                btnCancelar.setEnabled(true);
                Bloquear2();
                Bloquear3();
            }
            if (encontrado == false) {
                JOptionPane.showMessageDialog(null, "Registro no encontrado", null, JOptionPane.ERROR_MESSAGE);
                btnModificar.setEnabled(false);
                btnEliminar.setEnabled(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmFormularioC1.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        btnBuscar.setEnabled(false);
        btnCancelar.setEnabled(true);
        
        int cuantasColumnas;
        int columna;
        if (newRecord == true) {

            pd.insertar(txtId.getText(), Integer.parseInt(lblVendedorSeleccionado.getText()), Integer.parseInt(lblClienteSeleccionado.getText()), ftxtFechaPedido.getText(), ftxtFechaSugerida.getText());
            JOptionPane.showMessageDialog(null, "Guardado con éxito");
            reinicio();
            Columnas();
            rstPedidos = null;
            rstPedidos = pd.llenarTabla();

            try {
                ResultSetMetaData rstClientesMD = rstPedidos.getMetaData();
                cuantasColumnas = rstClientesMD.getColumnCount();

                //llenar la tabla con encabezados
                for (columna = 0; columna < cuantasColumnas; columna++) {
                    modeloPedidos.addColumn(encabezados.get(columna));
                }

                while (rstPedidos.next()) {
                    Object[] fila = new Object[columna];
                    for (int campo = 0; campo < cuantasColumnas; campo++) {
                        fila[campo] = rstPedidos.getObject(campo + 1);
                    }
                    modeloPedidos.addRow(fila);
                }

                //finaliza llenado de tabla
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }

            tblPedidos.setModel(modeloPedidos);
        }

        Bloquear();
        Limpiar();
        this.txtId.setText("");
        newRecord = false;


    }//GEN-LAST:event_btnAgregarActionPerformed

    private void cmbVendedoresItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbVendedoresItemStateChanged
        int posicion;
        posicion = cmbVendedores.getSelectedIndex();
        lblVendedorSeleccionado.setText(String.valueOf(defaultVendedores.getElementAt(posicion)));
    }//GEN-LAST:event_cmbVendedoresItemStateChanged

    private void cmbClientesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbClientesItemStateChanged
        int posicion;
        posicion = cmbClientes.getSelectedIndex();
        lblClienteSeleccionado.setText(String.valueOf(defaultClientes.getElementAt(posicion)));
    }//GEN-LAST:event_cmbClientesItemStateChanged

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        txtId.setEnabled(false);
        cmbVendedores.requestFocus();
        Desbloquear2();
        Desbloquear3();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        int cuantasColumnas;
        int columna;
        pd.modificar(txtId.getText(), Integer.parseInt(lblVendedorSeleccionado.getText()), Integer.parseInt(lblClienteSeleccionado.getText()), ftxtFechaPedido.getText(), ftxtFechaSugerida.getText());
        JOptionPane.showMessageDialog(null, "Guardado con éxito");
        reinicio();
        Columnas();
        rstPedidos = null;
        rstPedidos = pd.llenarTabla();

        try {
            ResultSetMetaData rstClientesMD = rstPedidos.getMetaData();
            cuantasColumnas = rstClientesMD.getColumnCount();

            //llenar la tabla con encabezados
            for (columna = 0; columna < cuantasColumnas; columna++) {
                modeloPedidos.addColumn(encabezados.get(columna));
            }

            while (rstPedidos.next()) {
                Object[] fila = new Object[columna];
                for (int campo = 0; campo < cuantasColumnas; campo++) {
                    fila[campo] = rstPedidos.getObject(campo + 1);
                }
                modeloPedidos.addRow(fila);
            }

            //finaliza llenado de tabla
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        txtId.setText("");
        tblPedidos.setModel(modeloPedidos);
        Limpiar();
        Desbloquear();
        Bloquear();
        btnCancelar.setEnabled(false);

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        String codigo = JOptionPane.showInputDialog("Ingrese el dato que desea eliminar: ");
        rs = pd.buscar(codigo);

        try {
            while (rs.next()) {
                txtId.setText(rs.getString(1));
                cmbVendedores.setActionCommand(rs.getString(2));
                cmbVendedores.setActionCommand(rs.getString(3));
                ftxtFechaPedido.setText(rs.getString(4));
                ftxtFechaSugerida.setText(rs.getString(5));
                encontrado = true;
                btnBuscar.setEnabled(true);
                btnCancelar.setEnabled(true);
                Bloquear2();
                Bloquear3();

                String buscar = codigo;
                int respuesta = JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar el dato Número " + codigo + " ?", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (respuesta == 0) {
                    pd.eliminar(buscar);
                    JOptionPane.showMessageDialog(null, "REGISTRO ELIMINADO CON EXITO.");
                    Limpiar();
                    txtId.setText("");
                    Bloquear();
                    btnCancelar.setEnabled(false);

                    reinicio();
                    Columnas();
                    int cuantasColumnas;
                    int columna;
                    rstPedidos = null;
                    rstPedidos = pd.llenarTabla();

                    try {
                        ResultSetMetaData rstClientesMD = rstPedidos.getMetaData();
                        cuantasColumnas = rstClientesMD.getColumnCount();

                        //llenar la tabla con encabezados
                        for (columna = 0; columna < cuantasColumnas; columna++) {
                            modeloPedidos.addColumn(encabezados.get(columna));
                        }

                        while (rstPedidos.next()) {
                            Object[] fila = new Object[columna];
                            for (int campo = 0; campo < cuantasColumnas; campo++) {
                                fila[campo] = rstPedidos.getObject(campo + 1);
                            }
                            modeloPedidos.addRow(fila);
                        }
                        //finaliza llenado de tabla
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                }
                if (respuesta == 1) {
                    JOptionPane.showMessageDialog(null, "Estuvo a punto de eliminar el registro. TENGA CUIDADO.", null, JOptionPane.WARNING_MESSAGE);
                }
            }
            if (encontrado == false) {
                JOptionPane.showMessageDialog(null, "Registro no encontrado", null, JOptionPane.ERROR_MESSAGE);
                btnModificar.setEnabled(false);
                btnEliminar.setEnabled(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmFormularioC1.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        JOptionPane.showMessageDialog(rootPane, "No se a afectado la base de DATOS. Regresando al INICIO.");
        Limpiar();
        Bloquear();
        btnCancelar.setEnabled(false);
        txtId.setText("");
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        dispose();
        frmMenu c = new frmMenu();
        c.setVisible(true);
    }//GEN-LAST:event_btnMenuActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmFormularioP.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmFormularioP.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmFormularioP.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmFormularioP.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmFormularioP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cmbClientes;
    private javax.swing.JComboBox<String> cmbVendedores;
    private javax.swing.JFormattedTextField ftxtFechaPedido;
    private javax.swing.JFormattedTextField ftxtFechaSugerida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblClienteSeleccionado;
    private javax.swing.JLabel lblVendedorSeleccionado;
    private javax.swing.JTable tblPedidos;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
