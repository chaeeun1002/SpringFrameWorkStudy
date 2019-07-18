package example4;

import java.io.FileWriter;
import java.io.IOException;

public class FileOutputter implements Outputter {
	private String filePath;
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	@Override
	public void output(String msg) throws IOException {
		FileWriter out = new FileWriter(filePath);
		out.write(msg);
		out.close();
		System.out.println("파일 생성 완료");
	}

}
