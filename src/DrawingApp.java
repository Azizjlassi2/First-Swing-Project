/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;



/**
 *
 * @author Jlassi Mohamed Aziz
 */
public class DrawingApp extends JComponent implements MouseMotionListener,MouseListener {
    private JFrame fen;
    private BufferedImage canvas;
    private Graphics2D g2d;
    
    
    private int x=0,y=0;
    private Color couleur = Color.black;
    private int taille = 5;
    
    
    public DrawingApp(){
        fen = new JFrame("Just Paint");
        fen.setSize(800,600);
        Container c = fen.getContentPane();
        c.setLayout(new BorderLayout());
        
        JPanel p1 = new JPanel();
        p1.setLayout(new FlowLayout());
        JButton b1 = new JButton("Black");
        b1.setBackground(Color.BLACK);
        JButton b2 = new JButton("BLUE");
        b2.setBackground(Color.BLUE);
        JButton b3 = new JButton("RED");
        b3.setBackground(Color.RED);
        JButton b4 = new JButton("GREEN");
        b4.setBackground(Color.GREEN);
        JButton b5 = new JButton("YELLOW");
        b5.setBackground(Color.yellow);
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        p1.add(b4);
        p1.add(b5);

        for (Component component : p1.getComponents()) {
            component.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e){
                    couleur = component.getBackground();
                }
            });
            
        };
        
        
        
        
        JPanel p2 =  new JPanel(new FlowLayout());
        JRadioButton t3 = new JRadioButton("3 px") ;
        JRadioButton t5 = new JRadioButton("5 px") ;
        JRadioButton t12 = new JRadioButton("12 px") ;
        ButtonGroup groupe = new ButtonGroup();
        groupe.add(t3);
        groupe.add(t5);
        groupe.add(t12);
        p2.add(t3);
        p2.add(t5);
        p2.add(t12);


        for (Component component : p2.getComponents()) {
            component.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e){
                    System.out.println(component);
                }
            });
            
        };
        JButton effacer = new JButton("Clear");
        effacer.setBackground(Color.WHITE);
        p2.add(effacer);

        effacer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                g2d.setColor(Color.WHITE);
                g2d.fillRect(x, y, canvas.getWidth(), canvas.getHeight());
                g2d.setColor(couleur);
                repaint();
            }
        });
        
        
        JPanel p3 = new JPanel(new GridLayout(2,1));
        p3.add(p1);
        p3.add(p2);
        c.add(p3,"North");
        c.add(this,"Center");
        this.setBackground(Color.white);
        
        fen.setVisible(true);

        // Initializer le canvas
        canvas = new BufferedImage(fen.getWidth(),fen.getHeight(), BufferedImage.TYPE_INT_ARGB);
        g2d = canvas.createGraphics();
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0,canvas.getWidth(), canvas.getHeight());
        g2d.setColor(Color.white);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);



        
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(canvas, 0, 0, null);
    }

    
    @Override
    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }
    
    
    @Override
    public void mouseDragged(MouseEvent e) {
        g2d.setColor(couleur);
        g2d.setStroke(new BasicStroke(taille));
        g2d.drawLine(x, y, e.getX(), e.getY());
        x = e.getX();
        y = e.getY();
        repaint();

    }


    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        new DrawingApp();
    }
     

  

    
    
    
    
     @Override
    public void mouseClicked(MouseEvent e) {
        
    }
    @Override
    public void mouseMoved(MouseEvent e) {
    }

  
    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
