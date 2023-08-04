package com.Akshayblog.Services.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Akshayblog.Services.FileService;
@Service
public class FielServiceImpl implements FileService{

	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {
		
		//File anme;
		String name = file.getOriginalFilename();
		
		//abc.png
		
		//randome name generate file
		String randomId = UUID.randomUUID().toString();
		String fileName1 = randomId.concat(name.substring(name.lastIndexOf(".")));
		
		//FullPath
		String filePath = path + File.separator+fileName1;
		
		//create folder if not created
		
		File f = new File(path);
		if(!f.exists())
		{
			f.mkdir();
		}
		
		//fileCopy
		Files.copy(file.getInputStream(), Paths.get(filePath));
		
		return fileName1;
	}

	@Override
	public InputStream getResource(String path, String fileName) throws FileNotFoundException {
		
		String fullpath = path +File.separator+fileName;
		InputStream is = new FileInputStream(fullpath);
		return is;
	}
	
}

