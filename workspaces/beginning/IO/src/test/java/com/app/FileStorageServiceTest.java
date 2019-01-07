package com.app;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.multipart.MultipartFile;

import com.app.exception.FileStorageException;
import com.app.exception.MyFileNotFoundException;
import com.app.property.FileStorageProperties;
import com.app.service.FileStorageService;

public class FileStorageServiceTest {

	private FileStorageService fileStorageService;

	@Before
	public void setup() {
		FileStorageProperties fileStorageProperties = mock(FileStorageProperties.class);
		when(fileStorageProperties.getUploadDir()).thenReturn("test");
		fileStorageService = new FileStorageService(fileStorageProperties);
	}

	@Test(expected = FileStorageException.class)
	public void FileStorageExceptionTest() {
		MultipartFile file = mock(MultipartFile.class);
		when(file.getOriginalFilename()).thenReturn("..");

		fileStorageService.storeFile(file);
	}

	@Test(expected = NullPointerException.class)
	public void NullPointerExceptionTest() {
		MultipartFile file = mock(MultipartFile.class);
		when(file.getOriginalFilename()).thenReturn("file");

		fileStorageService.storeFile(file);
	}
	
	@Test(expected = MyFileNotFoundException.class)
	public void MyFileNotFoundExceptionTest() {
		fileStorageService.loadFileAsResource("main1.cpp");
	}
	
	/*@Test
	public void loadFileAsResourceTest() {
		assertNotNull(fileStorageService.loadFileAsResource("main")); 
	}*/
}
