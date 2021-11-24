package corejava.v1ch02;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Программа для просмотра изображений
 */
public class ImageViewer {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var frame = new ImageViewerFrame();
            frame.setTitle("ImageViewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

/**
 * Фрейм с текстовой меткой для вывода изображения
 */
class ImageViewerFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 400;

    public ImageViewerFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        // Использовать метку для вывода изображений на экран
        var label = new JLabel();
        add(label);

        // Установить селектор файлов
        var chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));

        // Установить строку меню
        var menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        var menu = new JMenu("File");
        menuBar.add(menu);

        var openItem = new JMenuItem("Open");
        menu.add(openItem);
        openItem.addActionListener(event -> {
            // Отобразить диалоговое окно селектора файлов
            int result = chooser.showOpenDialog(null);

            // Если файл выбран, задать его в качестве пиктограммы для метки
            if (result == JFileChooser.APPROVE_OPTION) {
                String name = chooser.getSelectedFile().getPath();
                label.setIcon(new ImageIcon(name));
            }
        });

        var exitItem = new JMenuItem("Exit");
        menu.add(exitItem);
        exitItem.addActionListener(event -> System.exit(0));
    }
}
