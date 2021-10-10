package crudvector01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class CrudFrame extends JFrame{
    
    ArrayList<DatosPersona> listapersona = new ArrayList();

    JLabel lb_nombres    = new JLabel("Nombres: ");
    JLabel lb_ap_paterno = new JLabel("Ap. Paterno: ");
    JLabel lb_ap_materno = new JLabel("Ap. Materno: ");
    JLabel lb_codigo     = new JLabel("Codigo: ");
    
    JTextField txf_nombres    = new JTextField();
    JTextField txf_ap_paterno = new JTextField();
    JTextField txf_ap_materno = new JTextField();
    JTextField txf_codigo     = new JTextField();

    
    MetodosSistema metodos= new MetodosSistema();
    
    public CrudFrame(){
        
        JMenuBar menuBar = new JMenuBar();
        
        JMenu menuFile   = new JMenu();
        JMenu menuMantenimiento = new JMenu();
        JMenu menuReportes = new JMenu();
        
        JMenuItem menuFileExit               = new JMenuItem();
        JMenuItem menuMantenimientoRegistrar = new JMenuItem();
        JMenuItem menuMantenimientoEliminar  = new JMenuItem();
        
        JMenuItem menuReportesGeneral   = new JMenuItem();
        JMenuItem menuReportesDetallado = new JMenuItem();
        
        menuFile.setText("File");
        menuFileExit.setText("Salir");
        
        menuMantenimiento.setText("Crud");
        menuMantenimientoRegistrar.setText("Registrar");
        menuMantenimientoEliminar.setText("Eliminar");
        
        menuReportes.setText("Reportes");        
        menuReportesGeneral.setText("Rep. Global");
        menuReportesDetallado.setText("Rep. Detalle");
        
        menuFile.add(menuFileExit);
        
        menuMantenimiento.add(menuMantenimientoRegistrar);
        menuMantenimiento.add(menuMantenimientoEliminar);
        
        menuReportes.add(menuReportesGeneral);
        menuReportes.add(menuReportesDetallado);
        
        menuBar.add(menuFile);
        menuBar.add(menuMantenimiento);
        menuBar.add(menuReportes);
        
        setTitle("PRACTICA CRUD VECTOR");
        setJMenuBar(menuBar);
        setSize(new Dimension(650, 700));
        
        menuFileExit.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                  System.exit(0);
                }
            }
        );
        
        menuReportesGeneral.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                  String columnas[] = {"Nombres","Ap. Paterno","Ap. Materno","Codigo"};
                  Object filas[][] = new Object[metodos.lista.size()][4];
                  
                  
                  for(int i =0; i<listapersona.size();i++){
                      DatosPersona v = (DatosPersona)metodos.lista.get(i);
                      filas[i][0]=v.nombres;
                      filas[i][1]=v.ap_paterno;
                      filas[i][2]=v.ap_materno;
                      filas[i][3]=v.codigo;
                  }
                  
                  JTable tabla= new JTable(filas, columnas);
                  JScrollPane tabla1= new JScrollPane(tabla);
                  
                    JPanel reporte= new JPanel();
                    reporte.add(tabla1);
                    
                    Object  msg[]={reporte};
                    JOptionPane.showMessageDialog(null, msg, "Reporte", JOptionPane.QUESTION_MESSAGE);
                       
                    
                }
            }
        );
        
        
        
        menuMantenimientoRegistrar.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                  
                    JPanel pan1 = new JPanel(new GridLayout(1,2));
                    pan1.add(lb_nombres);
                    pan1.add(txf_nombres);
                    
                    JPanel pan2 = new JPanel(new GridLayout(1,2));
                    pan2.add(lb_ap_paterno);
                    pan2.add(txf_ap_paterno);
                    
                    JPanel pan3 = new JPanel(new GridLayout(1,2));
                    pan3.add(lb_ap_materno);
                    pan3.add(txf_ap_materno);
                    
                    JPanel pan4 = new JPanel(new GridLayout(1,2));
                    pan4.add(lb_codigo);
                    pan4.add(txf_codigo);
                    
                    Object msg []= {pan1, pan2, pan3, pan4};
                    
                    if(JOptionPane.showOptionDialog(null, msg,"Registrar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,null,null,null)==JOptionPane.OK_OPTION){
                    
                        DatosPersona dp= new DatosPersona();
                        dp.nombres=txf_nombres.getText();
                        dp.ap_paterno=txf_ap_paterno.getText();
                        dp.ap_materno=txf_ap_materno.getText();
                        dp.codigo=txf_codigo.getText();
                        listapersona.add(dp);
                        
                        metodos.registrarPersona(dp);
                        JOptionPane.showMessageDialog(null, "Se registro conExito", "Registro", JOptionPane.INFORMATION_MESSAGE);
                    }
                    
                }
            }
        );
        
        
    }
}
