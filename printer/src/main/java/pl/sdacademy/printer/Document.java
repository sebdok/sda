package pl.sdacademy.printer;

public class Document {
	private boolean printed;

	public Document(boolean b) {
		this.printed = b;
	}

	public boolean isPrinted() {
		return printed;
	}

	public void setPrinted(boolean b) {
		printed=b;
	}
}
