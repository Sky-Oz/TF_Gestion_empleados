/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import conexion.MySQLConexion;
import dao.DAOEmpleado;
import dao.DAOSueldo;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Administrativo;
import modelo.Empleado;
import modelo.Vendedor;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author CASA
 */
public class frmPrincipal extends javax.swing.JFrame {

DAOEmpleado obj = new DAOEmpleado();
DAOSueldo sue = new DAOSueldo();
    int tipo,criterio;
    String codemp;
    char sex;
    
    //Constructor no parametrizado
    public frmPrincipal() {
        initComponents();
        Muestra();  
        setIconImage(getIconImage());
    }
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("recursos/logomini.png"));
        return retValue;
    
    }

    //Método para crear y mostrar la tabla
    void Muestra() {
        DefaultTableModel dt = (DefaultTableModel) tablaEmp.getModel();
        dt.setRowCount(0);
        for (Empleado x : obj.lisEmpleados()) {
            Object v[] = {x.getCode(), x.getNome(), x.getApe(), x.getNpuesto(), x.getTpuesto(), x.getFcontrat(), x.getSbase()};
            dt.addRow(v);
        }
        btnEditar.setEnabled(true);
          btnGrabar.setEnabled(true);
          btnElim.setEnabled(true);
          btnLimpia.setEnabled(true);
          cboxCriterio.setSelectedIndex(0);
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtApe = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNom = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cboxSexo = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtFnac = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtDnac = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cboxGrad = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtTelf = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtCorr = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtDir = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtPuesto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cboxTpues = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        txtFcont = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cboxSeg = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        txtSueldo = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        btnGrabar = new javax.swing.JButton();
        btnLimpia = new javax.swing.JButton();
        btnElim = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnFin = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaEmp = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        txtPbusq = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        cboxCriterio = new javax.swing.JComboBox<>();
        bttImprimir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnCalcular = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtaSalida = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        txtfcese = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        lblFondo = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Gestión de Empleados");
        setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Generales"));

        jLabel6.setText("Apellidos");

        txtApe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApeActionPerformed(evt);
            }
        });

        jLabel7.setText("Nombres");

        jLabel8.setText("DNI");

        jLabel2.setText("Sexo");

        cboxSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));
        cboxSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxSexoActionPerformed(evt);
            }
        });

        jLabel9.setText("Fecha Nac.");

        jLabel10.setText("Distrito Nac.");

        jLabel11.setText("Grado de estudios");

        cboxGrad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tecnico", "Universitario", "Secundaria" }));
        cboxGrad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxGradActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtDni)
                                .addComponent(txtNom)
                                .addComponent(txtApe)
                                .addComponent(cboxSexo, 0, 181, Short.MAX_VALUE)
                                .addComponent(txtFnac))
                            .addComponent(txtDnac, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addComponent(cboxGrad, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApe, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFnac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDnac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cboxGrad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cboxGrad, cboxSexo, txtApe, txtDnac, txtDni, txtFnac, txtNom});

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de contacto"));

        jLabel12.setText("Teléfono");

        jLabel13.setText("E-mail");

        jLabel14.setText("Dirección");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTelf, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(txtCorr)
                    .addComponent(txtDir))
                .addGap(24, 24, 24))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelf, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(txtCorr, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtCorr, txtDir, txtTelf});

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de empleado"));
        jPanel7.setPreferredSize(new java.awt.Dimension(354, 100));

        jLabel15.setText("Puesto");

        jLabel3.setText("Tipo de puesto");

        cboxTpues.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrativo", "Ventas" }));
        cboxTpues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxTpuesActionPerformed(evt);
            }
        });

        jLabel16.setText("Fecha de contratación");

        jLabel4.setText("Seguro");

        cboxSeg.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AFP", "ONP" }));
        cboxSeg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxSegActionPerformed(evt);
            }
        });

        jLabel17.setText("Sueldo asignado");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel16)
                    .addComponent(jLabel15)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboxTpues, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPuesto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFcont, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxSeg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSueldo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboxTpues, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFcont, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboxSeg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cboxSeg, cboxTpues, txtFcont, txtPuesto, txtSueldo});

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Operaciones"));

        btnGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/registro.png"))); // NOI18N
        btnGrabar.setText("Registrar");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        btnLimpia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/nuevo.png"))); // NOI18N
        btnLimpia.setText("Nuevo");
        btnLimpia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiaActionPerformed(evt);
            }
        });

        btnElim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/eliminar.png"))); // NOI18N
        btnElim.setText("Eliminar");
        btnElim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElimActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/editar.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnFin.setText("Fin");
        btnFin.setEnabled(false);
        btnFin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGrabar)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnLimpia, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnElim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(45, 45, 45)
                .addComponent(btnFin)
                .addGap(33, 33, 33))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(btnFin))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(btnGrabar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimpia)
                        .addGap(13, 13, 13)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnElim)))
                .addGap(0, 33, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tablaEmp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombres", "Apellidos", "N. puesto", "T. puesto", "F. contratacion", "Sueldo"
            }
        ));
        tablaEmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEmpMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablaEmp);

        txtPbusq.setEnabled(false);
        txtPbusq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPbusqActionPerformed(evt);
            }
        });

        jLabel20.setText("Param. busqueda");

        jLabel21.setText("Criterio");

        jLabel5.setText("Empleados registrados");

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        cboxCriterio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ninguno", "Codigo", "E. Administrativo", "E. Ventas", "Nombre", "Apellido" }));
        cboxCriterio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxCriterioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPbusq, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboxCriterio, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(97, 97, 97))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtPbusq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(cboxCriterio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnBuscar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bttImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imprimir.png"))); // NOI18N
        bttImprimir.setText("Imprimir");
        bttImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(bttImprimir)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bttImprimir))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("REGISTRO", jPanel1);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        btnCalcular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/calculo_pago.png"))); // NOI18N
        btnCalcular.setText("Calcular");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Salida"));

        txtaSalida.setColumns(20);
        txtaSalida.setRows(5);
        jScrollPane2.setViewportView(txtaSalida);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos necesarios"));

        jLabel1.setText("Ingrese codigo del empleado");

        jLabel18.setText("Ingrese fecha de límite/cese ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel18))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtfcese, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(136, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtfcese, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Atención técnica al usuario"));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/slider-contacto-red.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(49, 49, 49)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(235, 235, 235)
                        .addComponent(btnCalcular)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnCalcular)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("DETALLE EMPLEADOS", jPanel3);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 102, 255));
        jLabel19.setText("GESTIÓN DE EMPLEADOS");

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/salir.png"))); // NOI18N
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(386, 386, 386)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel19))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel22)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void btnLimpiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiaActionPerformed
        
        btnEditar.setEnabled(false);
        btnElim.setEnabled(false);

        //Limpiado de campos para ingreso de nuevo trabajador
        txtApe.setText("");
        txtNom.setText("");
        txtDni.setText("");
        cboxSexo.setSelectedIndex(0);
        txtFnac.setText("");
        txtDnac.setText("");
        cboxGrad.setSelectedIndex(0);
        txtTelf.setText("");
        txtCorr.setText("");
        txtDir.setText("");
        txtPuesto.setText("");
        cboxTpues.setSelectedIndex(0);
        txtFcont.setText("");
        cboxSeg.setSelectedIndex(0);
        txtSueldo.setText("");
        
        txtApe.setEnabled(true);
        txtNom.setEnabled(true);
        cboxSexo.setEnabled(true);
        txtFnac.setEnabled(true);
        txtDnac.setEnabled(true);
        cboxGrad.setEnabled(true);
        txtCorr.setEnabled(true);
        txtDir.setEnabled(true);
        txtPuesto.setEnabled(true);
        cboxTpues.setEnabled(true);
        txtFcont.setEnabled(true);
        cboxSeg.setEnabled(true);
        txtDni.setEnabled(true);
        txtTelf.setEnabled(true);
        txtSueldo.setEnabled(true);
        
        
    }//GEN-LAST:event_btnLimpiaActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        //Si es tipo administrativo
        if (tipo == 0) {
            Administrativo a = new Administrativo();
            a.setApe(txtApe.getText());
            a.setNome(txtNom.getText());
            a.setSexo(cboxSexo.getSelectedItem().toString());
            a.setFnac(txtFnac.getText());
            a.setLnac(txtDnac.getText());
            a.setGestud(cboxGrad.getSelectedItem().toString());
            a.setMail(txtCorr.getText());
            a.setDir(txtDir.getText());
            a.setNpuesto(txtPuesto.getText());
            a.setTpuesto(cboxTpues.getSelectedItem().toString());
            a.setFcontrat(txtFcont.getText());
            a.setTseg(cboxSeg.getSelectedItem().toString());
            a.setDni(Integer.parseInt(txtDni.getText()));
            a.setTelef(Integer.parseInt(txtTelf.getText()));
            a.setSbase(Integer.parseInt(txtSueldo.getText()));
            
            obj.agrAdministrativo(a);
        }
        //Si es tipo vendedor
        if (tipo == 1) {
            Vendedor v = new Vendedor();
            v.setApe(txtApe.getText());
            v.setNome(txtNom.getText());
            v.setSexo(cboxSexo.getSelectedItem().toString());
            v.setFnac(txtFnac.getText());
            v.setLnac(txtDnac.getText());
            v.setGestud(cboxGrad.getSelectedItem().toString());
            v.setMail(txtCorr.getText());
            v.setDir(txtDir.getText());
            v.setNpuesto(txtPuesto.getText());
            v.setTpuesto(cboxTpues.getSelectedItem().toString());
            v.setFcontrat(txtFcont.getText());
            v.setTseg(cboxSeg.getSelectedItem().toString());
            v.setDni(Integer.parseInt(txtDni.getText()));
            v.setTelef(Integer.parseInt(txtTelf.getText()));
            v.setSbase(Integer.parseInt(txtSueldo.getText()));
            
            obj.agrVendedor(v);
        }

        JOptionPane.showMessageDialog(null, "Empleado registrado con éxito");
        //Deshabilita edicion de campos
        txtApe.setEnabled(false);
        txtNom.setEnabled(false);
        cboxSexo.setEnabled(false);
        txtFnac.setEnabled(false);
        txtDnac.setEnabled(false);
        cboxGrad.setEnabled(false);
        txtCorr.setEnabled(false);
        txtDir.setEnabled(false);
        txtPuesto.setEnabled(false);
        cboxTpues.setEnabled(false);
        txtFcont.setEnabled(false);
        cboxSeg.setEnabled(false);
        txtDni.setEnabled(false);
        txtTelf.setEnabled(false);
        txtSueldo.setEnabled(false);

        Muestra();
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void cboxSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxSexoActionPerformed
        
    }//GEN-LAST:event_cboxSexoActionPerformed

    private void cboxGradActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxGradActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxGradActionPerformed

    private void cboxTpuesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxTpuesActionPerformed
        //cbox que determina el tipo de empleado
        tipo = cboxTpues.getSelectedIndex();        
    }//GEN-LAST:event_cboxTpuesActionPerformed

    private void cboxSegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxSegActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxSegActionPerformed

    private void btnElimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElimActionPerformed
        
        Empleado e = obj.filtraEmpCod(codemp); 
        String tipo=e.getTpuesto();
        //Verificacion
        if (tipo.equals("Administrativo")) {            
            obj.borraAdm(e);
            System.out.println("El empleado Administrativo "+codemp+" ha sido eliminado");                      
        }else if(tipo.equals("Ventas")){
            obj.borraVend(e); 
            System.out.println("El empleado de Ventas "+codemp+" ha sido eliminado");     
        }else{
            System.out.println("Empleado no encontrado");
        }     
        
        
        Muestra();
    }//GEN-LAST:event_btnElimActionPerformed

    private void tablaEmpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEmpMouseClicked
   
          btnFin.setEnabled(false);
          codemp=(tablaEmp.getValueAt(tablaEmp.getSelectedRow(),0).toString()); 
          
          txtApe.setEnabled(false);
          txtNom.setEnabled(false);
          cboxSexo.setEnabled(false);
          txtFnac.setEnabled(false);
          txtDnac.setEnabled(false);
          cboxGrad.setEnabled(false);
          txtCorr.setEnabled(false);
          txtDir.setEnabled(false);
          txtPuesto.setEnabled(false);
          cboxTpues.setEnabled(false);
          txtFcont.setEnabled(false);
          cboxSeg.setEnabled(false);
          txtDni.setEnabled(false);
          txtTelf.setEnabled(false);
          txtSueldo.setEnabled(false);
          
          
          
          Empleado c = obj.filtraEmpCod(codemp);        
        
            this.txtApe.setText(c.getApe());
            this.txtNom.setText(c.getNome());  
            this.txtDni.setText(String.valueOf(c.getDni()));
            this.cboxSexo.setSelectedItem(c.getSexo()); 
            this.txtFnac.setText(c.getFnac());
            this.txtDnac.setText(c.getLnac());
            this.cboxGrad.setSelectedItem(c.getGestud());
            this.txtTelf.setText(String.valueOf(c.getTelef()));
            this.txtCorr.setText(c.getMail());
            this.txtDir.setText(c.getDir());
            this.txtPuesto.setText(c.getNpuesto());
            this.cboxTpues.setSelectedItem(c.getTpuesto());
            this.txtFcont.setText(c.getFcontrat());
            this.cboxSeg.setSelectedItem(c.getTseg());
            this.txtSueldo.setText(String.valueOf(c.getSbase()));         
        
            


    }//GEN-LAST:event_tablaEmpMouseClicked

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        txtaSalida.setText("");
        
        String code = txtBuscar.getText();//obtiene el codigo segun txtbox
        Empleado e = obj.filtraEmpCod(code);//busca        
        e.setFcese(txtfcese.getText());//setea la fecha de cese segun textbox
        //Verificacion
        if (e == null) {
            txtaSalida.setText("El codigo " + code + " no se encontro");
        }else if(e instanceof Administrativo){
            int hextras;
            hextras=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de horas extras realizadas: "));
            ((Administrativo) e).setHextras(hextras);  
            sue.cambiaHhee(code, hextras);
        }else if(e instanceof Vendedor){
            int montovent;
            montovent=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el monto total de ventas realizado: "));
            ((Vendedor) e).setMventas(montovent);
            sue.cambiaMvent(code, montovent);
        }
        
        sue.grabaSueldo(code);
        //Instancia de wrappers
        Calculo calculohaberes = new CTS(new Vacaciones(new Descuentos(new Bonificacion(new CalculoBasico()))));        
        txtaSalida.append("Resultados: "+calculohaberes.salida(e));
        Double total=calculohaberes.resultado(e);
        txtaSalida.append("El total a pagar es: "+Math.round(total*100)/100.0);
        sue.grabaTot(Math.round(total*100)/100.0);
        //Limpia
        txtBuscar.setText("");
        txtfcese.setText("");
        
        
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void txtPbusqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPbusqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPbusqActionPerformed

    private void txtApeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApeActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String param=txtPbusq.getText();
        //Sin filtro
        if (criterio == 0) {            
            Muestra();
        }
        
        //Por codigo
        if (criterio == 1) {            
            DefaultTableModel dt = (DefaultTableModel) tablaEmp.getModel();
            dt.setRowCount(0);
            for (Empleado x : obj.muestraEmpCod(param)) {
                Object v[] = {x.getCode(), x.getNome(), x.getApe(), x.getNpuesto(), x.getTpuesto(), x.getFcontrat(), x.getSbase()};
                dt.addRow(v);
            }            
            btnEditar.setEnabled(true);
            btnGrabar.setEnabled(true);
            btnElim.setEnabled(true);
            btnLimpia.setEnabled(true);        
        }
        
        //Por administrativos
        if (criterio == 2) {            
            DefaultTableModel dt = (DefaultTableModel) tablaEmp.getModel();
            dt.setRowCount(0);
            for (Empleado x : obj.filtraEmpAdm()) {
                Object v[] = {x.getCode(), x.getNome(), x.getApe(), x.getNpuesto(), x.getTpuesto(), x.getFcontrat(), x.getSbase()};
                dt.addRow(v);
            }
            btnEditar.setEnabled(true);
            btnGrabar.setEnabled(true);
            btnElim.setEnabled(true);
            btnLimpia.setEnabled(true);        
        }
        
        //Por vendedores
        if (criterio == 3) {            
            DefaultTableModel dt = (DefaultTableModel) tablaEmp.getModel();
            dt.setRowCount(0);
            for (Empleado x : obj.filtraEmpVen()) {
                Object v[] = {x.getCode(), x.getNome(), x.getApe(), x.getNpuesto(), x.getTpuesto(), x.getFcontrat(), x.getSbase()};
                dt.addRow(v);
            }
            btnEditar.setEnabled(true);
            btnGrabar.setEnabled(true);
            btnElim.setEnabled(true);
            btnLimpia.setEnabled(true);        
        }
        
        //Por nombre
        if (criterio == 4) {            
            DefaultTableModel dt = (DefaultTableModel) tablaEmp.getModel();
            dt.setRowCount(0);
            for (Empleado x : obj.filtraEmpNom(param)) {
                Object v[] = {x.getCode(), x.getNome(), x.getApe(), x.getNpuesto(), x.getTpuesto(), x.getFcontrat(), x.getSbase()};
                dt.addRow(v);
            }
            btnEditar.setEnabled(true);
            btnGrabar.setEnabled(true);
            btnElim.setEnabled(true);
            btnLimpia.setEnabled(true);        
        }        
        
        //Por apellido
        if (criterio == 5) {            
            DefaultTableModel dt = (DefaultTableModel) tablaEmp.getModel();
            dt.setRowCount(0);
            for (Empleado x : obj.filtraEmpApe(param)) {
                Object v[] = {x.getCode(), x.getNome(), x.getApe(), x.getNpuesto(), x.getTpuesto(), x.getFcontrat(), x.getSbase()};
                dt.addRow(v);
            }
            btnEditar.setEnabled(true);
            btnGrabar.setEnabled(true);
            btnElim.setEnabled(true);
            btnLimpia.setEnabled(true);        
        }
        
        
        
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        txtApe.setEnabled(true);
          txtNom.setEnabled(true);
          cboxSexo.setEnabled(true);
          txtFnac.setEnabled(true);
          txtDnac.setEnabled(true);
          cboxGrad.setEnabled(true);
          txtCorr.setEnabled(true);
          txtDir.setEnabled(true);
          txtPuesto.setEnabled(true);
          cboxTpues.setEnabled(true);
          txtFcont.setEnabled(true);
          cboxSeg.setEnabled(true);
          txtDni.setEnabled(true);
          txtTelf.setEnabled(true);
          txtSueldo.setEnabled(true);
          btnFin.setEnabled(true);
          
          btnEditar.setEnabled(false);
          btnGrabar.setEnabled(false);
          btnElim.setEnabled(false);
          btnLimpia.setEnabled(false);
          
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnFinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinActionPerformed
        //Si es tipo administrativo
        if (tipo == 0) {
            Administrativo a = new Administrativo();
            
            a.setCode(codemp);
            a.setApe(txtApe.getText());
            a.setNome(txtNom.getText());
            a.setSexo(cboxSexo.getSelectedItem().toString());
            a.setFnac(txtFnac.getText());
            a.setLnac(txtDnac.getText());
            a.setGestud(cboxGrad.getSelectedItem().toString());
            a.setMail(txtCorr.getText());
            a.setDir(txtDir.getText());
            a.setNpuesto(txtPuesto.getText());
            a.setTpuesto(cboxTpues.getSelectedItem().toString());
            a.setFcontrat(txtFcont.getText());
            a.setTseg(cboxSeg.getSelectedItem().toString());
            a.setDni(Integer.parseInt(txtDni.getText()));
            a.setTelef(Integer.parseInt(txtTelf.getText()));
            a.setSbase(Double.parseDouble(txtSueldo.getText()));
            
            obj.modificaAdm(a);
        }
        //Si es tipo vendedor
        if (tipo == 1) {
            Vendedor v = new Vendedor();
            
            v.setCode(codemp);
            v.setApe(txtApe.getText());
            v.setNome(txtNom.getText());
            v.setSexo(cboxSexo.getSelectedItem().toString());
            v.setFnac(txtFnac.getText());
            v.setLnac(txtDnac.getText());
            v.setGestud(cboxGrad.getSelectedItem().toString());
            v.setMail(txtCorr.getText());
            v.setDir(txtDir.getText());
            v.setNpuesto(txtPuesto.getText());
            v.setTpuesto(cboxTpues.getSelectedItem().toString());
            v.setFcontrat(txtFcont.getText());
            v.setTseg(cboxSeg.getSelectedItem().toString());
            v.setDni(Integer.parseInt(txtDni.getText()));
            v.setTelef(Integer.parseInt(txtTelf.getText()));
            v.setSbase(Double.parseDouble(txtSueldo.getText()));
            
            obj.modificaVend(v);
        }

        JOptionPane.showMessageDialog(null, "Los datos modificados con éxito");
        //Deshabilita edicion de campos
        txtApe.setEnabled(false);
        txtNom.setEnabled(false);
        cboxSexo.setEnabled(false);
        txtFnac.setEnabled(false);
        txtDnac.setEnabled(false);
        cboxGrad.setEnabled(false);
        txtCorr.setEnabled(false);
        txtDir.setEnabled(false);
        txtPuesto.setEnabled(false);
        cboxTpues.setEnabled(false);
        txtFcont.setEnabled(false);
        cboxSeg.setEnabled(false);
        txtDni.setEnabled(false);
        txtTelf.setEnabled(false);
        txtSueldo.setEnabled(false);

        Muestra();
        btnFin.setEnabled(false);
    }//GEN-LAST:event_btnFinActionPerformed

    private void cboxCriterioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxCriterioActionPerformed
        criterio = cboxCriterio.getSelectedIndex();
        if (cboxCriterio.getSelectedIndex()==0){
            txtPbusq.setEnabled(false);
        }
        
        if (cboxCriterio.getSelectedIndex()==1){
            txtPbusq.setEnabled(true);
        }
        
        if (cboxCriterio.getSelectedIndex()==2){
            txtPbusq.setEnabled(false);
        }
        
        if (cboxCriterio.getSelectedIndex()==3){
            txtPbusq.setEnabled(false);
        }
        
        if (cboxCriterio.getSelectedIndex()==4){
            txtPbusq.setEnabled(true);
        }
        
        if (cboxCriterio.getSelectedIndex()==5){
            txtPbusq.setEnabled(true);
        }
        
        
    }//GEN-LAST:event_cboxCriterioActionPerformed

    private void bttImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttImprimirActionPerformed
        
        try {
            //Conexion con la base de datos
            Connection cn=MySQLConexion.getConexion();
            
            JasperReport reporte = null;
            String path="C:\\Users\\diego\\Desktop\\Ciclo 2022-I\\Integrador\\TF_Gestion_empleados\\src\\reportes\\reportEmpleados.jasper";
            
            reporte = (JasperReport)JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(path, null, cn);
            JasperViewer view= new JasperViewer(jprint,false);
            
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            
            view.setVisible(true);
            
        } catch (Exception e) {
        }
    }//GEN-LAST:event_bttImprimirActionPerformed

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        frmInicio ini = new frmInicio();        
        ini.setVisible(true);
        this.setVisible(false);
        dispose();
    }//GEN-LAST:event_jLabel22MouseClicked

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
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnElim;
    private javax.swing.JButton btnFin;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnLimpia;
    private javax.swing.JButton bttImprimir;
    private javax.swing.JComboBox<String> cboxCriterio;
    private javax.swing.JComboBox<String> cboxGrad;
    private javax.swing.JComboBox<String> cboxSeg;
    private javax.swing.JComboBox<String> cboxSexo;
    private javax.swing.JComboBox<String> cboxTpues;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JTable tablaEmp;
    private javax.swing.JTextField txtApe;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCorr;
    private javax.swing.JTextField txtDir;
    private javax.swing.JTextField txtDnac;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtFcont;
    private javax.swing.JTextField txtFnac;
    private javax.swing.JTextField txtNom;
    private javax.swing.JTextField txtPbusq;
    private javax.swing.JTextField txtPuesto;
    private javax.swing.JTextField txtSueldo;
    private javax.swing.JTextField txtTelf;
    private javax.swing.JTextArea txtaSalida;
    private javax.swing.JTextField txtfcese;
    // End of variables declaration//GEN-END:variables
}
