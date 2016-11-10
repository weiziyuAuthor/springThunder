package yu.builder;

public class TextBuilder extends Builder {
	private StringBuffer buffer = new StringBuffer();
	@Override
	public Object getResult() {
		buffer.append("=============================\n");
		return buffer.toString();
	}

	@Override
	public void makeItems(String[] items) {
		for(int i=0;i<items.length;i++){
			buffer.append("*"+items[i]+"\n");
		}
		buffer.append("\n");
	}

	@Override
	public void makeString(String str) {
		buffer.append('■'+str+"\n");
		buffer.append("\n");
	}

	@Override
	public void makeTitle(String title) {
		buffer.append("================================\n");
		buffer.append("【"+title+"】");
		buffer.append("\n");
	}

}
