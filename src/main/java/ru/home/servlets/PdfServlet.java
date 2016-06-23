package ru.home.servlets;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import ru.home.dao.Abonent;
import ru.home.dao.Charge;
import ru.home.dao.Provider;
import ru.home.dao.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 * Created by ivan on 23.06.16.
 */
public class PdfServlet extends DispatcherServlet {
    static int FONT_SIZE_SMALL = 16;
    static int FONT_SIZE_BIG = 32;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Calendar endDate = (Calendar) req.getSession().getAttribute("endDate");
        Calendar beginDate = (Calendar) req.getSession().getAttribute("beginDate");
        String paymentAmount = req.getParameter("paymentAmount");
        String paymentId = req.getParameter("paymentId");

        Abonent abonent = (Abonent) req.getSession().getAttribute("abonent");
        Service service = (Service) req.getSession().getAttribute("service");
        Charge charge = (Charge) req.getSession().getAttribute("charge");
        Provider provider = service.getProviderByProviderId();


        try {
            Font font1 = new Font(Font.FontFamily.HELVETICA, FONT_SIZE_BIG, Font.BOLD);
            Font font2 = new Font(Font.FontFamily.HELVETICA, FONT_SIZE_SMALL, Font.ITALIC | Font.UNDERLINE);
            Document document = new Document();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PdfWriter.getInstance(document,baos);
            document.open();

            //Шрифты не поддерживают кирилицу. Если имя услуги на русском - не отобразится.
            document.add(new Paragraph("Provider " +provider.getProviderName()+
                    " /*there should be the name of the provider , but the fonts do not support Cyrillic*/",font2));
            Paragraph paragraph1 = new Paragraph("Receipt number "+paymentId+" of payment of the contract number " +
                    ""+abonent.getAbonentId()+" for the provision of services \"" +
                    ""+service.getServiceName()+"\"");
            paragraph1.setFont(font1);
            paragraph1.setAlignment(Element.ALIGN_CENTER);
            paragraph1.setSpacingAfter(FONT_SIZE_BIG);
            document.add(paragraph1);
            document.add(new Paragraph("Invoice for payment number "+charge.getChargeId()));

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            Paragraph paragraph2 = new Paragraph("Begin Date: "+ dateFormat.format(beginDate.getTime()));
            Paragraph paragraph3 = new Paragraph("End Date: "+ dateFormat.format(endDate.getTime()));

            document.add(new Paragraph(" \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n"));
            document.add(paragraph2);
            document.add(paragraph3);
            document.add(new Paragraph(" "));
            document.add(new Paragraph("Amount: $"+paymentAmount));
            document.add(new Paragraph(" \n\n\n"));

            Paragraph paragraph4 = new Paragraph("PAID");
            paragraph4.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph4);
            document.close();

            resp.setHeader("Expires","0");
            resp.setHeader("Cache-Control","must-revalidate, post-check=0, pre-check=0");
            resp.setHeader("Pragma","public");
            resp.setContentType("application/pdf");
            resp.setContentLength(baos.size());
            OutputStream os = resp.getOutputStream();
            baos.writeTo(os);
            os.flush();
            os.close();


        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }
}
