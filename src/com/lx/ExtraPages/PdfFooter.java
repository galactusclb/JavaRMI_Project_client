package com.lx.ExtraPages;

import java.awt.Color;
import java.awt.Font;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEvent;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfFooter implements PdfPageEvent {


	@Override
	public void onChapter(PdfWriter arg0, Document arg1, float arg2, Paragraph arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onChapterEnd(PdfWriter arg0, Document arg1, float arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCloseDocument(PdfWriter arg0, Document arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onEndPage(PdfWriter writer, Document doc) {
//		Paragraph footer = new Paragraph("THANK YOU", FontFactory.getFont(FontFactory.TIMES, 10, Font.BOLD));
//		footer.setAlignment(Element.ALIGN_RIGHT);
//		
//		PdfPTable footerTbl = new PdfPTable(1);
//		footerTbl.setTotalWidth( 300);
//		footerTbl.setHorizontalAlignment(Element.ALIGN_CENTER);
//		
//		PdfPCell cell = new PdfPCell(footer);
//		cell.setBorder(0);
//		cell.setPaddingLeft( 10);
//		footerTbl.addCell(cell);
//		footerTbl.writeSelectedRows(0, -1, 415, 30, writer.getDirectContent());
		
		
		PdfPCell preBorderBlue = new PdfPCell(new Phrase(""));
		preBorderBlue.setMinimumHeight(5f);
		preBorderBlue.setUseVariableBorders(true);
		preBorderBlue.setBorderColorTop(new BaseColor(new Color(255,185,6)));
		preBorderBlue.setBorderWidthTop(3);
		
		PdfPCell footerName = new PdfPCell(new Phrase("LOGICCHIP"));
		PdfPCell footerEmail = new PdfPCell(new Phrase("info@logicchip.com"));

		PdfPCell footerEmpty = new PdfPCell(new Phrase(""));
		
		footerName.setBorder(Rectangle.NO_BORDER);
		footerEmpty.setBorder(Rectangle.NO_BORDER);
		footerEmail.setBorder(Rectangle.NO_BORDER);
		
		
		Paragraph footer = new Paragraph("THANK YOU", FontFactory.getFont(FontFactory.TIMES, 10, Font.BOLD));
		footer.setAlignment(Element.ALIGN_RIGHT);
		
		PdfPTable footerTbl = new PdfPTable(1);
		footerTbl.setTotalWidth( 300);
//		footerTbl.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell = new PdfPCell(footer);
		cell.setBorder(0);
		cell.setPaddingLeft( 10);

		footerTbl.addCell(preBorderBlue);
		footerTbl.addCell(footerName);
		footerTbl.addCell(footerEmail);
		footerTbl.addCell(cell);
		
		footerTbl.writeSelectedRows(0, -1, 30, 90, writer.getDirectContent());
//		footerTbl.writeSelectedRows
	}

	@Override
	public void onGenericTag(PdfWriter arg0, Document arg1, Rectangle arg2, String arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onOpenDocument(PdfWriter arg0, Document arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onParagraph(PdfWriter arg0, Document arg1, float arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onParagraphEnd(PdfWriter arg0, Document arg1, float arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSection(PdfWriter arg0, Document arg1, float arg2, int arg3, Paragraph arg4) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSectionEnd(PdfWriter arg0, Document arg1, float arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStartPage(PdfWriter arg0, Document arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
//	void OnEndPage(PdfWriter writer, Document doc) {
////		Paragraph footer = new Paragraph("THANK YOU", FontFactory.getFont(FontFactory.TIMES, 10, Font.BOLD));
//		Paragraph footer = new Paragraph("THANK YOU", FontFactory.getFont(FontFactory.TIMES, 10, Font.BOLD));
//		footer.setAlignment(Element.ALIGN_RIGHT);
//		PdfPTable footerTbl = new PdfPTable(1);
//		footerTbl.setTotalWidth( 300);
//		footerTbl.setHorizontalAlignment(Element.ALIGN_CENTER);
//		PdfPCell cell = new PdfPCell(footer);
//		cell.setBorder(0);
//		cell.setPaddingLeft( 10);
//		footerTbl.addCell(cell);
//		footerTbl.writeSelectedRows(0, -1, 415, 30, writer.getDirectContent());
//	}

}
