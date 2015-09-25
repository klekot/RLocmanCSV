package info.poligon.rlocmancsv;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * Created by Igor Klekotnev on 25.09.2015.
 */
public class XLS_Parser {
    //метод для считывания содержимого таблицы
    public static File makeCSV() throws IOException {
        ArrayList<String> namesColumn = new ArrayList<>();
        ArrayList<String> catLevel0Column = new ArrayList<>();
        ArrayList<String> catLevel1Column = new ArrayList<>();
        ArrayList<String> catLevel2Column = new ArrayList<>();
        ArrayList<String> catLevel3Column = new ArrayList<>();
        ArrayList<String> catLevel4Column = new ArrayList<>();

        File inputWorkbook = new File(Main.inFile);
        File outCSV = new File(Main.outFile);
        Workbook w;

        try {
            w = Workbook.getWorkbook(inputWorkbook);
            // получаем первый лист
            Sheet sheet = w.getSheet(0);
            for (int i = 10; i < sheet.getRows(); i++) { // i = 10 - это чтобы шапка файла не попадала
                //здесь ColumnNumber - номер столбца, і - номер строки
                Cell namesCell = sheet.getCell(5, i);
                namesColumn.add(cleanUp(namesCell.getContents()));
                Cell catLevel0Cell = sheet.getCell(106, i);
                catLevel0Column.add(cleanUp(catLevel0Cell.getContents()));
                Cell catLevel1Cell = sheet.getCell(107, i);
                catLevel1Column.add(cleanUp(catLevel1Cell.getContents()));
                Cell catLevel2Cell = sheet.getCell(108, i);
                catLevel2Column.add(cleanUp(catLevel2Cell.getContents()));
                Cell catLevel3Cell = sheet.getCell(109, i);
                catLevel3Column.add(cleanUp(catLevel3Cell.getContents()));
                Cell catLevel4Cell = sheet.getCell(110, i);
                catLevel4Column.add(cleanUp(catLevel4Cell.getContents()));
            }
        } catch (BiffException e) {
            e.printStackTrace();
        }
        return outCSV;
    }
    private static String cleanUp(String string) {

        if (string.contains("\t") || (string.contains("\n"))) {
            string.replace('\t', ' ');
            string.replace('\n', ' ');
        }
        return string;
    }
}
