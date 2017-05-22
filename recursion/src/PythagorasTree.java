/**
 * Created by mircea on 22.05.17.
 */
import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import javax.swing.*;

public class PythagorasTree extends JPanel {
    final int depthLimit = 15;
    float hue = 0.10f;

    public PythagorasTree() {
        setPreferredSize(new Dimension(640, 640));
        setBackground(Color.white);
    }

    private void drawSquare(Graphics2D g, Point2D p1,
                            Point2D p2,
                            Point2D p3,
                            Point2D p4,
                              int depth) {

        Path2D square = new Path2D.Float();
        square.moveTo(p1.getX(), p1.getY());
        square.lineTo(p2.getX(), p2.getY());
        square.lineTo(p3.getX(), p3.getY());
        square.lineTo(p4.getX(), p4.getY());
        square.closePath();
        g.setColor(Color.getHSBColor(hue + depth * 0.02f, 1, 1));
        g.fill(square);
        g.setColor(Color.lightGray);
        g.draw(square);
    }

    private void computeNewPoints(Point2D p1, Point2D p2, Point2D p3, Point2D p4, Point2D p5) {

        double dx = p2.getX() - p1.getX();
        double dy = p1.getY() - p2.getY();

        p3.setLocation(
                p2.getX() - dy,
                p2.getY() - dx);

        p4.setLocation(
                p1.getX() - dy,
                p1.getY() - dx);

        p5.setLocation(
                p4.getX() + 0.5f * (dx - dy),
                p4.getY() - 0.5f * (dx + dy));
    }

    private void drawTree(Graphics2D g, Point2D p1, Point2D p2,
                          int depth) {

        if (depth == depthLimit)
            return;

        Point2D p3 = new Point2D.Double();
        Point2D p4 = new Point2D.Double();
        Point2D p5 = new Point2D.Double();

        computeNewPoints(p1, p2, p3, p4, p5);

        drawSquare(g, p1, p2, p3, p4, depth);

        drawTree(g, p4, p5, depth + 1);
        drawTree(g, p5, p3, depth + 1);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Point2D p1 = new Point2D.Double(275, 500);
        Point2D p2 = new Point2D.Double(375, 500);

        drawTree((Graphics2D) g, p1, p2, 0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame f = new JFrame();
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setTitle("Pythagoras Tree");
            f.setResizable(false);
            f.add(new PythagorasTree(), BorderLayout.CENTER);
            f.pack();
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        });
    }
}

