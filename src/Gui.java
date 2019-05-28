import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;


public class Gui {

    private JFrame frame;
    private JTextField txtCorporation;
    private StockPrice sym;

    /**
     * Create the application.
     */
    public Gui() throws FileNotFoundException {
        initialize();
        frame.setVisible(true);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);


        JLabel lblHigh = new JLabel("High: ");
        lblHigh.setBounds(33, 56, 225, 15);
        frame.getContentPane().add(lblHigh);

        JLabel lblLow = new JLabel("Low:");
        lblLow.setBounds(33, 83, 225, 15);
        frame.getContentPane().add(lblLow);

        JLabel lblVolume = new JLabel("Volume:");
        lblVolume.setBounds(33, 110, 225, 15);
        frame.getContentPane().add(lblVolume);

        JLabel lblCorporationsName = new JLabel("Corporations name");
        lblCorporationsName.setFont(new Font("Dialog", Font.BOLD, 20));
        lblCorporationsName.setBounds(33, 12, 225, 38);
        frame.getContentPane().add(lblCorporationsName);

        JLabel lblDate = new JLabel("Date:");
        lblDate.setBounds(33, 137, 225, 15);
        frame.getContentPane().add(lblDate);

//        JButton btnRandomize = new JButton("Randomize");
//        btnRandomize.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                txtCorporation.setText(db.randomizeSymbol());
//                lblCorporationsName.setText(txtCorporation.getText().substring(0, 1).toUpperCase() + txtCorporation.getText().substring(1));
//                System.out.println(db.getValue(txtCorporation.getText()).toUpperCase());
//                lblHigh.setText("High: " + sym.getHigh() + "$");
//                lblLow.setText("Low " + sym.getLow() + "$");
//                lblVolume.setText("Volume: " + sym.getVolume());
//                lblDate.setText("Date: " + sym.getDate());
//            }
//        });
//        btnRandomize.setBounds(227, 227, 112, 23);
//        frame.getContentPane().add(btnRandomize);

        txtCorporation = new JTextField();
        txtCorporation.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==KeyEvent.VK_ENTER){
                    //input.substring(0, 1).toUpperCase() + input.substring(1);
                    sym = new StockPrice(txtCorporation.getText());
                    lblHigh.setText("High: " + sym.getHigh() + "$");
                    lblLow.setText("Low " + sym.getLow() + "$");
                    lblVolume.setText("Volume: " + sym.getVolume());
                    lblDate.setText("Date: " + sym.getDate());
                }
            }
        });
        txtCorporation.setText("Corporations name");
        txtCorporation.setBounds(84, 228, 131, 20);
        frame.getContentPane().add(txtCorporation);
        txtCorporation.setColumns(10);
    }
}
