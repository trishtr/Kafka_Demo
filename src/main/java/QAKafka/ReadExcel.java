import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

    public static List<String> ReadExcel() throws IOException {
        String excelFilePath = "src/main/java/QAKafka/testDataSet.xlsx";

        FileInputStream inputStream = new FileInputStream(excelFilePath);

        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheet("Sheet1");


        int rows = sheet.getLastRowNum();
        //System.out.println(rows);
        int cols = sheet.getRow(1).getLastCellNum();
        //System.out.println(cols);

        List<String> messageListInString = new ArrayList<>();

        for(int r = 0; r <= rows; r++)
        {
            XSSFRow row = sheet.getRow(r);
            for(int c = 0; c<cols; c++){
                XSSFCell cell = row.getCell(c);
                //System.out.println("Print the mess: ");
                //System.out.println(cell.getStringCellValue());
                messageListInString.add(cell.getStringCellValue());
                }
            }
        return messageListInString;
        //System.out.println();
        //System.out.println(messageListInString);

        /*List<MessageEnvelop> messToPOJOLst = new ArrayList<>();
        for(String mess : messageListInString)
        {
            Gson gson = new Gson();
            MessageEnvelop messToPOJO = gson.fromJson(mess, MessageEnvelop.class);
            messToPOJOLst.add(messToPOJO);
        }
        System.out.println(messToPOJOLst);
        }*/

        }
}
