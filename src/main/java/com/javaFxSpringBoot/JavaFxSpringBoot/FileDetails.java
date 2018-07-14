package com.javaFxSpringBoot.JavaFxSpringBoot;

public class FileDetails {

	private String fileName;
	private long size;
	private String format;
	private String filePath;
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	private long duration;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "FileDetails [fileName=" + fileName + ", size=" + size + ", format=" + format + ", filePath=" + filePath
				+ "]";
	}

}
