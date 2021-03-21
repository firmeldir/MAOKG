package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;

@SuppressWarnings("serial")
public class HomeAnimation extends JPanel implements ActionListener {
    private static int maxWidth;
    private static int maxHeight;

    // the chimney coords
    double points1[][] = {
            { -40, -20 }, { -40, 16 }, { -25, 10 }, { -25, -20 }
    };
    //the roof coords
    double points2[][] = {
            { -7, -10 }, { -90, 23 }, { -90, 27 }, { 5, 27 }, { 5, 25 }, { 92, 25 }, { 92, 23 }, { -7, -10 }
    };

    Timer timer;

    // Для анімації масштабування
    private double scale = 1;
    private double delta = 0.01;

    // for movement animation
    private double tx = 1;
    private double ty = 0;
    private double deltaX = 1;
    private int radius = 220;
    private int radiusExtention = 110;

    public HomeAnimation() {
        timer = new Timer(10, this);
        timer.start();
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // Set rendering params.
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);

        // Set background color.
        g2d.setBackground(new Color(8, 0, 128));
        g2d.clearRect(0, 0, maxWidth, maxHeight);

        // Set (0;0) to the center to draw main Frame.
        g2d.translate(maxWidth/2, maxHeight/2);
        // Draw the main Frame.
        g2d.setColor(new Color(254, 165, 0));
        BasicStroke bs2 = new BasicStroke(16, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
        g2d.setStroke(bs2);
        g2d.drawRect(
                -(radius + radiusExtention),
                -(radius + radiusExtention),
                (radius + radiusExtention)*2,
                (radius + radiusExtention)*2
        );

        // Reset center to default value for the main animation.
        g2d.translate(tx, ty);

        // Draw chimney.
        GeneralPath chimney = new GeneralPath();
        chimney.moveTo(points1[0][0], points1[0][1]);
        for (int k = 1; k < points1.length; k++)
            chimney.lineTo(points1[k][0], points1[k][1]);
        chimney.closePath();
        g2d.scale(scale, scale);
        g2d.setColor(new Color(101, 67, 33));
        g2d.fill(chimney);

        // Draw house wall.
        g2d.setColor(new Color(128, 0, 0));
        g2d.fillRect(-90, 25, 180, 58);

        // Draw roof.
        g2d.setColor(new Color(128, 128, 128));
        GeneralPath roof = new GeneralPath();
        g2d.translate(0, 0);
        roof.moveTo(points2[0][0], points2[0][1]);
        for (int k = 1; k < points2.length; k++)
            roof.lineTo(points2[k][0], points2[k][1]);
        roof.closePath();
        g2d.fill(roof);

        // Draw two windows.
        GradientPaint gradP = new GradientPaint(5, 10, Color.PINK, 7, 2, Color.WHITE, true);
        g2d.setPaint(gradP);

        g2d.fillRect(-60, 40, 20,22);
        g2d.fillRect( -2, 40, 20,22);

        // Draw four stars.
        g2d.setColor(new Color(254, 255, 0));
        g2d.fillRect(-116, -20, 9,9);

        g2d.fillRect(-74, -42, 9,9);

        g2d.fillRect(18, -21, 9,9);

        g2d.fillRect(53, -37, 9,9);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Lab2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750, 750);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.add(new HomeAnimation());

        frame.setVisible(true);

        Dimension size = frame.getSize();
        Insets insets = frame.getInsets();
        maxWidth = size.width - insets.left - insets.right - 1;
        maxHeight = size.height - insets.top - insets.bottom - 1;
    }

    public void actionPerformed(ActionEvent e) {
        // scaling
        if (scale < 0.01) {
            delta = -delta;
        } else if (scale > 0.99) {
            delta = -delta;
        }

         //movement
        double radiusInSquare = Math.pow(radius, 2);
        if (tx <= 0 && ty < 0){
            tx -= deltaX;
            ty = (-1) * Math.abs(Math.sqrt(radiusInSquare - Math.pow(tx, 2)));
        }else if(tx > 0 && ty <= 0){
            tx -= deltaX;
            ty = (-1) * Math.abs(Math.sqrt(radiusInSquare - Math.pow(tx, 2)));
        }else if(tx >= 0 && ty > 0){
            tx += deltaX;
            ty = Math.abs(Math.sqrt(radiusInSquare - Math.pow(tx, 2)));
        }else if(tx < 0 && ty >= 0){
            tx += deltaX;
            ty = Math.abs(Math.sqrt(radiusInSquare - Math.pow(tx, 2)));
        }

        scale += delta;

        repaint();
    }
}
