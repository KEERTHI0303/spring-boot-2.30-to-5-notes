package com.example.filehandling;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
public class FileUploadController {
	//path
private static String uploadfile="D://jawakar//";
	
	@RequestMapping("/upload")
	public ModelAndView s() {
		return new ModelAndView("upload");
	}
	
	@PostMapping("/upload")
	public ModelAndView fileUpload(@RequestParam("file")
	MultipartFile file, RedirectAttributes  redirectAttributes) {
		if(file.isEmpty()) {
			return new ModelAndView("status","message","Please select a file and upload");
			
		}
		try {
			byte[] bytes=file.getBytes();
			Path path=Paths.get(uploadfile+file.getOriginalFilename());
			Files.write(path, bytes);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		return new ModelAndView("status","message","File uploaded successfully");
	}
	

}

