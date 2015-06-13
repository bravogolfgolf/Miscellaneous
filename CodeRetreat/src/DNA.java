
public class DNA {

	private String value;
	private String characters = "ATGC"; 

	public DNA(String value) {
		this.value = value;
	}

	public void clean() {
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < value.length() - 1; i++) {
			if(characters.contains(String.valueOf(value.charAt(i)))) {
				sb.append(value.charAt(i));
			}
		}
		this.value = sb.toString();
	}

	public String getValue() {
		return this.value;
	}

	public void reverse() {
		StringBuffer sb = new StringBuffer();
		for(int i = value.length() - 1; i >= 0; i--) {
			sb.append(value.charAt(i));
		}
		this.value = sb.toString();
	}
}
