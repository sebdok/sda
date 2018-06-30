package pl.sdacademy.printer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PrinterQueueTest {

	@DisplayName("Should print text")
	@Test
	
	void test00(){
		//given
		Printer printer = new Printer(1);
		Document document = new Document(false);
		//when
		printer.print(document);
		//then 
		// document is printed
		assertThat(document.isPrinted()).isTrue();
	}

	@DisplayName("should not print documents if minimum number of documents is not reached")
	@Test
	void test01(){
		// given
		int documentsThreshold = 4;
		Printer printer = new Printer(documentsThreshold);
		Document doc0 = notPrintedDocument();
		Document doc1 = notPrintedDocument();
		Document doc2 = notPrintedDocument();

		// when
		printer.print(doc0);
		printer.print(doc1);
		printer.print(doc2);

		// then
		assertThat(doc0.isPrinted()).isFalse();
		assertThat(doc1.isPrinted()).isFalse();
		assertThat(doc2.isPrinted()).isFalse();
	}

	@DisplayName("should print documents if minimum number of documents is reached")
	@Test
	void test02(){
		// given
		int documentsThreshold = 3;
		Printer printer = new Printer(documentsThreshold);
		Document doc0 = notPrintedDocument();
		Document doc1 = notPrintedDocument();
		Document doc2 = notPrintedDocument();

		// when
		printer.print(doc0);
		printer.print(doc1);
		printer.print(doc2);

		// then
		assertThat(doc0.isPrinted()).isTrue();
		assertThat(doc1.isPrinted()).isTrue();
		assertThat(doc2.isPrinted()).isTrue();
	}

	@DisplayName("should print documents if minimum number of documents is reached and then not print another " +
		"document")
	@Test
	void test03(){
		// given
		int documentsThreshold = 2;
		Printer printer = new Printer(documentsThreshold);
		Document doc0 = notPrintedDocument();
		Document doc1 = notPrintedDocument();
		Document doc2 = notPrintedDocument();

		// when
		printer.print(doc0);
		printer.print(doc1);
		printer.print(doc2);

		// then
		assertThat(doc0.isPrinted()).isTrue();
		assertThat(doc1.isPrinted()).isTrue();
		assertThat(doc2.isPrinted()).isFalse();
	}

	private Document notPrintedDocument() {
		return new Document(false);
	}


}