/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.havoc.hotel.util;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.havoc.hotel.admin.entity.Booking;
import com.havoc.hotel.admin.entity.Room;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author HYOJU
 */
public class BookingPdf {

    private static String FILE = "D:/Hotels/pdf/";
    protected static Font font10;
    protected static Font font10b;
    protected static Font font12;
    protected static Font font12b;
    protected static Font font14;
    

    public static String generateBookingPDF(Booking booking) throws DocumentException, FileNotFoundException, IOException {
        Document document = new Document(PageSize.A4);
        String bookingname = booking.getFirstName() + " " + booking.getLastName();
        document.addHeader("HOTEL HAVOC", "Hotel havoc Booking confirmation");
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(FILE + "Booking" + "" + booking.getCustomer().getFirstName() + ".pdf "));
        writer.setViewerPreferences(PdfWriter.PageModeUseOC);
        writer.setPdfVersion(PdfWriter.VERSION_1_7);
        document.open();
        String html = htmlTemplate(booking);

        List unorderedList = new List(List.UNORDERED);
       
        unorderedList.add(new ListItem("Name       :" + booking.getFirstName() + " " + booking.getLastName()));
//        unorderedList.add(new ListItem("Room Price :" + booking.getRoom().getRoomPrice()));
        unorderedList.add(new ListItem("Total Price :" + booking.getTotalPrice()));
        unorderedList.add(new ListItem("check in   :" + booking.getCheckinDate()));
        unorderedList.add(new ListItem("Total Nights:" + booking.getTotalNights()));
        unorderedList.add(new ListItem("check out  :"+ booking.getCheckoutDate()));
        unorderedList.add(new ListItem("Booked By  :" + booking.getCustomer().getUsername()));
       
       

        document.add(unorderedList);
        document.close();
        return bookingname;

    }

    private static String htmlTemplate(Booking booking) {
        StringBuilder html = new StringBuilder();

        html.append("" + "<h1> Booking Confirmation</h1>  ");
        return html.toString();

    }

    public BookingPdf(Booking booking) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public BookingPdf() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

