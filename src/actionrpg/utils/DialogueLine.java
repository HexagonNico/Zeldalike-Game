package actionrpg.utils;

public enum DialogueLine {

	OLD_MAN("It's dangerous to go alone...", "Take this!");
	
	private String lines[];
	
	private DialogueLine(String... lines) {
		this.lines = lines;
	}
	
	public String[] getLines() {
		return lines;
	}
}
