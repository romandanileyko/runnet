package ru.danileyko.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import ru.danileyko.model.ResultCountOfFreeIp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

/**
 * Created by danil on 27.07.2017.
 */
public class FreeIPPdfReport {
    public static ByteArrayInputStream freeIpReport(List<ResultCountOfFreeIp> freeIp){
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try{
            BaseFont baseFont = BaseFont.createFont("http://localhost:8080/font.ttf","cp1251",BaseFont.EMBEDDED);
            Font font = new Font(baseFont);


            PdfPTable table = new PdfPTable(3);
            table.setWidthPercentage(60);
            table.setWidths(new int[]{3,3,2});

            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

            PdfPCell hcell;

            hcell = new PdfPCell(new Phrase("NAME",headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("IP RANGE",headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("COUNT",headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            for (ResultCountOfFreeIp item : freeIp){

                PdfPCell cell;

                cell = new PdfPCell(new Phrase(String.valueOf(item.getName()),font));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(item.getIpange()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(String.valueOf(item.getCount())));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

            }

            PdfWriter.getInstance(document,out);
            document.open();
            document.add(table);
            document.close();

        }catch(Exception exception){
            exception.printStackTrace();
            }
    return new ByteArrayInputStream(out.toByteArray());
    }
}
