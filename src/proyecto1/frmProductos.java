package proyecto1;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmProductos extends javax.swing.JFrame {

    Productos cl = new Productos();
    boolean encontrado = false;
    ResultSet rs = null;
    boolean newRecord = false;
    int cantidad = 0;
    int mayor = 0;
    DefaultComboBoxModel modeloTalla = new DefaultComboBoxModel();
    DefaultComboBoxModel modeloCategoria = new DefaultComboBoxModel();
    DefaultTableModel modeloProductos = new DefaultTableModel();
    ArrayList<String> encabezados = new ArrayList<>();

    ResultSet rstProductos = null;

    public frmProductos() {
        initComponents();
        this.setLocationRelativeTo(null);
        txtidProducto.setEnabled(false);

        this.setLocationRelativeTo(null);
        btnCancelar.setEnabled(false);
     Bloqueo();
     Bloquear();
        //VER LA TABLA CON LOS DATOS DESDE UN INICIO
        int cuantasColumnas;
        int columna;
        reinicio();
        Columnas();
        rstProductos = null;
        rstProductos = cl.llenarTabla();

        try {
            ResultSetMetaData rstProductosMD = rstProductos.getMetaData();
            cuantasColumnas = rstProductosMD.getColumnCount();

            //llenar la tabla con encabezados
            for (columna = 0; columna < cuantasColumnas; columna++) {
                modeloProductos.addColumn(encabezados.get(columna));
            }

            while (rstProductos.next()) {
                Object[] fila = new Object[columna];
                for (int campo = 0; campo < cuantasColumnas; campo++) {
                    fila[campo] = rstProductos.getObject(campo + 1);
                }
                modeloProductos.addRow(fila);
            }

            //finaliza llenado de tabla
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        tblProductos.setModel(modeloProductos);

    }

    public void Columnas() {
        encabezados.clear();
        encabezados.add("Id");
        encabezados.add("Saldo");
        encabezados.add("Unidad de Medida");
        encabezados.add("Descripción");
        encabezados.add("Precio de venta");
        encabezados.add("Talla");
        encabezados.add("Categoria");

    }

    public void reinicio() {
        modeloProductos.setColumnCount(0);
        modeloProductos.setRowCount(0);
    }

    public void Limpiar() {
        txtdescripcion.setText("");
        txtprecioVenta.setText("");
        txtsaldo.setText("");
        txtunidadMedida.setText("");

    }

    public void Bloquear() {
        btnAgregar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnEliminar.setEnabled(false);
        btnModificar.setEnabled(false);
        btnGuardar.setEnabled(false);

    }

    public void Bloquear2() {
        btnNuevo.setEnabled(true);
        btnAgregar.setEnabled(false);
        btnCancelar.setEnabled(true);
        btnEliminar.setEnabled(false);
        btnModificar.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnBuscar.setEnabled(true);

    }
    public void Bloqueo(){
    txtdescripcion.setEnabled(false);
    txtprecioVenta.setEnabled(false);
    txtidProducto.setEnabled(false);
    txtsaldo.setEnabled(false);
    txtunidadMedida.setEnabled(false);
    }
    public void Desbloquear(){
    txtdescripcion.setEnabled(true);
    txtprecioVenta.setEnabled(true);
    txtsaldo.setEnabled(true);
    txtunidadMedida.setEnabled(true);
    
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        lblTablaproductos = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblsaldo = new javax.swing.JLabel();
        lblUnidmed = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtidProducto = new javax.swing.JTextField();
        txtsaldo = new javax.swing.JTextField();
        txtunidadMedida = new javax.swing.JTextField();
        txtdescripcion = new javax.swing.JTextField();
        txtprecioVenta = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cmbtalla = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cmbcategoria = new javax.swing.JComboBox<>();
        lbltallaSeleccionada = new javax.swing.JLabel();
        lblcategoriaSeleccionada = new javax.swing.JLabel();
        btnMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setFont(new java.awt.Font("Engravers MT", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 102));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/free-30-instagram-stories-icons10_122557.png"))); // NOI18N
        jLabel3.setText("\"MINI BAZAR MARTÍNEZ\"");
        jLabel3.setToolTipText("");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblTablaproductos.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 15)); // NOI18N
        lblTablaproductos.setForeground(new java.awt.Color(0, 204, 51));
        lblTablaproductos.setText("Registro de Productos");

        lblId.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblId.setText("Id:");

        lblsaldo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblsaldo.setText("Saldo:");

        lblUnidmed.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblUnidmed.setText("Unidad de medida:");

        lblDescripcion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDescripcion.setText("Descripción:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Precio de venta:");

        txtidProducto.setText(" ");

        txtsaldo.setText(" ");

        txtunidadMedida.setText(" ");
        txtunidadMedida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtunidadMedidaActionPerformed(evt);
            }
        });

        txtdescripcion.setText(" ");

        txtprecioVenta.setText("$");

        tblProductos.setModel(modeloProductos);
        jScrollPane1.setViewportView(tblProductos);

        btnNuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/camiseta-informal.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnAgregar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/calcetines (1).png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/panales.png"))); // NOI18N
        btnBuscar.setText("Buscar");

        btnModificar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/camiseta.png"))); // NOI18N
        btnModificar.setText("Modificar");

        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/flores.png"))); // NOI18N
        btnGuardar.setText("Guardar cambios");

        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/calcetines.png"))); // NOI18N
        btnEliminar.setText("Eliminar");

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/3668861-clothes-fashion-outfit-tshirt_108013 (1)_1.png"))); // NOI18N
        btnCancelar.setText("Cancelar");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("Talla:");

        cmbtalla.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbtalla.setForeground(new java.awt.Color(255, 102, 153));
        cmbtalla.setModel(modeloTalla        );
        cmbtalla.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbtallaItemStateChanged(evt);
            }
        });
        cmbtalla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbtallaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Categoria:");

        cmbcategoria.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbcategoria.setForeground(new java.awt.Color(255, 153, 0));
        cmbcategoria.setModel(modeloCategoria);

        lbltallaSeleccionada.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbltallaSeleccionada.setForeground(new java.awt.Color(0, 102, 51));
        lbltallaSeleccionada.setText("jLabel4");

        lblcategoriaSeleccionada.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblcategoriaSeleccionada.setForeground(new java.awt.Color(0, 102, 51));
        lblcategoriaSeleccionada.setText("jLabel5");

        btnMenu.setText("Regresar al MENU");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblsaldo)
                                    .addComponent(lblUnidmed)
                                    .addComponent(lblDescripcion))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtidProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtunidadMedida, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                    .addComponent(txtsaldo)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtprecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(cmbcategoria, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cmbtalla, javax.swing.GroupLayout.Alignment.LEADING, 0, 95, Short.MAX_VALUE))
                                        .addGap(20, 20, 20)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblcategoriaSeleccionada)
                                            .addComponent(lbltallaSeleccionada))))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(329, 329, 329)
                        .addComponent(lblTablaproductos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMenu))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(197, 197, 197)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTablaproductos)
                    .addComponent(btnMenu))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblId)
                            .addComponent(txtidProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblsaldo)
                            .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUnidmed)
                            .addComponent(txtsaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtunidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDescripcion))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtprecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbtalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(lbltallaSeleccionada))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cmbcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblcategoriaSeleccionada))
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnAgregar)
                    .addComponent(btnBuscar)
                    .addComponent(btnModificar)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtunidadMedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtunidadMedidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtunidadMedidaActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
          rs = null;

        //método en clase Clientes
        rs = cl.contarRegistros();
        try {
            while (rs.next()) {
                cantidad = rs.getInt(1);
                if (cantidad != 0) {
                    rs = null;
                    //método en clase Clientes
                    rs = cl.mayorRegistro();
                    while (rs.next()) {
                        mayor = rs.getInt(1) + 1;
                        //recuerde que debe completar 5 digitos
                        if (mayor < 10) {
                            txtidProducto.setText("0000" + mayor);
                        } else if (mayor < 100) {
                            this.txtidProducto.setText("000" + mayor);
                        } else if (mayor < 1000) {
                            txtidProducto.setText("00" + mayor);
                        } else if (mayor < 10000) {
                            txtidProducto.setText("0" + mayor);
                        } else {
                            txtidProducto.setText("" + mayor);
                        }
                    }
                } else {
                    txtidProducto.setText("0000" + 1);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "AVISO DEL SISTEMA", 0);
        }
       
        Limpiar();
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnBuscar.setEnabled(false);
        btnCancelar.setEnabled(true);
        this.txtsaldo.requestFocus();
        newRecord = true;
        Desbloquear();
        btnAgregar.setEnabled(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        int cuantasColumnas;
        int columna;
        if (newRecord == true) {
            if (this.txtdescripcion.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Debe llenar el campo de Descripción", "AVISO DEL SISTEMA", 2);
                this.txtdescripcion.requestFocus();

            } else if (this.txtprecioVenta.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Debe llenar el campo Precio venta", "AVISO DEL SISTEMA", 2);
                this.txtprecioVenta.requestFocus();
            } else if (this.txtsaldo.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Debe llenar el campo Primer Saldo", "AVISO DEL SISTEMA", 2);
                this.txtsaldo.requestFocus();
            } else if (this.txtunidadMedida.getText().equals("")) {

                JOptionPane.showMessageDialog(rootPane, "Debe llenar el campo de Unidad de medida", "AVISO DEL SISTEMA", 2);
                this.txtunidadMedida.requestFocus();
            }

        } else {
           // cl.insertar(txtidProducto.getText(), txtsaldo.getText(), txtunidadMedida.getText(), txtdescripcion.getText(), txtprecioVenta.getText(),);
        }
        JOptionPane.showMessageDialog(rootPane, "Registro guardado exitosamente!!", "AVISO DEL SISTEMA", 1);
        reinicio();
        Columnas();
        rstProductos = null;
        rstProductos = cl.llenarTabla();

        try {

            ResultSetMetaData rstProductosMD = rstProductos.getMetaData();
            cuantasColumnas = rstProductosMD.getColumnCount();
            //Llenado de tabla
            for(columna=0; columna<cuantasColumnas; columna++){
                modeloProductos.addColumn(encabezados.get(columna));
            }
            while(rstProductos.next()){
            Object[] fila = new Object[columna];
                        for (int campo = 0; campo < cuantasColumnas; campo++) {
                            fila[campo] = rstProductos.getObject(campo + 1);
                        }
                        modeloProductos.addRow(fila);
            }
            

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    tblProductos.setModel(modeloProductos);
Limpiar();
Bloquear2();
newRecord=false;

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void cmbtallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbtallaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbtallaActionPerformed

    private void cmbtallaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbtallaItemStateChanged
        // TODO add your handling code here:
        
        
        
        
    }//GEN-LAST:event_cmbtallaItemStateChanged

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
            java.util.logging.Logger.getLogger(frmProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmProductos().setVisible(true);
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
    private javax.swing.JComboBox<String> cmbcategoria;
    private javax.swing.JComboBox<String> cmbtalla;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblTablaproductos;
    private javax.swing.JLabel lblUnidmed;
    private javax.swing.JLabel lblcategoriaSeleccionada;
    private javax.swing.JLabel lblsaldo;
    private javax.swing.JLabel lbltallaSeleccionada;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtdescripcion;
    private javax.swing.JTextField txtidProducto;
    private javax.swing.JTextField txtprecioVenta;
    private javax.swing.JTextField txtsaldo;
    private javax.swing.JTextField txtunidadMedida;
    // End of variables declaration//GEN-END:variables
}
