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

public class frmFormularioC1 extends javax.swing.JFrame {

    Clientes cl = new Clientes();
    boolean encontrado = false;
    ResultSet rs = null;
    boolean newRecord = false;
    int cantidad = 0;
    int mayor = 0;

    DefaultTableModel modeloClientes = new DefaultTableModel();
    ArrayList<String> encabezados = new ArrayList<>();

    ResultSet rstClientes = null;
    //Clientes cliente = new Clientes();

    public frmFormularioC1() {
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
        rstClientes = null;
        rstClientes = cl.llenarTabla();

        try {
            ResultSetMetaData rstClientesMD = rstClientes.getMetaData();
            cuantasColumnas = rstClientesMD.getColumnCount();

            //llenar la tabla con encabezados
            for (columna = 0; columna < cuantasColumnas; columna++) {
                modeloClientes.addColumn(encabezados.get(columna));
            }

            while (rstClientes.next()) {
                Object[] fila = new Object[columna];
                for (int campo = 0; campo < cuantasColumnas; campo++) {
                    fila[campo] = rstClientes.getObject(campo + 1);
                }
                modeloClientes.addRow(fila);
            }

            //finaliza llenado de tabla
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        tblClientes.setModel(modeloClientes);

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
        txtEmail.setEnabled(false);
        txtTelcliente.setEnabled(false);
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
        txtEmail.setEnabled(true);
        txtTelcliente.setEnabled(true);
        txtTelRef.setEnabled(true);
    }

    private void Bloquear2() {
        txtApellido1.setEnabled(false);
        txtApellido2.setEnabled(false);
        txtNombres.setEnabled(false);
        txtDireccion.setEnabled(false);
        txtEmail.setEnabled(false);
        txtTelcliente.setEnabled(false);
        txtTelRef.setEnabled(false);
        btnAgregar.setEnabled(false);
        btnModificar.setEnabled(true);

    }

    private void Desbloquear2() {
        txtApellido1.setEnabled(true);
        txtApellido2.setEnabled(true);
        txtNombres.setEnabled(true);
        txtDireccion.setEnabled(true);
        txtEmail.setEnabled(true);
        txtTelcliente.setEnabled(true);
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
        txtEmail.setText("");
        txtTelcliente.setText("");
        txtTelRef.setText("");
    }

    public void Columnas() {
        encabezados.clear();
        encabezados.add("Id");
        encabezados.add("Primer Apellido");
        encabezados.add("Segundo Apellido");
        encabezados.add("Nombres");
        encabezados.add("Dirección");
        encabezados.add("E-mail");
        encabezados.add("Teléfono Personal");
        encabezados.add("Teléfono de Referencia");
    }

    public void reinicio() {
        modeloClientes.setColumnCount(0);
        modeloClientes.setRowCount(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblRegistro = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblApellido1 = new javax.swing.JLabel();
        lblApellido2 = new javax.swing.JLabel();
        lblNombres = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        lblTelpersonal = new javax.swing.JLabel();
        lblTelReferencia = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtApellido1 = new javax.swing.JTextField();
        txtApellido2 = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        lblTelpersonal1 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        txtTelcliente = new javax.swing.JFormattedTextField();
        txtTelRef = new javax.swing.JFormattedTextField();
        btnMenu = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 191, 191));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(new ImageIcon(getClass().getResource("/iconos/icono.png")).getImage());

        lblRegistro.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        lblRegistro.setForeground(new java.awt.Color(0, 204, 0));
        lblRegistro.setText("REGISTRO DE CLIENTES ");

        jLabel3.setFont(new java.awt.Font("Engravers MT", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 102));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/free-30-instagram-stories-icons10_122557.png"))); // NOI18N
        jLabel3.setText("\"MINI BAZAR MARTÍNEZ\"");
        jLabel3.setToolTipText("");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblId.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblId.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/rosa.png"))); // NOI18N
        lblId.setText("Id:");

        lblApellido1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblApellido1.setText("Primer apellido:");

        lblApellido2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblApellido2.setText("Segundo apellido:");

        lblNombres.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNombres.setText("Nombres:");

        lblDireccion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDireccion.setText("Dirección:");

        lblTelpersonal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTelpersonal.setText("E-mail:");

        lblTelReferencia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTelReferencia.setText("Teléfono de referencia:");

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

        txtDireccion.setText("  ");
        txtDireccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDireccionMouseClicked(evt);
            }
        });
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDireccionKeyPressed(evt);
            }
        });

        txtEmail.setText("   ");
        txtEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtEmailMouseClicked(evt);
            }
        });
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmailKeyPressed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(153, 153, 255));
        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/camiseta-informal.png"))); // NOI18N
        btnGuardar.setText("Guardar cambios");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnAgregar.setBackground(new java.awt.Color(248, 219, 219));
        btnAgregar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/calcetines.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnModificar.setBackground(new java.awt.Color(204, 255, 204));
        btnModificar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/calcetines (1).png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(204, 204, 255));
        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/camiseta.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnNuevo.setBackground(new java.awt.Color(255, 255, 204));
        btnNuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/2-gloves-christmas-icon_icon-icons.com_48855_1.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        lblTelpersonal1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTelpersonal1.setText("Teléfono personal:");

        btnRegresar.setBackground(new java.awt.Color(255, 153, 153));
        btnRegresar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/3668861-clothes-fashion-outfit-tshirt_108013_1.png"))); // NOI18N
        btnRegresar.setText("CANCELAR");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/flores.png"))); // NOI18N
        btnEliminar.setText("Eliminar Registro");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        tblClientes.setModel(modeloClientes);
        tblClientes.setEnabled(false);
        jScrollPane1.setViewportView(tblClientes);

        try {
            txtTelcliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelcliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTelclienteMouseClicked(evt);
            }
        });
        txtTelcliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTelclienteKeyPressed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblApellido2)
                                .addGap(30, 30, 30)
                                .addComponent(txtApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(lblNombres)
                                .addGap(33, 33, 33)
                                .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(lblDireccion)
                                .addGap(31, 31, 31)
                                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(lblTelpersonal)
                                .addGap(30, 30, 30)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTelReferencia)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(lblTelpersonal1)))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTelcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTelRef, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblId)
                                    .addComponent(lblApellido1))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 849, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMenu)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNuevo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAgregar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(538, 538, 538)
                                .addComponent(btnGuardar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar)
                        .addGap(236, 236, 236)
                        .addComponent(btnRegresar)))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(lblRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(394, 394, 394))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblId)
                    .addComponent(btnMenu))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblApellido2)
                            .addComponent(txtApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombres)
                            .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDireccion)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTelpersonal)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(lblTelpersonal1)
                                .addGap(25, 25, 25))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTelcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTelReferencia)
                            .addComponent(txtTelRef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModificar)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        /*
        btnBuscar.setEnabled(false);
        btnRegresar.setEnabled(true);
        int cuantasColumnas;
        int columna;
        cl.insertar(txtId.getText(), txtApellido1.getText(), txtApellido2.getText(), txtNombres.getText(), txtDireccion.getText(), txtEmail.getText(), txtTelcliente.getText(), txtTelRef.getText());
        JOptionPane.showMessageDialog(null, "Guardado con éxito");
        reinicio();
        Columnas();
        rstClientes = null;
        rstClientes = cl.llenarTabla();

        try {
            ResultSetMetaData rstClientesMD = rstClientes.getMetaData();
            cuantasColumnas = rstClientesMD.getColumnCount();

            //llenar la tabla con encabezados
            for (columna = 0; columna < cuantasColumnas; columna++) {
                modeloClientes.addColumn(encabezados.get(columna));
            }

            while (rstClientes.next()) {
                Object[] fila = new Object[columna];
                for (int campo = 0; campo < cuantasColumnas; campo++) {
                    fila[campo] = rstClientes.getObject(campo + 1);
                }
                modeloClientes.addRow(fila);
            }

            //finaliza llenado de tabla
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        tblClientes.setModel(modeloClientes);
        Bloquear();
        Limpiar();
        this.txtId.setText("");
        newRecord = false;
         */

        //AGREGAR DATOS A BASE DE DATOS Y MOSTRARLOS EN TABLA CON RESTRICCIONES
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
            } else if (this.txtEmail.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Debe llenar el campo Email", "AVISO DEL SISTEMA", 2);
                this.txtEmail.requestFocus();
            } else if (this.txtTelcliente.getText().equals("    -    ")) {
                JOptionPane.showMessageDialog(rootPane, "Debe llenar el campo TELEFONO DEL CLIENTE!!", "AVISO DEL SISTEMA", 2);
                this.txtTelcliente.requestFocus();
            } else if (this.txtTelRef.getText().equals("    -    ")) {
                JOptionPane.showMessageDialog(rootPane, "Debe llenar el campo TELEFONO DE REFERENCIA!!", "AVISO DEL SISTEMA", 2);
                this.txtTelRef.requestFocus();
            } else {
                cl.insertar(txtId.getText(), txtApellido1.getText(), txtApellido2.getText(), txtNombres.getText(), txtDireccion.getText(), txtEmail.getText(), txtTelcliente.getText(), txtTelRef.getText());
                JOptionPane.showMessageDialog(rootPane, "Registro guardado exitosamente!!", "AVISO DEL SISTEMA", 1);

                reinicio();
                Columnas();
                rstClientes = null;
                rstClientes = cl.llenarTabla();

                try {
                    ResultSetMetaData rstClientesMD = rstClientes.getMetaData();
                    cuantasColumnas = rstClientesMD.getColumnCount();

                    //llenar la tabla con encabezados
                    for (columna = 0; columna < cuantasColumnas; columna++) {
                        modeloClientes.addColumn(encabezados.get(columna));
                    }
                    while (rstClientes.next()) {
                        Object[] fila = new Object[columna];
                        for (int campo = 0; campo < cuantasColumnas; campo++) {
                            fila[campo] = rstClientes.getObject(campo + 1);
                        }
                        modeloClientes.addRow(fila);
                    }
                    //finaliza llenado de tabla
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
                tblClientes.setModel(modeloClientes);
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
        cl.modificar(txtId.getText(), txtApellido1.getText(), txtApellido2.getText(), txtNombres.getText(), txtDireccion.getText(), txtEmail.getText(), txtTelcliente.getText(), txtTelRef.getText());
        JOptionPane.showMessageDialog(null, "Guardado con éxito");
        reinicio();
        Columnas();
        rstClientes = null;
        rstClientes = cl.llenarTabla();

        try {
            ResultSetMetaData rstClientesMD = rstClientes.getMetaData();
            cuantasColumnas = rstClientesMD.getColumnCount();

            //llenar la tabla con encabezados
            for (columna = 0; columna < cuantasColumnas; columna++) {
                modeloClientes.addColumn(encabezados.get(columna));
            }
            while (rstClientes.next()) {
                Object[] fila = new Object[columna];
                for (int campo = 0; campo < cuantasColumnas; campo++) {
                    fila[campo] = rstClientes.getObject(campo + 1);
                }
                modeloClientes.addRow(fila);
            }
            //finaliza llenado de tabla
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        txtId.setText("");
        tblClientes.setModel(modeloClientes);
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
                txtEmail.setText(rs.getString(6));
                txtTelcliente.setText(rs.getString(7));
                txtTelRef.setText(rs.getString(8));
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
        txtApellido1.setBackground(Color.orange);
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
                txtEmail.setText(rs.getString(6));
                txtTelcliente.setText(rs.getString(7));
                txtTelRef.setText(rs.getString(8));
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
                    rstClientes = null;
                    rstClientes = cl.llenarTabla();
                    try {
                        ResultSetMetaData rstClientesMD = rstClientes.getMetaData();
                        cuantasColumnas = rstClientesMD.getColumnCount();

                        //llenar la tabla con encabezados
                        for (columna = 0; columna < cuantasColumnas; columna++) {
                            modeloClientes.addColumn(encabezados.get(columna));
                        }
                        while (rstClientes.next()) {
                            Object[] fila = new Object[columna];
                            for (int campo = 0; campo < cuantasColumnas; campo++) {
                                fila[campo] = rstClientes.getObject(campo + 1);
                            }
                            modeloClientes.addRow(fila);
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

    private void ColoresTodos() {
        txtApellido1.setBackground(Color.white);
        txtDireccion.setBackground(Color.white);
        txtTelcliente.setBackground(Color.white);
        txtApellido2.setBackground(Color.white);
        txtNombres.setBackground(Color.white);
        txtEmail.setBackground(Color.white);
        txtTelRef.setBackground(Color.white);
    }

    private void txtApellido1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellido1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtApellido2.requestFocus();
            txtApellido2.setBackground(Color.orange);
            txtApellido1.setBackground(Color.white);
        }
    }//GEN-LAST:event_txtApellido1KeyPressed

    private void txtApellido2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellido2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtNombres.requestFocus();
            txtNombres.setBackground(Color.orange);
            txtApellido2.setBackground(Color.white);
        }
    }//GEN-LAST:event_txtApellido2KeyPressed

    private void txtNombresKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtDireccion.requestFocus();
            txtDireccion.setBackground(Color.orange);
            txtNombres.setBackground(Color.white);
        }
    }//GEN-LAST:event_txtNombresKeyPressed

    private void txtEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtTelcliente.requestFocus();
            txtTelcliente.setBackground(Color.orange);
            txtEmail.setBackground(Color.white);
        }
    }//GEN-LAST:event_txtEmailKeyPressed

    private void txtTelRefKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelRefKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtApellido1.requestFocus();
            txtApellido1.setBackground(Color.orange);
            txtTelRef.setBackground(Color.white);
        }
    }//GEN-LAST:event_txtTelRefKeyPressed

    private void txtTelclienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelclienteKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtTelRef.requestFocus();
            txtTelRef.setBackground(Color.orange);
            txtTelcliente.setBackground(Color.white);
        }
    }//GEN-LAST:event_txtTelclienteKeyPressed

    private void txtDireccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtEmail.requestFocus();
            txtEmail.setBackground(Color.orange);
            txtDireccion.setBackground(Color.white);
        }
    }//GEN-LAST:event_txtDireccionKeyPressed

    private void txtApellido1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtApellido1MouseClicked
        ColoresTodos();
        txtApellido1.setBackground(Color.orange);


    }//GEN-LAST:event_txtApellido1MouseClicked

    private void txtApellido2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtApellido2MouseClicked
        ColoresTodos();
        txtApellido2.setBackground(Color.orange);
        ;
    }//GEN-LAST:event_txtApellido2MouseClicked

    private void txtNombresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombresMouseClicked
        ColoresTodos();
        txtNombres.setBackground(Color.orange);

    }//GEN-LAST:event_txtNombresMouseClicked

    private void txtDireccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDireccionMouseClicked
        ColoresTodos();
        txtDireccion.setBackground(Color.orange);

    }//GEN-LAST:event_txtDireccionMouseClicked

    private void txtEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEmailMouseClicked
        ColoresTodos();
        txtEmail.setBackground(Color.orange);

    }//GEN-LAST:event_txtEmailMouseClicked

    private void txtTelclienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTelclienteMouseClicked
        ColoresTodos();
        txtTelcliente.setBackground(Color.orange);

    }//GEN-LAST:event_txtTelclienteMouseClicked

    private void txtTelRefMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTelRefMouseClicked
        ColoresTodos();
        txtTelRef.setBackground(Color.orange);
    }//GEN-LAST:event_txtTelRefMouseClicked

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
            java.util.logging.Logger.getLogger(frmFormularioC1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmFormularioC1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmFormularioC1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmFormularioC1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmFormularioC1().setVisible(true);
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApellido1;
    private javax.swing.JLabel lblApellido2;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JLabel lblRegistro;
    private javax.swing.JLabel lblTelReferencia;
    private javax.swing.JLabel lblTelpersonal;
    private javax.swing.JLabel lblTelpersonal1;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtApellido1;
    private javax.swing.JTextField txtApellido2;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JFormattedTextField txtTelRef;
    private javax.swing.JFormattedTextField txtTelcliente;
    // End of variables declaration//GEN-END:variables
}
