

import java.io.File;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class Program {
    public static void main(String[] args) {
        String path = "D:\\1";
        String[] subs = Task1(path);
        Task2(subs);
    }

    public static String[] Task1(String path) {
        /*
        Напишите метод, который вернет содержимое текущей папки в виде массива строк.
        Напишите метод, который запишет массив, возвращенный предыдущим методом в файл.
        Обработайте ошибки с помощью try-catch конструкции. В случае возникновения исключения, оно должно записаться в лог-файл.
        */
        Logger logger = Logger.getLogger(Program.class.getName());
        ConsoleHandler ch = new ConsoleHandler();
        XMLFormatter formatter = new XMLFormatter();
        logger.addHandler(ch);
        ch.setFormatter(formatter);

        File f = new File(path);
        if (f.exists()) {
            if (f.isDirectory()) {
                try {
                    String[] subs = f.list();
                    if (subs != null) {
                        return subs;
                    }
                } catch (Exception ex) {
                    logger.warning(ex.getMessage());
                }
            }
            else {
                logger.warning("Not a Directory");
            }
        } else {
            logger.warning("Not Exists");
        }
        return null;
    }

    public static void Task2(String[] subs) {
        /*
        Напишите метод, который определит тип (расширение) файлов из текущей папки и выведет в консоль результат вида
        1 Расширение файла: txt
        2 Расширение файла: pdf
        3 Расширение файла:
        4 Расширение файла: jpg
         */
        for (String path: subs) {
            int index = path.lastIndexOf('.');
            String ext = "";
            if (index > 0) {
                ext = path.substring(index + 1);
            }
            System.out.println(String.format("Расширение файла: %s", ext));
        }
    }
}
