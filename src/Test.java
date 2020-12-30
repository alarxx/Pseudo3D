import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

public class Test extends JFrame {

    public Test(String s) {
        super(s);
        EventMaker em = new EventMaker();
        GridLayout manager = new GridLayout();
        manager.setRows(8);
        manager.setColumns(4);

        JPanel p1 = new JPanel();
        p1.setBackground(Color.LIGHT_GRAY);
        p1.setLayout(manager);
        add(p1);

        StringTokenizer rusAl = new StringTokenizer("А Б В Г Д Е Ё Ж З И Й К Л М Н О П Р С Т У Ф Х Ц Ч Ш Щ Ъ Ь Э Ю Я");
        while (rusAl.hasMoreTokens()){
            JButton button = new JButton(rusAl.nextToken());
            button.setBounds(10, 10, 30, 30);
            button.setBackground(Color.ORANGE);
            button.addActionListener(em);
            p1.add(button);
        }
        setSize(500, 500);
        setVisible(true);
    }

    public static void main(String[] args){
        JFrame f = new Test("Знай азбуку");
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public class EventMaker implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String str = e.getActionCommand();
            switch (str){
                case "А":
                    //Сменить, например, цвет кнопки на зелёный
                    setBackground(Color.BLUE);
                    break;
                case "Б":
                    setBackground(Color.RED);
                    break;
                case "В":
                    break;
                default:

            }

        }
    }
}
