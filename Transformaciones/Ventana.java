
package transformaciones;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import static java.lang.Boolean.FALSE;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Ventana extends JPanel implements ActionListener , KeyListener, MouseListener, MouseWheelListener{
    // ventana
    private JFrame ventana;
    // contenedor
    private Container contenedor;
    //declarar la figura
    private Punto figura[],p[];
    public JMenuBar arc;
    public JMenu uno;
    public JMenuItem opcion,opcion1,opcion2,opcion3,opcion4,opcion5,opcion6,opcion7,opcion8,opcion9;
    public JButton boton,boton1,boton2,boton3,boton4,boton5,boton6,boton7,boton8,boton9,botonAyuda,botonayudaM;


    
    public Ventana(String titulo,Punto figura[]) {
        // inicializar la ventana
        ventana = new JFrame(titulo);
        // definir tamaño a ventana
        ventana.setSize(1310, 600);
        setLayout(new FlowLayout(FlowLayout.LEFT, 2, 0));
        arc = new JMenuBar();
        uno = new JMenu("Acciones");
        opcion = new JMenuItem("Escalar");
        opcion1 = new JMenuItem("Trasladar");
        opcion2 = new JMenuItem("Rotacion derecha");
        opcion3 = new JMenuItem("Rotacion izquierda");
        opcion4 = new JMenuItem("ReflexionX");
        opcion5 = new JMenuItem("ReflexionY");
        opcion6 = new JMenuItem("ReflexionXY");
        opcion7 = new JMenuItem("Deformacion");
        opcion8 = new JMenuItem("Redibujar");
        opcion9 = new JMenuItem("salir");
        //menubar para transformaciones
        add(arc);
        arc.add(uno);
        uno.add(opcion);
        uno.add(opcion1);
        uno.add(opcion2);
        uno.add(opcion3);
        uno.add(opcion4);
        uno.add(opcion5);
        uno.add(opcion6);
        uno.add(opcion7);
        uno.add(opcion8);
        uno.add(opcion9);
        // conexion de las opciones
        opcion.addActionListener(this);
        opcion1.addActionListener(this);
        opcion2.addActionListener(this);
        opcion3.addActionListener(this);
        opcion4.addActionListener(this);
        opcion5.addActionListener(this);
        opcion6.addActionListener(this);
        opcion7.addActionListener(this);
        opcion8.addActionListener(this);
        opcion9.addActionListener(this);
        //botones para transformaciones
        boton= new JButton( "Escalar" );
        boton1= new JButton("Traslacion");
        boton2= new JButton("rotacion derecha");
        boton3= new JButton("rotacion izquierda");
        boton4= new JButton("reflexionX");
        boton5= new JButton("reflexionY");
        boton6= new JButton("reflexionXY");
        boton7= new JButton("deformacion");
        boton8= new JButton("redibujar");
        boton9= new JButton("salir");
        botonAyuda = new JButton("Atajos del teclado");
        botonayudaM = new JButton("Atajos del mouse");
        arc.add(boton9);
        arc.add(boton8);
        arc.add(boton7);
        arc.add(boton6);
        arc.add(boton5);
        arc.add(boton4);
        arc.add(boton3);
        arc.add(boton2);
        arc.add(boton1);
        arc.add(boton);
        arc.add(botonAyuda);
        arc.add(botonayudaM);
        //conexion de los botones
        boton.addActionListener(this);
        boton1.addActionListener(this);
        boton2.addActionListener(this);
        boton3.addActionListener(this);
        boton4.addActionListener(this);
        boton5.addActionListener(this);
        boton6.addActionListener(this);
        boton7.addActionListener(this);
        boton8.addActionListener(this);
        boton9.addActionListener(this);
        botonAyuda.addActionListener(this);
        botonayudaM.addActionListener(this);
        
        boton.setBackground(Color.YELLOW);
        boton1.setBackground(Color.BLUE);
        boton2.setBackground(Color.GREEN);
        boton3.setBackground(Color.MAGENTA);
        boton4.setBackground(Color.ORANGE);
        boton5.setBackground(Color.PINK);
        boton6.setBackground(Color.RED); 
        boton7.setBackground(Color.ORANGE);
        boton8.setBackground(Color.GREEN);
        boton9.setBackground(Color.white);
        botonAyuda.setBackground(Color.white);
        botonayudaM.setBackground(Color.white);
        boton.setFocusable(FALSE);
        boton1.setFocusable(FALSE);
        boton2.setFocusable(FALSE);
        boton3.setFocusable(FALSE);
        boton4.setFocusable(FALSE);
        boton5.setFocusable(FALSE);
        boton6.setFocusable(FALSE);
        boton7.setFocusable(FALSE);
        boton8.setFocusable(FALSE);
        boton9.setFocusable(FALSE);
        botonAyuda.setFocusable(FALSE);
        botonayudaM.setFocusable(FALSE);
        
               
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setFocusable(true);
        ventana.addKeyListener(this);
        ventana.setLocationRelativeTo(null);
        
        contenedor = ventana.getContentPane();
        contenedor.setSize(1000, 600);
        // agregar la ventana en el contenedor
        contenedor.add(this, BorderLayout.CENTER);
        this.figura=figura;
        p=figura;
        addMouseListener(this);
        addMouseWheelListener(this);
    }
    
       private void dibujar(Graphics g){
        for (int i = 0; i < figura.length-1; i++) {
            g.drawLine(
                    this.figura[i].getX(),
                    this.figura[i].getY(),
                    this.figura[i+1].getX(),
                    this.figura[i+1].getY()
            );
        }
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); 
        g.setColor(Color.BLACK);
        this.dibujar(g);
    }
   
  public void escalar(double fx, double fy){
        int tx=figura[0].getX(),ty=figura[0].getY();
        for (Punto punto : figura) {
            punto.setX((int)(((punto.getX() - tx)* fx) + tx));
            punto.setY((int)(((punto.getY() - ty)* fy) + ty));
        }
    }
    public void traslacion(int xf, int yf){
        for (Punto punto : figura) {
            punto.setX((int)(punto.getX() + xf));
            punto.setY((int)(punto.getY() + yf));
        }
    }
    public void RotacionDerecha (double angulo){
        int tx=figura[0].getX(),ty=figura[0].getY();
        for (Punto punto : figura) {
            punto.setX((int)((punto.getX() - tx)*Math.cos(Math.toRadians(angulo))-(punto.getY()-ty)*Math.sin(Math.toRadians(angulo))+tx));
           punto.setY((int)((punto.getX() - ty)*Math.sin(Math.toRadians(angulo))+(punto.getY()-ty)*Math.cos(Math.toRadians(angulo))+ty));
        }
    }
    public void rotacionIzquierda(double angulo){
        int tx=figura[0].getX(),ty=figura[0].getY();
        for (Punto punto : figura) {
            punto.setX((int)((punto.getX() - tx)*Math.cos(Math.toRadians(angulo))+(punto.getY()-ty)*Math.sin(Math.toRadians(angulo))+tx));
            punto.setY((int)(-(punto.getX() - ty)*Math.sin(Math.toRadians(angulo))+(punto.getY()-ty)*Math.cos(Math.toRadians(angulo))+ty));
        }
    }
    public void reflexionx(){
        int tx=figura[0].getX(),ty=figura[0].getY();
        for(Punto punto :figura){
          
            punto.setX((int) -(punto.getX()-tx)+tx);
            punto.setY((int) (punto.getY()-ty)+ty);
        }
    }public void reflexiony(){
        int tx=figura[0].getX(),ty=figura[0].getY();
        for(Punto punto :figura){
            punto.setX((int) (punto.getX()-tx)+tx);
            punto.setY((int) -(punto.getY()-ty)+ty);
        }
    }
    public void reflexionxy(){
        int tx=figura[0].getX(),ty=figura[0].getY();
        for(Punto punto :figura){
            punto.setX((int) -(punto.getX()-tx)+tx);
            punto.setY((int) -(punto.getY()-ty)+ty);
        }
    }
    public void deformacion(double dx, double dy){
        int tx=figura[0].getX(),ty=figura[0].getY();
        for (Punto punto : figura) {
            punto.setX((int)(((punto.getX() - tx)+ (punto.getY()-ty)*dx + tx)));
            punto.setY((int)(((punto.getY() - ty)* dy + (punto.getY()-ty) + ty)));
        }
    }
    public void setFigura(Punto figura[]){
        this.figura=figura;
    }
    public void redibujar(){
        Punto fig[] = {
          new Punto(30, 180),
            new Punto(30, 90),
            new Punto(30, 180),
            new Punto(60,180),
            new Punto(60,90),
            new Punto(30,90),
            new Punto(60,90),
            new Punto(60,60),
            new Punto(90,60),
            new Punto(90,180),
            new Punto(60,180),
            new Punto(90,180),
            new Punto(90,120),
            new Punto(120,120),
            new Punto(120,180),
            new Punto(90,180),
            new Punto(120,180),
            new Punto(120,40),
            new Punto(160,40),
            new Punto(160,80),
            new Punto(140,80),
            new Punto(140,180),
            new Punto(120,180),
            new Punto(180,180),
            new Punto(180,80),
            new Punto(160,80),
            new Punto(175,80),
            new Punto(175,50),
            new Punto(215,50),
            new Punto(215,180),
            new Punto(180,180),
            new Punto(215,180),
            new Punto(215,70),
            new Punto(255,70),
            new Punto(255,110),
            new Punto(235,110),
            new Punto(235,180),
            new Punto(215,180),
            new Punto(275,180),
            new Punto(275,110),
            new Punto(255,110),
            new Punto(265,110),
            new Punto(265,60),
            new Punto(305,60),
            new Punto(305,100),
            new Punto(295,100),
            new Punto(295,180),
            new Punto(265,180),
            new Punto(330,180),
            new Punto(330,100),
            new Punto(300,100),
        };
        setFigura(fig);
        repaint();
    }
 
    

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_H){
            this.escalar(.5,.5 );
            repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_F){
            this.traslacion(8, 2);
            repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_C){
            this.RotacionDerecha(3.0);
            repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_X){
            this.rotacionIzquierda(3.0);
            repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_D){
            this.reflexionx();
            repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_A){
            this.reflexiony();
            repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_E){
            this.reflexionxy();
            repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_W){
            this.deformacion(.2, .2);
            repaint();
        }
        if(e.getKeyCode()==KeyEvent.VK_Q){
            this.redibujar();
            repaint();
        }
        if(e.getKeyCode()==KeyEvent.VK_S){
            System.exit(0);

    }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton()==1){
            this.traslacion(8,8);
            ventana.repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
      if(e.getButton()==3){
            this.traslacion(-2,-2);
            repaint();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        double scroll = .1;
        scroll = (e.getWheelRotation() > 0) ? 1 + scroll : 1 - scroll;
        this.escalar( scroll, scroll);
        repaint();
    }
     public void actionPerformed(ActionEvent e){
        if(e.getSource()==opcion){
            Double x,y;
            x=Double.parseDouble(JOptionPane.showInputDialog("Introdzca valor para escalar en X"));
            y=Double.parseDouble(JOptionPane.showInputDialog("Introdzca valor para escalar en  Y"));
            this.escalar(x,y);
            repaint();
        }
        if(e.getSource()==opcion1){
            int x,y;
            x=Integer.parseInt(JOptionPane.showInputDialog("Introdzca valor para traslacion en X"));
            y=Integer.parseInt(JOptionPane.showInputDialog("Introdzca valor para traslacion en Y"));
            this.traslacion(x,y);
            ventana.repaint();
        }
        if(e.getSource()==opcion2){
            double angulo;
            angulo=Double.parseDouble(JOptionPane.showInputDialog("Introduzca el angulo"));
            this.RotacionDerecha(angulo);
            repaint();
        }
        if(e.getSource()==opcion3){
            double angulo;
            angulo=Double.parseDouble(JOptionPane.showInputDialog("Introduzca el angulo"));
            this.rotacionIzquierda(angulo);
            repaint();
        }
        if(e.getSource()==opcion4){
            this.reflexionx();
            repaint();
        }
        if(e.getSource()==opcion5){
            this.reflexiony();
            repaint();
        }
        if(e.getSource()==opcion6){
            this.reflexionxy();
            repaint();
        }
        if(e.getSource()==opcion7){
            double x,y;
            x=Double.parseDouble(JOptionPane.showInputDialog("Introdzca valor para deformacion en  X"));
            y=Double.parseDouble(JOptionPane.showInputDialog("Introdzca valor para deformacion en Y"));
            this.deformacion(x,y);
            ventana.repaint();
        }
        if(e.getSource()==opcion8){
            this.redibujar();
            repaint();
        }
         if(e.getSource()==opcion9){
            System.exit(0);
        }
        if(e.getSource()==boton){
            this.escalar(.5,.5);
            ventana.repaint();
        }
        if(e.getSource()==boton1){
            this.traslacion(12,12);
            ventana.repaint();
        }
        if(e.getSource()==boton2){
            this.RotacionDerecha(8);
            repaint();
        }
        if(e.getSource()==boton3){
            this.rotacionIzquierda(8);
            repaint();
        }
        if(e.getSource()==boton4){
            this.reflexionx();
            repaint();
        }
        if(e.getSource()==boton5){
            this.reflexiony();
            repaint();
        }
        if(e.getSource()==boton6){
            this.reflexionxy();
            repaint();
        }
        if(e.getSource()==boton7){
            this.deformacion(.2,.2);
            ventana.repaint();
        }
        if(e.getSource()==boton8){
            this.redibujar();
            repaint();
        }
        if(e.getSource()==boton9){
            
           System.exit(0);
    }
         if(e.getSource()==botonAyuda){
            
           JOptionPane.showMessageDialog(null,"  --Atajos del teclado--\n"
                   + " Si presionas la tecla H hace una escalacion"
                   + "Si presionas la tecla F hace una traslacion\n "
                   + "Si presionas la tecla C hace una rotacion a la derecha\n"
                   + "Si presionas la tecla H hace una rotacion a la izquierda\n"
                   + "Si presionas la tecla D hace una reflexion en X\n"
                   + "Si presionas la tecla A hace una reflexion en Y\n"
                   + "Si presionas la tecla E hace una reflexion en XY\n"
                   + "Si presionas la tecla W hace una deformacion\n"
                   + "Si presionas la tecla Q redibuja la figura original\n"
                   + "Si presionas la tecla S termina el programa\n");
    }
          if(e.getSource()==botonayudaM){
            
           JOptionPane.showMessageDialog(null,"---Atajos con el mouse--\n"
                   + "Para bajar la figura hacia la izquierda solo presionar varias veces el mouse\n"
                   + "Para hacer mas grande la imagen utilizar los dedos haciendo un movimiento hacia arriba con estos\n"
                   + "Para hacer mas pequeña la imagen utilizar los dedos haciendo un movimiento hacia abajo con estos\n");
    }
    }
}