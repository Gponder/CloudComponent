package com.ponder.datajpa;

import com.ponder.datajpa.model.FundPool;
import com.ponder.datajpa.repository.FundPoolRepository;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

@SpringBootTest
class DataJpaApplicationTests {

    @Autowired
    private FundPoolRepository fundPoolRepository;

    /**
     *  -- DELETE FROM t_fundpool WHERE id < 500
     * UPDATE t_fundpool SET id = remain_amount
     *
     * */
    @Test
    void contextLoads() throws IOException {
        String filePath = "D:\\work\\doc\\doc-合伙人\\电渠微信现金成本资金池汇总及监控表2020.11.26(1)(1).xlsx";

        FileInputStream stream = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(stream);
        XSSFSheet sheet = workbook.getSheet("活动及对应资金池汇总");//得到指定名称的Sheet
        for (Row row : sheet)
        {
            int num = row.getRowNum();
            FundPool fund = new FundPool();
            System.out.println(num);
            if (num>=2&&num!=6&&num !=27){
                Cell value0 = row.getCell(0);
                Cell value1 = row.getCell(1);
                Cell value2 = row.getCell(2);
                Cell value3 = row.getCell(3);
                Cell value4 = row.getCell(4);
                Cell value5 = row.getCell(5);
                Cell value6 = row.getCell(6);
                Cell value7 = row.getCell(7);
                fund.setId(num-2);
                fund.setBusiness_type(value1.getStringCellValue());
                fund.setRemark(value2.getStringCellValue());
                fund.setBusiness_name(value3.getStringCellValue());
                fund.setBusiness_id(value4.getStringCellValue());
                fund.setFund_type("微信现金红包".equals(value5.getStringCellValue())?1:2);
                fund.setStatus(value6.getStringCellValue().contains("正常在用")?1:0);
                fund.setRemain_amount(num-1.0);
                fund.setStart_time(new Date());
                fund.setAdd_time(new Timestamp(System.currentTimeMillis()));

                fundPoolRepository.save(fund);
            }

        }
    }

}
