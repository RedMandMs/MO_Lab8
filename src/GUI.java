import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {

    private JRadioButton f1RadioButton, f2RadioButton;
    private ButtonGroup chooseFunctionGroup = new ButtonGroup();
    private JTextArea textArea;

    public JCheckBox withGS;
    public JCheckBox withSven;

    private double eps = 0.05;
    private MyVector startPoint;

    Functions func = new Functions();

    MethodPolkaRibera polkaRibera = new MethodPolkaRibera(this);

    public void toDesign(){

        /** Главное окно */
        JFrame mainFrame = new JFrame("Лабораторная работа № 8 - Метод Полка-Рибьера");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /** Главная панель */
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainFrame.add(mainPanel);


        /**
         *  Панель с выбором функции для оптимизации
         */
        JPanel functionChoosePanel = new JPanel(new FlowLayout());
        mainPanel.add(functionChoosePanel, BorderLayout.NORTH);
        f1RadioButton = new JRadioButton();
        f1RadioButton.setSelected(true);
        f2RadioButton = new JRadioButton();
        chooseFunctionGroup.add(f1RadioButton);
        chooseFunctionGroup.add(f2RadioButton);
        functionChoosePanel.add(f1RadioButton);
        ImageIcon imageIconF1 = new ImageIcon("F1.jpg");
        JLabel jLabelF1 = new JLabel(imageIconF1);
        functionChoosePanel.add(jLabelF1);
        functionChoosePanel.add(f2RadioButton);
        ImageIcon imageIconF2 = new ImageIcon("F2.jpg");
        JLabel jLabelF2 = new JLabel(imageIconF2);
        functionChoosePanel.add(jLabelF2);




        /**
         *  Панель для установления параметров оптимизации
         */
        JPanel parametersChoosePanel = new JPanel();
        parametersChoosePanel.setLayout(new BoxLayout(parametersChoosePanel, BoxLayout.PAGE_AXIS));
        mainPanel.add(parametersChoosePanel, BorderLayout.WEST);



        /**
         *  Панель для вывода информации о результах оптимизации
         */
        JPanel resultPanel = new JPanel(new BorderLayout());
        mainPanel.add(resultPanel, BorderLayout.CENTER);
        textArea = new JTextArea();
        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        resultPanel.add(scroll, BorderLayout.CENTER);


        /**
         *  Панель для кнопок управления процессом
         */
        JPanel buttonPanel = new JPanel(new FlowLayout());
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        JButton startButton = new JButton("Start");
        startButton.addActionListener(new StartButtonListner());
        buttonPanel.add(startButton);


        /**
         * Чек-боксы для настройки вывода
         */
        withGS = new JCheckBox("С выводом результатов метода золотого сечения");
        withSven = new JCheckBox("С выводом результатов метода Свенна");
        buttonPanel.add(withGS);
        buttonPanel.add(withSven);

        /**
         * Размер и видимость окна
         */
        mainFrame.setSize(1000, 700);
        mainFrame.setVisible(true);
    }


    /**
     * Метод значения функции
     * @param x - точка на функции
     * @return - значение функции
     */
    public double function(MyVector x) {
        return func.valueFun(x);
    }


    /**
     *  Вывод промежуточных результатов оптимизации
     * @param text - текст, который нужно добавить в панель для вывода промежуточных результатов
     */
    public void putToResult(String text){
        textArea.append(text + "\n");
    }


    public MyVector grad(MyVector point) {

        return func.numGradFun(point);
    }


    /**
     * Listener для кнопки "Start"
     */
    private class StartButtonListner implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            textArea.setText(null);
            if(f1RadioButton.isSelected()){
                startPoint = new MyVector(new double[]{0,0});
                func.isFirstFunct = true;
            }else{
                startPoint = new MyVector(new double[]{-3, -1, 0, 1});
                func.isFirstFunct = false;
            }
            polkaRibera.goMethod(startPoint, eps);
        }

    }

}
