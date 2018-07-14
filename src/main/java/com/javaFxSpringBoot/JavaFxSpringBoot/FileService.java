package com.javaFxSpringBoot.JavaFxSpringBoot;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileUtils;

public class FileService {

	private String path;
	private long noOfFiles;
	private long totalSize;
	private List<FileDetails> filesList = null;

	public FileService() {
		this.path = "C:\\EDIT\\MyEdits";
		filesList = new ArrayList<>();
		// this.path = "/home/pi/niranjan";

		numberOfFiles();
		totalSizeOfLocation();
		getTheListOfFile();

	}

	private void getTheListOfFile() {

		String fileName;
		long fileSize;
		String format;

		String dirPath = "C:\\EDIT\\MyEdits";
		File dir = new File(dirPath);
		String[] files = dir.list();
		if (files.length == 0) {
			System.out.println("The directory is empty");
		} else {
			for (String aFile : files) {

				FileDetails fileDetails = new FileDetails();

				int index = aFile.indexOf(".");

				fileDetails.setFileName(aFile.substring(0, index));

				fileDetails.setFilePath(dirPath);

				fileDetails.setFormat(aFile.substring(index + 1));
				filesList.add(fileDetails);
				// System.out.println(" Name : " + aFile.substring(0, index) + " File format : "
				// + aFile.substring( index +1 ) );
				System.out.println(fileDetails);
			}
		}
	}

	private void totalSizeOfLocation() {

		File temp = new File(path);

		if (temp.isDirectory()) {

			long val = temp.getTotalSpace();

			System.out.println("Yes its a directory and size is : " + val);

		}

	}

	private void numberOfFiles() {
		try {
			long noOfFiles = Files.list(Paths.get(this.path)).filter(p -> p.toFile().isFile()).count();

			System.out.println("count = " + noOfFiles);

		} catch (Exception e) {

		}

	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public long getNoOfFiles() {
		return noOfFiles;
	}

	public void setNoOfFiles(int noOfFiles) {
		this.noOfFiles = noOfFiles;
	}

	public long getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

}
