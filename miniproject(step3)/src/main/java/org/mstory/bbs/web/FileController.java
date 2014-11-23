package org.mstory.bbs.web;
	
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
	
@Controller("FileController")
@RequestMapping("/file/*")
public class FileController {
		
	private static final Logger logger = LoggerFactory.getLogger(FileController.class);
	
	private static final String UPLOAD_DIR = "C:\\zzz\\upload\\";
	
	@RequestMapping(value="/upload", method=RequestMethod.POST, produces="text/html;charset=UTF-8")
	public @ResponseBody String uploadFile(MultipartFile file) throws Exception {
		
		System.out.println("uploadFile..............start");
		if(file.isEmpty()) {
			return "NONE";
		}
		
		String originName = file.getOriginalFilename();
		String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
		
		//fileName = new String(fileName.getBytes("8859_1"), "utf-8");
		
		String suffix = fileName.substring(fileName.lastIndexOf("."));
		System.out.println("»Æ¿Â¿⁄ : " + suffix);
		
		InputStream in = file.getInputStream();
		
		File uploadedFile = new File(UPLOAD_DIR + fileName);
		
		OutputStream fos = new FileOutputStream(uploadedFile);
		
		buffer(in, fos);
		fos.flush();
		fos.close();
		System.out.println("fileName : " + fileName);
		
		boolean isImage = isImage(suffix);
		
/*		if(isImage) {
			createThumbnail(uploadedFile);
		}*/
		
		String jsObjStr = "{fileName:'"+fileName+"', isImage:"+isImage+", suffix:'"+suffix+"', originName:'" + originName +"'}";
		
		String str = "<script>parent.updateResult(" + jsObjStr + ");</script>";
		
		System.out.println("uploadFile...............end");
		
		return str;
	}
	
	@RequestMapping(value = "/view/{path}", method=RequestMethod.GET, produces="image/jpeg")
	public @ResponseBody byte[] viewFile(@PathVariable("path") String path) throws Exception {
		System.out.println("viewFile......view : " + path);
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		InputStream fis = new FileInputStream(UPLOAD_DIR + path + ".jpg");
		buffer(fis, bos);
		return bos.toByteArray();
	}
	
	@RequestMapping(value="/down", method=RequestMethod.GET, produces="application/octest-stream")
	public @ResponseBody byte[] downFile(@RequestParam(value="src") String path,
										 HttpServletResponse res) throws Exception {
		if(path.equals("")) {
			return null;
		}
		res.addHeader("Content-Disposition", 
				"attachment; filename = " + new String(path.getBytes("UTF-8"),"8859_1"));
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		InputStream fis = new FileInputStream(UPLOAD_DIR + path);
		buffer(fis, bos);
		
		return bos.toByteArray();
	}
	
	private void createThumbnail(File origin) throws Exception {
		
		BufferedImage originalImage = ImageIO.read(origin);
		BufferedImage thumbnailImage = new BufferedImage(
									originalImage.getWidth()/10, originalImage.getHeight()/10, 		
									BufferedImage.TYPE_INT_BGR);
		
		Graphics2D g = thumbnailImage.createGraphics();
		g.drawImage(originalImage, 0, 0, thumbnailImage.getWidth(), thumbnailImage.getHeight(), null);
		
		File outputFile = new File(UPLOAD_DIR + "s_" + origin.getName());
		
		ImageIO.write(thumbnailImage, "jpg", outputFile);
	}
	
	public void buffer(InputStream is, OutputStream os) throws Exception {
		
		byte[] buffer = new byte[1024 * 8];
		
		while(true) {
			int count = is.read(buffer);
			if(count == -1) {
				break;
			}
			os.write(buffer, 0, count);
		}
		is.close();
	}
	
	private boolean isImage(String suffix) {		
		if(suffix.contains(".jpg")) {
			return true;
		}
		return false;
	}
	
	
}