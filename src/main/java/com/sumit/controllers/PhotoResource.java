/**
 * 
 */
package com.sumit.controllers;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.sumit.models.Photo;
import com.sumit.models.User;
import com.sumit.service.PhotoService;

/**
 * @author Sumit
 *
 */
@RestController
@RequestMapping("/rest")
public class PhotoResource {
	private String imageName;
	
	@Autowired
	PhotoService photoService;
	
	@RequestMapping(value="/photo/upload", method=RequestMethod.POST)
		public String upload(HttpServletRequest req, HttpServletResponse res)
		{
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)req;
			Iterator<String> itr = multipartRequest.getFileNames();
			MultipartFile multipartFile = multipartRequest.getFile(itr.next());
			String fileName= multipartFile.getOriginalFilename();
			imageName = fileName;
			String path = new File("target/classes/static/images").getAbsolutePath()+"\\"+fileName;
			try {
				multipartFile.transferTo(new File(path));
				System.out.println(path);
			}catch(IOException io)
			{
				io.printStackTrace();
			}
			
			return "upload successfully";
		}
	@RequestMapping(value="/photo/add", method=RequestMethod.POST)
	public Photo addPhoto(@RequestBody Photo photo) {
		photo.setImageName(imageName);
		return photoService.save(photo);
	}
	@RequestMapping(value="/photo/user", method=RequestMethod.POST)
	public List<Photo> getPhotosByUser(@RequestBody User user) {
		return photoService.findByUser(user);
	}
	@RequestMapping(value="/photo/photoId", method=RequestMethod.POST)
	public Photo getPhotoByPhotoId(@RequestBody Long photoId) {
		return photoService.findByPhotoId(photoId);
	}
	
	@RequestMapping(value="/photo/update", method=RequestMethod.POST)
	public void updatePhoto(@RequestBody Photo photo) {
		Photo currentPhoto = photoService.findByPhotoId(photo.getPhotoId());
		currentPhoto.setLikes(photo.getLikes());
		photoService.save(currentPhoto);
		
	}
	
	
	}

