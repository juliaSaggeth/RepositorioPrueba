package proyecto1;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmFormularioV1 extends javax.swing.JFrame {

    vendedores cl = new vendedores();
    boolean encontrado = false;
    ResultSet rs = null;
    boolean newRecord = false;
    int cantidad = 0;
    int mayor = 0;

    DefaultTableModel modeloVendedores = new DefaultTableModel();
    ArrayList<String> encabezados = new ArrayList<>();

    ResultSet rstVendedores = null;
    //Clientes cliente = new Clientes();

    public frmFormularioV1() {
        initComponents();

        this.setLocationRelativeTo(null);
        btnRegresar.setEnabled(false);
        txtId.setEnabled(false);
        Bloquear();

        //VER LA TABLA CON LOS DATOS DESDE UN INICIO
        int cuantasColumnas;
        int columna;
        reinicio();
        Columnas();
        rstVendedores = null;
        rstVendedores = cl.llenarTabla();

        try {
            ResultSetMetaData rstClientesMD = rstVendedores.getMetaData();
            cuantasColumnas = rstClientesMD.getColumnCount();

            //llenar la tabla con encabezados
            for (columna = 0; columna < cuantasColumnas; columna++) {
                modeloVendedores.addColumn(encabezados.get(columna));
            }

            while (rstVendedores.next()) {
                Object[] fila = new Object[columna];
                for (int campo = 0; campo < cuantasColumnas; campo++) {
                    fila[campo] = rstVendedores.getObject(campo + 1);
                }
                modeloVendedores.addRow(fila);
            }

            //finaliza llenado de tabla
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        tblVendedores.setModel(modeloVendedores);

    }

    private void Bloquear() {
        btnNuevo.setEnabled(true);
        btnAgregar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnModificar.setEnabled(false);
        btnBuscar.setEnabled(true);
        btnEliminar.setEnabled(true);
        txtApellido1.setEnabled(false);
        txtApellido2.setEnabled(false);
        txtNombres.setEnabled(false);
        txtDireccion.setEnabled(false);
        txtTelvendedor.setEnabled(false);
        txtTelRef.setEnabled(false);
    }

    private void Desbloquear() {
        btnNuevo.setEnabled(false);
        btnAgregar.setEnabled(true);
        //btnBuscar.setEnabled(false);
        txtApellido1.setEnabled(true);
        txtApellido2.setEnabled(true);
        txtNombres.setEnabled(true);
        txtDireccion.setEnabled(true);
        txtTelvendedor.setEnabled(true);
        txtTelRef.setEnabled(true);
    }

    private void Bloquear2() {
        txtApellido1.setEnabled(false);
        txtApellido2.setEnabled(false);
        txtNombres.setEnabled(false);
        txtDireccion.setEnabled(false);
        txtTelvendedor.setEnabled(false);
        txtTelRef.setEnabled(false);
        btnAgregar.setEnabled(false);
        btnModificar.setEnabled(true);

    }

    private void Desbloquear2() {
        txtApellido1.setEnabled(true);
        txtApellido2.setEnabled(true);
        txtNombres.setEnabled(true);
        txtDireccion.setEnabled(true);
        txtTelvendedor.setEnabled(true);
        txtTelRef.setEnabled(true);
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
        txtApellido1.setText("");
        txtApellido2.setText("");
        txtNombres.setText("");
        txtDireccion.setText("");
        txtTelvendedor.setText("");
        txtTelRef.setText("");
    }

    public void Columnas() {
        encabezados.clear();
        encabezados.add("Id");
        encabezados.add("Primer Apellido");
        encabezados.add("Segundo Apellido");
        encabezados.add("Nombres");
        encabezados.add("Dirección");
        encabezados.add("Teléfono Personal");
        encabezados.add("Teléfono de Referencia");
    }

    public void reinicio() {
        modeloVendedores.setColumnCount(0);
        modeloVendedores.setRowCount(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtApellido1 = new javax.swing.JTextField();
        txtApellido2 = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVendedores = new javax.swing.JTable();
        txtTelvendedor = new javax.swing.JFormattedTextField();
        txtTelRef = new javax.swing.JFormattedTextField();
        lblRegistro = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnMenu = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/iconos/icono.png")).getImage());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/flores.png"))); // NOI18N
        jLabel4.setText("Id:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Primer apellido:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Segundo apellido:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Nombres:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Dirección:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Teléfono personal:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Teléfono de referencia:");

        txtApellido1.setText("  ");
        txtApellido1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtApellido1MouseClicked(evt);
            }
        });
        txtApellido1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtApellido1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellido1KeyTyped(evt);
            }
        });

        txtApellido2.setText("  ");
        txtApellido2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtApellido2MouseClicked(evt);
            }
        });
        txtApellido2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtApellido2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellido2KeyTyped(evt);
            }
        });

        txtNombres.setText("  ");
        txtNombres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNombresMouseClicked(evt);
            }
        });
        txtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombresKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombresKeyTyped(evt);
            }
        });

        txtDireccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDireccionMouseClicked(evt);
            }
        });
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDireccionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(204, 204, 255));
        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/panales.png"))); // NOI18N
        btnGuardar.setText("Guardar cambios");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnAgregar.setBackground(new java.awt.Color(255, 255, 204));
        btnAgregar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/camiseta.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnModificar.setBackground(new java.awt.Color(255, 204, 255));
        btnModificar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/calcetines.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(204, 255, 204));
        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/camiseta-informal.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnNuevo.setBackground(new java.awt.Color(255, 204, 204));
        btnNuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/calcetines (1).png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnRegresar.setBackground(new java.awt.Color(255, 153, 153));
        btnRegresar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/3668861-clothes-fashion-outfit-tshirt_108013.png"))); // NOI18N
        btnRegresar.setText("CANCELAR");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/rosa.png"))); // NOI18N
        btnEliminar.setText("Eliminar Registro");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        tblVendedores.setModel(modeloVendedores);
        tblVendedores.setEnabled(false);
        jScrollPane1.setViewportView(tblVendedores);

        try {
            txtTelvendedor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelvendedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTelvendedorMouseClicked(evt);
            }
        });
        txtTelvendedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTelvendedorKeyPressed(evt);
            }
        });

        try {
            txtTelRef.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelRef.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTelRefMouseClicked(evt);
            }
        });
        txtTelRef.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTelRefKeyPressed(evt);
            }
        });

        lblRegistro.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        lblRegistro.setForeground(new java.awt.Color(0, 204, 0));
        lblRegistro.setText("REGISTRO DE VENDEDORES");

        jLabel3.setFont(new java.awt.Font("Engravers MT", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 102));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/free-30-instagram-stories-icons10_122557.png"))); // NOI18N
        jLabel3.setText("\"MINI BAZAR MARTÍNEZ\"");
        jLabel3.setToolTipText("");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(10, 10, 10)
                                .addComponent(txtTelRef, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(txtTelvendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnModificar)))
                .addGap(18, 18, 18)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(jLabel6))
                                    .addComponent(jLabel7))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtApellido1, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                    .addComponent(txtApellido2)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 849, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnMenu))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(298, 298, 298)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(115, 115, 115)
                                        .addComponent(lblRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnMenu)))))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(txtApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(23, 23, 23)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel9)
                                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtTelvendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtTelRef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAgregar)
                        .addComponent(btnBuscar)
                        .addComponent(btnModificar)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        btnBuscar.setEnabled(false);
        btnRegresar.setEnabled(true);
        int cuantasColumnas;
        int columna;
        if (newRecord == true) {

            if (this.txtApellido1.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Debe llenar el campo Primer apellido", "AVISO DEL SISTEMA", 2);
                this.txtApellido1.requestFocus();
            } else if (this.txtApellido2.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Debe llenar el campo Segundo Apellido", "AVISO DEL SISTEMA", 2);
                this.txtApellido2.requestFocus();
            } else if (this.txtNombres.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Debe llenar el campo Nombres", "AVISO DEL SISTEMA", 2);
                this.txtNombres.requestFocus();
            } else if (this.txtDireccion.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Debe llenar el campo Dirección", "AVISO DEL SISTEMA", 2);
                this.txtDireccion.requestFocus();
            } else if (this.txtTelvendedor.getText().equals("    -    ")) {
                JOptionPane.showMessageDialog(rootPane, "Debe llenar el campo TELEFONO DEL CLIENTE!!", "AVISO DEL SISTEMA", 2);
                this.txtTelvendedor.requestFocus();
            } else if (this.txtTelRef.getText().equals("    -    ")) {
                JOptionPane.showMessageDialog(rootPane, "Debe llenar el campo TELEFONO DE REFERENCIA!!", "AVISO DEL SISTEMA", 2);
                this.txtTelRef.requestFocus();
            } else {
                cl.insertar(txtId.getText(), txtApellido1.getText(), txtApellido2.getText(), txtNombres.getText(), txtDireccion.getText(), txtTelvendedor.getText(), txtTelRef.getText());
                JOptionPane.showMessageDialog(rootPane, "Registro guardado exitosamente!!", "AVISO DEL SISTEMA", 1);

                reinicio();
                Columnas();
                rstVendedores = null;
                rstVendedores = cl.llenarTabla();

                try {
                    ResultSetMetaData rstClientesMD = rstVendedores.getMetaData();
                    cuantasColumnas = rstClientesMD.getColumnCount();

                    //llenar la tabla con encabezados
                    for (columna = 0; columna < cuantasColumnas; columna++) {
                        modeloVendedores.addColumn(encabezados.get(columna));
                    }
                    while (rstVendedores.next()) {
                        Object[] fila = new Object[columna];
                        for (int campo = 0; campo < cuantasColumnas; campo++) {
                            fila[campo] = rstVendedores.getObject(campo + 1);
                        }
                        modeloVendedores.addRow(fila);
                    }
                    //finaliza llenado de tabla
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
                tblVendedores.setModel(modeloVendedores);
                Bloquear();
                Limpiar();
                this.txtId.setText("");
                newRecord = false;
            }

        }


    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        int cuantasColumnas;
        int columna;
        cl.modificar(txtId.getText(), txtApellido1.getText(), txtApellido2.getText(), txtNombres.getText(), txtDireccion.getText(), txtTelvendedor.getText(), txtTelRef.getText());
        JOptionPane.showMessageDialog(null, "Guardado con éxito");
        reinicio();
        Columnas();
        rstVendedores = null;
        rstVendedores = cl.llenarTabla();

        try {
            ResultSetMetaData rstClientesMD = rstVendedores.getMetaData();
            cuantasColumnas = rstClientesMD.getColumnCount();

            //llenar la tabla con encabezados
            for (columna = 0; columna < cuantasColumnas; columna++) {
                modeloVendedores.addColumn(encabezados.get(columna));
            }
            while (rstVendedores.next()) {
                Object[] fila = new Object[columna];
                for (int campo = 0; campo < cuantasColumnas; campo++) {
                    fila[campo] = rstVendedores.getObject(campo + 1);
                }
                modeloVendedores.addRow(fila);
            }
            //finaliza llenado de tabla
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        txtId.setText("");
        tblVendedores.setModel(modeloVendedores);
        Limpiar();
        Desbloquear();
        Bloquear();
        btnRegresar.setEnabled(false);

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String codigo = JOptionPane.showInputDialog("Ingrese el dato a buscar: ");
        rs = cl.buscar(codigo);

        try {
            while (rs.next()) {
                txtId.setText(rs.getString(1));
                txtApellido1.setText(rs.getString(2));
                txtApellido2.setText(rs.getString(3));
                txtNombres.setText(rs.getString(4));
                txtDireccion.setText(rs.getString(5));
                txtTelvendedor.setText(rs.getString(6));
                txtTelRef.setText(rs.getString(7));
                encontrado = true;
                btnBuscar.setEnabled(true);
                btnRegresar.setEnabled(true);
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

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        txtId.setEnabled(false);
        txtApellido1.requestFocus();
        Desbloquear2();
        Desbloquear3();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        rs = null;
        ColoresTodos();
        txtApellido1.setBackground(Color.yellow);
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
        btnRegresar.setEnabled(true);
        this.txtApellido1.requestFocus();
        newRecord = true;

    }//GEN-LAST:event_btnNuevoActionPerformed

    private void txtApellido1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellido1KeyTyped
        char tipo = evt.getKeyChar();
        if (Character.isDigit(tipo)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtApellido1KeyTyped

    private void txtApellido2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellido2KeyTyped
        char tipo = evt.getKeyChar();
        if (Character.isDigit(tipo)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtApellido2KeyTyped

    private void txtNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyTyped
        char tipo = evt.getKeyChar();
        if (Character.isDigit(tipo)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombresKeyTyped

    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped
        char tipo = evt.getKeyChar();
        if (Character.isDigit(tipo)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDireccionKeyTyped

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        JOptionPane.showMessageDialog(rootPane, "No se a afectado la base de DATOS. Regresando al INICIO.");
        Limpiar();
        Bloquear();
        btnRegresar.setEnabled(false);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        String codigo = JOptionPane.showInputDialog("Ingrese el dato que desea eliminar: ");
        rs = cl.buscar(codigo);

        try {
            while (rs.next()) {
                txtId.setText(rs.getString(1));
                txtApellido1.setText(rs.getString(2));
                txtApellido2.setText(rs.getString(3));
                txtNombres.setText(rs.getString(4));
                txtDireccion.setText(rs.getString(5));
                txtTelvendedor.setText(rs.getString(6));
                txtTelRef.setText(rs.getString(7));
                encontrado = true;
                btnBuscar.setEnabled(true);
                btnRegresar.setEnabled(true);
                Bloquear2();
                Bloquear3();

                String buscar = codigo;
                int respuesta = JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar el dato Número " + codigo + " ?", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (respuesta == 0) {
                    cl.eliminar(buscar);
                    JOptionPane.showMessageDialog(null, "REGISTRO ELIMINADO CON EXITO.");
                    Limpiar();
                    txtId.setText("");
                    Bloquear();
                    btnRegresar.setEnabled(false);

                    reinicio();
                    Columnas();
                    int cuantasColumnas;
                    int columna;
                    rstVendedores = null;
                    rstVendedores = cl.llenarTabla();
                    try {
                        ResultSetMetaData rstClientesMD = rstVendedores.getMetaData();
                        cuantasColumnas = rstClientesMD.getColumnCount();

                        //llenar la tabla con encabezados
                        for (columna = 0; columna < cuantasColumnas; columna++) {
                            modeloVendedores.addColumn(encabezados.get(columna));
                        }
                        while (rstVendedores.next()) {
                            Object[] fila = new Object[columna];
                            for (int campo = 0; campo < cuantasColumnas; campo++) {
                                fila[campo] = rstVendedores.getObject(campo + 1);
                            }
                            modeloVendedores.addRow(fila);
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

        //bucle para ordenar los datos, AUN NO FUNCIONA ¿A QUIEN LLAMO PARA ORDENAR EL ID   ?
        /*modeloVendedores = new DefaultTableModel(null, idvendedor) {
                    public Class getColumnClass(int column) {
                      if (column >= 0 && column <= getColumnCount())
                        return getValueAt(0, column).getClass();
                      else
                        return Object.class;
                    }
                };*/
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void ColoresTodos() {
        txtApellido1.setBackground(Color.white);
        txtDireccion.setBackground(Color.white);
        txtTelvendedor.setBackground(Color.white);
        txtApellido2.setBackground(Color.white);
        txtNombres.setBackground(Color.white);
        txtTelRef.setBackground(Color.white);

    }
    private void txtApellido1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellido1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtApellido2.requestFocus();
            txtApellido2.setBackground(Color.yellow);
            txtApellido1.setBackground(Color.white);
        }
    }//GEN-LAST:event_txtApellido1KeyPressed

    private void txtApellido1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtApellido1MouseClicked
        ColoresTodos();
        txtApellido1.setBackground(Color.yellow);

    }//GEN-LAST:event_txtApellido1MouseClicked

    private void txtApellido2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellido2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtNombres.requestFocus();
            txtNombres.setBackground(Color.yellow);
            txtApellido2.setBackground(Color.white);
        }
    }//GEN-LAST:event_txtApellido2KeyPressed

    private void txtApellido2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtApellido2MouseClicked
        ColoresTodos();
        txtApellido2.setBackground(Color.yellow);

    }//GEN-LAST:event_txtApellido2MouseClicked

    private void txtNombresKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtDireccion.requestFocus();
            txtDireccion.setBackground(Color.yellow);
            txtNombres.setBackground(Color.white);
        }
    }//GEN-LAST:event_txtNombresKeyPressed

    private void txtNombresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombresMouseClicked
        ColoresTodos();
        txtNombres.setBackground(Color.yellow);

    }//GEN-LAST:event_txtNombresMouseClicked

    private void txtDireccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtTelvendedor.requestFocus();
            txtTelvendedor.setBackground(Color.yellow);
            txtDireccion.setBackground(Color.white);
        }
    }//GEN-LAST:event_txtDireccionKeyPressed

    private void txtDireccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDireccionMouseClicked
        ColoresTodos();
        txtDireccion.setBackground(Color.yellow);

    }//GEN-LAST:event_txtDireccionMouseClicked

    private void txtTelRefMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTelRefMouseClicked
        ColoresTodos();
        txtTelRef.setBackground(Color.yellow);
    }//GEN-LAST:event_txtTelRefMouseClicked

    private void txtTelRefKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelRefKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtApellido1.requestFocus();
            txtApellido1.setBackground(Color.yellow);
            txtTelRef.setBackground(Color.white);
        }
    }//GEN-LAST:event_txtTelRefKeyPressed

    private void txtTelvendedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelvendedorKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtTelRef.requestFocus();
            txtTelRef.setBackground(Color.yellow);
            txtTelvendedor.setBackground(Color.white);
        }
    }//GEN-LAST:event_txtTelvendedorKeyPressed

    private void txtTelvendedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTelvendedorMouseClicked
        ColoresTodos();
        txtTelvendedor.setBackground(Color.yellow);
    }//GEN-LAST:event_txtTelvendedorMouseClicked

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        dispose();
        frmMenu c = new frmMenu();
        c.setVisible(true);
    }//GEN-LAST:event_btnMenuActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed

    }//GEN-LAST:event_txtDireccionActionPerformed

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
            java.util.logging.Logger.getLogger(frmFormularioV1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmFormularioV1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmFormularioV1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmFormularioV1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmFormularioV1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblRegistro;
    private javax.swing.JTable tblVendedores;
    private javax.swing.JTextField txtApellido1;
    private javax.swing.JTextField txtApellido2;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JFormattedTextField txtTelRef;
    private javax.swing.JFormattedTextField txtTelvendedor;
    // End of variables declaration//GEN-END:variables
}
